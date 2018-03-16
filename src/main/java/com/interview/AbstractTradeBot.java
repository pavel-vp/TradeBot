package com.interview;

/**
 * Created by pasha on 16.03.18.
 */
public abstract class AbstractTradeBot implements Bidder {
    protected int cashMy;
    protected int cashOther;

    protected int itemMy;
    protected int itemOther;

    protected int itemTotal;

    protected ITradeCalculator manager;

    public AbstractTradeBot(ITradeCalculator manager) {
        this.manager = manager;
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
