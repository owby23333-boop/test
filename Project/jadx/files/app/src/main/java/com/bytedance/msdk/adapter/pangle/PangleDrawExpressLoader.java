package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PangleDrawExpressLoader {

    private static class PangleDrawExpressAd extends TTBaseAd {
        private TTNativeExpressAd a;
        private boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        TTNativeExpressAd.ExpressAdInteractionListener f13968c = new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.2
            /* JADX WARN: Removed duplicated region for block: B:24:0x006f A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0011 A[SYNTHETIC] */
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onAdClicked(android.view.View r4, int r5) {
                /*
                    r3 = this;
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r4 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener r4 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.a(r4)
                    if (r4 == 0) goto L11
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r4 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener r4 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.b(r4)
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.AnonymousClass2.onAdClicked(android.view.View, int):void");
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x006f A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0011 A[SYNTHETIC] */
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onAdShow(android.view.View r4, int r5) {
                /*
                    r3 = this;
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r4 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener r4 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.m(r4)
                    if (r4 == 0) goto L11
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r4 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener r4 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.n(r4)
                    r4.onAdShow()
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.AnonymousClass2.onAdShow(android.view.View, int):void");
            }

            /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
            
                if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L43;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
            
                r5 = (((40 - 1) * 40) * ((40 * 2) - 1)) % 6;
             */
            /* JADX WARN: Code restructure failed: missing block: B:39:0x0015, code lost:
            
                continue;
             */
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onRenderFail(android.view.View r4, java.lang.String r5, int r6) {
                /*
                    r3 = this;
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.o(r0)
                    boolean r0 = r0 instanceof com.bytedance.msdk.api.v2.ad.draw.GMDrawExpressAdListener
                    if (r0 == 0) goto L70
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.p(r0)
                    com.bytedance.msdk.api.v2.ad.draw.GMDrawExpressAdListener r0 = (com.bytedance.msdk.api.v2.ad.draw.GMDrawExpressAdListener) r0
                    r0.onRenderFail(r4, r5, r6)
                L15:
                    r4 = 49
                    r5 = 60
                    r6 = 1
                    switch(r5) {
                        case 60: goto L1e;
                        case 61: goto L47;
                        case 62: goto L63;
                        default: goto L1d;
                    }
                L1d:
                    goto L15
                L1e:
                    switch(r4) {
                        case 49: goto L70;
                        case 50: goto L22;
                        case 51: goto L22;
                        default: goto L21;
                    }
                L21:
                    goto L47
                L22:
                    r4 = 87
                    int r5 = 87 - r6
                    int r5 = r5 * 87
                    int r4 = r4 * 2
                    int r4 = r4 - r6
                    int r5 = r5 * r4
                    int r5 = r5 % 6
                    if (r5 == 0) goto L32
                    goto L84
                L32:
                    r4 = 94
                    r5 = 94
                L36:
                    switch(r5) {
                        case 55: goto L3a;
                        case 56: goto L15;
                        case 57: goto L15;
                        default: goto L39;
                    }
                L39:
                    goto L44
                L3a:
                    r5 = 94
                    int r5 = r5 + r6
                    int r5 = r5 * 94
                    int r5 = r5 % 2
                    if (r5 == 0) goto L70
                    goto L15
                L44:
                    r5 = 56
                    goto L36
                L47:
                    r4 = 26
                    int r5 = r4 * r4
                    int r5 = r5 * 26
                    r0 = 9
                    int r1 = r0 * r0
                    int r1 = r1 * 9
                    int r5 = r5 + r1
                    r1 = 15
                    int r2 = r1 * r1
                    int r2 = r2 * 15
                    int r5 = r5 + r2
                    int r4 = r4 * 9
                    int r4 = r4 * 15
                    int r4 = r4 * 3
                    if (r5 >= r4) goto L70
                L63:
                    r4 = 40
                    int r5 = 40 - r6
                    int r5 = r5 * 40
                    int r4 = r4 * 2
                    int r4 = r4 - r6
                    int r5 = r5 * r4
                    int r5 = r5 % 6
                L70:
                    r4 = 53
                    switch(r4) {
                        case 52: goto L76;
                        case 53: goto L84;
                        case 54: goto L70;
                        default: goto L75;
                    }
                L75:
                    goto L70
                L76:
                    r4 = 13
                    int r4 = r4 * r4
                    r5 = 19
                    int r5 = r5 * r5
                    int r5 = r5 * 34
                    int r4 = r4 - r5
                    r5 = -1
                    if (r4 != r5) goto L76
                L84:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.AnonymousClass2.onRenderFail(android.view.View, java.lang.String, int):void");
            }

            /* JADX WARN: Code restructure failed: missing block: B:30:0x0081, code lost:
            
                if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L34;
             */
            /* JADX WARN: Code restructure failed: missing block: B:32:0x0090, code lost:
            
                if (((((40 - 1) * 40) * ((40 * 2) - 1)) % 6) == 0) goto L34;
             */
            /* JADX WARN: Removed duplicated region for block: B:42:0x0042 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:43:0x0067 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:44:0x0083 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:51:0x0039 A[SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0081 -> B:34:0x0093). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0090 -> B:34:0x0093). Please report as a decompilation issue!!! */
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onRenderSuccess(android.view.View r6, float r7, float r8) {
                /*
                    r5 = this;
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r6 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener r6 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.q(r6)
                    boolean r6 = r6 instanceof com.bytedance.msdk.api.v2.ad.draw.GMDrawExpressAdListener
                    r0 = 53
                    r1 = 94
                    if (r6 == 0) goto L37
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r6 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener r6 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.r(r6)
                    com.bytedance.msdk.api.v2.ad.draw.GMDrawExpressAdListener r6 = (com.bytedance.msdk.api.v2.ad.draw.GMDrawExpressAdListener) r6
                    r6.onRenderSuccess(r7, r8)
                L19:
                    r6 = -1
                    switch(r0) {
                        case 52: goto L2c;
                        case 53: goto L93;
                        case 54: goto L1e;
                        default: goto L1d;
                    }
                L1d:
                    goto L19
                L1e:
                    r7 = 61
                    int r7 = r7 * r7
                    r8 = 12
                    int r8 = r8 * r8
                    int r8 = r8 * 34
                    int r7 = r7 - r8
                    if (r7 != r6) goto L19
                    goto L93
                L2c:
                    r7 = 19
                    int r7 = r7 * r7
                    int r7 = r7 * 34
                    int r7 = 169 - r7
                    if (r7 != r6) goto L2c
                    goto L93
                L37:
                    r6 = 94
                L39:
                    r7 = 49
                    r8 = 60
                    r2 = 1
                    switch(r8) {
                        case 60: goto L42;
                        case 61: goto L67;
                        case 62: goto L83;
                        default: goto L41;
                    }
                L41:
                    goto L39
                L42:
                    switch(r7) {
                        case 49: goto L92;
                        case 50: goto L46;
                        case 51: goto L46;
                        default: goto L45;
                    }
                L45:
                    goto L67
                L46:
                    r7 = 87
                    int r8 = 87 - r2
                    int r8 = r8 * 87
                    int r7 = r7 * 2
                    int r7 = r7 - r2
                    int r8 = r8 * r7
                    int r8 = r8 % 6
                    if (r8 == 0) goto L56
                    goto L92
                L56:
                    switch(r6) {
                        case 55: goto L5a;
                        case 56: goto L39;
                        case 57: goto L39;
                        default: goto L59;
                    }
                L59:
                    goto L64
                L5a:
                    r7 = 94
                    int r7 = r7 + r2
                    int r7 = r7 * 94
                    int r7 = r7 % 2
                    if (r7 == 0) goto L92
                    goto L39
                L64:
                    r6 = 56
                    goto L56
                L67:
                    r6 = 26
                    int r7 = r6 * r6
                    int r7 = r7 * 26
                    r8 = 9
                    int r3 = r8 * r8
                    int r3 = r3 * 9
                    int r7 = r7 + r3
                    r3 = 15
                    int r4 = r3 * r3
                    int r4 = r4 * 15
                    int r7 = r7 + r4
                    int r6 = r6 * 9
                    int r6 = r6 * 15
                    int r6 = r6 * 3
                    if (r7 >= r6) goto L93
                L83:
                    r6 = 40
                    int r7 = 40 - r2
                    int r7 = r7 * 40
                    int r6 = r6 * 2
                    int r6 = r6 - r2
                    int r7 = r7 * r6
                    int r7 = r7 % 6
                    if (r7 == 0) goto L93
                L92:
                    return
                L93:
                    r6 = 53
                    goto L39
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.AnonymousClass2.onRenderSuccess(android.view.View, float, float):void");
            }
        };

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TTNativeExpressAd.ExpressVideoAdListener f13969d = new TTNativeExpressAd.ExpressVideoAdListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.3
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onClickRetry() {
                while (true) {
                    char c2 = '^';
                    char c3 = 'K';
                    while (true) {
                        switch (c2) {
                            case '\\':
                                switch (c3) {
                                    case 22:
                                    case 23:
                                        c2 = ']';
                                        c3 = ']';
                                        break;
                                }
                                break;
                            case ']':
                                break;
                            case '^':
                            default:
                                c2 = ']';
                                c3 = ']';
                                break;
                        }
                        return;
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
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.i(r0)
                    if (r0 == 0) goto L11
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.j(r0)
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.AnonymousClass3.onProgressUpdate(long, long):void");
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
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.k(r0)
                    if (r0 == 0) goto L11
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.l(r0)
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.AnonymousClass3.onVideoAdComplete():void");
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
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.g(r0)
                    if (r0 == 0) goto L11
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.h(r0)
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.AnonymousClass3.onVideoAdContinuePlay():void");
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
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.e(r0)
                    if (r0 == 0) goto L11
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.f(r0)
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.AnonymousClass3.onVideoAdPaused():void");
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
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.c(r0)
                    if (r0 == 0) goto L11
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.d(r0)
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.AnonymousClass3.onVideoAdStartPlay():void");
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
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.s(r0)
                    if (r0 == 0) goto L92
                    com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$PangleDrawExpressAd r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.this
                    com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener r0 = com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.t(r0)
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
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.AnonymousClass3.onVideoError(int, int):void");
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public void onVideoLoad() {
            }
        };

        PangleDrawExpressAd(TTNativeExpressAd tTNativeExpressAd, boolean z2) {
            Map<String, Object> mediaExtraInfo;
            this.a = tTNativeExpressAd;
            this.b = z2;
            setImageMode(this.a.getImageMode());
            setInteractionType(this.a.getInteractionType());
            setExpressAd(true);
            this.a.setExpressInteractionListener(this.f13968c);
            this.a.setVideoAdListener(this.f13969d);
            if (this.b && (mediaExtraInfo = tTNativeExpressAd.getMediaExtraInfo()) != null) {
                double value = PangleAdapterUtils.getValue(mediaExtraInfo.get("price"));
                Logger.d("TTMediationSDK_ECMP", "pangle 模板draw 返回的 cpm价格：" + value);
                setCpm(value <= PangleAdapterUtils.CPM_DEFLAUT_VALUE ? 0.0d : value);
            }
            putExtraMsg(GMAdConstant.EXTRA_ADID, Long.valueOf(getAdId()));
            putExtraMsg(GMAdConstant.EXTRA_CID, Long.valueOf(getCreativeId()));
            Map<String, Object> mediaExtraInfo2 = this.a.getMediaExtraInfo();
            if (mediaExtraInfo2 != null) {
                putExtraMsg("log_extra", mediaExtraInfo2.toString());
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            return tTNativeExpressAd != null ? PangleAdapterUtils.getAdId(tTNativeExpressAd.getMediaExtraInfo()) : super.getAdId();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0065 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0009 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0009 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0053 -> B:12:0x0018). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0096 -> B:24:0x0065). Please report as a decompilation issue!!! */
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
                r0 = 125(0x7d, float:1.75E-43)
                r1 = 94
                r2 = 15
                switch(r1) {
                    case 94: goto L9a;
                    case 95: goto L13;
                    case 96: goto L61;
                    default: goto L12;
                }
            L12:
                goto L9
            L13:
                r1 = 4
                switch(r0) {
                    case 94: goto L18;
                    case 95: goto L2f;
                    case 96: goto L47;
                    default: goto L17;
                }
            L17:
                goto L61
            L18:
                r0 = 70
                int r3 = r0 * r0
                r4 = 7
                int r5 = r4 * r4
                int r3 = r3 + r5
                int r5 = r1 * r1
                int r3 = r3 + r5
                r5 = 70
                int r5 = r5 * 7
                int r4 = r4 * 4
                int r5 = r5 + r4
                int r0 = r0 * 4
                int r5 = r5 + r0
                if (r3 >= r5) goto L56
            L2f:
                r0 = 69
                int r3 = r0 * r0
                r4 = 20
                int r5 = r4 * r4
                int r3 = r3 + r5
                int r5 = r1 * r1
                int r3 = r3 + r5
                r5 = 69
                int r5 = r5 * 20
                int r4 = r4 * 4
                int r5 = r5 + r4
                int r0 = r0 * 4
                int r5 = r5 + r0
                if (r3 >= r5) goto L9
            L47:
                r0 = 18
                int r0 = r0 * r0
                r3 = 35
                int r3 = r3 * r3
                int r3 = r3 * 34
                int r0 = r0 - r3
                r3 = -1
                if (r0 != r3) goto L18
                goto L65
            L56:
                r0 = 39
                int r0 = r0 + 1
                int r0 = r0 * 39
                int r0 = r0 % 2
                if (r0 == 0) goto L9
                goto L18
            L61:
                switch(r0) {
                    case 55: goto L65;
                    case 56: goto L7f;
                    case 57: goto L8e;
                    default: goto L64;
                }
            L64:
                goto L9a
            L65:
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
                if (r1 >= r0) goto L9
            L7f:
                r0 = 80
                int r1 = r0 * r0
                r3 = 0
                int r4 = r3 * r3
                int r1 = r1 + r4
                int r1 = r1 + r4
                int r0 = r0 * 0
                int r4 = r4 + r0
                int r4 = r4 + r0
                if (r1 >= r4) goto L9
            L8e:
                r0 = 15
                int r0 = r0 + 1
                int r0 = r0 * 15
                int r0 = r0 % 2
                if (r0 == 0) goto L65
                goto L9
            L9a:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.getAdView():android.view.View");
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
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.getReqId():java.lang.String");
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
            TTNativeExpressAd tTNativeExpressAd = this.a;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.destroy();
                this.a = null;
            }
            super.onDestroy();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
        
            if (((18 * 18) - ((35 * 35) * 34)) == (-1)) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0007, code lost:
        
            continue;
         */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0074 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0071 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x006f -> B:19:0x0043). Please report as a decompilation issue!!! */
        @Override // com.bytedance.msdk.base.TTBaseAd
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void render() {
            /*
                r6 = this;
                com.bytedance.sdk.openadsdk.TTNativeExpressAd r0 = r6.a
                if (r0 == 0) goto L74
                r0.render()
            L7:
                r0 = 15
                r1 = 15
            Lb:
                r2 = 12
                r3 = 95
                switch(r1) {
                    case 13: goto L7;
                    case 14: goto L74;
                    case 15: goto L13;
                    default: goto L12;
                }
            L12:
                goto L71
            L13:
                switch(r3) {
                    case 94: goto L26;
                    case 95: goto L71;
                    case 96: goto L17;
                    default: goto L16;
                }
            L16:
                goto L3f
            L17:
                r1 = 18
                int r1 = r1 * r1
                r2 = 35
                int r2 = r2 * r2
                int r2 = r2 * 34
                int r1 = r1 - r2
                r2 = -1
                if (r1 != r2) goto L26
                goto L43
            L26:
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
                if (r2 >= r5) goto L7
                goto L71
            L3f:
                switch(r2) {
                    case 55: goto L43;
                    case 56: goto L5d;
                    case 57: goto L67;
                    default: goto L42;
                }
            L42:
                goto L7
            L43:
                r1 = 26
                int r2 = r1 * r1
                int r2 = r2 * 26
                r3 = 9
                int r4 = r3 * r3
                int r4 = r4 * 9
                int r2 = r2 + r4
                int r4 = r0 * r0
                int r4 = r4 * 15
                int r2 = r2 + r4
                int r1 = r1 * 9
                int r1 = r1 * 15
                int r1 = r1 * 3
                if (r2 >= r1) goto L74
            L5d:
                r1 = 90
                int r1 = r1 + 1
                int r1 = r1 * 90
                int r1 = r1 % 2
                if (r1 == 0) goto L71
            L67:
                r1 = 15
                int r1 = r1 + 1
                int r1 = r1 * 15
                int r1 = r1 % 2
                if (r1 == 0) goto L43
            L71:
                r1 = 14
                goto Lb
            L74:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.render():void");
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void setDislikeCallback(Activity activity, final GMDislikeCallback gMDislikeCallback) {
            TTNativeExpressAd tTNativeExpressAd = this.a;
            if (tTNativeExpressAd != null) {
                tTNativeExpressAd.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback(this) { // from class: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.PangleDrawExpressAd.1
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
    public void loadAd(android.content.Context r2, final boolean r3, com.bytedance.sdk.openadsdk.TTAdNative r4, com.bytedance.sdk.openadsdk.AdSlot r5, final com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter r6) {
        /*
            r1 = this;
            if (r4 == 0) goto L84
            if (r6 != 0) goto L6
            goto L84
        L6:
            r2 = 1444(0x5a4, float:2.023E-42)
            com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$1 r0 = new com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader$1
            r0.<init>(r1)
            r4.loadExpressDrawFeedAd(r5, r0)
        L10:
            r3 = 95
            r4 = 7
            switch(r3) {
                case 94: goto L35;
                case 95: goto L2f;
                case 96: goto L17;
                default: goto L16;
            }
        L16:
            goto L10
        L17:
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
            if (r3 >= r6) goto L10
            goto L35
        L2f:
            r2 = 96
            switch(r2) {
                case 94: goto L53;
                case 95: goto L6d;
                case 96: goto L84;
                default: goto L34;
            }
        L34:
            goto L2f
        L35:
            r2 = 1
            r3 = 81
            int r5 = 81 - r2
            int r5 = r5 * 81
            int r3 = r3 * 2
            int r3 = r3 - r2
            int r5 = r5 * r3
            int r5 = r5 % 6
            if (r5 == 0) goto L84
            r2 = 66
            int r2 = r2 * r2
            r3 = 16
            int r3 = r3 * r3
            int r3 = r3 * 34
            int r2 = r2 - r3
            r3 = -1
            if (r2 != r3) goto L6d
        L53:
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
            if (r3 >= r0) goto L84
        L6d:
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
            if (r3 >= r6) goto L84
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleDrawExpressLoader.loadAd(android.content.Context, boolean, com.bytedance.sdk.openadsdk.TTAdNative, com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter):void");
    }
}
