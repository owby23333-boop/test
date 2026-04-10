package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes8.dex */
public class aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f8222a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f8223a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        byte[] f960a;

        public a(byte[] bArr, int i) {
            this.f960a = bArr;
            this.f8223a = i;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f8224a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Bitmap f961a;

        public b(Bitmap bitmap, long j) {
            this.f961a = bitmap;
            this.f8224a = j;
        }
    }

    public static b a(Context context, String str, boolean z) throws Throwable {
        a aVarA;
        ByteArrayInputStream byteArrayInputStream = null;
        b bVar = new b(null, 0L);
        Bitmap bitmapB = b(context, str);
        try {
            if (bitmapB != null) {
                bVar.f961a = bitmapB;
                return bVar;
            }
            try {
                aVarA = a(str, z);
            } catch (Exception e) {
                e = e;
            }
            if (aVarA == null) {
                com.xiaomi.push.x.a((Closeable) null);
                return bVar;
            }
            bVar.f8224a = aVarA.f8223a;
            byte[] bArr = aVarA.f960a;
            if (bArr != null) {
                if (z) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                    try {
                        int iA = a(context, byteArrayInputStream2);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = iA;
                        bVar.f961a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        byteArrayInputStream = byteArrayInputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        byteArrayInputStream = byteArrayInputStream2;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    } catch (Throwable th) {
                        th = th;
                        byteArrayInputStream = byteArrayInputStream2;
                        com.xiaomi.push.x.a((Closeable) byteArrayInputStream);
                        throw th;
                    }
                } else {
                    bVar.f961a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
            }
            a(context, aVarA.f960a, str);
            com.xiaomi.push.x.a((Closeable) byteArrayInputStream);
            return bVar;
            com.xiaomi.channel.commonutils.logger.b.a(e);
            com.xiaomi.push.x.a((Closeable) byteArrayInputStream);
            return bVar;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static Bitmap b(Context context, String str) throws Throwable {
        Throwable th;
        FileInputStream fileInputStream;
        Bitmap bitmap;
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon", com.xiaomi.push.bo.a(str));
        FileInputStream fileInputStream2 = null;
        Bitmap bitmapDecodeStream = null;
        fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream);
                    file.setLastModified(System.currentTimeMillis());
                    com.xiaomi.push.x.a((Closeable) fileInputStream);
                    return bitmapDecodeStream;
                } catch (Exception e) {
                    e = e;
                    Bitmap bitmap2 = bitmapDecodeStream;
                    fileInputStream2 = fileInputStream;
                    bitmap = bitmap2;
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    com.xiaomi.push.x.a((Closeable) fileInputStream2);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    com.xiaomi.push.x.a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                FileInputStream fileInputStream3 = fileInputStream2;
                th = th3;
                fileInputStream = fileInputStream3;
            }
        } catch (Exception e2) {
            e = e2;
            bitmap = null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00f7: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:56:0x00f7 */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d5 A[PHI: r1
  0x00d5: PHI (r1v5 java.net.HttpURLConnection) = (r1v4 java.net.HttpURLConnection), (r1v6 java.net.HttpURLConnection) binds: [B:47:0x00d3, B:52:0x00f2] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.xiaomi.push.service.aw.a a(java.lang.String r10, boolean r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.aw.a(java.lang.String, boolean):com.xiaomi.push.service.aw$a");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    public static Bitmap a(Context context, String str) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStreamOpenInputStream2;
        int iA;
        Uri uri = Uri.parse(str);
        ?? r0 = 0;
        r0 = 0;
        try {
            try {
                inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                try {
                    iA = a(context, inputStreamOpenInputStream);
                    inputStreamOpenInputStream2 = context.getContentResolver().openInputStream(uri);
                } catch (IOException e) {
                    e = e;
                    inputStreamOpenInputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    com.xiaomi.push.x.a((Closeable) r0);
                    com.xiaomi.push.x.a((Closeable) inputStreamOpenInputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                inputStreamOpenInputStream2 = null;
                inputStreamOpenInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                inputStreamOpenInputStream = null;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = iA;
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2, null, options);
                com.xiaomi.push.x.a((Closeable) inputStreamOpenInputStream2);
                com.xiaomi.push.x.a((Closeable) inputStreamOpenInputStream);
                return bitmapDecodeStream;
            } catch (IOException e3) {
                e = e3;
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.x.a((Closeable) inputStreamOpenInputStream2);
                com.xiaomi.push.x.a((Closeable) inputStreamOpenInputStream);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            r0 = context;
        }
    }

    private static int a(Context context, InputStream inputStream) {
        int i;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth != -1 && options.outHeight != -1) {
            int iRound = Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
            int i2 = options.outWidth;
            if (i2 <= iRound || (i = options.outHeight) <= iRound) {
                return 1;
            }
            return Math.min(i2 / iRound, i / iRound);
        }
        com.xiaomi.channel.commonutils.logger.b.m106a("decode dimension failed for bitmap.");
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.FileOutputStream, java.io.OutputStream] */
    private static void a(Context context, byte[] bArr, String str) throws Throwable {
        if (bArr == null) {
            com.xiaomi.channel.commonutils.logger.b.m106a("cannot save small icon cause bitmap is null");
            return;
        }
        a(context);
        ?? file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File((File) file, com.xiaomi.push.bo.a(str));
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                file = new FileOutputStream(file2);
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(file);
                    try {
                        bufferedOutputStream2.write(bArr);
                        bufferedOutputStream2.flush();
                        com.xiaomi.push.x.a(bufferedOutputStream2);
                        file = file;
                    } catch (Exception e) {
                        e = e;
                        bufferedOutputStream = bufferedOutputStream2;
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        com.xiaomi.push.x.a(bufferedOutputStream);
                        file = file;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        com.xiaomi.push.x.a(bufferedOutputStream);
                        com.xiaomi.push.x.a((Closeable) file);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                file = 0;
            } catch (Throwable th2) {
                th = th2;
                file = 0;
            }
            com.xiaomi.push.x.a((Closeable) file);
            if (f8222a == 0) {
                f8222a = com.xiaomi.push.w.a(new File(context.getCacheDir().getPath() + File.separator + "mipush_icon")) + file2.length();
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static void a(Context context) {
        File file = new File(context.getCacheDir().getPath() + File.separator + "mipush_icon");
        if (file.exists()) {
            if (f8222a == 0) {
                f8222a = com.xiaomi.push.w.a(file);
            }
            if (f8222a > 15728640) {
                try {
                    File[] fileArrListFiles = file.listFiles();
                    for (int i = 0; i < fileArrListFiles.length; i++) {
                        if (!fileArrListFiles[i].isDirectory() && Math.abs(System.currentTimeMillis() - fileArrListFiles[i].lastModified()) > 1209600) {
                            fileArrListFiles[i].delete();
                        }
                    }
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
                f8222a = 0L;
            }
        }
    }
}
