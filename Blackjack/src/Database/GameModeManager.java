/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.util.Map;
/**
 *
 * @author Thomas
 */
public class GameModeManager {
    private final DBManager dbmanager;
    private final Connection conn;
    private Statement statement;
    public GameModeManager(){
        dbmanager = new DBManager();
        conn = dbmanager.getConnection();}
        
    public void createTableDifficulty(){
        try{
            this.statement = conn.createStatement();
            this.statement.addBatch("CREATE TABLE DIFFICULTY (DifficultyID VARCHAR(5))");
            this.statement.executeBatch();
        }   catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
        public void closeConnection(){
        this.dbmanager.closeConnections();
    }
        
        public void dropTable(){
        try {
            this.statement = conn.createStatement();
            this.statement.addBatch("DROP TABLE DIFFICULTY");
            this.statement.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(GameModeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
