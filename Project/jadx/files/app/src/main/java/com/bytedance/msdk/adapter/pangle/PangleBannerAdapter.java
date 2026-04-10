package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.ad.GMBannerBaseAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterBannerAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.adapter.util.UIUtils;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.format.TTMediaView;
import com.bytedance.msdk.api.format.TTNativeAdView;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PangleBannerAdapter extends GMBannerBaseAdapter {
    private Context a;

    class PangleNativeAd extends TTBaseAd {
        private TTFeedAd a;
        private volatile boolean b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        TTNativeAd.AdInteractionListener f13955c = new TTNativeAd.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.3
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
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onAdClicked(android.view.View r9, com.bytedance.sdk.openadsdk.TTNativeAd r10) {
                /*
                    Method dump skipped, instruction units count: 210
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.AnonymousClass3.onAdClicked(android.view.View, com.bytedance.sdk.openadsdk.TTNativeAd):void");
            }

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
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onAdCreativeClick(android.view.View r9, com.bytedance.sdk.openadsdk.TTNativeAd r10) {
                /*
                    Method dump skipped, instruction units count: 214
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.AnonymousClass3.onAdCreativeClick(android.view.View, com.bytedance.sdk.openadsdk.TTNativeAd):void");
            }

            /* JADX WARN: Removed duplicated region for block: B:26:0x0088 A[LOOP:1: B:11:0x003a->B:26:0x0088, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:39:0x008d A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:48:0x0040 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:49:0x004c A[SYNTHETIC] */
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
            public void onAdShow(com.bytedance.sdk.openadsdk.TTNativeAd r9) {
                /*
                    Method dump skipped, instruction units count: 208
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.AnonymousClass3.onAdShow(com.bytedance.sdk.openadsdk.TTNativeAd):void");
            }
        };

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TTFeedAd.VideoAdListener f13956d = new TTFeedAd.VideoAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.4
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.AnonymousClass4.onVideoAdComplete(com.bytedance.sdk.openadsdk.TTFeedAd):void");
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.AnonymousClass4.onVideoAdContinuePlay(com.bytedance.sdk.openadsdk.TTFeedAd):void");
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.AnonymousClass4.onVideoAdPaused(com.bytedance.sdk.openadsdk.TTFeedAd):void");
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
            public void onVideoAdStartPlay(com.bytedance.sdk.openadsdk.TTFeedAd r10) {
                /*
                    Method dump skipped, instruction units count: 210
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.AnonymousClass4.onVideoAdStartPlay(com.bytedance.sdk.openadsdk.TTFeedAd):void");
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
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$PangleNativeAd r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.g(r0)
                    if (r0 == 0) goto L92
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$PangleNativeAd r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.h(r0)
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.AnonymousClass4.onVideoError(int, int):void");
            }

            @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
            public void onVideoLoad(TTFeedAd tTFeedAd) {
            }
        };

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        TTAppDownloadListener f13957e = new TTAppDownloadListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.5
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j2, long j3, String str, String str2) {
                if (((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener != null) {
                    ((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener.onDownloadProgress(j2, j3, -1, 1);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j2, long j3, String str, String str2) {
                if (((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener != null) {
                    ((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener.onDownloadFailed(j2, j3, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j2, String str, String str2) {
                if (((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener != null) {
                    ((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener.onDownloadFinished(j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j2, long j3, String str, String str2) {
                if (((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener != null) {
                    ((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener.onDownloadPaused(j2, j3, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                if (((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener != null) {
                    ((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener.onIdle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                if (((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener != null) {
                    ((TTBaseAd) PangleNativeAd.this).mTTAdAppDownloadListener.onInstalled(str, str2);
                }
            }
        };

        PangleNativeAd(TTFeedAd tTFeedAd) {
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
            this.a.getMediaExtraInfo();
            if (tTFeedAd.getImageMode() == 16 || tTFeedAd.getImageMode() == 3 || tTFeedAd.getImageMode() == 2) {
                if (tTFeedAd.getImageList() != null && !tTFeedAd.getImageList().isEmpty() && tTFeedAd.getImageList().get(0) != null) {
                    TTImage tTImage = tTFeedAd.getImageList().get(0);
                    setImageUrl(tTImage.getImageUrl());
                    setImageHeight(tTImage.getHeight());
                    setImageWidth(tTImage.getWidth());
                }
            } else if (tTFeedAd.getImageMode() == 4 && tTFeedAd.getImageList() != null && tTFeedAd.getImageList().size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<TTImage> it = tTFeedAd.getImageList().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getImageUrl());
                }
                setImages(arrayList);
            }
            if (PangleBannerAdapter.this.isClientBidding() && (mediaExtraInfo = tTFeedAd.getMediaExtraInfo()) != null) {
                double value = PangleAdapterUtils.getValue(mediaExtraInfo.get("price"));
                Logger.d("TTMediationSDK_ECMP", "pangle native 返回的 cpm价格：" + value);
                setCpm(value <= PangleAdapterUtils.CPM_DEFLAUT_VALUE ? 0.0d : value);
            }
            this.a.setVideoAdListener(this.f13956d);
            this.a.setDownloadListener(this.f13957e);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ITTAdapterBannerAdListener a() {
            return (ITTAdapterBannerAdListener) this.mTTAdatperCallback;
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
            return new GMAdDislike() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.1
                @Override // com.bytedance.msdk.api.v2.GMAdDislike
                public void setDislikeCallback(final GMDislikeCallback gMDislikeCallback) {
                    if (gMDislikeCallback != null) {
                        dislikeDialog.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.1.1
                            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                            public void onCancel() {
                                gMDislikeCallback.onCancel();
                            }

                            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                            public void onSelected(int i2, String str, boolean z2) {
                                gMDislikeCallback.onSelected(i2, str);
                                if (((TTBaseAd) PangleNativeAd.this).mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                                    PangleNativeAd.this.a().onAdClosed();
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                            public void onShow() {
                                gMDislikeCallback.onShow();
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
        public int getVideoWidth() {
            TTFeedAd tTFeedAd = this.a;
            if (tTFeedAd != null) {
                return tTFeedAd.getAdViewWidth();
            }
            return 0;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.b;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDislike() {
            return true;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            this.b = true;
            ThreadHelper.runOnUiThread(new Runnable() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeAd.2
                @Override // java.lang.Runnable
                public void run() {
                    if (PangleNativeAd.this.a != null) {
                        PangleNativeAd.this.a.setVideoAdListener(null);
                    }
                }
            });
            super.onDestroy();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, GMViewBinder gMViewBinder) {
            TTFeedAd tTFeedAd;
            View viewFindViewById;
            super.registerViewForInteraction(viewGroup, list, list2, gMViewBinder);
            if (viewGroup instanceof TTNativeAdView) {
                TTFeedAd tTFeedAd2 = this.a;
                if (tTFeedAd2 != null) {
                    tTFeedAd2.registerViewForInteraction(viewGroup, list, list2, this.f13955c);
                }
                TTFeedAd tTFeedAd3 = this.a;
                if (tTFeedAd3 != null && tTFeedAd3.getAdLogo() != null && (viewFindViewById = viewGroup.findViewById(gMViewBinder.logoLayoutId)) != null) {
                    viewFindViewById.setVisibility(0);
                    if (viewFindViewById instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
                        viewGroup2.removeAllViews();
                        ImageView imageView = new ImageView(PangleBannerAdapter.this.a);
                        imageView.setImageBitmap(this.a.getAdLogo());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                        layoutParams.width = UIUtils.dp2px(PangleBannerAdapter.this.a, 38.0f);
                        layoutParams.height = UIUtils.dp2px(PangleBannerAdapter.this.a, 38.0f);
                        viewFindViewById.setLayoutParams(layoutParams);
                        viewGroup2.addView(imageView, -1, -1);
                    } else if (viewFindViewById instanceof ImageView) {
                        ((ImageView) viewFindViewById).setImageBitmap(this.a.getAdLogo());
                    }
                }
                TTMediaView tTMediaView = (TTMediaView) viewGroup.findViewById(gMViewBinder.mediaViewId);
                if (tTMediaView != null && (tTFeedAd = this.a) != null) {
                    View adView = tTFeedAd.getAdView();
                    if (adView == null) {
                        return;
                    }
                    removeSelfFromParent(adView);
                    tTMediaView.removeAllViews();
                    tTMediaView.addView(adView, -1, -1);
                }
            }
            while (true) {
                byte b = -39;
                switch (8) {
                    case 8:
                    case 9:
                        return;
                    case 10:
                        while (true) {
                            if ((b < 62 && ((65 + 1) * 65) % 2 == 0) || (58 * 58) + (35 * 35) + (16 * 16) >= (58 * 35) + (35 * 16) + (58 * 16)) {
                                return;
                            } else {
                                b = 40;
                            }
                        }
                        break;
                }
            }
        }
    }

    class PangleNativeExpressAd extends TTBaseAd {
        TTNativeExpressAd a;
        private volatile boolean b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        TTNativeExpressAd.ExpressAdInteractionListener f13959c = new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.3
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
            public void onAdClicked(android.view.View r9, int r10) {
                /*
                    Method dump skipped, instruction units count: 210
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.AnonymousClass3.onAdClicked(android.view.View, int):void");
            }

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
            public void onAdShow(android.view.View r9, int r10) {
                /*
                    Method dump skipped, instruction units count: 214
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.AnonymousClass3.onAdShow(android.view.View, int):void");
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x000e, code lost:
            
                continue;
             */
            /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0078 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0079 A[SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0076 -> B:17:0x004a). Please report as a decompilation issue!!! */
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onRenderFail(android.view.View r4, java.lang.String r5, int r6) {
                /*
                    r3 = this;
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$PangleNativeExpressAd r4 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.this
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter r4 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.this
                    com.bytedance.msdk.api.AdError r5 = new com.bytedance.msdk.api.AdError
                    java.lang.String r6 = "渲染失败"
                    r5.<init>(r6)
                    r4.notifyAdFailed(r5)
                Le:
                    r4 = 15
                    r5 = 15
                L12:
                    r6 = 12
                    r0 = 95
                    switch(r5) {
                        case 13: goto Le;
                        case 14: goto L78;
                        case 15: goto L1a;
                        default: goto L19;
                    }
                L19:
                    goto L79
                L1a:
                    switch(r0) {
                        case 94: goto L2d;
                        case 95: goto L79;
                        case 96: goto L1e;
                        default: goto L1d;
                    }
                L1d:
                    goto L46
                L1e:
                    r5 = 18
                    int r5 = r5 * r5
                    r6 = 35
                    int r6 = r6 * r6
                    int r6 = r6 * 34
                    int r5 = r5 - r6
                    r6 = -1
                    if (r5 != r6) goto L2d
                    goto L4a
                L2d:
                    r5 = 70
                    int r6 = r5 * r5
                    r0 = 7
                    int r1 = r0 * r0
                    int r6 = r6 + r1
                    r1 = 4
                    int r2 = r1 * r1
                    int r6 = r6 + r2
                    r2 = 70
                    int r2 = r2 * 7
                    int r0 = r0 * 4
                    int r2 = r2 + r0
                    int r5 = r5 * 4
                    int r2 = r2 + r5
                    if (r6 >= r2) goto Le
                    goto L79
                L46:
                    switch(r6) {
                        case 55: goto L4a;
                        case 56: goto L64;
                        case 57: goto L6e;
                        default: goto L49;
                    }
                L49:
                    goto Le
                L4a:
                    r5 = 26
                    int r6 = r5 * r5
                    int r6 = r6 * 26
                    r0 = 9
                    int r1 = r0 * r0
                    int r1 = r1 * 9
                    int r6 = r6 + r1
                    int r1 = r4 * r4
                    int r1 = r1 * 15
                    int r6 = r6 + r1
                    int r5 = r5 * 9
                    int r5 = r5 * 15
                    int r5 = r5 * 3
                    if (r6 >= r5) goto L79
                L64:
                    r5 = 90
                    int r5 = r5 + 1
                    int r5 = r5 * 90
                    int r5 = r5 % 2
                    if (r5 == 0) goto L79
                L6e:
                    r5 = 15
                    int r5 = r5 + 1
                    int r5 = r5 * 15
                    int r5 = r5 % 2
                    if (r5 == 0) goto L4a
                L78:
                    return
                L79:
                    r5 = 14
                    goto L12
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.AnonymousClass3.onRenderFail(android.view.View, java.lang.String, int):void");
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Removed duplicated region for block: B:25:0x004f A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0050 A[SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004c -> B:15:0x0020). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onRenderSuccess(android.view.View r3, float r4, float r5) {
                /*
                    r2 = this;
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$PangleNativeExpressAd r3 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.this
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter r4 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.this
                    r4.notifyAdLoaded(r3)
                L7:
                    r3 = 92
                L9:
                    r4 = 14
                    r5 = 15
                Ld:
                    r0 = 12
                    switch(r4) {
                        case 13: goto L17;
                        case 14: goto L50;
                        case 15: goto L13;
                        default: goto L12;
                    }
                L12:
                    goto L9
                L13:
                    switch(r3) {
                        case 94: goto L50;
                        case 95: goto L4f;
                        case 96: goto L50;
                        default: goto L16;
                    }
                L16:
                    goto L1c
                L17:
                    r4 = 72
                    if (r3 < r4) goto L1c
                    goto L50
                L1c:
                    switch(r0) {
                        case 55: goto L20;
                        case 56: goto L3a;
                        case 57: goto L44;
                        default: goto L1f;
                    }
                L1f:
                    goto L50
                L20:
                    r3 = 26
                    int r4 = r3 * r3
                    int r4 = r4 * 26
                    r0 = 9
                    int r1 = r0 * r0
                    int r1 = r1 * 9
                    int r4 = r4 + r1
                    int r1 = r5 * r5
                    int r1 = r1 * 15
                    int r4 = r4 + r1
                    int r3 = r3 * 9
                    int r3 = r3 * 15
                    int r3 = r3 * 3
                    if (r4 >= r3) goto L4f
                L3a:
                    r3 = 90
                    int r3 = r3 + 1
                    int r3 = r3 * 90
                    int r3 = r3 % 2
                    if (r3 == 0) goto L7
                L44:
                    r3 = 15
                    int r3 = r3 + 1
                    int r3 = r3 * 15
                    int r3 = r3 % 2
                    if (r3 == 0) goto L20
                    goto L50
                L4f:
                    return
                L50:
                    r3 = 95
                    r4 = 15
                    goto Ld
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.AnonymousClass3.onRenderSuccess(android.view.View, float, float):void");
            }
        };

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TTNativeExpressAd.ExpressVideoAdListener f13960d = new TTNativeExpressAd.ExpressVideoAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.4
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
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onClickRetry() {
                /*
                    r2 = this;
                L0:
                    r0 = 93
                    r1 = 93
                L4:
                    switch(r0) {
                        case 92: goto Lc;
                        case 93: goto Lf;
                        case 94: goto L8;
                        default: goto L7;
                    }
                L7:
                    goto L0
                L8:
                    r0 = 4
                    if (r1 > r0) goto L13
                    goto L0
                Lc:
                    switch(r1) {
                        case 21: goto L13;
                        case 22: goto L14;
                        case 23: goto L14;
                        default: goto Lf;
                    }
                Lf:
                    switch(r1) {
                        case 91: goto L14;
                        case 92: goto L13;
                        case 93: goto L14;
                        default: goto L12;
                    }
                L12:
                    goto L19
                L13:
                    return
                L14:
                    r0 = 94
                    r1 = 75
                    goto L4
                L19:
                    r1 = 91
                    goto Lf
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.AnonymousClass4.onClickRetry():void");
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x006f A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0011 A[SYNTHETIC] */
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onProgressUpdate(long r2, long r4) {
                /*
                    r1 = this;
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$PangleNativeExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.e(r0)
                    if (r0 == 0) goto L11
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$PangleNativeExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.f(r0)
                    r0.onProgressUpdate(r2, r4)
                L11:
                    r2 = 12
                    r3 = 96
                    switch(r3) {
                        case 94: goto L1f;
                        case 95: goto L19;
                        case 96: goto L6f;
                        default: goto L18;
                    }
                L18:
                    goto L11
                L19:
                    switch(r2) {
                        case 94: goto L3d;
                        case 95: goto L57;
                        case 96: goto L6f;
                        default: goto L1c;
                    }
                L1c:
                    r2 = 95
                    goto L19
                L1f:
                    r2 = 1
                    r3 = 81
                    int r4 = 81 - r2
                    int r4 = r4 * 81
                    int r3 = r3 * 2
                    int r3 = r3 - r2
                    int r4 = r4 * r3
                    int r4 = r4 % 6
                    if (r4 == 0) goto L11
                    r2 = 66
                    int r2 = r2 * r2
                    r3 = 16
                    int r3 = r3 * r3
                    int r3 = r3 * 34
                    int r2 = r2 - r3
                    r3 = -1
                    if (r2 != r3) goto L57
                L3d:
                    r2 = 29
                    int r3 = r2 * r2
                    r4 = 45
                    int r5 = r4 * r4
                    int r3 = r3 + r5
                    r5 = 20
                    int r0 = r5 * r5
                    int r3 = r3 + r0
                    r0 = 29
                    int r0 = r0 * 45
                    int r4 = r4 * 20
                    int r0 = r0 + r4
                    int r2 = r2 * 20
                    int r0 = r0 + r2
                    if (r3 >= r0) goto L6f
                L57:
                    r2 = 70
                    int r3 = r2 * r2
                    r4 = 7
                    int r5 = r4 * r4
                    int r3 = r3 + r5
                    r5 = 4
                    int r0 = r5 * r5
                    int r3 = r3 + r0
                    r0 = 70
                    int r0 = r0 * 7
                    int r4 = r4 * 4
                    int r0 = r0 + r4
                    int r2 = r2 * 4
                    int r0 = r0 + r2
                    if (r3 >= r0) goto L11
                L6f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.AnonymousClass4.onProgressUpdate(long, long):void");
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x006f A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0011 A[SYNTHETIC] */
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onVideoAdComplete() {
                /*
                    r5 = this;
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$PangleNativeExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.g(r0)
                    if (r0 == 0) goto L11
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$PangleNativeExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.h(r0)
                    r0.onVideoCompleted()
                L11:
                    r0 = 12
                    r1 = 96
                    switch(r1) {
                        case 94: goto L1f;
                        case 95: goto L19;
                        case 96: goto L6f;
                        default: goto L18;
                    }
                L18:
                    goto L11
                L19:
                    switch(r0) {
                        case 94: goto L3d;
                        case 95: goto L57;
                        case 96: goto L6f;
                        default: goto L1c;
                    }
                L1c:
                    r0 = 95
                    goto L19
                L1f:
                    r0 = 1
                    r1 = 81
                    int r2 = 81 - r0
                    int r2 = r2 * 81
                    int r1 = r1 * 2
                    int r1 = r1 - r0
                    int r2 = r2 * r1
                    int r2 = r2 % 6
                    if (r2 == 0) goto L11
                    r0 = 66
                    int r0 = r0 * r0
                    r1 = 16
                    int r1 = r1 * r1
                    int r1 = r1 * 34
                    int r0 = r0 - r1
                    r1 = -1
                    if (r0 != r1) goto L57
                L3d:
                    r0 = 29
                    int r1 = r0 * r0
                    r2 = 45
                    int r3 = r2 * r2
                    int r1 = r1 + r3
                    r3 = 20
                    int r4 = r3 * r3
                    int r1 = r1 + r4
                    r4 = 29
                    int r4 = r4 * 45
                    int r2 = r2 * 20
                    int r4 = r4 + r2
                    int r0 = r0 * 20
                    int r4 = r4 + r0
                    if (r1 >= r4) goto L6f
                L57:
                    r0 = 70
                    int r1 = r0 * r0
                    r2 = 7
                    int r3 = r2 * r2
                    int r1 = r1 + r3
                    r3 = 4
                    int r4 = r3 * r3
                    int r1 = r1 + r4
                    r4 = 70
                    int r4 = r4 * 7
                    int r2 = r2 * 4
                    int r4 = r4 + r2
                    int r0 = r0 * 4
                    int r4 = r4 + r0
                    if (r1 >= r4) goto L11
                L6f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.AnonymousClass4.onVideoAdComplete():void");
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x006f A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0011 A[SYNTHETIC] */
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onVideoAdContinuePlay() {
                /*
                    r5 = this;
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$PangleNativeExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.c(r0)
                    if (r0 == 0) goto L11
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$PangleNativeExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.d(r0)
                    r0.onVideoResume()
                L11:
                    r0 = 12
                    r1 = 96
                    switch(r1) {
                        case 94: goto L1f;
                        case 95: goto L19;
                        case 96: goto L6f;
                        default: goto L18;
                    }
                L18:
                    goto L11
                L19:
                    switch(r0) {
                        case 94: goto L3d;
                        case 95: goto L57;
                        case 96: goto L6f;
                        default: goto L1c;
                    }
                L1c:
                    r0 = 95
                    goto L19
                L1f:
                    r0 = 1
                    r1 = 81
                    int r2 = 81 - r0
                    int r2 = r2 * 81
                    int r1 = r1 * 2
                    int r1 = r1 - r0
                    int r2 = r2 * r1
                    int r2 = r2 % 6
                    if (r2 == 0) goto L11
                    r0 = 66
                    int r0 = r0 * r0
                    r1 = 16
                    int r1 = r1 * r1
                    int r1 = r1 * 34
                    int r0 = r0 - r1
                    r1 = -1
                    if (r0 != r1) goto L57
                L3d:
                    r0 = 29
                    int r1 = r0 * r0
                    r2 = 45
                    int r3 = r2 * r2
                    int r1 = r1 + r3
                    r3 = 20
                    int r4 = r3 * r3
                    int r1 = r1 + r4
                    r4 = 29
                    int r4 = r4 * 45
                    int r2 = r2 * 20
                    int r4 = r4 + r2
                    int r0 = r0 * 20
                    int r4 = r4 + r0
                    if (r1 >= r4) goto L6f
                L57:
                    r0 = 70
                    int r1 = r0 * r0
                    r2 = 7
                    int r3 = r2 * r2
                    int r1 = r1 + r3
                    r3 = 4
                    int r4 = r3 * r3
                    int r1 = r1 + r4
                    r4 = 70
                    int r4 = r4 * 7
                    int r2 = r2 * 4
                    int r4 = r4 + r2
                    int r0 = r0 * 4
                    int r4 = r4 + r0
                    if (r1 >= r4) goto L11
                L6f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.AnonymousClass4.onVideoAdContinuePlay():void");
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x006f A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0011 A[SYNTHETIC] */
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onVideoAdPaused() {
                /*
                    r5 = this;
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$PangleNativeExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.A(r0)
                    if (r0 == 0) goto L11
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$PangleNativeExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.B(r0)
                    r0.onVideoPause()
                L11:
                    r0 = 12
                    r1 = 96
                    switch(r1) {
                        case 94: goto L1f;
                        case 95: goto L19;
                        case 96: goto L6f;
                        default: goto L18;
                    }
                L18:
                    goto L11
                L19:
                    switch(r0) {
                        case 94: goto L3d;
                        case 95: goto L57;
                        case 96: goto L6f;
                        default: goto L1c;
                    }
                L1c:
                    r0 = 95
                    goto L19
                L1f:
                    r0 = 1
                    r1 = 81
                    int r2 = 81 - r0
                    int r2 = r2 * 81
                    int r1 = r1 * 2
                    int r1 = r1 - r0
                    int r2 = r2 * r1
                    int r2 = r2 % 6
                    if (r2 == 0) goto L11
                    r0 = 66
                    int r0 = r0 * r0
                    r1 = 16
                    int r1 = r1 * r1
                    int r1 = r1 * 34
                    int r0 = r0 - r1
                    r1 = -1
                    if (r0 != r1) goto L57
                L3d:
                    r0 = 29
                    int r1 = r0 * r0
                    r2 = 45
                    int r3 = r2 * r2
                    int r1 = r1 + r3
                    r3 = 20
                    int r4 = r3 * r3
                    int r1 = r1 + r4
                    r4 = 29
                    int r4 = r4 * 45
                    int r2 = r2 * 20
                    int r4 = r4 + r2
                    int r0 = r0 * 20
                    int r4 = r4 + r0
                    if (r1 >= r4) goto L6f
                L57:
                    r0 = 70
                    int r1 = r0 * r0
                    r2 = 7
                    int r3 = r2 * r2
                    int r1 = r1 + r3
                    r3 = 4
                    int r4 = r3 * r3
                    int r1 = r1 + r4
                    r4 = 70
                    int r4 = r4 * 7
                    int r2 = r2 * 4
                    int r4 = r4 + r2
                    int r0 = r0 * 4
                    int r4 = r4 + r0
                    if (r1 >= r4) goto L11
                L6f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.AnonymousClass4.onVideoAdPaused():void");
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x006f A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0011 A[SYNTHETIC] */
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onVideoAdStartPlay() {
                /*
                    r5 = this;
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$PangleNativeExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.y(r0)
                    if (r0 == 0) goto L11
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$PangleNativeExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.z(r0)
                    r0.onVideoStart()
                L11:
                    r0 = 12
                    r1 = 96
                    switch(r1) {
                        case 94: goto L1f;
                        case 95: goto L19;
                        case 96: goto L6f;
                        default: goto L18;
                    }
                L18:
                    goto L11
                L19:
                    switch(r0) {
                        case 94: goto L3d;
                        case 95: goto L57;
                        case 96: goto L6f;
                        default: goto L1c;
                    }
                L1c:
                    r0 = 95
                    goto L19
                L1f:
                    r0 = 1
                    r1 = 81
                    int r2 = 81 - r0
                    int r2 = r2 * 81
                    int r1 = r1 * 2
                    int r1 = r1 - r0
                    int r2 = r2 * r1
                    int r2 = r2 % 6
                    if (r2 == 0) goto L11
                    r0 = 66
                    int r0 = r0 * r0
                    r1 = 16
                    int r1 = r1 * r1
                    int r1 = r1 * 34
                    int r0 = r0 - r1
                    r1 = -1
                    if (r0 != r1) goto L57
                L3d:
                    r0 = 29
                    int r1 = r0 * r0
                    r2 = 45
                    int r3 = r2 * r2
                    int r1 = r1 + r3
                    r3 = 20
                    int r4 = r3 * r3
                    int r1 = r1 + r4
                    r4 = 29
                    int r4 = r4 * 45
                    int r2 = r2 * 20
                    int r4 = r4 + r2
                    int r0 = r0 * 20
                    int r4 = r4 + r0
                    if (r1 >= r4) goto L6f
                L57:
                    r0 = 70
                    int r1 = r0 * r0
                    r2 = 7
                    int r3 = r2 * r2
                    int r1 = r1 + r3
                    r3 = 4
                    int r4 = r3 * r3
                    int r1 = r1 + r4
                    r4 = 70
                    int r4 = r4 * 7
                    int r2 = r2 * 4
                    int r4 = r4 + r2
                    int r0 = r0 * 4
                    int r4 = r4 + r0
                    if (r1 >= r4) goto L11
                L6f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.AnonymousClass4.onVideoAdStartPlay():void");
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x008f, code lost:
            
                continue;
             */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0080  */
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onVideoError(int r5, int r6) {
                /*
                    r4 = this;
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$PangleNativeExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.w(r0)
                    if (r0 == 0) goto L92
                    com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$PangleNativeExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.x(r0)
                    com.bytedance.msdk.api.AdError r1 = new com.bytedance.msdk.api.AdError
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "MediaPlayer inter error code:"
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.AnonymousClass4.onVideoError(int, int):void");
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoLoad() {
            }
        };

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        TTAppDownloadListener f13961e = new TTAppDownloadListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.5
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j2, long j3, String str, String str2) {
                if (((TTBaseAd) PangleNativeExpressAd.this).mTTAdAppDownloadListener != null) {
                    ((TTBaseAd) PangleNativeExpressAd.this).mTTAdAppDownloadListener.onDownloadProgress(j2, j3, -1, 1);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j2, long j3, String str, String str2) {
                if (((TTBaseAd) PangleNativeExpressAd.this).mTTAdAppDownloadListener != null) {
                    ((TTBaseAd) PangleNativeExpressAd.this).mTTAdAppDownloadListener.onDownloadFailed(j2, j3, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j2, String str, String str2) {
                if (((TTBaseAd) PangleNativeExpressAd.this).mTTAdAppDownloadListener != null) {
                    ((TTBaseAd) PangleNativeExpressAd.this).mTTAdAppDownloadListener.onDownloadFinished(j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j2, long j3, String str, String str2) {
                if (((TTBaseAd) PangleNativeExpressAd.this).mTTAdAppDownloadListener != null) {
                    ((TTBaseAd) PangleNativeExpressAd.this).mTTAdAppDownloadListener.onDownloadPaused(j2, j3, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                if (((TTBaseAd) PangleNativeExpressAd.this).mTTAdAppDownloadListener != null) {
                    ((TTBaseAd) PangleNativeExpressAd.this).mTTAdAppDownloadListener.onIdle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                if (((TTBaseAd) PangleNativeExpressAd.this).mTTAdAppDownloadListener != null) {
                    ((TTBaseAd) PangleNativeExpressAd.this).mTTAdAppDownloadListener.onInstalled(str, str2);
                }
            }
        };

        PangleNativeExpressAd(TTNativeExpressAd tTNativeExpressAd) {
            Map<String, Object> mediaExtraInfo;
            this.a = tTNativeExpressAd;
            setImageMode(this.a.getImageMode());
            setInteractionType(this.a.getInteractionType());
            setExpressAd(true);
            this.a.setExpressInteractionListener(this.f13959c);
            this.a.setDownloadListener(this.f13961e);
            if (tTNativeExpressAd.getImageMode() == 5) {
                this.a.setVideoAdListener(this.f13960d);
            }
            if (!PangleBannerAdapter.this.isClientBidding() || (mediaExtraInfo = tTNativeExpressAd.getMediaExtraInfo()) == null) {
                return;
            }
            double value = PangleAdapterUtils.getValue(mediaExtraInfo.get("price"));
            Logger.d("TTMediationSDK_ECMP", "banner混存 pangle 模板native 返回的 cpm价格：" + value);
            setCpm(value <= PangleAdapterUtils.CPM_DEFLAUT_VALUE ? 0.0d : value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ITTAdapterBannerAdListener a() {
            return (ITTAdapterBannerAdListener) this.mTTAdatperCallback;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            return tTNativeExpressAd != null ? PangleAdapterUtils.getAdId(tTNativeExpressAd.getMediaExtraInfo()) : super.getAdId();
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x008c A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0009 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:16:0x0029). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0072 -> B:27:0x0074). Please report as a decompilation issue!!! */
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
        public android.view.View getAdView() {
            /*
                r6 = this;
                com.bytedance.sdk.openadsdk.TTNativeExpressAd r0 = r6.a
                if (r0 == 0) goto L9
                android.view.View r0 = r0.getExpressAdView()
                return r0
            L9:
                r0 = 95
                r1 = 1
                r2 = 15
                switch(r0) {
                    case 94: goto L5c;
                    case 95: goto L12;
                    case 96: goto L25;
                    default: goto L11;
                }
            L11:
                goto L9
            L12:
                switch(r0) {
                    case 94: goto L74;
                    case 95: goto L8c;
                    case 96: goto L16;
                    default: goto L15;
                }
            L15:
                goto L25
            L16:
                r0 = 18
                int r0 = r0 * r0
                r3 = 35
                int r3 = r3 * r3
                int r3 = r3 * 34
                int r0 = r0 - r3
                r3 = -1
                if (r0 != r3) goto L74
                goto L29
            L25:
                switch(r0) {
                    case 55: goto L29;
                    case 56: goto L43;
                    case 57: goto L52;
                    default: goto L28;
                }
            L28:
                goto L5c
            L29:
                r0 = 26
                int r3 = r0 * r0
                int r3 = r3 * 26
                r4 = 9
                int r5 = r4 * r4
                int r5 = r5 * 9
                int r3 = r3 + r5
                int r5 = r2 * r2
                int r5 = r5 * 15
                int r3 = r3 + r5
                int r0 = r0 * 9
                int r0 = r0 * 15
                int r0 = r0 * 3
                if (r3 >= r0) goto L9
            L43:
                r0 = 80
                int r3 = r0 * r0
                r4 = 0
                int r5 = r4 * r4
                int r3 = r3 + r5
                int r3 = r3 + r5
                int r0 = r0 * 0
                int r5 = r5 + r0
                int r5 = r5 + r0
                if (r3 >= r5) goto L9
            L52:
                r0 = 15
                int r0 = r0 + r1
                int r0 = r0 * 15
                int r0 = r0 % 2
                if (r0 == 0) goto L29
                goto L9
            L5c:
                r0 = 30
                int r2 = 30 - r1
                int r2 = r2 * 30
                int r0 = r0 * 2
                int r0 = r0 - r1
                int r2 = r2 * r0
                int r2 = r2 % 6
                if (r2 == 0) goto L9
            L6b:
                r0 = 39
                int r0 = r0 + r1
                int r0 = r0 * 39
                int r0 = r0 % 2
                if (r0 == 0) goto L9
            L74:
                r0 = 70
                int r2 = r0 * r0
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
                int r0 = r0 * 4
                int r5 = r5 + r0
                if (r2 >= r5) goto L6b
            L8c:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.getAdView():android.view.View");
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

        /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
        
            if (((66 * 66) - ((16 * 16) * 34)) == (-1)) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
        
            if ((((29 * 29) + (45 * 45)) + (20 * 20)) >= (((29 * 45) + (45 * 20)) + (29 * 20))) goto L26;
         */
        @Override // com.bytedance.msdk.base.TTBaseAd
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String getReqId() {
            /*
                r5 = this;
            L0:
                r0 = 12
                r1 = 96
                switch(r1) {
                    case 94: goto Le;
                    case 95: goto L8;
                    case 96: goto L5e;
                    default: goto L7;
                }
            L7:
                goto L0
            L8:
                switch(r0) {
                    case 94: goto L2c;
                    case 95: goto L46;
                    case 96: goto L5e;
                    default: goto Lb;
                }
            Lb:
                r0 = 95
                goto L8
            Le:
                r0 = 1
                r1 = 81
                int r2 = 81 - r0
                int r2 = r2 * 81
                int r1 = r1 * 2
                int r1 = r1 - r0
                int r2 = r2 * r1
                int r2 = r2 % 6
                if (r2 == 0) goto L5e
                r0 = 66
                int r0 = r0 * r0
                r1 = 16
                int r1 = r1 * r1
                int r1 = r1 * 34
                int r0 = r0 - r1
                r1 = -1
                if (r0 != r1) goto L46
            L2c:
                r0 = 29
                int r1 = r0 * r0
                r2 = 45
                int r3 = r2 * r2
                int r1 = r1 + r3
                r3 = 20
                int r4 = r3 * r3
                int r1 = r1 + r4
                r4 = 29
                int r4 = r4 * 45
                int r2 = r2 * 20
                int r4 = r4 + r2
                int r0 = r0 * 20
                int r4 = r4 + r0
                if (r1 >= r4) goto L5e
            L46:
                r0 = 70
                int r1 = r0 * r0
                r2 = 7
                int r3 = r2 * r2
                int r1 = r1 + r3
                r3 = 4
                int r4 = r3 * r3
                int r1 = r1 + r4
                r4 = 70
                int r4 = r4 * 7
                int r2 = r2 * 4
                int r4 = r4 + r2
                int r0 = r0 * 4
                int r4 = r4 + r0
                if (r1 >= r4) goto L0
            L5e:
                com.bytedance.sdk.openadsdk.TTNativeExpressAd r0 = r5.a
                if (r0 == 0) goto L6b
                java.util.Map r0 = r0.getMediaExtraInfo()
                java.lang.String r0 = com.bytedance.msdk.adapter.pangle.PangleAdapterUtils.getReqId(r0)
                return r0
            L6b:
                java.lang.String r0 = super.getReqId()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.getReqId():java.lang.String");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.b;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDislike() {
            return true;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            this.b = true;
            ThreadHelper.runOnUiThread(new Runnable() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.1
                @Override // java.lang.Runnable
                public void run() {
                    TTNativeExpressAd tTNativeExpressAd = PangleNativeExpressAd.this.a;
                    if (tTNativeExpressAd != null) {
                        tTNativeExpressAd.destroy();
                    }
                }
            });
            super.onDestroy();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0053 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x004e A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x004c -> B:17:0x0020). Please report as a decompilation issue!!! */
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
        public void render() {
            /*
                r5 = this;
                com.bytedance.sdk.openadsdk.TTNativeExpressAd r0 = r5.a
                if (r0 == 0) goto L53
                r0.render()
            L7:
                r0 = 92
            L9:
                r1 = 14
                r2 = 15
            Ld:
                r3 = 12
                switch(r1) {
                    case 13: goto L17;
                    case 14: goto L4e;
                    case 15: goto L13;
                    default: goto L12;
                }
            L12:
                goto L9
            L13:
                switch(r0) {
                    case 94: goto L4e;
                    case 95: goto L53;
                    case 96: goto L4e;
                    default: goto L16;
                }
            L16:
                goto L1c
            L17:
                r1 = 72
                if (r0 < r1) goto L1c
                goto L4e
            L1c:
                switch(r3) {
                    case 55: goto L20;
                    case 56: goto L3a;
                    case 57: goto L44;
                    default: goto L1f;
                }
            L1f:
                goto L4e
            L20:
                r0 = 26
                int r1 = r0 * r0
                int r1 = r1 * 26
                r3 = 9
                int r4 = r3 * r3
                int r4 = r4 * 9
                int r1 = r1 + r4
                int r4 = r2 * r2
                int r4 = r4 * 15
                int r1 = r1 + r4
                int r0 = r0 * 9
                int r0 = r0 * 15
                int r0 = r0 * 3
                if (r1 >= r0) goto L53
            L3a:
                r0 = 90
                int r0 = r0 + 1
                int r0 = r0 * 90
                int r0 = r0 % 2
                if (r0 == 0) goto L7
            L44:
                r0 = 15
                int r0 = r0 + 1
                int r0 = r0 * 15
                int r0 = r0 % 2
                if (r0 == 0) goto L20
            L4e:
                r0 = 95
                r1 = 15
                goto Ld
            L53:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.render():void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void setDislikeCallback(Activity activity, final GMDislikeCallback gMDislikeCallback) {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.PangleNativeExpressAd.2
                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onCancel() {
                        GMDislikeCallback gMDislikeCallback2 = gMDislikeCallback;
                        if (gMDislikeCallback2 != null) {
                            gMDislikeCallback2.onCancel();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                    public void onSelected(int i2, String str, boolean z2) {
                        GMDislikeCallback gMDislikeCallback2 = gMDislikeCallback;
                        if (gMDislikeCallback2 != null) {
                            gMDislikeCallback2.onSelected(i2, str);
                            if (((TTBaseAd) PangleNativeExpressAd.this).mTTAdatperCallback instanceof ITTAdapterBannerAdListener) {
                                PangleNativeExpressAd.this.a().onAdClosed();
                            }
                        }
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
    }

    class TTBannerView extends TTBaseAd {
        TTNativeExpressAd a;
        View b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f13964d;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Object f13963c = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private volatile boolean f13965e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        TTNativeExpressAd.ExpressAdInteractionListener f13966f = new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.TTBannerView.4
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
            public void onAdClicked(android.view.View r9, int r10) {
                /*
                    Method dump skipped, instruction units count: 210
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.TTBannerView.AnonymousClass4.onAdClicked(android.view.View, int):void");
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.TTBannerView.AnonymousClass4.onAdShow(android.view.View, int):void");
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i2) {
                TTBannerView.this.f13964d = false;
                Logger.e("TTMediationSDK_banner", TTLogUtil.getTagThirdLevelById(PangleBannerAdapter.this.getAdapterRit(), PangleBannerAdapter.this.getAdSlotId()) + "TTBannerView onRenderFail -> code=" + i2 + ",msg=" + str);
                while (true) {
                    switch (72) {
                        case 70:
                            if (((90 + 1) * 90) % 2 == 0) {
                                continue;
                            } else if ((68 * 68 * 68) + (14 * 14 * 14) + (17 * 17 * 17) >= 68 * 14 * 17 * 3 || (13 * 13) - ((19 * 19) * 34) != -1 || (((29 - 1) * 29) * ((29 * 2) - 1)) % 6 != 0) {
                            }
                            break;
                        case 71:
                            if ((68 * 68 * 68) + (14 * 14 * 14) + (17 * 17 * 17) >= 68 * 14 * 17 * 3) {
                                continue;
                            }
                            break;
                    }
                    return;
                }
            }

            /* JADX WARN: Failed to build post-dominance tree
            java.lang.ArrayIndexOutOfBoundsException
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
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(android.view.View r6, float r7, float r8) {
                /*
                    Method dump skipped, instruction units count: 202
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.TTBannerView.AnonymousClass4.onRenderSuccess(android.view.View, float, float):void");
            }
        };

        TTBannerView() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ITTAdapterBannerAdListener a() {
            return (ITTAdapterBannerAdListener) this.mTTAdatperCallback;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            return tTNativeExpressAd != null ? PangleAdapterUtils.getAdId(tTNativeExpressAd.getMediaExtraInfo()) : super.getAdId();
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:31:0x0040. Please report as an issue. */
        /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0007. Please report as an issue. */
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
            	at jadx.core.dex.visitors.regions.maker.SynchronizedRegionMaker.process(SynchronizedRegionMaker.java:87)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:118)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
            */
        @Override // com.bytedance.msdk.base.TTBaseAd
        public synchronized android.view.View getAdView() {
            /*
                r6 = this;
                monitor-enter(r6)
            L1:
                r0 = 94
                r1 = 125(0x7d, float:1.75E-43)
                r2 = 95
            L7:
                switch(r0) {
                    case 94: goto L43;
                    case 95: goto Lb;
                    case 96: goto L40;
                    default: goto La;
                }
            La:
                goto L1
            Lb:
                switch(r1) {
                    case 94: goto L43;
                    case 95: goto Lf;
                    case 96: goto L43;
                    default: goto Le;
                }
            Le:
                goto L40
            Lf:
                java.lang.Object r0 = r6.f13963c     // Catch: java.lang.Throwable -> L3d
                monitor-enter(r0)     // Catch: java.lang.Throwable -> L3d
                android.view.View r1 = r6.b     // Catch: java.lang.Throwable -> L3a
                if (r1 != 0) goto L35
                long r1 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.InterruptedException -> L31 java.lang.Throwable -> L3a
                r3 = 2000(0x7d0, double:9.88E-321)
                long r3 = r3 + r1
            L1d:
                boolean r5 = r6.f13964d     // Catch: java.lang.InterruptedException -> L31 java.lang.Throwable -> L3a
                if (r5 != 0) goto L35
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 >= 0) goto L35
                java.lang.Object r5 = r6.f13963c     // Catch: java.lang.InterruptedException -> L31 java.lang.Throwable -> L3a
                long r1 = r3 - r1
                r5.wait(r1)     // Catch: java.lang.InterruptedException -> L31 java.lang.Throwable -> L3a
                long r1 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.InterruptedException -> L31 java.lang.Throwable -> L3a
                goto L1d
            L31:
                r1 = move-exception
                r1.printStackTrace()     // Catch: java.lang.Throwable -> L3a
            L35:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L3a
                android.view.View r0 = r6.b     // Catch: java.lang.Throwable -> L3d
                monitor-exit(r6)
                return r0
            L3a:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L3a
                throw r1     // Catch: java.lang.Throwable -> L3d
            L3d:
                r0 = move-exception
                monitor-exit(r6)
                throw r0
            L40:
                switch(r1) {
                    case 55: goto L43;
                    case 56: goto L1;
                    case 57: goto L43;
                    default: goto L43;
                }
            L43:
                r0 = 95
                r1 = 95
                goto L7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.TTBannerView.getAdView():android.view.View");
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
            return this.f13965e;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDislike() {
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x00b2, code lost:
        
            if (((((68 - 1) * 68) * ((68 * 2) - 1)) % 6) == 0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00e1, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void loadAd() {
            /*
                Method dump skipped, instruction units count: 250
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.TTBannerView.loadAd():void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            this.f13965e = true;
            ThreadHelper.runOnUiThread(new Runnable() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.TTBannerView.3
                @Override // java.lang.Runnable
                public void run() {
                    TTNativeExpressAd tTNativeExpressAd = TTBannerView.this.a;
                    if (tTNativeExpressAd != null) {
                        tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) null);
                        TTBannerView.this.a.destroy();
                    }
                }
            });
            super.onDestroy();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0015. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0011 A[FALL_THROUGH, PHI: r5
  0x0011: PHI (r5v2 char) = (r5v1 char), (r5v3 char), (r5v3 char), (r5v3 char), (r5v3 char) binds: [B:5:0x000f, B:8:0x0015, B:10:0x0019, B:23:0x0053, B:21:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0019 -> B:25:0x0056). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0020 -> B:25:0x0056). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x003f -> B:25:0x0056). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0053 -> B:18:0x0027). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:6:0x0011 -> B:7:0x0013). Please report as a decompilation issue!!! */
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
            	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
            	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
            */
        @Override // com.bytedance.msdk.base.TTBaseAd
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void setDislikeCallback(android.app.Activity r5, final com.bytedance.msdk.api.v2.GMDislikeCallback r6) {
            /*
                r4 = this;
                com.bytedance.sdk.openadsdk.TTNativeExpressAd r0 = r4.a
                r1 = 15
                if (r0 == 0) goto Lf
                com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$TTBannerView$2 r2 = new com.bytedance.msdk.adapter.pangle.PangleBannerAdapter$TTBannerView$2
                r2.<init>()
                r0.setDislikeCallback(r5, r2)
                goto L56
            Lf:
                r5 = 92
            L11:
                r6 = 14
            L13:
                r0 = 12
                switch(r6) {
                    case 13: goto L1e;
                    case 14: goto L1d;
                    case 15: goto L19;
                    default: goto L18;
                }
            L18:
                goto L11
            L19:
                switch(r5) {
                    case 94: goto L56;
                    case 95: goto L11;
                    case 96: goto L56;
                    default: goto L1c;
                }
            L1c:
                goto L23
            L1d:
                return
            L1e:
                r6 = 72
                if (r5 < r6) goto L23
                goto L56
            L23:
                switch(r0) {
                    case 55: goto L27;
                    case 56: goto L41;
                    case 57: goto L4b;
                    default: goto L26;
                }
            L26:
                goto L56
            L27:
                r6 = 26
                int r0 = r6 * r6
                int r0 = r0 * 26
                r2 = 9
                int r3 = r2 * r2
                int r3 = r3 * 9
                int r0 = r0 + r3
                int r3 = r1 * r1
                int r3 = r3 * 15
                int r0 = r0 + r3
                int r6 = r6 * 9
                int r6 = r6 * 15
                int r6 = r6 * 3
                if (r0 >= r6) goto L56
            L41:
                r6 = 90
                int r6 = r6 + 1
                int r6 = r6 * 90
                int r6 = r6 % 2
                if (r6 == 0) goto L11
            L4b:
                r6 = 15
                int r6 = r6 + 1
                int r6 = r6 * 15
                int r6 = r6 % 2
                if (r6 == 0) goto L27
                goto L11
            L56:
                r5 = 95
                r6 = 15
                goto L13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.TTBannerView.setDislikeCallback(android.app.Activity, com.bytedance.msdk.api.v2.GMDislikeCallback):void");
        }
    }

    private void a() {
        TTAdNative tTAdNativeCreateAdNative = TTAdSdk.getAdManager().createAdNative(this.a);
        AdSlot.Builder builderBuildPangleAdSlot = PangleAdapterUtils.buildPangleAdSlot(this.mAdSlot, this.mGMAdSlotBanner, getAdSlotId(), this.mWaterfallAbTestParam, getClientReqId(), getAdm(), false);
        int[] bannerSize = getBannerSize(this.mGMAdSlotBanner.getBannerSize(), this.mGMAdSlotBanner);
        builderBuildPangleAdSlot.setImageAcceptedSize(PangleAdapterUtils.dp2px(this.a, bannerSize[0]), PangleAdapterUtils.dp2px(this.a, bannerSize[1]));
        tTAdNativeCreateAdNative.loadFeedAd(builderBuildPangleAdSlot.build(), new TTAdNative.FeedAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int i2, String str) {
                PangleBannerAdapter.this.notifyAdFailed(new AdError(i2, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                if (list == null || list.isEmpty()) {
                    PangleBannerAdapter.this.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                } else {
                    PangleBannerAdapter pangleBannerAdapter = PangleBannerAdapter.this;
                    pangleBannerAdapter.notifyAdLoaded(pangleBannerAdapter.new PangleNativeAd(list.get(0)));
                }
            }
        });
    }

    private void b() {
        TTAdNative tTAdNativeCreateAdNative = TTAdSdk.getAdManager().createAdNative(this.a);
        AdSlot.Builder builderBuildPangleAdSlot = PangleAdapterUtils.buildPangleAdSlot(this.mAdSlot, this.mGMAdSlotBanner, getAdSlotId(), this.mWaterfallAbTestParam, getClientReqId(), getAdm(), false);
        int[] bannerSize = getBannerSize(this.mGMAdSlotBanner.getBannerSize(), this.mGMAdSlotBanner);
        int iDp2px = PangleAdapterUtils.dp2px(this.a, bannerSize[0]);
        int iDp2px2 = PangleAdapterUtils.dp2px(this.a, bannerSize[1]);
        builderBuildPangleAdSlot.setImageAcceptedSize(iDp2px, iDp2px2);
        if (iDp2px2 > 0) {
            builderBuildPangleAdSlot.setExpressViewAcceptedSize(iDp2px, iDp2px2);
        } else {
            builderBuildPangleAdSlot.setExpressViewAcceptedSize(iDp2px, 0.0f);
        }
        tTAdNativeCreateAdNative.loadNativeExpressAd(builderBuildPangleAdSlot.build(), new TTAdNative.NativeExpressAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int i2, String str) {
                PangleBannerAdapter.this.notifyAdFailed(new AdError(i2, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                if (list == null || list.size() == 0) {
                    PangleBannerAdapter.this.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                    return;
                }
                for (TTNativeExpressAd tTNativeExpressAd : list) {
                    if (tTNativeExpressAd != null) {
                        PangleBannerAdapter.this.new PangleNativeExpressAd(tTNativeExpressAd).render();
                        return;
                    }
                }
            }
        });
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0094. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:47:0x00f6. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0064 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0031 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[LOOP:3: B:43:0x00f6->B:63:?, LOOP_END, SYNTHETIC] */
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
    @Override // com.bytedance.msdk.adapter.ad.GMBannerBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadAd(android.content.Context r8, java.util.Map<java.lang.String, java.lang.Object> r9) {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleBannerAdapter.loadAd(android.content.Context, java.util.Map):void");
    }
}
