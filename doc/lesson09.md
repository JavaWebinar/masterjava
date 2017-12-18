# Онлайн проекта  <a href="https://github.com/JavaWebinar/masterjava">Masterjava</a>.

## [Материалы занятия](https://drive.google.com/drive/u/0/folders/0B9Ye2auQ_NsFd3pjNWZpR0QzVWs) 

### ![error](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png) Правка

#### Apply 9_0_fix_package.patch
> - В модуле `common-ws` перенес пакет `ru.javaops.web` в `ru.javaops.masterjava.web`

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Разбор домашнего задания HW8
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. [Реализация вложений в веб-сервисе](https://drive.google.com/open?id=0B9Ye2auQ_NsFbER6Rjc4dHRGODA)
#### Apply 9_1_HW8_service_attach.patch
> Переименовал `Attach` в `Attachment`

- <a href="https://docs.oracle.com/cd/E14571_01/web.1111/e13734/mtom.htm">Binary Data Transmission Using MTOM/XOP</a> 
- <a href="http://www.soapui.org/SOAP-and-WSDL/adding-headers-and-attachments.html">Тестирование вложений через SoapUi.</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. [Подключение MTOM](https://drive.google.com/open?id=0B9Ye2auQ_NsFeF8yWVBUbHd6Y0k)
#### Apply 9_2_HW8_MTOM.patch

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. [Реализация загрузки вложений в модуле webapp](https://drive.google.com/open?id=0B9Ye2auQ_NsFaVhpMkZRV3lSUlU)
> - Реализовал загрузку вложения через jQuery `FormData()` и Servlet 3 `@MultipartConfig`

- [Sending multipart/formdata with jQuery](https://stackoverflow.com/a/5976031/548473)

#### Apply 9_3_HW8_webapp_attach.patch

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 4. [Реализация вложений в почте](https://drive.google.com/open?id=0B9Ye2auQ_NsFQ0RZNktReWRoYjQ)
#### Apply 9_4_HW8_mail_attach.patch

### [Git revision](https://habrahabr.ru/post/310738/)
#### Apply 9_5_HW8_git_revision.patch
> Не забудте обновит `/apps/masterjava/config` новыми файлами конфигурации

---------------------

##  ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 5. [JAX-WS Message Context. Авторизация](https://drive.google.com/open?id=0B9Ye2auQ_NsFSEdYZzR3OGxxLVk)
#### Apply 9_6_msg_ctx_auth.patch

- <a href="https://jax-ws.java.net/articles/MessageContext.html">Message Context in JAX-WS</a>
- <a href="http://www.mkyong.com/webservices/jax-ws/application-authentication-with-jax-ws/">Application Authentication with JAX-WS</a>
  - <a href="http://examples.javacodegeeks.com/enterprise-java/jws/container-authentication-with-jax-ws/">Container Authentication</a>

#### Асинхронный вызов через <a href="https://examples.javacodegeeks.com/enterprise-java/jws/jax-ws-annotations-example/#1_8">@OneWay </a>

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 6. [JAX-WS Handlers](https://drive.google.com/open?id=0B9Ye2auQ_NsFYjhDUGM2N0tHVDg)
#### Apply 9_7_logging_handlers.patch
> Сделал `Client/Server LoggingHandler` внутренними классами `SoapLoggingHandlers`

- <a href="https://jax-ws.java.net/articles/handlers_introduction.html">Handlers in JAX-WS</a>
  - <a href="https://www.mkyong.com/webservices/jax-ws/jax-ws-soap-handler-in-server-side/">SOAP handler sample</a>
  - <a href="http://www.javaworld.com/article/2077679/soa/get-a-handle-on-the-jax-ws-api-s-handler-framework.html">Message Context</a>  


## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 7. [Домашнее задание. Статистика](https://drive.google.com/open?id=0B9Ye2auQ_NsFWGI0ejBZZ21Cc0k)
#### Apply 9_8_prepare_HW9.patch
> После обновления `hosts.conf` в `masterjava.config (/apps/masterjava/config/)` поломается конфигурация `endpoint`, в ДЗ требуется починить

  - Сделать отдельный Handler статистики трафика веб-сервиса (в статистике только логирование)
  - Сделать авторизацию в `mailService` через `SoapServerSecurityHandler` 

#### Optional
  - Вынести уровень логирования веб-сервисов и креденшелы авторизации в конфигурацию (`host.conf`)
  - Сделать (отнаследовать) для `mail-service` свои хендлеры логирования и авторизации с настройками из конфигурации

## Замечания:
  - обновите формат `hosts.conf` в `masterjava.config (/apps/masterjava/config/)`
  - в модуле `common-ws` находятся общие классы. Не хардкодьте туда `mail` сервис
  - попробуйте вынести весь общий код в классы `common-ws`
