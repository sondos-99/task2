import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Oracle extends DbUtils {
    Connection con = null;
    Statement stmt = null;
    @Override
    public Statement connect() {
        System.out.println("MySQL Connected.");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
            stmt = con.createStatement();
            con.close();
            stmt.close();
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
        }    }
}
