package com.kwad.components.core.j;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.mvp.a;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c<T extends com.kwad.sdk.mvp.a> extends KSFrameLayout {
    public T Ki;
    protected ViewGroup lU;
    protected Presenter mPresenter;

    public c(Context context) {
        this(context, null);
    }

    private c(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private c(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, 0);
        if (kD()) {
            return;
        }
        oa();
    }

    private void initMVP() {
        this.Ki = (T) kH();
        if (this.mPresenter == null) {
            this.mPresenter = onCreatePresenter();
            this.mPresenter.H(this.lU);
        }
        this.mPresenter.f(this.Ki);
    }

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract void initData();

    protected boolean kD() {
        return false;
    }

    protected abstract void kF();

    protected abstract T kH();

    protected final void oa() {
        initData();
        this.lU = (ViewGroup) com.kwad.sdk.i.a.inflate(getContext(), getLayoutId(), this);
        kF();
    }

    @NonNull
    public abstract Presenter onCreatePresenter();

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void onViewAttached() {
        super.onViewAttached();
        initMVP();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void onViewDetached() {
        super.onViewDetached();
        T t2 = this.Ki;
        if (t2 != null) {
            t2.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }
}
