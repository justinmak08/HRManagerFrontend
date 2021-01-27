import Vue from 'vue'
import Router from 'vue-router'
import Home from '../components/Home'
import Table from '../components/Table'
import Form from '../components/Form'
import Login from '../components/Login'
import BarCharts from '../components/BarCharts'
import PieCharts from '../components/PieCharts'
import Update from '../components/Update'
import Test from '@/components/Test'
import Employee from '../components/Employee'
import EmployeeForm from '../components/EmployeeForm'
import Projects from '../components/Projects'
import ProjectsForm from '../components/ProjectsForm'
import Teams from '../components/Teams'
import TeamsForm from '../components/TeamsForm'
import FindEmployeeByIdForm from '../components/FindEmployeeByIdForm'
import FindProjectByIdForm from '../components/FindProjectByIdForm'
import FindTeamByIdForm from '../components/FindTeamByIdForm'
import TeamsTable from '../components/TeamsTable'
import ProjectsTable from '../components/ProjectsTable'
import EmployeeTable from '../components/EmployeeTable'
import TeamsUpdate from '../components/TeamsUpdate'
import ProjectsUpdate from '../components/ProjectsUpdate'
import EmployeeUpdate from '../components/EmployeeUpdate'

Vue.use(Router)

const router = new Router({

    mode: 'history',
    // routes:[
    //     {path: '/login', component: Login, name: '登录'},
    //     {
    //         path: '/',
    //         name: '图书管理',
    //         component: Test,
    //         iconCls: 'el-icon-message',
    //         redirect: '/table',
    //         menuShow: true,
    //         children: [
    //             {path: '/table', component: Table, name: '查询图书',menuShow: true},
    //             {path: '/form', component: Form, name: '添加图书',menuShow: true}
    //         ]
    //     },
    //     {
    //         path: '/charts',
    //         name: '数据统计',
    //         component: Test,
    //         iconCls: 'el-icon-setting',
    //         menuShow: true,
    //         children: [
    //             {path: '/piecharts', component: PieCharts, name: '饼图',menuShow: true},
    //             {path: '/barcharts', component: BarCharts, name: '柱状图',menuShow: true}
    //         ]
    //     },
    //     {
    //         path: '/update',
    //         name: '修改图书',
    //         component: Test,
    //         redirect: '/edit',
    //         children: [
    //             {path: '/edit', component: Update, name: '修改图书'}
    //         ]
    //     }
    // ]


    routes:[
        {
            path: '/',
            name: '图书管理',
            component: Home,
            // leaf: true, // 只有一个节点
            menuShow: true,
            redirect: '/table',
            iconCls: 'iconfont icon-home', // 图标样式class
            children: [
                {path: '/table', component: Table, name: '查询图书', menuShow: true},
                {path: '/form', component: Form, name: '添加图书', menuShow: true}
            ]
        },
        {
            path: '/charts',
            name: '数据统计',
            component: Home,
            menuShow: true,
            redirect: '/barcharts',
            iconCls: 'iconfont icon-setting1',
            children: [
                {path: '/barcharts', component: BarCharts, name: '柱状图', menuShow: true},
                {path: '/piecharts', component: PieCharts, name: '饼图', menuShow: true}
            ]
        },
        {
            path: '/',
            name: 'Employee',
            component: Home,
            // leaf: true, // 只有一个节点
            menuShow: true,
            redirect: '/employee',
            iconCls: 'iconfont icon-home',
            children: [
                {path: '/employee', component: EmployeeTable, name: 'Employee', menuShow: true},
                {path: '/employeeForm', component: EmployeeForm, name: 'Add Employee', menuShow: true},
                {path: '/findEmployeeById', component: FindEmployeeByIdForm, name: 'Employee ID Query', menuShow: true}
            ]
        },
        {
            path: '/',
            name: 'Projects',
            component: Home,
            // leaf: true, // 只有一个节点
            menuShow: true,
            redirect: '/projects',
            iconCls: 'iconfont icon-home',
            children: [
                {path: '/projects', component: ProjectsTable, name: 'Projects', menuShow: true},
                {path: '/projectsForm', component: ProjectsForm, name: 'Add Projects', menuShow: true},
                {path: '/findProjectById', component: FindProjectByIdForm, name: 'Project ID Query', menuShow: true}
            ]
        },
        {
            path: '/projectsUpdate',
            name: 'Update Project',
            component: Home,
            redirect: '/projectsEdit',
            iconCls: 'iconfont icon-home',
            children: [
                {path: '/projectsEdit', component: ProjectsUpdate, name: 'Update Project'}
            ]
        },
        {
            path: '/',
            name: 'Teams',
            component: Home,
            menuShow: true,
            redirect: '/teams',
            iconCls: 'iconfont icon-home',
            children: [
                {path: '/teams', component: TeamsTable, name: 'Teams', menuShow: true},
                {path: '/teamsForm', component: TeamsForm, name: 'Add Teams', menuShow: true},
                {path: '/findTeamById', component: FindTeamByIdForm, name: 'Team ID Query', menuShow: true}
            ]
        },
        {
            path: '/teamsUpdate',
            name: 'Update Team',
            component: Home,
            redirect: '/teamsEdit',
            iconCls: 'iconfont icon-home', 
            children: [
                {path: '/teamsEdit', component: TeamsUpdate, name: 'Update Team'}
            ]
        },
        {
            path: '/employeeUpdate',
            name: 'Update Employee',
            component: Home,
            redirect: '/employeeEdit',
            iconCls: 'iconfont icon-home', 
            children: [
                {path: '/employeeEdit', component: EmployeeUpdate, name: 'Update Employee'}
            ]
        },
        {
            path: '/login',
            name: '登录',
            component: Login
        },
        {
            path: '/test',
            name: '登录',
            component: () => import(/* webpackChunkName: "about" */ '../components/Test.vue')
        },
        {
            path: '/update',
            name: '修改图书',
            component: Home,
            redirect: '/edit',
            iconCls: 'iconfont icon-home', // 图标样式class
            children: [
                {path: '/edit', component: Update, name: '修改图书'}
            ]
        }
    ]
})

router.beforeEach((to, from, next) => {
    // console.log('to:' + to.path)
    if (to.path.startsWith('/login')) {
    window.localStorage.removeItem('access-user')
    next()
} else {
    let user = JSON.parse(window.localStorage.getItem('access-user'))
    if (!user) {
        next({path: '/login'})
    } else {
        next()
    }
}
})

export default router