package com.funny.audio.view.update;

import com.funny.audio.models.CloudUpdateInfo;
import com.funny.audio.update.AppUpdater;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: UpdateDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.view.update.UpdateDialogFragment$update$2$1", f = "UpdateDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UpdateDialogFragment$update$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CloudUpdateInfo $updateInfo;
    int label;
    final /* synthetic */ UpdateDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UpdateDialogFragment$update$2$1(CloudUpdateInfo cloudUpdateInfo, UpdateDialogFragment updateDialogFragment, Continuation<? super UpdateDialogFragment$update$2$1> continuation) {
        super(2, continuation);
        this.$updateInfo = cloudUpdateInfo;
        this.this$0 = updateDialogFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpdateDialogFragment$update$2$1(this.$updateInfo, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UpdateDialogFragment$update$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        InputStream inputStreamByteStream;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Response responseExecute = AppUpdater.INSTANCE.getHttp().newCall(new Request.Builder().url(this.$updateInfo.getLatestDownloadUrl()).get().build()).execute();
        if (responseExecute.isSuccessful()) {
            ResponseBody responseBodyBody = responseExecute.body();
            if (responseBodyBody == null || (inputStreamByteStream = responseBodyBody.byteStream()) == null) {
                return Unit.INSTANCE;
            }
            ResponseBody responseBodyBody2 = responseExecute.body();
            Intrinsics.checkNotNull(responseBodyBody2);
            long contentLength = responseBodyBody2.getContentLength();
            File file = new File(this.this$0.requireContext().getCacheDir(), "update.apk");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[8192];
            int i = 0;
            for (int i2 = inputStreamByteStream.read(bArr); i2 > 0; i2 = inputStreamByteStream.read(bArr)) {
                fileOutputStream.write(bArr, 0, i2);
                i += i2;
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(this.this$0, ((i * 1.0f) / contentLength) * 100.0f, null), 3, null);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            AppUpdater.INSTANCE.install(file);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.funny.audio.view.update.UpdateDialogFragment$update$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: UpdateDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.update.UpdateDialogFragment$update$2$1$1", f = "UpdateDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $progress;
        int label;
        final /* synthetic */ UpdateDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UpdateDialogFragment updateDialogFragment, float f, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = updateDialogFragment;
            this.$progress = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$progress, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.getBd().sliderUpdateProgress.setCurrentProgress((int) this.$progress);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
