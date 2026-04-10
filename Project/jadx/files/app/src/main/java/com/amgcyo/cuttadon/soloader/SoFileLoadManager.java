package com.amgcyo.cuttadon.soloader;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.amgcyo.cuttadon.api.entity.soloader.AbiBean;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.r;
import com.amgcyo.cuttadon.utils.otherutils.z;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SoFileLoadManager {

    public enum AbiType {
        ARMEABI_V7A("armeabi-v7a"),
        ARM64_V8A("arm64-v8a"),
        ARMEABI("armeabi"),
        X86("x86"),
        X86_64("x86_64"),
        MIPS("mips"),
        MIPS64("mips64");


        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private String f4359s;

        AbiType(String str) {
            this.f4359s = str;
        }

        public static AbiType a(String str) {
            if (TextUtils.isEmpty(str)) {
                return ARMEABI_V7A;
            }
            String str2 = "Build.CPU_ABI：" + str;
            for (AbiType abiType : values()) {
                String str3 = "枚举:" + abiType.f();
                if (abiType.f().equals(str.toLowerCase())) {
                    return abiType;
                }
            }
            return ARMEABI_V7A;
        }

        public String f() {
            return this.f4359s;
        }
    }

    public static void a(Context context) {
        try {
            c.a(context.getApplicationContext().getClassLoader(), c());
        } catch (Throwable th) {
            String str = "loadSoFile error " + th.getMessage();
        }
    }

    public static AbiType b() {
        AbiType abiTypeA = AbiType.a(Build.CPU_ABI);
        if (abiTypeA != null) {
            String str = "abi:" + abiTypeA.f();
        }
        if (AbiType.ARM64_V8A == abiTypeA) {
            return abiTypeA;
        }
        AbiType abiType = AbiType.ARMEABI_V7A;
        String str2 = "64位之外的，统一使用 " + abiType.f();
        return abiType;
    }

    public static File c() {
        return MkApplication.getAppContext().getDir("libs", 0);
    }

    public static boolean a() {
        List listB;
        final String strF = b().f();
        File fileC = c();
        String str = "最终的abiName:" + strF + " 路径： " + fileC.getAbsolutePath();
        File[] fileArrListFiles = fileC.listFiles(new FileFilter() { // from class: com.amgcyo.cuttadon.soloader.a
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return (strF + ".json").equalsIgnoreCase(file.getName());
            }
        });
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            listB = null;
        } else {
            String str2 = "只过滤json文件后的大小：" + fileArrListFiles.length;
            listB = null;
            for (File file : fileArrListFiles) {
                String str3 = "fileName: " + file.getName();
                String strM = z.m(file.getAbsolutePath());
                String str4 = "JSON:" + strM;
                if (!TextUtils.isEmpty(strM)) {
                    listB = r.b(strM, AbiBean.class);
                    if (g.b((List<?>) listB)) {
                        break;
                    }
                }
            }
        }
        File[] fileArrListFiles2 = fileC.listFiles(new FileFilter() { // from class: com.amgcyo.cuttadon.soloader.b
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return SoFileLoadManager.a(file2);
            }
        });
        if (fileArrListFiles2 == null || fileArrListFiles2.length <= 0 || listB == null || listB.size() <= 0) {
            return false;
        }
        String str5 = " 大小：" + fileArrListFiles2.length;
        ArrayList arrayList = new ArrayList();
        for (File file2 : fileArrListFiles2) {
            String name = file2.getName();
            String strB = com.open.hule.library.c.b.b(file2);
            String str6 = name + "  " + strB;
            arrayList.add(new AbiBean(name, strB));
        }
        boolean zA = a(listB, arrayList);
        String str7 = "listEqual: " + zA;
        return zA;
    }

    static /* synthetic */ boolean a(File file) {
        return (file.getName().endsWith(".json") || file.getName().endsWith(".jpg")) ? false : true;
    }

    public static <E> boolean a(List<E> list, List<E> list2) {
        if (g.a((List<?>) list) && g.a((List<?>) list2)) {
            return true;
        }
        if (list.size() != list2.size()) {
            return false;
        }
        return list.containsAll(list2);
    }
}
