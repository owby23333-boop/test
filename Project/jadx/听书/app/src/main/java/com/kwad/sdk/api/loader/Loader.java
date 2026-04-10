package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class Loader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Context mContext;
    private IKsAdSDK auA;
    private m auB;
    private final AtomicBoolean mHasInit;

    /* synthetic */ Loader(byte b) {
        this();
    }

    static class a {
        private static final Loader auC = new Loader(0);
    }

    public static Loader get() {
        return a.auC;
    }

    private Loader() {
        this.auB = null;
        this.mHasInit = new AtomicBoolean(false);
    }

    public IKsAdSDK init(Context context, ClassLoader classLoader) {
        if (this.mHasInit.get()) {
            return this.auA;
        }
        mContext = context.getApplicationContext();
        bd(context);
        if (bc(context)) {
            this.auB = m.a(context, classLoader, i.aX(context));
        }
        boolean zBooleanValue = com.kwad.sdk.api.a.atz.booleanValue();
        m mVar = this.auB;
        if (mVar == null && zBooleanValue) {
            ClassLoader classLoaderInitDex = DexLoader.initDex(context, classLoader);
            if (classLoaderInitDex == null) {
                return null;
            }
            new StringBuilder("IKsAdSDK after dexClassLoader: ").append(classLoaderInitDex);
            this.auA = a(classLoaderInitDex);
            new StringBuilder("IKsAdSDK after mSDKImpl: ").append(this.auA);
        } else if (mVar == null) {
            IKsAdSDK iKsAdSDKA = a(getClass().getClassLoader());
            this.auA = iKsAdSDKA;
            iKsAdSDKA.setIsExternal(false);
        } else {
            IKsAdSDK iKsAdSDKDn = mVar.Dn();
            this.auA = iKsAdSDKDn;
            iKsAdSDKDn.setIsExternal(true);
        }
        com.kwad.sdk.api.c.a(this.auA);
        if (this.auB != null) {
            Dq();
        }
        this.mHasInit.set(true);
        return this.auA;
    }

    public void rest() {
        this.mHasInit.set(false);
        mContext = null;
        this.auA = null;
        this.auB = null;
    }

    private static void Dq() {
        try {
            int iDf = com.kwad.sdk.api.c.Df();
            if (iDf > 0) {
                try {
                    f.aW(mContext).setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
                    Thread.setDefaultUncaughtExceptionHandler(f.aW(mContext));
                    f.aW(mContext).cp(iDf);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private boolean bc(Context context) {
        try {
            String strAX = i.aX(context);
            String strAY = i.aY(context);
            if (TextUtils.isEmpty(strAX) && TextUtils.isEmpty(strAY)) {
                return false;
            }
            if (!TextUtils.isEmpty(strAY) && i.L(strAY, strAX)) {
                i.p(context, strAY);
                z(context, strAX);
                i.q(context, "");
                strAX = strAY;
            }
            return !TextUtils.isEmpty(strAX);
        } catch (Throwable th) {
            com.kwad.sdk.api.c.m(th);
            return false;
        }
    }

    private static void z(Context context, String str) {
        j.y(context, str);
    }

    private static void bd(Context context) {
        try {
            String strAZ = i.aZ(context);
            boolean zB = b.b(context, i.auf, false);
            if (TextUtils.isEmpty(strAZ) || !strAZ.equals(BuildConfig.VERSION_NAME) || zB) {
                String strAX = i.aX(context);
                i.p(context, "");
                i.q(context, "");
                b.a(context, i.auf, false);
                j.j(j.u(context, strAX));
                i.r(context, BuildConfig.VERSION_NAME);
            }
        } catch (Throwable th) {
            com.kwad.sdk.api.c.m(th);
        }
    }

    public boolean isExternalLoaded() {
        return this.auB != null;
    }

    public Context getContext() {
        return mContext;
    }

    public ClassLoader getRealClassLoader() {
        m mVar = this.auB;
        if (mVar != null) {
            return mVar.getClassLoader();
        }
        return getClass().getClassLoader();
    }

    public Resources getExternalResource() {
        m mVar = this.auB;
        if (mVar != null) {
            return mVar.Dm();
        }
        return null;
    }

    public ClassLoader getExternalClassLoader() {
        m mVar = this.auB;
        ClassLoader classLoader = mVar != null ? mVar.getClassLoader() : null;
        if (com.kwad.sdk.api.a.atz.booleanValue()) {
            classLoader = this.auA.getClass().getClassLoader();
            new StringBuilder("Loader getExternalClassLoader: ").append(classLoader);
        }
        new StringBuilder("Loader result: ").append(classLoader);
        return classLoader;
    }

    static synchronized IKsAdSDK a(ClassLoader classLoader) {
        Object objInvoke;
        try {
            objInvoke = Class.forName(((KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class)).value(), true, classLoader).getDeclaredMethod("get", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke == null) {
                throw new RuntimeException("Can not get sdk form " + classLoader);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return (IKsAdSDK) objInvoke;
    }

    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        checkInitSDK(context);
        return (T) this.auA.newComponentProxy(cls, obj);
    }

    public <T> T newInstance(Class<T> cls) {
        checkInitSDK(mContext);
        return (T) this.auA.newInstance(cls);
    }

    public static void checkInitSDK(Context context) {
        if (KsAdSDK.sHasInit.get()) {
            return;
        }
        if (context == null) {
            context = KSLifecycleObserver.getInstance().getApplication();
        }
        if (context == null) {
            context = c.Dl();
        }
        KsAdSDK.init(context, SdkConfig.create(b.getString(context, "sdkconfig")));
    }
}
