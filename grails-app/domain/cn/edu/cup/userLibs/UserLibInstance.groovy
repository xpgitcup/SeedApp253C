package cn.edu.cup.userLibs

class UserLibInstance {
    
    String name
    String description
    String developer
    Date   uploadDate 
    
    static belongsTo = [libType: UserLibConfig]
    
    static constraints = {
    }
    
    String toString() {
        return "${name}/${description}"
    }
}
