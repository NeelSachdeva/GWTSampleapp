package com.knoldus.gwtsampleapp.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.knoldus.gwtsampleapp.client.BillService;

public class BillServiceImpl extends RemoteServiceServlet implements BillService {

	
	private static final long serialVersionUID = 1L;

	@Override
	public String fetchName(String customername) {
		String resultString= customername ;
		return resultString;
	}

	@Override
	public int totalAmount(int itemprice1, int itemprice2) {
		int totalBill=itemprice1+itemprice2;
		return totalBill;
		
	}

}
