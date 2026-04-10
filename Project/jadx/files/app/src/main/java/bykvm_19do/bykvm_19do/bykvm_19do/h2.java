package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class h2 extends e2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f703e;

    h2(Context context) {
        super(false, false);
        this.f703e = context;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    protected boolean a(JSONObject jSONObject) throws Throwable {
        SharedPreferences sharedPreferences = this.f703e.getSharedPreferences("snssdk_openudid", 0);
        String string = sharedPreferences.getString("clientudid", null);
        if (!k2.a(string)) {
            try {
                string = a("clientudid.dat", UUID.randomUUID().toString());
            } catch (Exception unused) {
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("clientudid", string);
            editorEdit.apply();
        }
        jSONObject.put("clientudid", string);
        return true;
    }
}
