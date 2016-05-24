package cn.edu.cup.userLibs

import java.util.Formatter.DateTime

class UserLibInstance {

    def commonService
    
    String name
    String description
    String fileName
    String developer
    Date   uploadDate 
    
    static belongsTo = [libType: UserLibConfig]
    
    static constraints = {
        name()
        description()
        fileName()
        developer()
        uploadDate()
    }
    
    String toString() {
        return "${name}/${description}"
    }
    
    String realPath() {
        def uc = libType.path
        def webRootDir = commonService.getServletContext().getRealPath("/")
        return "${webRootDir}/userLibs/${uc}"
    }
    
    String realFileName() {
        def path = realPath()
        def destDir = "${path}/${fileName}"
    }
    
    Boolean status() {
        def rfileName = realFileName() 
        def f = new File(rfileName)
        return f.exists()
    }
}
