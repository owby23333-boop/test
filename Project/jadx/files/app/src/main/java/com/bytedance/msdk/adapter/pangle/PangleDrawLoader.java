package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PangleDrawLoader {

    private static class PangleDrawAd extends TTBaseAd {
        private TTFeedAd a;
        private boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        TTNativeAd.AdInteractionListener f13970c = new TTNativeAd.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.3
            /* JADX WARN: Removed duplicated region for block: B:24:0x006f A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0011 A[SYNTHETIC] */
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onAdClicked(android.view.View r4, com.bytedance.sdk.openadsdk.TTNativeAd r5) {
                /*
                    r3 = this;
                    com.bytedance.msdk.adapter.pangle.PangleDrawLoader$PangleDrawAd r4 = com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.this
                    com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener r4 = com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.b(r4)
                    if (r4 == 0) goto L11
                    com.bytedance.msdk.adapter.pangle.PangleDrawLoader$PangleDrawAd r4 = com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.this
                    com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener r4 = com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.l(r4)
                    r4.onAdClick()
                L11:
                    r4 = 12
                    r5 = 96
                    switch(r5) {
                        case 94: goto L1f;
                        case 95: goto L19;
                        case 96: goto L6f;
                        default: goto L18;
                    }
                L18:
                    goto L11
                L19:
                    switch(r4) {
                        case 94: goto L3d;
                        case 95: goto L57;
                        case 96: goto L6f;
                        default: goto L1c;
                    }
                L1c:
                    r4 = 95
                    goto L19
                L1f:
                    r4 = 1
                    r5 = 81
                    int r0 = 81 - r4
                    int r0 = r0 * 81
                    int r5 = r5 * 2
                    int r5 = r5 - r4
                    int r0 = r0 * r5
                    int r0 = r0 % 6
                    if (r0 == 0) goto L11
                    r4 = 66
                    int r4 = r4 * r4
                    r5 = 16
                    int r5 = r5 * r5
                    int r5 = r5 * 34
                    int r4 = r4 - r5
                    r5 = -1
                    if (r4 != r5) goto L57
                L3d:
                    r4 = 29
                    int r5 = r4 * r4
                    r0 = 45
                    int r1 = r0 * r0
                    int r5 = r5 + r1
                    r1 = 20
                    int r2 = r1 * r1
                    int r5 = r5 + r2
                    r2 = 29
                    int r2 = r2 * 45
                    int r0 = r0 * 20
                    int r2 = r2 + r0
                    int r4 = r4 * 20
                    int r2 = r2 + r4
                    if (r5 >= r2) goto L6f
                L57:
                    r4 = 70
                    int r5 = r4 * r4
                    r0 = 7
                    int r1 = r0 * r0
                    int r5 = r5 + r1
                    r1 = 4
                    int r2 = r1 * r1
                    int r5 = r5 + r2
                    r2 = 70
                    int r2 = r2 * 7
                    int r0 = r0 * 4
                    int r2 = r2 + r0
                    int r4 = r4 * 4
                    int r2 = r2 + r4
                    if (r5 >= r2) goto L11
                L6f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.AnonymousClass3.onAdClicked(android.view.View, com.bytedance.sdk.openadsdk.TTNativeAd):void");
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x006f A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0011 A[SYNTHETIC] */
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onAdCreativeClick(android.view.View r4, com.bytedance.sdk.openadsdk.TTNativeAd r5) {
                /*
                    r3 = this;
                    com.bytedance.msdk.adapter.pangle.PangleDrawLoader$PangleDrawAd r4 = com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.this
                    com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener r4 = com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.m(r4)
                    if (r4 == 0) goto L11
                    com.bytedance.msdk.adapter.pangle.PangleDrawLoader$PangleDrawAd r4 = com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.this
                    com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener r4 = com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.n(r4)
                    r4.onAdClick()
                L11:
                    r4 = 12
                    r5 = 96
                    switch(r5) {
                        case 94: goto L1f;
                        case 95: goto L19;
                        case 96: goto L6f;
                        default: goto L18;
                    }
                L18:
                    goto L11
                L19:
                    switch(r4) {
                        case 94: goto L3d;
                        case 95: goto L57;
                        case 96: goto L6f;
                        default: goto L1c;
                    }
                L1c:
                    r4 = 95
                    goto L19
                L1f:
                    r4 = 1
                    r5 = 81
                    int r0 = 81 - r4
                    int r0 = r0 * 81
                    int r5 = r5 * 2
                    int r5 = r5 - r4
                    int r0 = r0 * r5
                    int r0 = r0 % 6
                    if (r0 == 0) goto L11
                    r4 = 66
                    int r4 = r4 * r4
                    r5 = 16
                    int r5 = r5 * r5
                    int r5 = r5 * 34
                    int r4 = r4 - r5
                    r5 = -1
                    if (r4 != r5) goto L57
                L3d:
                    r4 = 29
                    int r5 = r4 * r4
                    r0 = 45
                    int r1 = r0 * r0
                    int r5 = r5 + r1
                    r1 = 20
                    int r2 = r1 * r1
                    int r5 = r5 + r2
                    r2 = 29
                    int r2 = r2 * 45
                    int r0 = r0 * 20
                    int r2 = r2 + r0
                    int r4 = r4 * 20
                    int r2 = r2 + r4
                    if (r5 >= r2) goto L6f
                L57:
                    r4 = 70
                    int r5 = r4 * r4
                    r0 = 7
                    int r1 = r0 * r0
                    int r5 = r5 + r1
                    r1 = 4
                    int r2 = r1 * r1
                    int r5 = r5 + r2
                    r2 = 70
                    int r2 = r2 * 7
                    int r0 = r0 * 4
                    int r2 = r2 + r0
                    int r4 = r4 * 4
                    int r2 = r2 + r4
                    if (r5 >= r2) goto L11
                L6f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.AnonymousClass3.onAdCreativeClick(android.view.View, com.bytedance.sdk.openadsdk.TTNativeAd):void");
            }

            /* JADX WARN: Removed duplicated region for block: B:26:0x0089 A[LOOP:1: B:11:0x003b->B:26:0x0089, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:40:0x008e A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:46:0x0041 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:49:0x00a9 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:55:0x004d A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:56:0x0094 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:57:0x009f A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:59:0x008e A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:60:0x008e A[SYNTHETIC] */
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
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onAdShow(com.bytedance.sdk.openadsdk.TTNativeAd r10) {
                /*
                    Method dump skipped, instruction units count: 210
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.AnonymousClass3.onAdShow(com.bytedance.sdk.openadsdk.TTNativeAd):void");
            }
        };

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TTFeedAd.VideoAdListener f13971d = new TTFeedAd.VideoAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.4
            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onProgressUpdate(long j2, long j3) {
                if (((TTBaseAd) PangleDrawAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) PangleDrawAd.this).mTTVideoListener.onProgressUpdate(j2, j3);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:26:0x0089 A[LOOP:1: B:11:0x003b->B:26:0x0089, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:40:0x008e A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:46:0x0041 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:49:0x00a9 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:55:0x004d A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:56:0x0094 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:57:0x009f A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:59:0x008e A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:60:0x008e A[SYNTHETIC] */
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
            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onVideoAdComplete(com.bytedance.sdk.openadsdk.TTFeedAd r10) {
                /*
                    Method dump skipped, instruction units count: 210
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.AnonymousClass4.onVideoAdComplete(com.bytedance.sdk.openadsdk.TTFeedAd):void");
            }

            /* JADX WARN: Removed duplicated region for block: B:33:0x00a5 A[LOOP:2: B:18:0x0055->B:33:0x00a5, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:39:0x0031 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:40:0x00aa A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:44:0x0011 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:48:0x0039 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:49:0x0053 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:50:0x0067 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:55:0x0031 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:60:0x005b A[SYNTHETIC] */
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
            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onVideoAdContinuePlay(com.bytedance.sdk.openadsdk.TTFeedAd r10) {
                /*
                    Method dump skipped, instruction units count: 212
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.AnonymousClass4.onVideoAdContinuePlay(com.bytedance.sdk.openadsdk.TTFeedAd):void");
            }

            /* JADX WARN: Removed duplicated region for block: B:26:0x0089 A[LOOP:1: B:11:0x003b->B:26:0x0089, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:40:0x008e A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:46:0x0041 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:49:0x00a9 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:55:0x004d A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:56:0x0094 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:57:0x009f A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:59:0x008e A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:60:0x008e A[SYNTHETIC] */
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
            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onVideoAdPaused(com.bytedance.sdk.openadsdk.TTFeedAd r10) {
                /*
                    Method dump skipped, instruction units count: 210
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.AnonymousClass4.onVideoAdPaused(com.bytedance.sdk.openadsdk.TTFeedAd):void");
            }

            /* JADX WARN: Removed duplicated region for block: B:33:0x00a5 A[LOOP:2: B:18:0x0055->B:33:0x00a5, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:39:0x0031 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:40:0x00aa A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:44:0x0011 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:48:0x0039 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:49:0x0053 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:50:0x0067 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:55:0x0031 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:60:0x005b A[SYNTHETIC] */
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
            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onVideoAdStartPlay(com.bytedance.sdk.openadsdk.TTFeedAd r10) {
                /*
                    Method dump skipped, instruction units count: 212
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.AnonymousClass4.onVideoAdStartPlay(com.bytedance.sdk.openadsdk.TTFeedAd):void");
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x008f, code lost:
            
                continue;
             */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0080  */
            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onVideoError(int r5, int r6) {
                /*
                    r4 = this;
                    com.bytedance.msdk.adapter.pangle.PangleDrawLoader$PangleDrawAd r0 = com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.q(r0)
                    if (r0 == 0) goto L92
                    com.bytedance.msdk.adapter.pangle.PangleDrawLoader$PangleDrawAd r0 = com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.r(r0)
                    com.bytedance.msdk.api.AdError r1 = new com.bytedance.msdk.api.AdError
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Android MediaPlay Error Code :"
                    r2.append(r3)
                    r2.append(r6)
                    java.lang.String r6 = r2.toString()
                    r1.<init>(r5, r6)
                    r0.onVideoError(r1)
                L27:
                    r5 = 73
                L29:
                    switch(r5) {
                        case 72: goto L92;
                        case 73: goto L8f;
                        case 74: goto L2d;
                        default: goto L2c;
                    }
                L2c:
                    goto L8f
                L2d:
                    r5 = 55
                    r6 = 16
                    r0 = 1
                    switch(r6) {
                        case 52: goto L51;
                        case 53: goto L5a;
                        case 54: goto L36;
                        default: goto L35;
                    }
                L35:
                    goto L8f
                L36:
                    r5 = 37
                    int r6 = r5 * r5
                    r1 = 196(0xc4, float:2.75E-43)
                    int r1 = r1 + r6
                    r6 = 9
                    int r2 = r6 * r6
                    int r1 = r1 + r2
                    r2 = 14
                    int r2 = r2 * 37
                    int r5 = r5 * 9
                    int r2 = r2 + r5
                    r5 = 14
                    int r5 = r5 * 9
                    int r2 = r2 + r5
                    if (r1 >= r2) goto L27
                    goto L5e
                L51:
                    r6 = 15
                    int r6 = r6 + r0
                    int r6 = r6 * 15
                    int r6 = r6 % 2
                    if (r6 == 0) goto L72
                L5a:
                    switch(r5) {
                        case 29: goto L5e;
                        case 30: goto L72;
                        case 31: goto L80;
                        default: goto L5d;
                    }
                L5d:
                    goto L6f
                L5e:
                    r5 = 69
                    int r6 = r5 * r5
                    r1 = 22
                    int r2 = r1 * r1
                    int r6 = r6 + r2
                    int r5 = r5 * 22
                    int r5 = r5 * 2
                    int r6 = r6 - r5
                    if (r6 >= 0) goto L92
                    goto L72
                L6f:
                    r5 = 30
                    goto L5a
                L72:
                    r5 = 61
                    int r5 = r5 * r5
                    r6 = 12
                    int r6 = r6 * r6
                    int r6 = r6 * 34
                    int r5 = r5 - r6
                    r6 = -1
                    if (r5 != r6) goto L8f
                L80:
                    r5 = 38
                    int r6 = 38 - r0
                    int r6 = r6 * 38
                    int r5 = r5 * 2
                    int r5 = r5 - r0
                    int r6 = r6 * r5
                    int r6 = r6 % 6
                    if (r6 == 0) goto L2d
                L8f:
                    r5 = 72
                    goto L29
                L92:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.AnonymousClass4.onVideoError(int, int):void");
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoLoad(TTFeedAd tTFeedAd) {
            }
        };

        PangleDrawAd(TTFeedAd tTFeedAd, boolean z2) {
            TTImage videoCoverImage;
            Map<String, Object> mediaExtraInfo;
            this.a = tTFeedAd;
            this.b = z2;
            ComplianceInfo complianceInfo = tTFeedAd.getComplianceInfo();
            if (complianceInfo != null) {
                setAppName(complianceInfo.getAppName());
                setAuthorName(complianceInfo.getDeveloperName());
                setPrivacyAgreement(complianceInfo.getPrivacyUrl());
                setVersionName(complianceInfo.getAppVersion());
                HashMap map = new HashMap();
                Map<String, String> permissionsMap = complianceInfo.getPermissionsMap();
                if (permissionsMap != null && permissionsMap.size() > 0) {
                    map.putAll(permissionsMap);
                }
                setPermissionsMap(map);
            }
            setTitle(tTFeedAd.getTitle());
            setAdDescription(tTFeedAd.getDescription());
            setActionText(tTFeedAd.getButtonText());
            setIconUrl(tTFeedAd.getIcon() != null ? tTFeedAd.getIcon().getImageUrl() : null);
            setImageMode(tTFeedAd.getImageMode());
            setInteractionType(tTFeedAd.getInteractionType());
            setSource(tTFeedAd.getSource());
            setRating(tTFeedAd.getAppScore());
            setIsAppDownload(tTFeedAd.getInteractionType() == 4);
            setExpressAd(false);
            this.a.getMediaExtraInfo();
            if (tTFeedAd.getImageMode() == 16 || tTFeedAd.getImageMode() == 3 || tTFeedAd.getImageMode() == 2) {
                if (tTFeedAd.getImageList() != null && !tTFeedAd.getImageList().isEmpty() && tTFeedAd.getImageList().get(0) != null) {
                    videoCoverImage = tTFeedAd.getImageList().get(0);
                    setImageUrl(videoCoverImage.getImageUrl());
                    setImageHeight(videoCoverImage.getHeight());
                    setImageWidth(videoCoverImage.getWidth());
                }
            } else if (tTFeedAd.getImageMode() == 4) {
                if (tTFeedAd.getImageList() != null && tTFeedAd.getImageList().size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<TTImage> it = tTFeedAd.getImageList().iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getImageUrl());
                    }
                    setImages(arrayList);
                }
            } else if (tTFeedAd.getImageMode() == 5 || tTFeedAd.getImageMode() == 15) {
                videoCoverImage = tTFeedAd.getVideoCoverImage();
                if (videoCoverImage == null && tTFeedAd.getImageList() != null && !tTFeedAd.getImageList().isEmpty() && tTFeedAd.getImageList().get(0) != null) {
                    videoCoverImage = tTFeedAd.getImageList().get(0);
                }
                if (videoCoverImage != null) {
                    setImageUrl(videoCoverImage.getImageUrl());
                    setImageHeight(videoCoverImage.getHeight());
                    setImageWidth(videoCoverImage.getWidth());
                }
            }
            if (this.b && (mediaExtraInfo = tTFeedAd.getMediaExtraInfo()) != null) {
                double value = PangleAdapterUtils.getValue(mediaExtraInfo.get("price"));
                Logger.d("TTMediationSDK_ECMP", "pangle draw 返回的 cpm价格：" + value);
                setCpm(value <= PangleAdapterUtils.CPM_DEFLAUT_VALUE ? 0.0d : value);
            }
            this.a.setVideoAdListener(this.f13971d);
            putExtraMsg(GMAdConstant.EXTRA_ADID, Long.valueOf(getAdId()));
            putExtraMsg(GMAdConstant.EXTRA_CID, Long.valueOf(getCreativeId()));
            putExtraMsg("duration", Double.valueOf(this.a.getVideoDuration()));
            Map<String, Object> mediaExtraInfo2 = this.a.getMediaExtraInfo();
            if (mediaExtraInfo2 != null) {
                putExtraMsg("log_extra", mediaExtraInfo2.toString());
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTFeedAd tTFeedAd = this.a;
            return tTFeedAd != null ? PangleAdapterUtils.getAdId(tTFeedAd.getMediaExtraInfo()) : super.getAdId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getCreativeId() {
            TTFeedAd tTFeedAd = this.a;
            return tTFeedAd != null ? PangleAdapterUtils.getCreativeId(tTFeedAd.getMediaExtraInfo()) : super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMAdDislike getDislikeDialog(Activity activity, Map<String, Object> map) {
            TTFeedAd tTFeedAd = this.a;
            if (tTFeedAd == null) {
                return super.getDislikeDialog(activity, map);
            }
            final TTAdDislike dislikeDialog = tTFeedAd.getDislikeDialog(activity);
            return new GMAdDislike(this) { // from class: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.2
                @Override // com.bytedance.msdk.api.v2.GMAdDislike
                public void setDislikeCallback(final GMDislikeCallback gMDislikeCallback) {
                    if (gMDislikeCallback != null) {
                        dislikeDialog.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback(this) { // from class: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.2.1
                            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                            public void onCancel() {
                                gMDislikeCallback.onCancel();
                            }

                            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                            public void onSelected(int i2, String str, boolean z2) {
                                gMDislikeCallback.onSelected(i2, str);
                            }

                            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                            public void onShow() {
                                GMDislikeCallback gMDislikeCallback2 = gMDislikeCallback;
                                if (gMDislikeCallback2 != null) {
                                    gMDislikeCallback2.onShow();
                                }
                            }
                        });
                    }
                }

                @Override // com.bytedance.msdk.api.v2.GMAdDislike
                public void showDislikeDialog() {
                    TTAdDislike tTAdDislike = dislikeDialog;
                    if (tTAdDislike != null) {
                        tTAdDislike.showDislikeDialog();
                    }
                }
            };
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMNativeCustomVideoReporter getGMNativeCustomVideoReporter() {
            if (isUseCustomVideo()) {
                return new GMNativeCustomVideoReporter() { // from class: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.1
                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoAutoStart() {
                        if (PangleDrawAd.this.a == null || PangleDrawAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleDrawAd.this.a.getCustomVideo().reportVideoAutoStart();
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoBreak(long j2) {
                        if (PangleDrawAd.this.a == null || PangleDrawAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleDrawAd.this.a.getCustomVideo().reportVideoBreak(j2);
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoContinue(long j2) {
                        if (PangleDrawAd.this.a == null || PangleDrawAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleDrawAd.this.a.getCustomVideo().reportVideoContinue(j2);
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoError(long j2, int i2, int i3) {
                        if (PangleDrawAd.this.a == null || PangleDrawAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleDrawAd.this.a.getCustomVideo().reportVideoError(j2, i2, i3);
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoFinish() {
                        if (PangleDrawAd.this.a == null || PangleDrawAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleDrawAd.this.a.getCustomVideo().reportVideoFinish();
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoPause(long j2) {
                        if (PangleDrawAd.this.a == null || PangleDrawAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleDrawAd.this.a.getCustomVideo().reportVideoPause(j2);
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoStart() {
                        if (PangleDrawAd.this.a == null || PangleDrawAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleDrawAd.this.a.getCustomVideo().reportVideoStart();
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoStartError(int i2, int i3) {
                        if (PangleDrawAd.this.a == null || PangleDrawAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleDrawAd.this.a.getCustomVideo().reportVideoStartError(i2, i3);
                    }
                };
            }
            return null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> mediaExtraInfo;
            TTFeedAd tTFeedAd = this.a;
            if (tTFeedAd == null || (mediaExtraInfo = tTFeedAd.getMediaExtraInfo()) == null) {
                return super.getMediaExtraInfo();
            }
            HashMap map = new HashMap();
            map.put(PangleAdapterUtils.MEDIA_EXTRA_COUPON, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_COUPON));
            map.put(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM));
            map.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT));
            return map;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public String getReqId() {
            TTFeedAd tTFeedAd = this.a;
            return tTFeedAd != null ? PangleAdapterUtils.getReqId(tTFeedAd.getMediaExtraInfo()) : super.getReqId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getVideoHeight() {
            TTFeedAd tTFeedAd = this.a;
            if (tTFeedAd != null) {
                return tTFeedAd.getAdViewHeight();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public String getVideoUrl() {
            TTFeedAd tTFeedAd;
            if (!isUseCustomVideo() || (tTFeedAd = this.a) == null || tTFeedAd.getCustomVideo() == null) {
                return null;
            }
            return this.a.getCustomVideo().getVideoUrl();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getVideoWidth() {
            TTFeedAd tTFeedAd = this.a;
            if (tTFeedAd != null) {
                return tTFeedAd.getAdViewWidth();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDislike() {
            return true;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            TTFeedAd tTFeedAd = this.a;
            if (tTFeedAd != null) {
                tTFeedAd.setVideoAdListener(null);
                this.a = null;
            }
            super.onDestroy();
        }

        /* JADX WARN: Code restructure failed: missing block: B:45:0x00e0, code lost:
        
            r11 = (((86 - 1) * 86) * ((86 * 2) - 1)) % 6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0112, code lost:
        
            if (((30 * 30) - ((10 * 10) * 34)) != (-1)) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0115, code lost:
        
            if (r9 == 5) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0118, code lost:
        
            if (r9 == 6) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x011b, code lost:
        
            if (r9 == 7) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0134, code lost:
        
            if ((((32 * 32) + (17 * 17)) + (24 * 24)) >= (((32 * 17) + (17 * 24)) + (32 * 24))) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0150, code lost:
        
            if (((((45 * 45) * 45) + ((13 * 13) * 13)) + ((11 * 11) * 11)) >= (((45 * 13) * 11) * 3)) goto L80;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x016a, code lost:
        
            if (((((97 * 97) * 97) + ((33 * 33) * 33)) + ((26 * 26) * 26)) >= (((97 * 33) * 26) * 3)) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x016d, code lost:
        
            r9 = 5;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0115 -> B:58:0x011e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x016d -> B:51:0x0114). Please report as a decompilation issue!!! */
        @Override // com.bytedance.msdk.base.TTBaseAd
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void registerViewForInteraction(@androidx.annotation.NonNull android.view.ViewGroup r9, java.util.List<android.view.View> r10, java.util.List<android.view.View> r11, com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder r12) {
            /*
                Method dump skipped, instruction units count: 388
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.PangleDrawAd.registerViewForInteraction(android.view.ViewGroup, java.util.List, java.util.List, com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder):void");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x000d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadAd(android.content.Context r1, final boolean r2, com.bytedance.sdk.openadsdk.TTAdNative r3, com.bytedance.sdk.openadsdk.AdSlot r4, final com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter r5) {
        /*
            r0 = this;
            if (r3 == 0) goto L6c
            if (r5 != 0) goto L5
            goto L6c
        L5:
            com.bytedance.msdk.adapter.pangle.PangleDrawLoader$1 r1 = new com.bytedance.msdk.adapter.pangle.PangleDrawLoader$1
            r1.<init>(r0)
            r3.loadDrawFeedAd(r4, r1)
        Ld:
            r1 = 12
            r2 = 96
            switch(r2) {
                case 94: goto L1c;
                case 95: goto L16;
                case 96: goto L15;
                default: goto L14;
            }
        L14:
            goto Ld
        L15:
            return
        L16:
            switch(r1) {
                case 94: goto L3a;
                case 95: goto L54;
                case 96: goto L6c;
                default: goto L19;
            }
        L19:
            r1 = 95
            goto L16
        L1c:
            r1 = 1
            r2 = 81
            int r3 = 81 - r1
            int r3 = r3 * 81
            int r2 = r2 * 2
            int r2 = r2 - r1
            int r3 = r3 * r2
            int r3 = r3 % 6
            if (r3 == 0) goto L6c
            r1 = 66
            int r1 = r1 * r1
            r2 = 16
            int r2 = r2 * r2
            int r2 = r2 * 34
            int r1 = r1 - r2
            r2 = -1
            if (r1 != r2) goto L54
        L3a:
            r1 = 29
            int r2 = r1 * r1
            r3 = 45
            int r4 = r3 * r3
            int r2 = r2 + r4
            r4 = 20
            int r5 = r4 * r4
            int r2 = r2 + r5
            r5 = 29
            int r5 = r5 * 45
            int r3 = r3 * 20
            int r5 = r5 + r3
            int r1 = r1 * 20
            int r5 = r5 + r1
            if (r2 >= r5) goto L6c
        L54:
            r1 = 70
            int r2 = r1 * r1
            r3 = 7
            int r4 = r3 * r3
            int r2 = r2 + r4
            r4 = 4
            int r5 = r4 * r4
            int r2 = r2 + r5
            r5 = 70
            int r5 = r5 * 7
            int r3 = r3 * 4
            int r5 = r5 + r3
            int r1 = r1 * 4
            int r5 = r5 + r1
            if (r2 >= r5) goto Ld
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawLoader.loadAd(android.content.Context, boolean, com.bytedance.sdk.openadsdk.TTAdNative, com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter):void");
    }
}
