package me.drakeet.multitype;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: MultiTypeAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @NonNull
    private List<?> a;

    @NonNull
    private g b;

    public d() {
        this(Collections.emptyList());
    }

    public <T> void a(@NonNull Class<? extends T> cls, @NonNull b<T, ?> bVar) {
        f.a(cls);
        f.a(bVar);
        a(cls);
        a(cls, bVar, new a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i2) {
        return this.b.a(getItemViewType(i2)).a(this.a.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i2) {
        return a(i2, this.a.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @Deprecated
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        onBindViewHolder(viewHolder, i2, Collections.emptyList());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return this.b.a(i2).a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder viewHolder) {
        return a(viewHolder).a(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        a(viewHolder).b(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        a(viewHolder).c(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
        a(viewHolder).d(viewHolder);
    }

    public d(@NonNull List<?> list) {
        this(list, new e());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2, List<Object> list) {
        this.b.a(viewHolder.getItemViewType()).a(viewHolder, this.a.get(i2), list);
    }

    public d(@NonNull List<?> list, @NonNull g gVar) {
        f.a(list);
        f.a(gVar);
        this.a = list;
        this.b = gVar;
    }

    <T> void a(@NonNull Class<? extends T> cls, @NonNull b<T, ?> bVar, @NonNull c<T> cVar) {
        this.b.a(cls, bVar, cVar);
        bVar.a = this;
    }

    public void a(@NonNull List<?> list) {
        f.a(list);
        this.a = list;
    }

    @NonNull
    private b a(@NonNull RecyclerView.ViewHolder viewHolder) {
        return this.b.a(viewHolder.getItemViewType());
    }

    int a(int i2, @NonNull Object obj) throws BinderNotFoundException {
        int iA = this.b.a(obj.getClass());
        if (iA != -1) {
            return iA + this.b.b(iA).a(i2, obj);
        }
        throw new BinderNotFoundException(obj.getClass());
    }

    private void a(@NonNull Class<?> cls) {
        if (this.b.b(cls)) {
            String str = "You have registered the " + cls.getSimpleName() + " type. It will override the original binder(s).";
        }
    }
}
