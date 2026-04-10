package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class m2 extends e2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f735e;

    m2(Context context) {
        super(true, true);
        this.f735e = context;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    protected boolean a(JSONObject jSONObject) throws JSONException {
        k2.a(jSONObject, "language", this.f735e.getResources().getConfiguration().locale.getLanguage());
        int rawOffset = TimeZone.getDefault().getRawOffset() / BaseConstants.Time.HOUR;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            rawOffset = 12;
        }
        jSONObject.put("timezone", rawOffset);
        k2.a(jSONObject, "region", Locale.getDefault().getCountry());
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        k2.a(jSONObject, "tz_name", timeZone.getID());
        jSONObject.put("tz_offset", timeZone.getOffset(System.currentTimeMillis() / 1000));
        return true;
    }
}
