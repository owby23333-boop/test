package com.bytedance.e.e.v;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.xiaomi.ad.common.util.SignatureUtils;
import com.yuewen.eq2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class tg {
    public static String bf(String str) throws IOException {
        return e(str, null);
    }

    public static com.bytedance.e.e.d.d d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(bf(str));
            com.bytedance.e.e.d.d dVar = new com.bytedance.e.e.d.d();
            dVar.e(jSONObject.optString("url"));
            dVar.e(jSONObject.optJSONObject(TtmlNode.TAG_BODY));
            dVar.bf(jSONObject.optString("dump_file"));
            dVar.e(jSONObject.optBoolean("encrypt", false));
            return dVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void e(@NonNull File file, @NonNull String str, boolean z) throws Throwable {
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
            vn.e(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            vn.e(fileOutputStream2);
            throw th;
        }
    }

    @Nullable
    public static String[] tg(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)), 1000);
        } catch (Exception e) {
            e = e;
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
            vn.e(bufferedReader2);
            throw th;
        }
        try {
            try {
                String line = bufferedReader.readLine();
                int iIndexOf = line.indexOf(")");
                if (iIndexOf > 0) {
                    line = line.substring(iIndexOf + 2);
                }
                String[] strArrSplit = line.split(" ");
                vn.e(bufferedReader);
                return strArrSplit;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                vn.e(bufferedReader2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            vn.e(bufferedReader);
            return null;
        }
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.delete();
    }

    public static boolean e(File file) {
        return file.exists() && file.delete();
    }

    public static String e(String str, String str2) throws Throwable {
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
                        vn.e(bufferedReader2);
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    vn.e(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String e(File file, String str, String str2, JSONObject jSONObject, boolean z) {
        return e(file, str, str2, jSONObject, null, z);
    }

    public static String e(File file, String str, String str2, JSONObject jSONObject, String str3, boolean z) throws Throwable {
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
            e(file2, jSONObject2.toString(), false);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return file2.getAbsolutePath();
    }

    public static void e(Context context, String str, String str2) throws Throwable {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            sb.append(" ");
            if (str == null) {
                str = eq2.g;
            }
            sb.append(str);
            sb.append(" ");
            if (str2 == null) {
                str2 = eq2.g;
            }
            sb.append(str2);
            sb.append(SignatureUtils.DELIMITER);
            e(v.bf(context), sb.toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
