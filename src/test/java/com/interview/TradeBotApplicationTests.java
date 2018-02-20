package com.interview;

import org.junit.Before;
import org.junit.Test;

public class TradeBotApplicationTests {

    Bidder bidder1;
    Bidder bidder2;
    int cash1;
    int cash2;
    int item1;
    int item2;


    @Before
    public void setUp() {
        bidder1 = new TradeBot01((item, cash) -> {
            item1 = item;
            cash1 = cash;
        });
        bidder2 = new TradeBot03((item, cash) -> {
            item2 = item;
            cash2 = cash;
        });
    }


	@Test
	public void test1() {
        int qty = 10;
        bidder1.init(qty, 50);
        bidder2.init(qty, 50);

        while (qty > 0) {
            int bid1 = bidder1.placeBid();
            int bid2 = bidder2.placeBid();
            System.out.println("------------------");
            System.out.println("------> "+bid1 + ", ----> "+ bid2);
            bidder1.bids(bid1, bid2);
            bidder2.bids(bid2, bid1);
            System.out.println("1------> item: "+item1 + ", cash: "+ cash1);
            System.out.println("2------> item: "+item2 + ", cash: "+ cash2);
            qty-=2;
        }


	}

}
