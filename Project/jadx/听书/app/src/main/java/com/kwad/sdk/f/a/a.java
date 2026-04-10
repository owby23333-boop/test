package com.kwad.sdk.f.a;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.z;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static volatile a aRe;
    private Activity mActivity;
    private int aRf = 3;
    private int aRg = 3;
    private int aRh = 3;
    private int aRi = 3;
    private AtomicBoolean aRj = new AtomicBoolean(false);
    private boolean aRk = false;
    private AtomicBoolean aRl = new AtomicBoolean(false);
    private AtomicBoolean mHasInit = new AtomicBoolean(false);

    private static boolean dW(int i) {
        return (i & 1) != 0;
    }

    private static boolean dX(int i) {
        return (i & 2) != 0;
    }

    private static boolean dY(int i) {
        return i == 1;
    }

    static /* synthetic */ int b(a aVar, Activity activity) {
        return k(activity);
    }

    static /* synthetic */ int c(a aVar, Activity activity) {
        return j(activity);
    }

    public static a Mq() {
        if (aRe == null) {
            synchronized (a.class) {
                if (aRe == null) {
                    aRe = new a();
                }
            }
        }
        return aRe;
    }

    public final void init(int i) {
        if (this.mHasInit.get() || i == 0) {
            return;
        }
        Mr();
        if (dW(i)) {
            this.aRk = true;
        }
        if (dX(i)) {
            this.aRj.set(true);
        }
        this.mHasInit.set(true);
    }

    private void Mr() {
        this.aRf = Build.VERSION.SDK_INT;
        b.Ho();
        b.a(new d() { // from class: com.kwad.sdk.f.a.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* JADX INFO: renamed from: onActivityCreated */
            public final void a(Activity activity, Bundle bundle) {
                super.a(activity, bundle);
                try {
                    a.this.mActivity = activity;
                    if (a.this.aRl.get()) {
                        return;
                    }
                    a aVar = a.this;
                    aVar.aRh = a.b(aVar, activity);
                    a aVar2 = a.this;
                    aVar2.aRg = a.c(aVar2, activity);
                    a.this.Ms();
                } catch (Throwable th) {
                    c.e("HdrHelper", "collectHdrAbility error", th);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* JADX INFO: renamed from: onActivityDestroyed */
            public final void b(Activity activity) {
                a.this.mActivity = null;
                b.Ho();
                b.b((com.kwad.sdk.core.c.c) this);
                super.b(activity);
            }
        });
    }

    private static int j(Activity activity) {
        try {
            int colorMode = activity.getWindow().getColorMode();
            activity.getWindow().setColorMode(2);
            int colorMode2 = activity.getWindow().getColorMode();
            activity.getWindow().setColorMode(colorMode);
            return colorMode2 == 2 ? 1 : 2;
        } catch (Throwable th) {
            c.e("HdrHelper", "getColorModeSupport error", th);
            return 3;
        }
    }

    private static int k(Activity activity) {
        try {
            if (Build.VERSION.SDK_INT < 34) {
                return 3;
            }
            Display display = activity.getDisplay();
            return display != null ? ((Boolean) z.f(display, "isHdrSdrRatioAvailable", new Object[0])).booleanValue() : false ? 1 : 2;
        } catch (Throwable th) {
            c.e("HdrHelper", "getScreenHdrAvailable error", th);
            return 3;
        }
    }

    public final void Ms() {
        if (!this.aRk || Mt()) {
            return;
        }
        report();
        ag.l("ksadsdk_pref", "hdr_has_reported", true);
        this.aRl.set(true);
    }

    private boolean Mt() {
        if (this.aRl.get()) {
            return true;
        }
        this.aRl.set(ag.m("ksadsdk_pref", "hdr_has_reported", false));
        return this.aRl.get();
    }

    private void report() {
        this.aRi = z(this.aRg, this.aRh);
        this.aRf = Build.VERSION.SDK_INT;
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.APM_LOG).i(1.0d).O("ad_sdk_hdr", "stats_ranger").z(new com.kwad.sdk.f.a.a.a(this.aRf, this.aRg, this.aRh, this.aRi)).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
    }

    private static int z(int i, int i2) {
        return (Build.VERSION.SDK_INT >= 34 && dY(i) && dY(i2)) ? 1 : 2;
    }
}
