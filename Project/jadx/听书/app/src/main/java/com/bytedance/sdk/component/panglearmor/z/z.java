package com.bytedance.sdk.component.panglearmor.z;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import com.bytedance.sdk.component.panglearmor.z.g.m;
import com.bytedance.sdk.openadsdk.api.plugin.g;
import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static z z;
    private long g = 0;

    public static z z() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z zVar = new z();
                    z = zVar;
                    zVar.g = 0L;
                }
            }
        }
        return z;
    }

    private boolean g() {
        return new SecureRandom().nextInt(10) == 1;
    }

    @DungeonFlag
    private boolean dl() {
        SharedPreferences sharedPreferences = SoftDecTool.getSharedPreferences(SoftDecTool.SP_NAME);
        if (sharedPreferences == null) {
            return false;
        }
        this.g = (System.currentTimeMillis() / 1000) - SoftDecTool.fr();
        int i = sharedPreferences.getInt("hit_times", 0);
        if (i < 2 && this.g >= 172800) {
            sharedPreferences.edit().putInt("hit_times", 2).apply();
            return g();
        }
        if (i != 0 || this.g < 21600) {
            return false;
        }
        sharedPreferences.edit().putInt("hit_times", 1).apply();
        return g();
    }

    public synchronized JSONObject z(Context context, String str) {
        String strG;
        JSONObject jSONObject = new JSONObject();
        try {
            strG = g(context);
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(strG) && dl()) {
            File file = new File(strG);
            if (file.exists()) {
                jSONObject = z(file, context, str);
            }
            return jSONObject;
        }
        return null;
    }

    @DungeonFlag
    private JSONObject z(File file, Context context, String str) {
        JSONObject jSONObjectZ = m.z(file);
        File fileZ = g.z(context);
        if (fileZ != null) {
            m.z(jSONObjectZ, "files", z(!TextUtils.isEmpty(str) ? g.z(context).getParent() : g.z(context).getPath()), false);
            File parentFile = fileZ.getParentFile();
            if (parentFile != null) {
                List<String> listZ = z((!TextUtils.isEmpty(str) ? parentFile.getParent() : parentFile.getPath()) + "/shared_prefs");
                List<String> listZ2 = z((!TextUtils.isEmpty(str) ? parentFile.getParent() : parentFile.getPath()) + "/databases");
                m.z(jSONObjectZ, "prefs", listZ, false);
                m.z(jSONObjectZ, "databases", listZ2, false);
            }
        }
        try {
            JSONObject jSONObjectZ2 = z(context);
            if (jSONObjectZ2 != null && jSONObjectZ2.length() > 0) {
                jSONObjectZ.put("manifest", jSONObjectZ2);
            }
            jSONObjectZ.put("rt", this.g);
            jSONObjectZ.put("path", str);
        } catch (JSONException unused) {
        }
        return jSONObjectZ;
    }

    private List<String> z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile() && file2.exists()) {
                    arrayList.add(file2.getName());
                }
            }
        }
        return arrayList;
    }

    private JSONObject z(Context context) {
        if (context == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 4239);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                jSONObject.put("application_name", applicationInfo.name);
                jSONObject.put("label", packageManager.getApplicationLabel(applicationInfo));
            }
            if (packageInfo != null) {
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                String[] strArr = packageInfo.requestedPermissions;
                ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (activityInfoArr != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        jSONArray.put(activityInfo.name);
                    }
                    jSONObject.put("activities", jSONArray);
                }
                if (strArr != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str : strArr) {
                        jSONArray2.put(str);
                    }
                    jSONObject.put("permissions", jSONArray2);
                }
                if (activityInfoArr2 != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (ActivityInfo activityInfo2 : activityInfoArr2) {
                        jSONArray3.put(activityInfo2.name);
                    }
                    jSONObject.put("receivers", jSONArray3);
                }
                if (serviceInfoArr != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        jSONArray4.put(serviceInfo.name);
                    }
                    jSONObject.put("services", jSONArray4);
                }
                if (providerInfoArr != null) {
                    JSONArray jSONArray5 = new JSONArray();
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        jSONArray5.put(providerInfo.name);
                    }
                    jSONObject.put("providers", jSONArray5);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String g(Context context) {
        if (context == null) {
            return null;
        }
        String packageCodePath = context.getPackageCodePath();
        if (TextUtils.isEmpty(packageCodePath)) {
            return null;
        }
        File file = new File(packageCodePath);
        if (file.exists() && file.canRead()) {
            return packageCodePath;
        }
        return null;
    }
}
