package com.anythink.core.common.k;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.SparseBooleanArray;
import com.anythink.core.common.k.o;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class q {
    private static final int a = 1;
    private static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f7742c = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile q f7743e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseBooleanArray f7744d = new SparseBooleanArray(3);

    public static q a() {
        if (f7743e == null) {
            synchronized (q.class) {
                if (f7743e == null) {
                    f7743e = new q();
                }
            }
        }
        return f7743e;
    }

    public final synchronized boolean b(Context context) {
        if (this.f7744d.indexOfKey(2) >= 0) {
            return this.f7744d.get(2);
        }
        boolean z2 = false;
        try {
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            if (listQueryIntentServices != null) {
                if (listQueryIntentServices.size() > 0) {
                    z2 = true;
                }
            }
        } catch (Exception unused) {
        }
        this.f7744d.put(2, z2);
        return z2;
    }

    public final synchronized boolean a(Context context) {
        if (this.f7744d.indexOfKey(1) >= 0) {
            return this.f7744d.get(1);
        }
        boolean z2 = false;
        if (Build.VERSION.SDK_INT < 16) {
            this.f7744d.put(1, false);
            return false;
        }
        try {
            o oVar = new o(context);
            o.a aVarA = oVar.a("com.huawei.hwid");
            String strB = oVar.b("com.huawei.hwid");
            if (aVarA == o.a.ENABLED) {
                if ("B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(strB)) {
                    z2 = true;
                }
            }
        } catch (Exception unused) {
        }
        this.f7744d.put(1, z2);
        return z2;
    }

    public final synchronized boolean b() {
        if (this.f7744d.indexOfKey(3) >= 0) {
            return this.f7744d.get(3);
        }
        boolean z2 = false;
        try {
            Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
            z2 = true;
        } catch (Exception unused) {
        }
        this.f7744d.put(3, z2);
        return z2;
    }
}
