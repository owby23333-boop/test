package com.google.android.play.core.splitcompat;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes7.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f6940a = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f6941b;

    public d(c cVar) {
        this.f6941b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ZipFile zipFile, ZipEntry zipEntry, File file) throws IOException {
        byte[] bArr = new byte[4096];
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            while (true) {
                try {
                    int i = inputStream.read(bArr);
                    if (i <= 0) {
                        a((Throwable) null, fileOutputStream);
                        a((Throwable) null, inputStream);
                        return;
                    }
                    fileOutputStream.write(bArr, 0, i);
                } finally {
                }
            }
        } finally {
        }
    }

    public final Set<File> a() throws IOException {
        boolean z;
        Log.d("SplitCompat", "NativeLibraryExtractor: synchronizing native libraries");
        Set<o> setC = this.f6941b.c();
        for (String str : this.f6941b.d()) {
            Iterator<o> it = setC.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (it.next().a().equals(str)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                Log.i("SplitCompat", String.format("NativeLibraryExtractor: extracted split '%s' has no corresponding split; deleting", str));
                this.f6941b.d(str);
            }
        }
        HashSet hashSet = new HashSet();
        for (o oVar : setC) {
            HashSet hashSet2 = new HashSet();
            a(oVar, new g(this, hashSet2, oVar));
            for (File file : this.f6941b.e(oVar.a())) {
                if (!hashSet2.contains(file)) {
                    Log.i("SplitCompat", String.format("NativeLibraryExtractor: file '%s' found in split '%s' that is not in the split file '%s'; removing", file.getAbsolutePath(), oVar.a(), oVar.b().getAbsolutePath()));
                    this.f6941b.b(file);
                }
            }
            hashSet.addAll(hashSet2);
        }
        return hashSet;
    }

    public final Set<File> a(o oVar) throws IOException {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        HashSet hashSet = new HashSet();
        a(oVar, new e(this, oVar, hashSet, atomicBoolean));
        if (atomicBoolean.get()) {
            return hashSet;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<File> a(Set<k> set, o oVar, ZipFile zipFile) {
        HashSet hashSet = new HashSet();
        a(oVar, set, new h(hashSet, oVar, zipFile));
        return hashSet;
    }

    private static void a(o oVar, i iVar) throws IOException {
        ZipFile zipFile;
        Set<k> hashSet;
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(oVar.b());
        } catch (IOException e) {
            e = e;
        }
        try {
            String strA = oVar.a();
            HashMap map = new HashMap();
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                Matcher matcher = f6940a.matcher(zipEntryNextElement.getName());
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    Log.d("SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' for ABI '%s'", strA, strGroup2, strGroup));
                    Set hashSet2 = (Set) map.get(strGroup);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet();
                        map.put(strGroup, hashSet2);
                    }
                    hashSet2.add(new k(zipEntryNextElement, strGroup2));
                }
            }
            String[] strArr = Build.SUPPORTED_ABIS;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    hashSet = new HashSet<>();
                    break;
                }
                String str = strArr[i];
                if (map.containsKey(str)) {
                    Log.d("SplitCompat", String.format("NativeLibraryExtractor: there are native libraries for supported ABI %s; will use this ABI", str));
                    hashSet = (Set) map.get(str);
                    break;
                } else {
                    Log.d("SplitCompat", String.format("NativeLibraryExtractor: there are no native libraries for supported ABI %s", str));
                    i++;
                }
            }
            iVar.a(zipFile, hashSet);
            zipFile.close();
        } catch (IOException e2) {
            e = e2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException e3) {
                    com.google.a.a.a.a.a.a.a(e, e3);
                }
            }
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(o oVar, Set<k> set, j jVar) {
        for (k kVar : set) {
            File fileA = this.f6941b.a(oVar.a(), kVar.f6949a);
            jVar.a(kVar, fileA, fileA.exists() && fileA.length() == kVar.f6950b.getSize());
        }
    }

    private static /* synthetic */ void a(Throwable th, FileOutputStream fileOutputStream) throws IOException {
        if (th == null) {
            fileOutputStream.close();
            return;
        }
        try {
            fileOutputStream.close();
        } catch (Throwable th2) {
            com.google.a.a.a.a.a.a.a(th, th2);
        }
    }

    private static /* synthetic */ void a(Throwable th, InputStream inputStream) throws IOException {
        if (th == null) {
            inputStream.close();
            return;
        }
        try {
            inputStream.close();
        } catch (Throwable th2) {
            com.google.a.a.a.a.a.a.a(th, th2);
        }
    }
}
