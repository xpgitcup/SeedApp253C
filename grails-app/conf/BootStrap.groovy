
import cn.edu.cup.test.TestDataA

class BootStrap {

    def initService
    
    /*
     * 初始化....
     * */
    def init = { servletContext ->
        environments {
            development {
                configureForDevelopment(servletContext);
            }
            production {
                initService.processTasks()
            }
        }
    }
    
    /*
     * 撤销、退出
     * */
    def destroy = {
    }
    
    /*
     * 初始化代码
     * */
    def configureForDevelopment(servletContext) {
        println "这是开发环境..."
        def webRootDir = servletContext.getRealPath("/")
        println "BootStrap ${webRootDir}"
        //系统数据库的初始化
        def scriptPath = "${webRootDir}scripts/system"
        println "初始化 ${scriptPath}"
        initService.loadScripts(scriptPath)
        //用户数据库的初始化
        def scriptPathUser = "${webRootDir}scripts/user"
        println "初始化 ${scriptPathUser}"
        initService.loadScripts(scriptPathUser)
        //处理任务
        initService.processTasks()
    }
    
    /*
     * 发布以后的
     * */
    def configureForProduction() {}

}
