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
    /*@GeneratedValue(generator = "WFM_EMP_VACATION_SEQ",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "WFM_EMP_VACATION_SEQ",name = "WFM_EMP_VACATION_SEQ",allocationSize = 1)*/
    /*@GeneratedValue(generator = "WFM_EMP_VACATION_SEQ")
    @GenericGenerator(name = "WFM_EMP_VACATION_SEQ", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "VACATION_ID", updatable = false, nullable = false)*/
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
