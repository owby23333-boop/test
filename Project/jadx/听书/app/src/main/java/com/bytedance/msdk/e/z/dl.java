package com.bytedance.msdk.e.z;

import android.text.TextUtils;
import com.bytedance.msdk.core.gz.i;
import com.bytedance.msdk.core.gz.kb;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.dl.gz.a;
import com.bytedance.msdk.gz.l;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.sdk.component.utils.wp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static volatile dl z;
    private volatile Map<Integer, l> g = new ConcurrentHashMap();
    private Map<String, com.bytedance.msdk.core.uy.g> dl = new ConcurrentHashMap();

    private dl() {
    }

    public static dl z() {
        if (z == null) {
            synchronized (dl.class) {
                if (z == null) {
                    z = new dl();
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized l z(int i) {
        l lVarZ;
        lVarZ = this.g.get(Integer.valueOf(i));
        if (lVarZ == null) {
            lVarZ = com.bytedance.msdk.e.z.z(i);
            this.g.put(Integer.valueOf(i), lVarZ);
        }
        return lVarZ;
    }

    private synchronized void g(JSONArray jSONArray) {
        if (jSONArray != null) {
            if (jSONArray.length() > 0) {
                try {
                    this.dl.clear();
                    a.g.clear();
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        com.bytedance.msdk.core.uy.g gVarZ = com.bytedance.msdk.core.uy.g.z(jSONObject, false);
                        if (gVarZ != null && !TextUtils.isEmpty(gVarZ.un())) {
                            this.dl.put(gVarZ.un(), gVarZ);
                            concurrentHashMap.put(gVarZ.un(), jSONObject.toString());
                        }
                    }
                    z(concurrentHashMap);
                    a.z();
                    com.bytedance.msdk.e.z.z().z("prime_rit_count", jSONArray.length());
                } catch (JSONException e) {
                    wp.z(e);
                }
            }
        }
    }

    public synchronized void z(JSONArray jSONArray) {
        g(jSONArray);
        dl(jSONArray);
    }

    private void dl(final JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        m.a(new Runnable() { // from class: com.bytedance.msdk.e.z.dl.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.e.g.g.z().z(jSONArray);
            }
        });
    }

    public synchronized com.bytedance.msdk.core.uy.g z(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.msdk.core.uy.g gVarE = this.dl.get(str);
        if (gVarE == null && (gVarE = com.bytedance.msdk.core.uy.g.e(z(i, str))) != null) {
            this.dl.put(str, gVarE);
        }
        if (i2 == 102) {
            return gVarE;
        }
        com.bytedance.msdk.core.uy.g gVarZ = com.bytedance.msdk.core.fo.a.z(gVarE, i2);
        return gVarZ != null ? gVarZ : gVarE;
    }

    private String z(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (i == 0) {
            arrayList.add(1);
            arrayList.add(2);
            arrayList.add(3);
            arrayList.add(5);
            arrayList.add(7);
            arrayList.add(8);
            arrayList.add(9);
            arrayList.add(10);
        } else {
            arrayList.add(Integer.valueOf(i));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String strG = z(((Integer) it.next()).intValue()).g(str);
            if (!TextUtils.isEmpty(strG)) {
                return strG;
            }
        }
        return null;
    }

    public synchronized void g() {
        Map<String, com.bytedance.msdk.core.uy.g> map = this.dl;
        if (map != null) {
            map.clear();
        }
    }

    public synchronized boolean dl() {
        return com.bytedance.msdk.e.z.z().g("prime_rit_count", -1) <= 0;
    }

    private synchronized void z(final Map<String, String> map) {
        if (map != null) {
            if (map.size() != 0) {
                m.a(new Runnable() { // from class: com.bytedance.msdk.e.z.dl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        for (Map.Entry entry : map.entrySet()) {
                            try {
                                String str = (String) entry.getKey();
                                String str2 = (String) entry.getValue();
                                com.bytedance.msdk.core.uy.g gVar = (com.bytedance.msdk.core.uy.g) dl.this.dl.get(str);
                                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && gVar != null) {
                                    dl.this.z(gVar.ti()).z(str, str2);
                                    dl.this.z(gVar);
                                }
                            } catch (Throwable th) {
                                wp.z(th);
                            }
                        }
                        map.clear();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void z(com.bytedance.msdk.core.uy.g gVar) {
        if (gVar != null) {
            if (gVar.un() != null) {
                if (gVar.kb()) {
                    if (i.z().z(gVar.uy())) {
                        i.z().g(gVar.uy());
                    }
                    if (i.z().z(gVar.fo())) {
                        i.z().g(gVar.fo());
                    }
                } else {
                    i.z().a(gVar.un());
                    i.z().fo(gVar.un());
                }
                for (uy uyVar : gVar.t()) {
                    if (uyVar.a()) {
                        if (com.bytedance.msdk.core.gz.wp.z().z(uyVar.dl())) {
                            com.bytedance.msdk.core.gz.wp.z().g(uyVar.dl());
                        }
                        if (kb.z().z(uyVar.g())) {
                            kb.z().g(uyVar.g());
                        }
                    } else {
                        com.bytedance.msdk.core.gz.wp.z().delete(gVar.un(), uyVar.fv());
                        kb.z().delete(gVar.un(), uyVar.fv());
                    }
                }
            }
        }
    }
}
