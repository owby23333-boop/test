package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.a1;
import bykvm_19do.bykvm_19do.bykvm_19do.j1;
import bykvm_19do.bykvm_19do.bykvm_19do.q1;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
final class g1 implements a1 {
    private final a1 a;
    private o0<Boolean> b;

    class a extends o0<Boolean> {
        a(g1 g1Var) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // bykvm_19do.bykvm_19do.bykvm_19do.o0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean a(Object... objArr) {
            try {
                PackageInfo packageInfo = ((Context) objArr[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);
                if (packageInfo == null) {
                    return false;
                }
                return Boolean.valueOf((Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode) >= 1);
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
    }

    class b implements j1.b<q1, String> {
        final /* synthetic */ Context a;

        b(Context context) {
            this.a = context;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.j1.b
        public String a(q1 q1Var) {
            if (q1Var != null) {
                String strC = g1.this.c(this.a);
                if (!TextUtils.isEmpty(strC)) {
                    return q1Var.a(this.a.getPackageName(), strC, "OUID");
                }
            }
            return null;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.j1.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public q1 a(IBinder iBinder) {
            return q1.a.a(iBinder);
        }
    }

    g1() {
        this(null);
    }

    g1(a1 a1Var) {
        this.b = new a(this);
        this.a = a1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Signature[] signatureArr = packageInfo != null ? packageInfo.signatures : null;
        if (signatureArr == null || signatureArr.length <= 0) {
            return null;
        }
        byte[] byteArray = signatureArr[0].toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            if (messageDigest == null) {
                return null;
            }
            byte[] bArrDigest = messageDigest.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public boolean a(Context context) {
        if (context == null) {
            return false;
        }
        Boolean boolB = this.b.b(context);
        return (this.a == null || boolB.booleanValue()) ? boolB.booleanValue() : this.a.a(context);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public a1.a b(Context context) {
        if (this.a != null && !this.b.b(new Object[0]).booleanValue()) {
            return this.a.b(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = (String) new j1(context, intent, new b(context)).a();
        a1.a aVar = new a1.a();
        aVar.a = str;
        return aVar;
    }
}
