import domain.Id;
import domain.MyAbstractClass;
import domain.MyLambda;
import domain.User;

import java.util.*;
import java.util.function.Function;

public class Application {
    public static void main(String... args) {
        User vasja = User.builder().name("Вася").surname("Васильевич").lastname("Васильев").build();
        User vasja1 = User.builder().name("Вася").surname("Васильевич").lastname("Васильев").build();
        System.out.println(vasja == vasja1);
        Map<Id, String> hashMap = new HashMap<>();
        hashMap.put(new Id(1), "1");
        hashMap.put(new Id(1), "2");
        hashMap.put(new Id(1), "3");
        hashMap.put(new Id(1), "4");
        hashMap.put(new Id(1), "5");
        hashMap.put(new Id(1), "6");
        hashMap.put(new Id(1), "7");
        hashMap.put(new Id(1), "8");
        hashMap.put(new Id(1), "9");
        hashMap.put(new Id(1), "10");
        hashMap.put(new Id(1), "11");
        hashMap.put(new Id(1), "12");
        hashMap.put(new Id(1), "13");
        hashMap.put(new Id(1), "14");
        hashMap.put(new Id(1), "15");
        hashMap.forEach((k, v) -> {
            System.out.println("key+" + k + " value " + v);
        });

        System.out.println(hashMap.get(new Id(1)));
        LinkedHashMap<Integer, String> linkHashMap = new LinkedHashMap<>();
        linkHashMap.put(1, "a");
        linkHashMap.put(2, "b");
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        //linkHashMap.forEach((key, value)-> System.out.println(key+" "+value));
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("aaa");
        hashSet.add("bbb");

        Function<String, Void> function = a -> {
            System.out.println(a);
            return null;
        };
        function.apply("a");

        MyAbstractClass myAbstractClass = new MyAbstractClass() {
            @Override
            public Integer abstractMethod() {
                System.out.println(vasja);
                return 2 + 2;
            }
        };
        System.out.println(myAbstractClass.abstractMethod());

        MyLambda myLambda = new MyLambda() {
            @Override
            public String doubleString(String arg) {
                return arg + arg;
            }
        };
        myLambda.doubleString("aa");
    }
}
