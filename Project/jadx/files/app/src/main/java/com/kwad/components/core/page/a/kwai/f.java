package com.kwad.components.core.page.a.kwai;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends com.kwad.components.core.page.a.kwai.a {
    private boolean Mh;
    private com.kwad.components.core.a.a mTitleBarHelper;

    public interface a {
        void ax(int i2);
    }

    private String getTitle() {
        if (!TextUtils.isEmpty(this.LL.mPageTitle)) {
            return this.LL.mPageTitle;
        }
        List<AdInfo> list = this.LL.mAdTemplate.adInfoList;
        return (list == null || list.size() <= 0 || this.LL.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.a.a.bJ(com.kwad.sdk.core.response.a.d.cb(this.LL.mAdTemplate));
    }

    private boolean oL() {
        return TextUtils.isEmpty(this.LL.mPageTitle);
    }

    private void oM() {
        this.mTitleBarHelper = new com.kwad.components.core.a.a(this.LL.gu);
        this.mTitleBarHelper.a(new com.kwad.components.core.a.b(getTitle()));
        this.mTitleBarHelper.aj(oL());
        this.mTitleBarHelper.a(new a.InterfaceC0385a() { // from class: com.kwad.components.core.page.a.kwai.f.1
            @Override // com.kwad.components.core.a.a.InterfaceC0385a
            public final void u(View view) {
                f.this.x(view);
            }

            @Override // com.kwad.components.core.a.a.InterfaceC0385a
            public final void v(View view) {
                f.this.y(view);
            }
        });
        ViewGroup viewGroupHc = this.mTitleBarHelper.hc();
        AdTemplate adTemplate = this.LL.mAdTemplate;
        int i2 = 0;
        if (!adTemplate.mIsForceJumpLandingPage && !com.kwad.sdk.core.response.a.b.cG(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            i2 = 8;
        }
        viewGroupHc.setVisibility(i2);
        this.LL.a(new a() { // from class: com.kwad.components.core.page.a.kwai.f.2
            @Override // com.kwad.components.core.page.a.kwai.f.a
            public final void ax(int i3) {
                f.this.mTitleBarHelper.hc().setVisibility(i3 == 1 ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(View view) {
        KsAdWebView ksAdWebView = this.LL.mAdWebView;
        if (ksAdWebView == null || !ksAdWebView.canGoBack()) {
            com.kwad.components.core.page.kwai.a aVar = this.LL.LM;
            if (aVar != null) {
                aVar.dK();
                return;
            }
            return;
        }
        this.LL.mAdWebView.goBack();
        if (this.Mh) {
            com.kwad.sdk.core.report.a.ay(this.LL.mAdTemplate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(View view) {
        KsAdWebView ksAdWebView = this.LL.mAdWebView;
        if (ksAdWebView == null || !ksAdWebView.canGoBack()) {
            com.kwad.components.core.page.kwai.a aVar = this.LL.LM;
            if (aVar != null) {
                aVar.dL();
                return;
            }
            return;
        }
        this.LL.mAdWebView.goBack();
        if (this.Mh) {
            com.kwad.sdk.core.report.a.ay(this.LL.mAdTemplate);
        }
    }

    @Override // com.kwad.components.core.page.a.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        b bVar = this.LL;
        this.Mh = TextUtils.equals(bVar.mPageUrl, com.kwad.sdk.core.response.a.a.aL(com.kwad.sdk.core.response.a.d.cb(bVar.mAdTemplate)));
        oM();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
