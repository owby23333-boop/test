package me.jessyan.art.base;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import me.jessyan.art.f.i;

/* JADX INFO: compiled from: BaseHolder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected a f21145s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected me.jessyan.art.a.a.a f21146t;

    /* JADX INFO: compiled from: BaseHolder.java */
    public interface a {
        void a(View view, int i2);
    }

    public c(View view) {
        super(view);
        this.f21145s = null;
        getClass().getSimpleName();
        this.f21146t = me.jessyan.art.f.e.a(view.getContext());
        this.f21146t.imageLoader();
        view.setOnClickListener(this);
        i.a(this, view);
    }

    public abstract void a(@NonNull T t2, int i2);

    public void a(a aVar) {
        this.f21145s = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar = this.f21145s;
        if (aVar != null) {
            aVar.a(view, getPosition());
        }
    }
}
