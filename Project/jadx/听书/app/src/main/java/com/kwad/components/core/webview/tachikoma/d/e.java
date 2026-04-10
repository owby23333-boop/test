package com.kwad.components.core.webview.tachikoma.d;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.kwad.components.core.proxy.j;
import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class e extends j {
    public String AI;
    public com.kwad.components.core.webview.tachikoma.f.c Yd;
    protected StyleTemplate Yf;
    private d ahA;
    private KSFrameLayout ahB;
    protected List<DialogInterface.OnDismissListener> ahC = new CopyOnWriteArrayList();
    public boolean ahD = false;
    protected com.kwad.components.core.webview.tachikoma.d.b ahp;
    protected l ahr;
    protected k ahs;
    public boolean aht;
    public a ahu;
    private com.kwad.components.core.webview.tachikoma.f.e ahx;
    public AdResultData mAdResultData;
    private Presenter mPresenter;

    public interface a {
        boolean hc();
    }

    public static e b(b bVar) {
        e eVar = new e();
        eVar.mAdResultData = bVar.iu();
        eVar.AI = bVar.getTemplateId();
        eVar.aht = bVar.aht;
        eVar.ahD = bVar.ahD;
        eVar.Yf = bVar.ahF;
        eVar.ahr = bVar.ahr;
        eVar.ahs = bVar.ahG;
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        eVar.setArguments(bundle);
        return eVar;
    }

    public final void a(com.kwad.components.core.webview.tachikoma.f.e eVar) {
        this.ahx = eVar;
    }

    public final void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.ahC.add(onDismissListener);
        }
    }

    public final void e(DialogInterface.OnDismissListener onDismissListener) {
        this.ahC.remove(onDismissListener);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.AI = getArguments().getString("templateId");
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (this.ahB == null) {
            this.ahB = (KSFrameLayout) layoutInflater.inflate(R.layout.ksad_video_tk_dialog_layout, viewGroup, false);
        }
        return this.ahB;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        try {
            super.onDestroyView();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("TkDialogFragment", "destroy view failed:" + th);
        }
        KSFrameLayout kSFrameLayout = this.ahB;
        if (kSFrameLayout != null && (kSFrameLayout.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ahB.getParent()).removeView(this.ahB);
            this.ahB = null;
        }
        com.kwad.components.core.webview.tachikoma.f.e eVar = this.ahx;
        if (eVar != null) {
            eVar.hi();
        }
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        D(view);
        com.kwad.components.core.webview.tachikoma.f.c cVar = this.Yd;
        if (cVar != null) {
            cVar.ha();
        }
        com.kwad.components.core.webview.tachikoma.f.e eVar = this.ahx;
        if (eVar != null) {
            eVar.ha();
        }
    }

    private void D(View view) {
        if (this.ahp == null) {
            this.ahp = ku();
        }
        kw();
        if (this.mPresenter == null) {
            Presenter presenterBD = bD();
            this.mPresenter = presenterBD;
            presenterBD.K(view);
        }
        this.mPresenter.n(this.ahp);
    }

    protected com.kwad.components.core.webview.tachikoma.d.b ku() {
        return new com.kwad.components.core.webview.tachikoma.d.b();
    }

    private Presenter bD() {
        this.mPresenter = new Presenter();
        if (this.ahp.ahs != null) {
            this.mPresenter.a(vG());
        } else {
            this.mPresenter.a(kv());
        }
        return this.mPresenter;
    }

    protected c kv() {
        return new c();
    }

    private d vG() {
        if (this.ahA == null) {
            this.ahA = new d();
        }
        return this.ahA;
    }

    protected void kw() {
        this.ahp.a(this.mAdResultData);
        this.ahp.mActivity = getActivity();
        this.ahp.afi = this;
        this.ahp.ahq = this.ahB;
        this.ahp.AI = this.AI;
        this.ahp.Yf = this.Yf;
        this.ahp.aht = this.aht;
        this.ahp.ahr = this.ahr;
        this.ahp.ahs = this.ahs;
        this.ahp.ahu = this.ahu;
        this.ahp.Yd = this.Yd;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.kwad.components.core.webview.tachikoma.f.c cVar = this.Yd;
        if (cVar != null) {
            cVar.hi();
        }
        for (DialogInterface.OnDismissListener onDismissListener : this.ahC) {
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
        l lVar = this.ahr;
        if (lVar != null) {
            lVar.callbackDialogDismiss();
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
            this.mPresenter = null;
        }
        com.kwad.components.core.webview.tachikoma.d.b bVar = this.ahp;
        if (bVar != null) {
            bVar.release();
            this.ahp = null;
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Window window;
        Resources resources;
        int identifier;
        try {
            super.onActivityCreated(bundle);
        } catch (Throwable unused) {
        }
        if (getDialog() == null || (window = getDialog().getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        int dimensionPixelSize = 0;
        getDialog().setCanceledOnTouchOutside(false);
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        window.setSoftInputMode(16);
        if (d(getDialog().getOwnerActivity())) {
            window.setFlags(1024, 1024);
        }
        try {
            if (this.ahr.isHideNavigationBar()) {
                if (getContext() != null && (resources = getContext().getResources()) != null && (identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android")) > 0) {
                    dimensionPixelSize = getContext().getResources().getDimensionPixelSize(identifier);
                }
                if (dimensionPixelSize > 0) {
                    getDialog().getWindow().getDecorView().setSystemUiVisibility(5382);
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.webview.tachikoma.d.e.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 0) {
                    return false;
                }
                if (e.this.ahD) {
                    return true;
                }
                if (e.this.ahA != null) {
                    return e.this.ahA.onBackPressed();
                }
                return false;
            }
        });
    }

    private static boolean d(Activity activity) {
        return activity != null && (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static class b {
        private boolean ahD;
        private StyleTemplate ahF;
        private k ahG;
        private l ahr;
        private boolean aht;
        private AdResultData mAdResultData;
        private String templateId;

        public final AdResultData iu() {
            return this.mAdResultData;
        }

        public final void a(AdResultData adResultData) {
            this.mAdResultData = adResultData;
        }

        public final String getTemplateId() {
            return this.templateId;
        }

        public final void bg(String str) {
            this.templateId = str;
        }

        public final void a(StyleTemplate styleTemplate) {
            this.ahF = styleTemplate;
        }

        public final void a(k kVar) {
            this.ahG = kVar;
        }

        public final boolean ln() {
            return this.aht;
        }

        public final void aZ(boolean z) {
            this.aht = false;
        }

        public final void ba(boolean z) {
            this.ahD = true;
        }

        public final boolean vH() {
            return this.ahD;
        }

        public final void c(l lVar) {
            this.ahr = lVar;
        }
    }
}
