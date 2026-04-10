package com.kwad.sdk.a.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.proxy.g;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends g {
    private static a asR;
    private final DialogInterface.OnDismissListener asS;
    private final AdTemplate mAdTemplate;
    private final DialogInterface.OnClickListener mOnClickListener;

    public static boolean a(Activity activity, AdTemplate adTemplate, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        if (activity != null && !activity.isFinishing() && adTemplate != null) {
            a aVar = asR;
            if (aVar != null && aVar.isShowing()) {
                asR.dismiss();
            }
            try {
                a aVar2 = new a(activity, adTemplate, onDismissListener, onClickListener);
                aVar2.show();
                asR = aVar2;
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(Activity activity, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        AdTemplate adTemplateCV;
        if (activity == null || activity.isFinishing() || (adTemplateCV = c.CU().CV()) == null) {
            return false;
        }
        return a(activity, adTemplateCV, onDismissListener, onClickListener);
    }

    public static boolean oW() {
        a aVar = asR;
        return aVar != null && aVar.isShowing();
    }

    public static boolean CP() {
        a aVar = asR;
        if (aVar == null || !aVar.isShowing()) {
            return false;
        }
        asR.dismiss();
        return true;
    }

    private a(Activity activity, AdTemplate adTemplate, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        super(activity);
        this.mAdTemplate = adTemplate;
        this.asS = onDismissListener;
        this.mOnClickListener = onClickListener;
    }

    @Override // com.kwad.components.core.proxy.g
    public final int getLayoutId() {
        return R.layout.ksad_install_dialog;
    }

    @Override // com.kwad.components.core.proxy.g
    public final void h(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ksad_install_tips_content);
        TextView textView2 = (TextView) view.findViewById(R.id.ksad_install_cancel);
        TextView textView3 = (TextView) view.findViewById(R.id.ksad_install_tv);
        final AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
        String strF = d.F(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate));
        if (strF.equals("")) {
            strF = this.mContext.getString(R.string.ksad_install_tips, com.kwad.sdk.core.response.b.a.av(adInfoEl));
        }
        textView.setText(strF);
        textView3.setText(d.Da());
        textView2.setText(d.Db());
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.a.a.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.dismiss();
                if (a.this.mOnClickListener != null) {
                    a.this.mOnClickListener.onClick(a.this, -2);
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.a.a.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (a.this.mOnClickListener != null) {
                    a.this.mOnClickListener.onClick(a.this, -1);
                }
                as.a(com.kwad.sdk.core.download.a.H(adInfoEl), new as.a() { // from class: com.kwad.sdk.a.a.a.2.1
                    @Override // com.kwad.sdk.utils.as.a
                    public final void pR() {
                        com.kwad.sdk.core.adlog.c.h(a.this.mAdTemplate, 1);
                        com.kwad.sdk.commercial.a.a.bk(a.this.mAdTemplate);
                    }

                    @Override // com.kwad.sdk.utils.as.a
                    public final void d(Throwable th) {
                        com.kwad.sdk.commercial.a.a.i(a.this.mAdTemplate, 100003, Log.getStackTraceString(th));
                    }
                });
            }
        });
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        try {
            super.dismiss();
            DialogInterface.OnDismissListener onDismissListener = this.asS;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(this);
            }
            asR = null;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
