package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;

/* JADX INFO: loaded from: classes3.dex */
public class ActionBarH5 extends FrameLayout implements c {
    private TextView Bj;
    private a Bk;
    private View Bl;
    private TextView dQ;
    private AdTemplate mAdTemplate;

    public interface a {
        void R(boolean z2);
    }

    public ActionBarH5(Context context) {
        super(context);
        D(context);
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        D(context);
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        D(context);
    }

    private void D(Context context) {
        com.kwad.sdk.i.a.inflate(context, R.layout.ksad_video_actionbar_h5, this);
        this.Bj = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.dQ = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.Bl = findViewById(R.id.ksad_download_bar_cover);
    }

    private void b(View view, final boolean z2) {
        com.kwad.components.core.d.b.a.a(new a.C0395a(view.getContext()).J(this.mAdTemplate).ap(view == this.Bl ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.1
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                if (ActionBarH5.this.Bk != null) {
                    ActionBarH5.this.Bk.R(z2);
                }
            }
        }));
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        b(view, true);
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        this.Bk = aVar;
        AdInfo adInfoCb = d.cb(this.mAdTemplate);
        this.Bj.setText(com.kwad.sdk.core.response.a.a.ao(adInfoCb));
        this.dQ.setText(com.kwad.sdk.core.response.a.a.ax(adInfoCb));
        setClickable(true);
        this.Bl.setClickable(true);
        new f(this.Bl, this);
        new f(this, this);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate)) {
            b(view, false);
        }
    }
}
