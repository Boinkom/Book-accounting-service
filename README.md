# 📚 Book Accounting Service

## 📋 Описание
Book Accounting Service — это RESTful веб-приложение на базе Spring Boot, предназначенное для учета книг и авторов. 
Сервис позволяет добавлять, редактировать, удалять книги, искать их по ID, а также управлять списком авторов с пагинацией.

---

## ⚙️ Стек технологий
- **Java 21**
- **Spring Boot 3.4** – фреймворк для создания веб-приложения
- **Spring Web** – обработка HTTP-запросов
- **Spring Data JPA** – взаимодействие с базой данных
- **H2 Database** – встроенная реляционная база данных
- **Lombok** – генерация геттеров/сеттеров и шаблонного кода
- **Hibernate Validator** – валидация DTO
- **JUnit & Mockito** – юнит-тесты сервисного слоя

---

## 🚀 Запуск проекта

### Подготовка
1. Установите [Java 21+](https://jdk.java.net/21/)
2. Установите [Maven](https://maven.apache.org/download.cgi)

### Шаги запуска
1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/Boinkom/Book-accounting-service.git
   cd Book-accounting-service
   ```
2. Соберите и запустите проект:
   ```bash
   ./mvnw spring-boot:run
   ```

3. Перейдите в браузере:
   - Приложение: `http://localhost:8181`
   - Консоль H2: `http://localhost:8181/h2-console`

---

## 📌 Примеры API

### Книги `/books`
| Метод | URL              | Описание                    |
|-------|------------------|-----------------------------|
| GET   | `/books`         | Получить все книги          |
| GET   | `/books/{id}`    | Получить книгу по ID        |
| POST  | `/books`         | Добавить новую книгу        |
| PUT   | `/books/{id}`    | Обновить книгу              |
| DELETE| `/books/{id}`    | Удалить книгу               |

### Авторы `/authors`
| Метод | URL              | Описание                          |
|-------|------------------|-----------------------------------|
| GET   | `/authors`       | Получить авторов с пагинацией     |
| GET   | `/authors/{id}`  | Получить автора по ID             |
| POST  | `/authors`       | Добавить нового автора            |

---

## 🧪 Тесты

Проект включает юнит-тесты для `AuthorService` и `BookService`. Запуск тестов:

```bash
./mvnw test
```

---
