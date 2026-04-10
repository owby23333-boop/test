package com.bytedance.pangle.util;

import android.content.Context;
import android.os.Build;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static String a;
    static String b;

    public static void a(String str) {
        a(new File(str));
    }

    private static void b(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream == null || outputStream == null) {
            return;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        try {
            byte[] bArr = new byte[1048576];
            while (true) {
                int i2 = bufferedInputStream.read(bArr);
                if (i2 == -1) {
                    bufferedOutputStream.flush();
                    return;
                }
                bufferedOutputStream.write(bArr, 0, i2);
            }
        } finally {
            bufferedInputStream.close();
            bufferedOutputStream.close();
        }
    }

    public static void a(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                Files.walkFileTree(Paths.get(file.getAbsolutePath(), new String[0]), new SimpleFileVisitor<Path>() { // from class: com.bytedance.pangle.util.h.1
                    AnonymousClass1() {
                    }

                    private static FileVisitResult a(Path path) {
                        if (path != null) {
                            try {
                                Files.deleteIfExists(path);
                            } catch (IOException unused) {
                            }
                        }
                        return FileVisitResult.CONTINUE;
                    }

                    private static FileVisitResult b(Path path) {
                        if (path != null) {
                            try {
                                Files.deleteIfExists(path);
                            } catch (IOException unused) {
                            }
                        }
                        return FileVisitResult.CONTINUE;
                    }

                    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                    public final /* synthetic */ FileVisitResult postVisitDirectory(Object obj, IOException iOException) {
                        return b((Path) obj);
                    }

                    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                    public final /* bridge */ /* synthetic */ FileVisitResult preVisitDirectory(Object obj, BasicFileAttributes basicFileAttributes) {
                        return FileVisitResult.CONTINUE;
                    }

                    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                    public final /* synthetic */ FileVisitResult visitFile(Object obj, BasicFileAttributes basicFileAttributes) {
                        return a((Path) obj);
                    }

                    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                    public final /* bridge */ /* synthetic */ FileVisitResult visitFileFailed(Object obj, IOException iOException) {
                        return FileVisitResult.CONTINUE;
                    }
                });
                return;
            } catch (IOException unused) {
                return;
            }
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                a(file2);
            }
        }
        file.delete();
    }

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        b(inputStream, outputStream);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String a(Context context) {
        File parentFile;
        if (b == null && (parentFile = context.getCacheDir().getParentFile()) != null) {
            try {
                b = parentFile.getCanonicalPath();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return b;
    }

    public static void a(String str, String str2) throws Exception {
        File file = new File(str);
        File file2 = new File(str2);
        if (file.exists()) {
            if (file.isDirectory()) {
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file2.isDirectory()) {
                    File[] fileArrListFiles = file.listFiles();
                    if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                        return;
                    }
                    for (File file3 : fileArrListFiles) {
                        String str3 = file2 + File.separator + file3.getName();
                        if (file3.isDirectory()) {
                            a(file3.getAbsolutePath(), str3);
                        } else if (!new File(str3).exists()) {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file3));
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int i2 = bufferedInputStream.read(bArr);
                                if (i2 == -1) {
                                    break;
                                } else {
                                    bufferedOutputStream.write(bArr, 0, i2);
                                }
                            }
                            bufferedOutputStream.close();
                            bufferedInputStream.close();
                        }
                    }
                    return;
                }
                throw new Exception("目标文件夹不是目录");
            }
            throw new Exception("源文件夹不是目录");
        }
        throw new Exception("文件夹不存在");
    }
}
