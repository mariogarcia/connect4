package patterns.creational

import patterns.creational.singleton.ChuckNorris
import spock.lang.Specification

class SingletonSpec extends Specification {
    def "check universal law saying that Chuck Norris is a singleton"() {
        given: "two calls to Chuck Norris instance"
        ChuckNorris chuckNorris1 = ChuckNorris.getInstance()
        ChuckNorris chuckNorris2 = ChuckNorris.getInstance()

        expect: "that they obey the universal law that there's only one Chuck Norris"
        chuckNorris1 == chuckNorris2

        and: "also that Chuck has always something to say!"
        chuckNorris1.hasSomethingToSay()
    }
}
