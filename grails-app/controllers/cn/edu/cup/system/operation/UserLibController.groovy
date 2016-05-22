package cn.edu.cup.system.operation

import static org.springframework.http.HttpStatus.*
import cn.edu.cup.userLibs.UserLibInstance
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserLibController {

    def commonService

    @Transactional
    def doUploadUserLib(UserLibInstance userLibInstanceInstance) {
        
        userLibInstanceInstance.save(flush:true)
        
        params.destDir = "temp"
        def destFile = commonService.upload(params)
        println "${destFile}"
        redirect(action:"index")
    }
    
    def prepareUploadUserLib() {
        respond new UserLibInstance(params)
    }
    
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UserLibInstance.list(params), model:[userLibInstanceInstanceCount: UserLibInstance.count()]
    }

    
}
