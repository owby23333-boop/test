package com.amgcyo.cuttadon.utils.otherutils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.baidu.mobads.sdk.internal.am;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: ShareUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class m0 {
    public static final String a = h.t() + ".fileprovider";

    public static boolean a(Context context, String str) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (!g.a(installedPackages)) {
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                if (str.equals(installedPackages.get(i2).packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void a(Context context, Bitmap bitmap) throws Exception {
        if (a(context, TbsConfig.APP_QQ)) {
            try {
                Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, (String) null, (String) null));
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.STREAM", uri);
                intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                intent.setType("image/*");
                intent.setComponent(new ComponentName(TbsConfig.APP_QQ, "com.tencent.mobileqq.activity.JumpActivity"));
                context.startActivity(Intent.createChooser(intent, "Share"));
                return;
            } catch (Exception e2) {
                throw e2;
            }
        }
        Toast.makeText(context, "您需要先安装QQ客户端", 1).show();
        throw new Exception();
    }

    public static void a(Context context, File file) throws Exception {
        Uri uriFromFile;
        if (a(context, "com.tencent.mm")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI"));
            intent.setAction("android.intent.action.SEND");
            intent.setType("image/*");
            if (file != null && file.isFile() && file.exists()) {
                if (Build.VERSION.SDK_INT >= 24) {
                    uriFromFile = FileProvider.getUriForFile(context, a, file);
                } else {
                    uriFromFile = Uri.fromFile(file);
                }
                intent.putExtra("android.intent.extra.STREAM", uriFromFile);
            }
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(Intent.createChooser(intent, "Share"));
            return;
        }
        Toast.makeText(context, "您需要先安装微信客户端", 1).show();
        throw new Exception();
    }

    public static void a(View view, int i2, int i3) {
        view.layout(0, 0, i2, i3);
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public static Bitmap a(View view) {
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache(true);
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawingCache);
        view.setDrawingCacheEnabled(false);
        return bitmapCreateBitmap;
    }

    public static void a(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(am.f12848e);
        intent.putExtra("android.intent.extra.TEXT", str);
        context.startActivity(Intent.createChooser(intent, str2));
    }

    public static File a(Bitmap bitmap) {
        String strB = z.b();
        File file = new File(strB);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(strB, System.currentTimeMillis() + ".png");
        if (file2.exists()) {
            file2.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
            try {
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return file2;
    }

    public static void a(String str, Bitmap bitmap) {
        String strB = z.b();
        File file = new File(strB);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(strB, str);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
