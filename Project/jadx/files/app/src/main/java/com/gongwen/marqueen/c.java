package com.gongwen.marqueen;

import android.view.View;
import java.util.List;

/* JADX INFO: compiled from: XMarqueeViewAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T> {
    protected List<T> a;
    private a b;

    /* JADX INFO: compiled from: XMarqueeViewAdapter.java */
    public interface a {
        void a();
    }

    public c(List<T> list) {
        this.a = list;
        if (list == null) {
            throw new RuntimeException("XMarqueeView datas is Null");
        }
    }

    public int a() {
        List<T> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public abstract View a(XMarqueeView xMarqueeView);

    public abstract void a(View view, View view2, int i2);

    public void b() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(a aVar) {
        this.b = aVar;
    }
}
