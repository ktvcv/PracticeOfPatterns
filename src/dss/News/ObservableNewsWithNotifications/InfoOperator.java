package dss.News.ObservableNewsWithNotifications;


import dss.News.ObservableNews.NationalNewsChanel;
import dss.News.ObservableNews.SportNewsChanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InfoOperator {
    static Scanner scanner = new Scanner(System.in);
    static NationalNewsChanel nationalNewsChanel = new NationalNewsChanel();
    static SportNewsChanel sportNewsChanel = new SportNewsChanel();
    static List<SubscriberWithNotification> subscriberList = new ArrayList<>();

    public static void main(String[] args) {
        String choice = "0";
        do {
            try {
                System.out.println("1. Create new user");
                System.out.println("2. Subscribe user to news chanel");
                System.out.println("3. Unsubscribe user to news chanel");
                System.out.println("4. Add news to a chanel");
                System.out.println("5. Manage your notifications");
                System.out.println("6. Show news of subscriber");
                System.out.println("7. Exit");

                choice = scanner.next();
                scanner.nextLine();
                switch (choice) {
                    case "1": {
                        System.out.println("Think your nickname up");
                        String nickName = scanner.next();
                        System.out.println("Enter your phone please as default method ro receive news,you can change it later");
                        String phone = scanner.next();
                        SubscriberWithNotification subscriber;
                        if (subscriberList.stream().noneMatch(x -> x.getUniqueNickName().equals(nickName))) {
                            subscriber = new SubscriberWithNotification(nickName);
                            subscriber.setNotificator(new MobileNotificator(phone));
                            subscriberList.add(subscriber);
                        } else {
                            System.out.println("Pick another nickname");
                        }
                        break;
                    }
                    case "2": {
                        SubscriberWithNotification subscriber = checkNickNameCommand();

                        String news = getChoice();
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
                        SubscriberWithNotification subscriber = checkNickNameCommand();

                        String news = getChoice();
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
                        SubscriberWithNotification subscriber = checkNickNameCommand();
                        if (subscriber == null)
                            break;
                        System.out.println("1. Add notification method: phone");
                        System.out.println("2. Change email for existing phone notification");
                        System.out.println("3. Add notification method: email");
                        System.out.println("4. Change number for existing email notification");
                        System.out.println("5. Delete notification method: email");
                        System.out.println("6. Delete notification method: mobile");

                        String number = scanner.next();
                        switch (number) {
                            case "1": {
                                System.out.println(addPhoneCommand(subscriber));
                                break;
                            }
                            case "2": {
                                System.out.println(changeSourcePhoneCommand(subscriber));
                                break;
                            }
                            case "3": {
                                System.out.println(addEmailCommand(subscriber));
                                break;
                            }
                            case "4": {
                                System.out.println(changeSourceEmailCommand(subscriber));
                                break;
                            }
                            case "6": {
                                System.out.println(deletePhoneNotificationCommand(subscriber));
                                break;
                            }
                            case "5": {
                                System.out.println(deleteEmailNotificationCommand(subscriber));
                                break;
                            }
                            default:
                                return;
                        }
                        break;
                    }
                    case "6": {
                        SubscriberWithNotification subscriber = checkNickNameCommand();
                        if (subscriber == null)
                            break;
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

    static SubscriberWithNotification checkNickNameCommand() {
        scanner.nextLine();
        System.out.println("1. Enter your nickname please");
        String nickName1 = scanner.next();
        SubscriberWithNotification subscriber = subscriberList.stream().filter(x -> x.getUniqueNickName().equals(nickName1)).findFirst().orElse(null);
        if (subscriber == null) {
            System.out.println("No such users");
            return null;
        }
        return subscriber;
    }

    static String addEmailCommand(SubscriberWithNotification subscriber) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Add notification method: add new email");
        String email = scanner.next();
        if (subscriber.getNotificator().stream().anyMatch(x -> x instanceof EmailNotificator)) {
            stringBuilder.append("You cant have more than one email for notifications");
            stringBuilder.append(", Not added, already exists");
            return stringBuilder.toString();
        }
        subscriber.setNotificator(new EmailNotificator(email));
        stringBuilder.append("Added");
        return stringBuilder.toString();
    }

    static String addPhoneCommand(SubscriberWithNotification subscriber) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Add notification method: add new phone");
        String phone = scanner.next();
        if (subscriber.getNotificator().stream().anyMatch(x -> x instanceof MobileNotificator)) {
            stringBuilder.append("You cant have more than one phone for notifications");
            stringBuilder.append(", Not added, already exists");
            return stringBuilder.toString();
        }
        subscriber.setNotificator(new MobileNotificator(phone));
        return "Added";
    }

    static String changeSourcePhoneCommand(SubscriberWithNotification subscriber) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Change number for existing, enter number");
        String newPhone = scanner.next();
        if (subscriber.getNotificator().stream().noneMatch(x -> x instanceof MobileNotificator)) {
            stringBuilder.append(", Such number doesnt exist, method of notification will be created");
        } else {
            subscriber.getNotificator().removeIf(x -> x instanceof MobileNotificator);
        }
        subscriber.setNotificator(new MobileNotificator(newPhone));
        stringBuilder.append("Phone was changed");
        return stringBuilder.toString();

    }

    static String changeSourceEmailCommand(SubscriberWithNotification subscriber) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Change email for existing, enter email");
        String newEmail = scanner.next();
        if (subscriber.getNotificator().stream().noneMatch(x -> x instanceof EmailNotificator)) {
            stringBuilder.append("Such email doesnt exist, method of notification will be created");
        } else {
            subscriber.getNotificator().removeIf(x -> x instanceof EmailNotificator);
        }
        subscriber.setNotificator(new EmailNotificator(newEmail));
        stringBuilder.append("Email was changed");
        return stringBuilder.toString();

    }

    static String deletePhoneNotificationCommand(SubscriberWithNotification subscriber) {
        StringBuilder stringBuilder = new StringBuilder();
        if (subscriber.getNotificator().removeIf(x -> x instanceof MobileNotificator))
            stringBuilder.append("Successfully removed");
        else
            stringBuilder.append("Nothing removed");
        return stringBuilder.toString();
    }

    static String deleteEmailNotificationCommand(SubscriberWithNotification subscriber) {
        StringBuilder stringBuilder = new StringBuilder();
        if (subscriber.getNotificator().removeIf(x -> x instanceof EmailNotificator))
            stringBuilder.append("Successfully removed");
        else
            stringBuilder.append("Nothing removed");
        return stringBuilder.toString();
    }

    static String getChoice() {
        System.out.println("1. Sport news");
        System.out.println("2. National news");
        System.out.println("Both: 1and2");

        return scanner.next();
    }
}
