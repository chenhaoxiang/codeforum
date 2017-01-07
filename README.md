这是我们数据库的一个课程设计，时间不多，老师只留给我们5天的时间做。

数据库为MySQL。

先说下功能吧：
注意：本项目没有用框架！
实现了登录注册。用户查看帖子。
用户积分政策。帖子按阅读量排名。
用户发表帖子。用户评论帖子。

用到的技术有：
AJAX、jQuery、ant、分页技术、拦截器、底层实现动态注解拦截、实现数据库事务处理、使用org.apache.commons.beanutils.BeanUtils封装Bean、ThreadLocal处理线程、重写QueryRunner抓取异常、在dao层就不必再抓取异常、还有一些时间，密码的工具类、、、

因为时间有限，只写了这些功能，如有兴趣，完全可以在这个基础上开发出一个小型论坛。
积分的那个，本来是想写一个权限管理的，奈何时间不让。
而且现在Spring实现权限管理比较简单，也就没写了。
其他你想要的功能你自己都可以加哦。

本项目比较简单，就不做过多介绍啦，有兴趣的可以拿去，所有源码都在，sql语句在项目根目录下。

数据库只有3个表：
![](http://img.blog.csdn.net/20170107204746740?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


未登录时的首页：
![](http://img.blog.csdn.net/20170107204824788?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

登录页面：

![](http://img.blog.csdn.net/20170107204857210?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

登录后的首页：

![](http://img.blog.csdn.net/20170107204927290?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

帖子页面：
![](http://img.blog.csdn.net/20170107205110930?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

发表帖子页面：
![](http://img.blog.csdn.net/20170107205142446?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

注册页面：
![](http://img.blog.csdn.net/20170107205206603?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY1MjUyMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)


好像页面也就这些啦，本人不是做UI哒，页面不好看请见谅哦。
时间也比较紧，也就没去网上找模板了。
相信这个项目应付学校的课程设计是完全够了的。