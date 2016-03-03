package testapp

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll('validate on a user with name #name should have returned #shouldBeValid')
    void "test name validation"() {
        expect:
        new User(name: name, email: 'valid@email.com').validate() == shouldBeValid

        where:
        name      | shouldBeValid
        null      | false
        ''        | false
        'emmett'  | true

    }
}
