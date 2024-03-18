package affiliate.engineRpcPartner;
import affiliate.engineRpc.Response.APIResponse;
import affiliate.engineRpcPartner.Request.PartnerGrpcRequestPojo;
import com.google.gson.Gson;
import com.tokopedia.accounts.User;
import com.tokopedia.entity.GQLEntityManager;
import entities.GenericResponse;
import entities.TestData;
import framework.baseClasses.BaseService;
import framework.utilities.http.HttpClient;
import framework.utilities.json.JsonMapper;


/**
 * Service class for Affiliate Engine rpc
 *
 * @author Himanshu-Badoni
 */
public class AffiliatePartnerService extends BaseService {

    Gson gson;

    String baseURL;

    GQLEntityManager gql;

    APIResponse response;

    HttpClient client;

    private String method;

    public AffiliatePartnerService(String environment, String method) {

        gson = new Gson();
        client = new HttpClient();
        response = new APIResponse();
        gql = new GQLEntityManager();


        if (environment.equalsIgnoreCase("Staging")) {
            baseURL = "https://gql-staging.tokopedia.com";

//Both the URL are same intentionally.
        } else {
            baseURL = "https://gql-staging.tokopedia.com";

        }

        this.method = "/affiliatepartner.AffiliatePartner." + method + "/invoke";


    }

    public <T> T validateRegisteredPartner(PartnerGrpcRequestPojo TestdataPojo, User user, Class<T> className, TestData userdata) {


        if (TestdataPojo == null) {
            logger("[ ERROR ] No Test Data found for Asserting Affiliate ");

        }
        String requestBodyJson = gson.toJson(TestdataPojo);
        logger("[ Final Json body for resquest ] " + requestBodyJson);


        GenericResponse res = client.postWithFormUrlUTF8(userdata.getHostnames().getHostURL("affiliate-engine-rpc-affiliate-partner", true) + method, userdata.getHeaderMap(), requestBodyJson, GenericResponse.class);

        logger("[Check Cookie response ] " + res.getResponse());
        return JsonMapper.convertStringToPojo(res.getResponse(), className);

    }


}
