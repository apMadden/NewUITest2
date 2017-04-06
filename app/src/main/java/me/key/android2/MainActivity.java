package me.key.android2;

import android.Manifest;
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
        action = getIntent().getAction();
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();

        navigationMap.put(Constants.NAVIGATE_KEYCHAIN, R.id.navigation_keychain);
        navigationMap.put(Constants.NAVIGATE_MAP, R.id.navigation_map);
        navigationMap.put(Constants.NAVIGATE_PROFILE, R.id.navigation_profile);

// get our folding cell

        binding.setKeyChainViewModel(keyChainViewModel);

        if (Utils.isMarshmallow()) {
            checkPermissionAndThenLoad();
        } else {
            loadEverything();
        }

        keySingleCardViewModels = new ArrayList<>();
        for(int i=0; i< KEY_NAMES.length;i++) {
            keySingleCardViewModels.add(new KeySingleCardViewModel(getApplicationContext().getDrawable(KEY_IMAGES[i]), KEY_NAMES[i], 12, KEY_CARD_COLORS[i], i, this));
        }
        keyGroupCardViewModels = new ArrayList<>();
        keyGroupCardViewModels.add(new KeyGroupCardViewModel("Bleeker Street Apartments", keySingleCardViewModels, this));
        keyChainViewModel = new KeyChainViewModel("", new LoginCardViewModel("", this), promoImageUrls, keySingleCardViewModels, keyGroupCardViewModels, this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.executePendingBindings();
        //initializeFragment(savedInstanceState);
    }

    Handler navDrawerRunnable = new Handler();
    Runnable runnable;

    public Runnable loadFragment(String fragmentTag) {
        return loadFragment(navigationMap.get(fragmentTag));
    }

    public Runnable loadFragment(final int menuItem) {
        runnable = null;
        final KeyMeFragment fragment;

        switch (menuItem) {
            case R.id.navigation_keychain:
                binding.navigation.setSelected(true);
                mTextMessage.setText(R.string.title_home);
                fragment = new KeyChainFragment();
                break;
            case R.id.navigation_map:
                binding.navigation.setSelected(true);
                mTextMessage.setText(R.string.title_map);
                fragment = new MapFragment();
                break;
            case R.id.navigation_profile:
                mTextMessage.setText(R.string.title_profile);
                fragment = new ProfileFragment();
                break;
            default:
                return null;
        }
        return new Runnable() {
            public void run() {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.hide(getSupportFragmentManager().findFragmentById(R.id.fragment_container));
                transaction.replace(R.id.fragment_container, fragment).commit();

            }
        };

    }

    /*
    Runnable navigateNowplaying = new Runnable() {
        public void run() {
            navigateLibrary.run();
            startActivity(new Intent(MainActivity.this, NowPlayingActivity.class));
        }
    };*/
    private void loadEverything() {
        loadFragment(action);
    }
    private void checkPermissionAndThenLoad() {
        //check for permission
        if (Nammu.checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
            loadEverything();
        } else {
            if (Nammu.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Snackbar.make(binding.navigation, "Timber will need to read external storage to display songs on your device.",
                        Snackbar.LENGTH_INDEFINITE)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Nammu.askForPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE, permissionReadstorageCallback);
                            }
                        }).show();
            } else {
                Nammu.askForPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE, permissionReadstorageCallback);
            }
        }
    }

    final PermissionCallback permissionReadstorageCallback = new PermissionCallback() {
        @Override
        public void permissionGranted() {
            loadEverything();
        }

        @Override
        public void permissionRefused() {
            finish();
        }
    };
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
        loadFragment(item.getItemId());
        /*
        switch (item.getItemId()) {
            case R.id.navigation_home:
                binding.navigation.setSelected(true);
                loadFragment(KeyChainFragment.TAG);
                mTextMessage.setText(R.string.title_home);
                return true;
            case R.id.navigation_dashboard:
                binding.navigation.setSelected(true);
                mTextMessage.setText(R.string.title_map);
                return true;
            case R.id.navigation_notifications:
                mTextMessage.setText(R.string.title_profile);
                return true;
        }*/
        return false;
    }
    /**
     * Used to handle result of askForPermission for Contacts Permission, in better way than
     * onRequestPermissionsResult() and handling with big switch statement
     */
    final PermissionCallback permissionContactsCallback = new PermissionCallback() {
        @Override public void permissionGranted() {
            boolean hasAccess = PermissionTools.accessContacts(MainActivity.this);
            Toast.makeText(MainActivity.this, "Access granted = " + hasAccess, Toast.LENGTH_SHORT).show();
        }

        @Override public void permissionRefused() {
            boolean hasAccess = PermissionTools.accessContacts(MainActivity.this);
            Toast.makeText(MainActivity.this, "Access granted = " + hasAccess, Toast.LENGTH_SHORT).show();
        }
    };

    /**
     * Used to handle result of askForPermission for Location, in better way than
     * onRequestPermissionsResult() and handling with big switch statement
     */
    final PermissionCallback permissionLocationCallback = new PermissionCallback() {
        @Override public void permissionGranted() {
            boolean hasAccess = PermissionTools.accessLocation(MainActivity.this);
            Toast.makeText(MainActivity.this, "Access granted = " + hasAccess, Toast.LENGTH_SHORT).show();
        }

        @Override public void permissionRefused() {
            boolean hasAccess = PermissionTools.accessLocation(MainActivity.this);
            Toast.makeText(MainActivity.this, "Access granted = " + hasAccess, Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    public void onRequestPermissionsResult(
            int requestCode, String[] permissions, int[] grantResults) {
        Nammu.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    private void addBackstackListener() {
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                getSupportFragmentManager().findFragmentById(R.id.fragment_container).onResume();
            }
        });
    }
}
