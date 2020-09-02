# Spring Ignite JDBC Mybatis Example

Ignite JDBC 조회 후 값이 없으면 Mariadb 조회 후 Ignite JDBC INSERT

Mabatis Multiple Datasource 활용으로 Mariadb, Ignite 모두 Mybatis(JDBC) 로 CRUD 처리

## DBMS - Mariadb
```
create table user (
    username varchar(100) primary key,
    password varchar(100)
);

insert into user values ('admin', 'dkdk');
insert into user values ('ddakker', 'dkdk');
```

## 실행
```
./gradlew clean build (windows gradlew.bat)
java -jar build/libs/test-ignite-jdbc-0.0.1-SNAPSHOT.jar
```

### 조회
* http://localhost:8080/users

### 조건 조회
* http://localhost:8080/users/ddakker

