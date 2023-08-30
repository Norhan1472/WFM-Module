package wfm.models;


import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date startDate;
    @Column(name = "NUM_DAYS")
    private long numDays;
    @ManyToOne(fetch = FetchType.EAGER)
/*
    @JsonIgnore
*/
    @JoinColumn(name = "VACATION_TYPE_ID")
    private WFM_PUBLIC_VAC_TYPE wfmPublicVacType;
}
