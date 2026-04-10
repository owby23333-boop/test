package com.funny.audio.view.bookshelf;

import com.funny.audio.database.DbContext;
import com.funny.audio.database.entities.BookshelfEntity;
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

/* JADX INFO: compiled from: CollectFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/funny/audio/database/entities/BookshelfEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.view.bookshelf.CollectFragment$loadCollect$list$1", f = "CollectFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CollectFragment$loadCollect$list$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<BookshelfEntity>>, Object> {
    int label;
    final /* synthetic */ CollectFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CollectFragment$loadCollect$list$1(CollectFragment collectFragment, Continuation<? super CollectFragment$loadCollect$list$1> continuation) {
        super(2, continuation);
        this.this$0 = collectFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectFragment$loadCollect$list$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<BookshelfEntity>> continuation) {
        return ((CollectFragment$loadCollect$list$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int i = this.this$0.filterType;
            if (i == FilterCollectType.INSTANCE.getRecentlyRead()) {
                return DbContext.INSTANCE.getCurrent().bookshelf().listByLatestRead();
            }
            if (i == FilterCollectType.INSTANCE.getRecentlyCollect()) {
                return DbContext.INSTANCE.getCurrent().bookshelf().listByLatestCollect();
            }
            if (i == FilterCollectType.INSTANCE.getRecentlyUpdate()) {
                return DbContext.INSTANCE.getCurrent().bookshelf().listByLatestUpdate();
            }
            return new ArrayList();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
