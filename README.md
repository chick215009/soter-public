# 项目部署

## 准备工作

* Windows11 **16G**（内存必须16G及以上） 8核
* JDK1.8
* MySQL 5.7
* Redis 6.2.4
* Maven 3.8.3
* IDEA2022.1（记得授予完全读写权限，JVM最大内存参数为8G，否则可能无法正常运行）

## 运行系统

选择<u>本地项目路径</u>（该本地路径IDEA应该有完全读写权限），输入命令 `git clone https://github.com/chenglm/soter-public`

## 后端运行

1. 使用 IntelliJ IDEA 2022.1 打开本项目

2. 修改配置文件

   1.  `Soter/soter-admin/src/main/resources/application.yml`，以下配置结合本机情况填写

      ```yml
      # 项目相关配置
      soter:
          # 所有上传的文件在该路径下
          profile: 自行填写（建议 本地项目路径/uploadPath）
          # 连接GitHub使用，申请个人GitHub token
         githubToken: 申请方式参考 https://docs.github.com/cn/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token
         # 缓存地址，从GitHub拉下来的项目暂存在此处，可以debug时查看
          tmp: 自行填写（建议 本地项目路径/tmp）
          
      # 开发环境配置
      server:
        # 服务器的HTTP端口，默认为8080
        port: 8080
        
      # Spring配置
      spring:
        # redis 配置
        redis:
          # 地址
          host: localhost
          # 端口，默认为6379
          port: 6379
          # 密码
          password:
      ```

   2. `Soter/soter-admin/src/main/resources/application-druid.yml`，MySQL数据库配置

      ```yml
      # 数据源配置
      spring:
          datasource:
              type: com.alibaba.druid.pool.DruidDataSource
              driverClassName: com.mysql.cj.jdbc.Driver
              druid:
                  # 主库数据源
                  master:
                      url: jdbc:mysql://localhost:本地MySQL端口号/soter?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
                      username: 
                      password: 
      ```

   3. `Soter/soter-admin/src/main/resources/logback.xml`，日志配置

      ```java
      <configuration>
          <!-- 日志存放路径 -->
      	<property name="log.path" value="" />
          ...
      ```

      

3. 创建数据库`soter`，运行`Soter/sql`下的sql脚本

4. 运行`Soter/soter-admin/src/main/java/cn/edu/nju/Application.java`，控制台看见banner即成功运行

## 前端运行

1. 进入本地项目路径/Soter 输入以下命令

   ```java
   # 进入项目目录
   cd soter-ui
   
   # 安装依赖
   npm install
   
   # 使用代理安装更快，代理可能不稳定，可以根据情况修改
   npm install --registry=https://registry.npmmirror.com
   
   # 本地开发 启动项目
   npm run dev
   ```

2. 打开浏览器，输入：http://localhost:80 默认账户/密码 `admin/admin123`），Web端看见登录页面则成功运行
