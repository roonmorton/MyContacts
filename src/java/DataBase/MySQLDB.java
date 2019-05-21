/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Juan Lemus
 */

public class MySQLDB {
    
    private Connection connection = null;
    private Statement st = null;
    
    public MySQLDB() {
        super();
    }
    
    public void conectar() throws ClassNotFoundException, SQLException{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/prueba","root", "la_clave");       
    }
    public ResultSet consultar(String query) throws SQLException{
        ResultSet rs;
        this.st = this.connection.createStatement();
        rs = this.st.executeQuery(query);
        this.close();
        return rs;
    }
    public void close() throws SQLException{
        this.connection.close();
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }
     
}
