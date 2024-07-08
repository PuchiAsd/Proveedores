package cl.praxis.desafioproveedores;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    private static MysqlConnection instance;
    private Connection connection;
    private String jdbcURL ="jdbc:mysql://localhost:3306/user_providers";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1234";

    private MysqlConnection() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }catch (ClassNotFoundException | SQLException e){
            throw new SQLException(e);
        }
    }

    public Connection getConnection(){
        return connection;
    }
    public static MysqlConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new MysqlConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new MysqlConnection();

        }
        return instance;
    }
}
