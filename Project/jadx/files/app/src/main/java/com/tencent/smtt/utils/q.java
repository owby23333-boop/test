package com.tencent.smtt.utils;

import android.os.Build;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class q {
    private b a = null;
    private b b = null;

    class a {
        private String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f19295c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f19296d;

        a(String str, long j2, long j3) {
            this.b = str;
            this.f19295c = j2;
            this.f19296d = j3;
        }

        long a() {
            return this.f19295c;
        }

        long b() {
            return this.f19296d;
        }
    }

    class b {
        private Map<String, a> b = new HashMap();

        b(File file) {
            this.b.clear();
            a(file);
        }

        private void a(File file) {
            if (!file.isDirectory()) {
                if (file.isFile()) {
                    a(file.getName(), file.length(), file.lastModified());
                    return;
                }
                return;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null || Build.VERSION.SDK_INT < 26) {
                for (File file2 : fileArrListFiles) {
                    a(file2);
                }
            }
        }

        private void a(String str, long j2, long j3) {
            if (str == null || str.length() <= 0 || j2 <= 0 || j3 <= 0) {
                return;
            }
            a aVar = q.this.new a(str, j2, j3);
            if (this.b.containsKey(str)) {
                return;
            }
            this.b.put(str, aVar);
        }

        Map<String, a> a() {
            return this.b;
        }
    }

    private boolean a(b bVar, b bVar2) {
        if (bVar == null || bVar.a() == null || bVar2 == null || bVar2.a() == null) {
            return false;
        }
        Map<String, a> mapA = bVar.a();
        Map<String, a> mapA2 = bVar2.a();
        for (Map.Entry<String, a> entry : mapA.entrySet()) {
            String key = entry.getKey();
            a value = entry.getValue();
            if (mapA2.containsKey(key)) {
                a aVar = mapA2.get(key);
                if (value.a() != aVar.a() || value.b() != aVar.b()) {
                }
            }
            return false;
        }
        return true;
    }

    public void a(File file) {
        this.a = new b(file);
    }

    public boolean a() {
        b bVar = this.b;
        return bVar != null && this.a != null && bVar.a().size() == this.a.a().size() && a(this.a, this.b);
    }

    public void b(File file) {
        this.b = new b(file);
    }
}
