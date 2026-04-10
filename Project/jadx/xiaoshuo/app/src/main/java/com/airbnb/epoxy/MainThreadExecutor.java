package com.airbnb.epoxy;

/* JADX INFO: loaded from: classes.dex */
class MainThreadExecutor extends HandlerExecutor {
    static final MainThreadExecutor INSTANCE = new MainThreadExecutor(false);
    static final MainThreadExecutor ASYNC_INSTANCE = new MainThreadExecutor(true);

    public MainThreadExecutor(boolean z) {
        super(z ? EpoxyAsyncUtil.AYSNC_MAIN_THREAD_HANDLER : EpoxyAsyncUtil.MAIN_THREAD_HANDLER);
    }
}
