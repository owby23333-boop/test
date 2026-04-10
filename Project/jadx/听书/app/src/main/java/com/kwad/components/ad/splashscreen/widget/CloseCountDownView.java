package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.ak;

/* JADX INFO: loaded from: classes3.dex */
public class CloseCountDownView extends LinearLayout {
    private a Iq;
    private String JJ;
    private int JK;
    private TextView JL;
    private TextView JM;
    private ImageView JN;
    private com.kwad.components.ad.splashscreen.widget.a JO;
    private Runnable JP;
    private boolean qy;

    public interface a {
        void eh();

        void mf();
    }

    static /* synthetic */ int d(CloseCountDownView closeCountDownView) {
        int i = closeCountDownView.JK;
        closeCountDownView.JK = i - 1;
        return i;
    }

    public CloseCountDownView(Context context) {
        super(context);
        this.JJ = "%ss";
        this.JK = 5;
        this.qy = false;
        this.JP = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!CloseCountDownView.this.qy) {
                    if (CloseCountDownView.this.JK <= 0) {
                        if (CloseCountDownView.this.Iq != null) {
                            CloseCountDownView.this.Iq.mf();
                            return;
                        }
                        return;
                    } else {
                        CloseCountDownView.this.postDelayed(this, 1000L);
                        CloseCountDownView closeCountDownView = CloseCountDownView.this;
                        closeCountDownView.ap(closeCountDownView.JK);
                        CloseCountDownView.d(CloseCountDownView.this);
                        return;
                    }
                }
                CloseCountDownView.this.postDelayed(this, 300L);
            }
        };
        ah(context);
    }

    public CloseCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.JJ = "%ss";
        this.JK = 5;
        this.qy = false;
        this.JP = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!CloseCountDownView.this.qy) {
                    if (CloseCountDownView.this.JK <= 0) {
                        if (CloseCountDownView.this.Iq != null) {
                            CloseCountDownView.this.Iq.mf();
                            return;
                        }
                        return;
                    } else {
                        CloseCountDownView.this.postDelayed(this, 1000L);
                        CloseCountDownView closeCountDownView = CloseCountDownView.this;
                        closeCountDownView.ap(closeCountDownView.JK);
                        CloseCountDownView.d(CloseCountDownView.this);
                        return;
                    }
                }
                CloseCountDownView.this.postDelayed(this, 300L);
            }
        };
        ah(context);
    }

    public CloseCountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.JJ = "%ss";
        this.JK = 5;
        this.qy = false;
        this.JP = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!CloseCountDownView.this.qy) {
                    if (CloseCountDownView.this.JK <= 0) {
                        if (CloseCountDownView.this.Iq != null) {
                            CloseCountDownView.this.Iq.mf();
                            return;
                        }
                        return;
                    } else {
                        CloseCountDownView.this.postDelayed(this, 1000L);
                        CloseCountDownView closeCountDownView = CloseCountDownView.this;
                        closeCountDownView.ap(closeCountDownView.JK);
                        CloseCountDownView.d(CloseCountDownView.this);
                        return;
                    }
                }
                CloseCountDownView.this.postDelayed(this, 300L);
            }
        };
        ah(context);
    }

    public CloseCountDownView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.JJ = "%ss";
        this.JK = 5;
        this.qy = false;
        this.JP = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!CloseCountDownView.this.qy) {
                    if (CloseCountDownView.this.JK <= 0) {
                        if (CloseCountDownView.this.Iq != null) {
                            CloseCountDownView.this.Iq.mf();
                            return;
                        }
                        return;
                    } else {
                        CloseCountDownView.this.postDelayed(this, 1000L);
                        CloseCountDownView closeCountDownView = CloseCountDownView.this;
                        closeCountDownView.ap(closeCountDownView.JK);
                        CloseCountDownView.d(CloseCountDownView.this);
                        return;
                    }
                }
                CloseCountDownView.this.postDelayed(this, 300L);
            }
        };
        ah(context);
    }

    private void ah(Context context) {
        setOrientation(0);
        m.inflate(context, R.layout.ksad_endcard_close_view, this);
        this.JL = (TextView) findViewById(R.id.ksad_ad_endcard_second);
        this.JM = (TextView) findViewById(R.id.ksad_ad_endcard_line);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_splash_endcard_close_img);
        this.JN = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (CloseCountDownView.this.Iq != null) {
                    CloseCountDownView.this.Iq.eh();
                }
            }
        });
    }

    public final void bu() {
        fP();
    }

    public final void bt() {
        fQ();
    }

    public void setOnViewClickListener(a aVar) {
        this.Iq = aVar;
    }

    public final void a(AdInfo adInfo, float f) {
        com.kwad.components.ad.splashscreen.widget.a aVarAi;
        boolean zDn = com.kwad.sdk.core.response.b.a.dn(adInfo);
        if (zDn) {
            aVarAi = com.kwad.components.ad.splashscreen.widget.a.aj(getContext());
        } else {
            aVarAi = com.kwad.components.ad.splashscreen.widget.a.ai(getContext());
        }
        this.JO = aVarAi;
        aVarAi.d(f);
        boolean zCv = com.kwad.sdk.core.response.b.a.cv(adInfo);
        this.JK = com.kwad.sdk.core.response.b.a.cu(adInfo);
        if (zDn) {
            nn();
        }
        if (zCv) {
            this.JL.setVisibility(0);
            this.JM.setVisibility(0);
            ap(this.JK);
            float fNp = this.JO.np();
            setPadding(com.kwad.sdk.c.a.a.a(getContext(), fNp), 0, com.kwad.sdk.c.a.a.a(getContext(), fNp), 0);
        } else {
            float fNo = this.JO.no();
            setPadding(com.kwad.sdk.c.a.a.a(getContext(), fNo), 0, com.kwad.sdk.c.a.a.a(getContext(), fNo), 0);
        }
        au();
    }

    private void nn() {
        ak.a(this, this.JO.mR());
        ak.a(this.JM, this.JO.nq());
        ak.a(this.JN, this.JO.nt());
        this.JL.setTextSize(0, this.JO.nr());
        this.JM.setTextSize(0, this.JO.nr());
        Drawable background = getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(this.JO.ns());
        }
    }

    public final void cq() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(int i) {
        this.JL.setText(String.format(this.JJ, Integer.valueOf(i)));
    }

    private void au() {
        post(this.JP);
    }

    private void fP() {
        this.qy = true;
    }

    private void fQ() {
        this.qy = false;
    }
}
