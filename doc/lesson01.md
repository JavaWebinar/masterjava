# Первое занятие: многопоточность.

- **Не стоит стремится прочитать все ссылки урока, их можно использовать как справочник. Гораздо важнее пройти основной материал урока и сделать Домашнее Задание**
- **Обязательно посмотри <a href="https://github.com/JavaOPs/topjava/wiki/Git#%D0%9F%D1%80%D0%B0%D0%B2%D0%B8%D0%BB%D0%B0-%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D1%8B-%D1%81-%D0%BF%D0%B0%D1%82%D1%87%D0%B0%D0%BC%D0%B8-%D0%BD%D0%B0-%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B5">правила работы с патчами на проекте</a>**
- **Делать Apply Patch лучше по одному, непосредственно перед видео на эту тему, а при просмотре видео сразу отслеживать все изменения кода проекта по изменению в патче (`Version Control->Local Changes-> Ctrl+D`)**
- **Код проекта обновляется и не всегда совпадает с видео (можно увидеть как развивался проект). Изменения в проекте указываю после соответствующего патча.** 

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. <a href="https://www.youtube.com/watch?v=whONxvrM2Fc">Вступление. Многопоточность и параллельность.</a>
![Concurrent vs Parallel](https://joearms.github.io/images/con_and_par.jpg)

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. <a href="https://www.youtube.com/watch?v=qpV0KRadPj8">Структура памяти Java. Ленивая инициализация.</a>
> В видео в `LazySingleton` ошибка: должно быть как в коде проекта `instance == null`

### Структура памяти: куча, стек, permanent/metaspace
  - <a href="https://www.slideshare.net/solit/jvm-16948708">JVM изнутри - оптимизация и профилирование</a>.
  - <a href="http://stackoverflow.com/questions/79923/what-and-where-are-the-stack-and-heap#24171266">Stack and Heap</a>
  - Дополнительно:
    - <a href="http://habrahabr.ru/post/117274/">Из каких частей состоит память java процесса</a>.
    - <a href="http://www.javaspecialist.ru/2011/04/permanent.html">Permanent область памяти</a>
    - <a href="http://www.javaspecialist.ru/2011/04/java-thread-stack.html">Java thread stack </a>
    - <a href="http://habrahabr.ru/post/134102/">Размер Java объектов</a>

### Ленивая инициализация
- <a href="https://habrahabr.ru/post/27108/">Реализация Singleton в JAVA</a>
- <a href="https://ru.wikipedia.org/wiki/Double_checked_locking">Double checked locking</a>
- <a href="https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom">Initialization-on-demand holder idiom</a>
- <a href="https://tproger.ru/translations/singleton-pitfalls/">Подводные камни Singleton</a>

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. <a href="https://www.youtube.com/watch?v=8bFF-5r_Kig">Реализация многопоточности в Java</a>
- <a href="https://ru.wikipedia.org/wiki/Параллелизм_в_Java">Параллелизм в Java</a>
- <a href="https://ru.wikipedia.org/wiki/Монитор_(синхронизация)">Монитор (синхронизация)</a>
- <a href="https://en.wikipedia.org/wiki/Compare-and-swap">Compare-and-swap</a>
- <a href="http://www.javaspecialist.ru/2011/06/java-memory-model.html">Java Memory Model</a>
- <a href="http://www.skipy.ru/technics/synchronization.html">Синхронизация потоков</a>
- <a href="https://habrahabr.ru/company/luxoft/blog/157273">Обзор java.util.concurrent.*</a>
- <a href="https://habrahabr.ru/post/132884/">Как работает ConcurrentHashMap</a>
- <a href="https://habrahabr.ru/post/277669/"> Справочник по синхронизаторам java.util.concurrent.*</a>
- <a href="http://articles.javatalks.ru/articles/17">Использование ThreadLocal переменных</a>
- <a href="https://www.youtube.com/watch?v=8piqauDj2yo">Николай Алименков — Прикладная многопоточность</a>
- <a href="http://stackoverflow.com/questions/20163056/in-java-can-thread-switching-happen-in-the-synchronized-block">Can thread switching happen in the synchronized block?</a>

#### Tproger: Многопоточное программирование в Java 8
- <a href="https://tproger.ru/translations/java8-concurrency-tutorial-1/">1. Параллельное выполнение кода с помощью потоков</a>
- <a href="https://tproger.ru/translations/java8-concurrency-tutorial-2/">2. Синхронизация доступа к изменяемым объектам</a>
- <a href="https://tproger.ru/translations/java8-concurrency-tutorial-3/">3. Атомарные переменные и конкурентные таблицы</a>

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 4. <a href="https://www.youtube.com/watch?v=AEhIh2qd-FM">Реализация многопоточной отправки писем. Execution Framework</a>
> правка к видео: `22:   completionService.submit(..)`

### ![](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png)  Все изменения в проекте будут делаться на основе патчей
#### Скачайте [1_1_MailService.patch](https://drive.google.com/open?id=0B9Ye2auQ_NsFTE5ZV3pzWElxTWM), положите его в проект, правой мышкой на нем сделайте Apply Patch ...

----------------------------

### Ресурсы (основы)
- Intuit, <a href="http://www.intuit.ru/studies/courses/16/16/lecture/27127">Потоки выполнения. Синхронизация</a>
- Алексей Владыкин, <a href="https://www.youtube.com/watch?v=zxZ0BXlTys0&list=PLlb7e2G7aSpRSBWi5jbGjIe-v_CjRO_Ug">Основы многопоточность в Java</a>
- Виталий Чибриков, <a href="https://www.youtube.com/watch?v=dLDhB6SRXzw&list=PLrCZzMib1e9qkzxEuU_huxtSAxrW1t9NZ">Java. Многопоточность</a>
- Computer Science Center, курс <a href="https://compscicenter.ru/courses/hp-course/2016-spring">Параллельное программирование</a>
- Юрий Ткач, курс <a href="https://www.youtube.com/playlist?list=PL6jg6AGdCNaXo06LjCBmRao-qJdf38oKp">Advanced Java - Concurrency</a>
- Головач, курс <a href="https://www.youtube.com/playlist?list=PLoij6udfBncgVRq487Me6yQa1kqtxobZS">Java Multithreading</a>

---
## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Задание первого занятия

Вычекать этот проект:
```git clone  https://github.com/JavaOPs/masterjava.git```

- Применить <a href="https://habrahabr.ru/post/114797/">оптимизацию</a> к MatrixUtil.singleThreadMultiply
- Реализовать метод `MatrixUtil.concurrentMultiply`, позволяющий многопоточно <a href="https://ru.wikipedia.org/wiki/Умножение_матриц">перемножать квадратные матрицы N*N</a>.
- Количество дочерних потоков ограничено `MainMatrix.THREAD_NUMBER`.
- Добиться того, чтобы на матрице 1000*1000 многопоточная реализация была быстрее однопоточной

-----
## ![error](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png) Подсказки по HW1
- не делайте 1000 000 тасок, лучше их сделать крупнее
- у меня разница между 4 и 1000 тасками по времени незаметна, поэтому делайте просто и не делайте сложно
- наконец: можно не считать значение элемента результирующей матрицы C за раз, а накапливать (`concurrentMultiply3`). Мои результаты:
```
Benchmark                             (matrixSize)  Mode  Cnt    Score    Error  Units
MatrixBenchmark.singleThreadMultiplyOpt       1000    ss  100  837,867 ± 25,530  ms/op
MatrixBenchmark.concurrentMultiply2           1000    ss  100  394,294 ± 21,657  ms/op
MatrixBenchmark.concurrentMultiply3           1000    ss  100  186,827 ± 11,882  ms/op
```