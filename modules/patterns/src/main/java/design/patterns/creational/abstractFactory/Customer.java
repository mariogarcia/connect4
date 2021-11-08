package design.patterns.creational.abstractFactory;

public class Customer {
    private final CustomerType customerType;

    public Customer(CustomerType type) {
        this.customerType = type;
    }

    public CustomerType getCustomerType() {
        return this.customerType;
    }
}
