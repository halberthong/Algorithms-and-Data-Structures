public class ParkingLotTest {
    public static void main(String[] args) throws parkingLotOverFLowException, parkingLotUnderFLowException{
        ParkingLot pl = new ParkingLot("Number 1");
        pl.enter();
        pl.enter();
        print(pl.carCount);
        pl.exit();
        pl.exit();
        pl.exit();
    }
    public static void print(Object obj) {
        if (obj == null) System.out.println("null");
        else System.out.println(obj.toString());
    }
}
