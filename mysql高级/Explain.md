#### 一.Explain

Explain命令在解决数据库性能上是第一推荐使用命令，大部分的性能问题可以通过此命令来简单的解决，Explain可以用来查看SQL语句的执行效 果，可以帮助选择更好的索引和优化查询语句，写出更好的优化语句。

Explain语法：explain select … from … [where …]

例如：explain select * from news;

输出：
`+----+-------------+-------+-------+-------------------+---------+---------+-------+------| id | select_type | table | type | possible_keys | key | key_len | ref | rows | Extra |+----+-------------+-------+-------+-------------------+---------+---------+-------+------`

下面对各个属性进行了解：

1、id：这是SELECT的查询序列号

2、select_type：select_type就是select的类型，可以有以下几种：

> SIMPLE：简单SELECT(不使用UNION或子查询等)
>
> PRIMARY：最外面的SELECT
>
> UNION：UNION中的第二个或后面的SELECT语句
>
> DEPENDENT UNION：UNION中的第二个或后面的SELECT语句，取决于外面的查询
>
> UNION RESULT：UNION的结果。
>
> SUBQUERY：子查询中的第一个SELECT
>
> DEPENDENT SUBQUERY：子查询中的第一个SELECT，取决于外面的查询
>
> DERIVED：导出表的SELECT(FROM子句的子查询)

3、table：显示这一行的数据是关于哪张表的

4、type：这列最重要，显示了连接使用了哪种类别,有无使用索引，是使用Explain命令分析性能瓶颈的关键项之一。

> 结果值从好到坏依次是：
>
> system > const > eq_ref > ref > fulltext > ref_or_null > index_merge > unique_subquery > index_subquery > range > index > ALL
>
> 一般来说，得保证查询至少达到range级别，最好能达到ref，否则就可能会出现性能问题。
>
> a.ALL：Full Table Scan 全表扫描，MySQL 将遍历全表以找到匹配的行。
> b.index：Full Index Scan 全索引扫描，index 与 ALL 区别为 index 类型只遍历索引树
> c. range：索引范围扫描，对索引的扫描开始于某一点，返回匹配值域的行。显而易
> 见的索引范围扫描是带有 between 或者 where 子句里带有<, >查询。当 mysql 使用索引
> 去查找一系列值时，例如 IN()和 OR 列表，也会显示 range（范围扫描）,当然性能上面是
> 有差异的。
> d. ref_or_null：该联接类型如同 ref,但是添加了 MySQL 可以专门搜索包含 NULL 值的
> 行。
> e. index_merge：该联接类型表示使用了索引合并优化方法。
> f. unique_subquery：该类型替换了下面形式的 IN 子查询的 ref: value IN (SELECT
> primary_key FROM single_table WHERE some_expr) 。unique_subquery 是一个索引查
> 找函数,可以完全替换子查询,效率更高。
> g. index_subquery：该联接类型类似于 unique_subquery。可以替换 IN 子查询,但只
> 适 合 下 列 形 式 的 子 查 询 中 的 非 唯 一 索 引 : value IN (SELECT key_column FROM
> single_table WHERE some_expr)
> h.ref：就是连接程序无法根据键值只取得一条记录，使用索引的最左前缀或者索引不
> 是 primary key 或 unique 索引的情况。当根据键值只查询到少数几条匹配的记录时，这
> 就是一个不错的连接类型。
> i.eq_ref：类似 ref，区别就在使用的索引是唯一索引，对于每个索引键值，表中只有
> 一条记录匹配，简单来说，就是多表连接中使用 primary key 或者 unique key 作为关联
> 条件.
> j.const、system：当 MySQL 对查询某部分进行优化，并转换为一个常量时，使用这
> 些类型访问。如将主键置于 where 列表中，MySQL 就能将该查询转换为一个常量。
> 注：system 是 const 类型的特例，当查询的表只有一行的情况下，使用 system
> k.NULL：MySQL 在优化过程中分解语句，执行时甚至不用访问表或索引，例如从一
> 个索引列里选取最小值可以通过单独索引查找完成。

5、possible_keys：列指出MySQL能使用哪个索引在该表中找到行

6、key：显示MySQL实际决定使用的键（索引）。如果没有选择索引，键是NULL

7、key_len：显示MySQL决定使用的键长度。如果键是NULL，则长度为NULL。使用的索引的长度。在不损失精确性的情况下，长度越短越好

8、ref：显示使用哪个列或常数与key一起从表中选择行。

9、rows：显示MySQL认为它执行查询时必须检查的行数。

10、Extra：包含MySQL解决查询的详细信息，也是关键参考项之一。



#### 二.慢查询日志

##### 当查询超过一定的时间没有返回结果的时候，才会记录到慢查询日志中。默认不开启。

采样的时候手工开启。可以帮助我们找出执行慢的 SQL 语句
1、查看慢 SQL 日志是否启用（on 表示启用）:
show variables like 'slow_query_log';
2、查看执行慢于多少秒的 SQL 会记录到日志文件中
show variables like 'long_query_time';
3、可以使用模糊搜索，查看所有含有 query 的变量信息
show variables like '%query%';

