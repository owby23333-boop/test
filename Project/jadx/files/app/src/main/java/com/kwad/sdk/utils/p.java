package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class p {
    public static final File[] ayA;
    public static final String ayB;
    private static final char ayC;
    public static final BigInteger ayr;
    public static final BigInteger ays;
    public static final BigInteger ayt;
    public static final BigInteger ayu;
    public static final BigInteger ayv;
    public static final BigInteger ayw;
    public static final char ayx;
    public static final BigInteger ayy;
    public static final BigInteger ayz;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(1024L);
        ayr = bigIntegerValueOf;
        ays = bigIntegerValueOf.multiply(ayr);
        ayt = ayr.multiply(ays);
        ayu = ayr.multiply(ayt);
        ayv = ayr.multiply(ayu);
        ayw = ayr.multiply(ayv);
        ayy = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
        ayz = ayr.multiply(ayy);
        ayA = new File[0];
        ayB = Character.toString('.');
        ayC = File.separatorChar;
        ayx = CY() ? '/' : '\\';
    }

    private static boolean CY() {
        return ayC == '\\';
    }

    public static String E(@NonNull Context context, String str) {
        return "/data/data/" + context.getPackageName() + "/" + str + "/";
    }

    public static boolean G(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static boolean H(File file) {
        return file.exists();
    }

    private static FileInputStream I(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        if (file.canRead()) {
            return new FileInputStream(file);
        }
        throw new IOException("File '" + file + "' cannot be read");
    }

    private static FileOutputStream J(File file) {
        return a(file, false);
    }

    public static void K(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            throw new IOException("Could not find parent directory");
        }
        if (parentFile.mkdirs() || parentFile.isDirectory()) {
            file.createNewFile();
            return;
        }
        throw new IOException("Directory '" + parentFile + "' could not be created");
    }

    private static void L(File file) throws IOException {
        if (file.exists()) {
            if (!U(file)) {
                O(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    public static boolean M(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                O(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean N(File file) {
        return M(file);
    }

    public static void O(File file) throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        IOException e2 = null;
        for (File file2 : fileArrListFiles) {
            try {
                R(file2);
            } catch (IOException e3) {
                e2 = e3;
            }
        }
        if (e2 != null) {
            throw e2;
        }
    }

    public static byte[] P(File file) {
        return Q(file).getBytes();
    }

    public static String Q(File file) {
        return a(file, Charset.defaultCharset());
    }

    private static void R(File file) throws IOException {
        if (file.isDirectory()) {
            L(file);
            return;
        }
        boolean zExists = file.exists();
        if (file.delete()) {
            return;
        }
        if (zExists) {
            throw new IOException("Unable to delete file: " + file);
        }
        throw new FileNotFoundException("File does not exist: " + file);
    }

    public static void S(File file) throws IOException {
        if (file == null) {
            throw new IOException("Dir is null.");
        }
        if (!file.exists()) {
            file.mkdirs();
        } else {
            if (file.isDirectory()) {
                return;
            }
            if (!M(file)) {
                throw new IOException("Fail to delete existing file, file = " + file.getAbsolutePath());
            }
            file.mkdir();
        }
        if (file.exists() && file.isDirectory()) {
            return;
        }
        throw new IOException("Fail to create dir, dir = " + file.getAbsolutePath());
    }

    public static void T(File file) throws IOException {
        M(file);
        n(file);
        if (!file.exists()) {
            throw new IOException("Create file fail");
        }
    }

    private static boolean U(File file) {
        an.checkNotNull(file);
        if (CY()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    public static boolean V(File file) throws Throwable {
        File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
        c(file, file2);
        return M(file2);
    }

    public static FileOutputStream a(File file, boolean z2) throws IOException {
        K(file);
        return new FileOutputStream(file, z2);
    }

    public static String a(File file, Charset charset) throws Throwable {
        FileInputStream fileInputStreamI;
        try {
            fileInputStreamI = I(file);
        } catch (Throwable th) {
            th = th;
            fileInputStreamI = null;
        }
        try {
            String strA = com.kwad.sdk.crash.utils.h.a(fileInputStreamI, com.kwad.sdk.crash.utils.a.a(charset));
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStreamI);
            return strA;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStreamI);
            throw th;
        }
    }

    public static void a(Context context, String str, File file) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Asset path is empty.");
        }
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = context.getAssets().open(str);
            b(inputStreamOpen, file);
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
        }
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z2) throws Throwable {
        ArrayList arrayList;
        File[] fileArrListFiles;
        an.f(file, "Source");
        an.f(file2, "Destination");
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is not a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        if (!file2.getCanonicalPath().startsWith(file.getCanonicalPath()) || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(fileArrListFiles.length);
            for (File file3 : fileArrListFiles) {
                arrayList.add(new File(file2, file3.getName()).getCanonicalPath());
            }
        }
        a(file, file2, null, z2, arrayList);
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z2, List<String> list) throws Throwable {
        File[] fileArrListFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (fileArrListFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        if (file2.exists()) {
            if (!file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' exists but is not a directory");
            }
        } else if (!file2.mkdirs() && !file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' directory cannot be created");
        }
        if (!file2.canWrite()) {
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        }
        for (File file3 : fileArrListFiles) {
            File file4 = new File(file2, file3.getName());
            if (list == null || !list.contains(file3.getCanonicalPath())) {
                if (file3.isDirectory()) {
                    a(file3, file4, fileFilter, z2, list);
                } else {
                    c(file3, file4, z2);
                }
            }
        }
        if (z2) {
            file2.setLastModified(file.lastModified());
        }
    }

    public static void a(File file, String str, Charset charset, boolean z2) {
        FileOutputStream fileOutputStreamA;
        try {
            fileOutputStreamA = a(file, false);
        } catch (Throwable th) {
            th = th;
            fileOutputStreamA = null;
        }
        try {
            com.kwad.sdk.crash.utils.h.a(str, fileOutputStreamA, charset);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStreamA);
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStreamA);
            throw th;
        }
    }

    private static void b(File file, File file2, boolean z2) throws Throwable {
        an.f(file, "Source");
        an.f(file2, "Destination");
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IOException("Destination '" + parentFile + "' directory cannot be created");
        }
        if (!file2.exists() || file2.canWrite()) {
            c(file, file2, true);
            return;
        }
        throw new IOException("Destination '" + file2 + "' exists but is read-only");
    }

    private static void b(InputStream inputStream, File file) throws Throwable {
        FileOutputStream fileOutputStreamJ;
        try {
            fileOutputStreamJ = J(file);
            try {
                com.kwad.sdk.crash.utils.h.g(inputStream, fileOutputStreamJ);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStreamJ);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStreamJ);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStreamJ = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.Closeable, java.nio.channels.FileChannel, java.nio.channels.ReadableByteChannel] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable, java.nio.channels.FileChannel] */
    private static void c(File file, File file2, boolean z2) throws Throwable {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        ?? channel;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        ?? channel2 = 0;
        channel2 = 0;
        channel2 = 0;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
            fileOutputStream = null;
        }
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                channel = fileInputStream.getChannel();
            } catch (Throwable th2) {
                th = th2;
                channel = 0;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            channel = fileOutputStream;
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) channel2);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) channel);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            throw th;
        }
        try {
            channel2 = fileOutputStream.getChannel();
            long size = channel.size();
            long jTransferFrom = 0;
            while (jTransferFrom < size) {
                long j2 = size - jTransferFrom;
                jTransferFrom += channel2.transferFrom(channel, jTransferFrom, j2 > 31457280 ? 31457280L : j2);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) channel2);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) channel);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            if (file.length() == file2.length()) {
                if (z2) {
                    file2.setLastModified(file.lastModified());
                }
            } else {
                throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
            }
        } catch (Throwable th4) {
            th = th4;
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) channel2);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) channel);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            throw th;
        }
    }

    private static boolean c(File file, File file2) throws Throwable {
        if (file.renameTo(file2)) {
            return true;
        }
        try {
            d(file, file2);
            try {
                file.delete();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
            return true;
        } catch (Exception e3) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e3);
            return false;
        }
    }

    public static void d(File file, File file2) throws Throwable {
        b(file, file2, true);
    }

    private static void d(File file, File file2, boolean z2) throws Throwable {
        a(file, file2, (FileFilter) null, true);
    }

    public static boolean delete(String str) {
        return M(new File(str));
    }

    public static void deleteContents(@NonNull File file) {
        File[] fileArrListFiles;
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                file2.delete();
            }
        }
    }

    public static void e(File file, File file2) throws Throwable {
        d(file, file2, true);
    }

    public static BufferedInputStream ec(String str) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception unused) {
            fileInputStream = null;
        }
        if (fileInputStream == null) {
            return null;
        }
        return new BufferedInputStream(fileInputStream);
    }

    public static boolean ed(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static boolean ee(String str) {
        return !TextUtils.isEmpty(str) && G(new File(str));
    }

    private static int ef(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    private static int eg(String str) {
        int iLastIndexOf;
        if (str != null && ef(str) <= (iLastIndexOf = str.lastIndexOf(46))) {
            return iLastIndexOf;
        }
        return -1;
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int iEg = eg(str);
        return iEg == -1 ? "" : str.substring(iEg + 1);
    }

    private static void n(File file) throws IOException {
        if (!file.exists()) {
            com.kwad.sdk.crash.utils.b.closeQuietly(J(file));
        }
        if (file.setLastModified(System.currentTimeMillis())) {
            return;
        }
        throw new IOException("Unable to set the last modification time for " + file);
    }
}
