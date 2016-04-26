package com.design.build;

public class Mingong implements Builder{
	private String window;
	private String floor;
	private Room room;
	@Override
	public void makeWindow() {
		// TODO Auto-generated method stub
		System.out.println("创建window");
		this.window=new String("window");
	}

	@Override
	public void makeFloor() {
		// TODO Auto-generated method stub
		System.out.println("创建floor");
		this.floor=new String("floor");
	}

	@Override
	public Room getRoom() {
		// TODO Auto-generated method stub
		Room room= new Room();
	    room.setFloor(floor);
	    room.setWindow(window);
	    return room;
	}

}
