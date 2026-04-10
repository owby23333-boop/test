package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.umeng.message.proguard.ad;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.android.agoo.common.AgooConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static String a(File file, String str, String str2, JSONObject jSONObject, String str3, boolean z2) throws Throwable {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", str2);
            jSONObject2.put(AgooConstants.MESSAGE_BODY, jSONObject);
            if (str3 == null) {
                str3 = "";
            }
            jSONObject2.put("dump_file", str3);
            jSONObject2.put("encrypt", z2);
            a(file2, jSONObject2.toString(), false);
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return file2.getAbsolutePath();
    }

    public static String a(File file, String str, String str2, JSONObject jSONObject, boolean z2) {
        return a(file, str, str2, jSONObject, null, z2);
    }

    public static String a(String str, String str2) throws Throwable {
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
                    if (line == null) {
                        f.a(bufferedReader2);
                        return sb.toString();
                    }
                    sb.append(line);
                    if (str2 != null) {
                        sb.append(str2);
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    f.a(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(Context context, String str, String str2) throws Throwable {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            sb.append(" ");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            sb.append(" ");
            if (str2 == null) {
                str2 = "null";
            }
            sb.append(str2);
            sb.append("\n");
            a(h.a(context), sb.toString(), true);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void a(@NonNull File file, @NonNull String str, boolean z2) throws Throwable {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        file.getParentFile().mkdirs();
        try {
            fileOutputStream = new FileOutputStream(file, z2);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            f.a(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            f.a(fileOutputStream);
            throw th;
        }
    }

    public static boolean a(File file) {
        return file.exists() && file.delete();
    }

    public static boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.delete()) {
                return true;
            }
        }
        return false;
    }

    public static bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.c b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(c(str));
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.c cVar = new bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.c();
            cVar.b(jSONObject.optString("url"));
            cVar.a(jSONObject.optJSONObject(AgooConstants.MESSAGE_BODY));
            cVar.a(jSONObject.optString("dump_file"));
            cVar.a(jSONObject.optBoolean("encrypt", false));
            return cVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(String str) throws IOException {
        return a(str, null);
    }

    @Nullable
    public static String[] d(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        String[] strArrSplit = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)), 1000);
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
            f.a(bufferedReader2);
            throw th;
        }
        try {
            try {
                String line = bufferedReader.readLine();
                int iIndexOf = line.indexOf(ad.f20406s);
                if (iIndexOf > 0) {
                    line = line.substring(iIndexOf + 2);
                }
                strArrSplit = line.split(" ");
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                f.a(bufferedReader2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
        }
        f.a(bufferedReader);
        return strArrSplit;
    }
}
