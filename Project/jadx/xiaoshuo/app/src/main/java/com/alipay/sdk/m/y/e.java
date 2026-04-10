package com.alipay.sdk.m.y;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import androidx.webkit.ProxyConfig;
import com.alibaba.android.arouter.utils.Consts;
import com.google.common.net.HttpHeaders;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static WebResourceResponse a(String str) {
        HashMap map;
        WebResourceResponse webResourceResponse;
        WebResourceResponse webResourceResponse2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(c(str));
            map = new HashMap();
            map.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, ProxyConfig.MATCH_ALL_SCHEMES);
            webResourceResponse = new WebResourceResponse(mimeTypeFromExtension, "UTF-8", fileInputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            webResourceResponse.setResponseHeaders(map);
            return webResourceResponse;
        } catch (Throwable th2) {
            th = th2;
            webResourceResponse2 = webResourceResponse;
            g.a(th);
            return webResourceResponse2;
        }
    }

    public static void b(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        b(file2.getAbsolutePath());
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }

    public static String c(String str) {
        return str.substring(str.lastIndexOf(Consts.DOT) + 1);
    }

    public static JSONObject d(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    String string = sb.toString();
                    g.b(com.alipay.sdk.m.n.a.B, "readFileToJSON result=" + string);
                    return new JSONObject(string);
                }
                sb.append(line);
            }
        } catch (Throwable th) {
            g.a(th);
            return null;
        }
    }
}
