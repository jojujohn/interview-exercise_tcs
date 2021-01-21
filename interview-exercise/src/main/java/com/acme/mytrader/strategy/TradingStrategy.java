package com.acme.mytrader.strategy;

import java.util.ArrayList;
import java.util.List;

import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceSource;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy {
	// the list of the listners who are subscribed
	List<PriceListener> listnerList=null; 
	private PriceSource ps ;
	
	public TradingStrategy(PriceSource ps){
	
		listnerList=new ArrayList<PriceListener> ();
		this.ps=ps;
		
	}
	
	public void registerListner(PriceListener pl) {
		this.listnerList.add(pl);
		ps.addPriceListener(pl);
		// TODO Auto-generated method stub
		
	}

	/**
	 * Monitors the stocks and calls the listner's update price
	 * @param security
	 * @param price
	 */
	public void monitorStocks(String security,double price) {
		
		
		listnerList.forEach(e->e.priceUpdate(security, price));
		
	}

	
	


	public void removePriceListener(PriceListener listener) {
		// TODO Auto-generated method stub
		
			this.listnerList.remove(listener);
			ps.removePriceListener(listener);
		}
		
	}
	
	
	
	
	

