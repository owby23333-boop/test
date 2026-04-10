package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1;

import com.bytedance.msdk.api.v2.ad.custom.bean.GMCustomInitConfig;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private GMCustomInitConfig f1415c;

    public a(String str, String str2) {
        this.a = str;
        this.b = str2;
        this.f1415c = new GMCustomInitConfig();
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.a = str2;
        this.b = str3;
        this.f1415c = new GMCustomInitConfig(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a a(java.lang.String r14, org.json.JSONObject r15) {
        /*
            if (r15 == 0) goto L5b
            java.lang.String r0 = "app_id"
            java.lang.String r3 = r15.optString(r0)
            java.lang.String r0 = "app_key"
            java.lang.String r4 = r15.optString(r0)
            java.lang.String r0 = "custom_type"
            java.lang.String r13 = r15.optString(r0)
            java.lang.String r0 = "1"
            boolean r0 = android.text.TextUtils.equals(r13, r0)
            if (r0 != 0) goto L22
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a r14 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a
            r14.<init>(r3, r4)
            goto L68
        L22:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a r0 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a
            java.lang.String r1 = "init_class_name"
            java.lang.String r5 = r15.optString(r1)
            java.lang.String r1 = "banner_class_name"
            java.lang.String r6 = r15.optString(r1)
            java.lang.String r1 = "interstitial_class_name"
            java.lang.String r7 = r15.optString(r1)
            java.lang.String r1 = "reward_class_name"
            java.lang.String r8 = r15.optString(r1)
            java.lang.String r1 = "full_video_class_name"
            java.lang.String r9 = r15.optString(r1)
            java.lang.String r1 = "splash_class_name"
            java.lang.String r10 = r15.optString(r1)
            java.lang.String r1 = "feed_class_name"
            java.lang.String r11 = r15.optString(r1)
            java.lang.String r1 = "draw_class_name"
            java.lang.String r12 = r15.optString(r1)
            r1 = r0
            r2 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r14 = r0
            goto L68
        L5b:
            r14 = 95
            switch(r14) {
                case 94: goto L67;
                case 95: goto L67;
                case 96: goto L61;
                default: goto L60;
            }
        L60:
            goto L5b
        L61:
            r14 = 70
            switch(r14) {
                case 70: goto L5b;
                case 71: goto L5b;
                case 72: goto L67;
                default: goto L66;
            }
        L66:
            goto L61
        L67:
            r14 = 0
        L68:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a.a(java.lang.String, org.json.JSONObject):bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a");
    }

    public String a() {
        while (true) {
            switch (73) {
                case 72:
                case 73:
                case 74:
                    return this.a;
            }
        }
    }

    public String b() {
        while (true) {
            switch (73) {
                case 72:
                case 73:
                case 74:
                    return this.b;
            }
        }
    }

    public GMCustomInitConfig c() {
        while (true) {
            switch (73) {
                case 72:
                case 73:
                case 74:
                    return this.f1415c;
            }
        }
    }

    /* JADX INFO: Infinite loop detected, blocks: 3, insns: 0 */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x000c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0013 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x002f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[LOOP:0: B:7:0x000d->B:26:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x000f -> B:10:0x0013). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x000f -> B:6:0x000c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d() {
        /*
            r6 = this;
            com.bytedance.msdk.api.v2.ad.custom.bean.GMCustomInitConfig r0 = r6.f1415c
            r1 = 1
            r2 = 0
            if (r0 == 0) goto Lb
            boolean r0 = r0.isCustom()
            goto L13
        Lb:
            r0 = 0
        Lc:
            r3 = 0
        Ld:
            r4 = 49
            switch(r4) {
                case 49: goto L2f;
                case 50: goto L13;
                case 51: goto Lc;
                default: goto L12;
            }
        L12:
            goto Ld
        L13:
            if (r0 == 0) goto Lc
        L15:
            r3 = 13
            r4 = 52
            r5 = 96
            switch(r5) {
                case 94: goto L2d;
                case 95: goto L1f;
                case 96: goto L2d;
                default: goto L1e;
            }
        L1e:
            goto L15
        L1f:
            switch(r4) {
                case 55: goto L27;
                case 56: goto L2d;
                case 57: goto L30;
                default: goto L22;
            }
        L22:
            r4 = 55
            r3 = 61
            goto L1f
        L27:
            switch(r3) {
                case 60: goto L15;
                case 61: goto L15;
                case 62: goto L2b;
                default: goto L2a;
            }
        L2a:
            goto L2d
        L2b:
            goto L2b
        L2d:
            r3 = 1
            goto Ld
        L2f:
            r1 = r3
        L30:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a.d():boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0003, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0003, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0005. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r3 = this;
            r0 = 55
            r1 = 0
        L3:
            r2 = 72
        L5:
            switch(r2) {
                case 72: goto L4c;
                case 73: goto L13;
                case 74: goto L9;
                default: goto L8;
            }
        L8:
            goto L3
        L9:
            switch(r1) {
                case 52: goto L3;
                case 53: goto Ld;
                case 54: goto L4c;
                default: goto Lc;
            }
        Lc:
            goto L4c
        Ld:
            switch(r0) {
                case 29: goto L17;
                case 30: goto L3;
                case 31: goto L9;
                default: goto L10;
            }
        L10:
            r0 = 30
            goto Ld
        L13:
            r2 = 57
            if (r1 > r2) goto L4c
        L17:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "AdNetworkConfValue{mAppId='"
            r0.append(r1)
            java.lang.String r1 = r3.a
            r0.append(r1)
            r1 = 39
            r0.append(r1)
            java.lang.String r2 = ", mAppKey='"
            r0.append(r2)
            java.lang.String r2 = r3.b
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = ", mGMCustomConfig="
            r0.append(r1)
            com.bytedance.msdk.api.v2.ad.custom.bean.GMCustomInitConfig r1 = r3.f1415c
            r0.append(r1)
            r1 = 125(0x7d, float:1.75E-43)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        L4c:
            r1 = 16
            r2 = 73
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a.toString():java.lang.String");
    }
}
