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
@Table(name = "WFM_CALENDAR_SHIFT")
public class WFM_CALENDER_SHIFT {
    @Id
    @Column(name = "SHIFT_START")
    private Date shiftStart; // primary
    @ManyToOne
    @JoinColumn(name = "EMP_ID")
    /*@JsonIgnore*/
    private WFM_EMP wfm_emp;
    @ManyToOne
    @JoinColumn(name = "SHIFT_ID")
    /*@JsonIgnore*/
    private WFM_SHIFTS wfm_shifts;
    // end date
    @Column(name = "CALENDAR_DATE")
    private Date calenderDate;// primary
    @Column(name = "SHIFT_TOTAL_WIEGHT")
    private Long shiftTotalWeight;
    @Column(name = "LAST_TOTAL_WIEGHT")
    private Long lastTotalWeight;
    @Column(name = "TOTAL_HOUR_WIEGHT")
    private Long totalHourWeight;
}
