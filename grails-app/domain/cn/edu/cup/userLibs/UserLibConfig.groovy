package cn.edu.cup.userLibs

class UserLibConfig {

    String name
    String path
    String description
    
    static constraints = {
    }
    
    String toString() {
        return "${name}/${path}"
    }
}
