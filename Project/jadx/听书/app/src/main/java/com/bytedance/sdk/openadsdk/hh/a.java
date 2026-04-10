package com.bytedance.sdk.openadsdk.hh;

import com.bytedance.sdk.component.utils.wp;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void z(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                wp.g("FileUtils", e);
            }
        }
    }

    public static File z(File file, String str) throws Throwable {
        File file2;
        ZipOutputStream zipOutputStream = null;
        try {
            try {
                file2 = new File(file.getParentFile(), str);
                try {
                    if (file.exists() && file.isDirectory()) {
                        ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file2));
                        try {
                            for (File file3 : file.listFiles()) {
                                zipOutputStream2.putNextEntry(new ZipEntry(file3.getName()));
                                z(zipOutputStream2, file3);
                                zipOutputStream2.closeEntry();
                            }
                            zipOutputStream2.flush();
                            zipOutputStream = zipOutputStream2;
                        } catch (IOException e) {
                            e = e;
                            zipOutputStream = zipOutputStream2;
                            wp.g("FileUtils", e);
                        } catch (Throwable th) {
                            th = th;
                            zipOutputStream = zipOutputStream2;
                            z(zipOutputStream);
                            throw th;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (IOException e3) {
                e = e3;
                file2 = null;
            }
            z(zipOutputStream);
            return file2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void z(String str, File file) throws Throwable {
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
                try {
                    bufferedWriter2.write(str);
                    z(bufferedWriter2);
                } catch (FileNotFoundException e) {
                    e = e;
                    bufferedWriter = bufferedWriter2;
                    wp.g("FileUtils", e);
                    z(bufferedWriter);
                } catch (IOException e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    wp.g("FileUtils", e);
                    z(bufferedWriter);
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    z(bufferedWriter);
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void z(OutputStream outputStream, File file) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1048576];
                    while (true) {
                        int i = fileInputStream2.read(bArr);
                        if (i != -1) {
                            outputStream.write(bArr, 0, i);
                        } else {
                            z(fileInputStream2);
                            return;
                        }
                    }
                } catch (FileNotFoundException e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    wp.g("FileUtils", e);
                    z(fileInputStream);
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    wp.g("FileUtils", e);
                    z(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    z(fileInputStream);
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void z(File file) {
        if (file.isDirectory()) {
            g(file);
        } else {
            file.delete();
        }
    }

    private static void g(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                z(file2);
            }
        }
    }
}
