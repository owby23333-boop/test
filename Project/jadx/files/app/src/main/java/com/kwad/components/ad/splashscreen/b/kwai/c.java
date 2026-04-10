package com.kwad.components.ad.splashscreen.b.kwai;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.widget.CloseCountDownView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.y;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.components.ad.splashscreen.b.e implements View.OnClickListener, com.kwad.sdk.widget.c {
    private CloseCountDownView DV;
    private ViewGroup DW;
    private ViewGroup DX;
    private ImageView DY;
    private TextView DZ;
    private TextView Ea;
    private CloseCountDownView.a Eb = new CloseCountDownView.a() { // from class: com.kwad.components.ad.splashscreen.b.kwai.c.1
        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void dP() {
            y.a aVar = new y.a();
            if (c.this.Cx.mTimerHelper != null) {
                aVar.duration = c.this.Cx.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.report.a.b(c.this.Cx.mAdTemplate, new i().bg(1).a(aVar).bm(6), (JSONObject) null);
            c.this.Cx.kQ();
        }

        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void lf() {
            y.a aVar = new y.a();
            if (c.this.Cx.mTimerHelper != null) {
                aVar.duration = c.this.Cx.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.report.a.b(c.this.Cx.mAdTemplate, new i().bg(14).a(aVar).bm(6), (JSONObject) null);
            c.this.Cx.kT();
        }
    };

    private void t(View view) {
        if (view == this.DW) {
            this.Cx.c(2, view.getContext(), 104, 2);
            return;
        }
        if (view == this.DX) {
            this.Cx.c(2, view.getContext(), 26, 1);
            return;
        }
        if (view == this.DY) {
            this.Cx.c(2, view.getContext(), 15, 2);
        } else if (view == this.DZ) {
            this.Cx.c(2, view.getContext(), 16, 2);
        } else if (view == this.Ea) {
            this.Cx.c(2, view.getContext(), 17, 2);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        t(view);
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.DV.setOnViewClickListener(this.Eb);
        this.DX.setOnClickListener(this);
        new com.kwad.sdk.widget.f(this.DX.getContext(), this.DX, this);
        if (com.kwad.sdk.core.response.a.b.cD(com.kwad.sdk.core.response.a.d.cb(this.Cx.mAdTemplate))) {
            this.DW.setOnClickListener(this);
            this.DY.setOnClickListener(this);
            this.DZ.setOnClickListener(this);
            this.Ea.setOnClickListener(this);
            new com.kwad.sdk.widget.f(this.DX.getContext(), this.DW, this);
            new com.kwad.sdk.widget.f(this.DX.getContext(), this.DY, this);
            new com.kwad.sdk.widget.f(this.DX.getContext(), this.DZ, this);
            new com.kwad.sdk.widget.f(this.DX.getContext(), this.Ea, this);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        t(view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.DV = (CloseCountDownView) findViewById(R.id.ksad_ad_endcard_close_root);
        this.DW = (ViewGroup) findViewById(R.id.ksad_splash_end_card_giftbox_view);
        this.DX = (ViewGroup) findViewById(R.id.ksad_splash_endcard_actionbar);
        this.DY = (ImageView) findViewById(R.id.ksad_ad_endcard_icon);
        this.DZ = (TextView) findViewById(R.id.ksad_ad_endcard_appname);
        this.Ea = (TextView) findViewById(R.id.ksad_ad_endcard_appdesc);
    }
}
