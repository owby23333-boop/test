package com.bytedance.msdk.adapter.pangle;

import android.content.Context;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.ad.GMFullVideoBaseAdapter;
import com.bytedance.msdk.adapter.listener.ITTAdapterFullVideoAdListener;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PangleFullVideoAdapter extends GMFullVideoBaseAdapter {
    public static final String TAG = "PangleFullVideoAdapter";
    private Context a;

    class PangleFullVideoAd extends TTBaseAd {
        private TTFullScreenVideoAd a;
        private boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f13972c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TTAdNative.FullScreenVideoAdListener f13973d = new TTAdNative.FullScreenVideoAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.PangleFullVideoAd.1
            /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x0070 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0012 A[SYNTHETIC] */
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onError(int r5, java.lang.String r6) {
                /*
                    r4 = this;
                    com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter$PangleFullVideoAd r0 = com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.PangleFullVideoAd.this
                    r1 = 0
                    com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.PangleFullVideoAd.a(r0, r1)
                    com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter$PangleFullVideoAd r0 = com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.PangleFullVideoAd.this
                    com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter r0 = com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.this
                    com.bytedance.msdk.api.AdError r1 = new com.bytedance.msdk.api.AdError
                    r1.<init>(r5, r6)
                    r0.notifyAdFailed(r1)
                L12:
                    r5 = 12
                    r6 = 96
                    r0 = 4
                    r1 = 20
                    switch(r6) {
                        case 94: goto L23;
                        case 95: goto L1d;
                        case 96: goto L89;
                        default: goto L1c;
                    }
                L1c:
                    goto L12
                L1d:
                    switch(r5) {
                        case 94: goto L41;
                        case 95: goto L59;
                        case 96: goto L70;
                        default: goto L20;
                    }
                L20:
                    r5 = 95
                    goto L1d
                L23:
                    r5 = 1
                    r6 = 81
                    int r2 = 81 - r5
                    int r2 = r2 * 81
                    int r6 = r6 * 2
                    int r6 = r6 - r5
                    int r2 = r2 * r6
                    int r2 = r2 % 6
                    if (r2 == 0) goto L12
                    r5 = 66
                    int r5 = r5 * r5
                    r6 = 16
                    int r6 = r6 * r6
                    int r6 = r6 * 34
                    int r5 = r5 - r6
                    r6 = -1
                    if (r5 != r6) goto L59
                L41:
                    r5 = 29
                    int r6 = r5 * r5
                    r2 = 45
                    int r3 = r2 * r2
                    int r6 = r6 + r3
                    int r3 = r1 * r1
                    int r6 = r6 + r3
                    r3 = 29
                    int r3 = r3 * 45
                    int r2 = r2 * 20
                    int r3 = r3 + r2
                    int r5 = r5 * 20
                    int r3 = r3 + r5
                    if (r6 >= r3) goto L70
                L59:
                    r5 = 70
                    int r6 = r5 * r5
                    r2 = 7
                    int r3 = r2 * r2
                    int r6 = r6 + r3
                    int r3 = r0 * r0
                    int r6 = r6 + r3
                    r3 = 70
                    int r3 = r3 * 7
                    int r2 = r2 * 4
                    int r3 = r3 + r2
                    int r5 = r5 * 4
                    int r3 = r3 + r5
                    if (r6 >= r3) goto L12
                L70:
                    r5 = 69
                    int r6 = r5 * r5
                    int r2 = r1 * r1
                    int r6 = r6 + r2
                    int r2 = r0 * r0
                    int r6 = r6 + r2
                    r2 = 69
                    int r2 = r2 * 20
                    r1 = 20
                    int r1 = r1 * 4
                    int r2 = r2 + r1
                    int r5 = r5 * 4
                    int r2 = r2 + r5
                    if (r6 >= r2) goto L89
                    goto L12
                L89:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.PangleFullVideoAd.AnonymousClass1.onError(int, java.lang.String):void");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
                if (tTFullScreenVideoAd != null) {
                    PangleFullVideoAd.this.a = tTFullScreenVideoAd;
                    PangleFullVideoAd.this.setExpressAd(true);
                    PangleFullVideoAd pangleFullVideoAd = PangleFullVideoAd.this;
                    pangleFullVideoAd.setInteractionType(pangleFullVideoAd.a.getInteractionType());
                    Map<String, Object> mediaExtraInfo = PangleFullVideoAd.this.a.getMediaExtraInfo();
                    if (PangleFullVideoAdapter.this.isClientBidding() && mediaExtraInfo != null) {
                        double value = PangleAdapterUtils.getValue(mediaExtraInfo.get("price"));
                        Logger.d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(PangleFullVideoAdapter.this.getAdapterRit(), PangleFullVideoAdapter.this.getAdSlotId()) + "pangle 全屏 返回的 cpm价格：" + value);
                        PangleFullVideoAd pangleFullVideoAd2 = PangleFullVideoAd.this;
                        if (value <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                            value = 0.0d;
                        }
                        pangleFullVideoAd2.setCpm(value);
                    }
                    if (mediaExtraInfo != null) {
                        Object obj = mediaExtraInfo.get("materialMetaIsFromPreload");
                        if (obj instanceof Boolean) {
                            PangleFullVideoAd.this.f13972c = ((Boolean) obj).booleanValue();
                            Logger.d("TTMediationSDK", "pangle 全屏 返回的adnPreload：" + PangleFullVideoAd.this.f13972c);
                        }
                    }
                    PangleFullVideoAd.this.a.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.PangleFullVideoAd.1.1
                        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onAdClose() {
                            if (((TTBaseAd) PangleFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                                PangleFullVideoAd.this.a().onFullVideoAdClosed();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onAdShow() {
                            if (((TTBaseAd) PangleFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                                PangleFullVideoAd.this.a().onFullVideoAdShow();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onAdVideoBarClick() {
                            if (((TTBaseAd) PangleFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                                PangleFullVideoAd.this.a().onFullVideoAdClick();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onSkippedVideo() {
                            if (((TTBaseAd) PangleFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                                PangleFullVideoAd.this.a().onSkippedVideo();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onVideoComplete() {
                            if (((TTBaseAd) PangleFullVideoAd.this).mTTAdatperCallback instanceof ITTAdapterFullVideoAdListener) {
                                PangleFullVideoAd.this.a().onVideoComplete();
                            }
                        }
                    });
                    PangleFullVideoAd.this.b = true;
                    PangleFullVideoAd pangleFullVideoAd3 = PangleFullVideoAd.this;
                    PangleFullVideoAdapter.this.notifyAdLoaded(pangleFullVideoAd3);
                    return;
                }
                PangleFullVideoAdapter.this.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                while (true) {
                    switch (23) {
                        case 21:
                            if (((33 + 1) * 33) % 2 != 0) {
                                return;
                            }
                            break;
                        case 22:
                        case 23:
                            return;
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached() {
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Removed duplicated region for block: B:20:0x004e A[FALL_THROUGH] */
            /* JADX WARN: Removed duplicated region for block: B:22:0x004d A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
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
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onFullScreenVideoCached(com.bytedance.sdk.openadsdk.TTFullScreenVideoAd r4) {
                /*
                    r3 = this;
                    com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter$PangleFullVideoAd r4 = com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.PangleFullVideoAd.this
                    r0 = 1
                    com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.PangleFullVideoAd.a(r4, r0)
                    com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter$PangleFullVideoAd r4 = com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.PangleFullVideoAd.this
                    com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter r1 = com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.this
                    r2 = 0
                    r1.notifyAdVideoCache(r4, r2)
                Le:
                    r4 = 73
                    r1 = 96
                L12:
                    switch(r4) {
                        case 72: goto L4e;
                        case 73: goto L16;
                        case 74: goto L19;
                        default: goto L15;
                    }
                L15:
                    goto L53
                L16:
                    switch(r1) {
                        case 94: goto Le;
                        case 95: goto L1d;
                        case 96: goto L4e;
                        default: goto L19;
                    }
                L19:
                    switch(r1) {
                        case 55: goto L4d;
                        case 56: goto L4d;
                        case 57: goto L1d;
                        default: goto L1c;
                    }
                L1c:
                    goto Le
                L1d:
                    r4 = 18
                    switch(r0) {
                        case 60: goto L23;
                        case 61: goto L31;
                        case 62: goto L40;
                        default: goto L22;
                    }
                L22:
                    goto L4e
                L23:
                    r1 = 0
                    int r2 = 0 - r0
                    int r2 = r2 * 0
                    int r1 = r1 * 2
                    int r1 = r1 - r0
                    int r2 = r2 * r1
                    int r2 = r2 % 6
                    if (r2 == 0) goto L4d
                L31:
                    int r1 = 18 - r0
                    int r1 = r1 * 18
                    r2 = 18
                    int r2 = r2 * 2
                    int r2 = r2 - r0
                    int r1 = r1 * r2
                    int r1 = r1 % 6
                    if (r1 == 0) goto L4d
                L40:
                    r1 = 99
                    int r1 = r1 * r1
                    int r4 = r4 * r4
                    int r4 = r4 * 34
                    int r1 = r1 - r4
                    r4 = -1
                    if (r1 != r4) goto L4d
                    goto L4e
                L4d:
                    return
                L4e:
                    r4 = 74
                    r1 = 55
                    goto L12
                L53:
                    r4 = 72
                    goto L12
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.PangleFullVideoAd.AnonymousClass1.onFullScreenVideoCached(com.bytedance.sdk.openadsdk.TTFullScreenVideoAd):void");
            }
        };

        PangleFullVideoAd() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ITTAdapterFullVideoAdListener a() {
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
            return (ITTAdapterFullVideoAdListener) this.mTTAdatperCallback;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean adnHasAdVideoCachedApi() {
            return true;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.a;
            return tTFullScreenVideoAd != null ? PangleAdapterUtils.getAdId(tTFullScreenVideoAd.getMediaExtraInfo()) : super.getAdId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getCreativeId() {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.a;
            return tTFullScreenVideoAd != null ? PangleAdapterUtils.getCreativeId(tTFullScreenVideoAd.getMediaExtraInfo()) : super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> mediaExtraInfo;
            TTFullScreenVideoAd tTFullScreenVideoAd = this.a;
            if (tTFullScreenVideoAd == null || (mediaExtraInfo = tTFullScreenVideoAd.getMediaExtraInfo()) == null) {
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
                com.bytedance.sdk.openadsdk.TTFullScreenVideoAd r0 = r5.a
                if (r0 == 0) goto L6b
                java.util.Map r0 = r0.getMediaExtraInfo()
                java.lang.String r0 = com.bytedance.msdk.adapter.pangle.PangleAdapterUtils.getReqId(r0)
                return r0
            L6b:
                java.lang.String r0 = super.getReqId()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.PangleFullVideoAd.getReqId():java.lang.String");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isAdnPreload() {
            return this.f13972c;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMAdConstant.AdIsReadyStatus isReadyStatus() {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.a;
            return (tTFullScreenVideoAd == null || tTFullScreenVideoAd.getExpirationTimestamp() <= System.currentTimeMillis()) ? GMAdConstant.AdIsReadyStatus.AD_IS_EXPIRED : GMAdConstant.AdIsReadyStatus.AD_IS_READY;
        }

        public void loadAd() {
            TTAdNative tTAdNativeCreateAdNative = TTAdSdk.getAdManager().createAdNative(PangleFullVideoAdapter.this.a);
            AdSlot adSlot = ((TTAbsAdLoaderAdapter) PangleFullVideoAdapter.this).mAdSlot;
            PangleFullVideoAdapter pangleFullVideoAdapter = PangleFullVideoAdapter.this;
            AdSlot.Builder builderBuildPangleAdSlot = PangleAdapterUtils.buildPangleAdSlot(adSlot, pangleFullVideoAdapter.mGMAdSlotFullVideo, pangleFullVideoAdapter.getAdSlotId(), ((TTAbsAdLoaderAdapter) PangleFullVideoAdapter.this).mWaterfallAbTestParam, PangleFullVideoAdapter.this.getClientReqId(), PangleFullVideoAdapter.this.getAdm(), false);
            builderBuildPangleAdSlot.setImageAcceptedSize(DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED, 1920).setOrientation(PangleFullVideoAdapter.this.mGMAdSlotFullVideo.getOrientation());
            tTAdNativeCreateAdNative.loadFullScreenVideoAd(builderBuildPangleAdSlot.build(), this.f13973d);
            while (true) {
                switch (42) {
                    case 40:
                    case 42:
                        return;
                    case 41:
                        int i2 = ((37 + 1) * 37) % 2;
                        return;
                }
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.a;
            if (tTFullScreenVideoAd != null) {
                tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(null);
                this.a.setDownloadListener(null);
                this.a = null;
            }
        }

        /* JADX WARN: Path cross not found for [B:4:0x0006, B:44:?], limit reached: 42 */
        /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x002d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x003b A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0052 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:36:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:37:? A[LOOP:0: B:13:0x0027->B:37:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0023 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0084 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:44:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:45:? A[LOOP:2: B:8:0x001b->B:45:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0079 -> B:13:0x0027). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0092 -> B:16:0x002d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0092 -> B:8:0x001b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x001f -> B:13:0x0027). Please report as a decompilation issue!!! */
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
        public void showAd(android.app.Activity r4, java.util.Map<com.bytedance.msdk.api.TTAdConstant.GroMoreExtraKey, java.lang.Object> r5) {
            /*
                r3 = this;
                com.bytedance.sdk.openadsdk.TTFullScreenVideoAd r0 = r3.a
                r1 = 15
                if (r0 == 0) goto L1b
                com.bytedance.sdk.openadsdk.TTAdConstant$RitScenes r0 = com.bytedance.msdk.adapter.pangle.PangleAdapterUtils.getRitScenes(r5)
                java.lang.String r5 = com.bytedance.msdk.adapter.pangle.PangleAdapterUtils.getCustomRitScenes(r5)
                if (r0 == 0) goto L16
                com.bytedance.sdk.openadsdk.TTFullScreenVideoAd r2 = r3.a
                r2.showFullScreenVideoAd(r4, r0, r5)
                goto L27
            L16:
                com.bytedance.sdk.openadsdk.TTFullScreenVideoAd r5 = r3.a
                r5.showFullScreenVideoAd(r4)
            L1b:
                r4 = 51
                r5 = 96
                switch(r5) {
                    case 95: goto L27;
                    case 96: goto L23;
                    case 97: goto L84;
                    default: goto L22;
                }
            L22:
                goto L1b
            L23:
                switch(r4) {
                    case 49: goto L6c;
                    case 50: goto L7b;
                    case 51: goto L83;
                    default: goto L26;
                }
            L26:
                goto L84
            L27:
                r4 = 61
                switch(r4) {
                    case 60: goto L2d;
                    case 61: goto L3b;
                    case 62: goto L52;
                    default: goto L2c;
                }
            L2c:
                goto L27
            L2d:
                r4 = 18
                int r4 = r4 * r4
                r5 = 35
                int r5 = r5 * r5
                int r5 = r5 * 34
                int r4 = r4 - r5
                r5 = -1
                if (r4 != r5) goto L84
            L3b:
                r4 = 54
                switch(r4) {
                    case 52: goto L41;
                    case 53: goto L1b;
                    case 54: goto L1b;
                    default: goto L40;
                }
            L40:
                goto L3b
            L41:
                r4 = 69
                int r5 = r4 * r4
                r0 = 22
                int r2 = r0 * r0
                int r5 = r5 + r2
                int r4 = r4 * 22
                int r4 = r4 * 2
                int r5 = r5 - r4
                if (r5 >= 0) goto L52
                goto L1b
            L52:
                r4 = 26
                int r5 = r4 * r4
                int r5 = r5 * 26
                r0 = 9
                int r2 = r0 * r0
                int r2 = r2 * 9
                int r5 = r5 + r2
                int r2 = r1 * r1
                int r2 = r2 * 15
                int r5 = r5 + r2
                int r4 = r4 * 9
                int r4 = r4 * 15
                int r4 = r4 * 3
                if (r5 >= r4) goto L83
            L6c:
                r4 = 80
                int r5 = r4 * r4
                r0 = 0
                int r2 = r0 * r0
                int r5 = r5 + r2
                int r5 = r5 + r2
                int r4 = r4 * 0
                int r2 = r2 + r4
                int r2 = r2 + r4
                if (r5 >= r2) goto L27
            L7b:
                r4 = 15
                int r4 = r4 + 1
                int r4 = r4 * 15
                int r4 = r4 % 2
            L83:
                return
            L84:
                r4 = 70
                int r5 = r4 * r4
                r0 = 44
                int r2 = r0 * r0
                int r5 = r5 + r2
                int r4 = r4 * 44
                int r4 = r4 * 2
                int r5 = r5 - r4
                if (r5 >= 0) goto L1b
                goto L2d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.PangleFullVideoAd.showAd(android.app.Activity, java.util.Map):void");
        }
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

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0013, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0061 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0013 A[SYNTHETIC] */
    @Override // com.bytedance.msdk.adapter.ad.GMFullVideoBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadAd(android.content.Context r5, java.util.Map<java.lang.String, java.lang.Object> r6) {
        /*
            r4 = this;
            super.loadAd(r5, r6)
            com.bytedance.msdk.api.v2.slot.GMAdSlotFullVideo r0 = r4.mGMAdSlotFullVideo
            if (r0 == 0) goto L90
            r4.a = r5
            if (r6 == 0) goto L93
            com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter$PangleFullVideoAd r5 = new com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter$PangleFullVideoAd
            r5.<init>()
            r5.loadAd()
        L13:
            r5 = 49
            r6 = 60
            r0 = 1
            switch(r6) {
                case 60: goto L1c;
                case 61: goto L45;
                case 62: goto L61;
                default: goto L1b;
            }
        L1b:
            goto L13
        L1c:
            switch(r5) {
                case 49: goto L70;
                case 50: goto L20;
                case 51: goto L20;
                default: goto L1f;
            }
        L1f:
            goto L45
        L20:
            r5 = 87
            int r6 = 87 - r0
            int r6 = r6 * 87
            int r5 = r5 * 2
            int r5 = r5 - r0
            int r6 = r6 * r5
            int r6 = r6 % 6
            if (r6 == 0) goto L30
            goto L70
        L30:
            r5 = 94
            r6 = 94
        L34:
            switch(r6) {
                case 55: goto L38;
                case 56: goto L13;
                case 57: goto L13;
                default: goto L37;
            }
        L37:
            goto L42
        L38:
            r6 = 94
            int r6 = r6 + r0
            int r6 = r6 * 94
            int r6 = r6 % 2
            if (r6 == 0) goto L70
            goto L13
        L42:
            r6 = 56
            goto L34
        L45:
            r5 = 26
            int r6 = r5 * r5
            int r6 = r6 * 26
            r1 = 9
            int r2 = r1 * r1
            int r2 = r2 * 9
            int r6 = r6 + r2
            r2 = 15
            int r3 = r2 * r2
            int r3 = r3 * 15
            int r6 = r6 + r3
            int r5 = r5 * 9
            int r5 = r5 * 15
            int r5 = r5 * 3
            if (r6 >= r5) goto L13
        L61:
            r5 = 40
            int r6 = 40 - r0
            int r6 = r6 * 40
            int r5 = r5 * 2
            int r5 = r5 - r0
            int r6 = r6 * r5
            int r6 = r6 % 6
            if (r6 == 0) goto L93
        L70:
            r5 = 53
            r6 = -1
            switch(r5) {
                case 52: goto L85;
                case 53: goto L93;
                case 54: goto L77;
                default: goto L76;
            }
        L76:
            goto L70
        L77:
            r5 = 61
            int r5 = r5 * r5
            r0 = 12
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r5 = r5 - r0
            if (r5 != r6) goto L70
            goto L93
        L85:
            r5 = 19
            int r5 = r5 * r5
            int r5 = r5 * 34
            int r5 = 169 - r5
            if (r5 != r6) goto L85
            goto L93
        L90:
            r4.notifyLoadFailBecauseGMAdSlotIsNull()
        L93:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleFullVideoAdapter.loadAd(android.content.Context, java.util.Map):void");
    }
}
