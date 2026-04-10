package com.kwad.sdk.o;

import android.content.Context;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bg;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class l {
    private static a bec;
    private static final AtomicBoolean mHasInit = new AtomicBoolean(false);

    public static class a extends com.kwad.sdk.core.response.a.a {
        public List<String> bee;
        public List<C0425a> bef;

        /* JADX INFO: renamed from: com.kwad.sdk.o.l$a$a, reason: collision with other inner class name */
        public static class C0425a extends com.kwad.sdk.core.response.a.a {
            public String beg;
            public String beh;
        }
    }

    public static boolean ei(Context context) {
        a aVar = bec;
        if (aVar == null || ap.L(aVar.bee) || ap.L(bec.bef) || !a(context, bec)) {
            return false;
        }
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (a(stackTraceElement, bec)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(Context context, a aVar) {
        String name = context.getClass().getName();
        Iterator it = new CopyOnWriteArrayList(aVar.bee).iterator();
        while (it.hasNext()) {
            if (ap.a((String) it.next(), name)) {
                com.kwad.sdk.core.d.c.d("WrapperBlackHelper", "isBlackClass");
                return true;
            }
        }
        return false;
    }

    private static boolean a(StackTraceElement stackTraceElement, a aVar) {
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        for (a.C0425a c0425a : new CopyOnWriteArrayList(aVar.bef)) {
            String str = c0425a.beg;
            String str2 = c0425a.beh;
            if (ap.a(str, className) && ap.a(str2, methodName)) {
                com.kwad.sdk.core.d.c.d("WrapperBlackHelper", "isBlackMethod");
                return true;
            }
        }
        return false;
    }

    public static void JL() {
        if (mHasInit.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.sdk.o.l.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a unused = l.bec = new a();
                try {
                    l.bec.parseJson((JSONObject) ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppConfigData(null, new com.kwad.sdk.g.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.o.l.1.1
                        @Override // com.kwad.sdk.g.b
                        public final /* synthetic */ JSONObject apply(JSONObject jSONObject) {
                            return o(jSONObject);
                        }

                        private static JSONObject o(JSONObject jSONObject) {
                            if (jSONObject == null) {
                                return null;
                            }
                            jSONObject.optJSONObject("wrapperBlackConfig");
                            return null;
                        }
                    }));
                } catch (Throwable unused2) {
                }
            }
        });
    }
}
