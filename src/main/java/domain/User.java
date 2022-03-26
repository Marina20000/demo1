package domain;

import lombok.*;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class User extends Dictionary {
    private String name;
    private String surname;
    private String lastname;

    MyAbstractClass myAbstractClass = new MyAbstractClass() {
        @Override
        public Integer abstractMethod() {
            return 2 + 2;
        }
    };
}
