package com.kwad.components.core.r;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.kwad.components.core.webview.tachikoma.d.e;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends e {
    protected com.kwad.components.core.webview.tachikoma.f.c Yd;

    public static b a(e.b bVar) {
        b bVar2 = new b();
        bVar2.mAdResultData = bVar.iu();
        bVar2.AI = bVar.getTemplateId();
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        bVar2.setArguments(bundle);
        return bVar2;
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.e, android.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.kwad.components.core.webview.tachikoma.f.c cVar = this.Yd;
        if (cVar != null) {
            cVar.ha();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.e, android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.kwad.components.core.webview.tachikoma.f.c cVar = this.Yd;
        if (cVar != null) {
            cVar.hi();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.e
    public final com.kwad.components.core.webview.tachikoma.d.b ku() {
        return super.ku();
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.e
    public final com.kwad.components.core.webview.tachikoma.d.c kv() {
        return new c();
    }

    public static b a(b bVar, Activity activity, com.kwad.components.core.webview.tachikoma.f.c cVar) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        bVar.Yd = cVar;
        bVar.show(activity.getFragmentManager(), "webTKCloseDialog");
        return bVar;
    }
}
