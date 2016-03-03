package testapp

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Role)
class RoleSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll('validate on a role with authority #authority should have returned #shouldBeValid')
    void "test name validation"() {
        expect:
        new Role(authority: authority).validate() == shouldBeValid

        where:
        authority      | shouldBeValid
        null      | false
        ''        | false
        'ADMIN'   | true

    }
}
