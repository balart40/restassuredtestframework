package applications.hogwartsschool;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
public class StudentPojo {

    private Long id;
    private String name;
    private String email;
    private String house;
    private LocalDate dob;
    private Integer age;

    public StudentPojo(Long id, String name, String email, String house, LocalDate dob, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.house = house;
        this.dob = dob;
        this.age = age;
    }
}
