package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.h0;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.error.AdBreakError;
import com.bytedance.msdk.base.TTBaseAd;
import com.umeng.analytics.pro.am;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h {
    private static int a;
    private static int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f1717c;

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
    public static void a() {
        /*
        L0:
            r0 = 31
            switch(r0) {
                case 29: goto L6;
                case 30: goto L6;
                case 31: goto L6;
                default: goto L5;
            }
        L5:
            goto L0
        L6:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            java.lang.String r1 = "apm_sdk_init"
            r0.e(r1)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            org.json.JSONArray r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0.c()
            if (r2 == 0) goto L33
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "--==-- v3bug size: "
            r3.append(r4)
            int r4 = r2.length()
            r3.append(r4)
            r3.toString()
            java.lang.String r3 = "sp_v3_bug"
            r1.put(r3, r2)
        L33:
            android.content.Context r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r2, r0, r1)
        L3a:
            r0 = 40
            switch(r0) {
                case 38: goto L0;
                case 39: goto L40;
                case 40: goto L45;
                default: goto L3f;
            }
        L3f:
            goto L3a
        L40:
            r0 = 95
            switch(r0) {
                case 52: goto L3a;
                case 53: goto L6;
                case 54: goto L0;
                default: goto L45;
            }
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x004d. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0052. Please report as an issue. */
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
    public static void a(int r3, int r4, long r5, boolean r7, boolean r8, org.json.JSONObject r9, long r10) {
        /*
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0 r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d.S()
            java.lang.String r2 = "is_config_from_assert"
            boolean r1 = r1.a(r2)
            r2 = 1
            if (r3 != r2) goto L12
            goto L1c
        L12:
            if (r7 != 0) goto L1b
            if (r3 != 0) goto L19
            if (r1 == 0) goto L19
            goto L1b
        L19:
            r3 = 0
            goto L1c
        L1b:
            r3 = 2
        L1c:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r3 = r0.e(r3)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r3 = r3.a(r5)
            java.lang.String r5 = "get_config_final"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r3 = r3.e(r5)
            r3.g(r4)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.c()
            r4.a(r8, r0, r9, r3)
            java.lang.Long r4 = java.lang.Long.valueOf(r10)
            java.lang.String r5 = "config_size"
            r3.put(r5, r4)
            android.content.Context r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r4, r0, r3)
        L49:
            r3 = 80
            r4 = 82
        L4d:
            switch(r3) {
                case 80: goto L52;
                case 81: goto L52;
                case 82: goto L51;
                default: goto L50;
            }
        L50:
            goto L49
        L51:
            return
        L52:
            switch(r4) {
                case 82: goto L5e;
                case 83: goto L49;
                case 84: goto L56;
                default: goto L55;
            }
        L55:
            goto L52
        L56:
            r3 = 82
        L58:
            switch(r3) {
                case 70: goto L52;
                case 71: goto L49;
                case 72: goto L52;
                default: goto L5b;
            }
        L5b:
            r3 = 71
            goto L58
        L5e:
            r3 = 82
            goto L4d
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(int, int, long, boolean, boolean, org.json.JSONObject, long):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0003, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0005. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(long r3) {
        /*
            r0 = 55
            r1 = 0
        L3:
            r2 = 72
        L5:
            switch(r2) {
                case 72: goto L48;
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
                case 54: goto L48;
                default: goto Lc;
            }
        Lc:
            goto L13
        Ld:
            switch(r0) {
                case 29: goto L3;
                case 30: goto L3;
                case 31: goto L9;
                default: goto L10;
            }
        L10:
            r0 = 30
            goto Ld
        L13:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            java.lang.String r1 = "sdk_backstage"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r0.e(r1)
            r1.a(r3)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r()
            r4.c(r3)
            java.lang.String r4 = "v3"
            org.json.JSONObject r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0.g(r4)
            r3.put(r4, r1)
            java.lang.String r4 = "v1"
            org.json.JSONObject r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0.g(r4)
            r3.put(r4, r1)
            android.content.Context r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r4, r0, r3)
            return
        L48:
            r1 = 16
            r2 = 73
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
    
        r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b();
        r0.e("sdk_init_end");
        r0.a(r4);
        r0.b(r8);
        r0.a("adn_count", java.lang.Integer.valueOf(r6));
        r4 = new java.util.HashMap();
        r4.put("is_from_local_config", java.lang.Integer.valueOf(r7));
        r4.put("adapter_version_list", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.g.a());
        r4.put("if_use_new_sdkinit", java.lang.Integer.valueOf(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().o()));
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), r0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x005d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005e, code lost:
    
        r1 = r7;
        r0 = 'S';
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0062, code lost:
    
        switch(r4) {
            case 39: goto L26;
            case 40: goto L28;
            case 41: goto L27;
            default: goto L14;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0065, code lost:
    
        r4 = '\'';
        r0 = ';';
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006a, code lost:
    
        switch(r0) {
            case 57: goto L17;
            case 58: goto L18;
            case 59: goto L17;
            default: goto L18;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006e, code lost:
    
        r4 = r5;
        r6 = r7;
        r7 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0072, code lost:
    
        r4 = r5;
        r6 = r7;
        r7 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        r7 = r6;
        r5 = r4;
        r4 = '9';
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
    
        switch(83) {
            case 82: goto L29;
            case 83: goto L21;
            case 84: goto L30;
            default: goto L30;
        };
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x005e -> B:7:0x000d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(long r4, int r6, int r7, long r8) {
        /*
        L0:
            r0 = 40
        L2:
            r1 = 30
            r2 = 57
            r3 = 83
            switch(r1) {
                case 30: goto L12;
                case 31: goto L0;
                case 32: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L2
        Lc:
            r1 = r7
        Ld:
            r7 = r6
            r5 = r4
            r4 = 57
            goto L62
        L12:
            switch(r3) {
                case 82: goto L5e;
                case 83: goto L16;
                case 84: goto L12;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            java.lang.String r1 = "sdk_init_end"
            r0.e(r1)
            r0.a(r4)
            r0.b(r8)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            java.lang.String r5 = "adn_count"
            r0.a(r5, r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            java.lang.String r6 = "is_from_local_config"
            r4.put(r6, r5)
            org.json.JSONObject r5 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.g.a()
            java.lang.String r6 = "adapter_version_list"
            r4.put(r6, r5)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a r5 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r()
            int r5 = r5.o()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "if_use_new_sdkinit"
            r4.put(r6, r5)
            android.content.Context r5 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r5, r0, r4)
            return
        L5e:
            r1 = r7
            r0 = 83
            goto Ld
        L62:
            switch(r4) {
                case 39: goto L6a;
                case 40: goto L72;
                case 41: goto L6e;
                default: goto L65;
            }
        L65:
            r4 = 39
            r0 = 59
            goto L62
        L6a:
            switch(r0) {
                case 57: goto L6e;
                case 58: goto L72;
                case 59: goto L6e;
                default: goto L6d;
            }
        L6d:
            goto L72
        L6e:
            r4 = r5
            r6 = r7
            r7 = r1
            goto L0
        L72:
            r4 = r5
            r6 = r7
            r7 = r1
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(long, int, int, long):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0056. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0060 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0056 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[LOOP:2: B:11:0x005a->B:26:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0051 A[LOOP:1: B:7:0x004e->B:8:0x0051, LOOP_END] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x005c -> B:6:0x004a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r4, com.bytedance.msdk.api.AdSlot r5, int r6, int r7) {
        /*
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            java.lang.String r1 = "adapter_request_fail"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r0.e(r1)
            r2 = 0
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r1.a(r2)
            r2 = 0
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r1.a(r2)
            r3 = -99999(0xfffffffffffe7961, float:NaN)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r1.c(r3)
            java.lang.String r3 = "adapter create fail !"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r1.d(r3)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r3 = "mediationrit_req_type"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r6 = r1.a(r3, r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r1 = "mediationrit_req_type_src"
            r6.a(r1, r7)
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            a(r0, r5, r4, r2, r6)
            android.content.Context r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r4, r0, r6)
        L44:
            r4 = 83
            switch(r4) {
                case 82: goto L4a;
                case 83: goto L5a;
                case 84: goto L44;
                default: goto L49;
            }
        L49:
            goto L44
        L4a:
            r5 = 57
            r6 = 83
        L4e:
            switch(r5) {
                case 39: goto L56;
                case 40: goto L44;
                case 41: goto L44;
                default: goto L51;
            }
        L51:
            r5 = 39
            r6 = 59
            goto L4e
        L56:
            switch(r6) {
                case 57: goto L44;
                case 58: goto L44;
                case 59: goto L5a;
                default: goto L59;
            }
        L59:
            goto L44
        L5a:
            r5 = 30
            switch(r5) {
                case 30: goto L60;
                case 31: goto L44;
                case 32: goto L4a;
                default: goto L5f;
            }
        L5f:
            goto L5a
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j, com.bytedance.msdk.api.AdSlot, int, int):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
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
    public static void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r2, com.bytedance.msdk.api.AdSlot r3, com.bytedance.msdk.base.TTBaseAd r4, int r5, java.lang.String r6) {
        /*
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            java.lang.String r1 = "bidding_info_invalid"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r0.e(r1)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r5 = r1.c(r5)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r5 = r5.d(r6)
            if (r3 == 0) goto L19
            int r6 = r3.getAdCount()
            goto L1a
        L19:
            r6 = 0
        L1a:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r1 = "ad_count"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r5 = r5.a(r1, r6)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d r6 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(r6)
            org.json.JSONObject r6 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.g()
            java.lang.String r1 = "grouping_params"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r5 = r5.a(r1, r6)
            r6 = 2
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r1 = "log_source"
            r5.a(r1, r6)
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            a(r0, r3, r2, r4, r5)
            android.content.Context r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r2, r0, r5)
        L4e:
            r2 = 96
            r3 = 94
        L52:
            switch(r2) {
                case 94: goto L62;
                case 95: goto L4e;
                case 96: goto L56;
                default: goto L55;
            }
        L55:
            goto L4e
        L56:
            r2 = 85
            switch(r2) {
                case 84: goto L5c;
                case 85: goto L5f;
                case 86: goto L56;
                default: goto L5b;
            }
        L5b:
            goto L56
        L5c:
            switch(r3) {
                case 82: goto L4e;
                case 83: goto L62;
                case 84: goto L56;
                default: goto L5f;
            }
        L5f:
            r2 = 94
            goto L52
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j, com.bytedance.msdk.api.AdSlot, com.bytedance.msdk.base.TTBaseAd, int, java.lang.String):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
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
    public static void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r2, com.bytedance.msdk.api.AdSlot r3, java.lang.String r4) {
        /*
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            java.lang.String r1 = "get_bidding_adm_to_adn"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r0.e(r1)
            r1.a(r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r1 = 0
            a(r0, r3, r2, r1, r4)
            android.content.Context r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r2, r0, r4)
        L1d:
            r2 = 73
            r3 = 96
        L21:
            switch(r2) {
                case 72: goto L34;
                case 73: goto L27;
                case 74: goto L2a;
                default: goto L24;
            }
        L24:
            r2 = 72
            goto L21
        L27:
            switch(r3) {
                case 94: goto L1d;
                case 95: goto L2e;
                case 96: goto L34;
                default: goto L2a;
            }
        L2a:
            switch(r3) {
                case 55: goto L33;
                case 56: goto L33;
                case 57: goto L2e;
                default: goto L2d;
            }
        L2d:
            goto L1d
        L2e:
            r2 = 1
            switch(r2) {
                case 60: goto L33;
                case 61: goto L33;
                case 62: goto L33;
                default: goto L32;
            }
        L32:
            goto L34
        L33:
            return
        L34:
            r2 = 74
            r3 = 55
            goto L21
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j, com.bytedance.msdk.api.AdSlot, java.lang.String):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x00a1. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x00a5. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r2, com.bytedance.msdk.api.AdSlot r3, java.lang.String r4, boolean r5, int r6, int r7, int r8, int r9, com.bytedance.msdk.api.AdError r10, long r11) {
        /*
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            boolean r1 = r10 instanceof com.bytedance.msdk.api.error.AdPacingError
            if (r1 != 0) goto L10
            boolean r1 = r10 instanceof com.bytedance.msdk.api.error.AdFreqError
            if (r1 != 0) goto L10
            boolean r1 = r10 instanceof com.bytedance.msdk.api.error.AdBreakError
            if (r1 == 0) goto L1b
        L10:
            int r1 = r10.code
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r0.c(r1)
            java.lang.String r10 = r10.message
            r1.d(r10)
        L1b:
            java.lang.String r10 = "media_request"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r10 = r0.e(r10)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r10.a(r4)
            if (r3 == 0) goto L2c
            int r10 = r3.getAdCount()
            goto L2d
        L2c:
            r10 = 0
        L2d:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r1 = "ad_count"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r4.a(r1, r10)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r10 = "adn_count"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r4.a(r10, r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            java.lang.String r8 = "mediationrit_req_type"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r4.a(r8, r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r9)
            java.lang.String r8 = "mediationrit_req_type_src"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r4.a(r8, r7)
            r5 = r5 ^ 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r7 = "mediation_req_type"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r4 = r4.a(r7, r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            java.lang.String r6 = "media_req_type"
            r4.a(r6, r5)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r5 = -1
            int r7 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r7 == 0) goto L83
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r5 = r5 - r11
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            java.lang.String r6 = "start_time"
            r4.put(r6, r5)
        L83:
            r5 = 0
            a(r0, r3, r2, r5, r4)
            android.content.Context r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r2, r0, r4)
        L8e:
            r2 = 9
            r3 = 8
            r4 = 8
        L94:
            r5 = 7
            if (r4 == r5) goto L8e
            if (r4 == r3) goto L9d
            if (r4 == r2) goto L9c
            goto Lab
        L9c:
            return
        L9d:
            r4 = 12
            r5 = 37
            switch(r5) {
                case 37: goto Lab;
                case 38: goto La5;
                case 39: goto L8e;
                default: goto La4;
            }
        La4:
            goto L9d
        La5:
            switch(r4) {
                case 25: goto L8e;
                case 26: goto L8e;
                case 27: goto Lab;
                default: goto La8;
            }
        La8:
            r4 = 27
            goto La5
        Lab:
            r4 = 9
            goto L94
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j, com.bytedance.msdk.api.AdSlot, java.lang.String, boolean, int, int, int, int, com.bytedance.msdk.api.AdError, long):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0016. Please report as an issue. */
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
    private static void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r2) {
        /*
            java.lang.String r0 = "-1"
            java.lang.String r1 = "block_pacing"
            r2.a(r1, r0)
            java.lang.String r1 = "waterfall_show_rule_id"
            r2.a(r1, r0)
            java.lang.String r1 = "block_show_count"
            r2.a(r1, r0)
        L12:
            r2 = 93
            r0 = 93
        L16:
            switch(r0) {
                case 92: goto L1e;
                case 93: goto L21;
                case 94: goto L1a;
                default: goto L19;
            }
        L19:
            goto L12
        L1a:
            r0 = 4
            if (r2 <= r0) goto L12
            return
        L1e:
            switch(r2) {
                case 21: goto L27;
                case 22: goto L27;
                case 23: goto L27;
                default: goto L21;
            }
        L21:
            switch(r2) {
                case 91: goto L27;
                case 92: goto L27;
                case 93: goto L27;
                default: goto L24;
            }
        L24:
            r2 = 91
            goto L21
        L27:
            r0 = 94
            r2 = 75
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d):void");
    }

    private static void a(d dVar, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, TTBaseAd tTBaseAd) {
        a(dVar, adSlot, jVar, tTBaseAd, (Map<String, Object>) null);
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
                    return;
                }
                if (c2 != ']') {
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
                        return;
                    default:
                        c3 = '[';
                        break;
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0377 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0019 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x000b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0017 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[LOOP:1: B:8:0x000f->B:111:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0017 -> B:8:0x000f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0013 -> B:6:0x000b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r10, com.bytedance.msdk.api.AdSlot r11, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r12, com.bytedance.msdk.base.TTBaseAd r13, java.util.Map<java.lang.String, java.lang.Object> r14) {
        /*
            Method dump skipped, instruction units count: 918
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d, com.bytedance.msdk.api.AdSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j, com.bytedance.msdk.base.TTBaseAd, java.util.Map):void");
    }

    /* JADX INFO: Infinite loop detected, blocks: 6, insns: 0 */
    public static void a(AdError adError, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, int i2, int i3, int i4, String str, long j2) {
        d dVarB = d.b();
        dVarB.e("bidding_adm_load_fail").a(j2).a(str).c(adError != null ? adError.thirdSdkErrorCode : -1).d(adError != null ? adError.thirdSdkErrorMessage : "unknown error").a("adn_count", Integer.valueOf(i2)).a("adn_preload", 0).a("mediationrit_req_type", Integer.valueOf(i3)).a("mediationrit_req_type_src", Integer.valueOf(i4));
        if (adError instanceof AdBreakError) {
            dVarB.f1692n = adError.code;
            dVarB.f1689k = adError.message;
        }
        HashMap map = new HashMap();
        a(dVarB, adSlot, jVar, (TTBaseAd) null, map);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map);
        while (true) {
            switch (23) {
                case 22:
                case 23:
                    while (true) {
                        switch (29) {
                            case 29:
                                return;
                            case 30:
                                while (true) {
                                }
                                break;
                        }
                    }
                    break;
                case 24:
                    while (true) {
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[LOOP:0: B:30:0x00d0->B:38:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.bytedance.msdk.api.AdError r4, com.bytedance.msdk.api.AdSlot r5, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r6, int r7, int r8, int r9, java.lang.String r10, long r11, java.lang.String r13, java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(com.bytedance.msdk.api.AdError, com.bytedance.msdk.api.AdSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j, int, int, int, java.lang.String, long, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0027. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.bytedance.msdk.api.AdSlot r2, int r3) {
        /*
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            java.lang.String r1 = "get_config_error"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r0.e(r1)
            r1.c(r3)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r1 = 0
            a(r0, r2, r1, r1, r3)
            android.content.Context r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r2, r0, r3)
        L1d:
            r2 = 73
            r3 = 96
        L21:
            switch(r2) {
                case 72: goto L2f;
                case 73: goto L27;
                case 74: goto L2a;
                default: goto L24;
            }
        L24:
            r2 = 72
            goto L21
        L27:
            switch(r3) {
                case 94: goto L1d;
                case 95: goto L2f;
                case 96: goto L2f;
                default: goto L2a;
            }
        L2a:
            switch(r3) {
                case 55: goto L2e;
                case 56: goto L2f;
                case 57: goto L2f;
                default: goto L2d;
            }
        L2d:
            goto L1d
        L2e:
            return
        L2f:
            r2 = 74
            r3 = 55
            goto L21
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(com.bytedance.msdk.api.AdSlot, int):void");
    }

    public static void a(AdSlot adSlot, int i2, long j2, String str, String str2, int i3, AdError adError, int i4) {
        d dVarB = d.b();
        dVarB.e("return_bidding_result").a(j2).e(i2).c(adError == null ? 0 : adError.code).d(adError == null ? "" : adError.message).a(2).a("fill_type", Integer.valueOf(i3)).a("waterfall_abtest", str).a("server_bidding_extra", str2).a("ad_count", Integer.valueOf(i4));
        HashMap map = new HashMap();
        a(dVarB, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, (TTBaseAd) null, map);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map);
        byte b2 = 26;
        char c2 = '\t';
        while (true) {
            char c3 = 14;
            while (true) {
                switch (c3) {
                    case 16:
                        if (b2 <= 22) {
                            while (true) {
                                switch (c2) {
                                    case 30:
                                        return;
                                }
                            }
                        }
                        break;
                }
                c3 = 16;
                b2 = -44;
                c2 = 30;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ce A[LOOP:2: B:32:0x00cb->B:33:0x00ce, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[LOOP:1: B:28:0x00c3->B:48:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00cb -> B:28:0x00c3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(@androidx.annotation.Nullable com.bytedance.msdk.api.AdSlot r3, com.bytedance.msdk.api.AdError r4, java.lang.String r5, java.lang.String r6) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(com.bytedance.msdk.api.AdSlot, com.bytedance.msdk.api.AdError, java.lang.String, java.lang.String):void");
    }

    public static void a(AdSlot adSlot, TTBaseAd tTBaseAd, long j2, int i2, int i3, int i4, String str, int i5) {
        d dVarB = d.b();
        dVarB.e("mediation_request_end").a(j2).a("waterfall_abtest", str).a("ad_count", Integer.valueOf(i5)).c(i4);
        HashMap map = new HashMap();
        a(dVarB, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, map);
        map.put("requested_adn_count", Integer.valueOf(i2));
        map.put("requested_level_count", Integer.valueOf(i3));
        int i6 = b;
        b = i6 + 1;
        if (i6 % 10 == 0) {
            map.put("gromore_thread_num", Integer.valueOf(ThreadHelper.getGroMoreThreadCount()));
        }
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map);
        char c2 = '\t';
        byte b2 = 26;
        while (true) {
            char c3 = 14;
            while (true) {
                switch (c3) {
                    case 14:
                        c3 = 16;
                        b2 = -44;
                        c2 = 30;
                        break;
                    case 16:
                        if (b2 <= 22) {
                            while (true) {
                                switch (c2) {
                                    case 30:
                                    case 31:
                                        return;
                                }
                            }
                        }
                        continue;
                        break;
                }
            }
        }
    }

    /* JADX INFO: Infinite loop detected, blocks: 3, insns: 0 */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(AdSlot adSlot, TTBaseAd tTBaseAd, long j2, String str) {
        d dVarB = d.b();
        dVarB.e("mediation_video_cached").a(j2).a("waterfall_abtest", str);
        HashMap map = new HashMap();
        a(dVarB, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, map);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map);
        while (true) {
            char c2 = '^';
            switch (60) {
                case 60:
                    switch (49) {
                        case 50:
                        case 51:
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
                    return;
                case 61:
                    return;
            }
        }
        while (true) {
            switch (53) {
                case 52:
                    while (true) {
                    }
                    break;
                case 53:
                    return;
            }
        }
    }

    public static void a(AdSlot adSlot, TTBaseAd tTBaseAd, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar) {
        d dVarB = d.b();
        dVarB.e("media_cache_success");
        HashMap map = new HashMap();
        a(dVarB, adSlot, jVar, tTBaseAd, map);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map);
        while (true) {
            char c2 = '\f';
            switch (96) {
                case 95:
                    while (true) {
                        switch (c2) {
                            case '^':
                            case '`':
                                return;
                            case '_':
                                break;
                            default:
                                c2 = '_';
                                break;
                        }
                    }
                    break;
                case 96:
                    return;
            }
        }
    }

    /* JADX INFO: Infinite loop detected, blocks: 3, insns: 0 */
    public static void a(AdSlot adSlot, TTBaseAd tTBaseAd, String str) {
        d dVarB = d.b();
        dVarB.e("rit_cache_cannot_use").a("cache_invalid_info", str);
        HashMap map = new HashMap();
        a(dVarB, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, map);
        dVarB.a("mediationrit_req_type", 2);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map);
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
                            case 61:
                                return;
                        }
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003a, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003a, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.bytedance.msdk.api.AdSlot r4, java.lang.String r5) {
        /*
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            java.lang.String r1 = "start_bidding_request"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r0.e(r1)
            r2 = 2
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r1.a(r2)
            java.lang.String r2 = "waterfall_abtest"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r5 = r1.a(r2, r5)
            r1 = 0
            if (r4 == 0) goto L1e
            int r2 = r4.getAdCount()
            goto L1f
        L1e:
            r2 = 0
        L1f:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = "ad_count"
            r5.a(r3, r2)
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            r2 = 0
            a(r0, r4, r2, r2, r5)
            android.content.Context r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r4, r0, r5)
            r4 = 55
        L3a:
            r5 = 72
        L3c:
            switch(r5) {
                case 72: goto L4f;
                case 73: goto L4a;
                case 74: goto L40;
                default: goto L3f;
            }
        L3f:
            goto L3a
        L40:
            switch(r1) {
                case 52: goto L3a;
                case 53: goto L44;
                case 54: goto L4f;
                default: goto L43;
            }
        L43:
            goto L3a
        L44:
            switch(r4) {
                case 29: goto L4e;
                case 30: goto L3a;
                case 31: goto L40;
                default: goto L47;
            }
        L47:
            r4 = 30
            goto L44
        L4a:
            r5 = 57
            if (r1 > r5) goto L3a
        L4e:
            return
        L4f:
            r5 = 73
            r1 = 16
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(com.bytedance.msdk.api.AdSlot, java.lang.String):void");
    }

    /* JADX INFO: Infinite loop detected, blocks: 3, insns: 0 */
    public static void a(AdSlot adSlot, String str, String str2) {
        d dVarB = d.b();
        dVarB.e("cache_cannot_use").a("cache_invalid_info", str).a("waterfall_abtest", str2);
        HashMap map = new HashMap();
        a(dVarB, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, (TTBaseAd) null, map);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map);
        while (true) {
            char c2 = '\r';
            char c3 = '4';
            switch (96) {
                case 95:
                    while (true) {
                        switch (c3) {
                            case '7':
                                switch (c2) {
                                    case '>':
                                        while (true) {
                                        }
                                        break;
                                }
                                break;
                            case '8':
                                break;
                            case '9':
                                break;
                            default:
                                c3 = '7';
                                c2 = '=';
                                break;
                        }
                    }
                    break;
            }
            return;
        }
        while (true) {
            switch (49) {
                case 49:
                    return;
            }
        }
    }

    public static void a(AdSlot adSlot, String str, boolean z2, String str2, int i2) {
        String message;
        if (i2 > 0) {
            message = AdError.getMessage(i2);
        } else {
            message = "";
            i2 = 0;
        }
        int i3 = i2 != 0 ? z2 ? 2 : 3 : !z2 ? 1 : 0;
        d dVarB = d.b();
        dVarB.e("mediation_request").a("waterfall_abtest", str).a("server_bidding_extra", str2).a("mediation_req_type", Integer.valueOf(i3)).a("ad_count", Integer.valueOf(adSlot != null ? adSlot.getAdCount() : 0)).c(i2).d(message);
        HashMap map = new HashMap();
        int i4 = a;
        a = i4 + 1;
        if (i4 % 10 == 0) {
            map.put("gromore_thread_num", Integer.valueOf(ThreadHelper.getGroMoreThreadCount()));
        }
        if (adSlot != null && adSlot.getPrimeRitReqType() == 5) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("parallel_num", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a());
                jSONObject.put(am.aU, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().c());
                jSONObject.put("primerit_list", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().b());
                map.put("preload_info", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (adSlot != null && adSlot.getAdType() == 3) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().b(map);
        }
        map.put("csj_plugin_version", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.d.g());
        a(dVarB, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, (TTBaseAd) null, map);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map);
    }

    public static void a(TTBaseAd tTBaseAd, int i2, String str, long j2, AdSlot adSlot, int i3, int i4, int i5, String str2, long j3) {
        int i6 = (tTBaseAd == null || !tTBaseAd.isAdnPreload()) ? 0 : 1;
        d dVarB = d.b();
        dVarB.e("media_fill").a(j2).c(i2).d(str).a("adn_count", Integer.valueOf(i3)).a("adn_preload", Integer.valueOf(i6)).a("ad_count", Integer.valueOf(i4));
        dVarB.a("fill_type", Integer.valueOf(i5));
        if (str2 != null) {
            dVarB.a("sub_adn_name", str2);
        }
        HashMap map = new HashMap();
        if (j3 != -1) {
            map.put("end_time", Long.valueOf(j3));
        }
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().K() && tTBaseAd != null && 5 == tTBaseAd.getAdType()) {
            dVarB.a("ex_info", j.a().a(tTBaseAd));
        }
        a(dVarB, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, map);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map);
        while (true) {
            switch (72) {
                case 72:
                    return;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x004e. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x003e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0049 A[LOOP:1: B:10:0x0046->B:11:0x0049, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[LOOP:2: B:14:0x0052->B:29:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0054 -> B:9:0x0042). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.bytedance.msdk.base.TTBaseAd r2, com.bytedance.msdk.api.AdSlot r3, int r4, int r5, int r6, java.lang.String r7) {
        /*
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r5 = r0.e(r5)
            java.lang.String r1 = "media_show_after"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r5 = r5.e(r1)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r1 = "play_again"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r5 = r5.a(r1, r6)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r6 = "reason"
            r5.a(r6, r4)
            boolean r4 = android.text.TextUtils.isEmpty(r7)
            if (r4 != 0) goto L2c
            java.lang.String r4 = "callstack_message"
            r0.a(r4, r7)
        L2c:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r5 = 0
            a(r0, r3, r5, r2, r4)
            android.content.Context r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r2, r0, r4)
        L3c:
            r2 = 83
            switch(r2) {
                case 82: goto L42;
                case 83: goto L52;
                case 84: goto L3c;
                default: goto L41;
            }
        L41:
            goto L3c
        L42:
            r3 = 57
            r4 = 83
        L46:
            switch(r3) {
                case 39: goto L4e;
                case 40: goto L3c;
                case 41: goto L52;
                default: goto L49;
            }
        L49:
            r3 = 39
            r4 = 59
            goto L46
        L4e:
            switch(r4) {
                case 57: goto L52;
                case 58: goto L3c;
                case 59: goto L52;
                default: goto L51;
            }
        L51:
            goto L3c
        L52:
            r3 = 30
            switch(r3) {
                case 30: goto L58;
                case 31: goto L58;
                case 32: goto L42;
                default: goto L57;
            }
        L57:
            goto L52
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(com.bytedance.msdk.base.TTBaseAd, com.bytedance.msdk.api.AdSlot, int, int, int, java.lang.String):void");
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, int i2, String str, int i3, int i4, String str2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d dVarF;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVarC;
        d dVarB = d.b();
        dVarB.e("media_reward_verify").a("adn_preload", Integer.valueOf((tTBaseAd == null || !tTBaseAd.isAdnPreload()) ? 0 : 1)).a("reason", Integer.valueOf(i3)).a("play_again", Integer.valueOf(i2));
        if (i4 != 0 && i4 != 20000) {
            dVarB.c(i4).d(str2);
        }
        HashMap map = new HashMap();
        if (adSlot != null && (dVarF = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()) != null && (cVarC = dVarF.c(adSlot.getAdUnitId())) != null) {
            map.put("reward_callback_type", Integer.valueOf(cVarC.v()));
            map.put("reward_start_time", Integer.valueOf(cVarC.w()));
        }
        if (str != null) {
            dVarB.a("sub_adn_name", str);
        }
        a(dVarB, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, map);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map);
        while (true) {
            switch (64) {
                case 64:
                case 65:
                    while (true) {
                        switch (37) {
                            case 37:
                            case 39:
                                return;
                        }
                    }
                    break;
                case 66:
                    return;
            }
        }
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, int i2, String str, String str2, boolean z2) {
        d dVarB = d.b();
        dVarB.e("media_click_listen").a("adn_preload", Integer.valueOf((tTBaseAd == null || !tTBaseAd.isAdnPreload()) ? 0 : 1)).a("play_again", Integer.valueOf(i2)).a("is_repeat", Integer.valueOf(z2 ? 1 : 0));
        if (str != null) {
            dVarB.a("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            dVarB.a("callstack_message", str2);
        }
        HashMap map = new HashMap();
        a(dVarB, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, map);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map);
        byte b2 = 26;
        char c2 = '\t';
        while (true) {
            char c3 = 14;
            while (true) {
                switch (c3) {
                    case 16:
                        if (b2 <= 22) {
                            while (true) {
                                switch (c2) {
                                    case 30:
                                        return;
                                }
                            }
                        }
                        break;
                }
                c3 = 16;
                b2 = -44;
                c2 = 30;
            }
        }
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
    public static void a(com.bytedance.msdk.base.TTBaseAd r6, com.bytedance.msdk.api.AdSlot r7, int r8, java.lang.String r9, boolean r10) {
        /*
            r4 = 0
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r5 = r10
            a(r0, r1, r2, r3, r4, r5)
        L9:
            r6 = 73
            switch(r6) {
                case 72: goto Lf;
                case 73: goto Lf;
                case 74: goto Lf;
                default: goto Le;
            }
        Le:
            goto L9
        Lf:
            r6 = 61
            switch(r6) {
                case 59: goto L21;
                case 60: goto L21;
                case 61: goto L15;
                default: goto L14;
            }
        L14:
            goto Lf
        L15:
            r6 = 93
            switch(r6) {
                case 92: goto L9;
                case 93: goto L1b;
                case 94: goto Lf;
                default: goto L1a;
            }
        L1a:
            goto L15
        L1b:
            r6 = 52
            switch(r6) {
                case 52: goto L21;
                case 53: goto L9;
                case 54: goto Lf;
                default: goto L20;
            }
        L20:
            goto Lf
        L21:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(com.bytedance.msdk.base.TTBaseAd, com.bytedance.msdk.api.AdSlot, int, java.lang.String, boolean):void");
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar, long j2, String str, boolean z2, int i2) {
        d dVarB = d.b();
        dVarB.e("mediation_fill").a(j2).a("waterfall_abtest", cVar != null ? cVar.C() : null).a("server_bidding_extra", str).a("mediation_req_type", Integer.valueOf(!z2 ? 1 : 0)).a("ad_count", Integer.valueOf(i2)).c(0).d("");
        HashMap map = new HashMap();
        if (adSlot != null && adSlot.getAdType() == 3) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().a(map);
        }
        a(dVarB, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, map);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map);
        for (char c2 = 14; c2 != '\f' && c2 != '\r'; c2 = '\r') {
        }
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar) {
        d dVarB = d.b();
        dVarB.e("bidding_adm_cache");
        HashMap map = new HashMap();
        a(dVarB, adSlot, jVar, tTBaseAd, map);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map);
        while (true) {
            char c2 = '\f';
            switch (96) {
                case 95:
                    while (true) {
                        switch (c2) {
                            case '^':
                            case '`':
                                return;
                            case '_':
                                break;
                            default:
                                c2 = '_';
                                break;
                        }
                    }
                    break;
                case 96:
                    return;
            }
        }
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, long j2) {
        d dVarB = d.b();
        dVarB.e("bidding_adm_load").a(j2);
        HashMap map = new HashMap();
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().K() && tTBaseAd != null && 5 == tTBaseAd.getAdType()) {
            dVarB.a("ex_info", j.a().a(tTBaseAd));
        }
        a(dVarB, adSlot, jVar, tTBaseAd, map);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map);
        while (true) {
            switch (83) {
                case 83:
                    while (true) {
                        switch (39) {
                            case 39:
                            case 40:
                                return;
                        }
                    }
                    break;
            }
        }
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
    public static void a(com.bytedance.msdk.base.TTBaseAd r7, com.bytedance.msdk.api.AdSlot r8, com.bytedance.msdk.api.AdError r9, int r10, int r11, java.lang.String r12) {
        /*
            r6 = 0
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            a(r0, r1, r2, r3, r4, r5, r6)
        La:
            r7 = 73
            switch(r7) {
                case 72: goto L10;
                case 73: goto L10;
                case 74: goto L10;
                default: goto Lf;
            }
        Lf:
            goto La
        L10:
            r7 = 61
            switch(r7) {
                case 59: goto L22;
                case 60: goto L22;
                case 61: goto L16;
                default: goto L15;
            }
        L15:
            goto L10
        L16:
            r7 = 93
            switch(r7) {
                case 92: goto La;
                case 93: goto L1c;
                case 94: goto L10;
                default: goto L1b;
            }
        L1b:
            goto L16
        L1c:
            r7 = 52
            switch(r7) {
                case 52: goto L22;
                case 53: goto La;
                case 54: goto L10;
                default: goto L21;
            }
        L21:
            goto L10
        L22:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(com.bytedance.msdk.base.TTBaseAd, com.bytedance.msdk.api.AdSlot, com.bytedance.msdk.api.AdError, int, int, java.lang.String):void");
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, AdError adError, int i2, int i3, String str, String str2) {
        d dVarB = d.b();
        dVarB.e(i2).c(adError != null ? adError.thirdSdkErrorCode : 0).d(adError != null ? adError.thirdSdkErrorMessage : null).e("media_show_fail_listen").a("play_again", Integer.valueOf(i3));
        if (str != null) {
            dVarB.a("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            dVarB.a("callstack_message", str2);
        }
        HashMap map = new HashMap();
        a(dVarB, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, map);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map);
        while (true) {
            switch (42) {
                case 42:
                    return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, String str) {
        d dVarB = d.b();
        dVarB.e("media_show_dislike").d(str);
        HashMap map = new HashMap();
        a(dVarB, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, map);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map);
        while (true) {
            char c2 = 'J';
            char c3 = '7';
            while (true) {
                switch (c2) {
                    case 'H':
                        break;
                    case 'I':
                        switch (c3) {
                            case '^':
                                c2 = 'I';
                                c3 = '`';
                                break;
                            case '_':
                            case '`':
                                break;
                            default:
                                if (c3 == '8' || c3 == '9') {
                                }
                                c2 = 'I';
                                c3 = '`';
                                break;
                        }
                        break;
                    case 'J':
                        if (c3 == '8') {
                        }
                        break;
                    default:
                        c2 = 'H';
                        break;
                }
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0030 A[SYNTHETIC] */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.bytedance.msdk.base.TTBaseAd r3, com.bytedance.msdk.api.AdSlot r4, java.lang.String r5, int r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L7
            goto L3e
        L7:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            java.lang.String r1 = "callstack_static"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r0.e(r1)
            java.lang.String r2 = "callstack_message"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r5 = r1.a(r2, r5)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r1 = "callstack_report_time"
            r5.a(r1, r6)
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            r6 = 0
            a(r0, r4, r6, r3, r5)
            android.content.Context r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r3, r0, r5)
        L30:
            r3 = 95
            r4 = 60
            switch(r3) {
                case 95: goto L38;
                case 96: goto L3b;
                case 97: goto L3e;
                default: goto L37;
            }
        L37:
            goto L30
        L38:
            switch(r4) {
                case 60: goto L3e;
                case 61: goto L38;
                case 62: goto L3e;
                default: goto L3b;
            }
        L3b:
            switch(r4) {
                case 49: goto L30;
                case 50: goto L3e;
                case 51: goto L3e;
                default: goto L3e;
            }
        L3e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(com.bytedance.msdk.base.TTBaseAd, com.bytedance.msdk.api.AdSlot, java.lang.String, int):void");
    }

    public static void a(TTBaseAd tTBaseAd, AdSlot adSlot, List<TTBaseAd> list, List<TTBaseAd> list2) {
        HashMap map;
        char c2 = '@';
        while (true) {
            switch (c2) {
                case '@':
                case 'A':
                    c2 = 'B';
                    break;
                case 'B':
                    d dVarB = d.b();
                    dVarB.e("bidding_win_event");
                    HashMap map2 = new HashMap();
                    a(dVarB, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, map2);
                    JSONArray jSONArray = new JSONArray();
                    if (!h0.a(list)) {
                        Iterator<TTBaseAd> it = list.iterator();
                        while (it.hasNext()) {
                            TTBaseAd next = it.next();
                            if (next != null) {
                                Iterator<TTBaseAd> it2 = it;
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    map = map2;
                                    try {
                                        jSONObject.putOpt("mediation_rit", next.getAdNetworkSlotId());
                                        jSONObject.putOpt("adn_name", next.getAdNetWorkName());
                                        jSONObject.putOpt("load_sort", Integer.valueOf(next.getLoadSort()));
                                        jSONObject.putOpt("show_sort", Integer.valueOf(next.getShowSort()));
                                        jSONObject.putOpt("exchange_rate", next.getExchangeRate());
                                        jSONObject.putOpt("rit_cpm", Double.valueOf(next.getCpm()));
                                        jSONObject.putOpt("m_aid", next.getAid());
                                        jSONObject.putOpt("req_bidding_type", Integer.valueOf(next.getAdNetworkSlotType()));
                                        jSONObject.putOpt("win_state", 1);
                                        jSONObject.putOpt("ad_extra", next.getAdExtra());
                                        jSONObject.putOpt("win_callback", next.getWinCallback());
                                        jSONObject.putOpt("loss_callback", next.getFailCallback());
                                        if (next.isServerBiddingAd()) {
                                            jSONObject.putOpt("pricing_type", Integer.valueOf(next.getPricingType()));
                                        }
                                        jSONArray.put(jSONObject);
                                    } catch (Exception unused) {
                                    }
                                } catch (Exception unused2) {
                                    map = map2;
                                }
                                it = it2;
                                map2 = map;
                            }
                        }
                    }
                    HashMap map3 = map2;
                    if (!h0.a(list2)) {
                        Iterator<TTBaseAd> it3 = list2.iterator();
                        while (it3.hasNext()) {
                            TTBaseAd next2 = it3.next();
                            if (next2 != null) {
                                Iterator<TTBaseAd> it4 = it3;
                                try {
                                    JSONObject jSONObject2 = new JSONObject();
                                    JSONArray jSONArray2 = jSONArray;
                                    try {
                                        jSONObject2.putOpt("mediation_rit", next2.getAdNetworkSlotId());
                                        jSONObject2.putOpt("adn_name", next2.getAdNetWorkName());
                                        jSONObject2.putOpt("load_sort", Integer.valueOf(next2.getLoadSort()));
                                        jSONObject2.putOpt("show_sort", Integer.valueOf(next2.getShowSort()));
                                        jSONObject2.putOpt("exchange_rate", next2.getExchangeRate());
                                        jSONObject2.putOpt("rit_cpm", Double.valueOf(next2.getCpm()));
                                        jSONObject2.putOpt("m_aid", next2.getAid());
                                        jSONObject2.putOpt("req_bidding_type", Integer.valueOf(next2.getAdNetworkSlotType()));
                                        jSONObject2.putOpt("win_state", 0);
                                        jSONObject2.putOpt("ad_extra", next2.getAdExtra());
                                        jSONObject2.putOpt("win_callback", next2.getWinCallback());
                                        jSONObject2.putOpt("loss_callback", next2.getFailCallback());
                                        if (next2.isServerBiddingAd()) {
                                            jSONObject2.putOpt("pricing_type", Integer.valueOf(next2.getPricingType()));
                                        }
                                        jSONArray = jSONArray2;
                                        jSONArray.put(jSONObject2);
                                    } catch (Exception unused3) {
                                        jSONArray = jSONArray2;
                                    }
                                } catch (Exception unused4) {
                                }
                                it3 = it4;
                            }
                        }
                    }
                    map3.put("others", jSONArray);
                    c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map3);
                    return;
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004b -> B:13:0x0042). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0053 -> B:13:0x0042). Please report as a decompilation issue!!! */
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
    public static void a(com.bytedance.msdk.base.TTBaseAd r4, com.bytedance.msdk.api.AdSlot r5, boolean r6) {
        /*
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            if (r4 == 0) goto Le
            boolean r1 = r4.isAdnPreload()
            if (r1 == 0) goto Le
            r1 = 1
            goto Lf
        Le:
            r1 = 0
        Lf:
            java.lang.String r2 = "media_show"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r2 = r0.e(r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r3 = "adn_preload"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r2.a(r3, r1)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r2 = "is_repeat"
            r1.a(r2, r6)
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            r1 = 0
            a(r0, r5, r1, r4, r6)
            android.content.Context r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r4, r0, r6)
        L38:
            r4 = 40
        L3a:
            r5 = 30
            r6 = 83
            switch(r5) {
                case 30: goto L42;
                case 31: goto L42;
                case 32: goto L49;
                default: goto L41;
            }
        L41:
            goto L3a
        L42:
            switch(r6) {
                case 82: goto L47;
                case 83: goto L46;
                case 84: goto L42;
                default: goto L45;
            }
        L45:
            goto L42
        L46:
            return
        L47:
            r4 = 83
        L49:
            r5 = 57
        L4b:
            switch(r5) {
                case 39: goto L53;
                case 40: goto L42;
                case 41: goto L38;
                default: goto L4e;
            }
        L4e:
            r4 = 59
            r5 = 39
            goto L4b
        L53:
            switch(r4) {
                case 57: goto L42;
                case 58: goto L42;
                case 59: goto L38;
                default: goto L56;
            }
        L56:
            goto L42
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(com.bytedance.msdk.base.TTBaseAd, com.bytedance.msdk.api.AdSlot, boolean):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(String str) {
        d dVarB = d.b();
        dVarB.c(0).d("广告请求").e(str);
        a(dVarB, (AdSlot) null, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, (TTBaseAd) null);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, null);
        while (true) {
            char c2 = 'J';
            char c3 = '7';
            while (true) {
                switch (c2) {
                    case 'H':
                        break;
                    case 'I':
                        switch (c3) {
                            case '^':
                                c2 = 'I';
                                c3 = '`';
                                break;
                            case '_':
                            case '`':
                                break;
                            default:
                                if (c3 == '8' || c3 == '9') {
                                }
                                c2 = 'I';
                                c3 = '`';
                                break;
                        }
                        break;
                    case 'J':
                        if (c3 == '8') {
                        }
                        break;
                    default:
                        c2 = 'H';
                        break;
                }
                return;
            }
        }
    }

    public static void a(String str, TTBaseAd tTBaseAd, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, AdError adError) {
        d dVarB = d.b();
        d dVarD = dVarB.c(adError != null ? adError.code : 0).d(adError != null ? adError.message : null);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        dVarD.b(str).e("custom_adn_init_fail");
        HashMap map = new HashMap();
        a(dVarB, adSlot, jVar, tTBaseAd, map);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map);
        while (true) {
            switch (72) {
                case 71:
                case 72:
                    return;
            }
        }
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public static void a(java.util.List<com.bytedance.msdk.base.TTBaseAd> r10, com.bytedance.msdk.api.AdSlot r11) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(java.util.List, com.bytedance.msdk.api.AdSlot):void");
    }

    /* JADX WARN: Failed to build post-dominance tree
    java.lang.ArrayIndexOutOfBoundsException: Index 91 out of bounds for length 89
    	at jadx.core.dex.visitors.blocks.DominatorTree.build(DominatorTree.java:54)
    	at jadx.core.dex.visitors.blocks.PostDominatorTree.compute(PostDominatorTree.java:32)
    	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:93)
    	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:50)
     */
    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getId()" because "imPostDom" is null
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:186)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
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
    public static void a(java.util.List<com.bytedance.msdk.base.TTBaseAd> r8, java.util.List<com.bytedance.msdk.base.TTBaseAd> r9, java.util.List<com.bytedance.msdk.base.TTBaseAd> r10, com.bytedance.msdk.api.AdSlot r11, java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(java.util.List, java.util.List, java.util.List, com.bytedance.msdk.api.AdSlot, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0011 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[LOOP:1: B:7:0x000b->B:31:?, LOOP_END, SYNTHETIC] */
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
    public static void a(boolean r3) {
        /*
        L0:
            r0 = 96
            switch(r0) {
                case 95: goto Lb;
                case 96: goto L6;
                case 97: goto Lb;
                default: goto L5;
            }
        L5:
            goto L0
        L6:
            r0 = 51
            switch(r0) {
                case 49: goto Lb;
                case 50: goto L44;
                case 51: goto Lb;
                default: goto Lb;
            }
        Lb:
            r0 = 61
            switch(r0) {
                case 60: goto Lb;
                case 61: goto L11;
                case 62: goto L44;
                default: goto L10;
            }
        L10:
            goto Lb
        L11:
            r0 = 54
            switch(r0) {
                case 52: goto L44;
                case 53: goto L0;
                case 54: goto L17;
                default: goto L16;
            }
        L16:
            goto L11
        L17:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0 r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d.S()
            java.lang.String r2 = "is_config_from_assert"
            boolean r1 = r1.a(r2)
            r2 = 0
            if (r3 == 0) goto L2d
            if (r1 == 0) goto L2c
            r2 = 2
            goto L2d
        L2c:
            r2 = 1
        L2d:
            java.lang.String r3 = "get_config_start"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r3 = r0.e(r3)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.String r2 = "reason"
            r3.a(r2, r1)
            android.content.Context r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            r1 = 0
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r3, r0, r1)
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0012 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[LOOP:1: B:8:0x000c->B:36:?, LOOP_END, SYNTHETIC] */
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
    public static void b(long r2) {
        /*
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
                case 92: goto L12;
                case 93: goto L0;
                default: goto L11;
            }
        L11:
            goto Lc
        L12:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            java.lang.String r1 = "sdk_init"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r0.e(r1)
            r1.b(r2)
            r2 = 0
            java.lang.String r3 = "com.unity3d.player.UnityPlayer"
            java.lang.Class.forName(r3)     // Catch: java.lang.Throwable -> L32
            java.lang.String r2 = "com.bytedance.ad.sdk.mediation.AdManager"
            java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r2 = "unity"
            goto L33
        L2e:
            java.lang.String r2 = "unity_pure"
            goto L33
        L32:
        L33:
            if (r2 == 0) goto L3a
            java.lang.String r3 = "develop_type"
            r0.a(r3, r2)
        L3a:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.d.g()
            java.lang.String r1 = "csj_plugin_version"
            r2.put(r1, r3)
            android.content.Context r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r3, r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(long):void");
    }

    /* JADX INFO: Infinite loop detected, blocks: 3, insns: 0 */
    public static void b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j jVar, AdSlot adSlot, int i2, int i3) {
        d dVarB = d.b();
        dVarB.e("adapter_request").a("mediationrit_req_type", Integer.valueOf(i2)).a("mediationrit_req_type_src", Integer.valueOf(i3));
        HashMap map = new HashMap();
        a(dVarB, adSlot, jVar, (TTBaseAd) null, map);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map);
        while (true) {
            char c2 = '\r';
            char c3 = '4';
            switch (96) {
                case 95:
                    while (true) {
                        switch (c3) {
                            case '7':
                                switch (c2) {
                                    case '>':
                                        while (true) {
                                        }
                                        break;
                                }
                                break;
                            case '8':
                                break;
                            case '9':
                                break;
                            default:
                                c3 = '7';
                                c2 = '=';
                                break;
                        }
                    }
                    break;
            }
            return;
        }
        while (true) {
            switch (49) {
                case 49:
                    return;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0015. Please report as an issue. */
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
    private static void b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r2) {
        /*
            java.lang.String r0 = "-1"
            java.lang.String r1 = "block_pacing"
            r2.a(r1, r0)
            java.lang.String r1 = "rit_adn_show_rule_id"
            r2.a(r1, r0)
            java.lang.String r1 = "block_show_count"
            r2.a(r1, r0)
        L11:
            r2 = 93
            r0 = 93
        L15:
            switch(r0) {
                case 92: goto L1d;
                case 93: goto L20;
                case 94: goto L19;
                default: goto L18;
            }
        L18:
            goto L11
        L19:
            r0 = 4
            if (r2 <= r0) goto L11
            return
        L1d:
            switch(r2) {
                case 21: goto L26;
                case 22: goto L26;
                case 23: goto L26;
                default: goto L20;
            }
        L20:
            switch(r2) {
                case 91: goto L26;
                case 92: goto L26;
                case 93: goto L26;
                default: goto L23;
            }
        L23:
            r2 = 91
            goto L20
        L26:
            r0 = 94
            r2 = 75
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x002a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(com.bytedance.msdk.api.AdSlot r3, java.lang.String r4) {
        /*
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            java.lang.String r1 = "media_will_show"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r1 = r0.e(r1)
            java.lang.String r2 = "waterfall_abtest"
            r1.a(r2, r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r1 = 0
            a(r0, r3, r1, r1, r4)
            android.content.Context r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r3, r0, r4)
        L20:
            r3 = 73
            r4 = 96
        L24:
            switch(r3) {
                case 72: goto L32;
                case 73: goto L2a;
                case 74: goto L2d;
                default: goto L27;
            }
        L27:
            r3 = 72
            goto L24
        L2a:
            switch(r4) {
                case 94: goto L20;
                case 95: goto L32;
                case 96: goto L32;
                default: goto L2d;
            }
        L2d:
            switch(r4) {
                case 55: goto L31;
                case 56: goto L32;
                case 57: goto L32;
                default: goto L30;
            }
        L30:
            goto L20
        L31:
            return
        L32:
            r3 = 74
            r4 = 55
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(com.bytedance.msdk.api.AdSlot, java.lang.String):void");
    }

    public static void b(TTBaseAd tTBaseAd, AdSlot adSlot, int i2, String str, String str2, boolean z2) {
        d dVarB = d.b();
        dVarB.e("media_show_listen").a("adn_preload", Integer.valueOf((tTBaseAd == null || !tTBaseAd.isAdnPreload()) ? 0 : 1)).a("play_again", Integer.valueOf(i2)).a("is_repeat", Integer.valueOf(z2 ? 1 : 0));
        if (str != null) {
            dVarB.a("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            dVarB.a("callstack_message", str2);
        }
        HashMap map = new HashMap();
        a(dVarB, adSlot, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) null, tTBaseAd, map);
        c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), dVarB, map);
        byte b2 = 26;
        char c2 = '\t';
        while (true) {
            char c3 = 14;
            while (true) {
                switch (c3) {
                    case 16:
                        if (b2 <= 22) {
                            while (true) {
                                switch (c2) {
                                    case 30:
                                        return;
                                }
                            }
                        }
                        break;
                }
                c3 = 16;
                b2 = -44;
                c2 = 30;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0020 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[LOOP:2: B:11:0x001a->B:26:?, LOOP_END, SYNTHETIC] */
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
    public static void b(com.bytedance.msdk.base.TTBaseAd r6, com.bytedance.msdk.api.AdSlot r7, int r8, java.lang.String r9, boolean r10) {
        /*
            r4 = 0
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r5 = r10
            b(r0, r1, r2, r3, r4, r5)
        L9:
            r6 = 61
            switch(r6) {
                case 59: goto L1a;
                case 60: goto L20;
                case 61: goto Lf;
                default: goto Le;
            }
        Le:
            goto L9
        Lf:
            r6 = 93
            switch(r6) {
                case 92: goto L1a;
                case 93: goto L15;
                case 94: goto L1a;
                default: goto L14;
            }
        L14:
            goto Lf
        L15:
            r6 = 52
            switch(r6) {
                case 52: goto L1a;
                case 53: goto L1a;
                case 54: goto L1a;
                default: goto L1a;
            }
        L1a:
            r6 = 73
            switch(r6) {
                case 72: goto L9;
                case 73: goto L20;
                case 74: goto L1a;
                default: goto L1f;
            }
        L1f:
            goto L1a
        L20:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(com.bytedance.msdk.base.TTBaseAd, com.bytedance.msdk.api.AdSlot, int, java.lang.String, boolean):void");
    }

    /* JADX INFO: Infinite loop detected, blocks: 3, insns: 0 */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0027, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(java.lang.String r2) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L7
            goto L45
        L7:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d.b()
            java.lang.String r1 = "callstack_dynamic"
            r0.e(r1)
            java.lang.String r1 = "callstack_message"
            r0.a(r1, r2)
            r2 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r1 = "callstack_report_time"
            r0.a(r1, r2)
            android.content.Context r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()
            r1 = 0
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(r2, r0, r1)
        L27:
            r2 = 49
            switch(r2) {
                case 49: goto L2d;
                case 50: goto L45;
                case 51: goto L45;
                default: goto L2c;
            }
        L2c:
            goto L27
        L2d:
            r0 = 52
            r1 = 96
            switch(r1) {
                case 94: goto L27;
                case 95: goto L35;
                case 96: goto L45;
                default: goto L34;
            }
        L34:
            goto L2d
        L35:
            r1 = 49
        L37:
            switch(r0) {
                case 55: goto L3f;
                case 56: goto L27;
                case 57: goto L2d;
                default: goto L3a;
            }
        L3a:
            r0 = 55
            r1 = 61
            goto L37
        L3f:
            switch(r1) {
                case 60: goto L45;
                case 61: goto L2d;
                case 62: goto L43;
                default: goto L42;
            }
        L42:
            goto L27
        L43:
            goto L43
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(java.lang.String):void");
    }
}
