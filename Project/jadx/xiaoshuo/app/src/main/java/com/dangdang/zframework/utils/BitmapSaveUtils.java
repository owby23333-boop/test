package com.dangdang.zframework.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes10.dex */
public class BitmapSaveUtils {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.graphics.Bitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void saveBitmap(android.content.Context r5, java.lang.String r6, android.graphics.Bitmap r7) throws java.lang.Throwable {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 < r1) goto Lf
            saveImageToGallery(r5, r7)     // Catch: java.lang.Exception -> La
            goto Le
        La:
            r5 = move-exception
            r5.printStackTrace()
        Le:
            return
        Lf:
            if (r7 != 0) goto L12
            return
        L12:
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            r1 = 0
            boolean r2 = r0.exists()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            if (r2 == 0) goto L21
            r0.delete()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
        L21:
            java.io.File r2 = r0.getParentFile()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            boolean r3 = r2.exists()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            if (r3 != 0) goto L2e
            r2.mkdirs()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
        L2e:
            r0.createNewFile()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L88
            r4 = 100
            r7.compress(r3, r4, r2)     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L88
            r2.flush()     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L88
            r2.close()     // Catch: java.lang.Exception -> L53
            goto L57
        L44:
            r7 = move-exception
            goto L4a
        L46:
            r5 = move-exception
            goto L8a
        L48:
            r7 = move-exception
            r2 = r1
        L4a:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L88
            if (r2 == 0) goto L57
            r2.close()     // Catch: java.lang.Exception -> L53
            goto L57
        L53:
            r7 = move-exception
            r7.printStackTrace()
        L57:
            java.lang.String r7 = java.io.File.separator
            int r7 = r6.lastIndexOf(r7)
            int r2 = r6.length()
            java.lang.String r6 = r6.substring(r7, r2)
            java.lang.String r7 = "fileName_x"
            com.dangdang.zframework.log.LogM.d(r7, r6)
            android.content.ContentResolver r7 = r5.getContentResolver()     // Catch: java.io.FileNotFoundException -> L76
            java.lang.String r2 = r0.getAbsolutePath()     // Catch: java.io.FileNotFoundException -> L76
            android.provider.MediaStore.Images.Media.insertImage(r7, r2, r6, r1)     // Catch: java.io.FileNotFoundException -> L76
            goto L7a
        L76:
            r6 = move-exception
            r6.printStackTrace()
        L7a:
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]
            r7 = 0
            java.lang.String r0 = r0.getAbsolutePath()
            r6[r7] = r0
            android.media.MediaScannerConnection.scanFile(r5, r6, r1, r1)
            return
        L88:
            r5 = move-exception
            r1 = r2
        L8a:
            if (r1 == 0) goto L94
            r1.close()     // Catch: java.lang.Exception -> L90
            goto L94
        L90:
            r6 = move-exception
            r6.printStackTrace()
        L94:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dangdang.zframework.utils.BitmapSaveUtils.saveBitmap(android.content.Context, java.lang.String, android.graphics.Bitmap):void");
    }

    @RequiresApi(api = 19)
    public static String saveImageToGallery(Context context, byte[] bArr) {
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        String str = String.format("ddreader_%s.png", new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date(lValueOf.longValue())));
        ContentValues contentValues = new ContentValues();
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + File.separator + "ddreader");
        }
        contentValues.put("_display_name", str);
        contentValues.put("mime_type", "image/png");
        contentValues.put("date_added", Long.valueOf(lValueOf.longValue() / 1000));
        contentValues.put("date_modified", Long.valueOf(lValueOf.longValue() / 1000));
        contentValues.put("date_expires", Long.valueOf((lValueOf.longValue() + 86400000) / 1000));
        contentValues.put("is_pending", (Integer) 1);
        ContentResolver contentResolver = context.getContentResolver();
        Uri uriInsert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        try {
            OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
            try {
                outputStreamOpenOutputStream.write(bArr);
                outputStreamOpenOutputStream.close();
                contentValues.clear();
                contentValues.put("is_pending", (Integer) 0);
                contentValues.putNull("date_expires");
                contentResolver.update(uriInsert, contentValues, null, null);
            } finally {
            }
        } catch (IOException e) {
            if (Build.VERSION.SDK_INT >= 30) {
                contentResolver.delete(uriInsert, null);
            }
            Log.d("", "Exception:" + e.toString());
        }
        return Environment.DIRECTORY_PICTURES + File.separator + str;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00e6  */
    @androidx.annotation.RequiresApi(api = 19)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String saveImageToGallery(android.content.Context r12, android.graphics.Bitmap r13) {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dangdang.zframework.utils.BitmapSaveUtils.saveImageToGallery(android.content.Context, android.graphics.Bitmap):java.lang.String");
    }
}
