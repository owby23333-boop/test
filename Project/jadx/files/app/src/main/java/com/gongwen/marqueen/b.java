package com.gongwen.marqueen;

import android.content.Context;
import android.widget.TextView;
import java.lang.CharSequence;

/* JADX INFO: compiled from: SimpleMF.java */
/* JADX INFO: loaded from: classes2.dex */
public class b<E extends CharSequence> extends a<TextView, E> {
    public b(Context context) {
        super(context);
    }

    @Override // com.gongwen.marqueen.a
    public TextView a(E e2) {
        TextView textView = new TextView(this.a);
        textView.setText(e2);
        return textView;
    }
}
