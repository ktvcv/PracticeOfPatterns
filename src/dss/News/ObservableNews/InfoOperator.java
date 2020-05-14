package dss.News.ObservableNews;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InfoOperator {
    public static void main(String[] args) {
        NationalNews nationalNews = new NationalNews();
        SportNews sportNews = new SportNews();
        List<Subscriber> subscriberList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            try{
            System.out.println("1. Create new user");
            System.out.println("2. Subscribe user to news chanel");
            System.out.println("3. Add news to a chanel");
            System.out.println("4. Show news for all subscribers");

            choice = scanner.nextInt();
        }
            catch (InputMismatchException e)
        {
            System.out.println("Not a number");
        }
        scanner.nextLine();
            switch (choice) {
                case 1: {
                    scanner.nextLine();
                    System.out.println("1. Think your nickname up");
                    String nickName = scanner.next();
                    if (subscriberList.stream().noneMatch(x -> x.getUniqueNickName().equals(nickName)))
                        subscriberList.add(new Subscriber(nickName));
                    else {
                        System.out.println("Pick another nickname");
                    }
                    break;
                }
                case 2: {
                    scanner.nextLine();
                    System.out.println("1. Enter your nickname please");
                    String nickName1 = scanner.next();
                    Subscriber subscriber = subscriberList.stream().filter(x -> x.getUniqueNickName().equals(nickName1)).findFirst().orElse(null);
                    if(subscriber == null) {
                        System.out.println("No such users");
                        break;
                    }
                    System.out.println("1. Sport news");
                    System.out.println("2. Media news");
                    System.out.println("Both: 1and2");
                    String news = scanner.next();
                    switch (news) {
                        case "1": {
                            sportNews.addObserver(subscriber);
                            break;
                        }
                        case "2": {
                            nationalNews.addObserver(subscriber);
                            break;
                        }
                        case "1and2": {
                            sportNews.addObserver(subscriber);
                            nationalNews.addObserver(subscriber);
                            break;
                        }
                        default:
                            return;
                    }
                    break;
                }
                case 3: {
                    System.out.println("1. Sport news");
                    System.out.println("2. Media news");

                    System.out.println("Enter chanel please");
                    int chanel = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new news");
                    String newNews = scanner.next();
                    switch (chanel) {
                        case 1: {
                            sportNews.addNews(newNews);
                            break;
                        }
                        case 2: {
                            nationalNews.addNews(newNews);
                            break;
                        }
                        default:
                            return;
                    }
                    break;
                }
                case 4: {
                    subscriberList.forEach(System.out::println);
                    System.out.println(sportNews);
                    break;
                }
                default:
                    return;

            }
        }
        while (true);

    }
}
