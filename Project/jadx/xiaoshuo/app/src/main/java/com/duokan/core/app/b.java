package com.duokan.core.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.duokan.core.app.AppWrapper;
import com.duokan.core.sys.BasicInflater;
import com.yuewen.dr1;
import com.yuewen.w01;
import com.yuewen.x01;
import com.yuewen.xv1;
import com.yuewen.y31;
import java.io.File;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes12.dex */
public class b extends Application implements xv1, ViewModelStoreOwner {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final long COLD_START_TIME = 600;
    private static b mSingleton;
    private Configuration mOverrideConfiguration;
    private Resources mResources;
    private ViewModelStore viewModelStore;
    private final CopyOnWriteArrayList<a> mActivityResultListeners = new CopyOnWriteArrayList<>();
    private final x01 mFeatureSet = new x01();
    private dr1 mInflaters = new dr1();
    protected float mSystemFontScale = 1.0f;
    private final AtomicBoolean isWebPage = new AtomicBoolean(false);

    public interface a {
        void onActivityResult(Activity activity, int i, int i2, Intent intent);
    }

    @TargetApi(14)
    public b() {
        mSingleton = this;
        if (AppWrapper.v() == null) {
            new AppWrapper(this);
        }
    }

    public static b get() {
        return mSingleton;
    }

    public void addOnActivityResultListener(a aVar) {
        this.mActivityResultListeners.addIfAbsent(aVar);
    }

    @Override // com.yuewen.xv1
    public void applyOverrideConfiguration(Configuration configuration) {
        if (this.mResources != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.mOverrideConfiguration != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.mOverrideConfiguration = new Configuration(configuration);
    }

    public boolean forCommunity() {
        return false;
    }

    public String getAppName() {
        return y31.f20204a;
    }

    public String getChannelAppName() {
        return "";
    }

    public File getDiagnosticDirectory() {
        return AppWrapper.v().z();
    }

    public Class<? extends Activity> getHomeActivityClass() {
        return null;
    }

    @Override // com.yuewen.xv1
    @AnyThread
    public LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater;
        dr1 dr1Var = this.mInflaters;
        LayoutInflater layoutInflater2 = dr1Var.f10324a;
        if (layoutInflater2 != null) {
            return layoutInflater2;
        }
        LayoutInflater layoutInflater3 = (LayoutInflater) super.getSystemService("layout_inflater");
        if (dr1Var.f10325b == layoutInflater3 && (layoutInflater = dr1Var.c) != null) {
            return layoutInflater;
        }
        dr1 dr1Var2 = new dr1();
        dr1Var2.f10325b = layoutInflater3;
        if (layoutInflater3 != null) {
            dr1Var2.c = layoutInflater3.cloneInContext(this);
        } else {
            dr1Var2.c = new BasicInflater(this);
        }
        this.mInflaters = dr1Var2;
        return dr1Var2.c;
    }

    public Class<? extends Activity> getMainActivityClass() {
        return null;
    }

    @Override // com.yuewen.xv1
    public Configuration getOverrideConfiguration() {
        return this.mOverrideConfiguration;
    }

    public Class<? extends Activity> getReaderActivityClass() {
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.mResources == null) {
            Configuration configuration = this.mOverrideConfiguration;
            if (configuration == null) {
                this.mResources = super.getResources();
            } else {
                this.mResources = createConfigurationContext(configuration).getResources();
            }
        }
        return this.mResources;
    }

    public float getSystemFontScale() {
        return this.mSystemFontScale;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(@NonNull String str) {
        return "layout_inflater".equals(str) ? getLayoutInflater() : super.getSystemService(str);
    }

    public Locale getUserChosenLocale() {
        return null;
    }

    public int getVersionCode() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 16384).versionCode;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public String getVersionName() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 16384).versionName;
        } catch (Throwable unused) {
            return "1.7.0";
        }
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        return this.viewModelStore;
    }

    public boolean inCtaMode() {
        return false;
    }

    public boolean isCameraPermissionConfirmed() {
        return false;
    }

    public final boolean isDebuggable() {
        return AppWrapper.v().M();
    }

    public boolean isShowingWelcome() {
        return false;
    }

    public boolean isWebAccessConfirmed() {
        return false;
    }

    public boolean isWebAccessEnabled() {
        return false;
    }

    public boolean isWebPage() {
        return this.isWebPage.get();
    }

    public Context noDensityScaleContext(Context context) {
        return context;
    }

    public final void onActivityResult(ManagedActivity managedActivity, int i, int i2, Intent intent) {
        Iterator<a> it = this.mActivityResultListeners.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(managedActivity, i, i2, intent);
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        this.viewModelStore = new ViewModelStore();
    }

    public void onRunningStateChanged(AppWrapper.RunningState runningState, AppWrapper.RunningState runningState2) {
    }

    @Override // com.yuewen.xv1
    public <T extends w01> T queryFeature(Class<T> cls) {
        return (T) queryLocalFeature(cls);
    }

    @Override // com.yuewen.xv1
    public <T extends w01> T queryLocalFeature(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        return (T) this.mFeatureSet.b(cls);
    }

    @Override // com.yuewen.xv1
    public boolean registerGlobalFeature(w01 w01Var) {
        return this.mFeatureSet.c(w01Var);
    }

    @Override // com.yuewen.xv1
    public boolean registerLocalFeature(w01 w01Var) {
        return this.mFeatureSet.c(w01Var);
    }

    public void removeOnActivityResultListener(a aVar) {
        this.mActivityResultListeners.remove(aVar);
    }

    public void runWhenWelcomeRealDismiss(Runnable runnable) {
    }

    public void setCameraPermissionConfirmed() {
    }

    @Override // com.yuewen.xv1
    @AnyThread
    public void setLayoutInflater(LayoutInflater layoutInflater) {
        dr1 dr1Var = new dr1();
        dr1Var.f10324a = layoutInflater;
        this.mInflaters = dr1Var;
    }

    public void setUseProxy(boolean z) {
    }

    public void setUserChosenLocale(Locale locale) {
    }

    public void setWebPage(boolean z) {
        this.isWebPage.set(z);
    }

    @Override // com.yuewen.xv1
    public boolean unregisterGlobalFeature(w01 w01Var) {
        return this.mFeatureSet.d(w01Var);
    }

    @Override // com.yuewen.xv1
    public boolean unregisterLocalFeature(w01 w01Var) {
        return this.mFeatureSet.d(w01Var);
    }
}
