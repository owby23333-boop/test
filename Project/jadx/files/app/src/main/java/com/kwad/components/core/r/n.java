package com.kwad.components.core.r;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.kwad.sdk.core.config.item.o;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class n {
    private static final String Qc = "com.kwad.components.core.r.n";
    private static volatile n Qd = null;
    public static final String TAG = "n";
    private boolean Qe = false;
    private o.a Qf;

    private n() {
    }

    private static boolean a(List<String> list, Class cls) {
        int i2 = 0;
        while (cls != null && !TextUtils.equals(cls.getName(), "java.lang.Object")) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (cls.getName().contains(it.next())) {
                    return true;
                }
            }
            cls = cls.getSuperclass();
            i2++;
            if (i2 >= 4) {
                break;
            }
        }
        return false;
    }

    private boolean a(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null && !list.isEmpty()) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.sdk.core.d.b.d(TAG, "checkBySuper begin:" + jElapsedRealtime);
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                String className = stackTraceElement.getClassName();
                if (className != null && az(className) && aA(className)) {
                    try {
                        if (a(list, Class.forName(className).getSuperclass())) {
                            v(jElapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        if (className.contains("$") && a(list, Class.forName(className.substring(0, className.lastIndexOf("$"))).getSuperclass())) {
                            v(jElapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused2) {
                        continue;
                    }
                }
            }
            v(jElapsedRealtime);
        }
        return false;
    }

    private static boolean aA(String str) {
        return !str.startsWith("com.kwad");
    }

    private static boolean aB(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Class.forName(str) != null;
    }

    private static boolean az(String str) {
        return (str.startsWith(DispatchConstants.ANDROID) || str.startsWith("java") || str.startsWith("dalvik") || str.startsWith("com.android") || str.contains(Qc) || !str.startsWith("androidx")) ? false : true;
    }

    private boolean c(List<String> list, List<String> list2) {
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
        return a(list2, stackTrace);
    }

    public static n qi() {
        if (Qd == null) {
            synchronized (n.class) {
                if (Qd == null) {
                    Qd = new n();
                }
            }
        }
        return Qd;
    }

    private void qk() {
        o.a aVar = this.Qf;
        if (aVar == null) {
            return;
        }
        if (!this.Qe && aVar.adL.size() > 0) {
            Iterator<String> it = this.Qf.adL.iterator();
            while (it.hasNext()) {
                this.Qe = aB(it.next());
                if (this.Qe) {
                    break;
                }
            }
        }
        if (this.Qe) {
            ArrayList arrayList = new ArrayList();
            if (this.Qf.adI.size() > 0) {
                for (Map.Entry<Integer, String> entry : this.Qf.adI.entrySet()) {
                    if (aB(entry.getValue())) {
                        arrayList.add(entry.getKey());
                    }
                }
            }
            o.a aVar2 = this.Qf;
            com.kwad.components.core.m.a.pr().a(c(aVar2.adJ, aVar2.adK), arrayList);
        }
    }

    private static void v(long j2) {
        com.kwad.sdk.core.d.b.d(TAG, "checkBySuper end:" + (SystemClock.elapsedRealtime() - j2));
    }

    public final boolean a(SceneImpl sceneImpl, String str) {
        boolean zC;
        if (this.Qe) {
            o.a aVar = this.Qf;
            zC = c(aVar.adJ, aVar.adK);
        } else {
            zC = false;
        }
        com.kwad.components.core.m.a.pr().a(sceneImpl, zC, str);
        return zC;
    }

    public final void init(Context context) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_config", 0);
            if (sharedPreferences != null) {
                com.kwad.sdk.core.config.c.abV.a(sharedPreferences);
                this.Qf = com.kwad.sdk.core.config.c.abV.getValue();
            }
            if (this.Qf != null) {
                qk();
            }
        }
    }

    public final int qj() {
        o.a aVar = this.Qf;
        if (aVar != null) {
            return aVar.adM;
        }
        return 0;
    }
}
