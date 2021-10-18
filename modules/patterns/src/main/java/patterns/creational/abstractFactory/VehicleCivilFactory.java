package patterns.creational.abstractFactory;

public class VehicleCivilFactory implements VehicleFactory {
    @Override
    public Vehicle create() {
        return new Suv();
    }
}
