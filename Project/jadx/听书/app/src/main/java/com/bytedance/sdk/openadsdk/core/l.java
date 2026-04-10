package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import java.io.Serializable;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class l extends com.bytedance.sdk.openadsdk.ls.dl.dl.a implements Serializable, Function<SparseArray<Object>, Object> {
    com.bytedance.sdk.openadsdk.ls.dl.dl.a z;

    @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
    public boolean e() {
        return false;
    }

    public l(com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar) {
        super(null);
        this.z = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
    public boolean z() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar = this.z;
        if (aVar == null) {
            if (super.z() && com.bytedance.sdk.openadsdk.core.uf.gc.z().z(zw.getContext(), com.kuaishou.weapon.p0.g.h) && com.bytedance.sdk.openadsdk.core.uf.gc.z().z(zw.getContext(), com.kuaishou.weapon.p0.g.g)) {
                return true;
            }
        } else if (aVar.z() && com.bytedance.sdk.openadsdk.core.uf.gc.z().z(zw.getContext(), com.kuaishou.weapon.p0.g.h) && com.bytedance.sdk.openadsdk.core.uf.gc.z().z(zw.getContext(), com.kuaishou.weapon.p0.g.g)) {
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
    public com.bytedance.sdk.openadsdk.ls.dl.dl.dl fo() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar = this.z;
        if (aVar == null) {
            return super.fo();
        }
        return aVar.fo();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
    public boolean g() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar = this.z;
        if (aVar == null) {
            return super.g();
        }
        return aVar.g();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
    public boolean dl() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar = this.z;
        if (aVar == null) {
            return super.dl();
        }
        return aVar.dl() && com.bytedance.sdk.openadsdk.core.uf.gc.z().z(zw.getContext(), com.kuaishou.weapon.p0.g.c);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
    public String uy() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar = this.z;
        if (aVar == null) {
            return super.uy();
        }
        return aVar.uy();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
    public boolean a() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar = this.z;
        if (aVar == null) {
            return super.a();
        }
        return aVar.a() && com.bytedance.sdk.openadsdk.core.uf.gc.z().z(zw.getContext(), com.kuaishou.weapon.p0.g.d);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
    public String kb() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar = this.z;
        if (aVar == null) {
            return super.kb();
        }
        return aVar.kb();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
    public boolean gc() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar = this.z;
        if (aVar == null) {
            return super.gc();
        }
        return aVar.gc() && com.bytedance.sdk.openadsdk.core.uf.gc.z().z(zw.getContext(), com.kuaishou.weapon.p0.g.j);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
    public String wp() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar = this.z;
        if (aVar == null) {
            return super.wp();
        }
        return aVar.wp();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
    public boolean m() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar = this.z;
        if (aVar == null) {
            return super.m();
        }
        return aVar.m();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
    public String v() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar = this.z;
        if (aVar == null) {
            return super.v();
        }
        return aVar.v();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
    public Map<String, Object> pf() {
        if (gk.dl < 6408) {
            return null;
        }
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar = this.z;
        if (aVar == null) {
            return super.pf();
        }
        return aVar.pf();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.dl.a
    public boolean gz() {
        if (gk.dl < 7000) {
            return true;
        }
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar = this.z;
        if (aVar == null) {
            return super.gz();
        }
        return aVar.gz();
    }

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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public java.lang.Object apply(android.util.SparseArray<java.lang.Object> r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L4
            return r0
        L4:
            r1 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            java.lang.Object r6 = r6.get(r1)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            switch(r6) {
                case 262101: goto L9a;
                case 262102: goto L70;
                case 262103: goto L67;
                case 262104: goto L5e;
                case 262105: goto L59;
                case 262106: goto L50;
                case 262107: goto L4b;
                case 262108: goto L42;
                case 262109: goto L3d;
                case 262110: goto L34;
                case 262111: goto L2b;
                case 262112: goto L26;
                default: goto L14;
            }
        L14:
            switch(r6) {
                case 262119: goto L21;
                case 262120: goto L18;
                default: goto L17;
            }
        L17:
            return r0
        L18:
            boolean r6 = r5.gz()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            return r6
        L21:
            java.util.Map r6 = r5.pf()
            return r6
        L26:
            java.lang.String r6 = r5.v()
            return r6
        L2b:
            boolean r6 = r5.e()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            return r6
        L34:
            boolean r6 = r5.m()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            return r6
        L3d:
            java.lang.String r6 = r5.wp()
            return r6
        L42:
            boolean r6 = r5.gc()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            return r6
        L4b:
            java.lang.String r6 = r5.kb()
            return r6
        L50:
            boolean r6 = r5.a()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            return r6
        L59:
            java.lang.String r6 = r5.uy()
            return r6
        L5e:
            boolean r6 = r5.dl()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            return r6
        L67:
            boolean r6 = r5.g()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            return r6
        L70:
            com.bytedance.sdk.openadsdk.ls.dl.dl.dl r6 = r5.fo()
            if (r6 == 0) goto L99
            double r0 = r6.z()
            double r2 = r6.g()
            com.bykv.z.z.z.z.z r6 = com.bykv.z.z.z.z.z.z()
            r4 = 262001(0x3ff71, float:3.67142E-40)
            com.bykv.z.z.z.z.z r6 = r6.z(r4, r0)
            r0 = 262002(0x3ff72, float:3.67143E-40)
            com.bykv.z.z.z.z.z r6 = r6.z(r0, r2)
            com.bykv.vk.openvk.api.proto.PluginValueSet r6 = r6.g()
            android.util.SparseArray r6 = r6.sparseArray()
            return r6
        L99:
            return r0
        L9a:
            boolean r6 = r5.z()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.l.apply(android.util.SparseArray):java.lang.Object");
    }
}
