package affiliate.partner.dataProvider;

import org.testng.annotations.DataProvider;
import affiliate.engineRpcPartner.Request.PartnerGrpcRequestPojo;

import java.time.LocalDate;

public class AffiliatePartnerDataProvider {

    LocalDate startDate = LocalDate.now().plusMonths(2);
    LocalDate endDate = startDate.plusDays(7);


    @DataProvider
    public Object[][] AssertRegisteredPartner() {
        return new Object[][]{{"BTCM-0000", "Buat Komisi", PartnerGrpcRequestPojo.builder().partnerId("6554619").siteId(1).userId("226079817").verticalId(1).platform("desktop").build()


        }, {"BTCM-0000", "Gabung Sekarang", PartnerGrpcRequestPojo.builder().partnerId("6554620").siteId(1).userId("226079817").verticalId(1).platform("desktop").build()


        }


        };
    }

    @DataProvider
    public Object[][] CreatePartnerOffer() {
        return new Object[][]{{"BTCM-0000", "OK", PartnerGrpcRequestPojo.builder().partnerId("6554619").siteId(1).userId("9122186").verticalId(1).commissionRate("10").endDate(endDate.toString()).startDate(startDate.toString()).budget(null).maxCap(null).budgetValue(null).build()


        }


        };
    }


    @DataProvider
    public Object[][] CreatePartnerOfferNegetive() {
        return new Object[][]{{"BTCM-0000", "an offer with same configuration and overlapping period already exists", PartnerGrpcRequestPojo.builder().partnerId("6554619").siteId(1).userId("9122186").verticalId(1).commissionRate("10").endDate(endDate.toString()).startDate(startDate.toString()).budget(null).maxCap(null).budgetValue(null).build()


        }


        };
    }

    @DataProvider
    public Object[][] UpdatePartnerOfferPositive() {
        return new Object[][]{{"BTCM-0000", "OK", PartnerGrpcRequestPojo.builder().partnerId("6554619").siteId(1).userId("9122186").verticalId(1).commissionRate("11").endDate(endDate.toString()).startDate(startDate.toString()).budget(null).maxCap(null).budgetValue(null).offerId("477").commissionId("455").build()


        }


        };
    }


}