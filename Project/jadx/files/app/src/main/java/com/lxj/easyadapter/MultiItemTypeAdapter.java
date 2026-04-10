package com.lxj.easyadapter;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lxj.easyadapter.ViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MultiItemTypeAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 D*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0003DEFB\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012J\u000e\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012J\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(J\"\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010)\u001a\u00020\u000b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(J\u001b\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00028\u0000¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\u000bH\u0016J\u0010\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000bH\u0016J\u0010\u00101\u001a\u0002022\u0006\u0010)\u001a\u00020\u000bH\u0004J\u0010\u00103\u001a\u0002022\u0006\u00100\u001a\u00020\u000bH\u0002J\u0010\u00104\u001a\u0002022\u0006\u00100\u001a\u00020\u000bH\u0002J\u0010\u00105\u001a\u00020#2\u0006\u00106\u001a\u000207H\u0016J\u0018\u00108\u001a\u00020#2\u0006\u0010+\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u000bH\u0016J\u0018\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020;2\u0006\u0010)\u001a\u00020\u000bH\u0016J\u0010\u0010<\u001a\u00020#2\u0006\u0010+\u001a\u00020\u0003H\u0016J\u0016\u0010=\u001a\u00020#2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0012J \u0010?\u001a\u00020#2\u0006\u0010:\u001a\u00020;2\u0006\u0010@\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u000bH\u0004J\u000e\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u00020\u001bJ\b\u0010C\u001a\u000202H\u0004R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\r¨\u0006G"}, d2 = {"Lcom/lxj/easyadapter/MultiItemTypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/lxj/easyadapter/ViewHolder;", "data", "", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "setData", "footersCount", "", "getFootersCount", "()I", "headersCount", "getHeadersCount", "mFootViews", "Landroid/util/SparseArray;", "Landroid/view/View;", "mHeaderViews", "mItemDelegateManager", "Lcom/lxj/easyadapter/ItemDelegateManager;", "getMItemDelegateManager", "()Lcom/lxj/easyadapter/ItemDelegateManager;", "setMItemDelegateManager", "(Lcom/lxj/easyadapter/ItemDelegateManager;)V", "mOnItemClickListener", "Lcom/lxj/easyadapter/MultiItemTypeAdapter$OnItemClickListener;", "getMOnItemClickListener", "()Lcom/lxj/easyadapter/MultiItemTypeAdapter$OnItemClickListener;", "setMOnItemClickListener", "(Lcom/lxj/easyadapter/MultiItemTypeAdapter$OnItemClickListener;)V", "realItemCount", "getRealItemCount", "addFootView", "", com.anythink.expressad.a.B, "addHeaderView", "addItemDelegate", "itemViewDelegate", "Lcom/lxj/easyadapter/ItemDelegate;", "viewType", "convert", "holder", "t", "(Lcom/lxj/easyadapter/ViewHolder;Ljava/lang/Object;)V", "getItemCount", "getItemViewType", "position", "isEnabled", "", "isFooterViewPos", "isHeaderViewPos", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "onViewAttachedToWindow", "onViewHolderCreated", "itemView", "setListener", "viewHolder", "setOnItemClickListener", "onItemClickListener", "useItemDelegateManager", "Companion", "OnItemClickListener", "SimpleOnItemClickListener", "easy-adapter_release"}, k = 1, mv = {1, 1, 15})
public class MultiItemTypeAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    private final SparseArray<View> a = new SparseArray<>();
    private final SparseArray<View> b = new SparseArray<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private com.lxj.easyadapter.c<T> f17305c = new com.lxj.easyadapter.c<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private b f17306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private List<? extends T> f17307e;

    /* JADX INFO: compiled from: MultiItemTypeAdapter.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: MultiItemTypeAdapter.kt */
    public interface b {
        boolean a(@NotNull View view, @NotNull RecyclerView.ViewHolder viewHolder, int i2);

        void b(@NotNull View view, @NotNull RecyclerView.ViewHolder viewHolder, int i2);
    }

    /* JADX INFO: compiled from: MultiItemTypeAdapter.kt */
    public static class c implements b {
        @Override // com.lxj.easyadapter.MultiItemTypeAdapter.b
        public boolean a(@NotNull View view, @NotNull RecyclerView.ViewHolder viewHolder, int i2) {
            return false;
        }
    }

    /* JADX INFO: compiled from: MultiItemTypeAdapter.kt */
    static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ ViewHolder f17309t;

        d(ViewHolder viewHolder) {
            this.f17309t = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (MultiItemTypeAdapter.this.getF17306d() != null) {
                int adapterPosition = this.f17309t.getAdapterPosition() - MultiItemTypeAdapter.this.b();
                b f17306d = MultiItemTypeAdapter.this.getF17306d();
                if (f17306d != null) {
                    f17306d.b(view, this.f17309t, adapterPosition);
                } else {
                    i.a();
                    throw null;
                }
            }
        }
    }

    /* JADX INFO: compiled from: MultiItemTypeAdapter.kt */
    static final class e implements View.OnLongClickListener {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ ViewHolder f17311t;

        e(ViewHolder viewHolder) {
            this.f17311t = viewHolder;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            if (MultiItemTypeAdapter.this.getF17306d() == null) {
                return false;
            }
            int adapterPosition = this.f17311t.getAdapterPosition() - MultiItemTypeAdapter.this.b();
            b f17306d = MultiItemTypeAdapter.this.getF17306d();
            if (f17306d != null) {
                return f17306d.a(view, this.f17311t, adapterPosition);
            }
            i.a();
            throw null;
        }
    }

    static {
        new a(null);
    }

    public MultiItemTypeAdapter(@NotNull List<? extends T> list) {
        this.f17307e = list;
    }

    private final int e() {
        return (getItemCount() - b()) - a();
    }

    public final void a(@NotNull ViewHolder viewHolder, @NotNull View view) {
    }

    protected final boolean a(int i2) {
        return true;
    }

    @Nullable
    /* JADX INFO: renamed from: c, reason: from getter */
    protected final b getF17306d() {
        return this.f17306d;
    }

    protected final boolean d() {
        return this.f17305c.a() > 0;
    }

    @NotNull
    public final List<T> getData() {
        return this.f17307e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return b() + a() + this.f17307e.size();
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
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return c(position) ? this.a.keyAt(position) : b(position) ? this.b.keyAt((position - b()) - e()) : !d() ? super.getItemViewType(position) : this.f17305c.a(this.f17307e.get(position - b()), position - b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        WrapperUtils.a.a(recyclerView, new q<GridLayoutManager, GridLayoutManager.SpanSizeLookup, Integer, Integer>() { // from class: com.lxj.easyadapter.MultiItemTypeAdapter.onAttachedToRecyclerView.1
            {
                super(3);
            }

            @Override // kotlin.jvm.b.q
            public /* bridge */ /* synthetic */ Integer a(GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup, Integer num) {
                return Integer.valueOf(a(gridLayoutManager, spanSizeLookup, num.intValue()));
            }

            public final int a(@NotNull GridLayoutManager gridLayoutManager, @NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup, int i2) {
                int itemViewType = MultiItemTypeAdapter.this.getItemViewType(i2);
                if (MultiItemTypeAdapter.this.a.get(itemViewType) == null && MultiItemTypeAdapter.this.b.get(itemViewType) == null) {
                    return spanSizeLookup.getSpanSize(i2);
                }
                return gridLayoutManager.getSpanCount();
            }
        });
    }

    private final boolean c(int i2) {
        return i2 < b();
    }

    public final int a() {
        return this.b.size();
    }

    public final int b() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i2) {
        if (this.a.get(i2) != null) {
            ViewHolder.a aVar = ViewHolder.f17314c;
            View view = this.a.get(i2);
            if (view != null) {
                return aVar.a(view);
            }
            i.a();
            throw null;
        }
        if (this.b.get(i2) == null) {
            ViewHolder viewHolderA = ViewHolder.f17314c.a(viewGroup.getContext(), viewGroup, this.f17305c.a(i2).a());
            a(viewHolderA, viewHolderA.getB());
            a(viewGroup, viewHolderA, i2);
            return viewHolderA;
        }
        ViewHolder.a aVar2 = ViewHolder.f17314c;
        View view2 = this.b.get(i2);
        if (view2 != null) {
            return aVar2.a(view2);
        }
        i.a();
        throw null;
    }

    private final boolean b(int i2) {
        return i2 >= b() + e();
    }

    public final void a(@NotNull ViewHolder viewHolder, T t2) {
        this.f17305c.a(viewHolder, t2, viewHolder.getAdapterPosition() - b());
    }

    protected final void a(@NotNull ViewGroup viewGroup, @NotNull ViewHolder viewHolder, int i2) {
        if (a(i2)) {
            viewHolder.getB().setOnClickListener(new d(viewHolder));
            viewHolder.getB().setOnLongClickListener(new e(viewHolder));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i2) {
        if (c(i2) || b(i2)) {
            return;
        }
        a(viewHolder, this.f17307e.get(i2 - b()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@NotNull ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        int layoutPosition = viewHolder.getLayoutPosition();
        if (c(layoutPosition) || b(layoutPosition)) {
            WrapperUtils.a.a(viewHolder);
        }
    }

    @NotNull
    public final MultiItemTypeAdapter<T> a(@NotNull com.lxj.easyadapter.b<T> bVar) {
        this.f17305c.a(bVar);
        return this;
    }

    public final void a(@NotNull b bVar) {
        this.f17306d = bVar;
    }
}
