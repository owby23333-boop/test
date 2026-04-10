package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.embedapplog.gm;
import com.bytedance.embedapplog.ls;
import com.bytedance.embedapplog.uy;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
final class by implements gm {
    private bm<Boolean> g;
    private final gm z;

    by() {
        this(null);
    }

    by(gm gmVar) {
        this.g = new bm<Boolean>() { // from class: com.bytedance.embedapplog.by.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.embedapplog.bm
            /* JADX INFO: renamed from: dl, reason: merged with bridge method [inline-methods] */
            public Boolean z(Object... objArr) {
                long longVersionCode;
                try {
                    PackageInfo packageInfo = ((Context) objArr[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);
                    if (packageInfo == null) {
                        return Boolean.FALSE;
                    }
                    if (Build.VERSION.SDK_INT >= 28) {
                        longVersionCode = packageInfo.getLongVersionCode();
                    } else {
                        longVersionCode = packageInfo.versionCode;
                    }
                    return Boolean.valueOf(longVersionCode >= 1);
                } catch (PackageManager.NameNotFoundException unused) {
                    return Boolean.FALSE;
                } catch (Throwable th) {
                    cb.z(th);
                    return Boolean.FALSE;
                }
            }
        };
        this.z = gmVar;
    }

    @Override // com.bytedance.embedapplog.gm
    public boolean z(Context context) {
        if (context == null) {
            return false;
        }
        Boolean boolG = this.g.g(context);
        if (this.z != null && !boolG.booleanValue()) {
            return this.z.z(context);
        }
        return boolG.booleanValue();
    }

    @Override // com.bytedance.embedapplog.gm
    public gm.z g(final Context context) {
        if (this.z != null && !this.g.g(new Object[0]).booleanValue()) {
            return this.z.g(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = (String) new uy(context, intent, new uy.g<ls, String>() { // from class: com.bytedance.embedapplog.by.2
            @Override // com.bytedance.embedapplog.uy.g
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public ls z(IBinder iBinder) {
                return ls.z.z(iBinder);
            }

            @Override // com.bytedance.embedapplog.uy.g
            public String z(ls lsVar) {
                if (lsVar == null) {
                    return null;
                }
                String strDl = by.this.dl(context);
                if (TextUtils.isEmpty(strDl)) {
                    return null;
                }
                return lsVar.z(context.getPackageName(), strDl, "OUID");
            }
        }).z();
        gm.z zVar = new gm.z();
        zVar.g = str;
        return zVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dl(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        } catch (Exception e) {
            cb.z(e);
        }
        Signature[] signatureArr = packageInfo != null ? packageInfo.signatures : null;
        if (signatureArr != null && signatureArr.length > 0) {
            byte[] byteArray = signatureArr[0].toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                if (messageDigest != null) {
                    byte[] bArrDigest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b : bArrDigest) {
                        sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                    }
                    return sb.toString();
                }
            } catch (Exception e2) {
                cb.z(e2);
            }
        }
        return null;
    }
}
