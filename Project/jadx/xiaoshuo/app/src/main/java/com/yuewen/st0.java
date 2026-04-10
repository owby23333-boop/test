package com.yuewen;

import com.duokan.download.domain.DownloadType;
import com.duokan.reader.ui.FlowChargingTransferChoice;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public abstract class st0 {
    public static final String d = "transfer_choice_at_data_plan";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f17622b;
    public FlowChargingTransferChoice c;

    public st0() {
        this.f17621a = "";
        this.f17622b = 0L;
        this.c = FlowChargingTransferChoice.Default;
    }

    public void a(JSONObject jSONObject) {
        try {
            jSONObject.put("download_type", b().toString());
            jSONObject.put("download_channel", this.f17621a.toString());
            jSONObject.put("file_length", this.f17622b);
            FlowChargingTransferChoice flowChargingTransferChoice = this.c;
            if (flowChargingTransferChoice == null) {
                flowChargingTransferChoice = FlowChargingTransferChoice.Default;
            }
            jSONObject.put(d, flowChargingTransferChoice.name());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public abstract DownloadType b();

    public abstract String c();

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        return jSONObject;
    }

    public String toString() {
        return d().toString();
    }

    public st0(JSONObject jSONObject) {
        this.f17621a = "";
        this.f17622b = 0L;
        FlowChargingTransferChoice flowChargingTransferChoice = FlowChargingTransferChoice.Default;
        this.c = flowChargingTransferChoice;
        this.f17621a = jSONObject.optString("download_channel");
        this.f17622b = jSONObject.optLong("file_length", 0L);
        FlowChargingTransferChoice flowChargingTransferChoiceValueOf = FlowChargingTransferChoice.valueOf(jSONObject.optString(d, flowChargingTransferChoice.name()));
        this.c = flowChargingTransferChoiceValueOf;
        if (flowChargingTransferChoiceValueOf == null) {
            this.c = flowChargingTransferChoice;
        }
    }
}
