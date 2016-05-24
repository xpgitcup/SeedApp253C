package cn.edu.cup.userLibs



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserClassInstanceController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UserClassInstance.list(params), model:[userClassInstanceInstanceCount: UserClassInstance.count()]
    }

    def show(UserClassInstance userClassInstanceInstance) {
        respond userClassInstanceInstance
    }

    def create() {
        respond new UserClassInstance(params)
    }

    @Transactional
    def save(UserClassInstance userClassInstanceInstance) {
        if (userClassInstanceInstance == null) {
            notFound()
            return
        }

        if (userClassInstanceInstance.hasErrors()) {
            respond userClassInstanceInstance.errors, view:'create'
            return
        }

        userClassInstanceInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userClassInstance.label', default: 'UserClassInstance'), userClassInstanceInstance.id])
                redirect userClassInstanceInstance
            }
            '*' { respond userClassInstanceInstance, [status: CREATED] }
        }
    }

    def edit(UserClassInstance userClassInstanceInstance) {
        respond userClassInstanceInstance
    }

    @Transactional
    def update(UserClassInstance userClassInstanceInstance) {
        if (userClassInstanceInstance == null) {
            notFound()
            return
        }

        if (userClassInstanceInstance.hasErrors()) {
            respond userClassInstanceInstance.errors, view:'edit'
            return
        }

        userClassInstanceInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'UserClassInstance.label', default: 'UserClassInstance'), userClassInstanceInstance.id])
                redirect userClassInstanceInstance
            }
            '*'{ respond userClassInstanceInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(UserClassInstance userClassInstanceInstance) {

        if (userClassInstanceInstance == null) {
            notFound()
            return
        }

        userClassInstanceInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'UserClassInstance.label', default: 'UserClassInstance'), userClassInstanceInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userClassInstance.label', default: 'UserClassInstance'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
