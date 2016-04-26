package com.design.command;

public class Control {
	private Command onCommand;
	private Command offCommand;
	private Command changeChannel;
	public Control(Command onCommand,
			Command offCommand,Command changeChannel){
		this.onCommand=onCommand;
		this.offCommand=offCommand;
		this.changeChannel=changeChannel;
	}
	public void turnOn(){
		onCommand.execute();
	}
	public void turnOff(){
		offCommand.execute();
	}
	public void changeChannel(){
		changeChannel.execute();
	}
}
