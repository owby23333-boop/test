package com.kwad.components.core.proxy;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements a {
    private final WeakReference<Activity> We;
    private com.kwad.components.core.proxy.launchdialog.d Wf;
    private com.kwad.components.core.proxy.launchdialog.d Wg;

    public c(Activity activity) {
        this.We = new WeakReference<>(activity);
    }

    public final boolean c(Activity activity) {
        WeakReference<Activity> weakReference;
        if (activity == null || (weakReference = this.We) == null || weakReference.get() == null) {
            return false;
        }
        return this.We.get().equals(activity);
    }

    @Override // com.kwad.components.core.proxy.a
    public final String getPageName() {
        WeakReference<Activity> weakReference = this.We;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.We.get().toString();
    }

    public final void a(Lifecycle.Event event) {
        this.Wf = this.Wg;
        this.Wg = new com.kwad.components.core.proxy.launchdialog.d(event);
    }

    @Override // com.kwad.components.core.proxy.a
    public final com.kwad.components.core.proxy.launchdialog.d rT() {
        return this.Wf;
    }

    @Override // com.kwad.components.core.proxy.a
    public final com.kwad.components.core.proxy.launchdialog.d rU() {
        return this.Wg;
    }
}
