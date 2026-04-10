package com.kwad.components.core.m;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.mvp.a;
import com.kwad.sdk.o.m;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c<T extends com.kwad.sdk.mvp.a> extends KSFrameLayout {
    public T Rv;
    public Presenter mPresenter;
    protected ViewGroup nY;

    protected boolean ai() {
        return false;
    }

    protected abstract void ak();

    protected abstract T al();

    protected abstract int getLayoutId();

    protected abstract void initData();

    public abstract Presenter onCreatePresenter();

    public c(Context context) {
        this(context, null);
    }

    private c(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        if (ai()) {
            return;
        }
        qs();
    }

    protected final void qs() {
        initData();
        this.nY = (ViewGroup) m.inflate(getContext(), getLayoutId(), this);
        ak();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void aa() {
        super.aa();
        initMVP();
    }

    private void initMVP() {
        this.Rv = (T) al();
        if (this.mPresenter == null) {
            Presenter presenterOnCreatePresenter = onCreatePresenter();
            this.mPresenter = presenterOnCreatePresenter;
            presenterOnCreatePresenter.K(this.nY);
        }
        this.mPresenter.n(this.Rv);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ab() {
        super.ab();
        T t = this.Rv;
        if (t != null) {
            t.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }
}
