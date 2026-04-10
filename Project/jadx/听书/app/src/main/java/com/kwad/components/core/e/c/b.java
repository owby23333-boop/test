package com.kwad.components.core.e.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.e.c.a;
import com.kwad.components.core.proxy.g;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends g {
    private static b OG;
    private final C0332b OH;
    private com.kwad.components.core.e.c.a OL;
    private boolean OM;

    @Override // com.kwad.components.core.proxy.g
    public final int getLayoutId() {
        return 0;
    }

    @Override // com.kwad.components.core.proxy.g
    public final boolean oX() {
        return true;
    }

    public static boolean a(Context context, C0332b c0332b) {
        Activity activityEj;
        b bVar = OG;
        if ((bVar == null || !bVar.isShowing()) && context != null && (activityEj = m.ej(context)) != null && !activityEj.isFinishing()) {
            com.kwad.sdk.a.a.c.CU().dismiss();
            try {
                b bVar2 = new b(activityEj, c0332b);
                OG = bVar2;
                bVar2.show();
                com.kwad.sdk.core.adlog.c.b(c0332b.adTemplate, 86, (JSONObject) null);
                return true;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        }
        return false;
    }

    public static boolean oW() {
        b bVar = OG;
        if (bVar != null) {
            return bVar.isShowing();
        }
        return false;
    }

    private b(Activity activity, C0332b c0332b) {
        super(activity);
        this.OM = false;
        this.OH = c0332b;
        if (com.kwad.sdk.c.a.a.d(activity)) {
            getWindow().addFlags(1024);
        }
        setOnShowListener(c0332b.OO);
        setOnDismissListener(c0332b.OP);
    }

    @Override // com.kwad.components.core.proxy.g
    public final ViewGroup dw() {
        com.kwad.components.core.e.c.a aVar = new com.kwad.components.core.e.c.a(this.mContext, this, this.OH);
        this.OL = aVar;
        return aVar;
    }

    @Override // com.kwad.components.core.proxy.g
    public final void h(View view) {
        this.OL.setChangeListener(new a.InterfaceC0331a() { // from class: com.kwad.components.core.e.c.b.1
            @Override // com.kwad.components.core.e.c.a.InterfaceC0331a
            public final void oV() {
                b.this.dismiss();
            }
        });
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog
    public final void onStart() {
        super.onStart();
        b bVar = OG;
        if (bVar != null) {
            bVar.setTitle((CharSequence) null);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OG = null;
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        OG = null;
    }

    public final void al(boolean z) {
        this.OM = z;
        dismiss();
    }

    public final boolean oY() {
        return this.OM;
    }

    @Override // android.app.Dialog
    public final void show() {
        Resources resources;
        int identifier;
        try {
            super.show();
            try {
                if (((getContext() == null || (resources = getContext().getResources()) == null || (identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) ? 0 : getContext().getResources().getDimensionPixelSize(identifier)) > 0) {
                    getWindow().getDecorView().setSystemUiVisibility(5382);
                    return;
                }
                return;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                return;
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
    }

    @Override // android.app.Dialog
    public final boolean isShowing() {
        return super.isShowing();
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        com.kwad.sdk.core.adlog.c.cb(this.OH.adTemplate);
    }

    /* JADX INFO: renamed from: com.kwad.components.core.e.c.b$b, reason: collision with other inner class name */
    public static class C0332b {
        protected DialogInterface.OnShowListener OO;
        protected DialogInterface.OnDismissListener OP;
        protected final AdTemplate adTemplate;
        protected String url;

        /* synthetic */ C0332b(a aVar, byte b) {
            this(aVar);
        }

        private C0332b(a aVar) {
            this.adTemplate = aVar.adTemplate;
            this.url = aVar.url;
            this.OO = aVar.OO;
            this.OP = aVar.OP;
        }
    }

    public static class a {
        private DialogInterface.OnShowListener OO;
        private DialogInterface.OnDismissListener OP;
        private AdTemplate adTemplate;
        private String url;

        public final a aA(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final a ak(String str) {
            this.url = str;
            return this;
        }

        public final a a(DialogInterface.OnShowListener onShowListener) {
            this.OO = onShowListener;
            return this;
        }

        public final a c(DialogInterface.OnDismissListener onDismissListener) {
            this.OP = onDismissListener;
            return this;
        }

        public final C0332b oZ() {
            if (com.kwad.components.core.a.oz.booleanValue() && (this.adTemplate == null || TextUtils.isEmpty(this.url))) {
                throw new IllegalArgumentException("param is error, please check it");
            }
            return new C0332b(this, (byte) 0);
        }
    }
}
