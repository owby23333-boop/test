package com.kwad.components.ad.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadProgressView extends FrameLayout {
    private int MA;
    protected Drawable MC;
    protected Drawable MD;
    private String ME;
    protected TextView Mw;
    private int Mx;
    private int My;
    private int Mz;
    private final KsAppDownloadListener dW;
    protected TextProgressBar fR;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;

    public DownloadProgressView(Context context) {
        this(context, null);
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet, int i) {
        super(m.wrapContextIfNeed(context), attributeSet, i);
        this.dW = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.widget.DownloadProgressView.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DownloadProgressView.this.Mw.setText(com.kwad.sdk.core.response.b.a.aE(DownloadProgressView.this.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                DownloadProgressView.this.Mw.setVisibility(8);
                DownloadProgressView.this.fR.setVisibility(0);
                DownloadProgressView.this.fR.e(com.kwad.sdk.core.response.b.a.t(i2, DownloadProgressView.this.ME), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DownloadProgressView.this.Mw.setVisibility(8);
                DownloadProgressView.this.fR.setVisibility(0);
                DownloadProgressView.this.fR.e(com.kwad.sdk.core.response.b.a.cl(DownloadProgressView.this.mAdTemplate), DownloadProgressView.this.fR.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DownloadProgressView.this.Mw.setText(com.kwad.sdk.core.response.b.a.aE(DownloadProgressView.this.mAdInfo));
                DownloadProgressView.this.Mw.setVisibility(0);
                DownloadProgressView.this.fR.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DownloadProgressView.this.Mw.setVisibility(8);
                DownloadProgressView.this.fR.setVisibility(0);
                DownloadProgressView.this.fR.e(com.kwad.sdk.core.response.b.a.ac(DownloadProgressView.this.mAdInfo), DownloadProgressView.this.fR.getMax());
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i2) {
                DownloadProgressView.this.Mw.setVisibility(8);
                DownloadProgressView.this.fR.setVisibility(0);
                DownloadProgressView.this.fR.e(com.kwad.sdk.core.response.b.a.IQ(), i2);
            }
        };
        initAttrs(context, attributeSet);
        initView();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_DownloadProgressView);
        this.Mx = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadTextColor, -117146);
        this.My = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadLeftTextColor, -1);
        this.Mz = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadRightTextColor, -117146);
        this.MA = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DownloadProgressView_ksad_downloadTextSize, com.kwad.sdk.c.a.a.a(getContext(), 11.0f));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_progressDrawable);
        this.MC = drawable;
        if (drawable == null) {
            nO();
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_backgroundDrawable);
        this.MD = drawable2;
        if (drawable2 == null) {
            nP();
        }
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.ksad_DownloadProgressView_ksad_downloadingFormat);
        this.ME = string;
        if (string == null) {
            this.ME = "下载中  %s%%";
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    protected void nN() {
        m.inflate(getContext(), R.layout.ksad_download_progress_layout, this);
    }

    protected void nO() {
        this.MC = getResources().getDrawable(R.drawable.ksad_feed_download_progress);
    }

    protected void nP() {
        this.MD = getResources().getDrawable(R.drawable.ksad_feed_app_download_before_bg);
    }

    private void initView() {
        nN();
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_progress_bar);
        this.fR = textProgressBar;
        textProgressBar.setTextDimen(this.MA);
        this.fR.setTextColor(this.My, this.Mz);
        this.fR.setProgressDrawable(this.MC);
        TextView textView = (TextView) findViewById(R.id.ksad_normal_text);
        this.Mw = textView;
        textView.setTextColor(this.Mx);
        this.Mw.setTextSize(0, this.MA);
        this.Mw.setVisibility(0);
        this.Mw.setBackground(this.MD);
        findViewById(R.id.ksad_foreground_cover).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.widget.DownloadProgressView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadProgressView.this.performClick();
            }
        });
    }

    public final void at(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEl = e.el(adTemplate);
        this.mAdInfo = adInfoEl;
        this.Mw.setText(com.kwad.sdk.core.response.b.a.aE(adInfoEl));
        this.fR.setVisibility(8);
        this.Mw.setVisibility(0);
    }

    public KsAppDownloadListener getAppDownloadListener() {
        return this.dW;
    }
}
