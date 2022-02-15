import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DbUtils m = new MySQL();
        m.connect();

        Scanner sc = new Scanner(System.in);
        String []list = new String[5];
        System.out.print("Please Enter what u want to select : ");
        for (int i =0;i<5;i++ ){

            list[i]=(sc.nextLine());

        }

        m.select("users" , list);
        m.disConnect();

//        DbWorker dbWorker;
//        dbWorker = (DbUtils dbUtils) ->{
//            dbUtils.connect();
//            dbUtils.delete("");
//        };
//
//        dbWorker.connect(new MySQL());

    }

}
