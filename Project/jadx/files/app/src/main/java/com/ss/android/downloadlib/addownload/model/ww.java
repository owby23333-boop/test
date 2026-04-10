package com.ss.android.downloadlib.addownload.model;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ww {

    private static class mb {
        private static ww mb = new ww();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences b() {
        return x.getContext().getSharedPreferences("sp_ad_download_event", 0);
    }

    @NonNull
    ConcurrentHashMap<Long, com.ss.android.downloadad.api.mb.ox> ox() {
        ConcurrentHashMap<Long, com.ss.android.downloadad.api.mb.ox> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, ?> all = b().getAll();
        if (all == null) {
            return concurrentHashMap;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    long jLongValue = Long.valueOf(entry.getKey()).longValue();
                    com.ss.android.downloadad.api.mb.ox oxVarOx = com.ss.android.downloadad.api.mb.ox.ox(new JSONObject(String.valueOf(entry.getValue())));
                    if (jLongValue > 0 && oxVarOx != null) {
                        concurrentHashMap.put(Long.valueOf(jLongValue), oxVarOx);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return concurrentHashMap;
    }

    private ww() {
    }

    public static ww mb() {
        return mb.mb;
    }

    public void mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(oxVar);
        mb((Collection<com.ss.android.downloadad.api.mb.ox>) arrayList);
    }

    public synchronized void mb(final Collection<com.ss.android.downloadad.api.mb.ox> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.addownload.model.ww.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferences.Editor editorEdit = ww.this.b().edit();
                        for (com.ss.android.downloadad.api.mb.ox oxVar : collection) {
                            if (oxVar != null && oxVar.ox() != 0) {
                                editorEdit.putString(String.valueOf(oxVar.ox()), oxVar.km().toString());
                            }
                        }
                        editorEdit.apply();
                    }
                }, true);
            }
        }
    }

    public void mb(final List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.addownload.model.ww.2
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor editorEdit = ww.this.b().edit();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    editorEdit.remove((String) it.next());
                }
                editorEdit.apply();
            }
        }, true);
    }
}
