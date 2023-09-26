package wfm.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "WFM_EMP_VACATION")
public class WFM_EMP_VACATION {
    @Id
    @Column(name = "VACATION_ID")
    private String vacationId;
    @Column(name = "NO_DAYS")
    private Long noDays;
    @Column(name = "START_DATE")
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date startDate;
    @ManyToOne
    @JoinColumn(name = "EMP_ID")
    private WFM_EMP wfmEmp;
}
