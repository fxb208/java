package com.watch;

import java.util.ArrayList;
import java.util.List;

public class Transporter implements Watched{
	List<Watcher> watchers=new ArrayList<>();
	@Override
	public void addWatcher(Watcher watcher) {
		// TODO Auto-generated method stub
		this.watchers.add(watcher);
	}

	@Override
	public void removeWatcher(Watcher watcher) {
		// TODO Auto-generated method stub
		this.watchers.remove(watcher);
	}

	@Override
	public void notifyWatchers() {
		// TODO Auto-generated method stub
		for(Watcher watcher:watchers){
			watcher.update();
		}
	}

}
