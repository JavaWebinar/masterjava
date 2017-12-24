# Онлайн проекта  <a href="https://github.com/JavaWebinar/masterjava">Masterjava</a>.

## [Материалы занятия](https://drive.google.com/drive/u/0/folders/0B9Ye2auQ_NsFWGU0MTRQYkFQdEk) 

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Разбор домашнего задания HW9
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. [Реализация SOAP handlers](https://drive.google.com/open?id=0B9Ye2auQ_NsFTVhpbTNCTDZ4bTA)
> - Для `SecurityHandler` в `mail-service` сделал родительский `MailHandlers`

#### Apply 10_1_HW9_handlers.patch

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. [Конфигурирование сервисов](https://drive.google.com/open?id=0B9Ye2auQ_NsFR1lybnQyRUJUUEU)
> Поправил в конфигурации [обработку null значений](https://github.com/typesafehub/config/issues/282)

#### Apply 10_2_HW9_host_config.patch

- <a href="https://github.com/typesafehub/config#how-to-handle-defaults">Handle defaults in config</a>

----------------------------

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. [JavaEE](https://drive.google.com/open?id=0B9Ye2auQ_NsFUU92ZFBEZmJjb2c)
- <a href="https://ru.wikipedia.org/wiki/Java_Platform,_Enterprise_Edition">Java Platform, Enterprise Edition</a>
- <a href="https://habrahabr.ru/post/283290/">Холивары в комментах</a>
- <a href="http://www.ibm.com/developerworks/websphere/techjournal/1301_stephen/1301_stephen.html">CDI</a>
- <a href="https://ru.wikipedia.org/wiki/Enterprise_JavaBeans">Enterprise JavaBeans</a>
- <a href="http://tomee.apache.org/comparison.html">TomEE состав</a>
- <a href="https://zeroturnaround.com/rebellabs/java-tools-and-technologies-landscape-2016/">Application Server statistics</a>

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 4. [JAX-RS](https://drive.google.com/file/d/0B9Ye2auQ_NsFeWQxTUVBSDFGMGM)
#### Apply 10_3_JAX_RS.patch
> - Обновил версию JAX-RS. См. [upgrage issue](https://github.com/jersey/jersey/issues/3664)
> - В `users.html`
>   - сделал проверку на `"Addresses are not selected"`
>   -  в `done()` объект привожу к строке (JAX-RS возвращает json)
>   -  в `fail()` сделал вывод `result.responseText`

#### Apply 10_4_jersey_logging.patch
> - [JAX-RS Test URL](http://localhost:8080/mail/rest/test)
> - [JAX-RS Detail WADL URL](http://localhost:8080/mail/rest/application.wadl?detail=true)

- <a href="https://jersey.java.net/">Jersey: RESTful Web Services in Java</a>
- <a href="https://jersey.java.net/documentation/latest/modules-and-dependencies.html">Modules and dependencies</a>
- <a href="http://howtodoinjava.com/jersey/jersey-2-hello-world-application-tutorial/">Example with web.xml</a>
- <a href="https://jersey.java.net/documentation/latest/deployment.html#deployment.servlet.3">Descriptor-less deployment</a>
  - [ServletContainerInitializer](http://stackoverflow.com/a/10784700/548473)
  - [Servlet 3.0 ServletContainerInitializer and Spring WebApplicationInitializer](http://www.java-allandsundry.com/2014/03/servlet-30-servletcontainerinitializer.html)
- <a href="http://howtodoinjava.com/jersey/jax-rs-jersey-moxy-json-example/">Jersey + MOXy JSON</a>
- <a href="https://jersey.java.net/documentation/latest/bean-validation.html#d0e11875">Validation</a>  
- <a href="https://jersey.java.net/documentation/latest/wadl.html#d0e13052">Web Application Description Language (WADL)</a>
  - <a href="http://localhost:8080/mail/rest/application.wadl">mail/rest/application.wadl</a>
  - <a href="https://wadl.java.net/">wadl2java client stub generation</a>

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 5. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFMUpGRGpSVXJLVGs">JMS</a>
> - Вынес в `parent-web` версию ActiveMQ
> - Переименовал `SendServlet` в `SoapSendServlet`

#### Apply 10_5_JMS.patch
> ![Внимание](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png) **Для того, чтобы по JNDI приложение работало с JMS сконфигурируйте Tomcat:**
> - Скопируйте
>   - `config_templates/context.xml` в `$TOMCAT_HOME/conf`
>   - `$MAVEN_REPO(~/.m2)/org/apache/activemq/activemq-all/5.15.2/activemq-all-5.15.2.jar` в `$TOMCAT_HOME/lib`

- <a href="https://ru.wikipedia.org/wiki/Java_Message_Service">Java Message Service</a>
- <a href="http://queues.io/">Queues</a>
- <a href="https://www.linkedin.com/pulse/jms-vs-amqp-eran-shaham">JMS vs AMQP</a>, <a href="https://ru.wikipedia.org/wiki/AMQP">AMQP</a>
- <a href="http://blog.net21.cz/index.php?/archives/3-ActiveMQ,-HornetQ-and-RabbitMQ-Performance-Comparison.html">ActiveMQ, HornetQ and RabbitMQ Performance Comparison</a>
- <a href="http://activemq.apache.org/tomcat.html">ActiveMQ + Tomcat</a>
- <a href="http://www.tomcatexpert.com/blog/2010/12/16/integrating-activemq-tomcat-using-local-jndi">Embedded/StandAlone ActiveMQ</a>, <a href="http://activemq.apache.org/configuring-transports.html">ActiveMQ transport</a>, <a href="http://activemq.apache.org/uri-protocols.html">URI protocols</a>
- <a href="https://martinsdeveloperworld.wordpress.com/2013/03/03/apache-activemq-and-tomcat/">Apache ActiveMQ and Tomcat sample</a>
   - [When close JMS connection/sessions](http://stackoverflow.com/questions/19772082/when-should-i-close-a-jms-connection-that-was-created-in-a-stateless-session-bea)
   - [Cache JMS connections/sessions](https://developer.jboss.org/wiki/ShouldICacheJMSConnectionsAndJMSSessions)

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 6. [Авторизация в контейнере Tomcat](https://drive.google.com/file/d/0B9Ye2auQ_NsFcU1FU3FTQ25NNzA)
#### Apply 10_6_tomcat_auth.patch

- [Realm Configuration HOW-TO](http://tomcat.apache.org/tomcat-8.0-doc/realm-howto.html)
- [Setup your own Tomcat security realm](http://www.christianschenk.org/blog/setup-your-own-tomcat-security-realm/)


## Домашнее задание
- Добавить аттачи в JAX-RS
  - [File upload example in Jersey](http://www.mkyong.com/webservices/jax-rs/file-upload-example-in-jersey) **НЕ РАБОТАЕТ!**
  - <a href="http://stackoverflow.com/questions/22837257/how-to-write-jersey-multipart-webapp-tomcat-server">Jersey Multipart on Tomcat</a> (вложения приходят, но пустые или обрезанные)
- Реализовать отсылку почты через JMS `ObjectMessage`

#### Optional
  - Починить вложения в JAX-RS (javax.mail читает поток из вложения 2 раза)
  - Сделать вложения в JMS
