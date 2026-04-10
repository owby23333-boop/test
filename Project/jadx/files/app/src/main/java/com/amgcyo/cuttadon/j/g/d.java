package com.amgcyo.cuttadon.j.g;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/* JADX INFO: compiled from: RxSearch.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: compiled from: RxSearch.java */
    class a implements TextWatcher {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ BehaviorSubject f4102s;

        a(BehaviorSubject behaviorSubject) {
            this.f4102s = behaviorSubject;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f4102s.onNext(charSequence.toString());
        }
    }

    public static Observable<String> a(EditText editText) {
        BehaviorSubject behaviorSubjectCreate = BehaviorSubject.create();
        editText.addTextChangedListener(new a(behaviorSubjectCreate));
        return behaviorSubjectCreate;
    }
}
