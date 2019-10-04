import com.google.common.collect.Lists;
import java.util.List;

public class HelloOtus {

    private static List<String> getArrFromString(String pattern){
        List<String> strlist = Lists.newArrayList();
        String[] strarray = pattern.split(" ");
        for(String i : strarray)
            strlist.add(i);
        return strlist;
    }
 public static void main(String[] args) {
        List<String> strlist = getArrFromString("aaa bbb ccc ddd eee fff");
        for (String i : strlist)
            System.out.println(i);

 }

}
