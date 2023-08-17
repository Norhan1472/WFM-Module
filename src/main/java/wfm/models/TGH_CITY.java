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
@Table(name = "TGH_CITY")
public class TGH_CITY {
    @Id
    @Column(name = "CITY_CODE")
    private String cityCode;
    @Column(name = "CITY_NAME")
    private String cityName;
    @JsonIgnore
    @OneToMany(mappedBy = "tghCity")
    private Set<TGH_POST_OFFICE> tghPostOffices = new HashSet<>();
}
