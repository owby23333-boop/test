package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import java.util.Iterator;

/* JADX INFO: compiled from: MaterialTextInputPicker.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class g<S> extends k<S> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @StyleRes
    private int f15320t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private DateSelector<S> f15321u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private CalendarConstraints f15322v;

    @NonNull
    static <T> g<T> a(DateSelector<T> dateSelector, @StyleRes int i2, @NonNull CalendarConstraints calendarConstraints) {
        g<T> gVar = new g<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        gVar.setArguments(bundle);
        return gVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f15320t = bundle.getInt("THEME_RES_ID_KEY");
        this.f15321u = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f15322v = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.f15321u.a(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.f15320t)), viewGroup, bundle, this.f15322v, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f15320t);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f15321u);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f15322v);
    }

    /* JADX INFO: compiled from: MaterialTextInputPicker.java */
    class a extends j<S> {
        a() {
        }

        @Override // com.google.android.material.datepicker.j
        public void a(S s2) {
            Iterator<j<S>> it = g.this.f15334s.iterator();
            while (it.hasNext()) {
                it.next().a(s2);
            }
        }

        @Override // com.google.android.material.datepicker.j
        public void a() {
            Iterator<j<S>> it = g.this.f15334s.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }
}
