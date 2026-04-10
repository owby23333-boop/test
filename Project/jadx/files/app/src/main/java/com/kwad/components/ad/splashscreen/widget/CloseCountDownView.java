package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: classes3.dex */
public class CloseCountDownView extends LinearLayout {
    private String EO;
    private int EP;
    private TextView EQ;
    private TextView ER;
    private ImageView ES;
    private Runnable ET;
    private a Eb;
    private boolean nV;

    public interface a {
        void dP();

        void lf();
    }

    public CloseCountDownView(Context context) {
        super(context);
        this.EO = "%ss";
        this.EP = 5;
        this.nV = false;
        this.ET = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nV) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.EP <= 0) {
                    if (CloseCountDownView.this.Eb != null) {
                        CloseCountDownView.this.Eb.lf();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ag(closeCountDownView.EP);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        af(context);
    }

    public CloseCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.EO = "%ss";
        this.EP = 5;
        this.nV = false;
        this.ET = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nV) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.EP <= 0) {
                    if (CloseCountDownView.this.Eb != null) {
                        CloseCountDownView.this.Eb.lf();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ag(closeCountDownView.EP);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        af(context);
    }

    public CloseCountDownView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.EO = "%ss";
        this.EP = 5;
        this.nV = false;
        this.ET = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nV) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.EP <= 0) {
                    if (CloseCountDownView.this.Eb != null) {
                        CloseCountDownView.this.Eb.lf();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ag(closeCountDownView.EP);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        af(context);
    }

    @RequiresApi(api = 21)
    public CloseCountDownView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.EO = "%ss";
        this.EP = 5;
        this.nV = false;
        this.ET = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CloseCountDownView.this.nV) {
                    CloseCountDownView.this.postDelayed(this, 300L);
                    return;
                }
                if (CloseCountDownView.this.EP <= 0) {
                    if (CloseCountDownView.this.Eb != null) {
                        CloseCountDownView.this.Eb.lf();
                    }
                } else {
                    CloseCountDownView.this.postDelayed(this, 1000L);
                    CloseCountDownView closeCountDownView = CloseCountDownView.this;
                    closeCountDownView.ag(closeCountDownView.EP);
                    CloseCountDownView.d(CloseCountDownView.this);
                }
            }
        };
        af(context);
    }

    private void af(Context context) {
        setOrientation(0);
        com.kwad.sdk.i.a.inflate(context, R.layout.ksad_endcard_close_view, this);
        this.EQ = (TextView) findViewById(R.id.ksad_ad_endcard_second);
        this.ER = (TextView) findViewById(R.id.ksad_ad_endcard_line);
        this.ES = (ImageView) findViewById(R.id.ksad_splash_endcard_close_img);
        this.ES.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CloseCountDownView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (CloseCountDownView.this.Eb != null) {
                    CloseCountDownView.this.Eb.dP();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(int i2) {
        this.EQ.setText(String.format(this.EO, Integer.valueOf(i2)));
    }

    static /* synthetic */ int d(CloseCountDownView closeCountDownView) {
        int i2 = closeCountDownView.EP;
        closeCountDownView.EP = i2 - 1;
        return i2;
    }

    private void fc() {
        post(this.ET);
    }

    private void fd() {
        this.nV = true;
    }

    private void fe() {
        this.nV = false;
    }

    public final void a(AdInfo adInfo) {
        Context context;
        float f2;
        boolean zBP = com.kwad.sdk.core.response.a.a.bP(adInfo);
        this.EP = com.kwad.sdk.core.response.a.a.bO(adInfo);
        if (zBP) {
            this.EQ.setVisibility(0);
            this.ER.setVisibility(0);
            ag(this.EP);
            context = getContext();
            f2 = 12.0f;
        } else {
            context = getContext();
            f2 = 4.0f;
        }
        setPadding(com.kwad.sdk.b.kwai.a.a(context, f2), 0, com.kwad.sdk.b.kwai.a.a(getContext(), f2), 0);
        fc();
    }

    public final void aS() {
        fe();
    }

    public final void aT() {
        fd();
    }

    public final void bn() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    public void setOnViewClickListener(a aVar) {
        this.Eb = aVar;
    }
}
