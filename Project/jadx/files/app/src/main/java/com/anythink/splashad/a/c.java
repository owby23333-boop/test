package com.anythink.splashad.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.d.i;
import com.anythink.basead.ui.ThirdPartySplashAdView;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.ATMediationRequestInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.l;
import com.anythink.core.common.b.n;
import com.anythink.core.common.h;
import com.anythink.core.common.j;
import com.anythink.core.common.k.s;
import com.anythink.core.common.v;
import com.anythink.splashad.api.ATSplashSkipAdListener;
import com.anythink.splashad.api.ATSplashSkipInfo;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.anythink.core.common.f<g> {
    d a;

    /* JADX INFO: renamed from: com.anythink.splashad.a.c$2, reason: invalid class name */
    final class AnonymousClass2 implements l {
        final /* synthetic */ boolean[] a;
        final /* synthetic */ f b;

        AnonymousClass2(boolean[] zArr, f fVar) {
            this.a = zArr;
            this.b = fVar;
        }

        @Override // com.anythink.core.common.b.l
        public final void onAdClicked(View view) {
            this.b.onSplashAdClicked();
        }

        @Override // com.anythink.core.common.b.l
        public final void onAdDislikeButtonClick() {
        }

        @Override // com.anythink.core.common.b.l
        public final void onAdImpressed() {
            boolean[] zArr = this.a;
            if (zArr[0]) {
                return;
            }
            zArr[0] = true;
            this.b.onSplashAdShow();
        }

        @Override // com.anythink.core.common.b.l
        public final void onAdVideoEnd() {
        }

        @Override // com.anythink.core.common.b.l
        public final void onAdVideoProgress(int i2) {
        }

        @Override // com.anythink.core.common.b.l
        public final void onAdVideoStart() {
        }

        @Override // com.anythink.core.common.b.l
        public final void onDeeplinkCallback(boolean z2) {
            this.b.onDeeplinkCallback(z2);
        }

        @Override // com.anythink.core.common.b.l
        public final void onDownloadConfirmCallback(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            this.b.onDownloadConfirm(context, aTNetworkConfirmInfo);
        }
    }

    /* JADX INFO: renamed from: com.anythink.splashad.a.c$3, reason: invalid class name */
    final class AnonymousClass3 implements com.anythink.basead.e.a {
        final /* synthetic */ f a;

        AnonymousClass3(f fVar) {
            this.a = fVar;
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClick(int i2) {
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
            this.a.onSplashAdDismiss();
        }

        @Override // com.anythink.basead.e.a
        public final void onAdShow() {
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z2) {
        }

        @Override // com.anythink.basead.e.a
        public final void onShowFailed(com.anythink.basead.c.e eVar) {
        }
    }

    private c(Context context, String str) {
        super(context, str);
    }

    private void e(String str) {
        d dVar = this.a;
        if (dVar != null) {
            com.anythink.core.common.e.e eVar = new com.anythink.core.common.e.e();
            eVar.x(dVar.f12754f);
            eVar.y(dVar.f12753e);
            eVar.z("4");
            eVar.w("0");
            eVar.a(true);
            com.anythink.core.common.j.c.a(eVar, ErrorCode.getErrorCode(ErrorCode.timeOutError, "", "Splash FetchAd Timeout."));
            this.a.b = null;
            this.a = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        h hVar = this.f7393d.get(str);
        this.f7393d.remove(str);
        if (hVar != null) {
            if (hVar instanceof e) {
                ((e) hVar).j();
                return;
            }
            return;
        }
        com.anythink.core.common.e.e eVar2 = new com.anythink.core.common.e.e();
        eVar2.x(this.f7392c);
        eVar2.y(str);
        eVar2.z("4");
        eVar2.w("0");
        eVar2.a(true);
        com.anythink.core.common.j.c.a(eVar2, ErrorCode.getErrorCode(ErrorCode.timeOutError, "", "Splash FetchAd Timeout."));
    }

    @Override // com.anythink.core.common.f
    public final /* synthetic */ h a(j jVar) {
        g gVar = (g) jVar;
        e eVar = new e(gVar.a());
        eVar.T = gVar.f12774h;
        eVar.a(gVar.f7583d);
        return eVar;
    }

    @Override // com.anythink.core.common.f
    protected final String a() {
        return "4";
    }

    @Override // com.anythink.core.common.f
    public final boolean g() {
        d dVar = this.a;
        return dVar != null && dVar.a();
    }

    @Override // com.anythink.core.common.f
    public final boolean i() {
        d dVar = this.a;
        return dVar != null ? !TextUtils.isEmpty(dVar.f12753e) : super.i();
    }

    @Override // com.anythink.core.common.f
    public final /* synthetic */ boolean a(String str, String str2, j jVar, com.anythink.core.common.b.a aVar) {
        g gVar = (g) jVar;
        if (aVar == null || !(aVar instanceof b)) {
            return false;
        }
        this.a = new d(this.b);
        this.a.a(gVar.a(), str, str2, gVar.b, gVar.f7582c, (b) aVar, gVar.f12774h);
        return true;
    }

    public static c a(Context context, String str) {
        com.anythink.core.common.f fVarB = v.a().b(str);
        if (fVarB == null || !(fVarB instanceof c)) {
            fVarB = new c(context, str);
            v.a().a(str, fVarB);
        }
        return (c) fVarB;
    }

    public final void a(Context context, ATMediationRequestInfo aTMediationRequestInfo, String str, b bVar, int i2, int i3, com.anythink.core.common.b.b bVar2, Map<String, Object> map) {
        g gVar = new g();
        gVar.a(context);
        gVar.b = aTMediationRequestInfo;
        gVar.f7582c = str;
        gVar.f12774h = i2;
        gVar.f7583d = i3;
        gVar.f7584e = bVar2;
        gVar.f7586g = map;
        super.a(this.b, "4", this.f7392c, gVar, bVar);
    }

    @Override // com.anythink.core.common.f
    public final void a(String str, com.anythink.core.common.b.a aVar) {
        if (aVar == null || !(aVar instanceof b)) {
            return;
        }
        ((b) aVar).setRequestId(str);
    }

    private static h a(g gVar) {
        e eVar = new e(gVar.a());
        eVar.T = gVar.f12774h;
        eVar.a(gVar.f7583d);
        return eVar;
    }

    @Override // com.anythink.core.common.f
    public final com.anythink.core.common.e.b a(Context context, boolean z2, boolean z3, Map<String, Object> map) {
        com.anythink.core.common.e.b bVar;
        d dVar = this.a;
        com.anythink.core.common.e.b bVar2 = null;
        if (dVar != null && (bVar = dVar.f12752d) != null && bVar.d() <= 0) {
            bVar2 = dVar.f12752d;
        }
        if (bVar2 != null) {
            com.anythink.core.common.e.e eVarH = bVar2.h();
            if (z2) {
                com.anythink.core.common.j.c.a(eVarH, true, -1, 0, eVarH.x(), eVarH.H(), eVarH.f7247u, "", eVarH.X(), eVarH.f7243q == 3, "");
            }
            return bVar2;
        }
        return super.a(context, z2, z3, map);
    }

    public final synchronized void a(final Activity activity, final ViewGroup viewGroup, final a aVar, final ATEventInterface aTEventInterface, final ATSplashSkipInfo aTSplashSkipInfo, final String str, final Map<String, Object> map) {
        final com.anythink.core.common.e.b bVarA = a((Context) activity, false, true, map);
        if (bVarA == null) {
            return;
        }
        if (bVarA != null && (bVarA.e() instanceof CustomSplashAdapter)) {
            a(bVarA);
            f();
            bVarA.a(bVarA.d() + 1);
            if (this.a != null && this.a.f12752d == bVarA) {
                this.a.f12752d = null;
            }
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.splashad.a.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    final CustomSplashAdapter customSplashAdapter = (CustomSplashAdapter) bVarA.e();
                    Activity activity2 = activity;
                    if (activity2 != null) {
                        customSplashAdapter.refreshActivityContext(activity2);
                    }
                    final com.anythink.core.common.e.e trackingInfo = bVarA.e().getTrackingInfo();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (trackingInfo != null) {
                        trackingInfo.f7248v = ((com.anythink.core.common.f) c.this).f7396g;
                        trackingInfo.C = str;
                        trackingInfo.h(com.anythink.core.common.k.g.a(trackingInfo.X(), trackingInfo.x(), jCurrentTimeMillis));
                        s.a(((com.anythink.core.common.f) c.this).b, trackingInfo);
                        s.a((Map<String, Object>) map, trackingInfo);
                    }
                    com.anythink.core.common.a.a().a(((com.anythink.core.common.f) c.this).b, bVarA);
                    com.anythink.core.common.j.a.a(((com.anythink.core.common.f) c.this).b).a(13, trackingInfo, customSplashAdapter.getUnitGroupInfo(), jCurrentTimeMillis);
                    n.a().a(new Runnable() { // from class: com.anythink.splashad.a.c.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            IExHandler iExHandlerB = n.a().b();
                            if (iExHandlerB != null) {
                                CustomSplashAdapter customSplashAdapter2 = customSplashAdapter;
                                customSplashAdapter2.setAdDownloadListener(iExHandlerB.createDownloadListener(customSplashAdapter2, null, aTEventInterface));
                            }
                            ATSplashSkipInfo aTSplashSkipInfo2 = aTSplashSkipInfo;
                            boolean z2 = aTSplashSkipInfo2 != null && aTSplashSkipInfo2.canUseCustomSkipView();
                            boolean zIsSupportCustomSkipView = customSplashAdapter.isSupportCustomSkipView();
                            if (z2 && zIsSupportCustomSkipView) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                aTSplashSkipInfo.setContainer(viewGroup);
                                customSplashAdapter.setSplashSkipInfo(aTSplashSkipInfo);
                            }
                            final f fVar = new f(customSplashAdapter, aVar);
                            if (customSplashAdapter.getMixedFormatAdType() == 0) {
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                c.a(c.this, activity, viewGroup, fVar, z2, bVarA.f(), trackingInfo);
                            } else {
                                CustomSplashAdapter customSplashAdapter3 = customSplashAdapter;
                                AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                                customSplashAdapter3.internalShow(activity, viewGroup, fVar);
                            }
                            if (!z2) {
                                ATSplashSkipInfo aTSplashSkipInfo3 = aTSplashSkipInfo;
                                return;
                            }
                            ATSplashSkipAdListener aTSplashSkipAdListener = aTSplashSkipInfo.getATSplashSkipAdListener();
                            if (aTSplashSkipAdListener != null) {
                                aTSplashSkipAdListener.isSupportCustomSkipView(zIsSupportCustomSkipView);
                            }
                            if (zIsSupportCustomSkipView) {
                                aTSplashSkipInfo.getSkipView().setOnClickListener(new View.OnClickListener() { // from class: com.anythink.splashad.a.c.1.1.1
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        f fVar2 = fVar;
                                        if (fVar2 != null) {
                                            fVar2.a(2);
                                            fVar.onSplashAdDismiss();
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            });
        }
    }

    private boolean a(String str, String str2, g gVar, com.anythink.core.common.b.a aVar) {
        if (aVar == null || !(aVar instanceof b)) {
            return false;
        }
        this.a = new d(this.b);
        this.a.a(gVar.a(), str, str2, gVar.b, gVar.f7582c, (b) aVar, gVar.f12774h);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(Activity activity, ViewGroup viewGroup, f fVar, boolean z2, BaseAd baseAd, com.anythink.core.common.e.e eVar) {
        ViewGroup customAdContainer;
        if (baseAd == 0 || !(baseAd instanceof com.anythink.core.common.e.a.e)) {
            if (fVar != null) {
                fVar.a(99);
                fVar.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "", "showThirdPartyNativeSplash fail,AdCache return illegal type adObject"));
                fVar.onSplashAdDismiss();
                return;
            }
            return;
        }
        com.anythink.core.common.e.a.b bVar = new com.anythink.core.common.e.a.b((com.anythink.core.common.e.a.e) baseAd);
        com.anythink.core.common.e.a.c cVar = new com.anythink.core.common.e.a.c((com.anythink.core.common.e.a.a) baseAd, eVar, Integer.parseInt("4"));
        String strA = com.anythink.core.common.f.a(cVar);
        baseAd.setNativeEventListener(new AnonymousClass2(new boolean[]{false}, fVar));
        i.a().a(strA, baseAd);
        ThirdPartySplashAdView thirdPartySplashAdView = new ThirdPartySplashAdView(activity.getApplicationContext(), cVar, bVar, new AnonymousClass3(fVar), strA);
        thirdPartySplashAdView.setDontCountDown(z2);
        if (baseAd.getCustomAdContainer() != null) {
            customAdContainer = baseAd.getCustomAdContainer();
            customAdContainer.addView(thirdPartySplashAdView);
        } else {
            customAdContainer = thirdPartySplashAdView;
        }
        thirdPartySplashAdView.registerNativeClickListener(viewGroup);
        viewGroup.addView(customAdContainer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void a(c cVar, Activity activity, ViewGroup viewGroup, f fVar, boolean z2, BaseAd baseAd, com.anythink.core.common.e.e eVar) {
        ViewGroup customAdContainer;
        if (baseAd != 0 && (baseAd instanceof com.anythink.core.common.e.a.e)) {
            com.anythink.core.common.e.a.b bVar = new com.anythink.core.common.e.a.b((com.anythink.core.common.e.a.e) baseAd);
            com.anythink.core.common.e.a.c cVar2 = new com.anythink.core.common.e.a.c((com.anythink.core.common.e.a.a) baseAd, eVar, Integer.parseInt("4"));
            String strA = com.anythink.core.common.f.a(cVar2);
            baseAd.setNativeEventListener(cVar.new AnonymousClass2(new boolean[]{false}, fVar));
            i.a().a(strA, baseAd);
            ThirdPartySplashAdView thirdPartySplashAdView = new ThirdPartySplashAdView(activity.getApplicationContext(), cVar2, bVar, cVar.new AnonymousClass3(fVar), strA);
            thirdPartySplashAdView.setDontCountDown(z2);
            if (baseAd.getCustomAdContainer() != null) {
                customAdContainer = baseAd.getCustomAdContainer();
                customAdContainer.addView(thirdPartySplashAdView);
            } else {
                customAdContainer = thirdPartySplashAdView;
            }
            thirdPartySplashAdView.registerNativeClickListener(viewGroup);
            viewGroup.addView(customAdContainer);
            return;
        }
        fVar.a(99);
        fVar.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, "", "showThirdPartyNativeSplash fail,AdCache return illegal type adObject"));
        fVar.onSplashAdDismiss();
    }
}
