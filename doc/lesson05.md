# Онлайн проекта  <a href="https://github.com/JavaWebinar/masterjava">Masterjava</a>.

## [Материалы занятия](https://drive.google.com/drive/u/0/folders/0B9Ye2auQ_NsFei05cGNKbEM3eG8) (скачать все патчи можно через Download папки patch)

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Разбор домашнего задания HW4

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. [Сохранение в базу в batch-моде с обработкой конфликтов](https://drive.google.com/file/d/0B9Ye2auQ_NsFZEJwR2ZqMEdVRG8)

#### 5_1_HW4_export_chunk.patch
> Добавил `required` в `upload.html`

```
mvn clean -pl web\upload -am package
cd web/upload
mvn org.codehaus.cargo:cargo-maven2-plugin:run
```
[URL to Upload](http://localhost:8080/upload)

**ВНИМАНИЕ! перед накаткой патча создайте каталог `web\webapp\src`**
#### 5_2_HW4_webapp_users.patch

#### 5_3_HW4_already_present.patch
## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. [Вставка в несколько потоков](https://drive.google.com/file/d/0B9Ye2auQ_NsFek5PYTdQbjBlUU0)
#### 5_4_HW4_parallel.patch
**Внимание! в postgres 10 с sequence могут быть проблемы**
> Правка для postgres 10: `h.execute("SELECT setval('user_seq', " + (id + step - 1) + ")")`

> Fix: в `UserProcessor.process` нельзя делать `85:  chunk.clean()`, тк этот список асинхронно используется для вставки.

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. [Рефакторинг](https://drive.google.com/open?id=1IYCUi8bPbP0FTp_Nylzh8Ssbu-rXahVX)
#### 5_5_HW4_parallel2.patch

----------------
## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 4. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFZ3VZMlFITkk0LXM">Конфигурирование приложения</a>
**ВНИМАНИЕ! перед накаткой патча создейте в `common` каталог `\src` , иначе патч промахивается (от корня `common\src`).**
#### 5_6_typesafe_config.patch
> Перенес `compile/runtime` транзитивные зависимости из `parent` в `common`. Таким образом мы можен наследоваться от `parent` и не тянуть при этом все общие jar библиотеки

**ВНИМАНИЕ!! Не забудте положить `persist.conf` в `/apps/masterjava/config` (или убрать `required` из `persist\src\main\resources\persist.conf`)**

- <a href="http://springtips.blogspot.ru/">Переопределение занчений в конфигурации в Spring</a>. 
- <a href="http://docs.spring.io/spring-boot/docs/current/reference/html/howto-properties-and-configuration.html#howto-change-configuration-depending-on-the-environment">Встроенные профили Spring Boot</a>
- <a href="http://commons.apache.org/proper/commons-configuration/index.html">Apache commons-configuration2</a>
- <a href="https://github.com/typesafehub/config">Typesafe config library </a>, user in <a href="https://www.playframework.com/documentation/2.5.x/ConfigFile">Playframework</a>
 - <a href="https://github.com/typesafehub/config/blob/master/HOCON.md">HOCON Syntax</a>: Include, required(), Substitutions 

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 5. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFc3p3QTVwYktBWUk">Lombok</a>
#### 5_7_lombok.patch
- Подключаем <a href="https://habrahabr.ru/post/142356/">Lombok</a>
- <a href="https://urvanov.ru/2015/09/22/project-lombok/">Фичи Lombok</a>
- [Ten More Ways to Reduce Boilerplate with Lombok](https://www.sitepoint.com/beyond-pojos-ten-ways-reduce-boilerplate-lombok/)
- <a href="https://github.com/mplushnikov/lombok-intellij-plugin">Подключение к IDEA</a>
- <a href="http://stackoverflow.com/questions/3852091/is-it-safe-to-use-project-lombok">Drawbacks</a>, <a href="http://stackoverflow.com/a/29771875/548473">Call super constructor</a>
- <a href="https://www.sitepoint.com/declutter-pojos-with-lombok-tutorial/">Declutter Your POJOs with Lombok</a>

## Домашнее задание
- добавить в DB и сделать DAO для городов, групп и проектов (города и группы как - foreign keys)
- добавить тесты на DAO
- добавить в модуле `upload` импорт и сохранение в базу городов (импорт групп и проектов будут в следующем ДЗ)
  - загружаем `payload.xml`
  - предполагается, что пользователей будет много, а городов, групп, проектов- на порядки меньше.
  - если город уже есть в базе, просто пропускаем (не считаем ошибкой)

#### Optional
- добавить при импорте пользователей связи на города
  - если город юзера отсутствует в базе - ошибка импорта
