import java.util.ArrayList;
import java.util.HashMap;

public abstract class ParentTrains {
    protected int trainNumber;
    protected String trainName;
    protected int acSeats;
    protected int generalSeats;
    protected int acFare;
    protected int generalFare;

    protected int pnr = 1000;

    protected String departure;
    protected String destination;
    protected HashMap<Integer, ChildTrains> trains = new HashMap<>();
    protected HashMap<Integer, Ticketbookinfo> passengers = new HashMap<>();
    protected ArrayList<WaitingList>waitingListArrayList=new ArrayList<>();

    public abstract HashMap<Integer, ChildTrains> getTrains();

    public abstract void setTrains(int trainNumber, ChildTrains val);

    public abstract void setTrainNumber(int trainNumber);

    public abstract void setAcSeats(int acSeats);
    public abstract void setGeneralSeats(int generalSeats);
    public abstract void setAcFare(int acFare);
    public abstract void setGeneralFare(int generalFare);
    public abstract void setTrainName(String trainName);
    public abstract void setDeparture(String departure);
    public abstract void setDestination(String destination);

    public abstract int getTrainNumber();
    public abstract String getTrainName();
    public abstract int getAcSeats();
    public abstract int getGeneralSeats();
    public abstract int getAcFare();
    public abstract int getGeneralFare();
    public abstract String getDeparture();
    public abstract String getDestination();

    public abstract void bookedAcSeats(int booked);
    public abstract void cancelAcSeats(int cancelled);

    public abstract void bookedGeneralSeats(int booked);
    public abstract void cancelGeneralSeats(int cancelled);

    public abstract void displayTrains();
    public abstract void addTrainDetails(int trainNumber, ChildTrains childTrains);
    public abstract void bookTickets(int trainNumber, int seats, int type);

    public abstract void cancelTickets(int pnr);
}

