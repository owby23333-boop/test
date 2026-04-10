package com.duokan.login;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.duokan.login.ResultResponseAdapter;
import com.yuewen.oh3;

/* JADX INFO: loaded from: classes12.dex */
public class SendPhoneTicketCallbackAdapter extends ResultResponseAdapter {
    public static final int e = 305;
    public final oh3 d;

    public static class a extends ResultResponseAdapter.a implements oh3 {
        public a(ResultReceiver resultReceiver) {
            super(resultReceiver);
        }

        @Override // com.yuewen.oh3
        public void c(Bitmap bitmap, String str) {
            Bundle bundle = new Bundle(2);
            bundle.putParcelable("captCode", bitmap);
            bundle.putString("captIck", str);
            i().send(305, bundle);
        }
    }

    public SendPhoneTicketCallbackAdapter(Handler handler, oh3 oh3Var) {
        super(handler);
        this.d = oh3Var;
    }

    @Override // com.duokan.login.ResultResponseAdapter, android.os.ResultReceiver
    public void onReceiveResult(int i, Bundle bundle) {
        super.onReceiveResult(i, bundle);
        if (i != 305) {
            return;
        }
        this.d.c((Bitmap) bundle.getParcelable("captCode"), bundle.getString("captIck"));
    }
}
