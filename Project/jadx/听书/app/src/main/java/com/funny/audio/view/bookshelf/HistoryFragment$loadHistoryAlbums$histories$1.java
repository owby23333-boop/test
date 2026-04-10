package com.funny.audio.view.bookshelf;

import com.funny.audio.database.DbContext;
import com.funny.audio.database.entities.PlayHistoryEntity;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HistoryFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/funny/audio/database/entities/PlayHistoryEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.view.bookshelf.HistoryFragment$loadHistoryAlbums$histories$1", f = "HistoryFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class HistoryFragment$loadHistoryAlbums$histories$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<PlayHistoryEntity>>, Object> {
    int label;
    final /* synthetic */ HistoryFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HistoryFragment$loadHistoryAlbums$histories$1(HistoryFragment historyFragment, Continuation<? super HistoryFragment$loadHistoryAlbums$histories$1> continuation) {
        super(2, continuation);
        this.this$0 = historyFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoryFragment$loadHistoryAlbums$histories$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<PlayHistoryEntity>> continuation) {
        return ((HistoryFragment$loadHistoryAlbums$histories$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r11v18, types: [java.time.ZonedDateTime] */
    /* JADX WARN: Type inference failed for: r11v23, types: [java.time.ZonedDateTime] */
    /* JADX WARN: Type inference failed for: r11v32, types: [java.time.ZonedDateTime] */
    /* JADX WARN: Type inference failed for: r11v36, types: [java.time.ZonedDateTime] */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.time.ZonedDateTime] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int i = this.this$0.filterType;
            if (i == FilterHistoryType.INSTANCE.getAll()) {
                return DbContext.INSTANCE.getCurrent().playHistory().pageByAll(this.this$0.page, this.this$0.pageSize);
            }
            if (i == FilterHistoryType.INSTANCE.getToday()) {
                return DbContext.INSTANCE.getCurrent().playHistory().pageByTimeFilter(LocalDateTime.now().with((TemporalAdjuster) LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(), LocalDateTime.now().with((TemporalAdjuster) LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(), this.this$0.page, this.this$0.pageSize);
            }
            if (i == FilterHistoryType.INSTANCE.getYesterday()) {
                return DbContext.INSTANCE.getCurrent().playHistory().pageByTimeFilter(LocalDateTime.now().minusDays(1L).with((TemporalAdjuster) LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(), LocalDateTime.now().minusDays(1L).with((TemporalAdjuster) LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(), this.this$0.page, this.this$0.pageSize);
            }
            if (i == FilterHistoryType.INSTANCE.getEarlier()) {
                return DbContext.INSTANCE.getCurrent().playHistory().pageByTimeBefore(LocalDateTime.now().minusDays(1L).with((TemporalAdjuster) LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(), this.this$0.page, this.this$0.pageSize);
            }
            return new ArrayList();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
