package com.knoldus.gwtsampleapp.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BillServiceAsync {

	void totalAmount(int itemprice1, int itemprice2,
			AsyncCallback<Integer> callback);

	void fetchName(String customername, AsyncCallback<String> callback);

}
