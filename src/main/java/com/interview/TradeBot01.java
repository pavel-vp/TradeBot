package com.interview;

/**
 * Created by pasha on 20.02.18.
 */
public class TradeBot01 extends AbstractTradeBot {

    public TradeBot01(ITradeCalculator manager) {
        super(manager);
    }

    protected int itemLeft() {
        return (itemTotal - (itemMy + itemOther)) / 2;
    }

    @Override
    public void init(int quantity, int cash) {
        cashMy = cash;
        cashOther =  cash;

        itemTotal = quantity;

        itemMy = 0;
        itemOther = 0;
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
        int maxBid = cashMy - itemLeft();

        int bid = (int)( Math.random() * maxBid ) + 1;

        return bid;
    }

}
