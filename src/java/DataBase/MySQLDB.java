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
    private Statement statement = null;
    
    public MySQLDB() {
        super();
    }
    
    public void conectar() throws ClassNotFoundException, SQLException{
            Class.forName("com.mysql.jdbc.Driver");
            setConnection(DriverManager.getConnection("jdbc:mysql://localhost/prueba","root", "la_clave"));       
    }
    
    public ResultSet consultar(String query) throws SQLException{
        ResultSet rs;
        this.setStatement(this.getConnection().createStatement());
        rs = this.getStatement().executeQuery(query);
        this.close();
        return rs;
    }
    
    public void close() throws SQLException{
        this.getConnection().close();
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * @return the statement
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * @param statement the statement to set
     */
    public void setStatement(Statement statement) {
        this.statement = statement;
    }

   

  
     
}
