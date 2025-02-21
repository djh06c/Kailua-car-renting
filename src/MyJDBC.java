public class MyJDBC {
    public static void main(String[] args) {
        carObject db = new carObject();

        // lav ny bil
        db.createCar("Gasoline", "ABC123", 120000, "Sedan", 1);

        // læs alle biler
        db.readCars();

                /*
        // slet bil
        db.deleteCar(1);

                 */
    }
}
