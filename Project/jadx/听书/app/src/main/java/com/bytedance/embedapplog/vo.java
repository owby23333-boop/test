package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.umeng.analytics.pro.ar;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class vo extends sd {
    long fv;
    int i;
    private JSONObject io;
    private JSONArray iq;
    zz js;
    long ls;
    JSONArray p;
    JSONArray pf;
    long q;
    JSONArray tb;
    public int v;
    public byte[] wp;
    private u zw;

    @Override // com.bytedance.embedapplog.sd
    String a() {
        return "pack";
    }

    void z(JSONObject jSONObject, zz zzVar, u uVar, JSONArray jSONArray, JSONArray[] jSONArrayArr, long[] jArr, int i) {
        z(0L);
        this.io = jSONObject;
        this.js = zzVar;
        this.zw = uVar;
        this.iq = jSONArray;
        this.pf = jSONArrayArr[0];
        this.ls = jArr[0];
        this.p = jSONArrayArr[1];
        this.fv = jArr[1];
        this.tb = jSONArrayArr[2];
        this.q = jArr[2];
        this.uy = i;
    }

    @Override // com.bytedance.embedapplog.sd
    protected List<String> z() {
        return Arrays.asList(ar.d, "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "_data", "blob", "_fail", TypedValues.Custom.S_INT, "event_type", TypedValues.Custom.S_INT);
    }

    @Override // com.bytedance.embedapplog.sd
    public int z(Cursor cursor) {
        this.z = cursor.getLong(0);
        this.g = cursor.getLong(1);
        this.wp = cursor.getBlob(2);
        this.i = cursor.getInt(3);
        this.uy = cursor.getInt(4);
        this.f299a = "";
        this.io = null;
        this.js = null;
        this.zw = null;
        this.iq = null;
        this.pf = null;
        this.p = null;
        this.tb = null;
        return 5;
    }

    @Override // com.bytedance.embedapplog.sd
    protected void z(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.g));
        contentValues.put("_data", uy());
        contentValues.put("event_type", Integer.valueOf(this.uy));
    }

    public byte[] uy() {
        this.wp = null;
        try {
            byte[] bArrZ = s.z(m().toString());
            this.wp = bArrZ;
            return bArrZ;
        } catch (OutOfMemoryError e) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tf.dl.length; i++) {
                if (tf.dl[i] != null) {
                    sb.append(tf.dl[i].toString()).append(";");
                }
            }
            throw new RuntimeException(sb.toString(), e);
        }
    }

    @Override // com.bytedance.embedapplog.sd
    protected void z(JSONObject jSONObject) {
        cb.g((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.sd
    protected JSONObject g() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.io);
        jSONObject.put("time_sync", r.z);
        jSONObject.put("local_time", System.currentTimeMillis() / 1000);
        if (this.js != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.js.m());
            jSONObject.put("launch", jSONArray);
        }
        u uVar = this.zw;
        int i = 0;
        if (uVar != null) {
            JSONObject jSONObjectM = uVar.m();
            JSONArray jSONArray2 = this.iq;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            JSONArray jSONArray3 = new JSONArray();
            int i2 = 0;
            long j = 0;
            while (i2 < length) {
                JSONArray jSONArray4 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject(this.iq.optString(i2));
                JSONObject jSONObject3 = new JSONObject(jSONObject2.optString("params"));
                jSONArray4.put(i, jSONObject3.optString("page_key", ""));
                jSONArray4.put(1, (jSONObject3.optInt("duration", i) + 999) / 1000);
                jSONArray3.put(jSONArray4);
                int i3 = length;
                long jOptLong = jSONObject2.optLong("local_time_ms", 0L);
                if (jOptLong > j) {
                    jSONObjectM.put("$page_title", jSONObject3.optString("page_title", ""));
                    jSONObjectM.put("$page_key", jSONObject3.optString("page_key", ""));
                    j = jOptLong;
                }
                i2++;
                length = i3;
                i = 0;
            }
            if (length > 0) {
                jSONObjectM.put("activites", jSONArray3);
            }
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(jSONObjectM);
            jSONObject.put("terminate", jSONArray5);
        }
        JSONArray jSONArray6 = this.pf;
        int length2 = jSONArray6 != null ? jSONArray6.length() : 0;
        if (length2 > 0) {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.pf);
        }
        JSONArray jSONArray7 = this.iq;
        int length3 = jSONArray7 != null ? jSONArray7.length() : 0;
        JSONArray jSONArray8 = this.p;
        int length4 = jSONArray8 != null ? jSONArray8.length() : 0;
        if (length4 > 0) {
            jSONObject.put("event_v3", this.p);
        }
        JSONArray jSONArray9 = this.tb;
        int length5 = jSONArray9 != null ? jSONArray9.length() : 0;
        if (length5 > 0) {
            jSONObject.put("log_data", this.tb);
        }
        StringBuilder sb = new StringBuilder("pack {ts:");
        sb.append(this.g);
        StringBuilder sbAppend = sb.append(", la:");
        Object obj = this.js;
        if (obj == null) {
            obj = "0";
        }
        sbAppend.append(obj);
        StringBuilder sbAppend2 = sb.append(", te:");
        u uVar2 = this.zw;
        sbAppend2.append(uVar2 != null ? uVar2 : "0");
        sb.append(", p:").append(length3);
        sb.append(", v1:").append(length2);
        sb.append(", v3:").append(length4);
        sb.append(", m:").append(length5);
        cb.z(sb.toString());
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.sd
    protected sd g(JSONObject jSONObject) {
        cb.g((Throwable) null);
        return null;
    }

    @Override // com.bytedance.embedapplog.sd
    protected String gz() {
        return String.valueOf(this.z);
    }
}
