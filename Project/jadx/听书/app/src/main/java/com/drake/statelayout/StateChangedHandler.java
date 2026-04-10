package com.drake.statelayout;

import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StateChangedHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0016J*\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0016¨\u0006\r"}, d2 = {"Lcom/drake/statelayout/StateChangedHandler;", "", "onAdd", "", TtmlNode.RUBY_CONTAINER, "Lcom/drake/statelayout/StateLayout;", "state", "Landroid/view/View;", NotificationCompat.CATEGORY_STATUS, "Lcom/drake/statelayout/Status;", "tag", "onRemove", "DEFAULT", "statelayout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface StateChangedHandler {

    /* JADX INFO: renamed from: DEFAULT, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void onAdd(StateLayout container, View state, Status status, Object tag);

    void onRemove(StateLayout container, View state, Status status, Object tag);

    /* JADX INFO: renamed from: com.drake.statelayout.StateChangedHandler$DEFAULT, reason: from kotlin metadata */
    /* JADX INFO: compiled from: StateChangedHandler.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/drake/statelayout/StateChangedHandler$DEFAULT;", "Lcom/drake/statelayout/StateChangedHandler;", "()V", "statelayout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion implements StateChangedHandler {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @Override // com.drake.statelayout.StateChangedHandler
        public void onAdd(StateLayout stateLayout, View view, Status status, Object obj) {
            DefaultImpls.onAdd(this, stateLayout, view, status, obj);
        }

        @Override // com.drake.statelayout.StateChangedHandler
        public void onRemove(StateLayout stateLayout, View view, Status status, Object obj) {
            DefaultImpls.onRemove(this, stateLayout, view, status, obj);
        }
    }

    /* JADX INFO: compiled from: StateChangedHandler.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onRemove(StateChangedHandler stateChangedHandler, StateLayout container, View state, Status status, Object obj) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(status, "status");
            state.setVisibility(8);
        }

        public static void onAdd(StateChangedHandler stateChangedHandler, StateLayout container, View state, Status status, Object obj) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(status, "status");
            if (container.indexOfChild(state) != -1) {
                state.setVisibility(0);
            } else {
                container.addView(state);
            }
        }
    }
}
