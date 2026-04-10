package com.kwad.components.ad.reward.i.a;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.reward.i.a {
    private c xM = new c();
    private C0368a xN = new C0368a();
    private final b xO = new b(com.kwad.components.ad.reward.kwai.b.gQ());

    /* JADX INFO: renamed from: com.kwad.components.ad.reward.i.a.a$a, reason: collision with other inner class name */
    static class C0368a extends com.kwad.components.ad.reward.i.b {
        public C0368a() {
            this.xI = "安装应用";
        }
    }

    static class b extends com.kwad.components.ad.reward.i.b {
        public b(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            this.xI = String.format("进阶奖励：安装并激活APP %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i2);
            this.xJ = String.format("进阶奖励：安装并激活APP %ss", sb2.toString());
        }
    }

    static class c extends com.kwad.components.ad.reward.i.b {
        public c() {
            this.xI = "基础奖励：观看视频";
            this.xJ = "基础奖励：需再观看%ss视频";
        }
    }

    public static void a(a aVar, Context context, AdTemplate adTemplate) {
        if (aj.ah(context, com.kwad.sdk.core.response.a.a.ar(d.cb(adTemplate)))) {
            aVar.jQ();
        } else {
            aVar.jR();
        }
    }

    private void jP() {
        if (this.xM.isCompleted() && this.xN.isCompleted() && this.xO.isCompleted()) {
            jF();
        } else {
            jG();
        }
    }

    private void jR() {
        com.kwad.sdk.core.d.b.d("LaunchAppTask", "markInstallUncompleted");
        this.xN.jG();
        jP();
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.components.ad.reward.i.c
    public final boolean isCompleted() {
        return this.xN.isCompleted() && this.xO.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.i.a
    public final List<com.kwad.components.ad.reward.i.c> jD() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.xM);
        arrayList.add(this.xO);
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.i.a
    public final int jE() {
        Iterator<com.kwad.components.ad.reward.i.c> it = jD().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (!it.next().isCompleted()) {
                i2++;
            }
        }
        return i2;
    }

    public final void jN() {
        com.kwad.sdk.core.d.b.d("LaunchAppTask", "markWatchVideoCompleted");
        this.xM.jF();
        jP();
    }

    public final boolean jO() {
        return this.xM.isCompleted();
    }

    public final void jQ() {
        com.kwad.sdk.core.d.b.d("LaunchAppTask", "markInstallCompleted");
        this.xN.jF();
        jP();
    }

    public final void jS() {
        com.kwad.sdk.core.d.b.d("LaunchAppTask", "markUseAppCompleted");
        this.xO.jF();
        jP();
    }

    public final boolean jT() {
        com.kwad.sdk.core.d.b.d("LaunchAppTask", "isInstallCompleted");
        return this.xN.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.xM.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.xO.parseJson(jSONObject.optJSONObject("mUseAppTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        s.a(jSONObject, "mWatchVideoTask", this.xM);
        s.a(jSONObject, "mInstallAppTask", this.xN);
        s.a(jSONObject, "mUseAppTask", this.xO);
        return jSONObject;
    }
}
