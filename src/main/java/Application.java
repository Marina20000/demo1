import domain.User;

public class Application {
    public static void main(String... args) {
        User vasja = new User("Вася", "Васильевич", "Васильев");
        User vasja1 = new User("Вася", "Васильевич", "Васильев");
        System.out.println(vasja == vasja1);
    }
}
