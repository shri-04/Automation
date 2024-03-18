package affiliate.partner;
/**
 * @author Himanshu Badoni
 * @created 17/05/23
 */

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import affiliate.engineRpcPartner.Response.PartnerGrpcErrorResponsePojo;
import affiliate.engineRpcPartner.Response.PartnerGrpcResponsePojo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;


public class Assertion_Partner {


    public void assertIsRegistered(PartnerGrpcResponsePojo rest, String ExpectedErrorMessage) {


        assertEquals(rest.getData().getResult().getData().getCtaText(), ExpectedErrorMessage);


        assertNotNull(rest.getData().getResult());


    }

    public void assertObjectNotNull(PartnerGrpcResponsePojo rest, String ExpectedErrorMessage) {

        assertEquals(rest.getData().getResult().getHeader().getMessage(),ExpectedErrorMessage);

        assertNotNull(rest.getData().getResult().getData().getOfferId());


    }

    public void assertGrpcError(PartnerGrpcErrorResponsePojo rest, String ExpectedErrorMessage) {

        assertEquals(rest.getError(),ExpectedErrorMessage);

        assertNull(rest.getData());


    }


}
