package com.bytedance.sdk.openadsdk.core.gk.z;

import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.a.g.dl;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.tb;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private boolean z(long j, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return j2 == 0 ? !eo.z(j, jCurrentTimeMillis) : jCurrentTimeMillis - j >= j2;
    }

    public void z(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectZ;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("id_conf")) == null) {
            return;
        }
        try {
            dl dlVarZ = com.bytedance.sdk.openadsdk.core.g.z();
            long j = dlVarZ.getLong("last_gather_id_time", 0L);
            long jOptLong = jSONObjectOptJSONObject.optLong("delt", 0L);
            if (j <= 0 || z(j, jOptLong)) {
                String strOptString = jSONObjectOptJSONObject.optString("store");
                int iOptInt = jSONObjectOptJSONObject.optInt("state", 0);
                if (iOptInt != 1) {
                    if (iOptInt != 2) {
                        if (iOptInt != 4) {
                            return;
                        }
                        File file = new File(strOptString);
                        File file2 = new File(com.bytedance.sdk.openadsdk.api.plugin.g.z(zw.getContext()), file.getName());
                        if (file2.exists()) {
                            file2.delete();
                        }
                        z(file);
                    }
                    jSONObjectZ = null;
                } else {
                    jSONObjectZ = z(strOptString);
                }
                int iOptInt2 = jSONObjectOptJSONObject.optInt("upload", 0);
                if (iOptInt2 > 0) {
                    dlVarZ.put("last_gather_id_time", System.currentTimeMillis());
                    File file3 = new File(strOptString);
                    jSONObjectZ.put("c_r", file3.canRead());
                    jSONObjectZ.put("c_w", file3.canWrite());
                    jSONObjectZ.put("d", strOptString);
                    z(strOptString, jSONObjectZ, iOptInt2 == 2);
                }
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private void z(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        z(file2);
                    }
                }
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    private JSONObject z(String str) throws JSONException {
        String strZ = uy.z();
        if (TextUtils.isEmpty(strZ)) {
            return null;
        }
        String str2 = (!tb.gc() ? 1 : 0) + strZ;
        JSONObject jSONObjectG = g(str);
        if (jSONObjectG == null) {
            jSONObjectG = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectG.optJSONObject("aid");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            jSONObjectG.putOpt("aid", jSONObjectOptJSONObject);
        }
        String packageName = zw.getContext().getPackageName();
        if (packageName == null) {
            packageName = com.bytedance.sdk.openadsdk.core.uy.ls().q();
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(packageName);
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONObjectOptJSONObject.put(packageName, jSONArrayOptJSONArray);
        }
        int i = 0;
        while (true) {
            if (i >= jSONArrayOptJSONArray.length()) {
                i = -1;
                break;
            }
            if (TextUtils.equals(jSONArrayOptJSONArray.optString(i), str2)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            jSONArrayOptJSONArray.put(str2);
        }
        g(jSONObjectG, str);
        z(jSONObjectOptJSONObject, str);
        return jSONObjectG;
    }

    @DungeonFlag
    private void z(JSONObject jSONObject, String str) {
        byte[] bArrA;
        File file = new File(str);
        if (file.exists()) {
            if (!file.canWrite()) {
                return;
            }
        } else if (!file.mkdirs()) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString) && (bArrA = a(next + "/" + strOptString)) != null) {
                        File file2 = new File(str, z.z(bArrA, 20));
                        if (file2.isFile()) {
                            file2.delete();
                        }
                        file2.mkdirs();
                        file2.getAbsolutePath();
                    }
                }
            }
        }
    }

    private void g(JSONObject jSONObject, String str) {
        FileOutputStream fileOutputStream;
        byte[] bArrA = a(jSONObject.toString());
        if (bArrA == null || bArrA.length <= 0) {
            return;
        }
        try {
            fileOutputStream = new FileOutputStream(new File(com.bytedance.sdk.openadsdk.api.plugin.g.z(zw.getContext()), new File(str).getName()));
        } catch (Throwable unused) {
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArrA);
            com.bytedance.sdk.component.m.dl.dl.g.z(fileOutputStream);
        } catch (Throwable unused2) {
            com.bytedance.sdk.component.m.dl.dl.g.z(fileOutputStream);
        }
    }

    @DungeonFlag
    private JSONObject g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        JSONObject jSONObjectDl = dl(str);
        if (file.exists() && file.isDirectory() && file.canRead()) {
            HashMap map = new HashMap();
            z(file, str, map);
            if (map.size() == 0) {
                return jSONObjectDl;
            }
            if (jSONObjectDl == null) {
                jSONObjectDl = new JSONObject();
            }
            JSONObject jSONObjectOptJSONObject = jSONObjectDl.optJSONObject("aid");
            try {
                if (jSONObjectOptJSONObject == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObjectDl.put("aid", jSONObject);
                    } catch (JSONException unused) {
                    }
                    jSONObjectOptJSONObject = jSONObject;
                } else {
                    for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(entry.getKey());
                        if (jSONArrayOptJSONArray != null) {
                            Set<String> value = entry.getValue();
                            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                String strOptString = jSONArrayOptJSONArray.optString(i);
                                if (!TextUtils.isEmpty(strOptString)) {
                                    value.add(strOptString);
                                }
                            }
                        }
                    }
                }
            } catch (JSONException unused2) {
            }
            for (Map.Entry<String, Set<String>> entry2 : map.entrySet()) {
                String key = entry2.getKey();
                Set<String> value2 = entry2.getValue();
                if (!TextUtils.isEmpty(key) && value2 != null && value2.size() != 0) {
                    try {
                        JSONArray jSONArray = new JSONArray();
                        Iterator<String> it = value2.iterator();
                        while (it.hasNext()) {
                            jSONArray.put(it.next());
                        }
                        jSONObjectOptJSONObject.put(key, jSONArray);
                    } catch (JSONException e) {
                        wp.z(e);
                    }
                }
            }
        }
        return jSONObjectDl;
    }

    private JSONObject dl(String str) {
        byte[] bArrA = m.a(new File(com.bytedance.sdk.openadsdk.api.plugin.g.z(zw.getContext()), new File(str).getName()));
        if (bArrA == null) {
            return null;
        }
        try {
            String strZ = z(bArrA);
            if (strZ != null) {
                return new JSONObject(strZ);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        return null;
    }

    private void z(File file, String str, Map<String, Set<String>> map) {
        if (file == null || !file.exists() || !file.canRead() || file.getName().startsWith("._tt_")) {
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                file.delete();
                String absolutePath = file.getAbsolutePath();
                if (absolutePath.length() <= str.length()) {
                    return;
                }
                try {
                    String strZ = z(z.z(absolutePath.substring(str.length() + 1)));
                    if (strZ == null) {
                        return;
                    }
                    String[] strArrSplit = strZ.split("/");
                    if (strArrSplit.length != 2) {
                        return;
                    }
                    String str2 = strArrSplit[0];
                    String str3 = strArrSplit[1];
                    Set<String> hashSet = map.get(str2);
                    if (hashSet == null) {
                        hashSet = new HashSet<>();
                        map.put(str2, hashSet);
                    }
                    hashSet.add(str3);
                    return;
                } catch (JSONException unused) {
                    return;
                }
            }
            for (File file2 : fileArrListFiles) {
                if (!file2.getName().startsWith("._tt_") && file2.isDirectory()) {
                    z(file2, str, map);
                    file2.delete();
                }
            }
            return;
        }
        try {
            file.delete();
        } catch (Throwable unused2) {
        }
    }

    private byte[] a(String str) {
        byte[] bytes = com.bytedance.sdk.component.utils.z.g(str).getBytes(StandardCharsets.UTF_8);
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length + 1);
        byteBufferAllocate.put((byte) 3);
        byteBufferAllocate.put(bytes);
        return byteBufferAllocate.array();
    }

    private String z(byte[] bArr) throws JSONException {
        byte b = bArr[0];
        int length = bArr.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 1, bArr2, 0, length);
        if (b == 3) {
            return com.bytedance.sdk.component.utils.z.dl(new String(bArr2));
        }
        return null;
    }

    private void z(String str, JSONObject jSONObject, boolean z) {
        if (z || gc(str)) {
            z(str, jSONObject);
        }
    }

    private void z(String str, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            jSONObject = g(str);
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("aid");
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            HashSet hashSet = new HashSet();
            int i = 0;
            while (itKeys.hasNext()) {
                i++;
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(itKeys.next());
                if (jSONArrayOptJSONArray != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i2);
                        if (!TextUtils.isEmpty(strOptString)) {
                            hashSet.add(strOptString);
                        }
                    }
                }
            }
            try {
                jSONObject.put("size", i);
                if (!hashSet.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                    jSONObject.put(TtmlNode.COMBINE_ALL, jSONArray);
                }
            } catch (JSONException unused) {
            }
        }
        v.z().z("s_d_i_c", jSONObject);
    }

    private boolean gc(String str) {
        File[] fileArrListFiles;
        long jLastModified;
        File file = new File(str);
        boolean z = true;
        if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                String name = file2.getName();
                if (name.startsWith("._tt_")) {
                    try {
                        jLastModified = Long.parseLong(name.substring(5));
                    } catch (Throwable unused) {
                        jLastModified = file2.lastModified();
                    }
                    if (eo.z(jLastModified, System.currentTimeMillis())) {
                        z = false;
                    } else {
                        file2.delete();
                    }
                }
            }
        }
        if (z) {
            new File(file, "._tt_" + System.currentTimeMillis()).mkdirs();
        }
        return z;
    }
}
