package com.bytedance.sdk.component.z;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.z.kb;
import com.funny.audio.core.utils.FileUtils;
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

/* JADX INFO: loaded from: classes2.dex */
class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f863a;
    private final kb.z dl;
    private final LruCache<String, dl> g;
    private final Map<String, List<g>> z = new ConcurrentHashMap();
    private volatile boolean gc = false;

    static final class dl {
        zw z = zw.PUBLIC;
        Set<String> g = new HashSet();
        Set<String> dl = new HashSet();

        dl() {
        }
    }

    q(String str, int i, kb.z zVar, final Executor executor, JSONObject jSONObject) {
        this.f863a = str;
        if (i <= 0) {
            this.g = new LruCache<>(16);
        } else {
            this.g = new LruCache<>(i);
        }
        this.dl = zVar;
        if (jSONObject == null) {
            a(str);
            new Object() { // from class: com.bytedance.sdk.component.z.q.1
            };
        } else {
            update(jSONObject);
        }
    }

    void update(JSONObject jSONObject) {
        z(jSONObject);
        a(this.f863a);
    }

    dl z(String str, Set<String> set) {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        String string = new Uri.Builder().scheme(scheme).authority(authority).path(uri.getPath()).toString();
        dl dlVar = new dl();
        if (authority == null || authority.isEmpty()) {
            dlVar.z = zw.PUBLIC;
            return dlVar;
        }
        for (String str2 : set) {
            if (authority.equals(str2) || authority.endsWith(FileUtils.FILE_EXTENSION_SEPARATOR.concat(String.valueOf(str2)))) {
                dlVar.z = zw.PRIVATE;
                return dlVar;
            }
        }
        dl dlVar2 = this.g.get(string);
        return dlVar2 != null ? dlVar2 : z(string);
    }

    private void z(JSONObject jSONObject) {
        this.z.clear();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONArray jSONArray = jSONObject2.getJSONArray(next);
                LinkedList linkedList = new LinkedList();
                this.z.put(next, linkedList);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList.add(g(jSONArray.getJSONObject(i)));
                }
            }
        } catch (JSONException e) {
            fo.g("Parse configurations failed, response: " + jSONObject.toString(), e);
        }
        this.gc = true;
    }

    private dl z(String str) throws z {
        dl dlVar = new dl();
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        String strG = g(authority);
        if (TextUtils.isEmpty(scheme) || TextUtils.isEmpty(authority) || strG == null) {
            dlVar.z = zw.PUBLIC;
            return dlVar;
        }
        List<g> listDl = dl(strG);
        if (listDl == null) {
            return dlVar;
        }
        for (g gVar : listDl) {
            if (gVar.z.matcher(str).find()) {
                if (gVar.g.compareTo(dlVar.z) >= 0) {
                    dlVar.z = gVar.g;
                }
                dlVar.g.addAll(gVar.dl);
                dlVar.dl.addAll(gVar.f864a);
            }
        }
        this.g.put(str, dlVar);
        return dlVar;
    }

    static class z extends IllegalStateException {
        z(String str) {
            super(str);
        }
    }

    private static String g(String str) {
        String[] strArrSplit;
        int length;
        if (str != null && (length = (strArrSplit = str.split("[.]")).length) >= 2) {
            return length == 2 ? str : strArrSplit[length - 2] + FileUtils.FILE_EXTENSION_SEPARATOR + strArrSplit[length - 1];
        }
        return null;
    }

    private List<g> dl(String str) throws z {
        if (!this.gc) {
            throw new z("Permission config is outdated!");
        }
        return this.z.get(str);
    }

    private static g g(JSONObject jSONObject) throws JSONException {
        g gVar = new g();
        gVar.z = Pattern.compile(jSONObject.getString("pattern"));
        gVar.g = zw.z(jSONObject.getString("group"));
        gVar.dl = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("included_methods");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                gVar.dl.add(jSONArrayOptJSONArray.getString(i));
            }
        }
        gVar.f864a = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("excluded_methods");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                gVar.f864a.add(jSONArrayOptJSONArray2.getString(i2));
            }
        }
        return gVar;
    }

    private static String a(String str) {
        return "com.bytedance.ies.web.jsbridge2.PermissionConfig.".concat(String.valueOf(str));
    }

    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<String> f864a;
        List<String> dl;
        zw g;
        Pattern z;

        private g() {
        }
    }
}
