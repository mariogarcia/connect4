package patterns.creational

import patterns.creational.abstractFactory.Customer
import patterns.creational.abstractFactory.CustomerType
import patterns.creational.abstractFactory.VehicleContractor
import patterns.creational.abstractFactory.VehicleFactory
import spock.lang.Specification

class AbstractFactorySpec extends Specification {
    def "when using different vehicle factories we should get different type of vehicles"() {
        when:
        VehicleContractor contractor = new VehicleContractor()
        VehicleFactory vehicleFactory = contractor.getFactoryByCustomerType(new Customer(type))

        then:
        vehicleFactory.create().toString() == expectedVehicle

        where:
        type                  | expectedVehicle
        CustomerType.CIVIL    | "Suv"
        CustomerType.MILITARY | "Tank"
    }
}
