package com.bytedance.sdk.openadsdk.core.hh.g;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.zw;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static Map<String, Integer> dl = new HashMap();
    private static String g;
    private static String z;

    static {
        if (dl.z()) {
            g = Build.SUPPORTED_ABIS[0];
        } else {
            g = Build.CPU_ABI;
        }
        dl.put("arm64-v8a", 64);
        dl.put("armeabi-v7a", 32);
        dl.put("armeabi", 32);
        dl.put("x86_64", 64);
        dl.put("x86", 32);
        dl.put("mips64", 64);
        dl.put("mips", 32);
        z = g();
    }

    private static Map<String, List<ZipEntry>> z(ZipFile zipFile) {
        String[] strArrSplit;
        HashMap map = new HashMap();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        Pattern patternCompile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (!zipEntryNextElement.isDirectory() && patternCompile.matcher(zipEntryNextElement.getName()).matches() && (strArrSplit = zipEntryNextElement.getName().split(File.separator)) != null && strArrSplit.length >= 2) {
                String str = strArrSplit[strArrSplit.length - 2];
                if (dl.containsKey(str)) {
                    if (map.get(str) == null) {
                        map.put(str, new LinkedList());
                    }
                    ((List) map.get(str)).add(zipEntryNextElement);
                }
            }
        }
        wp.z("NativeLibHelper", "NativeLibHelper getAllSoZipEntries, zipFile=" + zipFile.getName() + ", soEntries=" + map.toString());
        return map;
    }

    public static String z() {
        String str = z;
        if (str != null) {
            return str;
        }
        String strG = g();
        z = strG;
        return strG;
    }

    private static String g() {
        JSONObject jSONObjectDl = dl();
        String strZ = z(jSONObjectDl);
        return strZ == null ? g(jSONObjectDl) : strZ;
    }

    private static String z(JSONObject jSONObject) {
        if (!dl.z()) {
            return null;
        }
        try {
            String str = (String) z.z(zw.getContext().getApplicationInfo(), "primaryCpuAbi");
            wp.g("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=".concat(String.valueOf(str)));
            z(jSONObject, "primaryCpuAbi", str);
            if (str == null) {
                return null;
            }
            int i = 0;
            if (dl.g()) {
                try {
                    i = Process.is64Bit() ? 64 : 32;
                    wp.g("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode=".concat(String.valueOf(i)));
                } catch (Exception unused) {
                    wp.g("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode exception default=".concat(String.valueOf(i)));
                }
            } else {
                wp.g("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode default=0");
            }
            z(jSONObject, "processMode", String.valueOf(i));
            if (i != 0) {
                if (dl.get(str).intValue() != i) {
                    return null;
                }
                wp.g("NativeLibHelper", "NativeLibHelper inferHostAbiAuto2, sHostAbi=".concat(String.valueOf(str)));
                return str;
            }
            wp.g("NativeLibHelper", "NativeLibHelper inferHostAbiAuto1, sHostAbi=".concat(String.valueOf(str)));
            return str;
        } catch (Exception e) {
            wp.dl("NativeLibHelper", "NativeLibHelper inferHostAbiAuto failed!", e);
            z(jSONObject, "autoError", "1");
            return null;
        }
    }

    private static String g(JSONObject jSONObject) {
        HashSet hashSet;
        String[] strArr;
        try {
            Context context = zw.getContext();
            ZipFile zipFile = new ZipFile(new File(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir));
            hashSet = new HashSet(z(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException unused) {
                wp.g("NativeLibHelper", "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");
            }
            strArr = dl.z() ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        } catch (Throwable th) {
            wp.dl("NativeLibHelper", "NativeLibHelper inferHostAbiManual failed!", th);
            z(jSONObject, "manualError", "1");
        }
        if (hashSet.isEmpty()) {
            wp.g("NativeLibHelper", "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + strArr[0]);
            z(jSONObject, "supportedABI0", strArr[0]);
            return strArr[0];
        }
        for (String str : strArr) {
            if (hashSet.contains(str)) {
                wp.g("NativeLibHelper", "NativeLibHelper inferHostAbiManual, match cpuAbi=".concat(String.valueOf(str)));
                z(jSONObject, "matchCpuAbi", str);
                return str;
            }
        }
        if (dl.z()) {
            z(jSONObject, "defaultABI0", Build.SUPPORTED_ABIS[0]);
            return Build.SUPPORTED_ABIS[0];
        }
        z(jSONObject, "defaultABI", Build.CPU_ABI);
        return Build.CPU_ABI;
    }

    private static void z(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            wp.z(e);
        }
    }

    private static JSONObject dl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("primaryCpuAbi", "0");
            jSONObject.put("processMode", "0");
            jSONObject.put("supportedABI0", "0");
            jSONObject.put("matchCpuAbi", "0");
            jSONObject.put("defaultABI0", "0");
            jSONObject.put("defaultABI", "0");
            jSONObject.put("autoError", "0");
            jSONObject.put("manualError", "0");
        } catch (JSONException e) {
            wp.z(e);
        }
        return jSONObject;
    }
}
