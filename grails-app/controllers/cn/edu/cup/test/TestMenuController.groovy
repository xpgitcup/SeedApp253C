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
        
        println "${parent}"
        println "${loader}"
        
        println "文件名：${fileName}"
        def engine = new GroovyScriptEngine(fileName)
        
        def className = "testuserlib.TestUserLib"
        def clazz = engine.loadScriptByName(className)
        def instance = clazz.newInstance()
        println "${clazz}"
        //def clazz = loader.loadClass(fileName)
        
        println "${clazz}"
        
        return [fileName: fileName, value: 100];
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
