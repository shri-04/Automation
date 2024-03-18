package affiliate.core;

import affiliate.engineRpc.Request.RequestPojoGQL;
import affiliate.engineRpc.Request.RequestPojoGrpc;
import affiliate.engineRpc.Response.APIResponse;
import affiliate.engineRpc.Response.ErrorResponsePojo;
import affiliate.engineRpc.Response.GrpcResponse;

import java.io.IOException;

import static org.testng.Assert.*;

public class AssertCreateCookie_GQL {

    public void assertRecievedAffiliateUUID(APIResponse res, RequestPojoGQL testDataPojo) {


        assertEquals(res.getData().getCreateAffiliateCookie().getData().getAffiliateUUID(), testDataPojo.getVariables().getInput().getAffiliateDetail().getAffiliateUUID());


    }

    public void assertRecievedMessage(APIResponse res, String message) {


        assertEquals(res.getData().getCreateAffiliateCookie().getData().getError().getMessage(), message);


    }

    public void assertRecievedStatus(APIResponse res, int Status) {


        assertEquals(res.getData().getCreateAffiliateCookie().getData().getStatus(), Status);


    }

    public void assertNegetiveResponseMessage(ErrorResponsePojo res, String ExpectedMessage) throws IOException {


        res.getErrors().get(0).getMessage();


        assertEquals(res.getErrors().get(0).getMessage(), ExpectedMessage);


    }


    public void assertNegetiveResponseCode(ErrorResponsePojo res, int Status) {


        assertEquals(res.getErrors().get(0).getExtensions().getCode(), Status);


    }

    public void gRPC_assertAffiliateUuid(GrpcResponse res, RequestPojoGrpc testDataObject, Boolean status) {


        Boolean Bol = res.getData().getResult().getAffiliateUuid().contains(testDataObject.getPage_detail().getAffiliate_uuid());
        assertEquals(Bol, status);


    }


}
