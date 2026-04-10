package com.kwad.sdk.core.webview.a.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static File bs(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            return filesDir;
        }
        return new File("/data/data/" + context.getPackageName() + "/file/");
    }

    private static String bt(Context context) {
        String str = bs(context) + File.separator + "offlinepackage";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static File bu(Context context) throws IOException {
        String strBt = bt(context);
        if (TextUtils.isEmpty(strBt)) {
            return null;
        }
        cS(strBt);
        File file = new File(strBt, "packageIndex.json");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    public static String cQ(String str) {
        try {
            return Uri.parse(str).getQueryParameter("sceneId");
        } catch (Throwable unused) {
            com.kwad.sdk.core.d.b.e("HybridFileUtils", "getSceneId This isn't a hierarchical URI url is " + str);
            return "";
        }
    }

    public static String cR(String str) {
        try {
            List<String> pathSegments = Uri.parse(str).getPathSegments();
            String str2 = null;
            if (pathSegments != null && pathSegments.size() > 0) {
                str2 = pathSegments.get(pathSegments.size() - 1);
            }
            return (TextUtils.isEmpty(str2) || !str2.contains(".zip")) ? "" : str2.substring(0, str2.indexOf(".zip"));
        } catch (Throwable unused) {
            com.kwad.sdk.core.d.b.e("HybridFileUtils", "getZipName This isn't a hierarchical URI url is " + str);
            return "";
        }
    }

    private static boolean cS(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    public static void f(Context context, String str, String str2) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String name = nextEntry.getName();
            String strBt = bt(context);
            if (!new File(strBt, name).getAbsolutePath().startsWith(strBt)) {
                break;
            }
            if (!nextEntry.isDirectory()) {
                File file = new File(str2 + File.separator + name);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = zipInputStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i2);
                    fileOutputStream.flush();
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            } else if (!name.contains("../")) {
                new File(str2 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
            }
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
    }

    public static String v(Context context, String str) {
        String strBt = bt(context);
        if (TextUtils.isEmpty(strBt)) {
            return null;
        }
        return strBt + File.separator + str;
    }

    public static String w(Context context, String str) {
        String strBt = bt(context);
        if (TextUtils.isEmpty(strBt)) {
            return null;
        }
        return strBt + File.separator + str + ".zip";
    }

    public static String x(Context context, String str) {
        String strBt = bt(context);
        if (TextUtils.isEmpty(strBt)) {
            return null;
        }
        return strBt + File.separator + str;
    }

    public static String y(Context context, String str) {
        String strBt = bt(context);
        if (TextUtils.isEmpty(strBt)) {
            return null;
        }
        return strBt + File.separator + str + File.separator + "_manifest_.json";
    }
}
