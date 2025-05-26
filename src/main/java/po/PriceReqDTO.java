package po;

import lombok.Data;

@Data
public class PriceReqDTO {

    private String productId; // ID of the product
    private String customerId; // ID of the customer
    private Double price; // Price of the product
    private String currency; // Currency of the price
    private String requestDate; // Date of the price request
    private String region; // Region for the price request

}
