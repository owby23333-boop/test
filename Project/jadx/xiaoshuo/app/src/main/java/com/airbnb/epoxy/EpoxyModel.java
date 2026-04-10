package com.airbnb.epoxy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import com.airbnb.epoxy.EpoxyController;
import com.yuewen.w51;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class EpoxyModel<T> {
    private static long idCounter = -1;
    boolean addedToAdapter;
    EpoxyController controllerToStageTo;
    private boolean currentlyInInterceptors;
    private EpoxyController firstControllerAddedTo;
    private boolean hasDefaultId;
    private int hashCodeWhenAdded;
    private long id;

    @LayoutRes
    private int layout;
    private boolean shown;

    @Nullable
    private SpanSizeOverrideCallback spanSizeOverride;

    public interface AddPredicate {
        boolean addIf();
    }

    public interface SpanSizeOverrideCallback {
        int getSpanSize(int i, int i2, int i3);
    }

    public EpoxyModel(long j) {
        this.shown = true;
        id(j);
    }

    private static int getPosition(@NonNull EpoxyController epoxyController, @NonNull EpoxyModel<?> epoxyModel) {
        return epoxyController.isBuildingModels() ? epoxyController.getFirstIndexOfModelInBuildingList(epoxyModel) : epoxyController.getAdapter().getModelPosition(epoxyModel);
    }

    public void addIf(boolean z, @NonNull EpoxyController epoxyController) {
        if (z) {
            addTo(epoxyController);
            return;
        }
        EpoxyController epoxyController2 = this.controllerToStageTo;
        if (epoxyController2 != null) {
            epoxyController2.clearModelFromStaging(this);
            this.controllerToStageTo = null;
        }
    }

    public void addTo(@NonNull EpoxyController epoxyController) {
        epoxyController.addInternal(this);
    }

    public final void addWithDebugValidation(@NonNull EpoxyController epoxyController) {
        if (epoxyController == null) {
            throw new IllegalArgumentException("Controller cannot be null");
        }
        if (epoxyController.isModelAddedMultipleTimes(this)) {
            throw new IllegalEpoxyUsage("This model was already added to the controller at position " + epoxyController.getFirstIndexOfModelInBuildingList(this));
        }
        if (this.firstControllerAddedTo == null) {
            this.firstControllerAddedTo = epoxyController;
            this.hashCodeWhenAdded = hashCode();
            epoxyController.addAfterInterceptorCallback(new EpoxyController.ModelInterceptorCallback() { // from class: com.airbnb.epoxy.EpoxyModel.1
                @Override // com.airbnb.epoxy.EpoxyController.ModelInterceptorCallback
                public void onInterceptorsFinished(EpoxyController epoxyController2) {
                    EpoxyModel epoxyModel = EpoxyModel.this;
                    epoxyModel.hashCodeWhenAdded = epoxyModel.hashCode();
                    EpoxyModel.this.currentlyInInterceptors = false;
                }

                @Override // com.airbnb.epoxy.EpoxyController.ModelInterceptorCallback
                public void onInterceptorsStarted(EpoxyController epoxyController2) {
                    EpoxyModel.this.currentlyInInterceptors = true;
                }
            });
        }
    }

    public void bind(@NonNull T t) {
    }

    public View buildView(@NonNull ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(getLayout(), viewGroup, false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EpoxyModel)) {
            return false;
        }
        EpoxyModel epoxyModel = (EpoxyModel) obj;
        return this.id == epoxyModel.id && getViewType() == epoxyModel.getViewType() && this.shown == epoxyModel.shown;
    }

    @LayoutRes
    public abstract int getDefaultLayout();

    @LayoutRes
    public final int getLayout() {
        int i = this.layout;
        return i == 0 ? getDefaultLayout() : i;
    }

    public int getSpanSize(int i, int i2, int i3) {
        return 1;
    }

    public int getViewType() {
        return getLayout();
    }

    public boolean hasDefaultId() {
        return this.hasDefaultId;
    }

    public int hashCode() {
        long j = this.id;
        return (((((int) (j ^ (j >>> 32))) * 31) + getViewType()) * 31) + (this.shown ? 1 : 0);
    }

    @NonNull
    public EpoxyModel<T> hide() {
        return show(false);
    }

    public long id() {
        return this.id;
    }

    public boolean isDebugValidationEnabled() {
        return this.firstControllerAddedTo != null;
    }

    public boolean isShown() {
        return this.shown;
    }

    @NonNull
    public EpoxyModel<T> layout(@LayoutRes int i) {
        onMutation();
        this.layout = i;
        return this;
    }

    public boolean onFailedToRecycleView(@NonNull T t) {
        return false;
    }

    public final void onMutation() {
        if (isDebugValidationEnabled() && !this.currentlyInInterceptors) {
            throw new ImmutableModelException(this, getPosition(this.firstControllerAddedTo, this));
        }
        EpoxyController epoxyController = this.controllerToStageTo;
        if (epoxyController != null) {
            epoxyController.setStagedModel(this);
        }
    }

    public void onViewAttachedToWindow(@NonNull T t) {
    }

    public void onViewDetachedFromWindow(@NonNull T t) {
    }

    public void onVisibilityChanged(@FloatRange(from = w51.l, to = 100.0d) float f, @FloatRange(from = w51.l, to = 100.0d) float f2, @Px int i, @Px int i2, @NonNull T t) {
    }

    public void onVisibilityStateChanged(int i, @NonNull T t) {
    }

    public void preBind(@NonNull T t, @Nullable EpoxyModel<?> epoxyModel) {
    }

    @NonNull
    public EpoxyModel<T> reset() {
        onMutation();
        this.layout = 0;
        this.shown = true;
        return this;
    }

    public boolean shouldSaveViewState() {
        return false;
    }

    @NonNull
    public EpoxyModel<T> show() {
        return show(true);
    }

    public final int spanSize(int i, int i2, int i3) {
        SpanSizeOverrideCallback spanSizeOverrideCallback = this.spanSizeOverride;
        return spanSizeOverrideCallback != null ? spanSizeOverrideCallback.getSpanSize(i, i2, i3) : getSpanSize(i, i2, i3);
    }

    public EpoxyModel<T> spanSizeOverride(@Nullable SpanSizeOverrideCallback spanSizeOverrideCallback) {
        this.spanSizeOverride = spanSizeOverrideCallback;
        return this;
    }

    public String toString() {
        return getClass().getSimpleName() + "{id=" + this.id + ", viewType=" + getViewType() + ", shown=" + this.shown + ", addedToAdapter=" + this.addedToAdapter + '}';
    }

    public void unbind(@NonNull T t) {
    }

    public final void validateStateHasNotChangedSinceAdded(String str, int i) {
        if (isDebugValidationEnabled() && !this.currentlyInInterceptors && this.hashCodeWhenAdded != hashCode()) {
            throw new ImmutableModelException(this, str, i);
        }
    }

    public void bind(@NonNull T t, @NonNull List<Object> list) {
        bind(t);
    }

    public EpoxyModel<T> id(long j) {
        if ((this.addedToAdapter || this.firstControllerAddedTo != null) && j != this.id) {
            throw new IllegalEpoxyUsage("Cannot change a model's id after it has been added to the adapter.");
        }
        this.hasDefaultId = false;
        this.id = j;
        return this;
    }

    @NonNull
    public EpoxyModel<T> show(boolean z) {
        onMutation();
        this.shown = z;
        return this;
    }

    public void bind(@NonNull T t, @NonNull EpoxyModel<?> epoxyModel) {
        bind(t);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public EpoxyModel() {
        long j = idCounter;
        idCounter = j - 1;
        this(j);
        this.hasDefaultId = true;
    }

    public void addIf(@NonNull AddPredicate addPredicate, @NonNull EpoxyController epoxyController) {
        addIf(addPredicate.addIf(), epoxyController);
    }

    public EpoxyModel<T> id(@Nullable Number... numberArr) {
        long j = 0;
        if (numberArr != null) {
            long jHashLong64Bit = 0;
            for (Number number : numberArr) {
                jHashLong64Bit = (jHashLong64Bit * 31) + IdUtils.hashLong64Bit(number == null ? 0L : r6.hashCode());
            }
            j = jHashLong64Bit;
        }
        return id(j);
    }

    public EpoxyModel<T> id(long j, long j2) {
        return id((IdUtils.hashLong64Bit(j) * 31) + IdUtils.hashLong64Bit(j2));
    }

    public EpoxyModel<T> id(@Nullable CharSequence charSequence) {
        id(IdUtils.hashString64Bit(charSequence));
        return this;
    }

    public EpoxyModel<T> id(@Nullable CharSequence charSequence, @Nullable CharSequence... charSequenceArr) {
        long jHashString64Bit = IdUtils.hashString64Bit(charSequence);
        if (charSequenceArr != null) {
            for (CharSequence charSequence2 : charSequenceArr) {
                jHashString64Bit = (jHashString64Bit * 31) + IdUtils.hashString64Bit(charSequence2);
            }
        }
        return id(jHashString64Bit);
    }

    public EpoxyModel<T> id(@Nullable CharSequence charSequence, long j) {
        id((IdUtils.hashString64Bit(charSequence) * 31) + IdUtils.hashLong64Bit(j));
        return this;
    }
}
