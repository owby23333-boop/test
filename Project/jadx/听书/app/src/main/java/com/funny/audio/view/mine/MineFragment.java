package com.funny.audio.view.mine;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.net.MailTo;
import androidx.fragment.app.FragmentManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.funny.audio.GlideOkHttpModule;
import com.funny.audio.R;
import com.funny.audio.ad.AdManager;
import com.funny.audio.ad.AdSetting;
import com.funny.audio.api.ApiManager;
import com.funny.audio.core.ext.LongKt;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.core.net.ApiServiceFactory;
import com.funny.audio.core.net.AppBody;
import com.funny.audio.core.net.NetModelsKt;
import com.funny.audio.core.net.Response;
import com.funny.audio.core.utils.FileUtils;
import com.funny.audio.core.utils.MiscUtils;
import com.funny.audio.databinding.FragmentMineBinding;
import com.funny.audio.media_player.MediaPlayerManager;
import com.funny.audio.models.UserInfo;
import com.funny.audio.update.AppUpdater;
import com.funny.audio.user.UserManager;
import com.funny.audio.view.DialogUtils;
import com.funny.audio.view.ImageUtils;
import com.funny.audio.view.NavigationUtils;
import com.funny.audio.view.core.BaseFragment;
import com.funny.audio.view.core.MessageDialogFragment;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
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

