package com.anythink.core.c;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.s;
import com.anythink.core.common.g.i;
import com.anythink.core.common.g.j;
import com.anythink.core.common.k.p;
import com.umeng.message.proguard.ad;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static final String a = "e";
    private static volatile e b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f6735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, d> f6736d = new ConcurrentHashMap<>();

    public interface a {
        void a(AdError adError);

        void a(d dVar);

        void b(d dVar);
    }

    private e(Context context) {
        this.f6735c = context;
    }

    private void b() {
        this.f6736d.clear();
    }

    private List<s> c(String str) {
        List<s> listE;
        if (this.f6736d == null) {
            return null;
        }
        ArrayList<d> arrayList = new ArrayList();
        arrayList.addAll(this.f6736d.values());
        ArrayList arrayList2 = new ArrayList();
        for (d dVar : arrayList) {
            if (TextUtils.equals(String.valueOf(dVar.X()), str) && (listE = dVar.E()) != null) {
                arrayList2.addAll(listE);
            }
        }
        return arrayList2;
    }

    public static e a(Context context) {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e(context);
                }
            }
        }
        return b;
    }

    private static void b(Context context, d dVar) {
        int iD = dVar.d();
        n.a().c(iD);
        p.a(context, g.f6799o, "r", iD);
    }

    public final d b(String str) {
        String strP = n.a().p();
        return this.f6736d.get(strP + str);
    }

    public final void a() {
        Context context = this.f6735c;
        if (context != null) {
            try {
                context.getSharedPreferences(g.A, 0).edit().clear().apply();
            } catch (Error | Exception unused) {
            }
        }
    }

    public final void a(Context context, String str, d dVar, String str2) {
        String strP = n.a().p();
        if (strP == null) {
            strP = "";
        }
        synchronized (this) {
            this.f6736d.put(strP + str, dVar);
        }
        if (dVar.h() == 1) {
            n.a().I();
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        p.a(context, g.f6799o, strP + str + "_PL_SY", str2);
    }

    public final d a(String str) {
        String strP = n.a().p();
        if (strP == null) {
            strP = "";
        }
        if (this.f6736d.containsKey(strP + str)) {
            return this.f6736d.get(strP + str);
        }
        String strB = p.b(this.f6735c, g.f6799o, strP + str + "_PL_SY", "");
        if (!TextUtils.isEmpty(strB)) {
            d dVarB = d.b(strB);
            if (dVarB != null) {
                this.f6736d.put(strP + str, dVarB);
            }
            return dVarB;
        }
        StringBuilder sb = new StringBuilder("no key[");
        sb.append(strP);
        sb.append(str);
        sb.append("]");
        return null;
    }

    public final void a(final d dVar, final String str, final String str2, final String str3, final Map<String, Object> map, final a aVar) {
        n.a().a(new Runnable() { // from class: com.anythink.core.c.e.1
            @Override // java.lang.Runnable
            public final void run() {
                d dVar2 = dVar;
                String strP = dVar2 != null ? dVar2.P() : null;
                Map<String, Object> mapD = n.a().d(str3);
                if (dVar == null) {
                    new j(e.this.f6735c, str, str2, str3, strP, mapD, map).a(0, new i() { // from class: com.anythink.core.c.e.1.3
                        @Override // com.anythink.core.common.g.i
                        public final void onLoadCanceled(int i2) {
                            a aVar2 = aVar;
                            if (aVar2 != null) {
                                aVar2.a(ErrorCode.getErrorCode(ErrorCode.exception, "", "by canceled"));
                            }
                        }

                        @Override // com.anythink.core.common.g.i
                        public final void onLoadError(int i2, String str4, AdError adError) {
                            if (ErrorCode.statuError.equals(adError.getCode()) && (ErrorCode.placementIdError.equals(adError.getPlatformCode()) || ErrorCode.appIdError.equals(adError.getPlatformCode()) || "10001".equals(adError.getPlatformCode()))) {
                                String str5 = str + str3 + str2;
                                StringBuilder sb = new StringBuilder("code: ");
                                sb.append(adError.getPlatformCode());
                                sb.append("msg: ");
                                sb.append(adError.getPlatformMSG());
                                sb.append(", key -> ");
                                sb.append(str5);
                                p.a(e.this.f6735c, g.A, str5, System.currentTimeMillis());
                                if (n.a().A()) {
                                    String str6 = "Please check these params in your code (AppId: " + str + ", AppKey: " + str2 + ", PlacementId: " + str3 + ad.f20406s;
                                }
                            }
                            a aVar2 = aVar;
                            if (aVar2 != null) {
                                aVar2.a(adError);
                            }
                        }

                        @Override // com.anythink.core.common.g.i
                        public final void onLoadFinish(int i2, Object obj) {
                            String string = (String) obj;
                            try {
                                JSONObject jSONObject = new JSONObject(string);
                                jSONObject.put("updateTime", System.currentTimeMillis());
                                string = jSONObject.toString();
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            d dVarB = d.b(string);
                            if (dVarB == null) {
                                a aVar2 = aVar;
                                if (aVar2 != null) {
                                    aVar2.a(ErrorCode.getErrorCode(ErrorCode.placeStrategyError, "", "Placement Service error."));
                                    return;
                                }
                                return;
                            }
                            e eVar = e.this;
                            Context context = eVar.f6735c;
                            String str4 = str3;
                            if (dVarB.Z() != 1) {
                                string = "";
                            }
                            eVar.a(context, str4, dVarB, string);
                            e.a(e.this.f6735c, dVarB);
                            if (dVarB.N() == 1) {
                                com.anythink.core.common.s.a().a(e.this.f6735c, str3);
                            }
                            a aVar3 = aVar;
                            if (aVar3 != null) {
                                aVar3.a(dVarB);
                            }
                        }

                        @Override // com.anythink.core.common.g.i
                        public final void onLoadStart(int i2) {
                        }
                    });
                    return;
                }
                if (!(!mapD.equals(r0.M())) && !dVar.ax() && !com.anythink.core.common.s.a().c(e.this.f6735c, str3)) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(dVar);
                        return;
                    }
                    return;
                }
                final boolean[] zArr = new boolean[1];
                long jY = dVar.Y();
                final CountDownTimer countDownTimer = new CountDownTimer(jY, jY) { // from class: com.anythink.core.c.e.1.1
                    @Override // android.os.CountDownTimer
                    public final void onFinish() {
                        zArr[0] = true;
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        a aVar3 = aVar;
                        if (aVar3 != null) {
                            aVar3.a(dVar);
                        }
                    }

                    @Override // android.os.CountDownTimer
                    public final void onTick(long j2) {
                    }
                };
                if (jY == 0) {
                    zArr[0] = true;
                    a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.a(dVar);
                    }
                } else {
                    countDownTimer.start();
                }
                new j(e.this.f6735c, str, str2, str3, strP, mapD, map).a(0, new i() { // from class: com.anythink.core.c.e.1.2
                    @Override // com.anythink.core.common.g.i
                    public final void onLoadCanceled(int i2) {
                        AnonymousClass1 anonymousClass1;
                        a aVar4;
                        if (zArr[0] || (aVar4 = aVar) == null) {
                            return;
                        }
                        aVar4.a(dVar);
                    }

                    @Override // com.anythink.core.common.g.i
                    public final void onLoadError(int i2, String str4, AdError adError) {
                        AnonymousClass1 anonymousClass1;
                        a aVar4;
                        if (ErrorCode.statuError.equals(adError.getCode()) && (ErrorCode.placementIdError.equals(adError.getPlatformCode()) || ErrorCode.appIdError.equals(adError.getPlatformCode()) || "10001".equals(adError.getPlatformCode()))) {
                            String str5 = str + str3 + str2;
                            StringBuilder sb = new StringBuilder("code: ");
                            sb.append(adError.getPlatformCode());
                            sb.append("msg: ");
                            sb.append(adError.getPlatformMSG());
                            sb.append(", key -> ");
                            sb.append(str5);
                            p.a(e.this.f6735c, g.A, str5, System.currentTimeMillis());
                        }
                        n.a().a(new Runnable() { // from class: com.anythink.core.c.e.1.2.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                CountDownTimer countDownTimer2 = countDownTimer;
                                if (countDownTimer2 != null) {
                                    countDownTimer2.cancel();
                                }
                            }
                        });
                        if (zArr[0] || (aVar4 = aVar) == null) {
                            return;
                        }
                        aVar4.a(dVar);
                    }

                    @Override // com.anythink.core.common.g.i
                    public final void onLoadFinish(int i2, Object obj) {
                        String string = (String) obj;
                        try {
                            JSONObject jSONObject = new JSONObject(string);
                            jSONObject.put("updateTime", System.currentTimeMillis());
                            string = jSONObject.toString();
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        d dVarB = d.b(string);
                        if (dVarB != null) {
                            e eVar = e.this;
                            Context context = eVar.f6735c;
                            String str4 = str3;
                            if (dVarB.Z() != 1) {
                                string = "";
                            }
                            eVar.a(context, str4, dVarB, string);
                            e.a(e.this.f6735c, dVarB);
                            if (dVarB.N() == 1) {
                                com.anythink.core.common.s.a().a(e.this.f6735c, str3);
                            }
                        }
                        n.a().a(new Runnable() { // from class: com.anythink.core.c.e.1.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                CountDownTimer countDownTimer2 = countDownTimer;
                                if (countDownTimer2 != null) {
                                    countDownTimer2.cancel();
                                }
                            }
                        });
                        if (zArr[0]) {
                            a aVar4 = aVar;
                            if (aVar4 == null || dVarB == null) {
                                return;
                            }
                            aVar4.b(dVarB);
                            return;
                        }
                        if (dVarB != null) {
                            a aVar5 = aVar;
                            if (aVar5 != null) {
                                aVar5.a(dVarB);
                                return;
                            }
                            return;
                        }
                        a aVar6 = aVar;
                        if (aVar6 != null) {
                            aVar6.a(ErrorCode.getErrorCode(ErrorCode.placeStrategyError, "", "Placement Service error."));
                        }
                    }

                    @Override // com.anythink.core.common.g.i
                    public final void onLoadStart(int i2) {
                    }
                });
            }
        });
    }

    static /* synthetic */ void a(Context context, d dVar) {
        int iD = dVar.d();
        n.a().c(iD);
        p.a(context, g.f6799o, "r", iD);
    }
}
