package com.interview;

/**
 * Created by pasha on 20.02.18.
 */
public class TradeBot01 implements Bidder {

    protected int cashMy;
    protected int cashOther;

    protected int itemMy;
    protected int itemOther;

    protected int itemTotal;

    protected ITradeCalculator manager;

    public TradeBot01(ITradeCalculator manager) {
        this.manager = manager;
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

    @Override
    public void bids(int own, int other) {
        if (own > other) {
           itemMy+=2;
        } else {
            if (own < other) {
                itemOther+=2;
            } else {
                itemMy++;
                itemOther++;
            }
        }
        cashMy -= own;
        cashOther -= other;
        if (this.manager != null) {
            this.manager.afterMove(itemMy, cashMy);
        }
    }
}
