package com.bytedance.z.g.gz;

import android.content.Context;
import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void z(File file, String str, boolean z) throws Throwable {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file, z);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            m.z(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            m.z(fileOutputStream2);
            throw th;
        }
    }

    public static boolean z(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.delete();
    }

    public static boolean z(File file) {
        return file.exists() && file.delete();
    }

    public static String z(String str, String str2) throws Throwable {
        BufferedReader bufferedReader = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line != null) {
                        sb.append(line);
                        if (str2 != null) {
                            sb.append(str2);
                        }
                    } else {
                        m.z(bufferedReader2);
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    m.z(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String g(String str) throws IOException {
        return z(str, null);
    }

    public static com.bytedance.z.g.dl.dl dl(String str) {
        try {
            JSONObject jSONObject = new JSONObject(g(str));
            com.bytedance.z.g.dl.dl dlVar = new com.bytedance.z.g.dl.dl();
            dlVar.z(jSONObject.optString("url"));
            dlVar.z(jSONObject.optJSONObject(TtmlNode.TAG_BODY));
            dlVar.g(jSONObject.optString("dump_file"));
            dlVar.z(jSONObject.optBoolean("encrypt", false));
            return dlVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String z(File file, String str, String str2, JSONObject jSONObject, boolean z) {
        return z(file, str, str2, jSONObject, null, z);
    }

    public static String z(File file, String str, String str2, JSONObject jSONObject, String str3, boolean z) throws Throwable {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", str2);
            jSONObject2.put(TtmlNode.TAG_BODY, jSONObject);
            if (str3 == null) {
                str3 = "";
            }
            jSONObject2.put("dump_file", str3);
            jSONObject2.put("encrypt", z);
            z(file2, jSONObject2.toString(), false);
        } catch (IOException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
        return file2.getAbsolutePath();
    }

    public static void z(Context context, String str, String str2) throws Throwable {
        try {
            StringBuilder sbAppend = new StringBuilder().append(System.currentTimeMillis()).append(" ");
            if (str == null) {
                str = "null";
            }
            StringBuilder sbAppend2 = sbAppend.append(str).append(" ");
            if (str2 == null) {
                str2 = "null";
            }
            z(gz.g(context), sbAppend2.append(str2).append("\n").toString(), true);
        } catch (IOException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }
}
