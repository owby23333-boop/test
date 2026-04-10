package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
final class k {
    private final String ZD;
    private final String ZE;
    private final String ZF;
    private Resources ZG;
    private ClassLoader ZH;
    private IKsAdSDK ZI;

    private k(String str, String str2, String str3) {
        this.ZD = str;
        this.ZE = str2;
        this.ZF = str3;
    }

    static k b(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            throw new RuntimeException("mApk not a file");
        }
        k kVar = new k(str, str2, str3);
        kVar.init(context);
        return kVar;
    }

    private void init(Context context) {
        tE();
        Resources resourcesA = q.a(context, context.getResources(), this.ZD);
        ClassLoader classLoaderA = e.a(context, this.ZD, this.ZE, this.ZF);
        IKsAdSDK iKsAdSDKA = Loader.a(classLoaderA);
        this.ZG = resourcesA;
        this.ZH = classLoaderA;
        this.ZI = iKsAdSDKA;
        int sDKType = iKsAdSDKA.getSDKType();
        if (sDKType == 1) {
            return;
        }
        throw new RuntimeException("sdkType error apiType: 1 , sdkType:" + sDKType);
    }

    static synchronized k r(Context context, String str) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
        return b(context, h.n(context, str), h.o(context, str), h.p(context, str));
    }

    private void tE() {
        if (TextUtils.isEmpty(this.ZD)) {
            throw new RuntimeException("mApk is null");
        }
        File file = new File(this.ZD);
        if (!file.isFile() || !file.exists()) {
            throw new RuntimeException("mApk not a file");
        }
    }

    final ClassLoader getClassLoader() {
        return this.ZH;
    }

    final Resources tC() {
        return this.ZG;
    }

    final IKsAdSDK tD() {
        return this.ZI;
    }

    public final String toString() {
        return "ExternalPackage{mApk='" + this.ZD + "', mDexDir='" + this.ZE + "', mNativeLibDir='" + this.ZF + "', mResource=" + this.ZG + ", mClassLoader=" + this.ZH + ", mKsSdk=" + this.ZI + '}';
    }
}
