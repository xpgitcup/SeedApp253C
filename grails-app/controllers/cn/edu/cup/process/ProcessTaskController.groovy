package cn.edu.cup.process



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProcessTaskController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ProcessTask.list(params), model:[processTaskInstanceCount: ProcessTask.count()]
    }

    def show(ProcessTask processTaskInstance) {
        respond processTaskInstance
    }

    def create() {
        respond new ProcessTask(params)
    }

    @Transactional
    def save(ProcessTask processTaskInstance) {
        if (processTaskInstance == null) {
            notFound()
            return
        }

        if (processTaskInstance.hasErrors()) {
            respond processTaskInstance.errors, view:'create'
            return
        }

        processTaskInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'processTask.label', default: 'ProcessTask'), processTaskInstance.id])
                redirect processTaskInstance
            }
            '*' { respond processTaskInstance, [status: CREATED] }
        }
    }

    def edit(ProcessTask processTaskInstance) {
        respond processTaskInstance
    }

    @Transactional
    def update(ProcessTask processTaskInstance) {
        if (processTaskInstance == null) {
            notFound()
            return
        }

        if (processTaskInstance.hasErrors()) {
            respond processTaskInstance.errors, view:'edit'
            return
        }

        processTaskInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ProcessTask.label', default: 'ProcessTask'), processTaskInstance.id])
                redirect processTaskInstance
            }
            '*'{ respond processTaskInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ProcessTask processTaskInstance) {

        if (processTaskInstance == null) {
            notFound()
            return
        }

        processTaskInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ProcessTask.label', default: 'ProcessTask'), processTaskInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'processTask.label', default: 'ProcessTask'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
