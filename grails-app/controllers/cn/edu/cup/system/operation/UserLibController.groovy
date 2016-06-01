package cn.edu.cup.system.operation

import static org.springframework.http.HttpStatus.*
import cn.edu.cup.userLibs.UserLibInstance
import cn.edu.cup.userLibs.UserLibConfig
import cn.edu.cup.userLibs.UserClassInstance
import cn.edu.cup.userLibs.UserMethodInstance
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
        
        def nfileName = params.uploadedFile.originalFilename
        println "准备上传：${nfileName}"

        params.destDir = userLibInstanceInstance.realPath()
        
        def cfile = new File("${userLibInstanceInstance.realPath()}/${nfileName}")
        /*
        if (cfile.exists()) {
        flash.message = "${nfileName}已经存在了！"
        redirect(action: "prepareUploadUserLib")
        } else {
        def destFile = commonService.upload(params)
        println "${destFile}"
        userLibInstanceInstance.fileName = nfileName
        userLibInstanceInstance.save(flush:true)
        println "上传成功......"
        userLibInstanceInstance.getEntries()
        redirect(action:"index")
        }*/
        def destFile = commonService.upload(params)
        println "${destFile}"
        userLibInstanceInstance.fileName = nfileName
        userLibInstanceInstance.save(flush:true)
        println "上传成功......"
        def clnames = userLibInstanceInstance.getEntries()
        clnames.each() {e->
            if (e.contains('.class')) {
                println "?? ${e}"
                def k = e.lastIndexOf('.class')
                def cn = e.substring(0, k).replace('/', '.') //e.substring(k+1)
                println "c: ${cn}"
                def nc = new UserClassInstance(name: cn, lib: userLibInstanceInstance)
                nc.save(flush: true)
                
                def object = nc.classInstance()
                //def ms = object.class.getDeclaredMethods()
                //def ms = object.class.getMethods()
                def ms = nc.classInstanceMethods()
                ms.each() {ee->
                    def nm = new UserMethodInstance(name: ee.name, clazz: nc)
                    nm.save(flush: true)
                    println "method ${ee}"
                }
            }
        }
        redirect(action:"index")
        
    }
    
    def prepareUploadUserLib() {
        respond new UserLibInstance(params)
    }
    
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def theList = UserLibInstance.list(params)
        //def status = []
        //theList.each() {e->
        //    status.add(checkStatus(e.fileName))
        //}
        model:[
            userLibInstanceInstanceList: theList,
            //status: status,
            userLibInstanceInstanceCount: UserLibInstance.count()
        ]
    }

    
}
