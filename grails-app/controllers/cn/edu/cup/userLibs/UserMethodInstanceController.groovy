package cn.edu.cup.userLibs



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserMethodInstanceController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UserMethodInstance.list(params), model:[userMethodInstanceInstanceCount: UserMethodInstance.count()]
    }

    def show(UserMethodInstance userMethodInstanceInstance) {
        respond userMethodInstanceInstance
    }

    def create() {
        respond new UserMethodInstance(params)
    }

    @Transactional
    def save(UserMethodInstance userMethodInstanceInstance) {
        if (userMethodInstanceInstance == null) {
            notFound()
            return
        }

        if (userMethodInstanceInstance.hasErrors()) {
            respond userMethodInstanceInstance.errors, view:'create'
            return
        }

        userMethodInstanceInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userMethodInstance.label', default: 'UserMethodInstance'), userMethodInstanceInstance.id])
                redirect userMethodInstanceInstance
            }
            '*' { respond userMethodInstanceInstance, [status: CREATED] }
        }
    }

    def edit(UserMethodInstance userMethodInstanceInstance) {
        respond userMethodInstanceInstance
    }

    @Transactional
    def update(UserMethodInstance userMethodInstanceInstance) {
        if (userMethodInstanceInstance == null) {
            notFound()
            return
        }

        if (userMethodInstanceInstance.hasErrors()) {
            respond userMethodInstanceInstance.errors, view:'edit'
            return
        }

        userMethodInstanceInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'UserMethodInstance.label', default: 'UserMethodInstance'), userMethodInstanceInstance.id])
                redirect userMethodInstanceInstance
            }
            '*'{ respond userMethodInstanceInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(UserMethodInstance userMethodInstanceInstance) {

        if (userMethodInstanceInstance == null) {
            notFound()
            return
        }

        userMethodInstanceInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'UserMethodInstance.label', default: 'UserMethodInstance'), userMethodInstanceInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userMethodInstance.label', default: 'UserMethodInstance'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
