package com.bytedance.sdk.openadsdk.z.z;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.pf.a;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import com.volcengine.mobsecBiz.metasec.ml.PglMSConfig;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManager;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManagerUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import ms.bz.bd.c.Pgl.pblu;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile a fo = null;
    private static volatile String m = "";
    private static volatile z z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1501a;
    private volatile boolean dl;
    private final AtomicBoolean e = new AtomicBoolean(false);
    private PglMSManager g;
    private volatile String gc;
    private volatile int gz;

    private static z a(String str) {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z(str);
                }
            }
        }
        return z;
    }

    public static z z() {
        return z;
    }

    private z(String str) {
        this.gz = pblu.COLLECT_MODE_DEFAULT;
        String strQ = uy.ls().q();
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = uy.ls().p();
        if (aVarP != null) {
            if (!aVarP.dl() || !aVarP.a() || !aVarP.gc()) {
                this.gz = 290;
            } else if (!aVarP.g()) {
                this.gz = 810;
            }
            if (gk.dl >= 4600 && !aVarP.m()) {
                this.gz = 290;
            }
        }
        this.gc = null;
        this.f1501a = strQ;
        this.dl = gc(str);
    }

    private boolean gc(String str) {
        try {
            Context context = zw.getContext();
            PglMSConfig.Builder builder = new PglMSConfig.Builder("1371", this.f1501a, "THYFfhd167Y/Etj/JFI+OYhGnAsIhCvIXKQbbKuslfRMO6XQmCuZImqOyljyF6dQ900Hy8ecQzUcHu72ks7Xvvncqt7BZjf4VSth/OzZbJlDJqtayy2lcb5mqCQUzE5fIvFXAZkyxl+SRzGnzUojBcyqITZ3bGRvteMi+qu/15oKM3BWY0IDJ9Ry5FUGfzt+FyCqvZI8PFQNAzvZXcWHlJoRXydZUjUbtEy/AFUvusIO1HDx", this.gz);
            builder.addDataObserver(new PglITokenObserver() { // from class: com.bytedance.sdk.openadsdk.z.z.z.1
                @Override // com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver
                public void onTokenLoaded(String str2) {
                    String unused = z.m = str2;
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.dl.a.z().pf(str2);
                }
            });
            if (!uy.ls().gz()) {
                builder.addAdvanceInfo("kOA1", "1");
            } else if (!uy.ls().kb()) {
                builder.setOaid(str);
            }
            if (!uy.ls().gc()) {
                builder.addAdvanceInfo("kS1", "1");
            }
            if (!uy.ls().wp()) {
                builder.addAdvanceInfo("kDisableBlueToothCollection", "1");
            }
            PglMSManagerUtils.init(context, builder.setDeviceID(this.gc).setClientType(1).build());
            PglMSManagerUtils.initToken("1371");
            dl();
            return true;
        } catch (Throwable th) {
            wp.g("MSSdkImpl", "appid 为空，初始化失败！", th);
            return false;
        }
    }

    private void dl() {
        if (this.g == null) {
            this.g = PglMSManagerUtils.get("1371");
        }
    }

    public void z(String str) {
        if (this.dl) {
            dl();
            if (TextUtils.isEmpty(str) || str.equals(this.gc) || this.g == null) {
                return;
            }
            this.gc = str;
            this.g.setDeviceID(str);
        }
    }

    public void g(String str) {
        if (this.dl) {
            dl();
            PglMSManager pglMSManager = this.g;
            if (pglMSManager != null) {
                pglMSManager.report(str);
            }
        }
    }

    public static String g() {
        if (TextUtils.isEmpty(m)) {
            m = com.bytedance.sdk.openadsdk.core.dl.a.z().q();
        }
        return m;
    }

    public Map<String, String> z(String str, byte[] bArr) {
        if (!this.dl) {
            return new HashMap();
        }
        dl();
        PglMSManager pglMSManager = this.g;
        if (pglMSManager != null) {
            return pglMSManager.getFeatureHash(str, bArr);
        }
        return new HashMap();
    }

    public static void z(a aVar) {
        fo = aVar;
        z(true);
    }

    public static z z(boolean z2) {
        if (uy.ls().uy()) {
            if (fo != null) {
                if (z == null) {
                    return a(com.bytedance.sdk.openadsdk.core.un.zw.dl(fo));
                }
                return z;
            }
            if (z2) {
                return a("error");
            }
            return null;
        }
        return a(null);
    }
}
