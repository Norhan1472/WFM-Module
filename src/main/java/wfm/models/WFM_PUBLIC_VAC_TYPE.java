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
@Table(name = "WFM_PUBLIC_VAC_TYPE")
public class WFM_PUBLIC_VAC_TYPE {
    @Id
    @Column(name = "VACATION_TYPE_ID")
    private String vacationTypeId;
    @Column(name = "VACATION_NAME")
    private String vacationName;
    @OneToMany(mappedBy = "wfmPublicVacType")
    @JsonIgnore
    private Set<WFM_PUBLIC_VAC>wfmPublicVacs = new HashSet<>();
}
