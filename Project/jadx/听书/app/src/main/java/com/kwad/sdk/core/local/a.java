package com.kwad.sdk.core.local;

import android.content.Context;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.request.model.f;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static volatile a aDZ;
    public static ThreadLocal<SimpleDateFormat> aEa = new ThreadLocal<SimpleDateFormat>() { // from class: com.kwad.sdk.core.local.a.1
        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ SimpleDateFormat initialValue() {
            return Hv();
        }

        private static SimpleDateFormat Hv() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static a Hq() {
        if (aDZ == null) {
            synchronized (a.class) {
                if (aDZ == null) {
                    aDZ = new a();
                }
            }
        }
        return aDZ;
    }

    public static boolean Hr() {
        List<f> listDw = dw(15);
        if (listDw.size() == 0) {
            return true;
        }
        long j = -1;
        int i = 0;
        for (f fVar : listDw) {
            i += fVar.count;
            if (fVar.aIK > j) {
                j = fVar.aIK;
            }
        }
        c.d("AdCounter", "onBind localCountCheck: allCount: " + i + ", lastShowTime: " + j);
        if (i > Ht()) {
            return false;
        }
        return j + (Hu() * 1000) <= System.currentTimeMillis();
    }

    public static void ch(AdTemplate adTemplate) {
        if (adTemplate.watched) {
            c.d("AdCounter", "startWatchAd this ad has been watched.");
        } else {
            ci(adTemplate);
        }
    }

    public static List<f> Hs() {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return null;
        }
        String string = getString("ksadsdk_local_ad_task_info_adstyle_data");
        ArrayList<f> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
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

    private static List<f> dw(int i) {
        ArrayList arrayList = new ArrayList();
        List<f> listHs = Hs();
        if (listHs != null && listHs.size() != 0) {
            for (f fVar : listHs) {
                if (15 == fVar.adStyle) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    public static void e(int i, long j) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putInt("reward_aggregation_max_per_day", i).putLong("reward_aggregation_min_interval", j).apply();
    }

    private static int Ht() {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 30;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getInt("reward_aggregation_max_per_day", 30);
    }

    private static long Hu() {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 1200L;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getLong("reward_aggregation_min_interval", 1200L);
    }

    private static boolean a(f fVar) {
        long j = fVar.aIK;
        if (j <= 0) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = aEa.get();
        return simpleDateFormat.format(new Date(j)).equals(simpleDateFormat.format(new Date()));
    }

    private static void ci(AdTemplate adTemplate) {
        boolean z;
        int iEt = e.et(adTemplate);
        int iEf = e.ef(adTemplate);
        List listHs = Hs();
        if (listHs == null || listHs.size() == 0) {
            listHs = new ArrayList();
            listHs.add(new f(iEf, iEt, 1, System.currentTimeMillis()));
        } else {
            Iterator it = listHs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                f fVar = (f) it.next();
                if (fVar.adStyle == iEf && fVar.taskType == iEt) {
                    fVar.count++;
                    if (!a(fVar)) {
                        fVar.count = 1;
                        fVar.aG(System.currentTimeMillis());
                    }
                    z = true;
                }
            }
            if (!z) {
                listHs.add(new f(iEf, iEt, 1, System.currentTimeMillis()));
            }
        }
        Q("ksadsdk_local_ad_task_info_adstyle_data", aa.S(listHs).toString());
        adTemplate.watched = true;
    }

    private static void Q(String str, String str2) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putString(str, str2).apply();
    }

    private static String getString(String str) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getString(str, null);
        } catch (Throwable th) {
            c.printStackTrace(th);
            return null;
        }
    }
}
