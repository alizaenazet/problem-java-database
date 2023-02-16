package azet.belajar_java_database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

import azet.belajar_java_database.Utilities.ConnectionUtil;

public class ResultSetTest {
    


    
        @Test
        public void testExecuteQuery() throws SQLException {
            Connection connection = ConnectionUtil.getDataSource().getConnection();
    
            Statement statement = connection.createStatement();
    
            String sql = """
                    SELECT * FROM customer
                    """;
    
            ResultSet resultSet = statement.executeQuery(sql);
    
            while (resultSet.next()) {
                String id = resultSet.getString("customer.id");
                String name = resultSet.getString("customer.name");
                String email = resultSet.getString("customer.email");
                System.out.println(String.join(", ", id, name, email));
            }
    
            resultSet.close();
    
            statement.close();
    
            connection.close();
        }
    
    
}
