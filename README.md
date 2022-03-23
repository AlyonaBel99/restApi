# Spring Boot, Maven, PostgeSQL, Flyway, Rest API, JPA and Hibernate
Эта программа реализуется с помощью Spring Boot (version 2.6.4), здесь происходит миграция базы данных со скриптов SQL при помощи Hibernate и Flyway,
которые проверяют коректность таблиц SQL и моделей самой программы. Реализованы API запросы к данным сущностям при помощи нативных запросов.

## Шаги по настройке 

**1. Клонируйте приложение**

```bash
git clone https://github.com/AlyonaBel99/restApi.git
```

**2. Создайте базу данных PostgeSQL**
```bash
create database publishing_articles
```
- run `src/main/resources/blogapi.sql`

**3. Измените имя пользователя и пароль в соответствии с вашей установкой**

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` и `spring.datasource.password` в соответствии с вашей установкой

**4. Запустите приложение, используя Maven**

```bash
mvn spring-boot:run
```
Приложение начнет работать по ссылке <http://localhost:8080>

| Method | Url | Description |
| ------ | --- | ----------- |
| GET    | /articale/{id} | Выдача информации о статье по её идентификатору |
| GET    | /articale/all | Выдача списка всех статей  | 
| GET    | /articale/category/{categoryName} | Выдача списка всех статей, относящихся к указанной категории |
| GET    | /articale/author/{authorName} | Выдача списка всех статей конкретного автора |
| GET    | /articale/tag/{tagName} | Выдача списка всех статей, относящихся к указанному тегу |
| GET    | /articale/date/{date} | Выдача списка всех статей за текущий день |

## Объекты
**Статья**

+ Название
+ Краткое содержание
+ Содержание
+ Автор
+ Категория
+ Теги
+ Дата публикации

Может относиться только к одной категории.

Может относиться к нескольким тегам.

**Автор**

+ Имя
+ Фамилия

**Категория**
+ Название

**Тег**
+ Название
