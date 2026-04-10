package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.embedapplog.gm;
import com.bytedance.embedapplog.li;
import com.bytedance.embedapplog.uy;

/* JADX INFO: loaded from: classes2.dex */
final class zd implements gm {
    private static final bm<Boolean> g = new bm<Boolean>() { // from class: com.bytedance.embedapplog.zd.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.bm
        /* JADX INFO: renamed from: dl, reason: merged with bridge method [inline-methods] */
        public Boolean z(Object... objArr) {
            return Boolean.valueOf(zb.z((Context) objArr[0]));
        }
    };
    private String z;

    zd() {
    }

    private boolean gc(Context context) {
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.z = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.z = "com.huawei.hwid.tv";
            } else {
                this.z = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    static boolean dl(Context context) {
        if (context == null) {
            return false;
        }
        return g.g(context).booleanValue();
    }

    @Override // com.bytedance.embedapplog.gm
    public boolean z(Context context) {
        return gc(context);
    }

    @Override // com.bytedance.embedapplog.gm
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public z g(Context context) {
        z zVar = new z();
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
            String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
            if (!TextUtils.isEmpty(string)) {
                zVar.g = string;
                zVar.dl = Boolean.parseBoolean(string2);
                zVar.z = 202003021704L;
                return zVar;
            }
        } catch (Throwable th) {
            cb.z(th);
        }
        Pair<String, Boolean> pairM = m(context);
        if (pairM != null) {
            zVar.g = (String) pairM.first;
            zVar.dl = ((Boolean) pairM.second).booleanValue();
            zVar.z = z(context, this.z);
        }
        return zVar;
    }

    private static int z(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e) {
            cb.z(e);
            return 0;
        }
    }

    private Pair<String, Boolean> m(Context context) {
        if (TextUtils.isEmpty(this.z)) {
            return null;
        }
        return (Pair) new uy(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage(this.z), new uy.g<li, Pair<String, Boolean>>() { // from class: com.bytedance.embedapplog.zd.2
            @Override // com.bytedance.embedapplog.uy.g
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public li z(IBinder iBinder) {
                return li.z.z(iBinder);
            }

            @Override // com.bytedance.embedapplog.uy.g
            public Pair<String, Boolean> z(li liVar) {
                if (liVar == null) {
                    return null;
                }
                return new Pair<>(liVar.z(), Boolean.valueOf(liVar.g()));
            }
        }).z();
    }

    static class z extends gm.z {
        long z = 0;

        z() {
        }
    }
}
