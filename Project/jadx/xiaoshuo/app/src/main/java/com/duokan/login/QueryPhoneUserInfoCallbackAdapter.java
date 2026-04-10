package com.duokan.login;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.duokan.login.ResultResponseAdapter;
import com.xiaomi.onetrack.api.at;
import com.yuewen.wr2;

/* JADX INFO: loaded from: classes12.dex */
public class QueryPhoneUserInfoCallbackAdapter extends ResultResponseAdapter {
    public static final int e = 321;
    public static final int f = 322;
    public static final int g = 323;
    public final wr2 d;

    public static class a extends ResultResponseAdapter.a implements wr2 {
        public a(ResultReceiver resultReceiver) {
            super(resultReceiver);
        }

        public static Bundle j(String str, String str2) {
            Bundle bundle = new Bundle(2);
            bundle.putString(at.d, str);
            bundle.putString("token", str2);
            return bundle;
        }

        @Override // com.yuewen.wr2
        public void b(String str, String str2) {
            i().send(322, j(str, str2));
        }

        @Override // com.yuewen.wr2
        public void d(String str, String str2) {
            i().send(321, j(str, str2));
        }

        @Override // com.yuewen.wr2
        public void e(String str, String str2) {
            i().send(323, j(str, str2));
        }
    }

    public QueryPhoneUserInfoCallbackAdapter(Handler handler, wr2 wr2Var) {
        super(handler);
        this.d = wr2Var;
    }

    @Override // com.duokan.login.ResultResponseAdapter, android.os.ResultReceiver
    public void onReceiveResult(int i, Bundle bundle) {
        super.onReceiveResult(i, bundle);
        switch (i) {
            case 321:
                this.d.d(bundle.getString(at.d), bundle.getString("token"));
                break;
            case 322:
                this.d.b(bundle.getString(at.d), bundle.getString("token"));
                break;
            case 323:
                this.d.e(bundle.getString(at.d), bundle.getString("token"));
                break;
        }
    }
}
