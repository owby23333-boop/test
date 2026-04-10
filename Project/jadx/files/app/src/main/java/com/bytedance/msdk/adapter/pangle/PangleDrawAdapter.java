package com.bytedance.msdk.adapter.pangle;

import android.content.Context;
import com.bytedance.msdk.adapter.ad.GMDrawBaseAdapter;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* JADX INFO: loaded from: classes2.dex */
public class PangleDrawAdapter extends GMDrawBaseAdapter {
    private Context a;

    private void a(TTAdNative tTAdNative, AdSlot.Builder builder) {
        new PangleDrawLoader().loadAd(this.a, isClientBidding(), tTAdNative, builder.build(), this);
        while (true) {
            switch (95) {
                case 94:
                    if ((((30 - 1) * 30) * ((30 * 2) - 1)) % 6 != 0) {
                        return;
                    }
                    break;
                case 95:
                    return;
                case 96:
                    if ((84 * 84 * 84) + (42 * 42 * 42) + (22 * 22 * 22) < 84 * 42 * 22 * 3 && ((70 * 70) + (44 * 44)) - ((70 * 44) * 2) < 0) {
                        int i2 = (18 * 18) - ((35 * 35) * 34);
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0046. Please report as an issue. */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
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
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private void a(com.bytedance.sdk.openadsdk.TTAdNative r7, com.bytedance.sdk.openadsdk.AdSlot.Builder r8, int r9, int r10) {
        /*
            r6 = this;
            float r9 = (float) r9
            if (r10 <= 0) goto L5
            float r10 = (float) r10
            goto L6
        L5:
            r10 = 0
        L6:
            r8.setExpressViewAcceptedSize(r9, r10)
            com.bytedance.sdk.openadsdk.AdSlot r4 = r8.build()
            com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader r0 = new com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader
            r0.<init>()
            android.content.Context r1 = r6.a
            boolean r2 = r6.isClientBidding()
            r3 = r7
            r5 = r6
            r0.loadAd(r1, r2, r3, r4, r5)
        L1d:
            r7 = 83
            r8 = 1
            r9 = 9
            switch(r7) {
                case 81: goto L26;
                case 82: goto L2d;
                case 83: goto L2d;
                default: goto L25;
            }
        L25:
            goto L1d
        L26:
            r7 = 9
            int r7 = r7 + r8
            int r7 = r7 * 9
            int r7 = r7 % 2
        L2d:
            r7 = 72
            r10 = 29
            r0 = 39
            switch(r10) {
                case 29: goto L87;
                case 30: goto L46;
                case 31: goto L37;
                default: goto L36;
            }
        L36:
            goto L2d
        L37:
            r7 = 99
            int r7 = r7 * r7
            r1 = 18
            int r1 = r1 * r1
            int r1 = r1 * 34
            int r7 = r7 - r1
            r1 = -1
            if (r7 != r1) goto L87
            goto L4a
        L46:
            switch(r7) {
                case 39: goto L4a;
                case 40: goto L64;
                case 41: goto L73;
                default: goto L49;
            }
        L49:
            goto L84
        L4a:
            int r7 = r0 * r0
            int r7 = r7 * 39
            r0 = 13
            int r1 = r0 * r0
            int r1 = r1 * 13
            int r7 = r7 + r1
            int r1 = r9 * r9
            int r1 = r1 * 9
            int r7 = r7 + r1
            r1 = 39
            int r1 = r1 * 13
            int r1 = r1 * 9
            int r1 = r1 * 3
            if (r7 >= r1) goto L1d
        L64:
            int r7 = 29 - r8
            int r7 = r7 * 29
            r10 = 29
            int r10 = r10 * 2
            int r10 = r10 - r8
            int r7 = r7 * r10
            int r7 = r7 % 6
            if (r7 == 0) goto L2d
        L73:
            r7 = 12
            int r10 = r7 * r7
            r0 = 14
            int r1 = r0 * r0
            int r10 = r10 + r1
            int r7 = r7 * 14
            int r7 = r7 * 2
            int r10 = r10 - r7
            if (r10 >= 0) goto L1d
            goto L2d
        L84:
            r7 = 39
            goto L46
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawAdapter.a(com.bytedance.sdk.openadsdk.TTAdNative, com.bytedance.sdk.openadsdk.AdSlot$Builder, int, int):void");
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getAdNetWorkName() {
        return "pangle";
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getSdkVersion() {
        try {
            return TTAdSdk.getAdManager().getSDKVersion();
        } catch (Exception unused) {
            return "0.0";
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x007f. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:34:0x00d9. Please report as an issue. */
    /* JADX WARN: Path cross not found for [B:25:0x0092, B:30:0x00bc], limit reached: 38 */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00de  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00d7 -> B:34:0x00d9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00d9 -> B:37:0x00de). Please report as a decompilation issue!!! */
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
    @Override // com.bytedance.msdk.adapter.ad.GMDrawBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadAd(android.content.Context r10, java.util.Map<java.lang.String, java.lang.Object> r11) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawAdapter.loadAd(android.content.Context, java.util.Map):void");
    }
}
