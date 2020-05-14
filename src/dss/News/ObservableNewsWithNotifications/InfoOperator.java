package dss.News.ObservableNewsWithNotifications;


import dss.News.ObservableNews.NationalNews;
import dss.News.ObservableNews.SportNews;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InfoOperator {
    public static void main(String[] args)  {
        NationalNews nationalNews = new NationalNews();
        SportNews sportNews = new SportNews();
        List<SubscriberWithNotification> subscriberList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            try{
            System.out.println("1. Create new user");
            System.out.println("2. Subscribe user to news chanel");
            System.out.println("3. Add news to a chanel");
            System.out.println("4. Show news for all subscribers");
            System.out.println("5. Manage your notifications");
            System.out.println("6. Exit");

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
                    System.out.println("Think your nickname up");
                    String nickName = scanner.next();
                    System.out.println("Enter your phone please as default method ro receive news,you can change it later");
                    String phone = scanner.next();
                    SubscriberWithNotification subscriber;
                    if (subscriberList.stream().noneMatch(x -> x.getUniqueNickName().equals(nickName))) {
                        subscriber = new SubscriberWithNotification (nickName);
                        subscriber.setNotificator(new MobileNotificator(phone));
                        subscriberList.add(subscriber);
                    }
                    else {
                        System.out.println("Pick another nickname");
                    }
                    break;
                }
                case 2: {
                    scanner.nextLine();
                    System.out.println("1. Enter your nickname please");
                    String nickName1 = scanner.next();
                    SubscriberWithNotification subscriber = subscriberList.stream().filter(x -> x.getUniqueNickName().equals(nickName1)).findFirst().orElse(null);
                    if(subscriber == null) {
                        System.out.println("No such users");
                        break;
                    }
                    System.out.println("1. Sport news");
                    System.out.println("2. National news");
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
                    System.out.println("2. National news");

                    System.out.println("Enter chanel please");
                    int chanel = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new news");
                    String newNews = scanner.nextLine();
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
                case 5: {
                    scanner.nextLine();
                    System.out.println("1. Enter your nickname please");
                    String nickName1 = scanner.next();
                    SubscriberWithNotification subscriber = subscriberList.stream().filter(x -> x.getUniqueNickName().equals(nickName1)).findFirst().orElse(null);
                    if(subscriber == null) {
                        System.out.println("No such users");
                        break;
                    }
                    System.out.println("1. Add notification method: phone");
                    System.out.println("2. Change number for existing phone notification");
                    System.out.println("3. Add notification method: email");
                    System.out.println("4. Change number for existing email notification");
                    System.out.println("5. Delete notification method: email");
                    System.out.println("6. Delete notification method: mobile");

                    int number = scanner.nextInt();
                    switch (number) {
                        case 1: {
                            System.out.println("Add notification method: phone, enter number");
                            String phone = scanner.next();
                            if(subscriber.getNotificator().stream().anyMatch(x -> x instanceof MobileNotificator))
                            {
                                System.out.println("You cant have more than one phone for notifications");
                                break;
                            }
                            subscriber.setNotificator(new MobileNotificator(phone));
                            break;
                        }
                        case 2: {
                            System.out.println("Change number for existing, enter number");
                            String newPhone = scanner.next();
                            if(subscriber.getNotificator().stream().noneMatch(x -> x instanceof MobileNotificator)) {
                                System.out.println("Such number doesnt exist, method of notification will be created");
                            }
                            else {
                                subscriber.getNotificator().removeIf(x -> x instanceof MobileNotificator);
                            }
                            subscriber.setNotificator(new MobileNotificator(newPhone));
                            break;
                        }
                        case 3: {
                            System.out.println("Add notification method: email, enter email");
                            String email = scanner.next();
                            if(subscriber.getNotificator().stream().anyMatch(x -> x instanceof EmailNotificator))
                            {
                                System.out.println("You cant have more than one email for notifications");
                                break;
                            }
                            subscriber.setNotificator(new EmailNotificator(email));
                            break;
                        }
                        case 4: {
                            System.out.println("Change email for existing, enter email");
                            String newEmail = scanner.next();
                            if(subscriber.getNotificator().stream().noneMatch(x -> x instanceof EmailNotificator)) {
                                System.out.println("Such email doesnt exist, method of notification will be created");
                            }
                            else {
                                subscriber.getNotificator().removeIf(x -> x instanceof EmailNotificator);
                            }
                            subscriber.setNotificator(new EmailNotificator(newEmail));
                            break;
                        }
                        case 5: {
                            if(subscriber.getNotificator().removeIf(x -> x instanceof EmailNotificator))
                                System.out.println("Successfully removed");
                            else System.out.println("Nothing removed");
                            break;
                        }
                        case 6: {
                            if(subscriber.getNotificator().removeIf(x -> x instanceof MobileNotificator))
                                System.out.println("Successfully removed");
                            else System.out.println("Nothing removed");
                            break;
                        }
                        default:
                            return;
                    }
                    break;
                }
                default:
                    return;

            }
        }
        while (true);

    }
}
