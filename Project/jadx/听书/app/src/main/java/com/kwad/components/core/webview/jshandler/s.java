package com.kwad.components.core.webview.jshandler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.text.TextUtils;
import com.kwad.sdk.utils.bi;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class s implements SensorEventListener, com.kwad.sdk.core.webview.c.a {
    private Map<Integer, com.kwad.sdk.core.webview.c.c> acz = new ConcurrentHashMap();

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerSensorListener";
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (!TextUtils.isEmpty(str)) {
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.acz.put(Integer.valueOf(aVar.type), cVar);
            a(aVar.type, aVar.acC, cVar);
            return;
        }
        cVar.onError(-1, "data is empty");
    }

    private void a(int i, int i2, final com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.utils.bi.Rx().a(i, i2, this, new bi.b() { // from class: com.kwad.components.core.webview.jshandler.s.1
            @Override // com.kwad.sdk.utils.bi.b
            public final void onFailed() {
                cVar.onError(-1, "sensor is not support");
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.utils.bi.Rx().a(this);
    }

    private void a(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 4) {
            type = 2;
        } else if (type == 10) {
            type = 1;
        }
        com.kwad.sdk.core.webview.c.c cVar = this.acz.get(Integer.valueOf(type));
        if (cVar != null) {
            ArrayList<Float> arrayList = new ArrayList<>();
            for (int i = 0; i < sensorEvent.values.length; i++) {
                arrayList.add(Float.valueOf(sensorEvent.values[i]));
            }
            a aVar = new a();
            aVar.acD = arrayList;
            aVar.timestamp = sensorEvent.timestamp;
            aVar.accuracy = sensorEvent.accuracy;
            cVar.a(aVar);
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        a(sensorEvent);
    }

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int acC;
        public ArrayList<Float> acD;
        public int accuracy;
        public long timestamp;
        public int type;

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            int i = this.type;
            if (i != 0) {
                com.kwad.sdk.utils.aa.putValue(jSONObject, "type", i);
            }
            int i2 = this.acC;
            if (i2 != 0) {
                com.kwad.sdk.utils.aa.putValue(jSONObject, com.umeng.analytics.pro.an.aU, i2);
            }
            long j = this.timestamp;
            if (j != 0) {
                com.kwad.sdk.utils.aa.putValue(jSONObject, UMCrash.SP_KEY_TIMESTAMP, j);
            }
            int i3 = this.accuracy;
            if (i3 != 0) {
                com.kwad.sdk.utils.aa.putValue(jSONObject, "accuracy", i3);
            }
            if (!this.acD.isEmpty()) {
                com.kwad.sdk.utils.aa.putValue(jSONObject, "values", this.acD);
            }
            return jSONObject;
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null || jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.acC = jSONObject.optInt(com.umeng.analytics.pro.an.aU);
            this.timestamp = jSONObject.optLong(UMCrash.SP_KEY_TIMESTAMP);
            this.accuracy = jSONObject.optInt("accuracy");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
            ArrayList<Float> arrayList = new ArrayList<>();
            if (jSONArrayOptJSONArray == null) {
                this.acD = arrayList;
                return;
            }
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                try {
                    Object obj = jSONArrayOptJSONArray.get(i);
                    if (obj != null) {
                        arrayList.add((Float) obj);
                    }
                } catch (Throwable unused) {
                }
            }
            this.acD = arrayList;
        }
    }
}
