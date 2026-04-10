package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static c f19006e = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f19007g = false;
    private String a = "EmergenceMsgPublisher";
    private String b = "tbs_emergence";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f19008c = "emergence_executed_ids";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f19009d = "emergence_ids";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Integer, a> f19010f = new ConcurrentHashMap();

    public interface a {
        void a(String str);
    }

    public static class b {
        public int a = -1;
        public int b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f19011c = "";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f19012d = -1;

        public String toString() {
            return "{seqId=" + this.a + ", code=" + this.b + ", extra='" + this.f19011c + "', expired=" + this.f19012d + '}';
        }
    }

    private c() {
    }

    public static c a() {
        if (f19006e == null) {
            f19006e = new c();
        }
        return f19006e;
    }

    private synchronized void a(Context context, b bVar, a aVar) {
        String[] strArrSplit;
        if (aVar != null) {
            a("Executed command: " + bVar.b + ", extra: " + bVar.f19011c);
            aVar.a(bVar.f19011c);
            SharedPreferences sharedPreferences = context.getSharedPreferences(this.b, 4);
            String string = sharedPreferences.getString(this.f19008c, "");
            HashSet hashSet = new HashSet();
            if (!TextUtils.isEmpty(string) && (strArrSplit = string.split(",")) != null && strArrSplit.length > 0) {
                try {
                    for (String str : strArrSplit) {
                        hashSet.add(Integer.valueOf(Integer.parseInt(str)));
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            hashSet.add(Integer.valueOf(bVar.a));
            StringBuilder sb = new StringBuilder();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                sb.append((Integer) it.next());
                sb.append(",");
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(this.f19008c, sb.toString());
            editorEdit.commit();
        }
    }

    private void a(String str) {
    }

    public synchronized Map<Integer, b> a(Context context) {
        String[] strArrSplit;
        HashMap map = new HashMap();
        SharedPreferences sharedPreferences = context.getSharedPreferences(this.b, 0);
        if (context == null) {
            a("Unexpected null context!");
            return map;
        }
        String string = sharedPreferences.getString(this.f19009d, "");
        if (TextUtils.isEmpty(string)) {
            a("Empty local emergence ids!");
            return map;
        }
        a("Local emergence ids: " + string);
        String[] strArrSplit2 = string.split(";");
        if (strArrSplit2 != null) {
            for (String str : strArrSplit2) {
                if (!TextUtils.isEmpty(str) && (strArrSplit = str.split(",")) != null && strArrSplit.length == 4) {
                    b bVar = new b();
                    try {
                        bVar.a = Integer.parseInt(strArrSplit[0]);
                        bVar.b = Integer.parseInt(strArrSplit[1]);
                        bVar.f19011c = String.valueOf(strArrSplit[2]);
                        bVar.f19012d = Long.parseLong(strArrSplit[3]);
                    } catch (Throwable unused) {
                    }
                    if (System.currentTimeMillis() < bVar.f19012d) {
                        map.put(Integer.valueOf(bVar.a), bVar);
                    }
                }
            }
        }
        String string2 = sharedPreferences.getString(this.f19008c, "");
        a("Executed ids: " + string2);
        String[] strArrSplit3 = string2.split(",");
        if (strArrSplit3 != null) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : strArrSplit3) {
                if (!TextUtils.isEmpty(str2)) {
                    int i2 = -1;
                    try {
                        i2 = Integer.parseInt(str2);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (i2 > 0) {
                        arrayList.add(Integer.valueOf(i2));
                    }
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                map.remove(arrayList.get(i3));
            }
        }
        return map;
    }

    public synchronized void a(Context context, Integer num, a aVar) {
        Map<Integer, b> mapA = a(context);
        Iterator<Integer> it = mapA.keySet().iterator();
        while (it.hasNext()) {
            b bVar = mapA.get(it.next());
            if (bVar == null) {
                a("Unexpected null command!");
            } else if (bVar.b == num.intValue()) {
                a(context, bVar, aVar);
                return;
            }
        }
        if (!f19007g) {
            this.f19010f.put(num, aVar);
            a("Emergence config did not arrived yet, code[" + num + "] has been suspended");
        }
    }

    public synchronized void b(Context context) {
        Map<Integer, b> mapA = a(context);
        a("On notify emergence, validate commands: " + mapA);
        f19007g = true;
        for (Integer num : this.f19010f.keySet()) {
            for (Integer num2 : mapA.keySet()) {
                if (mapA.get(num2).b == num.intValue()) {
                    a(context, mapA.get(num2), this.f19010f.get(num));
                }
            }
        }
        if (!this.f19010f.isEmpty()) {
            a("Emergency code[" + this.f19010f.keySet() + "] did not happen, clear suspended queries");
            this.f19010f.clear();
        }
    }
}
