package com.bytedance.msdk.adapter.pangle;

import android.content.Context;
import android.view.View;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.ad.GMInterstitialBaseAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterInterstitialListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PangleInterstitialAdapter extends GMInterstitialBaseAdapter {
    public static final String TAG = "PangleInterstitialAdapter";
    public static final String VERSION_00 = "0.0";
    public static final String VERSION_4900 = "4.9.0.0";
    private PangleExpressInterstitialAd a;
    private Context b;

    class PangleExpressInterstitialAd extends TTBaseAd {
        private TTNativeExpressAd a;
        private boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        TTNativeExpressAd.AdInteractionListener f13975c = new TTNativeExpressAd.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleInterstitialAdapter.PangleExpressInterstitialAd.2
            /* JADX WARN: Removed duplicated region for block: B:32:0x00a7 A[LOOP:2: B:17:0x0057->B:32:0x00a7, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:45:0x0069 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:57:0x005d A[SYNTHETIC] */
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
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onAdClicked(android.view.View r9, int r10) {
                /*
                    Method dump skipped, instruction units count: 214
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleInterstitialAdapter.PangleExpressInterstitialAd.AnonymousClass2.onAdClicked(android.view.View, int):void");
            }

            /* JADX WARN: Removed duplicated region for block: B:32:0x00a5 A[LOOP:2: B:17:0x0055->B:32:0x00a5, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:38:0x00aa A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:45:0x0039 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:46:0x0053 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:47:0x0067 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:52:0x0031 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:57:0x005b A[SYNTHETIC] */
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
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onAdDismiss() {
                /*
                    Method dump skipped, instruction units count: 212
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleInterstitialAdapter.PangleExpressInterstitialAd.AnonymousClass2.onAdDismiss():void");
            }

            /* JADX WARN: Removed duplicated region for block: B:26:0x008b A[LOOP:1: B:11:0x003d->B:26:0x008b, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:38:0x0090 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:47:0x0043 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:48:0x004f A[SYNTHETIC] */
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
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onAdShow(android.view.View r9, int r10) {
                /*
                    Method dump skipped, instruction units count: 210
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleInterstitialAdapter.PangleExpressInterstitialAd.AnonymousClass2.onAdShow(android.view.View, int):void");
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0045. Please report as an issue. */
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i2) {
                Logger.e("TTMediationSDK_interisitial", TTLogUtil.getTagThirdLevelById(PangleInterstitialAdapter.this.getAdapterRit(), PangleInterstitialAdapter.this.getAdSlotId()) + "PangleExpressInterstitialAd onRenderFail -> code=" + i2 + ",msg=" + str);
                PangleInterstitialAdapter.this.notifyAdFailed(new AdError(i2, str));
                while (true) {
                    char c2 = '(';
                    while (true) {
                        switch (c2) {
                            case '(':
                                switch (92) {
                                    case 90:
                                        int i3 = (((53 - 1) * 53) * ((53 * 2) - 1)) % 6;
                                        continue;
                                }
                                c2 = '*';
                                break;
                            case ')':
                                break;
                            case '*':
                                break;
                            default:
                                c2 = '*';
                                break;
                        }
                        return;
                    }
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0070 A[LOOP:2: B:11:0x0070->B:12:0x0073, LOOP_START, PHI: r5
  0x0070: PHI (r5v19 char) = (r5v5 char), (r5v20 char) binds: [B:9:0x006d, B:12:0x0073] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Removed duplicated region for block: B:27:0x00b3 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:29:0x009e A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00b3 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:32:0x00b4 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:38:? A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:39:? A[LOOP:1: B:23:0x00b4->B:39:?, LOOP_END, SYNTHETIC] */
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
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onRenderSuccess(android.view.View r5, float r6, float r7) {
                /*
                    Method dump skipped, instruction units count: 214
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleInterstitialAdapter.PangleExpressInterstitialAd.AnonymousClass2.onRenderSuccess(android.view.View, float, float):void");
            }
        };

        PangleExpressInterstitialAd() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ITTAdapterInterstitialListener a() {
            while (true) {
                char c2 = ']';
                char c3 = ']';
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                                case 21:
                                    c2 = '^';
                                    c3 = 'K';
                                    break;
                            }
                        case ']':
                            while (true) {
                                switch (c3) {
                                    case '[':
                                    case '\\':
                                    case ']':
                                        break;
                                    default:
                                        c3 = '[';
                                        break;
                                }
                            }
                            c2 = '^';
                            c3 = 'K';
                            break;
                        case '^':
                            if (c3 > 4) {
                            }
                            break;
                    }
                }
            }
            return (ITTAdapterInterstitialListener) this.mTTAdatperCallback;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            return tTNativeExpressAd != null ? PangleAdapterUtils.getAdId(tTNativeExpressAd.getMediaExtraInfo()) : super.getAdId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getCreativeId() {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            return tTNativeExpressAd != null ? PangleAdapterUtils.getCreativeId(tTNativeExpressAd.getMediaExtraInfo()) : super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> mediaExtraInfo;
            TTNativeExpressAd tTNativeExpressAd = this.a;
            if (tTNativeExpressAd == null || (mediaExtraInfo = tTNativeExpressAd.getMediaExtraInfo()) == null) {
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
            TTNativeExpressAd tTNativeExpressAd = this.a;
            return tTNativeExpressAd != null ? PangleAdapterUtils.getReqId(tTNativeExpressAd.getMediaExtraInfo()) : super.getReqId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.a == null;
        }

        public void loadAd() {
            TTAdNative tTAdNativeCreateAdNative = TTAdSdk.getAdManager().createAdNative(PangleInterstitialAdapter.this.b);
            AdSlot.Builder builderBuildPangleAdSlot = PangleAdapterUtils.buildPangleAdSlot(((TTAbsAdLoaderAdapter) PangleInterstitialAdapter.this).mAdSlot, ((TTAbsAdLoaderAdapter) PangleInterstitialAdapter.this).mGMAdSlotBase, PangleInterstitialAdapter.this.getAdSlotId(), ((TTAbsAdLoaderAdapter) PangleInterstitialAdapter.this).mWaterfallAbTestParam, PangleInterstitialAdapter.this.getClientReqId(), PangleInterstitialAdapter.this.getAdm(), false);
            builderBuildPangleAdSlot.setExpressViewAcceptedSize(PangleInterstitialAdapter.this.mGMAdSlotInterstitial.getWidth(), PangleInterstitialAdapter.this.mGMAdSlotInterstitial.getHeight());
            tTAdNativeCreateAdNative.loadInteractionExpressAd(builderBuildPangleAdSlot.build(), new TTAdNative.NativeExpressAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleInterstitialAdapter.PangleExpressInterstitialAd.1
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
                public void onError(int i2, String str) {
                    PangleInterstitialAdapter.this.notifyAdFailed(new AdError(i2, str));
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
                public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                    Map<String, Object> mediaExtraInfo;
                    if (list == null || list.size() == 0) {
                        PangleInterstitialAdapter.this.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                        return;
                    }
                    Logger.d("TTMediationSDK_interisitial", TTLogUtil.getTagThirdLevelById(PangleInterstitialAdapter.this.getAdapterRit(), PangleInterstitialAdapter.this.getAdSlotId()) + "穿山甲SDK--插屏-onNativeExpressAdLoad");
                    PangleExpressInterstitialAd.this.a = list.get(0);
                    PangleExpressInterstitialAd.this.setExpressAd(true);
                    PangleExpressInterstitialAd pangleExpressInterstitialAd = PangleExpressInterstitialAd.this;
                    pangleExpressInterstitialAd.setInteractionType(pangleExpressInterstitialAd.a.getInteractionType());
                    if (PangleInterstitialAdapter.this.isClientBidding() && (mediaExtraInfo = PangleExpressInterstitialAd.this.a.getMediaExtraInfo()) != null) {
                        double value = PangleAdapterUtils.getValue(mediaExtraInfo.get("price"));
                        Logger.d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(PangleInterstitialAdapter.this.getAdapterRit(), PangleInterstitialAdapter.this.getAdSlotId()) + "pangle 插屏 返回的 cpm价格：" + value);
                        PangleExpressInterstitialAd pangleExpressInterstitialAd2 = PangleExpressInterstitialAd.this;
                        if (value <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                            value = 0.0d;
                        }
                        pangleExpressInterstitialAd2.setCpm(value);
                    }
                    PangleExpressInterstitialAd.this.a.setExpressInteractionListener(PangleExpressInterstitialAd.this.f13975c);
                    PangleExpressInterstitialAd.this.a.render();
                }
            });
            while (true) {
                switch (42) {
                    case 41:
                        if (((37 + 1) * 37) % 2 != 0) {
                            return;
                        }
                        break;
                    case 42:
                        return;
                }
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) null);
                this.a.setDownloadListener(null);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0065 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0007 A[SYNTHETIC] */
        @Override // com.bytedance.msdk.base.TTBaseAd
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void showAd(android.app.Activity r4, java.util.Map<com.bytedance.msdk.api.TTAdConstant.GroMoreExtraKey, java.lang.Object> r5) {
            /*
                r3 = this;
                com.bytedance.sdk.openadsdk.TTNativeExpressAd r5 = r3.a
                if (r5 == 0) goto L65
                r5.showInteractionExpressAd(r4)
            L7:
                r4 = 12
                r5 = 96
                switch(r5) {
                    case 94: goto L15;
                    case 95: goto Lf;
                    case 96: goto L65;
                    default: goto Le;
                }
            Le:
                goto L7
            Lf:
                switch(r4) {
                    case 94: goto L33;
                    case 95: goto L4d;
                    case 96: goto L65;
                    default: goto L12;
                }
            L12:
                r4 = 95
                goto Lf
            L15:
                r4 = 1
                r5 = 81
                int r0 = 81 - r4
                int r0 = r0 * 81
                int r5 = r5 * 2
                int r5 = r5 - r4
                int r0 = r0 * r5
                int r0 = r0 % 6
                if (r0 == 0) goto L65
                r4 = 66
                int r4 = r4 * r4
                r5 = 16
                int r5 = r5 * r5
                int r5 = r5 * 34
                int r4 = r4 - r5
                r5 = -1
                if (r4 != r5) goto L4d
            L33:
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
                if (r5 >= r2) goto L65
            L4d:
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
                if (r5 >= r2) goto L7
            L65:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleInterstitialAdapter.PangleExpressInterstitialAd.showAd(android.app.Activity, java.util.Map):void");
        }
    }

    private boolean a() {
        return !"0.0".equals(getSdkVersion()) && VERSION_4900.compareTo(getSdkVersion()) > 0;
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

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0054 -> B:11:0x0032). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0062 -> B:21:0x0065). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0088 -> B:14:0x0038). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0088 -> B:21:0x0065). Please report as a decompilation issue!!! */
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
    @Override // com.bytedance.msdk.adapter.ad.GMInterstitialBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void loadAd(android.content.Context r4, java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            r3 = this;
            super.loadAd(r4, r5)
            boolean r0 = r3.a()
            r1 = 1
            if (r0 != 0) goto L1a
            com.bytedance.msdk.api.AdError r4 = new com.bytedance.msdk.api.AdError
            r5 = 81004(0x13c6c, float:1.13511E-40)
            java.lang.String r0 = com.bytedance.msdk.api.AdError.getMessage(r5)
            r4.<init>(r5, r0)
            r3.notifyAdFailed(r4)
            goto L65
        L1a:
            com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitial r0 = r3.mGMAdSlotInterstitial
            if (r0 == 0) goto L2f
            r3.b = r4
            if (r5 == 0) goto L8b
            com.bytedance.msdk.adapter.pangle.PangleInterstitialAdapter$PangleExpressInterstitialAd r4 = new com.bytedance.msdk.adapter.pangle.PangleInterstitialAdapter$PangleExpressInterstitialAd
            r4.<init>()
            r3.a = r4
            com.bytedance.msdk.adapter.pangle.PangleInterstitialAdapter$PangleExpressInterstitialAd r4 = r3.a
            r4.loadAd()
            goto L8b
        L2f:
            r3.notifyLoadFailBecauseGMAdSlotIsNull()
        L32:
            r4 = 39
            switch(r4) {
                case 39: goto L8b;
                case 40: goto L38;
                case 41: goto L47;
                default: goto L37;
            }
        L37:
            goto L32
        L38:
            r4 = 29
            int r5 = 29 - r1
            int r5 = r5 * 29
            int r4 = r4 * 2
            int r4 = r4 - r1
            int r5 = r5 * r4
            int r5 = r5 % 6
            if (r5 == 0) goto L8b
        L47:
            r4 = 38
            int r5 = 38 - r1
            int r5 = r5 * 38
            int r4 = r4 * 2
            int r4 = r4 - r1
            int r5 = r5 * r4
            int r5 = r5 % 6
            if (r5 == 0) goto L32
        L56:
            r4 = 7
            int r5 = 7 - r1
            int r5 = r5 * 7
            int r4 = r4 * 2
            int r4 = r4 - r1
            int r5 = r5 * r4
            int r5 = r5 % 6
            if (r5 == 0) goto L65
            goto L71
        L65:
            r4 = 34
            r5 = 31
            switch(r5) {
                case 29: goto L32;
                case 30: goto L6d;
                case 31: goto L8b;
                default: goto L6c;
            }
        L6c:
            goto L65
        L6d:
            switch(r4) {
                case 57: goto L56;
                case 58: goto L71;
                case 59: goto L7a;
                default: goto L70;
            }
        L70:
            goto L8b
        L71:
            r4 = 17
            int r4 = r4 + r1
            int r4 = r4 * 17
            int r4 = r4 % 2
            if (r4 == 0) goto L8b
        L7a:
            r4 = 12
            int r5 = r4 * r4
            r0 = 37
            int r2 = r0 * r0
            int r5 = r5 + r2
            int r4 = r4 * 37
            int r4 = r4 * 2
            int r5 = r5 - r4
            if (r5 >= 0) goto L38
            goto L65
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleInterstitialAdapter.loadAd(android.content.Context, java.util.Map):void");
    }
}
