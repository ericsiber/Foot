package co.simplon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class Main {

//    static String databaseUrl = "jdbc:oracle:thin:USERNAME/PASSWORD@HOSTNAME:PORT:SID";
    static String databaseUrl = "jdbc:oracle:thin:simplon/simplon@localhost:1521:xe";	

    static String requeteSql = "SELECT * FROM EMP";

    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver(new OracleDriver());

        Connection connexion = DriverManager.getConnection(databaseUrl);
        Statement requete = connexion.createStatement();
        ResultSet resultat = requete.executeQuery(requeteSql);
        while (resultat.next()) {
            String nom = resultat.getString("ENAME");
            String job = resultat.getString("job");            
            System.out.println(nom+" "+job);
        }
        resultat.close();
        requete.close();
        connexion.close();
    }
}
