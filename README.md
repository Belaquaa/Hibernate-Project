# Проект: База данных пользователей

Этот проект представляет собой реализацию базы данных пользователей с использованием Java. Он предоставляет функциональность для управления пользователями, включая добавление, удаление, получение всех элементов, а также создание, очищение и удаление таблицы.

## Особенности

- Реализация через JDBC: Стандартная реализация с использованием JDBC (Java Database Connectivity) для взаимодействия с базой данных.
- Реализация через Hibernate: Улучшенная реализация с использованием фреймворка Hibernate для упрощения работы с базой данных и повышения производительности.
- Покрытие тестами: Проект включает в себя набор тестов для проверки корректности работы всех операций с базой данных.
- Конфигурация через HikariCP: Для управления пулом соединений с базой данных используется библиотека HikariCP, обеспечивающая высокую производительность и надежность.

## Требования

- Java 17 или выше
- База данных (например, MySQL, PostgreSQL)
- Maven для сборки проекта

- ## Установка и запуск

1. Клонируйте репозиторий: git clone https://github.com/your-username/your-repo.git https://github.com/Belaquaa/PrePrj.git
2. Перейдите в директорию проекта: cd PrePrj
3. Настройте конфигурацию базы данных в файле src/main/resources/hibernate.cfg.xml
4. Соберите проект с помощью Maven: mvn clean install
5. Запустите приложение.

## Использование

- Добавление пользователя: UserDao.saveUser(String name, String lastName, byte age)
- Удаление пользователя: UserDao.removeUserById(long id)
- Получение всех пользователей: UserDao.getAllUsers()
- Создание таблицы: UserDao.createUsersTable()
- Очистка таблицы: UserDao.cleanUsersTable()
- Удаление таблицы: UserDao.dropUsersTable()

## Лицензия

Этот проект распространяется под лицензией HAHAHA License.
