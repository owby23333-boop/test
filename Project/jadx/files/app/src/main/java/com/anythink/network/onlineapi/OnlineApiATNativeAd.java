package com.anythink.network.onlineapi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.b;
import com.anythink.basead.d.h;
import com.anythink.basead.e.a;
import com.anythink.basead.ui.OwnNativeAdView;
import com.anythink.core.common.e.e;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class OnlineApiATNativeAd extends CustomNativeAd {
    h a;
    Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    View f12599c;

    public OnlineApiATNativeAd(Context context, h hVar) {
        this.b = context.getApplicationContext();
        this.a = hVar;
        this.a.a(new a() { // from class: com.anythink.network.onlineapi.OnlineApiATNativeAd.1
            @Override // com.anythink.basead.e.a
            public final void onAdClick(int i2) {
                e detail = OnlineApiATNativeAd.this.getDetail();
                if (detail != null) {
                    detail.x(i2);
                }
                OnlineApiATNativeAd.this.notifyAdClicked();
            }

            @Override // com.anythink.basead.e.a
            public final void onAdClosed() {
            }

            @Override // com.anythink.basead.e.a
            public final void onAdShow() {
                OnlineApiATNativeAd.this.notifyAdImpression();
            }

            @Override // com.anythink.basead.e.a
            public final void onDeeplinkCallback(boolean z2) {
                OnlineApiATNativeAd.this.notifyDeeplinkCallback(z2);
            }

            @Override // com.anythink.basead.e.a
            public final void onShowFailed(com.anythink.basead.c.e eVar) {
            }
        });
        setNetworkInfoMap(b.a(this.a.a()));
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
        if (this.f12599c == null) {
            this.f12599c = this.a.a(this.b, false, false, null);
        }
        return this.f12599c;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public ViewGroup getCustomAdContainer() {
        if (this.a != null) {
            return new OwnNativeAdView(this.b);
        }
        return null;
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
