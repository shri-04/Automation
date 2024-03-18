package affiliate.engineRpcPartner.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartnerGrpcRequestPojo {

    private String partnerId;
    private String userId;
    private int siteId;
    private int verticalId;
    private String platform;
    private String commissionRate;
    private String startDate;
    private String endDate;
    private String maxCap;
    private String budget;
    private String budgetValue;
    private String status;
    private String offerId;
    private String commissionId;
    private Boolean isBudgetForced;


}
