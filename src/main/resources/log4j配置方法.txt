log4j.rootLogger=日志级别，appender1, appender2, ….
	日志级别：ALL<DEBUG<INFO<WARN<ERROR<FATAL<OFF，不区分大小写
	注意，rootLogger默认是对整个工程生效
	注意，如果只想对某些包操作，那么：log4j.logger.com.lvmama=info, stdout，表示该日志对package com.lvmama生效
	注意，这样做可以区分dev/线上，也可以减小性能影响：if(log.isDebugEnabled()){log.debug();}

log4j.appender.appender1=org.apache.log4j.日志输出到哪儿
	ConsoleAppender（控制台）
	FileAppender（文件）
	DailyRollingFileAppender（每天(或者每分，每月)产生一个日志文件）
	RollingFileAppender（文件大小到达指定尺寸时产生一个新的文件）
	WriteAppender（将日志信息以流格式发送到任意指定的地方）
	JDBCAppender（将日志信息保存到数据库中）

log4j.appender.appender1.File=文件目录及文件
log4j.appender.appender1.MaxFileSize=最大文件大小
log4j.appender.appender1.MaxBackupIndex=备份文件个数

log4j.appender.ServerDailyRollingFile.DatePattern=日志后缀格式
	'.'yyyy-MM,对应monthly(每月)
	'.'yyyy-ww,对应weekly(每周)
	'.'yyyy-MM-dd,对应daily(每天)
	'.'yyyy-MM-dd-a,对应half-daily(每半天)
	'.'yyyy-MM-dd-HH,对应hourly(每小时)
	'.'yyyy-MM-dd-HH-mm,对应minutely(每分钟)
	DatePattern中不用处理的文字要放到单引号(')中，如上面的(.)。如果您对此有疑问可以查阅SimpleDateFormat的文档。	
	DailyRollingFileAppender中使用这个类来处理DatePattern。DatePattern格式化之后的文本作为文件名字的后缀。
	DailyRollingFileAppender不支持格式化之后的文本作为文件名字的前缀。
	DailyRollingFileAppender在每一个日志事件(LoggingEvent)附加(append)之前检查是否需要附加。
	也就是说如果在一个滚动区间中没有任何日志记录，那么这个区间的日志记录文件就不会形成。

log4j.appender.appender1.layout=org.apache.log4j.日志布局格式
	HTMLLayout（以HTML表格形式布局）
	SimpleLayout（包含日志信息的级别和信息字符串）
	TTCCLayout（包含日志产生的时间，执行绪，类别等信息）
	PatternLayout（可以灵活的指定布局格式，常用）


 log4j.appender.appender1.layout.ConversionPattern=日志输出格式
	%c 输出日志信息所属的类的全名
	%d 输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，比如：%d{yyy-M-dd HH:mm:ss }，输出类似：2002-10-18- 22：10：28
	%f 输出日志信息所属的类的类名
	%L 输出日志事件的发生位置，即输出日志信息的语句处于它所在的类的第几行。 例如 20
	%l 输出日志事件的发生位置，即输出日志信息的语句处于它所在的类的第几行。 例如 Test.java:20
	%m 输出代码中指定的信息，如log(message)中的message
	%n 输出一个回车换行符，Windows平台为“rn”，Unix平台为“n”
	%p 输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL。如果是调用debug()输出的，则为DEBUG，依此类推
	%r 输出自应用启动到输出该日志信息所耗费的毫秒数
	%t 输出产生该日志事件的线程名
	%x：输出和当前线程相关联的NDC(嵌套诊断环境)，尤其用到像java servlets这样的多客户多线程的应用中。

log4j.appender.ServerDailyRollingFile.Append=true
	true表示将输出的内容附加在原来的文件，而不是覆盖原来的文件。


因为日志级别分别有error,warn,info,debug,fatal5种，有些是5个字母的，有些是4个字母的，如果直接写%p就会对不齐，%-5p的意思是日志级别输出左对齐，右边以空格填充，%5p的意思是日志级别输出右对齐，左边以空格填充
c：指定输出category的名称，最小的长度是20，如果category的名称长度小于20的话，默认的情况下右对齐。
%-20c："-"号表示左对齐。
%.30c：指定输出category的名称，最大的长度是30，如果category的名称长度大于30的话，就会将左边多出的字符截掉，但小于30的话也不会补空格。




















