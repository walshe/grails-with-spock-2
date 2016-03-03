package testapp

import groovy.transform.ToString

@ToString(includes = ['authority'])
class Role {

    static final String ADMIN = 'ADMIN'
    static final String EMPLOYEE = 'EMPLOYEE'

    String authority

    static constraints = {
        authority nullable: false
    }
}
