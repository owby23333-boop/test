package com.kwad.sdk.api.loader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.anythink.core.common.c.d;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.proxy.IComponentProxy;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class Loader {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;
    private final AtomicBoolean IC;
    private IKsAdSDK ZJ;
    private k ZK;

    static class a {
        private static final Loader ZL = new Loader(0);
    }

    private Loader() {
        this.ZK = null;
        this.IC = new AtomicBoolean(false);
    }

    /* synthetic */ Loader(byte b) {
        this();
    }

    @NonNull
    @MainThread
    static synchronized IKsAdSDK a(ClassLoader classLoader) {
        Object objInvoke;
        try {
            objInvoke = Class.forName(((KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class)).value(), true, classLoader).getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[0]).invoke(null, new Object[0]);
            if (objInvoke == null) {
                throw new RuntimeException("Can not get sdk form " + classLoader);
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
        return (IKsAdSDK) objInvoke;
    }

    private boolean aC(Context context) {
        String strAy = g.ay(context);
        String strAz = g.az(context);
        if (TextUtils.isEmpty(strAy) && TextUtils.isEmpty(strAz)) {
            return false;
        }
        if (!TextUtils.isEmpty(strAz) && g.q(strAz, strAy)) {
            g.h(context, strAz);
            s(context, strAy);
            g.i(context, "");
            strAy = strAz;
        }
        return !TextUtils.isEmpty(strAy);
    }

    private static void aD(Context context) {
        String strAA = g.aA(context);
        boolean zB = t.b(context, g.Zp, false);
        if (TextUtils.isEmpty(strAA) || !strAA.equals("3.3.38") || zB) {
            String strAy = g.ay(context);
            g.h(context, "");
            g.i(context, "");
            t.a(context, g.Zp, false);
            h.e(h.m(context, strAy));
            g.j(context, "3.3.38");
        }
    }

    public static Loader get() {
        return a.ZL;
    }

    private static void s(Context context, String str) {
        h.q(context, str);
    }

    private static void tF() {
        try {
            int iTx = com.kwad.sdk.api.c.tx();
            if (iTx > 0) {
                try {
                    d.ax(mContext).setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
                    Thread.setDefaultUncaughtExceptionHandler(d.ax(mContext));
                    d.ax(mContext).aO(iTx);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public Context getContext() {
        return mContext;
    }

    @MainThread
    public ClassLoader getExternalClassLoader() {
        k kVar = this.ZK;
        if (kVar != null) {
            return kVar.getClassLoader();
        }
        return null;
    }

    @MainThread
    public Resources getExternalResource() {
        k kVar = this.ZK;
        if (kVar != null) {
            return kVar.tC();
        }
        return null;
    }

    public ClassLoader getRealClassLoader() {
        k kVar = this.ZK;
        return kVar != null ? kVar.getClassLoader() : Loader.class.getClassLoader();
    }

    public IKsAdSDK init(@NonNull Context context) {
        if (this.IC.get()) {
            return this.ZJ;
        }
        mContext = context.getApplicationContext();
        aD(context);
        if (aC(context)) {
            this.ZK = k.r(context, g.ay(context));
        }
        k kVar = this.ZK;
        if (kVar == null) {
            this.ZJ = a(Loader.class.getClassLoader());
            this.ZJ.setIsExternal(false);
        } else {
            this.ZJ = kVar.tD();
            this.ZJ.setIsExternal(true);
        }
        com.kwad.sdk.api.c.a(this.ZJ);
        if (this.ZK != null) {
            tF();
        }
        this.IC.set(true);
        return this.ZJ;
    }

    public boolean isExternalLoaded() {
        return this.ZK != null;
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        if (!KsAdSDK.sHasInit.get()) {
            KsAdSDK.init(context, SdkConfig.create(t.getString(context, d.a.a)));
        }
        return (T) this.ZJ.newComponentProxy(cls, obj);
    }

    @MainThread
    public <T> T newInstance(Class<T> cls) {
        if (!KsAdSDK.sHasInit.get()) {
            Context application = mContext;
            if (application == null) {
                application = KSLifecycleObserver.getInstance().getApplication();
            }
            KsAdSDK.init(application, SdkConfig.create(t.getString(application, d.a.a)));
        }
        return (T) this.ZJ.newInstance(cls);
    }

    public void rest() {
        this.IC.set(false);
        mContext = null;
        this.ZJ = null;
        this.ZK = null;
    }
}
