package com.duokan.login;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.duokan.reader.services.LoginAccountInfo;
import com.yuewen.u63;

/* JADX INFO: loaded from: classes12.dex */
public class ReloginListenerAdapter extends ResultReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3755b = 17;
    public static final int c = 18;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u63 f3756a;

    public static class a implements u63 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ResultReceiver f3757a;

        public a(ResultReceiver resultReceiver) {
            this.f3757a = resultReceiver;
        }

        @Override // com.yuewen.u63
        public void a(LoginAccountInfo loginAccountInfo) {
            this.f3757a.send(17, loginAccountInfo.a());
        }

        @Override // com.yuewen.u63
        public void b(int i, String str) {
            Bundle bundle = new Bundle(2);
            bundle.putInt("code", i);
            bundle.putString("message", str);
            this.f3757a.send(18, bundle);
        }
    }

    public ReloginListenerAdapter(Handler handler, u63 u63Var) {
        super(handler);
        this.f3756a = u63Var;
    }

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i, Bundle bundle) {
        super.onReceiveResult(i, bundle);
        if (i == 17) {
            this.f3756a.a(new LoginAccountInfo(bundle));
        } else {
            if (i != 18) {
                return;
            }
            this.f3756a.b(bundle.getInt("code"), bundle.getString("message"));
        }
    }
}
