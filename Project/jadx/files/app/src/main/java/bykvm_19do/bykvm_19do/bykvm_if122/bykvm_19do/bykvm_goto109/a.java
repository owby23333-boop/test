package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.g;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.h;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.m0;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile a a;

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a$a, reason: collision with other inner class name */
    class C0046a extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a {
        final /* synthetic */ d a;

        C0046a(d dVar) {
            this.a = dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:102:0x02f3 A[Catch: all -> 0x0328, TryCatch #5 {all -> 0x0328, blocks: (B:6:0x0011, B:8:0x0028, B:12:0x0032, B:29:0x0085, B:31:0x008f, B:97:0x02d0, B:100:0x02dd, B:101:0x02ee, B:102:0x02f3, B:17:0x0043, B:19:0x005e, B:24:0x0073, B:26:0x007b, B:103:0x0305, B:21:0x006c, B:14:0x003c), top: B:123:0x0011, inners: #1, #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0085 A[Catch: all -> 0x0328, TryCatch #5 {all -> 0x0328, blocks: (B:6:0x0011, B:8:0x0028, B:12:0x0032, B:29:0x0085, B:31:0x008f, B:97:0x02d0, B:100:0x02dd, B:101:0x02ee, B:102:0x02f3, B:17:0x0043, B:19:0x005e, B:24:0x0073, B:26:0x007b, B:103:0x0305, B:21:0x006c, B:14:0x003c), top: B:123:0x0011, inners: #1, #2 }] */
        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b r20, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b r21) {
            /*
                Method dump skipped, instruction units count: 879
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.C0046a.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b r4, java.io.IOException r5) {
            /*
                r3 = this;
                boolean r4 = r5 instanceof java.net.SocketTimeoutException
                if (r4 == 0) goto Lc
                r4 = 44405(0xad75, float:6.2225E-41)
            L7:
                java.lang.String r5 = r5.toString()
                goto L15
            Lc:
                r4 = 44404(0xad74, float:6.2223E-41)
                if (r5 == 0) goto L12
                goto L7
            L12:
                java.lang.String r5 = "没有网络"
            L15:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Server Bidding Request onError...errorCode="
                r0.append(r1)
                r0.append(r4)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "ServerBiddingHelper"
                com.bytedance.msdk.adapter.util.Logger.e(r1, r0)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a$d r0 = r3.a
                if (r0 == 0) goto L39
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.this
                com.bytedance.msdk.api.AdError r2 = new com.bytedance.msdk.api.AdError
                r2.<init>(r4, r5)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a(r1, r0, r2)
            L39:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.C0046a.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b, java.io.IOException):void");
        }
    }

    class b implements Runnable {
        final /* synthetic */ d a;
        final /* synthetic */ AdError b;

        b(a aVar, d dVar, AdError adError) {
            this.a = dVar;
            this.b = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = this.a;
            if (dVar != null) {
                dVar.a(this.b);
            }
        }
    }

    class c implements Runnable {
        final /* synthetic */ d a;
        final /* synthetic */ g b;

        c(a aVar, d dVar, g gVar) {
            this.a = dVar;
            this.b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = this.a;
            if (dVar != null) {
                dVar.a(this.b);
            }
        }
    }

    public interface d {
        void a(g gVar);

        void a(AdError adError);
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
    public static int a(int r4) {
        /*
        L0:
            r0 = 93
            r1 = 93
        L4:
            r2 = 3
            r3 = 4
            switch(r1) {
                case 92: goto Ld;
                case 93: goto L10;
                case 94: goto La;
                default: goto L9;
            }
        L9:
            goto L0
        La:
            if (r0 <= r3) goto L0
            goto L1e
        Ld:
            switch(r0) {
                case 21: goto L1e;
                case 22: goto L1c;
                case 23: goto L1a;
                default: goto L10;
            }
        L10:
            switch(r0) {
                case 91: goto L20;
                case 92: goto L1e;
                case 93: goto L16;
                default: goto L13;
            }
        L13:
            r0 = 91
            goto L10
        L16:
            switch(r4) {
                case 1: goto L1c;
                case 2: goto L20;
                case 3: goto L1a;
                case 4: goto L1a;
                case 5: goto L1f;
                case 6: goto L19;
                case 7: goto L1a;
                case 8: goto L1a;
                case 9: goto L1f;
                default: goto L19;
            }
        L19:
            goto L1f
        L1a:
            r2 = 5
            goto L1f
        L1c:
            r2 = 2
            goto L1f
        L1e:
            r2 = 4
        L1f:
            return r2
        L20:
            r1 = 94
            r0 = 75
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a(int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094 A[Catch: all -> 0x0121, TryCatch #2 {all -> 0x0121, blocks: (B:12:0x0023, B:14:0x0037, B:18:0x0041, B:35:0x0094, B:37:0x009e, B:39:0x0117, B:23:0x0052, B:25:0x006d, B:30:0x0082, B:32:0x008a, B:27:0x007b, B:20:0x004b), top: B:50:0x0023, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.h a(org.json.JSONObject r7) {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a(org.json.JSONObject):bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.h");
    }

    /* JADX INFO: Infinite loop detected, blocks: 3, insns: 0 */
    private String a(AdSlot adSlot, j jVar) {
        while (true) {
            switch (53) {
                case 52:
                    while (true) {
                    }
                    break;
                case 53:
                    while (true) {
                        switch (60) {
                            case 60:
                                switch (49) {
                                    case 50:
                                    case 51:
                                        char c2 = '5';
                                        while (true) {
                                            switch (c2) {
                                                case '7':
                                                    break;
                                                case '8':
                                                case '9':
                                                    break;
                                                default:
                                                    c2 = '8';
                                                    break;
                                            }
                                        }
                                        break;
                                }
                                break;
                        }
                    }
                    String linkedId = adSlot != null ? adSlot.getLinkedId() : null;
                    if (jVar == null) {
                        return linkedId;
                    }
                    return (linkedId + "_") + jVar.d();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        if (r2 == '1') goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
    
        if (r2 == '3') goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002a, code lost:
    
        r2 = '1';
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000d. Please report as an issue. */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0021 -> B:19:0x002a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0026 -> B:19:0x002a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L2d
        L7:
            r4 = 97
            r0 = 49
            r2 = 39
            switch(r4) {
                case 95: goto L11;
                case 96: goto L1d;
                case 97: goto L24;
                default: goto L10;
            }
        L10:
            goto L7
        L11:
            switch(r2) {
                case 60: goto L24;
                case 61: goto L15;
                case 62: goto L76;
                default: goto L14;
            }
        L14:
            goto L1d
        L15:
            r4 = 31
        L17:
            switch(r4) {
                case 52: goto L76;
                case 53: goto L2a;
                case 54: goto L2a;
                default: goto L1a;
            }
        L1a:
            r4 = 53
            goto L17
        L1d:
            if (r2 == r0) goto L24
            r4 = 51
            if (r2 == r4) goto L24
            goto L2a
        L24:
            r4 = 29
            switch(r4) {
                case 29: goto L76;
                case 30: goto L2a;
                case 31: goto L24;
                default: goto L29;
            }
        L29:
            goto L24
        L2a:
            r2 = 49
            goto L1d
        L2d:
            com.bytedance.msdk.api.v2.ad.custom.init.GMCustomAdapterConfiguration r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(r4)     // Catch: java.lang.Throwable -> L58
            if (r0 == 0) goto L38
            java.lang.String r1 = r0.getNetworkSdkVersion()     // Catch: java.lang.Throwable -> L58
            goto L76
        L38:
            java.util.Map r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.e()     // Catch: java.lang.Throwable -> L58
            if (r0 != 0) goto L3f
            goto L76
        L3f:
            java.lang.String r4 = com.bytedance.msdk.adapter.config.DefaultAdapterClasses.getClassNameByAdnName(r4)     // Catch: java.lang.Throwable -> L58
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L58
            if (r2 == 0) goto L4a
            goto L76
        L4a:
            java.lang.Object r4 = r0.get(r4)     // Catch: java.lang.Throwable -> L58
            com.bytedance.msdk.adapter.config.ITTAdapterConfiguration r4 = (com.bytedance.msdk.adapter.config.ITTAdapterConfiguration) r4     // Catch: java.lang.Throwable -> L58
            if (r4 != 0) goto L53
            goto L76
        L53:
            java.lang.String r1 = r4.getNetworkSdkVersion()     // Catch: java.lang.Throwable -> L58
            goto L76
        L58:
            r4 = move-exception
            r4.printStackTrace()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "GDT SDK 初始化失败。。 e="
            r0.append(r2)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = "TTMediationSDK_SDK_Init"
            com.bytedance.msdk.adapter.util.Logger.e(r0, r4)
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x0073. Please report as an issue. */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0073 -> B:30:0x0085). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007d -> B:31:0x008c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:104)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private java.lang.String a(java.util.Map<java.lang.String, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter> r4, android.content.Context r5, com.bytedance.msdk.api.AdSlot r6, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r7, java.util.Map<java.lang.String, java.lang.Object> r8) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            if (r6 == 0) goto L65
            if (r7 != 0) goto L8
            goto L85
        L8:
            java.lang.String r1 = r7.e()
            java.lang.String r2 = "baidu"
            boolean r1 = android.text.TextUtils.equals(r2, r1)
            if (r1 == 0) goto L5c
            java.lang.String r8 = r6.getAdUnitId()
            com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter r8 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g.a(r8, r7)
            if (r8 == 0) goto L84
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            java.lang.String r2 = r6.getLinkedId()
            r0[r1] = r2
            r1 = 1
            java.lang.String r2 = r6.getAdUnitId()
            r0[r1] = r2
            r1 = 2
            java.lang.String r2 = r7.d()
            r0[r1] = r2
            java.lang.String r1 = "%1$s_%2$s_%3$s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r4.put(r0, r8)
            int r4 = r6.getAdType()
            r0 = 5
            if (r4 != r0) goto L4f
            java.lang.String r4 = r7.d()
            com.bytedance.msdk.api.v2.slot.GMAdSlotNative r6 = com.bytedance.msdk.api.v2.ad.AdUtils.getAdSlotNative(r6, r7)
            goto L57
        L4f:
            java.lang.String r4 = r7.d()
            com.bytedance.msdk.api.v2.slot.GMAdSlotBase r6 = com.bytedance.msdk.api.v2.ad.AdUtils.covertAdSlot2GMAdSlotBase(r6)
        L57:
            java.lang.String r0 = r8.getBiddingToken(r5, r4, r6)
            goto L84
        L5c:
            java.lang.String r4 = r7.e()
            java.lang.String r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.a(r8, r4)
            goto L84
        L65:
            r4 = 39
        L67:
            switch(r4) {
                case 37: goto L85;
                case 38: goto L6b;
                case 39: goto L85;
                default: goto L6a;
            }
        L6a:
            goto L8c
        L6b:
            r5 = 72
            r6 = 55
            switch(r6) {
                case 55: goto L80;
                case 56: goto L84;
                case 57: goto L73;
                default: goto L72;
            }
        L72:
            goto L6b
        L73:
            switch(r6) {
                case 27: goto L7b;
                case 28: goto L73;
                case 29: goto L85;
                default: goto L76;
            }
        L76:
            r6 = 27
            r5 = 99
            goto L73
        L7b:
            r6 = 94
            if (r5 == r6) goto L67
            goto L8c
        L80:
            switch(r5) {
                case 71: goto L84;
                case 72: goto L84;
                case 73: goto L6b;
                default: goto L83;
            }
        L83:
            goto L80
        L84:
            return r0
        L85:
            java.lang.String r4 = "serverBiddingRequest"
            java.lang.String r5 = "adSlot is null or waterFallConfig is null can not get server bidding token"
            com.bytedance.msdk.adapter.util.Logger.i(r4, r5)
        L8c:
            r4 = 38
            goto L67
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a(java.util.Map, android.content.Context, com.bytedance.msdk.api.AdSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j, java.util.Map):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x04ec A[Catch: Exception -> 0x05b8, TryCatch #3 {Exception -> 0x05b8, blocks: (B:123:0x045f, B:125:0x0464, B:127:0x0472, B:131:0x04a5, B:133:0x04ab, B:134:0x04c4, B:142:0x04df, B:144:0x04e2, B:146:0x04ec, B:147:0x04f1, B:149:0x051b, B:150:0x051f, B:152:0x0525, B:154:0x052d, B:156:0x053f, B:159:0x0552, B:160:0x055b, B:162:0x0595, B:163:0x059e, B:157:0x0548, B:164:0x05b2, B:139:0x04d8, B:136:0x04ce), top: B:185:0x045f, inners: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x051b A[Catch: Exception -> 0x05b8, TryCatch #3 {Exception -> 0x05b8, blocks: (B:123:0x045f, B:125:0x0464, B:127:0x0472, B:131:0x04a5, B:133:0x04ab, B:134:0x04c4, B:142:0x04df, B:144:0x04e2, B:146:0x04ec, B:147:0x04f1, B:149:0x051b, B:150:0x051f, B:152:0x0525, B:154:0x052d, B:156:0x053f, B:159:0x0552, B:160:0x055b, B:162:0x0595, B:163:0x059e, B:157:0x0548, B:164:0x05b2, B:139:0x04d8, B:136:0x04ce), top: B:185:0x045f, inners: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x002a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x05e5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02d3 A[Catch: all -> 0x03f1, TRY_ENTER, TryCatch #7 {all -> 0x03f1, blocks: (B:72:0x029c, B:74:0x02a5, B:76:0x02af, B:79:0x02ba, B:80:0x02bf, B:83:0x02d3, B:88:0x02ea, B:97:0x03e4, B:89:0x0345, B:91:0x0357, B:96:0x036e, B:78:0x02b6), top: B:193:0x029c }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0345 A[Catch: all -> 0x03f1, TryCatch #7 {all -> 0x03f1, blocks: (B:72:0x029c, B:74:0x02a5, B:76:0x02af, B:79:0x02ba, B:80:0x02bf, B:83:0x02d3, B:88:0x02ea, B:97:0x03e4, B:89:0x0345, B:91:0x0357, B:96:0x036e, B:78:0x02b6), top: B:193:0x029c }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e A[LOOP:1: B:7:0x001b->B:8:0x001e, LOOP_END] */
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.util.Map<java.lang.String, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter> r30, android.content.Context r31, com.bytedance.msdk.api.AdSlot r32, java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> r33, java.util.List<com.bytedance.msdk.base.TTBaseAd> r34, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c r35, int r36, boolean r37) {
        /*
            Method dump skipped, instruction units count: 1544
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a(java.util.Map, android.content.Context, com.bytedance.msdk.api.AdSlot, java.util.List, java.util.List, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c, int, boolean):java.lang.String");
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
    private java.lang.String a(org.json.JSONObject r2, boolean r3) {
        /*
            r1 = this;
            org.json.JSONObject r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.m0.a(r2)
            if (r2 == 0) goto L15
            java.lang.String r0 = "token_type"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Exception -> L10
            r2.putOpt(r0, r3)     // Catch: java.lang.Exception -> L10
        L10:
            java.lang.String r2 = r2.toString()
            goto L27
        L15:
            r2 = 15
            switch(r2) {
                case 13: goto L15;
                case 14: goto L15;
                case 15: goto L1b;
                default: goto L1a;
            }
        L1a:
            goto L15
        L1b:
            r2 = 95
            switch(r2) {
                case 94: goto L15;
                case 95: goto L26;
                case 96: goto L15;
                default: goto L20;
            }
        L20:
            r2 = 12
            switch(r2) {
                case 55: goto L15;
                case 56: goto L15;
                case 57: goto L15;
                default: goto L25;
            }
        L25:
            goto L15
        L26:
            r2 = 0
        L27:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a(org.json.JSONObject, boolean):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0001, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x000b. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x000e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONObject a() {
        /*
            r3 = this;
            r0 = 0
        L1:
            r1 = 73
            r2 = 96
        L5:
            switch(r1) {
                case 72: goto L37;
                case 73: goto Lb;
                case 74: goto Le;
                default: goto L8;
            }
        L8:
            r1 = 72
            goto L5
        Lb:
            switch(r2) {
                case 94: goto L1;
                case 95: goto L12;
                case 96: goto L12;
                default: goto Le;
            }
        Le:
            switch(r2) {
                case 55: goto L1f;
                case 56: goto L1f;
                case 57: goto L12;
                default: goto L11;
            }
        L11:
            goto L1
        L12:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()
            java.lang.String r0 = r0.c()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            goto L37
        L1f:
            r1 = 0
            if (r0 == 0) goto L23
            goto L36
        L23:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L32
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()     // Catch: java.lang.Exception -> L32
            java.lang.String r2 = r2.c()     // Catch: java.lang.Exception -> L32
            r0.<init>(r2)     // Catch: java.lang.Exception -> L32
            r1 = r0
            goto L36
        L32:
            r0 = move-exception
            r0.printStackTrace()
        L36:
            return r1
        L37:
            r1 = 74
            r2 = 55
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a():org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0000, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONObject a(com.bytedance.msdk.api.AdSlot r6) {
        /*
            r5 = this;
        L0:
            r0 = 15
        L2:
            switch(r0) {
                case 13: goto L0;
                case 14: goto L11;
                case 15: goto L6;
                default: goto L5;
            }
        L5:
            goto L61
        L6:
            r0 = 95
            switch(r0) {
                case 94: goto L0;
                case 95: goto L61;
                case 96: goto L0;
                default: goto Lb;
            }
        Lb:
            r0 = 12
            switch(r0) {
                case 55: goto L11;
                case 56: goto L61;
                case 57: goto L11;
                default: goto L10;
            }
        L10:
            goto L0
        L11:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            int r1 = r6.getAdType()     // Catch: java.lang.Exception -> L60
            java.lang.String r2 = "id"
            java.lang.String r3 = r6.getAdUnitId()     // Catch: java.lang.Exception -> L60
            r0.put(r2, r3)     // Catch: java.lang.Exception -> L60
            java.lang.String r2 = "adtype"
            r0.put(r2, r1)     // Catch: java.lang.Exception -> L60
            java.lang.String r2 = "pos"
            int r3 = a(r1)     // Catch: java.lang.Exception -> L60
            r0.put(r2, r3)     // Catch: java.lang.Exception -> L60
            java.lang.String r2 = "accepted_size"
            int r3 = r6.getImgAcceptedWidth()     // Catch: java.lang.Exception -> L60
            int r4 = r6.getImgAcceptedHeight()     // Catch: java.lang.Exception -> L60
            r5.a(r0, r2, r3, r4)     // Catch: java.lang.Exception -> L60
            java.lang.String r2 = "is_support_dpl"
            boolean r3 = r6.isSupportDeepLink()     // Catch: java.lang.Exception -> L60
            r0.put(r2, r3)     // Catch: java.lang.Exception -> L60
            int r6 = r6.getAdCount()     // Catch: java.lang.Exception -> L60
            r2 = 1
            if (r6 >= r2) goto L4f
            r6 = 1
        L4f:
            r3 = 3
            if (r6 <= r3) goto L53
            r6 = 3
        L53:
            r3 = 7
            if (r1 == r3) goto L5a
            r3 = 8
            if (r1 != r3) goto L5b
        L5a:
            r6 = 1
        L5b:
            java.lang.String r1 = "ad_count"
            r0.put(r1, r6)     // Catch: java.lang.Exception -> L60
        L60:
            return r0
        L61:
            r0 = 14
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a(com.bytedance.msdk.api.AdSlot):org.json.JSONObject");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:59:0x002d. Please report as an issue. */
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
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.g r5, java.lang.String r6) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.g, java.lang.String):void");
    }

    private void a(d dVar, g gVar) {
        ThreadHelper.runOnMSDKThread(new c(this, dVar, gVar));
        while (true) {
            switch (54) {
                case 52:
                    switch (37) {
                        case 94:
                        case 95:
                            return;
                    }
                case 54:
                    return;
            }
        }
    }

    private void a(d dVar, AdError adError) {
        ThreadHelper.runOnMSDKThread(new b(this, dVar, adError));
        while (true) {
            switch (54) {
                case 52:
                    switch (37) {
                        case 94:
                        case 95:
                            return;
                    }
                case 54:
                    return;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0007. Please report as an issue. */
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
    static /* synthetic */ void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a r0, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.d r1, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.g r2) {
        /*
            r0.a(r1, r2)
        L3:
            r0 = 93
            r1 = 93
        L7:
            switch(r1) {
                case 92: goto Lf;
                case 93: goto L12;
                case 94: goto Lb;
                default: goto La;
            }
        La:
            goto L3
        Lb:
            r1 = 4
            if (r0 <= r1) goto L3
            return
        Lf:
            switch(r0) {
                case 21: goto L18;
                case 22: goto L18;
                case 23: goto L18;
                default: goto L12;
            }
        L12:
            switch(r0) {
                case 91: goto L18;
                case 92: goto L18;
                case 93: goto L18;
                default: goto L15;
            }
        L15:
            r0 = 91
            goto L12
        L18:
            r1 = 94
            r0 = 75
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a$d, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.g):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x001a, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0019 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a r1, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.d r2, com.bytedance.msdk.api.AdError r3) {
        /*
            r1.a(r2, r3)
        L3:
            r1 = 94
            r2 = 75
            r3 = 93
        L9:
            r0 = 92
            if (r1 == r0) goto L10
            if (r1 == r3) goto L13
            goto L1a
        L10:
            switch(r2) {
                case 21: goto L1a;
                case 22: goto L1a;
                case 23: goto L1a;
                default: goto L13;
            }
        L13:
            switch(r2) {
                case 91: goto L3;
                case 92: goto L1a;
                case 93: goto L19;
                default: goto L16;
            }
        L16:
            r2 = 91
            goto L13
        L19:
            return
        L1a:
            r1 = 93
            r2 = 93
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a$d, com.bytedance.msdk.api.AdError):void");
    }

    private void a(JSONObject jSONObject, String str, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", i2);
            jSONObject2.put("height", i3);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0012 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[LOOP:1: B:8:0x000c->B:27:?, LOOP_END, SYNTHETIC] */
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONObject b() {
        /*
            r3 = this;
        L0:
            r0 = 73
            switch(r0) {
                case 72: goto Lc;
                case 73: goto Lc;
                case 74: goto L6;
                default: goto L5;
            }
        L5:
            goto L0
        L6:
            r0 = -55
            switch(r0) {
                case 39: goto L0;
                case 40: goto Lc;
                case 41: goto L12;
                default: goto Lb;
            }
        Lb:
            goto L12
        Lc:
            r0 = 91
            switch(r0) {
                case 91: goto L12;
                case 92: goto Lc;
                case 93: goto L0;
                default: goto L11;
            }
        L11:
            goto Lc
        L12:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "appid"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J()     // Catch: java.lang.Exception -> L37
            java.lang.String r2 = r2.b()     // Catch: java.lang.Exception -> L37
            r0.put(r1, r2)     // Catch: java.lang.Exception -> L37
            java.lang.String r1 = "name"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J()     // Catch: java.lang.Exception -> L37
            java.lang.String r2 = r2.i()     // Catch: java.lang.Exception -> L37
            r0.put(r1, r2)     // Catch: java.lang.Exception -> L37
            r3.c(r0)     // Catch: java.lang.Exception -> L37
            r3.b(r0)     // Catch: java.lang.Exception -> L37
        L37:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.b():org.json.JSONObject");
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    private org.json.JSONObject b(com.bytedance.msdk.api.AdSlot r7) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.b(com.bytedance.msdk.api.AdSlot):org.json.JSONObject");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0021 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0007 A[SYNTHETIC] */
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
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
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
    private org.json.JSONObject b(java.lang.String r3) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            r1 = 0
            if (r0 == 0) goto L16
        L7:
            r3 = 94
            r0 = 125(0x7d, float:1.75E-43)
            switch(r3) {
                case 94: goto L21;
                case 95: goto Lf;
                case 96: goto L12;
                default: goto Le;
            }
        Le:
            goto L7
        Lf:
            switch(r0) {
                case 94: goto L7;
                case 95: goto L7;
                case 96: goto L7;
                default: goto L12;
            }
        L12:
            switch(r0) {
                case 55: goto L7;
                case 56: goto L7;
                case 57: goto L7;
                default: goto L15;
            }
        L15:
            goto L21
        L16:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L1d
            r0.<init>(r3)     // Catch: java.lang.Exception -> L1d
            r1 = r0
            goto L21
        L1d:
            r3 = move-exception
            r3.printStackTrace()
        L21:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.b(java.lang.String):org.json.JSONObject");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0002. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0008. Please report as an issue. */
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
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private void b(org.json.JSONObject r6) {
        /*
            r5 = this;
        L0:
            r0 = 15
        L2:
            switch(r0) {
                case 13: goto L0;
                case 14: goto L11;
                case 15: goto L6;
                default: goto L5;
            }
        L5:
            goto L36
        L6:
            r0 = 95
            switch(r0) {
                case 94: goto L0;
                case 95: goto L36;
                case 96: goto L0;
                default: goto Lb;
            }
        Lb:
            r0 = 12
            switch(r0) {
                case 55: goto L0;
                case 56: goto L36;
                case 57: goto L0;
                default: goto L10;
            }
        L10:
            goto L0
        L11:
            android.content.Context r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.f.b(r0)
            if (r0 == 0) goto L35
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L35
            r1.<init>()     // Catch: java.lang.Exception -> L35
            java.lang.String r2 = "latitude"
            float r3 = r0.a     // Catch: java.lang.Exception -> L35
            double r3 = (double) r3     // Catch: java.lang.Exception -> L35
            r1.put(r2, r3)     // Catch: java.lang.Exception -> L35
            java.lang.String r2 = "longitude"
            float r0 = r0.b     // Catch: java.lang.Exception -> L35
            double r3 = (double) r0     // Catch: java.lang.Exception -> L35
            r1.put(r2, r3)     // Catch: java.lang.Exception -> L35
            java.lang.String r0 = "geo"
            r6.put(r0, r1)     // Catch: java.lang.Exception -> L35
        L35:
            return
        L36:
            r0 = 14
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.b(org.json.JSONObject):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0002, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x000c. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x000f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a c() {
        /*
            java.lang.Class<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a> r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.class
        L2:
            r1 = 73
            r2 = 96
        L6:
            switch(r1) {
                case 72: goto L2b;
                case 73: goto Lc;
                case 74: goto Lf;
                default: goto L9;
            }
        L9:
            r1 = 72
            goto L6
        Lc:
            switch(r2) {
                case 94: goto L2;
                case 95: goto L2b;
                case 96: goto L2b;
                default: goto Lf;
            }
        Lf:
            switch(r2) {
                case 55: goto L13;
                case 56: goto L2;
                case 57: goto L2b;
                default: goto L12;
            }
        L12:
            goto L2
        L13:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a
            if (r1 != 0) goto L28
            monitor-enter(r0)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a     // Catch: java.lang.Throwable -> L25
            if (r1 != 0) goto L23
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a r1 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a     // Catch: java.lang.Throwable -> L25
            r1.<init>()     // Catch: java.lang.Throwable -> L25
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a = r1     // Catch: java.lang.Throwable -> L25
        L23:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L25
            goto L28
        L25:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L25
            throw r1
        L28:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.a
            return r0
        L2b:
            r1 = 74
            r2 = 55
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a.c():bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_goto109.a");
    }

    private void c(JSONObject jSONObject) {
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                if (c2 == '\\') {
                    switch (c3) {
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
                        try {
                            jSONObject.put("package_name", m0.a());
                            jSONObject.put("version_code", m0.d());
                            jSONObject.put("version", m0.e());
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    default:
                        c3 = '[';
                        break;
                }
            }
        }
    }

    public String a(Map<String, TTAbsAdLoaderAdapter> map, Context context, AdSlot adSlot, List<j> list, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar, int i2, boolean z2) {
        while (true) {
            switch (73) {
                case 72:
                case 73:
                case 74:
                    return a(map, context, adSlot, list, null, cVar, i2, z2);
            }
        }
    }

    public void a(String str, d dVar) {
        char c2;
        while (true) {
            char c3 = '(';
            while (true) {
                if (c3 == '(') {
                    c2 = '8';
                    switch (83) {
                        case 81:
                            switch (56) {
                                case 29:
                                case 30:
                                    c3 = ')';
                                    break;
                            }
                            break;
                        case 83:
                            c3 = ')';
                            break;
                    }
                } else if (c3 != ')') {
                    c3 = ')';
                }
            }
            while (true) {
                switch (c2) {
                    case '\'':
                        break;
                    case '(':
                    case ')':
                        break;
                    default:
                        c2 = '\'';
                        break;
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            Logger.e("ServerBiddingHelper", "Server Bidding Request onResponse...response is invalid");
            a(dVar, new AdError(-1, "response is invalid"));
            return;
        }
        try {
            g gVar = new g();
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("items");
            String strOptString = jSONObject.optString("m_meta");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    try {
                        h hVarA = a(jSONArrayOptJSONArray.optJSONObject(i2));
                        if (hVarA != null) {
                            arrayList.add(hVarA);
                        }
                    } catch (Throwable th) {
                        Logger.d("ServerBiddingHelper", "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                    }
                }
                gVar.b(arrayList);
            }
            a(gVar, strOptString);
            a(dVar, gVar);
        } catch (Throwable th2) {
            String string = th2.toString();
            Logger.e("ServerBiddingHelper", "Server Bidding onResponse throwable ：" + string);
            if (TextUtils.isEmpty(string)) {
                string = AdError.getMessage(-1);
            }
            a(dVar, new AdError(-1, string));
        }
    }

    public void a(Map<String, TTAbsAdLoaderAdapter> map, Context context, AdSlot adSlot, List<j> list, List<TTBaseAd> list2, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar, int i2, boolean z2, d dVar) {
        String strA = a(map, context, adSlot, list, list2, cVar, i2, z2);
        Logger.i("serverBiddingRequest", "serverBiddingRequest-encryptBody=" + strA);
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.c cVarC = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b.b().a().c();
        cVarC.b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c.b());
        String strQ = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().q();
        if (!TextUtils.isEmpty(strQ)) {
            cVarC.a("X-Tt-Env", strQ);
            cVarC.a("x-use-ppe", "1");
        }
        cVarC.a("User-Agent", com.bytedance.msdk.base.b.b);
        cVarC.c(strA);
        cVarC.a(new C0046a(dVar));
        while (true) {
            switch (42) {
                case 40:
                case 41:
                case 42:
                    return;
            }
        }
    }
}
