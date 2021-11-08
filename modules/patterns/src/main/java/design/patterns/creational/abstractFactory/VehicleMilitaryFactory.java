package design.patterns.creational.abstractFactory;

public class VehicleMilitaryFactory implements VehicleFactory {
    @Override
    public Vehicle create() {
        return new Tank();
    }
}
