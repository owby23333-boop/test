package com.kwad.sdk.mobileid;

import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import com.kuaishou.weapon.p0.g;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.mobileid.a.a.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static String TAG = "MobileIdManager";
    public static com.kwad.sdk.mobileid.a.a.a aTh;
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
        d dVarNu = Nu();
        if (dVarNu.isSuccess()) {
            dVarNu = Nr();
            com.kwad.sdk.core.d.c.d(TAG, "init success :" + dVarNu);
        } else {
            com.kwad.sdk.core.d.c.d(TAG, "init error: " + dVarNu.Nz());
        }
        c.a(context, dVarNu);
    }

    private static d Nr() {
        d dVar;
        Context context = mContext;
        int iD = ao.d(context, bd.dt(context), bc.useNetworkStateDisable());
        try {
            if (!ao.isWifiConnected(mContext)) {
                dVar = new d(true, "uaidTokenCanRequest");
                new com.kwad.sdk.mobileid.a.a().ci(mContext);
                com.kwad.sdk.core.d.c.w(TAG, "requestMobileIdByMobileData");
            } else {
                boolean z = iD == 1;
                boolean z2 = !Ns();
                if (z && z2) {
                    dVar = new d(true, "uaidTokenCanRequestByWifi");
                    h.schedule(new bg() { // from class: com.kwad.sdk.mobileid.a.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            a.ch(a.mContext);
                            com.kwad.sdk.core.d.c.w(a.TAG, "requestMobileIdChangeToyMobileData");
                            h.schedule(new bg() { // from class: com.kwad.sdk.mobileid.a.1.1
                                @Override // com.kwad.sdk.utils.bg
                                public final void doTask() {
                                    a.Nt();
                                    com.kwad.sdk.core.d.c.w(a.TAG, "schedule unbindNetwork");
                                }
                            }, 2L, TimeUnit.SECONDS);
                        }
                    }, e.Gl(), TimeUnit.SECONDS);
                } else if (z) {
                    dVar = new d(false, "noRequestByBrand");
                } else if (z2) {
                    dVar = new d(false, "noRequestByNoCMCC");
                } else {
                    dVar = new d(false, "noRequestByBrandAndCMCC");
                }
            }
            return dVar;
        } catch (Exception e) {
            d dVar2 = new d(false, "noRequestByException");
            dVar2.gn(e.getMessage());
            ServiceProvider.reportSdkCaughtException(e);
            return dVar2;
        }
    }

    private static boolean Ns() {
        String str = Build.MANUFACTURER;
        com.kwad.sdk.core.d.c.w(TAG, "isHuaweiOrHonorDevice manufacturer: " + str);
        return "HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ch(final Context context) {
        if (aTh == null) {
            aTh = new com.kwad.sdk.mobileid.a.a.a();
        }
        c.b(context, new d(true, "uaidTokenCanRequestByWifiPre"));
        aTh.a(context, new a.InterfaceC0422a() { // from class: com.kwad.sdk.mobileid.a.2
            @Override // com.kwad.sdk.mobileid.a.a.a.InterfaceC0422a
            public final void Ny() {
                new com.kwad.sdk.mobileid.a.a().b(context, true);
            }
        });
    }

    public static void Nt() {
        synchronized (a.class) {
            if (aTh != null) {
                com.kwad.sdk.core.d.c.w(TAG, "unbindNetwork");
                aTh.Nt();
            }
        }
    }

    private static d Nu() {
        String str;
        boolean zQq = ag.Qq();
        boolean z = zQq && !ag.QD() && Nv();
        if (!zQq) {
            str = "noRequestByUaidEnable";
        } else if (ag.QD()) {
            str = "noRequestByUaidExist";
        } else {
            str = !Nv() ? "noNetworkPermission" : "uaidTokenCanRequest";
        }
        return new d(z, str);
    }

    private static boolean Nv() {
        String[] strArr = {g.b, g.d, "android.permission.CHANGE_NETWORK_STATE", g.f1857a};
        for (int i = 0; i < 4; i++) {
            if (ActivityCompat.checkSelfPermission(ServiceProvider.getContext(), strArr[i]) != 0) {
                return false;
            }
        }
        return true;
    }
}
