package thread;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Exchanger {

    private Integer n;

    public void increment(){
        ++n;
    }

    public void decrement(){
        --n;
    }
}
