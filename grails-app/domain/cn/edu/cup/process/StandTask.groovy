package cn.edu.cup.process

import static org.springframework.http.HttpStatus.*

class StandTask {
    
    def systemLogService
    
    String name
    String paramsDescription
    
    static constraints = {
    }
    
    String toString() {
        return "${name}&${paramsDescription}"
    }
    
}
