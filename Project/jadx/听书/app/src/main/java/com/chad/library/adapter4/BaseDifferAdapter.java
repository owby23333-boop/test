package com.chad.library.adapter4;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: BaseDifferAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0015\b\u0016\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0002\u0010\u000bB\u0015\b\u0016\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0002\u0010\u000eB!\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u001f\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010\u001fJ\u001d\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J'\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00028\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010#J\u001e\u0010$\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016J(\u0010$\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0016\u0010$\u001a\u00020\u001a2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016J \u0010$\u001a\u00020\u001a2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020!H\u0016J\"\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J$\u0010*\u001a\u00020\u001a2\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016J\u0015\u0010-\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u001f\u0010-\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010\u001fJ\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0016J\u001a\u0010.\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u000201H\u0016J\u001a\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u0002012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001e\u00102\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\"J'\u00102\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00028\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0002\u0010#J\u0018\u00103\u001a\u00020\u001a2\u000e\u00104\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nH\u0016J \u00103\u001a\u00020\u001a2\u000e\u00104\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0018\u00105\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020!H\u0016J\"\u00105\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R0\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/chad/library/adapter4/BaseDifferAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/chad/library/adapter4/BaseQuickAdapter;", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "items", "", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;Ljava/util/List;)V", "config", "Landroidx/recyclerview/widget/AsyncDifferConfig;", "(Landroidx/recyclerview/widget/AsyncDifferConfig;)V", "(Landroidx/recyclerview/widget/AsyncDifferConfig;Ljava/util/List;)V", "value", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "mDiffer", "Landroidx/recyclerview/widget/AsyncListDiffer;", "mListener", "Landroidx/recyclerview/widget/AsyncListDiffer$ListListener;", "add", "", "data", "(Ljava/lang/Object;)V", "commitCallback", "Ljava/lang/Runnable;", "(Ljava/lang/Object;Ljava/lang/Runnable;)V", "position", "", "(ILjava/lang/Object;)V", "(ILjava/lang/Object;Ljava/lang/Runnable;)V", "addAll", "collection", "", "move", "fromPosition", "toPosition", "onCurrentListChanged", "previousList", "currentList", "remove", "removeAt", "removeAtRange", "range", "Lkotlin/ranges/IntRange;", "set", "submitList", "list", "swap", "com.github.CymChad.brvah"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BaseDifferAdapter<T, VH extends RecyclerView.ViewHolder> extends BaseQuickAdapter<T, VH> {
    private final AsyncListDiffer<T> mDiffer;
    private final AsyncListDiffer.ListListener<T> mListener;

    public void onCurrentListChanged(List<? extends T> previousList, List<? extends T> currentList) {
        Intrinsics.checkNotNullParameter(previousList, "previousList");
        Intrinsics.checkNotNullParameter(currentList, "currentList");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDifferAdapter(AsyncDifferConfig<T> config, List<? extends T> items) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(items, "items");
        AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), config);
        this.mDiffer = asyncListDiffer;
        AsyncListDiffer.ListListener<T> listListener = new AsyncListDiffer.ListListener() { // from class: com.chad.library.adapter4.BaseDifferAdapter$$ExternalSyntheticLambda0
            @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
            public final void onCurrentListChanged(List list, List list2) {
                BaseDifferAdapter.mListener$lambda$0(this.f$0, list, list2);
            }
        };
        this.mListener = listListener;
        asyncListDiffer.addListListener(listListener);
        asyncListDiffer.submitList(items);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseDifferAdapter(DiffUtil.ItemCallback<T> diffCallback) {
        this(diffCallback, CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BaseDifferAdapter(DiffUtil.ItemCallback<T> diffCallback, List<? extends T> items) {
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        Intrinsics.checkNotNullParameter(items, "items");
        AsyncDifferConfig<T> asyncDifferConfigBuild = new AsyncDifferConfig.Builder(diffCallback).build();
        Intrinsics.checkNotNullExpressionValue(asyncDifferConfigBuild, "build(...)");
        this(asyncDifferConfigBuild, items);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseDifferAdapter(AsyncDifferConfig<T> config) {
        this(config, CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(config, "config");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mListener$lambda$0(BaseDifferAdapter this$0, List previousList, List currentList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(previousList, "previousList");
        Intrinsics.checkNotNullParameter(currentList, "currentList");
        boolean zDisplayEmptyView = this$0.displayEmptyView(previousList);
        boolean zDisplayEmptyView2 = this$0.displayEmptyView(currentList);
        if (zDisplayEmptyView && !zDisplayEmptyView2) {
            this$0.notifyItemRemoved(0);
            this$0.getRecyclerView().scrollToPosition(0);
        } else if (zDisplayEmptyView2 && !zDisplayEmptyView) {
            this$0.notifyItemInserted(0);
        } else if (zDisplayEmptyView && zDisplayEmptyView2) {
            this$0.notifyItemChanged(0, 0);
        }
        this$0.onCurrentListChanged(previousList, currentList);
    }

    @Override // com.chad.library.adapter4.BaseQuickAdapter
    public final List<T> getItems() {
        List<T> currentList = this.mDiffer.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        return currentList;
    }

    @Override // com.chad.library.adapter4.BaseQuickAdapter
    public final void setItems(List<? extends T> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.mDiffer.submitList(value, null);
    }

    @Override // com.chad.library.adapter4.BaseQuickAdapter
    public void submitList(List<? extends T> list) {
        this.mDiffer.submitList(list, null);
    }

    public final void submitList(List<? extends T> list, Runnable commitCallback) {
        this.mDiffer.submitList(list, commitCallback);
    }

    @Override // com.chad.library.adapter4.BaseQuickAdapter
    public void set(int position, T data) {
        Intrinsics.checkNotNullParameter(data, "data");
        set(position, data, null);
    }

    @Override // com.chad.library.adapter4.BaseQuickAdapter
    public void add(T data) {
        Intrinsics.checkNotNullParameter(data, "data");
        add(data, (Runnable) null);
    }

    @Override // com.chad.library.adapter4.BaseQuickAdapter
    public void add(int position, T data) {
        Intrinsics.checkNotNullParameter(data, "data");
        add(position, data, null);
    }

    @Override // com.chad.library.adapter4.BaseQuickAdapter
    public void addAll(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        addAll(collection, (Runnable) null);
    }

    @Override // com.chad.library.adapter4.BaseQuickAdapter
    public void addAll(int position, Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        addAll(position, collection, null);
    }

    @Override // com.chad.library.adapter4.BaseQuickAdapter
    public void removeAt(int position) {
        removeAt(position, null);
    }

    @Override // com.chad.library.adapter4.BaseQuickAdapter
    public void remove(T data) {
        Intrinsics.checkNotNullParameter(data, "data");
        remove(data, null);
    }

    @Override // com.chad.library.adapter4.BaseQuickAdapter
    public void removeAtRange(IntRange range) {
        Intrinsics.checkNotNullParameter(range, "range");
        removeAtRange(range, null);
    }

    @Override // com.chad.library.adapter4.BaseQuickAdapter
    public void swap(int fromPosition, int toPosition) {
        swap(fromPosition, toPosition, null);
    }

    @Override // com.chad.library.adapter4.BaseQuickAdapter
    public void move(int fromPosition, int toPosition) {
        move(fromPosition, toPosition, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void set(int position, T data, Runnable commitCallback) {
        Intrinsics.checkNotNullParameter(data, "data");
        List<? extends T> mutableList = CollectionsKt.toMutableList((Collection) getItems());
        mutableList.set(position, data);
        submitList(mutableList, commitCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void add(T data, Runnable commitCallback) {
        Intrinsics.checkNotNullParameter(data, "data");
        List<? extends T> mutableList = CollectionsKt.toMutableList((Collection) getItems());
        mutableList.add(data);
        submitList(mutableList, commitCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void add(int position, T data, Runnable commitCallback) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (position > getItems().size() || position < 0) {
            throw new IndexOutOfBoundsException("position: " + position + ". size:" + getItems().size());
        }
        List<? extends T> mutableList = CollectionsKt.toMutableList((Collection) getItems());
        mutableList.add(position, data);
        submitList(mutableList, commitCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(Collection<? extends T> collection, Runnable commitCallback) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        List<? extends T> mutableList = CollectionsKt.toMutableList((Collection) getItems());
        mutableList.addAll(collection);
        submitList(mutableList, commitCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(int position, Collection<? extends T> collection, Runnable commitCallback) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        if (position > getItems().size() || position < 0) {
            throw new IndexOutOfBoundsException("position: " + position + ". size:" + getItems().size());
        }
        List<? extends T> mutableList = CollectionsKt.toMutableList((Collection) getItems());
        mutableList.addAll(position, collection);
        submitList(mutableList, commitCallback);
    }

    public void removeAt(int position, Runnable commitCallback) {
        if (position >= getItems().size()) {
            throw new IndexOutOfBoundsException("position: " + position + ". size:" + getItems().size());
        }
        List<? extends T> mutableList = CollectionsKt.toMutableList((Collection) getItems());
        mutableList.remove(position);
        submitList(mutableList, commitCallback);
    }

    public void remove(T data, Runnable commitCallback) {
        Intrinsics.checkNotNullParameter(data, "data");
        List<? extends T> mutableList = CollectionsKt.toMutableList((Collection) getItems());
        mutableList.remove(data);
        submitList(mutableList, commitCallback);
    }

    public void removeAtRange(IntRange range, Runnable commitCallback) {
        int last;
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            return;
        }
        if (range.getFirst() >= getItems().size()) {
            throw new IndexOutOfBoundsException("Range first position: " + range.getFirst() + " - last position: " + range.getLast() + ". size:" + getItems().size());
        }
        if (range.getLast() >= getItems().size()) {
            last = getItems().size() - 1;
        } else {
            last = range.getLast();
        }
        List<? extends T> mutableList = CollectionsKt.toMutableList((Collection) getItems());
        int first = range.getFirst();
        if (first <= last) {
            while (true) {
                mutableList.remove(last);
                if (last == first) {
                    break;
                } else {
                    last--;
                }
            }
        }
        submitList(mutableList, commitCallback);
    }

    public void swap(int fromPosition, int toPosition, Runnable commitCallback) {
        if (!(fromPosition >= 0 && fromPosition < getItems().size())) {
            if (!(toPosition >= 0 && toPosition < getItems().size())) {
                return;
            }
        }
        List<? extends T> mutableList = CollectionsKt.toMutableList((Collection) getItems());
        Collections.swap(mutableList, fromPosition, toPosition);
        submitList(mutableList, commitCallback);
    }

    public void move(int fromPosition, int toPosition, Runnable commitCallback) {
        if (!(fromPosition >= 0 && fromPosition < getItems().size())) {
            if (!(toPosition >= 0 && toPosition < getItems().size())) {
                return;
            }
        }
        List<? extends T> mutableList = CollectionsKt.toMutableList((Collection) getItems());
        mutableList.add(toPosition, mutableList.remove(fromPosition));
        submitList(mutableList, commitCallback);
    }
}
