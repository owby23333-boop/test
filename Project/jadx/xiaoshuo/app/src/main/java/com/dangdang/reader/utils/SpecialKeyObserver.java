package com.dangdang.reader.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.yuewen.h8;

/* JADX INFO: loaded from: classes10.dex */
public class SpecialKeyObserver {
    private Context mContext;
    private HomeKeyBroadcastReceiver mHomeKeyReceiver;
    private IntentFilter mIntentFilter;
    private OnHomeKeyListener mOnHomeKeyListener;
    private OnPowerKeyListener mOnPowerKeyListener;
    private PowerKeyBroadcastReceiver mPowerKeyReceiver;

    public class HomeKeyBroadcastReceiver extends BroadcastReceiver {
        final String SYSTEM_DIALOG_REASON_KEY = h8.d;
        final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
        final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";

        public HomeKeyBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (!intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") || (stringExtra = intent.getStringExtra(h8.d)) == null || SpecialKeyObserver.this.mOnHomeKeyListener == null) {
                return;
            }
            if (stringExtra.equals("homekey")) {
                SpecialKeyObserver.this.mOnHomeKeyListener.onHomeKeyPressed();
            } else if (stringExtra.equals("recentapps")) {
                SpecialKeyObserver.this.mOnHomeKeyListener.onHomeKeyLongPressed();
            }
        }
    }

    public interface OnHomeKeyListener {
        void onHomeKeyLongPressed();

        void onHomeKeyPressed();
    }

    public interface OnPowerKeyListener {
        void onPowerKeyPressed(boolean z);
    }

    public class PowerKeyBroadcastReceiver extends BroadcastReceiver {
        public PowerKeyBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (SpecialKeyObserver.this.mOnPowerKeyListener != null) {
                String action = intent.getAction();
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    SpecialKeyObserver.this.mOnPowerKeyListener.onPowerKeyPressed(false);
                } else if (action.equals("android.intent.action.SCREEN_ON")) {
                    SpecialKeyObserver.this.mOnPowerKeyListener.onPowerKeyPressed(true);
                }
            }
        }
    }

    public SpecialKeyObserver(Context context) {
        this.mContext = context;
    }

    public void setHomeKeyListener(OnHomeKeyListener onHomeKeyListener) {
        this.mOnHomeKeyListener = onHomeKeyListener;
    }

    public void setPowerKeyListener(OnPowerKeyListener onPowerKeyListener) {
        this.mOnPowerKeyListener = onPowerKeyListener;
    }

    public void startHomeListener() {
        this.mIntentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        HomeKeyBroadcastReceiver homeKeyBroadcastReceiver = new HomeKeyBroadcastReceiver();
        this.mHomeKeyReceiver = homeKeyBroadcastReceiver;
        this.mContext.registerReceiver(homeKeyBroadcastReceiver, this.mIntentFilter);
    }

    public void startPowerListener() {
        IntentFilter intentFilter = new IntentFilter();
        this.mIntentFilter = intentFilter;
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.mIntentFilter.addAction("android.intent.action.SCREEN_ON");
        PowerKeyBroadcastReceiver powerKeyBroadcastReceiver = new PowerKeyBroadcastReceiver();
        this.mPowerKeyReceiver = powerKeyBroadcastReceiver;
        this.mContext.registerReceiver(powerKeyBroadcastReceiver, this.mIntentFilter);
    }

    public void stopHomeListener() {
        HomeKeyBroadcastReceiver homeKeyBroadcastReceiver = this.mHomeKeyReceiver;
        if (homeKeyBroadcastReceiver != null) {
            this.mContext.unregisterReceiver(homeKeyBroadcastReceiver);
            this.mHomeKeyReceiver = null;
        }
    }

    public void stopPowerListener() {
        PowerKeyBroadcastReceiver powerKeyBroadcastReceiver = this.mPowerKeyReceiver;
        if (powerKeyBroadcastReceiver != null) {
            this.mContext.unregisterReceiver(powerKeyBroadcastReceiver);
            this.mPowerKeyReceiver = null;
        }
    }
}
