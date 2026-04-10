package com.bytedance.sdk.openadsdk.core.za.bf;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.sdk.component.utils.wu;
import com.bytedance.sdk.openadsdk.core.lc;
import com.ryg.utils.DLConstants;
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

/* JADX INFO: loaded from: classes10.dex */
public class bf {
    private static String bf;
    private static Map<String, Integer> d = new HashMap();
    private static String e;

    static {
        if (d.e()) {
            bf = Build.SUPPORTED_ABIS[0];
        } else {
            bf = Build.CPU_ABI;
        }
        d.put("arm64-v8a", 64);
        d.put("armeabi-v7a", 32);
        d.put(DLConstants.CPU_ARMEABI, 32);
        d.put("x86_64", 64);
        d.put(DLConstants.CPU_X86, 32);
        d.put("mips64", 64);
        d.put(DLConstants.CPU_MIPS, 32);
        e = bf();
    }

    private static String bf() {
        JSONObject jSONObjectD = d();
        String strE = e(jSONObjectD);
        return strE == null ? bf(jSONObjectD) : strE;
    }

    private static JSONObject d() {
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
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private static Map<String, List<ZipEntry>> e(ZipFile zipFile) {
        String[] strArrSplit;
        HashMap map = new HashMap();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        Pattern patternCompile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (!zipEntryNextElement.isDirectory() && patternCompile.matcher(zipEntryNextElement.getName()).matches() && (strArrSplit = zipEntryNextElement.getName().split(File.separator)) != null && strArrSplit.length >= 2) {
                String str = strArrSplit[strArrSplit.length - 2];
                if (d.containsKey(str)) {
                    if (map.get(str) == null) {
                        map.put(str, new LinkedList());
                    }
                    ((List) map.get(str)).add(zipEntryNextElement);
                }
            }
        }
        wu.d("NativeLibHelper", "NativeLibHelper getAllSoZipEntries, zipFile=" + zipFile.getName() + ", soEntries=" + map.toString());
        return map;
    }

    private static String bf(JSONObject jSONObject) {
        HashSet hashSet;
        String[] strArr;
        try {
            Context context = lc.getContext();
            ZipFile zipFile = new ZipFile(new File(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir));
            hashSet = new HashSet(e(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException unused) {
                wu.tg("NativeLibHelper", "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");
            }
            strArr = d.e() ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        } catch (Throwable th) {
            wu.d("NativeLibHelper", "NativeLibHelper inferHostAbiManual failed!", th);
            e(jSONObject, "manualError", "1");
        }
        if (hashSet.isEmpty()) {
            wu.tg("NativeLibHelper", "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + strArr[0]);
            e(jSONObject, "supportedABI0", strArr[0]);
            return strArr[0];
        }
        for (String str : strArr) {
            if (hashSet.contains(str)) {
                wu.tg("NativeLibHelper", "NativeLibHelper inferHostAbiManual, match cpuAbi=" + str);
                e(jSONObject, "matchCpuAbi", str);
                return str;
            }
        }
        if (d.e()) {
            String[] strArr2 = Build.SUPPORTED_ABIS;
            e(jSONObject, "defaultABI0", strArr2[0]);
            return strArr2[0];
        }
        String str2 = Build.CPU_ABI;
        e(jSONObject, "defaultABI", str2);
        return str2;
    }

    public static String e() {
        String str = e;
        if (str != null) {
            return str;
        }
        String strBf = bf();
        e = strBf;
        return strBf;
    }

    private static String e(JSONObject jSONObject) {
        if (!d.e()) {
            return null;
        }
        try {
            String str = (String) e.e(lc.getContext().getApplicationInfo(), "primaryCpuAbi");
            wu.tg("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=" + str);
            e(jSONObject, "primaryCpuAbi", str);
            if (str == null) {
                return null;
            }
            int i = 0;
            if (d.bf()) {
                try {
                    i = Process.is64Bit() ? 64 : 32;
                    wu.tg("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode=" + i);
                } catch (Exception unused) {
                    wu.tg("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode exception default=" + i);
                }
            } else {
                wu.tg("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode default=0");
            }
            e(jSONObject, "processMode", "" + i);
            if (i != 0) {
                if (d.get(str).intValue() != i) {
                    return null;
                }
                wu.tg("NativeLibHelper", "NativeLibHelper inferHostAbiAuto2, sHostAbi=" + str);
                return str;
            }
            wu.tg("NativeLibHelper", "NativeLibHelper inferHostAbiAuto1, sHostAbi=" + str);
            return str;
        } catch (Exception e2) {
            wu.d("NativeLibHelper", "NativeLibHelper inferHostAbiAuto failed!", e2);
            e(jSONObject, "autoError", "1");
            return null;
        }
    }

    private static void e(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
