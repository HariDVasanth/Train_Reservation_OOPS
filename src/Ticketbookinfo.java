public class Ticketbookinfo {

    private int train_number;
    private int type;
    private int seats;


    public Ticketbookinfo(int train_number, int type, int seats){
        this.train_number=train_number;
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

