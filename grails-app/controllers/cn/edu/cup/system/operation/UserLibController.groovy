package cn.edu.cup.system.operation

import static org.springframework.http.HttpStatus.*
import cn.edu.cup.userLibs.UserLibInstance
import cn.edu.cup.userLibs.UserLibConfig
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserLibController {

    def commonService

    def checkStatus(fileName) {
        def sf = new File(fileName)
        return sf.exists()
    }
    
    @Transactional
    def doUploadUserLib(UserLibInstance userLibInstanceInstance) {
        
        def uc = UserLibConfig.findById(userLibInstanceInstance.libType.id)
        def webRootDir = commonService.getServletContext().getRealPath("/")
        params.destDir = "${webRootDir}/userLibs/${uc.path}"
        def destFile = commonService.upload(params)
        println "${destFile}"

        userLibInstanceInstance.fileName = destFile
        userLibInstanceInstance.save(flush:true)
        
        redirect(action:"index")
    }
    
    def prepareUploadUserLib() {
        respond new UserLibInstance(params)
    }
    
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def theList = UserLibInstance.list(params)
        def status = []
        theList.each() {e->
            status.add(checkStatus(e.fileName))
        }
        model:[
            userLibInstanceInstanceList: theList,
            status: status,
            userLibInstanceInstanceCount: UserLibInstance.count()
        ]
    }

    
}
