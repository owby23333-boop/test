package com.kwad.components.ad.reward.h.kwai;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.webview.a.b.d;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.core.webview.a.b.d {
    private static WeakReference<b> xz;
    private long mPlayedDuration;
    private j xw;

    @Nullable
    public static b a(b bVar, Activity activity, long j2, com.kwad.components.core.webview.a.d.c cVar, d.a aVar) {
        if (activity == null || activity.isFinishing() || jx()) {
            return null;
        }
        bVar.Ps = cVar;
        bVar.Vn = aVar;
        bVar.show(activity.getFragmentManager(), "tkCloseDialog");
        if (j2 > 0) {
            bVar.k(j2);
        }
        xz = new WeakReference<>(bVar);
        return bVar;
    }

    @Nullable
    public static b a(j jVar, Activity activity, long j2, DialogInterface.OnDismissListener onDismissListener, com.kwad.components.core.webview.a.d.c cVar) {
        if (activity == null || activity.isFinishing() || jx()) {
            return null;
        }
        d.b bVar = new d.b();
        bVar.setAdTemplate(jVar.mAdTemplate);
        bVar.aH("ksad-video-secondclick-card");
        b bVarA = a(jVar, bVar);
        bVarA.Ps = cVar;
        bVarA.d(onDismissListener);
        bVarA.k(j2);
        bVarA.show(activity.getFragmentManager(), "tkExtraReward");
        xz = new WeakReference<>(bVarA);
        return bVarA;
    }

    public static b a(j jVar, d.b bVar) {
        b bVar2 = new b();
        bVar2.xw = jVar;
        bVar2.mAdTemplate = bVar.getAdTemplate();
        bVar2.Vk = bVar.getTemplateId();
        bVar2.Vm = bVar.rC();
        bVar2.Vu = bVar.rD();
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        bVar2.setArguments(bundle);
        return bVar2;
    }

    private static boolean jx() {
        WeakReference<b> weakReference = xz;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    private void k(long j2) {
        this.mPlayedDuration = j2;
        com.kwad.components.core.webview.a.b.b bVar = this.Vi;
        if (bVar != null) {
            bVar.mPlayedDuration = j2;
        }
    }

    @Override // com.kwad.components.core.webview.a.b.d
    public final void jA() {
        super.jA();
        this.Vi.mPlayedDuration = this.mPlayedDuration;
    }

    @Override // com.kwad.components.core.webview.a.b.d
    public final com.kwad.components.core.webview.a.b.b jy() {
        return new a(this.xw);
    }

    @Override // com.kwad.components.core.webview.a.b.d
    public final com.kwad.components.core.webview.a.b.c jz() {
        return new c();
    }

    @Override // com.kwad.components.core.webview.a.b.d, android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.xw = null;
        xz = null;
    }
}
