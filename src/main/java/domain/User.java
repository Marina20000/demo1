package domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class User extends Dictionary{
    private String name;
    private String surname;
    private String lastname;
}
