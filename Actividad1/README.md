# Sistema de Gestión de Biblioteca en Java

## 1. Justificación Teórica del Diseño

El sistema de gestión de biblioteca fue diseñado utilizando **principios de programación orientada a objetos** y **buenas prácticas de ingeniería de software**, con el objetivo de lograr **modularidad**, **extensibilidad** y **mantenibilidad**.

Se utilizó una arquitectura basada en capas, con clases bien definidas que separan responsabilidades como el almacenamiento de datos (`BookRepository`), la lógica de negocio (`LoanManager`) y la definición de entidades (`Book`, `EBook`).

Además, el diseño promueve el uso de **interfaces**, **colecciones genéricas** (`ArrayList`, `Book[]`) y manejo robusto de errores mediante excepciones personalizadas.

---

## 2. Aplicación Explícita de los Principios SOLID

| Principio | Aplicación |
|----------|------------|
| **SRP** (Single Responsibility Principle) | Cada clase tiene una única responsabilidad: `Book` representa datos, `LoanManager` gestiona préstamos, y los repositorios almacenan libros. |
| **OCP** (Open/Closed Principle) | Se implementó la interfaz `BookFilter`, permitiendo agregar nuevos filtros sin modificar el código existente. |
| **LSP** (Liskov Substitution Principle) | Se creó la subclase `EBook` que extiende `Book`, y puede usarse donde se espera un objeto `Book` sin alterar el comportamiento del sistema. |
| **ISP** (Interface Segregation Principle) | Las interfaces se dividen de forma específica: `BookRepository` no incluye operaciones de préstamo, y `LoanManager` está separada. |
| **DIP** (Dependency Inversion Principle) | `LoanManager` y `LibraryReportGenerator` dependen de la **interfaz** `BookRepository`, no de sus implementaciones concretas. |

---

## 3. Ejemplos de Estructuras de Datos y Control de Errores

### Estructuras de Datos

```java
// Uso de ArrayList en ArrayListBookRepository
private ArrayList<Book> books = new ArrayList<>();

// Uso de arreglo fijo en ArrayBookRepository
private Book[] books = new Book[MAX_BOOKS];
```

```plaintext
+---------------------+
|      <<interface>>  |
|    BookRepository   |
+---------------------+
| +addBook(b)         |
| +removeBook(ISBN)   |
| +findBookByISBN()   |
| +listAllBooks()     |
+---------------------+
           /\
           ||
+---------------------------+    +-----------------------------+
|  ArrayListBookRepository  |    |     ArrayBookRepository     |
+---------------------------+    +-----------------------------+
| -books: ArrayList<Book>   |    | -books: Book[]               |
| +addBook()                |    | +addBook()                   |
| +...                      |    | +...                         |
+---------------------------+    +-----------------------------+

+-------------+            +-----------------+
|    Book     |<---------- |    EBook        |
+-------------+            +-----------------+
| ISBN        |            | downloadLink    |
| title       |            +-----------------+
| author      |
| year        |
| isAvailable |
+-------------+

+---------------------+
|   <<interface>>     |
|    LoanManager      |
+---------------------+
| +loanBook()         |
| +returnBook()       |
| +isBookLoaned()     |
+---------------------+
           /\
           ||
+------------------------+
|  SimpleLoanManager     |
+------------------------+
| -repository: BookRepo  |
| +loanBook()            |
| +...                   |
+------------------------+
```
