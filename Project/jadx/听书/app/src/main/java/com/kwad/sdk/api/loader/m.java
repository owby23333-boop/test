package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.g;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
final class m {
    private final String auu;
    private final String auv;
    private final String auw;
    private Resources aux;
    private ClassLoader auy;
    private IKsAdSDK auz;

    public final String toString() {
        return "ExternalPackage{mApk='" + this.auu + "', mDexDir='" + this.auv + "', mNativeLibDir='" + this.auw + "', mResource=" + this.aux + ", mClassLoader=" + this.auy + ", mKsSdk=" + this.auz + '}';
    }

    final Resources Dm() {
        return this.aux;
    }

    final ClassLoader getClassLoader() {
        return this.auy;
    }

    final IKsAdSDK Dn() {
        return this.auz;
    }

    private m(String str, String str2, String str3) {
        this.auu = str;
        this.auv = str2;
        this.auw = str3;
    }

    static synchronized m a(Context context, ClassLoader classLoader, String str) {
        try {
        } catch (Throwable th) {
            com.kwad.sdk.api.c.m(th);
            return null;
        }
        return b(context, classLoader, j.v(context, str), j.w(context, str), j.x(context, str));
    }

    static m b(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            throw new RuntimeException("mApk not a file");
        }
        try {
            if (Build.VERSION.SDK_INT >= 34 && context != null && context.getApplicationInfo().targetSdkVersion >= 34) {
                file.setReadOnly();
            }
        } catch (Throwable unused) {
        }
        m mVar = new m(str, str2, str3);
        mVar.a(context, classLoader);
        return mVar;
    }

    private void a(Context context, ClassLoader classLoader) {
        Do();
        Resources resourcesA = w.a(context, context.getResources(), this.auu);
        ClassLoader classLoaderA = g.a(context, classLoader, this.auu, this.auv, this.auw);
        IKsAdSDK iKsAdSDKA = Loader.a(classLoaderA);
        this.aux = resourcesA;
        this.auy = classLoaderA;
        this.auz = iKsAdSDKA;
        if (!(iKsAdSDKA.getClass().getClassLoader() instanceof g.a)) {
            throw new RuntimeException("classLoader is not expect dynamic classloader:");
        }
        int sDKType = iKsAdSDKA.getSDKType();
        if (sDKType != 1) {
            throw new RuntimeException("sdkType error apiType: 1 , sdkType:" + sDKType);
        }
    }

    private void Do() {
        if (TextUtils.isEmpty(this.auu)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(this.auu);
        if (!file.isFile() || !file.exists()) {
            throw new RuntimeException("mApk not a file");
        }
    }
}
