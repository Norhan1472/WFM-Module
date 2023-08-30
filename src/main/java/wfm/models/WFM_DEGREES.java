package wfm.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "WFM_DEGREES")
public class WFM_DEGREES {
    @Id
    @Column(name = "DEGREE_VALUE")
    private long degreeValue;
    @Column(name ="DEGREE_DESC")
    private String degreeDesc;
}
