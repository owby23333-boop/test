package com.funny.audio.view.bookshelf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CollectFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.view.bookshelf.CollectFragment$startCheckUpdateJob$1$newJob$1", f = "CollectFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY, TypedValues.Cycle.TYPE_WAVE_PHASE}, m = "invokeSuspend", n = {}, s = {})
final class CollectFragment$startCheckUpdateJob$1$newJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CollectFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CollectFragment$startCheckUpdateJob$1$newJob$1(CollectFragment collectFragment, Continuation<? super CollectFragment$startCheckUpdateJob$1$newJob$1> continuation) {
        super(2, continuation);
        this.this$0 = collectFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectFragment$startCheckUpdateJob$1$newJob$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CollectFragment$startCheckUpdateJob$1$newJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Path cross not found for [B:12:0x0020, B:4:0x000c], limit reached: 56 */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0030 A[Catch: Exception -> 0x01bd, TryCatch #1 {Exception -> 0x01bd, blocks: (B:14:0x0024, B:16:0x0030, B:19:0x003e, B:20:0x004e, B:22:0x0054, B:33:0x018f, B:23:0x005a, B:25:0x006e, B:28:0x00b0, B:29:0x0142, B:30:0x0168), top: B:41:0x0024, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x003e A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x01c9 -> B:41:0x0024). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.bookshelf.CollectFragment$startCheckUpdateJob$1$newJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
