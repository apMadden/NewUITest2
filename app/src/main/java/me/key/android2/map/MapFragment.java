package me.key.android2.map;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import me.key.android2.Constants;
import me.key.android2.KeyMeFragment;

/**
 * Created by Andy on 3/14/2017.
 */

public class MapFragment extends KeyMeFragment {
    public static final String TAG = MapFragment.class.getSimpleName();


    public static MapFragment newInstance(long id, boolean useTransition, String transitionName) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putLong(Constants.ARTIST_ID, id);
        args.putBoolean("transition", useTransition);
        if (useTransition)
            args.putString("transition_name", transitionName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //artistID = getArguments().getLong(Constants.ARTIST_ID);
        }
    }
}
