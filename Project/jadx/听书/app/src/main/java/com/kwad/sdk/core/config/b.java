package com.kwad.sdk.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bo;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static final Map<String, Set<com.kwad.sdk.core.config.item.b>> ayA = new ConcurrentHashMap();
    private static SharedPreferences ayB = null;

    public static <T> void a(com.kwad.sdk.core.config.item.b<T> bVar) {
        String key = bVar.getKey();
        if (TextUtils.isEmpty(key)) {
            return;
        }
        Set<com.kwad.sdk.core.config.item.b> setDy = dy(key);
        if (setDy == null) {
            setDy = new CopyOnWriteArraySet<>();
            ayA.put(key, setDy);
        }
        setDy.add(bVar);
    }

    private static Set<com.kwad.sdk.core.config.item.b> dy(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ayA.get(str);
    }

    public static void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : ayA.keySet()) {
            Set<com.kwad.sdk.core.config.item.b> set = ayA.get(str);
            if (set != null && !set.isEmpty() && jSONObject.has(str)) {
                for (com.kwad.sdk.core.config.item.b bVar : set) {
                    if (bVar != null) {
                        bVar.k(jSONObject);
                    }
                }
            }
        }
    }

    private static SharedPreferences EN() {
        if (ayB == null) {
            ayB = bo.ho("ksadsdk_config");
        }
        return ayB;
    }

    public static synchronized void bq(Context context) {
        try {
            SharedPreferences sharedPreferencesEN = EN();
            if (sharedPreferencesEN != null) {
                SharedPreferences.Editor editorEdit = sharedPreferencesEN.edit();
                a(editorEdit);
                editorEdit.commit();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static synchronized void br(Context context) {
        SharedPreferences sharedPreferencesEN = EN();
        if (sharedPreferencesEN != null) {
            a(sharedPreferencesEN);
        }
    }

    private static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            Iterator<String> it = ayA.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = ayA.get(it.next());
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            bVar.b(editor);
                        }
                    }
                }
            }
        }
    }

    private static void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            Iterator<String> it = ayA.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = ayA.get(it.next());
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            try {
                                bVar.a(sharedPreferences);
                            } catch (Exception e) {
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                            }
                        }
                    }
                }
            }
        }
    }

    static void a(Context context, com.kwad.sdk.core.config.item.b<?> bVar) {
        SharedPreferences sharedPreferencesEN;
        if (bVar == null || (sharedPreferencesEN = EN()) == null) {
            return;
        }
        try {
            bVar.a(sharedPreferencesEN);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }
}
