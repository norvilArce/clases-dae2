package pe.isil.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Category {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer categoryId;
    private String description;
    private Boolean status;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
