package affiliate.core;

import affiliate.engineRpc.Request.RequestPojoGQL;
import affiliate.engineRpc.Response.APIResponse;
import affiliate.engineRpc.AffiliateEngineService;
import affiliate.engineRpc.Response.ErrorResponsePojo;
import affiliate.core.dataProvider.CreateAffiliateCookieDataProvider;
import com.tokopedia.accounts.User;
import custom.testng.Module;
import framework.baseClasses.BaseTest;
import framework.constants.Priority;
import framework.constants.TestGroup;
import framework.listeners.JiraID;
import org.testng.annotations.Test;

import java.io.IOException;



@Module(name="CreateAffiliateCookie", testType= {TestGroup.SANITY,TestGroup.BLT},priority = Priority.P0)
public class P0_CreateAffiliateCookie extends BaseTest {

    User user = new User();
    AffiliateEngineService createCookie;

    AssertCreateCookie_GQL assertResponse = new AssertCreateCookie_GQL();


    @Override
    public void setUpTestData() {

        System.out.println("running setUpTestData");
        String env = System.getProperty("env");
        user.setUser_email("arif.adiputra+affiliate.wallet.s001@tokopedia.com");
        user.setUser_password("tokopedia789");
        createCookie = new AffiliateEngineService("Staging");


    }

    @JiraID(id="BTCM-118686,BTCM-118688,BTCM-118689,BTCM-118690,BTCM-118691,BTCM-118692,BTCM-118693,BTCM-118695,BTCM-118696,BTCM-118698,BTCM-118699,BTCM-118700,BTCM-118701,BTCM-118702,BTCM-118703,BTCM-118704,BTCM-118705,BTCM-118706,BTCM-118708,BTCM-118709,BTCM-118710,BTCM-118711,BTCM-118712,BTCM-118713,BTCM-118714,BTCM-118715,BTCM-118716,BTCM-118717,BTCM-118718,BTCM-118719,BTCM-118720,BTCM-118724,BTCM-118730,BTCM-131004,BTCM-131006,BTCM-131007,BTCM-131008,BTCM-131009")
    @Test(dataProvider = "PositiveTestData", dataProviderClass = CreateAffiliateCookieDataProvider.class)
    public void testCreateAffiliateCookiePostiveTC(String jira_id, String message, RequestPojoGQL testDataObject) {


        createCookie.logger("[Starting the GQL request]");
        APIResponse resp = createCookie.createAffiliateCookie(testDataObject, user,APIResponse.class);
        assertResponse.assertRecievedAffiliateUUID(resp, testDataObject);
        assertResponse.assertRecievedMessage(resp,message);
        assertResponse.assertRecievedStatus(resp, 1);


    }

    @JiraID(id="BTCM-118723,BTCM-118726,BTCM-131011,BTCM-118736")
    @Test(dataProvider = "ErrorTestData", dataProviderClass = CreateAffiliateCookieDataProvider.class)
    public void testCreateAffiliateCookiePostiveTCWithExceptions(String jira_id, String message, RequestPojoGQL testDataObject) {


        createCookie.logger("[Starting the GQL request]");
        APIResponse resp = createCookie.createAffiliateCookie(testDataObject, user,APIResponse.class);
        assertResponse.assertRecievedMessage(resp,message);
        assertResponse.assertRecievedStatus(resp, 0);


    }

    @JiraID(id="BTCM-118721,BTCM-118722,BTCM-118729,BTCM-118732,BTCM-118725,BTCM-131005,BTCM-131010")
   @Test(dataProvider = "NegetiveTestData", dataProviderClass = CreateAffiliateCookieDataProvider.class)
    public void testCreateAffiliateCookieNegetiveTC(String jira_id, String message, RequestPojoGQL testDataObject) throws IOException {


        createCookie.logger("[Starting the GQL request]");
        ErrorResponsePojo err_resp = createCookie.createAffiliateCookie(testDataObject, user,ErrorResponsePojo.class);
        assertResponse.assertNegetiveResponseMessage(err_resp,message);
        assertResponse.assertNegetiveResponseCode(err_resp,500);




    }

    @Override
    public void cleanUpTestData() {

    }


}
