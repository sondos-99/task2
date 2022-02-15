import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySQL extends DbUtils{

    private Connection con;
    private Statement stmt;

    @Override
    public Statement connect() {
        System.out.println("MySQL Connected.");
        con = null;
        stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java",
                    "root", "");
            stmt = con.createStatement();

            return stmt;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void disConnect() {
        try {
            con.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
