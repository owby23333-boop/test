package com.kwad.components.core.webview.a.b;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.l.g;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class d extends g {
    public com.kwad.components.core.webview.a.d.c Ps;
    protected com.kwad.components.core.webview.a.b.b Vi;
    public String Vk;
    protected com.kwad.sdk.components.g Vl;
    public boolean Vm;
    public a Vn;
    private com.kwad.components.core.webview.a.d.d Vq;
    private KSFrameLayout Vs;
    protected List<DialogInterface.OnDismissListener> Vt = new CopyOnWriteArrayList();
    public boolean Vu = false;
    public AdTemplate mAdTemplate;
    private Presenter mPresenter;
    protected StyleTemplate mStyleTemplate;

    public interface a {
        boolean gr();
    }

    public static class b {
        private com.kwad.sdk.components.g Vl;
        private boolean Vm;
        private boolean Vu;
        private StyleTemplate Vw;
        private AdTemplate mAdTemplate;
        private String templateId;

        public final void aH(String str) {
            this.templateId = str;
        }

        public final void aN(boolean z2) {
            this.Vm = false;
        }

        public final void aO(boolean z2) {
            this.Vu = true;
        }

        public final void c(com.kwad.sdk.components.g gVar) {
            this.Vl = gVar;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final String getTemplateId() {
            return this.templateId;
        }

        public final boolean rC() {
            return this.Vm;
        }

        public final boolean rD() {
            return this.Vu;
        }

        public final void setAdTemplate(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
        }

        public final void setStyleTemplate(StyleTemplate styleTemplate) {
            this.Vw = styleTemplate;
        }
    }

    private Presenter an() {
        this.mPresenter = new Presenter();
        this.mPresenter.a(jz());
        return this.mPresenter;
    }

    public static d b(b bVar) {
        d dVar = new d();
        dVar.mAdTemplate = bVar.getAdTemplate();
        dVar.Vk = bVar.getTemplateId();
        dVar.Vm = bVar.Vm;
        dVar.Vu = bVar.Vu;
        dVar.mStyleTemplate = bVar.Vw;
        dVar.Vl = bVar.Vl;
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        dVar.setArguments(bundle);
        return dVar;
    }

    private void z(View view) {
        if (this.mPresenter == null) {
            this.mPresenter = an();
            this.mPresenter.H(view);
            this.Vi = jy();
        }
        jA();
        this.mPresenter.f(this.Vi);
    }

    @Override // com.kwad.components.core.l.g
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        getDialog().requestWindowFeature(1);
        if (this.Vs == null) {
            this.Vs = (KSFrameLayout) layoutInflater.inflate(R.layout.ksad_video_tk_dialog_layout, viewGroup, false);
        }
        return this.Vs;
    }

    public final void a(com.kwad.components.core.webview.a.d.d dVar) {
        this.Vq = dVar;
    }

    public final void d(DialogInterface.OnDismissListener onDismissListener) {
        if (onDismissListener != null) {
            this.Vt.add(onDismissListener);
        }
    }

    public final void e(DialogInterface.OnDismissListener onDismissListener) {
        this.Vt.remove(onDismissListener);
    }

    protected void jA() {
        this.Vi.mActivity = getActivity2();
        com.kwad.components.core.webview.a.b.b bVar = this.Vi;
        bVar.mTkDialogFragment = this;
        bVar.Vj = this.Vs;
        bVar.mAdTemplate = this.mAdTemplate;
        bVar.Vk = this.Vk;
        bVar.mStyleTemplate = this.mStyleTemplate;
        bVar.Vm = this.Vm;
        bVar.Vl = this.Vl;
        bVar.Vn = this.Vn;
        bVar.Ps = this.Ps;
    }

    protected com.kwad.components.core.webview.a.b.b jy() {
        return new com.kwad.components.core.webview.a.b.b();
    }

    protected c jz() {
        return new c();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Window window;
        try {
            super.onActivityCreated(bundle);
        } catch (Throwable unused) {
        }
        if (getDialog() == null || (window = getDialog().getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        window.setAttributes(attributes);
        getDialog().setCanceledOnTouchOutside(false);
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        window.setSoftInputMode(16);
        if (this.Vu) {
            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.webview.a.b.d.1
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                    return i2 == 4 && keyEvent.getAction() == 0;
                }
            });
        }
        window.setFlags(1024, 1024);
        if (this.Vu) {
            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.webview.a.b.d.2
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                    return i2 == 4 && keyEvent.getAction() == 0;
                }
            });
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Vk = getArguments().getString("templateId");
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
            this.mPresenter = null;
        }
        com.kwad.components.core.webview.a.b.b bVar = this.Vi;
        if (bVar != null) {
            bVar.release();
            this.Vi = null;
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        KSFrameLayout kSFrameLayout = this.Vs;
        if (kSFrameLayout != null && (kSFrameLayout.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.Vs.getParent()).removeView(this.Vs);
            this.Vs = null;
        }
        com.kwad.components.core.webview.a.d.d dVar = this.Vq;
        if (dVar != null) {
            dVar.gy();
        }
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.kwad.components.core.webview.a.d.c cVar = this.Ps;
        if (cVar != null) {
            cVar.gy();
        }
        for (DialogInterface.OnDismissListener onDismissListener : this.Vt) {
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
        com.kwad.sdk.components.g gVar = this.Vl;
        if (gVar != null) {
            gVar.callbackDialogDismiss();
        }
    }

    @Override // android.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        z(view);
        com.kwad.components.core.webview.a.d.c cVar = this.Ps;
        if (cVar != null) {
            cVar.gs();
        }
        com.kwad.components.core.webview.a.d.d dVar = this.Vq;
        if (dVar != null) {
            dVar.gs();
        }
    }
}
