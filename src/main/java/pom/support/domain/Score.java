package pom.support.domain;

//import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(ignoreUnknow=true)
//@JspnInclude(JsonInclude)
public class Score {

    @Builder.Default
    private long merchantCode = 52145886L;

    @Builder.Default
    private boolean newIndicatorClient = false;

    @Builder.Default
    private int ramoAtividade = 5411;

    @Builder.Default
    private int billingSize = 1000;

}
