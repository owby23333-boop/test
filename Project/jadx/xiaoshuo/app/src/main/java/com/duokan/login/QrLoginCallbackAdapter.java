package com.duokan.login;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.duokan.login.ResultResponseAdapter;
import com.yuewen.zq2;

/* JADX INFO: loaded from: classes12.dex */
public class QrLoginCallbackAdapter extends ResultResponseAdapter {
    public static final int e = 289;
    public static final int f = 290;
    public final zq2 d;

    public static class a extends ResultResponseAdapter.a implements zq2 {
        public a(ResultReceiver resultReceiver) {
            super(resultReceiver);
        }

        @Override // com.yuewen.zq2
        public void g() {
            i().send(290, null);
        }

        @Override // com.yuewen.zq2
        public void h(Bitmap bitmap) {
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("bitmap", bitmap);
            i().send(289, bundle);
        }
    }

    public QrLoginCallbackAdapter(Handler handler, zq2 zq2Var) {
        super(handler);
        this.d = zq2Var;
    }

    @Override // com.duokan.login.ResultResponseAdapter, android.os.ResultReceiver
    public void onReceiveResult(int i, Bundle bundle) {
        super.onReceiveResult(i, bundle);
        if (i == 289) {
            this.d.h((Bitmap) bundle.getParcelable("bitmap"));
        } else {
            if (i != 290) {
                return;
            }
            this.d.g();
        }
    }
}
