package affiliate.engineRpcPartner.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PartnerGrpcErrorResponsePojo {

    @JsonProperty("error")
    private String error;

    @JsonProperty("data")
    private Object data;


}
