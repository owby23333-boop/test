package com.bytedance.sdk.openadsdk.v;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.umeng.analytics.pro.an;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private WeakReference<gz> g;
    private Context z;
    private Map<String, z> dl = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SensorEventListener f1490a = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.v.m.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            gz gzVarA;
            if (sensorEvent.sensor.getType() != 1 || (gzVarA = m.this.a()) == null) {
                return;
            }
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f);
                jSONObject.put("y", f2);
                jSONObject.put(an.aD, f3);
                gzVarA.z("accelerometer_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener gc = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.v.m.12
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            gz gzVarA;
            if (sensorEvent.sensor.getType() != 4 || (gzVarA = m.this.a()) == null) {
                return;
            }
            float degrees = (float) Math.toDegrees(sensorEvent.values[0]);
            float degrees2 = (float) Math.toDegrees(sensorEvent.values[1]);
            float degrees3 = (float) Math.toDegrees(sensorEvent.values[2]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", degrees);
                jSONObject.put("y", degrees2);
                jSONObject.put(an.aD, degrees3);
                gzVarA.z("gyro_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener m = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.v.m.23
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            gz gzVarA;
            if (sensorEvent.sensor.getType() != 10 || (gzVarA = m.this.a()) == null) {
                return;
            }
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f);
                jSONObject.put("y", f2);
                jSONObject.put(an.aD, f3);
                gzVarA.z("accelerometer_grativityless_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    private SensorEventListener e = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.v.m.34
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                System.arraycopy(sensorEvent.values, 0, uy.g, 0, uy.g.length);
            } else if (sensorEvent.sensor.getType() == 2) {
                System.arraycopy(sensorEvent.values, 0, uy.dl, 0, uy.dl.length);
            }
            SensorManager.getRotationMatrix(uy.f1491a, null, uy.g, uy.dl);
            SensorManager.getOrientation(uy.f1491a, uy.gc);
            gz gzVarA = m.this.a();
            if (gzVarA == null) {
                return;
            }
            float f = uy.gc[0];
            float f2 = uy.gc[1];
            float f3 = uy.gc[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("alpha", f);
                jSONObject.put("beta", f2);
                jSONObject.put("gamma", f3);
                gzVarA.z("rotation_vector_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };

    interface z {
        JSONObject z(JSONObject jSONObject) throws Throwable;
    }

    public m(gz gzVar) {
        this.z = gzVar.getContext();
        this.g = new WeakReference<>(gzVar);
        dl();
    }

    public Set<String> z() {
        return this.dl.keySet();
    }

    private void dl() {
        this.dl.put("adInfo", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.45
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                if (gzVarA != null) {
                    JSONObject jSONObjectJs = gzVarA.js();
                    if (jSONObjectJs != null) {
                        jSONObjectJs.put("code", 1);
                        return jSONObjectJs;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", -1);
                return jSONObject3;
            }
        });
        this.dl.put("appInfo", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.56
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.5.1");
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = m.this.z().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put("supportList", jSONArray);
                gz gzVarA = m.this.a();
                if (gzVarA != null) {
                    jSONObject2.put("deviceId", gzVarA.m());
                    jSONObject2.put("netType", gzVarA.ls());
                    jSONObject2.put("innerAppName", gzVarA.dl());
                    jSONObject2.put("appName", gzVarA.a());
                    jSONObject2.put("appVersion", gzVarA.gc());
                    Map<String, String> mapZ = gzVarA.z();
                    for (String str : mapZ.keySet()) {
                        jSONObject2.put(str, mapZ.get(str));
                    }
                }
                return jSONObject2;
            }
        });
        this.dl.put("playableSDKInfo", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.61
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.5.1");
                jSONObject2.put(an.x, "android");
                return jSONObject2;
            }
        });
        this.dl.put("subscribe_app_ad", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.62
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.v.z zVarGc = m.this.gc();
                JSONObject jSONObject2 = new JSONObject();
                if (zVarGc == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("download_app_ad", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.63
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.v.z zVarGc = m.this.gc();
                JSONObject jSONObject2 = new JSONObject();
                if (zVarGc == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("isViewable", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.2
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                if (gzVarA == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("viewStatus", gzVarA.gz());
                return jSONObject3;
            }
        });
        this.dl.put("getVolume", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.3
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                if (gzVarA == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("endcard_mute", gzVarA.e());
                return jSONObject3;
            }
        });
        this.dl.put("getScreenSize", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.4
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                if (gzVarA == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectFv = gzVarA.fv();
                jSONObjectFv.put("code", 1);
                return jSONObjectFv;
            }
        });
        this.dl.put("start_accelerometer_observer", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.5
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        e.z("PlayableJsBridge", "invoke start_accelerometer_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                uy.z(m.this.z, m.this.f1490a, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("close_accelerometer_observer", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.6
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    uy.z(m.this.z, m.this.f1490a);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    e.z("PlayableJsBridge", "invoke close_accelerometer_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.dl.put("start_gyro_observer", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.7
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        e.z("PlayableJsBridge", "invoke start_gyro_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                uy.g(m.this.z, m.this.gc, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("close_gyro_observer", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.8
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    uy.z(m.this.z, m.this.gc);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    e.z("PlayableJsBridge", "invoke close_gyro_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.dl.put("start_accelerometer_grativityless_observer", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.9
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        e.z("PlayableJsBridge", "invoke start_accelerometer_grativityless_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                uy.dl(m.this.z, m.this.m, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("close_accelerometer_grativityless_observer", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.10
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    uy.z(m.this.z, m.this.m);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    e.z("PlayableJsBridge", "invoke close_accelerometer_grativityless_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.dl.put("start_rotation_vector_observer", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.11
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        e.z("PlayableJsBridge", "invoke start_rotation_vector_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                uy.a(m.this.z, m.this.e, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("close_rotation_vector_observer", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.13
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    uy.z(m.this.z, m.this.e);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    e.z("PlayableJsBridge", "invoke close_rotation_vector_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.dl.put("device_shake", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.14
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    uy.z(m.this.z, 300L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    e.z("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.dl.put("device_shake_short", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.15
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    uy.z(m.this.z, 150L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    e.z("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.dl.put("playable_style", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.16
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA != null) {
                    JSONObject jSONObjectG = gzVarA.g();
                    jSONObjectG.put("code", 1);
                    return jSONObjectG;
                }
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
        });
        this.dl.put("sendReward", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.17
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA != null) {
                    gzVarA.q();
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                }
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
        });
        this.dl.put("webview_time_track", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.18
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                return new JSONObject();
            }
        });
        this.dl.put("playable_event", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.19
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null || jSONObject == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                gzVarA.g(jSONObject.optString(NotificationCompat.CATEGORY_EVENT, null), jSONObject.optJSONObject("params"));
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("reportAd", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.20
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put(ILivePush.ClickType.CLOSE, new z() { // from class: com.bytedance.sdk.openadsdk.v.m.21
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("openAdLandPageLinks", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.22
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("get_viewport", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.24
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectTb = gzVarA.tb();
                jSONObjectTb.put("code", 1);
                return jSONObjectTb;
            }
        });
        this.dl.put("jssdk_load_finish", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.25
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                gzVarA.h();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_material_render_result", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.26
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                gzVarA.kb(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("detect_change_playable_click", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.27
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectFo = gzVarA.fo();
                jSONObjectFo.put("code", 1);
                return jSONObjectFo;
            }
        });
        this.dl.put("check_camera_permission", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.28
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectWp = gzVarA.wp();
                jSONObjectWp.put("code", 1);
                return jSONObjectWp;
            }
        });
        this.dl.put("check_external_storage", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.29
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectI = gzVarA.i();
                if (jSONObjectI.isNull("result")) {
                    jSONObjectI.put("code", -1);
                } else {
                    jSONObjectI.put("code", 1);
                }
                return jSONObjectI;
            }
        });
        this.dl.put("playable_open_camera", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.30
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                gzVarA.z(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_pick_photo", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.31
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                gzVarA.g(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_download_media_in_photos", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.32
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                gzVarA.dl(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_preventTouchEvent", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.33
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                gzVarA.a(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_settings_info", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.35
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectV = gzVarA.v();
                jSONObjectV.put("code", 1);
                return jSONObjectV;
            }
        });
        this.dl.put("playable_load_main_scene", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.36
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                gzVarA.iq();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_enter_section", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.37
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                gzVarA.m(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_end", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.38
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                gzVarA.zw();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_finish_play_playable", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.39
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                gzVarA.io();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_transfrom_module_show", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.40
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                gzVarA.uf();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_transfrom_module_change_color", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.41
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                gzVarA.sy();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_set_scroll_rect", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.42
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_click_area", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.43
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                gzVarA.e(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_real_play_start", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.44
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_material_first_frame_show", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.46
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                gzVarA.hh();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_stuck_check_pong", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.47
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                gzVarA.l();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_material_adnormal_mask", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.48
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                gzVarA.gz(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_long_press_panel", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.49
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_alpha_player_play", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.50
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_transfrom_module_highlight", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.51
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_send_click_event", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.52
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_query_media_permission_declare", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.53
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectFo = gzVarA.fo(jSONObject);
                jSONObjectFo.put("code", 1);
                return jSONObjectFo;
            }
        });
        this.dl.put("playable_query_media_permission_enable", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.54
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                gz gzVarA = m.this.a();
                JSONObject jSONObject2 = new JSONObject();
                if (gzVarA == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectUy = gzVarA.uy(jSONObject);
                jSONObjectUy.put("code", 1);
                return jSONObjectUy;
            }
        });
        this.dl.put("playable_apply_media_permission", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.55
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.v.z zVarGc = m.this.gc();
                JSONObject jSONObject2 = new JSONObject();
                if (zVarGc == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_start_kws", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.57
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.v.z zVarGc = m.this.gc();
                JSONObject jSONObject2 = new JSONObject();
                if (zVarGc == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_close_kws", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.58
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.v.z zVarGc = m.this.gc();
                JSONObject jSONObject2 = new JSONObject();
                if (zVarGc == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_video_preload_task_add", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.59
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.v.z zVarGc = m.this.gc();
                JSONObject jSONObject2 = new JSONObject();
                if (zVarGc == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.dl.put("playable_video_preload_task_cancel", new z() { // from class: com.bytedance.sdk.openadsdk.v.m.60
            @Override // com.bytedance.sdk.openadsdk.v.m.z
            public JSONObject z(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.v.z zVarGc = m.this.gc();
                JSONObject jSONObject2 = new JSONObject();
                if (zVarGc == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public gz a() {
        WeakReference<gz> weakReference = this.g;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.v.z gc() {
        gz gzVarA = a();
        if (gzVarA == null) {
            return null;
        }
        return gzVarA.p();
    }

    public JSONObject z(String str, JSONObject jSONObject) {
        try {
            z zVar = this.dl.get(str);
            if (zVar == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
            return zVar.z(jSONObject);
        } catch (Throwable th) {
            e.z("PlayableJsBridge", "invoke error", th);
            return null;
        }
    }

    public void g() {
        uy.z(this.z, this.f1490a);
        uy.z(this.z, this.gc);
        uy.z(this.z, this.m);
        uy.z(this.z, this.e);
    }
}
