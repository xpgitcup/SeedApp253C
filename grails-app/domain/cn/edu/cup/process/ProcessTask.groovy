package cn.edu.cup.process

class ProcessTask {
    
    StandTask name
    Boolean status
    Date createdAt 
    ProcessTask upTask
    String paramsString
    
    static mapping = {
        
    }
    
    static constraints = {
        name()
        status()
        createdAt()
        upTask(nullable: true)
    }
    
    String toString() {
        return "${name}/(${createdAt}.${status}})"
    }
}
