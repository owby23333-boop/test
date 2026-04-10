package com.kwad.sdk.oaid;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.WorkerThread;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class OADIDSDKHelper25 {
    private static final String SUB_TAG = "OADIDSDKHelper25:";
    private static final String TAG = "KSAdSDK";
    private static boolean mIsRequestIng = false;
    private static boolean sGetOaidFail = false;

    @Keep
    static class IIdentifierListener25 implements IIdentifierListener {
        private final a mOaidListener;
        private final long mStartTime;

        public IIdentifierListener25(long j2, a aVar) {
            this.mStartTime = j2;
            this.mOaidListener = aVar;
        }

        public void OnSupport(boolean z2, IdSupplier idSupplier) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                if (TextUtils.isEmpty(oaid)) {
                    boolean unused = OADIDSDKHelper25.sGetOaidFail = true;
                } else {
                    String str = "OADIDSDKHelper25:oaid time=" + jCurrentTimeMillis + "--OAID:" + oaid;
                    this.mOaidListener.cg(oaid);
                }
            }
            boolean unused2 = OADIDSDKHelper25.mIsRequestIng = false;
        }
    }

    public interface a {
        @WorkerThread
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
            int iInitSdk = MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListener25(jCurrentTimeMillis, aVar));
            String str = "OADIDSDKHelper25:sdk init time=" + (System.currentTimeMillis() - jCurrentTimeMillis) + "--result=" + iInitSdk;
        } catch (Throwable unused) {
            mIsRequestIng = false;
            sGetOaidFail = true;
        }
    }

    public static boolean isSupport() {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        try {
            new IIdentifierListener() { // from class: com.kwad.sdk.oaid.OADIDSDKHelper25.1
                public final void OnSupport(boolean z2, IdSupplier idSupplier) {
                }
            }.OnSupport(true, (IdSupplier) null);
            Class.forName("com.bun.miitmdid.core.MdidSdkHelper", false, OADIDSDKHelper25.class.getClassLoader());
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
