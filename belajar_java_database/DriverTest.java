package azet.belajar_java_database;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mysql.cj.jdbc.Driver;

public class DriverTest {

    
    @Test
    public void testRegister() {
        
        try {
            Driver mySqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mySqlDriver);
            
        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }
    


}

