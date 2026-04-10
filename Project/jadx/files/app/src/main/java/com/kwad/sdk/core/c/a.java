package com.kwad.sdk.core.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.request.model.f;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.s;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static SimpleDateFormat Kd = new SimpleDateFormat("yyyy-MM-dd");
    private static volatile a afz;

    private static boolean a(@NonNull f fVar) {
        long j2 = fVar.alj;
        if (j2 <= 0) {
            return false;
        }
        return Kd.format(new Date(j2)).equals(Kd.format(new Date()));
    }

    @NonNull
    private static List<f> aX(int i2) {
        ArrayList arrayList = new ArrayList();
        List<f> listWi = wi();
        if (listWi != null && listWi.size() != 0) {
            for (f fVar : listWi) {
                if (15 == fVar.adStyle) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    public static void ao(AdTemplate adTemplate) {
        if (adTemplate.watched) {
            b.d("AdCounter", "startWatchAd this ad has been watched.");
        } else {
            ap(adTemplate);
        }
    }

    private static void ap(AdTemplate adTemplate) {
        f fVar;
        int iCi = d.ci(adTemplate);
        int iBV = d.bV(adTemplate);
        List listWi = wi();
        if (listWi != null && listWi.size() != 0) {
            boolean z2 = false;
            Iterator it = listWi.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f fVar2 = (f) it.next();
                if (fVar2.adStyle == iBV && fVar2.taskType == iCi) {
                    fVar2.count++;
                    if (!a(fVar2)) {
                        fVar2.count = 1;
                        fVar2.S(System.currentTimeMillis());
                    }
                    z2 = true;
                }
            }
            if (!z2) {
                fVar = new f(iBV, iCi, 1, System.currentTimeMillis());
            }
            t("ksadsdk_local_ad_task_info_adstyle_data", s.E(listWi).toString());
            adTemplate.watched = true;
        }
        listWi = new ArrayList();
        fVar = new f(iBV, iCi, 1, System.currentTimeMillis());
        listWi.add(fVar);
        t("ksadsdk_local_ad_task_info_adstyle_data", s.E(listWi).toString());
        adTemplate.watched = true;
    }

    public static void b(int i2, long j2) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putInt("reward_aggregation_max_per_day", i2).putLong("reward_aggregation_min_interval", j2).apply();
    }

    private static String getString(String str) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getString(str, null);
    }

    private static void t(String str, String str2) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putString(str, str2).apply();
    }

    public static a wg() {
        if (afz == null) {
            synchronized (a.class) {
                if (afz == null) {
                    afz = new a();
                }
            }
        }
        return afz;
    }

    public static boolean wh() {
        List<f> listAX = aX(15);
        if (listAX.size() == 0) {
            return true;
        }
        long j2 = -1;
        int i2 = 0;
        for (f fVar : listAX) {
            i2 += fVar.count;
            long j3 = fVar.alj;
            if (j3 > j2) {
                j2 = j3;
            }
        }
        b.d("AdCounter", "onBind localCountCheck: allCount: " + i2 + ", lastShowTime: " + j2);
        if (i2 > wj()) {
            return false;
        }
        return j2 + (wk() * 1000) <= System.currentTimeMillis();
    }

    public static List<f> wi() {
        if (((e) ServiceProvider.get(e.class)).getContext() == null) {
            return null;
        }
        String string = getString("ksadsdk_local_ad_task_info_adstyle_data");
        ArrayList<f> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                f fVar = new f();
                fVar.parseJson(jSONObject);
                arrayList.add(fVar);
            }
        } catch (Exception unused) {
        }
        ArrayList arrayList2 = new ArrayList();
        for (f fVar2 : arrayList) {
            if (a(fVar2)) {
                arrayList2.add(fVar2);
            }
        }
        return arrayList2;
    }

    private static int wj() {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return 30;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getInt("reward_aggregation_max_per_day", 30);
    }

    private static long wk() {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return 1200L;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getLong("reward_aggregation_min_interval", 1200L);
    }
}
