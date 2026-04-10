package com.bytedance.sdk.openadsdk.core.g.z.g;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.hh;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.i;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.sy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.e;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f1072a = new AtomicBoolean(true);
    private String dl;
    private final Context g;
    private g gc;
    private final na z;

    public interface g {
        void z();

        void z(String str, boolean z);
    }

    public interface z {
        void z();
    }

    public dl(na naVar, Context context) {
        this.z = naVar;
        this.g = context;
    }

    public dl z(String str) {
        this.dl = str;
        return this;
    }

    public void z(g gVar) {
        this.gc = gVar;
    }

    public static boolean z(na naVar, boolean z2) {
        i iVarFb = naVar != null ? naVar.fb() : null;
        return iVarFb != null && iVarFb.z(z2);
    }

    public int z(final z zVar) {
        na naVar = this.z;
        i iVarFb = naVar != null ? naVar.fb() : null;
        z(iVarFb);
        g(iVarFb);
        q.m().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.g.z.g.dl.1
            @Override // java.lang.Runnable
            public void run() {
                z zVar2 = zVar;
                if (zVar2 != null) {
                    zVar2.z();
                }
            }
        }, 500L);
        return 1;
    }

    private void z(i iVar) {
        if (iVar == null || TextUtils.isEmpty(iVar.a())) {
            return;
        }
        final String strA = iVar.a();
        e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.g.z.g.dl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    hh.g(dl.this.g.getApplicationContext(), strA, 0, 17, 0, 0);
                } catch (Throwable th) {
                    wp.z(th);
                }
            }
        });
    }

    private void g(final i iVar) {
        if (iVar == null) {
            return;
        }
        try {
            zw.z().z(iVar.g(), new sy.dl<com.bytedance.sdk.component.fo.g>() { // from class: com.bytedance.sdk.openadsdk.core.g.z.g.dl.3
                @Override // com.bytedance.sdk.openadsdk.core.sy.dl
                public void z(int i, String str) {
                    dl.this.z();
                    dl.this.dl(iVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.sy.dl
                public void z(com.bytedance.sdk.component.fo.g gVar) {
                    if (gVar == null || !gVar.gz() || TextUtils.isEmpty(gVar.a())) {
                        dl.this.z();
                        dl.this.dl(iVar);
                    } else {
                        try {
                            dl.this.z(new JSONObject(gVar.a()));
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        com.bytedance.sdk.openadsdk.core.i.a.g(this.z, this.dl, 4);
        g gVar = this.gc;
        if (gVar != null) {
            gVar.z("net_fail", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(JSONObject jSONObject) {
        try {
            if (jSONObject.has("is_apply_coupon")) {
                g(jSONObject);
            }
        } catch (Throwable unused) {
            z();
        }
    }

    private void g(JSONObject jSONObject) {
        boolean zOptBoolean = jSONObject.optBoolean("is_apply_coupon");
        String strOptString = jSONObject.optString("error_type");
        if (zOptBoolean && "success".equals(strOptString)) {
            com.bytedance.sdk.openadsdk.core.i.a.g(this.z, this.dl, 1);
        } else if (zOptBoolean && "has_applied".equals(strOptString)) {
            com.bytedance.sdk.openadsdk.core.i.a.g(this.z, this.dl, 2);
        } else if (!zOptBoolean) {
            com.bytedance.sdk.openadsdk.core.i.a.g(this.z, this.dl, 3);
        }
        if (this.gc != null) {
            if (zOptBoolean && "success".equals(strOptString)) {
                this.gc.z();
            } else {
                this.gc.z(strOptString, zOptBoolean);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(i iVar) {
        if (this.f1072a.getAndSet(false)) {
            g(iVar);
        }
    }
}
