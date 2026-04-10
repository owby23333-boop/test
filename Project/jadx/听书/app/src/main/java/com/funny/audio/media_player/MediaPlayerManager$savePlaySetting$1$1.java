package com.funny.audio.media_player;

import com.funny.audio.core.utils.TextUtils;
import com.funny.audio.database.DbContext;
import com.funny.audio.database.entities.PlaySettingEntity;
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
@DebugMetadata(c = "com.funny.audio.media_player.MediaPlayerManager$savePlaySetting$1$1", f = "MediaPlayerManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MediaPlayerManager$savePlaySetting$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AlbumDetailInfo $albumDetailInfo;
    int label;
    final /* synthetic */ MediaPlayerManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaPlayerManager$savePlaySetting$1$1(AlbumDetailInfo albumDetailInfo, MediaPlayerManager mediaPlayerManager, Continuation<? super MediaPlayerManager$savePlaySetting$1$1> continuation) {
        super(2, continuation);
        this.$albumDetailInfo = albumDetailInfo;
        this.this$0 = mediaPlayerManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaPlayerManager$savePlaySetting$1$1(this.$albumDetailInfo, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MediaPlayerManager$savePlaySetting$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        PlaySettingEntity playSettingEntity = new PlaySettingEntity();
        playSettingEntity.setAlbumId(this.$albumDetailInfo.getId());
        playSettingEntity.setValue(TextUtils.INSTANCE.serializeJson(this.this$0.getCurrentPlaySetting()));
        playSettingEntity.setTime(System.currentTimeMillis());
        DbContext.INSTANCE.getCurrent().playSetting().add(playSettingEntity);
        return Unit.INSTANCE;
    }
}
