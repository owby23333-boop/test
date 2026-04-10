package com.yuewen;

import android.view.View;
import androidx.annotation.NonNull;
import com.duokan.slidelayout.State;

/* JADX INFO: loaded from: classes6.dex */
public class ns1 implements ms1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f14928a;

    public ns1(@NonNull View view) {
        this.f14928a = view;
    }

    @Override // com.yuewen.ms1
    @NonNull
    public View a() {
        return this.f14928a;
    }

    @Override // com.yuewen.ms1
    public void b(State state, State state2) {
    }
}
