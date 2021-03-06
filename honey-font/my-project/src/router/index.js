import Vue from 'vue'
import Router from 'vue-router'
import vPage from 'v-page'
import login from '@/components/login'
import Checkstatus1 from '@/components/Checkstatus1'
import Hosthoneypot from '@/components/Hosthoneypot'
import index from '@/components/index'
import applyhoney from '@/components/applyhoney'
import systemindex from '@/components/systemindex'
import honeybuild from '@/components/honeybuild'
import fileoperations from '@/components/Hosthoneypots/fileoperations'
import filemap from '@/components/Hosthoneypots/filemap'
import networkusage from '@/components/Hosthoneypots/networkusage'
import registryinfo from '@/components/Hosthoneypots/registryinfo'
import registryassignment from '@/components/Hosthoneypots/registryassignment'
import processoper from '@/components/Hosthoneypots/processoper'
import operationthread from '@/components/Hosthoneypots/operationthread'
import Hungthread from '@/components/Hosthoneypots/Hungthread'
import replythread from '@/components/Hosthoneypots/replythread'
import moduleoperation from '@/components/Hosthoneypots/moduleoperation'
import HoneyControl from '@/components/HoneyControl'
import Operator from '@/components/Operator'
import UpdatePassword from '@/components/UpdatePassword'
import test from '@/components/Hosthoneypots/test'
import start_self_release from '@/components/Hosthoneypots/1_start_self_release'
import registration_service_dynamic_library from '@/components/Hosthoneypots/2_registration_service_dynamic_library'
import add_system_firewall from '@/components/Hosthoneypots/3_add_system_firewall'
import prohibited_service  from '@/components/Hosthoneypots/4_prohibited_service'
import reduce_system_security  from '@/components/Hosthoneypots/5_reduce_system_security'
import modify_the_registry  from '@/components/Hosthoneypots/6_modify_the_registry'
import release_PE_file  from '@/components/Hosthoneypots/7_release_PE_file'
import intrusion_process  from '@/components/Hosthoneypots/8_intrusion_process'
import self_deletion  from '@/components/Hosthoneypots/9_self_deletion'
import use_of_mutexes  from '@/components/Hosthoneypots/10_use_of_mutexes'
import camouflage_system_service  from '@/components/Hosthoneypots/11_camouflage_system_service'

Vue.use(vPage)
Vue.use(Router)
const routes = [
  {
    path: '/updatepassword',
    name: 'UpdatePassword',
    component: UpdatePassword
  },
  {
    path: '/index',
    name: 'index',
    meta: {
      requireAuth: true, // 添加该字段，表示进入这个路由是需要登录的
      suft:false
    },
    component: index,
    children: [
      {
        path: '/applyhoney',
        name: 'applyhoney',
        meta: {
          requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
        },
        component: applyhoney
      },
      {
        path: '/Checkstatus1',
        name: 'Checkstatus1',
        meta: {
          requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
        },
        component: Checkstatus1
      },
      {
        path: '/honeybuild',
        name: 'honeybuild',
        meta: {
          requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
        },
        component: honeybuild
      },
      {
        path: '/Hosthoneypot',
        name: 'Hosthoneypot',
        meta: {
          requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
        },
        component: Hosthoneypot,
        children: [
          {
            path: '/fileoperations',
            name: 'fileoperations',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: fileoperations
          },
          {
            path: '/filemap',
            name: 'filemap',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: filemap

          },
          {
            path: '/networkusage',
            name: 'networkusage',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: networkusage
          },
          {
            path: '/registryinfo',
            name: 'registryinfo',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: registryinfo
          },
          {
            path: '/registryassignment',
            name: 'registryassignment',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: registryassignment
          },
          {
            path: '/processoper',
            name: 'processoper',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: processoper
          },
          {
            path: '/operationthread',
            name: 'operatinthread',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: operationthread
          },
          {
            path: '/Hungthread',
            name: 'Hungthread',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: Hungthread
          },
          {
            path: '/replythread',
            name: 'replythread',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: replythread
          },
          {
            path: '/moduleoperation',
            name: 'moduleoperation',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: moduleoperation
          },
          {
            path: '/test',
            name: 'test',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: test
          },
          {
            path: '/1_start_self_release',
            name: '1_start_self_release',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: start_self_release
          },
          {
            path: '/2_registration_service_dynamic_library',
            name: '2_registration_service_dynamic_library',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: registration_service_dynamic_library
          },
          {
            path: '/3_add_system_firewall',
            name: '3_add_system_firewall',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: add_system_firewall
          },
          {
            path: '/4_prohibited_service',
            name: '4_prohibited_service',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: prohibited_service
          },
          {
            path: '/5_reduce_system_security',
            name: '5_reduce_system_security',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: reduce_system_security
          },
          {
            path: '/6_modify_the_registry',
            name: '6_modify_the_registry',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: modify_the_registry
          },
          {
            path: '/7_release_PE_file',
            name: '7_release_PE_file',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: release_PE_file
          },
          {
            path: '/8_intrusion_process',
            name: '8_intrusion_process',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: intrusion_process
          },
          {
            path: '/9_self_deletion',
            name: '9_self_deletion',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: self_deletion
          },
          {
            path: '/10_use_of_mutexes',
            name: '10_use_of_mutexes',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: use_of_mutexes
          },
          {
            path: '/11_camouflage_system_service',
            name: '11_camouflage_system_service',
            meta: {
              requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
            },
            component: camouflage_system_service
          }
        ]
      },

      {
        path: '/honeycontrol',
        name: 'honeycontrol',
        meta: {
          requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
        },
        component: HoneyControl
      },
      {
        path: '/Operator',
        name: 'Operator',
        meta: {
          requireAuth: true // 添加该字段，表示进入这个路由是需要登录的
        },
        component: Operator
      }
    ]
  },
  {
    path: '/systemindex',
    name: 'systemindex',
    component: systemindex,
    meta: {
        requireAuth: false // 添加该字段，表示进入这个路由是需要登录的

    }
  }

]

const router = new Router({
  routes
})

router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) { // 判断该路由是否需要登录权限
    if (sessionStorage.getItem('username') !== null) { // 通过vuex state获取当前的token是否存在
      next()
    } else {
      next({
        path: '/systemindex',
        query: { redirect: to.fullPath } // 将跳转的路由path作为参数，登录成功后跳转到该路由
      })
    }
  } else {
    if (to.meta.suft !== false){
        next()
    }

  }
})
export default router
