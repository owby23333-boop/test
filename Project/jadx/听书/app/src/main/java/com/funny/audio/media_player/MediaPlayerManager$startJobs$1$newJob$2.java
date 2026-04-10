package com.funny.audio.media_player;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.funny.audio.database.DbContext;
import com.funny.audio.database.entities.BookshelfEntity;
import com.funny.audio.database.entities.PlayHistoryEntity;
import com.funny.audio.database.entities.PlayProgressEntity;
import com.funny.audio.models.AlbumDetailInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MediaPlayerManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.media_player.MediaPlayerManager$startJobs$1$newJob$2", f = "MediaPlayerManager.kt", i = {}, l = {TTAdConstant.IMAGE_LIST_CODE, TTAdConstant.VIDEO_COVER_URL_CODE}, m = "invokeSuspend", n = {}, s = {})
final class MediaPlayerManager$startJobs$1$newJob$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    MediaPlayerManager$startJobs$1$newJob$2(Continuation<? super MediaPlayerManager$startJobs$1$newJob$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaPlayerManager$startJobs$1$newJob$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MediaPlayerManager$startJobs$1$newJob$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0036 A[Catch: Exception -> 0x005d, TryCatch #1 {Exception -> 0x005d, blocks: (B:12:0x0021, B:14:0x0036, B:16:0x0040, B:18:0x004c, B:20:0x0054), top: B:38:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0065 A[Catch: Exception -> 0x017e, TryCatch #0 {Exception -> 0x017e, blocks: (B:21:0x005d, B:23:0x0065, B:27:0x014d, B:26:0x0142), top: B:36:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x018b A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0189 -> B:38:0x0021). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.media_player.MediaPlayerManager$startJobs$1$newJob$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.funny.audio.media_player.MediaPlayerManager$startJobs$1$newJob$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: MediaPlayerManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.media_player.MediaPlayerManager$startJobs$1$newJob$2$1", f = "MediaPlayerManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AlbumDetailInfo $albumInfo;
        final /* synthetic */ PlayHistoryEntity $playHistory;
        final /* synthetic */ PlayProgressEntity $playProgressInfo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PlayProgressEntity playProgressEntity, PlayHistoryEntity playHistoryEntity, AlbumDetailInfo albumDetailInfo, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$playProgressInfo = playProgressEntity;
            this.$playHistory = playHistoryEntity;
            this.$albumInfo = albumDetailInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$playProgressInfo, this.$playHistory, this.$albumInfo, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            DbContext.INSTANCE.getCurrent().playProgress().add(this.$playProgressInfo);
            DbContext.INSTANCE.getCurrent().playHistory().add(this.$playHistory);
            BookshelfEntity bookshelfEntity = DbContext.INSTANCE.getCurrent().bookshelf().get(this.$albumInfo.getId());
            if (bookshelfEntity != null) {
                bookshelfEntity.setLastReadTime(this.$playProgressInfo.getTime());
                bookshelfEntity.setTrackIndex(this.$playProgressInfo.getTrackIndex());
                DbContext.INSTANCE.getCurrent().bookshelf().modify(bookshelfEntity);
            }
            return Unit.INSTANCE;
        }
    }
}
