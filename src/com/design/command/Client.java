package com.design.command;

public class Client {
	public static void main(String[] args) {
		int channel=2;
		TV myTV=new TV();
		Command onCommand=new CommandOn(myTV);
		Command offCommand=new CommandOff(myTV);
		Command changeChannel=new CommandChange(myTV, channel);
		Control control=new Control(onCommand, offCommand, changeChannel);
		control.turnOn();
		control.changeChannel();
		control.turnOff();
	}
}
