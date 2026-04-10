package com.amgcyo.cuttadon.sdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.main.MkMainActivity;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.api.presenter.ConfigPresenter;
import com.amgcyo.cuttadon.k.b.c;
import com.amgcyo.cuttadon.utils.otherutils.x0;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class OwnerSplashActivity extends MyBaseAdActivity<ConfigPresenter> implements c.InterfaceC0109c {
    public static void launch(Context context, int i2, boolean z2) {
        Intent intent = new Intent(context, (Class<?>) OwnerSplashActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean("needStartMainActivity", z2);
        bundle.putString("pos_id", "");
        bundle.putInt("durationTime", i2);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private void q() {
        if (this.f4254n0) {
            startActivity(new Intent(this, (Class<?>) MkMainActivity.class));
        }
        finish();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        if (message.f21197s != 888) {
            q();
            return;
        }
        NewApiAd newApiAd = (NewApiAd) message.f21202x;
        if (newApiAd == null) {
            q();
            return;
        }
        com.amgcyo.cuttadon.k.b.c cVar = new com.amgcyo.cuttadon.k.b.c(this);
        cVar.a(this, this.f4257q0, newApiAd, this, this.f4254n0);
        this.mSplashContainer.addView(cVar);
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyBaseAdActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        NewApiAd newApiAdA = com.amgcyo.cuttadon.app.o.c.a(com.amgcyo.cuttadon.f.n.f3697k, 1, new boolean[0]);
        if (newApiAdA != null) {
            com.amgcyo.cuttadon.k.b.c cVar = new com.amgcyo.cuttadon.k.b.c(this);
            cVar.a(this, this.f4257q0, newApiAdA, this, this.f4254n0);
            this.mSplashContainer.addView(cVar);
        } else if (com.amgcyo.cuttadon.utils.otherutils.h.M0()) {
            obtainPresenter().i(Message.a(this, new Object[]{true}));
        } else {
            q();
        }
        x0.c().a("[SPLASH]api");
    }

    @Override // com.amgcyo.cuttadon.k.b.c.InterfaceC0109c
    public void onSplashImageClick(NewApiAd newApiAd) {
        q();
        if (newApiAd == null || TextUtils.isEmpty(newApiAd.getDown_url())) {
            return;
        }
        newApiAd.setLocation("闪屏");
        newApiAd.setOwnerType("开屏广告");
        com.amgcyo.cuttadon.h.h.a.a(this, newApiAd);
    }

    @Override // com.amgcyo.cuttadon.k.b.c.InterfaceC0109c
    public void onSplashViewDismiss(boolean z2) {
        q();
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyBaseAdActivity, me.jessyan.art.base.f.h
    @NonNull
    public ConfigPresenter obtainPresenter() {
        if (this.f2276v == 0) {
            this.f2276v = new ConfigPresenter(me.jessyan.art.f.e.a(this));
        }
        return (ConfigPresenter) this.f2276v;
    }
}
