package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.funny.audio.core.utils.FileUtils;
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
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: loaded from: classes4.dex */
public final class w {
    public static final BigInteger aZe;
    public static final BigInteger aZf;
    public static final BigInteger aZg;
    public static final BigInteger aZh;
    public static final BigInteger aZi;
    public static final BigInteger aZj;
    public static final char aZk;
    public static final BigInteger aZl;
    public static final BigInteger aZm;
    public static final File[] aZn;
    public static final String aZo;
    private static final char aZp;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(1024L);
        aZe = bigIntegerValueOf;
        BigInteger bigIntegerMultiply = bigIntegerValueOf.multiply(bigIntegerValueOf);
        aZf = bigIntegerMultiply;
        BigInteger bigIntegerMultiply2 = bigIntegerValueOf.multiply(bigIntegerMultiply);
        aZg = bigIntegerMultiply2;
        BigInteger bigIntegerMultiply3 = bigIntegerValueOf.multiply(bigIntegerMultiply2);
        aZh = bigIntegerMultiply3;
        BigInteger bigIntegerMultiply4 = bigIntegerValueOf.multiply(bigIntegerMultiply3);
        aZi = bigIntegerMultiply4;
        aZj = bigIntegerValueOf.multiply(bigIntegerMultiply4);
        BigInteger bigIntegerMultiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(LockFreeTaskQueueCore.FROZEN_MASK));
        aZl = bigIntegerMultiply5;
        aZm = bigIntegerValueOf.multiply(bigIntegerMultiply5);
        aZn = new File[0];
        aZo = Character.toString('.');
        aZp = File.separatorChar;
        if (Qb()) {
            aZk = '/';
        } else {
            aZk = '\\';
        }
    }

    public static BufferedInputStream gP(String str) {
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

    public static boolean gQ(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static boolean gR(String str) {
        return !TextUtils.isEmpty(str) && O(new File(str));
    }

    public static boolean O(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static boolean P(File file) {
        return file.exists();
    }

    private static boolean e(File file, File file2) throws Throwable {
        if (file.renameTo(file2)) {
            return true;
        }
        try {
            f(file, file2);
            try {
                file.delete();
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
            return false;
        }
    }

    private static FileInputStream Q(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canRead()) {
                throw new IOException("File '" + file + "' cannot be read");
            }
            return new FileInputStream(file);
        }
        throw new FileNotFoundException("File '" + file + "' does not exist");
    }

    private static FileOutputStream R(File file) {
        return a(file, false);
    }

    public static FileOutputStream a(File file, boolean z) throws IOException {
        S(file);
        return new FileOutputStream(file, z);
    }

    public static void S(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            if (!parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
            file.createNewFile();
            return;
        }
        throw new IOException("Could not find parent directory");
    }

    private static void s(File file) throws IOException {
        if (!file.exists()) {
            com.kwad.sdk.crash.utils.b.closeQuietly(R(file));
        }
        if (!file.setLastModified(System.currentTimeMillis())) {
            throw new IOException("Unable to set the last modification time for " + file);
        }
    }

    public static void f(File file, File file2) throws Throwable {
        b(file, file2, true);
    }

    private static void b(File file, File file2, boolean z) throws Throwable {
        ax.g(file, "Source");
        ax.g(file2, "Destination");
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
        if (file2.exists() && !file2.canWrite()) {
            throw new IOException("Destination '" + file2 + "' exists but is read-only");
        }
        c(file, file2, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.Closeable, java.nio.channels.FileChannel, java.nio.channels.ReadableByteChannel] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable, java.nio.channels.FileChannel] */
    private static void c(File file, File file2, boolean z) throws Throwable {
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
                long j = size - jTransferFrom;
                jTransferFrom += channel2.transferFrom(channel, jTransferFrom, j > 31457280 ? 31457280L : j);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) channel2);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) channel);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            if (file.length() != file2.length()) {
                throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
            }
            if (z) {
                file2.setLastModified(file.lastModified());
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

    public static void g(File file, File file2) throws Throwable {
        d(file, file2, true);
    }

    private static void d(File file, File file2, boolean z) throws Throwable {
        a(file, file2, (FileFilter) null, true);
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z) throws Throwable {
        ArrayList arrayList;
        File[] fileArrListFiles;
        ax.g(file, "Source");
        ax.g(file2, "Destination");
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
        a(file, file2, null, z, arrayList);
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z, List<String> list) throws Throwable {
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
                    a(file3, file4, fileFilter, z, list);
                } else {
                    c(file3, file4, z);
                }
            }
        }
        if (z) {
            file2.setLastModified(file.lastModified());
        }
    }

    private static void b(InputStream inputStream, File file) throws Throwable {
        FileOutputStream fileOutputStreamR;
        try {
            fileOutputStreamR = R(file);
            try {
                com.kwad.sdk.crash.utils.h.e(inputStream, fileOutputStreamR);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStreamR);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStreamR);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStreamR = null;
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

    private static void M(File file) throws IOException {
        if (file.exists()) {
            if (!aa(file)) {
                N(file);
            }
            if (!file.delete()) {
                throw new IOException("Unable to delete directory " + file + FileUtils.FILE_EXTENSION_SEPARATOR);
            }
        }
    }

    public static boolean delete(String str) {
        return T(new File(str));
    }

    public static boolean T(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                N(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean U(File file) {
        return T(file);
    }

    public static void N(File file) throws IOException {
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
        IOException e = null;
        for (File file2 : fileArrListFiles) {
            try {
                X(file2);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public static String a(File file, Charset charset) throws Throwable {
        FileInputStream fileInputStreamQ;
        try {
            fileInputStreamQ = Q(file);
        } catch (Throwable th) {
            th = th;
            fileInputStreamQ = null;
        }
        try {
            String strA = com.kwad.sdk.crash.utils.h.a(fileInputStreamQ, com.kwad.sdk.crash.utils.a.a(charset));
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStreamQ);
            return strA;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStreamQ);
            throw th;
        }
    }

    public static byte[] V(File file) {
        return W(file).getBytes();
    }

    public static String W(File file) {
        return a(file, Charset.defaultCharset());
    }

    public static void a(File file, String str, Charset charset, boolean z) {
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

    private static void X(File file) throws IOException {
        if (file.isDirectory()) {
            M(file);
            return;
        }
        boolean zExists = file.exists();
        if (file.delete()) {
            return;
        }
        if (!zExists) {
            throw new FileNotFoundException("File does not exist: " + file);
        }
        throw new IOException("Unable to delete file: " + file);
    }

    public static void Y(File file) throws IOException {
        if (file == null) {
            throw new IOException("Dir is null.");
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            if (!T(file)) {
                throw new IOException("Fail to delete existing file, file = " + file.getAbsolutePath());
            }
            file.mkdir();
        } else {
            file.mkdirs();
        }
        if (!file.exists() || !file.isDirectory()) {
            throw new IOException("Fail to create dir, dir = " + file.getAbsolutePath());
        }
    }

    public static void Z(File file) throws IOException {
        T(file);
        s(file);
        if (!file.exists()) {
            throw new IOException("Create file fail");
        }
    }

    private static boolean aa(File file) {
        ax.checkNotNull(file);
        if (Qb()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    private static boolean Qb() {
        return aZp == '\\';
    }

    private static int gS(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    private static int gT(String str) {
        int iLastIndexOf;
        if (str != null && gS(str) <= (iLastIndexOf = str.lastIndexOf(46))) {
            return iLastIndexOf;
        }
        return -1;
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int iGT = gT(str);
        return iGT == -1 ? "" : str.substring(iGT + 1);
    }

    public static void deleteContents(File file) {
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

    public static boolean ab(File file) throws Throwable {
        File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
        e(file, file2);
        return T(file2);
    }

    public static String P(Context context, String str) {
        return "/data/data/" + context.getPackageName() + "/" + str + "/";
    }
}
