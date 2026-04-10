package com.kwad.sdk.oaid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.e;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class OADIDSDKHelper {
    private static final String SUB_TAG = "OADIDSDKHelper:";
    private static final String TAG = "KSAdSDK";
    private static boolean mIsRequestIng = false;
    private static boolean sGetOaidFail = false;

    @Keep
    static class IIdentifierListenerImpl implements IIdentifierListener {
        private final a mOaidListener;
        private final long mStartTime;

        public IIdentifierListenerImpl(long j2, a aVar) {
            this.mStartTime = j2;
            this.mOaidListener = aVar;
        }

        public void onSupport(IdSupplier idSupplier) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                if (TextUtils.isEmpty(oaid)) {
                    boolean unused = OADIDSDKHelper.sGetOaidFail = true;
                } else {
                    String str = "OADIDSDKHelper:oaid time=" + jCurrentTimeMillis + "--OAID:" + oaid;
                    this.mOaidListener.cg(oaid);
                }
            }
            boolean unused2 = OADIDSDKHelper.mIsRequestIng = false;
        }
    }

    public interface a {
        void cg(String str);
    }

    public static void getOAId(Context context, a aVar) {
        if (context == null || sGetOaidFail) {
            return;
        }
        if (!isSupport()) {
            sGetOaidFail = true;
            return;
        }
        if (mIsRequestIng) {
            return;
        }
        mIsRequestIng = true;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            int iInitSdk = MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListenerImpl(jCurrentTimeMillis, aVar));
            String str = "OADIDSDKHelper:sdk init time=" + (System.currentTimeMillis() - jCurrentTimeMillis) + "--result=" + iInitSdk;
        } catch (Throwable unused) {
            mIsRequestIng = false;
            sGetOaidFail = true;
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static boolean isSupport() {
        if (Build.VERSION.SDK_INT < 16) {
            return false;
        }
        try {
            new IIdentifierListener() { // from class: com.kwad.sdk.oaid.OADIDSDKHelper.1
                public final void onSupport(IdSupplier idSupplier) {
                }
            }.onSupport((IdSupplier) null);
            String str = "OADIDSDKHelper:oaidVersion" + e.a();
            Class.forName("com.bun.miitmdid.core.MdidSdkHelper", false, OADIDSDKHelper.class.getClassLoader());
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
