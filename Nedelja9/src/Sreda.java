import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Sreda {

    public static int prviUslov(int num) {
        if (num % 3 == 0){
            return num * num;
        }
        return num;
    }

    public static boolean drugiUslov(int num){
        return (num * num) % 3 != 0;
    }

    public static int treciUslov(int num){
        if (num % 2 != 0){
            num *= 2;
        }
        return num;
    }

    public static Set<Integer> sorted(List<Integer> list) {
       return list.stream().
               map(Sreda::prviUslov).
               filter(Sreda::drugiUslov).
               map(Sreda::treciUslov).
               collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,5,4,7,8,6,3,4);
        System.out.println(sorted(list));
    }
}