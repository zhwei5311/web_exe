CentOS安装MySQL5.7(rpm安装版)

ps:rpm的mysql包安装起来较为简单，解压版需要做许多配置，容易出错，对于水平不是很高的人不建议轻易尝试！

下载：https://dev.mysql.com/downloads/mysql/5.7.html#downloads ，选择“Red Hat Enterprise Linux/Oracle Linux"和”Red Hat Enterprise Linux 7/Oracle Linux 7" ，然后点击选择“RPM Bundle"后的”Download"按钮进行下载；

<img src="C:\Users\zhwei\AppData\Roaming\Typora\typora-user-images\image-20200611165626448.png" alt="image-20200611165626448" style="zoom:50%;" />

下载后的安装包名字为“mysql-5.7.30-1.el7.x86_64.rpm-bundle.tar”，将下载后的文件借助WinSCP等工具将其传输至服务器中，本次安装存放的目录为“/usr/local/src/mysql”下；

通过命令“cd /usr/local/src/mysql”进入mysql安装包的目录下

![image-20200611171520882](C:\Users\zhwei\AppData\Roaming\Typora\typora-user-images\image-20200611171520882.png)

安装依赖

查看环境是否已经安装了mysql，有的话就卸载，一般CentOS7默认安装了mariadb，需要把它卸载掉

- 查看：[root@localhost mysql]# rpm -qa|grep mariadb
- 卸载：[root@localhost mysql]# rpm -e --nodeps mariadb-libs-5.5.56-2.el7.x86_64

安装MySQL5.7所需要的依赖，在安装依赖时如果遇到询问是否下载之类的提示信息，一律输入y回车即可；

[root@localhost mysql]# yum install libaio

[root@localhost mysql]# yum install perl

[root@localhost mysql]# yum install net-tools

安装MySQL5.7

解压安装包：[root@localhost mysql]# tar -xvf mysql-5.7.30-1.el7.x86_64.rpm-bundle.tar

![image-20200611172623120](C:\Users\zhwei\AppData\Roaming\Typora\typora-user-images\image-20200611172623120.png)

解压后会有很多rpm文件，我们需要安装4个rpm文件

[root@localhost mysql]# rpm -ivh mysql-community-common-5.7.30-1.el7.x86_64.rpm

[root@localhost mysql]# rpm -ivh mysql-community-libs-5.7.30-1.el7.x86_64.rpm 

[root@localhost mysql]# rpm -ivh mysql-community-client-5.7.30-1.el7.x86_64.rpm 

[root@localhost mysql]# rpm -ivh mysql-community-server-5.7.30-1.el7.x86_64.rpm 

查看MySQL的启动状态，如果没有(inactive)则手动启动

查看MySQL的启动状态：[root@localhost mysql]# service mysqld status

<img src="C:\Users\zhwei\AppData\Roaming\Typora\typora-user-images\image-20200611182043165.png" alt="image-20200611182043165" style="zoom: 80%;" />

启动MySQL（active）：[root@localhost mysql]# service mysqld start

<img src="C:\Users\zhwei\AppData\Roaming\Typora\typora-user-images\image-20200611182630449.png" alt="image-20200611182630449" style="zoom:80%;" />

修改密码

查看临时密码：[root@localhost mysql]# grep password /var/log/mysqld.log

<img src="C:\Users\zhwei\AppData\Roaming\Typora\typora-user-images\image-20200611182822651.png" alt="image-20200611182822651" style="zoom:80%;" />

用临时密码登录MySQL：[root@localhost mysql]# mysql -uroot -p

修改成新的密码：mysql> set password = password("******（密码）");

如果遇到报错：Your password does not satisfy the current policy requirements.则需要修改密码等级；

​	a) 查看MySQL初始的密码策略：mysql> SHOW VARIABLES LIKE 'validate_password%';

<img src="C:\Users\zhwei\AppData\Roaming\Typora\typora-user-images\image-20200611183740314.png" alt="image-20200611183740314" style="zoom: 80%;" />

​	b)  我这里将密码长度设置为6位：mysql> set global validate_password_length=6;

​	c)  修改密码强度：mysql> set global validate_password_policy=0;

​	重新执行一下修改密码的命令：mysql> set password = password("******（密码）");

 开启远程连接的权限：mysql> GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY '123456（密码）' WITH GRANT OPTION;

mysql> flush privileges;

配置MySQL的配置文件my.cnf：[root@localhost mysql]# vi /etc/my.cnf

在文件的末尾添加如下几行

lower_case_table_names=1    #配置表名不区分大小写 1：不区分大小写 0：区分大小写  这行必须配置 默认表名是区分大小写的，不利于开发
character-set-server=utf8     #设置为默认编码为utf8
init_connect='SET NAMES utf8'
max_connections=1024     #设置最大连接数

<img src="C:\Users\zhwei\AppData\Roaming\Typora\typora-user-images\image-20200611185406000.png" alt="image-20200611185406000" style="zoom:80%;" />

按esc，输入:wq退出文本编辑器；

重启MySQL以使配置生效：[root@localhost mysql]# service mysqld restart

关闭防火墙：[root@localhost mysql]# systemctl stop firewalld

至此，完成CentOS7环境下安装MySQL；







