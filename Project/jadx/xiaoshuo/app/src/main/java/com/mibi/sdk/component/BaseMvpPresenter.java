package com.mibi.sdk.component;

import android.os.Bundle;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.mvp.IView;
import com.mibi.sdk.mvp.Presenter;

/* JADX INFO: loaded from: classes13.dex */
public class BaseMvpPresenter<T extends IView> extends Presenter<T> {
    private Session mSession;

    public BaseMvpPresenter(Class<T> cls) {
        super(cls);
    }

    public synchronized Session getSession() {
        checkInLifecycle();
        return this.mSession;
    }

    @Override // com.mibi.sdk.mvp.Presenter
    public void onInit(Bundle bundle) {
        super.onInit(bundle);
    }

    public synchronized void updateSession(Session session) {
        this.mSession = session;
    }
}
