import testapp.Role

class BootStrap {

    def init = { servletContext ->

        Role.findOrSaveWhere(authority: Role.ADMIN)
        Role.findOrSaveWhere(authority: Role.EMPLOYEE)

    }
    def destroy = {
    }
}
