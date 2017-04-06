package me.key.android2.keychain;

import android.os.Bundle;

import me.key.android2.Constants;
import me.key.android2.KeyMeFragment;

/**
 * Created by Andy on 4/6/2017.
 */

public class KeyChainFragment extends KeyMeFragment {
    public static final String TAG = KeyChainFragment.class.getSimpleName();


    public static KeyChainFragment newInstance(long id, boolean useTransition, String transitionName) {
        KeyChainFragment fragment = new KeyChainFragment();
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
