package com.chad.library.adapter4.loadState;

import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoadState.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/chad/library/adapter4/loadState/LoadState;", "", "endOfPaginationReached", "", "(Z)V", "getEndOfPaginationReached", "()Z", "Error", "Loading", "None", "NotLoading", "Lcom/chad/library/adapter4/loadState/LoadState$Error;", "Lcom/chad/library/adapter4/loadState/LoadState$Loading;", "Lcom/chad/library/adapter4/loadState/LoadState$None;", "Lcom/chad/library/adapter4/loadState/LoadState$NotLoading;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class LoadState {
    private final boolean endOfPaginationReached;

    public /* synthetic */ LoadState(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(z);
    }

    private LoadState(boolean z) {
        this.endOfPaginationReached = z;
    }

    public final boolean getEndOfPaginationReached() {
        return this.endOfPaginationReached;
    }

    /* JADX INFO: compiled from: LoadState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/chad/library/adapter4/loadState/LoadState$None;", "Lcom/chad/library/adapter4/loadState/LoadState;", "()V", "equals", "", AdnName.OTHER, "", "hashCode", "", "toString", "", "com.github.CymChad.brvah"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class None extends LoadState {
        public static final None INSTANCE = new None();

        private None() {
            super(false, null);
        }

        public boolean equals(Object other) {
            return (other instanceof None) && getEndOfPaginationReached() == ((None) other).getEndOfPaginationReached();
        }

        public int hashCode() {
            return Boolean.hashCode(getEndOfPaginationReached());
        }

        public String toString() {
            return "None(endOfPaginationReached=" + getEndOfPaginationReached() + ')';
        }
    }

    /* JADX INFO: compiled from: LoadState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/chad/library/adapter4/loadState/LoadState$NotLoading;", "Lcom/chad/library/adapter4/loadState/LoadState;", "endOfPaginationReached", "", "(Z)V", "equals", AdnName.OTHER, "", "hashCode", "", "toString", "", "Companion", "com.github.CymChad.brvah"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class NotLoading extends LoadState {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final NotLoading Complete = new NotLoading(true);
        private static final NotLoading Incomplete = new NotLoading(false);

        public static final NotLoading getComplete() {
            return INSTANCE.getComplete();
        }

        public static final NotLoading getIncomplete() {
            return INSTANCE.getIncomplete();
        }

        public NotLoading(boolean z) {
            super(z, null);
        }

        public String toString() {
            return "NotLoading(endOfPaginationReached=" + getEndOfPaginationReached() + ')';
        }

        public boolean equals(Object other) {
            return (other instanceof NotLoading) && getEndOfPaginationReached() == ((NotLoading) other).getEndOfPaginationReached();
        }

        public int hashCode() {
            return Boolean.hashCode(getEndOfPaginationReached());
        }

        /* JADX INFO: compiled from: LoadState.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/chad/library/adapter4/loadState/LoadState$NotLoading$Companion;", "", "()V", "Complete", "Lcom/chad/library/adapter4/loadState/LoadState$NotLoading;", "getComplete$annotations", "getComplete", "()Lcom/chad/library/adapter4/loadState/LoadState$NotLoading;", "Incomplete", "getIncomplete$annotations", "getIncomplete", "com.github.CymChad.brvah"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public static /* synthetic */ void getComplete$annotations() {
            }

            @JvmStatic
            public static /* synthetic */ void getIncomplete$annotations() {
            }

            private Companion() {
            }

            public final NotLoading getComplete() {
                return NotLoading.Complete;
            }

            public final NotLoading getIncomplete() {
                return NotLoading.Incomplete;
            }
        }
    }

    /* JADX INFO: compiled from: LoadState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/chad/library/adapter4/loadState/LoadState$Loading;", "Lcom/chad/library/adapter4/loadState/LoadState;", "()V", "equals", "", AdnName.OTHER, "", "hashCode", "", "toString", "", "com.github.CymChad.brvah"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Loading extends LoadState {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(false, null);
        }

        public String toString() {
            return "Loading(endOfPaginationReached=" + getEndOfPaginationReached() + ')';
        }

        public boolean equals(Object other) {
            return (other instanceof Loading) && getEndOfPaginationReached() == ((Loading) other).getEndOfPaginationReached();
        }

        public int hashCode() {
            return Boolean.hashCode(getEndOfPaginationReached());
        }
    }

    /* JADX INFO: compiled from: LoadState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/chad/library/adapter4/loadState/LoadState$Error;", "Lcom/chad/library/adapter4/loadState/LoadState;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "equals", "", AdnName.OTHER, "", "hashCode", "", "toString", "", "com.github.CymChad.brvah"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Error extends LoadState {
        private final Throwable error;

        public final Throwable getError() {
            return this.error;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Throwable error) {
            super(false, null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public boolean equals(Object other) {
            if (other instanceof Error) {
                Error error = (Error) other;
                if (getEndOfPaginationReached() == error.getEndOfPaginationReached() && Intrinsics.areEqual(this.error, error.error)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Boolean.hashCode(getEndOfPaginationReached()) + this.error.hashCode();
        }

        public String toString() {
            return "Error(endOfPaginationReached=" + getEndOfPaginationReached() + ", error=" + this.error + ')';
        }
    }
}
