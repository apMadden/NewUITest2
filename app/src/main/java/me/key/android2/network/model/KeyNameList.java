package me.key.android2.network.model;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class KeyNameList implements JSONFromServer {

    public String data[];
    private String object = "";

    @Override
    public KeyNameList preProcess() {
//		if (data == null)
//			data = new ArrayList<HistoryItem>();
//		for (int i = 0; i < data.size(); i++)
//			data.get(i).preProcess();

        return this;
    }

//	public static class HistoryListWrapper implements JSONFromServer {
//		
//		public HistoryItem item;
//
//		@Override
//		public HistoryListWrapper preProcess() {
//			if (item != null)
//				item.preProcess();
//			
//			return this;
//		}
//	}

}
