package cn.edu.cup.process



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class StandTaskController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond StandTask.list(params), model:[standTaskInstanceCount: StandTask.count()]
    }

    def show(StandTask standTaskInstance) {
        respond standTaskInstance
    }

    def create() {
        respond new StandTask(params)
    }

    @Transactional
    def save(StandTask standTaskInstance) {
        if (standTaskInstance == null) {
            notFound()
            return
        }

        if (standTaskInstance.hasErrors()) {
            respond standTaskInstance.errors, view:'create'
            return
        }

        standTaskInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'standTask.label', default: 'StandTask'), standTaskInstance.id])
                redirect standTaskInstance
            }
            '*' { respond standTaskInstance, [status: CREATED] }
        }
    }

    def edit(StandTask standTaskInstance) {
        respond standTaskInstance
    }

    @Transactional
    def update(StandTask standTaskInstance) {
        if (standTaskInstance == null) {
            notFound()
            return
        }

        if (standTaskInstance.hasErrors()) {
            respond standTaskInstance.errors, view:'edit'
            return
        }

        standTaskInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'StandTask.label', default: 'StandTask'), standTaskInstance.id])
                redirect standTaskInstance
            }
            '*'{ respond standTaskInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(StandTask standTaskInstance) {

        if (standTaskInstance == null) {
            notFound()
            return
        }

        standTaskInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'StandTask.label', default: 'StandTask'), standTaskInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'standTask.label', default: 'StandTask'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
