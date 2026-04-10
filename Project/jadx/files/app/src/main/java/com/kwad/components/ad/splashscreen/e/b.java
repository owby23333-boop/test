package com.kwad.components.ad.splashscreen.e;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.f;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.kwad.sdk.widget.c {
    private a CL;
    private f EA;
    private ViewStub Eu;
    private ViewGroup Ev;
    private View Ew;
    private TextView Ex;
    private boolean Ey;

    @Nullable
    private e Ez;

    @NonNull
    private ViewGroup gu;

    @Nullable
    private AdInfo mAdInfo;

    @Nullable
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;

    public b(@NonNull ViewGroup viewGroup, ViewStub viewStub, boolean z2, com.kwad.components.core.d.b.c cVar) {
        this.gu = viewGroup;
        this.Eu = viewStub;
        this.mApkDownloadHelper = cVar;
        this.Ey = z2;
    }

    private void a(com.kwad.components.ad.splashscreen.d dVar) {
        if (dVar == null) {
            return;
        }
        ac(dVar.kI());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(String str) {
        TextView textView = this.Ex;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    private void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.Ew = viewGroup.findViewById(R.id.ksad_splash_actionbar_native);
        this.Ex = (TextView) viewGroup.findViewById(R.id.ksad_splash_actionbar_text);
        this.EA = new f(this.Ew.getContext(), this.Ew, this);
        this.Ew.getContext();
        a(com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mAdInfo, this.mApkDownloadHelper, 4));
    }

    private void g(boolean z2, boolean z3) {
        e eVar = this.Ez;
        if (eVar != null) {
            eVar.f(z2, z3);
        }
    }

    public final void D(AdTemplate adTemplate) {
        a aVar;
        this.mAdTemplate = adTemplate;
        a aVar2 = this.CL;
        if (aVar2 == null) {
            this.CL = new a(this.gu.getContext(), this.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.e.b.1
                @Override // com.kwad.components.ad.splashscreen.e.a
                protected final void aa(String str) {
                    b.this.ac(str);
                }
            };
        } else {
            aVar2.setAdTemplate(this.mAdTemplate);
        }
        if (adTemplate != null) {
            this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        }
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (aVar = this.CL) == null) {
            return;
        }
        cVar.b(aVar);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        g(true, view.equals(this.Ew));
    }

    public final void a(@Nullable e eVar) {
        this.Ez = eVar;
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (this.Ey) {
            g(false, view.equals(this.Ew));
        }
    }

    public final void lD() {
        com.kwad.sdk.core.d.b.d("SplashActionBarNativeHelper", "rollBackToNative mRootViewStub: " + this.Eu);
        if (this.Ev == null) {
            ViewStub viewStub = this.Eu;
            this.Ev = (ViewGroup) ((viewStub == null || viewStub.getParent() == null) ? this.gu.findViewById(R.id.ksad_splash_actionbar_native_root) : this.Eu.inflate());
            g(this.Ev);
        }
        ViewGroup viewGroup = this.Ev;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public final void onUnbind() {
        a aVar;
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (aVar = this.CL) == null) {
            return;
        }
        cVar.c(aVar);
    }
}
