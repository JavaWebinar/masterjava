# Онлайн проекта  <a href="https://github.com/JavaWebinar/masterjava">Masterjava</a>.

## [Материалы занятия](https://drive.google.com/drive/u/0/folders/0B9Ye2auQ_NsFeUFhRGRETk80MkE) 

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Разбор домашнего задания HW7

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFU1FSVmw2S05sR1U">Делаем общий `mailService.wsdl`</a>
> Напомню, что общие wsdl ресурсы хранятся в `${masterjava.config}/wsdl`

#### Apply 1_HW7_wsdl_share.patch
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFelpFalNxQVBTc3c">Доступ к переменным maven в приложении</a>
#### Apply 2_app_conf.patch
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. [Обновление WSDL](https://drive.google.com/file/d/0B9Ye2auQ_NsFWDFRYm5uNlJlNmM)
#### Apply 3_HW7_update_wsdl.patch
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 4. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFWHdabmhJV2FUYzQ">Отправка почты из модуля `webapp`</a>
#### Apply 4_HW7_webapp.patch

----
##  ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 5. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFZDdwM2ZoX0RsZEU">SOAP Exception. Выделение общей части схемы</a>
**ВНИМАНИЕ! перед накаткой патча создейте в `services` каталог `\common-ws` (от корня `services\common-ws`)**
#### Apply 5_soap_exceptions.patch
- <a href="http://blog.idrsolutions.com/2013/10/web-services-exception-handling/">Передача по SOAP Exception</a>

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 6. [Коррекция схемы](https://drive.google.com/file/d/0B9Ye2auQ_NsFZ1FmODdWcmlKdUk)  
#### Apply 6_fix_wsdl_and_schema.patch

--------------
##  ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 7. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFczZjQVkyNkNLd00">Домашнее задание</a>
Сделать отправку почты из модуля web c вложениями:
- <a href="https://docs.oracle.com/cd/E14571_01/web.1111/e13734/mtom.htm">Binary Data Transmission Using MTOM/XOP</a> 
- <a href="http://www.soapui.org/SOAP-and-WSDL/adding-headers-and-attachments.html">Тестирование вложений через SoapUi.</a>
- <a href="https://commons.apache.org/proper/commons-email/userguide.html">Sending emails with attachments</a>
  
### Optional
- Добавить <a href="https://habrahabr.ru/post/310738/">Git revision</a> в `version.html` 
