package com.kwad.components.ad.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadProgressView extends FrameLayout {
    protected TextView GY;

    @ColorInt
    private int GZ;

    @ColorInt
    private int Ha;

    @ColorInt
    private int Hb;
    private int Hc;
    private Drawable Hd;
    private Drawable He;
    private String Hf;
    private final KsAppDownloadListener cE;
    protected TextProgressBar dl;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;

    public DownloadProgressView(@NonNull Context context) {
        this(context, null);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(Wrapper.wrapContextIfNeed(context), attributeSet, i2);
        this.cE = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.widget.DownloadProgressView.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.GY.setText(com.kwad.sdk.core.response.a.a.ax(downloadProgressView.mAdInfo));
                DownloadProgressView.this.GY.setVisibility(0);
                DownloadProgressView.this.dl.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DownloadProgressView.this.GY.setVisibility(8);
                DownloadProgressView.this.dl.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.dl.f(com.kwad.sdk.core.response.a.a.aI(downloadProgressView.mAdTemplate), DownloadProgressView.this.dl.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.GY.setText(com.kwad.sdk.core.response.a.a.ax(downloadProgressView.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DownloadProgressView.this.GY.setVisibility(8);
                DownloadProgressView.this.dl.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.dl.f(com.kwad.sdk.core.response.a.a.U(downloadProgressView.mAdInfo), DownloadProgressView.this.dl.getMax());
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i3) {
                DownloadProgressView.this.GY.setVisibility(8);
                DownloadProgressView.this.dl.setVisibility(0);
                DownloadProgressView.this.dl.f(com.kwad.sdk.core.response.a.a.xI(), i3);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i3) {
                DownloadProgressView.this.GY.setVisibility(8);
                DownloadProgressView.this.dl.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.dl.f(com.kwad.sdk.core.response.a.a.i(i3, downloadProgressView.Hf), i3);
            }
        };
        initAttrs(context, attributeSet);
        initView();
    }

    @SuppressLint({"CustomViewStyleable"})
    private void initAttrs(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_DownloadProgressView);
        this.GZ = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadTextColor, -117146);
        this.Ha = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadLeftTextColor, -1);
        this.Hb = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadRightTextColor, -117146);
        this.Hc = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DownloadProgressView_ksad_downloadTextSize, com.kwad.sdk.b.kwai.a.a(getContext(), 11.0f));
        this.Hd = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_progressDrawable);
        if (this.Hd == null) {
            this.Hd = getResources().getDrawable(R.drawable.ksad_feed_download_progress);
        }
        this.He = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_backgroundDrawable);
        if (this.He == null) {
            this.He = getResources().getDrawable(R.drawable.ksad_feed_app_download_before_bg);
        }
        this.Hf = typedArrayObtainStyledAttributes.getString(R.styleable.ksad_DownloadProgressView_ksad_downloadingFormat);
        if (this.Hf == null) {
            this.Hf = "下载中  %s%%";
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void initView() {
        com.kwad.sdk.i.a.inflate(getContext(), R.layout.ksad_download_progress_layout, this);
        this.dl = (TextProgressBar) findViewById(R.id.ksad_progress_bar);
        this.dl.setTextDimen(this.Hc);
        this.dl.setTextColor(this.Ha, this.Hb);
        this.dl.setProgressDrawable(this.Hd);
        this.GY = (TextView) findViewById(R.id.ksad_normal_text);
        this.GY.setTextColor(this.GZ);
        this.GY.setTextSize(0, this.Hc);
        this.GY.setVisibility(0);
        this.GY.setBackground(this.He);
        findViewById(R.id.ksad_foreground_cover).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.widget.DownloadProgressView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadProgressView.this.performClick();
            }
        });
    }

    public final void E(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = d.cb(adTemplate);
        this.GY.setText(com.kwad.sdk.core.response.a.a.ax(this.mAdInfo));
        this.dl.setVisibility(8);
        this.GY.setVisibility(0);
    }

    public final void a(AdInfo adInfo, int i2, int i3) {
        if (i2 == 0) {
            this.GY.setText(com.kwad.sdk.core.response.a.a.ax(adInfo));
            return;
        }
        if (i2 == 2) {
            this.GY.setVisibility(8);
            this.dl.setVisibility(0);
            this.dl.f(com.kwad.sdk.core.response.a.a.i(i3, this.Hf), i3);
            return;
        }
        if (i2 != 7) {
            if (i2 == 8) {
                this.GY.setVisibility(8);
                this.dl.setVisibility(0);
                this.dl.f(com.kwad.sdk.core.response.a.a.aI(this.mAdTemplate), this.dl.getMax());
                return;
            } else if (i2 != 11) {
                if (i2 != 12) {
                    return;
                }
                this.GY.setVisibility(8);
                this.dl.setVisibility(0);
                this.dl.f(com.kwad.sdk.core.response.a.a.U(adInfo), this.dl.getMax());
                return;
            }
        }
        this.GY.setText(com.kwad.sdk.core.response.a.a.ax(adInfo));
        this.GY.setVisibility(0);
        this.dl.setVisibility(8);
    }

    public KsAppDownloadListener getAppDownloadListener() {
        return this.cE;
    }
}
