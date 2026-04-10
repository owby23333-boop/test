package com.ss.android.downloadlib.addownload.g;

import android.content.SharedPreferences;
import com.ss.android.downloadlib.addownload.wp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class fo {

    private static class z {
        private static fo z = new fo();
    }

    public static fo z() {
        return z.z;
    }

    private fo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences dl() {
        return com.bytedance.sdk.openadsdk.ats.a.z(wp.getContext(), "sp_ad_download_event", 0);
    }

    ConcurrentHashMap<Long, com.ss.android.g.z.g.g> g() {
        ConcurrentHashMap<Long, com.ss.android.g.z.g.g> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, ?> all = dl().getAll();
        if (all == null) {
            return concurrentHashMap;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    long jLongValue = Long.valueOf(entry.getKey()).longValue();
                    com.ss.android.g.z.g.g gVarG = com.ss.android.g.z.g.g.g(new JSONObject(String.valueOf(entry.getValue())));
                    if (jLongValue > 0 && gVarG != null) {
                        concurrentHashMap.put(Long.valueOf(jLongValue), gVarG);
                    }
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
            }
        }
        return concurrentHashMap;
    }

    public void z(com.ss.android.g.z.g.g gVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(gVar);
        z((Collection<com.ss.android.g.z.g.g>) arrayList);
    }

    public synchronized void z(final Collection<com.ss.android.g.z.g.g> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                com.ss.android.downloadlib.gc.z().z(new Runnable() { // from class: com.ss.android.downloadlib.addownload.g.fo.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferences.Editor editorEdit = fo.this.dl().edit();
                        for (com.ss.android.g.z.g.g gVar : collection) {
                            if (gVar != null && gVar.g() != 0) {
                                editorEdit.putString(String.valueOf(gVar.g()), gVar.nh().toString());
                            }
                        }
                        editorEdit.apply();
                    }
                }, true);
            }
        }
    }

    public void z(final List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.ss.android.downloadlib.gc.z().z(new Runnable() { // from class: com.ss.android.downloadlib.addownload.g.fo.2
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor editorEdit = fo.this.dl().edit();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    editorEdit.remove((String) it.next());
                }
                editorEdit.apply();
            }
        }, true);
    }
}
