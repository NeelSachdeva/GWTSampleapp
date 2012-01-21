package com.knoldus.gwtsampleapp.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
@RemoteServiceRelativePath("billservice")
public interface BillService extends RemoteService {
	
	
	String fetchName(String customername);
	int totalAmount(int itemprice1 , int itemprice2);

}
