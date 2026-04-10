package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Pair;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class aj implements Runnable {
    protected int a;
    protected long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long f18521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f18523e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f18524f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f18525g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final byte[] f18526h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final aa f18527i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ac f18528j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final af f18529k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ai f18530l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f18531m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ah f18532n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ah f18533o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f18534p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final String f18535q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Map<String, String> f18536r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f18537s;

    public aj(Context context, int i2, int i3, byte[] bArr, String str, String str2, ah ahVar, boolean z2) {
        this(context, i2, i3, bArr, str, str2, ahVar, 2, 30000, z2);
    }

    private static void a(String str) {
        al.e("[Upload] Failed to upload(%d): %s", 1, str);
    }

    public final void b(long j2) {
        this.f18521c += j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Pair pair;
        boolean zBooleanValue;
        try {
            this.a = 0;
            this.b = 0L;
            this.f18521c = 0L;
            String str = ab.c(this.f18524f) == null ? "network is not available" : (this.f18526h == null || this.f18526h.length == 0) ? "request package is empty!" : (this.f18524f == null || this.f18527i == null || this.f18528j == null || this.f18529k == null) ? "illegal access error" : this.f18528j.c() == null ? "illegal local strategy" : null;
            if (str != null) {
                a(false, 0, str);
                return;
            }
            byte[] bArrA = ap.a(this.f18526h);
            if (bArrA == null) {
                a(false, 0, "failed to zip request body");
                return;
            }
            HashMap map = new HashMap(10);
            map.put("tls", "1");
            map.put("prodId", this.f18527i.e());
            map.put("bundleId", this.f18527i.f18471c);
            map.put("appVer", this.f18527i.f18483o);
            if (this.f18536r != null) {
                map.putAll(this.f18536r);
            }
            map.put(com.taobao.agoo.a.a.b.JSON_CMD, Integer.toString(this.f18525g));
            map.put("platformId", Byte.toString((byte) 1));
            map.put("sdkVer", this.f18527i.f18476h);
            map.put("strategylastUpdateTime", Long.toString(this.f18528j.c().f18420o));
            this.f18530l.a(this.f18531m, System.currentTimeMillis());
            String str2 = this.f18534p;
            this.f18528j.c();
            String strB = str2;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i2 + 1;
                if (i2 >= this.f18522d) {
                    a(false, i3, "failed after many attempts");
                    return;
                }
                if (i4 > 1) {
                    al.d("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i4));
                    ap.b(this.f18523e);
                    if (i4 == this.f18522d) {
                        al.d("[Upload] Use the back-up url at the last time: %s", this.f18535q);
                        strB = this.f18535q;
                    }
                }
                al.c("[Upload] Send %d bytes", Integer.valueOf(bArrA.length));
                strB = b(strB);
                al.c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", strB, Integer.valueOf(this.f18525g), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                byte[] bArrA2 = this.f18529k.a(strB, bArrA, this, map);
                Map<String, String> map2 = this.f18529k.f18503c;
                Pair<Boolean, Boolean> pairA = a(bArrA2, map2);
                if (((Boolean) pairA.first).booleanValue()) {
                    Pair<Boolean, Boolean> pairA2 = a(map2);
                    if (((Boolean) pairA2.first).booleanValue()) {
                        byte[] bArrB = ap.b(bArrA2);
                        if (bArrB != null) {
                            bArrA2 = bArrB;
                        }
                        br brVarA = ae.a(bArrA2);
                        if (brVarA == null) {
                            a(false, 1, "failed to decode response package");
                            Boolean bool = Boolean.FALSE;
                            pair = new Pair(bool, bool);
                        } else {
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(brVarA.b);
                            objArr[1] = Integer.valueOf(brVarA.f18722c == null ? 0 : brVarA.f18722c.length);
                            al.c("[Upload] Response cmd is: %d, length of sBuffer is: %d", objArr);
                            if (a(brVarA, this.f18527i, this.f18528j)) {
                                a(true, 2, "successfully uploaded");
                                Boolean bool2 = Boolean.TRUE;
                                pair = new Pair(bool2, bool2);
                            } else {
                                a(false, 2, "failed to process response package");
                                Boolean bool3 = Boolean.FALSE;
                                pair = new Pair(bool3, bool3);
                            }
                        }
                        zBooleanValue = !((Boolean) pair.first).booleanValue() ? ((Boolean) pair.second).booleanValue() : false;
                    } else {
                        zBooleanValue = ((Boolean) pairA2.second).booleanValue();
                    }
                } else {
                    zBooleanValue = ((Boolean) pairA.second).booleanValue();
                }
                if (!zBooleanValue) {
                    return;
                }
                i2 = i4;
                i3 = 1;
            }
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public aj(Context context, int i2, int i3, byte[] bArr, String str, String str2, ah ahVar, int i4, int i5, boolean z2) {
        this.f18522d = 2;
        this.f18523e = 30000;
        this.f18534p = null;
        this.a = 0;
        this.b = 0L;
        this.f18521c = 0L;
        this.f18537s = false;
        this.f18524f = context;
        this.f18527i = aa.a(context);
        this.f18526h = bArr;
        this.f18528j = ac.a();
        if (af.a == null) {
            af.a = new af(context);
        }
        this.f18529k = af.a;
        this.f18530l = ai.a();
        this.f18531m = i2;
        this.f18534p = str;
        this.f18535q = str2;
        this.f18532n = ahVar;
        this.f18533o = this.f18530l.a;
        this.f18525g = i3;
        if (i4 > 0) {
            this.f18522d = i4;
        }
        if (i5 > 0) {
            this.f18523e = i5;
        }
        this.f18537s = z2;
        this.f18536r = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(boolean r5, int r6, java.lang.String r7) {
        /*
            r4 = this;
            int r0 = r4.f18525g
            r1 = 630(0x276, float:8.83E-43)
            if (r0 == r1) goto L1a
            r1 = 640(0x280, float:8.97E-43)
            if (r0 == r1) goto L17
            r1 = 830(0x33e, float:1.163E-42)
            if (r0 == r1) goto L1a
            r1 = 840(0x348, float:1.177E-42)
            if (r0 == r1) goto L17
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L1c
        L17:
            java.lang.String r0 = "userinfo"
            goto L1c
        L1a:
            java.lang.String r0 = "crash"
        L1c:
            r1 = 1
            r2 = 0
            if (r5 == 0) goto L2a
            java.lang.Object[] r6 = new java.lang.Object[r1]
            r6[r2] = r0
            java.lang.String r0 = "[Upload] Success: %s"
            com.tencent.bugly.proguard.al.a(r0, r6)
            goto L3d
        L2a:
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r3[r2] = r6
            r3[r1] = r0
            r6 = 2
            r3[r6] = r7
            java.lang.String r6 = "[Upload] Failed to upload(%d) %s: %s"
            com.tencent.bugly.proguard.al.e(r6, r3)
        L3d:
            long r0 = r4.b
            long r2 = r4.f18521c
            long r0 = r0 + r2
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 <= 0) goto L5d
            com.tencent.bugly.proguard.ai r6 = r4.f18530l
            boolean r0 = r4.f18537s
            long r0 = r6.a(r0)
            long r2 = r4.b
            long r0 = r0 + r2
            long r2 = r4.f18521c
            long r0 = r0 + r2
            com.tencent.bugly.proguard.ai r6 = r4.f18530l
            boolean r2 = r4.f18537s
            r6.a(r0, r2)
        L5d:
            com.tencent.bugly.proguard.ah r6 = r4.f18532n
            if (r6 == 0) goto L64
            r6.a(r5, r7)
        L64:
            com.tencent.bugly.proguard.ah r6 = r4.f18533o
            if (r6 == 0) goto L6b
            r6.a(r5, r7)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.aj.a(boolean, int, java.lang.String):void");
    }

    private static String b(String str) {
        if (ap.a(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            al.a(th);
            return str;
        }
    }

    private static boolean a(br brVar, aa aaVar, ac acVar) {
        if (brVar == null) {
            al.d("resp == null!", new Object[0]);
            return false;
        }
        byte b = brVar.a;
        if (b != 0) {
            al.e("resp result error %d", Byte.valueOf(b));
            return false;
        }
        try {
            if (!ap.a(brVar.f18726g) && !aa.b().i().equals(brVar.f18726g)) {
                w.a().a(ac.a, "device", brVar.f18726g.getBytes("UTF-8"), true);
                aaVar.d(brVar.f18726g);
            }
        } catch (Throwable th) {
            al.a(th);
        }
        aaVar.f18481m = brVar.f18724e;
        int i2 = brVar.b;
        if (i2 == 510) {
            byte[] bArr = brVar.f18722c;
            if (bArr == null) {
                al.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i2));
                return false;
            }
            bt btVar = (bt) ae.a(bArr, bt.class);
            if (btVar == null) {
                al.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(brVar.b));
                return false;
            }
            acVar.a(btVar);
        }
        return true;
    }

    private Pair<Boolean, Boolean> a(byte[] bArr, Map<String, String> map) {
        if (bArr == null) {
            a("Failed to upload for no response!");
            return new Pair<>(Boolean.FALSE, Boolean.TRUE);
        }
        al.c("[Upload] Received %d bytes", Integer.valueOf(bArr.length));
        if (bArr.length == 0) {
            a(false, 1, "response data from server is empty");
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    al.c("[Upload] HTTP headers from server: key = %s, value = %s", entry.getKey(), entry.getValue());
                }
            }
            Boolean bool = Boolean.FALSE;
            return new Pair<>(bool, bool);
        }
        Boolean bool2 = Boolean.TRUE;
        return new Pair<>(bool2, bool2);
    }

    public final void a(long j2) {
        this.a++;
        this.b += j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.util.Pair<java.lang.Boolean, java.lang.Boolean> a(java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.aj.a(java.util.Map):android.util.Pair");
    }
}
