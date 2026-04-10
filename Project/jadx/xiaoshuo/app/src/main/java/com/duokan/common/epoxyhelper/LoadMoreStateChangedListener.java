package com.duokan.common.epoxyhelper;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/duokan/common/epoxyhelper/LoadMoreStateChangedListener;", "", "onLoadMoreStateChanged", "", "state", "", "Companion", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LoadMoreStateChangedListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int LOAD_MORE_STATE_FAILED = 1;
    public static final int LOAD_MORE_STATE_LOADING = 0;
    public static final int LOAD_MORE_STATE_NONE = -1;
    public static final int LOAD_MORE_STATE_NO_MORE = 2;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/duokan/common/epoxyhelper/LoadMoreStateChangedListener$Companion;", "", "()V", "LOAD_MORE_STATE_FAILED", "", "LOAD_MORE_STATE_LOADING", "LOAD_MORE_STATE_NONE", "LOAD_MORE_STATE_NO_MORE", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int LOAD_MORE_STATE_FAILED = 1;
        public static final int LOAD_MORE_STATE_LOADING = 0;
        public static final int LOAD_MORE_STATE_NONE = -1;
        public static final int LOAD_MORE_STATE_NO_MORE = 2;

        private Companion() {
        }
    }

    void onLoadMoreStateChanged(int state);
}
