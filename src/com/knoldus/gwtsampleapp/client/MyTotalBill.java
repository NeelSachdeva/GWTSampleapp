package com.knoldus.gwtsampleapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MyTotalBill implements EntryPoint {

	VerticalPanel vpanel = new VerticalPanel();
	HorizontalPanel hpanel1 = new HorizontalPanel();
	HorizontalPanel hpanel2 = new HorizontalPanel();
	HorizontalPanel hpanel3 = new HorizontalPanel();
	HorizontalPanel hpanel4 = new HorizontalPanel();

	Label cname = new Label("Customer Name :");
	TextBox tbcustomer = new TextBox();
	Label itemprice1 = new Label("1st Item Price :");
	TextBox textbox1 = new TextBox();

	Label itemprice2 = new Label("2nd Item Price");
	TextBox textbox2 = new TextBox();

	Button submit = new Button("Calculate My Bill");

	String result1;
	String result2;

	private final BillServiceAsync billService = GWT.create(BillService.class);

	public void onModuleLoad() {

		hpanel1.add(cname);
		hpanel1.add(tbcustomer);

		hpanel2.add(itemprice1);
		hpanel2.add(textbox1);

		hpanel3.add(itemprice2);
		hpanel3.add(textbox2);

		hpanel4.add(submit);

		vpanel.add(hpanel1);
		vpanel.add(hpanel2);
		vpanel.add(hpanel3);
		vpanel.add(hpanel4);

		hpanel1.setSpacing(10);
		hpanel2.setSpacing(10);
		hpanel3.setSpacing(10);
		hpanel4.setSpacing(10);

		RootPanel.get("mainpanel").add(vpanel); /*
												 * get("mainpanel") is used to
												 * map the entire layout to HTML
												 * page.
												 */

		submit.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				billService.fetchName(tbcustomer.getText(),
						new AsyncCallback<String>() {

							@Override
							public void onSuccess(String result) {
								System.out.println(result);
								result1 = result;
							}

							@Override
							public void onFailure(Throwable caught) {
								System.out.println("RPC Failed" + caught);

							}
						});

				int itemprice1 = Integer.parseInt(textbox1.getText());
				int itemprice2 = Integer.parseInt(textbox2.getText());

				billService.totalAmount(itemprice1, itemprice2,
						new AsyncCallback<Integer>() {

							@Override
							public void onSuccess(Integer result) {
								System.out.println(result);
								result2 = result.toString();
								Window.alert("Hello " + result1
										+ " , Your Bill Amount is $" + result2);

							}

							@Override
							public void onFailure(Throwable caught) {
								System.out.println("RPC Failed" + caught);

							}
						});

			}
		});
	}

}