4、是否开启慢查询日志

set global slow_query_log=1

5、指定保存路径及文件名，默认为数据文件目录，

set GLOBAL slow_query_log_file="bxg_mysql_slow.log" # 

--指定多少秒返回查询的结果为慢查询
set long_query_time=1

6、记录所有没有使用到索引的查询语句

log_queries_not_using_indexes=1

7、记录那些由于查找了多于 1000 次而引发的慢查询

min_examined_row_limit=1000

8、记录那些慢的 optimize table，analyze table 和 alter table 语句

log_slow_admin_statements=1

9、记录由 Slave 所产生的慢查询

log_slow_slave_statements=1

##### 命令行修改配置方式不需要不重启即可生效，但重启之后会自动失效。

1、set global slow_query_log=1;
2、set global slow_query_log_file='bxg_mysql_slow.log';
3、set long_query_time=1;
4、set global log_queries_not_using_indexes=1;
5、set global min_examined_row_limit=1000;
6、set global log_slow_admin_statements=1;
7、set global log_slow_slave_statements=1;

#### 三.缓存

##### 关闭缓存有两种放法，一种临时的，一种永久的。临时的直接在命令行执行

set global query_cache_size=0;
set global query_cache_type=0; --如果配置文件中为关闭缓存的话，不能通过命令开启缓存

##### 永久的修改配置文件 my.cnf ,添加下面的配置即可。

query_cache_type=0
query_cache_size=0

##### 另外，我们还可以通过 sql_no_cache 关键字在 sql 语句中直接禁用缓存，在开启缓存

##### 的情况下我们对 sql 语句做一些改动

Select sql_no_cache count(*) from pythonlearn.lianjia; -- 不缓存
Select sql_cache count(*) from pythonlearn.lianjia; -- 缓存（也可以不加，默认缓存已经开启了）

#### 四.准备测试数据

##### -- 用户表

