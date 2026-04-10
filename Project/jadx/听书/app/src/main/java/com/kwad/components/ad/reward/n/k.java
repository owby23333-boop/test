package com.kwad.components.ad.reward.n;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends d implements com.kwad.sdk.widget.d {
    private ViewStub CB;
    private ViewGroup CC;
    private KsStyledTextButton CD;
    private KsStyledTextButton CE;
    private KsPriceView Cd;
    private TextView Cg;
    private TextView Ch;
    private View Ci;
    private TextView fv;
    private TextView ko;
    private KSCornerImageView nR;
    private com.kwad.components.ad.reward.g tm;

    public k(com.kwad.components.ad.reward.g gVar, ViewStub viewStub) {
        this.CB = viewStub;
        this.tm = gVar;
    }

    public k(com.kwad.components.ad.reward.g gVar, ViewGroup viewGroup) {
        this.CC = viewGroup;
        this.tm = gVar;
    }

    public final void hide() {
        ViewGroup viewGroup = this.CC;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup hP() {
        return this.CC;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(rVar.getAdTemplate(), com.kwad.components.ad.reward.model.a.R(rVar.getAdTemplate()));
    }

    private void a(AdTemplate adTemplate, com.kwad.components.ad.reward.model.a aVar) {
        KSImageLoader.loadAppIcon(this.nR, aVar.ho(), adTemplate, 8);
        this.ko.setText(aVar.getTitle());
        this.fv.setText(aVar.hp());
        int dimensionPixelSize = this.CC.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_end_origin_text_size);
        this.Cd.getConfig().as(dimensionPixelSize).au(dimensionPixelSize).at(this.CC.getResources().getColor(R.color.ksad_jinniu_end_origin_color));
        this.Cd.d(aVar.getPrice(), aVar.getOriginPrice(), true);
        String strIg = aVar.ig();
        this.Ci.setVisibility(TextUtils.isEmpty(strIg) ? 8 : 0);
        if (strIg != null) {
            this.Cg.setText(strIg);
        }
        this.Ch.setText(aVar.ih());
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        f(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.ea(this.tm.mAdTemplate)) {
            f(view, false);
        }
    }

    private void f(View view, boolean z) {
        boolean zEquals = view.equals(this.CE);
        int i = MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT;
        if (zEquals) {
            com.kwad.components.ad.reward.g gVar = this.tm;
            Context context = view.getContext();
            if (z) {
                i = 38;
            }
            gVar.a(2, context, i, 1);
            return;
        }
        if (view.equals(this.CD)) {
            com.kwad.components.ad.reward.g gVar2 = this.tm;
            Context context2 = view.getContext();
            if (z) {
                i = 37;
            }
            gVar2.a(2, context2, i, 1);
            return;
        }
        if (view.equals(this.CC)) {
            com.kwad.components.ad.reward.g gVar3 = this.tm;
            Context context3 = view.getContext();
            if (z) {
                i = 2;
            }
            gVar3.a(2, context3, i, 2);
        }
    }
}
