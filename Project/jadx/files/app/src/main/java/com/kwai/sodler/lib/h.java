package com.kwai.sodler.lib;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.p;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class h extends g {
    public h(String str) {
        super(str);
    }

    private Set<File> a(Context context, File file, File file2) throws IOException {
        String[] list;
        new StringBuilder("Install plugin so libs, destDir = ").append(file2);
        HashSet hashSet = new HashSet();
        if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
            for (String str : list) {
                hashSet.add(new File(file2.getAbsolutePath() + File.separator + str));
            }
            return hashSet;
        }
        File file3 = new File(file2.getParentFile(), this.aIq.JH());
        p.S(file3);
        for (String str2 : com.kwai.sodler.lib.d.c.h(file, file3)) {
            new StringBuilder("extractSoLib, soName = ").append(str2);
            File fileA = com.kwai.sodler.lib.d.c.a(file3, str2, file2);
            if (fileA != null) {
                hashSet.add(fileA);
            }
        }
        p.M(file3);
        return hashSet;
    }

    private File ae(File file) throws IOException {
        File file2 = new File(file.getParentFile(), this.aIq.JG());
        p.S(file2);
        return file2;
    }

    private void e(Set<File> set) throws Throwable {
        com.kwai.sodler.lib.c.b bVar = this.aIW;
        if (bVar == null || bVar.aJE.size() <= 0 || set == null) {
            return;
        }
        HashMap<String, String> map = this.aIW.aJE;
        for (File file : set) {
            String strW = ac.W(file);
            String str = map.get(file.getName());
            if (str != null && !TextUtils.equals(strW, str)) {
                f(set);
                throw new PluginError.LoadError(new Exception(file.getName() + " Md5 check error,find " + strW + ",except " + str), 4008);
            }
        }
    }

    private static void f(Set<File> set) {
        Iterator<File> it = set.iterator();
        while (it.hasNext()) {
            p.M(it.next());
        }
    }

    @Override // com.kwai.sodler.lib.g, com.kwai.sodler.lib.a.a
    public void at(Context context, String str) {
        ClassLoader classLoader;
        super.at(context, str);
        File file = new File(str);
        try {
            this.aIQ = ae(file);
            try {
                try {
                    e(a(context, file, this.aIQ));
                    com.kwai.sodler.lib.c.b bVar = this.aIW;
                    if (bVar == null || (classLoader = bVar.aJH) == null) {
                        classLoader = getClass().getClassLoader();
                    }
                    synchronized (Runtime.getRuntime()) {
                        try {
                            com.kwai.sodler.lib.ext.d.c(classLoader, this.aIQ);
                        } finally {
                            PluginError.LoadError loadError = new PluginError.LoadError(th, 4004);
                        }
                    }
                } catch (PluginError.LoadError e2) {
                    p.M(file);
                    throw e2;
                }
            } catch (IOException th) {
                throw new PluginError.LoadError(th, i);
            }
        } catch (IOException e3) {
            throw new PluginError.LoadError(e3, 4003);
        }
    }
}
