package com.duokan.core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes12.dex */
public abstract class PullDownRefreshBaseView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RefreshState f2922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f2923b;

    public enum RefreshState {
        NO_REFRESH,
        DOWN_TO_REFRESH,
        RELEASE_TO_REFRESH,
        REFRESHING,
        REFRESH_DONE
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2924a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f2924a = iArr;
            try {
                iArr[RefreshState.NO_REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2924a[RefreshState.DOWN_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2924a[RefreshState.RELEASE_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2924a[RefreshState.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2924a[RefreshState.REFRESH_DONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public PullDownRefreshBaseView(Context context) {
        this(context, null);
    }

    public void a() {
        Runnable runnable = this.f2923b;
        if (runnable != null) {
            runnable.run();
            this.f2923b = null;
        }
    }

    public final void b(RefreshState refreshState, RefreshState refreshState2) {
        int i = a.f2924a[refreshState2.ordinal()];
        if (i == 1) {
            d();
            return;
        }
        if (i == 2) {
            c(refreshState);
            return;
        }
        if (i == 3) {
            g();
        } else if (i == 4) {
            f();
        } else {
            if (i != 5) {
                return;
            }
            e();
        }
    }

    public abstract void c(RefreshState refreshState);

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public final RefreshState getRefreshState() {
        return this.f2922a;
    }

    public void setOnRefreshDone(Runnable runnable) {
        this.f2923b = runnable;
    }

    public abstract void setRate(float f);

    public final void setRefreshState(RefreshState refreshState) {
        RefreshState refreshState2 = this.f2922a;
        if (refreshState2 == refreshState) {
            return;
        }
        int i = a.f2924a[refreshState2.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5 && (refreshState == RefreshState.NO_REFRESH || refreshState == RefreshState.DOWN_TO_REFRESH)) {
                            this.f2922a = refreshState;
                        }
                    } else if (refreshState == RefreshState.REFRESH_DONE) {
                        this.f2922a = refreshState;
                    }
                } else if (refreshState == RefreshState.DOWN_TO_REFRESH || refreshState == RefreshState.REFRESHING) {
                    this.f2922a = refreshState;
                }
            } else if (refreshState == RefreshState.NO_REFRESH || refreshState == RefreshState.RELEASE_TO_REFRESH) {
                this.f2922a = refreshState;
            }
        } else if (refreshState == RefreshState.DOWN_TO_REFRESH) {
            this.f2922a = refreshState;
        }
        RefreshState refreshState3 = this.f2922a;
        if (refreshState2 != refreshState3) {
            b(refreshState2, refreshState3);
        }
    }

    public PullDownRefreshBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2922a = RefreshState.NO_REFRESH;
        setClipChildren(false);
        setClipToPadding(false);
    }
}
