package com.bytedance.adsdk.ugeno.gc.dl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.gc.kb;
import com.bytedance.adsdk.ugeno.gc.m;
import com.bytedance.adsdk.ugeno.gc.uy;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected m.z f241a;
    protected com.bytedance.adsdk.ugeno.gc.m dl;
    protected String e;
    protected String fo;
    protected com.bytedance.adsdk.ugeno.g.dl g;
    protected Map<String, String> gc;
    protected String gz;
    protected String m;
    protected Context uy;
    protected kb z;

    public abstract boolean z(Object... objArr);

    public g(Context context) {
        this.uy = context;
    }

    public void m() {
        this.f241a = this.dl.z();
        com.bytedance.adsdk.ugeno.gc.m mVar = this.dl;
        if (mVar == null) {
            return;
        }
        m.z zVarZ = mVar.z();
        this.f241a = zVarZ;
        if (zVarZ == null) {
            return;
        }
        this.gc = zVarZ.dl();
        this.m = this.f241a.g();
        this.e = this.f241a.z();
        this.gz = this.f241a.a();
        this.fo = this.f241a.gc();
    }

    public String e() {
        return this.m;
    }

    public String gz() {
        return this.gz;
    }

    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar) {
        this.g = dlVar;
    }

    public void z(com.bytedance.adsdk.ugeno.gc.m mVar) {
        this.dl = mVar;
    }

    public void z(kb kbVar) {
        this.z = kbVar;
    }

    public static class z {
        public static g z(Context context, com.bytedance.adsdk.ugeno.g.dl dlVar, JSONObject jSONObject, JSONObject jSONObject2) {
            com.bytedance.adsdk.ugeno.gc.m mVarZ;
            m.z zVarZ;
            com.bytedance.adsdk.ugeno.gc.e eVarZ;
            if (dlVar == null || jSONObject == null || (mVarZ = com.bytedance.adsdk.ugeno.gc.m.z(jSONObject, jSONObject2)) == null || (zVarZ = mVarZ.z()) == null) {
                return null;
            }
            String strZ = zVarZ.z();
            if (TextUtils.equals(strZ, MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM)) {
                dl dlVar2 = new dl(context);
                dlVar2.z(dlVar);
                dlVar2.z(mVarZ);
                dlVar2.m();
                return dlVar2;
            }
            if (TextUtils.isEmpty(strZ) || TextUtils.equals(strZ, "global")) {
                eVarZ = uy.z(zVarZ.g());
            } else {
                eVarZ = uy.z(zVarZ.gc());
            }
            if (eVarZ == null) {
                return null;
            }
            g gVarZ = eVarZ.z(context);
            gVarZ.z(dlVar);
            gVarZ.z(mVarZ);
            gVarZ.m();
            return gVarZ;
        }
    }
}
