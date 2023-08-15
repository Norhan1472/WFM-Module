package wfm.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "WFM_PUBLIC_VAC")
public class WFM_PUBLIC_VAC {
    @Id
    @Column(name = "VACATION_ID")
    private String vacationId;
    @Column(name = "VACATION_NAME")
    private String vacationName;
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "NUM_DAYS")
    private long numDays;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "VACATION_TYPE_ID")
    private WFM_PUBLIC_VAC_TYPE wfmPublicVacType;
}
