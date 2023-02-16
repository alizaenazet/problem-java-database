package azet.belajar_java_database;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPoolTest {
   
   @Test
    void hikariCP(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:/belajar_java_database");
        config.setUsername("root");
        config.setPassword("ALIzaenalAbidin110305");

        //KONFIGURASI POOL
            config.setMaximumPoolSize(10);
            config.setMinimumIdle(3);
            config.setIdleTimeout(60_000);
            config.setMaxLifetime(10 * 60_000);

            try {
                HikariDataSource dataSource = new HikariDataSource(config);
                Connection connection = dataSource.getConnection();
                connection.close();
                
            } catch (SQLException e) {
                Assertions.fail(e);
            }


    }
}