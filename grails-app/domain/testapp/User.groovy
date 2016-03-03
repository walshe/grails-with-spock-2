package testapp

class User {

    String name

    static hasMany = [roles: Role]

    static constraints = {
    }
}
