package com.kwad.components.ad.e.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.bf;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.e.kwai.a implements View.OnClickListener {
    private KsAdVideoPlayConfig dY;
    private ViewGroup nj;
    private ImageView nk;
    private TextView nl;

    public a(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.dY = ksAdVideoPlayConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eS() {
        if (this.nj.getVisibility() != 0) {
            return;
        }
        this.nj.setVisibility(8);
    }

    private boolean f(AdInfo adInfo) {
        if (!af.isNetworkConnected(getContext())) {
            return false;
        }
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dY;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return true;
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return af.isWifiConnected(getContext());
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                return af.isWifiConnected(getContext()) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && af.isMobileConnected(getContext()));
            }
        }
        if (com.kwad.sdk.core.response.a.a.bG(adInfo)) {
            return true;
        }
        return com.kwad.sdk.core.response.a.a.bH(adInfo) && af.isWifiConnected(getContext());
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        ViewGroup viewGroup;
        int i2;
        super.ar();
        if (f(com.kwad.sdk.core.response.a.d.cb(this.nf.mAdTemplate))) {
            viewGroup = this.nj;
            i2 = 8;
        } else {
            this.nl.setText(bf.H(com.kwad.sdk.core.response.a.a.F(r0) * 1000));
            this.nk.setOnClickListener(this);
            this.nf.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            viewGroup = this.nj;
            i2 = 0;
        }
        viewGroup.setVisibility(i2);
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.a.1
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                super.onVideoPlayStart();
                a.this.eS();
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlaying() {
                super.onVideoPlaying();
                a.this.eS();
            }
        };
        this.nf.ng.a(this.mVideoPlayStateListener);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.nk) {
            this.nf.ng.fa();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nj = (ViewGroup) findViewById(R.id.ksad_data_flow_container);
        this.nk = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.nl = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
    }
}
