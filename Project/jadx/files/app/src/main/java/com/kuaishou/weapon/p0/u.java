package com.kuaishou.weapon.p0;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class u implements Runnable {
    public static final int a = 1;
    public static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16820c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16821d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16822e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f16823f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f16824g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f16825h = 4;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static long f16826o;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f16828j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private q f16829k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private t f16830l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private File f16831m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Cdo f16832n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f16833p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f16835r;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f16834q = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    List<Integer> f16827i = new ArrayList();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Map<Integer, a> f16836s = new HashMap();

    class a {
        int a;

        public a(int i2) {
            this.a = i2;
        }
    }

    public u(Context context, int i2, boolean z2) {
        this.f16833p = 0;
        this.f16835r = false;
        this.f16828j = context;
        this.f16829k = q.a(context);
        this.f16830l = t.a(context);
        this.f16832n = Cdo.a(context);
        this.f16831m = new File(context.getFilesDir(), ".tmp");
        this.f16833p = i2;
        this.f16835r = z2;
    }

    private void a(s sVar) {
        File file;
        Object obj;
        long length;
        Object obj2;
        try {
            if (!TextUtils.isEmpty(sVar.f16780j) && sVar.f16780j.length() >= 10) {
                if (!this.f16831m.exists()) {
                    this.f16831m.mkdir();
                }
                File file2 = new File(this.f16831m, sVar.a + "-" + sVar.f16774d + ".tmp");
                File file3 = new File(this.f16831m, sVar.a + "-" + sVar.f16774d + ".zip");
                boolean zA = l.a(this.f16828j).a(sVar.f16779i, file2);
                if (!zA) {
                    zA = l.a(this.f16828j).a(sVar.f16779i, file2);
                }
                if (zA) {
                    if (file3.exists()) {
                        file3.delete();
                    }
                    int iC = b.c(file2.getAbsolutePath(), file3.getAbsolutePath(), c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(com.anythink.expressad.foundation.g.a.bN), 2));
                    if (iC != 0) {
                        long length2 = file3.exists() ? file3.length() : -1L;
                        if (file3.exists()) {
                            file3.delete();
                        }
                        HashMap map = new HashMap();
                        file = file3;
                        map.put(com.anythink.core.c.e.a, cj.f16641p);
                        StringBuilder sb = new StringBuilder();
                        obj2 = com.anythink.core.c.e.a;
                        sb.append(sVar.a);
                        map.put("pk", sb.toString());
                        map.put("pv", sVar.f16774d);
                        map.put("m", sVar.f16780j);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(length2);
                        map.put("len", sb2.toString());
                        map.put("l", ExifInterface.GPS_DIRECTION_TRUE);
                        bg.a(this.f16828j, "1002001", map);
                        zA = false;
                    } else {
                        file = file3;
                        obj2 = com.anythink.core.c.e.a;
                    }
                    if (iC == 0 && file2.exists()) {
                        file2.delete();
                    }
                    obj = obj2;
                } else {
                    file = file3;
                    HashMap map2 = new HashMap();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(sVar.a);
                    map2.put("pk", sb3.toString());
                    map2.put("pv", sVar.f16774d);
                    map2.put("m", sVar.f16780j);
                    obj = com.anythink.core.c.e.a;
                    map2.put(obj, "download fail");
                    map2.put("l", ExifInterface.GPS_DIRECTION_TRUE);
                    bg.a(this.f16828j, "1002001", map2);
                    this.f16836s.put(Integer.valueOf(sVar.a), new a(3));
                }
                String strA = f.a(file);
                if (zA && sVar.f16780j.equals(strA)) {
                    dm.a(file.getAbsolutePath(), Boolean.TRUE);
                    sVar.f16775e = file.getAbsolutePath();
                    if (this.f16829k.a(sVar, (String) null, (String) null)) {
                        if (this.f16836s != null && !this.f16836s.containsKey(Integer.valueOf(sVar.a))) {
                            this.f16836s.put(Integer.valueOf(sVar.a), new a(1));
                        }
                        this.f16832n.a(Cdo.b, System.currentTimeMillis(), true);
                        return;
                    }
                    if (this.f16836s != null && !this.f16836s.containsKey(Integer.valueOf(sVar.a))) {
                        this.f16836s.put(Integer.valueOf(sVar.a), new a(4));
                    }
                    this.f16829k.a(sVar.a, sVar.f16774d, (PackageInfo) null);
                    return;
                }
                if (file2.exists()) {
                    length = file2.length();
                    file2.delete();
                } else {
                    length = -1;
                }
                this.f16829k.a(sVar.a, sVar.f16774d, (PackageInfo) null);
                HashMap map3 = new HashMap();
                map3.put(obj, cj.f16642q);
                map3.put("ret", zA ? "1" : "0");
                map3.put("am", sVar.f16780j);
                map3.put("acm", strA);
                map3.put("p", file.getAbsolutePath());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(length);
                map3.put("len", sb4.toString());
                map3.put("l", ExifInterface.GPS_DIRECTION_TRUE);
                bg.a(this.f16828j, "1002001", map3);
                return;
            }
            this.f16829k.a(sVar.a, sVar.f16774d, (PackageInfo) null);
        } catch (Throwable unused) {
            this.f16829k.a(sVar.a, sVar.f16774d, (PackageInfo) null);
        }
    }

    public JSONObject a() {
        try {
            String str = ct.a + ct.f16672g;
            String strA = cu.a(this.f16828j);
            if (!TextUtils.isEmpty(strA)) {
                str = str + "?" + strA;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObjectC = cu.c(this.f16828j);
            if (jSONObjectC != null) {
                jSONObject.put("data", new bm(this.f16828j).c(jSONObjectC.toString()));
            }
            l lVarA = l.a(this.f16828j);
            m mVar = new m(str, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            JSONObject jSONObject2 = new JSONObject(lVarA.a(mVar));
            int iOptInt = jSONObject2.optInt("result", 0);
            if (iOptInt != 1) {
                if (iOptInt != -7) {
                    return null;
                }
                Cdo.a(this.f16828j).a(Cdo.a, 1, false);
                return null;
            }
            String strA2 = new bm(this.f16828j).a(jSONObject2.getString("antispamPluginManageRsp"));
            if (TextUtils.isEmpty(strA2)) {
                if (this.f16834q == 0) {
                    this.f16834q = 8;
                }
                throw new NetworkErrorException("kuaishou risk pluginloader response is null");
            }
            JSONObject jSONObject3 = new JSONObject(strA2);
            if (jSONObject3.optInt("status", 0) == 1) {
                return jSONObject3.optJSONObject("plugin");
            }
            if (this.f16832n == null) {
                return null;
            }
            this.f16832n.a(Cdo.b, System.currentTimeMillis(), true);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<String> it;
        JSONObject jSONObject;
        boolean z2;
        String str;
        try {
            synchronized (u.class) {
                try {
                    if (this.f16833p == 1 || this.f16833p == 2 || this.f16833p == 4 || this.f16835r || System.currentTimeMillis() - f16826o >= 300000) {
                        this.f16830l.d();
                        f16826o = System.currentTimeMillis();
                        if ((System.currentTimeMillis() - this.f16832n.a(Cdo.b)) - (((long) this.f16832n.a(Cdo.f16709c, 6)) * 3600000) > 0) {
                            List<s> listA = this.f16830l.a();
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList<s> arrayList3 = new ArrayList();
                            ArrayList arrayList4 = new ArrayList();
                            JSONObject jSONObjectA = a();
                            if (jSONObjectA == null) {
                                throw new Exception("pluginJsonObject is null ");
                            }
                            boolean z3 = false;
                            try {
                                boolean zB = dl.b(this.f16828j);
                                Iterator<String> itKeys = jSONObjectA.keys();
                                HashSet hashSet = new HashSet();
                                boolean z4 = false;
                                while (itKeys.hasNext()) {
                                    String next = itKeys.next();
                                    if (zB && next.endsWith("64")) {
                                        if (next.length() > 3) {
                                            hashSet.add(next.substring(0, next.length() - 3));
                                            str = next.substring(0, next.length() - 3) + ".32";
                                            hashSet.add(str);
                                            z4 = true;
                                        } else {
                                            z4 = true;
                                        }
                                    } else if (zB || !next.endsWith("32")) {
                                        if (zB && next.endsWith("v8")) {
                                            if (next.length() > 3) {
                                                hashSet.add(next.substring(0, next.length() - 3));
                                                str = next.substring(0, next.length() - 3) + ".v7";
                                                hashSet.add(str);
                                                z4 = true;
                                            } else {
                                                z4 = true;
                                            }
                                        } else if (!zB && next.endsWith("v7")) {
                                            if (next.length() > 3) {
                                                hashSet.add(next.substring(0, next.length() - 3));
                                                hashSet.add(next.substring(0, next.length() - 3) + ".v8");
                                            }
                                            z4 = true;
                                        }
                                    } else if (next.length() > 3) {
                                        hashSet.add(next.substring(0, next.length() - 3));
                                        str = next.substring(0, next.length() - 3) + ".64";
                                        hashSet.add(str);
                                        z4 = true;
                                    } else {
                                        z4 = true;
                                    }
                                }
                                if (z4) {
                                    Iterator it2 = hashSet.iterator();
                                    while (it2.hasNext()) {
                                        jSONObjectA.remove((String) it2.next());
                                    }
                                }
                                z3 = z4;
                            } catch (Throwable unused) {
                            }
                            Iterator<String> itKeys2 = jSONObjectA.keys();
                            while (itKeys2.hasNext()) {
                                String next2 = itKeys2.next();
                                s sVarA = o.a(jSONObjectA.optJSONObject(next2));
                                if (sVarA != null) {
                                    if (z3 && !sVarA.f16795y && (next2.endsWith("32") || next2.endsWith("64") || next2.endsWith("v7") || next2.endsWith("v8"))) {
                                        sVarA.f16795y = true;
                                    }
                                    if (sVarA.f16792v) {
                                        arrayList4.add(next2);
                                    }
                                    if (!sVarA.f16795y) {
                                        arrayList3.add(sVarA);
                                    }
                                    int iIndexOf = listA.indexOf(sVarA);
                                    if (iIndexOf < 0 || !sVarA.f16795y) {
                                        it = itKeys2;
                                        jSONObject = jSONObjectA;
                                        z2 = z3;
                                        if (sVarA.f16795y) {
                                            arrayList2.add(sVarA);
                                        }
                                    } else {
                                        s sVar = listA.get(iIndexOf);
                                        if (dm.b(sVarA.f16774d, sVar.f16774d)) {
                                            if (sVarA.f16794x != sVar.f16794x) {
                                                this.f16830l.c(sVarA.a, sVarA.f16794x);
                                            }
                                            if (!this.f16830l.d(sVarA.a)) {
                                                arrayList2.add(sVarA);
                                            }
                                            it = itKeys2;
                                            jSONObject = jSONObjectA;
                                            z2 = z3;
                                        } else {
                                            jSONObject = jSONObjectA;
                                            z2 = z3;
                                            it = itKeys2;
                                            this.f16832n.a(Cdo.b, System.currentTimeMillis(), true);
                                            if (sVarA.f16794x != sVar.f16794x) {
                                                this.f16830l.c(sVarA.a, sVarA.f16794x);
                                            }
                                            arrayList.add(sVarA);
                                        }
                                        listA.remove(iIndexOf);
                                    }
                                    jSONObjectA = jSONObject;
                                    z3 = z2;
                                    itKeys2 = it;
                                }
                            }
                            for (s sVar2 : listA) {
                                if (!arrayList4.contains(sVar2.f16773c)) {
                                    if (this.f16827i != null) {
                                        this.f16827i.add(Integer.valueOf(sVar2.a));
                                    }
                                    this.f16829k.a(sVar2.f16773c);
                                }
                            }
                            for (s sVar3 : arrayList3) {
                                if (!arrayList4.contains(sVar3.f16773c)) {
                                    if (this.f16827i != null) {
                                        this.f16827i.add(Integer.valueOf(sVar3.a));
                                    }
                                    this.f16829k.a(sVar3.f16773c);
                                }
                            }
                            ArrayList<s> arrayList5 = new ArrayList();
                            if (arrayList2.size() != 0) {
                                arrayList5.addAll(arrayList2);
                            }
                            if (arrayList.size() != 0) {
                                arrayList5.addAll(arrayList);
                            }
                            for (s sVar4 : arrayList5) {
                                if (sVar4 != null) {
                                    if (arrayList.contains(sVar4)) {
                                        this.f16829k.a(sVar4.a, sVar4.f16774d, (PackageInfo) null);
                                    } else if (arrayList2.contains(sVar4)) {
                                        a(sVar4);
                                    }
                                }
                            }
                        } else {
                            this.f16829k.c();
                            this.f16830l.b();
                        }
                    }
                } finally {
                    WeaponHI.iD();
                }
            }
        } catch (Throwable unused2) {
            this.f16829k.c();
            this.f16830l.b();
        }
    }
}
