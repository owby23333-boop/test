package com.funny.audio.user;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: UserManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.user.UserManager$startSyncBookshelfData$1$newJob$1", f = "UserManager.kt", i = {}, l = {81, 85, 89}, m = "invokeSuspend", n = {}, s = {})
final class UserManager$startSyncBookshelfData$1$newJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    UserManager$startSyncBookshelfData$1$newJob$1(Continuation<? super UserManager$startSyncBookshelfData$1$newJob$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserManager$startSyncBookshelfData$1$newJob$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UserManager$startSyncBookshelfData$1$newJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Path cross not found for [B:33:0x000b, B:15:0x0027], limit reached: 36 */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033 A[Catch: Exception -> 0x004f, TryCatch #0 {Exception -> 0x004f, blocks: (B:17:0x002b, B:19:0x0033, B:22:0x0041), top: B:31:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007d A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x007b -> B:31:0x002b). Please report as a decompilation issue!!! */
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
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L27
            if (r1 == r4) goto L1f
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            goto L27
        L12:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1a:
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L23
            r10 = r9
            goto L70
        L1f:
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L23
            goto L2a
        L23:
            r10 = move-exception
            r1 = r0
            r0 = r9
            goto L54
        L27:
            kotlin.ResultKt.throwOnFailure(r10)
        L2a:
            r10 = r9
        L2b:
            com.funny.audio.user.UserManager r1 = com.funny.audio.user.UserManager.INSTANCE     // Catch: java.lang.Exception -> L4f
            boolean r1 = r1.isLogin()     // Catch: java.lang.Exception -> L4f
            if (r1 != 0) goto L41
            r1 = r10
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch: java.lang.Exception -> L4f
            r10.label = r4     // Catch: java.lang.Exception -> L4f
            r5 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r5, r1)     // Catch: java.lang.Exception -> L4f
            if (r1 != r0) goto L2b
            return r0
        L41:
            com.funny.audio.user.UserManager r1 = com.funny.audio.user.UserManager.INSTANCE     // Catch: java.lang.Exception -> L4f
            r5 = r10
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Exception -> L4f
            r10.label = r3     // Catch: java.lang.Exception -> L4f
            java.lang.Object r1 = com.funny.audio.user.UserManager.access$syncBookshelfData(r1, r5)     // Catch: java.lang.Exception -> L4f
            if (r1 != r0) goto L70
            return r0
        L4f:
            r1 = move-exception
            r8 = r0
            r0 = r10
            r10 = r1
            r1 = r8
        L54:
            java.lang.String r5 = com.funny.audio.user.UserManager.access$getTagName$p()
            java.lang.String r10 = r10.getMessage()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "同步用户书架数据作业出错: "
            r6.<init>(r7)
            java.lang.StringBuilder r10 = r6.append(r10)
            java.lang.String r10 = r10.toString()
            android.util.Log.e(r5, r10)
            r10 = r0
            r0 = r1
        L70:
            r1 = r10
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r10.label = r2
            r5 = 15000(0x3a98, double:7.411E-320)
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r5, r1)
            if (r1 != r0) goto L2b
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.user.UserManager$startSyncBookshelfData$1$newJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
