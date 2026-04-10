package com.duokan.reader.ui.reading.payment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.yuewen.qg2;
import com.yuewen.st2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
class VipButtonParser implements qg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6234a;

    public VipButtonParser(Context context) {
        this.f6234a = context;
    }

    @Override // com.yuewen.qg2
    public View a(JSONObject jSONObject, ViewGroup viewGroup, int i) {
        return View.inflate(this.f6234a, st2.n.yf, viewGroup);
    }

    @Override // com.yuewen.qg2
    public String type() {
        return "vip_button";
    }
}
