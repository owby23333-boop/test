package com.amgcyo.cuttadon.utils.comic;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class PreCacheLayoutManager extends LinearLayoutManager {
    private int a;

    public PreCacheLayoutManager(Context context) {
        super(context);
        this.a = 0;
    }

    public void a(int i2) {
        this.a = i2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    protected int getExtraLayoutSpace(RecyclerView.State state) {
        int i2;
        int height;
        if (this.a <= 0) {
            return 0;
        }
        if (getOrientation() == 0) {
            i2 = this.a;
            height = getWidth();
        } else {
            i2 = this.a;
            height = getHeight();
        }
        return i2 * height;
    }
}
