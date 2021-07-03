package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_company")
public class Company {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "company_id")
    private Long id;

    @Column(length = 11)
    private String ruc;

    @Column(name = "trade_name", length = 50)
    private String tradeName;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Employee> employees;
}
