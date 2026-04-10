package com.bytedance.sdk.openadsdk.core.un;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.openadsdk.core.iq.l;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class xl {
    private static volatile xl z;
    private final Set<String> dl = Collections.synchronizedSet(new HashSet());
    private String g;

    public static xl z() {
        if (z == null) {
            synchronized (xl.class) {
                if (z == null) {
                    z = new xl();
                }
            }
        }
        return z;
    }

    public void z(List<l.dl> list, l.z zVar) {
        g(list, zVar);
        Iterator<l.dl> it = list.iterator();
        while (it.hasNext()) {
            z(it.next(), zVar);
        }
    }

    private void z(final l.dl dlVar, final l.z zVar) {
        File[] fileArrListFiles;
        l.a aVarDl = dlVar.dl();
        final String strZ = dlVar.dl().z();
        if (this.dl.contains(strZ)) {
            return;
        }
        File file = new File(g());
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    String name = file2.getName();
                    String strSubstring = name.substring(0, name.indexOf("$"));
                    String strSubstring2 = name.substring(name.indexOf("$") + 1);
                    if (!strSubstring.equals(dlVar.z())) {
                        continue;
                    } else {
                        if (strSubstring2.equals(com.bytedance.sdk.component.utils.gc.g(aVarDl.g()))) {
                            return;
                        }
                        com.bytedance.sdk.component.utils.m.dl(file2);
                        if (zVar != null) {
                            zVar.g(g(dlVar.z()));
                        }
                    }
                }
            }
        }
        this.dl.add(strZ);
        File file3 = new File(g(), com.bytedance.sdk.component.utils.gc.g(strZ));
        com.bytedance.sdk.component.fo.g.g gVarA = com.bytedance.sdk.openadsdk.core.io.gc.z().g().a();
        gVarA.z(strZ);
        gVarA.z(file3.getParent(), file3.getName());
        gVarA.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.un.xl.1
            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, final com.bytedance.sdk.component.fo.g gVar) {
                xl.this.dl.remove(strZ);
                if (gVar.gz() && gVar.e() != null && gVar.e().exists()) {
                    com.bytedance.sdk.component.uy.e.z(new com.bytedance.sdk.component.uy.fo("downloadZip") { // from class: com.bytedance.sdk.openadsdk.core.un.xl.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                com.bytedance.sdk.component.utils.gk.z(gVar.e().getAbsolutePath(), xl.this.dl(dlVar.a()));
                                if (zVar != null) {
                                    zVar.z(dlVar);
                                }
                            } catch (Throwable th) {
                                com.bytedance.sdk.component.utils.wp.dl("WebCacheResourceManager", "unzip web resources failed：" + xl.this.dl(dlVar.a()), th);
                            }
                            try {
                                gVar.e().delete();
                            } catch (Throwable unused) {
                            }
                        }
                    }, 5);
                } else {
                    com.bytedance.sdk.component.utils.wp.a("WebCacheResourceManager", "download resources failed 1：" + strZ);
                }
            }

            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                xl.this.dl.remove(strZ);
                com.bytedance.sdk.component.utils.wp.a("WebCacheResourceManager", "download resources failed 2：" + strZ);
            }
        });
    }

    private void z(File file) {
        g(file);
        try {
            com.bytedance.sdk.openadsdk.core.uy.ls().wj().z(file);
        } catch (Throwable unused) {
        }
    }

    private void g(File file) {
        try {
            if (file.exists()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (file.setLastModified(jCurrentTimeMillis)) {
                    return;
                }
                file.renameTo(file);
                if (file.lastModified() < jCurrentTimeMillis) {
                    com.bytedance.sdk.component.utils.wp.g("WebCacheResourceManager", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dl(String str) {
        File file = new File(g(), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private String g() {
        if (TextUtils.isEmpty(this.g)) {
            try {
                File file = new File(com.bytedance.sdk.openadsdk.api.plugin.g.g(com.bytedance.sdk.openadsdk.core.zw.getContext()), "tt_web_resource");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.g = file.getAbsolutePath();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.a("WebCacheResourceManager", "init root path error: ".concat(String.valueOf(th)));
            }
        }
        return this.g;
    }

    public List<l.dl> z(String str) {
        if (!com.bytedance.sdk.openadsdk.core.iq.l.z || com.bytedance.sdk.openadsdk.core.iq.l.z().isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            String path = new URL(str).getPath();
            if (path != null && !path.isEmpty()) {
                for (l.dl dlVar : com.bytedance.sdk.openadsdk.core.iq.l.z()) {
                    if (path.contains(dlVar.g())) {
                        arrayList.add(dlVar);
                    }
                }
                return arrayList;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public WebResourceResponse z(WebResourceResponse webResourceResponse, String str, List<l.dl> list, Map<String, z> map) {
        z zVar;
        try {
            String path = new URL(str).getPath();
            if (map != null) {
                zVar = map.get(path);
                if (zVar == null) {
                    zVar = new z(path);
                    map.put(path, zVar);
                }
            } else {
                zVar = new z(path);
            }
            String strZ = "text/html";
            for (l.dl dlVar : list) {
                File file = new File(dl(dlVar.a()), path.substring(path.indexOf(dlVar.g())).replace(dlVar.g(), ""));
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    if (webResourceResponse == null) {
                        Iterator<l.g> it = dlVar.dl().dl().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            l.g next = it.next();
                            if (TextUtils.equals(next.g(), file.getName())) {
                                strZ = next.z();
                                break;
                            }
                        }
                        WebResourceResponse webResourceResponse2 = new WebResourceResponse(strZ, "utf-8", fileInputStream);
                        try {
                            zVar.z();
                            webResourceResponse = webResourceResponse2;
                        } catch (Exception unused) {
                            return webResourceResponse2;
                        }
                    }
                    webResourceResponse.setData(fileInputStream);
                    z(new File(dl(dlVar.a())));
                    return webResourceResponse;
                }
            }
            zVar.g();
            return webResourceResponse;
        } catch (Exception unused2) {
            return webResourceResponse;
        }
    }

    public void z(l.z zVar) {
        try {
            for (File file : new File(g()).listFiles()) {
                if (System.currentTimeMillis() - file.lastModified() >= 604800000) {
                    try {
                        com.bytedance.sdk.component.utils.m.dl(file);
                        String name = file.getName();
                        String strSubstring = name.substring(0, name.indexOf("$"));
                        if (zVar != null) {
                            zVar.g(g(strSubstring));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public void g(List<l.dl> list, l.z zVar) {
        File[] fileArrListFiles;
        boolean z2;
        File file = new File(g());
        if (!file.exists() || (fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.un.xl.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory();
            }
        })) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            String strSubstring = file2.getName().substring(0, file2.getName().indexOf("$"));
            Iterator<l.dl> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().z().equals(strSubstring)) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (!z2) {
                com.bytedance.sdk.component.utils.m.dl(file2);
                if (zVar != null) {
                    zVar.g(g(strSubstring));
                }
            }
        }
    }

    public static l.dl g(String str) {
        if (com.bytedance.sdk.openadsdk.core.iq.l.z().isEmpty()) {
            return null;
        }
        for (l.dl dlVar : com.bytedance.sdk.openadsdk.core.iq.l.z()) {
            if (dlVar.z().equals(str)) {
                return dlVar;
            }
        }
        return null;
    }

    public static class z {
        private final String z;
        private final AtomicInteger g = new AtomicInteger(0);
        private final AtomicInteger dl = new AtomicInteger(0);

        z(String str) {
            this.z = str;
        }

        void z() {
            this.g.incrementAndGet();
        }

        void g() {
            this.dl.incrementAndGet();
        }

        public String dl() {
            return this.z;
        }

        public int a() {
            return this.g.get();
        }

        public int gc() {
            return this.dl.get();
        }
    }
}
