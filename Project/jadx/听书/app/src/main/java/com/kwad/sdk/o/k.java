package com.kwad.sdk.o;

import android.app.Application;
import android.content.Context;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
final class k {
    static Context wrapContextIfNeed(Context context) {
        return Wrapper.wrapContextIfNeed(context);
    }

    static Context unwrapContextIfNeed(Context context) {
        if (aN(context)) {
            context = aM(context);
        }
        if (!aN(context)) {
            return context;
        }
        RuntimeException runtimeException = null;
        for (int i = 0; i < 10; i++) {
            if (runtimeException == null) {
                RuntimeException runtimeException2 = new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bn());
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(runtimeException2);
                runtimeException = runtimeException2;
            }
            context = aM(context);
            if (!aN(context)) {
                return context;
            }
        }
        return context;
    }

    static Context eh(Context context) {
        Context applicationContext = unwrapContextIfNeed(context).getApplicationContext();
        if (applicationContext instanceof Application) {
            return applicationContext;
        }
        for (int i = 0; i < 10; i++) {
            applicationContext = applicationContext.getApplicationContext();
            if (applicationContext instanceof Application) {
                return applicationContext;
            }
            if (aN(applicationContext)) {
                applicationContext = aM(applicationContext);
            }
        }
        return applicationContext;
    }

    static boolean aN(Context context) {
        return context instanceof ResContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static Context aM(Context context) {
        return ((ResContext) context).getDelegatedContext();
    }

    public static void onDestroy(Context context) {
        Wrapper.onDestroy(context);
    }
}
