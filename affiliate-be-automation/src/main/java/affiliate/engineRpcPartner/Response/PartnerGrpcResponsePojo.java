package affiliate.engineRpcPartner.Response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.io.IOException;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PartnerGrpcResponsePojo {
    @JsonProperty("data")
    private Data data;

    @lombok.Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data {


        @JsonProperty("timer")
        private String timer;

        @JsonProperty("result")
        private String result;


        public Result getResult() {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.readValue(result, Result.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Error parsing result JSON: " + e.getMessage(), e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        @lombok.Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Result {
            private Header header;
            private InnerData data;

            @lombok.Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Header {
                private double processTime;
                private String message;
            }

            @lombok.Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class InnerData {
                private boolean isRegistered;
                private String ctaLink;
                private String ctaText;
                private String offerId;
                private String commissionId;


            }


        }


    }
}










