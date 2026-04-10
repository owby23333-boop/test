package androidx.core.database;

import android.database.CursorWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class CursorWindowCompat {
    private CursorWindowCompat() {
    }

    @NonNull
    public static CursorWindow create(@Nullable String name, long windowSizeBytes) {
        return new CursorWindow(name, windowSizeBytes);
    }
}
