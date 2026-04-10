package com.kwad.sdk.o;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.z;

/* JADX INFO: loaded from: classes4.dex */
public final class m {
    private static Application bei;

    public static void z(Context context, boolean z) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean("useContextClassLoader", z).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    public static int getThemeResId(Context context) {
        if (context instanceof ContextThemeWrapper) {
            Object objA = z.a((Object) context, "android.view.ContextThemeWrapper", "getThemeResId");
            if (objA != null) {
                return ((Integer) objA).intValue();
            }
            return 0;
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
        }
        return 0;
    }

    private static boolean SZ() {
        if (f.SS().Rw()) {
            return true;
        }
        ServiceProvider.reportSdkCaughtException(new RuntimeException("please init KSPlugin"));
        return false;
    }

    public static View a(Context context, int i, ViewGroup viewGroup, boolean z) {
        return eq(context).inflate(i, viewGroup, z);
    }

    public static View inflate(Context context, int i, ViewGroup viewGroup) {
        return eq(context).inflate(i, viewGroup);
    }

    public static void a(Application application) {
        if (bei == null) {
            bei = application;
        }
    }

    public static Application Ta() {
        SZ();
        Application applicationTb = Tb();
        if (j.SX()) {
            bei = (Application) j.wrapContextIfNeed(applicationTb);
        }
        return bei;
    }

    private static Application Tb() {
        Context applicationContext;
        Application application = bei;
        if (application != null) {
            return application;
        }
        Context contextPp = ServiceProvider.Pp();
        if (contextPp instanceof Application) {
            Application application2 = (Application) contextPp;
            bei = application2;
            return application2;
        }
        Context applicationContext2 = contextPp.getApplicationContext();
        if (applicationContext2 instanceof Application) {
            Application application3 = (Application) applicationContext2;
            bei = application3;
            return application3;
        }
        if (aN(applicationContext2)) {
            applicationContext = j.eh(applicationContext2);
        } else if (k.aN(applicationContext2)) {
            applicationContext = k.eh(applicationContext2);
        } else {
            applicationContext = contextPp.getApplicationContext();
        }
        if (applicationContext instanceof Application) {
            bei = (Application) applicationContext;
        } else {
            Application application4 = com.kwad.sdk.core.c.b.Ho().getApplication();
            if (application4 != null) {
                bei = application4;
            } else if (applicationContext instanceof ContextWrapper) {
                Context baseContext = ((ContextWrapper) applicationContext).getBaseContext();
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext instanceof Application) {
                    bei = (Application) baseContext;
                }
            }
        }
        if (bei == null) {
            bei = Tc();
        }
        Application applicationEn = en(bei);
        bei = applicationEn;
        return applicationEn;
    }

    private static Application Tc() {
        Application application = (Application) z.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        return application != null ? application : (Application) z.a("android.app.AppGlobals", "getInitialApplication", new Object[0]);
    }

    public static Activity ej(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        Context contextEl = el(context);
        if (contextEl instanceof Activity) {
            return (Activity) contextEl;
        }
        com.kwad.sdk.core.c.b.Ho();
        return com.kwad.sdk.core.c.b.getCurrentActivity();
    }

    public static Context wrapContextIfNeed(Context context) {
        Context contextWrapContextIfNeed;
        if (!SZ() || !Td()) {
            return context;
        }
        if (j.SX()) {
            contextWrapContextIfNeed = j.wrapContextIfNeed(context);
        } else {
            contextWrapContextIfNeed = k.wrapContextIfNeed(context);
        }
        return ek(contextWrapContextIfNeed);
    }

    public static boolean Td() {
        return ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bk() || f.SS().ST();
    }

    private static Context ek(Context context) {
        if (j.SX() && !aN(context)) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect KSContext in external --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bn()));
        } else if (!j.SX() && !k.aN(context)) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect ResContext in external --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bn()));
        }
        return context;
    }

    public static Context el(Context context) {
        Context contextUnwrapContextIfNeed;
        if (!SZ() || !Td() || eo(context)) {
            return context;
        }
        if (aN(context)) {
            contextUnwrapContextIfNeed = j.eg(context);
        } else {
            contextUnwrapContextIfNeed = k.unwrapContextIfNeed(context);
        }
        return em(contextUnwrapContextIfNeed);
    }

    private static Context em(Context context) {
        if (k.aN(context) || (context instanceof b)) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bn()));
        }
        return context;
    }

    private static Application en(Context context) {
        if (context instanceof Application) {
            return (Application) context;
        }
        ServiceProvider.reportSdkCaughtException(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bn() + "--isExternal:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bk() + "--isInnerDex:" + f.SS().ST()));
        return null;
    }

    public static boolean eo(Context context) {
        return (aN(context) || k.aN(context)) ? false : true;
    }

    private static boolean aN(Context context) {
        return context instanceof b;
    }

    public static Context ep(Context context) {
        try {
            if (k.aN(context)) {
                context = k.aM(context);
            }
            if (context instanceof b) {
                context = ((b) context).getDelegatedContext();
            }
            if (eo(context)) {
                return context;
            }
            for (int i = 0; i < 5; i++) {
                if (k.aN(context)) {
                    context = k.aM(context);
                }
                if (context instanceof b) {
                    context = ((b) context).getDelegatedContext();
                }
                if (eo(context)) {
                    return context;
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return context;
    }

    public static LayoutInflater eq(Context context) {
        Context contextWrapContextIfNeed = wrapContextIfNeed(context);
        if (k.aN(contextWrapContextIfNeed)) {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(contextWrapContextIfNeed);
            a(layoutInflaterFrom);
            return layoutInflaterFrom;
        }
        return LayoutInflater.from(contextWrapContextIfNeed);
    }

    public static LayoutInflater b(Context context, Context context2) {
        LayoutInflater layoutInflaterCloneInContext = LayoutInflater.from(er(context)).cloneInContext(context2);
        a(layoutInflaterCloneInContext);
        return layoutInflaterCloneInContext;
    }

    private static Context er(Context context) {
        return context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : context;
    }

    private static void a(LayoutInflater layoutInflater) {
        z.a(layoutInflater, "mFactory", (Object) null);
        z.a(layoutInflater, "mFactory2", (Object) null);
    }

    public static void n(Activity activity) {
        k.onDestroy(activity);
    }
}
