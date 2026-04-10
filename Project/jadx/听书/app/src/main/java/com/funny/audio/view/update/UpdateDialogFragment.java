package com.funny.audio.view.update;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.databinding.FragmentUpdateDialogBinding;
import com.funny.audio.models.CloudUpdateInfo;
import com.funny.audio.models.UpdateTypes;
import com.funny.audio.update.AppUpdater;
import com.funny.audio.view.NavigationUtils;
import com.funny.audio.view.core.BaseDialogFragment;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: UpdateDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\u001a\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0011\u0010\u0017\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/funny/audio/view/update/UpdateDialogFragment;", "Lcom/funny/audio/view/core/BaseDialogFragment;", "Lcom/funny/audio/databinding/FragmentUpdateDialogBinding;", "()V", "dialogwidthPixels", "", "getDialogwidthPixels", "()I", "setDialogwidthPixels", "(I)V", "listener", "Lcom/funny/audio/view/update/UpdateDialogListener;", "disableCancel", "", "dismiss", "initData", "initView", "view", "Landroid/view/View;", "onStart", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "update", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UpdateDialogFragment extends BaseDialogFragment<FragmentUpdateDialogBinding> {
    private int dialogwidthPixels;
    private UpdateDialogListener listener;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean disableCancel$lambda$0(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
    }

    public final int getDialogwidthPixels() {
        return this.dialogwidthPixels;
    }

    public final void setDialogwidthPixels(int i) {
        this.dialogwidthPixels = i;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            requireActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.dialogwidthPixels = (int) (((double) displayMetrics.widthPixels) * 0.85d);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setLayout(this.dialogwidthPixels, -2);
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
        }
    }

    @Override // com.funny.audio.view.core.BaseDialogFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.initView(view);
        getBd().sliderUpdateProgress.setEnabled(false);
        QMUIFrameLayout qMUIFrameLayout = getBd().btnCancel;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout, "bd.btnCancel");
        ViewKt.click$default(qMUIFrameLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.update.UpdateDialogFragment.initView.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                UpdateDialogFragment.this.dismiss();
            }
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout2 = getBd().btnUpdate;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout2, "bd.btnUpdate");
        ViewKt.click$default(qMUIFrameLayout2, 0, new Function0<Unit>() { // from class: com.funny.audio.view.update.UpdateDialogFragment.initView.2
            {
                super(0);
            }

            /* JADX INFO: renamed from: com.funny.audio.view.update.UpdateDialogFragment$initView$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: UpdateDialogFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.update.UpdateDialogFragment$initView$2$1", f = "UpdateDialogFragment.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ UpdateDialogFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(UpdateDialogFragment updateDialogFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = updateDialogFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (this.this$0.update(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(UpdateDialogFragment.this, null), 3, null);
            }
        }, 1, null);
        TextView textView = getBd().tvManualUpdate;
        Intrinsics.checkNotNullExpressionValue(textView, "bd.tvManualUpdate");
        ViewKt.click$default(textView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.update.UpdateDialogFragment.initView.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CloudUpdateInfo updateInfo = AppUpdater.INSTANCE.getUpdateInfo();
                if (updateInfo != null) {
                    UpdateDialogFragment updateDialogFragment = UpdateDialogFragment.this;
                    String manualUpdateUrl = updateInfo.getManualUpdateUrl();
                    if (manualUpdateUrl.length() > 0) {
                        NavigationUtils.INSTANCE.toH5Out(updateDialogFragment.requireActivity(), manualUpdateUrl);
                    }
                }
            }
        }, 1, null);
        disableCancel();
    }

    public final void disableCancel() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(false);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(false);
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null) {
            dialog3.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.funny.audio.view.update.UpdateDialogFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return UpdateDialogFragment.disableCancel$lambda$0(dialogInterface, i, keyEvent);
                }
            });
        }
    }

    @Override // com.funny.audio.view.core.BaseDialogFragment
    public void initData() {
        super.initData();
        CloudUpdateInfo updateInfo = AppUpdater.INSTANCE.getUpdateInfo();
        Intrinsics.checkNotNull(updateInfo);
        if (updateInfo.getFeedbackTip().length() > 0) {
            getBd().tvContent.setText(updateInfo.getFeedbackTip());
            getBd().tvContent.setVisibility(0);
        } else {
            getBd().tvContent.setVisibility(8);
        }
        if (updateInfo.getUpdateType() != UpdateTypes.INSTANCE.getFORCE() && updateInfo.getUpdateType() != UpdateTypes.INSTANCE.getAUTO_FORCE()) {
            getBd().btnCancel.setVisibility(0);
        } else {
            getBd().btnCancel.setVisibility(8);
        }
        if (updateInfo.getManualUpdateUrl().length() > 0) {
            getBd().lyManualUpdate.setVisibility(0);
        } else {
            getBd().lyManualUpdate.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object update(Continuation<? super Unit> continuation) {
        Object objAwait;
        getBd().lyUpdateProgress.setVisibility(0);
        CloudUpdateInfo updateInfo = AppUpdater.INSTANCE.getUpdateInfo();
        return (updateInfo == null || (objAwait = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UpdateDialogFragment$update$2$1(updateInfo, this, null), 3, null).await(continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : objAwait;
    }

    public static /* synthetic */ void show$default(UpdateDialogFragment updateDialogFragment, FragmentManager fragmentManager, UpdateDialogListener updateDialogListener, int i, Object obj) {
        if ((i & 2) != 0) {
            updateDialogListener = null;
        }
        updateDialogFragment.show(fragmentManager, updateDialogListener);
    }

    public final void show(FragmentManager manager, UpdateDialogListener listener) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        if (listener != null) {
            this.listener = listener;
        }
        show(manager, "UpdateDialog");
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        UpdateDialogListener updateDialogListener = this.listener;
        if (updateDialogListener != null) {
            updateDialogListener.onDismiss();
        }
        super.dismiss();
    }
}
