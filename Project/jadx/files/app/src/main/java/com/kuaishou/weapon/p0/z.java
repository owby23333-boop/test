package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set<String> f16946e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Set<String> f16947f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Set<String> f16948g = new HashSet();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Set<String> f16949h = new HashSet();
    private String a = i.a("f118f1f9431de3a626df48d7302911", "0820");
    private String b = i.a("f118f1ef4616f3fc27d1", "0820");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16944c = i.a("f118f1e84f0bf5ba3bd1579c6d35", "0820");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f16945d = i.a("fc03e7a44510", "0820");

    public int a() {
        try {
            if (this.f16947f == null || this.f16947f.size() <= 0) {
                return 0;
            }
            return this.f16947f.size();
        } catch (Exception unused) {
            return 0;
        }
    }

    public JSONArray a(Context context) throws Throwable {
        BufferedReader bufferedReader;
        int iIndexOf;
        Set<String> set;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/self/maps"));
        } catch (Exception unused) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        try {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            hashSet2.add("/system/fr");
            hashSet2.add("/system/em");
            hashSet2.add("/apex/com.");
            hashSet2.add("/data/dalv");
            hashSet2.add("/system/li");
            hashSet2.add("/vendor/li");
            hashSet2.add("/system/ve");
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
                return null;
            }
            this.f16946e.clear();
            this.f16947f.clear();
            this.f16948g.clear();
            this.f16949h.clear();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if ((line.endsWith(com.anythink.china.common.a.a.f6395g) || line.endsWith(".jar") || line.endsWith(".dex") || line.endsWith(".odex") || line.endsWith(".so")) && !line.contains("gson.jar") && !line.contains("volley.jar") && !line.contains("FwkPlugin") && (iIndexOf = line.indexOf(47)) >= 0) {
                    String strSubstring = line.substring(iIndexOf);
                    if (strSubstring.contains(this.a) || strSubstring.contains(this.b) || strSubstring.contains(this.f16944c)) {
                        set = this.f16946e;
                    } else {
                        if (strSubstring.contains(this.f16945d) && !strSubstring.contains("libart.so") && !strSubstring.contains("libart64.so")) {
                            this.f16949h.add(strSubstring);
                        }
                        if (!strSubstring.contains("es/.0/") && !strSubstring.contains("app_DvaPlugin") && !strSubstring.contains("/system_ext/") && (!strSubstring.contains(packageName) || strSubstring.contains("odex_cache") || strSubstring.contains("app_"))) {
                            String strSubstring2 = strSubstring.length() > 10 ? strSubstring.substring(0, 10) : strSubstring;
                            if (!strSubstring.contains("FeatureFramework") && !strSubstring.contains("GmsConfigOverlay") && !strSubstring.contains("/system/app/") && !strSubstring.contains("/system/vendor/lib/") && !strSubstring.contains("/hw_") && !strSubstring.contains("/system/product/lib")) {
                                if (strSubstring.contains("mokee-") || strSubstring.contains("mokee.")) {
                                    set = this.f16947f;
                                } else {
                                    if (!strSubstring.contains("lineageos-") && !strSubstring.contains("lineageos.") && !strSubstring.contains("Hook") && !strSubstring.contains("hook")) {
                                        if (strSubstring.contains("posedBridge") || !hashSet2.contains(strSubstring2)) {
                                            hashSet.add(strSubstring);
                                            if (hashSet.size() > 15 || this.f16946e.size() > 10 || this.f16947f.size() > 10 || this.f16948g.size() > 10) {
                                                break;
                                            }
                                        }
                                    }
                                    set = this.f16948g;
                                }
                            }
                        }
                    }
                    set.add(strSubstring);
                }
            }
            if (hashSet.size() > 0) {
                JSONArray jSONArray = new JSONArray((Collection) hashSet);
                try {
                    bufferedReader.close();
                } catch (IOException unused3) {
                }
                return jSONArray;
            }
        } catch (Exception unused4) {
            if (bufferedReader != null) {
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
        try {
            bufferedReader.close();
        } catch (IOException unused6) {
        }
        return null;
    }

    public Set<String> b() {
        try {
            if (this.f16948g == null || this.f16948g.size() <= 0) {
                return null;
            }
            return this.f16948g;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set<String> c() {
        try {
            if (this.f16949h == null || this.f16949h.size() <= 0) {
                return null;
            }
            return this.f16949h;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d() {
        String str;
        try {
            if (this.f16946e == null || this.f16946e.size() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            for (String str2 : this.f16946e) {
                if (str2.contains(this.a)) {
                    str = "0";
                } else if (str2.contains(this.b)) {
                    str = "1";
                } else if (str2.contains(this.f16944c)) {
                    str = "2";
                }
                jSONObject.put(str, 1);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set e() {
        try {
            HashSet hashSet = new HashSet();
            if (this.f16946e == null || this.f16946e.size() <= 0) {
                return null;
            }
            for (String str : this.f16946e) {
                if (str.endsWith("dex")) {
                    hashSet.add(str);
                }
                if (hashSet.size() > 5) {
                    break;
                }
            }
            if (hashSet.size() > 0) {
                return hashSet;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
