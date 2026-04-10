package com.sntech.stat.newstat.oaid;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.sntech.stat.newstat.oaid.Cdo;
import t0.c;
import y.b;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class OADIDSDKHelper25 {
    private static final String TAG = "SNADS.Log";
    private static boolean mIsRequestIng = false;
    private static boolean sGetOaidFail = false;

    @Keep
    public static class IIdentifierListener25 implements IIdentifierListener {
        private final com.sntech.stat.newstat.oaid.Cdo mIdListener;
        private final long mStartTime;

        /* JADX INFO: renamed from: com.sntech.stat.newstat.oaid.OADIDSDKHelper25$IIdentifierListener25$do, reason: invalid class name */
        public class Cdo implements Cdo.InterfaceC0508do {

            /* JADX INFO: renamed from: do, reason: not valid java name */
            public final /* synthetic */ IdSupplier f132do;

            public Cdo(IIdentifierListener25 iIdentifierListener25, IdSupplier idSupplier) {
                this.f132do = idSupplier;
            }

            @Override // com.sntech.stat.newstat.oaid.Cdo.InterfaceC0508do
            public String getAAID() {
                return this.f132do.getAAID();
            }

            @Override // com.sntech.stat.newstat.oaid.Cdo.InterfaceC0508do
            public String getOAID() {
                return this.f132do.getOAID();
            }

            @Override // com.sntech.stat.newstat.oaid.Cdo.InterfaceC0508do
            public String getVAID() {
                return this.f132do.getVAID();
            }

            @Override // com.sntech.stat.newstat.oaid.Cdo.InterfaceC0508do
            public boolean isSupported() {
                return this.f132do.isSupported();
            }
        }

        public IIdentifierListener25(long j2, com.sntech.stat.newstat.oaid.Cdo cdo) {
            this.mStartTime = j2;
            this.mIdListener = cdo;
        }

        @Keep
        public void OnSupport(boolean z2, IdSupplier idSupplier) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                if (TextUtils.isEmpty(oaid)) {
                    boolean unused = OADIDSDKHelper25.sGetOaidFail = true;
                } else {
                    String str = "OADIDSDKHelper25:oaid time=" + jCurrentTimeMillis + "--OAID:" + oaid;
                }
                ((c) this.mIdListener).a(new Cdo(this, idSupplier));
            } else {
                ((c) this.mIdListener).a(null);
            }
            boolean unused2 = OADIDSDKHelper25.mIsRequestIng = false;
        }

        @Keep
        public void onSupport(IdSupplier idSupplier) {
        }
    }

    public static int getOAId(Context context, Cdo cdo) {
        int iInitSdk;
        long jCurrentTimeMillis;
        if (context != null && !sGetOaidFail) {
            if (!isSupport()) {
                sGetOaidFail = true;
            } else if (!mIsRequestIng) {
                mIsRequestIng = true;
                try {
                    jCurrentTimeMillis = System.currentTimeMillis();
                    iInitSdk = MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListener25(jCurrentTimeMillis, cdo));
                } catch (Throwable th) {
                    th = th;
                    iInitSdk = 0;
                }
                try {
                    String str = "OADIDSDKHelper25:sdk init time=" + (System.currentTimeMillis() - jCurrentTimeMillis) + "--result=" + iInitSdk;
                    return iInitSdk;
                } catch (Throwable th2) {
                    th = th2;
                    StringBuilder sbA = b.a("OADIDSDKHelper25:oaid sdk not find ");
                    sbA.append(th.getMessage());
                    sbA.toString();
                    mIsRequestIng = false;
                    sGetOaidFail = true;
                    return iInitSdk;
                }
            }
        }
        return 0;
    }

    public static boolean isSupport() {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        try {
            Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
        } catch (Throwable unused) {
        }
        try {
            return Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener").getMethod("onSupport", Boolean.TYPE, IdSupplier.class) != null;
        } catch (Throwable th) {
            StringBuilder sbA = b.a("OADIDSDKHelper25:isSupport oaid sdk not find ");
            sbA.append(th.getMessage());
            sbA.toString();
            return false;
        }
    }
}
