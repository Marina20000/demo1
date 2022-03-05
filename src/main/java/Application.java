import domain.User;

public class Application {
    public static void main(String... args){
        User user = new User.Builder()
                .name("ivan")
                .lastname("sidorov")
                .build();
    }
}
