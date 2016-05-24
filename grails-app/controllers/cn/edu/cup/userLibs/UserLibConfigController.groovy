package cn.edu.cup.userLibs

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserLibConfigController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UserLibConfig.list(params), model:[userLibConfigInstanceCount: UserLibConfig.count()]
    }

    def show(UserLibConfig userLibConfigInstance) {
        respond userLibConfigInstance
    }

    def create() {
        respond new UserLibConfig(params)
    }

    @Transactional
    def save(UserLibConfig userLibConfigInstance) {
        if (userLibConfigInstance == null) {
            notFound()
            return
        }

        if (userLibConfigInstance.hasErrors()) {
            respond userLibConfigInstance.errors, view:'create'
            return
        }

        userLibConfigInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userLibConfig.label', default: 'UserLibConfig'), userLibConfigInstance.id])
                redirect userLibConfigInstance
            }
            '*' { respond userLibConfigInstance, [status: CREATED] }
        }
    }

    def edit(UserLibConfig userLibConfigInstance) {
        respond userLibConfigInstance
    }

    @Transactional
    def update(UserLibConfig userLibConfigInstance) {
        if (userLibConfigInstance == null) {
            notFound()
            return
        }

        if (userLibConfigInstance.hasErrors()) {
            respond userLibConfigInstance.errors, view:'edit'
            return
        }

        userLibConfigInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'UserLibConfig.label', default: 'UserLibConfig'), userLibConfigInstance.id])
                redirect userLibConfigInstance
            }
            '*'{ respond userLibConfigInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(UserLibConfig userLibConfigInstance) {

        if (userLibConfigInstance == null) {
            notFound()
            return
        }

        userLibConfigInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'UserLibConfig.label', default: 'UserLibConfig'), userLibConfigInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userLibConfig.label', default: 'UserLibConfig'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
