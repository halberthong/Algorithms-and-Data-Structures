public class ParkingLot {
    public static final int capacity = 100;
    protected int carCount;
    protected String name;
    public ParkingLot(String s) {
        carCount = 0;
        name = s;
    }
    public int carCount() {
        return carCount;
    }
    public String name() {
        return name;
    }
    public void enter() throws parkingLotOverFLowException {
        if (carCount == capacity) {
            throw new parkingLotOverFLowException(this);
        } else {
            carCount++;
        }
    }
    public void exit() throws parkingLotUnderFLowException {
        if (carCount == 0) {
            throw new parkingLotUnderFLowException(this);
        } else {
            carCount--;
        }
    }
}
class parkingLotOverFLowException extends Exception {
    public ParkingLot overflowParkingLot;
    public parkingLotOverFLowException(ParkingLot p) {
        overflowParkingLot = p;
    }
}

class parkingLotUnderFLowException extends Exception {
    public ParkingLot underflowParkingLot;
    public parkingLotUnderFLowException(ParkingLot p) {
        underflowParkingLot = p;
    }
}
