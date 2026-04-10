package com.yuewen;

import android.graphics.RectF;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class lb3 extends pr0 {
    public float C;
    public RectF[] D;

    public lb3() {
        this.C = 1.0f;
        this.D = new RectF[0];
    }

    public static lb3 g(String str) {
        try {
            return new lb3(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.yuewen.pr0
    public boolean d() {
        return this.f16107a < 0 && this.f16108b < 0;
    }

    @Override // com.yuewen.pr0
    public JSONObject e() {
        JSONArray jSONArray;
        int i;
        JSONObject jSONObjectE = super.e();
        try {
            jSONObjectE.put("font_scale", this.C);
            jSONArray = new JSONArray();
            i = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (true) {
            if (i >= this.D.length) {
                break;
            }
            int i2 = i * 4;
            jSONArray.put(i2 + 0, r3[i].left);
            jSONArray.put(i2 + 1, this.D[i].top);
            jSONArray.put(i2 + 2, this.D[i].right);
            jSONArray.put(i2 + 3, this.D[i].bottom);
            i++;
            return jSONObjectE;
        }
        jSONObjectE.put("content_margins", jSONArray);
        return jSONObjectE;
    }

    @Override // com.yuewen.pr0
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        lb3 lb3Var = (lb3) obj;
        return Float.compare(this.C, lb3Var.C) == 0 && Arrays.equals(this.D, lb3Var.D);
    }

    public lb3(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.C = 1.0f;
        int i = 0;
        this.D = new RectF[0];
        this.C = (float) jSONObject.getDouble("font_scale");
        JSONArray jSONArray = jSONObject.getJSONArray("content_margins");
        this.D = new RectF[jSONArray.length() / 4];
        while (true) {
            RectF[] rectFArr = this.D;
            if (i >= rectFArr.length) {
                return;
            }
            int i2 = i * 4;
            rectFArr[i] = new RectF((float) jSONArray.getDouble(i2 + 0), (float) jSONArray.getDouble(i2 + 1), (float) jSONArray.getDouble(i2 + 2), (float) jSONArray.getDouble(i2 + 3));
            i++;
        }
    }

    public lb3(lb3 lb3Var) {
        super(lb3Var);
        this.C = 1.0f;
        this.D = new RectF[0];
        this.C = lb3Var.C;
        this.D = lb3Var.D;
    }
}
