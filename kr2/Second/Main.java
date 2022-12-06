package Second;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> dv = new ArrayList<String>();
        dv.add("000");
        dv.add("111");
        dv.add("010101");
        dv.add("11");
        dv.add("00");
        dv.add("101");
        dv.add("0110");
        dv.add("001");
        dv.add("10101");

        String regex = "0+|1+|(01)+(01)+(0$|(01)$)|(10)+(1$|(10)$)";
        Pattern pattern = Pattern.compile(regex);

        for(String dv1 : dv){
            Matcher matcher = pattern.matcher(dv1);
            System.out.println(dv1 +" -> "+ matcher.matches());
        }
    }
}