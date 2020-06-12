CentOS7安装redis

下载：http://download.redis.io/redis-stable.tar.gz

解压：tar -zxvf redis-stable.tar.gz，我把文件放置在/usr/local/src/redis目录下；

安装

​	进入redis解压文件目录：[root@localhost redis]# cd redis-stable/

​	[root@localhost redis-stable]# make

​	[root@localhost redis-stable]# cd src

​	[root@localhost src]# make install PREFIX=/usr/local/src/redis

​	[root@localhost src]# cd ..

​	[root@localhost redis-stable]# mkdir /usr/local/src/redis/etc

​	[root@localhost redis]# cd redis-stable

​	[root@localhost redis-stable]# mv redis.conf /usr/local/src/redis/etc

​	[root@localhost redis]# cd etc

​	配置redis为后台启动：[root@localhost etc]# vim redis.conf //将daemonize no 改成daemonize yes

<img src="C:\Users\zhwei\AppData\Roaming\Typora\typora-user-images\image-20200612133612360.png" alt="image-20200612133612360" style="zoom:80%;" />

将redis加入到开机启动：修改根目录下rc.local文件：[root@localhost etc]# vim /etc/rc.local

在rc.local文件中添加内容：/usr/local/src/redis/bin/redis-server /usr/local/src/redis/etc/redis.conf（意思就是开机调用这段开启redis的命令）

启动redis：[root@localhost etc]# /usr/local/src/redis/bin/redis-server /usr/local/src/redis/etc/redis.conf

<img src="C:\Users\zhwei\AppData\Roaming\Typora\typora-user-images\image-20200612141143317.png" alt="image-20200612141143317" style="zoom:80%;" />

停止redis ：pkill redis  //停止redis

卸载redis:

```
rm -rf /usr/local/src/redis //删除安装目录
rm -rf /usr/bin/redis-* //删除所有redis相关命令脚本
m -rf /root/download/redis-4.0.4 //删除redis解压文件夹
```

