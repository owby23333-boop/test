package com.amgcyo.cuttadon.j.a;

import androidx.exifinterface.media.ExifInterface;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.utils.otherutils.z;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: DataCleanManager.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private static int a;

    public static String a(double d2) {
        double d3 = d2 / 1024.0d;
        if (d3 < 1.0d) {
            return d2 + "B";
        }
        double d4 = d3 / 1024.0d;
        if (d4 < 1.0d) {
            return new BigDecimal(Double.toString(d3)).setScale(2, 4).toPlainString() + "K";
        }
        double d5 = d4 / 1024.0d;
        if (d5 < 1.0d) {
            return new BigDecimal(Double.toString(d4)).setScale(2, 4).toPlainString() + "M";
        }
        double d6 = d5 / 1024.0d;
        if (d6 < 1.0d) {
            return new BigDecimal(Double.toString(d5)).setScale(2, 4).toPlainString() + "G";
        }
        return new BigDecimal(d6).setScale(2, 4).toPlainString() + ExifInterface.GPS_DIRECTION_TRUE;
    }

    public static long a(File file) throws Exception {
        File[] fileArrListFiles;
        long length;
        long j2 = 0;
        try {
            fileArrListFiles = file.listFiles();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    length = a(file2);
                } else {
                    length = file2.length();
                }
                j2 += length;
            }
            return j2;
        }
        return 0L;
    }

    public static void a(final BaseTitleBarActivity baseTitleBarActivity, final String str, final boolean z2, final com.amgcyo.cuttadon.j.e.b bVar, final boolean z3) {
        if (baseTitleBarActivity == null) {
            return;
        }
        List<String> listH = z.h(str);
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(listH)) {
            a = 0;
            if (z2) {
                baseTitleBarActivity.showLoading("");
            }
            final int size = listH.size();
            if (size > 300) {
                baseTitleBarActivity.showMessage("当前缓存文件较多，请耐心等待!");
            }
            String str2 = "文件个数:" + size;
            for (final String str3 : listH) {
                f.a().a(new g(new Callable() { // from class: com.amgcyo.cuttadon.j.a.a
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return e.a(str3, size, baseTitleBarActivity, z2, str, z3, bVar);
                    }
                }));
            }
            return;
        }
        a = 0;
        baseTitleBarActivity.runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.j.a.c
            @Override // java.lang.Runnable
            public final void run() {
                e.a(str, z3, baseTitleBarActivity, bVar, z2);
            }
        });
    }

    static /* synthetic */ Boolean a(String str, int i2, final BaseTitleBarActivity baseTitleBarActivity, final boolean z2, final String str2, final boolean z3, final com.amgcyo.cuttadon.j.e.b bVar) throws Exception {
        boolean zA = z.a(str);
        a++;
        if (a == i2) {
            baseTitleBarActivity.runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.j.a.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.a(z2, baseTitleBarActivity, str2, z3, bVar);
                }
            });
        }
        return Boolean.valueOf(zA);
    }

    static /* synthetic */ void a(boolean z2, BaseTitleBarActivity baseTitleBarActivity, String str, boolean z3, com.amgcyo.cuttadon.j.e.b bVar) {
        if (z2) {
            baseTitleBarActivity.hideLoading();
        }
        File file = new File(str);
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length <= 0) {
            boolean zDelete = file.delete();
            if (z3) {
                StringBuilder sb = new StringBuilder();
                sb.append("缓存文件清理");
                sb.append(zDelete ? "成功~" : "失败~");
                baseTitleBarActivity.showMessage(sb.toString());
            }
            if (bVar != null && zDelete) {
                bVar.a();
            }
        }
        a = 0;
    }

    static /* synthetic */ void a(String str, boolean z2, BaseTitleBarActivity baseTitleBarActivity, com.amgcyo.cuttadon.j.e.b bVar, boolean z3) {
        File file = new File(str);
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length <= 0) {
            boolean zDelete = file.delete();
            if (z2) {
                StringBuilder sb = new StringBuilder();
                sb.append("缓存文件清理");
                sb.append(zDelete ? "成功~" : "失败~");
                baseTitleBarActivity.showMessage(sb.toString());
            }
            if (bVar != null && zDelete) {
                bVar.a();
            }
        } else {
            baseTitleBarActivity.showMessage("处理完成!");
        }
        if (z3) {
            baseTitleBarActivity.hideLoading();
        }
    }

    public static void a(final String str) {
        final List<String> listH = z.h(str);
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a(listH)) {
            a = 0;
            int size = listH.size();
            String str2 = "文件个数:" + size;
            if (size > 300) {
                o.b("当前缓存文件较多，请耐心等待!");
            }
            for (final String str3 : listH) {
                f.a().a(new g(new Callable() { // from class: com.amgcyo.cuttadon.j.a.b
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return e.a(str3, listH, str);
                    }
                }));
            }
            return;
        }
        a = 0;
        File file = new File(str);
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length > 0) {
            return;
        }
        boolean zDelete = file.delete();
        StringBuilder sb = new StringBuilder();
        sb.append("缓存文件清理");
        sb.append(zDelete ? "成功~" : "失败~");
        sb.toString();
    }

    static /* synthetic */ Boolean a(String str, List list, String str2) throws Exception {
        boolean zA = z.a(str);
        a++;
        if (a == list.size()) {
            File file = new File(str2);
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length <= 0) {
                boolean zDelete = file.delete();
                StringBuilder sb = new StringBuilder();
                sb.append("缓存文件清理");
                sb.append(zDelete ? "成功~" : "失败~");
                sb.toString();
            }
            a = 0;
        }
        return Boolean.valueOf(zA);
    }
}
