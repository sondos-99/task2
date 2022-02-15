import java.sql.ResultSet;
import java.sql.Statement;

public abstract class DbUtils {
    abstract Statement connect() ;
    abstract void disConnect() ;

    public void insert(String table, String columns[], String values[]) {
        try {

            StringBuilder builder = new StringBuilder();
            builder.append("insert into ");
            builder.append(table);
            builder.append("(");
            for (int i = 0; i < columns.length; i++) {
                if (i != columns.length - 1) {
                    builder.append(columns[i] + ",");
                } else {
                    builder.append(columns[i]);
                }
            }
            builder.append(")");
            builder.append(" values");
            builder.append("(");
            for (int i = 0; i < values.length; i++) {
                if (i != columns.length - 1) {
                    builder.append("'" + values[i] + "',");
                } else {
                    builder.append("'" + values[i] + "'");
                }
            }
            builder.append(")");
            System.out.println(builder.toString());
            connect().execute(builder.toString());
            System.out.println("Record saved.");
            System.out.println("-----------------------------------------");
            disConnect();
        } catch (Exception e) {
            disConnect();
            e.printStackTrace();
        }
    }

// we can use hash map here
    public void update(String table, String columnsToSet[], String valuesToSet[] , String columnsWhere[], String valuesWhere[]) {

        try {

            StringBuilder builder = new StringBuilder();
            builder.append("update ");
            builder.append(table);
            builder.append("set ");
            for (int i = 0; i < columnsToSet.length; i++) {
                if (i != columnsToSet.length - 1) {
                    builder.append(columnsToSet[i] +"=" +valuesToSet[i]+ ",");
                } else {
                    builder.append(columnsToSet[i] +"=" +valuesToSet[i]);
                }
            }

            builder.append(" WHERE ");
            for (int i = 0; i < columnsWhere.length; i++) {
                if (i != columnsWhere.length - 1) {
                    builder.append(columnsWhere[i] +"=" +valuesWhere[i]+ ",");
                } else {
                    builder.append(columnsWhere[i] +"=" +valuesWhere[i]);
                }
            }

            System.out.println(builder.toString());
            connect().execute(builder.toString());
            System.out.println("Record saved.");
            System.out.println("-----------------------------------------");
            disConnect();
        } catch (Exception e) {
            disConnect();
            e.printStackTrace();
        }
    }

    public void select(String table, String columns[]) {
        try {

            StringBuilder builder = new StringBuilder();
            builder.append("select ");
            builder.append(table);
            for (int i = 0; i < columns.length; i++) {
                if (i != columns.length - 1) {
                    builder.append(columns[i] + ",");
                } else {
                    builder.append(columns[i]);
                }
            }
            builder.append(" FROM ");
            builder.append(table);

            System.out.println(builder.toString());
            connect().execute(builder.toString());
            System.out.println("Record saved.");
            System.out.println("-----------------------------------------");
            disConnect();
        } catch (Exception e) {
            disConnect();
            e.printStackTrace();
        }
    }

    public void delete(String table, String columns[] , String values[] ) {

        try {

            StringBuilder builder = new StringBuilder();
            builder.append("delete FROM ");
            builder.append(table);
            builder.append("WHERE");

            for (int i = 0; i < columns.length; i++) {
                if (i != columns.length - 1) {
                    builder.append(columns[i] +"="+values[i]+ ",");
                } else {
                    builder.append(columns[i] +"="+values[i]);
                }
            }
            System.out.println(builder.toString());
            connect().execute(builder.toString());
            System.out.println("Record saved.");
            System.out.println("-----------------------------------------");
            disConnect();
        } catch (Exception e) {
            disConnect();
            e.printStackTrace();
        }
    }

}
