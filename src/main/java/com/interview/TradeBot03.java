package com.interview;

/**
 * Created by pasha on 20.02.18.
 */
public class TradeBot03 extends TradeBot01 {
    public TradeBot03(ITradeCalculator manager) {
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

        int bid = cashMy / itemLeft() + 1;

        if (bid > cashMy) {
            bid = cashMy;
        }

        return bid;
    }

}
