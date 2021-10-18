package patterns.creational.abstractFactory;

public class VehicleContractor {
    public VehicleFactory getFactoryByCustomerType(Customer customer) {
        if (customer.getCustomerType() == CustomerType.MILITARY){
            return new VehicleMilitaryFactory();
        }
        return new VehicleCivilFactory();
    }
}
