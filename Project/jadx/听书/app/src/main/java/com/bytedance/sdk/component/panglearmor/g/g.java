package com.bytedance.sdk.component.panglearmor.g;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import com.kuaishou.weapon.p0.bi;
import com.umeng.analytics.pro.an;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static volatile g z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedList<JSONObject> f783a;
    private LinkedList<JSONObject> dl;
    private SharedPreferences g;
    private LinkedList<JSONObject> gc;
    private long m;

    public g() {
        this.g = null;
        this.dl = null;
        this.f783a = null;
        this.gc = null;
        this.m = 0L;
        this.g = SoftDecTool.getSharedPreferences("pithar");
        this.dl = dl("sp_angle");
        this.f783a = dl("sp_screen");
        this.gc = dl("sp_net");
        this.m = gc.z().dl() / gc.z().a();
    }

    public static g z() {
        if (z == null) {
            synchronized (g.class) {
                if (z == null) {
                    z = new g();
                }
            }
        }
        return z;
    }

    public LinkedList<JSONObject> z(String str) {
        if ("sp_angle".equals(str)) {
            return this.dl;
        }
        if ("sp_screen".equals(str)) {
            return this.f783a;
        }
        if ("sp_net".equals(str)) {
            return this.gc;
        }
        return null;
    }

    public void z(JSONObject jSONObject, String str) {
        LinkedList<JSONObject> linkedListZ = z(str);
        if (linkedListZ == null) {
            return;
        }
        linkedListZ.add(jSONObject);
        if (linkedListZ.size() > this.m) {
            linkedListZ.removeFirst();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jDl = jCurrentTimeMillis - gc.z().dl();
        Iterator<JSONObject> it = linkedListZ.iterator();
        JSONObject jSONObject2 = null;
        while (it.hasNext()) {
            JSONObject next = it.next();
            long jOptLong = next.optLong(an.aI, 0L);
            if (jOptLong < jDl) {
                it.remove();
                jSONObject2 = next;
            } else if (jOptLong > jCurrentTimeMillis) {
                it.remove();
            }
        }
        if (jSONObject2 != null && linkedListZ.size() < 2) {
            linkedListZ.addFirst(jSONObject2);
        }
        z(str, linkedListZ);
    }

    public synchronized void g(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ("android.intent.action.SCREEN_OFF".equals(str)) {
            LinkedList<JSONObject> linkedListZ = z("sp_screen");
            int iOptInt = 1;
            if (linkedListZ != null && linkedListZ.size() > 0) {
                JSONObject last = linkedListZ.getLast();
                if (last.optLong(an.aI, 0L) / bi.s == jCurrentTimeMillis / bi.s) {
                    iOptInt = 1 + last.optInt("val", 0);
                    linkedListZ.removeLast();
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(an.aI, jCurrentTimeMillis);
                jSONObject.put("val", iOptInt);
                z(jSONObject, "sp_screen");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void z(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iOptInt = i == 4 ? 1 : i > 0 ? 2 : 0;
        LinkedList<JSONObject> linkedListZ = z("sp_net");
        if (linkedListZ != null && linkedListZ.size() > 0) {
            JSONObject last = linkedListZ.getLast();
            if (last.optLong(an.aI, 0L) / bi.s == jCurrentTimeMillis / bi.s) {
                iOptInt |= last.optInt("val", 0);
                linkedListZ.removeLast();
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(an.aI, jCurrentTimeMillis);
            jSONObject.put("val", iOptInt);
            z(jSONObject, "sp_net");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private LinkedList<JSONObject> dl(String str) {
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        SharedPreferences sharedPreferences = this.g;
        if (sharedPreferences == null) {
            return linkedList;
        }
        String string = sharedPreferences.getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            for (String str2 : string.split("\\|")) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        linkedList.add(new JSONObject(str2));
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return linkedList;
    }

    public void z(String str, LinkedList<JSONObject> linkedList) {
        if (linkedList == null || this.g == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<JSONObject> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append("\\|");
        }
        SharedPreferences.Editor editorEdit = this.g.edit();
        editorEdit.putString(str, sb.toString());
        editorEdit.apply();
    }

    public LinkedList<JSONObject> z(long j) {
        if (j == 0) {
            return this.dl;
        }
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = null;
        for (JSONObject jSONObject2 : this.dl) {
            if (jCurrentTimeMillis - jSONObject2.optLong(an.aI, 0L) < j) {
                linkedList.add(jSONObject2);
            } else {
                jSONObject = jSONObject2;
            }
        }
        if (jSONObject != null && linkedList.size() < 2) {
            linkedList.addFirst(jSONObject);
        }
        return linkedList;
    }
}
