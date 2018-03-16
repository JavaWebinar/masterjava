# Онлайн проекта  <a href="https://github.com/JavaWebinar/masterjava">Masterjava</a>.

## [Материалы занятия](https://drive.google.com/drive/u/0/folders/0B9Ye2auQ_NsFVEJBS3VzVnBtMnc)


## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Разбор домашнего задания HW5

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. [Реализация модели/DAO/JUnit](https://drive.google.com/open?id=0B9Ye2auQ_NsFZzA1OHBUNExGdEk)
#### Apply 6_1_HW5_model_sql.patch
> - Перенес sql файлы в корневую папку `sql`
> - Изменения базы оставил только в файле миграции `databaseChangeLog.sql`
> - Сделал первичный ключ PK `city.ref`. Это справочник, и важно, чтобы внешние ссылки FK на него можно было вставить без заморочек.
    У нас на одном проекте были проблемы, когда на разных окружениях справочные таблицы имели разные id. Данные нельзя было просто вставить скриптами миграции sql без подселектов или программного кода и
    была задача привести их всех к одинаковым `id`. С `ref` как PK все упростится. Хотя у кого-то может быть другой опыт:)

- Также см. отдельную тему **Миграция DB** в уроке.
- Скрип миграции `lb_apply.bat` (на sh переведите сами, если unix) можно запускать много раз. По истории смотрится, чтобы каждый ChangeSet накатился только 1 раз.
- [Liquibase](http://www.liquibase.org/)
  - [Downloads](http://www.liquibase.org/download)
  - [Run migration](http://www.liquibase.org/quickstart.html)

#### Apply 6_2_HW5_dao_test.patch
> в `CityDaoTest` и `ProjectDaoTest` также выделил `init()`

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFMGdjajREWlhmV2c">Реализация `upload` с городами</a>
> - Классы `Result/ChunkResult/GroupResult` упростил до `List<FailedEmails>`
> - Переименовал 
>   - `ProcessPayload -> PayloadProcessor`
>   - `CityExport -> CityProcessor`
>   - `UserExport -> UserProcessor`

#### Apply 6_3_HW5_add_PayloadProcessor.patch
#### Apply 6_4_HW5_NEW_add_CityProcessor.patch

----------------

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. <a href="https://drive.google.com/file/d/0B9Ye2auQ_NsFbFR5bDBzYzdYeDA">Миграция DB</a>
- <a href="http://www.liquibase.org">Liquibase</a> (<a href="http://www.dropwizard.io/0.7.1/docs/manual/migrations.html">Dropwizard Migrations</a>)
- <a href="https://flywaydb.org/">Flyway</a> (<a href="http://stackoverflow.com/questions/37385823/liquibase-vs-flyway-which-one-to-use">Liquibase vs FLyway which one to use?</a>)
- <a href="http://www.mybatis.org/migrations/">MyBatis Migrations</a>
- <a href="https://habrahabr.ru/post/314048/">Техника безопасности при работе с PostgreSQL</a>
- <a href="https://habrahabr.ru/post/231213/">История про несогласованные данные</a>
- <a href="https://docs.google.com/document/d/1ul1jH7sccyQVqpjItdFo_OQI9YxJV3V5hxqI7xa-YPM">DB Migration rules</a>

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 4. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFSkh4eWtSb2I4YUU">Веб-сервисы</a>
#### Apply 6_5_web_services.patch

- <a href="https://ru.wikipedia.org/wiki/Веб-служба">Веб-служба</a>. <a href="https://en.wikipedia.org/wiki/Web_service">Web service</a>
- Примеры SOAP:
  - <a href="http://www.cbr.ru/DailyInfoWebServ/DailyInfo.asmx">Веб-сервис Центробанка, для получения ежедневных данных.</a>
  - <a href="http://api.yandex.ru/speller/doc/dg/concepts/api-overview.xml">Яндекса проверки правописания.</a>
     - <a href="https://tech.yandex.ru/#catalog">Yandex каталог технологий</a>
  - <a href="https://www.flightstats.com/developers/bin/view/Web+Services/WSDL">Ряд веб сервисов авиастатистики, для мониторинга полетов, сведений о погоде, и.т.п.</a>
- <a href="https://en.wikipedia.org/wiki/Web_API#Resource_vs._service">Resource vs. service</a>
- <a href="https://habrahabr.ru/post/131343/">REST vs SOAP.</a>

#### <a href="https://ru.wikipedia.org/wiki/REST">REST</a>.
- <a href="http://blog.mwaysolutions.com/2014/06/05/10-best-practices-for-better-restful-api/">10 Best Practices for Better RESTful API</a>
  - <a href="https://en.wikipedia.org/wiki/Java_API_for_RESTful_Web_Services">JAX-RS</a>, <a href="https://jersey.java.net/documentation/latest/wadl.html">WADL</a>

#### <a href="https://ru.wikipedia.org/wiki/SOAP">SOAP</a>
- <a href="http://www.4stud.info/networking/web-services.html">SOAP веб-сервисы</a>. 
- <a href="https://ru.wikipedia.org/wiki/WSDL">WSDL</a>. 
- <a href="http://static.ccm2.net/ccm.net/faq/images/0-pdpEtRZG-web.png">Web Services Standards</a>. 

#### Java реализации.
- <a href="http://en.wikipedia.org/wiki/Java_API_for_XML_Web_Services">JAX-WS</a>. <a href="https://en.wikipedia.org/wiki/SOAP_with_Attachments_API_for_Java">SAAJ</a>. <a href="https://en.wikipedia.org/wiki/Java_API_for_XML-based_RPC">JAX-RPC</a>.
- <a href="http://stackoverflow.com/questions/11566609/difference-between-jax-ws-axis2-and-cxf">JAX-WS vs Axis2 vs CXF</a>. <a href="http://stackoverflow.com/questions/1243247/difference-between-apache-cxf-and-axis">CFX vs AXIS</a>. <a href="http://stackoverflow.com/questions/297033/which-framework-is-better-cxf-or-spring-ws">CXF vs Spring-WS</a>
- <a href="http://nagesh625.blogspot.ru/2013/12/axis-vs-cxf-vs-spring-webservices.html">AXIS vs CXF vs Spring WebServices</a>
- <a href="http://www.javacodebook.com/2013/08/19/web-service-framework-comparison-2013-part-ii/">Web Service Framework Comparison</a>
- <a href="http://docs.spring.io/spring-ws/sites/2.0/reference/html/why-contract-first.html">Contract-first and Contract-last styles</a>
- <a href="http://docs.spring.io/spring-ws/docs/2.2.0.RELEASE/reference/htmlsingle/#message-factories">Spring-WS Message Factories</a>

#### Имплементируем Mail Service
- [Introduction to JAX-WS](http://www.baeldung.com/jax-ws)
- <a href="http://www.mkyong.com/tutorials/jax-ws-tutorials/">JAX-WS Tutorial</a>
   - <a href="http://jax-ws.java.net">GlassFish » Metro » JAX-WS</a>
   - MailService <a href="http://localhost:8080/mail/mailService?wsdl">WSDL</a> / <a href="http://localhost:8080/mail/mailService?xsd=1">XSD</a>
- Тестирование через <a href="http://www.soapui.org/">SoapUI</a>.

----------------
## Домашнее задание
- Реализовать `MailSender` с конфигурированием параметров в `mail.conf`
   - <a href="https://commons.apache.org/proper/commons-email">Commons Email</a>
   - Параметры почты (yandex):
```
   mail.host: smtp.yandex.ru
   mail.port: 465
   mail.username: user@yandex.ru
   mail.password: password
   mail.useSSL: true
   mail.useTLS: false
   mail.debug: true
   mail.fromName: Name
```
- Сохранят результат отправки писем в DB (в `MailSender`). 
- DAO и модель для сохранения сделать в модуле `mail-service`
- Протестировать отправку почты через SoapUI и/или `MailServiceClient`

> если стоит Avast и Avast Mail Shield, для отправки требуется отключить

#### Optional
- добавить в модуле `upload` импорт и сохранение в базу групп и проектов (упрощение: только добавление без удаления/модификации)
- добавить при импорте пользователей связи на группы 
  - если пользователь уже есть в базе, поведение остается прежним: сразу ошибка импорта
  - если пользователь новый, добавляется он и его группы
  - если какая-либо группа пользователя отсутствует в базе - ошибка импорта
  
## Замечания:
  - пользователей много, а их групп еще больше. Если в чанке 2000 юзеров, не делайте 2001 запрос к базе при вставке 1го чанка.
  - не считывате конфигурацию при каждой отсылке email
  - попробуйте не дублировать инициализацию базы в `mail-service`
    - <a href="http://maven.apache.org/guides/mini/guide-attached-tests.html">Guide to using attached tests</a>

