package com.kwad.sdk.core.webview.b.c;

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

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static void f(Context context, String str, String str2) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String name = nextEntry.getName();
            String strBX = bX(context);
            if (!new File(strBX, name).getAbsolutePath().startsWith(strBX)) {
                break;
            }
            if (nextEntry.isDirectory()) {
                if (!name.contains("../")) {
                    new File(str2 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                }
            } else {
                File file = new File(str2 + File.separator + name);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = zipInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i);
                    fileOutputStream.flush();
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            }
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
    }

    private static File bW(Context context) {
        File filesDir = context.getFilesDir();
        return filesDir == null ? new File("/data/data/" + context.getPackageName() + "/file/") : filesDir;
    }

    private static String bX(Context context) {
        String str = bW(context) + File.separator + "offlinepackage";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String H(Context context, String str) {
        String strBX = bX(context);
        if (TextUtils.isEmpty(strBX)) {
            return null;
        }
        return strBX + File.separator + str;
    }

    public static File bY(Context context) throws IOException {
        String strBX = bX(context);
        if (TextUtils.isEmpty(strBX)) {
            return null;
        }
        fc(strBX);
        File file = new File(strBX, "packageIndex.json");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    public static String I(Context context, String str) {
        String strBX = bX(context);
        if (TextUtils.isEmpty(strBX)) {
            return null;
        }
        return strBX + File.separator + str + ".zip";
    }

    public static String J(Context context, String str) {
        String strBX = bX(context);
        if (TextUtils.isEmpty(strBX)) {
            return null;
        }
        return strBX + File.separator + str;
    }

    public static String K(Context context, String str) {
        String strBX = bX(context);
        if (TextUtils.isEmpty(strBX)) {
            return null;
        }
        return strBX + File.separator + str + File.separator + "_manifest_.json";
    }

    public static String fa(String str) {
        try {
            return Uri.parse(str).getQueryParameter("sceneId");
        } catch (Throwable unused) {
            com.kwad.sdk.core.d.c.e("HybridFileUtils", "getSceneId This isn't a hierarchical URI url is " + str);
            return "";
        }
    }

    public static String fb(String str) {
        try {
            List<String> pathSegments = Uri.parse(str).getPathSegments();
            String str2 = (pathSegments == null || pathSegments.size() <= 0) ? null : pathSegments.get(pathSegments.size() - 1);
            return (TextUtils.isEmpty(str2) || !str2.contains(".zip")) ? "" : str2.substring(0, str2.indexOf(".zip"));
        } catch (Throwable unused) {
            com.kwad.sdk.core.d.c.e("HybridFileUtils", "getZipName This isn't a hierarchical URI url is " + str);
            return "";
        }
    }

    private static boolean fc(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }
}
