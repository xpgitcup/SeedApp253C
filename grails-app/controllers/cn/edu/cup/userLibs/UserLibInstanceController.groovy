package cn.edu.cup.userLibs



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserLibInstanceController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UserLibInstance.list(params), model:[userLibInstanceInstanceCount: UserLibInstance.count()]
    }

    def show(UserLibInstance userLibInstanceInstance) {
        respond userLibInstanceInstance
    }

    def create() {
        respond new UserLibInstance(params)
    }

    @Transactional
    def save(UserLibInstance userLibInstanceInstance) {
        if (userLibInstanceInstance == null) {
            notFound()
            return
        }

        if (userLibInstanceInstance.hasErrors()) {
            respond userLibInstanceInstance.errors, view:'create'
            return
        }

        userLibInstanceInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userLibInstance.label', default: 'UserLibInstance'), userLibInstanceInstance.id])
                redirect userLibInstanceInstance
            }
            '*' { respond userLibInstanceInstance, [status: CREATED] }
        }
    }

    def edit(UserLibInstance userLibInstanceInstance) {
        respond userLibInstanceInstance
    }

    @Transactional
    def update(UserLibInstance userLibInstanceInstance) {
        if (userLibInstanceInstance == null) {
            notFound()
            return
        }

        if (userLibInstanceInstance.hasErrors()) {
            respond userLibInstanceInstance.errors, view:'edit'
            return
        }

        userLibInstanceInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'UserLibInstance.label', default: 'UserLibInstance'), userLibInstanceInstance.id])
                redirect userLibInstanceInstance
            }
            '*'{ respond userLibInstanceInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(UserLibInstance userLibInstanceInstance) {

        if (userLibInstanceInstance == null) {
            notFound()
            return
        }

        userLibInstanceInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'UserLibInstance.label', default: 'UserLibInstance'), userLibInstanceInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userLibInstance.label', default: 'UserLibInstance'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
