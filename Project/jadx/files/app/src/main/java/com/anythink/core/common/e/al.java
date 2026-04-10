package com.anythink.core.common.e;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class al {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final String f7182e = "reqId";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final String f7183f = "reqDatetime";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final String f7184g = "fillOffers";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final String f7185h = "bidResps";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final String f7186i = "adSourceId";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final String f7187j = "price";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final String f7188k = "networkFirmId";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final String f7189l = "demandType";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final String f7190m = "tp_bid_id";
    String a;
    long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    List<a> f7191c = new ArrayList(3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    List<a> f7192d = new ArrayList(3);

    public static class a {
        public int a;
        public String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7193c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public double f7194d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f7195e;

        public a() {
        }

        public final synchronized JSONObject a() {
            JSONObject jSONObject;
            jSONObject = new JSONObject();
            try {
                jSONObject.put(al.f7186i, this.b);
                jSONObject.put(al.f7187j, this.f7194d);
                jSONObject.put(al.f7188k, this.f7193c);
                jSONObject.put(al.f7189l, this.a);
                jSONObject.put(al.f7190m, this.f7195e);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return jSONObject;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(com.anythink.core.common.e.ai r7) {
            /*
                r6 = this;
                r6.<init>()
                java.lang.String r0 = r7.t()
                r6.b = r0
                com.anythink.core.b.f r0 = com.anythink.core.b.f.a()
                com.anythink.core.common.e.m r0 = r0.a(r7)
                if (r0 == 0) goto L29
                boolean r1 = r7.aa()
                if (r1 == 0) goto L1e
                double r1 = r0.f7350o
                r6.f7194d = r1
                goto L2f
            L1e:
                boolean r1 = r7.j()
                if (r1 == 0) goto L2f
                double r1 = r0.price
                r6.f7194d = r1
                goto L2f
            L29:
                double r1 = r7.x()
                r6.f7194d = r1
            L2f:
                int r1 = r7.c()
                r6.f7193c = r1
                int r1 = r7.l()
                r2 = 1
                r3 = 2
                if (r1 == 0) goto L58
                if (r1 == r2) goto L55
                r4 = 3
                if (r1 == r3) goto L52
                r5 = 4
                if (r1 == r4) goto L4f
                if (r1 == r5) goto L55
                r4 = 7
                if (r1 == r4) goto L55
                r4 = 8
                if (r1 == r4) goto L58
                goto L5a
            L4f:
                r6.a = r5
                goto L5a
            L52:
                r6.a = r4
                goto L5a
            L55:
                r6.a = r3
                goto L5a
            L58:
                r6.a = r2
            L5a:
                r1 = 35
                int r7 = r7.c()
                if (r1 != r7) goto L64
                r6.a = r3
            L64:
                if (r0 == 0) goto L69
                java.lang.String r7 = r0.f7342g
                goto L6b
            L69:
                java.lang.String r7 = ""
            L6b:
                r6.f7195e = r7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.e.al.a.<init>(com.anythink.core.common.e.ai):void");
        }
    }

    private synchronized long c() {
        return this.b;
    }

    private synchronized JSONArray d() {
        return c(this.f7191c);
    }

    private synchronized JSONArray e() {
        return c(this.f7192d);
    }

    public final synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put(f7182e, this.a);
            jSONObject.put(f7183f, this.b);
            jSONObject.put(f7184g, d());
            jSONObject.put(f7185h, e());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public final synchronized void b(String str) {
        this.a = str;
    }

    private synchronized List<a> c(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    a aVar = new a();
                    JSONObject jSONObject = new JSONObject(jSONArray.optString(i2));
                    aVar.b = jSONObject.getString(f7186i);
                    aVar.f7194d = jSONObject.getDouble(f7187j);
                    aVar.f7193c = jSONObject.getInt(f7188k);
                    aVar.a = jSONObject.getInt(f7189l);
                    if (jSONObject.has(f7190m)) {
                        aVar.f7195e = jSONObject.getString(f7190m);
                    }
                    arrayList.add(aVar);
                }
                Collections.sort(arrayList, new Comparator<a>() { // from class: com.anythink.core.common.e.al.1
                    private static int a(a aVar2, a aVar3) {
                        double d2 = aVar2.f7194d;
                        double d3 = aVar3.f7194d;
                        if (d2 > d3) {
                            return -1;
                        }
                        return d2 == d3 ? 0 : 1;
                    }

                    @Override // java.util.Comparator
                    public final /* bridge */ /* synthetic */ int compare(a aVar2, a aVar3) {
                        double d2 = aVar2.f7194d;
                        double d3 = aVar3.f7194d;
                        if (d2 > d3) {
                            return -1;
                        }
                        return d2 == d3 ? 0 : 1;
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }

    private synchronized void b(List<a> list) {
        this.f7192d = list;
    }

    public final synchronized String b() {
        return this.a;
    }

    public final synchronized void b(a aVar) {
        a(this.f7192d, aVar);
    }

    public static al a(String str) {
        al alVar = new al();
        try {
            JSONObject jSONObject = new JSONObject(str);
            alVar.b(jSONObject.getString(f7182e));
            alVar.a(jSONObject.getLong(f7183f));
            alVar.a(alVar.c(jSONObject.getString(f7184g)));
            alVar.b(alVar.c(jSONObject.getString(f7185h)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return alVar;
    }

    public final synchronized void a(long j2) {
        this.b = j2;
    }

    private synchronized void a(List<a> list) {
        this.f7191c = list;
    }

    private synchronized JSONArray c(List<a> list) {
        JSONArray jSONArray;
        jSONArray = new JSONArray();
        if (list != null) {
            Iterator<a> it = list.iterator();
            while (it.hasNext()) {
                try {
                    jSONArray.put(it.next().a());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return jSONArray;
    }

    public final synchronized void a(a aVar) {
        a(this.f7191c, aVar);
    }

    private synchronized void a(List<a> list, a aVar) {
        if (aVar != null) {
            if (list.size() == 0) {
                list.add(aVar);
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    i2 = -1;
                    break;
                } else if (aVar.f7194d > list.get(i2).f7194d) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                list.add(i2, aVar);
                return;
            }
            list.add(aVar);
        }
    }
}
