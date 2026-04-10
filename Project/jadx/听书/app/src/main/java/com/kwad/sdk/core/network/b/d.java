package com.kwad.sdk.core.network.b;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.session.MediaController;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Random;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements b {
    private static boolean aFG = true;
    public static double aFH = 1.0d;
    private static volatile boolean aFL = false;
    private static String aFM = "";
    private long aFI = -1;
    private long aFJ = -1;
    private long aFK = -1;
    private j aFN = new j();

    private static boolean aA(long j) {
        return j != -1;
    }

    private static boolean aD(long j) {
        return j >= 50;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final /* synthetic */ b dy(int i) {
        return dC(1);
    }

    public d() {
        aFH = new Random().nextDouble();
    }

    private static void en(String str) {
        if (aFG) {
            com.kwad.sdk.core.d.c.d("NetworkMonitorRecorder", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: eo, reason: merged with bridge method [inline-methods] */
    public d ei(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.aFN.url = str;
        if (str.contains("?")) {
            String[] strArrSplit = str.split("\\?");
            if (strArrSplit.length > 0) {
                str = strArrSplit[0];
            }
        }
        if (!TextUtils.isEmpty(str)) {
            en("url:" + str);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: ep, reason: merged with bridge method [inline-methods] */
    public d ej(String str) {
        try {
            this.aFN.host = Uri.parse(str).getHost();
            en("host:" + this.aFN.host);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("NetworkMonitorRecorder", Log.getStackTraceString(e));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: dB, reason: merged with bridge method [inline-methods] */
    public d dx(int i) {
        this.aFN.httpCode = i;
        en("http_code:" + i);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: eq, reason: merged with bridge method [inline-methods] */
    public d ek(String str) {
        this.aFN.errorMsg = str;
        en(str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: er, reason: merged with bridge method [inline-methods] */
    public d el(String str) {
        this.aFN.aEH = str;
        en("reqType:" + str);
        et(com.kwad.sdk.ip.direct.a.Mw());
        Ic();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: HV, reason: merged with bridge method [inline-methods] */
    public d HN() {
        this.aFN.aER = SystemClock.elapsedRealtime();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: HW, reason: merged with bridge method [inline-methods] */
    public d HO() {
        this.aFJ = SystemClock.elapsedRealtime();
        en("this.responseReceiveTime:" + this.aFJ);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: aB, reason: merged with bridge method [inline-methods] */
    public d az(long j) {
        this.aFN.aEX = j;
        en("responseSize:" + j);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: HX, reason: merged with bridge method [inline-methods] */
    public d HP() {
        if (aA(this.aFI) && aA(this.aFJ)) {
            this.aFN.aEY = this.aFJ - this.aFI;
            en("info.waiting_response_cost:" + this.aFN.aEY);
        }
        return this;
    }

    private d aC(long j) {
        this.aFN.aEZ = j;
        en("totalCost:" + j);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: es, reason: merged with bridge method [inline-methods] */
    public d em(String str) {
        this.aFN.aFb = str;
        en("requestId:" + str);
        return this;
    }

    private d dC(int i) {
        this.aFN.aFc = i;
        en("hasData:" + i);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: dD, reason: merged with bridge method [inline-methods] */
    public d dz(int i) {
        this.aFN.result = i;
        en("result:" + i);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: HY, reason: merged with bridge method [inline-methods] */
    public d HQ() {
        if (aA(this.aFN.aER)) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.aFI = jElapsedRealtime;
            j jVar = this.aFN;
            jVar.aEL = jElapsedRealtime - jVar.aER;
            if (aA(this.aFN.aEJ)) {
                j jVar2 = this.aFN;
                jVar2.aEK = jVar2.aEL - this.aFN.aEJ;
            }
            en("info.request_create_cost:" + this.aFN.aEL);
            en("info.requestAddParamsCost:" + this.aFN.aEK);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b HR() {
        if (aA(this.aFN.aER)) {
            this.aFN.aEJ = SystemClock.elapsedRealtime() - this.aFN.aER;
            en("info.request_prepare_cost:" + this.aFN.aEJ);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: HZ, reason: merged with bridge method [inline-methods] */
    public d HS() {
        if (aA(this.aFJ)) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.aFK = jElapsedRealtime;
            this.aFN.aEW = jElapsedRealtime - this.aFJ;
            en("info.response_parse_cost:" + this.aFN.aEW);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: Ia, reason: merged with bridge method [inline-methods] */
    public d HT() {
        if (aA(this.aFK)) {
            this.aFN.aFd = SystemClock.elapsedRealtime() - this.aFK;
            Ib();
            en("info.response_done_cost:" + this.aFN.aFd);
        }
        return this;
    }

    private void Ib() {
        j jVar = this.aFN;
        if (jVar == null || jVar.aFc != 1 || aD(this.aFN.aFd)) {
            return;
        }
        this.aFN.aFd = -1L;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b dA(int i) {
        this.aFN.aFf = i;
        if (i != 0) {
            this.aFN.aEI = 1;
        }
        return this;
    }

    private d et(String str) {
        this.aFN.aFe = str;
        return this;
    }

    private d Ic() {
        this.aFN.aFg = (int) com.kwad.sdk.ip.direct.a.Mx();
        this.aFN.aFh = (int) com.kwad.sdk.ip.direct.a.My();
        this.aFN.aFi = (int) com.kwad.sdk.ip.direct.a.Mz();
        return this;
    }

    private static boolean c(i iVar) {
        if (TextUtils.isEmpty(iVar.url)) {
            return true;
        }
        String lowerCase = iVar.url.toLowerCase();
        return lowerCase.contains("beta") || lowerCase.contains("test") || lowerCase.contains("staging");
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final void report() {
        if (c((i) this.aFN)) {
            return;
        }
        if (this.aFN.httpCode != 200) {
            Id();
            return;
        }
        long jElapsedRealtime = aA(this.aFN.aER) ? SystemClock.elapsedRealtime() - this.aFN.aER : -1L;
        aC(jElapsedRealtime);
        if (jElapsedRealtime > MediaController.RELEASE_UNBIND_TIMEOUT_MS || jElapsedRealtime <= -1) {
            return;
        }
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(this.aFN);
        }
        en("report normal" + this.aFN.toString());
    }

    private void Id() {
        i iVarC = c(this.aFN);
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(iVarC);
        }
        com.kwad.sdk.core.d.c.d("NetworkMonitorRecorder", "reportError" + iVarC.toJson().toString());
    }

    private static i c(j jVar) {
        i iVar = new i();
        iVar.errorMsg = jVar.errorMsg;
        iVar.host = jVar.host;
        iVar.httpCode = jVar.httpCode;
        iVar.aEH = jVar.aEH;
        iVar.url = jVar.url;
        iVar.aEI = jVar.aEI;
        return iVar;
    }
}
