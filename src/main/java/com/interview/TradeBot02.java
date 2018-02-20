package com.interview;

/**
 * Created by pasha on 20.02.18.
 */
public class TradeBot02 extends TradeBot01 {
    public TradeBot02(ITradeCalculator manager) {
        super(manager);
    }

    @Override
    public int placeBid() {
        if (cashMy < 1) {
            return 0;
        }
        if (cashMy <= itemLeft() || cashOther < 1) {
            return 1;
        }
        if (itemLeft() == 1) {
            return cashMy;
        }
        // Reason for guess a bid

        int moreThanOtherQty = cashMy - cashOther;
        if (moreThanOtherQty < 0) {
            moreThanOtherQty = 0;
        }

        int maxBid =  (cashMy - (itemLeft() - 1) );

        int bid = moreThanOtherQty + (int)( Math.random() * maxBid ) + 1;
        if (bid > cashMy) {
            bid = cashMy;
        }

        return bid;
    }


}
