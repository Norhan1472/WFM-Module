package wfm.payload.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OFFICES_Search_Req {
    private String officeName;
    private String cityName;
}
