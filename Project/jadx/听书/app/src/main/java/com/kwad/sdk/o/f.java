package com.kwad.sdk.o;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.z;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class f {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Resources bdQ;
    private Resources bdR;
    private i bdS;
    private boolean bdT;
    private ClassLoader bdU;
    private boolean bdV;
    private final AtomicBoolean mHasInit;

    /* synthetic */ f(byte b) {
        this();
    }

    private f() {
        this.mHasInit = new AtomicBoolean(false);
        this.bdV = com.kwad.framework.a.a.alb.booleanValue();
    }

    static class a {
        private static final f bdW = new f(0);
    }

    public static f SS() {
        return a.bdW;
    }

    public final void init() {
        if (this.mHasInit.get()) {
            return;
        }
        try {
            if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bk()) {
                if (BM() && SV()) {
                    this.bdU = getClass().getClassLoader();
                    j.ct(BN());
                    com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", toString());
                    this.bdT = true;
                } else {
                    this.bdT = false;
                }
            } else if (this.bdV) {
                j.ct(true);
                SU();
                this.bdU = getClass().getClassLoader();
                this.bdT = true;
            }
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
        this.mHasInit.set(true);
    }

    public final boolean ST() {
        return this.bdV;
    }

    private boolean BM() {
        boolean zBk = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bk();
        if (!this.bdV || zBk) {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BM();
        }
        return false;
    }

    private static boolean BN() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BN();
    }

    public final boolean Rw() {
        return this.mHasInit.get();
    }

    public final ClassLoader getClassLoader() {
        return this.bdU;
    }

    public final Resources getResources() {
        boolean zBk = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bk();
        com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "getResources mIsInnerDexMode: " + this.bdV + ", mHostResources: " + this.bdQ + ", isExternal: " + zBk);
        if (this.bdV && !zBk) {
            return this.bdQ;
        }
        return this.bdS;
    }

    public String toString() {
        return "KSPlugin{mHostResources=" + this.bdQ + ", mResResources=" + this.bdR + ", mPluginResources=" + this.bdS + ", mEnable=" + this.bdT + '}';
    }

    private boolean SU() {
        Context contextPp = ServiceProvider.Pp();
        if (!m.eo(contextPp)) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSPlugin unwrapContextIfNeed fail"));
            return false;
        }
        this.bdQ = contextPp.getResources();
        return true;
    }

    private boolean SV() {
        Context contextPp;
        Object objA;
        try {
            contextPp = ServiceProvider.Pp();
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
        if (!m.eo(contextPp)) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSPlugin unwrapContextIfNeed fail"));
            return false;
        }
        Class<?> cls = Class.forName("com.kwad.sdk.api.loader.Loader", false, getClass().getClassLoader());
        Resources resourcesA = null;
        Object objInvoke = cls.getDeclaredMethod("get", new Class[0]).invoke(null, new Object[0]);
        for (Field field : cls.getDeclaredFields()) {
            if (field.getType() != IKsAdSDK.class && field.getType() != Context.class && field.getType() != AtomicBoolean.class && (objA = z.a(field, objInvoke)) != null) {
                for (Field field2 : objA.getClass().getDeclaredFields()) {
                    if (field2.getType() == Resources.class) {
                        field2.setAccessible(true);
                        String strV = com.kwad.sdk.o.a.v(contextPp, u.aX(contextPp));
                        if (!TextUtils.isEmpty(strV)) {
                            resourcesA = com.kwad.library.b.b.a.a(contextPp, contextPp.getResources(), strV);
                            com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "use merge res ");
                        } else {
                            com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "find dynamicFile failed");
                        }
                        if (resourcesA == null) {
                            resourcesA = (Resources) field2.get(objA);
                        }
                        Resources resources = contextPp.getResources();
                        i iVar = new i(resourcesA, resources);
                        z.a(field2, objA, iVar);
                        this.bdQ = resources;
                        this.bdR = resourcesA;
                        this.bdS = iVar;
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
