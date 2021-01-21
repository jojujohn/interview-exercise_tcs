package com.acme.mytrader.price;

import java.util.HashMap;

import com.acme.mytrader.execution.ExecutionService;

/**
 * Observer class
 * @author jopr2
 *
 */
public class PriceListenerImpl implements PriceListener {
	
	
	
	private HashMap<String, Stock> stockCache=new HashMap <String, Stock>(); 
	
	private ExecutionService es=null;
	private HashMap<String, Boolean> buyCache=new HashMap <String, Boolean>(); 
	
	//private 
	
	public PriceListenerImpl(ExecutionService es) {
			
			this.setEs(es);
			loadMetadata();
	}

	private void loadMetadata() {
		// TODO Auto-generated method stub
		Stock s1=new Stock();
		s1.setStockName("IBM");
		s1.setStockBuyingThresholdQty(10);
		s1.setStockBuyingThresholdPrice(300);
		stockCache.put(s1.getStockName(),s1);
	}

	@Override
	public void priceUpdate(String security, double price) {
		// This method will be called when the subject state changes
		System.out.println("inside price update");
		Stock s=stockCache.get(security);
		
		boolean isBuyExecutionRequired=s!=null?(s.getStockBuyingThresholdPrice()>price?true:false):false;
		if(isBuyExecutionRequired && !this.buyCache.containsKey(security)) {
			es.buy(security, price, s.getStockBuyingThresholdQty());
			buyCache.put(security,Boolean.TRUE);
		}
		
		

	}

	public ExecutionService getEs() {
		return es;
	}

	public void setEs(ExecutionService es) {
		this.es = es;
	}


}
class Stock {
	private String stockName;
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public double getStockBuyingThresholdPrice() {
		return stockBuyingThresholdPrice;
	}
	public void setStockBuyingThresholdPrice(double stockBuyingThresholdPrice) {
		this.stockBuyingThresholdPrice = stockBuyingThresholdPrice;
	}
	public int getStockBuyingThresholdQty() {
		return stockBuyingThresholdQty;
	}
	public void setStockBuyingThresholdQty(int stockBuyingThresholdQty) {
		this.stockBuyingThresholdQty = stockBuyingThresholdQty;
	}
	private double stockBuyingThresholdPrice;
	private int stockBuyingThresholdQty;
	Stock () {
		
		
	}
	
}
