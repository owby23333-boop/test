package com.anythink.expressad.foundation.g.f.h;

import android.text.TextUtils;
import com.anythink.expressad.foundation.h.o;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static String a = "a";
    public static String b = "d";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f10578c = "e";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10579d = "b";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f10580e = new LinkedHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, com.anythink.expressad.foundation.g.f.c.b> f10581f = new LinkedHashMap();

    public b() {
    }

    private JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.f10580e.entrySet()) {
                jSONObject.put(URLEncoder.encode(entry.getKey(), "UTF-8"), URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
            for (Map.Entry<String, com.anythink.expressad.foundation.g.f.c.b> entry2 : this.f10581f.entrySet()) {
                jSONObject.put(URLEncoder.encode(entry2.getKey(), "UTF-8"), URLEncoder.encode("FILE_NAME_" + entry2.getValue().b().getName(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException unused) {
        } catch (JSONException e2) {
            o.d(f10579d, e2.getMessage());
        }
        return jSONObject;
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.f10580e.put(str, str2);
    }

    public final Map<String, String> b() {
        return this.f10580e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(28);
        try {
            for (Map.Entry<String, String> entry : this.f10580e.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
            for (Map.Entry<String, com.anythink.expressad.foundation.g.f.c.b> entry2 : this.f10581f.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode(entry2.getKey(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode("FILE_NAME_" + entry2.getValue().b().getName(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e2) {
            o.d(f10579d, e2.getMessage());
        }
        return sb.toString();
    }

    private void a(String str, File file, String str2, String str3) throws FileNotFoundException {
        if (file != null && file.exists()) {
            if (TextUtils.isEmpty(str2)) {
                str2 = file.getName();
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f10581f.put(str, new com.anythink.expressad.foundation.g.f.c.b(str2, file, str2, str3));
            return;
        }
        throw new FileNotFoundException();
    }

    private b(String str, String str2) {
        this.f10580e.put(str, str2);
    }

    private b(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
        }
    }

    private void a(Map<String, ?> map) throws FileNotFoundException {
        if (map != null) {
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof String) {
                    a(entry.getKey(), (String) entry.getValue());
                } else if (value instanceof File) {
                    String key = entry.getKey();
                    File file = (File) entry.getValue();
                    if (file != null && file.exists()) {
                        String name = TextUtils.isEmpty(null) ? file.getName() : null;
                        if (!TextUtils.isEmpty(key)) {
                            this.f10581f.put(key, new com.anythink.expressad.foundation.g.f.c.b(name, file, name, null));
                        }
                    } else {
                        throw new FileNotFoundException();
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private b(String... strArr) {
        int length = strArr.length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Supplied arguments must be even");
        }
        for (int i2 = 0; i2 < length; i2 += 2) {
            a(strArr[i2], strArr[i2 + 1]);
        }
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : this.f10580e.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }

    private void a(String str) {
        this.f10580e.remove(str);
        this.f10581f.remove(str);
    }

    private void a(String str, File file) throws FileNotFoundException {
        if (file != null && file.exists()) {
            String name = TextUtils.isEmpty(null) ? file.getName() : null;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f10581f.put(str, new com.anythink.expressad.foundation.g.f.c.b(name, file, name, null));
            return;
        }
        throw new FileNotFoundException();
    }

    private void a(String str, File file, String str2) throws FileNotFoundException {
        if (file != null && file.exists()) {
            if (TextUtils.isEmpty(str2)) {
                str2 = file.getName();
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f10581f.put(str, new com.anythink.expressad.foundation.g.f.c.b(str2, file, str2, null));
            return;
        }
        throw new FileNotFoundException();
    }
}
