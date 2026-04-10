package com.amgcyo.cuttadon.utils.otherutils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import com.fatcatfat.io.R;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ScannerUtils {

    public enum ScannerType {
        RECEIVER,
        MEDIA
    }

    public static boolean a(Context context, String str, Bitmap bitmap, ScannerType scannerType) {
        String str2 = str + ".png";
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), com.amgcyo.cuttadon.f.o.d(R.string.app_name));
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str2);
        if (!file.exists()) {
            file2 = new File(z.b(), str2);
        }
        if (file2.exists()) {
            file2.delete();
            file2 = new File(file, str2);
        }
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                if (scannerType == ScannerType.RECEIVER) {
                    b(context, file2.getAbsolutePath());
                } else if (scannerType == ScannerType.MEDIA) {
                    a(context, file2.getAbsolutePath());
                }
                if (bitmap != null && !bitmap.isRecycled()) {
                    System.gc();
                }
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (scannerType == ScannerType.RECEIVER) {
                    b(context, file2.getAbsolutePath());
                } else if (scannerType == ScannerType.MEDIA) {
                    a(context, file2.getAbsolutePath());
                }
                if (bitmap != null && !bitmap.isRecycled()) {
                    System.gc();
                }
                return false;
            }
        } catch (Throwable th) {
            if (scannerType == ScannerType.RECEIVER) {
                b(context, file2.getAbsolutePath());
            } else if (scannerType == ScannerType.MEDIA) {
                a(context, file2.getAbsolutePath());
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                System.gc();
            }
            throw th;
        }
    }

    private static void b(Context context, String str) {
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + str)));
    }

    private static void a(Context context, String str) {
        MediaScannerConnection.scanFile(context, new String[]{str}, null, null);
    }
}
