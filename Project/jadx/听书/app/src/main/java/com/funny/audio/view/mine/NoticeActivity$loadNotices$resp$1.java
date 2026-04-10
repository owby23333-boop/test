package com.funny.audio.view.mine;

import com.funny.audio.api.ApiManager;
import com.funny.audio.core.net.PageData;
import com.funny.audio.core.net.Response;
import com.funny.audio.models.SystemNoticeInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NoticeActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lcom/funny/audio/core/net/Response;", "Lcom/funny/audio/core/net/PageData;", "Lcom/funny/audio/models/SystemNoticeInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.view.mine.NoticeActivity$loadNotices$resp$1", f = "NoticeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NoticeActivity$loadNotices$resp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Response<PageData<SystemNoticeInfo>>>, Object> {
    final /* synthetic */ String $channel;
    final /* synthetic */ String $key;
    int label;
    final /* synthetic */ NoticeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NoticeActivity$loadNotices$resp$1(String str, String str2, NoticeActivity noticeActivity, Continuation<? super NoticeActivity$loadNotices$resp$1> continuation) {
        super(2, continuation);
        this.$key = str;
        this.$channel = str2;
        this.this$0 = noticeActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NoticeActivity$loadNotices$resp$1(this.$key, this.$channel, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Response<PageData<SystemNoticeInfo>>> continuation) {
        return ((NoticeActivity$loadNotices$resp$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return ApiManager.INSTANCE.getNotice().getSystemNoticeList(this.$key, this.$channel, this.this$0.getPage());
    }
}
