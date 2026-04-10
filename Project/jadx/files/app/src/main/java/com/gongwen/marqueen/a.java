package com.gongwen.marqueen;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

/* JADX INFO: compiled from: MarqueeFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T extends View, E> extends Observable {
    protected Context a;
    protected List<T> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected List<E> f14912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MarqueeView f14913d;

    public a(Context context) {
        this.a = context;
    }

    private boolean c() {
        return this.f14913d != null;
    }

    private void d() {
        if (c()) {
            setChanged();
            notifyObservers("UPDATE_DATA");
        }
    }

    protected abstract T a(E e2);

    public void a(List<E> list) {
        if (list == null) {
            return;
        }
        this.f14912c = list;
        this.b = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.b.add((T) a(list.get(i2)));
        }
        d();
    }

    protected List<T> b() {
        List<T> list = this.b;
        return list != null ? list : Collections.EMPTY_LIST;
    }

    public List<E> a() {
        return this.f14912c;
    }

    protected void a(MarqueeView marqueeView) {
        if (!c()) {
            this.f14913d = marqueeView;
            addObserver(marqueeView);
            return;
        }
        throw new IllegalStateException(String.format("The %s has been attached to the %s!", toString(), this.f14913d.toString()));
    }
}
