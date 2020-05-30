package dss.News.ObservableNews;


import dss.News.ObservableNewsWithNotifications.SubscriberWithNotification;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InfoOperator {
    static NationalNewsChanel nationalNewsChanel = new NationalNewsChanel();
    static SportNewsChanel sportNewsChanel = new SportNewsChanel();
    static List<Subscriber> subscriberList = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String choice = "0";
        do {
            try {
                System.out.println("1. Create new user");
                System.out.println("2. Subscribe user to news chanel");
                System.out.println("3. Unsubscribe user from news chanel");
                System.out.println("4. Add news to a chanel");
                System.out.println("5. Show all news os subscriber");

                choice = scanner.next();
                scanner.nextLine();
                switch (choice) {
                    case "1": {
                        System.out.println("Think your nickname up");
                        String nickName = scanner.next();
                        Subscriber subscriber;
                        if (subscriberList.stream().noneMatch(x -> x.getUniqueNickName().equals(nickName))) {
                            subscriber = new SubscriberWithNotification(nickName);
                            subscriberList.add(subscriber);
                        } else {
                            System.out.println("Pick another nickname");
                        }
                        break;
                    }
                    case "2": {
                        Subscriber subscriber = getSubscriber();
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
                                sportNewsChanel.addObserver(subscriber);
                                break;
                            }
                            case "2": {
                                nationalNewsChanel.addObserver(subscriber);
                                break;
                            }
                            case "1and2": {
                                sportNewsChanel.addObserver(subscriber);
                                nationalNewsChanel.addObserver(subscriber);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    }
                    case "3": {
                        Subscriber subscriber = getSubscriber();
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
                                sportNewsChanel.deleteObserver(subscriber);
                                break;
                            }
                            case "2": {
                                nationalNewsChanel.deleteObserver(subscriber);
                                break;
                            }
                            case "1and2": {
                                sportNewsChanel.deleteObserver(subscriber);
                                nationalNewsChanel.deleteObserver(subscriber);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    }
                    case "4": {
                        System.out.println("1. Sport news");
                        System.out.println("2. National news");

                        System.out.println("Enter chanel please 1 or 2");
                        String chanel = scanner.next();
                        scanner.nextLine();
                        System.out.println("Enter new news");
                        String newNews = scanner.nextLine();
                        switch (chanel) {
                            case "1": {
                                sportNewsChanel.addNews(newNews);
                                break;
                            }
                            case "2": {
                                nationalNewsChanel.addNews(newNews);
                                break;
                            }
                            default:
                                System.out.println("No such choice");
                                break;
                        }
                        break;
                    }
                    case "5": {
                        Subscriber subscriber = getSubscriber();
                        if(subscriber == null) {
                            System.out.println("No such users");
                            break;
                        }
                        System.out.println(subscriber.getNews());
                        break;
                    }

                    default:
                        return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true);

    }

    static Subscriber getSubscriber(){
        System.out.println("1. Enter your nickname please");
        String nickName1 = scanner.next();
        Subscriber subscriber = subscriberList.stream().filter(x -> x.getUniqueNickName().equals(nickName1)).findFirst().orElse(null);
        if(subscriber == null) {
            System.out.println("No such users");
            return null;
        }
        return subscriber;
    }
}
