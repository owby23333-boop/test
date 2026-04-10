package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f1454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f1455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f1456f;

    public e(String str, String str2, String str3, int i2, String str4, double d2, double d3) {
        this.a = str2;
        this.b = str3;
        this.f1453c = i2;
        this.f1454d = str4;
        this.f1455e = d2;
        this.f1456f = d3;
    }

    public static e a(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return null;
        }
        return new e(str, jSONObject.optString("label_name"), jSONObject.optString("timestamp"), jSONObject.optInt("label_id"), jSONObject.optString("label_version"), jSONObject.optDouble("upper_bound"), jSONObject.optDouble("lower_bound"));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0006. Please report as an issue. */
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
    public int a() {
        /*
            r3 = this;
            int r0 = r3.f1453c
        L2:
            r1 = 93
            r2 = 93
        L6:
            switch(r2) {
                case 92: goto Le;
                case 93: goto L11;
                case 94: goto La;
                default: goto L9;
            }
        L9:
            goto L2
        La:
            r2 = 4
            if (r1 <= r2) goto L2
            goto L17
        Le:
            switch(r1) {
                case 21: goto L17;
                case 22: goto L18;
                case 23: goto L18;
                default: goto L11;
            }
        L11:
            switch(r1) {
                case 91: goto L18;
                case 92: goto L17;
                case 93: goto L18;
                default: goto L14;
            }
        L14:
            r1 = 91
            goto L11
        L17:
            return r0
        L18:
            r2 = 94
            r1 = 75
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.e.a():int");
    }

    public String b() {
        while (true) {
            switch (73) {
                case 72:
                case 73:
                case 74:
                    return this.a;
            }
        }
    }

    public String c() {
        while (true) {
            switch (73) {
                case 72:
                case 73:
                case 74:
                    return this.f1454d;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0006. Please report as an issue. */
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
    public double d() {
        /*
            r4 = this;
            double r0 = r4.f1456f
        L2:
            r2 = 93
            r3 = 93
        L6:
            switch(r3) {
                case 92: goto Le;
                case 93: goto L11;
                case 94: goto La;
                default: goto L9;
            }
        L9:
            goto L2
        La:
            r3 = 4
            if (r2 <= r3) goto L2
            goto L17
        Le:
            switch(r2) {
                case 21: goto L17;
                case 22: goto L18;
                case 23: goto L18;
                default: goto L11;
            }
        L11:
            switch(r2) {
                case 91: goto L18;
                case 92: goto L17;
                case 93: goto L18;
                default: goto L14;
            }
        L14:
            r2 = 91
            goto L11
        L17:
            return r0
        L18:
            r3 = 94
            r2 = 75
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.e.d():double");
    }

    public String e() {
        while (true) {
            switch (73) {
                case 72:
                case 73:
                case 74:
                    return this.b;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x000f. Please report as an issue. */
    public double f() {
        double d2 = this.f1455e;
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                if (c2 == '\\') {
                    switch (c3) {
                        case 22:
                        case 23:
                            c2 = ']';
                            c3 = ']';
                            break;
                    }
                } else if (c2 != ']') {
                    c2 = ']';
                    c3 = ']';
                }
            }
            while (true) {
                switch (c3) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c3 = '[';
                        break;
                }
            }
        }
        return d2;
    }
}
