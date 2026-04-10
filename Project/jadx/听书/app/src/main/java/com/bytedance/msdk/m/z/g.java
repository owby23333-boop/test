package com.bytedance.msdk.m.z;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.msdk.api.a.kb;
import com.bytedance.msdk.gz.io;
import com.bytedance.msdk.gz.l;
import com.bytedance.msdk.z.z.a;
import com.bytedance.msdk.z.z.dl;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {
    private dl z;
    private final Set<String> g = new CopyOnWriteArraySet();
    private boolean dl = false;

    protected abstract String dl();

    protected abstract String g();

    protected abstract Map<String, Object> z();

    public void a() {
        g((kb) null);
    }

    public void z(kb kbVar) {
        this.dl = true;
        g(kbVar);
    }

    public void z(kb kbVar, dl dlVar) {
        this.z = dlVar;
        this.dl = true;
        g(kbVar);
    }

    private void g(kb kbVar) {
        com.bytedance.msdk.core.uy.z zVarZ = com.bytedance.msdk.core.g.g().z(g());
        if (kbVar == null && zVarZ == null && !MediationConstant.ADN_PANGLE.equals(g())) {
            return;
        }
        dl(kbVar);
    }

    private synchronized void dl(kb kbVar) {
        try {
            if (this.dl || !com.bytedance.msdk.m.g.z.a(g())) {
                String strDl = dl();
                if (!TextUtils.isEmpty(strDl)) {
                    throw new Exception("adn init ".concat(String.valueOf(strDl)));
                }
                Map<String, Object> mapZ = z();
                if (mapZ == null) {
                    throw new Exception("adn init getConfig() is null");
                }
                mapZ.put(MediationConstant.EXTRA_ADN_NAME, g());
                mapZ.put("q_x_c", Integer.valueOf(com.bytedance.msdk.e.z.z.z().a()));
                mapZ.put("wf_q_x_c", Integer.valueOf(com.bytedance.msdk.e.z.z.z().gc()));
                a aVarZ = com.bytedance.msdk.m.g.g.z().z(g(), kbVar);
                if (aVarZ == null) {
                    throw new Exception("configuration is null");
                }
                z(aVarZ, mapZ);
                if (!this.dl) {
                    com.bytedance.msdk.m.g.z.dl(g());
                }
            }
        } catch (Throwable th) {
            wp.z(th);
            com.bytedance.msdk.m.g.z.z(g(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, th.toString()));
        }
    }

    private synchronized void z(a aVar, Map<String, Object> map) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.msdk.z.gc.dl.z("TMe", "--==--time: start " + g());
        aVar.z(com.bytedance.msdk.core.g.getContext(), map, new dl() { // from class: com.bytedance.msdk.m.z.g.1
            @Override // com.bytedance.msdk.z.z.dl
            public void z() {
                if (g.this.z != null) {
                    g.this.z.z();
                }
                if (TextUtils.equals(g.this.g(), MediationConstant.ADN_PANGLE)) {
                    io.z();
                }
                long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                com.bytedance.msdk.z.gc.dl.z("TMe", "--==--time: " + g.this.g() + ", ----==----- " + jElapsedRealtime2);
                if (!g.this.g.contains(g.this.g())) {
                    g.this.g.add(g.this.g());
                    l.dl(g.this.g(), jElapsedRealtime2);
                }
                com.bytedance.msdk.m.g.z.z(g.this.g(), (Pair<Boolean, String>) new Pair(Boolean.TRUE, ""));
            }

            @Override // com.bytedance.msdk.z.z.dl
            public void z(com.bytedance.msdk.api.z zVar) {
                if (g.this.z != null) {
                    g.this.z.z(zVar);
                }
                if (zVar != null) {
                    com.bytedance.msdk.m.g.z.z(g.this.g(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, "errorCode = " + zVar.z + " errorMessage = " + zVar.g));
                }
            }
        });
    }
}
