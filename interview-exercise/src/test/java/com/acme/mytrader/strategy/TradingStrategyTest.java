package com.acme.mytrader.strategy;

import org.junit.Test;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceListenerImpl;
import com.acme.mytrader.price.PriceSource;

public class TradingStrategyTest {
    @Test
    public void testNothing() {
    	// Mock class for executor service
    	ExecutionService es=new ExecutionService() {

			@Override
			public void buy(String security, double price, int volume) {
				// TODO Auto-generated method stub
				System.out.println(security+price+price);
				
			}

			@Override
			public void sell(String security, double price, int volume) {
				// TODO Auto-generated method stub
				
			}
    		
    	};
    	PriceListenerImpl pl=new PriceListenerImpl(es);
    	// Mock class for  PriceSource
    	PriceSource psA=new PriceSource() {

			@Override
			public void addPriceListener(PriceListener listener) {
				// TODO Auto-generated method stub
				
				
			}

			@Override
			public void removePriceListener(PriceListener listener) {
				// TODO Auto-generated method stub
				
			}
    		
    	};
    	TradingStrategy ts=new TradingStrategy(psA);
    	ts.registerListner(pl);
    	for (int i=30;i<200;i=i+20) {
    	ts.monitorStocks("IBM",i);
    	}
    	
    }
}
