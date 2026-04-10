package com.kwad.sdk.g.kwai;

import android.hardware.SensorEvent;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int sensorType = -1;
    public List<Float> axd = new ArrayList();
    public long timestamp = 0;

    public static e a(SensorEvent sensorEvent, long j2) {
        if (sensorEvent == null) {
            return null;
        }
        e eVar = new e();
        eVar.sensorType = sensorEvent.sensor.getType();
        eVar.timestamp = j2 / 1000;
        for (float f2 : sensorEvent.values) {
            eVar.axd.add(Float.valueOf(f2));
        }
        return eVar;
    }

    private void a(e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.sensorType = jSONObject.optInt("sensorType");
        eVar.timestamp = jSONObject.optLong("timestamp");
        super.afterToJson(jSONObject);
    }

    private static JSONObject b(e eVar, JSONObject jSONObject) {
        s.putValue(jSONObject, "sensorType", eVar.sensorType);
        s.putValue(jSONObject, "timestamp", eVar.timestamp);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public final void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        s.putValue(jSONObject, "values", this.axd);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObjectB = b(this, new JSONObject());
        afterToJson(jSONObjectB);
        return jSONObjectB;
    }
}
