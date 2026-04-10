package com.kwad.sdk.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final Map<String, Set<com.kwad.sdk.core.config.item.b>> abo = new ConcurrentHashMap();
    private static SharedPreferences abp = null;

    static void a(Context context, com.kwad.sdk.core.config.item.b<?> bVar) {
        SharedPreferences sharedPreferencesAO;
        if (bVar == null || (sharedPreferencesAO = aO(context)) == null) {
            return;
        }
        try {
            bVar.a(sharedPreferencesAO);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    private static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            Iterator<String> it = abo.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = abo.get(it.next());
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
            Iterator<String> it = abo.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = abo.get(it.next());
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            try {
                                bVar.a(sharedPreferences);
                            } catch (Exception e2) {
                                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                            }
                        }
                    }
                }
            }
        }
    }

    public static <T> void a(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        String key = bVar.getKey();
        if (TextUtils.isEmpty(key)) {
            return;
        }
        Set<com.kwad.sdk.core.config.item.b> setBl = bl(key);
        if (setBl == null) {
            setBl = new CopyOnWriteArraySet<>();
            abo.put(key, setBl);
        }
        setBl.add(bVar);
    }

    private static SharedPreferences aO(Context context) {
        if (abp == null && context != null) {
            abp = context.getSharedPreferences("ksadsdk_config", 0);
        }
        return abp;
    }

    @WorkerThread
    public static synchronized boolean aP(Context context) {
        SharedPreferences sharedPreferencesAO = aO(context);
        if (sharedPreferencesAO == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesAO.edit();
        a(editorEdit);
        return editorEdit.commit();
    }

    @WorkerThread
    public static synchronized void aQ(Context context) {
        SharedPreferences sharedPreferencesAO = aO(context);
        if (sharedPreferencesAO != null) {
            a(sharedPreferencesAO);
        }
    }

    @Nullable
    private static Set<com.kwad.sdk.core.config.item.b> bl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return abo.get(str);
    }

    public static void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : abo.keySet()) {
            Set<com.kwad.sdk.core.config.item.b> set = abo.get(str);
            if (set != null && !set.isEmpty() && jSONObject.has(str)) {
                for (com.kwad.sdk.core.config.item.b bVar : set) {
                    if (bVar != null) {
                        bVar.f(jSONObject);
                    }
                }
            }
        }
    }
}
