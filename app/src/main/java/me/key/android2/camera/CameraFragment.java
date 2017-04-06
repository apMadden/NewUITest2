package me.key.android2.camera;

import android.os.Bundle;

import me.key.android2.Constants;
import me.key.android2.KeyMeFragment;

/**
 * Created by Andy on 3/23/2017.
 */

public class CameraFragment extends KeyMeFragment{
    public static final String TAG = CameraFragment.class.getSimpleName();


    public static CameraFragment newInstance(long id, boolean useTransition, String transitionName) {
        CameraFragment fragment = new CameraFragment();
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
