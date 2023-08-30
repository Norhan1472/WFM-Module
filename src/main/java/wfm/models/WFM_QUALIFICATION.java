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
@Table(name = "WFM_QUALIFICATION")
public class WFM_QUALIFICATION {
    @Id
    @Column(name = "QUALIFICATION_ID")
    private long qualificationId;
    @Column(name = "QUALIFICATION_NAME")
    private String qualificationName;

}
