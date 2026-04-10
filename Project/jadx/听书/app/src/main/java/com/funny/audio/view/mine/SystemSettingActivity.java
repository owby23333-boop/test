package com.funny.audio.view.mine;

import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.funny.audio.AppManager;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.databinding.ActivitySystemSettingBinding;
import com.funny.audio.settings.AppSettingEntityKt;
import com.funny.audio.user.UserManager;
import com.funny.audio.user.UserSettings;
import com.funny.audio.view.DialogUtils;
import com.funny.audio.view.core.BaseActivity;
import com.funny.audio.view.core.MessageDialogFragment;
import com.funny.audio.view.core.StatusBarUtils;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: SystemSettingActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0011\u0010\u0010\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\rH\u0002J-\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00052\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\rH\u0014J\u0006\u0010\u001c\u001a\u00020\rJ\u0019\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lcom/funny/audio/view/mine/SystemSettingActivity;", "Lcom/funny/audio/view/core/BaseActivity;", "Lcom/funny/audio/databinding/ActivitySystemSettingBinding;", "()V", "REQUEST_NOTIFICATION_PERMISSION", "", "notificationPlayerPermission", "", "getNotificationPlayerPermission", "()Z", "setNotificationPlayerPermission", "(Z)V", "initData", "", "initStatusBar", "initView", "loadAudioTop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadNotificationPlayerPermission", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "requestNotificationPermission", "setAudioTop", "flag", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SystemSettingActivity extends BaseActivity<ActivitySystemSettingBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean needRestartApp;
    private final int REQUEST_NOTIFICATION_PERMISSION = 100;
    private boolean notificationPlayerPermission;

    /* JADX INFO: renamed from: com.funny.audio.view.mine.SystemSettingActivity$setAudioTop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SystemSettingActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.mine.SystemSettingActivity", f = "SystemSettingActivity.kt", i = {0}, l = {115, 119}, m = "setAudioTop", n = {"this"}, s = {"L$0"})
    static final class C06261 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06261(Continuation<? super C06261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SystemSettingActivity.this.setAudioTop(false, this);
        }
    }

    public final boolean getNotificationPlayerPermission() {
        return this.notificationPlayerPermission;
    }

    public final void setNotificationPlayerPermission(boolean z) {
        this.notificationPlayerPermission = z;
    }

    /* JADX INFO: compiled from: SystemSettingActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/funny/audio/view/mine/SystemSettingActivity$Companion;", "", "()V", "needRestartApp", "", "getNeedRestartApp", "()Z", "setNeedRestartApp", "(Z)V", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getNeedRestartApp() {
            return SystemSettingActivity.needRestartApp;
        }

        public final void setNeedRestartApp(boolean z) {
            SystemSettingActivity.needRestartApp = z;
        }
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initView() {
        initStatusBar();
        ImageView imageView = getBd().appBack;
        Intrinsics.checkNotNullExpressionValue(imageView, "bd.appBack");
        ViewKt.click$default(imageView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.SystemSettingActivity.initView.1
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
                SystemSettingActivity.this.finish();
            }
        }, 1, null);
        QMUILinearLayout qMUILinearLayout = getBd().lyAudioTop;
        Intrinsics.checkNotNullExpressionValue(qMUILinearLayout, "bd.lyAudioTop");
        ViewKt.click$default(qMUILinearLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.SystemSettingActivity.initView.2
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
                UserSettings setting = UserManager.INSTANCE.getSetting();
                Intrinsics.checkNotNull(setting);
                if (setting.getAudioTop()) {
                    MessageDialogFragment content = new MessageDialogFragment().setTitle("关闭音频置顶").setContent("关闭后听书过程将会被其他app音频打断，确认关闭吗？\n重启app后生效！");
                    final SystemSettingActivity systemSettingActivity = SystemSettingActivity.this;
                    MessageDialogFragment inactiveBtn$default = MessageDialogFragment.setInactiveBtn$default(content.setPositiveBtn("确定", new DialogUtils.OnButtonClickListener() { // from class: com.funny.audio.view.mine.SystemSettingActivity.initView.2.1
                        @Override // com.funny.audio.view.DialogUtils.OnButtonClickListener
                        public boolean onClick(View v) {
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SystemSettingActivity$initView$2$1$onClick$1(systemSettingActivity, null), 3, null);
                            return true;
                        }
                    }), "取消", null, 2, null);
                    FragmentManager supportFragmentManager = SystemSettingActivity.this.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "this.supportFragmentManager");
                    inactiveBtn$default.show(supportFragmentManager);
                    return;
                }
                MessageDialogFragment content2 = new MessageDialogFragment().setTitle("音频置顶").setContent("可以与其他app一起播放音频\n如一边玩游戏一边听书。\n重启app后生效！");
                final SystemSettingActivity systemSettingActivity2 = SystemSettingActivity.this;
                MessageDialogFragment inactiveBtn$default2 = MessageDialogFragment.setInactiveBtn$default(content2.setPositiveBtn("确定", new DialogUtils.OnButtonClickListener() { // from class: com.funny.audio.view.mine.SystemSettingActivity.initView.2.2
                    @Override // com.funny.audio.view.DialogUtils.OnButtonClickListener
                    public boolean onClick(View v) {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SystemSettingActivity$initView$2$2$onClick$1(systemSettingActivity2, null), 3, null);
                        return true;
                    }
                }), "取消", null, 2, null);
                FragmentManager supportFragmentManager2 = SystemSettingActivity.this.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "this.supportFragmentManager");
                inactiveBtn$default2.show(supportFragmentManager2);
            }
        }, 1, null);
        QMUILinearLayout qMUILinearLayout2 = getBd().lyNotificationPlayer;
        Intrinsics.checkNotNullExpressionValue(qMUILinearLayout2, "bd.lyNotificationPlayer");
        ViewKt.click$default(qMUILinearLayout2, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.SystemSettingActivity.initView.3
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
                if (SystemSettingActivity.this.getNotificationPlayerPermission()) {
                    DialogUtils.INSTANCE.tip("通知栏权限已开，如未生效可以尝试重启app或者手动到设置中勾选通知栏权限~");
                    return;
                }
                MessageDialogFragment content = new MessageDialogFragment().setTitle("通知栏权限").setContent("部分手机通知栏不出现播放器可能是因为需要系统给app提供通知栏权限，请点击确定或者手动到设置中勾选通知栏权限后重启app~");
                final SystemSettingActivity systemSettingActivity = SystemSettingActivity.this;
                MessageDialogFragment inactiveBtn$default = MessageDialogFragment.setInactiveBtn$default(content.setPositiveBtn("确定", new DialogUtils.OnButtonClickListener() { // from class: com.funny.audio.view.mine.SystemSettingActivity.initView.3.1
                    @Override // com.funny.audio.view.DialogUtils.OnButtonClickListener
                    public boolean onClick(View v) {
                        systemSettingActivity.requestNotificationPermission();
                        return true;
                    }
                }), "取消", null, 2, null);
                FragmentManager supportFragmentManager = SystemSettingActivity.this.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "this.supportFragmentManager");
                inactiveBtn$default.show(supportFragmentManager);
            }
        }, 1, null);
    }

    /* JADX INFO: renamed from: com.funny.audio.view.mine.SystemSettingActivity$initData$1, reason: invalid class name */
    /* JADX INFO: compiled from: SystemSettingActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.mine.SystemSettingActivity$initData$1", f = "SystemSettingActivity.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SystemSettingActivity.this.new AnonymousClass1(continuation);
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
                if (SystemSettingActivity.this.loadAudioTop(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            SystemSettingActivity.this.loadNotificationPlayerPermission();
            return Unit.INSTANCE;
        }
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initData() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.funny.audio.view.mine.SystemSettingActivity$onResume$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SystemSettingActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.mine.SystemSettingActivity$onResume$1", f = "SystemSettingActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06251(Continuation<? super C06251> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SystemSettingActivity.this.new C06251(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SystemSettingActivity.this.loadNotificationPlayerPermission();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C06251(null), 3, null);
    }

    /* JADX INFO: renamed from: com.funny.audio.view.mine.SystemSettingActivity$setAudioTop$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SystemSettingActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.mine.SystemSettingActivity$setAudioTop$2", f = "SystemSettingActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06272 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $flag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06272(boolean z, Continuation<? super C06272> continuation) {
            super(2, continuation);
            this.$flag = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06272(this.$flag, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06272) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            UserSettings setting = UserManager.INSTANCE.getSetting();
            Intrinsics.checkNotNull(setting);
            AppSettingEntityKt.save(setting.getAudioTopSetting(), Boxing.boxBoolean(this.$flag));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setAudioTop(boolean r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) throws java.lang.Throwable {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.funny.audio.view.mine.SystemSettingActivity.C06261
            if (r0 == 0) goto L14
            r0 = r14
            com.funny.audio.view.mine.SystemSettingActivity$setAudioTop$1 r0 = (com.funny.audio.view.mine.SystemSettingActivity.C06261) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            com.funny.audio.view.mine.SystemSettingActivity$setAudioTop$1 r0 = new com.funny.audio.view.mine.SystemSettingActivity$setAudioTop$1
            r0.<init>(r14)
        L19:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3e
            if (r2 == r5) goto L36
            if (r2 != r4) goto L2e
            kotlin.ResultKt.throwOnFailure(r14)
            goto L78
        L2e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L36:
            java.lang.Object r13 = r0.L$0
            com.funny.audio.view.mine.SystemSettingActivity r13 = (com.funny.audio.view.mine.SystemSettingActivity) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L67
        L3e:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlinx.coroutines.CoroutineDispatcher r14 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r14 = (kotlin.coroutines.CoroutineContext) r14
            kotlinx.coroutines.CoroutineScope r6 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r14)
            r7 = 0
            r8 = 0
            com.funny.audio.view.mine.SystemSettingActivity$setAudioTop$2 r14 = new com.funny.audio.view.mine.SystemSettingActivity$setAudioTop$2
            r14.<init>(r13, r3)
            r9 = r14
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r10 = 3
            r11 = 0
            kotlinx.coroutines.Deferred r13 = kotlinx.coroutines.BuildersKt.async$default(r6, r7, r8, r9, r10, r11)
            r0.L$0 = r12
            r0.label = r5
            java.lang.Object r13 = r13.await(r0)
            if (r13 != r1) goto L66
            return r1
        L66:
            r13 = r12
        L67:
            boolean r14 = com.funny.audio.view.mine.SystemSettingActivity.needRestartApp
            if (r14 != 0) goto L6d
            com.funny.audio.view.mine.SystemSettingActivity.needRestartApp = r5
        L6d:
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r13 = r13.loadAudioTop(r0)
            if (r13 != r1) goto L78
            return r1
        L78:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.mine.SystemSettingActivity.setAudioTop(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadAudioTop(Continuation<? super Unit> continuation) {
        UserSettings setting = UserManager.INSTANCE.getSetting();
        Intrinsics.checkNotNull(setting);
        String strConcat = setting.getAudioTop() ? "是" : "否";
        TextView textView = getBd().tvAudioTop;
        if (needRestartApp) {
            strConcat = strConcat.concat("(重启app后生效)");
        }
        textView.setText(strConcat);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadNotificationPlayerPermission() {
        boolean zAreNotificationsEnabled = false;
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                if (ContextCompat.checkSelfPermission(getContext(), "android.permission.POST_NOTIFICATIONS") == 0) {
                    zAreNotificationsEnabled = true;
                }
            } else {
                zAreNotificationsEnabled = NotificationManagerCompat.from(getContext()).areNotificationsEnabled();
            }
        } catch (Exception unused) {
        }
        this.notificationPlayerPermission = zAreNotificationsEnabled;
        getBd().tvNotificationPlayer.setText(this.notificationPlayerPermission ? "是" : "否");
    }

    private final void initStatusBar() {
        SystemSettingActivity systemSettingActivity = this;
        StatusBarUtils.INSTANCE.translucent(systemSettingActivity);
        if (AppManager.INSTANCE.isNightMode()) {
            StatusBarUtils.INSTANCE.setStatusBarDarkMode(systemSettingActivity);
        } else {
            StatusBarUtils.INSTANCE.setStatusBarLightMode(systemSettingActivity);
        }
    }

    public final void requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= 33) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, this.REQUEST_NOTIFICATION_PERMISSION);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != this.REQUEST_NOTIFICATION_PERMISSION || grantResults.length <= 0) {
            return;
        }
        int i = grantResults[0];
    }
}
