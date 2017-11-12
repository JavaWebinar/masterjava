package ru.javaops.masterjava.persist;

import java.sql.DriverManager;

public class DBITestProvider {
    public static void initDBI() {
        initDBI("jdbc:postgresql://localhost:5432/masterjava", "user", "password");
    }

    public static void initDBI(String dbUrl, String dbUser, String dbPassword) {
        DBIProvider.init(() -> {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("PostgreSQL driver not found", e);
            }
            return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        });
    }
}