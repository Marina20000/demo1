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
}
