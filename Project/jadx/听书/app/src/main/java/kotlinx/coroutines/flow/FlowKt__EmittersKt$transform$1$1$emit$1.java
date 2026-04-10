package kotlinx.coroutines.flow;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowKt__EmittersKt;

/* JADX INFO: compiled from: Emitters.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1", f = "Emitters.kt", i = {}, l = {38}, m = "emit", n = {}, s = {})
public final class FlowKt__EmittersKt$transform$1$1$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowKt__EmittersKt.AnonymousClass1.C05051<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__EmittersKt$transform$1$1$emit$1(FlowKt__EmittersKt.AnonymousClass1.C05051<? super T> c05051, Continuation<? super FlowKt__EmittersKt$transform$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c05051;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
