# Онлайн проекта  <a href="https://github.com/JavaWebinar/masterjava">Masterjava</a>.

## [Материалы занятия](https://drive.google.com/drive/u/0/folders/0B9Ye2auQ_NsFSGFQZ2I0V2pmbXM)  (скачать все патчи можно через Download папки patch)

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Разбор домашнего задания HW2
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFRFpzemZ0OHp3SUE">Scheme, j2html, JAXB</a>
#### Apply 3_1_HW2_schema.patch
- <a href="http://stackoverflow.com/questions/1631396/what-is-an-xsncname-type-and-when-should-it-be-used">xs:ID restriction</a>

#### Apply 3_2_HW2_JAXB.patch
> - убрал второй параметр xmlName (всегда `payload.xml`)  
> - в `parseByJaxb` сделал закрытие `InputStream` сразу после обработки
> - сделал методы статическими
> - вместо вложенного стрима для групп юзера сделал пересечение коллекций `Collections.disjoint`
> - результат JAXB также вывожу в HTML (в ДЗ только в Optional) 
> - в `j2html` вместо `setAttribute` сделал `attr` 

- <a href="https://www.youtube.com/watch?v=hxL5HejbvgE">Тагир Валеев. StreamEx + странности Stream API</a>  
- <a href="https://habrahabr.ru/post/255659/">StreamEx примеры</a> 
- <a href="http://j2html.com/">Java HTML5 builder</a>  

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFZ3JzdFpOekliVjA">Optional: StAX</a>
#### Apply 3_3_HW2_StAX.patch
> - зарефакторил в `StaxStreamProcessor` `doUntil()` и `getAttribute()` 
> - константы вставил в код 
> - вместо вложенного цикла для групп юзера сделал пересечение коллекций `Collections.disjoint` и для маскирования пустых групп `Strings.nullToEmpty`

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFbUFYY3E3Q24wRlk">StAX refactoring: startElement + JAXB</a>
#### Apply 3_4_StAX_refactoring.patch
- [Java XML API: выбираем правильно. StAX: работаем с удовольствием](https://habrahabr.ru/post/339716/)
- [StAX + JAXB](http://blog.bdoughan.com/2012/08/handle-middle-of-xml-document-with-jaxb.html)

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNEMzQTMtZGtZWEk">Optional: XSLT</a>
#### Apply 3_5_HW2_xslt.patch
> В `groups.xsl` добавил явный namespace. Теперь при создании xPath IDEA делает автодополнения

- <a href="http://stackoverflow.com/questions/1667454/xsl-transformation-in-java-with-parameters">XSL Transformation in Java with parameters</a>
- <a href="https://greenbytes.de/tech/tc/xslt/">Test Cases for XSLT support in browsers</a>  

## Затяние 3
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 4. [Обзор Guava](https://drive.google.com/open?id=0B9Ye2auQ_NsFeFB5a29JQ2tRNHM)
- [The Top 20 Most Popular Java Libraries](https://dzone.com/articles/the-top-100-java-libraries-in-2016-after-analyzing)
- [Guava Wiki](https://github.com/google/guava/wiki)
  - [Apache Commons](https://commons.apache.org/)
  - [Spring Boot cache providers](http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-caching.html#_supported_cache_providers)
- [Release 21.0: Java 8!](https://github.com/google/guava/wiki/Release21)
- [118 слайдов от Егора Чернышева](https://www.slideshare.net/echernyshev/guava-41982734)
  

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 5. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFbGlWWkk0amM1cms">Монады. flatMap</a>
- <a href="https://habrahabr.ru/post/183150/"> Функторы, аппликативные функторы и монады в картинках</a>
- <a href="https://habrahabr.ru/company/cit/blog/262055/">Монады в Java 8</a>
  - <a href="https://www.coursera.org/specializations/scala">Куср Сoursera по функциональному программированию</a>
- <a href="http://stackoverflow.com/a/19932439/548473">Three Monad laws.</a>
- <a href="https://dzone.com/articles/whats-wrong-java-8-part-iv">What's Wrong in Java 8 Monads</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 6. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFM3FrSUEzeVBrbk0">SOA и Микросервисы</a>
 - <a href="http://ru.wikipedia.org/wiki/Сервис-ориентированная_архитектура">Сервис-ориентированная архитектура</a> как повышение абстракции производства ПО
 - <a href="http://www.javaworld.com/article/2071889/soa/what-is-service-oriented-architecture.html">What is service-oriented architecture?</a>
 - <a href="https://ru.wikipedia.org/wiki/Микросервисы">Современное представление (SOA): Микросервисы</a>
 - <a href="http://habrahabr.ru/post/249183/">Микросервисы (Microservices)</a> 
 - <a href="https://habrahabr.ru/company/jugru/blog/272009/">Доклад Кирилла Толкачёва и Александра Тарасова про микросервисы</a>
   - <a href="https://www.youtube.com/watch?v=ULppXf2ZWRM">Минск: Микросервисы - Огонь, Вода и Медные трубы</a>
   - <a href="http://www.slideshare.net/kirilltolkachev7/java-day-minsk-2016-keynote-about-microservices-in-real-world?qid=6f50c48c-f17f-4431-b977-df4a8575d65f">Слайды</a>
 - <a href="http://cqrs.nu/">CQRS</a>  
    - <a href="https://habrahabr.ru/post/178259/">Event Sourcing</a>, 
    - <a href="https://habrahabr.ru/post/146429/">CQRS + Event Sourcing</a>, 
    - <a href="https://github.com/cer/event-sourcing-examples">Event-Sourcing+CQRS example application</a>
 - Интеграция через несколько ДБ. 
    - <a href="https://www.youtube.com/watch?v=15Xvq6xBcGI">Гибридные решения для эффективного хранения данных</a>.
    - <a href="http://evtuhovich.ru/blog/2012/02/12/pgbouncer/">PgBouncer</a>
 - <a href="https://spring.io/blog/2015/07/14/microservices-with-spring">Microservices with Spring</a>, <a href="https://habrahabr.ru/post/280786/">Микросервисная архитектура, Spring Cloud и Docker</a>
    - <a href="https://github.com/paulc4/microservices-demo">Microservices demo</a>
    - <a href="http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html">Spring Cloud Netflix</a>
    - <a href="https://ru.wikipedia.org/wiki/Netflix">Netflix</a>
    - Service Discovery: Eureka
    - Circuit Breaker: Hystrix
    - Load Balancer: Ribbon
    - Declarative REST Client: Feign
    - External Configuration: Archaius
    - Gateway, Router and Filter: Zuul
    - Metrics: Spectator, Servo, and Atlas
    - RxJava with Spring MVC
      - <a href="http://reactivex.io/intro.html">ReactiveX</a>
      - <a href="https://github.com/ReactiveX/RxJava">RxJava: Reactive Extensions for the JVM</a>
   - Справичник
      - <a href="https://spring.io/search?q=microservice">microservice in spring.io</a>
      - <a href="http://plainoldobjects.com/2014/04/01/building-microservices-with-spring-boot-part1/">Building microservices with Spring Boot – part 1</a>
      - <a href="http://plainoldobjects.com/2014/05/05/building-microservices-with-spring-boot-part-2/">Building microservices with Spring Boot – part 2</a>
      - <a href="http://plainoldobjects.com/2014/11/16/deploying-spring-boot-based-microservices-with-docker/">Deploying Spring Boot-based microservices with Docker – part 3</a>
      - <a href="https://github.com/livelessons-spring/building-microservices">Developing Microservices With Spring Boot</a>
      - <a href="http://www.youtube.com/watch?v=VPtlZLdm7Nc&list=PLgGXSWYM2FpNmY5a1MuomSvvovSWHWoAR">Webinar: Building "Bootiful" Microservices with Spring Boot</a>
      - <a href="https://blog.heroku.com/archives/2015/3/3/managing_your_microservices_on_heroku_with_netflix_s_eureka">Managing your Microservices on Heroku with Netflix's Eureka</a> 
 - Платформы
     - <a href="https://cdelmas.github.io/2015/11/01/A-comparison-of-Microservices-Frameworks.html">A comparison of Microservices Frameworks</a>
     - <a href="https://www.lightbend.com/lagom">Lagom</a>, <a href="https://playframework.com/">Play Framework</a>
     - <a href="http://zeroturnaround.com/rebellabs/java-tools-and-technologies-landscape-2016/">Микросервисе в обзоре Zeroturnaround</a>
     - <a href="https://dzone.com/articles/new-in-spring-5-functional-web-framework">Spring 5: Functional Web Framework</a>
     - <a href="http://www.ofbizian.com/2014/09/camel-microservices.html">Apache Camel for Micro­service Architectures</a>
     
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 7. <a href="https://drive.google.com/file/d/0B9Ye2auQ_NsFelJqQ0d5WllaR0k">Многомодульный Maven проект</a>
#### Apply 3_5_multimodule.patch
- <a href="https://github.com/JavaWebinar/topjava08/blob/doc/doc/lesson01.md#-4-maven">Maven на topjava</a>. Snapshot. <a href="http://maven.apache.org/guides/mini/guide-multiple-modules.html">The Reactor</a>.
- <a href="http://stackoverflow.com/questions/17482320/maven-module-inheritance-vs-aggregation">Maven module inheritance vs aggregation</a>
- Расширение кругозора:
  - <a href="https://www.youtube.com/watch?v=21qdRgFsTy0">Антон Архипов, Евгений Борисов, Барух Садогурский — Maven vs Gradle vs SBT</a>

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Домашнее задание HW3
- Сделать структуру проекта согласно схеме. В модулях c `packaging=pom` кода нет, корневое `src` перенести в другие модули. 
  - `Matrix + Benchmark` перенести в модуль `test`.
  - Схемы XML/XSD в модуль `upload`

**Внимание: название модуля `export` в видео и картинке идеологически неверно. В коде и патчах переименовал в `upload`.**

WAR модули:
-  **`mail-service`** - модуль отсылки почты. Транспорт: JAX-WS, JAX-RS, JMX, AKKA
-  **`upload`** - модуль загрузки payload.xml. Заргузка и многопоточночная вставка в DB
-  **`webapp`** - веб-интерфейс для отсылки почты пользователям из DB. Клиент модуля `mail-service`

![image](https://cloud.githubusercontent.com/assets/13649199/23876457/ab01ff0a-084e-11e7-964f-49c90579fac9.png)

- Учитывая, что web модулей в проекте предполагается много, измените структуру, чтобы не дублировать  `maven-war-plugin` (и другие общие зависимости war модулей).
- Проверьте, что проект собирается!

#### Optional
- Реализовать простую форму заргузки файла `payload.xml` в модуле `upload` (через StAX) и отобразить загруженных пользователей (имя/email/flag) 
  - для отображения взять любой шаблон  (JSP, [Thymeleaf](http://www.concretepage.com/thymeleaf/java-thymeleaf-example-getting-started-with-thymeleaf), ...)
  - загрузку сделать через любую реализацию (Servlet 3.х предпочтительнее):
    - <a href="https://commons.apache.org/proper/commons-fileupload/">Commons FileUpload</a>
    - <a href="https://tomcat.apache.org/tomcat-8.0-doc/api/org/apache/tomcat/util/http/fileupload/package-summary.html">Tomcat fileupload copied and package renamed</a>
    - <a href="http://docs.oracle.com/javaee/6/tutorial/doc/glraq.html">Java EE 6 Tutorial: fileupload example</a>
    - <a href="https://gist.github.com/keesun/1604411">Servlet 3.0's FileUpload Sample</a>
- Сделать загрузку через StAX+JAXB многопоточно. Сейчас `JaxbParser` реализован с `synchronize`, что означает что он потокобезопасен (может работать с несколькими запросами), но последовательно, в одном потоке. Нужен рефакторинг.
  - [Thread safe of JAXBContext, Marshaller, Unmarshalleris](https://stackoverflow.com/a/37926057/548473)

## Замечания:
- 1: имя артифакта `artifactId` как и пакеты называть только в lowercase. Обычно используют "-" как разделитель слов. Имя каталога модуля лучше делать тоже самое: [Project Directories Should Match the Artifact ID](http://blog.sonatype.com/2011/01/maven-tip-project-directories-and-artifact-ids/)
- 2: следите, чтобы пути в шаблонах были не от рута "/". Каждое приложение деплоится в свой Application Context.
- 3: чтобы не дублировать `maven-war-plugin` сделать `paren-web`. Он наследуется от `parent`, а от него наследуются все war модули.
