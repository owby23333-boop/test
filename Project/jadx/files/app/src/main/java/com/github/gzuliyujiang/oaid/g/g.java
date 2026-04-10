package com.github.gzuliyujiang.oaid.g;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.github.gzuliyujiang.oaid.OAIDException;
import com.github.gzuliyujiang.oaid.g.m;
import repeackage.com.uodis.opendevice.aidl.OpenDeviceIdentifierService;

/* JADX INFO: compiled from: HuaweiImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class g implements com.github.gzuliyujiang.oaid.d {
    private final Context a;
    private String b;

    /* JADX INFO: compiled from: HuaweiImpl.java */
    class a implements m.a {
        a(g gVar) {
        }

        @Override // com.github.gzuliyujiang.oaid.g.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            OpenDeviceIdentifierService openDeviceIdentifierServiceAsInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
            if (openDeviceIdentifierServiceAsInterface.isOaidTrackLimited()) {
                throw new OAIDException("User has disabled advertising identifier");
            }
            return openDeviceIdentifierServiceAsInterface.getOaid();
        }
    }

    public g(Context context) {
        this.a = context;
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.b = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.b = "com.huawei.hwid.tv";
            } else {
                this.b = "com.huawei.hms";
                if (packageManager.getPackageInfo(this.b, 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            com.github.gzuliyujiang.oaid.e.a(e2);
            return false;
        }
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public void a(com.github.gzuliyujiang.oaid.c cVar) {
        Context context = this.a;
        if (context == null || cVar == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                if (!TextUtils.isEmpty(string)) {
                    com.github.gzuliyujiang.oaid.e.a("Get oaid from global settings: " + string);
                    cVar.a(string);
                    return;
                }
            } catch (Exception e2) {
                com.github.gzuliyujiang.oaid.e.a(e2);
            }
        }
        if (TextUtils.isEmpty(this.b) && !a()) {
            cVar.a(new OAIDException("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.b);
        m.a(this.a, intent, cVar, new a(this));
    }
}
