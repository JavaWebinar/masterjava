# Многомодульный maven. Многопоточность. XML. Веб сервисы. Удаленное взаимодействие

![image](https://cloud.githubusercontent.com/assets/13649199/23876457/ab01ff0a-084e-11e7-964f-49c90579fac9.png)

- **приложение импорта** из XML (JAXB, StAX, XPath, XSLT)
- **многопоточного почтового веб-сервиса** (JavaMail, java.util.concurrent, JAX-WS, MTOM, хендлеры авторизации, логирования и статистики) 
- **веб приложения отправки почты с вложениями**
  - по SOAP (JAX-WS, MTOM)
  - по JAX-RS (Jersey)
  - по JMS ([ActiveMQ](http://activemq.apache.org/))
  - через [AKKA](http://akka.io/)
  - используя асинхронные сервлеты 3.0
- сохранение данных в PostgreSQL используя [jDBI](http://jdbi.org/)
- миграция базы [LiquiBase](http://www.liquibase.org/)
- использование в проекте [Guava](https://github.com/google/guava/wiki), [Thymleaf](http://www.thymeleaf.org/), [Lombook](https://projectlombok.org/), [StreamEx](https://github.com/amaembo/streamex), 
[Typesafe Config](https://github.com/typesafehub/config), [Java Microbenchmark JMH](http://openjdk.java.net/projects/code-tools/jmh)

## 17.10: [Занятие 1: Многопоточность](https://github.com/JavaOPs/masterjava) 
- Вступление. Многопоточность и параллельность
- Структура памяти Java. Ленивая инициализация
- Реализация многопоточности в Java
- Реализация многопоточной отправки писем. Execution Framework

## 24.10: Занятие 2
- Разбор ДЗ (многопоточная реализация умножения матриц)
- [Java Microbenchmark JMH](http://openjdk.java.net/projects/code-tools/jmh/) (от Алексея Шипилева)
- Формат XML. Создание схемы XSD.
- Работа с XML в Java
  - JAXB, JAXP
  - StAX
  - XPath
  - XSLT

## 31.10: Занятие 3
- Разбор ДЗ (работа с XML)
- [Обзор Guava](https://drive.google.com/open?id=0B9Ye2auQ_NsFeFB5a29JQ2tRNHM)
- Монады. flatMap
- SOA и Микросервисы
- Многомодульный Maven проект

## 07.11: Занятие 4
- Разбор ДЗ (реализация структуры проекта, загрузка и разбор xml)
- Thymleaf
- Maven. Поиск и разрешение конфликтов зависимостей
- Подключаем логирование с общими настройкам
- Библиотеки и фреймворки для работы с JDBC.
- Модуль persist

## 14.11: Занятие 5
- Разбор ДЗ 
  - Сохранение в базу в batch-моде с обработкой конфликтов
  - Вставка в несколько потоков
- Конфигурирование приложения (<a href="https://github.com/typesafehub/config">Typesafe config</a>)
- Lombook

## 21.11: Занятие 6
- Разбор ДЗ (доработка модели и модуля export)
- Миграция DB
- Веб-сервисы (REST/SOAP)
  - Java реализации SOAP
  - Имплементируем Mail Service
  
## 28.11: Занятие 7
- Разбор ДЗ 
  - реализация MailSender
  - сохранение результатов отправки в DB
  - импорт Проектов и Групп 
- Стили WSDL. Кастомизация WSDL
- Публикация кастомизированного WSDL. Автогенерация.
- Деплой в Tomcat
- Создание клиента почтового сервиса
- Реализация массовой и групповой отправки почты. HW7

## 05.12: Занятие 8
- Разбор ДЗ
   - Делаем общий mailService.wsdl
   - Обновление WSDL
   - Отправка почты из модуля webapp
- Доступ к переменным maven в приложении
- SOAP Exception. Выделение общей части схемы
- Коррекция схемы

## 12.12: Занятие 9
- Добавление мавен плагинов (copy-rename-maven-plugin, maven-antrun-plugin, liquibase-maven-plugin)
- Разбор ДЗ
  - Реализация вложений в веб-сервисе
  - Подключение MTOM
  - Реализация загрузки вложений в модуле webapp
  - Реализация вложений в почте
- JAX-WS Message Context. Авторизация
- JAX-WS Handlers (логирование SOAP)
- Домашнее задание. Статистика

## 19.12: Занятие 10
- Разбор ДЗ
  - Реализация SOAP handlers
  - Конфигурирование сервисов
- JavaEE
- JAX-RS. Интеграция с Jersey
- JMS. Интеграция с [ActiveMQ](http://activemq.apache.org/)
 
## 26.12: Занятие 11
- Авторизация в контейнере Tomcat
- Отправка почты с вложениями
  - по JAX-RS
  - по JMS
- Рефакторинг. Эксепшены в лямбдах Java 8
- Concurrent and distributed applications toolkit AKKA
- Отсылка почты через AKKA Actors (Typed и Untyped Actors)
- Асинхронные сервлеты 3.0
- Домашнее задание
  - Разбор решения с асинхронными сервлетами
- [Выбор языка программирования](https://drive.google.com/open?id=0B9Ye2auQ_NsFZUVNakNxeUtGeFE)