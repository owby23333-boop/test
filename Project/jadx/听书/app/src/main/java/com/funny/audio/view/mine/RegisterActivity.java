package com.funny.audio.view.mine;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.funny.audio.AppManager;
import com.funny.audio.R;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.core.utils.StringUtils;
import com.funny.audio.databinding.ActivityRegisterBinding;
import com.funny.audio.view.core.BaseActivity;
import com.funny.audio.view.core.StatusBarUtils;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
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

/* JADX INFO: compiled from: RegisterActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0011\u0010\b\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/funny/audio/view/mine/RegisterActivity;", "Lcom/funny/audio/view/core/BaseActivity;", "Lcom/funny/audio/databinding/ActivityRegisterBinding;", "()V", "initData", "", "initStatusBar", "initView", "login", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RegisterActivity extends BaseActivity<ActivityRegisterBinding> {

    /* JADX INFO: renamed from: com.funny.audio.view.mine.RegisterActivity$login$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RegisterActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.mine.RegisterActivity", f = "RegisterActivity.kt", i = {0, 0, 0}, l = {170}, m = "login", n = {"this", "account", "password1"}, s = {"L$0", "L$1", "L$2"})
    static final class C06231 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C06231(Continuation<? super C06231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RegisterActivity.this.login(this);
        }
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initData() {
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initView() {
        initStatusBar();
        ImageView imageView = getBd().appBack;
        Intrinsics.checkNotNullExpressionValue(imageView, "bd.appBack");
        ViewKt.click$default(imageView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.RegisterActivity.initView.1
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
                RegisterActivity.this.finish();
            }
        }, 1, null);
        EditText editText = getBd().etAccount;
        Intrinsics.checkNotNullExpressionValue(editText, "bd.etAccount");
        editText.addTextChangedListener(new TextWatcher() { // from class: com.funny.audio.view.mine.RegisterActivity$initView$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String string = this.this$0.getBd().etAccount.getText().toString();
                if (string.length() == 0) {
                    this.this$0.getBd().tvAccountTips.setTextColor(ContextCompat.getColor(this.this$0.getContext(), R.color.secondary_text_color));
                    this.this$0.getBd().tvAccountTips.setText("大陆邮箱/手机号码");
                } else if (StringUtils.isPhoneNum(string) || StringUtils.isEmail(string)) {
                    this.this$0.getBd().tvAccountTips.setTextColor(ContextCompat.getColor(this.this$0.getContext(), R.color.tips_success_text_color));
                    this.this$0.getBd().tvAccountTips.setText("格式正确");
                } else {
                    this.this$0.getBd().tvAccountTips.setTextColor(ContextCompat.getColor(this.this$0.getContext(), R.color.tips_error_text_color));
                    this.this$0.getBd().tvAccountTips.setText("请输入正确的邮箱/手机号码");
                }
            }
        });
        EditText editText2 = getBd().etPassword1;
        Intrinsics.checkNotNullExpressionValue(editText2, "bd.etPassword1");
        editText2.addTextChangedListener(new TextWatcher() { // from class: com.funny.audio.view.mine.RegisterActivity$initView$$inlined$addTextChangedListener$default$2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String string = this.this$0.getBd().etPassword1.getText().toString();
                if (string.length() < 6) {
                    if (string.length() == 0) {
                        this.this$0.getBd().tvPassword1Tips.setTextColor(ContextCompat.getColor(this.this$0.getContext(), R.color.secondary_text_color));
                        this.this$0.getBd().tvPassword1Tips.setText("字母或数字，至少6位");
                        return;
                    } else {
                        this.this$0.getBd().tvPassword1Tips.setTextColor(ContextCompat.getColor(this.this$0.getContext(), R.color.tips_error_text_color));
                        this.this$0.getBd().tvPassword1Tips.setText("请输入至少6位");
                        return;
                    }
                }
                this.this$0.getBd().tvPassword1Tips.setTextColor(ContextCompat.getColor(this.this$0.getContext(), R.color.tips_success_text_color));
                this.this$0.getBd().tvPassword1Tips.setText("格式正确");
            }
        });
        EditText editText3 = getBd().etPassword2;
        Intrinsics.checkNotNullExpressionValue(editText3, "bd.etPassword2");
        editText3.addTextChangedListener(new TextWatcher() { // from class: com.funny.audio.view.mine.RegisterActivity$initView$$inlined$addTextChangedListener$default$3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String string = this.this$0.getBd().etPassword1.getText().toString();
                String string2 = this.this$0.getBd().etPassword2.getText().toString();
                if (string2.length() == 0) {
                    this.this$0.getBd().tvPassword2Tips.setTextColor(ContextCompat.getColor(this.this$0.getContext(), R.color.secondary_text_color));
                    this.this$0.getBd().tvPassword2Tips.setText("字母或数字，至少6位");
                } else if (!Intrinsics.areEqual(string2, string)) {
                    this.this$0.getBd().tvPassword2Tips.setTextColor(ContextCompat.getColor(this.this$0.getContext(), R.color.tips_error_text_color));
                    this.this$0.getBd().tvPassword2Tips.setText("两个密码不相同");
                } else {
                    this.this$0.getBd().tvPassword2Tips.setTextColor(ContextCompat.getColor(this.this$0.getContext(), R.color.tips_success_text_color));
                    this.this$0.getBd().tvPassword2Tips.setText("格式正确");
                }
            }
        });
        QMUIFrameLayout qMUIFrameLayout = getBd().btnRegister;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout, "bd.btnRegister");
        ViewKt.click$default(qMUIFrameLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.RegisterActivity.initView.5
            {
                super(0);
            }

            /* JADX INFO: renamed from: com.funny.audio.view.mine.RegisterActivity$initView$5$1, reason: invalid class name */
            /* JADX INFO: compiled from: RegisterActivity.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.mine.RegisterActivity$initView$5$1", f = "RegisterActivity.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ RegisterActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(RegisterActivity registerActivity, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = registerActivity;
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

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(RegisterActivity.this, null), 3, null);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object login(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.mine.RegisterActivity.login(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void initStatusBar() {
        RegisterActivity registerActivity = this;
        StatusBarUtils.INSTANCE.translucent(registerActivity);
        if (AppManager.INSTANCE.isNightMode()) {
            StatusBarUtils.INSTANCE.setStatusBarDarkMode(registerActivity);
        } else {
            StatusBarUtils.INSTANCE.setStatusBarLightMode(registerActivity);
        }
    }
}
