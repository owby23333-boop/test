package com.sn.android;

import android.content.Context;
import com.google.gson.Gson;
import com.sn.android.entity.InitConfig;
import com.sntech.net.DomainProvider;
import com.sntech.okhttpconnection.log.Cfor;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.sn.android.new, reason: invalid class name */
/* JADX INFO: compiled from: Initializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cnew {

    /* JADX INFO: renamed from: com.sn.android.new$if, reason: invalid class name */
    /* JADX INFO: compiled from: Initializer.java */
    public interface Cif {
        /* JADX INFO: renamed from: do, reason: not valid java name */
        void mo87do();

        /* JADX INFO: renamed from: do, reason: not valid java name */
        void mo88do(Exception exc);
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static void m86do(Context context, Cif cif) {
        if (n.a.a != null) {
            cif.mo87do();
            return;
        }
        com.sntech.net.Cif.m103if(DomainProvider.baseUrl() + "ic", Cfor.m127if(context), true, new Cdo(context, cif));
    }

    /* JADX INFO: renamed from: com.sn.android.new$do, reason: invalid class name */
    /* JADX INFO: compiled from: Initializer.java */
    public class Cdo implements com.sntech.net.Cdo {

        /* JADX INFO: renamed from: do, reason: not valid java name */
        public final /* synthetic */ Context f70do;

        /* JADX INFO: renamed from: if, reason: not valid java name */
        public final /* synthetic */ Cif f71if;

        public Cdo(Context context, Cif cif) {
            this.f70do = context;
            this.f71if = cif;
        }

        @Override // com.sntech.net.Cdo
        /* JADX INFO: renamed from: do */
        public void mo75do(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("data")) {
                    this.f70do.getSharedPreferences("prefs_sn_android", 0).edit().remove("init_config");
                    throw new Exception("no data");
                }
                e0.c.a(this.f70do, "init_config", jSONObject.getJSONObject("data").toString());
                n.a.a = (InitConfig) new Gson().fromJson(jSONObject.getJSONObject("data").toString(), InitConfig.class);
                this.f71if.mo87do();
            } catch (Exception e2) {
                this.f71if.mo88do(e2);
            }
        }

        @Override // com.sntech.net.Cdo
        /* JADX INFO: renamed from: do */
        public void mo74do(Exception exc) {
            InitConfig initConfig;
            String string = this.f70do.getSharedPreferences("prefs_sn_android", 0).getString("init_config", null);
            if (string != null) {
                try {
                    initConfig = (InitConfig) new Gson().fromJson(string, InitConfig.class);
                } catch (Exception unused) {
                    initConfig = null;
                }
            } else {
                initConfig = null;
            }
            if (initConfig != null) {
                n.a.a = initConfig;
            } else {
                this.f71if.mo88do(exc);
            }
        }
    }
}
