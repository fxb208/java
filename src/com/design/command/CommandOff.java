package com.design.command;

public class CommandOff implements Command{
	private TV myTV;
	public CommandOff(TV myTV){
		this.myTV=myTV;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.myTV.turnOff();
	}
}
