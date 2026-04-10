package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class bd implements NativeExceptionHandler {
    private final Context a;
    private final as b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final aa f18654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ac f18655d;

    public bd(Context context, aa aaVar, as asVar, ac acVar) {
        this.a = context;
        this.b = asVar;
        this.f18654c = aaVar;
        this.f18655d = acVar;
    }

    private static Map<String, String> a(String[] strArr) {
        HashMap map = new HashMap(strArr == null ? 1 : strArr.length);
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str = strArr[i2];
                if (str != null) {
                    al.a("Extra message[%d]: %s", Integer.valueOf(i2), str);
                    String[] strArrSplit = str.split("=");
                    if (strArrSplit.length == 2) {
                        map.put(strArrSplit[0], strArrSplit[1]);
                    } else {
                        al.d("bad extraMsg %s", str);
                    }
                }
            }
        } else {
            al.c("not found extraMsg", new Object[0]);
        }
        return map;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final boolean getAndUpdateAnrState() {
        if (ay.a() == null) {
            return false;
        }
        ay ayVarA = ay.a();
        if (ayVarA.a.get()) {
            al.c("anr is processing, return", new Object[0]);
            return false;
        }
        ActivityManager activityManager = ayVarA.b;
        if (!((z.a(activityManager) || az.a(activityManager, 0L) == null) ? false : true)) {
            al.c("proc is not in anr, wait next check", new Object[0]);
            return false;
        }
        if (ayVarA.a(System.currentTimeMillis())) {
            return false;
        }
        return ayVarA.a(true);
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException(int i2, int i3, long j2, long j3, String str, String str2, String str3, String str4, int i4, String str5, int i5, int i6, int i7, String str6, String str7) {
        al.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i2, i3, j2, j3, str, str2, str3, str4, i4, str5, i5, i6, i7, str6, str7, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x017d A[PHI: r4
  0x017d: PHI (r4v10 java.lang.String) = (r4v9 java.lang.String), (r4v14 java.lang.String) binds: [B:37:0x0153, B:41:0x0163] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a8 A[Catch: all -> 0x0225, TryCatch #1 {all -> 0x0225, blocks: (B:46:0x01a2, B:48:0x01a8, B:50:0x01b1), top: B:78:0x01a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b1 A[Catch: all -> 0x0225, TRY_LEAVE, TryCatch #1 {all -> 0x0225, blocks: (B:46:0x01a2, B:48:0x01a8, B:50:0x01b1), top: B:78:0x01a2 }] */
    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void handleNativeException2(int r28, int r29, long r30, long r32, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, int r38, java.lang.String r39, int r40, int r41, int r42, java.lang.String r43, java.lang.String r44, java.lang.String[] r45) {
        /*
            Method dump skipped, instruction units count: 565
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.bd.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final CrashDetailBean packageCrashDatas(String str, String str2, long j2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z2, boolean z3) {
        int i2;
        String str12;
        int iIndexOf;
        boolean zI = at.a().i();
        if (zI) {
            al.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.b = 1;
        crashDetailBean.f18431e = this.f18654c.g();
        aa aaVar = this.f18654c;
        crashDetailBean.f18432f = aaVar.f18483o;
        crashDetailBean.f18433g = aaVar.q();
        crashDetailBean.f18439m = this.f18654c.f();
        crashDetailBean.f18440n = str3;
        crashDetailBean.f18441o = zI ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.f18442p = str4;
        crashDetailBean.f18443q = str5 != null ? str5 : "";
        crashDetailBean.f18444r = j2;
        crashDetailBean.f18447u = ap.c(crashDetailBean.f18443q.getBytes());
        crashDetailBean.A = str;
        crashDetailBean.B = str2;
        crashDetailBean.L = this.f18654c.s();
        crashDetailBean.f18434h = this.f18654c.p();
        crashDetailBean.f18435i = this.f18654c.A();
        crashDetailBean.f18448v = str8;
        String dumpFilePath = NativeCrashHandler.getInstance() != null ? NativeCrashHandler.getDumpFilePath() : null;
        String strA = be.a(dumpFilePath, str8);
        if (!ap.a(strA)) {
            crashDetailBean.Z = strA;
        }
        crashDetailBean.aa = be.b(dumpFilePath);
        crashDetailBean.f18449w = be.a(str9, at.f18581f, at.f18585j, at.f18590o);
        crashDetailBean.f18450x = be.a(str10, at.f18581f, null, true);
        crashDetailBean.N = str7;
        crashDetailBean.O = str6;
        crashDetailBean.P = str11;
        crashDetailBean.F = this.f18654c.k();
        crashDetailBean.G = this.f18654c.j();
        crashDetailBean.H = this.f18654c.l();
        crashDetailBean.I = ab.b(this.a);
        crashDetailBean.J = ab.g();
        crashDetailBean.K = ab.h();
        if (z2) {
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.f18451y = ao.a();
            aa aaVar2 = this.f18654c;
            crashDetailBean.Q = aaVar2.a;
            crashDetailBean.R = aaVar2.a();
            crashDetailBean.f18452z = ap.a(this.f18654c.Q, at.f18583h);
            int iIndexOf2 = crashDetailBean.f18443q.indexOf("java:\n");
            if (iIndexOf2 > 0 && (i2 = iIndexOf2 + 6) < crashDetailBean.f18443q.length()) {
                String str13 = crashDetailBean.f18443q;
                String strSubstring = str13.substring(i2, str13.length() - 1);
                if (strSubstring.length() > 0 && crashDetailBean.f18452z.containsKey(crashDetailBean.B) && (iIndexOf = (str12 = crashDetailBean.f18452z.get(crashDetailBean.B)).indexOf(strSubstring)) > 0) {
                    String strSubstring2 = str12.substring(iIndexOf);
                    crashDetailBean.f18452z.put(crashDetailBean.B, strSubstring2);
                    crashDetailBean.f18443q = crashDetailBean.f18443q.substring(0, i2);
                    crashDetailBean.f18443q += strSubstring2;
                }
            }
            if (str == null) {
                crashDetailBean.A = this.f18654c.f18472d;
            }
            crashDetailBean.U = this.f18654c.z();
            aa aaVar3 = this.f18654c;
            crashDetailBean.V = aaVar3.f18492x;
            crashDetailBean.W = aaVar3.t();
            crashDetailBean.X = this.f18654c.y();
        } else {
            crashDetailBean.C = -1L;
            crashDetailBean.D = -1L;
            crashDetailBean.E = -1L;
            if (crashDetailBean.f18449w == null) {
                crashDetailBean.f18449w = "This crash occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.Q = -1L;
            crashDetailBean.U = -1;
            crashDetailBean.V = -1;
            crashDetailBean.W = map;
            crashDetailBean.X = this.f18654c.y();
            crashDetailBean.f18452z = null;
            if (str == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.f18451y = bArr;
            }
        }
        return crashDetailBean;
    }
}
