package me.jessyan.art.base.f;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: ActivityDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public interface a {
    void onCreate(@Nullable Bundle bundle);

    void onDestroy();

    void onPause();

    void onResume();

    void onSaveInstanceState(@NonNull Bundle bundle);

    void onStart();

    void onStop();
}
