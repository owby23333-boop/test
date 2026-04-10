package com.lxj.easyadapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.lxj.easyadapter.d, reason: from Kotlin metadata */
/* JADX INFO: compiled from: ViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/lxj/easyadapter/ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "convertView", "Landroid/view/View;", "(Landroid/view/View;)V", "getConvertView", "()Landroid/view/View;", "mViews", "Landroid/util/SparseArray;", "getView", ExifInterface.GPS_DIRECTION_TRUE, "viewId", "", "(I)Landroid/view/View;", "getViewOrNull", "setImageResource", "resId", "setText", "text", "", "Companion", "easy-adapter_release"}, k = 1, mv = {1, 1, 15})
public final class ViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f17314c = new a(null);
    private final SparseArray<View> a;

    @NotNull
    private final View b;

    /* JADX INFO: renamed from: com.lxj.easyadapter.d$a */
    /* JADX INFO: compiled from: ViewHolder.kt */
    public static final class a {
        private a() {
        }

        @NotNull
        public final ViewHolder a(@NotNull View view) {
            return new ViewHolder(view);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        @NotNull
        public final ViewHolder a(@NotNull Context context, @NotNull ViewGroup viewGroup, int i2) {
            return new ViewHolder(LayoutInflater.from(context).inflate(i2, viewGroup, false));
        }
    }

    public ViewHolder(@NotNull View view) {
        super(view);
        this.b = view;
        this.a = new SparseArray<>();
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: from getter */
    public final View getB() {
        return this.b;
    }

    @Nullable
    public final <T extends View> T b(int i2) {
        T t2 = (T) this.a.get(i2);
        if (t2 == null) {
            t2 = (T) this.b.findViewById(i2);
            this.a.put(i2, t2);
        }
        if (t2 instanceof View) {
            return t2;
        }
        return null;
    }

    @NotNull
    public final <T extends View> T a(int i2) {
        T t2 = (T) this.a.get(i2);
        if (t2 == null) {
            t2 = (T) this.b.findViewById(i2);
            this.a.put(i2, t2);
        }
        if (t2 != null) {
            return t2;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }

    @NotNull
    public final ViewHolder a(int i2, @NotNull CharSequence charSequence) {
        TextView textView = (TextView) a(i2);
        if (textView != null) {
            textView.setText(charSequence);
        }
        return this;
    }
}
