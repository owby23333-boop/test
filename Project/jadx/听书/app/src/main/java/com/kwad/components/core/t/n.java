package com.kwad.components.core.t;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.config.item.q;
import com.kwad.sdk.internal.api.SceneImpl;
import com.uc.crashsdk.export.LogType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class n {
    public static final String TAG = "n";
    private static final String Ze = "com.kwad.components.core.t.n";
    private static volatile n Zf;
    private boolean Zg = false;
    private q.a Zh;

    private n() {
    }

    public static n tn() {
        if (Zf == null) {
            synchronized (n.class) {
                if (Zf == null) {
                    Zf = new n();
                }
            }
        }
        return Zf;
    }

    public final void init() {
        q.a aVar = (q.a) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.azv);
        this.Zh = aVar;
        if (aVar != null) {
            tp();
        }
    }

    public final boolean b(SceneImpl sceneImpl, String str) {
        boolean zA = this.Zg ? a(this.Zh.aCt, this.Zh.aCu) : false;
        com.kwad.components.core.p.a.se().a(sceneImpl, zA, str);
        return zA;
    }

    public final int to() {
        q.a aVar = this.Zh;
        if (aVar != null) {
            return aVar.aCw;
        }
        return 0;
    }

    private void tp() {
        q.a aVar = this.Zh;
        if (aVar == null) {
            return;
        }
        if (!this.Zg && aVar.aCv.size() > 0) {
            Iterator<String> it = this.Zh.aCv.iterator();
            while (it.hasNext()) {
                boolean zAK = aK(it.next());
                this.Zg = zAK;
                if (zAK) {
                    break;
                }
            }
        }
        if (this.Zg) {
            ArrayList arrayList = new ArrayList();
            if (this.Zh.aCs.size() > 0) {
                for (Map.Entry<Integer, String> entry : this.Zh.aCs.entrySet()) {
                    if (aK(entry.getValue())) {
                        arrayList.add(entry.getKey());
                    }
                }
            }
            com.kwad.components.core.p.a.se().a(a(this.Zh.aCt, this.Zh.aCu), arrayList);
        }
    }

    private boolean a(List<String> list, List<String> list2) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (className != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (className.contains(it.next())) {
                        return true;
                    }
                }
            }
        }
        com.kwad.sdk.n.b.OQ().c(stackTrace);
        return a(list2, stackTrace);
    }

    private boolean a(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null && !list.isEmpty()) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.sdk.core.d.c.d(TAG, "checkBySuper begin:" + jElapsedRealtime);
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                String className = stackTraceElement.getClassName();
                if (className != null && aI(className) && aJ(className)) {
                    try {
                        if (a(list, Class.forName(className).getSuperclass())) {
                            O(jElapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        if (className.contains("$") && a(list, Class.forName(className.substring(0, className.lastIndexOf("$"))).getSuperclass())) {
                            O(jElapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused2) {
                        continue;
                    }
                }
            }
            O(jElapsedRealtime);
        }
        return false;
    }

    private static void O(long j) {
        com.kwad.sdk.core.d.c.d(TAG, "checkBySuper end:" + (SystemClock.elapsedRealtime() - j));
    }

    private static boolean a(List<String> list, Class cls) {
        int i = 0;
        while (cls != null && !TextUtils.equals(cls.getName(), "java.lang.Object")) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (cls.getName().contains(it.next())) {
                    return true;
                }
            }
            cls = cls.getSuperclass();
            i++;
            if (i >= 4) {
                break;
            }
        }
        return false;
    }

    private static boolean aI(String str) {
        return (str.startsWith("android") || str.startsWith(LogType.JAVA_TYPE) || str.startsWith("dalvik") || str.startsWith("com.android") || str.contains(Ze) || !str.startsWith("androidx")) ? false : true;
    }

    private static boolean aJ(String str) {
        return !str.startsWith("com.kwad");
    }

    private static boolean aK(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Class.forName(str) != null;
    }
}
