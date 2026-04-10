package com.anythink.network.myoffer;

import android.content.Context;
import android.view.View;
import com.anythink.basead.b;
import com.anythink.basead.e.a;
import com.anythink.basead.f.e;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MyOfferATNativeAd extends CustomNativeAd {
    e a;
    Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    View f12585c;

    public MyOfferATNativeAd(Context context, e eVar) {
        this.b = context.getApplicationContext();
        this.a = eVar;
        this.a.a(new a() { // from class: com.anythink.network.myoffer.MyOfferATNativeAd.1
            @Override // com.anythink.basead.e.a
            public final void onAdClick(int i2) {
                com.anythink.core.common.e.e detail = MyOfferATNativeAd.this.getDetail();
                if (detail != null) {
                    detail.x(i2);
                }
                MyOfferATNativeAd.this.notifyAdClicked();
            }

            @Override // com.anythink.basead.e.a
            public final void onAdClosed() {
            }

            @Override // com.anythink.basead.e.a
            public final void onAdShow() {
                MyOfferATNativeAd.this.notifyAdImpression();
            }

            @Override // com.anythink.basead.e.a
            public final void onDeeplinkCallback(boolean z2) {
            }

            @Override // com.anythink.basead.e.a
            public final void onShowFailed(com.anythink.basead.c.e eVar2) {
            }
        });
        setNetworkInfoMap(b.a(this.a.e()));
        setAdChoiceIconUrl(this.a.j());
        setTitle(this.a.b());
        setDescriptionText(this.a.f());
        setIconImageUrl(this.a.h());
        setMainImageUrl(this.a.i());
        setCallToActionText(this.a.g());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void clear(View view) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.l();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        e eVar = this.a;
        if (eVar != null) {
            eVar.a((a) null);
            this.a.m();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        if (this.f12585c == null) {
            this.f12585c = e.k();
        }
        return this.f12585c;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        if (this.a != null) {
            List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
            if (clickViewList == null || clickViewList.size() <= 0) {
                this.a.a(view);
            } else {
                this.a.a(view, clickViewList);
            }
        }
    }
}
