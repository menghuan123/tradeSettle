## 云mall脚手架项目TSF轻量版


### 什么是轻量版

相比普通版本，轻量版移除了所有demo，仅保留了最基本的项目结构。方便搭建新服务



### 项目结构说明

| 包名 | 用途 |
|-----|-----|
| restapi | rest api 包，包含controller，提供restful服务 |
| domain | 域模块，包含域的相关类文件 |
| interface | 接口模块，包含dubbo服务所暴露的接口 |
| repository | repository,持久化相关，如mybatis的mapper等 |
| service | interface的具体实现 |
| starter | 启动器，项目启动入口，一般放置配置等文件 |

### 项目依赖关系

```
starter -> 
  rest ->
    service ->
      interface
      domain ->
        repo
```
 
> 不建议对依赖关系进行调整，有不满足需求的情况请提交issue或反馈给levikang


### 生成自定义项目

```shell
./start_lite.sh
# 根据提示生成
```


- 说明
```
1.修改app.properties的app.id和app.name  
2.修改application.properties的applicationName
```


### 如何启动
1、 首先下载 [consul](https://www.consul.io/downloads.html)
```shell
# 参考 https://cloud.tencent.com/document/product/649/16618
# 本地启动consul
./consul agent -dev
```

2、 IDEA中增加启动配置
```shell
-Dtsf_consul_ip=127.0.0.1 -Dtsf_consul_port=8500 -Dtsf.swagger.enabled=false -Dspring.profile.active=local
```

3、 启动服务

> 与普通版不同的是，轻量版不再需要复杂的配置，即可启动。
> 如果需要普通版的内部集成的组件，请参考普通版的设置（注意，部分组件需要调整pom，删掉注释）


### maven setting.xml 参考
```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" 
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">

    <localRepository>/data/rmall/repository/</localRepository>

    <pluginGroups/>
    <!-- 公司内部代理 -->
    <!-- <proxies>
      <proxy>
        <id>optional</id>
        <active>true</active>
        <protocol>http</protocol>
        <host>127.0.0.1</host>
        <port>12639</port>
        <username></username>
        <password></password>
        <nonProxyHosts>maven.data.oa.com|maven.oa.com</nonProxyHosts>
      </proxy>
      <proxy>
        <id>optional1</id>
        <active>true</active>
        <protocol>https</protocol>
        <host>127.0.0.1</host>
        <port>12639</port>
        <username></username>
        <password></password>
        <nonProxyHosts>maven.data.oa.com|maven.oa.com</nonProxyHosts>
      </proxy>
  </proxies> -->
    <!-- maven 仓库用户认证信息 -->
    <servers>
        <server>
            <id>releases</id>
            <username>tcloud</username>
            <password>Tcloud!2019fff</password>
        </server>
        <server>
            <id>snapshots</id>
            <username>tcloud</username>
            <password>Tcloud!2019fff</password>
        </server>
        <server>
            <id>thirdparty</id>
            <username>tcloud</username>
            <password>Tcloud!2019fff</password>
        </server>
        <server>
            <id>nexus</id>
            <username>tcloud</username>
            <password>Tcloud!2019fff</password>
        </server>
        <server>
            <id>mirrors-tencent-central</id>
            <username>levikang</username>
            <password>b4aa9f78338c11ea8f586c92bf3acd2c</password>
        </server>
        <server>
            <id>com-tencent-smartretail</id>
            <username>levikang</username>
            <password>b4aa9f78338c11ea8f586c92bf3acd2c</password>
        </server>
        <server>
            <id>mirrors-tencent-central-pub</id>
            <username>g_rmalldeploy</username>
            <password>22fb5eac538d11eaa8e96c92bf47000d</password>
        </server>
    </servers>
    <!-- maven 仓库本地镜像配置 -->
    <mirrors>
        <!-- <mirror>
      <id>nexus</id>
      <mirrorOf>*</mirrorOf>
      <name>nexus local repo.</name>
      <url>http://182.254.217.143:8081/nexus/content/groups/public/</url>
    </mirror> -->
    </mirrors>


    <!-- 公司 maven 仓库服务器地址配置 -->
    <profiles>
        <profile>
            <id>rmall_nexus</id>
            <repositories>
                <repository>
                    <id>nexus</id>
                    <name>nexus</name>
                    <url>http://maven.rmall.qq.com/repository/maven-public/</url>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                </repository>
            </repositories>

            <pluginRepositories>
                <pluginRepository>
                    <id>nexus</id>
                    <name>nexus</name>
                    <url>http://maven.rmall.qq.com/repository/maven-public/</url>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                </pluginRepository>
            </pluginRepositories>
        </profile>
        <profile>
            <id>qcloud-repo</id>
            <repositories>
                <repository>
                    <id>qcloud-central</id>
                    <name>qcloud mirror central</name>
                    <url>http://mirrors.cloud.tencent.com/nexus/repository/maven-public/</url>
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                </repository>
            </repositories>
            <pluginRepositories>
                <pluginRepository>
                    <id>qcloud-plugin-central</id>
                    <url>http://mirrors.cloud.tencent.com/nexus/repository/maven-public/</url>
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                </pluginRepository>
            </pluginRepositories>
        </profile>

        <profile>
            <id>mirrors-tencent</id>
            <repositories>
                <repository>
                    <id>mirrors-tencent-central</id>
                    <name>mirrors tencent central</name>
                    <url>https://mirrors.tencent.com/repository/maven/RMALL</url>
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                </repository>
            </repositories>
            <pluginRepositories>
                <pluginRepository>
                    <id>mirrors-tencent-plugin-central</id>
                    <url>https://mirrors.tencent.com/repository/maven/RMALL</url>
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                </pluginRepository>
            </pluginRepositories>
        </profile>

        <profile>
            <id>unidal</id>
            <repositories>
                <repository>
                    <id>unidal</id>
                    <name>unidal</name>
                    <url>http://unidal.org/nexus/content/repositories/releases/</url>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                </repository>
            </repositories>
        </profile>
        <profile>
            <id>qcloud-tsf</id>
            <repositories>
                <repository>
                    <id>qcloud-tsf</id>
                    <name>qcloud mirror central</name>
                    <url>https://mirrors.tencent.com/repository/maven/tsf</url>
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                </repository>
            </repositories>
        </profile>

        <profile>
            <id>jdk-1.8</id>
            <activation>
                <activeByDefault>true</activeByDefault>
                <jdk>1.8</jdk>
            </activation>
            <properties>
                <maven.compiler.source>1.8</maven.compiler.source>
                <maven.compiler.target>1.8</maven.compiler.target>
                <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
                <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
            </properties>
        </profile>
    </profiles>
    <activeProfiles>
        <!-- <activeProfile>mirrors-tencent</activeProfile> -->
        <activeProfile>rmall_nexus</activeProfile>
        <activeProfile>qcloud-repo</activeProfile>
        <activeProfile>unidal</activeProfile>
        <activeProfile>qcloud-tsf</activeProfile>
    </activeProfiles>

</settings>


```
