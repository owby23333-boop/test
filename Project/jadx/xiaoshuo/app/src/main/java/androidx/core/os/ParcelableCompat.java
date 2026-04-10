package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ParcelableCompat {

    public static class ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {
        private final ParcelableCompatCreatorCallbacks<T> mCallbacks;

        public ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> callbacks) {
            this.mCallbacks = callbacks;
        }

        @Override // android.os.Parcelable.Creator
        public T createFromParcel(Parcel in) {
            return this.mCallbacks.createFromParcel(in, null);
        }

        @Override // android.os.Parcelable.Creator
        public T[] newArray(int size) {
            return this.mCallbacks.newArray(size);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public T createFromParcel(Parcel in, ClassLoader loader) {
            return this.mCallbacks.createFromParcel(in, loader);
        }
    }

    private ParcelableCompat() {
    }

    @Deprecated
    public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> callbacks) {
        return new ParcelableCompatCreatorHoneycombMR2(callbacks);
    }
}
