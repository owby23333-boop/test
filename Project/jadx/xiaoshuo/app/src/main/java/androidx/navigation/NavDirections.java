package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface NavDirections {
    @IdRes
    int getActionId();

    @NonNull
    Bundle getArguments();
}
