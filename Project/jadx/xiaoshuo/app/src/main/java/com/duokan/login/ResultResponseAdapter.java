package com.duokan.login;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.yuewen.v83;

/* JADX INFO: loaded from: classes12.dex */
public class ResultResponseAdapter extends ResultReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3758b = 273;
    public static final int c = 274;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v83 f3759a;

    public static class a implements v83 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResultReceiver f3760a;

        public a(ResultReceiver resultReceiver) {
            this.f3760a = resultReceiver;
        }

        @Override // com.yuewen.v83
        public void a(int i, String str) {
            Bundle bundle = new Bundle(2);
            bundle.putInt("code", i);
            bundle.putString("message", str);
            this.f3760a.send(274, bundle);
        }

        @Override // com.yuewen.v83
        public void f(Bundle bundle) {
            this.f3760a.send(273, bundle);
        }

        public ResultReceiver i() {
            return this.f3760a;
        }
    }

    public ResultResponseAdapter(Handler handler) {
        super(handler);
    }

    public ResultResponseAdapter a(v83 v83Var) {
        this.f3759a = v83Var;
        return this;
    }

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i, Bundle bundle) {
        v83 v83Var;
        if (i != 273) {
            if (i == 274 && (v83Var = this.f3759a) != null) {
                v83Var.a(bundle.getInt("code"), bundle.getString("message"));
                return;
            }
            return;
        }
        v83 v83Var2 = this.f3759a;
        if (v83Var2 != null) {
            v83Var2.f(bundle);
        }
    }
}
