package com.kwad.components.ad.reward.l.b;

import android.content.Context;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.reward.l.a {
    private c Bd = new c();
    private C0302a Be = new C0302a();
    private final b Bf = new b(com.kwad.components.ad.reward.a.b.hB());

    public static void a(a aVar, Context context, AdTemplate adTemplate) {
        if (as.aq(context, com.kwad.sdk.core.response.b.a.ay(e.el(adTemplate)))) {
            aVar.kN();
        } else {
            aVar.kO();
        }
    }

    public final void kK() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markWatchVideoCompleted");
        this.Bd.kC();
        kM();
    }

    public final void kN() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markInstallCompleted");
        this.Be.kC();
        kM();
    }

    private void kO() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markInstallUncompleted");
        this.Be.kD();
        kM();
    }

    public final void kP() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markUseAppCompleted");
        this.Bf.kC();
        kM();
    }

    public final boolean kQ() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "isInstallCompleted");
        return this.Be.isCompleted();
    }

    public final boolean kL() {
        return this.Bd.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final int kB() {
        Iterator<com.kwad.components.ad.reward.l.c> it = kA().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!it.next().isCompleted()) {
                i++;
            }
        }
        return i;
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final List<com.kwad.components.ad.reward.l.c> kA() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.Bd);
        arrayList.add(this.Bf);
        return arrayList;
    }

    private void kM() {
        if (this.Bd.isCompleted() && this.Be.isCompleted() && this.Bf.isCompleted()) {
            kC();
        } else {
            kD();
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.c
    public final boolean isCompleted() {
        return this.Be.isCompleted() && this.Bf.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.a(jSONObject, "mWatchVideoTask", this.Bd);
        aa.a(jSONObject, "mInstallAppTask", this.Be);
        aa.a(jSONObject, "mUseAppTask", this.Bf);
        return jSONObject;
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        try {
            this.Bd.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.Bf.parseJson(jSONObject.optJSONObject("mUseAppTask"));
        } catch (Throwable unused) {
        }
    }

    static class c extends com.kwad.components.ad.reward.l.b {
        public c() {
            this.AZ = "基础奖励：观看视频";
            this.Ba = "基础奖励：需再观看%ss视频";
        }
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.reward.l.b.a$a, reason: collision with other inner class name */
    static class C0302a extends com.kwad.components.ad.reward.l.b {
        public C0302a() {
            this.AZ = "安装应用";
        }
    }

    static class b extends com.kwad.components.ad.reward.l.b {
        public b(int i) {
            this.AZ = String.format("进阶奖励：安装并激活APP %ss", new StringBuilder().append(i).toString());
            this.Ba = String.format("进阶奖励：安装并激活APP %ss", new StringBuilder().append(i).toString());
        }
    }
}
