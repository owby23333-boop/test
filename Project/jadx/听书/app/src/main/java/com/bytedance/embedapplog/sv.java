package com.bytedance.embedapplog;

import android.content.Context;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.umeng.analytics.pro.an;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class sv extends gp {
    private final Context gc;

    sv(Context context) {
        super(true, true);
        this.gc = context;
    }

    @Override // com.bytedance.embedapplog.gp
    protected boolean z(JSONObject jSONObject) throws JSONException {
        gb.z(jSONObject, "language", this.gc.getResources().getConfiguration().locale.getLanguage());
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            rawOffset = 12;
        }
        jSONObject.put(an.M, rawOffset);
        gb.z(jSONObject, TtmlNode.TAG_REGION, Locale.getDefault().getCountry());
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        gb.z(jSONObject, "tz_name", timeZone.getID());
        jSONObject.put("tz_offset", timeZone.getOffset(System.currentTimeMillis() / 1000));
        return true;
    }
}
