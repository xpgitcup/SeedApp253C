package cn.edu.cup.system

import cn.edu.cup.process.ProcessTask
import cn.edu.cup.process.StandTask
import grails.transaction.Transactional

@Transactional
class InitService {
    
    def dataSource

    def processTasks() {
        println "开始处理："
        def tasks = ProcessTask.findAllByStatus(false)
        tasks.each() {e->
            taskExecute(e)
            println "处理${e}..."
        }
    }
    
    def taskExecute(ProcessTask task) {
        switch (task.name.name) {
        case "更新":
            def file = new File(task.paramsString)
            if (file.exists()) {
                def ok = file.delete()
                task.status = ok
                task.save()
            }
            break;
        default:
            println "不认识的任务：${task}"
        }
    }
    
    //加载数据库初始化脚本
    def loadScripts(String dir) {
        def File sf = new File(dir)
        println "load scripts ${dir}"
        if (sf.exists()) {
            if (sf) {
                sf.eachFile {f->
                    if (f.isFile()) {
                        executeScript(f)
                    }
                }
            }
        }
    }
    
    //执行附加脚本
    def executeScript(File sf) {
        //def File sf = new File(fileName)
        println "init - ${sf}"
        if (sf) {
            def db
            def sql = sf.text
            db = new groovy.sql.Sql (dataSource)
            //println "init - ${sql}"
            def lines = sql.split(";")
            lines.each() {it->
                //println "line: ${it}"
                it = it.trim()
                if (!it.isEmpty()) {
                    db.executeUpdate(it)
                }
            }
        }
    }
    
}
