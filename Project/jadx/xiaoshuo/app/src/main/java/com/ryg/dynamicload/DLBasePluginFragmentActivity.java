package com.ryg.dynamicload;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.loader.app.LoaderManager;
import com.ryg.dynamicload.internal.DLIntent;
import com.ryg.dynamicload.internal.DLPluginManager;
import com.ryg.dynamicload.internal.DLPluginPackage;
import com.ryg.utils.DLConstants;

/* JADX INFO: loaded from: classes3.dex */
public class DLBasePluginFragmentActivity extends FragmentActivity implements DLPlugin {
    private static final String TAG = "DLBasePluginFragmentActivity";
    protected int mFrom = 0;
    protected DLPluginManager mPluginManager;
    protected DLPluginPackage mPluginPackage;
    protected FragmentActivity mProxyActivity;
    protected FragmentActivity that;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.mFrom == 0) {
            super.addContentView(view, layoutParams);
        } else {
            this.mProxyActivity.addContentView(view, layoutParams);
        }
    }

    @Override // com.ryg.dynamicload.DLPlugin
    public void attach(Activity activity, DLPluginPackage dLPluginPackage) {
        Log.d(TAG, "attach: proxyActivity= " + activity);
        FragmentActivity fragmentActivity = (FragmentActivity) activity;
        this.mProxyActivity = fragmentActivity;
        this.that = fragmentActivity;
        this.mPluginPackage = dLPluginPackage;
    }

    public int bindPluginService(DLIntent dLIntent, ServiceConnection serviceConnection, int i) {
        if (this.mFrom == 1 && dLIntent.getPluginPackage() == null) {
            dLIntent.setPluginPackage(this.mPluginPackage.packageName);
        }
        return this.mPluginManager.bindPluginService(this.that, dLIntent, serviceConnection, i);
    }

    @Override // android.app.Activity
    public View findViewById(int i) {
        return this.mFrom == 0 ? super.findViewById(i) : this.mProxyActivity.findViewById(i);
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.mFrom == 0) {
            super.finish();
        } else {
            this.mProxyActivity.finish();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        if (this.mFrom == 0) {
            return super.getApplicationContext();
        }
        Application application = this.mPluginPackage.pluginApplication;
        return application != null ? application : this.mProxyActivity.getApplicationContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        return this.mFrom == 0 ? super.getClassLoader() : this.mProxyActivity.getClassLoader();
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        return this.mFrom == 0 ? super.getIntent() : this.mProxyActivity.getIntent();
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        return this.mFrom == 0 ? super.getLayoutInflater() : this.mProxyActivity.getLayoutInflater();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return this.mFrom == 0 ? super.getMenuInflater() : this.mProxyActivity.getMenuInflater();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        return this.mFrom == 0 ? super.getPackageName() : this.mPluginPackage.packageName;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.mFrom == 0 ? super.getResources() : this.mProxyActivity.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return this.mFrom == 0 ? super.getSharedPreferences(str, i) : this.mProxyActivity.getSharedPreferences(str, i);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public FragmentManager getSupportFragmentManager() {
        return this.mFrom == 0 ? super.getSupportFragmentManager() : this.mProxyActivity.getSupportFragmentManager();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public LoaderManager getSupportLoaderManager() {
        return this.mFrom == 0 ? super.getSupportLoaderManager() : this.mProxyActivity.getSupportLoaderManager();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        return this.mFrom == 0 ? super.getSystemService(str) : this.mProxyActivity.getSystemService(str);
    }

    @Override // android.app.Activity
    public Window getWindow() {
        return this.mFrom == 0 ? super.getWindow() : this.mProxyActivity.getWindow();
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        return this.mFrom == 0 ? super.getWindowManager() : this.mProxyActivity.getWindowManager();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.mFrom == 0) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mFrom == 0) {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.mFrom = bundle.getInt(DLConstants.FROM, 0);
        }
        if (this.mFrom == 0) {
            super.onCreate(bundle);
            this.mProxyActivity = this;
            this.that = this;
        }
        this.mPluginManager = DLPluginManager.getInstance(this.that);
        StringBuilder sb = new StringBuilder("onCreate: from= ");
        sb.append(this.mFrom == 0 ? "DLConstants.FROM_INTERNAL" : "FROM_EXTERNAL");
        Log.d(TAG, sb.toString());
    }

    @Override // android.app.Activity, com.ryg.dynamicload.DLPlugin
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.mFrom == 0) {
            return super.onCreateOptionsMenu(menu);
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mFrom == 0) {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback, com.ryg.dynamicload.DLPlugin
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.mFrom == 0) {
            return super.onKeyUp(i, keyEvent);
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        if (this.mFrom == 0) {
            super.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity, com.ryg.dynamicload.DLPlugin
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.mFrom == 0) {
            return onOptionsItemSelected(menuItem);
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        if (this.mFrom == 0) {
            super.onPause();
        }
    }

    @Override // android.app.Activity, com.ryg.dynamicload.DLPlugin
    public void onRestart() {
        if (this.mFrom == 0) {
            super.onRestart();
        }
    }

    @Override // android.app.Activity, com.ryg.dynamicload.DLPlugin
    public void onRestoreInstanceState(Bundle bundle) {
        if (this.mFrom == 0) {
            super.onRestoreInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        if (this.mFrom == 0) {
            super.onResume();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.mFrom == 0) {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        if (this.mFrom == 0) {
            super.onStart();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        if (this.mFrom == 0) {
            super.onStop();
        }
    }

    @Override // android.app.Activity, com.ryg.dynamicload.DLPlugin
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mFrom == 0) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.ryg.dynamicload.DLPlugin
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        if (this.mFrom == 0) {
            super.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback, com.ryg.dynamicload.DLPlugin
    public void onWindowFocusChanged(boolean z) {
        if (this.mFrom == 0) {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        if (this.mFrom == 0) {
            super.sendBroadcast(intent);
            return;
        }
        FragmentActivity fragmentActivity = this.that;
        if (fragmentActivity != null) {
            fragmentActivity.sendBroadcast(intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        if (this.mFrom == 0) {
            super.setContentView(view);
        } else {
            this.mProxyActivity.setContentView(view);
        }
    }

    public int startPluginActivity(DLIntent dLIntent) {
        return startPluginActivityForResult(dLIntent, -1);
    }

    public int startPluginActivityForResult(DLIntent dLIntent, int i) {
        if (this.mFrom == 1 && dLIntent.getPluginPackage() == null) {
            dLIntent.setPluginPackage(this.mPluginPackage.packageName);
        }
        return this.mPluginManager.startPluginActivityForResult(this.that, dLIntent, i);
    }

    public int startPluginService(DLIntent dLIntent) {
        if (this.mFrom == 1 && dLIntent.getPluginPackage() == null) {
            dLIntent.setPluginPackage(this.mPluginPackage.packageName);
        }
        return this.mPluginManager.startPluginService(this.that, dLIntent);
    }

    public int unBindPluginService(DLIntent dLIntent, ServiceConnection serviceConnection) {
        if (this.mFrom == 1 && dLIntent.getPluginPackage() == null) {
            dLIntent.setPluginPackage(this.mPluginPackage.packageName);
        }
        return this.mPluginManager.unBindPluginService(this.that, dLIntent, serviceConnection);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.mFrom == 0) {
            super.setContentView(view, layoutParams);
        } else {
            this.mProxyActivity.setContentView(view, layoutParams);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        if (this.mFrom == 0) {
            super.setContentView(i);
        } else {
            this.mProxyActivity.setContentView(i);
        }
    }
}
