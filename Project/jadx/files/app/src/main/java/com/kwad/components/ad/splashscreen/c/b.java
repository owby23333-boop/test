package com.kwad.components.ad.splashscreen.c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.c;
import com.kwad.components.core.l.f;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsSplashScreenAd;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends f {
    private KsSplashScreenAd.SplashScreenAdInteractionListener BP;
    private AdResultData Eq;
    private com.kwad.sdk.core.g.b cb;

    private void a(com.kwad.sdk.core.g.b bVar) {
        this.cb = bVar;
    }

    public static b b(@NonNull AdResultData adResultData, com.kwad.sdk.core.g.b bVar, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("adResultData", adResultData);
        b bVar2 = new b();
        bVar2.setArguments(bundle);
        bVar2.a(bVar);
        bVar2.setSplashScreenAdListener(splashScreenAdInteractionListener);
        return bVar2;
    }

    private void initData() {
        this.Eq = (AdResultData) getArguments().getSerializable("adResultData");
    }

    private void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.BP = splashScreenAdInteractionListener;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initData();
        return c.a(getContext(), this.Eq, this.cb, this.BP);
    }
}
