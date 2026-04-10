package com.kwai.sodler.lib.kwai.b;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.sodler.lib.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static final String CLAZZ_NAME = "com.kwai.sodler.lib.kwai.b.a";
    private static final ThreadLocal<C0477a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new ArrayList();
    private static final Map<String, WeakReference<Context>> sResContextCache = new HashMap();

    /* JADX INFO: renamed from: com.kwai.sodler.lib.kwai.b.a$a, reason: collision with other inner class name */
    static class C0477a {
        private long aaA;
        private WeakReference<Context> aaw;
        private int aax;
        private StackTraceElement[] aay;
        private int aaz;

        private C0477a() {
            this.aaw = new WeakReference<>(null);
            this.aax = 0;
            this.aay = null;
            this.aaz = 0;
        }

        /* synthetic */ C0477a(byte b) {
            this();
        }

        static /* synthetic */ int c(C0477a c0477a) {
            int i2 = c0477a.aax;
            c0477a.aax = i2 + 1;
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.aaw = new WeakReference<>(null);
            this.aax = 0;
            this.aay = null;
            this.aaz = 0;
            this.aaA = 0L;
        }

        static /* synthetic */ int g(C0477a c0477a) {
            int i2 = c0477a.aaz;
            c0477a.aaz = i2 + 1;
            return i2;
        }
    }

    @Nullable
    private static Context a(String str, Context context) {
        WeakReference<Context> weakReference = sResContextCache.get(str + System.identityHashCode(context));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    static Resources.Theme a(Resources.Theme theme, Resources.Theme theme2, int i2, String str) {
        Resources resources;
        com.kwai.sodler.lib.kwai.a aVarFx = fx(str);
        if (aVarFx == null || !aVarFx.isLoaded() || (resources = aVarFx.getResources()) == null) {
            return theme;
        }
        if (theme2 != null) {
            return theme2;
        }
        Resources.Theme themeNewTheme = resources.newTheme();
        themeNewTheme.applyStyle(i2, true);
        return themeNewTheme;
    }

    static Resources a(Resources resources, String str) {
        com.kwai.sodler.lib.kwai.a aVarFx = fx(str);
        if (aVarFx == null || !aVarFx.isLoaded()) {
            StringBuilder sb = new StringBuilder("replaceExternalResources pluginId: ");
            sb.append(str);
            sb.append(" , plugin: ");
            sb.append(aVarFx);
            sb.append(", isLoaded(): false");
            return resources;
        }
        Resources resources2 = aVarFx.getResources();
        StringBuilder sb2 = new StringBuilder("replaceExternalResources pluginId: ");
        sb2.append(str);
        sb2.append(", wrappedResources: ");
        sb2.append(resources2);
        return resources2 != null ? resources2 : resources;
    }

    public static LayoutInflater a(LayoutInflater layoutInflater, String str) {
        com.kwai.sodler.lib.kwai.a aVarFx = fx(str);
        if (aVarFx == null || !aVarFx.isLoaded()) {
            return layoutInflater;
        }
        Context context = layoutInflater.getContext();
        if (context instanceof b) {
            return layoutInflater;
        }
        Context contextAu = au(context, str);
        return contextAu instanceof b ? layoutInflater.cloneInContext(contextAu) : layoutInflater;
    }

    private static void a(String str, Context context, Context context2) {
        sResContextCache.put(str + System.identityHashCode(context), new WeakReference<>(context2));
    }

    private static boolean a(String str, Context context, C0477a c0477a) {
        Context contextA = a(str, context);
        String name = contextA != null ? contextA.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (Arrays.equals(stackTrace, c0477a.aay)) {
            C0477a.g(c0477a);
            c0477a.aay = stackTrace;
            return c0477a.aaz >= 5;
        }
        if (c0477a.aay != null) {
            c0477a.clear();
            return false;
        }
        c0477a.aay = stackTrace;
        int i2 = 0;
        int i3 = 0;
        while (i2 < stackTrace.length) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            String className = stackTraceElement.getClassName();
            Iterator<String> it = getAutoUnWrapStackList().iterator();
            while (it.hasNext()) {
                if (className.contains(it.next())) {
                    return true;
                }
            }
            String methodName = stackTraceElement.getMethodName();
            i2++;
            if (i2 < stackTrace.length && CLAZZ_NAME.equals(className) && "wrapContextIfNeed".equals(methodName)) {
                StackTraceElement stackTraceElement2 = stackTrace[i2];
                if (TextUtils.equals(name, stackTraceElement2.getClassName()) && "getBaseContext".equals(stackTraceElement2.getMethodName()) && (i3 = i3 + 1) >= 5) {
                    return true;
                }
            }
        }
        return false;
    }

    @NonNull
    public static Context au(Context context, String str) {
        if (context == null) {
            return null;
        }
        com.kwai.sodler.lib.kwai.a aVarFx = fx(str);
        if (aVarFx == null || !aVarFx.isLoaded() || (context instanceof b) || b(str, context)) {
            return context;
        }
        Context contextA = a(str, context);
        if (contextA != null) {
            return contextA;
        }
        Context cVar = context instanceof ContextThemeWrapper ? new c((ContextThemeWrapper) context, str) : context instanceof androidx.appcompat.view.ContextThemeWrapper ? new d((androidx.appcompat.view.ContextThemeWrapper) context, str) : context instanceof ContextWrapper ? new e(context, str) : new e(context, str);
        a(str, context, cVar);
        return cVar;
    }

    static ClassLoader b(ClassLoader classLoader, String str) {
        com.kwai.sodler.lib.kwai.kwai.b bVarJj;
        com.kwai.sodler.lib.kwai.a aVarFx = fx(str);
        return (aVarFx == null || !aVarFx.isLoaded() || (bVarJj = aVarFx.Jj()) == null) ? classLoader : bVarJj;
    }

    private static boolean b(String str, Context context) {
        C0477a c0477a = sAutoUnWrapModelTL.get();
        byte b = 0;
        if (c0477a == null) {
            sAutoUnWrapModelTL.set(new C0477a(b));
        } else if (c0477a.aaw.get() != context || Math.abs(System.currentTimeMillis() - c0477a.aaA) >= 150) {
            c0477a.clear();
            c0477a.aaw = new WeakReference(context);
            c0477a.aaA = System.currentTimeMillis();
        } else {
            C0477a.c(c0477a);
            if (c0477a.aax >= (context instanceof Application ? 15 : 5) && a(str, context, c0477a)) {
                c0477a.clear();
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Nullable
    public static Application dD(Context context) {
        int i2 = 0;
        ?? UnwrapContextIfNeed = unwrapContextIfNeed(context);
        while (i2 < 15) {
            Object applicationContext = UnwrapContextIfNeed.getApplicationContext();
            boolean z2 = applicationContext instanceof b;
            Object delegatedContext = applicationContext;
            if (z2) {
                delegatedContext = ((b) applicationContext).getDelegatedContext();
            }
            if (delegatedContext instanceof Application) {
                return (Application) delegatedContext;
            }
            i2++;
            UnwrapContextIfNeed = delegatedContext;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Context dE(Context context) {
        return ((b) context).getDelegatedContext();
    }

    private static boolean dF(Context context) {
        return context instanceof b;
    }

    private static com.kwai.sodler.lib.kwai.a fx(String str) {
        com.kwai.sodler.lib.a.a aVarFv = i.IZ().Jc().fv(str);
        if (aVarFv != null && aVarFv.isLoaded() && (aVarFv instanceof com.kwai.sodler.lib.kwai.a)) {
            return (com.kwai.sodler.lib.kwai.a) aVarFv;
        }
        return null;
    }

    private static List<String> getAutoUnWrapStackList() {
        if (sAutoUnWrapStackList.isEmpty()) {
            sAutoUnWrapStackList.add("com.sensorsdata.analytics.android.sdk");
        }
        return sAutoUnWrapStackList;
    }

    public static Context unwrapContextIfNeed(Context context) {
        if (dF(context)) {
            context = dE(context);
        }
        if (!dF(context)) {
            return context;
        }
        for (int i2 = 0; i2 < 10; i2++) {
            context = dE(context);
            if (!dF(context)) {
                return context;
            }
        }
        return context;
    }

    static Object wrapSystemService(Object obj, String str, Context context) {
        if (!"layout_inflater".equals(str) || !(obj instanceof LayoutInflater)) {
            return obj;
        }
        LayoutInflater layoutInflater = (LayoutInflater) obj;
        return layoutInflater.getContext() instanceof b ? layoutInflater : layoutInflater.cloneInContext(context);
    }
}
