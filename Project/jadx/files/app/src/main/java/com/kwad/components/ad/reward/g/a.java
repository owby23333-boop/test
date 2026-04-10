package com.kwad.components.ad.reward.g;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Nullable;
import com.arialyy.aria.core.listener.ISchedulers;
import com.kwad.components.ad.reward.k.q;
import com.kwad.components.core.l.g;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends g implements DialogInterface.OnKeyListener, DialogInterface.OnShowListener, b {
    private static a so;
    private AdTemplate mAdTemplate;
    private q sn;

    @Nullable
    private b sp;

    public static void a(Activity activity, b bVar, AdTemplate adTemplate) {
        so = new a();
        Bundle bundle = new Bundle();
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        so.setArguments(bundle);
        so.a(bVar);
        so.show(activity.getFragmentManager(), "playAgainDialog");
    }

    private void a(@Nullable b bVar) {
        this.sp = bVar;
    }

    private void hG() {
        try {
            String string = getArguments().getString("key_template_json", null);
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(string));
            this.mAdTemplate = adTemplate;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    @Override // com.kwad.components.core.l.g
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        getDialog().requestWindowFeature(1);
        getDialog().setOnKeyListener(this);
        hG();
        if (this.sn == null) {
            this.sn = new q(layoutInflater, viewGroup);
            this.sn.b(this);
        }
        return this.sn.hc();
    }

    @Override // com.kwad.components.ad.reward.g.b
    public final void gL() {
        dismiss();
        b bVar = this.sp;
        if (bVar != null) {
            bVar.gL();
        }
        com.kwad.sdk.core.report.a.p(this.mAdTemplate, ISchedulers.SUB_STOP);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().setOnShowListener(this);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        if (i2 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        dismiss();
        b bVar = this.sp;
        if (bVar != null) {
            bVar.gL();
        }
        return true;
    }

    @Override // com.kwad.components.ad.reward.g.c, com.kwad.components.core.webview.jshandler.d.a
    public final void onPlayAgainClick(boolean z2) {
        dismiss();
        b bVar = this.sp;
        if (bVar != null) {
            bVar.onPlayAgainClick(z2);
        }
        com.kwad.sdk.core.report.a.p(this.mAdTemplate, 162);
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        y.b bVar = new y.b();
        bVar.akm = 205;
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, 162, bVar, (JSONObject) null);
    }
}
