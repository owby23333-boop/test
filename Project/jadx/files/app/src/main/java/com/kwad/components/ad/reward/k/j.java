package com.kwad.components.ad.reward.k;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends d implements com.kwad.sdk.widget.c {
    private TextView hb;
    private KSCornerImageView lM;
    private TextView lN;
    private com.kwad.components.ad.reward.j qS;
    private TextView yB;
    private TextView yC;
    private View yD;
    private ViewStub yW;
    private ViewGroup yX;
    private KsStyledTextButton yY;
    private KsStyledTextButton yZ;
    private KsPriceView yy;

    public j(com.kwad.components.ad.reward.j jVar, ViewGroup viewGroup) {
        this.yX = viewGroup;
        this.qS = jVar;
    }

    public j(com.kwad.components.ad.reward.j jVar, ViewStub viewStub) {
        this.yW = viewStub;
        this.qS = jVar;
    }

    private void a(AdTemplate adTemplate, com.kwad.components.ad.reward.model.a aVar) {
        KSImageLoader.loadAppIcon(this.lM, aVar.fo(), adTemplate, 8);
        this.hb.setText(aVar.getTitle());
        this.lN.setText(aVar.gE());
        int dimensionPixelSize = this.yX.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_end_origin_text_size);
        this.yy.getConfig().aj(dimensionPixelSize).al(dimensionPixelSize).ak(this.yX.getResources().getColor(R.color.ksad_jinniu_end_origin_color));
        this.yy.d(aVar.getPrice(), aVar.getOriginPrice(), true);
        String strHq = aVar.hq();
        this.yD.setVisibility(TextUtils.isEmpty(strHq) ? 8 : 0);
        if (strHq != null) {
            this.yB.setText(strHq);
        }
        this.yC.setText(aVar.hr());
    }

    private void d(View view, boolean z2) {
        boolean zEquals = view.equals(this.yZ);
        int i2 = TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED;
        if (zEquals) {
            com.kwad.components.ad.reward.j jVar = this.qS;
            Context context = view.getContext();
            if (z2) {
                i2 = 38;
            }
            jVar.a(2, context, i2, 1);
            return;
        }
        if (view.equals(this.yY)) {
            com.kwad.components.ad.reward.j jVar2 = this.qS;
            Context context2 = view.getContext();
            if (z2) {
                i2 = 37;
            }
            jVar2.a(2, context2, i2, 1);
            return;
        }
        if (view.equals(this.yX)) {
            com.kwad.components.ad.reward.j jVar3 = this.qS;
            Context context3 = view.getContext();
            if (z2) {
                i2 = 2;
            }
            jVar3.a(2, context3, i2, 2);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        d(view, true);
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(v vVar) {
        super.a(vVar);
        a(vVar.getAdTemplate(), com.kwad.components.ad.reward.model.a.v(vVar.getAdTemplate()));
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.a.c.bQ(this.qS.mAdTemplate)) {
            d(view, false);
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup hc() {
        return this.yX;
    }

    public final void hide() {
        ViewGroup viewGroup = this.yX;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }
}
