package com.kwad.components.core.j;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.kwad.sdk.mvp.a {
    public List<com.kwad.components.core.j.kwai.a> Kg = new ArrayList();

    @NonNull
    private final b<?> Kh;

    @NonNull
    public final Context mContext;

    @NonNull
    public final View mRootView;

    public a(b<?> bVar) {
        this.Kh = bVar;
        this.mContext = bVar.mContext;
        this.mRootView = bVar.mRootView;
    }

    @Deprecated
    public final Activity getActivity() {
        return this.Kh.getActivity();
    }

    public final void hH() {
        this.Kh.finish();
    }

    @Override // com.kwad.sdk.mvp.a
    public void release() {
        this.Kg.clear();
    }
}
