package com.bytedance.sdk.component.e;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import com.alibaba.android.arouter.utils.Consts;
import com.bytedance.component.sdk.annotation.WorkerThread;
import com.bytedance.sdk.component.e.wu;
import com.yuewen.en2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class y {
    private final LruCache<String, d> bf;
    private final wu.e d;
    private final Map<String, List<bf>> e = new ConcurrentHashMap();
    private volatile boolean ga = false;
    private final String tg;

    public static final class bf {
        wl bf;
        List<String> d;
        Pattern e;
        List<String> tg;

        private bf() {
        }
    }

    public static final class d {
        wl e = wl.PUBLIC;
        Set<String> bf = new HashSet();
        Set<String> d = new HashSet();
    }

    public static class e extends IllegalStateException {
        public e(String str) {
            super(str);
        }
    }

    @WorkerThread
    public y(String str, int i, wu.e eVar, final Executor executor, JSONObject jSONObject) {
        this.tg = str;
        if (i <= 0) {
            this.bf = new LruCache<>(16);
        } else {
            this.bf = new LruCache<>(i);
        }
        this.d = eVar;
        if (jSONObject == null) {
            eVar.e(tg(str), new wu.e.InterfaceC0099e() { // from class: com.bytedance.sdk.component.e.y.1
            });
        } else {
            update(jSONObject);
        }
    }

    private static String bf(String str) {
        String[] strArrSplit;
        int length;
        if (str == null || (length = (strArrSplit = str.split("[.]")).length) < 2) {
            return null;
        }
        if (length == 2) {
            return str;
        }
        return strArrSplit[length - 2] + Consts.DOT + strArrSplit[length - 1];
    }

    private List<bf> d(String str) throws e {
        if (this.ga) {
            return this.e.get(str);
        }
        throw new e("Permission config is outdated!");
    }

    private static String tg(String str) {
        return "com.bytedance.ies.web.jsbridge2.PermissionConfig." + str;
    }

    public d e(String str, Set<String> set) {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        String string = new Uri.Builder().scheme(scheme).authority(authority).path(uri.getPath()).toString();
        d dVar = new d();
        if (authority == null || authority.isEmpty()) {
            dVar.e = wl.PUBLIC;
            return dVar;
        }
        for (String str2 : set) {
            if (!authority.equals(str2)) {
                if (authority.endsWith(Consts.DOT + str2)) {
                }
            }
            dVar.e = wl.PRIVATE;
            return dVar;
        }
        d dVar2 = this.bf.get(string);
        return dVar2 != null ? dVar2 : e(string);
    }

    public void update(JSONObject jSONObject) {
        e(jSONObject);
        this.d.e(tg(this.tg), jSONObject.toString());
    }

    @WorkerThread
    private static bf bf(JSONObject jSONObject) throws JSONException {
        bf bfVar = new bf();
        bfVar.e = Pattern.compile(jSONObject.getString("pattern"));
        bfVar.bf = wl.e(jSONObject.getString(en2.d));
        bfVar.d = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("included_methods");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                bfVar.d.add(jSONArrayOptJSONArray.getString(i));
            }
        }
        bfVar.tg = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("excluded_methods");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                bfVar.tg.add(jSONArrayOptJSONArray2.getString(i2));
            }
        }
        return bfVar;
    }

    @WorkerThread
    private void e(JSONObject jSONObject) {
        this.e.clear();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONArray jSONArray = jSONObject2.getJSONArray(next);
                LinkedList linkedList = new LinkedList();
                this.e.put(next, linkedList);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList.add(bf(jSONArray.getJSONObject(i)));
                }
            }
        } catch (JSONException e2) {
            zk.bf("Parse configurations failed, response: " + jSONObject.toString(), e2);
        }
        this.ga = true;
    }

    private d e(String str) throws e {
        d dVar = new d();
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        String strBf = bf(authority);
        if (!TextUtils.isEmpty(scheme) && !TextUtils.isEmpty(authority) && strBf != null) {
            List<bf> listD = d(strBf);
            if (listD == null) {
                return dVar;
            }
            for (bf bfVar : listD) {
                if (bfVar.e.matcher(str).find()) {
                    if (bfVar.bf.compareTo(dVar.e) >= 0) {
                        dVar.e = bfVar.bf;
                    }
                    dVar.bf.addAll(bfVar.d);
                    dVar.d.addAll(bfVar.tg);
                }
            }
            this.bf.put(str, dVar);
            return dVar;
        }
        dVar.e = wl.PUBLIC;
        return dVar;
    }
}
