package com.funny.audio.media_player;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MediaPlayerManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.media_player.MediaPlayerManager$startJobs$1$newJob$1", f = "MediaPlayerManager.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME}, m = "invokeSuspend", n = {}, s = {})
final class MediaPlayerManager$startJobs$1$newJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    MediaPlayerManager$startJobs$1$newJob$1(Continuation<? super MediaPlayerManager$startJobs$1$newJob$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaPlayerManager$startJobs$1$newJob$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MediaPlayerManager$startJobs$1$newJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005c A[Catch: Exception -> 0x00a1, TryCatch #2 {Exception -> 0x00a1, blocks: (B:9:0x0023, B:11:0x005c, B:12:0x0077), top: B:64:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a9 A[Catch: Exception -> 0x01a7, TryCatch #0 {Exception -> 0x01a7, blocks: (B:13:0x00a1, B:15:0x00a9, B:17:0x00b1, B:19:0x00c3, B:21:0x00df, B:23:0x00fb, B:24:0x0112, B:26:0x011a, B:28:0x0122, B:30:0x0134, B:32:0x015b, B:33:0x0164, B:35:0x016c, B:37:0x0174, B:42:0x018b), top: B:60:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x011a A[Catch: Exception -> 0x01a7, TryCatch #0 {Exception -> 0x01a7, blocks: (B:13:0x00a1, B:15:0x00a9, B:17:0x00b1, B:19:0x00c3, B:21:0x00df, B:23:0x00fb, B:24:0x0112, B:26:0x011a, B:28:0x0122, B:30:0x0134, B:32:0x015b, B:33:0x0164, B:35:0x016c, B:37:0x0174, B:42:0x018b), top: B:60:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x016c A[Catch: Exception -> 0x01a7, TryCatch #0 {Exception -> 0x01a7, blocks: (B:13:0x00a1, B:15:0x00a9, B:17:0x00b1, B:19:0x00c3, B:21:0x00df, B:23:0x00fb, B:24:0x0112, B:26:0x011a, B:28:0x0122, B:30:0x0134, B:32:0x015b, B:33:0x0164, B:35:0x016c, B:37:0x0174, B:42:0x018b), top: B:60:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x018b A[Catch: Exception -> 0x01a7, TRY_LEAVE, TryCatch #0 {Exception -> 0x01a7, blocks: (B:13:0x00a1, B:15:0x00a9, B:17:0x00b1, B:19:0x00c3, B:21:0x00df, B:23:0x00fb, B:24:0x0112, B:26:0x011a, B:28:0x0122, B:30:0x0134, B:32:0x015b, B:33:0x0164, B:35:0x016c, B:37:0x0174, B:42:0x018b), top: B:60:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01bf A[Catch: Exception -> 0x0226, TryCatch #1 {Exception -> 0x0226, blocks: (B:46:0x01b3, B:48:0x01bf, B:50:0x01c7, B:52:0x01d9, B:54:0x01e7, B:55:0x0215), top: B:62:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01e7 A[Catch: Exception -> 0x0226, TryCatch #1 {Exception -> 0x0226, blocks: (B:46:0x01b3, B:48:0x01bf, B:50:0x01c7, B:52:0x01d9, B:54:0x01e7, B:55:0x0215), top: B:62:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0215 A[Catch: Exception -> 0x0226, TRY_LEAVE, TryCatch #1 {Exception -> 0x0226, blocks: (B:46:0x01b3, B:48:0x01bf, B:50:0x01c7, B:52:0x01d9, B:54:0x01e7, B:55:0x0215), top: B:62:0x01b3 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x01b0 -> B:62:0x01b3). Please report as a decompilation issue!!! */
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
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instruction units count: 554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.media_player.MediaPlayerManager$startJobs$1$newJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
