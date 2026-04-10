package com.bytedance.sdk.openadsdk.core.dt;

import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class ue {
    private int bf;
    private String d;
    private String e;
    private int ga;
    private String p;
    private String tg;
    private String v;
    private int vn;

    public static ue e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ue ueVar = new ue();
        try {
            ueVar.e(jSONObject.optInt("wc_skip_type"));
            ueVar.e(jSONObject.optString("wc_miniapp_link"));
            ueVar.bf(jSONObject.optString("adv_id"));
            ueVar.d(jSONObject.optString(TTLiveConstants.APP_SITEID_KEY));
            ueVar.d(jSONObject.optInt("wc_open_method"));
            ueVar.tg(jSONObject.optString("wc_miniapp_sdk"));
            ueVar.ga(jSONObject.optString("wc_appid"));
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wu.bf("parse WechatData failed:" + th.getMessage());
        }
        return ueVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x000f A[SYNTHETIC] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String ue1691727045732dc(java.lang.String r2) {
        /*
        L0:
            r0 = 74
            r1 = 55
        L4:
            switch(r0) {
                case 72: goto L0;
                case 73: goto L8;
                case 74: goto Lb;
                default: goto L7;
            }
        L7:
            goto L2b
        L8:
            switch(r1) {
                case 94: goto L26;
                case 95: goto Lf;
                case 96: goto Lf;
                default: goto Lb;
            }
        Lb:
            switch(r1) {
                case 55: goto L26;
                case 56: goto L26;
                case 57: goto Lf;
                default: goto Le;
            }
        Le:
            goto L26
        Lf:
            char[] r2 = r2.toCharArray()
            r0 = 0
        L14:
            int r1 = r2.length
            if (r0 >= r1) goto L20
            char r1 = r2[r0]
            r1 = r1 ^ r0
            char r1 = (char) r1
            r2[r0] = r1
            int r0 = r0 + 1
            goto L14
        L20:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            return r0
        L26:
            r0 = 73
            r1 = 96
            goto L4
        L2b:
            r0 = 72
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.dt.ue.ue1691727045732dc(java.lang.String):java.lang.String");
    }

    public int bf() {
        return this.bf;
    }

    public String d() {
        return this.d;
    }

    public int ga() {
        return this.ga;
    }

    public String p() {
        return this.p;
    }

    public String tg() {
        return this.tg;
    }

    public String toString() {
        return zk().toString();
    }

    public String v() {
        return this.v;
    }

    public int vn() {
        return this.vn;
    }

    public JSONObject zk() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wc_skip_type", bf());
            jSONObject.put("wc_miniapp_link", e());
            jSONObject.put("adv_id", d());
            jSONObject.put(TTLiveConstants.APP_SITEID_KEY, tg());
            jSONObject.put("wc_open_method", vn());
            jSONObject.put("wc_miniapp_sdk", p());
            jSONObject.put("wc_appid", v());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wu.bf("toString failed:" + th.getMessage());
        }
        return jSONObject;
    }

    public void bf(int i) {
        this.ga = i;
    }

    public void d(int i) {
        this.vn = i;
    }

    public String e() {
        return this.e;
    }

    public void ga(String str) {
        this.v = str;
    }

    public void tg(String str) {
        this.p = str;
    }

    public void bf(String str) {
        this.d = str;
    }

    public void d(String str) {
        this.tg = str;
    }

    public void e(int i) {
        this.bf = i;
    }

    public void e(String str) {
        this.e = str;
    }
}
