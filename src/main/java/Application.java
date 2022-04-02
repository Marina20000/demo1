import domain.*;

import java.util.*;
import java.util.function.*;

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

        MyLambda myLambda = arg -> arg + arg;
        myLambda.doubleString("a");

        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a + b;

        Consumer<Integer> consumer = (Integer x) -> System.out.println(x);

        BiConsumer<Integer, String> biConsumer = (Integer x, String y) -> System.out.println(x + " : " + y);

        Predicate<String> predicate = (String s) -> s == null;

        Optional<Department> optionalDepartment = Optional.of(new Employee())
                .map(employee -> employee.getDepartment())
                .filter(Objects::nonNull)
                //.orElse(new Department("*****"))
                .or(() -> Optional.of(new Department("*****")));
        System.out.println(optionalDepartment.get().getName());

        hashMap.entrySet().forEach(it -> System.out.println(it));
        hashMap.entrySet().stream()
                .map(it -> it.getKey() + " " + it.getValue())
                .forEach(it -> System.out.println(it));
        String filterExample = hashSet.stream().filter(it -> it.contains("a")).findAny().orElse("ccc");
        System.out.println(filterExample);
    }
}
