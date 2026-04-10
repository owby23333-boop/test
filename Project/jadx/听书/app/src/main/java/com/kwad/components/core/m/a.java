package com.kwad.components.core.m;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.kwad.sdk.mvp.a {
    public List<com.kwad.components.core.m.a.a> Rt = new ArrayList();
    private final b<?> Ru;
    public final Context mContext;
    public final View mRootView;

    public a(b<?> bVar) {
        this.Ru = bVar;
        this.mContext = bVar.mContext;
        this.mRootView = bVar.mRootView;
    }

    @Override // com.kwad.sdk.mvp.a
    public void release() {
        this.Rt.clear();
    }

    public final void iz() {
        this.Ru.finish();
    }

    @Deprecated
    public final Activity getActivity() {
        return this.Ru.getActivity();
    }
}
