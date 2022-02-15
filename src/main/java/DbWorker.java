import java.sql.Statement;

public interface DbWorker {

    Statement connect(DbUtils db);
    void disConnect (DbUtils db);

}
