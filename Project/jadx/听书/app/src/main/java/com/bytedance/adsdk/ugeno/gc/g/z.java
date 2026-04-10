package com.bytedance.adsdk.ugeno.gc.g;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.gc.m;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {
    public static final HashSet<String> z = new HashSet<>(Arrays.asList("convert", "dislike", "openAppPermission", "openAppPolicy", "openPrivacy", "openAppFunction", ILivePush.ClickType.CLOSE, "skip", "videoControl", "pauseVideo", "resumeVideo", "muteVideo", "preventEvent"));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f243a;
    protected com.bytedance.adsdk.ugeno.g.dl dl;
    protected String e;
    protected m.z g;
    protected String gc;
    protected String gz;
    protected Map<String, String> m;

    public abstract void z();

    public z(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, m.z zVar) {
        this.dl = dlVar;
        this.g = zVar;
        this.e = str;
        gc();
    }

    private void gc() {
        m.z zVar = this.g;
        if (zVar == null) {
            return;
        }
        this.f243a = zVar.z();
        this.gc = this.g.g();
        Map<String, String> mapDl = this.g.dl();
        this.m = mapDl;
        if (mapDl == null || mapDl.isEmpty() || !this.m.containsKey("emitCustomEvent")) {
            return;
        }
        this.gz = this.m.get("emitCustomEvent");
    }

    public void g() {
        dl();
    }

    public void dl() {
        if (a()) {
            m.z zVar = new m.z();
            zVar.z(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
            zVar.g("emit");
            HashMap map = new HashMap();
            map.put("name", this.gz);
            zVar.z(map);
            new g(this.dl, this.gc, zVar).z();
        }
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.gz);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.gc.g.z$z, reason: collision with other inner class name */
    public static class C0046z {
        public static z z(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, m.z zVar) {
            if (zVar == null) {
                return null;
            }
            com.bytedance.adsdk.ugeno.gc.g gVarZ = com.bytedance.adsdk.ugeno.gc.a.z(zVar.g());
            if (gVarZ == null) {
                return new dl(dlVar, str, zVar);
            }
            z zVarZ = gVarZ.z(dlVar, str, zVar);
            return zVarZ == null ? new dl(dlVar, str, zVar) : zVarZ;
        }
    }
}
