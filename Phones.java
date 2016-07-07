import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zybinskiy.dmitriy on 05.07.2016.
 */
public class Phones {
    public static void main(String[] args) throws IOException {



ArrayList<String> ivanov=new ArrayList<String>();
        ivanov.add("+8 800 2000 500");
        ivanov.add("+8 800 200 600");
        ArrayList<String> petrov=new ArrayList<String>();
        petrov.add("+8 800 2000 700 ");
        ArrayList<String>sidorov=new ArrayList<String>();
        sidorov.add("+8 800 2000 800");
        sidorov.add("+8 800 2000 900");
        sidorov.add("+8 800 2000 000");

        HashMap<String, ArrayList> map = new HashMap<>();
        map.put("Иванов И.И",ivanov);
        map.put("Петров С.И",petrov);
        map.put("Сидоров С.С",sidorov);
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String input=reader.readLine();

        ArrayList phones = map.get(input);
        if (phones != null) {
            System.out.println(phones);
        } else {
            System.out.println("Can't find the name");
        }


    }
}