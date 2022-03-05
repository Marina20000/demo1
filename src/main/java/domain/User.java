package domain;


public class User extends Dictionary{
    private String name;
    private String surname;
    private String lastname;

    private User(Builder builder) {
        this.name=builder.name;
        this.surname=builder.surname;
        this.lastname = builder.lastname;
    }

    public static class Builder{
        private String name;
        private String surname;
        private String lastname;
        private String version;
        private Long id;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public User build() {
            User user =  new User(this);
            return user;
        }

    }
}
