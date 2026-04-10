package com.bytedance.sdk.component.e.dl;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.a.fo;
import com.funny.audio.core.utils.FileUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class g implements com.bytedance.sdk.component.e.g, com.bytedance.sdk.component.e.z {
    private final boolean dl;
    private final com.bytedance.sdk.component.a.g.z g;
    private com.bytedance.sdk.component.a.g.z z;

    public g(com.bytedance.sdk.component.a.g.z zVar, boolean z) {
        this.z = zVar;
        this.g = zVar;
        this.dl = z;
    }

    private void z(String str) {
        int i;
        fo foVar;
        com.bytedance.sdk.component.a.g.z encrypt;
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            try {
                i = Integer.parseInt(str);
            } catch (Throwable unused) {
                i = 0;
            }
        }
        if (i == 0) {
            this.z = null;
            return;
        }
        com.bytedance.sdk.component.a.g.z zVar = this.z;
        if ((zVar != null && zVar.type() == i) || (foVar = (fo) com.bytedance.sdk.openadsdk.ats.dl.z("kv_store_factory")) == null || (encrypt = foVar.getEncrypt(i)) == null) {
            return;
        }
        this.z = encrypt;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x013e A[Catch: all -> 0x014e, TRY_LEAVE, TryCatch #6 {all -> 0x014e, blocks: (B:13:0x0031, B:15:0x003a, B:16:0x0041, B:17:0x004e, B:19:0x0054, B:21:0x0060, B:23:0x0066, B:25:0x006a, B:26:0x0070, B:28:0x0074, B:29:0x0078, B:67:0x00ec, B:69:0x00f2, B:70:0x0106, B:72:0x010c, B:73:0x0116, B:74:0x011a, B:75:0x0126, B:76:0x0132, B:77:0x013e, B:42:0x00a4, B:45:0x00ae, B:48:0x00b8, B:51:0x00c2, B:54:0x00cc, B:57:0x00d6), top: B:117:0x0031 }] */
    @Override // com.bytedance.sdk.component.e.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.lang.Object> z(java.io.File r17) {
        /*
            Method dump skipped, instruction units count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.dl.g.z(java.io.File):java.util.Map");
    }

    private Pair<String, String> getType(String str) {
        if (str.contains(FileUtils.FILE_EXTENSION_SEPARATOR)) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length >= 2) {
                return new Pair<>(strArrSplit[0], strArrSplit[1]);
            }
        }
        return new Pair<>("s", str);
    }

    @Override // com.bytedance.sdk.component.e.g
    public void z(Map<String, Object> map, File file) throws Throwable {
        FileWriter fileWriter;
        Throwable th;
        String strConcat;
        if (file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        Properties properties = new Properties();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null) {
                if (entry.getValue() instanceof Set) {
                    Set set = (Set) entry.getValue();
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((String) it.next());
                    }
                    strConcat = "ss.".concat(String.valueOf(key));
                    value = jSONArray.toString();
                } else if (entry.getValue() instanceof Boolean) {
                    strConcat = "b.".concat(String.valueOf(key));
                } else if (entry.getValue() instanceof Integer) {
                    strConcat = "i.".concat(String.valueOf(key));
                } else if (entry.getValue() instanceof Long) {
                    strConcat = "l.".concat(String.valueOf(key));
                } else if ((entry.getValue() instanceof Float) || (entry.getValue() instanceof Double)) {
                    strConcat = "f.".concat(String.valueOf(key));
                } else {
                    strConcat = "s.".concat(String.valueOf(key));
                }
                String strValueOf = String.valueOf(value);
                if (this.dl) {
                    strConcat = this.g.encrypt(strConcat);
                }
                com.bytedance.sdk.component.a.g.z zVar = this.g;
                if (zVar != null) {
                    strValueOf = zVar.encrypt(String.valueOf(strValueOf));
                }
                properties.put(strConcat, strValueOf);
            }
        }
        try {
            fileWriter = new FileWriter(file);
        } catch (Throwable th2) {
            fileWriter = null;
            th = th2;
        }
        try {
            com.bytedance.sdk.component.a.g.z zVar2 = this.g;
            properties.put(".i.tt_ect", zVar2 != null ? String.valueOf(zVar2.type()) : "0");
            properties.store(fileWriter, (String) null);
            fileWriter.flush();
            try {
                fileWriter.close();
            } catch (Exception unused2) {
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }
}
