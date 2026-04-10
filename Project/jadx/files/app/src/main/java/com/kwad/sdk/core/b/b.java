package com.kwad.sdk.core.b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KSLifecycleListener;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bo;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class b implements c {
    private static volatile b afv;
    private static final List<c> mListeners = new CopyOnWriteArrayList();
    private final AtomicBoolean IC = new AtomicBoolean(false);

    @Nullable
    private Application mApplication;

    private b() {
    }

    public static void a(c cVar) {
        mListeners.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void a(com.kwad.sdk.d.a<c> aVar) {
        for (c cVar : mListeners) {
            if (cVar != null) {
                aVar.accept(cVar);
            }
        }
    }

    public static void b(c cVar) {
        mListeners.remove(cVar);
    }

    @Nullable
    public static Activity getCurrentActivity() {
        if (wf()) {
            return KSLifecycleObserver.getInstance().getCurrentActivity();
        }
        if (a.wc().isEnable()) {
            return a.wc().getCurrentActivity();
        }
        return null;
    }

    public static boolean isAppOnForeground() {
        if (wf()) {
            return KSLifecycleObserver.getInstance().isAppOnForeground();
        }
        if (a.wc().isEnable()) {
            return a.wc().isAppOnForeground();
        }
        return false;
    }

    public static boolean isEnable() {
        return wf() || a.wc().isEnable();
    }

    public static b we() {
        if (afv == null) {
            synchronized (b.class) {
                if (afv == null) {
                    afv = new b();
                }
            }
        }
        return afv;
    }

    public static boolean wf() {
        try {
            if (bi.ag(((e) ServiceProvider.get(e.class)).getApiVersion(), "3.3.26")) {
                return KSLifecycleObserver.getInstance().isEnable();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void init(Context context) {
        if (this.IC.get() || context == null) {
            return;
        }
        this.IC.set(true);
        try {
            if (bi.ag(((e) ServiceProvider.get(e.class)).getApiVersion(), "3.3.26")) {
                this.mApplication = KSLifecycleObserver.getInstance().getApplication();
                KSLifecycleObserver.getInstance().registerLifecycleListener(new KSLifecycleListener() { // from class: com.kwad.sdk.core.b.b.1
                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityCreated(final Activity activity, final Bundle bundle) {
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.b.b.1.1
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.d.a
                            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                            public void accept(c cVar) {
                                cVar.onActivityCreated(activity, bundle);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityDestroyed(final Activity activity) {
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.b.b.1.4
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.d.a
                            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                            public void accept(c cVar) {
                                cVar.onActivityDestroyed(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityPaused(final Activity activity) {
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.b.b.1.3
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.d.a
                            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                            public void accept(c cVar) {
                                cVar.onActivityPaused(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onActivityResumed(final Activity activity) {
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.b.b.1.2
                            /* JADX INFO: Access modifiers changed from: private */
                            @Override // com.kwad.sdk.d.a
                            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                            public void accept(c cVar) {
                                cVar.onActivityResumed(activity);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onBackToBackground() {
                        com.kwad.sdk.core.d.b.z("LifecycleHolder", "onBackToBackground");
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.b.b.1.6
                            private static void c(c cVar) {
                                cVar.onBackToBackground();
                            }

                            @Override // com.kwad.sdk.d.a
                            public final /* synthetic */ void accept(c cVar) {
                                c(cVar);
                            }
                        });
                    }

                    @Override // com.kwad.sdk.api.core.KSLifecycleListener
                    public final void onBackToForeground() {
                        com.kwad.sdk.core.d.b.z("LifecycleHolder", "onBackToForeground");
                        b bVar = b.this;
                        b.a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.b.b.1.5
                            private static void c(c cVar) {
                                cVar.onBackToForeground();
                            }

                            @Override // com.kwad.sdk.d.a
                            public final /* synthetic */ void accept(c cVar) {
                                c(cVar);
                            }
                        });
                    }
                });
            } else {
                com.kwad.sdk.core.d.b.z("LifecycleHolder", "init KSLifecycleObserver not support");
            }
        } catch (Throwable unused) {
        }
        Context contextDt = bo.dt(context);
        if (contextDt instanceof Application) {
            this.mApplication = (Application) contextDt;
            a.wc().init(this.mApplication);
            a.wc().a(this);
        }
    }

    @Override // com.kwad.sdk.core.b.c
    public void onActivityCreated(final Activity activity, final Bundle bundle) {
        a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.b.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.onActivityCreated(activity, bundle);
            }
        });
    }

    @Override // com.kwad.sdk.core.b.c
    public void onActivityDestroyed(final Activity activity) {
        a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.b.b.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.onActivityDestroyed(activity);
            }
        });
    }

    @Override // com.kwad.sdk.core.b.c
    public void onActivityPaused(final Activity activity) {
        a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.b.b.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.onActivityPaused(activity);
            }
        });
    }

    @Override // com.kwad.sdk.core.b.c
    public void onActivityResumed(final Activity activity) {
        a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.b.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.a
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.onActivityResumed(activity);
            }
        });
    }

    @Override // com.kwad.sdk.core.b.c
    public void onBackToBackground() {
        com.kwad.sdk.core.d.b.z("LifecycleHolder", "onBackToBackground old");
        a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.b.b.7
            private static void c(c cVar) {
                cVar.onBackToBackground();
            }

            @Override // com.kwad.sdk.d.a
            public final /* synthetic */ void accept(c cVar) {
                c(cVar);
            }
        });
    }

    @Override // com.kwad.sdk.core.b.c
    public void onBackToForeground() {
        com.kwad.sdk.core.d.b.z("LifecycleHolder", "onBackToForeground old");
        a(new com.kwad.sdk.d.a<c>() { // from class: com.kwad.sdk.core.b.b.6
            private static void c(c cVar) {
                cVar.onBackToForeground();
            }

            @Override // com.kwad.sdk.d.a
            public final /* synthetic */ void accept(c cVar) {
                c(cVar);
            }
        });
    }
}
