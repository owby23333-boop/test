package com.anythink.network.adx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.d.h;
import com.anythink.basead.e.a;
import com.anythink.basead.e.e;
import com.anythink.basead.ui.BaseMediaAdView;
import com.anythink.basead.ui.OwnNativeAdView;
import com.anythink.core.common.d.b;
import com.anythink.core.common.d.c;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AdxATNativeAd extends CustomNativeAd {
    h a;
    Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f12325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f12326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    View f12327e;

    public AdxATNativeAd(final Context context, h hVar, boolean z2, boolean z3) {
        this.b = context.getApplicationContext();
        this.a = hVar;
        h hVar2 = this.a;
        hVar2.a(new e(hVar2.a()) { // from class: com.anythink.network.adx.AdxATNativeAd.1
            @Override // com.anythink.basead.e.a
            public final void onAdClick(int i2) {
                com.anythink.core.common.e.e detail = AdxATNativeAd.this.getDetail();
                if (detail != null) {
                    detail.x(i2);
                }
                AdxATNativeAd.this.notifyAdClicked();
                if (AdxATNativeAd.this.a.a().n() == 67) {
                    if (AdxATNativeAd.this.a.a(true, false)) {
                        c.a(context).a(AdxATNativeAd.this.a.a().p(), 1, 0);
                    }
                    if (AdxATNativeAd.this.a.a(false, false)) {
                        b.a(context).a(AdxATNativeAd.this.a.a().p(), 1, 0);
                    }
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onAdClosed() {
                AdxATNativeAd.this.notifyAdDislikeClick();
            }

            @Override // com.anythink.basead.e.e, com.anythink.basead.e.a
            public final void onAdShow() {
                super.onAdShow();
                AdxATNativeAd.this.notifyAdImpression();
                if (AdxATNativeAd.this.a.a().n() == 67) {
                    if (AdxATNativeAd.this.a.a(true, true)) {
                        c.a(context).a(AdxATNativeAd.this.a.a().p(), 0, 1);
                    }
                    if (AdxATNativeAd.this.a.a(false, true)) {
                        b.a(context).a(AdxATNativeAd.this.a.a().p(), 0, 1);
                    }
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onDeeplinkCallback(boolean z4) {
                AdxATNativeAd.this.notifyDeeplinkCallback(z4);
            }

            @Override // com.anythink.basead.e.a
            public final void onShowFailed(com.anythink.basead.c.e eVar) {
            }
        });
        this.f12325c = z2;
        this.f12326d = z3;
        if (z2 || this.a.h()) {
            return;
        }
        setNetworkInfoMap(com.anythink.basead.b.a(this.a.a()));
        setAdChoiceIconUrl(this.a.g());
        setTitle(this.a.b());
        setDescriptionText(this.a.c());
        setIconImageUrl(this.a.e());
        setMainImageUrl(this.a.f());
        setCallToActionText(this.a.d());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void clear(View view) {
        h hVar = this.a;
        if (hVar != null) {
            hVar.i();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        h hVar = this.a;
        if (hVar != null) {
            hVar.a((a) null);
            this.a.j();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        if (this.f12327e == null) {
            this.f12327e = this.a.a(this.b, this.f12325c, this.f12326d, new BaseMediaAdView.a() { // from class: com.anythink.network.adx.AdxATNativeAd.2
                @Override // com.anythink.basead.ui.BaseMediaAdView.a
                public final void onClickCloseView() {
                    AdxATNativeAd.this.notifyAdDislikeClick();
                }
            });
        }
        return this.f12327e;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public ViewGroup getCustomAdContainer() {
        if (this.a == null || this.f12325c) {
            return null;
        }
        return new OwnNativeAdView(this.b);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return this.f12325c || this.a.h();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onPause() {
        h hVar = this.a;
        if (hVar != null) {
            hVar.l();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onResume() {
        h hVar = this.a;
        if (hVar != null) {
            hVar.k();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        this.a.k();
        if (this.f12325c || this.a == null) {
            return;
        }
        List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
        if (clickViewList == null || clickViewList.size() <= 0) {
            this.a.a(view);
        } else {
            this.a.a(view, clickViewList);
        }
    }
}
