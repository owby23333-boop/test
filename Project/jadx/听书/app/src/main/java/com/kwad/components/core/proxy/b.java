package com.kwad.components.core.proxy;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements Application.ActivityLifecycleCallbacks {
    private k Wc;
    private Set<c> Wd = new HashSet();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public b(k kVar) {
        this.Wc = kVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity activity, Bundle bundle) {
        this.Wd.add(new c(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        c cVarB = b(activity);
        if (cVarB != null) {
            cVarB.a(Lifecycle.Event.ON_CREATE);
            k kVar = this.Wc;
            if (kVar != null) {
                kVar.a(cVarB);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityCreated : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        c cVarB = b(activity);
        if (cVarB != null) {
            cVarB.a(Lifecycle.Event.ON_START);
            k kVar = this.Wc;
            if (kVar != null) {
                kVar.b(cVarB);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityStarted : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        c cVarB = b(activity);
        if (cVarB != null) {
            cVarB.a(Lifecycle.Event.ON_RESUME);
            k kVar = this.Wc;
            if (kVar != null) {
                kVar.c(cVarB);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityResumed : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        c cVarB = b(activity);
        if (cVarB != null) {
            cVarB.a(Lifecycle.Event.ON_PAUSE);
            k kVar = this.Wc;
            if (kVar != null) {
                kVar.d(cVarB);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityPaused : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        c cVarB = b(activity);
        if (cVarB != null) {
            cVarB.a(Lifecycle.Event.ON_STOP);
            k kVar = this.Wc;
            if (kVar != null) {
                kVar.e(cVarB);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityStopped : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        c cVarB = b(activity);
        if (cVarB != null) {
            k kVar = this.Wc;
            if (kVar != null) {
                kVar.f(cVarB);
            }
            this.Wd.remove(cVarB);
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityDestroyed : " + activity);
    }

    private c b(Activity activity) {
        for (c cVar : this.Wd) {
            if (cVar.c(activity)) {
                return cVar;
            }
        }
        return null;
    }
}
