package com.kwad.components.ad.reward.i.kwai;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.i.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.reward.i.a {
    private b xK = new b();
    private final C0369a xL = new C0369a(d.uM());

    /* JADX INFO: renamed from: com.kwad.components.ad.reward.i.kwai.a$a, reason: collision with other inner class name */
    static class C0369a extends com.kwad.components.ad.reward.i.b {
        public C0369a(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            this.xI = String.format("进阶奖励：浏览详情页 %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i2);
            this.xJ = String.format("进阶奖励：浏览详情页 %ss", sb2.toString());
        }
    }

    static class b extends com.kwad.components.ad.reward.i.b {
        public b() {
            this.xI = "基础奖励：观看视频";
            this.xJ = "基础奖励：需再观看%ss视频";
        }
    }

    private void jP() {
        if (this.xL.isCompleted()) {
            jF();
        } else {
            jG();
        }
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.components.ad.reward.i.c
    public final boolean isCompleted() {
        return this.xL.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.i.a
    public final List<c> jD() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.xK);
        arrayList.add(this.xL);
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.i.a
    public final int jE() {
        Iterator<c> it = jD().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (!it.next().isCompleted()) {
                i2++;
            }
        }
        return i2;
    }

    public final void jN() {
        com.kwad.sdk.core.d.b.d("LandPageOpenTask", "markWatchVideoCompleted");
        this.xK.jF();
        jP();
    }

    public final boolean jO() {
        return this.xK.isCompleted();
    }

    public final void markOpenNsCompleted() {
        com.kwad.sdk.core.d.b.d("LandPageOpenTask", "markOpenNsCompleted");
        this.xL.jF();
        jP();
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.xK.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.xL.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        s.a(jSONObject, "mWatchVideoTask", this.xK);
        s.a(jSONObject, "mOpenNsTask", this.xL);
        return jSONObject;
    }
}
