package com.design.command;

public class CommandChange implements Command{
	private TV myTV;
	private int channel;
	public CommandChange(TV myTV,int channel){
		this.myTV=myTV;
		this.channel=channel;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		myTV.changeChannel(channel);
	}
	
}
