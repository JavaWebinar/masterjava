# Онлайн проекта  <a href="https://github.com/JavaWebinar/masterjava">Masterjava</a>.

## [Материалы занятия](https://drive.google.com/drive/u/0/folders/0B9Ye2auQ_NsFd1FnME50bEt6RDA) 

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Разбор домашнего задания HW10
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. [Отправка вложений по JAX-RS](https://drive.google.com/open?id=0B9Ye2auQ_NsFT3VmNXR2djRqM1E)
#### Apply 11_1_HW10_jersey_attach.patch
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. [Отправка почты с вложениями по JMS](https://drive.google.com/open?id=0B9Ye2auQ_NsFdEZhVll2UFdCY0U)
#### Apply 11_2_HW10_JMS_attach.patch

- [Недостатки ObjectMessage (или недостатки сериализации Java)]( http://jmesnil.net/weblog/2012/07/27/on-jms-objectmessage-and-its-pitfalls)

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. [Рефакторинг. Эксепшены в Java 8 лямбда](https://drive.google.com/open?id=0B9Ye2auQ_NsFQUE4SzFQS2VDZ2M)
> Отправку по JMS листа аттачей

#### Apply 11_3_HW10_JMS_attach_fix.patch
#### Apply 11_4_refactoring.patch
- [Pair (tuple) in Java](http://stackoverflow.com/questions/521171/a-java-collection-of-value-pairs-tuples) 
- [Java 8 Lambda with exception](http://stackoverflow.com/questions/18198176/java-8-lambda-function-that-throws-exception)
- [What's Wrong in Java 8](https://dzone.com/articles/whats-wrong-java-8-part-iv)
- [Durian](https://github.com/diffplug/durian) ( [Дуриан](https://ru.wikipedia.org/wiki/Дуриан) )

> #### Дополнительно:
> #### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png)  [Николай Алименков - Нужен ли нам JMS в мире современных Java-технологий?](http://bekeriya.com/watch?v=RVwXdCfzJZA)

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 4. [Concurrent and distributed applications toolkit AKKA](https://drive.google.com/open?id=0B9Ye2auQ_NsFR0tjc28tRzVHQVk)
> #### Внимание! Перед накаткой патчеа создайте в `services` каталог `akka-remote` (`services/akka-remote`) иначе файлы придется руками сюда перетаскивать.
> После патча скопируйте `akka.conf` в `${masterjava.config} (/apps/masterjava/config)` 
 
#### Apply 11_5_akka.patch
- [Wiki Akka (toolkit)](https://en.wikipedia.org/wiki/Akka_(toolkit))
- [Модель акторов](https://ru.wikipedia.org/wiki/Модель_акторов)
- [Видео: Akka и его использование в Яндексе](http://2014.jpoint.ru/talks/07/)
   - [Remoting](http://doc.akka.io/docs/akka/current/scala/remoting.html)
   - [Remoting Sample](http://doc.akka.io/docs/akka/current/java/remoting.html#Remoting_Sample)
   - [Tutorials](http://akka.io/downloads/)
   - [Get started with Lightbend technologies](https://developer.lightbend.com/start)
   - [Typesafe Changes Name to Lightbend](https://www.lightbend.com/blog/typesafe-changes-name-to-lightbend)

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 5. [Отсылка почты через AKKA Actors](https://drive.google.com/file/d/0B9Ye2auQ_NsFQWppSmxRYnVKX3M)
#### Apply 11_6_akka_typed.patch
> **При задержке выполнения актора более чем на 5 сек. будет вываливаться `AskTimeoutException: Timed out`. В `AkkaActivator` сделал Timeout 20 сек.**

   - [Typed Actors](http://doc.akka.io/docs/akka/current/java/typed-actors.html)
     - [Spring Asynchronous Methods](https://spring.io/guides/gs/async-method)
     - [Spring Async support](https://spring.io/blog/2012/05/07/spring-mvc-3-2-preview-introducing-servlet-3-async-support)
     - [Asynchronous with JAX-RS](http://allegro.tech/2014/10/async-rest.html)
   - [Currying vs Partial application](https://stackoverflow.com/a/218055/548473)
   - [Serialization](http://doc.akka.io/docs/akka/current/scala/serialization.html)


#### Apply 11_7_akka_untyped.patch
> Переименовал `AkkaActorSendServlet` в `AkkaUntypedSendServlet`
   - [Actors](http://doc.akka.io/docs/akka/current/java/actors.html)

##  ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 6. [Асинхронные сервлеты 3.0](https://drive.google.com/open?id=0B9Ye2auQ_NsFV2I2TndUT0kzT2s)
- [Tomcat 7 Async Processing](http://stackoverflow.com/questions/7287244/tomcat-7-async-processing)
- [Async in Servlet 3.0 vs NIO in Servlet 3.1](http://stackoverflow.com/questions/39802643/java-async-in-servlet-3-0-vs-nio-in-servlet-3-1)
- [AsyncContext.start in Servlet 3.0](https://stackoverflow.com/questions/10073392/whats-the-purpose-of-asynccontext-start-in-servlet-3-0)
- [The Limited Usefulness of AsyncContext.start()](https://dzone.com/articles/limited-usefulness)

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 7. [Выбор языка программирования](https://drive.google.com/file/d/0B9Ye2auQ_NsFZUVNakNxeUtGeFE)
- [Scala dependency injection (di)](http://jonasboner.com/real-world-scala-dependency-injection-di)
- [Когда появится следующий большой язык программирования](https://habrahabr.ru/company/wrike/blog/323550)
- [Как я нашел лучший в мире язык программирования](https://habrahabr.ru/post/260149/)
- [Котлин рулит](https://habrahabr.ru/company/JetBrains/blog/329028/)
   - [Почему следует полностью переходить на Kotlin](https://habrahabr.ru/company/mailru/blog/329294)
   - [Stepik: Бесплатный Stepik курс Kotlin](https://stepik.org/course/Kotlin-2852)
   - [Devcolibri: Базовый курс по Kotlin](https://www.youtube.com/playlist?list=PLIU76b8Cjem4ZOt3tlWykUX1AjL9zE19t)

## Домашнее задание
-  Сделать асинхронное ожидание и **вывод результатов отправки почты** пользователю в сервлетах:
   - `AkkaTypedSendServlet` с выполнением в Tomcat `ThreadPoolExecutor`
   - `AkkaActorSendServlet` с выполнением в собственном `ExecutorService`

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 8. [Разбор решения с асинхронными сервлетами](https://drive.google.com/open?id=0B9Ye2auQ_NsFTWk1VS1GV1ROY0U)
#### Apply 11_8_async_servlet.patch

-----------

### ![error](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png) Коррекция:
#### Apply 11_9_fix.patch
- `UserDao.insertWitId` поправил на `UserDao.insertWithId`
- `UserTestData.FIST5_USERS` поправил на `FIRST5_USERS`
