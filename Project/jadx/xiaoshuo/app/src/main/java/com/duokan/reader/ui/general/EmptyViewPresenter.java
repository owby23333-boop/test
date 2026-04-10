package com.duokan.reader.ui.general;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.yuewen.st2;

/* JADX INFO: loaded from: classes5.dex */
public class EmptyViewPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f5431a;

    public EmptyViewPresenter(Context context) {
        this.f5431a = LayoutInflater.from(context).inflate(st2.n.c5, (ViewGroup) null);
    }

    public View a() {
        return this.f5431a;
    }

    public void b(int i) {
        ((ImageView) this.f5431a.findViewById(st2.k.tm)).setImageResource(i);
    }

    public void c(int i) {
        TextView textView = (TextView) this.f5431a.findViewById(st2.k.um);
        textView.setText(i);
        if (i == 0) {
            textView.setVisibility(8);
        }
    }

    public void d(String str) {
        TextView textView = (TextView) this.f5431a.findViewById(st2.k.um);
        textView.setText(str);
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        }
    }

    public void e(int i) {
        TextView textView = (TextView) this.f5431a.findViewById(st2.k.vm);
        textView.setText(i);
        if (i == 0) {
            textView.setVisibility(8);
        }
    }

    public void f(String str) {
        TextView textView = (TextView) this.f5431a.findViewById(st2.k.vm);
        textView.setText(str);
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        }
    }
}
