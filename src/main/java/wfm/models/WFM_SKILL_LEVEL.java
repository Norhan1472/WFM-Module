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
@Table(name = "WFM_SKILL_LEVEL")
public class WFM_SKILL_LEVEL {
    @Id
    @Column(name = "LEVEL_ID")
    private String levelId;
    @Column(name = "LEVEL_NAME")
    private String levelName;
    @OneToMany(mappedBy = "skillLevel")
    @JsonIgnore
    private Set<WFM_EMP>emps = new HashSet<>();
}
