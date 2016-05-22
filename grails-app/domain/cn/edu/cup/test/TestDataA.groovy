package cn.edu.cup.test

class TestDataA {
    
    Double dataa
    Double datab
    
    static mapping = {
    }

    static constraints = {
    }
    
    String toDtring() {
        return "(%{dataa}, ${datab})"
    }
}
