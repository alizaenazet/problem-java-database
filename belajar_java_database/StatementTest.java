package azet.belajar_java_database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

import azet.belajar_java_database.Utilities.ConnectionUtil;

public class StatementTest {
    
    @Test
    public void testStatement() throws SQLException{
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        Statement statement = connection.createStatement();

        statement.close();

        connection.close();
    }
    @Test
    public void testExecuteUpdate() throws SQLException{
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        Statement statement = connection.createStatement();

        String sql = """
                INSERT INTO customer(id,name,email) VALUES('yanti','yulianti','yanti@gmail.com'),('anton','antonio','anton@gmail.com')
                """;

        int update = statement.executeUpdate(sql);
        System.out.println(update);

        statement.close();

        connection.close();
    }
    @Test
    public void testDelete() throws SQLException{
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        Statement statement = connection.createStatement();

        String sql = """
               DELETE FROM customer WHERE id = 'budi'
                """;

        int update = statement.executeUpdate(sql);
        System.out.println(update);

        statement.close();

        connection.close();
    }
    @Test
    public void testExecuteQuery() throws SQLException{
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        Statement statement = connection.createStatement();

        String sql = """
                SELECT * FROM customer
                """;

        ResultSet resultSet  = statement.executeQuery(sql);
        resultSet.close();
        System.out.println(resultSet);

        statement.close();

        connection.close();
    }
}
