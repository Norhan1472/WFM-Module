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
@Table(name = "WFM_SHIFTS")
public class WFM_SHIFTS {
    @Id
    @Column(name = "SHIFT_ID")
    private String shiftId;
    @Column(name = "DURATION")
    private long duration;
    @OneToMany(mappedBy = "wfm_shifts")//fetch = FetchType.EAGER,
    @JsonIgnore
    private Set<WFM_CALENDAR_SHIFT>wfm_calender_shifts = new HashSet<>();
}
