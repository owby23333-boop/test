package com.tramini.plugin.a.i;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.tramini.plugin.a.i.f;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends f {

    final class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ WebView f19354s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ ExecutorService f19355t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ String[] f19356u;

        /* JADX INFO: renamed from: com.tramini.plugin.a.i.b$a$a, reason: collision with other inner class name */
        final class RunnableC0539a implements Runnable {

            /* JADX INFO: renamed from: com.tramini.plugin.a.i.b$a$a$a, reason: collision with other inner class name */
            final class C0540a implements ValueCallback<String> {
                C0540a() {
                }

                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(String str) {
                    Properties properties = new Properties();
                    try {
                        properties.load(new StringReader("unicodedString=".concat(String.valueOf(str))));
                    } catch (IOException unused) {
                    }
                    String property = properties.getProperty("unicodedString");
                    if (property.length() > 2) {
                        a.this.f19356u[0] = property.substring(1, property.length() - 1);
                    }
                    synchronized (a.this.f19355t) {
                        a.this.f19355t.notifyAll();
                    }
                }
            }

            RunnableC0539a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (Build.VERSION.SDK_INT >= 19) {
                    a.this.f19354s.evaluateJavascript("(function() { return (document.getElementsByTagName('html')[0].innerHTML); })();", new C0540a());
                }
            }
        }

        a(WebView webView, ExecutorService executorService, String[] strArr) {
            this.f19354s = webView;
            this.f19355t = executorService;
            this.f19356u = strArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.f19354s == null) {
                    synchronized (this.f19355t) {
                        this.f19355t.notifyAll();
                    }
                }
                this.f19354s.post(new RunnableC0539a());
            } catch (Throwable unused) {
            }
        }
    }

    public static com.tramini.plugin.a.g.a a(JSONObject jSONObject, com.tramini.plugin.a.g.c cVar, String str, String str2) {
        return a(f.a(jSONObject.optString("in_na"), str), "", jSONObject.optString("tobj_k"), jSONObject.optLong("bwt", 10000L), jSONObject.optLong("bswt", com.anythink.expressad.exoplayer.i.a.f9492f), jSONObject, jSONObject.optString("bu_k"), cVar.f19339e, str2);
    }

    private static String b(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            ArrayList<Field> arrayList = new ArrayList();
            f.a(obj.getClass(), arrayList);
            for (Field field : arrayList) {
                if (field != null) {
                    field.setAccessible(true);
                    Object obj2 = field.get(obj);
                    if (obj2 != null && (obj2 instanceof String) && ((String) obj2).contains("<!DOCTYPE html>")) {
                        return (String) obj2;
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static JSONObject c(Object obj, String str) {
        try {
            ArrayList<Field> arrayList = new ArrayList();
            f.a(obj.getClass(), arrayList);
            for (Field field : arrayList) {
                if (field != null) {
                    field.setAccessible(true);
                    Object obj2 = field.get(obj);
                    if (obj2 != null && (obj2 instanceof JSONObject) && !TextUtils.isEmpty(((JSONObject) obj2).optString(str, ""))) {
                        return (JSONObject) obj2;
                    }
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String d(String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            String strA = "";
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null) {
                    int iOptInt = jSONObjectOptJSONObject.optInt(NativeAdvancedJsUtils.f8246p, -1);
                    String strOptString = jSONObjectOptJSONObject.optString("param", "");
                    if (iOptInt == 101) {
                        if (TextUtils.isEmpty(str2)) {
                            continue;
                        } else {
                            strA = f.c.a(str2, strOptString);
                        }
                    }
                    if (!TextUtils.isEmpty(strA)) {
                        return strA;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x023a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.tramini.plugin.a.g.a a(java.lang.Object r33, java.lang.String r34, java.lang.String r35, long r36, long r38, org.json.JSONObject r40, java.lang.String r41, org.json.JSONArray r42, java.lang.String r43) {
        /*
            Method dump skipped, instruction units count: 700
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tramini.plugin.a.i.b.a(java.lang.Object, java.lang.String, java.lang.String, long, long, org.json.JSONObject, java.lang.String, org.json.JSONArray, java.lang.String):com.tramini.plugin.a.g.a");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x015e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.String r8, java.lang.Object r9, org.json.JSONObject r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tramini.plugin.a.i.b.a(java.lang.String, java.lang.Object, org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    private static String a(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            ArrayList<Field> arrayList = new ArrayList();
            f.a(obj.getClass(), arrayList);
            for (Field field : arrayList) {
                if (field != null) {
                    field.setAccessible(true);
                    Object obj2 = field.get(obj);
                    if (obj2 != null && (obj2 instanceof String) && ((String) obj2).endsWith(".mp4")) {
                        return (String) obj2;
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String a(WebView webView, long j2, long j3) {
        if (Build.VERSION.SDK_INT < 19) {
            return "";
        }
        try {
            Thread.sleep(j2);
        } catch (InterruptedException unused) {
        }
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(2);
        String[] strArr = new String[1];
        try {
            executorServiceNewFixedThreadPool.submit(new a(webView, executorServiceNewFixedThreadPool, strArr));
        } catch (Throwable unused2) {
        }
        try {
            synchronized (executorServiceNewFixedThreadPool) {
                executorServiceNewFixedThreadPool.wait(j2 + j3);
            }
            executorServiceNewFixedThreadPool.shutdown();
            return strArr[0] != null ? strArr[0] : "";
        } catch (Exception unused3) {
            return "";
        }
    }
}
