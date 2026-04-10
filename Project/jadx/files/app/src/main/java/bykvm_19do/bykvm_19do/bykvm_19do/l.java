package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class l extends e2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f730e;

    l(Context context) {
        super(false, false);
        this.f730e = context;
    }

    private boolean a() {
        h hVarK = a.k();
        if (hVarK != null) {
            return hVarK.A();
        }
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    protected boolean a(JSONObject jSONObject) throws Throwable {
        String string;
        String string2;
        l0.a("a.1", null);
        if (a()) {
            try {
                string = Settings.Secure.getString(this.f730e.getContentResolver(), "android_id");
            } catch (Exception e2) {
                l0.c("", e2);
                string = null;
            }
        } else {
            string = null;
        }
        if (!k2.a(string) || "9774d56d682e549c".equals(string)) {
            SharedPreferences sharedPreferences = this.f730e.getSharedPreferences("snssdk_openudid", 0);
            string2 = sharedPreferences.getString("openudid", null);
            if (!k2.a(string2)) {
                string2 = new BigInteger(64, new SecureRandom()).toString(16);
                if (string2.charAt(0) == '-') {
                    string2 = string2.substring(1);
                }
                int length = 13 - string2.length();
                if (length > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (length > 0) {
                        sb.append('F');
                        length--;
                    }
                    sb.append(string2);
                    string2 = sb.toString();
                }
                try {
                    string2 = a("openudid.dat", string2);
                } catch (Exception unused) {
                }
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString("openudid", string2);
                editorEdit.apply();
            }
        } else {
            string2 = string;
        }
        jSONObject.put("openudid", string2);
        return true;
    }
}
