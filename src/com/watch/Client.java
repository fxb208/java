package com.watch;

public class Client {
	public static void main(String[] args) {
		Police police=new Police();
		Security security=new Security();
		Thief thief=new Thief();
		Transporter transporter=new Transporter();
		transporter.addWatcher(thief);
		transporter.addWatcher(security);
		transporter.addWatcher(police);
		transporter.notifyWatchers();
	}
	
}
