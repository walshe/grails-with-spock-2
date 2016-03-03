package testapp


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test User create"() {

        given: "empty user table"
            assert User.list() == []

        when: "we try to save a user"
            User user = new User(name: 'emmett').save()

        then: "user is actually created"
            user != null
    }

    void "test User retrieve"() {

        given: "empty user table"
        assert User.list() == []

        when: "we save a user"
        User user = new User(name: 'emmett').save()

        then: "user is actually retrievable"

        assert User.get(user.id) != null
    }


    void "test User update"() {
        given: "empty user table"
        assert User.list() == []

        when: "we save a user"

        User user = new User(name: 'emmett').save()

        and: "we update it"

        User retrievedUser = User.get(user.id)
        retrievedUser.name = "newname"
        retrievedUser.save()

        then: "user has been updated"

        assert User.get(user.id).name == "newname"

    }



    void "test User delete"() {
        given: "empty user table"
        assert User.list() == []

        when: "we save a user"

        User user = new User(name: 'emmett').save()
        Long userId = user.id

        assert user!=null

        and: "we delete it"

        user.delete()

        then: "user has been deleted"

        assert User.get(userId) == null
    }
}
