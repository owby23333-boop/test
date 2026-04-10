package com.kwad.components.ad.interstitial.e;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.tencent.smtt.sdk.TbsListener;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.kwad.components.core.l.g implements View.OnClickListener {
    private static boolean lR;
    private TextView hb;
    private com.kwad.components.ad.interstitial.c.c jq;
    private KSCornerImageView lM;
    private TextView lN;
    private TextView lO;
    private TextView lP;
    private TextView lQ;
    private AdTemplate mAdTemplate;

    public static void d(com.kwad.components.ad.interstitial.c.c cVar) {
        if (lR) {
            return;
        }
        lR = true;
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_TEMPLATE", cVar.mAdTemplate.toJson().toString());
        bVar.setArguments(bundle);
        bVar.e(cVar);
        bVar.show(cVar.hR.getOwnerActivity().getFragmentManager(), "interstitialCloseDialog");
    }

    private void e(com.kwad.components.ad.interstitial.c.c cVar) {
        this.jq = cVar;
    }

    private void i(View view) {
        this.lM = (KSCornerImageView) view.findViewById(R.id.ksad_interstitial_intercept_app_icon);
        this.hb = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_app_title);
        this.lN = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_desc);
        this.lO = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_detail);
        this.lP = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_btn_continue);
        this.lQ = (TextView) view.findViewById(R.id.ksad_interstitial_intercept_dialog_btn_deny);
        com.kwad.sdk.b.kwai.a.a(this, this.lM, this.hb, this.lN, this.lO, this.lP, this.lQ);
    }

    private void initData() {
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        KSImageLoader.loadAppIcon(this.lM, com.kwad.sdk.core.response.a.a.bL(adInfoCb), this.mAdTemplate, 12);
        this.hb.setText(com.kwad.sdk.core.response.a.a.bJ(adInfoCb));
        this.lN.setText(com.kwad.sdk.core.response.a.a.ao(adInfoCb));
        if (com.kwad.sdk.core.response.a.a.aJ(this.mAdTemplate)) {
            this.lO.setText(com.kwad.sdk.core.response.a.a.ax(adInfoCb));
        }
    }

    @Override // com.kwad.components.core.l.g
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        getDialog().requestWindowFeature(1);
        String string = getArguments().getString("KEY_TEMPLATE");
        try {
            this.mAdTemplate = new AdTemplate();
            this.mAdTemplate.parseJson(new JSONObject(string));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        View viewInflate = com.kwad.sdk.i.a.inflate(layoutInflater.getContext(), R.layout.ksad_interstitial_exit_intercept_dialog, viewGroup);
        i(viewInflate);
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
        com.kwad.components.ad.interstitial.c.c cVar = this.jq;
        if (cVar != null) {
            com.kwad.sdk.core.report.a.d(cVar.mAdTemplate, new JSONObject(), new com.kwad.sdk.core.report.i().bh(149).bj(9));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.components.ad.interstitial.c.c cVar;
        Context context;
        int i2;
        if (this.jq != null) {
            if (view.equals(this.lM)) {
                cVar = this.jq;
                context = cVar.hR.getContext();
                i2 = 127;
            } else if (view.equals(this.hb)) {
                cVar = this.jq;
                context = cVar.hR.getContext();
                i2 = 128;
            } else if (view.equals(this.lN)) {
                cVar = this.jq;
                context = cVar.hR.getContext();
                i2 = 129;
            } else if (view.equals(this.lO)) {
                cVar = this.jq;
                context = cVar.hR.getContext();
                i2 = 131;
            } else if (view.equals(this.lP)) {
                com.kwad.sdk.core.report.a.c(this.jq.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.report.i().bj(9));
            } else if (view.equals(this.lQ)) {
                com.kwad.components.ad.interstitial.c.c cVar2 = this.jq;
                cVar2.a(false, -1, cVar2.eM);
                this.jq.hR.dismiss();
                com.kwad.sdk.core.report.a.a(this.jq.mAdTemplate, new com.kwad.sdk.core.report.i().bh(TbsListener.ErrorCode.NEEDDOWNLOAD_STATIC_INSTALLING).bj(9));
            }
            cVar.a(context, i2, 2, 9);
        }
        dismiss();
        lR = false;
    }
}
