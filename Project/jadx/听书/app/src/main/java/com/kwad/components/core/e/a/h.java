package com.kwad.components.core.e.a;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements d {
    private static WeakReference<Window> OB;
    private final com.kwad.sdk.core.c.c<Activity> An = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.e.a.h.1
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* JADX INFO: renamed from: onActivityDestroyed */
        public final void b(Activity activity) {
            super.b(activity);
            com.kwad.sdk.core.c.b.Ho();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            if (activity.equals((Activity) h.this.OA.get())) {
                h.this.fZ();
            }
        }
    };
    private WeakReference<Activity> OA;
    private g Oy;
    private b Oz;
    private ViewGroup qT;
    private boolean qU;

    public static void a(Window window) {
        OB = new WeakReference<>(window);
    }

    public static void oR() {
        WeakReference<Window> weakReference = OB;
        if (weakReference != null) {
            weakReference.clear();
        }
        OB = null;
    }

    public final boolean b(AdTemplate adTemplate, b bVar) {
        Window window;
        try {
            this.Oz = bVar;
            com.kwad.sdk.core.c.b.Ho();
            Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing()) {
                WeakReference<Window> weakReference = OB;
                if (weakReference != null) {
                    window = weakReference.get();
                } else {
                    window = currentActivity.getWindow();
                }
                View viewFindViewById = window.getDecorView().findViewById(R.id.content);
                if (!(viewFindViewById instanceof ViewGroup)) {
                    return false;
                }
                this.OA = new WeakReference<>(currentActivity);
                this.Oy = new g(m.wrapContextIfNeed(currentActivity), adTemplate, this);
                com.kwad.sdk.core.c.b.Ho();
                com.kwad.sdk.core.c.b.a(this.An);
                this.qT = (ViewGroup) viewFindViewById;
                this.qT.addView(this.Oy, new ViewGroup.LayoutParams(-1, -1));
                bVar.oI();
                return true;
            }
            com.kwad.sdk.core.d.c.d("InstalledActivateViewHelper", "showInWindow fail activity:" + currentActivity);
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.d("InstalledActivateViewHelper", "showInWindow fail error:" + th);
            com.kwad.sdk.core.d.c.printStackTrace(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fZ() {
        g gVar;
        if (this.qU) {
            return;
        }
        this.qU = true;
        this.Oz.fY();
        ViewGroup viewGroup = this.qT;
        if (viewGroup != null && (gVar = this.Oy) != null) {
            viewGroup.removeView(gVar);
        }
        com.kwad.sdk.core.c.b.Ho();
        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this.An);
    }

    @Override // com.kwad.components.core.e.a.d
    public final void oJ() {
        fZ();
    }
}
