package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CPUAggregationManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.NativeCPUAggregationData;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class aj extends bf {
    private CPUAggregationManager.CPUAggregationListener a;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f12828q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f12829r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f12830s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f12831t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int[] f12832u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private HashMap<String, Object> f12833v;

    public aj(Context context, String str) {
        super(context);
        this.f12832u = new int[]{1098};
        this.f12828q = str;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        if (this.f12898k == null) {
            this.f12899l = false;
            return;
        }
        this.f12899l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, "cpu_hot");
            this.f12898k.createProdHandler(jSONObject3);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu_hot");
            jSONObject.put("appsid", this.f12828q);
            jSONObject.put("pageIndex", this.f12830s);
            jSONObject.put("pageSize", this.f12829r);
            jSONObject.put("channels", this.f12832u);
            if (!TextUtils.isEmpty(this.f12828q)) {
                jSONObject.put("appid", this.f12828q);
            }
            jSONObject2.put("timeout", this.f12831t);
            jSONObject2 = j.a(this.f12833v);
            jSONObject2.put("listScene", TbsListener.ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f12898k.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, int i2) {
        super.b(str, i2);
        CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.a;
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onHotContentError(str, i2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void d() {
        CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.a;
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onExitLp();
        }
    }

    public void a(CPUAggregationManager.CPUAggregationListener cPUAggregationListener) {
        this.a = cPUAggregationListener;
    }

    public void a(int i2, int i3, HashMap<String, Object> map) {
        this.f12830s = i2;
        this.f12829r = i3;
        this.f12833v = map;
    }

    public void a(int i2) {
        this.f12831t = i2;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(IOAdEvent iOAdEvent) {
        if (this.a != null) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((List) iOAdEvent.getData().get("cpuHotList")).iterator();
                while (it.hasNext()) {
                    arrayList.add(new NativeCPUAggregationData(this.f12895h, it.next(), this.f12833v));
                }
                this.a.onHotContentLoaded(arrayList);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(int i2, String str) {
        super.a(i2, str);
        CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.a;
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onHotContentError(str, i2);
        }
    }
}
