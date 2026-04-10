package com.bytedance.sdk.openadsdk.g;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.dl.a;
import com.bykv.vk.openvk.component.video.api.dl.dl;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.io.gc;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.fo;
import com.funny.audio.core.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private Set<String> dl;
    private ReentrantLock g;
    private Map<String, com.bytedance.sdk.openadsdk.g.z> z;

    private static final class z {
        private static final g z = new g();
    }

    public static g z() {
        return z.z;
    }

    private g() {
        this.z = new HashMap();
        this.g = new ReentrantLock();
        this.dl = new HashSet();
        String str = com.bytedance.sdk.openadsdk.core.g.z().get("sdk_brand_video_cahce", "");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                g(jSONArray.optJSONObject(i));
            }
        } catch (Throwable unused) {
        }
    }

    private com.bytedance.sdk.component.fo.z g() {
        return gc.z().g();
    }

    private void g(JSONObject jSONObject) {
        if (jSONObject != null) {
            com.bytedance.sdk.openadsdk.g.z zVar = new com.bytedance.sdk.openadsdk.g.z(jSONObject);
            this.z.put(zVar.g(), zVar);
        }
    }

    public void z(JSONObject jSONObject) {
        final JSONArray jSONArrayDl = dl(jSONObject);
        if (jSONArrayDl == null || jSONArrayDl.length() == 0) {
            return;
        }
        gz.z().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.g.g.1
            @Override // java.lang.Runnable
            public void run() {
                jSONArrayDl.length();
                g.this.z(jSONArrayDl);
            }
        }, 20000L);
    }

    private JSONArray dl(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("creatives");
        JSONArray jSONArray = new JSONArray();
        if (jSONArrayOptJSONArray2 == null) {
            return jSONArray;
        }
        for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("precache_brand_video")) != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    jSONArray.put(jSONArrayOptJSONArray.opt(i2));
                }
            }
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(JSONArray jSONArray) {
        try {
            this.g.lock();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                g(jSONArray.optJSONObject(i));
            }
            Map<String, com.bytedance.sdk.openadsdk.g.z> mapGc = gc();
            int iDl = dl();
            a();
            delete(mapGc);
            this.g.unlock();
            z(iDl);
        } catch (Throwable th) {
            this.g.unlock();
            throw th;
        }
    }

    private void z(int i) {
        File[] fileArrListFiles = new File(fo.z()).listFiles();
        int iUm = zw.g().um();
        if (fileArrListFiles == null || fileArrListFiles.length <= iUm - i) {
            return;
        }
        for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
            String strZ = z(fileArrListFiles[i2]);
            if (!this.z.containsKey(strZ) && fileArrListFiles[i2].exists()) {
                fileArrListFiles[i2].delete();
                wp.g("BrandVideoCacheManager", "delete not need:".concat(String.valueOf(strZ)));
            }
        }
    }

    private String z(File file) {
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR);
        return iLastIndexOf != -1 ? name.substring(0, iLastIndexOf) : name;
    }

    private void delete(Map<String, com.bytedance.sdk.openadsdk.g.z> map) {
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            map.get(it.next()).g(fo.z());
        }
    }

    private int dl() {
        Iterator<String> it = this.z.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            a aVarZ = z(this.z.get(it.next()));
            if (aVarZ != null) {
                String strGc = aVarZ.gc();
                String strP = aVarZ.p();
                String strLs = aVarZ.ls();
                File file = new File(strGc, strP);
                if (!file.exists() || file.length() <= 0) {
                    i++;
                    if (this.dl.contains(strP)) {
                        wp.z("BrandVideoCacheManager", " task :" + strP + " is running!");
                    } else {
                        this.dl.add(strP);
                        z(strLs, strGc, strP);
                    }
                }
            }
        }
        return i;
    }

    private void z(final String str, String str2, final String str3) {
        com.bytedance.sdk.component.fo.g.g gVarA = g().a();
        gVarA.z(str);
        gVarA.z(str2, str3);
        gVarA.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.g.g.2
            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                g.this.z(str3);
            }

            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                wp.g("BrandVideoCacheManager", "download " + str + " failed: " + iOException);
                g.this.z(str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str) {
        try {
            this.g.lock();
            this.dl.remove(str);
        } finally {
            this.g.unlock();
        }
    }

    private a z(com.bytedance.sdk.openadsdk.g.z zVar) {
        if (zVar == null) {
            return null;
        }
        String strG = zVar.g();
        if (TextUtils.isEmpty(strG)) {
            strG = com.bytedance.sdk.component.utils.gc.g(zVar.z());
        }
        dl dlVar = new dl();
        dlVar.dl(zVar.z());
        dlVar.gc(strG);
        dlVar.gc(0);
        a aVar = new a(fo.z(), dlVar, dlVar, 0, 0);
        aVar.z(fo.z());
        return aVar;
    }

    private void a() {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.z.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.openadsdk.g.z zVar = this.z.get(it.next());
            if (zVar != null) {
                jSONArray.put(zVar.gc());
            }
        }
        com.bytedance.sdk.openadsdk.core.g.z().put("sdk_brand_video_cahce", jSONArray.toString());
    }

    private Map<String, com.bytedance.sdk.openadsdk.g.z> gc() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, com.bytedance.sdk.openadsdk.g.z>> it = this.z.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, com.bytedance.sdk.openadsdk.g.z> next = it.next();
            if (next.getValue().a()) {
                map.put(next.getKey(), next.getValue());
                it.remove();
            } else {
                arrayList.add(next.getValue());
            }
        }
        int size = this.z.size() - zw.g().um();
        if (size > 0) {
            Collections.sort(arrayList, new Comparator<com.bytedance.sdk.openadsdk.g.z>() { // from class: com.bytedance.sdk.openadsdk.g.g.3
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                public int compare(com.bytedance.sdk.openadsdk.g.z zVar, com.bytedance.sdk.openadsdk.g.z zVar2) {
                    long jDl = zVar2.dl() - zVar.dl();
                    if (jDl == 0) {
                        String strZ = fo.z();
                        jDl = zVar.z(strZ) - zVar2.z(strZ);
                    }
                    return (int) jDl;
                }
            });
            for (int i = 0; i < size; i++) {
                com.bytedance.sdk.openadsdk.g.z zVar = (com.bytedance.sdk.openadsdk.g.z) arrayList.get(i);
                this.z.remove(zVar.g());
                map.put(zVar.g(), zVar);
            }
        }
        return map;
    }
}
