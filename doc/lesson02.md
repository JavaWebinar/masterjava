# Онлайн проекта  <a href="https://github.com/JavaWebinar/masterjava">Masterjava</a>.
- **Не стоит стремится прочитать все ссылки урока, их можно впоследствии использовать как справочник. Гораздо важнее сделать Домашнее Задание**
- **Обязательно посмотри <a href="https://github.com/JavaOPs/topjava/wiki/Git#%D0%9F%D1%80%D0%B0%D0%B2%D0%B8%D0%BB%D0%B0-%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D1%8B-%D1%81-%D0%BF%D0%B0%D1%82%D1%87%D0%B0%D0%BC%D0%B8-%D0%BD%D0%B0-%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B5">правила работы с патчами на проекте</a> (совпадают с проектом Topjava)**
- **Делать Apply Patch лучше по одному, непосредственно перед видео на эту тему, а при просмотре видео сразу отслеживать все изменения кода проекта по изменению в патче**
- **Код проекта обновляется и не всегда совпадает с видео (можно увидеть как развивался проект). Изменения в проекте указываю после соответствующего патча.** 
- <a href="https://www.youtube.com/watch?v=eq3KiAH4IBI&ab_channel=IntelliJIDEA">42 IntelliJ IDEA Tips and Tricks</a>

