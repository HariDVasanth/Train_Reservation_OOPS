import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChildTrains extends ParentTrains {

    Scanner scanner=new Scanner(System.in);

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }


    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }


    public void setGeneralSeats(int generalSeats) {
        this.generalSeats = generalSeats;
    }


    public void setAcSeats(int acSeats) {
        this.acSeats = acSeats;
    }


    public void setAcFare(int acFare) {
        this.acFare = acFare;
    }


    public void setGeneralFare(int generalFare) {
        this.generalFare = generalFare;
    }




    public void setDeparture(String departure) {
        this.departure = departure;
    }


    public void setDestination(String destination) {
        this.destination = destination;
    }


    public void setTrains(int trainNumber, ChildTrains val) {
        trains.put(trainNumber, val);
    }


    public int getTrainNumber() {
        return trainNumber;
    }


    public String getTrainName() {
        return trainName;
    }


    public int getAcSeats() {
        return acSeats;
    }


    public int getGeneralSeats() {
        return generalSeats;
    }


    public int getGeneralFare() {
        return generalFare;
    }


    public int getAcFare() {
        return acFare;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public HashMap<Integer, ChildTrains> getTrains() {
        return trains;
    }


    public void displayTrains() {
        for (Map.Entry<Integer, ChildTrains> entry : trains.entrySet()) {
            int key = entry.getKey();
            ParentTrains value = entry.getValue();
            System.out.println("Train number: " + key);
            System.out.println();
            System.out.println(value);
        }
    }

    public String toString(){
        return  "Train name:"+" "+getTrainName()+"\n"+
                "Departure: "+getDeparture()+"\n"+
                "Destination: "+getDestination()+"\n"+
                "Ac seats Available:"+" "+getAcSeats()+"\n"+
                "General seats Available:"+" "+getGeneralSeats()+"\n"+
                "Ac seats fare:"+" "+getAcFare()+"\n"+
                "General seats fare:"+" "+getGeneralFare();

    }


    public void bookedAcSeats(int booked) {
        acSeats -= booked;
    }


    public void cancelAcSeats(int cancelled) {
        acSeats += cancelled;
    }


    public void bookedGeneralSeats(int booked) {
        generalSeats -= booked;
    }


    public void cancelGeneralSeats(int cancelled) {
        generalSeats += cancelled;
    }


    public void addTrainDetails(int trainNumber, ChildTrains childTrains) {
        trains.put(trainNumber, childTrains);
    }


    public void bookTickets(int trainNumber, int seats, int type) {
        if (type == 1) {
            acSeats = getTrains().get(trainNumber).getAcSeats();
            acFare = getTrains().get(trainNumber).getAcFare();
            if (acSeats >=seats) {
                System.out.println("Amount to pay: " + acFare * seats);
                pnr += 1;

                Ticketbookinfo ticketbookinfo = new Ticketbookinfo(trainNumber, type, seats);
                passengers.put(pnr, ticketbookinfo);

                System.out.println("Ac seats booked successfully, your PNR is: " + pnr);
                bookedAcSeats(seats);
                System.out.println("AC seats Available: " + getAcSeats());

            }else{System.out.println("Do you want to be added to the waiting list?");
                System.out.println("if YES type'1");
                int n=scanner.nextInt();
                if(n==1) {
                    WaitingList waitingList = new WaitingList(type, seats, trainNumber);
                    waitingListArrayList.add(waitingList);
                    System.out.println("Your requirements are added to waiting list");
                }
                else{
                    System.out.println("Thank you...");
                }
            }
        } else if (type == 2) {

            generalSeats = getTrains().get(trainNumber).getGeneralSeats();
            generalFare = getTrains().get(trainNumber).getGeneralFare();

            if(generalSeats>=seats){
            System.out.println("Amount to pay: " + generalFare * seats);
            pnr += 1;

            Ticketbookinfo ticketbookinfo = new Ticketbookinfo(trainNumber, type, seats);
            passengers.put(pnr, ticketbookinfo);

            System.out.println("Ticket booked successfully, your PNR is: " + pnr);
            bookedGeneralSeats(seats);
            System.out.println("General seats Available: " + getGeneralSeats());
        }
            else{
            System.out.println("Do you want to be added to the waiting list?");
            System.out.println("if YES type'1");
            int n=scanner.nextInt();
            if(n==1) {
                WaitingList waitingList = new WaitingList(type, seats, trainNumber);
                waitingListArrayList.add(waitingList);
                System.out.println("Your Requirements are added in the waitinglist");
            }
            else{
                System.out.println("Thank you...");
            }
        }
    }
    }



    public void cancelTickets(int pnr) {
        if (passengers.containsKey(pnr)) {
            Ticketbookinfo ticketbookinfo = passengers.get(pnr);
            int trainNumber = ticketbookinfo.getTrainNumber();
            int seats = ticketbookinfo.getSeats();
            int type = ticketbookinfo.getType();
            int canceledAcSeat = 0;
            int cancelgeneralSeats=0;
            if (type == 1) {
                canceledAcSeat=seats;

                System.out.println("Tickets cancelled successfully");
                passengers.remove(pnr);
            } else if (type == 2) {
                System.out.println("Tickets cancelled successfully");
                passengers.remove(pnr);
            }
            if(!waitingListArrayList.isEmpty()){
                WaitingList waitingList=waitingListArrayList.get(0);
                int waitingListTrainNumber=waitingList.getTrainNumber();
                int seatType=waitingList.getType();
                int waitingSeats=waitingList.getSeats();
                if(seatType==1){
                    if(canceledAcSeat>=waitingSeats){
                        canceledAcSeat-=waitingSeats;
                        pnr+=1;
                        Ticketbookinfo ticketbookinfo1=new Ticketbookinfo(waitingListTrainNumber,seatType,waitingSeats);
                        passengers.put(pnr,ticketbookinfo1);
                        System.out.println("Trains moved from waiting list to booked");
                        waitingListArrayList.remove(0);
                        cancelAcSeats(canceledAcSeat);
                    }
                    else if(type==2){
                        if(cancelgeneralSeats>=waitingSeats){
                            cancelgeneralSeats-=waitingSeats;
                            pnr+=1;
                            Ticketbookinfo ticketbookinfo1=new Ticketbookinfo(waitingListTrainNumber,seatType,waitingSeats);
                            passengers.put(pnr,ticketbookinfo1);
                            System.out.println("Trains moved from waiting list to booked");
                            waitingListArrayList.remove(0);
                            cancelGeneralSeats(cancelgeneralSeats);
                        }
                    }
                }
            }

        }
    }
}
