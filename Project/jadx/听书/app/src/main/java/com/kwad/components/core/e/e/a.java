package com.kwad.components.core.e.e;

import android.app.DialogFragment;
import android.content.Context;
import android.view.View;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.o.m;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends KSFrameLayout {
    private final DialogFragment PR;
    private final View PS;
    private a.C0333a PT;

    public a(Context context, DialogFragment dialogFragment, a.C0333a c0333a) {
        super(context);
        this.PR = dialogFragment;
        this.PT = c0333a;
        m.inflate(context, R.layout.ksad_seconed_confirm_dialog_layout, this);
        this.PS = findViewById(R.id.ksad_second_confirm_root_view);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        Presenter presenterBD = bD();
        presenterBD.K(this.PS);
        presenterBD.n(pX());
    }

    private static Presenter bD() {
        Presenter presenter = new Presenter();
        presenter.a(new d());
        return presenter;
    }

    private c pX() {
        c cVar = new c();
        cVar.PR = this.PR;
        cVar.PT = this.PT;
        return cVar;
    }
}