## <a href="https://drive.google.com/drive/u/0/folders/0B9Ye2auQ_NsFSnRmQ3dQRm9hSWM">Материалы занятия</a> (скачать все патчи можно через Download папки patch)
![image](https://cloud.githubusercontent.com/assets/13649199/18330295/5f2ca214-7560-11e6-8e1e-c0494f798c37.png)

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1.1 <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFRWpKUUlYYjhuVGs">Вступление. Разбор домашнего задания HW1</a>
#### 2_1_HW1_singleThreadMultiplyOpt.patch
#### 2_2_HW1_concurrentMultiply.patch
- <a href="https://habrahabr.ru/post/283290/">Сравнение EE и Spring в комментариях</a>
- <a href="http://stackoverflow.com/questions/1132507/java-array-thread-safety">Java array thread-safety</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1.2 [Еще одна реализация умножения, parallel() и ForkJoinPool](https://drive.google.com/file/d/0B9Ye2auQ_NsFT0FYaUdaenVMT1k)
#### 2_3_HW1_concurrentMultiply2.patch
> `Callable / executor.invokeAll` в `concurrentMultiply2` поменял на `Runnable / CountDownLatch`

- [Fork/Join Framework в Java 7](https://habrahabr.ru/post/128985/)
- [Java Parallel Streams Are Bad for Your Health](https://zeroturnaround.com/rebellabs/java-parallel-streams-are-bad-for-your-health/)
- [Custom thread pool in Java 8 parallel stream](https://stackoverflow.com/a/21172732/548473)

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFZExZS0cwYUhIUkE">Java Microbenchmark JMH (от Алексея Шипилева)</a>
#### 2_4_JMH_Benchmark.patch
#### 2_5_JMH_main_jar.patch

> Сделал forks=10 для большой точности измерений и убрал лишние измерения 
 
- <a href="http://tutorials.jenkov.com/java-performance/jmh.html">JMH - Java Microbenchmark Harness</a>, <a href="http://java-performance.info/jmh/">Java Performance Tuning Guide</a>
- <a href="https://github.com/artyushov/idea-jmh-plugin">idea-jmh-plugin</a>, <a href="http://stackoverflow.com/questions/37720692/exception-while-trying-to-acquire-a-jmh-lock/#39562747">Exception while trying to acquire a JMH lock</a>
- <a href="http://stackoverflow.com/a/1172371/548473">Maven latest dependency version</a>

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFazM3V3FwQ3pLYkU">Формат XML. Создание схемы XSD.</a>
#### 2_6_xml_scheme.patch
- <a href="http://genberm.narod.ru/xml/lections/xml/introduction.html">История создания</a>. <a href="http://www.duct-tape-architect.ru/?p=315">XML формат и технологии</a>, <a href="https://ru.wikipedia.org/wiki/XML">XML</a>
- <a href="http://stackoverflow.com/questions/33746/xml-attribute-vs-xml-element#33757">Attribute vs Element</a>. 
- <a href="http://genberm.narod.ru/xml/schema/schema0/2.7.html">sequence/ choice/ all/ group</a>. <a href="https://docstore.mik.ua/orelly/xml/schema/ch09_01.htm">Define referring to Another XML Element</a>
- <a href="http://genberm.narod.ru/xml/lections.html">Лекции по XML</a>

## Работа с XML в Java

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 4. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFM0hGNnVCMHN5YTg">JAXB, JAXP</a>
#### 2_7_JAXB.patch
> - Добавил в `maven-surefire-plugin` UTF-8
> - Убрал лишний `synchronized`  в `JaxbParser.marshal()` (уже есть в `JaxbMarshaller.marshal()`)
> - Сделал загрузку ресурсов <a href="https://google.github.io/guava/releases/snapshot/api/docs/com/google/common/io/Resources.html#getResource(java.lang.String)">используя context class loader</a>
>   - <a href="http://stackoverflow.com/questions/676250/different-ways-of-loading-a-file-as-an-inputstream#676273">Different ways of loading a file as an InputStream</a>

- <a href="http://www.vogella.com/tutorials/JavaXML/article.html">Работа с XML в Java</a>.
- <a href="https://ru.wikipedia.org/wiki/Document_Object_Model">DOM</a>, <a href="https://ru.wikipedia.org/wiki/SAX">SAX</a>
- <a href="http://www.ibm.com/developerworks/ru/library/x-jaxp/">JAXP: вспомогательный слой над SAX и DOM API</a>
- <a href="https://ru.wikipedia.org/wiki/Java_Architecture_for_XML_Binding">JAXB</a>, <a href="https://ru.wikipedia.org/wiki/JAXP">JAXP</a>, <a href="https://ru.wikipedia.org/wiki/Xerces">Xerces</a>, <a href="https://ru.wikipedia.org/wiki/Xalan">Xalan</a>
- <a href="https://www.ibm.com/developerworks/ru/library/x-javaxmlvalidapi/">Валидации XML</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 5. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFWnpzN3l4cGc3aFE">StAX</a>
#### 2_8_StAX.patch
- [Java XML API: выбираем правильно. StAX: работаем с удовольствием](https://habrahabr.ru/post/339716/)
- <a href="https://en.wikipedia.org/wiki/StAX">StAX</a>: <a href="https://www.ibm.com/developerworks/ru/library/x-stax1/">XMLStreamReader</a>, <a href="https://www.ibm.com/developerworks/ru/library/x-stax2/">XMLEventReader</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 6. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFanFseGRaRUV6TXc">XPath</a>
#### 2_9_XPath.patch
- XPath: <a href="http://www.ibm.com/developerworks/ru/library/x-javaxpathapi/">Java XPath API</a>
- <a href="https://msdn.microsoft.com/ru-ru/library/ms256086">Примеры XPath</a> 

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 7. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFbkVNWGliQUJtVlk">XSLT</a>
#### 2_10_Xslt.patch
- <a href="http://www.ibm.com/developerworks/ru/library/x-jaxp2">Преобразование XSLT</a>, <a href="http://stackoverflow.com/questions/3360017/why-does-xslt-output-all-text-by-default">Default XSLT output</a>
- <a href="https://ru.wikipedia.org/wiki/XSLT">XSLT</a>, <a href="https://ru.wikipedia.org/wiki/XSL">XSL</a>
  - <a href="https://www.w3.org/TR/xslt#built-in-rule">XSL Transformations (XSLT)</a>
- Дополнительно
  - [What kind of language is XSLT?](https://www.ibm.com/developerworks/xml/library/x-xslt)
  - [Saxon: Anatomy of an XSLT processor](http://www.ibm.com/developerworks/library/x-xslt2/)
  
## Домашнее задание
- 1: Изменить XML схему: 
  - 1.1 добавить проекты. Имеют название (например `topjava, masterjava`) и описание
  - 1.2 добавить группы. Они имеют название и тип (`REGISTERING/CURRENT/FINISHED`) и принадлежат проекту. Например проект `topjava`, группы `topjava01`,`topjava02`, ..
  - 1.3 сделать `User.email` аттрибутом. 
  - 1.4 реализовать принадлежность участников разным группам (`Admin` состоит в группах `topjava07, topjava08, masterjava01`)
- 2: Дополнить xml тестовыми данными.
- 3: Реализовать класс `MainXml`, которые принимает параметром имя проекта в тестовом xml и выводит отсортированный список его участников (использовать JAXB).

#### Optional
- 4: Сделать реализацию `MainXml` через StAX (выводить имя/email)
- 5: Из списка участников сделать html таблицу (имя/email). Реализация- любая.
- 6: Вывести через XSLT преобразование html таблицу с группами заданного проекта
  - [XSLT param](http://stackoverflow.com/questions/1667454/xsl-transformation-in-java-with-parameters)

## Замечания:
- 1: Не используйте IDREF, где можно сделать обычную вложенность, принятую в структурах XML
- 2: Попробуйте сделать минимальное количестово XML текста на одного юзера (пользователей много, экономим)
- 3: Используйте StaxStreamProcessor! Добавляйте туда и используйте утильные методы.
- 4: Постарайтесь оптимизировать реализацию определения "находится ли пользователь в проекте". Не делать сложность (N пользователей * M групп)!
