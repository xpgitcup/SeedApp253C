package cn.edu.cup.userLibs

class UserMethodInstance {
    
    String name
    
    static belongsTo = [clazz: UserClassInstance]

    static constraints = {
    }
    
    String toString() {
        return "${clazz}.${name}"
    }
}
