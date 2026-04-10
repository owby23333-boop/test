package com.kwad.components.ad.reward.presenter.a;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.k.o;
import com.kwad.components.ad.reward.k.v;
import com.kwad.components.ad.reward.model.AdLiveEndResultData;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.a.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a {
    private IAdLiveEndRequest fV;
    private long gJ;

    @Nullable
    private o pV;

    @Nullable
    private View uj;
    private final m<com.kwad.components.core.liveEnd.a, AdLiveEndResultData> mNetworking = new m<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.a.b.1
        @NonNull
        private static AdLiveEndResultData W(String str) {
            AdLiveEndResultData adLiveEndResultData = new AdLiveEndResultData();
            adLiveEndResultData.parseJson(new JSONObject(str));
            return adLiveEndResultData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* JADX INFO: renamed from: bH, reason: merged with bridge method [inline-methods] */
        public com.kwad.components.core.liveEnd.a createRequest() {
            return new com.kwad.components.core.liveEnd.a(b.this.fV);
        }

        @Override // com.kwad.sdk.core.network.m
        public final boolean isPostByJson() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.m
        @NonNull
        public final /* synthetic */ BaseResultData parseData(String str) {
            return W(str);
        }
    };
    private final AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.a.b.2
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.ik();
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            b.this.gJ = j2;
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            b.this.il();
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            b.this.il();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void hQ() {
        i iVar = new i();
        y.a aVar = new y.a();
        iVar.bm(24);
        iVar.a(aVar);
        com.kwad.components.core.r.c.qa().a(this.qS.mAdTemplate, null, iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ik() {
        if (this.fV == null) {
            return;
        }
        this.mNetworking.request(new p<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.a.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar) {
                super.onStartRequest(aVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar, int i2, String str) {
                super.onError(aVar, i2, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar, @NonNull final AdLiveEndResultData adLiveEndResultData) {
                super.onSuccess(aVar, adLiveEndResultData);
                if (adLiveEndResultData.mQLivePushEndInfo == null) {
                    return;
                }
                b.this.qS.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.a.b.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (b.this.pV == null) {
                            b bVar = b.this;
                            bVar.pV = new o(bVar.qS);
                        }
                        b.this.pV.f(b.this.qS.mRootContainer);
                        b.this.pV.b(v.C(b.this.qS.mAdTemplate));
                        b.this.pV.a(b.this.qS, adLiveEndResultData.mQLivePushEndInfo, b.this.gJ);
                        b.this.qS.pV = b.this.pV;
                        b bVar2 = b.this;
                        bVar2.uj = bVar2.findViewById(R.id.ksad_live_end_page_layout_root);
                        b.this.uj.setVisibility(0);
                        b.this.hQ();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void il() {
        View view = this.uj;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        com.kwad.components.core.offline.api.kwai.a aVar;
        super.ar();
        if (this.qS.pw.jY()) {
            this.qS.pw.a(null, this.mAdLivePlayStateListener);
            String strAZ = com.kwad.sdk.core.response.a.a.aZ(d.cb(this.qS.mAdTemplate));
            if (TextUtils.isEmpty(strAZ) || (aVar = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class)) == null) {
                return;
            }
            this.fV = aVar.getAdLiveEndRequest(strAZ);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mNetworking.cancel();
        if (this.qS.pw.jY()) {
            this.qS.pw.b(null, this.mAdLivePlayStateListener);
        }
    }
}
