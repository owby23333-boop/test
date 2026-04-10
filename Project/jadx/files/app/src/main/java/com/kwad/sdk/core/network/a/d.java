package com.kwad.sdk.core.network.a;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.r;
import java.util.Random;
import okhttp3.internal.Version;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements b {
    private static boolean agW = true;
    public static double agX = 1.0d;
    private static volatile boolean ahb = false;
    private static String ahc = "";
    private long agY = -1;
    private long agZ = -1;
    private long aha = -1;
    private k ahd = new k();

    public d() {
        agX = new Random().nextDouble();
    }

    private static boolean L(long j2) {
        return j2 != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public d K(long j2) {
        this.ahd.agv = j2;
        bZ("responseSize:" + j2);
        return this;
    }

    private d N(long j2) {
        this.ahd.agx = j2;
        bZ("totalCost:" + j2);
        return this;
    }

    private static boolean O(long j2) {
        return j2 >= 50;
    }

    private static j b(k kVar) {
        j jVar = new j();
        jVar.errorMsg = kVar.errorMsg;
        jVar.host = kVar.host;
        jVar.httpCode = kVar.httpCode;
        jVar.age = kVar.age;
        jVar.url = kVar.url;
        jVar.agf = kVar.agf;
        jVar.agg = kVar.agg;
        return jVar;
    }

    private static boolean b(@NonNull j jVar) {
        if (TextUtils.isEmpty(jVar.url)) {
            return true;
        }
        String lowerCase = jVar.url.toLowerCase();
        return lowerCase.contains("beta") || lowerCase.contains("test") || lowerCase.contains("staging");
    }

    private static void bZ(String str) {
        if (agW) {
            com.kwad.sdk.core.d.b.d("NetworkMonitorRecorder", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* JADX INFO: renamed from: bc, reason: merged with bridge method [inline-methods] */
    public d aY(int i2) {
        this.ahd.httpCode = i2;
        bZ("http_code:" + i2);
        return this;
    }

    private d bd(int i2) {
        this.ahd.agA = i2;
        bZ("hasData:" + i2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* JADX INFO: renamed from: be, reason: merged with bridge method [inline-methods] */
    public d ba(int i2) {
        this.ahd.result = i2;
        bZ("result:" + i2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* JADX INFO: renamed from: ca, reason: merged with bridge method [inline-methods] */
    public d bU(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.ahd.url = str;
        if (str.contains("?")) {
            String[] strArrSplit = str.split("\\?");
            if (strArrSplit.length > 0) {
                str = strArrSplit[0];
            }
        }
        if (!TextUtils.isEmpty(str)) {
            bZ("url:" + str);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* JADX INFO: renamed from: cb, reason: merged with bridge method [inline-methods] */
    public d bV(String str) {
        try {
            this.ahd.host = Uri.parse(str).getHost();
            bZ("host:" + this.ahd.host);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.e("NetworkMonitorRecorder", Log.getStackTraceString(e2));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* JADX INFO: renamed from: cc, reason: merged with bridge method [inline-methods] */
    public d bW(String str) {
        this.ahd.errorMsg = str;
        bZ(str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* JADX INFO: renamed from: cd, reason: merged with bridge method [inline-methods] */
    public d bX(String str) {
        this.ahd.age = str;
        bZ("reqType:" + str);
        cf(com.kwad.sdk.ip.direct.a.AO());
        wT();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* JADX INFO: renamed from: ce, reason: merged with bridge method [inline-methods] */
    public d bY(String str) {
        this.ahd.agz = str;
        bZ("requestId:" + str);
        return this;
    }

    private d cf(String str) {
        this.ahd.agC = str;
        return this;
    }

    private static String wL() {
        if (ahb) {
            return ahc;
        }
        try {
            try {
                ahc = Version.userAgent();
            } catch (Throwable unused) {
                ahc = (String) r.c((Class<?>) Version.class, TTDownloadField.TT_USERAGENT);
            }
        } catch (Exception unused2) {
        }
        ahb = true;
        return ahc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* JADX INFO: renamed from: wM, reason: merged with bridge method [inline-methods] */
    public d wD() {
        this.ahd.agp = SystemClock.elapsedRealtime();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* JADX INFO: renamed from: wN, reason: merged with bridge method [inline-methods] */
    public d wE() {
        this.agZ = SystemClock.elapsedRealtime();
        bZ("this.responseReceiveTime:" + this.agZ);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* JADX INFO: renamed from: wO, reason: merged with bridge method [inline-methods] */
    public d wF() {
        if (L(this.agY) && L(this.agZ)) {
            this.ahd.agw = this.agZ - this.agY;
            bZ("info.waiting_response_cost:" + this.ahd.agw);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* JADX INFO: renamed from: wP, reason: merged with bridge method [inline-methods] */
    public d wG() {
        if (L(this.ahd.agp)) {
            this.agY = SystemClock.elapsedRealtime();
            k kVar = this.ahd;
            kVar.agj = this.agY - kVar.agp;
            if (L(kVar.agh)) {
                k kVar2 = this.ahd;
                kVar2.agi = kVar2.agj - kVar2.agh;
            }
            bZ("info.request_create_cost:" + this.ahd.agj);
            bZ("info.requestAddParamsCost:" + this.ahd.agi);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* JADX INFO: renamed from: wQ, reason: merged with bridge method [inline-methods] */
    public d wI() {
        if (L(this.agZ)) {
            this.aha = SystemClock.elapsedRealtime();
            this.ahd.agu = this.aha - this.agZ;
            bZ("info.response_parse_cost:" + this.ahd.agu);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.a.b
    /* JADX INFO: renamed from: wR, reason: merged with bridge method [inline-methods] */
    public d wJ() {
        if (L(this.aha)) {
            this.ahd.agB = SystemClock.elapsedRealtime() - this.aha;
            wS();
            bZ("info.response_done_cost:" + this.ahd.agB);
        }
        return this;
    }

    private void wS() {
        k kVar = this.ahd;
        if (kVar == null || kVar.agA != 1 || O(kVar.agB)) {
            return;
        }
        this.ahd.agB = -1L;
    }

    private d wT() {
        this.ahd.agE = (int) com.kwad.sdk.ip.direct.a.AP();
        this.ahd.agF = (int) com.kwad.sdk.ip.direct.a.AQ();
        this.ahd.agG = (int) com.kwad.sdk.ip.direct.a.AR();
        return this;
    }

    private void wU() {
        j jVarB = b(this.ahd);
        l lVar = (l) ServiceProvider.get(l.class);
        if (lVar != null) {
            lVar.a(jVarB);
        }
        bZ("reportError" + jVarB.toString());
    }

    @Override // com.kwad.sdk.core.network.a.b
    public final /* synthetic */ b aZ(int i2) {
        return bd(1);
    }

    @Override // com.kwad.sdk.core.network.a.b
    public final b bb(int i2) {
        k kVar = this.ahd;
        kVar.agD = i2;
        if (i2 != 0) {
            kVar.agf = 1;
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.a.b
    public final void report() {
        if (b((j) this.ahd)) {
            return;
        }
        this.ahd.agg = wL();
        if (this.ahd.httpCode != 200) {
            wU();
            return;
        }
        long jElapsedRealtime = L(this.ahd.agp) ? SystemClock.elapsedRealtime() - this.ahd.agp : -1L;
        N(jElapsedRealtime);
        if (jElapsedRealtime > 30000 || jElapsedRealtime <= -1) {
            return;
        }
        l lVar = (l) ServiceProvider.get(l.class);
        if (lVar != null) {
            lVar.a(this.ahd);
        }
        bZ("report normal" + this.ahd.toString());
    }

    @Override // com.kwad.sdk.core.network.a.b
    public final b wH() {
        if (L(this.ahd.agp)) {
            this.ahd.agh = SystemClock.elapsedRealtime() - this.ahd.agp;
            bZ("info.request_prepare_cost:" + this.ahd.agh);
        }
        return this;
    }
}
