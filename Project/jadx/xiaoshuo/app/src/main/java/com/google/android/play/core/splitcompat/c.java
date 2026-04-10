package com.google.android.play.core.splitcompat;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f6936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f6937b;

    public c(File file, long j) {
        String absolutePath = file.getAbsolutePath();
        StringBuilder sb = new StringBuilder(String.valueOf(absolutePath).length() + 82);
        sb.append("FileStorage: initializing (files directory = ");
        sb.append(absolutePath);
        sb.append(", versionCode = ");
        sb.append(j);
        sb.append(")");
        Log.d("SplitCompat", sb.toString());
        this.f6936a = file;
        this.f6937b = j;
    }

    private static File c(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                return file;
            }
            throw new IllegalArgumentException("File input must be directory when it exists.");
        }
        if (file.mkdirs()) {
            return file;
        }
        String strValueOf = String.valueOf(file.getAbsolutePath());
        throw new IOException(strValueOf.length() != 0 ? "Unable to create directory: ".concat(strValueOf) : new String("Unable to create directory: "));
    }

    private final File e() {
        return c(new File(f(), "verified-splits"));
    }

    private final File f() {
        return c(new File(g(), Long.toString(this.f6937b)));
    }

    private final File g() {
        return c(new File(this.f6936a, "splitcompat"));
    }

    private final File h() {
        return c(new File(f(), "native-libraries"));
    }

    public final File a(File file) {
        return new File(e(), file.getName());
    }

    public final File b() {
        return c(new File(f(), "unverified-splits"));
    }

    public final List<String> d() {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = h().listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file.isDirectory()) {
                    arrayList.add(file.getName());
                }
            }
        }
        return arrayList;
    }

    private static void d(File file) throws IOException {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                d(file2);
            }
        }
        if (file.exists() && !file.delete()) {
            throw new IOException(String.format("Failed to delete '%s'", file.getAbsolutePath()));
        }
    }

    private final File g(String str) {
        return c(new File(h(), str));
    }

    private static String h(String str) {
        String strValueOf = String.valueOf(str);
        return ".apk".length() != 0 ? strValueOf.concat(".apk") : new String(strValueOf);
    }

    public final File a(String str) {
        return new File(b(), h(str));
    }

    public final File b(String str) {
        return new File(e(), h(str));
    }

    public final File c(String str) {
        return c(new File(c(new File(f(), "dex")), str));
    }

    public final Set<File> e(String str) {
        HashSet hashSet = new HashSet();
        File[] fileArrListFiles = g(str).listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file.isFile()) {
                    hashSet.add(file);
                }
            }
        }
        return hashSet;
    }

    public final void f(String str) throws IOException {
        d(b(str));
    }

    public final File a(String str, String str2) {
        return new File(g(str), str2);
    }

    public final void b(File file) throws IOException {
        com.google.android.play.core.splitcompat.c.b.a(file.getParentFile().getParentFile().equals(h()), "File to remove is not a native library");
        d(file);
    }

    public final Set<o> c() {
        File fileE = e();
        HashSet hashSet = new HashSet();
        File[] fileArrListFiles = fileE.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file.isFile() && file.getName().endsWith(".apk")) {
                    hashSet.add(new o(file, file.getName().substring(0, r7.length() - 4)));
                }
            }
        }
        return hashSet;
    }

    public final void d(String str) throws IOException {
        d(g(str));
    }

    public final void a() throws IOException {
        File fileG = g();
        String[] list = fileG.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(Long.toString(this.f6937b))) {
                    File file = new File(fileG, str);
                    String strValueOf = String.valueOf(file);
                    long j = this.f6937b;
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 118);
                    sb.append("FileStorage: removing directory for different version code (directory = ");
                    sb.append(strValueOf);
                    sb.append(", current version code = ");
                    sb.append(j);
                    sb.append(")");
                    Log.d("SplitCompat", sb.toString());
                    d(file);
                }
            }
        }
    }
}
