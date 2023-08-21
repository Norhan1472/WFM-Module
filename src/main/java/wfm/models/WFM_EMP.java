package wfm.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "WFM_EMP")
public class WFM_EMP {
    @Id
    @Column(name = "EMP_ID")
    private long empId;
    //office code
    @ManyToOne
    @JoinColumn(name = "OFFICE_CODE")
    @JsonIgnore
    private TGH_POST_OFFICE postOffice;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "PHONE")
    private long phone;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "BIRTHDATE")
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date birthdate;
    @Column(name = "HIRE_DATE")
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date hireDate;
    @Column(name = "CITY")
    private String city;
    //levelId
    @ManyToOne
    @JoinColumn(name = "LEVEL_ID")
    private WFM_SKILL_LEVEL skillLevel;
    //laborTypeId
    @ManyToOne
    @JoinColumn(name = "LABOR_TYPE_ID")
    private WFM_LABOR_TYPE laborType;
    @Column(name = "DEGREE")
    private Integer degree;
    @Column(name = "QUALIFICATION_DATE")
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date qualificationDate;
    @Column(name = "QUALIFICATION_ID")
    private Integer qualification;
    @Column(name = "JOB_TITLE_ID")
    private Integer jobTitle;
    @Column(name = "JOB_ID")
    private Integer job;
    @Column(name = "CIVIL")
    private Integer civil;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "SOC_SEC_NBR")
    private String cardId;
    @OneToMany(mappedBy = "wfm_emp")//fetch = FetchType.EAGER,
    @JsonIgnore
    private Set<WFM_CALENDER_SHIFT> wfm_calender_shifts = new HashSet<>();
}
