package me.key.android2.network.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import me.key.android.net.NetworkRequest.JSONFromServer;

public class StyleCategoryList implements JSONFromServer {

    public List<StyleCategoryItem> data;
    private String object = "";
    public String id;

    public StyleCategoryList() {

    }

    public StyleCategoryList(HashSet<StyleCategoryItem> hash) {
        data = new ArrayList<StyleCategoryItem>(hash);
    }

    public StyleCategoryList(ArrayList<StyleCategoryItem> arrayList) {
        data = arrayList;
    }

    @Override
    public StyleCategoryList preProcess() {
        if (data == null)
            data = new ArrayList<StyleCategoryItem>();
        for (int i = 0; i < data.size(); i++)
            data.get(i).preProcess();

        return this;
    }

}