/* JADX INFO: compiled from: MineFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0011\u0010\u0006\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0011\u0010\u000e\u001a\u00020\u000fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0011\u0010\u0016\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/funny/audio/view/mine/MineFragment;", "Lcom/funny/audio/view/core/BaseFragment;", "Lcom/funny/audio/databinding/FragmentMineBinding;", "()V", "lastGetUserInfoTime", "", "checkUpdate", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCache", "initData", "initView", "view", "Landroid/view/View;", "loadCacheInfo", "", "loadContact", "loadPureMode", "loadSettingGroups2", "loadUserInfo", "loadVersion", "onResume", "reloadUserInfo", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MineFragment extends BaseFragment<FragmentMineBinding> {
    private long lastGetUserInfoTime;

    /* JADX INFO: renamed from: com.funny.audio.view.mine.MineFragment$checkUpdate$1, reason: invalid class name */
    /* JADX INFO: compiled from: MineFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.mine.MineFragment", f = "MineFragment.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD}, m = "checkUpdate", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MineFragment.this.checkUpdate(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.mine.MineFragment$clearCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MineFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.mine.MineFragment", f = "MineFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF}, m = "clearCache", n = {}, s = {})
    static final class C06141 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06141(Continuation<? super C06141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MineFragment.this.clearCache(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.mine.MineFragment$reloadUserInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MineFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.mine.MineFragment", f = "MineFragment.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME}, m = "reloadUserInfo", n = {"this"}, s = {"L$0"})
    static final class C06171 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06171(Continuation<? super C06171> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MineFragment.this.reloadUserInfo(this);
        }
    }

    @Override // com.funny.audio.view.core.BaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        LinearLayout linearLayout = getBd().lyUser;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "bd.lyUser");
        ViewKt.click$default(linearLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.MineFragment.initView.1
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
                if (UserManager.INSTANCE.isLogin()) {
                    NavigationUtils.INSTANCE.toUserEdit(MineFragment.this.requireActivity());
                } else {
                    NavigationUtils.toLogin$default(NavigationUtils.INSTANCE, MineFragment.this.requireActivity(), null, null, 6, null);
                }
            }
        }, 1, null);
        QMUILinearLayout qMUILinearLayout = getBd().lyLogout;
        Intrinsics.checkNotNullExpressionValue(qMUILinearLayout, "bd.lyLogout");
        ViewKt.click$default(qMUILinearLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.MineFragment.initView.2
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
                MessageDialogFragment content = new MessageDialogFragment().setTitle("退出登录").setContent("退出登录后将无法同步云端收藏/历史记录。");
                final MineFragment mineFragment = MineFragment.this;
                MessageDialogFragment messageDialogFragmentDisableCancel = MessageDialogFragment.setPositiveBtn$default(content.setInactiveBtn("确定", new DialogUtils.OnButtonClickListener() { // from class: com.funny.audio.view.mine.MineFragment.initView.2.1
                    @Override // com.funny.audio.view.DialogUtils.OnButtonClickListener
                    public boolean onClick(View v) {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MineFragment$initView$2$1$onClick$1(mineFragment, null), 3, null);
                        return true;
                    }
                }), "点错了", null, 2, null).disableCancel();
                FragmentManager childFragmentManager = MineFragment.this.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "this.childFragmentManager");
                messageDialogFragmentDisableCancel.show(childFragmentManager);
            }
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout = getBd().btnClearCache;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout, "bd.btnClearCache");
        ViewKt.click$default(qMUIFrameLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.MineFragment.initView.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.funny.audio.view.mine.MineFragment$initView$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: MineFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.mine.MineFragment$initView$3$1", f = "MineFragment.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ MineFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(MineFragment mineFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = mineFragment;
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
                        obj = this.this$0.loadCacheInfo(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    MessageDialogFragment content = new MessageDialogFragment().setTitle("清理缓存").setContent((String) obj);
                    final MineFragment mineFragment = this.this$0;
                    MessageDialogFragment messageDialogFragmentDisableCancel = MessageDialogFragment.setInactiveBtn$default(content.setPositiveBtn("清除", new DialogUtils.OnButtonClickListener() { // from class: com.funny.audio.view.mine.MineFragment.initView.3.1.1
                        @Override // com.funny.audio.view.DialogUtils.OnButtonClickListener
                        public boolean onClick(View v) {
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new MineFragment$initView$3$1$1$onClick$1(mineFragment, null), 3, null);
                            return true;
                        }
                    }), "取消", null, 2, null).disableCancel();
                    FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "this@MineFragment.childFragmentManager");
                    messageDialogFragmentDisableCancel.show(childFragmentManager);
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(MineFragment.this, null), 3, null);
            }
        }, 1, null);
        QMUILinearLayout qMUILinearLayout2 = getBd().lyContact;
        Intrinsics.checkNotNullExpressionValue(qMUILinearLayout2, "bd.lyContact");
        ViewKt.click$default(qMUILinearLayout2, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.MineFragment.initView.4
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
                try {
                    String string = ContextCompat.getString(MineFragment.this.requireContext(), R.string.contact_email_text);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(requireContext…tring.contact_email_text)");
                    Intent intent = new Intent("android.intent.action.SENDTO");
                    intent.setData(Uri.parse(MailTo.MAILTO_SCHEME));
                    intent.putExtra("android.intent.extra.EMAIL", new String[]{string});
                    MineFragment.this.requireActivity().startActivity(intent);
                } catch (Exception unused) {
                    DialogUtils.INSTANCE.tip("启动邮件发送失败！");
                }
            }
        }, 1, null);
        QMUILinearLayout qMUILinearLayout3 = getBd().lyCheckUpdate;
        Intrinsics.checkNotNullExpressionValue(qMUILinearLayout3, "bd.lyCheckUpdate");
        ViewKt.click$default(qMUILinearLayout3, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.MineFragment.initView.5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.funny.audio.view.mine.MineFragment$initView$5$1, reason: invalid class name */
            /* JADX INFO: compiled from: MineFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.mine.MineFragment$initView$5$1", f = "MineFragment.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ MineFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(MineFragment mineFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = mineFragment;
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
                        if (this.this$0.checkUpdate(this) == coroutine_suspended) {
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
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(MineFragment.this, null), 3, null);
            }
        }, 1, null);
        QMUILinearLayout qMUILinearLayout4 = getBd().lyShareApp;
        Intrinsics.checkNotNullExpressionValue(qMUILinearLayout4, "bd.lyShareApp");
        ViewKt.click$default(qMUILinearLayout4, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.MineFragment.initView.6
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
                try {
                    Object systemService = MineFragment.this.requireContext().getSystemService("clipboard");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                    ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("", AppUpdater.INSTANCE.getShareAppUrl()));
                    DialogUtils.INSTANCE.tip("APP下载地址已复制到粘贴板~快去分享吧~");
                } catch (Exception unused) {
                }
            }
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout2 = getBd().lyNotice;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout2, "bd.lyNotice");
        ViewKt.click$default(qMUIFrameLayout2, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.MineFragment.initView.7
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
                NavigationUtils.INSTANCE.toNotice(MineFragment.this.requireActivity());
            }
        }, 1, null);
        QMUILinearLayout qMUILinearLayout5 = getBd().lyFeedback;
        Intrinsics.checkNotNullExpressionValue(qMUILinearLayout5, "bd.lyFeedback");
        ViewKt.click$default(qMUILinearLayout5, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.MineFragment.initView.8
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
                NavigationUtils.INSTANCE.toFeedback(MineFragment.this.requireActivity());
            }
        }, 1, null);
        QMUILinearLayout qMUILinearLayout6 = getBd().lyPleaseAlbum;
        Intrinsics.checkNotNullExpressionValue(qMUILinearLayout6, "bd.lyPleaseAlbum");
        ViewKt.click$default(qMUILinearLayout6, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.MineFragment.initView.9
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
                NavigationUtils.INSTANCE.toPleaseAlbum(MineFragment.this.requireActivity());
            }
        }, 1, null);
        QMUILinearLayout qMUILinearLayout7 = getBd().lySystemSetting;
        Intrinsics.checkNotNullExpressionValue(qMUILinearLayout7, "bd.lySystemSetting");
        ViewKt.click$default(qMUILinearLayout7, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.MineFragment.initView.10
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
                NavigationUtils.INSTANCE.toSystemSetting(MineFragment.this.requireActivity());
            }
        }, 1, null);
        QMUILinearLayout qMUILinearLayout8 = getBd().lyPureMode;
        Intrinsics.checkNotNullExpressionValue(qMUILinearLayout8, "bd.lyPureMode");
        ViewKt.click$default(qMUILinearLayout8, 0, new Function0<Unit>() { // from class: com.funny.audio.view.mine.MineFragment.initView.11
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
                long jCurrentTimeMillis = System.currentTimeMillis();
                AdSetting setting = AdManager.INSTANCE.getSetting();
                Intrinsics.checkNotNull(setting);
                if (setting.getPureTime().getValueLong() > jCurrentTimeMillis) {
                    DialogUtils.INSTANCE.tip("已处于纯净模式！");
                    return;
                }
                PureModeRewardAdDialog pureModeRewardAdDialog = new PureModeRewardAdDialog();
                FragmentManager parentFragmentManager = MineFragment.this.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "this.parentFragmentManager");
                pureModeRewardAdDialog.show(parentFragmentManager);
            }
        }, 1, null);
    }

    @Override // com.funny.audio.view.core.BaseFragment
    public void initData() {
        loadContact();
        loadVersion();
        loadUserInfo();
        loadPureMode();
        loadSettingGroups2();
    }

    @Override // com.funny.audio.view.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (UserManager.INSTANCE.isLogin()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastGetUserInfoTime > 180000) {
                this.lastGetUserInfoTime = jCurrentTimeMillis;
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C06161(null), 3, null);
            }
        }
        loadUserInfo();
        loadPureMode();
        loadSettingGroups2();
    }

    /* JADX INFO: renamed from: com.funny.audio.view.mine.MineFragment$onResume$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MineFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.mine.MineFragment$onResume$1", f = "MineFragment.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
    static final class C06161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06161(Continuation<? super C06161> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MineFragment.this.new C06161(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (MineFragment.this.reloadUserInfo(this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadUserInfo() {
        try {
            if (UserManager.INSTANCE.isLogin()) {
                UserInfo user = UserManager.INSTANCE.getUser();
                Intrinsics.checkNotNull(user);
                String avatarPath = user.getAvatarPath();
                if (avatarPath == null || avatarPath.length() == 0) {
                    getBd().ivUserCover.setImageResource(R.mipmap.default_user_cover);
                } else {
                    ImageUtils imageUtils = ImageUtils.INSTANCE;
                    Context contextRequireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    QMUIRadiusImageView qMUIRadiusImageView = getBd().ivUserCover;
                    Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "bd.ivUserCover");
                    imageUtils.loadToView(contextRequireContext, qMUIRadiusImageView, user.getAvatarPath());
                }
                getBd().tvNickname.setText(user.getNickname());
                getBd().tvAccount.setText("ID:" + user.getAccount());
                getBd().lyLogout.setVisibility(0);
                getBd().tvLogoutAccount.setText(user.getAccount());
                return;
            }
            getBd().ivUserCover.setImageResource(R.mipmap.default_user_cover);
            getBd().tvNickname.setText("登录/注册");
            getBd().tvAccount.setText("登录即可免费同步云端收藏");
            getBd().lyLogout.setVisibility(8);
        } catch (Exception unused) {
        }
    }

    private final void loadPureMode() {
        AdSetting setting = AdManager.INSTANCE.getSetting();
        Intrinsics.checkNotNull(setting);
        if (AdManager.INSTANCE.getShow() && setting.getPureModeRewardAd().getShow()) {
            if (setting.getPureTime().getValueLong() > System.currentTimeMillis()) {
                getBd().tvPureMode.setText("至" + LongKt.toDateString(setting.getPureTime().getValueLong(), "yyyy-MM-dd HH:mm:ss"));
            } else {
                getBd().tvPureMode.setText("去除弹窗广告");
            }
            getBd().lyPureMode.setVisibility(0);
            return;
        }
        getBd().lyPureMode.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadSettingGroups2() {
        if (getBd().lyLogout.getVisibility() == 8 && getBd().lyPureMode.getVisibility() == 8) {
            getBd().lySettingGroups2.setVisibility(8);
        } else {
            getBd().lySettingGroups2.setVisibility(0);
        }
        if (getBd().lyLogout.getVisibility() == 0 && getBd().lyPureMode.getVisibility() == 0) {
            getBd().space.setVisibility(0);
        } else {
            getBd().space.setVisibility(8);
        }
    }

    private final void loadContact() {
        String string = ContextCompat.getString(requireContext(), R.string.contact_email_text);
        Intrinsics.checkNotNullExpressionValue(string, "getString(requireContext…tring.contact_email_text)");
        getBd().tvContact.setText(string);
    }

    private final void loadVersion() {
        getBd().tvAppVersion.setText(MiscUtils.getAppVersion(getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object reloadUserInfo(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.funny.audio.view.mine.MineFragment.C06171
            if (r0 == 0) goto L14
            r0 = r11
            com.funny.audio.view.mine.MineFragment$reloadUserInfo$1 r0 = (com.funny.audio.view.mine.MineFragment.C06171) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.funny.audio.view.mine.MineFragment$reloadUserInfo$1 r0 = new com.funny.audio.view.mine.MineFragment$reloadUserInfo$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            com.funny.audio.view.mine.MineFragment r0 = (com.funny.audio.view.mine.MineFragment) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L60
            goto L60
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L36:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L5f
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11     // Catch: java.lang.Exception -> L5f
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r11)     // Catch: java.lang.Exception -> L5f
            r5 = 0
            r6 = 0
            com.funny.audio.view.mine.MineFragment$reloadUserInfo$2 r11 = new com.funny.audio.view.mine.MineFragment$reloadUserInfo$2     // Catch: java.lang.Exception -> L5f
            r2 = 0
            r11.<init>(r2)     // Catch: java.lang.Exception -> L5f
            r7 = r11
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: java.lang.Exception -> L5f
            r8 = 3
            r9 = 0
            kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L5f
            r0.L$0 = r10     // Catch: java.lang.Exception -> L5f
            r0.label = r3     // Catch: java.lang.Exception -> L5f
            java.lang.Object r11 = r11.await(r0)     // Catch: java.lang.Exception -> L5f
            if (r11 != r1) goto L5f
            return r1
        L5f:
            r0 = r10
        L60:
            r0.loadUserInfo()
            r0.loadSettingGroups2()
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.mine.MineFragment.reloadUserInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.funny.audio.view.mine.MineFragment$reloadUserInfo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MineFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.mine.MineFragment$reloadUserInfo$2", f = "MineFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06182 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06182(Continuation<? super C06182> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MineFragment.this.new C06182(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06182) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Response<UserInfo> userInfo = ApiManager.INSTANCE.getUser().getUserInfo();
            if (NetModelsKt.successWithData(userInfo)) {
                AppBody<UserInfo> body = userInfo.getBody();
                Intrinsics.checkNotNull(body);
                UserInfo data = body.getData();
                Intrinsics.checkNotNull(data);
                UserInfo userInfo2 = data;
                UserInfo user = UserManager.INSTANCE.getUser();
                Intrinsics.checkNotNull(user);
                if (!Intrinsics.areEqual(user.getDeviceId(), userInfo2.getDeviceId())) {
                    UserManager.INSTANCE.logout();
                    MessageDialogFragment messageDialogFragmentDisableCancel = MessageDialogFragment.setPositiveBtn$default(new MessageDialogFragment().setTitle("下线通知").setContent("您的账号已在另一台设备登录。"), "知道了", null, 2, null).disableCancel();
                    FragmentManager childFragmentManager = MineFragment.this.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "this@MineFragment.childFragmentManager");
                    messageDialogFragmentDisableCancel.show(childFragmentManager);
                } else {
                    UserManager.INSTANCE.save(userInfo2);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadCacheInfo(Continuation<? super String> continuation) {
        StringBuilder sb = new StringBuilder();
        File file = new File(FileUtils.getCacheFileDir(getContext()), ApiServiceFactory.INSTANCE.getCacheDir());
        File file2 = new File(FileUtils.getCacheFileDir(getContext()), GlideOkHttpModule.INSTANCE.getCacheDir());
        File file3 = new File(FileUtils.getCacheFileDir(getContext()), MediaPlayerManager.INSTANCE.getCacheDir());
        File externalCacheDir = requireContext().getExternalCacheDir();
        File externalFilesDir = requireContext().getExternalFilesDir("Download");
        if (file.exists()) {
            sb.append("网络缓存：" + MineFragmentKt.getNoMoreThanTwoDigits((FileUtils.getDirSizes(file) / 1024.0d) / 1024.0d) + " MB" + System.lineSeparator());
        }
        if (file2.exists()) {
            sb.append("封面缓存：" + MineFragmentKt.getNoMoreThanTwoDigits((FileUtils.getDirSizes(file2) / 1024.0d) / 1024.0d) + " MB" + System.lineSeparator());
        }
        if (file3.exists()) {
            sb.append("音频缓存：" + MineFragmentKt.getNoMoreThanTwoDigits((FileUtils.getDirSizes(file3) / 1024.0d) / 1024.0d) + " MB" + System.lineSeparator());
        }
        long dirSizes = 0;
        if (externalCacheDir != null && externalCacheDir.exists()) {
            dirSizes = 0 + FileUtils.getDirSizes(externalCacheDir);
        }
        if (externalFilesDir != null && externalFilesDir.exists()) {
            dirSizes += FileUtils.getDirSizes(externalFilesDir);
        }
        sb.append("其他缓存：" + MineFragmentKt.getNoMoreThanTwoDigits((dirSizes / 1024.0d) / 1024.0d) + " MB" + System.lineSeparator());
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "stringBuilder.toString()");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object clearCache(kotlin.coroutines.Continuation<? super kotlin.Unit> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.mine.MineFragment.clearCache(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object checkUpdate(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.funny.audio.view.mine.MineFragment.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r12
            com.funny.audio.view.mine.MineFragment$checkUpdate$1 r0 = (com.funny.audio.view.mine.MineFragment.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            com.funny.audio.view.mine.MineFragment$checkUpdate$1 r0 = new com.funny.audio.view.mine.MineFragment$checkUpdate$1
            r0.<init>(r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r0 = r0.L$0
            com.funny.audio.view.mine.MineFragment r0 = (com.funny.audio.view.mine.MineFragment) r0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> L85
            goto L60
        L2f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L37:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlinx.coroutines.CoroutineDispatcher r12 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L85
            kotlin.coroutines.CoroutineContext r12 = (kotlin.coroutines.CoroutineContext) r12     // Catch: java.lang.Exception -> L85
            kotlinx.coroutines.CoroutineScope r5 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r12)     // Catch: java.lang.Exception -> L85
            r6 = 0
            r7 = 0
            com.funny.audio.view.mine.MineFragment$checkUpdate$updateInfo$1 r12 = new com.funny.audio.view.mine.MineFragment$checkUpdate$updateInfo$1     // Catch: java.lang.Exception -> L85
            r12.<init>(r3)     // Catch: java.lang.Exception -> L85
            r8 = r12
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8     // Catch: java.lang.Exception -> L85
            r9 = 3
            r10 = 0
            kotlinx.coroutines.Deferred r12 = kotlinx.coroutines.BuildersKt.async$default(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L85
            r0.L$0 = r11     // Catch: java.lang.Exception -> L85
            r0.label = r4     // Catch: java.lang.Exception -> L85
            java.lang.Object r12 = r12.await(r0)     // Catch: java.lang.Exception -> L85
            if (r12 != r1) goto L5f
            return r1
        L5f:
            r0 = r11
        L60:
            com.funny.audio.models.CloudUpdateInfo r12 = (com.funny.audio.models.CloudUpdateInfo) r12     // Catch: java.lang.Exception -> L85
            com.funny.audio.update.AppUpdater r1 = com.funny.audio.update.AppUpdater.INSTANCE     // Catch: java.lang.Exception -> L85
            boolean r12 = r1.hasUpdate(r12, r4)     // Catch: java.lang.Exception -> L85
            if (r12 == 0) goto L7d
            com.funny.audio.view.update.UpdateDialogFragment r12 = new com.funny.audio.view.update.UpdateDialogFragment     // Catch: java.lang.Exception -> L85
            r12.<init>()     // Catch: java.lang.Exception -> L85
            androidx.fragment.app.FragmentManager r0 = r0.getChildFragmentManager()     // Catch: java.lang.Exception -> L85
            java.lang.String r1 = "this.childFragmentManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> L85
            r1 = 2
            com.funny.audio.view.update.UpdateDialogFragment.show$default(r12, r0, r3, r1, r3)     // Catch: java.lang.Exception -> L85
            goto L8c
        L7d:
            com.funny.audio.view.DialogUtils r12 = com.funny.audio.view.DialogUtils.INSTANCE     // Catch: java.lang.Exception -> L85
            java.lang.String r0 = "已更新到最新版本！"
            r12.tip(r0)     // Catch: java.lang.Exception -> L85
            goto L8c
        L85:
            com.funny.audio.view.DialogUtils r12 = com.funny.audio.view.DialogUtils.INSTANCE
            java.lang.String r0 = "检查更新出错！"
            r12.tip(r0)
        L8c:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.mine.MineFragment.checkUpdate(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
