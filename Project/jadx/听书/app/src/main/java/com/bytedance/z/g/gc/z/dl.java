package com.bytedance.z.g.gc.z;

import android.content.Context;
import android.os.Process;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.z.g.gz;
import com.bytedance.z.g.gz.pf;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.an;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected g f1517a;
    protected com.bytedance.z.g.gc dl = gz.z().dl();
    protected Context g;
    protected a gc;
    protected com.bytedance.z.g.dl z;

    protected boolean g() {
        return true;
    }

    protected boolean z() {
        return true;
    }

    dl(com.bytedance.z.g.dl dlVar, Context context, g gVar, a aVar) {
        this.z = dlVar;
        this.g = context;
        this.f1517a = gVar;
        this.gc = aVar;
    }

    public com.bytedance.z.g.dl.z z(com.bytedance.z.g.dl.z zVar) {
        if (zVar == null) {
            zVar = new com.bytedance.z.g.dl.z();
        }
        g(zVar);
        gc(zVar);
        return zVar;
    }

    void g(com.bytedance.z.g.dl.z zVar) {
        g gVar;
        if (g() && (gVar = this.f1517a) != null) {
            zVar.z(gVar);
        }
        zVar.z(gz.m());
        g gVar2 = this.f1517a;
        zVar.z("is_background", Boolean.valueOf((gVar2 == null || !gVar2.dl()) && !com.bytedance.z.g.gz.z.z(this.g)));
        zVar.z("pid", Integer.valueOf(Process.myPid()));
        zVar.z(an.Z, Integer.valueOf(this.gc.z()));
        zVar.z(this.dl.gc());
        zVar.g(gz.fo());
        zVar.z(gz.uy(), gz.kb());
        zVar.z(this.dl.m());
        zVar.z(pf.z(this.g));
        if (z()) {
            a(zVar);
        }
        zVar.z(this.dl.a());
        String strE = gz.e();
        if (strE != null) {
            zVar.z("business", strE);
        }
        if (gz.gz()) {
            zVar.z("is_mp", (Object) 1);
        }
        zVar.dl(gz.g().z());
        zVar.z("crash_uuid", UUID.randomUUID().toString());
    }

    void dl(com.bytedance.z.g.dl.z zVar) {
        Map<String, Object> mapZ = gz.z().z();
        if (mapZ == null) {
            return;
        }
        if (mapZ.containsKey("app_version")) {
            zVar.z("crash_version", mapZ.get("app_version"));
        }
        if (mapZ.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) {
            zVar.z("app_version", mapZ.get(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
        }
        if (mapZ.containsKey("version_code")) {
            try {
                zVar.z("crash_version_code", Integer.valueOf(Integer.parseInt(mapZ.get("version_code").toString())));
            } catch (Exception unused) {
                zVar.z("crash_version_code", mapZ.get("version_code"));
            }
        }
        if (mapZ.containsKey("update_version_code")) {
            try {
                zVar.z("crash_update_version_code", Integer.valueOf(Integer.parseInt(mapZ.get("update_version_code").toString())));
            } catch (Exception unused2) {
                zVar.z("crash_update_version_code", mapZ.get("update_version_code"));
            }
        }
    }

    private void gc(com.bytedance.z.g.dl.z zVar) {
        List<com.bytedance.z.g.z> listZ = gz.g().z(this.z);
        if (listZ != null) {
            JSONObject jSONObject = new JSONObject();
            Iterator<com.bytedance.z.g.z> it = listZ.iterator();
            while (it.hasNext()) {
                Map<? extends String, ? extends String> mapZ = it.next().z(this.z);
                if (mapZ != null) {
                    try {
                        for (String str : mapZ.keySet()) {
                            jSONObject.put(str, mapZ.get(str));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            zVar.z(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject);
        }
    }

    protected void a(com.bytedance.z.g.dl.z zVar) {
        zVar.g(com.bytedance.z.g.gc.a.z(gz.gc().a(), gz.gc().gc()));
    }
}
