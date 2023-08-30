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
@Table(name = "WFM_JOBS")
public class WFM_JOBS {
    @Id
    @Column(name = "JOB_ID")
    private long jobId;
    @Column(name = "JOB_NAME")
    private String jobName;
}
