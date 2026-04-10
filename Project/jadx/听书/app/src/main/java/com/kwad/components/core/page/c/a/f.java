package com.kwad.components.core.page.c.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.b.a;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends com.kwad.components.core.page.c.a.a {
    private boolean Uh;
    private com.kwad.components.core.b.a mTitleBarHelper;

    public interface a {
        void aQ(int i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.Uh = TextUtils.equals(this.TJ.mPageUrl, com.kwad.sdk.core.response.b.a.aS(com.kwad.sdk.core.response.b.e.el(this.TJ.mAdTemplate)));
        ro();
    }

    private String getTitle() {
        if (TextUtils.isEmpty(this.TJ.mPageTitle)) {
            return (this.TJ.mAdTemplate.adInfoList == null || this.TJ.mAdTemplate.adInfoList.size() <= 0 || this.TJ.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.b.a.cl(com.kwad.sdk.core.response.b.e.el(this.TJ.mAdTemplate));
        }
        return this.TJ.mPageTitle;
    }

    private void ro() {
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a(this.TJ.jI);
        this.mTitleBarHelper = aVar;
        aVar.a(new com.kwad.components.core.b.b(getTitle()));
        this.mTitleBarHelper.aj(true);
        this.mTitleBarHelper.a(new a.InterfaceC0322a() { // from class: com.kwad.components.core.page.c.a.f.1
            @Override // com.kwad.components.core.b.a.InterfaceC0322a
            public final void x(View view) {
                f.this.A(view);
            }

            @Override // com.kwad.components.core.b.a.InterfaceC0322a
            public final void y(View view) {
                f.this.B(view);
            }
        });
        ViewGroup viewGroupHP = this.mTitleBarHelper.hP();
        int i = 0;
        if (!this.TJ.mAdTemplate.mIsForceJumpLandingPage && !com.kwad.sdk.core.response.b.a.cm(this.TJ.mAdTemplate) && !com.kwad.sdk.core.response.b.b.dC(com.kwad.sdk.core.response.b.e.el(this.TJ.mAdTemplate))) {
            i = 8;
        }
        viewGroupHP.setVisibility(i);
        this.TJ.a(new a() { // from class: com.kwad.components.core.page.c.a.f.2
            @Override // com.kwad.components.core.page.c.a.f.a
            public final void aQ(int i2) {
                f.this.mTitleBarHelper.hP().setVisibility(i2 == 1 ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(View view) {
        if (this.TJ != null) {
            this.TJ.a(this.Uh, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(View view) {
        if (this.TJ.TK != null) {
            this.TJ.TK.qP();
        }
    }
}
