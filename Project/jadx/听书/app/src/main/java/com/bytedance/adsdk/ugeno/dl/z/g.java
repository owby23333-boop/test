package com.bytedance.adsdk.ugeno.dl.z;

import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.dl.ls;
import com.bytedance.adsdk.ugeno.g.dl;
import com.bytedance.adsdk.ugeno.gc.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g implements fv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected JSONObject f234a;
    protected String g;
    protected fv z;
    protected boolean dl = true;
    protected boolean gc = false;

    public abstract void dl(ls lsVar, fv.g gVar, fv.z zVar);

    public g(fv fvVar) {
        this.z = fvVar;
    }

    public void z(JSONObject jSONObject) {
        this.f234a = jSONObject;
    }

    public void z(String str) {
        this.g = str;
    }

    public void z(boolean z) {
        this.dl = z;
    }

    public boolean z() {
        String str;
        return this.dl && (str = this.g) != null && "3".compareTo(str) <= 0 && this.f234a != null;
    }

    public void g(boolean z) {
        this.gc = z;
    }

    @Override // com.bytedance.adsdk.ugeno.dl.fv
    public void z(ls lsVar, fv.g gVar, fv.z zVar) {
        if (z()) {
            dl(lsVar, gVar, zVar);
        } else {
            g(lsVar, gVar, zVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.dl.fv
    public void z(dl dlVar, String str, m.z zVar) {
        fv fvVar = this.z;
        if (fvVar == null) {
            return;
        }
        fvVar.z(dlVar, str, zVar);
    }

    protected void g(ls lsVar, fv.g gVar, fv.z zVar) {
        fv fvVar = this.z;
        if (fvVar == null) {
            return;
        }
        fvVar.z(lsVar, gVar, zVar);
    }
}
