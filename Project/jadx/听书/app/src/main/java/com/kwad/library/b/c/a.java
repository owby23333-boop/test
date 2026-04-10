package com.kwad.library.b.c;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.kwad.sdk.utils.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static final String CLAZZ_NAME = "com.kwad.library.b.c.a";
    private static final ThreadLocal<C0381a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new ArrayList();
    private static final Map<String, WeakReference<Context>> sResContextCache = new HashMap();

    /* JADX INFO: renamed from: com.kwad.library.b.c.a$a, reason: collision with other inner class name */
    static class C0381a {
        private WeakReference<Context> aqb;
        private int aqc;
        private StackTraceElement[] aqd;
        private int aqe;
        private long aqf;

        private C0381a() {
            this.aqb = new WeakReference<>(null);
            this.aqc = 0;
            this.aqd = null;
            this.aqe = 0;
        }

        /* synthetic */ C0381a(byte b) {
            this();
        }

        static /* synthetic */ int c(C0381a c0381a) {
            int i = c0381a.aqc;
            c0381a.aqc = i + 1;
            return i;
        }

        static /* synthetic */ int g(C0381a c0381a) {
            int i = c0381a.aqe;
            c0381a.aqe = i + 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.aqb = new WeakReference<>(null);
            this.aqc = 0;
            this.aqd = null;
            this.aqe = 0;
            this.aqf = 0L;
        }
    }

    private static com.kwad.library.b.a bM(String str) {
        return com.kwad.library.solder.a.a.k(null, str);
    }

    public static Context j(Context context, String str) {
        Context eVar;
        if (context == null) {
            return null;
        }
        com.kwad.library.b.a aVarBM = bM(str);
        if (aVarBM == null || !aVarBM.isLoaded() || (context instanceof b) || b(str, context)) {
            return context;
        }
        Context contextA = a(str, context);
        if (contextA != null) {
            return contextA;
        }
        if (context instanceof ContextThemeWrapper) {
            eVar = new c((ContextThemeWrapper) context, str);
        } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            eVar = new d((androidx.appcompat.view.ContextThemeWrapper) context, str);
        } else if (context instanceof ContextWrapper) {
            eVar = new e(context, str);
        } else {
            eVar = new e(context, str);
        }
        a(str, context, eVar);
        return eVar;
    }

    private static Context a(String str, Context context) {
        WeakReference<Context> weakReference = sResContextCache.get(str + System.identityHashCode(context));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private static void a(String str, Context context, Context context2) {
        sResContextCache.put(str + System.identityHashCode(context), new WeakReference<>(context2));
    }

    private static boolean b(String str, Context context) {
        ThreadLocal<C0381a> threadLocal = sAutoUnWrapModelTL;
        C0381a c0381a = threadLocal.get();
        byte b = 0;
        if (c0381a != null) {
            if (c0381a.aqb.get() != context || Math.abs(System.currentTimeMillis() - c0381a.aqf) >= 150) {
                c0381a.clear();
                c0381a.aqb = new WeakReference(context);
                c0381a.aqf = System.currentTimeMillis();
            } else {
                C0381a.c(c0381a);
                if (c0381a.aqc >= (context instanceof Application ? 15 : 5) && a(str, context, c0381a)) {
                    c0381a.clear();
                    return true;
                }
            }
        } else {
            threadLocal.set(new C0381a(b));
        }
        return false;
    }

    private static boolean a(String str, Context context, C0381a c0381a) {
        Context contextA = a(str, context);
        String name = contextA != null ? contextA.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (!Arrays.equals(stackTrace, c0381a.aqd)) {
            if (c0381a.aqd != null) {
                c0381a.clear();
                return false;
            }
            c0381a.aqd = stackTrace;
            int i = 0;
            int i2 = 0;
            while (i < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                String className = stackTraceElement.getClassName();
                Iterator<String> it = getAutoUnWrapStackList().iterator();
                while (it.hasNext()) {
                    if (className.contains(it.next())) {
                        Log.d("PluginWrapper", "needAutoUnWrap true 命中白名单");
                        return true;
                    }
                }
                String methodName = stackTraceElement.getMethodName();
                i++;
                if (i < stackTrace.length && CLAZZ_NAME.equals(className) && "wrapContextIfNeed".equals(methodName)) {
                    StackTraceElement stackTraceElement2 = stackTrace[i];
                    if (TextUtils.equals(name, stackTraceElement2.getClassName()) && "getBaseContext".equals(stackTraceElement2.getMethodName()) && (i2 = i2 + 1) >= 5) {
                        return true;
                    }
                }
            }
            return false;
        }
        C0381a.g(c0381a);
        c0381a.aqd = stackTrace;
        if (c0381a.aqe < 5) {
            return false;
        }
        Log.d("PluginWrapper", "needAutoUnWrap true 连续相同堆栈");
        return true;
    }

    private static List<String> getAutoUnWrapStackList() {
        List<String> list = sAutoUnWrapStackList;
        if (list.isEmpty()) {
            list.add("com.sensorsdata.analytics.android.sdk");
        }
        return list;
    }

    public static LayoutInflater a(LayoutInflater layoutInflater, String str) {
        com.kwad.library.b.a aVarBM = bM(str);
        if (aVarBM == null || !aVarBM.isLoaded()) {
            return layoutInflater;
        }
        Context context = layoutInflater.getContext();
        if (context instanceof b) {
            return layoutInflater;
        }
        Context contextJ = j(context, str);
        return contextJ instanceof b ? layoutInflater.cloneInContext(contextJ) : layoutInflater;
    }

    public static Context unwrapContextIfNeed(Context context) {
        if (aN(context)) {
            context = aM(context);
        }
        if (!aN(context)) {
            return context;
        }
        for (int i = 0; i < 10; i++) {
            context = aM(context);
            if (!aN(context)) {
                return context;
            }
        }
        return context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Context aM(Context context) {
        return ((b) context).getDelegatedContext();
    }

    private static boolean aN(Context context) {
        return context instanceof b;
    }

    static Resources a(Resources resources, String str) {
        com.kwad.library.b.a aVarBM = bM(str);
        if (aVarBM == null || !aVarBM.isLoaded()) {
            new StringBuilder("replaceExternalResources pluginId: ").append(str).append(" , plugin: ").append(aVarBM);
            return resources;
        }
        Resources resources2 = aVarBM.getResources();
        new StringBuilder("replaceExternalResources pluginId: ").append(str).append(", wrappedResources: ").append(resources2);
        return resources2 != null ? resources2 : resources;
    }

    static Resources.Theme a(Resources.Theme theme, Resources.Theme theme2, int i, String str) {
        Resources resources;
        com.kwad.library.b.a aVarBM = bM(str);
        if (aVarBM == null || !aVarBM.isLoaded() || (resources = aVarBM.getResources()) == null) {
            return theme;
        }
        if (theme2 != null) {
            return theme2;
        }
        Resources.Theme themeNewTheme = resources.newTheme();
        themeNewTheme.applyStyle(i, true);
        return themeNewTheme;
    }

    static ClassLoader a(ClassLoader classLoader, String str) {
        com.kwad.library.b.a.b bVarZI;
        com.kwad.library.b.a aVarBM = bM(str);
        return (aVarBM == null || !aVarBM.isLoaded() || (bVarZI = aVarBM.zI()) == null) ? classLoader : bVarZI;
    }

    static Object wrapSystemService(Object obj, String str, Context context) {
        if (!"layout_inflater".equals(str) || !(obj instanceof LayoutInflater)) {
            return obj;
        }
        LayoutInflater layoutInflater = (LayoutInflater) obj;
        return layoutInflater.getContext() instanceof b ? layoutInflater : layoutInflater.cloneInContext(context);
    }

    static int getThemeResId(Context context) {
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
}
