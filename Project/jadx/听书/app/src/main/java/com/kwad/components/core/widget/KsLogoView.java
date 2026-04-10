package com.kwad.components.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;

/* JADX INFO: loaded from: classes4.dex */
public class KsLogoView extends LinearLayout {
    private boolean ajf;
    TextView ajg;
    ImageView ajh;
    private a aji;
    private SimpleImageLoadingListener hy;

    /* JADX INFO: loaded from: classes3.dex */
    public interface a {
        void bE();
    }

    public TextView getTextView() {
        return this.ajg;
    }

    public ImageView getIcon() {
        return this.ajh;
    }

    public KsLogoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public KsLogoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsLogoView(Context context, AttributeSet attributeSet, int i) {
        super(m.wrapContextIfNeed(context), attributeSet, i);
        this.hy = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.we();
                if (KsLogoView.this.aji != null) {
                    KsLogoView.this.aji.bE();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.aji != null) {
                    KsLogoView.this.aji.bE();
                }
            }
        };
        init();
    }

    public KsLogoView(Context context, boolean z) {
        super(m.wrapContextIfNeed(context));
        this.hy = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.we();
                if (KsLogoView.this.aji != null) {
                    KsLogoView.this.aji.bE();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.aji != null) {
                    KsLogoView.this.aji.bE();
                }
            }
        };
        if (z) {
            setBackground(getResources().getDrawable(R.drawable.ksad_splash_logo_bg));
        }
        init();
    }

    private void init() {
        m.inflate(getContext(), R.layout.ksad_logo_layout, this);
        this.ajg = (TextView) findViewById(R.id.ksad_logo_text);
        this.ajh = (ImageView) findViewById(R.id.ksad_logo_icon);
        boolean z = getBackground() == null;
        this.ajf = z;
        if (z) {
            this.ajh.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_gray));
            this.ajg.setTextColor(-6513508);
        } else {
            this.ajh.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_white));
            this.ajg.setTextColor(-1711276033);
        }
    }

    public final void aP(AdTemplate adTemplate) {
        View viewFindViewById = findViewById(R.id.ksad_logo_container);
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        String str = this.ajf ? adInfoEl.adBaseInfo.adGrayMarkIcon : adInfoEl.adBaseInfo.adMarkIcon;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(adInfoEl.adBaseInfo.adSourceDescription)) {
            this.ajg.setVisibility(0);
            this.ajg.setText(com.kwad.sdk.core.response.b.a.aD(adInfoEl));
            this.ajh.setVisibility(0);
            we();
            a aVar = this.aji;
            if (aVar != null) {
                aVar.bE();
            }
        } else {
            if (!TextUtils.isEmpty(adInfoEl.adBaseInfo.adSourceDescription)) {
                this.ajg.setText(com.kwad.sdk.core.response.b.a.aD(adInfoEl));
                this.ajg.setVisibility(0);
            } else {
                this.ajg.setVisibility(8);
                this.ajg.setText("");
            }
            if (!TextUtils.isEmpty(str)) {
                KSImageLoader.loadFeeImage(this.ajh, str, adTemplate, this.hy);
                this.ajh.setVisibility(0);
            } else {
                this.ajh.setVisibility(8);
                this.ajh.setImageDrawable(null);
                a aVar2 = this.aji;
                if (aVar2 != null) {
                    aVar2.bE();
                }
            }
        }
        viewFindViewById.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void we() {
        this.ajh.setImageDrawable(getContext().getResources().getDrawable(this.ajf ? R.drawable.ksad_logo_gray : R.drawable.ksad_logo_white));
    }

    public void setLogoLoadFinishListener(a aVar) {
        this.aji = aVar;
    }

    public static Bitmap a(KsLogoView ksLogoView) {
        TextView textView = ksLogoView.getTextView();
        int iCeil = ((ksLogoView.getVisibility() != 0 || textView.getText() == null || textView.getText().length() <= 0) ? 0 : ((int) Math.ceil(textView.getPaint().measureText(textView.getText().toString()))) + textView.getPaddingLeft() + textView.getPaddingRight()) + (ksLogoView.getIcon().getVisibility() == 0 ? com.kwad.sdk.c.a.a.a(ksLogoView.getContext(), 18.0f) : 0);
        int iA = com.kwad.sdk.c.a.a.a(ksLogoView.getContext(), 16.0f);
        ksLogoView.measure(iCeil, iA);
        ksLogoView.layout(0, 0, iCeil, iA);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(ksLogoView.getWidth(), ksLogoView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(0);
        ksLogoView.draw(canvas);
        return bitmapCreateBitmap;
    }
}
