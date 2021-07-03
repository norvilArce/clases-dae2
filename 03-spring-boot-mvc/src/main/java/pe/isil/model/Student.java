package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private String documentNumber;
    private String firstName;
    private String lastNameFather;
    private String lastNameMother;
    private Integer age;

}
