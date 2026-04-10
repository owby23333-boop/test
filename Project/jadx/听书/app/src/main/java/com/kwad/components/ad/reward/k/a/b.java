package com.kwad.components.ad.reward.k.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.tachikoma.d.e;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.core.webview.tachikoma.d.e {
    private static WeakReference<b> AP;
    private g AM;
    private long AO;

    private static boolean kt() {
        WeakReference<b> weakReference = AP;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public static b a(g gVar, e.b bVar) {
        b bVar2 = new b();
        bVar2.AM = gVar;
        bVar2.mAdResultData = bVar.iu();
        bVar2.AI = bVar.getTemplateId();
        bVar2.aht = bVar.ln();
        bVar2.ahD = bVar.vH();
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        bVar2.setArguments(bundle);
        return bVar2;
    }

    public static b a(b bVar, Activity activity, long j, com.kwad.components.core.webview.tachikoma.f.c cVar, e.a aVar) {
        if (activity == null || activity.isFinishing() || kt()) {
            return null;
        }
        bVar.Yd = cVar;
        bVar.ahu = aVar;
        bVar.show(activity.getFragmentManager(), "tkCloseDialog");
        if (j > 0) {
            bVar.q(j);
        }
        AP = new WeakReference<>(bVar);
        return bVar;
    }

    public static b a(g gVar, Activity activity, long j, DialogInterface.OnDismissListener onDismissListener, com.kwad.components.core.webview.tachikoma.f.c cVar) {
        if (activity == null || activity.isFinishing() || kt()) {
            return null;
        }
        e.b bVar = new e.b();
        bVar.a(gVar.mAdResultData);
        bVar.bg(com.kwad.sdk.core.response.b.b.dP(gVar.mAdTemplate));
        b bVarA = a(gVar, bVar);
        bVarA.Yd = cVar;
        bVarA.d(onDismissListener);
        bVarA.q(j);
        bVarA.show(activity.getFragmentManager(), "tkExtraReward");
        AP = new WeakReference<>(bVarA);
        return bVarA;
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.e
    public final com.kwad.components.core.webview.tachikoma.d.b ku() {
        return new a(this.AM);
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.e
    public final com.kwad.components.core.webview.tachikoma.d.c kv() {
        return new c();
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.e
    public final void kw() {
        super.kw();
        this.ahp.AO = this.AO;
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.e, android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.AM = null;
        AP = null;
    }

    private void q(long j) {
        this.AO = j;
        if (this.ahp != null) {
            this.ahp.AO = j;
        }
    }
}
