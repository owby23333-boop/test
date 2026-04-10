package com.anythink.core.common;

import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.e.ai;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static String a = "c";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile c f6999f;
    ConcurrentHashMap<String, Long> b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ConcurrentHashMap<String, Long> f7000c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Map<String, a> f7001d = new ConcurrentHashMap(5);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Map<String, Map<String, Long>> f7002e;

    public static class a {
        String a;
        long b;
    }

    private c() {
    }

    public static c a() {
        if (f6999f == null) {
            synchronized (c.class) {
                if (f6999f == null) {
                    f6999f = new c();
                }
            }
        }
        return f6999f;
    }

    public final boolean b(ai aiVar) {
        if (aiVar.l() == 7) {
            return false;
        }
        if (aiVar.I() == 0) {
            return false;
        }
        return (this.f7000c.get(aiVar.t()) != null ? this.f7000c.get(aiVar.t()).longValue() : 0L) + aiVar.I() >= System.currentTimeMillis();
    }

    private void b(String str, long j2) {
        this.f7000c.put(str, Long.valueOf(j2));
    }

    public final boolean a(ai aiVar) {
        if (aiVar.H() == 0) {
            return false;
        }
        return (this.b.get(aiVar.t()) != null ? this.b.get(aiVar.t()).longValue() : 0L) + aiVar.H() >= System.currentTimeMillis();
    }

    public final void a(String str, long j2) {
        this.b.put(str, Long.valueOf(j2));
    }

    public final void a(String str) {
        this.f7002e = new ConcurrentHashMap(3);
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                try {
                    String next = itKeys.next();
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                    HashMap map = new HashMap(3);
                    Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                    while (itKeys2.hasNext()) {
                        try {
                            String next2 = itKeys2.next();
                            map.put(next2, Long.valueOf(jSONObjectOptJSONObject.getLong(next2)));
                        } catch (Throwable unused) {
                        }
                    }
                    this.f7002e.put(next, map);
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
        }
    }

    public final void a(String str, long j2, AdError adError) {
        if (TextUtils.equals(adError.getCode(), ErrorCode.noADError)) {
            a aVar = this.f7001d.get(str);
            if (aVar == null) {
                aVar = new a();
            }
            aVar.a = adError.getPlatformCode();
            aVar.b = j2;
            this.f7001d.put(str, aVar);
        }
    }

    public final boolean a(int i2, com.anythink.core.c.d dVar, ai aiVar) {
        int i3;
        Long l2;
        if (this.f7002e == null) {
            return false;
        }
        List<Integer> listB = dVar.b();
        if (listB.size() == 0) {
            return false;
        }
        a aVar = this.f7001d.get(aiVar.t());
        if (aVar == null) {
            return false;
        }
        switch (i2) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                i3 = 3;
                break;
            case 2:
            default:
                i3 = 1;
                break;
            case 8:
                i3 = 2;
                break;
        }
        if (!listB.contains(Integer.valueOf(i3))) {
            StringBuilder sb = new StringBuilder("The current load mode is: ");
            sb.append(i3);
            sb.append(", no need to filter");
            return false;
        }
        Map<String, Long> map = this.f7002e.get(String.valueOf(aiVar.c()));
        return (map == null || (l2 = map.get(aVar.a)) == null || aVar.b + l2.longValue() < System.currentTimeMillis()) ? false : true;
    }
}
