package design.patterns.structural

import design.patterns.structural.adapter.ThirdPartyReaderAdapter
import design.patterns.structural.adapter.NumbersReader
import spock.lang.Specification

class AdapterSpec extends Specification {
    def "read lines from a file using an adapter"() {
        given: 'a version of the interface acting as an adapter of ThirdPartyReader'
        File file = new File(this.getClass().getResource("/numbers.txt").file)
        NumbersReader reader = new ThirdPartyReaderAdapter(file)

        expect: 'the sum of all numbers is 24'
        reader.read().sum() == 24
    }
}
