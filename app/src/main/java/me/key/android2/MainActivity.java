package me.key.android2;

import android.Manifest;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.IntegerRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import me.key.android2.camera.Camera2Activity;
import me.key.android2.databinding.ActivityMainBinding;
import me.key.android2.keychain.KeyChainFragment;
import me.key.android2.keychain.KeyChainViewModel;
import me.key.android2.keychain.KeyChainViewModelInterface;
import me.key.android2.keychain.viewmodels.KeyGroupCardViewModel;
import me.key.android2.keychain.viewmodels.KeySingleCardViewModel;
import me.key.android2.keychain.viewmodels.LoginCardViewModel;
import me.key.android2.map.MapFragment;
import me.key.android2.profile.ProfileFragment;
import pl.tajchert.nammu.Nammu;
import pl.tajchert.nammu.PermissionCallback;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, KeyChainViewModelInterface {

    public static final String TAG = MainActivity.class.getSimpleName();
    private static MainActivity sMainActivity;
    Map<String, Integer> navigationMap = new HashMap<>();
    Map<String, KeyMeFragment> fragMap = new HashMap<String, KeyMeFragment>();
    /**
     * Bundle key representing the Active Fragment
     */
    private static final String STATE_ACTIVE_FRAGMENT = "active_fragment";
    private TextView mTextMessage;
    private Fragment mFragment;
    private ActivityMainBinding binding;
    private KeyChainViewModel keyChainViewModel;

    String action;
    ArrayList<String> promoImageUrls;
    ArrayList<KeySingleCardViewModel> keySingleCardViewModels;
    ArrayList<KeyGroupCardViewModel> keyGroupCardViewModels;
    String KEY_NAMES[] = {"Mom's house", "Home", "Work", "Front Door", "back door"};
    int KEY_IMAGES[] = {R.drawable.key_head_blue, R.drawable.key_head_green, R.drawable.key_head_orange, R.drawable.key_head_purple, R.drawable.key_head_teal};
    int KEY_CARD_COLORS[] = {R.color.rob_blue, R.color.rob_green, R.color.rob_orange, R.color.rob_purple, R.color.rob_teal};
    //int ICONS[] = {R.drawable.ic_home_black_24dp, R.drawable.ic_map_black_24dp, R.drawable.ic_store_black_24dp, R.drawable.ic_shopping_cart_black_24dp, R.drawable.ic_account_box_black_24dp, R.drawable.ic_help_black_24dp, R.drawable.ic_build_black_24dp};

    public static MainActivity getInstance() {
        return sMainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sMainActivity = this;
        Log.i(TAG, "onCreate: HUHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH                       a");
        action = getIntent().getAction();
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        keySingleCardViewModels = new ArrayList<>();
        for(int i=0; i< KEY_NAMES.length;i++) {
            keySingleCardViewModels.add(new KeySingleCardViewModel(getApplicationContext().getDrawable(KEY_IMAGES[i]), KEY_NAMES[i], 12, KEY_CARD_COLORS[i], i, this));
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
    public void handleCardFlip(View v) {
        Log.i(TAG, "expandButtonPressed: 1");
        //((com.ramotion.foldingcell.FoldingCell)v).position.get().toggle((v.getRootView().findViewById(R.id.cv_keychain_single_key_temp));
    }
    public void handleLoginButtonPressed(View v) {

    }
    public void cardLogInClick(View v) {
        startActivity(new Intent(this, Camera2Activity.class));
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_keychain:
                binding.navigation.setSelected(true);
                //loadFragment(KeyChainFragment.TAG);
                mTextMessage.setText(R.string.title_home);
                return true;
            case R.id.navigation_map:
                binding.navigation.setSelected(true);
                mTextMessage.setText(R.string.title_map);
                return true;
            case R.id.navigation_profile:
                mTextMessage.setText("CAMERA");
                return true;
        }
        return false;
    }
}
