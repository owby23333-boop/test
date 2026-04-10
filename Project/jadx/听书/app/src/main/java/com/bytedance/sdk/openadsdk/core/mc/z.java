package com.bytedance.sdk.openadsdk.core.mc;

import android.content.Context;
import android.net.Network;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.openadsdk.core.dl.a;
import com.bytedance.sdk.openadsdk.core.iq.r;
import com.bytedance.sdk.openadsdk.core.mc.z.dl;
import com.bytedance.sdk.openadsdk.core.mc.z.g;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.kb;
import com.kuaishou.weapon.p0.bi;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static final List<String> i = Arrays.asList("-10001", "-10008", "103111", "105002", "-5", "-2", "-15", "-10", "-11");
    private static volatile z z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r f1263a;
    private final dl dl;
    private final Context g;
    private final a gc;
    private String[] gz;
    private final AtomicBoolean e = new AtomicBoolean(false);
    private long fo = 0;
    private long uy = 0;
    private long kb = 0;
    private long wp = 0;
    private boolean m = true;

    private z(Context context) {
        this.g = context;
        this.dl = dl.z(context);
        a aVarZ = a.z();
        this.gc = aVarZ;
        if (aVarZ != null) {
            String strDl = aVarZ.dl("cr", 3300000L);
            if (!TextUtils.isEmpty(strDl)) {
                this.f1263a = new r(aVarZ.dl("vd", z(strDl)), aVarZ.dl(NotificationCompat.CATEGORY_ERROR, z(strDl)), aVarZ.dl("tk", z(strDl)), aVarZ.dl("cr", z(strDl)));
            } else {
                this.f1263a = new r("", "", "", "");
            }
            dl();
            return;
        }
        this.f1263a = new r("", "-1", "", "");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long z(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            switch(r0) {
                case 49: goto L1c;
                case 50: goto L12;
                case 51: goto L8;
                default: goto L7;
            }
        L7:
            goto L26
        L8:
            java.lang.String r0 = "3"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L26
            r3 = 2
            goto L27
        L12:
            java.lang.String r0 = "2"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L26
            r3 = 0
            goto L27
        L1c:
            java.lang.String r0 = "1"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L26
            r3 = 1
            goto L27
        L26:
            r3 = -1
        L27:
            if (r3 == 0) goto L2d
            r0 = 3300000(0x325aa0, double:1.6304166E-317)
            return r0
        L2d:
            r0 = 50000(0xc350, double:2.47033E-319)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.mc.z.z(java.lang.String):long");
    }

    private boolean g() {
        a aVar = this.gc;
        if (aVar != null) {
            String strDl = aVar.dl("cr", 3300000L);
            if (!TextUtils.isEmpty(strDl) && !TextUtils.isEmpty(this.gc.dl("tk", z(strDl)))) {
                return true;
            }
        }
        return false;
    }

    private void dl() {
        a aVar = this.gc;
        if (aVar != null) {
            this.uy = aVar.g("uni_fir_ts", 0L);
            if (eo.z(System.currentTimeMillis(), this.uy)) {
                this.kb = this.gc.g("uni_times", 0L);
                this.wp = this.gc.g("uni_ts", 0L);
            } else {
                this.kb = 0L;
                this.wp = 0L;
            }
        }
    }

    public static z z(Context context) {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z(context);
                }
            }
        }
        return z;
    }

    public r z() {
        if (g() || !this.m) {
            return this.f1263a;
        }
        if (!this.e.compareAndSet(false, true)) {
            return this.f1263a;
        }
        gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.mc.z.1
            /* JADX WARN: Removed duplicated region for block: B:53:0x00cf  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x00e2  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instruction units count: 294
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.mc.z.AnonymousClass1.run():void");
            }
        });
        return this.f1263a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ca A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x010b A[ADDED_TO_REGION, EDGE_INSN: B:76:0x010b->B:58:0x010b BREAK  A[LOOP:0: B:3:0x0007->B:79:0x0007], REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(android.net.Network r16, java.util.List<java.lang.String> r17) {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.mc.z.z(android.net.Network, java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.e.set(false);
        this.dl.g();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z(android.net.Network r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.mc.z.z(android.net.Network, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    private Pair<String, String> z(Network network, String str, String str2, String str3) {
        String string;
        JSONObject jSONObjectZ = g.z(network, str, null);
        try {
            if (jSONObjectZ == null) {
                this.f1263a.z(str3, "6", "", str2);
                return new Pair<>("6", "");
            }
            String string2 = jSONObjectZ.has("err_code") ? jSONObjectZ.getString("err_code") : "6";
            if (this.gz == null || System.currentTimeMillis() - this.fo > bi.s) {
                this.gz = kb.fo();
                this.fo = System.currentTimeMillis();
            }
            String[] strArr = this.gz;
            if (strArr.length == 2 && !TextUtils.isEmpty(strArr[1])) {
                this.f1263a.z(this.gz[1]);
            }
            if (jSONObjectZ.has("province")) {
                this.f1263a.g(jSONObjectZ.getString("province"));
            }
            if (jSONObjectZ.has("code")) {
                string2 = "0";
                string = jSONObjectZ.getString("code");
            } else {
                string = "";
            }
            return new Pair<>(string2, string);
        } catch (Throwable unused) {
            return new Pair<>("6", "");
        }
    }
}
