package com.chad.library.adapter.base;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashSet;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: BaseViewHolder.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends RecyclerView.ViewHolder {
    private final SparseArray<View> a;
    private final LinkedHashSet<Integer> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BaseQuickAdapter f14746c;

    /* JADX INFO: compiled from: BaseViewHolder.java */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int adapterPosition;
            if (b.this.f14746c.e() == null || (adapterPosition = b.this.getAdapterPosition()) == -1) {
                return;
            }
            b.this.f14746c.e().onItemChildClick(b.this.f14746c, view, adapterPosition - b.this.f14746c.c());
        }
    }

    public b(View view) {
        super(view);
        this.a = new SparseArray<>();
        this.b = new LinkedHashSet<>();
        new LinkedHashSet();
        new HashSet();
    }

    public b b(@IdRes int i2, @ColorInt int i3) {
        ((TextView) a(i2)).setTextColor(i3);
        return this;
    }

    public b a(@IdRes int i2, CharSequence charSequence) {
        ((TextView) a(i2)).setText(charSequence);
        return this;
    }

    public b a(@IdRes int i2, @ColorInt int i3) {
        a(i2).setBackgroundColor(i3);
        return this;
    }

    public b a(@IdRes int i2, boolean z2) {
        a(i2).setVisibility(z2 ? 0 : 8);
        return this;
    }

    public b a(@IdRes int... iArr) {
        for (int i2 : iArr) {
            this.b.add(Integer.valueOf(i2));
            View viewA = a(i2);
            if (viewA != null) {
                if (!viewA.isClickable()) {
                    viewA.setClickable(true);
                }
                viewA.setOnClickListener(new a());
            }
        }
        return this;
    }

    protected b a(BaseQuickAdapter baseQuickAdapter) {
        this.f14746c = baseQuickAdapter;
        return this;
    }

    public <T extends View> T a(@IdRes int i2) {
        T t2 = (T) this.a.get(i2);
        if (t2 != null) {
            return t2;
        }
        T t3 = (T) this.itemView.findViewById(i2);
        this.a.put(i2, t3);
        return t3;
    }
}
