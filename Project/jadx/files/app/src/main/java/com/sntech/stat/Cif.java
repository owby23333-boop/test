package com.sntech.stat;

import android.content.Context;
import com.sntech.net.DomainProvider;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import q.b;
import t0.d;

/* JADX INFO: renamed from: com.sntech.stat.if, reason: invalid class name */
/* JADX INFO: compiled from: SNCAttributionTask.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cif implements Runnable {

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public Context f128do;

    /* JADX INFO: renamed from: com.sntech.stat.if$do, reason: invalid class name */
    /* JADX INFO: compiled from: SNCAttributionTask.java */
    public class Cdo implements Callback {

        /* JADX INFO: renamed from: do, reason: not valid java name */
        public int f129do = 0;

        /* JADX INFO: renamed from: if, reason: not valid java name */
        public final /* synthetic */ OkHttpClient f130if;

        public Cdo(Cif cif, OkHttpClient okHttpClient) {
            this.f130if = okHttpClient;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException iOException) {
            boolean z2 = com.sntech.stat.Cdo.f125do;
            int i2 = this.f129do;
            this.f129do = i2 + 1;
            if (i2 >= 3 || call == null || call.request() == null) {
                return;
            }
            try {
                Thread.sleep(this.f129do * 5000);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            this.f130if.newCall(call.request().newBuilder().url(call.request().url()).build()).enqueue(this);
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            if (response != null) {
                response.code();
            }
            boolean z2 = com.sntech.stat.Cdo.f125do;
            if (response.isSuccessful()) {
                try {
                    "200".equals(new JSONObject(response.body().string()).optString("code"));
                } catch (JSONException unused) {
                    boolean z3 = com.sntech.stat.Cdo.f125do;
                }
            }
        }
    }

    public Cif(Context context) {
        this.f128do = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObjectA;
        d dVar;
        boolean z2 = com.sntech.stat.Cdo.f125do;
        JSONObject jSONObjectM146do = null;
        try {
            Context context = this.f128do;
            synchronized (d.class) {
                if (d.f21704e == null) {
                    d.f21704e = new d(context);
                }
                dVar = d.f21704e;
            }
            jSONObjectA = dVar.a();
        } catch (JSONException unused) {
            boolean z3 = com.sntech.stat.Cdo.f125do;
            jSONObjectA = null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (jSONObjectA != null) {
                jSONObject.put("attData", jSONObjectA);
            }
            jSONObjectM146do = Cfor.m146do(this.f128do, jSONObject);
        } catch (Exception unused2) {
            boolean z4 = com.sntech.stat.Cdo.f125do;
        }
        if (jSONObjectM146do != null) {
            RequestBody requestBodyCreate = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObjectM146do.toString());
            Request.Builder builder = new Request.Builder();
            String str = b.a;
            Request requestBuild = builder.url(DomainProvider.baseDeviceUrl() + "att").post(requestBodyCreate).build();
            OkHttpClient okHttpClientBuild = new OkHttpClient.Builder().build();
            okHttpClientBuild.newCall(requestBuild).enqueue(new Cdo(this, okHttpClientBuild));
        }
    }
}
