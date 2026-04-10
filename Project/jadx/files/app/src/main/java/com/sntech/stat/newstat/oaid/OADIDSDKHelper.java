package com.sntech.stat.newstat.oaid;

import android.annotation.SuppressLint;
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
public class OADIDSDKHelper {
    private static final String TAG = "SNADS.Log";
    private static boolean mIsRequestIng = false;
    private static boolean sGetOaidFail = false;

    @Keep
    public static class IIdentifierListenerImpl implements IIdentifierListener {
        private final com.sntech.stat.newstat.oaid.Cdo mIdListener;
        private final long mStartTime;

        /* JADX INFO: renamed from: com.sntech.stat.newstat.oaid.OADIDSDKHelper$IIdentifierListenerImpl$do, reason: invalid class name */
        public class Cdo implements Cdo.InterfaceC0508do {

            /* JADX INFO: renamed from: do, reason: not valid java name */
            public final /* synthetic */ IdSupplier f131do;

            public Cdo(IIdentifierListenerImpl iIdentifierListenerImpl, IdSupplier idSupplier) {
                this.f131do = idSupplier;
            }

            @Override // com.sntech.stat.newstat.oaid.Cdo.InterfaceC0508do
            public String getAAID() {
                return this.f131do.getAAID();
            }

            @Override // com.sntech.stat.newstat.oaid.Cdo.InterfaceC0508do
            public String getOAID() {
                return this.f131do.getOAID();
            }

            @Override // com.sntech.stat.newstat.oaid.Cdo.InterfaceC0508do
            public String getVAID() {
                return this.f131do.getVAID();
            }

            @Override // com.sntech.stat.newstat.oaid.Cdo.InterfaceC0508do
            public boolean isSupported() {
                return this.f131do.isSupported();
            }
        }

        public IIdentifierListenerImpl(long j2, com.sntech.stat.newstat.oaid.Cdo cdo) {
            this.mStartTime = j2;
            this.mIdListener = cdo;
        }

        public void onSupport(IdSupplier idSupplier) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                if (TextUtils.isEmpty(oaid)) {
                    boolean unused = OADIDSDKHelper.sGetOaidFail = true;
                } else {
                    String str = "OADIDSDKHelper30:oaid time=" + jCurrentTimeMillis + "--OAID:" + oaid;
                }
                ((c) this.mIdListener).a(new Cdo(this, idSupplier));
            } else {
                ((c) this.mIdListener).a(null);
            }
            boolean unused2 = OADIDSDKHelper.mIsRequestIng = false;
        }
    }

    /* JADX INFO: renamed from: com.sntech.stat.newstat.oaid.OADIDSDKHelper$do, reason: invalid class name */
    public class Cdo implements IIdentifierListener {
    }

    public static int getOAId(Context context, com.sntech.stat.newstat.oaid.Cdo cdo) {
        int iInitSdk;
        long jCurrentTimeMillis;
        if (context != null && !sGetOaidFail) {
            if (!isSupport()) {
                sGetOaidFail = true;
            } else if (!mIsRequestIng) {
                mIsRequestIng = true;
                try {
                    jCurrentTimeMillis = System.currentTimeMillis();
                    iInitSdk = MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListenerImpl(jCurrentTimeMillis, cdo));
                } catch (Throwable th) {
                    th = th;
                    iInitSdk = 0;
                }
                try {
                    String str = "OADIDSDKHelper30:sdk init time=" + (System.currentTimeMillis() - jCurrentTimeMillis) + "--result=" + iInitSdk;
                    return iInitSdk;
                } catch (Throwable th2) {
                    th = th2;
                    StringBuilder sbA = b.a("OADIDSDKHelper30:oaid sdk not find ");
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

    @SuppressLint({"ObsoleteSdkInt"})
    public static boolean isSupport() {
        if (Build.VERSION.SDK_INT < 16) {
            return false;
        }
        try {
            Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
        } catch (Throwable unused) {
        }
        try {
            new Cdo().onSupport((IdSupplier) null);
            return true;
        } catch (Throwable th) {
            StringBuilder sbA = b.a("OADIDSDKHelper30:isSupport oaid sdk not find ");
            sbA.append(th.getMessage());
            sbA.toString();
            return false;
        }
    }
}
