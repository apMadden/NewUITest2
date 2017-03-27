package me.key.android2;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


import me.key.android2.databinding.ActivityMainBinding;
import me.key.android2.keychain.KeyChainViewModel;
import me.key.android2.keychain.KeyChainViewModelInterface;
import me.key.android2.keychain.viewmodels.KeyGroupCardViewModel;
import me.key.android2.keychain.viewmodels.KeySingleCardViewModel;
import me.key.android2.keychain.viewmodels.LoginCardViewModel;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, KeyChainViewModelInterface {

    public static final String TAG = MainActivity.class.getSimpleName();

    /**
     * Bundle key representing the Active Fragment
     */
    private static final String STATE_ACTIVE_FRAGMENT = "active_fragment";
    private TextView mTextMessage;
    private Fragment mFragment;
    private ActivityMainBinding binding;
    private KeyChainViewModel keyChainViewModel;
    ArrayList<String> promoImageUrls;
    ArrayList<KeySingleCardViewModel> keySingleCardViewModels;
    ArrayList<KeyGroupCardViewModel> keyGroupCardViewModels;
    String KEY_NAMES[] = {"Mom's house", "Home", "Work", "Front Door", "back door"};
    int KEY_IMAGES[] = {R.drawable.key_head_blue, R.drawable.key_head_green, R.drawable.key_head_orange, R.drawable.key_head_purple, R.drawable.key_head_teal};
    int KEY_CARD_COLORS[] = {R.color.rob_blue, R.color.rob_green, R.color.rob_orange, R.color.rob_purple, R.color.rob_teal};
    //int ICONS[] = {R.drawable.ic_home_black_24dp, R.drawable.ic_map_black_24dp, R.drawable.ic_store_black_24dp, R.drawable.ic_shopping_cart_black_24dp, R.drawable.ic_account_box_black_24dp, R.drawable.ic_help_black_24dp, R.drawable.ic_build_black_24dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        keySingleCardViewModels = new ArrayList<>();
        for(int i=0; i< KEY_NAMES.length;i++) {
            keySingleCardViewModels.add(new KeySingleCardViewModel(getApplicationContext().getDrawable(KEY_IMAGES[i]), KEY_NAMES[i], 12, KEY_CARD_COLORS[i]));
        }
        keyGroupCardViewModels = new ArrayList<>();
        keyGroupCardViewModels.add(new KeyGroupCardViewModel("Bleeker Street Apartments", keySingleCardViewModels, this));
        keyChainViewModel = new KeyChainViewModel("", new LoginCardViewModel("", this), promoImageUrls, keySingleCardViewModels, keyGroupCardViewModels, this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setKeyChainViewModel(keyChainViewModel);
        binding.executePendingBindings();
        //initializeFragment(savedInstanceState);
    }

    public void expandButtonPressed(View v) {
        Log.i(TAG, "expandButtonPressed: 1");
        keyGroupCardViewModels.get(0).toggleExpand(v.getRootView().findViewById(R.id.cv_keychain_single_key_temp));
    }
    public void handleLoginButtonPressed(View v) {

    }

    private void initializeFragment(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mFragment = (Fragment) getSupportFragmentManager().getFragment(savedInstanceState, STATE_ACTIVE_FRAGMENT);
        }
        if (mFragment == null) {
            //mFragment = new KeyChainFragment();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        //fragmentManager.beginTransaction().replace(R.id.content,                mFragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                mTextMessage.setText(R.string.title_home);
                return true;
            case R.id.navigation_dashboard:
                mTextMessage.setText(R.string.title_map);
                return true;
            case R.id.navigation_notifications:
                mTextMessage.setText(R.string.title_profile);
                return true;
        }
        return false;
    }

}
