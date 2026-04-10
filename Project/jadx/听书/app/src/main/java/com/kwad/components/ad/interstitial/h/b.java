package com.kwad.components.ad.interstitial.h;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.media3.extractor.ts.TsExtractor;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.core.proxy.j;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends j implements View.OnClickListener {
    private static boolean nV;
    private TextView fv;
    private TextView ko;
    private AdTemplate mAdTemplate;
    private com.kwad.components.ad.interstitial.f.c mj;
    private KSCornerImageView nR;
    private TextView nS;
    private TextView nT;
    private TextView nU;

    public static void e(com.kwad.components.ad.interstitial.f.c cVar) {
        if (nV) {
            return;
        }
        nV = true;
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_TEMPLATE", cVar.mAdTemplate.toJson().toString());
        bVar.setArguments(bundle);
        bVar.f(cVar);
        bVar.show(cVar.kW.getOwnerActivity().getFragmentManager(), "interstitialCloseDialog");
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        String string = getArguments().getString("KEY_TEMPLATE");
        try {
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        View viewInflate = layoutInflater.inflate(R.layout.ksad_interstitial_exit_intercept_dialog, viewGroup);
        j(viewInflate);
        initData();
        return viewInflate;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCancelable(false);
        com.kwad.components.ad.interstitial.f.c cVar = this.mj;
        if (cVar != null) {
            com.kwad.sdk.core.adlog.c.d(cVar.mAdTemplate, new JSONObject(), new com.kwad.sdk.core.adlog.c.b().df(149).dk(9));
        }
    }

    private void j(View view) {
        this.nR = (KSCornerImageView) view.findViewById(R.id.ksad_interstitial_intercept_app_icon);
        this.ko = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_app_title);
        this.fv = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_desc);
        this.nS = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_detail);
        this.nT = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_btn_continue);
        TextView textView = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_btn_deny);
        this.nU = textView;
        com.kwad.sdk.c.a.a.a(this, this.nR, this.ko, this.fv, this.nS, this.nT, textView);
    }

    private void initData() {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
        KSImageLoader.loadAppIcon(this.nR, com.kwad.sdk.core.response.b.a.co(adInfoEl), this.mAdTemplate, 12);
        this.ko.setText(com.kwad.sdk.core.response.b.a.cl(adInfoEl));
        this.fv.setText(com.kwad.sdk.core.response.b.a.au(adInfoEl));
        if (com.kwad.sdk.core.response.b.a.co(this.mAdTemplate)) {
            this.nS.setText(com.kwad.sdk.core.response.b.a.aE(adInfoEl));
        }
    }

    private void f(com.kwad.components.ad.interstitial.f.c cVar) {
        this.mj = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.mj != null) {
            if (view.equals(this.nR)) {
                com.kwad.components.ad.interstitial.f.c cVar = this.mj;
                cVar.a(cVar.kW.getContext(), 127, 2, 9);
            } else if (view.equals(this.ko)) {
                com.kwad.components.ad.interstitial.f.c cVar2 = this.mj;
                cVar2.a(cVar2.kW.getContext(), 128, 2, 9);
            } else if (view.equals(this.fv)) {
                com.kwad.components.ad.interstitial.f.c cVar3 = this.mj;
                cVar3.a(cVar3.kW.getContext(), TsExtractor.TS_STREAM_TYPE_AC3, 2, 9);
            } else if (view.equals(this.nS)) {
                com.kwad.components.ad.interstitial.f.c cVar4 = this.mj;
                cVar4.a(cVar4.kW.getContext(), 131, 2, 9);
            } else if (view.equals(this.nT)) {
                com.kwad.sdk.core.adlog.c.c(this.mj.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().dk(9));
            } else if (view.equals(this.nU)) {
                com.kwad.components.ad.interstitial.f.c cVar5 = this.mj;
                cVar5.a(false, -1, cVar5.cq);
                this.mj.kW.dismiss();
                com.kwad.sdk.core.adlog.c.e(this.mj.mAdTemplate, null, new com.kwad.sdk.core.adlog.c.b().df(MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS).dk(9));
            }
        }
        dismiss();
        nV = false;
    }
}
