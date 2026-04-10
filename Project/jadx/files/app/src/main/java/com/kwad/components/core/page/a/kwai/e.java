package com.kwad.components.core.page.a.kwai;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends a {
    private ImageView mWebTipBarCloseBtn;
    private LinearLayout mWebTipBarLayout;
    private TextView mWebTipBarTitle;

    @NonNull
    private KsAdWebView.c getOnWebViewScrollChangeListener() {
        return new KsAdWebView.c() { // from class: com.kwad.components.core.page.a.kwai.e.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.c
            public final void op() {
                if (e.this.LL.ou() && e.this.mWebTipBarLayout.getVisibility() == 0) {
                    e.this.mWebTipBarLayout.setVisibility(8);
                }
            }
        };
    }

    private void initTipBarView() {
        this.mWebTipBarLayout = (LinearLayout) findViewById(R.id.ksad_web_tip_bar);
        if (!TextUtils.isEmpty(this.LL.mPageTitle)) {
            this.mWebTipBarLayout.setVisibility(8);
            return;
        }
        this.mWebTipBarTitle = (TextView) findViewById(R.id.ksad_web_tip_bar_textview);
        this.mWebTipBarCloseBtn = (ImageView) findViewById(R.id.ksad_web_tip_close_btn);
        this.mWebTipBarCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.a.kwai.e.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.mWebTipBarLayout.setVisibility(8);
            }
        });
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.LL.mAdTemplate);
        boolean zBm = com.kwad.sdk.core.response.a.a.bm(adInfoCb);
        String strBi = com.kwad.sdk.core.response.a.a.bi(adInfoCb);
        if (zBm) {
            this.mWebTipBarLayout.setVisibility(0);
            this.mWebTipBarTitle.setText(strBi);
            this.mWebTipBarTitle.setSelected(true);
        } else {
            this.mWebTipBarLayout.setVisibility(8);
        }
        this.LL.a(getOnWebViewScrollChangeListener());
    }

    @Override // com.kwad.components.core.page.a.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        initTipBarView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
