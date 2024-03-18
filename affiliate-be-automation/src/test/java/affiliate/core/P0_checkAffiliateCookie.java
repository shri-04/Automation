package affiliate.core;

import affiliate.core.dataProvider.CheckAffiliateCookieDataProvider;
import affiliate.engineRpc.AffiliateEngineService;
import affiliate.engineRpc.Request.RequestPojoGrpc;
import affiliate.engineRpc.Response.GrpcResponse;
import com.tokopedia.accounts.User;
import custom.testng.Module;
import entities.TestData;
import framework.baseClasses.BaseTest;
import framework.constants.Priority;
import framework.constants.TestGroup;
import framework.listeners.JiraID;
import org.testng.annotations.Test;

import java.util.HashMap;


@Module(name = "CheckAffiliateCookie", testType = {TestGroup.SANITY},priority = Priority.P0)
public class P0_checkAffiliateCookie extends BaseTest {


    AffiliateEngineService createCookie;

    User user = new User();
    TestData data = new TestData();


    AssertCreateCookie_GQL assertResponse = new AssertCreateCookie_GQL();

    @Override
    public void setUpTestData() {
        System.out.println("running setUpTestData");
        String env = System.getProperty("env");
        user.setUser_email("arif.adiputra+affiliate.wallet.s001@tokopedia.com");
        user.setUser_password("tokopedia789");
        createCookie = new AffiliateEngineService("Staging");
        HashMap headers = new HashMap();
        headers.put("Origin", "http://grpcox-staging.tokopedia.net");
        headers.put("Referer", "http://grpcox-staging.tokopedia.net");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put("use_tls", "false");
        data.setHeaderMap(headers);

    }


    @JiraID(id = "BTCM-143278,BTCM-143289,BTCM-143303,BTCM-143306,BTCM-143308,BTCM-143309,BTCM-143310")
    @Test(dataProvider = "PositiveTestData", dataProviderClass = CheckAffiliateCookieDataProvider.class)
    public void testCheckAffiliateCookiePositiveTC(String jira_id, Boolean status, RequestPojoGrpc testDataObject) {


        createCookie.logger("[Starting the Grpc request]");
        GrpcResponse resp = createCookie.checkAffiliateCookie(testDataObject, user, GrpcResponse.class, data);
        assertResponse.gRPC_assertAffiliateUuid(resp, testDataObject,status);
    }


    @Override
    public void cleanUpTestData() {
        System.out.println("running cleanUpTestData");
    }
}
