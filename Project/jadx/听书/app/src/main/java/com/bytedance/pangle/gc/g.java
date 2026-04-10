package com.bytedance.pangle.gc;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.e;
import com.bytedance.pangle.util.fo;
import com.bytedance.pangle.util.gz;
import com.bytedance.sdk.openadsdk.api.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static Map<String, Integer> g;
    private static String z;

    static {
        HashMap map = new HashMap();
        g = map;
        map.put("arm64-v8a", 64);
        g.put("armeabi-v7a", 32);
        g.put("armeabi", 32);
        g.put("x86_64", 64);
        g.put("x86", 32);
        g.put("mips64", 64);
        g.put("mips", 32);
        z = dl();
    }

    public static void z(File file, File file2, String str, Map<String, List<ZipEntry>> map) throws Throwable {
        ZipFile zipFile = null;
        try {
            z(str, file2);
            ZipFile zipFile2 = new ZipFile(file);
            if (map == null) {
                try {
                    map = z(zipFile2);
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    throw th;
                }
            }
            boolean z2 = z(map, z);
            ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper copyNativeLib pre-verify-matchHostAbi[" + z2 + "], pkg=" + str);
            if (z2) {
                List<ZipEntry> listZ = z(map);
                if (listZ != null && !listZ.isEmpty()) {
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    Iterator<ZipEntry> it = listZ.iterator();
                    while (it.hasNext()) {
                        z(zipFile2, it.next(), file2);
                    }
                }
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copyNativeLib, supportedSoEntries empty, pkg=".concat(String.valueOf(str)));
                zipFile2.close();
                return;
            }
            zipFile2.close();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void z(String str, File file) throws IOException {
        Plugin plugin = Zeus.getPlugin(str);
        if (plugin.mSharedHostSos.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(plugin.mSharedHostSos);
        String str2 = Zeus.getAppApplication().getApplicationInfo().nativeLibraryDir;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String[] strArrSplit = str2.split(File.pathSeparator);
        for (String str3 : plugin.mSharedHostSos) {
            for (String str4 : strArrSplit) {
                File file2 = new File(str4, str3);
                if (arrayList.contains(str3) && file2.exists()) {
                    gz.z(file2.getAbsolutePath(), new File(file, str3).getAbsolutePath());
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copySoFromHost, hostSoPath=" + file2.getAbsolutePath());
                    arrayList.remove(str3);
                }
            }
        }
    }

    private static Map<String, List<ZipEntry>> z(ZipFile zipFile) {
        String[] strArrSplit;
        HashMap map = new HashMap();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        Pattern patternCompile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (!zipEntryNextElement.isDirectory() && !zipEntryNextElement.getName().contains("../") && zipEntryNextElement.getName().startsWith("lib/") && patternCompile.matcher(zipEntryNextElement.getName()).matches() && (strArrSplit = zipEntryNextElement.getName().split(File.separator)) != null && strArrSplit.length >= 2) {
                String str = strArrSplit[strArrSplit.length - 2];
                if (g.containsKey(str)) {
                    if (map.get(str) == null) {
                        map.put(str, new LinkedList());
                    }
                    ((List) map.get(str)).add(zipEntryNextElement);
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper getAllSoZipEntries, zipFile=" + zipFile.getName() + ", soEntries=" + map.toString());
        return map;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static List<ZipEntry> z(Map<String, List<ZipEntry>> map) {
        LinkedList linkedList;
        HashSet hashSet;
        if (map == null || map.isEmpty()) {
            return null;
        }
        linkedList = new LinkedList();
        hashSet = new HashSet();
        String str = z;
        str.hashCode();
        switch (str) {
            case "mips64":
                z(map, "mips64", linkedList, hashSet);
                return linkedList;
            case "x86_64":
                z(map, "x86_64", linkedList, hashSet);
                return linkedList;
            case "armeabi":
                z(map, "armeabi", linkedList, hashSet);
                z(map, "armeabi-v7a", linkedList, hashSet);
                return linkedList;
            case "x86":
                z(map, "x86", linkedList, hashSet);
                return linkedList;
            case "mips":
                z(map, "mips", linkedList, hashSet);
                return linkedList;
            case "armeabi-v7a":
                z(map, "armeabi-v7a", linkedList, hashSet);
                z(map, "armeabi", linkedList, hashSet);
                return linkedList;
            case "arm64-v8a":
                z(map, "arm64-v8a", linkedList, hashSet);
                return linkedList;
            default:
                return linkedList;
        }
    }

    private static void z(Map<String, List<ZipEntry>> map, String str, List<ZipEntry> list, Set<String> set) {
        List<ZipEntry> list2 = map.get(str);
        if (list2 == null || list2.size() == 0) {
            return;
        }
        for (ZipEntry zipEntry : list2) {
            String strSubstring = zipEntry.getName().substring(zipEntry.getName().lastIndexOf(File.separator) + 1);
            if (!set.contains(strSubstring)) {
                list.add(zipEntry);
                set.add(strSubstring);
            }
        }
    }

    private static void z(ZipFile zipFile, ZipEntry zipEntry, File file) throws IOException {
        String name = zipEntry.getName();
        if (name.contains("..")) {
            return;
        }
        File file2 = new File(file, name.substring(name.lastIndexOf(File.separator) + 1));
        int i = 0;
        boolean z2 = false;
        do {
            if (file2.exists()) {
                file2.delete();
            }
            try {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copySoZipEntry, soZipEntry=" + zipEntry + ", targetSoFile=" + file2);
                e.z(zipFile.getInputStream(zipEntry), new FileOutputStream(file2));
                z2 = true;
            } catch (IOException e) {
                if (i >= 3) {
                    throw e;
                }
                i++;
            }
        } while (!z2);
    }

    public static String z() {
        String str = z;
        if (str != null) {
            return str;
        }
        String strDl = dl();
        z = strDl;
        return strDl;
    }

    public static int g() {
        return g.get(z()).intValue();
    }

    private static String dl() {
        JSONObject jSONObjectA = a();
        String strZ = z(jSONObjectA);
        return strZ == null ? g(jSONObjectA) : strZ;
    }

    private static String z(JSONObject jSONObject) {
        if (!fo.z()) {
            return null;
        }
        try {
            String str = (String) FieldUtils.readField(Zeus.getAppApplication().getApplicationInfo(), "primaryCpuAbi");
            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=".concat(String.valueOf(str)));
            z(jSONObject, "primaryCpuAbi", str);
            if (str == null) {
                return null;
            }
            int i = 0;
            if (fo.uy()) {
                try {
                    i = Process.is64Bit() ? 64 : 32;
                    ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode=".concat(String.valueOf(i)));
                } catch (Exception unused) {
                    ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode exception default=".concat(String.valueOf(i)));
                }
            } else {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode default=0");
            }
            z(jSONObject, "processMode", String.valueOf(i));
            if (i != 0) {
                if (g.get(str).intValue() != i) {
                    return null;
                }
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto2, sHostAbi=".concat(String.valueOf(str)));
                return str;
            }
            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto1, sHostAbi=".concat(String.valueOf(str)));
            return str;
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto failed!", e);
            z(jSONObject, "autoError", "1");
            return null;
        }
    }

    private static String g(JSONObject jSONObject) {
        HashSet hashSet;
        String[] strArr;
        try {
            ZipFile zipFile = new ZipFile(new File(Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0).applicationInfo.sourceDir));
            hashSet = new HashSet(z(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException unused) {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");
            }
            strArr = fo.z() ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual failed!", th);
            z(jSONObject, "manualError", "1");
        }
        if (hashSet.isEmpty()) {
            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + strArr[0]);
            z(jSONObject, "supportedABI0", strArr[0]);
            return strArr[0];
        }
        for (String str : strArr) {
            if (hashSet.contains(str)) {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, match cpuAbi=".concat(String.valueOf(str)));
                z(jSONObject, "matchCpuAbi", str);
                return str;
            }
        }
        if (fo.z()) {
            z(jSONObject, "defaultABI0", Build.SUPPORTED_ABIS[0]);
            return Build.SUPPORTED_ABIS[0];
        }
        z(jSONObject, "defaultABI", Build.CPU_ABI);
        return Build.CPU_ABI;
    }

    public static com.bytedance.pangle.util.gc<Boolean, Map<String, List<ZipEntry>>> z(File file) throws Throwable {
        boolean z2;
        HashMap map = new HashMap();
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    map.putAll(z(zipFile2));
                    if (map.isEmpty()) {
                        ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [true] soEntries empty, ".concat(String.valueOf(file)));
                        z2 = true;
                    } else {
                        boolean z3 = z(map, z);
                        if (z3) {
                            ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + z3 + "], " + file);
                        } else {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + z3 + "], " + file);
                        }
                        z2 = z3;
                    }
                    com.bytedance.pangle.util.gc<Boolean, Map<String, List<ZipEntry>>> gcVar = new com.bytedance.pangle.util.gc<>(Boolean.valueOf(z2), map);
                    try {
                        zipFile2.close();
                    } catch (IOException unused) {
                        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                    }
                    return gcVar;
                } catch (IOException e) {
                    e = e;
                    zipFile = zipFile2;
                    ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, get sourceApk ZipFile failed!", e);
                    com.bytedance.pangle.util.gc<Boolean, Map<String, List<ZipEntry>>> gcVar2 = new com.bytedance.pangle.util.gc<>(Boolean.FALSE, map);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused2) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                        }
                    }
                    return gcVar2;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused3) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                        }
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean z(Map<String, List<ZipEntry>> map, String str) {
        if (TextUtils.equals(str, "armeabi") || TextUtils.equals(str, "armeabi-v7a")) {
            return map.containsKey("armeabi") || map.containsKey("armeabi-v7a");
        }
        return map.containsKey(str);
    }

    public static boolean g(File file) throws Throwable {
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                    Pattern patternCompile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
                    while (enumerationEntries.hasMoreElements()) {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        if (!zipEntryNextElement.isDirectory() && patternCompile.matcher(zipEntryNextElement.getName()).matches()) {
                            try {
                                zipFile2.close();
                                return true;
                            } catch (IOException unused) {
                                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                                return true;
                            }
                        }
                    }
                    try {
                        zipFile2.close();
                    } catch (IOException unused2) {
                        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                    }
                    return false;
                } catch (IOException e) {
                    e = e;
                    zipFile = zipFile2;
                    ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, get sourceApk ZipFile failed!", e);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused3) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused4) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                        }
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void z(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            m.z(e);
        }
    }

    private static JSONObject a() {
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
            m.z(e);
        }
        return jSONObject;
    }
}
