package com.bytedance.sdk.openadsdk.s;

import com.bytedance.sdk.component.utils.wu;
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

/* JADX INFO: loaded from: classes10.dex */
public class tg {
    private static void bf(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                e(file2);
            }
        }
    }

    public static void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                wu.d("FileUtils", e);
            }
        }
    }

    public static File e(File file, String str) throws Throwable {
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
                                e(zipOutputStream2, file3);
                                zipOutputStream2.closeEntry();
                            }
                            zipOutputStream2.flush();
                            zipOutputStream = zipOutputStream2;
                        } catch (IOException e) {
                            e = e;
                            zipOutputStream = zipOutputStream2;
                            wu.d("FileUtils", e);
                        } catch (Throwable th) {
                            th = th;
                            zipOutputStream = zipOutputStream2;
                            e(zipOutputStream);
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
            e(zipOutputStream);
            return file2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void e(String str, File file) throws Throwable {
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
                try {
                    bufferedWriter2.write(str);
                    e(bufferedWriter2);
                } catch (FileNotFoundException e) {
                    e = e;
                    bufferedWriter = bufferedWriter2;
                    wu.d("FileUtils", e);
                    e(bufferedWriter);
                } catch (IOException e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    wu.d("FileUtils", e);
                    e(bufferedWriter);
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    e(bufferedWriter);
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

    public static void e(OutputStream outputStream, File file) throws Throwable {
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
                            e(fileInputStream2);
                            return;
                        }
                    }
                } catch (FileNotFoundException e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    wu.d("FileUtils", e);
                    e(fileInputStream);
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    wu.d("FileUtils", e);
                    e(fileInputStream);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    e(fileInputStream);
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

    public static void e(File file) {
        if (file.isDirectory()) {
            bf(file);
        } else {
            file.delete();
        }
    }
}
