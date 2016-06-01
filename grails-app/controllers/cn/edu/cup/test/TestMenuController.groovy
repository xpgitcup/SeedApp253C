package cn.edu.cup.test

import cn.edu.cup.system.SystemMenu
import cn.edu.cup.test.TestDataA
import cn.edu.cup.userLibs.UserLibInstance

class TestMenuController {

    def calculate(TestDataA a) {
        def userLib = UserLibInstance.get(1)
        def fileName = userLib.fileName
        
        ClassLoader parent = getClass().getClassLoader(); 
        GroovyClassLoader loader = new GroovyClassLoader(parent);   
        
        def file = new File(userLib.realFileName())
        
        loader.addURL(file.toURL())
        
        def className = "cn.edu.cup.test.UserLib4TestDataA"
        
        def clazz = loader.loadClass(className)
        println "${clazz}"
        
        def cs = loader.getLoadedClasses();
        println "类？？${cs}"
        cs.each() {e->
            println "测试： ${e}"
        }
        
        
        def object = clazz.newInstance()
        
        def aa = TestDataA.get(a.id)
        def value = object.invokeMethod("calculator", aa)
        
        def ms = object.class.getDeclaredMethods()
        ms.each() {e->
            println "......${e}"
        }
        
        object = null
        
        return [fileName: fileName, value: value];
    }
    
    def testUserLib(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def theList = TestDataA.list(params)
        def theResult = []
        theList.each() {e->
            theResult.add(calculate(e))
        }
        model:[
            testDataAInstanceList: theList,
            theResult: theResult,
            testDataAInstanceCount: TestDataA.count()
        ]
    }
    
    def show(SystemMenu systemMenuInstance) {
        respond systemMenuInstance
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SystemMenu.list(params), model:[systemMenuInstanceCount: SystemMenu.count()]
    }
    
}
