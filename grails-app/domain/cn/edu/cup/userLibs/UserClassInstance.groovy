package cn.edu.cup.userLibs

class UserClassInstance {

    String name
    
    static belongsTo = [lib: UserLibInstance]
    
    static constraints = {
    }
    
    String toString() {
        return "${name}"
    }
    
    /*
     * 创建类的实例
     * */
    def classInstance() {
        ClassLoader parent = getClass().getClassLoader(); 
        GroovyClassLoader loader = new GroovyClassLoader(parent);  
        def libFile = new File(lib.realFileName())
        loader.addURL(libFile.toURL())
        def clazz = loader.parseClass(name)
        def object = clazz.newInstance()
        return object
    }
}
