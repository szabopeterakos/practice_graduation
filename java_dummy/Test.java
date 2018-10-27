import java.io.*;

public class Test {

    public static File file = new File("test.txt");

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to you guys!!!");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int i = 0;
        while ((st = br.readLine()) != null) {
            i++;
            System.out.println(st+st+i);
        }
    }

}
