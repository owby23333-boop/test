package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class d extends c {

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private int f1549h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private int f1550i0;

    protected d(Context context, String str) {
        super(context, str);
        this.f1549h0 = 0;
        this.f1550i0 = -1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x003f. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x0043. Please report as an issue. */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private void k(int r2) {
        /*
            r1 = this;
            int r0 = r1.f1550i0
            if (r2 <= r0) goto L47
            r1.f1550i0 = r2
            java.util.List<java.lang.Integer> r0 = r1.f1625n
            if (r0 == 0) goto L47
            int r0 = r0.size()
            if (r2 >= r0) goto L47
            java.util.List<java.lang.Integer> r0 = r1.f1625n
            java.lang.Object r2 = r0.get(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 == 0) goto L47
            java.util.Map<java.lang.Integer, java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j>> r0 = r1.f1616e
            if (r0 == 0) goto L47
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L47
            java.util.Map<java.lang.Integer, java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j>> r0 = r1.f1616e
            java.lang.Object r2 = r0.get(r2)
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L47
            int r0 = r1.f1549h0
            int r2 = r2.size()
            int r2 = r2 + r0
            r1.f1549h0 = r2
        L37:
            r2 = 92
            switch(r2) {
                case 90: goto L37;
                case 91: goto L3d;
                case 92: goto L3d;
                default: goto L3c;
            }
        L3c:
            goto L37
        L3d:
            r0 = 9
            switch(r0) {
                case 9: goto L47;
                case 10: goto L43;
                case 11: goto L37;
                default: goto L42;
            }
        L42:
            goto L3d
        L43:
            switch(r2) {
                case 40: goto L37;
                case 41: goto L3d;
                case 42: goto L3d;
                default: goto L46;
            }
        L46:
            goto L37
        L47:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.d.k(int):void");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.f, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e
    protected void a(int i2, boolean z2) {
        while (true) {
            switch (73) {
                case 72:
                case 73:
                case 74:
                    try {
                        k(i2);
                        break;
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    super.a(i2, z2);
                    return;
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
    public int d0() {
        /*
            r3 = this;
            int r0 = r3.f1549h0
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.d.d0():int");
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
    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    public int h() {
        /*
            r2 = this;
        L0:
            r0 = 93
            r1 = 93
        L4:
            switch(r1) {
                case 92: goto Lc;
                case 93: goto Lf;
                case 94: goto L8;
                default: goto L7;
            }
        L7:
            goto L0
        L8:
            r1 = 4
            if (r0 <= r1) goto L0
            goto L15
        Lc:
            switch(r0) {
                case 21: goto L15;
                case 22: goto L17;
                case 23: goto L17;
                default: goto Lf;
            }
        Lf:
            switch(r0) {
                case 91: goto L17;
                case 92: goto L15;
                case 93: goto L17;
                default: goto L12;
            }
        L12:
            r0 = 91
            goto Lf
        L15:
            r0 = 2
            return r0
        L17:
            r1 = 94
            r0 = 75
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.d.h():int");
    }
}
