package com.kwad.components.core.d.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.core.l.e {

    @Nullable
    private static b II;

    @NonNull
    private final C0394b IJ;
    private com.kwad.components.core.d.a.a IM;
    private boolean IN;

    public static class a {

        @Nullable
        private DialogInterface.OnShowListener IP;

        @Nullable
        private DialogInterface.OnDismissListener IQ;
        private AdTemplate adTemplate;
        private String url;

        public final a I(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final a a(@Nullable DialogInterface.OnShowListener onShowListener) {
            this.IP = onShowListener;
            return this;
        }

        public final a al(String str) {
            this.url = str;
            return this;
        }

        public final a c(@Nullable DialogInterface.OnDismissListener onDismissListener) {
            this.IQ = onDismissListener;
            return this;
        }

        public final C0394b nd() {
            if (com.kwad.components.core.a.bI.booleanValue() && (this.adTemplate == null || TextUtils.isEmpty(this.url))) {
                throw new IllegalArgumentException("param is error, please check it");
            }
            return new C0394b(this, (byte) 0);
        }
    }

    /* JADX INFO: renamed from: com.kwad.components.core.d.a.b$b, reason: collision with other inner class name */
    public static class C0394b {

        @Nullable
        protected DialogInterface.OnShowListener IP;

        @Nullable
        protected DialogInterface.OnDismissListener IQ;
        protected final AdTemplate adTemplate;
        protected String url;

        private C0394b(a aVar) {
            this.adTemplate = aVar.adTemplate;
            this.url = aVar.url;
            this.IP = aVar.IP;
            this.IQ = aVar.IQ;
        }

        /* synthetic */ C0394b(a aVar, byte b) {
            this(aVar);
        }
    }

    private b(Activity activity, @NonNull C0394b c0394b) {
        super(activity);
        this.IN = false;
        this.IJ = c0394b;
        if (com.kwad.sdk.b.kwai.a.a(activity)) {
            getWindow().addFlags(1024);
        }
        setOnShowListener(c0394b.IP);
        setOnDismissListener(c0394b.IQ);
    }

    public static boolean a(Context context, C0394b c0394b) {
        Activity activityDu;
        b bVar = II;
        if ((bVar != null && bVar.isShowing()) || (activityDu = bo.du(context)) == null || activityDu.isFinishing()) {
            return false;
        }
        com.kwad.sdk.kwai.kwai.c.tm().dismiss();
        try {
            b bVar2 = new b(activityDu, c0394b);
            II = bVar2;
            bVar2.show();
            com.kwad.sdk.core.report.a.b(c0394b.adTemplate, 86, (JSONObject) null);
            return true;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
            return false;
        }
    }

    public static boolean na() {
        b bVar = II;
        if (bVar != null) {
            return bVar.isShowing();
        }
        return false;
    }

    public final void ak(boolean z2) {
        this.IN = z2;
        dismiss();
    }

    @Override // com.kwad.components.core.l.e
    public final ViewGroup cm() {
        this.IM = new com.kwad.components.core.d.a.a(this.mContext, this, this.IJ);
        return this.IM;
    }

    @Override // com.kwad.components.core.l.e, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        II = null;
    }

    @Override // com.kwad.components.core.l.e
    public final void g(View view) {
        this.IM.setChangeListener(new a.InterfaceC0393a() { // from class: com.kwad.components.core.d.a.b.1
            @Override // com.kwad.components.core.d.a.a.InterfaceC0393a
            public final void mZ() {
                b.this.dismiss();
            }
        });
    }

    @Override // com.kwad.components.core.l.e
    public final int getLayoutId() {
        return 0;
    }

    @Override // android.app.Dialog
    public final boolean isShowing() {
        return super.isShowing();
    }

    @Override // com.kwad.components.core.l.e
    public final boolean nb() {
        return true;
    }

    public final boolean nc() {
        return this.IN;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        com.kwad.sdk.core.report.a.aA(this.IJ.adTemplate);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        II = null;
    }

    @Override // com.kwad.components.core.l.e, android.app.Dialog
    public final void onStart() {
        super.onStart();
        b bVar = II;
        if (bVar != null) {
            bVar.setTitle((CharSequence) null);
        }
    }

    @Override // android.app.Dialog
    public final void show() {
        try {
            super.show();
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }
}
