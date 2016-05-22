package cn.edu.cup.test



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TestDataAController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TestDataA.list(params), model:[testDataAInstanceCount: TestDataA.count()]
    }

    def show(TestDataA testDataAInstance) {
        respond testDataAInstance
    }

    def create() {
        respond new TestDataA(params)
    }

    @Transactional
    def save(TestDataA testDataAInstance) {
        if (testDataAInstance == null) {
            notFound()
            return
        }

        if (testDataAInstance.hasErrors()) {
            respond testDataAInstance.errors, view:'create'
            return
        }

        testDataAInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'testDataA.label', default: 'TestDataA'), testDataAInstance.id])
                redirect testDataAInstance
            }
            '*' { respond testDataAInstance, [status: CREATED] }
        }
    }

    def edit(TestDataA testDataAInstance) {
        respond testDataAInstance
    }

    @Transactional
    def update(TestDataA testDataAInstance) {
        if (testDataAInstance == null) {
            notFound()
            return
        }

        if (testDataAInstance.hasErrors()) {
            respond testDataAInstance.errors, view:'edit'
            return
        }

        testDataAInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TestDataA.label', default: 'TestDataA'), testDataAInstance.id])
                redirect testDataAInstance
            }
            '*'{ respond testDataAInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TestDataA testDataAInstance) {

        if (testDataAInstance == null) {
            notFound()
            return
        }

        testDataAInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TestDataA.label', default: 'TestDataA'), testDataAInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'testDataA.label', default: 'TestDataA'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
