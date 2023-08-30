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
@Table(name = "WFM_JOB_TITLE")
public class WFM_JOB_TITLE {
    @Id
    @Column(name = "JOB_TITLE_ID")
    private long jobTitleId;
    @Column(name = "JOB_TITLE_NAME")
    private String jobTitleName;
}
