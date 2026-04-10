package me.jessyan.art.base.f;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: FragmentDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public interface f {
    void a(@Nullable Bundle bundle);

    void a(@Nullable View view, @Nullable Bundle bundle);

    boolean isAdded();

    void onAttach(@NonNull Context context);

    void onCreate(@Nullable Bundle bundle);

    void onDestroy();

    void onDestroyView();

    void onDetach();

    void onPause();

    void onResume();

    void onSaveInstanceState(@NonNull Bundle bundle);

    void onStart();

    void onStop();
}
