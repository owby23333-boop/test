package com.yuewen;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes12.dex */
public class gn4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f11621a = false;

    public static long a(String str) {
        try {
            Enumeration<? extends ZipEntry> enumerationEntries = new ZipFile(str).entries();
            long size = 0;
            while (enumerationEntries.hasMoreElements()) {
                size += enumerationEntries.nextElement().getSize();
            }
            return size;
        } catch (IOException unused) {
            return 0L;
        }
    }

    public static String b(String str) {
        int iLastIndexOf = str.lastIndexOf(File.separatorChar);
        if (iLastIndexOf == -1) {
            return null;
        }
        return str.substring(0, iLastIndexOf);
    }

    public static boolean c(File file, File file2) throws Throwable {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)));
            boolean zD = d(zipInputStream, file2);
            zipInputStream.close();
            return zD;
        } catch (Error e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean d(ZipInputStream zipInputStream, File file) throws Throwable {
        LinkedList linkedList = new LinkedList();
        if (!file.exists()) {
            file.mkdirs();
            linkedList.add(file);
        }
        try {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                while (nextEntry != null) {
                    String name = nextEntry.getName();
                    File file2 = new File(file, name);
                    if (!file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                        qt1.a("unzip", "unzip path traversal failed, entry name = " + name);
                        return false;
                    }
                    if (!nextEntry.isDirectory()) {
                        linkedList.add(file2);
                        String strB = b(name);
                        if (strB != null) {
                            File file3 = new File(file, strB);
                            if (!file3.exists()) {
                                file3.mkdirs();
                            }
                        }
                        if (!file2.exists() || file2.length() != nextEntry.getSize()) {
                            FileOutputStream fileOutputStream = null;
                            try {
                                byte[] bArr = new byte[1024];
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                                while (true) {
                                    try {
                                        int i = zipInputStream.read(bArr);
                                        if (i <= 0) {
                                            break;
                                        }
                                        fileOutputStream2.write(bArr, 0, i);
                                    } catch (Throwable th) {
                                        th = th;
                                        fileOutputStream = fileOutputStream2;
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                fileOutputStream2.flush();
                                fileOutputStream2.getFD().sync();
                                try {
                                    fileOutputStream2.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    } else if (!file2.exists()) {
                        file2.mkdirs();
                        linkedList.add(file2);
                    }
                    nextEntry = zipInputStream.getNextEntry();
                }
                return true;
            } catch (Exception e3) {
                e3.printStackTrace();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    q41.A((File) it.next());
                }
                return false;
            }
        } catch (Error e4) {
            e4.printStackTrace();
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                q41.A((File) it2.next());
            }
            return false;
        }
    }

    public static boolean e(Context context, String str, File file) {
        InputStream inputStreamOpen = null;
        try {
            try {
                inputStreamOpen = context.getAssets().open(str);
                ZipInputStream zipInputStream = new ZipInputStream(inputStreamOpen);
                boolean zD = d(zipInputStream, file);
                zipInputStream.close();
                return zD;
            } catch (Exception e) {
                e.printStackTrace();
                if (inputStreamOpen == null) {
                    return false;
                }
                try {
                    inputStreamOpen.close();
                    return false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
        } finally {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public static boolean f(Context context, String[] strArr, File file) {
        AssetManager assets = context.getAssets();
        int length = strArr.length;
        InputStream[] inputStreamArr = new InputStream[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                try {
                    inputStreamArr[i2] = assets.open(strArr[i2]);
                } catch (Exception e) {
                    e.printStackTrace();
                    for (int i3 = 0; i3 < length; i3++) {
                        InputStream inputStream = inputStreamArr[i3];
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    return false;
                }
            } catch (Throwable th) {
                while (i < length) {
                    InputStream inputStream2 = inputStreamArr[i];
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    i++;
                }
                throw th;
            }
        }
        ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(Arrays.asList(inputStreamArr))));
        boolean zD = d(zipInputStream, file);
        zipInputStream.close();
        while (i < length) {
            InputStream inputStream3 = inputStreamArr[i];
            if (inputStream3 != null) {
                try {
                    inputStream3.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            i++;
        }
        return zD;
    }

    public static boolean g(Context context, int i, File file) {
        InputStream inputStreamOpenRawResource = null;
        try {
            try {
                inputStreamOpenRawResource = context.getResources().openRawResource(i);
                ZipInputStream zipInputStream = new ZipInputStream(inputStreamOpenRawResource);
                boolean zD = d(zipInputStream, file);
                zipInputStream.close();
                return zD;
            } catch (Exception e) {
                e.printStackTrace();
                if (inputStreamOpenRawResource == null) {
                    return false;
                }
                try {
                    inputStreamOpenRawResource.close();
                    return false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
        } finally {
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public static boolean h(File file, String str, ZipOutputStream zipOutputStream) {
        if (file == null) {
            return false;
        }
        if (file.isFile()) {
            l(file, str, zipOutputStream);
        } else {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                for (File file2 : fileArrListFiles) {
                    if (!h(file2, str + File.separator + file2.getName(), zipOutputStream)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean i(File file, ZipOutputStream zipOutputStream) {
        if (file == null) {
            return false;
        }
        if (file.isFile()) {
            return l(file, file.getName(), zipOutputStream);
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                if (!i(file2, zipOutputStream)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean j(File file, File file2) {
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2 = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
        } catch (Throwable unused) {
        }
        try {
            boolean zH = h(file, file.getName(), zipOutputStream);
            yu3.b(zipOutputStream);
            return zH;
        } catch (Throwable unused2) {
            zipOutputStream2 = zipOutputStream;
            yu3.b(zipOutputStream2);
            return false;
        }
    }

    public static boolean k(File file, File file2) {
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2 = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
        } catch (Throwable unused) {
        }
        try {
            boolean zI = i(file, zipOutputStream);
            yu3.b(zipOutputStream);
            return zI;
        } catch (Throwable unused2) {
            zipOutputStream2 = zipOutputStream;
            yu3.b(zipOutputStream2);
            return false;
        }
    }

    public static boolean l(File file, String str, ZipOutputStream zipOutputStream) {
        BufferedInputStream bufferedInputStream = null;
        try {
            byte[] bArr = new byte[1024];
            zipOutputStream.putNextEntry(new ZipEntry(str));
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            while (true) {
                try {
                    int i = bufferedInputStream2.read(bArr, 0, 1024);
                    if (i == -1) {
                        yu3.b(bufferedInputStream2);
                        try {
                            zipOutputStream.closeEntry();
                            return true;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return true;
                        }
                    }
                    zipOutputStream.write(bArr, 0, i);
                } catch (Throwable unused) {
                    bufferedInputStream = bufferedInputStream2;
                    yu3.b(bufferedInputStream);
                    try {
                        zipOutputStream.closeEntry();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return false;
                }
            }
        } catch (Throwable unused2) {
        }
    }
}
