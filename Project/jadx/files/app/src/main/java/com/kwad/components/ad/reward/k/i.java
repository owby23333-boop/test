package com.kwad.components.ad.reward.k;

import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends d implements View.OnClickListener {
    private AdTemplate adTemplate;
    private TextView hb;
    private KSCornerImageView lM;
    private TextView lN;
    private TextView lO;
    private View oi;
    private k.a qB;
    private ViewGroup sN;
    private DialogFragment yS;
    private TextView yT;
    private View yU;
    private View yV;

    public i(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, k.a aVar) {
        this.yS = dialogFragment;
        this.adTemplate = adTemplate;
        this.qB = aVar;
        this.sN = (ViewGroup) layoutInflater.inflate(R.layout.ksad_reward_jinniu_dialog, viewGroup, false);
        initView();
    }

    private void initView() {
        this.lM = (KSCornerImageView) this.sN.findViewById(R.id.ksad_reward_jinniu_dialog_icon);
        this.hb = (TextView) this.sN.findViewById(R.id.ksad_reward_jinniu_dialog_title);
        this.lN = (TextView) this.sN.findViewById(R.id.ksad_reward_jinniu_dialog_desc);
        this.yT = (TextView) this.sN.findViewById(R.id.ksad_reward_jinniu_dialog_play_time_tips);
        this.lO = (TextView) this.sN.findViewById(R.id.ksad_reward_jinniu_dialog_detail);
        this.oi = this.sN.findViewById(R.id.ksad_reward_jinniu_dialog_btn_close);
        this.yU = this.sN.findViewById(R.id.ksad_reward_jinniu_dialog_btn_deny);
        this.yV = this.sN.findViewById(R.id.ksad_reward_jinniu_dialog_btn_continue);
        this.oi.setOnClickListener(this);
        this.yU.setOnClickListener(this);
        this.yV.setOnClickListener(this);
        this.lM.setOnClickListener(this);
        this.hb.setOnClickListener(this);
        this.lN.setOnClickListener(this);
        this.lO.setOnClickListener(this);
    }

    public final void a(k.c cVar) {
        KSImageLoader.loadAppIcon(this.lM, cVar.fo(), this.adTemplate, 4);
        this.hb.setText(cVar.getTitle());
        this.lN.setText(cVar.gE());
        this.yT.setText(cVar.gG());
        if (com.kwad.sdk.core.response.a.a.aJ(this.adTemplate)) {
            this.lO.setText(String.format("%s >", com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(this.adTemplate))));
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup hc() {
        return this.sN;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        k.a aVar;
        if (view.equals(this.oi)) {
            this.yS.dismiss();
            k.a aVar2 = this.qB;
            if (aVar2 != null) {
                aVar2.gz();
                return;
            }
            return;
        }
        if (view.equals(this.yU)) {
            this.yS.dismiss();
            k.a aVar3 = this.qB;
            if (aVar3 != null) {
                aVar3.J(false);
                return;
            }
            return;
        }
        if (view.equals(this.yV)) {
            this.yS.dismiss();
            k.a aVar4 = this.qB;
            if (aVar4 != null) {
                aVar4.gz();
                return;
            }
            return;
        }
        if (view.equals(this.lM)) {
            k.a aVar5 = this.qB;
            if (aVar5 != null) {
                aVar5.g(127, 2);
                return;
            }
            return;
        }
        if (view.equals(this.hb)) {
            k.a aVar6 = this.qB;
            if (aVar6 != null) {
                aVar6.g(128, 2);
                return;
            }
            return;
        }
        if (view.equals(this.lN)) {
            k.a aVar7 = this.qB;
            if (aVar7 != null) {
                aVar7.g(129, 2);
                return;
            }
            return;
        }
        if (!view.equals(this.lO) || (aVar = this.qB) == null) {
            return;
        }
        aVar.g(131, 2);
    }
}
