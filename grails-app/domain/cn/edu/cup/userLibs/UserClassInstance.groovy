package cn.edu.cup.userLibs

class UserClassInstance {

    String name
    
    static belongsTo = [lib: UserLibInstance]
    
    static hasMany = [methods: UserMethodInstance]
    
    static constraints = {
    }
    
    String toString() {
        return "${name}"
    }
    
    /*
     * 创建类
     * */
    def loadClass() {
        ClassLoader parent = getClass().getClassLoader(); 
        GroovyClassLoader loader = new GroovyClassLoader(parent);  
        def libFile = new File(lib.realFileName())
        println "classInstance ${libFile}"
        loader.addURL(libFile.toURL())
        //def clazz = loader.parseClass(name)
        def clazz = loader.loadClass(name)
        println "classInstance ${clazz}"
        return clazz
    }
    
    /*
     * 创建类的实例
     * */
    def classInstanceMethods() {
        def cc = loadClass()
        def ms = cc.getDeclaredMethods()
        return ms
    }
    
    /*
     * 创建类的实例
     * */
    def classInstance() {
        def object = loadClass().newInstance()
        return object
    }
}
