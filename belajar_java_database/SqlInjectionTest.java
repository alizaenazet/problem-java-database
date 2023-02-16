package azet.belajar_java_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.print.DocFlavor.READER;

import org.junit.jupiter.api.Test;

import com.mysql.cj.xdevapi.Result;

import azet.belajar_java_database.Utilities.ConnectionUtil;

public class SqlInjectionTest {
    @Test
    public void testSqlInjection() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String username = "admin1'; #";
        String password = "admin";

        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("berhasil login");
        } else {
            System.out.println("berhasil gagal login");
        }

        preparedStatement.close();
        connection.close();
    }
}
