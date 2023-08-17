package wfm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "WFM_LABOR_TYPE")
public class WFM_LABOR_TYPE {
    @Id
    @Column(name = "LABOR_TYPE_ID")
    private String laborTypeId;
    @Column(name = "LABOR_TYPE_NAME")
    private String laborTypeName;
    @OneToMany(mappedBy = "laborType")
    @JsonIgnore
    private Set<WFM_EMP>emps = new HashSet<>();
}
