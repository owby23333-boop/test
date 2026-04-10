package com.mibi.sdk.mvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes14.dex */
public abstract class MvpActivity extends Activity implements IPresenterFactory, IView {
    private static final String KEY_SAVE_PRESENTER_DATA = "KEY_SAVE_PRESENTER_DATA";
    private static final String KEY_SAVE_VIEW_UUID = "SAVE_VIEW_UUID";
    private Map<String, IPresenter> mPresenters = new HashMap();
    private String mViewUuid;

    public final IPresenter getPresenter() {
        IPresenter iPresenter = this.mPresenters.get(this.mViewUuid);
        if (iPresenter != null) {
            return iPresenter;
        }
        IPresenter iPresenterOnCreatePresenter = onCreatePresenter();
        this.mPresenters.put(this.mViewUuid, iPresenterOnCreatePresenter);
        return iPresenterOnCreatePresenter;
    }

    public abstract void handleCreate(Bundle bundle);

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (getPresenter() != null) {
            if (intent == null) {
                intent = new Intent();
            }
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            getPresenter().handleResult(i, i2, extras);
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.mViewUuid = UUID.randomUUID().toString();
        } else {
            this.mViewUuid = bundle.getString(KEY_SAVE_VIEW_UUID);
        }
        handleCreate(bundle);
        IPresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.init(this, getIntent().getExtras(), bundle != null ? bundle.getBundle(KEY_SAVE_PRESENTER_DATA) : null);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (isChangingConfigurations()) {
            return;
        }
        for (IPresenter iPresenter : this.mPresenters.values()) {
            if (iPresenter != null) {
                iPresenter.release();
            }
        }
        this.mPresenters.clear();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        IPresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.resume(this);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        IPresenter presenter = getPresenter();
        if (presenter != null) {
            Bundle bundle2 = new Bundle();
            presenter.save(bundle2);
            bundle.putBundle(KEY_SAVE_PRESENTER_DATA, bundle2);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        IPresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        IPresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.detach();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onSaveInstanceState(bundle, persistableBundle);
        IPresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.save(bundle);
        }
    }
}
