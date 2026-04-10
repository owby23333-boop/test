package com.funny.audio.view;

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
import com.funny.audio.databinding.FragmentAlertNoticeDialogBinding;
import com.funny.audio.models.AlertNoticeInfo;
import com.funny.audio.models.AlertNoticeTypes;
import com.funny.audio.settings.AppSettingEntity;
import com.funny.audio.settings.AppSettingEntityKt;
import com.funny.audio.user.UserManager;
import com.funny.audio.user.UserSettings;
import com.funny.audio.view.core.BaseDialogFragment;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.widget.webview.QMUIWebView;
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

/* JADX INFO: compiled from: AlertNoticeDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/funny/audio/view/AlertNoticeDialogFragment;", "Lcom/funny/audio/view/core/BaseDialogFragment;", "Lcom/funny/audio/databinding/FragmentAlertNoticeDialogBinding;", "()V", "alertNoticeInfo", "Lcom/funny/audio/models/AlertNoticeInfo;", "getAlertNoticeInfo", "()Lcom/funny/audio/models/AlertNoticeInfo;", "setAlertNoticeInfo", "(Lcom/funny/audio/models/AlertNoticeInfo;)V", "dialogwidthPixels", "", "getDialogwidthPixels", "()I", "setDialogwidthPixels", "(I)V", "disableCancel", "", "initData", "initView", "view", "Landroid/view/View;", "onStart", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AlertNoticeDialogFragment extends BaseDialogFragment<FragmentAlertNoticeDialogBinding> {
    private AlertNoticeInfo alertNoticeInfo;
    private int dialogwidthPixels;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean disableCancel$lambda$0(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
    }

    public final AlertNoticeInfo getAlertNoticeInfo() {
        return this.alertNoticeInfo;
    }

    public final void setAlertNoticeInfo(AlertNoticeInfo alertNoticeInfo) {
        this.alertNoticeInfo = alertNoticeInfo;
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
            this.dialogwidthPixels = (int) (((double) displayMetrics.widthPixels) * 0.95d);
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
        QMUIFrameLayout qMUIFrameLayout = getBd().btnInactive;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout, "bd.btnInactive");
        ViewKt.click$default(qMUIFrameLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.AlertNoticeDialogFragment.initView.1
            {
                super(0);
            }

            /* JADX INFO: renamed from: com.funny.audio.view.AlertNoticeDialogFragment$initView$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: AlertNoticeDialogFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.AlertNoticeDialogFragment$initView$1$1", f = "AlertNoticeDialogFragment.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
            static final class C02381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ AlertNoticeDialogFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C02381(AlertNoticeDialogFragment alertNoticeDialogFragment, Continuation<? super C02381> continuation) {
                    super(2, continuation);
                    this.this$0 = alertNoticeDialogFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C02381(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C02381) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: renamed from: com.funny.audio.view.AlertNoticeDialogFragment$initView$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: AlertNoticeDialogFragment.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "com.funny.audio.view.AlertNoticeDialogFragment$initView$1$1$1", f = "AlertNoticeDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                static final class C02391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ AlertNoticeDialogFragment this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C02391(AlertNoticeDialogFragment alertNoticeDialogFragment, Continuation<? super C02391> continuation) {
                        super(2, continuation);
                        this.this$0 = alertNoticeDialogFragment;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C02391(this.this$0, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C02391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        AppSettingEntity readedAlertNoticeIdSetting;
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        UserSettings setting = UserManager.INSTANCE.getSetting();
                        if (setting == null || (readedAlertNoticeIdSetting = setting.getReadedAlertNoticeIdSetting()) == null) {
                            return null;
                        }
                        AlertNoticeInfo alertNoticeInfo = this.this$0.getAlertNoticeInfo();
                        Intrinsics.checkNotNull(alertNoticeInfo);
                        AppSettingEntityKt.save(readedAlertNoticeIdSetting, alertNoticeInfo.getId());
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C02391(this.this$0, null), 3, null).await(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    this.this$0.dismiss();
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
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C02381(AlertNoticeDialogFragment.this, null), 3, null);
            }
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout2 = getBd().btnPositive;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout2, "bd.btnPositive");
        ViewKt.click$default(qMUIFrameLayout2, 0, new Function0<Unit>() { // from class: com.funny.audio.view.AlertNoticeDialogFragment.initView.2
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
                AlertNoticeDialogFragment.this.dismiss();
            }
        }, 1, null);
        disableCancel();
    }

    @Override // com.funny.audio.view.core.BaseDialogFragment
    public void initData() {
        super.initData();
        AlertNoticeInfo alertNoticeInfo = this.alertNoticeInfo;
        Intrinsics.checkNotNull(alertNoticeInfo);
        if (alertNoticeInfo.getTitle().length() == 0) {
            getBd().tvTitle.setText("消息通知");
        } else {
            TextView textView = getBd().tvTitle;
            AlertNoticeInfo alertNoticeInfo2 = this.alertNoticeInfo;
            Intrinsics.checkNotNull(alertNoticeInfo2);
            textView.setText(alertNoticeInfo2.getTitle());
        }
        AlertNoticeInfo alertNoticeInfo3 = this.alertNoticeInfo;
        Intrinsics.checkNotNull(alertNoticeInfo3);
        int type = alertNoticeInfo3.getType();
        if (type == AlertNoticeTypes.INSTANCE.getTEXT()) {
            getBd().webview.setVisibility(8);
            getBd().tvContent.setVisibility(0);
            TextView textView2 = getBd().tvContent;
            AlertNoticeInfo alertNoticeInfo4 = this.alertNoticeInfo;
            Intrinsics.checkNotNull(alertNoticeInfo4);
            textView2.setText(alertNoticeInfo4.getContent());
            return;
        }
        if (type == AlertNoticeTypes.INSTANCE.getURL()) {
            getBd().webview.setVisibility(0);
            getBd().tvContent.setVisibility(8);
            getBd().webview.getSettings().setJavaScriptEnabled(true);
            QMUIWebView qMUIWebView = getBd().webview;
            AlertNoticeInfo alertNoticeInfo5 = this.alertNoticeInfo;
            Intrinsics.checkNotNull(alertNoticeInfo5);
            qMUIWebView.loadUrl(alertNoticeInfo5.getContent());
            return;
        }
        getBd().webview.setVisibility(8);
        getBd().tvContent.setVisibility(0);
        getBd().tvContent.setText("无法识别信息类型");
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
            dialog3.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.funny.audio.view.AlertNoticeDialogFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return AlertNoticeDialogFragment.disableCancel$lambda$0(dialogInterface, i, keyEvent);
                }
            });
        }
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        show(manager, "AlertNoticeDialogFragment");
    }
}
