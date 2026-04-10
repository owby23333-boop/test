package com.bytedance.sdk.openadsdk.core.q;

import android.content.Context;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fo implements com.bytedance.sdk.component.gz.z.a {
    @Override // com.bytedance.sdk.component.gz.z.a
    public String g() {
        return "csj_";
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public boolean i() {
        return false;
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public com.bytedance.sdk.component.gz.g.dl kb() {
        return null;
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public boolean m() {
        return true;
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public int uy() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public boolean z() {
        return false;
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public boolean v() {
        return zw.g().tb();
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public Looper pf() {
        return com.bytedance.sdk.component.uy.g.z.z().g().getLooper();
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public com.bytedance.sdk.component.gz.z.g z(JSONObject jSONObject) {
        try {
            jSONObject.put("is_new", true);
            jSONObject.put("sdk_session_id", g.z);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        com.bytedance.sdk.component.gz.g.a.z.z zVar = new com.bytedance.sdk.component.gz.g.a.z.z(UUID.randomUUID().toString(), com.bytedance.sdk.openadsdk.core.q.z.g.g().z("new_adlog_monitor").g(jSONObject.toString()).z());
        zVar.dl((byte) 0);
        zVar.g((byte) 2);
        zVar.z((byte) 1);
        return zVar;
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public boolean a() {
        return com.bytedance.sdk.openadsdk.core.gk.fo.z();
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public boolean z(Context context) {
        return com.bytedance.sdk.component.utils.v.z(context);
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public String gc() {
        return com.bytedance.sdk.openadsdk.core.un.uy.i();
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public com.bytedance.sdk.component.gz.z.z.g e() {
        return new uy(com.bytedance.sdk.openadsdk.core.io.gc.z().g().dl());
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    /* JADX INFO: renamed from: ls, reason: merged with bridge method [inline-methods] */
    public ExecutorService gz() {
        return com.bytedance.sdk.component.uy.e.g();
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public Executor fo() {
        return com.bytedance.sdk.component.uy.e.z();
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public String z(String str) {
        return com.bytedance.sdk.component.utils.z.dl(str);
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public String g(String str) {
        return com.bytedance.sdk.component.utils.z.g(str);
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public boolean dl() {
        return zw.g().q();
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public com.bytedance.sdk.component.gz.z.gz wp() {
        return z.z;
    }

    @Override // com.bytedance.sdk.component.gz.z.a
    public void z(JSONObject jSONObject, JSONObject jSONObject2) {
        boolean zNb = zw.g().nb();
        boolean z = false;
        if (jSONObject2 != null && jSONObject2.optInt("success") == 1) {
            z = true;
        }
        if (z && zNb) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.i.a.z(jSONObject, jSONObject2);
    }
}
