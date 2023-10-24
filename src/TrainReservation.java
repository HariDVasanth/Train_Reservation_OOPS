import java.util.Scanner;

public class TrainReservation {
    public static void main(String[] args) {
        ChildTrains trainSystem = new ChildTrains();
        User userSystem = new User();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("*** Welcome ***");
            System.out.println("1. Add Trains");
            System.out.println("2. Display all trains");
            System.out.println("3. Book trains");
            System.out.println("4. Cancel tickets");
            System.out.println("5. Exit");
            System.out.print("Enter your Choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter your username: ");
                    String username = scanner.next();
                    System.out.print("Enter your password: ");
                    String password = scanner.next();

                    if (userSystem.login(username, password)) {
                        System.out.println("***** Add Trains *****");

                        System.out.print("Enter train number: ");
                        int trainNumber = scanner.nextInt();

                        System.out.print("Enter Train name: ");
                        String trainName = scanner.next();
                        trainSystem.setTrainName(trainName);

                        System.out.print("Enter departure point: ");
                        String departure = scanner.next();
                        trainSystem.setDeparture(departure);

                        System.out.print("Enter destination point: ");
                        String destination = scanner.next();
                        trainSystem.setDestination(destination);

                        System.out.print("Enter Ac seats available: ");
                        int acSeats = scanner.nextInt();
                        trainSystem.setAcSeats(acSeats);

                        System.out.print("Enter Ac seat fare: ");
                        int acFare = scanner.nextInt();
                        trainSystem.setAcFare(acFare);

                        System.out.print("Enter general seats available: ");
                        int generalSeats = scanner.nextInt();
                        trainSystem.setGeneralSeats(generalSeats);

                        System.out.print("Enter general seat fare: ");
                        int generalFare = scanner.nextInt();
                        trainSystem.setGeneralFare(generalFare);

                        System.out.print("Do you want to continue (Y/N): ");
                        char continueChoice = scanner.next().charAt(0);

                        trainSystem.setTrains(trainNumber, trainSystem);
                        System.out.println("Tickets Uploaded");

                        if (continueChoice != 'Y' && continueChoice != 'y') {
                            break;
                        }
                    } else {
                        System.out.println("Invalid username or password");
                    }
                    break;

                case 2:
                    System.out.println("Trains Available");
                    trainSystem.displayTrains();
                    break;

                case 3:
                    System.out.println("Returning user?");
                    System.out.println("Press 1 to login");
                    System.out.println("Press 2 to register");
                    int option = scanner.nextInt();

                    switch (option) {
                        case 1:
                            System.out.print("Enter your username: ");
                            String user = scanner.next();
                            System.out.print("Enter your password: ");
                            String pass = scanner.next();

                            if (userSystem.register(user, pass)) {
                                System.out.println("Train ticket Bookings");
                                System.out.print("Enter train number: ");
                                int trainNumber = scanner.nextInt();

                                int acSeats = trainSystem.getTrains().get(trainNumber).getAcSeats();
                                int generalSeats = trainSystem.getTrains().get(trainNumber).getGeneralSeats();

                                System.out.println("Ac seats available to book: " + acSeats);
                                System.out.println("General seats available to book: " + generalSeats);

                                System.out.print("Enter number of tickets to book: ");
                                int seats = scanner.nextInt();

                                System.out.print("Enter type of coach: ");
                                System.out.println("1. AC coach");
                                System.out.println("2. General Coach");
                                int type = scanner.nextInt();

                                if (type == 1) {
                                    trainSystem.bookTickets(trainNumber, seats, type);
                                } else if (type == 2) {
                                    trainSystem.bookTickets(trainNumber, seats, type);
                                } else {
                                    System.out.println("Wrong coach type");
                                }
                            }
                            break;

                        case 2:
                            System.out.print("Set username: ");
                            String userName = scanner.next();
                            System.out.print("Set password: ");
                            String passWord = scanner.next();
                            userSystem.setRegister(userName, passWord);
                            break;
                    }
                    break;

                case 4:
                    System.out.println("*** Ticket Cancellation ***");
                    System.out.print("Enter your PNR number: ");
                    int pnr = scanner.nextInt();
                    trainSystem.cancelTickets(pnr);
                    break;

                case 5:
                    System.out.println("Thank you.......");
                    return;

                default:
                    System.out.println("You chose the wrong option");
            }
        }
    }
}