CREATE TABLE `person` (
`id` bigint(20) unsigned NOT NULL, `fname` varchar(100) NOT NULL, `lname` varchar(100) NOT NULL, `age` tinyint(3) unsigned NOT NULL, `sex` tinyint(1) unsigned NOT NULL, PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8

##### --用户部门表

CREATE TABLE `department` (
`id` bigint(20) unsigned NOT NULL, `department` varchar(100) NOT NULL, PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8

##### -- 用户住址表

CREATE TABLE `address` (
`id` bigint(20) unsigned NOT NULL, `address` varchar(100) NOT NULL, PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8

##### -- 创建存储过程，用于批量添加测试数据

DELIMITER $$
DROP PROCEDURE IF EXISTS `generate`$$
CREATE  PROCEDURE  `generate`(IN num INT)
BEGIN
	DECLARE chars VARCHAR(100) DEFAULT 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
	

	DECLARE fname VARCHAR(10) DEFAULT '';
	DECLARE lname VARCHAR(25) DEFAULT '';
	DECLARE id INT UNSIGNED;
	DECLARE len INT;
	SET id=1;
	DELETE FROM person;
	WHILE id <= num DO
		SET len = FLOOR(1 + RAND()*10);
		SET fname = '';
		WHILE len > 0 DO
			SET fname = CONCAT(fname,SUBSTRING(chars,FLOOR(1 + RAND()*62),1));
			SET len = len - 1;
		END WHILE;
		SET len = FLOOR(1+RAND()*25);
		SET lname = '';
		WHILE len > 0 DO
			SET lname = CONCAT(lname,SUBSTR(chars,FLOOR(1 + RAND()*62),1));
			SET len = len - 1;
		END WHILE;
		INSERT INTO person VALUES (id,fname,lname, FLOOR(RAND()*100), FLOOR(RAND()*2));
		SET id = id + 1;
	END WHILE;
END $$
DELIMITER ;

##### 执行存储过程

-- 停掉事务
SET autocommit = 0; -- 调用存储过程
CALL generate(1000000);
SET autocommit = 1; -- 重启事务

#### 五.Profiling 的使用

要想优化一条 Query，就须要清楚这条 Query 的性能瓶颈到底在哪里，是消耗的 CPU
计算太多，还是需要的 IO 操作太多？要想能够清楚地了解这些信息，可以通过 Query
Profiler 功能得到。
Query Profiler 是 MYSQL 自带的一种 query 诊断分析工具，通过它可以分析出一条
SQL 语句的性能瓶颈在什么地方。通常我们是使用的 explain,以及 slow query log 都无法
做到精确分析，但是 Query Profiler 却可以定位出一条 SQL 语句执行的各种资源消耗情况，
比如 CPU，IO 等，以及该 SQL 执行所耗费的时间等。

##### 用法

（1）通过执行“set profiling”命令，可以开启关闭 QueryProfiler 功能
mysql> SET global profiling=on;（set profiling=1）
（2）查看相关变量
show VARIABLES like '%profiling%';
（3）设置保存数量默认 15 条，最大值为 100
mysql> set profiling_history_size=100;
（4）在开启 Query Profiler 功能之后，MySQL 就会自动记录所有执行的 Query 的
profile 信息，下面执行 n 条 Query 作为测试
select * from person limit 10000,100;
（3）获取当前系统中保存的多个 Query 的 profile 的概要信息
mysql> show profiles;
（4）针对单个 Query 获取详细的 profile 信息。
可以根据概要信息中的 Query_ID 来获取某个 Query 在执行过程中详细的 profile 信
息。例如查看 cpu 和 io 的详细信息
show profile cpu,block io for query 501;
show profile ALL for query 501;
ALL ：显示所有信息
|BLOCK IO ：块设备 IO 输入输出次数
|CONTEXT SWITCHES：上下文切换相关开销
|CPU：用户和系统的 CPU 使用情况
|IPC：显示发送和接收消息的相关消耗
|MEMORY：内存消耗情况（该版本 is not currently implemented）
|PAGE FAULTS：显示主要和次要页面故障相关的开销
|SOURCE：显示和 Source_function,Source_file,Source_line 相关的开销信息
|SWAPS：显示交换次数相关的开销
注意：profiling 被应用在每一个会话中，当前会话关闭后，profiling 统计的信息将丢失。

#### 六.sql 语句优化

##### 常用 sql 优化建议

1、避免 SELECT * 从数据库里读出越多的数据，那么查询就会变得越慢。并且如果你的数据库服务器和

WEB 服务器是两台独立的服务器的话，这还会增加网络传输的负载。
select * from person where lname='x8RJWmQX';
select id from person where lname='x8RJWmQX';
2、避免在 where 子句中使用!=或<>操作符
应尽量避免在 where 子句中使用!=或<>操作符，否则引擎放弃使用索引而进行全表
扫描。
EXPLAIN select * from person where fname != 'sss’ ;
3、 尽量避免全表扫描
对查询进行优化，应尽量避免全表扫描，首先应考虑在 where 及 order by 涉及的
列上建立索引。
4、用 UNION 来代替 OR
采用 OR 语句：
select * from person where fname ='LVc1oJjd' or fname='bjRdlVo';
采用 UNION 语句，返回的结果同上面的一样，但是速度要快些：
select * from person where fname ='LVc1oJjd' Union
select * from person where fname='bjRdlVo';
分别对这两个 sql 进行 explain 分析：
OR 语句的结果
UNION 语句的结果
我们来比较下重要指标，发现主要差别是 type 和 ref 这两项。type 显示的是访问
类型，是较为重要的一个指标，结果值从好到坏依次是：
system > const > eq_ref > ref > fulltext > ref_or_null > index_merge >
unique_subquery > index_subquery > range > index > ALL
UNION 语句的 type 值为 一般为 ref，OR 语句的 type 值为 range，可以看到这
是一个很明显的差距。
UNION 语句的 ref 值为 const，OR 语句的 type 值为 null，const 表示是常量值
引用，非常快。
这两项的差距就说明了 UNION 要优于 OR，从我们的直观感觉上也可以理解，虽然
这两个方式都用到了索引，但 UNION 是用一个明确的值到索引中查找，目标非常明确，
OR 需要对比两个值，目标相对要模糊一些，所以 OR 在恍惚中落后了。
5、 like 语句避免前置百分号
前置百分号会导致索引失效
select * from person where fname like '%LVc1o%' ;
下面走索引
select * from person where fname like 'LVc1o%' ;
6、 避免在 where 子句中对字段进行表达式操作
应尽量避免在 where 子句中对字段进行表达式操作，这将导致引擎放弃使用索引而
进行全表扫描。如：
select id from t where num/2=100
应改为:
select id from t where num=100*2
7、 避免在 where 子句中对字段进行函数操作
应尽量避免在 where 子句中对字段进行函数操作，这将导致引擎放弃使用索引而进行
全表扫描。如：
select id from t where substring(name,1,3)=’abc’ 
应改为:
select id from t where name like ‘abc%’
8、尽量使用数字型字段
尽量使用数字型字段，若只含数值信息的字段尽量不要设计为字符型，这会降低查询
和连接的性能，并会增加存储开销。这是因为引擎在处理查询和连接时会 逐个比较字符
串中每一个字符，而对于数字型而言只需要比较一次就够了。

9、大数据量的分页优化
使用 limit 进行分页，翻到 10000 多页后效率低。原因在于 limit offset 会逐行查找，
是先查询再跳过。
select * from person limit 999900,100; -- 慢了，大概需要 0.4 秒多
a. 从业务逻辑优化
不允许翻过 100 页，例如百度一般可以翻到 70 页左右
b. 技术优化方法一
select * from person where id>999900 limit 100;
这样就非常快，0.001s 左右，因为使用了 id 索引
但这样用有前提，id 是连续的，中间的数据不能删，否则 id 为 999900 的并不是第
999900 个记录。
c. 技术优化方法二
如果必须用 limit offset 查询，就用延迟关联
select id from person limit 999900 ,100;
这样只查询 id 列，实现了索引覆盖，就会很快
select p.* from person p inner join (select id from person limit 999900 ,100) as tmp on
p.id=tmp.id;
通过内连接再获取分页后每条记录的详细信息


