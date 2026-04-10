package com.funny.audio.view.mine;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.net.MailTo;
import androidx.fragment.app.FragmentManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.funny.audio.AppManager;
import com.funny.audio.R;
import com.funny.audio.api.ApiManager;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.core.net.AppBody;
import com.funny.audio.core.net.NetModelsKt;
import com.funny.audio.core.net.Response;
import com.funny.audio.core.utils.TextUtils;
import com.funny.audio.database.DbContext;
import com.funny.audio.database.entities.BookshelfEntity;
import com.funny.audio.database.entities.PlayHistoryEntity;
import com.funny.audio.databinding.ActivityLoginBinding;
import com.funny.audio.models.GetUserDataReq;
import com.funny.audio.models.UserDataInfo;
import com.funny.audio.models.UserDataType;
import com.funny.audio.models.UserInfo;
import com.funny.audio.user.UserManager;
import com.funny.audio.view.DialogUtils;
import com.funny.audio.view.NavigationUtils;
import com.funny.audio.view.core.BaseActivity;
import com.funny.audio.view.core.MessageDialogFragment;
import com.funny.audio.view.core.StatusBarUtils;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: LoginActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0011\u0010\b\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/funny/audio/view/mine/LoginActivity;", "Lcom/funny/audio/view/core/BaseActivity;", "Lcom/funny/audio/databinding/ActivityLoginBinding;", "()V", "initData", "", "initStatusBar", "initView", "login", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LoginActivity extends BaseActivity<ActivityLoginBinding> {

    /* JADX INFO: renamed from: com.funny.audio.view.mine.LoginActivity$login$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoginActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.mine.LoginActivity", f = "LoginActivity.kt", i = {0, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED}, m = "login", n = {"this", "this"}, s = {"L$0", "L$0"})
    static final class C06121 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06121(Continuation<? super C06121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LoginActivity.this.login(this);
        }
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initView() {
        initStatusBar();
        ImageView imageView = getBd().appBack;
        Intrinsics.checkNotNullExpressionValue(imageView, "bd.appBack");
        ViewKt.click$default(imageView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.LoginActivity.initView.1
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
                LoginActivity.this.finish();
            }
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout = getBd().btnLogin;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout, "bd.btnLogin");
        ViewKt.click$default(qMUIFrameLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.LoginActivity.initView.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.funny.audio.view.mine.LoginActivity$initView$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: LoginActivity.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.mine.LoginActivity$initView$2$1", f = "LoginActivity.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ LoginActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LoginActivity loginActivity, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = loginActivity;
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
                        if (this.this$0.login(this) == coroutine_suspended) {
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(LoginActivity.this, null), 3, null);
            }
        }, 1, null);
        TextView textView = getBd().tvRegister;
        Intrinsics.checkNotNullExpressionValue(textView, "bd.tvRegister");
        ViewKt.click$default(textView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.LoginActivity.initView.3
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
                LoginActivity.this.finish();
                NavigationUtils.INSTANCE.toRegister(LoginActivity.this.getContext());
            }
        }, 1, null);
        TextView textView2 = getBd().tvForgetPassword;
        Intrinsics.checkNotNullExpressionValue(textView2, "bd.tvForgetPassword");
        ViewKt.click$default(textView2, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.LoginActivity.initView.4
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
                MessageDialogFragment content = new MessageDialogFragment().setTitle("找回密码").setContent("向我们发送邮件帮助您找回密码，我们收到后会尽快联系您！");
                final LoginActivity loginActivity = LoginActivity.this;
                MessageDialogFragment inactiveBtn$default = MessageDialogFragment.setInactiveBtn$default(content.setPositiveBtn("立即发送", new DialogUtils.OnButtonClickListener() { // from class: com.funny.audio.view.mine.LoginActivity.initView.4.1
                    @Override // com.funny.audio.view.DialogUtils.OnButtonClickListener
                    public boolean onClick(View v) {
                        String string = loginActivity.getContext().getString(R.string.contact_email_text);
                        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.contact_email_text)");
                        String string2 = loginActivity.getContext().getString(R.string.app_name);
                        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.app_name)");
                        Intent intent = new Intent("android.intent.action.SENDTO");
                        intent.setData(Uri.parse(MailTo.MAILTO_SCHEME));
                        intent.putExtra("android.intent.extra.EMAIL", new String[]{string});
                        intent.putExtra("android.intent.extra.SUBJECT", "帮忙找回密码(" + string2 + ")");
                        intent.putExtra("android.intent.extra.TEXT", "请帮助我找回密码。\n\n我注册用的邮箱/手机号是：\n\n我的联系方式是：\n\n请准确填写以上信息，我们将会在1个工作日内帮你找回密码。");
                        loginActivity.getContext().startActivity(intent);
                        return true;
                    }
                }), "暂时不用", null, 2, null);
                FragmentManager supportFragmentManager = LoginActivity.this.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "this.supportFragmentManager");
                inactiveBtn$default.show(supportFragmentManager);
            }
        }, 1, null);
    }

    private final void initStatusBar() {
        LoginActivity loginActivity = this;
        StatusBarUtils.INSTANCE.translucent(loginActivity);
        if (AppManager.INSTANCE.isNightMode()) {
            StatusBarUtils.INSTANCE.setStatusBarDarkMode(loginActivity);
        } else {
            StatusBarUtils.INSTANCE.setStatusBarLightMode(loginActivity);
        }
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initData() {
        NavigationUtils navigationUtils = NavigationUtils.INSTANCE;
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        String account = navigationUtils.getAccount(intent);
        NavigationUtils navigationUtils2 = NavigationUtils.INSTANCE;
        Intent intent2 = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent2, "intent");
        String password = navigationUtils2.getPassword(intent2);
        if (account != null) {
            getBd().etAccount.setText(account);
        }
        if (password != null) {
            getBd().etPassword.setText(password);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object login(kotlin.coroutines.Continuation<? super kotlin.Unit> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.mine.LoginActivity.login(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.funny.audio.view.mine.LoginActivity$login$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LoginActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.mine.LoginActivity$login$2", f = "LoginActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06132 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UserInfo $body;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06132(UserInfo userInfo, Continuation<? super C06132> continuation) {
            super(2, continuation);
            this.$body = userInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06132(this.$body, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06132) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            UserManager.INSTANCE.save(this.$body);
            String id = this.$body.getId();
            GetUserDataReq getUserDataReq = new GetUserDataReq();
            getUserDataReq.setUserId(id);
            getUserDataReq.setType(UserDataType.INSTANCE.getBOOKSHELF());
            Response<List<UserDataInfo>> userData = ApiManager.INSTANCE.getUser().getUserData(getUserDataReq);
            if (NetModelsKt.successWithData(userData)) {
                AppBody<List<UserDataInfo>> body = userData.getBody();
                Intrinsics.checkNotNull(body);
                List<UserDataInfo> data = body.getData();
                Intrinsics.checkNotNull(data);
                for (UserDataInfo userDataInfo : data) {
                    TextUtils textUtils = TextUtils.INSTANCE;
                    DbContext.INSTANCE.getCurrent().bookshelf().add((BookshelfEntity) textUtils.getGson().fromJson(userDataInfo.getContent(), BookshelfEntity.class));
                }
            }
            GetUserDataReq getUserDataReq2 = new GetUserDataReq();
            getUserDataReq2.setUserId(id);
            getUserDataReq2.setType(UserDataType.INSTANCE.getHISTORY());
            getUserDataReq2.setSize(20);
            Response<List<UserDataInfo>> userData2 = ApiManager.INSTANCE.getUser().getUserData(getUserDataReq2);
            if (NetModelsKt.successWithData(userData2)) {
                AppBody<List<UserDataInfo>> body2 = userData2.getBody();
                Intrinsics.checkNotNull(body2);
                List<UserDataInfo> data2 = body2.getData();
                Intrinsics.checkNotNull(data2);
                for (UserDataInfo userDataInfo2 : data2) {
                    TextUtils textUtils2 = TextUtils.INSTANCE;
                    DbContext.INSTANCE.getCurrent().playHistory().add((PlayHistoryEntity) textUtils2.getGson().fromJson(userDataInfo2.getContent(), PlayHistoryEntity.class));
                }
            }
            return Unit.INSTANCE;
        }
    }
}
