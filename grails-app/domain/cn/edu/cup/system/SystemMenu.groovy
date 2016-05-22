package cn.edu.cup.system

import groovy.xml.MarkupBuilder

class SystemMenu {
    
    String menuContext
    String menuAction
    int    menuRight
    String menuDescription
    int    menuOrder
    SystemMenu upMenuItem
    
    static hasMany = [menuItems: SystemMenu]
    
    static constraints = {
        menuContext()
        menuAction()
        menuRight()
        menuDescription()
        menuOrder()
        upMenuItem(nullable:true)
    }
    
    static mapping = {
        sort('menuOrder')
        sort('id')
        menuItems sort: 'menuOrder', 'id'  //这是排序的标准做法 
    }
    
    String toString() {
        return "${menuContext}(${menuRight})"
    }
    
    //获取顶级菜单的标题
    String topMenuContext() {
        def menuItem = this
        while (menuItem.upMenuItem) {
            menuItem = menuItem.upMenuItem
        }
        return menuItem.menuContext
    }
    
    /*
     * 返回以当前菜单为根节点的序列 
     * */
    String currentTree() {
        def writer = new StringWriter()
        def ulString = new MarkupBuilder(writer)

        ulString.ul() {
            li([id: "${id}"]) {
                span("${menuContext}")
                
            }
        }
        
        return writer.toString()
    }
    
}
