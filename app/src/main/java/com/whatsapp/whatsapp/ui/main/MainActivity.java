package com.whatsapp.whatsapp.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.whatsapp.whatsapp.R;
import com.whatsapp.whatsapp.databinding.ActivityMainBinding;
import com.whatsapp.whatsapp.ui.main.calls.CallsFragment;
import com.whatsapp.whatsapp.ui.main.chats.ChatsFragment;
import com.whatsapp.whatsapp.ui.main.status.StatusFragment;
import com.whatsapp.whatsapp.utils.OnTabSelectedListener;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private ActivityMainBinding mBinding;
    private FloatingActionButton mFab;
    private MainViewModel mViewModel;
    private int mScreenIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setSupportActionBar(mBinding.toolbar);
        init();
        listener();
        setTabs();
    }

    private void init() {
        mContext = this;
        mFab = mBinding.fab;
        mViewModel.getScreenIndex().observe(this, index -> this.mScreenIndex = index);
    }

    private void listener() {

        mFab.setOnClickListener(v -> {
            switch (mScreenIndex) {
                case 1:
                    onStatus(v);
                    break;
                case 2:
                    onIncomingCall(v);
                    break;
                default:
                    onChat(v);
            }
        });

        mBinding.tabLayout.addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mScreenIndex = tab.getPosition();
                mViewModel.setScreenIndex(tab.getPosition());
                switch (mScreenIndex) {
                    case 1:
                        mFab.setImageIcon(Icon.createWithResource(mContext, R.drawable.ic_camera));
                        break;
                    case 2:
                        mFab.setImageIcon(Icon.createWithResource(mContext, R.drawable.ic_incoming_call));
                        break;
                    default:
                        mFab.setImageIcon(Icon.createWithResource(mContext, R.drawable.ic_message));
                }
            }
        });
    }

    private void onChat(View view) {
        showSnackBar(view, "Chat screen running...");
    }

    private void onStatus(View view) {
        showSnackBar(view, "Status screen running...");
    }

    private void onIncomingCall(View view) {
        showSnackBar(view, "Incoming call screen running...");
    }

    private void showSnackBar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).setAction("Done", null).show();
    }

    private void setTabs() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(ChatsFragment.newInstance(), getResources().getString(R.string.title_chats));
        adapter.addFragment(StatusFragment.newInstance(), getResources().getString(R.string.title_status));
        adapter.addFragment(CallsFragment.newInstance(), getResources().getString(R.string.title_calls));
        ViewPager viewPager = mBinding.viewPager;
        viewPager.setAdapter(adapter);
        TabLayout tabs = mBinding.tabLayout;
        tabs.setupWithViewPager(viewPager);
    }

    private void setTabIcon(TabLayout.Tab tab, @DrawableRes int icon) {
        if (tab != null) {
            tab.setIcon(icon);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {

        getMenuInflater().inflate(R.menu.home_screen_menu, menu);

        mViewModel.getScreenIndex().observe(this, index -> {
            if (index == 1) {
                menu.findItem(R.id.action_new_group).setVisible(false);
                menu.findItem(R.id.action_new_broadcast).setVisible(false);
                menu.findItem(R.id.action_linked_devices).setVisible(false);
                menu.findItem(R.id.action_starred_messages).setVisible(false);
                menu.findItem(R.id.action_status_privacy).setVisible(true);
                menu.findItem(R.id.action_clear_call_log).setVisible(false);
            } else if (index == 2) {
                menu.findItem(R.id.action_new_group).setVisible(false);
                menu.findItem(R.id.action_new_broadcast).setVisible(false);
                menu.findItem(R.id.action_linked_devices).setVisible(false);
                menu.findItem(R.id.action_starred_messages).setVisible(false);
                menu.findItem(R.id.action_status_privacy).setVisible(false);
                menu.findItem(R.id.action_clear_call_log).setVisible(true);
            } else {
                menu.findItem(R.id.action_new_group).setVisible(true);
                menu.findItem(R.id.action_new_broadcast).setVisible(true);
                menu.findItem(R.id.action_linked_devices).setVisible(true);
                menu.findItem(R.id.action_starred_messages).setVisible(true);
                menu.findItem(R.id.action_status_privacy).setVisible(false);
                menu.findItem(R.id.action_clear_call_log).setVisible(false);
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                onSearch();
                return true;
            case R.id.action_new_group:
                onCreateNewGroup();
                return true;
            case R.id.action_new_broadcast:
                onCreateNewBroadcast();
                return true;
            case R.id.action_linked_devices:
                onLinkedDevices();
                return true;
            case R.id.action_starred_messages:
                onStarredMessages();
                return true;
            case R.id.action_status_privacy:
                onStatusPrivacy();
                return true;
            case R.id.action_clear_call_log:
                onClearCallLog();
                return true;
            case R.id.action_settings:
                onSettings();
                return true;
            default:
                return false;
        }
    }

    private void onSearch() {

    }

    private void onCreateNewGroup() {

    }

    private void onCreateNewBroadcast() {

    }

    private void onLinkedDevices() {

    }

    private void onStarredMessages() {

    }

    private void onStatusPrivacy() {

    }

    private void onClearCallLog() {

    }

    private void onSettings() {

    }
}