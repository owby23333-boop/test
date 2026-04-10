package com.kwad.sdk.core.config;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.item.e;
import com.kwad.sdk.core.config.item.f;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.m;
import com.kwad.sdk.core.config.item.p;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.x;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private static final AtomicBoolean adx = new AtomicBoolean(false);
    private static volatile SdkConfigData ady;

    public static boolean D(long j2) {
        return (j2 & c.abF.getValue().longValue()) != 0;
    }

    public static double a(f fVar) {
        Double dVj = (Double) b(fVar);
        if (dVj == null) {
            dVj = fVar.vj();
        }
        return dVj.doubleValue();
    }

    public static int a(k kVar) {
        Integer numVj = (Integer) b((com.kwad.sdk.core.config.item.b) kVar);
        if (numVj == null) {
            numVj = kVar.vj();
        }
        return numVj.intValue();
    }

    public static long a(m mVar) {
        Long lVj = (Long) b(mVar);
        if (lVj == null) {
            lVj = mVar.vj();
        }
        return lVj.longValue();
    }

    public static String a(p pVar) {
        String str = (String) b(pVar);
        return str != null ? str : pVar.vj();
    }

    public static JSONObject a(e eVar) {
        JSONObject jSONObject = (JSONObject) b(eVar);
        return jSONObject != null ? jSONObject : eVar.vj();
    }

    public static boolean a(com.kwad.sdk.core.config.item.d dVar) {
        Boolean boolVj = (Boolean) b(dVar);
        if (boolVj == null) {
            boolVj = dVar.vj();
        }
        return boolVj.booleanValue();
    }

    @WorkerThread
    public static synchronized void aR(Context context) {
        if (adx.get()) {
            return;
        }
        com.kwad.sdk.core.d.b.d("SdkConfigManager", "loadCache");
        c.init();
        ui();
        b.aQ(context);
        uG();
        adx.set(true);
    }

    private static <T> T b(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        if (isLoaded()) {
            return bVar.getValue();
        }
        final Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        b.a(context, bVar);
        g.execute(new av() { // from class: com.kwad.sdk.core.config.d.1
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                d.aR(context);
            }
        });
        return bVar.getValue();
    }

    public static boolean b(k kVar) {
        Integer num = (Integer) b((com.kwad.sdk.core.config.item.b) kVar);
        return num != null ? num.intValue() > 0 : kVar.vj().intValue() > 0;
    }

    public static void c(@NonNull SdkConfigData sdkConfigData) {
        synchronized (d.class) {
            ady = sdkConfigData;
        }
    }

    public static boolean gR() {
        return c.acS.getValue().booleanValue();
    }

    public static String getLogObiwanData() {
        return c.acX.getValue();
    }

    public static String getUserAgent() {
        return c.acG.getValue();
    }

    public static boolean isCanUseTk() {
        return a(c.acu);
    }

    public static boolean isLoaded() {
        return adx.get();
    }

    public static int sJ() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return c.abq.getValue().intValue();
    }

    public static boolean sK() {
        return false;
    }

    public static boolean sL() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return c.abu.getValue().intValue() == 1;
    }

    public static boolean sM() {
        return c.acf.getValue().intValue() == 1;
    }

    public static boolean sN() {
        return c.ach.getValue().intValue() == 1;
    }

    public static boolean sO() {
        return c.acg.getValue().intValue() == 1;
    }

    public static boolean sP() {
        return c.ace.getValue().intValue() == 1;
    }

    public static String sQ() {
        return c.acs.getImei();
    }

    public static String sR() {
        return c.acs.getOaid();
    }

    public static List<String> sS() {
        return c.abN.getValue();
    }

    public static boolean sT() {
        return c.acF.getValue().intValue() == 1;
    }

    public static boolean sU() {
        return c.acH.getValue().intValue() == 1;
    }

    public static boolean sW() {
        return c.adb.getValue().booleanValue();
    }

    public static boolean sX() {
        return c.adc.getValue().booleanValue();
    }

    public static int sY() {
        if (ady != null) {
            return ady.goodIdcThresholdMs;
        }
        return 200;
    }

    public static int sZ() {
        return c.ade.getValue().intValue();
    }

    public static boolean ta() {
        return c.adp.getValue().booleanValue();
    }

    public static double tb() {
        return c.acO.getValue().floatValue();
    }

    public static boolean tc() {
        return c.ads.getValue().booleanValue();
    }

    public static boolean uA() {
        return c.acr.getValue().booleanValue();
    }

    public static boolean uB() {
        return c.act.getValue().booleanValue();
    }

    public static boolean uC() {
        return !c.acw.getValue().booleanValue();
    }

    public static boolean uD() {
        return a(c.acv);
    }

    public static boolean uE() {
        return c.acy.getValue().intValue() == 1;
    }

    public static int uF() {
        return c.acz.getValue().intValue();
    }

    @NonNull
    public static SdkConfigData uG() {
        if (ady == null) {
            synchronized (d.class) {
                if (ady == null) {
                    ady = new SdkConfigData();
                    String strCk = x.ck(ServiceProvider.getContext());
                    if (TextUtils.isEmpty(strCk)) {
                        com.kwad.sdk.core.d.b.d("SdkConfigManager", "configCache is empty");
                    } else {
                        try {
                            ady.parseJson(new JSONObject(strCk));
                        } catch (JSONException e2) {
                            com.kwad.sdk.core.d.b.printStackTrace(e2);
                        }
                    }
                }
            }
        }
        return ady;
    }

    public static boolean uH() {
        return c.abA.getValue().intValue() == 1;
    }

    public static boolean uI() {
        return c.abB.getValue().intValue() == 1;
    }

    public static int uJ() {
        return c.abD.getValue().intValue();
    }

    public static boolean uK() {
        return c.abE.getValue().booleanValue();
    }

    public static boolean uL() {
        return c.ada.getValue().intValue() == 1;
    }

    public static int uM() {
        return c.abC.getValue().intValue();
    }

    public static int uN() {
        return c.acJ.getValue().intValue();
    }

    public static int uO() {
        return c.acI.getValue().intValue();
    }

    public static boolean uP() {
        return c.acK.getValue().intValue() == 1;
    }

    public static boolean uQ() {
        return c.acL.getValue().booleanValue();
    }

    public static float uR() {
        float fFloatValue = c.acM.getValue().floatValue();
        if (fFloatValue <= 0.0f || fFloatValue > 1.0f) {
            return 0.3f;
        }
        return fFloatValue;
    }

    public static float uS() {
        return c.acN.getValue().floatValue();
    }

    public static boolean uT() {
        return c.acP.getValue().booleanValue();
    }

    public static boolean uU() {
        return c.acT.getValue().intValue() > 0;
    }

    public static boolean uV() {
        return c.acZ.getValue().intValue() == 1;
    }

    public static long uW() {
        return c.acY.getValue().longValue();
    }

    public static boolean uX() {
        return c.add.vo();
    }

    public static com.kwad.sdk.core.network.idc.kwai.a uY() {
        return c.adf.getValue();
    }

    public static long uZ() {
        return c.adg.getValue().longValue();
    }

    public static boolean ug() {
        return c.aby.getValue().intValue() == 1;
    }

    public static int uh() {
        return c.abz.getValue().intValue();
    }

    private static void ui() {
        com.kwad.components.ad.c.a.init();
        com.kwad.components.ad.feed.kwai.a.init();
        com.kwad.components.ad.fullscreen.kwai.a.init();
        com.kwad.components.ad.interstitial.kwai.a.init();
        com.kwad.components.ad.reward.kwai.a.init();
        com.kwad.components.ad.splashscreen.a.a.init();
    }

    public static List<String> uj() {
        return c.abP.getValue();
    }

    public static String uk() {
        return c.abM.getValue();
    }

    @NonNull
    public static List<String> ul() {
        return c.abO.getValue();
    }

    public static int um() {
        return c.adk.getValue().intValue();
    }

    public static boolean un() {
        return c.abH.getValue().booleanValue();
    }

    public static String uo() {
        return c.abJ.getValue();
    }

    public static String up() {
        return c.abK.getValue();
    }

    public static boolean uq() {
        return c.abv.getValue().intValue() == 1;
    }

    public static int ur() {
        return c.abw.getValue().intValue();
    }

    public static boolean us() {
        return c.abx.getValue().intValue() == 1;
    }

    public static int ut() {
        return c.abW.getValue().intValue();
    }

    public static int uu() {
        return c.abX.getValue().intValue();
    }

    public static int uv() {
        return c.abY.getValue().intValue();
    }

    public static long uw() {
        return ((long) c.abZ.getValue().intValue()) * 60000;
    }

    public static boolean ux() {
        return c.aci.getValue().intValue() == 1;
    }

    public static boolean uy() {
        return c.acj.getValue().intValue() == 1;
    }

    public static int uz() {
        return c.acq.getValue().intValue();
    }

    public static int va() {
        return c.adh.getValue().intValue();
    }

    public static boolean vb() {
        return c.adi.getValue().floatValue() == 1.0f;
    }

    public static boolean vc() {
        return c.adj.vo();
    }

    public static boolean vd() {
        return c.adl.vo();
    }

    public static String ve() {
        return c.adm.getValue();
    }

    public static String vf() {
        return c.adn.getValue();
    }

    public static String vg() {
        return c.ado.getValue();
    }

    public static int vh() {
        return c.adr.getValue().intValue();
    }

    public static boolean vi() {
        return c.adt.getValue().booleanValue();
    }
}
