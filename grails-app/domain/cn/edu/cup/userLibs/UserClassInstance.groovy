package cn.edu.cup.userLibs

class UserClassInstance {

    String name
    
    static belongsTo = [lib: UserLibInstance]
    
    static constraints = {
    }
    
    String toString() {
        return "${name}"
    }
}
