package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PangleNativeLoader {
    private boolean a;
    private Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TTAbsAdLoaderAdapter f13980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13981d;

    class PangleNativeAd extends TTBaseAd {
        private TTFeedAd a;
        TTNativeAd.AdInteractionListener b = new TTNativeAd.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.4
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
                    com.bytedance.msdk.adapter.pangle.PangleNativeLoader$PangleNativeAd r4 = com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener r4 = com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.z(r4)
                    if (r4 == 0) goto L11
                    com.bytedance.msdk.adapter.pangle.PangleNativeLoader$PangleNativeAd r4 = com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener r4 = com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.A(r4)
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.AnonymousClass4.onAdClicked(android.view.View, com.bytedance.sdk.openadsdk.TTNativeAd):void");
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
                    com.bytedance.msdk.adapter.pangle.PangleNativeLoader$PangleNativeAd r4 = com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener r4 = com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.B(r4)
                    if (r4 == 0) goto L11
                    com.bytedance.msdk.adapter.pangle.PangleNativeLoader$PangleNativeAd r4 = com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener r4 = com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.C(r4)
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.AnonymousClass4.onAdCreativeClick(android.view.View, com.bytedance.sdk.openadsdk.TTNativeAd):void");
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
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onAdShow(com.bytedance.sdk.openadsdk.TTNativeAd r10) {
                /*
                    Method dump skipped, instruction units count: 212
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.AnonymousClass4.onAdShow(com.bytedance.sdk.openadsdk.TTNativeAd):void");
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        TTFeedAd.VideoAdListener f13982c = new TTFeedAd.VideoAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.5
            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onProgressUpdate(long j2, long j3) {
                if (((TTBaseAd) PangleNativeAd.this).mTTVideoListener != null) {
                    ((TTBaseAd) PangleNativeAd.this).mTTVideoListener.onProgressUpdate(j2, j3);
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.AnonymousClass5.onVideoAdComplete(com.bytedance.sdk.openadsdk.TTFeedAd):void");
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
            public void onVideoAdContinuePlay(com.bytedance.sdk.openadsdk.TTFeedAd r10) {
                /*
                    Method dump skipped, instruction units count: 210
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.AnonymousClass5.onVideoAdContinuePlay(com.bytedance.sdk.openadsdk.TTFeedAd):void");
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
            public void onVideoAdPaused(com.bytedance.sdk.openadsdk.TTFeedAd r10) {
                /*
                    Method dump skipped, instruction units count: 212
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.AnonymousClass5.onVideoAdPaused(com.bytedance.sdk.openadsdk.TTFeedAd):void");
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.AnonymousClass5.onVideoAdStartPlay(com.bytedance.sdk.openadsdk.TTFeedAd):void");
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
                    com.bytedance.msdk.adapter.pangle.PangleNativeLoader$PangleNativeAd r0 = com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.a(r0)
                    if (r0 == 0) goto L92
                    com.bytedance.msdk.adapter.pangle.PangleNativeLoader$PangleNativeAd r0 = com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.b(r0)
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.AnonymousClass5.onVideoError(int, int):void");
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoLoad(TTFeedAd tTFeedAd) {
            }
        };

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TTAppDownloadListener f13983d = new TTAppDownloadListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.6
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j2, long j3, String str, String str2) {
                if (((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener != null) {
                    PangleNativeLoader.this.f13981d = 2;
                    ((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener.onDownloadProgress(j2, j3, -1, 1);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j2, long j3, String str, String str2) {
                if (((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener != null) {
                    PangleNativeLoader.this.f13981d = 4;
                    ((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener.onDownloadFailed(j2, j3, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j2, String str, String str2) {
                if (((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener != null) {
                    PangleNativeLoader.this.f13981d = 5;
                    ((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener.onDownloadFinished(j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j2, long j3, String str, String str2) {
                if (((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener != null) {
                    PangleNativeLoader.this.f13981d = 3;
                    ((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener.onDownloadPaused(j2, j3, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                if (((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener != null) {
                    PangleNativeLoader.this.f13981d = 0;
                    ((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener.onIdle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                if (((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener != null) {
                    PangleNativeLoader.this.f13981d = 6;
                    ((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener.onInstalled(str, str2);
                }
            }
        };

        PangleNativeAd(TTFeedAd tTFeedAd) {
            TTImage videoCoverImage;
            Map<String, Object> mediaExtraInfo;
            this.a = tTFeedAd;
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
            DislikeInfo dislikeInfo = tTFeedAd.getDislikeInfo();
            if (dislikeInfo != null) {
                putExtraMsg(GMAdConstant.PANGLE_DISLIKE_INFO, dislikeInfo);
            }
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
            if (PangleNativeLoader.this.a && (mediaExtraInfo = tTFeedAd.getMediaExtraInfo()) != null) {
                double value = PangleAdapterUtils.getValue(mediaExtraInfo.get("price"));
                Logger.d("TTMediationSDK_ECMP", "pangle native 返回的 cpm价格：" + value);
                setCpm(value <= PangleAdapterUtils.CPM_DEFLAUT_VALUE ? 0.0d : value);
            }
            this.a.setVideoAdListener(this.f13982c);
            this.a.setDownloadListener(this.f13983d);
            putExtraMsg(GMAdConstant.EXTRA_ADID, Long.valueOf(getAdId()));
            putExtraMsg(GMAdConstant.EXTRA_CID, Long.valueOf(getCreativeId()));
            Map<String, Object> mediaExtraInfo2 = this.a.getMediaExtraInfo();
            if (mediaExtraInfo2 != null) {
                putExtraMsg("log_extra", mediaExtraInfo2.toString());
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void cancelDownload() {
            TTFeedAd tTFeedAd = this.a;
            if (tTFeedAd == null || tTFeedAd.getDownloadStatusController() == null) {
                return;
            }
            this.a.getDownloadStatusController().cancelDownload();
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
            if (this.a == null) {
                return super.getDislikeDialog(activity, map);
            }
            final TTDislikeDialogAbstract tTDislikeDialogAbstract = null;
            if (map != null && (map.get(GMAdConstant.PANGLE_CUSTOM_DIALOG) instanceof TTDislikeDialogAbstract)) {
                tTDislikeDialogAbstract = (TTDislikeDialogAbstract) map.get(GMAdConstant.PANGLE_CUSTOM_DIALOG);
            }
            if (tTDislikeDialogAbstract == null) {
                final TTAdDislike dislikeDialog = this.a.getDislikeDialog(activity);
                return new GMAdDislike() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.3
                    @Override // com.bytedance.msdk.api.v2.GMAdDislike
                    public void setDislikeCallback(final GMDislikeCallback gMDislikeCallback) {
                        if (gMDislikeCallback != null) {
                            dislikeDialog.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.3.1
                                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                                public void onCancel() {
                                    gMDislikeCallback.onCancel();
                                }

                                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                                public void onSelected(int i2, String str, boolean z2) {
                                    try {
                                        if (PangleNativeLoader.this.f13980c != null) {
                                            PangleNativeLoader.this.f13980c.nativeDislikeClick(PangleNativeAd.this, str, null);
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
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
            Logger.e("TTMediationSDK", "---pangle_getDislikeDialog_custom_dialog---");
            this.a.setDislikeDialog(tTDislikeDialogAbstract);
            return new GMAdDislike(this) { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.2
                @Override // com.bytedance.msdk.api.v2.GMAdDislike
                public void setDislikeCallback(GMDislikeCallback gMDislikeCallback) {
                }

                @Override // com.bytedance.msdk.api.v2.GMAdDislike
                public void showDislikeDialog() {
                    TTDislikeDialogAbstract tTDislikeDialogAbstract2 = tTDislikeDialogAbstract;
                    if (tTDislikeDialogAbstract2 != null) {
                        tTDislikeDialogAbstract2.show();
                    }
                }
            };
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int getDownloadStatus() {
            return PangleNativeLoader.this.f13981d;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMNativeCustomVideoReporter getGMNativeCustomVideoReporter() {
            if (isUseCustomVideo()) {
                return new GMNativeCustomVideoReporter() { // from class: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.1
                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoAutoStart() {
                        if (PangleNativeAd.this.a == null || PangleNativeAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleNativeAd.this.a.getCustomVideo().reportVideoAutoStart();
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoBreak(long j2) {
                        if (PangleNativeAd.this.a == null || PangleNativeAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleNativeAd.this.a.getCustomVideo().reportVideoBreak(j2);
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoContinue(long j2) {
                        if (PangleNativeAd.this.a == null || PangleNativeAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleNativeAd.this.a.getCustomVideo().reportVideoContinue(j2);
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoError(long j2, int i2, int i3) {
                        if (PangleNativeAd.this.a == null || PangleNativeAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleNativeAd.this.a.getCustomVideo().reportVideoError(j2, i2, i3);
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoFinish() {
                        if (PangleNativeAd.this.a == null || PangleNativeAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleNativeAd.this.a.getCustomVideo().reportVideoFinish();
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoPause(long j2) {
                        if (PangleNativeAd.this.a == null || PangleNativeAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleNativeAd.this.a.getCustomVideo().reportVideoPause(j2);
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoStart() {
                        if (PangleNativeAd.this.a == null || PangleNativeAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleNativeAd.this.a.getCustomVideo().reportVideoStart();
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter
                    public void reportVideoStartError(int i2, int i3) {
                        if (PangleNativeAd.this.a == null || PangleNativeAd.this.a.getCustomVideo() == null) {
                            return;
                        }
                        PangleNativeAd.this.a.getCustomVideo().reportVideoStartError(i2, i3);
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

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void pauseAppDownload() {
            TTFeedAd tTFeedAd = this.a;
            if (tTFeedAd == null || tTFeedAd.getDownloadStatusController() == null || PangleNativeLoader.this.f13981d != 2) {
                return;
            }
            this.a.getDownloadStatusController().changeDownloadStatus();
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x00fc A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00ca A[SYNTHETIC] */
        @Override // com.bytedance.msdk.base.TTBaseAd
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void registerViewForInteraction(@androidx.annotation.NonNull android.app.Activity r10, @androidx.annotation.NonNull android.view.ViewGroup r11, java.util.List<android.view.View> r12, java.util.List<android.view.View> r13, java.util.List<android.view.View> r14, com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder r15) {
            /*
                Method dump skipped, instruction units count: 264
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.registerViewForInteraction(android.app.Activity, android.view.ViewGroup, java.util.List, java.util.List, java.util.List, com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x008b A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x008b A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0019 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0033 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0041 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0080 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x006f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0011 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0011 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x004b A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:53:? A[LOOP:2: B:13:0x0041->B:53:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x007d -> B:6:0x0011). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // com.bytedance.msdk.base.TTBaseAd
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void registerViewForInteraction(@androidx.annotation.NonNull android.view.ViewGroup r8, java.util.List<android.view.View> r9, java.util.List<android.view.View> r10, com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder r11) {
            /*
                r7 = this;
                r1 = 0
                r5 = 0
                r0 = r7
                r2 = r8
                r3 = r9
                r4 = r10
                r6 = r11
                r0.registerViewForInteraction(r1, r2, r3, r4, r5, r6)
            La:
                r8 = 73
                r9 = 2
                switch(r8) {
                    case 72: goto L11;
                    case 73: goto L11;
                    case 74: goto L6f;
                    default: goto L10;
                }
            L10:
                goto La
            L11:
                r8 = 61
                r10 = 34
                switch(r8) {
                    case 59: goto L19;
                    case 60: goto L33;
                    case 61: goto L41;
                    default: goto L18;
                }
            L18:
                goto L11
            L19:
                r8 = 49
                int r11 = r8 * r8
                int r0 = r10 * r10
                int r11 = r11 + r0
                r0 = 18
                int r1 = r0 * r0
                int r11 = r11 + r1
                r1 = 49
                int r1 = r1 * 34
                r2 = 34
                int r2 = r2 * 18
                int r1 = r1 + r2
                int r8 = r8 * 18
                int r1 = r1 + r8
                if (r11 >= r1) goto L8b
            L33:
                r8 = 40
                int r11 = r8 * r8
                int r0 = r9 * r9
                int r11 = r11 + r0
                int r8 = r8 * 2
                int r8 = r8 * 2
                int r11 = r11 - r8
                if (r11 >= 0) goto L8b
            L41:
                r8 = 52
                r11 = 93
                r0 = 85
                switch(r11) {
                    case 92: goto La;
                    case 93: goto L4b;
                    case 94: goto L80;
                    default: goto L4a;
                }
            L4a:
                goto L41
            L4b:
                switch(r8) {
                    case 52: goto L8b;
                    case 53: goto L4f;
                    case 54: goto L5f;
                    default: goto L4e;
                }
            L4e:
                goto L80
            L4f:
                int r0 = r0 * r0
                r8 = 32
                int r10 = r8 * r8
                int r0 = r0 + r10
                r10 = 85
                int r10 = r10 * 32
                int r10 = r10 * 2
                int r0 = r0 - r10
                if (r0 >= 0) goto La
            L5f:
                r8 = 80
                int r10 = r8 * r8
                r11 = 0
                int r0 = r11 * r11
                int r10 = r10 + r0
                int r10 = r10 + r0
                int r8 = r8 * 0
                int r0 = r0 + r8
                int r0 = r0 + r8
                if (r10 >= r0) goto L6f
                goto L11
            L6f:
                r8 = 1
                r10 = 82
                int r11 = 82 - r8
                int r11 = r11 * 82
                int r10 = r10 * 2
                int r10 = r10 - r8
                int r11 = r11 * r10
                int r11 = r11 % 6
                if (r11 == 0) goto L11
                goto L8b
            L80:
                int r0 = r0 * r0
                r8 = 16
                int r8 = r8 * r8
                int r8 = r8 * 34
                int r0 = r0 - r8
                r8 = -1
                goto L11
            L8b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.PangleNativeAd.registerViewForInteraction(android.view.ViewGroup, java.util.List, java.util.List, com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder):void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void resumeAppDownload() {
            TTFeedAd tTFeedAd = this.a;
            if (tTFeedAd == null || tTFeedAd.getDownloadStatusController() == null || PangleNativeLoader.this.f13981d != 3) {
                return;
            }
            this.a.getDownloadStatusController().changeDownloadStatus();
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
    public void loadAd(android.content.Context r2, boolean r3, com.bytedance.sdk.openadsdk.TTAdNative r4, com.bytedance.sdk.openadsdk.AdSlot r5, final com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter r6) {
        /*
            r1 = this;
            if (r4 == 0) goto L8a
            if (r6 != 0) goto L6
            goto L8a
        L6:
            r1.f13980c = r6
            r1.b = r2
            r1.a = r3
            r2 = 1444(0x5a4, float:2.023E-42)
            com.bytedance.msdk.adapter.pangle.PangleNativeLoader$1 r3 = new com.bytedance.msdk.adapter.pangle.PangleNativeLoader$1
            r3.<init>()
            r4.loadFeedAd(r5, r3)
        L16:
            r3 = 95
            r4 = 7
            switch(r3) {
                case 94: goto L3b;
                case 95: goto L35;
                case 96: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L16
        L1d:
            int r3 = r4 * r4
            int r3 = r3 + r2
            r5 = 10
            int r6 = r5 * r5
            int r3 = r3 + r6
            r6 = 38
            int r6 = r6 * 7
            r0 = 7
            int r0 = r0 * 10
            int r6 = r6 + r0
            r0 = 38
            int r0 = r0 * 10
            int r6 = r6 + r0
            if (r3 >= r6) goto L16
            goto L3b
        L35:
            r2 = 96
            switch(r2) {
                case 94: goto L59;
                case 95: goto L73;
                case 96: goto L8a;
                default: goto L3a;
            }
        L3a:
            goto L35
        L3b:
            r2 = 1
            r3 = 81
            int r5 = 81 - r2
            int r5 = r5 * 81
            int r3 = r3 * 2
            int r3 = r3 - r2
            int r5 = r5 * r3
            int r5 = r5 % 6
            if (r5 == 0) goto L8a
            r2 = 66
            int r2 = r2 * r2
            r3 = 16
            int r3 = r3 * r3
            int r3 = r3 * 34
            int r2 = r2 - r3
            r3 = -1
            if (r2 != r3) goto L73
        L59:
            r2 = 29
            int r3 = r2 * r2
            r5 = 45
            int r6 = r5 * r5
            int r3 = r3 + r6
            r6 = 20
            int r0 = r6 * r6
            int r3 = r3 + r0
            r0 = 29
            int r0 = r0 * 45
            int r5 = r5 * 20
            int r0 = r0 + r5
            int r2 = r2 * 20
            int r0 = r0 + r2
            if (r3 >= r0) goto L8a
        L73:
            r2 = 70
            int r3 = r2 * r2
            int r5 = r4 * r4
            int r3 = r3 + r5
            r5 = 4
            int r6 = r5 * r5
            int r3 = r3 + r6
            r6 = 70
            int r6 = r6 * 7
            int r4 = r4 * 4
            int r6 = r6 + r4
            int r2 = r2 * 4
            int r6 = r6 + r2
            if (r3 >= r6) goto L8a
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleNativeLoader.loadAd(android.content.Context, boolean, com.bytedance.sdk.openadsdk.TTAdNative, com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter):void");
    }
}
