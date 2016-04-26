package com.design.command;

public class CommandOn implements Command{
	private TV myTV;
	public CommandOn(TV myTV){
		this.myTV=myTV;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		myTV.turnOn();
	}

}
