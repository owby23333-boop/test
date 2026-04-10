package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.embedapplog.aq;
import com.bytedance.embedapplog.rk;
import com.bytedance.embedapplog.vn;
import com.yuewen.yg3;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
final class rw implements rk {
    private ev<Boolean> bf;
    private final rk e;

    public rw() {
        this(null);
    }

    @Override // com.bytedance.embedapplog.rk
    public boolean bf(Context context) {
        if (context == null) {
            return false;
        }
        Boolean boolBf = this.bf.bf(context);
        return (this.e == null || boolBf.booleanValue()) ? boolBf.booleanValue() : this.e.bf(context);
    }

    @Override // com.bytedance.embedapplog.rk
    public rk.e d(final Context context) {
        if (this.e != null && !this.bf.bf(new Object[0]).booleanValue()) {
            return this.e.d(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = (String) new aq(context, intent, new aq.bf<vn, String>() { // from class: com.bytedance.embedapplog.rw.2
            @Override // com.bytedance.embedapplog.aq.bf
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public vn bf(IBinder iBinder) {
                return vn.e.e(iBinder);
            }

            @Override // com.bytedance.embedapplog.aq.bf
            public String e(vn vnVar) {
                if (vnVar == null) {
                    return null;
                }
                String strE = rw.this.e(context);
                if (TextUtils.isEmpty(strE)) {
                    return null;
                }
                return vnVar.e(context.getPackageName(), strE, "OUID");
            }
        }).e();
        rk.e eVar = new rk.e();
        eVar.bf = str;
        return eVar;
    }

    public rw(rk rkVar) {
        this.bf = new ev<Boolean>() { // from class: com.bytedance.embedapplog.rw.1
            @Override // com.bytedance.embedapplog.ev
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Boolean e(Object... objArr) {
                try {
                    PackageInfo packageInfo = ((Context) objArr[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);
                    if (packageInfo == null) {
                        return Boolean.FALSE;
                    }
                    return Boolean.valueOf(packageInfo.getLongVersionCode() >= 1);
                } catch (PackageManager.NameNotFoundException unused) {
                    return Boolean.FALSE;
                } catch (Throwable th) {
                    tx.e(th);
                    return Boolean.FALSE;
                }
            }
        };
        this.e = rkVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        } catch (Exception e) {
            tx.e(e);
        }
        Signature[] signatureArr = packageInfo != null ? packageInfo.signatures : null;
        if (signatureArr != null && signatureArr.length > 0) {
            byte[] byteArray = signatureArr[0].toByteArray();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(yg3.b.f20351b);
                if (messageDigest != null) {
                    byte[] bArrDigest = messageDigest.digest(byteArray);
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : bArrDigest) {
                        sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                    }
                    return sb.toString();
                }
            } catch (Exception e2) {
                tx.e(e2);
            }
        }
        return null;
    }
}
