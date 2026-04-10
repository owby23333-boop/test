package com.bytedance.sdk.component.adexpress.z.g;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.adexpress.z.dl.z;
import com.bytedance.sdk.component.utils.gk;
import com.bytedance.sdk.component.utils.wp;
import com.kuaishou.weapon.p0.bi;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dl {
    public abstract File z();

    protected boolean z(Map<String, com.bytedance.sdk.component.adexpress.z.dl.z> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.adexpress.z.dl.z zVar = map.get(it.next());
            if (zVar != null && !z(zVar.getResources())) {
                return false;
            }
        }
        return true;
    }

    protected boolean z(List<z.C0124z> list) {
        if (list == null || list.size() <= 0 || z() == null) {
            return false;
        }
        for (z.C0124z c0124z : list) {
            String strG = com.bytedance.sdk.component.utils.gc.g(c0124z.z());
            if (TextUtils.isEmpty(strG)) {
                return false;
            }
            File file = new File(z(), strG);
            String strZ = com.bytedance.sdk.component.utils.gc.z(file);
            if (!file.exists() || !file.isFile() || c0124z.g() == null || !c0124z.g().equals(strZ)) {
                return false;
            }
        }
        return true;
    }

    protected boolean z(z.g gVar) {
        if (gVar == null || z() == null) {
            return false;
        }
        List<Pair<String, String>> listG = gVar.g();
        if (listG == null || listG.size() <= 0) {
            return true;
        }
        Iterator<Pair<String, String>> it = listG.iterator();
        while (it.hasNext()) {
            File file = new File(z(), (String) it.next().first);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
        }
        return true;
    }

    public List<z.C0124z> z(com.bytedance.sdk.component.adexpress.z.dl.z zVar, com.bytedance.sdk.component.adexpress.z.dl.z zVar2) {
        Map<String, com.bytedance.sdk.component.adexpress.z.dl.z> mapZ = zVar.z();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (mapZ.size() == 0) {
            if (zVar2 != null && zVar2.z().size() != 0) {
                Map<String, com.bytedance.sdk.component.adexpress.z.dl.z> mapZ2 = zVar2.z();
                Iterator<String> it = mapZ2.keySet().iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.adexpress.z.dl.z zVar3 = mapZ2.get(it.next());
                    if (zVar3 != null) {
                        arrayList.addAll(zVar3.getResources());
                    }
                }
            }
        } else if (zVar2 == null || zVar2.z().size() == 0) {
            if (mapZ.size() != 0) {
                Iterator<String> it2 = mapZ.keySet().iterator();
                while (it2.hasNext()) {
                    com.bytedance.sdk.component.adexpress.z.dl.z zVar4 = mapZ.get(it2.next());
                    if (zVar4 != null) {
                        arrayList2.addAll(zVar4.getResources());
                    }
                }
            }
        } else {
            Map<String, com.bytedance.sdk.component.adexpress.z.dl.z> mapZ3 = zVar2.z();
            for (String str : mapZ.keySet()) {
                com.bytedance.sdk.component.adexpress.z.dl.z zVar5 = mapZ.get(str);
                com.bytedance.sdk.component.adexpress.z.dl.z zVar6 = mapZ3.get(str);
                if (zVar6 == null && zVar5 != null) {
                    arrayList2.addAll(zVar5.getResources());
                } else if (zVar5 == null && zVar6 != null) {
                    arrayList.addAll(zVar6.getResources());
                } else if (zVar5 != null) {
                    for (z.C0124z c0124z : zVar5.getResources()) {
                        if (c0124z != null && !zVar6.getResources().contains(c0124z) && c0124z.g() != null && c0124z.z() != null) {
                            arrayList2.add(c0124z);
                        }
                    }
                    for (z.C0124z c0124z2 : zVar6.getResources()) {
                        if (c0124z2 != null && !zVar5.getResources().contains(c0124z2)) {
                            arrayList.add(c0124z2);
                        }
                    }
                }
            }
        }
        if (z(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    private boolean z(List<z.C0124z> list, List<z.C0124z> list2) {
        for (z.C0124z c0124z : list) {
            String strZ = c0124z.z();
            String strG = com.bytedance.sdk.component.utils.gc.g(strZ);
            File file = new File(z(), strG);
            File file2 = new File(file + bi.k);
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
            com.bytedance.sdk.component.fo.g.g gVarA = com.bytedance.sdk.component.adexpress.z.z.z.z().dl().a();
            gVarA.z(strZ);
            gVarA.z(z().getAbsolutePath(), strG);
            com.bytedance.sdk.component.fo.g gVarZ = gVarA.z();
            list2.add(c0124z);
            if (gVarZ == null || !gVarZ.gz() || gVarZ.e() == null || !gVarZ.e().exists()) {
                dl(list2);
                return false;
            }
        }
        return true;
    }

    public List<z.C0124z> g(com.bytedance.sdk.component.adexpress.z.dl.z zVar, com.bytedance.sdk.component.adexpress.z.dl.z zVar2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (zVar2 == null || zVar2.getResources().isEmpty()) {
            arrayList2.addAll(zVar.getResources());
        } else if (zVar.getResources().isEmpty()) {
            arrayList.addAll(zVar2.getResources());
        } else {
            for (z.C0124z c0124z : zVar.getResources()) {
                if (!zVar2.getResources().contains(c0124z) && c0124z != null && c0124z.z() != null && c0124z.g() != null) {
                    arrayList2.add(c0124z);
                }
            }
            for (z.C0124z c0124z2 : zVar2.getResources()) {
                if (!zVar.getResources().contains(c0124z2)) {
                    arrayList.add(c0124z2);
                }
            }
        }
        if (z(arrayList2, arrayList3)) {
            return arrayList;
        }
        return null;
    }

    public void g(List<z.C0124z> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<z.C0124z> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(z(), com.bytedance.sdk.component.utils.gc.g(it.next().z()));
            File file2 = new File(file + bi.k);
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public boolean z(String str) {
        File file = new File(z().getAbsoluteFile(), com.bytedance.sdk.component.utils.gc.g(str) + ".zip");
        com.bytedance.sdk.component.fo.g.g gVarA = com.bytedance.sdk.component.adexpress.z.z.z.z().dl().a();
        gVarA.z(str);
        gVarA.z(file.getParent(), file.getName());
        com.bytedance.sdk.component.fo.g gVarZ = gVarA.z();
        if (gVarZ.gz() && gVarZ.e() != null && gVarZ.e().exists()) {
            File fileE = gVarZ.e();
            try {
                gk.z(fileE.getAbsolutePath(), file.getParent());
                if (!fileE.exists()) {
                    return true;
                }
                fileE.delete();
                return true;
            } catch (Exception e) {
                wp.z(e);
            }
        }
        return false;
    }

    public void z(int i) {
        if (com.bytedance.sdk.component.adexpress.z.z.z.z().a() != null) {
            com.bytedance.sdk.component.adexpress.z.z.z.z().a().z(i);
        }
    }

    public void dl(List<z.C0124z> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<z.C0124z> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(z(), com.bytedance.sdk.component.utils.gc.g(it.next().z()));
            File file2 = new File(file + bi.k);
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public static void z(File file, com.bytedance.sdk.component.adexpress.z.dl.z zVar, String str) {
        FileOutputStream fileOutputStream;
        if (zVar == null) {
            return;
        }
        String strGz = zVar.gz();
        if (TextUtils.isEmpty(strGz)) {
            return;
        }
        File file2 = new File(file, str);
        File file3 = new File(file2 + bi.k);
        if (file3.exists()) {
            file3.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file3);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(strGz.getBytes("utf-8"));
            if (file2.exists()) {
                file2.delete();
            }
            file3.renameTo(file2);
            try {
                fileOutputStream.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            try {
                wp.dl("PlayComponentEngineCacheManager", "version save error3", th);
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (Throwable th3) {
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th3;
            }
        }
    }

    public static boolean dl(com.bytedance.sdk.component.adexpress.z.dl.z zVar, com.bytedance.sdk.component.adexpress.z.dl.z zVar2) {
        if (zVar != null) {
            try {
                if (!TextUtils.isEmpty(zVar.dl())) {
                    if (zVar2 == null) {
                        return false;
                    }
                    if (z(zVar.dl(), zVar2.dl())) {
                        return true;
                    }
                    Map<String, com.bytedance.sdk.component.adexpress.z.dl.z> mapZ = zVar.z();
                    Map<String, com.bytedance.sdk.component.adexpress.z.dl.z> mapZ2 = zVar2.z();
                    if (mapZ.isEmpty()) {
                        return !mapZ2.isEmpty();
                    }
                    if (mapZ2.isEmpty()) {
                        return false;
                    }
                    return z(mapZ, mapZ2);
                }
            } catch (Throwable th) {
                th.getMessage();
                return false;
            }
        }
        return true;
    }

    private static boolean z(Map<String, com.bytedance.sdk.component.adexpress.z.dl.z> map, Map<String, com.bytedance.sdk.component.adexpress.z.dl.z> map2) {
        if (map.size() != map2.size()) {
            return true;
        }
        for (String str : map2.keySet()) {
            com.bytedance.sdk.component.adexpress.z.dl.z zVar = map.get(str);
            if (zVar == null) {
                return true;
            }
            com.bytedance.sdk.component.adexpress.z.dl.z zVar2 = map2.get(str);
            if (zVar2 == null) {
                return false;
            }
            if (z(zVar.dl(), zVar2.dl())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean z(java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "\\."
            java.lang.String[] r7 = r7.split(r0)
            java.lang.String[] r6 = r6.split(r0)
            int r0 = r7.length
            int r1 = r6.length
            int r0 = java.lang.Math.min(r0, r1)
            r1 = 0
            r2 = r1
        L12:
            if (r2 >= r0) goto L42
            r3 = r7[r2]
            int r3 = r3.length()
            r4 = r6[r2]
            int r4 = r4.length()
            int r3 = r3 - r4
            r4 = 1
            if (r3 != 0) goto L3f
            r3 = r7[r2]
            r5 = r6[r2]
            int r3 = r3.compareTo(r5)
            if (r3 <= 0) goto L2f
            return r4
        L2f:
            if (r3 >= 0) goto L32
            return r1
        L32:
            int r3 = r0 + (-1)
            if (r2 != r3) goto L3c
            int r7 = r7.length
            int r6 = r6.length
            if (r7 <= r6) goto L3b
            return r4
        L3b:
            return r1
        L3c:
            int r2 = r2 + 1
            goto L12
        L3f:
            if (r3 <= 0) goto L42
            return r4
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.z.g.dl.z(java.lang.String, java.lang.String):boolean");
    }

    @Deprecated
    public static boolean z(com.bytedance.sdk.component.adexpress.z.dl.z zVar, String str) {
        if (zVar == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(zVar.dl())) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return z(zVar.dl(), str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void g(File file, com.bytedance.sdk.component.adexpress.z.dl.z zVar, String str) {
        if (zVar == null || file == null) {
            return;
        }
        try {
            new File(file, str).delete();
        } catch (Throwable unused) {
        }
        if (zVar.getResources() != null) {
            Iterator<z.C0124z> it = zVar.getResources().iterator();
            while (it.hasNext()) {
                try {
                    new File(file, com.bytedance.sdk.component.utils.gc.g(it.next().z())).delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }
}
