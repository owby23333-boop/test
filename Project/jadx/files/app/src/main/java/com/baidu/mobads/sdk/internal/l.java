package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class l extends ad {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CpuChannelListManager.CpuChannelListListener f13152q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f13153r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f13154s;

    public l(Context context) {
        super(context);
    }

    public void a(CpuChannelListManager.CpuChannelListListener cpuChannelListListener) {
        this.f13152q = cpuChannelListListener;
    }

    public void a(String str, int i2) {
        this.f13153r = str;
        this.f13154s = i2;
    }

    @Override // com.baidu.mobads.sdk.internal.ad, com.baidu.mobads.sdk.internal.bf
    public void a() {
        if (this.f12898k == null) {
            this.f12899l = false;
            return;
        }
        this.f12899l = true;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, "cpu");
            this.f12898k.createProdHandler(jSONObject2);
            m mVar = new m(this);
            this.f12898k.addEventListener(w.an, mVar);
            this.f12898k.addEventListener(w.ao, mVar);
            jSONObject.put("appsid", this.f13153r);
            jSONObject.put("subChannelId", this.f13154s);
            jSONObject.put("event_type", "cpu_channelIds");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a(jSONObject);
    }
}
