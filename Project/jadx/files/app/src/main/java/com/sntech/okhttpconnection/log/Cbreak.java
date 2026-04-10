package com.sntech.okhttpconnection.log;

import android.content.Context;
import android.util.Base64;
import anet.channel.entity.ConnType;
import com.sntech.okhttpconnection.log.Ccatch;
import com.sntech.okhttpconnection.log.Cif;
import com.taobao.accs.utl.BaseMonitor;
import java.io.IOException;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.sntech.okhttpconnection.log.break, reason: invalid class name */
/* JADX INFO: compiled from: WhiteListManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cbreak implements Callback {

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public final /* synthetic */ Ccatch.Cdo f93do;

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public final /* synthetic */ Context f94for;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public final /* synthetic */ String f95if;

    public Cbreak(Ccatch.Cdo cdo, String str, Context context) {
        this.f93do = cdo;
        this.f95if = str;
        this.f94for = context;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        Cdo.m119do();
        this.f93do.mo108do(new Ccatch.Cif(false, false, null, null, null));
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        if (response.isSuccessful()) {
            try {
                String str = new String(Cif.Cdo.m132do(Base64.decode(response.body().string(), 0), "x04VOtkJji86dsmn".getBytes(), "x04VOtkJji86dsmn".getBytes()));
                if (Cdo.m119do()) {
                    String str2 = "response: " + str;
                }
                JSONObject jSONObject = new JSONObject(str);
                boolean z2 = this.f95if.equals(jSONObject.optString("r")) && jSONObject.optInt(ConnType.PK_OPEN) == 1;
                boolean z3 = jSONObject.optInt("grey") == 1;
                Set setM111do = Ccatch.m111do(jSONObject.optJSONArray("whitelist"));
                Set setM111do2 = Ccatch.m111do(jSONObject.optJSONArray("blacklist"));
                String strOptString = jSONObject.optString("webSupportList");
                Cnew.m138do(this.f94for, jSONObject.optJSONArray(BaseMonitor.COUNT_POINT_DNS));
                Cdo.f110if.getSharedPreferences("sn_prefs_logs", 0).edit().putBoolean("risk_user", jSONObject.optBoolean("risk_user")).apply();
                String strOptString2 = jSONObject.optString("data");
                if (strOptString2 != null) {
                    Cdo.f107else = new JSONObject(strOptString2).optInt("printUrlLog", 0) == 1;
                }
                this.f93do.mo108do(new Ccatch.Cif(z2, z3, setM111do, setM111do2, strOptString));
                return;
            } catch (Exception unused) {
                Cdo.m119do();
            }
        }
        this.f93do.mo108do(new Ccatch.Cif(false, false, null, null, null));
    }
}
