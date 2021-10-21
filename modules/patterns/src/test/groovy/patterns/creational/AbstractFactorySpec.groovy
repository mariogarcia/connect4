package patterns.creational

import patterns.creational.abstractFactory.Customer
import patterns.creational.abstractFactory.CustomerType
import patterns.creational.abstractFactory.VehicleContractor
import patterns.creational.abstractFactory.VehicleFactory
import spock.lang.Specification

class AbstractFactorySpec extends Specification {
    def "create vehicles for different customers"() {
        when: "asking the contractor to get the proper factory"
        VehicleContractor contractor = new VehicleContractor()
        VehicleFactory vehicleFactory = contractor.getFactoryByCustomerType(customer)

        then: "the provided factory should build the expected type of vehicle"
        vehicleFactory.create().toString() == expectedVehicle

        where: "possible customers and expected results are"
        customer                            | expectedVehicle
        new Customer(CustomerType.CIVIL)    | "Suv"
        new Customer(CustomerType.MILITARY) | "Tank"
    }
}