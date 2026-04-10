package com.funny.audio.view.album;

import com.funny.audio.database.DbContext;
import com.funny.audio.database.entities.BookshelfEntity;
import com.funny.audio.database.entities.PlayProgressEntity;
import com.funny.audio.models.AlbumDetailInfo;
import com.funny.audio.models.AnnouncerItem;
import com.funny.audio.models.CategoryItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AlbumDetailActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.view.album.AlbumDetailActivity$collect$2$1", f = "AlbumDetailActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AlbumDetailActivity$collect$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AlbumDetailInfo $albumDetailInfo;
    int label;
    final /* synthetic */ AlbumDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AlbumDetailActivity$collect$2$1(AlbumDetailInfo albumDetailInfo, AlbumDetailActivity albumDetailActivity, Continuation<? super AlbumDetailActivity$collect$2$1> continuation) {
        super(2, continuation);
        this.$albumDetailInfo = albumDetailInfo;
        this.this$0 = albumDetailActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AlbumDetailActivity$collect$2$1(this.$albumDetailInfo, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AlbumDetailActivity$collect$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        BookshelfEntity bookshelfEntity = new BookshelfEntity();
        bookshelfEntity.setAlbumId(this.$albumDetailInfo.getId());
        bookshelfEntity.setTitle(this.$albumDetailInfo.getTitle());
        AnnouncerItem announcerItem = (AnnouncerItem) CollectionsKt.firstOrNull((List) this.$albumDetailInfo.getAnnouncers());
        String id = announcerItem != null ? announcerItem.getId() : null;
        bookshelfEntity.setAnnouncer(announcerItem != null ? announcerItem.getAnnouncerName() : null);
        bookshelfEntity.setAnnouncerId(id);
        bookshelfEntity.setCoverPath(this.$albumDetailInfo.getCoverPath());
        CategoryItem categoryItem = (CategoryItem) CollectionsKt.firstOrNull((List) this.$albumDetailInfo.getCategories());
        String categoryName = categoryItem != null ? categoryItem.getCategoryName() : null;
        String id2 = categoryItem != null ? categoryItem.getId() : null;
        bookshelfEntity.setCategory(categoryName);
        bookshelfEntity.setCategoryId(id2);
        bookshelfEntity.setFinishStatus(this.$albumDetailInfo.getFinishStatus());
        bookshelfEntity.setTrackCount(this.$albumDetailInfo.getTrackCount());
        bookshelfEntity.setLatestTrackId(this.$albumDetailInfo.getLatestTrackId());
        bookshelfEntity.setLatestTrackTitle(this.$albumDetailInfo.getLatestTrackTitle());
        Long latestTrackTime = this.$albumDetailInfo.getLatestTrackTime();
        if (latestTrackTime != null) {
            bookshelfEntity.setLastUpdateTime(latestTrackTime.longValue());
        }
        bookshelfEntity.setCollectTime(System.currentTimeMillis());
        PlayProgressEntity playProgressEntityLatest = DbContext.INSTANCE.getCurrent().playProgress().latest(this.$albumDetailInfo.getId());
        if (playProgressEntityLatest != null) {
            bookshelfEntity.setTrackIndex(playProgressEntityLatest.getTrackIndex());
            bookshelfEntity.setLastReadTime(playProgressEntityLatest.getTime());
        }
        DbContext.INSTANCE.getCurrent().bookshelf().add(bookshelfEntity);
        this.this$0.isCollect = true;
        return Unit.INSTANCE;
    }
}
