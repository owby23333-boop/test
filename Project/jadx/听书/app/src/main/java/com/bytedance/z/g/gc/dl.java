package com.bytedance.z.g.gc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.z.g.gz.uy;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class dl {
    private Context z;

    public dl(Context context) {
        this.z = context;
    }

    public void z(boolean z) {
        z();
        if (z) {
            g();
        }
    }

    private void z() {
        try {
            SharedPreferences sharedPreferencesG = com.bytedance.sdk.openadsdk.api.plugin.g.g(this.z, "npth", 0);
            long j = sharedPreferencesG.getLong("history_time", -1L);
            if (j < 0) {
                sharedPreferencesG.edit().putLong("history_time", System.currentTimeMillis()).apply();
            } else if (System.currentTimeMillis() - j > 86400000) {
                com.bytedance.z.g.gz.a.z(com.bytedance.z.g.gz.gz.g(this.z));
                sharedPreferencesG.edit().putLong("history_time", System.currentTimeMillis()).apply();
            }
        } catch (Exception e) {
            wp.z(e);
        }
    }

    private void g() {
        File[] fileArrZ = z(com.bytedance.z.g.gz.gz.z(this.z), ".npth");
        if (fileArrZ == null) {
            return;
        }
        Arrays.sort(fileArrZ, Collections.reverseOrder());
        for (int i = 0; i < fileArrZ.length && i < 50; i++) {
            File file = fileArrZ[i];
            try {
                if (com.bytedance.z.g.g.z.z().z(file.getAbsolutePath())) {
                    com.bytedance.z.g.gz.a.z(file);
                } else {
                    com.bytedance.z.g.dl.dl dlVarDl = com.bytedance.z.g.gz.a.dl(file.getAbsolutePath());
                    if (dlVarDl != null && dlVarDl.g() != null) {
                        JSONObject jSONObjectG = dlVarDl.g();
                        z(file.getName(), jSONObjectG);
                        dlVarDl.g().put("upload_scene", "launch_scan");
                        if (com.bytedance.z.g.e.g.z(dlVarDl.z(), jSONObjectG.toString(), dlVarDl.dl()).z() && !com.bytedance.z.g.gz.a.z(file)) {
                            com.bytedance.z.g.g.z.z().z(com.bytedance.z.g.g.z.z.z(file.getAbsolutePath()));
                        }
                    }
                }
            } catch (Exception e) {
                uy.g(e);
            }
        }
    }

    private com.bytedance.z.g.dl z(String str, JSONObject jSONObject) {
        if (jSONObject == null && TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("launch_")) {
            return com.bytedance.z.g.dl.LAUNCH;
        }
        if (str.startsWith("anr_")) {
            return com.bytedance.z.g.dl.ANR;
        }
        if (str.startsWith("java_")) {
            if (jSONObject.optInt("is_dart") == 1) {
                return com.bytedance.z.g.dl.DART;
            }
            if (jSONObject.optInt("isJava") == 1) {
                return com.bytedance.z.g.dl.JAVA;
            }
        }
        return null;
    }

    private File[] z(File file, String str) {
        if (!file.exists()) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return file.listFiles();
        }
        return file.listFiles(new FilenameFilter() { // from class: com.bytedance.z.g.gc.dl.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                return str2 != null && str2.endsWith(".npth");
            }
        });
    }
}
