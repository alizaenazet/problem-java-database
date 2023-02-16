package azet.belajar_java_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mysql.cj.jdbc.Driver;

public class ConnectionTest {
    @BeforeAll
    public static void beforeAll() {
        try {
            Driver mySqlDriver = new Driver();
            DriverManager.registerDriver(mySqlDriver);
            
        } catch (SQLException e) {
            Assertions.fail(e);
        }
    };
    @Test
    public void testConnectiom() {
        String jdbcUrl = "jdbc:mysql://localhost:/belajar_java_database";
        String username = "root";
        String password = "ALIzaenalAbidin110305";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("sukses mengkoneksikan");
        } catch (SQLException e) {
           System.out.println(e); Assertions.fail(e);
        }
    }
    @Test
    public void testConnectiomClose() {
        String jdbcUrl = "jdbc:mysql://localhost:/belajar_java_database";
        String username = "root";
        String password = "ALIzaenalAbidin110305";

        try(Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("sukses mengkoneksikan");
        } catch (SQLException e) {
           System.out.println(e); Assertions.fail(e);
        }
    }
}
