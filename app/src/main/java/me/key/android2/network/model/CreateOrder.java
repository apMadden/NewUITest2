package me.key.android2.network.model;

import java.util.ArrayList;
import java.util.List;

import me.key.android.net.NetworkRequest.JSONToServer;

public class CreateOrder implements JSONToServer {

    public String promotion_code;
    public Shipping delivery_method = null;
    public List<Transaction> transactions;
    //public String payment_receipt; // not used. ios inapp purchase receipts
    public String payment_token;

    public CreateOrder(ArrayList<Transaction> transactions, Shipping shipping, String cardToken, String promotionCode) {
        this.transactions = transactions;
        this.delivery_method = shipping;
        this.payment_token = cardToken;
        this.promotion_code = promotionCode;
    }

    @Override
    public void process() {

    }


}
