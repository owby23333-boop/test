package com.duokan.login;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.duokan.login.ResultResponseAdapter;
import com.iflytek.aikit.media.speech.SpeechConstant;
import com.yuewen.bk2;

/* JADX INFO: loaded from: classes12.dex */
public class PhoneTicketLoginCallbackAdapter extends ResultResponseAdapter {
    public static final int e = 337;
    public final bk2 d;

    public static class a extends ResultResponseAdapter.a implements bk2 {
        public a(ResultReceiver resultReceiver) {
            super(resultReceiver);
        }

        @Override // com.yuewen.bk2
        public void onNeedNotification(String str, String str2) {
            Bundle bundle = new Bundle(2);
            bundle.putString(SpeechConstant.IST_SESSION_ID, str);
            bundle.putString("url", str2);
            i().send(337, bundle);
        }

        @Override // com.yuewen.bk2
        public void onPhoneNumInvalid() {
        }

        @Override // com.yuewen.bk2
        public void onTicketOrTokenInvalid() {
        }

        @Override // com.yuewen.bk2
        public void onTzSignInvalid() {
        }
    }

    public PhoneTicketLoginCallbackAdapter(Handler handler, bk2 bk2Var) {
        super(handler);
        this.d = bk2Var;
    }

    @Override // com.duokan.login.ResultResponseAdapter, android.os.ResultReceiver
    public void onReceiveResult(int i, Bundle bundle) {
        super.onReceiveResult(i, bundle);
        if (i != 337) {
            return;
        }
        this.d.onNeedNotification(bundle.getString(SpeechConstant.IST_SESSION_ID), bundle.getString("url"));
    }
}
