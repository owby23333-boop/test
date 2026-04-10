package com.chad.library.adapter4.dragswipe;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.RecyclerView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.chad.library.adapter4.dragswipe.listener.OnItemDragListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DragSwipeExt.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J(\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u001a\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, d2 = {"com/chad/library/adapter4/dragswipe/DragSwipeExtKt$setItemDragListener$4$listener$1", "Lcom/chad/library/adapter4/dragswipe/listener/OnItemDragListener;", "onItemDragEnd", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pos", "", "onItemDragMoving", "source", "from", TypedValues.Attributes.S_TARGET, "to", "onItemDragStart", "com.github.CymChad.brvah"}, k = 1, mv = {1, 9, 0}, xi = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD)
public final class DragSwipeExtKt$setItemDragListener$4$listener$1 implements OnItemDragListener {
    final /* synthetic */ Function2<RecyclerView.ViewHolder, Integer, Unit> $onItemDragEnd;
    final /* synthetic */ Function4<RecyclerView.ViewHolder, Integer, RecyclerView.ViewHolder, Integer, Unit> $onItemDragMoving;
    final /* synthetic */ Function2<RecyclerView.ViewHolder, Integer, Unit> $onItemDragStart;

    /* JADX WARN: Multi-variable type inference failed */
    public DragSwipeExtKt$setItemDragListener$4$listener$1(Function2<? super RecyclerView.ViewHolder, ? super Integer, Unit> function2, Function4<? super RecyclerView.ViewHolder, ? super Integer, ? super RecyclerView.ViewHolder, ? super Integer, Unit> function4, Function2<? super RecyclerView.ViewHolder, ? super Integer, Unit> function22) {
        this.$onItemDragStart = function2;
        this.$onItemDragMoving = function4;
        this.$onItemDragEnd = function22;
    }

    @Override // com.chad.library.adapter4.dragswipe.listener.OnItemDragListener
    public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {
        this.$onItemDragStart.invoke(viewHolder, Integer.valueOf(pos));
    }

    @Override // com.chad.library.adapter4.dragswipe.listener.OnItemDragListener
    public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        this.$onItemDragMoving.invoke(source, Integer.valueOf(from), target, Integer.valueOf(to));
    }

    @Override // com.chad.library.adapter4.dragswipe.listener.OnItemDragListener
    public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        this.$onItemDragEnd.invoke(viewHolder, Integer.valueOf(pos));
    }
}
