package com.funny.audio.view.album;

import com.funny.audio.api.ApiManager;
import com.funny.audio.core.net.Response;
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

/* JADX INFO: compiled from: AlbumDetailActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lcom/funny/audio/core/net/Response;", "Lcom/funny/audio/models/AlbumDetailInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.view.album.AlbumDetailActivity$loadAlbumDetail$resp$1", f = "AlbumDetailActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AlbumDetailActivity$loadAlbumDetail$resp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response<AlbumDetailInfo>>, Object> {
    int label;
    final /* synthetic */ AlbumDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AlbumDetailActivity$loadAlbumDetail$resp$1(AlbumDetailActivity albumDetailActivity, Continuation<? super AlbumDetailActivity$loadAlbumDetail$resp$1> continuation) {
        super(2, continuation);
        this.this$0 = albumDetailActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AlbumDetailActivity$loadAlbumDetail$resp$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Response<AlbumDetailInfo>> continuation) {
        return ((AlbumDetailActivity$loadAlbumDetail$resp$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return ApiManager.INSTANCE.getBusiness().getAlbumDetailInfo(this.this$0.albumId);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
