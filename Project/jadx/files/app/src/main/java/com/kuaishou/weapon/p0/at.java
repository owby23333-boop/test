package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class at {
    private JSONObject a;
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16559c;

    public at(Context context) {
        if (Engine.loadSuccess) {
            try {
                String strPqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.f16632g).intValue(), 0, 100, "");
                if (TextUtils.isEmpty(strPqr)) {
                    return;
                }
                this.a = new JSONObject(strPqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public Set a(int i2) {
        HashSet hashSet = new HashSet();
        if (i2 == 0) {
            hashSet.add("/preas/chi");
        }
        return hashSet;
    }

    public Set a(Context context, String str, int i2) {
        JSONObject jSONObject = this.a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            Set setA = a(i2);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String strReplace = jSONArray.getString(i3).replaceAll(" ", "").replace("\n", "").replace("\t", "").replace("\u200b", "");
                boolean zStartsWith = strReplace.startsWith(":");
                String strSubstring = strReplace;
                if (zStartsWith) {
                    strSubstring = strReplace.substring(1);
                }
                Object objSubstring = strSubstring.length() > 10 ? strSubstring.substring(0, 10) : strSubstring;
                String packageName = context.getPackageName();
                if (!strSubstring.contains(packageName) && !packageName.contains(strSubstring) && !setA.contains(objSubstring)) {
                    hashSet.add(strSubstring);
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

    public boolean a() {
        return this.b;
    }

    public JSONArray b(String str) {
        JSONObject jSONObject = this.a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                hashSet.add(jSONArray.getString(i2));
            }
            JSONArray jSONArray2 = new JSONArray();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                jSONArray2.put(it.next());
            }
            return jSONArray2;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean b() {
        return this.f16559c;
    }

    public Set c(String str) {
        JSONObject jSONObject = this.a;
        if (jSONObject != null) {
            try {
                String strOptString = jSONObject.optString(str, null);
                if (!TextUtils.isEmpty(strOptString) && strOptString.length() > 3) {
                    HashSet hashSet = new HashSet();
                    JSONArray jSONArray = new JSONArray(strOptString);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        hashSet.add(Integer.valueOf(Integer.valueOf((String) jSONArray.get(i2), 16).intValue()));
                    }
                    return hashSet;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public JSONArray d(String str) {
        JSONObject jSONObject = this.a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            int i2 = 0;
            if (TextUtils.equals(str, "46")) {
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                JSONArray jSONArray2 = new JSONArray();
                while (i2 < jSONArray.length()) {
                    jSONArray2.put(jSONArray.getString(i2).replaceAll(" ", "").replace("\n", "").replace(">", ""));
                    i2++;
                }
                return jSONArray2;
            }
            if (!TextUtils.equals(str, "45")) {
                return null;
            }
            String strA = i.a("aae31bed33c490b6613a", "0701");
            String strA2 = i.a("99e111e83fc4d0a7662b", "0701");
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray3 = new JSONArray(string);
            HashSet hashSet = new HashSet();
            while (i2 < jSONArray3.length()) {
                hashSet.add(jSONArray3.getString(i2).replaceAll(" ", "").replace("\n", ""));
                i2++;
            }
            JSONArray jSONArray4 = new JSONArray();
            for (Object obj : hashSet) {
                jSONArray4.put(obj);
                String str2 = (String) obj;
                if (str2.contains(strA)) {
                    this.b = true;
                }
                if (str2.contains(strA2)) {
                    this.f16559c = true;
                }
            }
            return jSONArray4;
        } catch (Exception unused) {
            return null;
        }
    }
}
