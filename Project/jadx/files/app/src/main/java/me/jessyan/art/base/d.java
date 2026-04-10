package me.jessyan.art.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import me.jessyan.art.base.c;

/* JADX INFO: compiled from: DefaultAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d<T> extends RecyclerView.Adapter<c<T>> {
    protected List<T> a;
    protected a b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c<T> f21149c;

    /* JADX INFO: compiled from: DefaultAdapter.java */
    public interface a<T> {
        void a(@NonNull View view, int i2, @NonNull T t2, int i3);
    }

    public d(List<T> list) {
        this.a = list;
    }

    public abstract int a(int i2);

    @NonNull
    public abstract c<T> a(@NonNull View view, int i2);

    public void a(List<T> list) {
        this.a = list;
    }

    public List<T> b() {
        return this.a;
    }

    public T getItem(int i2) {
        List<T> list = this.a;
        if (list == null) {
            return null;
        }
        if (i2 >= list.size()) {
            i2 = this.a.size() - 1;
        }
        return this.a.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    public void a() {
        this.a.clear();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public c<T> onCreateViewHolder(ViewGroup viewGroup, final int i2) {
        this.f21149c = a(LayoutInflater.from(viewGroup.getContext()).inflate(a(i2), viewGroup, false), i2);
        this.f21149c.a(new c.a() { // from class: me.jessyan.art.base.a
            @Override // me.jessyan.art.base.c.a
            public final void a(View view, int i3) {
                this.a.a(i2, view, i3);
            }
        });
        return this.f21149c;
    }

    public d() {
        if (this.a == null) {
            this.a = new ArrayList();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public /* synthetic */ void a(int i2, View view, int i3) {
        if (this.b == null || this.a.size() <= 0) {
            return;
        }
        if (i3 >= this.a.size()) {
            i3 = this.a.size() - 1;
        }
        this.b.a(view, i2, this.a.get(i3), i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull c<T> cVar, int i2) {
        if (i2 >= this.a.size()) {
            i2 = this.a.size() - 1;
        }
        cVar.a(this.a.get(i2), i2);
    }

    public void a(a aVar) {
        this.b = aVar;
    }
}
