package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import com.bytedance.msdk.adapter.ad.GMSplashBaseAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.ISplashCardListener;
import com.bytedance.sdk.openadsdk.ISplashClickEyeListener;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PangleSplashAdapter extends GMSplashBaseAdapter {
    public static final String VERSION_00 = "0.0";
    public static final String VERSION_4712 = "4.7.1.2";
    private Context a;
    private int b = 3000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PangleSplashAd f13996c;

    class PangleSplashAd extends TTBaseAd {
        private TTSplashAd a;
        private CSJSplashAd b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f13997c;

        PangleSplashAd() {
        }

        private void a(TTAdNative tTAdNative, AdSlot adSlot) {
            tTAdNative.loadSplashAd(adSlot, new TTAdNative.CSJSplashAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.1
                /* JADX WARN: Removed duplicated region for block: B:37:0x00a6 A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:46:? A[SYNTHETIC] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0095 -> B:8:0x0025). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                @androidx.annotation.MainThread
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onSplashLoadFail(com.bytedance.sdk.openadsdk.CSJAdError r5) {
                    /*
                        Method dump skipped, instruction units count: 208
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.AnonymousClass1.onSplashLoadFail(com.bytedance.sdk.openadsdk.CSJAdError):void");
                }

                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                @MainThread
                public void onSplashLoadSuccess() {
                    while (true) {
                        char c2 = ']';
                        char c3 = ']';
                        while (true) {
                            switch (c2) {
                                case '\\':
                                    switch (c3) {
                                        case 21:
                                            Logger.e("TTMediationSDK", "new api onSplashLoadSuccess");
                                            c2 = '^';
                                            c3 = 'K';
                                            break;
                                    }
                                case ']':
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
                                    Logger.e("TTMediationSDK", "new api onSplashLoadSuccess");
                                    c2 = '^';
                                    c3 = 'K';
                                    break;
                                case '^':
                                    if (c3 > 4) {
                                    }
                                    break;
                            }
                            return;
                        }
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:27:0x007f A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:34:0x002f A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:35:0x003e A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:37:? A[LOOP:1: B:9:0x0029->B:37:?, LOOP_END, SYNTHETIC] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004b -> B:9:0x0029). Please report as a decompilation issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0072 -> B:12:0x002f). Please report as a decompilation issue!!! */
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
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                @androidx.annotation.MainThread
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onSplashRenderFail(com.bytedance.sdk.openadsdk.CSJSplashAd r4, com.bytedance.sdk.openadsdk.CSJAdError r5) {
                    /*
                        r3 = this;
                        java.lang.String r4 = "TTMediationSDK"
                        java.lang.String r0 = "new api onSplashRenderFail"
                        com.bytedance.msdk.adapter.util.Logger.e(r4, r0)
                        com.bytedance.msdk.adapter.pangle.PangleSplashAdapter$PangleSplashAd r4 = com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.this
                        com.bytedance.msdk.adapter.pangle.PangleSplashAdapter r4 = com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.this
                        if (r5 == 0) goto L75
                        com.bytedance.msdk.api.AdError r0 = new com.bytedance.msdk.api.AdError
                        int r1 = r5.getCode()
                        java.lang.String r5 = r5.getMsg()
                        r0.<init>(r1, r5)
                        r4.notifyAdFailed(r0)
                    L1d:
                        r4 = 34
                        r5 = 31
                        r0 = 1
                        switch(r5) {
                            case 29: goto L29;
                            case 30: goto L26;
                            case 31: goto L29;
                            default: goto L25;
                        }
                    L25:
                        goto L1d
                    L26:
                        switch(r4) {
                            case 57: goto L4d;
                            case 58: goto L5b;
                            case 59: goto L64;
                            default: goto L29;
                        }
                    L29:
                        r4 = 39
                        switch(r4) {
                            case 39: goto L7f;
                            case 40: goto L2f;
                            case 41: goto L3e;
                            default: goto L2e;
                        }
                    L2e:
                        goto L29
                    L2f:
                        r4 = 29
                        int r5 = 29 - r0
                        int r5 = r5 * 29
                        int r4 = r4 * 2
                        int r4 = r4 - r0
                        int r5 = r5 * r4
                        int r5 = r5 % 6
                        if (r5 == 0) goto L1d
                    L3e:
                        r4 = 38
                        int r5 = 38 - r0
                        int r5 = r5 * 38
                        int r4 = r4 * 2
                        int r4 = r4 - r0
                        int r5 = r5 * r4
                        int r5 = r5 % 6
                        if (r5 == 0) goto L29
                    L4d:
                        r4 = 7
                        int r5 = 7 - r0
                        int r5 = r5 * 7
                        int r4 = r4 * 2
                        int r4 = r4 - r0
                        int r5 = r5 * r4
                        int r5 = r5 % 6
                        if (r5 == 0) goto L1d
                    L5b:
                        r4 = 17
                        int r4 = r4 + r0
                        int r4 = r4 * 17
                        int r4 = r4 % 2
                        if (r4 == 0) goto L7f
                    L64:
                        r4 = 12
                        int r5 = r4 * r4
                        r1 = 37
                        int r2 = r1 * r1
                        int r5 = r5 + r2
                        int r4 = r4 * 37
                        int r4 = r4 * 2
                        int r5 = r5 - r4
                        if (r5 >= 0) goto L2f
                        goto L1d
                    L75:
                        com.bytedance.msdk.api.AdError r5 = new com.bytedance.msdk.api.AdError
                        java.lang.String r0 = "csjAdError is null"
                        r5.<init>(r0)
                        r4.notifyAdFailed(r5)
                    L7f:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.AnonymousClass1.onSplashRenderFail(com.bytedance.sdk.openadsdk.CSJSplashAd, com.bytedance.sdk.openadsdk.CSJAdError):void");
                }

                /* JADX WARN: Removed duplicated region for block: B:45:0x0079 A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:51:0x007a A[SYNTHETIC] */
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                @androidx.annotation.MainThread
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onSplashRenderSuccess(com.bytedance.sdk.openadsdk.CSJSplashAd r6) {
                    /*
                        Method dump skipped, instruction units count: 308
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.AnonymousClass1.onSplashRenderSuccess(com.bytedance.sdk.openadsdk.CSJSplashAd):void");
                }
            }, PangleSplashAdapter.this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0011 A[SYNTHETIC] */
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
        public com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener b() {
            /*
                r3 = this;
            L0:
                r0 = 94
                r1 = 75
                r2 = 93
            L6:
                switch(r0) {
                    case 92: goto La;
                    case 93: goto Ld;
                    case 94: goto L19;
                    default: goto L9;
                }
            L9:
                goto L19
            La:
                switch(r1) {
                    case 21: goto L19;
                    case 22: goto L11;
                    case 23: goto L11;
                    default: goto Ld;
                }
            Ld:
                switch(r1) {
                    case 91: goto L0;
                    case 92: goto L19;
                    case 93: goto L11;
                    default: goto L10;
                }
            L10:
                goto L16
            L11:
                com.bytedance.msdk.adapter.listener.ITTAdatperCallback r0 = r3.mTTAdatperCallback
                com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener r0 = (com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener) r0
                return r0
            L16:
                r1 = 91
                goto Ld
            L19:
                r0 = 93
                r1 = 93
                goto L6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.b():com.bytedance.msdk.adapter.listener.ITTAdapterSplashAdListener");
        }

        private void b(TTAdNative tTAdNative, AdSlot adSlot) {
            tTAdNative.loadSplashAd(adSlot, new TTAdNative.SplashAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.2
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Removed duplicated region for block: B:25:0x0054 A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:32:0x0055 A[SYNTHETIC] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0051 -> B:15:0x0025). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
                @androidx.annotation.MainThread
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onError(int r4, java.lang.String r5) {
                    /*
                        r3 = this;
                        com.bytedance.msdk.adapter.pangle.PangleSplashAdapter$PangleSplashAd r0 = com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.this
                        com.bytedance.msdk.adapter.pangle.PangleSplashAdapter r0 = com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.this
                        com.bytedance.msdk.api.AdError r1 = new com.bytedance.msdk.api.AdError
                        r1.<init>(r4, r5)
                        r0.notifyAdFailed(r1)
                    Lc:
                        r4 = 92
                    Le:
                        r5 = 14
                        r0 = 15
                    L12:
                        r1 = 12
                        switch(r5) {
                            case 13: goto L1c;
                            case 14: goto L55;
                            case 15: goto L18;
                            default: goto L17;
                        }
                    L17:
                        goto Le
                    L18:
                        switch(r4) {
                            case 94: goto L55;
                            case 95: goto L54;
                            case 96: goto L55;
                            default: goto L1b;
                        }
                    L1b:
                        goto L21
                    L1c:
                        r5 = 72
                        if (r4 < r5) goto L21
                        goto L55
                    L21:
                        switch(r1) {
                            case 55: goto L25;
                            case 56: goto L3f;
                            case 57: goto L49;
                            default: goto L24;
                        }
                    L24:
                        goto L55
                    L25:
                        r4 = 26
                        int r5 = r4 * r4
                        int r5 = r5 * 26
                        r1 = 9
                        int r2 = r1 * r1
                        int r2 = r2 * 9
                        int r5 = r5 + r2
                        int r2 = r0 * r0
                        int r2 = r2 * 15
                        int r5 = r5 + r2
                        int r4 = r4 * 9
                        int r4 = r4 * 15
                        int r4 = r4 * 3
                        if (r5 >= r4) goto L54
                    L3f:
                        r4 = 90
                        int r4 = r4 + 1
                        int r4 = r4 * 90
                        int r4 = r4 % 2
                        if (r4 == 0) goto Lc
                    L49:
                        r4 = 15
                        int r4 = r4 + 1
                        int r4 = r4 * 15
                        int r4 = r4 % 2
                        if (r4 == 0) goto L25
                        goto L55
                    L54:
                        return
                    L55:
                        r4 = 95
                        r5 = 15
                        goto L12
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.AnonymousClass2.onError(int, java.lang.String):void");
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
                @MainThread
                public void onSplashAdLoad(TTSplashAd tTSplashAd) {
                    Map<String, Object> mediaExtraInfo;
                    if (tTSplashAd == null) {
                        PangleSplashAdapter.this.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                        while (true) {
                            switch (87) {
                                case 85:
                                    if ((94 * 94 * 94) + (29 * 29 * 29) + (12 * 12 * 12) >= 94 * 29 * 12 * 3) {
                                    }
                                    break;
                                case 87:
                                    return;
                            }
                        }
                        int i2 = (((50 - 1) * 50) * ((50 * 2) - 1)) % 6;
                        return;
                    }
                    PangleSplashAd.this.a = tTSplashAd;
                    PangleSplashAd.this.setExpressAd(true);
                    PangleSplashAd pangleSplashAd = PangleSplashAd.this;
                    pangleSplashAd.setInteractionType(pangleSplashAd.a.getInteractionType());
                    if (PangleSplashAdapter.this.isClientBidding() && (mediaExtraInfo = PangleSplashAd.this.a.getMediaExtraInfo()) != null) {
                        double value = PangleAdapterUtils.getValue(mediaExtraInfo.get("price"));
                        Logger.d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(PangleSplashAdapter.this.getAdapterRit(), PangleSplashAdapter.this.getAdSlotId()) + "pangle Splash 返回的 cpm价格：" + value);
                        PangleSplashAd pangleSplashAd2 = PangleSplashAd.this;
                        if (value <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                            value = 0.0d;
                        }
                        pangleSplashAd2.setCpm(value);
                    }
                    PangleSplashAd.this.a.setSplashInteractionListener(new TTSplashAd.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.2.1
                        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                        public void onAdClicked(View view, int i3) {
                            if (((TTBaseAd) PangleSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                PangleSplashAd.this.b().onAdClicked();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                        public void onAdShow(View view, int i3) {
                            if (((TTBaseAd) PangleSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                PangleSplashAd.this.b().onAdShow();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                        public void onAdSkip() {
                            Logger.e("TTMediationSDK", "穿山甲_splash_onAdSkip");
                            if (((TTBaseAd) PangleSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                PangleSplashAd.this.b().onAdSkip();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                        public void onAdTimeOver() {
                            Logger.e("TTMediationSDK", "穿山甲_splash_onAdTimeOver");
                            if (((TTBaseAd) PangleSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                PangleSplashAd.this.b().onAdDismiss();
                            }
                        }
                    });
                    PangleSplashAd.this.a.setSplashClickEyeListener(new ISplashClickEyeListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.2.2
                        @Override // com.bytedance.sdk.openadsdk.ISplashClickEyeListener
                        public boolean isSupportSplashClickEye(boolean z2) {
                            Logger.e("TTMediationSDK", "穿山甲_splash_isSupportSplashClickEye:" + z2);
                            PangleSplashAd.this.f13997c = z2;
                            return false;
                        }

                        @Override // com.bytedance.sdk.openadsdk.ISplashClickEyeListener
                        public void onSplashClickEyeAnimationFinish() {
                            Logger.e("TTMediationSDK", "穿山甲_splash_onSplashClickEyeAnimationFinish");
                            if (((TTBaseAd) PangleSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                PangleSplashAd.this.b().onMinWindowPlayFinish();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.ISplashClickEyeListener
                        public void onSplashClickEyeAnimationStart() {
                            Logger.e("TTMediationSDK", "穿山甲_splash_onSplashClickEyeAnimationStart");
                            PangleSplashAd pangleSplashAd3 = PangleSplashAd.this;
                            if (pangleSplashAd3.f13997c && (((TTBaseAd) pangleSplashAd3).mTTAdatperCallback instanceof ITTAdapterSplashAdListener)) {
                                PangleSplashAd.this.b().onMinWindowStart();
                            }
                        }
                    });
                    PangleSplashAd.this.a.setSplashCardListener(new ISplashCardListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.2.3
                        @Override // com.bytedance.sdk.openadsdk.ISplashCardListener
                        public Activity getActivity() {
                            Logger.e("TTMediationSDK", "穿山甲_splash_getActivity");
                            if (((TTBaseAd) PangleSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                return PangleSplashAd.this.b().getActivity();
                            }
                            return null;
                        }

                        @Override // com.bytedance.sdk.openadsdk.ISplashCardListener
                        public void onSplashClickEyeClose() {
                            Logger.e("TTMediationSDK", "穿山甲_splash_onSplashClickEyeClose");
                            if (((TTBaseAd) PangleSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                PangleSplashAd.this.b().onSplashClickEyeClose();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.ISplashCardListener
                        public void onSplashEyeReady() {
                            Logger.e("TTMediationSDK", "穿山甲_splash_onSplashEyeReady");
                            if (((TTBaseAd) PangleSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                PangleSplashAd.this.b().onSplashEyeReady();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.ISplashCardListener
                        public void setSupportSplashClickEye(boolean z2) {
                            Logger.e("TTMediationSDK", "穿山甲_splash_setSupportSplashClickEye");
                            if (((TTBaseAd) PangleSplashAd.this).mTTAdatperCallback instanceof ITTAdapterSplashAdListener) {
                                PangleSplashAd.this.b().setSupportSplashClickEye(z2);
                            }
                        }
                    });
                    PangleSplashAd pangleSplashAd3 = PangleSplashAd.this;
                    PangleSplashAdapter.this.notifyAdLoaded(pangleSplashAd3);
                    while (true) {
                        switch (34) {
                            case 32:
                                if ((30 * 30) - ((10 * 10) * 34) != -1) {
                                }
                                break;
                            case 34:
                                return;
                        }
                    }
                    if (((31 + 1) * 31) % 2 != 0) {
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:23:0x006c A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:26:0x000e A[SYNTHETIC] */
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
                @androidx.annotation.MainThread
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onTimeout() {
                    /*
                        r5 = this;
                        com.bytedance.msdk.adapter.pangle.PangleSplashAdapter$PangleSplashAd r0 = com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.this
                        com.bytedance.msdk.adapter.pangle.PangleSplashAdapter r0 = com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.this
                        com.bytedance.msdk.api.AdError r1 = new com.bytedance.msdk.api.AdError
                        java.lang.String r2 = "splash ad load timeout !"
                        r1.<init>(r2)
                        r0.notifyAdFailed(r1)
                    Le:
                        r0 = 12
                        r1 = 96
                        switch(r1) {
                            case 94: goto L1c;
                            case 95: goto L16;
                            case 96: goto L6c;
                            default: goto L15;
                        }
                    L15:
                        goto Le
                    L16:
                        switch(r0) {
                            case 94: goto L3a;
                            case 95: goto L54;
                            case 96: goto L6c;
                            default: goto L19;
                        }
                    L19:
                        r0 = 95
                        goto L16
                    L1c:
                        r0 = 1
                        r1 = 81
                        int r2 = 81 - r0
                        int r2 = r2 * 81
                        int r1 = r1 * 2
                        int r1 = r1 - r0
                        int r2 = r2 * r1
                        int r2 = r2 % 6
                        if (r2 == 0) goto L6c
                        r0 = 66
                        int r0 = r0 * r0
                        r1 = 16
                        int r1 = r1 * r1
                        int r1 = r1 * 34
                        int r0 = r0 - r1
                        r1 = -1
                        if (r0 != r1) goto L54
                    L3a:
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
                        if (r1 >= r4) goto L6c
                    L54:
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
                        if (r1 >= r4) goto Le
                    L6c:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.AnonymousClass2.onTimeout():void");
                }
            }, PangleSplashAdapter.this.b);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x00c9  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00e1 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00f1 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x010b A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x010b A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00db A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00db A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x00ab -> B:17:0x00db). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void a() {
            /*
                Method dump skipped, instruction units count: 298
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.a():void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            Map<String, Object> mediaExtraInfo;
            if (PangleSplashAdapter.this.a()) {
                TTSplashAd tTSplashAd = this.a;
                if (tTSplashAd != null) {
                    mediaExtraInfo = tTSplashAd.getMediaExtraInfo();
                    return PangleAdapterUtils.getAdId(mediaExtraInfo);
                }
                return super.getAdId();
            }
            CSJSplashAd cSJSplashAd = this.b;
            if (cSJSplashAd != null) {
                mediaExtraInfo = cSJSplashAd.getMediaExtraInfo();
                return PangleAdapterUtils.getAdId(mediaExtraInfo);
            }
            return super.getAdId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getCreativeId() {
            Map<String, Object> mediaExtraInfo;
            if (PangleSplashAdapter.this.a()) {
                TTSplashAd tTSplashAd = this.a;
                if (tTSplashAd != null) {
                    mediaExtraInfo = tTSplashAd.getMediaExtraInfo();
                    return PangleAdapterUtils.getCreativeId(mediaExtraInfo);
                }
                return super.getCreativeId();
            }
            CSJSplashAd cSJSplashAd = this.b;
            if (cSJSplashAd != null) {
                mediaExtraInfo = cSJSplashAd.getMediaExtraInfo();
                return PangleAdapterUtils.getCreativeId(mediaExtraInfo);
            }
            return super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> mediaExtraInfo;
            HashMap map;
            if (PangleSplashAdapter.this.a()) {
                TTSplashAd tTSplashAd = this.a;
                if (tTSplashAd != null && (mediaExtraInfo = tTSplashAd.getMediaExtraInfo()) != null) {
                    map = new HashMap();
                    map.put(PangleAdapterUtils.MEDIA_EXTRA_COUPON, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_COUPON));
                    map.put(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM));
                    map.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT));
                    return map;
                }
                return super.getMediaExtraInfo();
            }
            CSJSplashAd cSJSplashAd = this.b;
            if (cSJSplashAd != null && (mediaExtraInfo = cSJSplashAd.getMediaExtraInfo()) != null) {
                map = new HashMap();
                map.put(PangleAdapterUtils.MEDIA_EXTRA_COUPON, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_COUPON));
                map.put(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM));
                map.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT));
                return map;
            }
            return super.getMediaExtraInfo();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public int[] getMinWindowSize() {
            if (PangleSplashAdapter.this.a()) {
                TTSplashAd tTSplashAd = this.a;
                if (tTSplashAd != null) {
                    return tTSplashAd.getSplashClickEyeSizeToDp();
                }
                return null;
            }
            CSJSplashAd cSJSplashAd = this.b;
            if (cSJSplashAd != null) {
                return cSJSplashAd.getSplashClickEyeSizeToDp();
            }
            return null;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.bytedance.msdk.base.TTBaseAd
        public String getReqId() {
            Map<String, Object> mediaExtraInfo;
            char c2 = '7';
            char c3 = 0;
            while (true) {
                char c4 = 'H';
                while (true) {
                    switch (c4) {
                        case 'H':
                            c4 = 'I';
                            c3 = 16;
                            break;
                        case 'J':
                            while (true) {
                                switch (c3) {
                                    case '5':
                                        while (true) {
                                            switch (c2) {
                                                case 29:
                                                case 30:
                                                    break;
                                                case 31:
                                                    break;
                                                default:
                                                    c2 = 30;
                                                    break;
                                            }
                                        }
                                        break;
                                }
                            }
                            break;
                    }
                }
            }
            if (PangleSplashAdapter.this.a()) {
                TTSplashAd tTSplashAd = this.a;
                if (tTSplashAd != null) {
                    mediaExtraInfo = tTSplashAd.getMediaExtraInfo();
                    return PangleAdapterUtils.getReqId(mediaExtraInfo);
                }
                return super.getReqId();
            }
            CSJSplashAd cSJSplashAd = this.b;
            if (cSJSplashAd != null) {
                mediaExtraInfo = cSJSplashAd.getMediaExtraInfo();
                return PangleAdapterUtils.getReqId(mediaExtraInfo);
            }
            return super.getReqId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return PangleSplashAdapter.this.a() ? this.a == null : this.b == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            if (PangleSplashAdapter.this.a()) {
                TTSplashAd tTSplashAd = this.a;
                if (tTSplashAd != null) {
                    tTSplashAd.setSplashInteractionListener(null);
                    this.a.setDownloadListener(null);
                    this.a.renderExpressAd(null);
                    this.a = null;
                    return;
                }
                return;
            }
            CSJSplashAd cSJSplashAd = this.b;
            if (cSJSplashAd != null) {
                cSJSplashAd.setSplashAdListener(null);
                this.b.setDownloadListener(null);
                this.b.setSplashCardListener(null);
                this.b.setSplashClickEyeListener(null);
                this.b = null;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
        
            if ((((45 + 1) * 45) % 2) == 0) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:
        
            if (((61 * 61) - ((21 * 21) * 34)) != (-1)) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x007d, code lost:
        
            if (((((45 - 1) * 45) * ((45 * 2) - 1)) % 6) == 0) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0080, code lost:
        
            switch(r7) {
                case 57: goto L47;
                case 58: goto L38;
                case 59: goto L46;
                default: goto L47;
            };
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x009c, code lost:
        
            if ((((27 * 27) + (34 * 34)) + (17 * 17)) >= (((27 * 34) + (34 * 17)) + (27 * 17))) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00ad, code lost:
        
            if ((((12 * 12) + (37 * 37)) - ((12 * 37) * 2)) >= 0) goto L71;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0051 -> B:25:0x0054). Please report as a decompilation issue!!! */
        @Override // com.bytedance.msdk.base.TTBaseAd
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void showSplashAd(android.view.ViewGroup r7) {
            /*
                Method dump skipped, instruction units count: 220
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.PangleSplashAd.showSplashAd(android.view.ViewGroup):void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showSplashCardView(ViewGroup viewGroup, Activity activity) {
            CSJSplashAd cSJSplashAd = this.b;
            if (cSJSplashAd != null) {
                cSJSplashAd.showSplashCardView(viewGroup, activity);
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showSplashClickEyeView(ViewGroup viewGroup) {
            CSJSplashAd cSJSplashAd = this.b;
            if (cSJSplashAd != null) {
                cSJSplashAd.showSplashClickEyeView(viewGroup);
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void splashMinWindowAnimationFinish() {
            TTSplashAd tTSplashAd = this.a;
            if (tTSplashAd != null) {
                tTSplashAd.splashClickEyeAnimationFinish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        return !"0.0".equals(getSdkVersion()) && VERSION_4712.compareTo(getSdkVersion()) > 0;
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x003e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x005b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007d -> B:13:0x0038). Please report as a decompilation issue!!! */
    @Override // com.bytedance.msdk.adapter.ad.GMSplashBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadAd(android.content.Context r7, java.util.Map<java.lang.String, java.lang.Object> r8) {
        /*
            r6 = this;
            super.loadAd(r7, r8)
            r6.a = r7
            com.bytedance.msdk.api.v2.slot.GMAdSlotSplash r7 = r6.mGMAdSlotSplash
            if (r7 == 0) goto L8d
            if (r8 == 0) goto L90
            java.lang.String r7 = "ad_load_timeout"
            boolean r0 = r8.containsKey(r7)
            if (r0 == 0) goto L1e
            java.lang.Object r7 = r8.get(r7)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            goto L20
        L1e:
            int r7 = r6.b
        L20:
            r6.b = r7
            com.bytedance.msdk.adapter.pangle.PangleSplashAdapter$PangleSplashAd r7 = new com.bytedance.msdk.adapter.pangle.PangleSplashAdapter$PangleSplashAd
            r7.<init>()
            r6.f13996c = r7
            com.bytedance.msdk.adapter.pangle.PangleSplashAdapter$PangleSplashAd r7 = r6.f13996c
            r7.a()
        L2e:
            r7 = 70
            r8 = -1
            r0 = 1
            r1 = 34
            switch(r7) {
                case 70: goto L38;
                case 71: goto L38;
                case 72: goto L76;
                default: goto L37;
            }
        L37:
            goto L2e
        L38:
            r7 = 95
            switch(r7) {
                case 94: goto L5b;
                case 95: goto L90;
                case 96: goto L3e;
                default: goto L3d;
            }
        L3d:
            goto L4c
        L3e:
            r7 = 61
            int r7 = r7 * r7
            r0 = 21
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r7 = r7 - r0
            if (r7 != r8) goto L2e
            goto L90
        L4c:
            r7 = 38
            int r2 = 38 - r0
            int r2 = r2 * 38
            int r7 = r7 * 2
            int r7 = r7 - r0
            int r2 = r2 * r7
            int r2 = r2 % 6
            if (r2 == 0) goto L38
        L5b:
            r7 = 27
            int r2 = r7 * r7
            int r3 = r1 * r1
            int r2 = r2 + r3
            r3 = 17
            int r4 = r3 * r3
            int r2 = r2 + r4
            r4 = 27
            int r4 = r4 * 34
            r5 = 34
            int r5 = r5 * 17
            int r4 = r4 + r5
            int r7 = r7 * 17
            int r4 = r4 + r7
            if (r2 >= r4) goto L76
            goto L90
        L76:
            r7 = 10
            int r7 = r7 + r0
            int r7 = r7 * 10
            int r7 = r7 % 2
            if (r7 == 0) goto L80
            goto L38
        L80:
            r7 = 5
            int r7 = r7 * r7
            r0 = 28
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r7 = r7 - r0
            if (r7 != r8) goto L90
            goto L2e
        L8d:
            r6.notifyLoadFailBecauseGMAdSlotIsNull()
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleSplashAdapter.loadAd(android.content.Context, java.util.Map):void");
    }
}
