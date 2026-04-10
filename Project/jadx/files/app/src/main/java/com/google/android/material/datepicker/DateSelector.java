package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Pair;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface DateSelector<S> extends Parcelable {
    @StyleRes
    int a(Context context);

    @NonNull
    View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, @NonNull CalendarConstraints calendarConstraints, @NonNull j<S> jVar);

    @NonNull
    String b(Context context);

    void g(long j2);

    @NonNull
    Collection<Pair<Long, Long>> j();

    boolean k();

    @NonNull
    Collection<Long> l();

    @Nullable
    S m();
}
