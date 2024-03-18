package affiliate.partner;

import affiliate.engineRpcPartner.AffiliatePartnerService;
import affiliate.engineRpcPartner.Request.PartnerGrpcRequestPojo;
import affiliate.engineRpcPartner.Response.PartnerGrpcResponsePojo;
import affiliate.partner.dataProvider.AffiliatePartnerDataProvider;
import com.tokopedia.accounts.User;
import custom.testng.Module;
import entities.TestData;
import framework.baseClasses.BaseTest;
import framework.constants.Priority;
import framework.constants.TestGroup;
import framework.listeners.JiraID;
import org.testng.annotations.Test;

import java.util.HashMap;

@Module(name = "CreatePartnerOOFFER", testType = {TestGroup.SANITY}, priority = Priority.P0)
public class P0_UpdatePartnerOffer extends BaseTest {

    AffiliatePartnerService affiliatePartnerService;

    User user = new User();
    TestData data = new TestData();
    Assertion_Partner assertResponse = new Assertion_Partner();

    @Override
    public void setUpTestData() {
        System.out.println("running setUpTestData");
        String env = System.getProperty("env");
        user.setUser_email("arif.adiputra+affiliate.wallet.s001@tokopedia.com");
        user.setUser_password("tokopedia789");
        affiliatePartnerService = new AffiliatePartnerService("Staging","UpdatePartnerOffer");
        HashMap headers = new HashMap();
        headers.put("Origin", "http://grpcox-staging.tokopedia.net");
        headers.put("Referer", "http://grpcox-staging.tokopedia.net");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("use_tls", "false");
        data.setHeaderMap(headers);

    }

    @JiraID(id = "1")
    @Test(dataProvider = "UpdatePartnerOfferPositive", dataProviderClass = AffiliatePartnerDataProvider.class,priority = 0)
    public void PositiveTestUpdatePartnerOfferTC(String jira_id, String message, PartnerGrpcRequestPojo testDataObject) {


        affiliatePartnerService.logger("[Starting the Grpc request]");
        PartnerGrpcResponsePojo response = affiliatePartnerService.validateRegisteredPartner(testDataObject, user, PartnerGrpcResponsePojo.class, data);
        assertResponse.assertObjectNotNull(response, message);

    }
    @Override
    public void cleanUpTestData() {

    }
}
