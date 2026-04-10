package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class az {
    private JSONObject a;

    public az(Context context, int i2) {
        if (Engine.loadSuccess) {
            try {
                String strPqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.f16628c).intValue(), 2, i2 < 10 ? 10 : i2, "");
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

    public Set a(Set set) {
        if (set != null) {
            try {
                if (set.size() > 0) {
                    HashSet hashSet = new HashSet();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (!a(set, str)) {
                            hashSet.add(str);
                        }
                    }
                    return hashSet;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public JSONObject a(String str, boolean z2) {
        if (this.a != null) {
            try {
                String strA = a(str);
                if (!TextUtils.isEmpty(strA) && strA.length() > 3) {
                    JSONObject jSONObject = new JSONObject(strA);
                    if (!z2) {
                        return jSONObject;
                    }
                    Iterator<String> itKeys = jSONObject.keys();
                    boolean z3 = false;
                    while (itKeys.hasNext()) {
                        if (jSONObject.getInt(itKeys.next()) == 1) {
                            z3 = true;
                        }
                    }
                    if (z3) {
                        return jSONObject;
                    }
                    return null;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public JSONObject a(JSONObject jSONObject) {
        try {
            String strA = i.a("da4c6c97b9", "0702");
            String strA2 = i.a("da4c709eb15f", "0702");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(strA);
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(strA2);
            JSONObject jSONObject2 = new JSONObject();
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() == 3) {
                jSONObject2.put("0", jSONArrayOptJSONArray.get(2));
            }
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() == 3) {
                jSONObject2.put("1", jSONArrayOptJSONArray2.get(2));
            }
            if (jSONObject2.length() > 0) {
                return jSONObject2;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean a(Set set, String str) {
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!str2.equals(str) && str2.contains(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public JSONObject b(String str) {
        if (this.a == null) {
            return null;
        }
        try {
            String strA = a(str);
            if (TextUtils.isEmpty(strA) || strA.length() <= 3) {
                return null;
            }
            return new JSONObject(strA);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray c(String str) {
        JSONObject jSONObject = this.a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 2) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                hashSet.add((String) jSONArray.get(i2));
            }
            Set setA = a(hashSet);
            if (setA == null || setA.size() <= 0) {
                return null;
            }
            return new JSONArray((Collection) setA);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d(String str) {
        if (this.a == null) {
            return null;
        }
        try {
            String strA = a(str);
            if (TextUtils.isEmpty(strA) || strA.length() <= 3) {
                return null;
            }
            return a(new JSONObject(strA));
        } catch (Exception unused) {
            return null;
        }
    }
}
