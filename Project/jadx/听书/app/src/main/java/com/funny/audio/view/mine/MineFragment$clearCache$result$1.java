package com.funny.audio.view.mine;

import com.funny.audio.core.utils.FileUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MineFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.funny.audio.view.mine.MineFragment$clearCache$result$1", f = "MineFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MineFragment$clearCache$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ File $apiCacheFile;
    final /* synthetic */ File $imageCacheFile;
    final /* synthetic */ File $mediaCacheFile;
    final /* synthetic */ File $otherCacheFile;
    final /* synthetic */ File $otherDownloadFile;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MineFragment$clearCache$result$1(File file, File file2, File file3, File file4, File file5, Continuation<? super MineFragment$clearCache$result$1> continuation) {
        super(2, continuation);
        this.$apiCacheFile = file;
        this.$imageCacheFile = file2;
        this.$mediaCacheFile = file3;
        this.$otherCacheFile = file4;
        this.$otherDownloadFile = file5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MineFragment$clearCache$result$1(this.$apiCacheFile, this.$imageCacheFile, this.$mediaCacheFile, this.$otherCacheFile, this.$otherDownloadFile, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((MineFragment$clearCache$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            FileUtils.delete(this.$apiCacheFile.getPath());
            FileUtils.delete(this.$imageCacheFile.getPath());
            FileUtils.delete(this.$mediaCacheFile.getPath());
            File file = this.$otherCacheFile;
            FileUtils.delete(file != null ? file.getPath() : null);
            File file2 = this.$otherDownloadFile;
            FileUtils.delete(file2 != null ? file2.getPath() : null);
            return Boxing.boxBoolean(true);
        } catch (Exception unused) {
            return Boxing.boxBoolean(false);
        }
    }
}
