package com.anythink.basead.d.c;

import android.content.Context;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ab;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.k;
import com.anythink.core.common.k.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static volatile c b;
    ConcurrentHashMap<String, ArrayList<String>> a = new ConcurrentHashMap<>();

    private c() {
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public final synchronized void a(Context context, String str, i iVar, k kVar) {
        if (iVar.d() == 3 && (kVar instanceof ab)) {
            if (((ab) kVar).X() <= 0) {
                return;
            }
            ab abVar = (ab) kVar;
            ArrayList<String> arrayList = this.a.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                try {
                    JSONArray jSONArray = new JSONArray(p.b(context, g.f6810z, str, ""));
                    if (jSONArray.length() > 0) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            arrayList.add(jSONArray.optString(i2));
                        }
                    }
                } catch (Exception unused) {
                }
                this.a.put(str, arrayList);
            }
            if (arrayList.size() >= abVar.X()) {
                arrayList.remove(arrayList.size() - 1);
            }
            arrayList.add(0, iVar.p());
            p.a(context, g.f6810z, str, new JSONArray((Collection) arrayList).toString());
        }
    }

    public final String[] a(Context context, String str) {
        ArrayList<String> arrayList = this.a.get(str);
        if (arrayList == null) {
            try {
                JSONArray jSONArray = new JSONArray(p.b(context, g.f6810z, str, ""));
                if (jSONArray.length() > 0) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        try {
                            arrayList2.add(jSONArray.optString(i2));
                        } catch (Exception unused) {
                        }
                    }
                    arrayList = arrayList2;
                }
            } catch (Exception unused2) {
            }
        }
        if (arrayList == null) {
            return null;
        }
        this.a.put(str, arrayList);
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    public static String a(String str, String str2) {
        return str + str2;
    }
}
