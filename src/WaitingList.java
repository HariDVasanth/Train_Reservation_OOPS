public class WaitingList {
    private int train_number;
    private int type;
    private int seats;

    public WaitingList(int type,int seats,int trainNumber){
        this.train_number=trainNumber;
        this.type=type;
        this.seats=seats;
    }
    public int getTrainNumber() {
        return train_number;
    }

    public int getType() {
        return type;
    }

    public int getSeats() {
        return seats;
    }


}

