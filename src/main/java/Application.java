import domain.User;

public class Application {
    public static void main(String... args) {
        User vasja = User.builder().name("Вася").surname("Васильевич").lastname("Васильев").build();
        User vasja1 = User.builder().name("Вася").surname("Васильевич").lastname("Васильев").build();
        System.out.println(vasja == vasja1);
    }
}
