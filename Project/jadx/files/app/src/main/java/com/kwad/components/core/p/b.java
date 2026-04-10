package com.kwad.components.core.p;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.a.b.d;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends d {
    protected com.kwad.components.core.webview.a.d.c Ps;

    @Nullable
    public static b a(b bVar, Activity activity, com.kwad.components.core.webview.a.d.c cVar) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        bVar.Ps = cVar;
        bVar.show(activity.getFragmentManager(), "webTKCloseDialog");
        return bVar;
    }

    public static b a(d.b bVar) {
        b bVar2 = new b();
        bVar2.mAdTemplate = bVar.getAdTemplate();
        bVar2.Vk = bVar.getTemplateId();
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        bVar2.setArguments(bundle);
        return bVar2;
    }

    @Override // com.kwad.components.core.webview.a.b.d
    public final com.kwad.components.core.webview.a.b.b jy() {
        return super.jy();
    }

    @Override // com.kwad.components.core.webview.a.b.d
    public final com.kwad.components.core.webview.a.b.c jz() {
        return new c();
    }

    @Override // com.kwad.components.core.webview.a.b.d, android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.kwad.components.core.webview.a.d.c cVar = this.Ps;
        if (cVar != null) {
            cVar.gy();
        }
    }

    @Override // com.kwad.components.core.webview.a.b.d, android.app.Fragment
    public final void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.kwad.components.core.webview.a.d.c cVar = this.Ps;
        if (cVar != null) {
            cVar.gs();
        }
    }
}
