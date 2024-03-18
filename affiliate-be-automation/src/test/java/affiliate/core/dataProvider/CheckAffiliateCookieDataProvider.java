package affiliate.core.dataProvider;

import affiliate.engineRpc.Request.RequestPojoGrpc;
import org.testng.annotations.DataProvider;

public class CheckAffiliateCookieDataProvider {

    @DataProvider
    public Object[][] PositiveTestData() {
        return new Object[][]{
                {"BTCM-143278", false, RequestPojoGrpc.builder()                                   //Cookie exists
                        .buyer_detail(RequestPojoGrpc.BuyerDetail.builder()
                                .buyerid("9143286")
                                .visitorid("")
                                .build())
                        .page_detail(RequestPojoGrpc.PageDetail.builder()
                                .affiliate_uuid("sSAHdRm6HuzhdC7kRskXZRJ7Rlna138xv_57ab4GmKnQuAZOYwccoiJd60PPoM6-oA==")
                                .pageid("6554619")
                                .site_id(1)
                                .page_name("")
                                .pageType("shop")
                                .vertical_id(1)
                                .build())
                        .build()


                },{"BTCM-143289", false, RequestPojoGrpc.builder()                                   //Cookie doesnt exists
                .buyer_detail(RequestPojoGrpc.BuyerDetail.builder()
                        .buyerid("9143286")
                        .visitorid("")
                        .build())
                .page_detail(RequestPojoGrpc.PageDetail.builder()
                        .affiliate_uuid("sSAHdRm6HuzhdC7kRskXZRJ7Rlna138xv_57ab4GmKnQuAZOYwccoiJd60PPoM6-oA==")
                        .pageid("6554622")
                        .site_id(1)
                        .page_name("")
                        .pageType("shop")
                        .vertical_id(1)
                        .build())
                .build()


        },{"BTCM-143303", false, RequestPojoGrpc.builder()                                   //Cookie doesnt exists for wishlist
                .buyer_detail(RequestPojoGrpc.BuyerDetail.builder()
                        .buyerid("9143286")
                        .visitorid("")
                        .build())
                .page_detail(RequestPojoGrpc.PageDetail.builder()
                        .affiliate_uuid("sSAHdRm6HuzhdC7kRskXZRJ7Rlna138xv_57ab4GmKnQuAZOYwccoiJd60PPoM6-oA==")
                        .pageid("1064")
                        .site_id(1)
                        .page_name("")
                        .pageType("4")
                        .vertical_id(1)
                        .build())
                .build()


        },{"BTCM-143306", false, RequestPojoGrpc.builder()                                   // Create Affiliate Cookie for a OS Shop where cookie is already created for given buyerid and pageType = product
                .buyer_detail(RequestPojoGrpc.BuyerDetail.builder()
                        .buyerid("9143286")
                        .visitorid("")
                        .build())
                .page_detail(RequestPojoGrpc.PageDetail.builder()
                        .affiliate_uuid("sSAHdRm6HuzhdC7kRskXZRJ7Rlna138xv_57ab4GmKnQuAZOYwccoiJd60PPoM6-oA==")
                        .pageid("6554619")
                        .site_id(1)
                        .page_name("")
                        .pageType("product")
                        .vertical_id(1)
                        .build())
                .build()


        },{"BTCM-143308", false, RequestPojoGrpc.builder()                                   // Create Affiliate Cookie for a OS Shop where cookie is already created for given buyerid and pageType = product
                .buyer_detail(RequestPojoGrpc.BuyerDetail.builder()
                        .buyerid("9143286")
                        .visitorid("")
                        .build())
                .page_detail(RequestPojoGrpc.PageDetail.builder()
                        .affiliate_uuid("sSAHdRm6HuzhdC7kRskXZRJ7Rlna138xv_57ab4GmKnQuAZOYwccoiJd60PPoM6-oA==")
                        .pageid("6554619")
                        .site_id(1)
                        .page_name("")
                        .pageType("4")
                        .vertical_id(1)
                        .build())
                .build(),


        },{"BTCM-143309", false, RequestPojoGrpc.builder()                                   // Create Affiliate Cookie for a OS Shop where cookie is already created for given buyerid and pageType = product
                .buyer_detail(RequestPojoGrpc.BuyerDetail.builder()
                        .buyerid("9143286")
                        .visitorid("")
                        .build())
                .page_detail(RequestPojoGrpc.PageDetail.builder()
                        .affiliate_uuid("sSAHdRm6HuzhdC7kRskXZRJ7Rlna138xv_57ab4GmKnQuAZOYwccoiJd60PPoM6-oA==")
                        .pageid("6554619")
                        .site_id(1)
                        .page_name("")
                        .pageType("3")
                        .vertical_id(1)
                        .build())
                .build(),


        },{"BTCM-143310", false, RequestPojoGrpc.builder()                                   // Create Affiliate Cookie for a OS Shop where cookie is already created for given buyerid and pageType = product
                .buyer_detail(RequestPojoGrpc.BuyerDetail.builder()
                        .buyerid("9143286")
                        .visitorid("")
                        .build())
                .page_detail(RequestPojoGrpc.PageDetail.builder()
                        .affiliate_uuid("sSAHdRm6HuzhdC7kRskXZRJ7Rlna138xv_57ab4GmKnQuAZOYwccoiJd60PPoM6-oA==")
                        .pageid("6554619")
                        .site_id(1)
                        .page_name("")
                        .pageType("")
                        .vertical_id(1)
                        .build())
                .build(),


        }

        };


    }


}
