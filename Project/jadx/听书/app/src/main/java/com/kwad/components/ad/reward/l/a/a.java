package com.kwad.components.ad.reward.l.a;

import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.reward.l.a {
    private b Bb = new b();
    private final C0301a Bc = new C0301a(e.FC());

    public final void kK() {
        c.d("LandPageOpenTask", "markWatchVideoCompleted");
        this.Bb.kC();
        kM();
    }

    public final void markOpenNsCompleted() {
        c.d("LandPageOpenTask", "markOpenNsCompleted");
        this.Bc.kC();
        kM();
    }

    public final boolean kL() {
        return this.Bb.isCompleted();
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
        arrayList.add(this.Bb);
        arrayList.add(this.Bc);
        return arrayList;
    }

    private void kM() {
        if (this.Bc.isCompleted()) {
            kC();
        } else {
            kD();
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.c
    public final boolean isCompleted() {
        return this.Bc.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.a(jSONObject, "mWatchVideoTask", this.Bb);
        aa.a(jSONObject, "mOpenNsTask", this.Bc);
        return jSONObject;
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        try {
            this.Bb.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.Bc.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable unused) {
        }
    }

    static class b extends com.kwad.components.ad.reward.l.b {
        public b() {
            this.AZ = "基础奖励：观看视频";
            this.Ba = "基础奖励：需再观看%ss视频";
        }
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.reward.l.a.a$a, reason: collision with other inner class name */
    static class C0301a extends com.kwad.components.ad.reward.l.b {
        public C0301a(int i) {
            this.AZ = String.format("进阶奖励：浏览详情页 %ss", new StringBuilder().append(i).toString());
            this.Ba = String.format("进阶奖励：浏览详情页 %ss", new StringBuilder().append(i).toString());
        }
    }
}
