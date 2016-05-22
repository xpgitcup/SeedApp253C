package cn.edu.cup.userLibs

import java.util.Formatter.DateTime

class UserLibInstance {
    
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
}
