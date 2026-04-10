package com.drake.statelayout.handler;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.drake.statelayout.StateChangedHandler;
import com.drake.statelayout.StateLayout;
import com.drake.statelayout.Status;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FadeStateChangedHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J*\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/drake/statelayout/handler/FadeStateChangedHandler;", "Lcom/drake/statelayout/StateChangedHandler;", "duration", "", "(J)V", "getDuration", "()J", "setDuration", "stateLayout", "Ljava/lang/ref/WeakReference;", "Lcom/drake/statelayout/StateLayout;", "onAdd", "", TtmlNode.RUBY_CONTAINER, "state", "Landroid/view/View;", NotificationCompat.CATEGORY_STATUS, "Lcom/drake/statelayout/Status;", "tag", "", "onRemove", "statelayout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class FadeStateChangedHandler implements StateChangedHandler {
    private long duration;
    private WeakReference<StateLayout> stateLayout;

    public FadeStateChangedHandler() {
        this(0L, 1, null);
    }

    public FadeStateChangedHandler(long j) {
        this.duration = j;
        this.stateLayout = new WeakReference<>(null);
    }

    public /* synthetic */ FadeStateChangedHandler(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 400L : j);
    }

    public final long getDuration() {
        return this.duration;
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    @Override // com.drake.statelayout.StateChangedHandler
    public void onRemove(final StateLayout container, final View state, final Status status, final Object tag) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(status, "status");
        if (!Intrinsics.areEqual(container, this.stateLayout.get()) && status == Status.LOADING) {
            StateChangedHandler.DefaultImpls.onRemove(this, container, state, status, tag);
        } else {
            state.animate().setDuration(this.duration).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.drake.statelayout.handler.FadeStateChangedHandler.onRemove.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    StateChangedHandler.INSTANCE.onRemove(container, state, status, tag);
                }
            }).start();
        }
    }

    @Override // com.drake.statelayout.StateChangedHandler
    public void onAdd(StateLayout container, View state, Status status, Object tag) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(status, "status");
        if (!Intrinsics.areEqual(container, this.stateLayout.get()) && status == Status.LOADING) {
            this.stateLayout = new WeakReference<>(container);
            StateChangedHandler.INSTANCE.onAdd(container, state, status, tag);
        } else {
            StateChangedHandler.DefaultImpls.onAdd(this, container, state, status, tag);
            state.setAlpha(0.0f);
            state.animate().setDuration(this.duration).alpha(1.0f).start();
        }
    }
}
