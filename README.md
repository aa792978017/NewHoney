# NewHoney
最新的蜜罐仓库，里面包括前端和后端的项目
honey-font  为前端项目文件
honey-back  为后端项目文件

前端项目打开方式：
1.在github把项目文件下载到本地
2.使用发开工具Visual Studio Code或者其他ide打开项目，以honey-font里面的my-project为跟目录打开项目
3.然后按照前端文档使用vue命令添加依赖然后运行即可
4.安装好依赖以后会发现存在样式问题，使用我们从github项目文件里面的index.css文件复制，
	然后替换在honey-font\my-project\node_modules\element-ui\lib\theme-chalk目录下的index.css即可

后端项目打开方式：
1.根据后端文档配置开发环境
2.使用idea开发工具打开项目，以honey-back下的Honeypot为根目录打开项目即可
3.第一次打开会maven会根据pom文件自动下载依赖的jar包，等待下载完成即可运行项目