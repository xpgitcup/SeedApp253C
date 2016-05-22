package cn.edu.cup.test

import cn.edu.cup.system.SystemMenu

class TestMenuController {

    def show(SystemMenu systemMenuInstance) {
        respond systemMenuInstance
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SystemMenu.list(params), model:[systemMenuInstanceCount: SystemMenu.count()]
    }
    
}
