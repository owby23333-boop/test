package com.kwad.components.ad.splashscreen.b;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends e {
    private static void j(View view, int i2) {
        if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = i2;
            view.setLayoutParams(layoutParams);
        } else if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.topMargin = i2;
            view.setLayoutParams(layoutParams2);
        }
    }

    private void li() {
        bh.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.g.1
            @Override // java.lang.Runnable
            public final void run() {
                if (g.this.getActivity() != null) {
                    try {
                        ViewGroup viewGroup = (ViewGroup) g.this.getActivity().getWindow().getDecorView();
                        if (com.kwad.sdk.b.kwai.a.B(viewGroup) && com.kwad.sdk.b.kwai.a.aF(g.this.getActivity()) == viewGroup.getHeight()) {
                            g.this.lj();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lj() {
        int i2 = this.Cx.BR;
        if (i2 == 1 || i2 == 0) {
            j(this.Cx.mRootContainer.findViewById(R.id.ksad_preload_container), lk());
        }
        com.kwad.components.ad.splashscreen.h hVar = this.Cx;
        if (hVar.BR == 0) {
            j(hVar.mRootContainer.findViewById(R.id.ksad_splash_logo_container), com.kwad.sdk.b.kwai.a.getStatusBarHeight(getActivity()) + com.kwad.sdk.b.kwai.a.a(getContext(), 12.0f));
            j(this.Cx.mRootContainer.findViewById(R.id.ksad_splash_sound), com.kwad.sdk.b.kwai.a.getStatusBarHeight(getActivity()) + com.kwad.sdk.b.kwai.a.a(getContext(), 32.0f));
            j(this.Cx.mRootContainer.findViewById(R.id.ksad_skip_view_area), com.kwad.sdk.b.kwai.a.getStatusBarHeight(getActivity()));
        }
        if (com.kwad.sdk.core.response.a.a.aV(com.kwad.sdk.core.response.a.d.cb(this.Cx.mAdTemplate))) {
            return;
        }
        int i3 = this.Cx.BR;
        if (i3 == 2 || i3 == 3) {
            j(this.Cx.mRootContainer.findViewById(R.id.ksad_compliance_view), com.kwad.sdk.b.kwai.a.getStatusBarHeight(getActivity()));
        }
    }

    private int lk() {
        Activity activity;
        float f2;
        int i2 = this.Cx.BR;
        if (i2 == 1) {
            activity = getActivity();
            f2 = 16.0f;
        } else {
            if (i2 != 0) {
                return 0;
            }
            activity = getActivity();
            f2 = 32.0f;
        }
        return com.kwad.sdk.b.kwai.a.a(activity, f2) + com.kwad.sdk.b.kwai.a.getStatusBarHeight(getActivity());
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        li();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
