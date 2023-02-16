package azet.belajar_java_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

import azet.belajar_java_database.Utilities.ConnectionUtil;

public class BatchTest {

    @Test
    public void testStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO comments(email,comment) VALUES('cmiw@gmail.com','no comment itu sih derita elu'),('awuwu@icloud.com','itu sih derita elu')";

        for (int i = 0; i < 100; i++) {
            statement.addBatch(sql);
        }
        statement.executeBatch();
        statement.close();
        connection.close();

    }

    @Test
    public void testPreparedStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO comments(email,comment)VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < 33; i++) {
            preparedStatement.clearParameters();
            preparedStatement.setString(1, "ekocuy@gmail.com");
            preparedStatement.setString(2, "acimilakuwooooo");
            preparedStatement.addBatch();
            for (int j = 0; j < 33; j++) {
                preparedStatement.clearParameters();
                preparedStatement.setString(1, "cmiwiw@icloud.com");
                preparedStatement.setString(2, "awuwauwaw");
                preparedStatement.addBatch();
                for (int j2 = 0; j2 < 33; j2++) {
                    preparedStatement.clearParameters();
            preparedStatement.setString(1, "yanto@yahoo.com");
            preparedStatement.setString(2, "aseloleee");
            preparedStatement.addBatch();
                }
            }
            
        }

        preparedStatement.executeBatch();
        preparedStatement.close();
        connection.close();
    }


    @Test
    public void resultTheTest() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM comments";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("comments.id");
            String email = resultSet.getString("comments.email");
            String comment = resultSet.getString("comments.comment");
            System.out.println(String.join(", ", String.valueOf(id), email, comment));
        }
        resultSet.close();
        statement.close();
        connection.close();

    }
}
