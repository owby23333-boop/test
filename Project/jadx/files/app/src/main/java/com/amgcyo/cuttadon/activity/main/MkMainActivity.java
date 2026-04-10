package com.amgcyo.cuttadon.activity.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.BmobDialogButtonListener;
import cn.bmob.v3.listener.BmobUpdateListener;
import cn.bmob.v3.update.BmobUpdateAgent;
import cn.bmob.v3.update.UpdateResponse;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.setting.MkNoticeActivity;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.api.entity.migrate.DaoliuData;
import com.amgcyo.cuttadon.api.entity.other.LocalReadHistoryBean;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkCommentStatus;
import com.amgcyo.cuttadon.api.entity.other.MkConfigSource;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.entity.other.RewardAdParam;
import com.amgcyo.cuttadon.api.entity.other.UmPushBean;
import com.amgcyo.cuttadon.api.entity.other.UserIndex;
import com.amgcyo.cuttadon.api.presenter.ConfigPresenter;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.database.ReadHistoryDatabase;
import com.amgcyo.cuttadon.fragment.books.BookAndComicFragment;
import com.amgcyo.cuttadon.fragment.books.MkBookStoreFragment;
import com.amgcyo.cuttadon.fragment.books.MkMineFragmentNew;
import com.amgcyo.cuttadon.fragment.books.MkQiushuFragemnt;
import com.amgcyo.cuttadon.fragment.fission5.Fission5IndexFragment;
import com.amgcyo.cuttadon.fragment.fission6.Fission6IndexFragment;
import com.amgcyo.cuttadon.h.i.h.e;
import com.amgcyo.cuttadon.soloader.SoFileLoadManager;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.utils.otherutils.t0;
import com.amgcyo.cuttadon.utils.otherutils.x0;
import com.amgcyo.cuttadon.view.dialog.f1;
import com.amgcyo.cuttadon.view.dialog.u0;
import com.amgcyo.cuttadon.view.otherview.BadgeView;
import com.amgcyo.cuttadon.view.otherview.FixedAnimatedRadioButton;
import com.amgcyo.cuttadon.view.popupview.Fission5FirstTipDialog;
import com.amgcyo.cuttadon.widget.ui.FixedSpeedViewpager;
import com.anythink.splashad.api.ATSplashEyeAdListener;
import com.fatcatfat.io.R;
import com.lxj.xpopup.a;
import com.lxj.xpopup.core.BasePopupView;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushTagCallback;
import com.umeng.message.common.inter.ITagManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import me.jessyan.art.mvp.Message;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
public class MkMainActivity extends BaseTitleBarActivity<ConfigPresenter> implements com.amgcyo.cuttadon.g.b, com.amgcyo.cuttadon.h.f.c, com.open.hule.library.b.a {
    public static final int CLIPBOARD = 1;
    public static final int SAF = 0;
    private MkCommentEvent D0;

    @BindView(R.id.btn_fission6)
    Button btn_fission6;

    @BindView(R.id.btn_my)
    Button btn_my;

    @BindView(R.id.btn_qiushu)
    Button btn_qiushu;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private long f2579n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    MkMineFragmentNew f2580o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    MkQiushuFragemnt f2581p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    List<Fragment> f2582q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    int f2583r0;

    @BindView(R.id.rb_bookCity)
    FixedAnimatedRadioButton rb_bookCity;

    @BindView(R.id.rb_bookshelf)
    FixedAnimatedRadioButton rb_bookshelf;

    @BindView(R.id.rb_fission6)
    FixedAnimatedRadioButton rb_fission6;

    @BindView(R.id.rb_mine)
    FixedAnimatedRadioButton rb_mine;

    @BindView(R.id.rb_qiushu)
    FixedAnimatedRadioButton rb_qiushu;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    int f2584s0;

    @BindView(R.id.tabradios)
    RadioGroup tabradios;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    BadgeView f2586u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    BadgeView f2587v0;

    @BindView(R.id.viewpager)
    FixedSpeedViewpager viewpager;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    BadgeView f2588w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    UserIndex f2589x0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    int f2585t0 = 10;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    int f2590y0 = -1;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    int f2591z0 = -1;
    int A0 = -1;
    int B0 = -1;
    int C0 = -1;
    int E0 = 0;
    private boolean F0 = false;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            MkMainActivity mkMainActivity = MkMainActivity.this;
            FixedAnimatedRadioButton fixedAnimatedRadioButton = mkMainActivity.rb_mine;
            if (fixedAnimatedRadioButton != null) {
                mkMainActivity.f2583r0 = fixedAnimatedRadioButton.getMeasuredWidth();
                MkMainActivity mkMainActivity2 = MkMainActivity.this;
                if (mkMainActivity2.f2583r0 > 0) {
                    mkMainActivity2.rb_mine.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        }
    }

    class b implements ATSplashEyeAdListener {
        final /* synthetic */ com.amgcyo.cuttadon.h.i.h.e a;

        class a implements e.b {
            a() {
            }

            @Override // com.amgcyo.cuttadon.h.i.h.e.b
            public void a(int i2) {
                String unused = ((BaseTitleBarActivity) MkMainActivity.this).f2273s;
            }

            @Override // com.amgcyo.cuttadon.h.i.h.e.b
            public void a() {
                String unused = ((BaseTitleBarActivity) MkMainActivity.this).f2273s;
                com.amgcyo.cuttadon.h.i.h.a.a.onFinished();
            }
        }

        b(com.amgcyo.cuttadon.h.i.h.e eVar) {
            this.a = eVar;
        }

        @Override // com.anythink.splashad.api.ATSplashEyeAdListener
        public void onAdDismiss(boolean z2, String str) {
            String unused = ((BaseTitleBarActivity) MkMainActivity.this).f2273s;
            com.amgcyo.cuttadon.h.i.h.e.a(MkMainActivity.this.getApplicationContext()).a();
            com.amgcyo.cuttadon.h.i.h.a.a.destroy();
            com.amgcyo.cuttadon.h.i.h.a.a = null;
        }

        @Override // com.anythink.splashad.api.ATSplashEyeAdListener
        public void onAnimationStart(View view) {
            this.a.a((ViewGroup) MkMainActivity.this.getWindow().getDecorView(), (ViewGroup) MkMainActivity.this.findViewById(android.R.id.content), new a());
        }
    }

    private void e(String str) {
        boolean zB = com.amgcyo.cuttadon.utils.otherutils.f0.b(this.f2277w);
        String str2 = "enabled:" + zB;
        if (zB || com.amgcyo.cuttadon.app.o.c.g() < 5) {
            return;
        }
        String str3 = "key_notification_" + str;
        com.amgcyo.cuttadon.utils.otherutils.g0 g0VarA = com.amgcyo.cuttadon.utils.otherutils.g0.a();
        boolean zA = g0VarA.a(str3, false);
        String str4 = "isTodayShow:" + zA;
        if (zA) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(3);
        String str5 = "year_week" + i2 + i3;
        boolean zA2 = g0VarA.a(str5, false);
        String str6 = "当前是" + i2 + "年第" + i3 + "周,year_week_key:" + str5 + "\n" + zA2;
        if (zA2) {
            return;
        }
        new f1(this.f2277w, str5, str3).show();
    }

    private void f(String str) {
        try {
            ConfigPresenter configPresenter = new ConfigPresenter(me.jessyan.art.f.e.a(this));
            if (!str.equals(com.amgcyo.cuttadon.utils.comic.d.a("HotKey", ""))) {
                configPresenter.h(Message.a(this, new Object[0]));
            }
            if (str.equals(com.amgcyo.cuttadon.utils.comic.d.a("regex_new", ""))) {
                return;
            }
            configPresenter.e(Message.a(this, new Object[0]));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void p() {
        File file = new File(com.amgcyo.cuttadon.utils.otherutils.z.b, "gaoshanliushui.mp3");
        if (!file.exists()) {
            com.amgcyo.cuttadon.utils.otherutils.z.a(this, R.raw.gaoshanliushui, file.getName(), com.amgcyo.cuttadon.utils.otherutils.z.b);
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("tts_mp3_path", file.getAbsolutePath());
        }
        try {
            String[] list = getAssets().list("baidu_tts");
            if (list == null || list.length <= 0) {
                return;
            }
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    File file2 = new File(SoFileLoadManager.c(), str);
                    if (!file2.exists()) {
                        com.amgcyo.cuttadon.utils.otherutils.z.a(this, "baidu_tts" + File.separator + str, file2.getAbsolutePath());
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void q() {
        MkQiushuFragemnt mkQiushuFragemnt = this.f2581p0;
        if (mkQiushuFragemnt != null) {
            mkQiushuFragemnt.l();
        } else {
            showMessage("参数异常，请重启APP后重试！");
        }
        this.F0 = false;
    }

    private void r() {
        String strB = com.amgcyo.cuttadon.utils.otherutils.j.b(this);
        String str = "clipboardText:" + strB;
        if (TextUtils.isEmpty(strB)) {
            b("clipboard no data ");
            showErrorMsgGravityBottom("剪切板无数据，可尝试回到旧app重新操作或选择从备份文件中恢复！");
            return;
        }
        try {
            a((DaoliuData) com.amgcyo.cuttadon.utils.otherutils.r.a(strB, DaoliuData.class), true);
        } catch (Exception e2) {
            e2.printStackTrace();
            showErrorMsgGravityBottom("剪切板无备份数据，可尝试回到旧app重新操作或选择从备份文件中恢复！");
            a("clipboard error,clipboardText is " + strB, e2);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.a0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2634s.n();
                }
            }, com.anythink.expressad.exoplayer.i.a.f9492f);
        }
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "refresh_user_center")
    private void refreshUserIndex(com.amgcyo.cuttadon.view.read.page.i iVar) {
        if (iVar != null && this.f2589x0 == null) {
            getUserIndex(false);
        }
    }

    private void s() {
        try {
            Toast.makeText(this.f2277w, "请选择刚才保存的备份文件进行恢复.", 0).show();
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("text/*");
            intent.putExtra("android.content.extra.SHOW_ADVANCED", true);
            intent.putExtra("android.content.extra.FANCY", true);
            intent.putExtra("android.content.extra.SHOW_FILESIZE", true);
            if (Build.VERSION.SDK_INT >= 26) {
                String strB = com.amgcyo.cuttadon.utils.otherutils.j.b(this);
                String str = "clipboardText:" + strB;
                if (!TextUtils.isEmpty(strB)) {
                    try {
                        Uri uri = Uri.parse(strB);
                        if (uri != null) {
                            intent.putExtra("android.provider.extra.INITIAL_URI", uri);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            startActivityForResult(intent, BaseTitleBarActivity.READ_REQUEST_CODE);
        } catch (Exception e3) {
            showErrorMsgGravityBottom("操作失败，请反馈给客服！");
            a("start saf error ", e3);
        }
    }

    @Subscriber(mode = ThreadMode.MAIN, tag = "tag_restore_data")
    private void subscriberRestoreData(MkCommentEvent mkCommentEvent) {
        if (mkCommentEvent == null) {
            return;
        }
        if (mkCommentEvent.f() == 0) {
            a(0, 0);
        } else {
            a(0, 1);
        }
    }

    @Subscriber(mode = ThreadMode.POST, tag = "tag_read_activity_to_book_city")
    private void subscriberToBookCity(com.amgcyo.cuttadon.view.read.page.i iVar) {
        if (iVar == null) {
            return;
        }
        toBookCity(iVar.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        BaseAd baseAdB = com.amgcyo.cuttadon.sdk.utils.e.b("position_asking_book_reward_ad_video", "asking_book");
        if (baseAdB == null) {
            showMessage("错误码：c1227");
            return;
        }
        String platform = baseAdB.getPlatform();
        if (TextUtils.isEmpty(platform)) {
            showMessage("错误码：c1228");
        } else {
            com.amgcyo.cuttadon.h.g.i.a().a(this.f2277w, new RewardAdParam(platform, "position_asking_book_reward_ad_video", com.amgcyo.cuttadon.utils.otherutils.h.a(platform, "k"), baseAdB.getStyle(), baseAdB.isNoExempt()), this);
        }
    }

    private void u() {
        final String str = com.amgcyo.cuttadon.utils.otherutils.g.B() + "oldpush_to_umpush";
        boolean zA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a(str, false);
        String str2 = "jpush_to_umpush:" + zA;
        System.out.println("jpush_to_umpush:" + zA);
        if (zA) {
            return;
        }
        List<MkBook> listB = AppDatabase.i().a().b();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(listB)) {
            System.out.println("no push data");
            return;
        }
        System.out.println("jpusyBookList:" + listB.size());
        String[] strArrA = com.amgcyo.cuttadon.i.n.a(listB);
        if (strArrA == null || strArrA.length <= 0) {
            return;
        }
        PushAgent.getInstance(MkApplication.getAppContext()).getTagManager().addTags(new UPushTagCallback() { // from class: com.amgcyo.cuttadon.activity.main.z
            @Override // com.umeng.message.api.UPushTagCallback
            public final void onMessage(boolean z2, Object obj) {
                MkMainActivity.a(str, z2, (ITagManager.Result) obj);
            }
        }, strArrA);
    }

    private void w() {
        com.github.gzuliyujiang.oaid.b.a((Context) MkApplication.getAppContext());
        if (com.amgcyo.cuttadon.app.o.c.h()) {
            com.amgcyo.cuttadon.utils.otherutils.g0 g0VarA = com.amgcyo.cuttadon.utils.otherutils.g0.a();
            if (g0VarA.a("topon_new", false)) {
                boolean zA = g0VarA.a("topon_splash_ad_1_key", false);
                boolean zA2 = g0VarA.a("topon_inter_ad_4_key", false);
                boolean zA3 = g0VarA.a("topon_reward_ad_5_key", false);
                String str = "topon是否需要初始化插屏全屏：\n" + zA2 + " 和激励视频：" + zA3 + " 和闪屏图片：" + zA;
                if (zA2) {
                    String strA = com.amgcyo.cuttadon.utils.otherutils.h.a("topon_new", "d");
                    String str2 = "插屏全屏id：" + strA;
                    if (!TextUtils.isEmpty(strA)) {
                        com.amgcyo.cuttadon.h.i.e.a().a(this, strA, null, 1);
                    }
                }
                if (zA3) {
                    RewardAdParam rewardAdParam = new RewardAdParam();
                    rewardAdParam.setAdPosition("topon_pre_reward_mainpage");
                    rewardAdParam.setPlatform("topon_new");
                    rewardAdParam.setStochasticKey("topon_pre_reward_mainpage");
                    rewardAdParam.setLoadType(1);
                    com.amgcyo.cuttadon.h.g.j.c().a(this.f2277w, rewardAdParam, (com.amgcyo.cuttadon.h.f.c) null);
                }
                if (zA) {
                    String strA2 = com.amgcyo.cuttadon.utils.otherutils.h.a("topon_new", "a");
                    if (TextUtils.isEmpty(strA2)) {
                        return;
                    }
                    com.amgcyo.cuttadon.h.i.g.c.a().a(this, strA2);
                }
            }
        }
    }

    private void x() {
        if (com.amgcyo.cuttadon.h.i.h.a.a == null) {
            return;
        }
        com.amgcyo.cuttadon.h.i.h.e eVarA = com.amgcyo.cuttadon.h.i.h.e.a(getApplicationContext());
        int[] suggestedSize = com.amgcyo.cuttadon.h.i.h.a.a.getSuggestedSize(getApplicationContext());
        if (suggestedSize != null) {
            eVarA.a(suggestedSize[0], suggestedSize[1]);
        }
        com.amgcyo.cuttadon.h.i.h.a.a.setEyeAdContainer(eVarA.b());
        com.amgcyo.cuttadon.h.i.h.a.a.show(this, null, new b(eVarA));
    }

    private void y() {
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
            boolean zA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("is_show_with_draw" + t0.a(), false);
            String str = "is_show_with_draw:" + zA;
            if (zA) {
                return;
            }
            a.b bVar = new a.b(this.f2277w);
            bVar.b(true);
            bVar.d(false);
            bVar.e(true);
            Fission5FirstTipDialog fission5FirstTipDialog = new Fission5FirstTipDialog(this.f2277w);
            bVar.a((BasePopupView) fission5FirstTipDialog);
            fission5FirstTipDialog.u();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void z() {
        String strD = com.amgcyo.cuttadon.utils.otherutils.g0.a().d("UmPushBean");
        UmPushBean umPushBean = (UmPushBean) com.amgcyo.cuttadon.utils.otherutils.r.a(strD, UmPushBean.class);
        if (umPushBean != null) {
            UmPushBean.ExtraBean extra = umPushBean.getExtra();
            String type = extra.getType();
            int bookId = extra.getBookId();
            String str = "类型：" + type + " bookId: " + bookId;
            byte b2 = -1;
            switch (type.hashCode()) {
                case -1945383662:
                    if (type.equals("bookUpdate")) {
                        b2 = 1;
                    }
                    break;
                case -1039690024:
                    if (type.equals("notice")) {
                        b2 = 4;
                    }
                    break;
                case -191501435:
                    if (type.equals("feedback")) {
                        b2 = 2;
                    }
                    break;
                case 1614800665:
                    if (type.equals("bookDetails")) {
                        b2 = 0;
                    }
                    break;
                case 2103873213:
                    if (type.equals("comment_rep")) {
                        b2 = 3;
                    }
                    break;
            }
            if (b2 == 0) {
                com.amgcyo.cuttadon.utils.otherutils.r0.b(this.f2277w, bookId, extra.getForm());
            } else if (b2 == 1) {
                com.amgcyo.cuttadon.utils.otherutils.g0.a().b("UmPushBean", "");
            } else if (b2 == 2 || b2 == 3) {
                if (com.amgcyo.cuttadon.utils.otherutils.g.j() != null) {
                    Intent intent = new Intent(this.f2277w, (Class<?>) MkNoticeActivity.class);
                    intent.putExtra("UmPushBean", umPushBean);
                    intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                    this.f2277w.startActivity(intent);
                }
            } else if (b2 == 4) {
                Intent intent2 = new Intent(this.f2277w, (Class<?>) MkNoticeActivity.class);
                intent2.putExtra("UmPushBean", umPushBean);
                intent2.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                this.f2277w.startActivity(intent2);
            }
        }
        String str2 = "notification receiver:" + strD;
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b("UmPushBean", "");
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return null;
    }

    public void getUserIndex(boolean z2) {
        ((ConfigPresenter) this.f2276v).j(Message.a(this, new Object[]{Boolean.valueOf(z2), 861}));
        long jB = t0.b(com.amgcyo.cuttadon.utils.otherutils.h.z());
        Long.valueOf(jB);
        if (jB <= 0 || jB >= 1440) {
            ((ConfigPresenter) this.f2276v).g(Message.a(this, new Object[0]));
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        if (message.f21197s == 861) {
            this.f2589x0 = (UserIndex) message.f21202x;
            UserIndex userIndex = this.f2589x0;
            if (userIndex == null || TextUtils.isEmpty(userIndex.getUser_login())) {
                return;
            }
            if (this.f2589x0.getInvitation_count() > 0) {
                com.amgcyo.cuttadon.utils.otherutils.g.p(3);
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.tabradios.getChildCount(); i3++) {
                if (this.tabradios.getChildAt(i3).getVisibility() == 0) {
                    i2++;
                }
            }
            if (i2 == 0) {
                i2 = 4;
            }
            this.f2584s0 = this.f2589x0.getAsking_book_number();
            if (com.amgcyo.cuttadon.utils.otherutils.h.H0()) {
                int sign_in = this.f2589x0.getSign_in();
                if (this.f2588w0 == null) {
                    if (sign_in != 1) {
                        Button button = this.btn_fission6;
                        int i4 = this.f2585t0;
                        this.f2588w0 = com.amgcyo.cuttadon.f.o.a(this, button, "签到", i4, i4, 2);
                    } else {
                        Button button2 = this.btn_fission6;
                        int i5 = this.f2585t0;
                        this.f2588w0 = com.amgcyo.cuttadon.f.o.a(this, button2, "赚钱", i5, i5, 2);
                    }
                }
            } else {
                int i6 = this.f2584s0;
                if (i6 > 0) {
                    MkQiushuFragemnt mkQiushuFragemnt = this.f2581p0;
                    if (mkQiushuFragemnt != null) {
                        mkQiushuFragemnt.a(Integer.valueOf(i6));
                    }
                    String strValueOf = this.f2584s0 >= 9 ? "9+" : String.valueOf(this.f2584s0);
                    if (this.f2587v0 == null) {
                        Button button3 = this.btn_qiushu;
                        int i7 = this.f2585t0;
                        this.f2587v0 = com.amgcyo.cuttadon.f.o.a(this, button3, strValueOf, i7, i7, 2);
                    }
                }
            }
            int service_appeal_number = this.f2589x0.getService_appeal_number() + this.f2589x0.getComment_number();
            if (service_appeal_number > 0) {
                this.f2586u0 = com.amgcyo.cuttadon.f.o.a(this, this.btn_my, service_appeal_number >= 9 ? "9+" : String.valueOf(service_appeal_number), this.f2583r0 / (i2 - 1), this.f2585t0, 2);
            }
        }
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        getUserIndex(false);
        String strA = t0.a();
        try {
            insertSaveData();
            e(strA);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        z();
        f(strA);
        setLoginText(com.amgcyo.cuttadon.utils.otherutils.g.j());
        ((ConfigPresenter) this.f2276v).f(Message.a(this, new Object[0]));
        this.f2582q0 = new ArrayList();
        this.viewpager.setNoScroll(true);
        MkBookStoreFragment mkBookStoreFragment = new MkBookStoreFragment();
        this.f2582q0.clear();
        this.f2582q0.add(new BookAndComicFragment());
        this.f2582q0.add(mkBookStoreFragment);
        this.f2581p0 = new MkQiushuFragemnt();
        this.f2582q0.add(this.f2581p0);
        this.rb_qiushu.setVisibility(0);
        this.btn_qiushu.setVisibility(4);
        this.rb_qiushu.setText("求书");
        com.amgcyo.cuttadon.f.o.b(this.rb_qiushu, getResources().getDrawable(R.drawable.rb_qiushu));
        if (com.amgcyo.cuttadon.utils.otherutils.h.H0()) {
            this.f2582q0.add(new Fission5IndexFragment());
            this.rb_fission6.setVisibility(0);
            this.rb_fission6.setText("福利");
            com.amgcyo.cuttadon.f.o.b(this.rb_fission6, getResources().getDrawable(R.drawable.rb_fuli));
            this.btn_fission6.setVisibility(4);
            y();
        } else if (com.amgcyo.cuttadon.utils.otherutils.h.I0() || com.amgcyo.cuttadon.utils.otherutils.h.J0()) {
            this.f2582q0.add(new Fission6IndexFragment());
            this.rb_fission6.setVisibility(0);
            this.rb_fission6.setText(com.amgcyo.cuttadon.f.o.d(R.string.share));
            com.amgcyo.cuttadon.f.o.b(this.rb_fission6, getResources().getDrawable(R.drawable.rb_fission));
            this.btn_fission6.setVisibility(4);
            if (this.f2588w0 == null) {
                Button button = this.btn_fission6;
                String strA2 = com.amgcyo.cuttadon.f.o.a();
                int i2 = this.f2585t0;
                this.f2588w0 = com.amgcyo.cuttadon.f.o.a(this, button, strA2, i2, i2, 2);
            }
        } else {
            this.btn_fission6.setVisibility(8);
            this.rb_fission6.setVisibility(8);
        }
        this.f2580o0 = new MkMineFragmentNew();
        this.f2582q0.add(this.f2580o0);
        this.viewpager.setOffscreenPageLimit(this.f2582q0.size());
        this.viewpager.setAdapter(new com.amgcyo.cuttadon.adapter.other.s(this, this.f2582q0, getSupportFragmentManager()));
        this.rb_mine.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        com.amgcyo.cuttadon.view.read.page.k.c(this).j(com.amgcyo.cuttadon.utils.otherutils.g.M());
        p();
        u();
        try {
            String strS = com.amgcyo.cuttadon.utils.otherutils.h.s();
            if (!TextUtils.isEmpty(strS)) {
                Bmob.initialize(this, strS);
                BmobUpdateAgent.setUpdateListener(new BmobUpdateListener() { // from class: com.amgcyo.cuttadon.activity.main.f0
                    @Override // cn.bmob.v3.listener.BmobUpdateListener
                    public final void onUpdateReturned(int i3, UpdateResponse updateResponse) {
                        this.a.b(i3, updateResponse);
                    }
                });
                BmobUpdateAgent.setDialogListener(new BmobDialogButtonListener() { // from class: com.amgcyo.cuttadon.activity.main.e0
                    @Override // cn.bmob.v3.listener.BmobDialogButtonListener
                    public final void onClick(int i3) {
                        this.a.c(i3);
                    }
                });
                BmobUpdateAgent.silentUpdate(this);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        com.amgcyo.cuttadon.utils.otherutils.g.t0();
        w();
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_main;
    }

    public void insertSaveData() {
        StringBuilder sb;
        String str;
        MkUser mkUser;
        boolean zP = com.amgcyo.cuttadon.utils.otherutils.g.p();
        String str2 = "onCorruption:" + zP;
        if (zP) {
            String strE = com.amgcyo.cuttadon.utils.otherutils.z.e();
            AppDatabase appDatabaseI = AppDatabase.i();
            System.out.println("正在恢复数据...");
            String strM = com.amgcyo.cuttadon.utils.otherutils.z.m(new File(strE, "user.json").getAbsolutePath());
            if (!TextUtils.isEmpty(strM) && !"null".equals(strM) && (mkUser = (MkUser) com.amgcyo.cuttadon.utils.otherutils.r.a(strM, MkUser.class)) != null) {
                com.amgcyo.cuttadon.utils.otherutils.g.a(String.valueOf(mkUser.getUser_id()), mkUser.getToken());
                int i2 = (appDatabaseI.d().insert(mkUser) > 0L ? 1 : (appDatabaseI.d().insert(mkUser) == 0L ? 0 : -1));
            }
            String strM2 = com.amgcyo.cuttadon.utils.otherutils.z.m(new File(strE, "shelf.json").getAbsolutePath());
            if (!TextUtils.isEmpty(strM2) && !"null".equals(strM2)) {
                List<MkBook> listB = com.amgcyo.cuttadon.utils.otherutils.r.b(strM2, MkBook.class);
                if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) listB)) {
                    for (MkBook mkBook : listB) {
                        if (appDatabaseI.a().insert(mkBook) > 0) {
                            sb = new StringBuilder();
                            sb.append(mkBook.getName());
                            str = "-恢复成功";
                        } else {
                            sb = new StringBuilder();
                            sb.append(mkBook.getName());
                            str = "-恢复失败";
                        }
                        sb.append(str);
                        sb.toString();
                    }
                }
            }
            String strM3 = com.amgcyo.cuttadon.utils.otherutils.z.m(new File(strE, "comment.json").getAbsolutePath());
            if (!TextUtils.isEmpty(strM3) && !"null".equals(strM3)) {
                List listB2 = com.amgcyo.cuttadon.utils.otherutils.r.b(strM3, MkCommentStatus.class);
                if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) listB2)) {
                    Iterator it = listB2.iterator();
                    while (it.hasNext()) {
                        int i3 = (appDatabaseI.b().insert((MkCommentStatus) it.next()) > 0L ? 1 : (appDatabaseI.b().insert((MkCommentStatus) it.next()) == 0L ? 0 : -1));
                    }
                }
            }
            String strM4 = com.amgcyo.cuttadon.utils.otherutils.z.m(new File(strE, "site_regular.json").getAbsolutePath());
            if (!TextUtils.isEmpty(strM4) && !"null".equals(strM4)) {
                List listB3 = com.amgcyo.cuttadon.utils.otherutils.r.b(strM4, MkConfigSource.class);
                if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) listB3)) {
                    Iterator it2 = listB3.iterator();
                    while (it2.hasNext()) {
                        int i4 = (appDatabaseI.c().insert((MkConfigSource) it2.next()) > 0L ? 1 : (appDatabaseI.c().insert((MkConfigSource) it2.next()) == 0L ? 0 : -1));
                    }
                }
            }
            String strM5 = com.amgcyo.cuttadon.utils.otherutils.z.m(new File(strE, "read_history.json").getAbsolutePath());
            if (!TextUtils.isEmpty(strM5) && !"null".equals(strM5)) {
                ReadHistoryDatabase readHistoryDatabaseB = ReadHistoryDatabase.b();
                List listB4 = com.amgcyo.cuttadon.utils.otherutils.r.b(strM5, LocalReadHistoryBean.class);
                if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) listB4)) {
                    Iterator it3 = listB4.iterator();
                    while (it3.hasNext()) {
                        int i5 = (readHistoryDatabaseB.a().insert((LocalReadHistoryBean) it3.next()) > 0L ? 1 : (readHistoryDatabaseB.a().insert((LocalReadHistoryBean) it3.next()) == 0L ? 0 : -1));
                    }
                }
            }
            com.amgcyo.cuttadon.utils.otherutils.g.b(false);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    public void loadRewardVideoAd() {
        String strB = com.amgcyo.cuttadon.utils.otherutils.g.B();
        this.E0 = com.amgcyo.cuttadon.utils.otherutils.g0.a().a(strB + "technology", 0);
        int iK = com.amgcyo.cuttadon.utils.otherutils.h.k();
        String strD = com.amgcyo.cuttadon.f.o.d(R.string.askbook_msg);
        if (iK <= 0) {
            strD = com.amgcyo.cuttadon.f.o.d(R.string.askbook_msg_not_free);
        }
        String str = "今日求书次数：" + this.E0 + " 总次数：" + iK;
        if (this.E0 <= iK || com.amgcyo.cuttadon.utils.otherutils.g.a(com.amgcyo.cuttadon.utils.otherutils.h.l())) {
            q();
            return;
        }
        u0 u0Var = new u0(this.f2277w, View.inflate(a(), R.layout.dialog_tips_dialog, null), R.style.custom_dialog);
        u0Var.setCancelable(true);
        u0Var.a(strD, "我要求书", "看小视频求书");
        u0Var.a(new com.amgcyo.cuttadon.g.f() { // from class: com.amgcyo.cuttadon.activity.main.c0
            @Override // com.amgcyo.cuttadon.g.f
            public final void a() {
                this.a.t();
            }
        });
        u0Var.show();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    public /* synthetic */ void n() {
        com.amgcyo.cuttadon.utils.otherutils.j.a(a());
    }

    public /* synthetic */ void o() {
        Button button = this.btn_qiushu;
        int i2 = this.f2585t0;
        this.f2587v0 = com.amgcyo.cuttadon.f.o.a(this, button, "赚钱", i2, i2, 2);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        x();
    }

    @OnClick({R.id.rb_bookCity, R.id.rb_bookshelf, R.id.rb_qiushu, R.id.rb_fission6, R.id.rb_mine})
    public void onClick(View view) {
        int i2 = 0;
        switch (view.getId()) {
            case R.id.rb_bookCity /* 2131298196 */:
                if (this.f2590y0 == -1) {
                    while (true) {
                        if (i2 < this.f2582q0.size()) {
                            if (this.f2582q0.get(i2) instanceof MkBookStoreFragment) {
                                this.f2590y0 = i2;
                            } else {
                                i2++;
                            }
                        }
                    }
                }
                int currentItem = this.viewpager.getCurrentItem();
                int i3 = this.f2590y0;
                if (currentItem != i3) {
                    this.viewpager.setCurrentItem(i3);
                }
                x0.c().a("[MAIN]点击书城");
                break;
            case R.id.rb_bookshelf /* 2131298197 */:
                if (this.C0 == -1) {
                    while (true) {
                        if (i2 < this.f2582q0.size()) {
                            if (this.f2582q0.get(i2) instanceof BookAndComicFragment) {
                                this.C0 = i2;
                            } else {
                                i2++;
                            }
                        }
                    }
                }
                int currentItem2 = this.viewpager.getCurrentItem();
                int i4 = this.C0;
                if (currentItem2 != i4) {
                    this.viewpager.setCurrentItem(i4);
                    me.jessyan.art.f.h.a((Activity) this.f2277w);
                }
                x0.c().a("[MAIN]点击书架");
                break;
            case R.id.rb_fission6 /* 2131298199 */:
                shareWhenFission();
                break;
            case R.id.rb_mine /* 2131298200 */:
                if (this.A0 == -1) {
                    while (true) {
                        if (i2 < this.f2582q0.size()) {
                            if (this.f2582q0.get(i2) instanceof MkMineFragmentNew) {
                                this.A0 = i2;
                            } else {
                                i2++;
                            }
                        }
                    }
                }
                if (this.viewpager.getCurrentItem() != this.A0) {
                    me.jessyan.art.f.h.b((Activity) this.f2277w);
                    this.viewpager.setCurrentItem(this.A0);
                }
                BadgeView badgeView = this.f2586u0;
                if (badgeView != null && badgeView.isShown()) {
                    this.f2586u0.a();
                }
                x0.c().a("[MAIN]点击我的");
                break;
            case R.id.rb_qiushu /* 2131298201 */:
                if (this.B0 == -1) {
                    while (true) {
                        if (i2 < this.f2582q0.size()) {
                            if (this.f2582q0.get(i2) instanceof MkQiushuFragemnt) {
                                this.B0 = i2;
                            } else {
                                i2++;
                            }
                        }
                    }
                }
                int currentItem3 = this.viewpager.getCurrentItem();
                int i5 = this.B0;
                if (currentItem3 != i5) {
                    this.viewpager.setCurrentItem(i5);
                    me.jessyan.art.f.h.a((Activity) this.f2277w);
                }
                BadgeView badgeView2 = this.f2587v0;
                if (badgeView2 != null) {
                    badgeView2.a();
                }
                x0.c().a("[MAIN]点击求书");
                break;
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        x0.c().a();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (System.currentTimeMillis() - this.f2579n0 > com.anythink.expressad.exoplayer.i.a.f9492f) {
            showMessage("再按一次退出程序");
            this.f2579n0 = System.currentTimeMillis();
            return true;
        }
        MkApplication appContext = MkApplication.getAppContext();
        try {
            appContext.downloadArray.clear();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        zhugeIodEvent("[SPLASH]退出app");
        appContext.setFissionUrl("");
        appContext.setVersion(null);
        appContext.setVersion_data(null);
        com.amgcyo.cuttadon.sdk.utils.g.a();
        com.amgcyo.cuttadon.sdk.utils.d.a();
        boolean zA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("ylh_init_error", false);
        boolean zE = com.amgcyo.cuttadon.utils.otherutils.g.e();
        if (!zA && !zE) {
            finish();
            return true;
        }
        forceExit();
        System.out.println("app must force exit");
        return true;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (com.amgcyo.cuttadon.f.n.f3696j) {
            com.amgcyo.cuttadon.f.n.f3696j = false;
            try {
                this.rb_bookCity.setChecked(true);
                this.viewpager.setCurrentItem(1);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        a("other_page");
        if (com.amgcyo.cuttadon.utils.otherutils.g.a((Context) this)) {
            com.amgcyo.cuttadon.view.read.page.k kVarC = com.amgcyo.cuttadon.view.read.page.k.c(this);
            if (kVarC != null) {
                com.amgcyo.cuttadon.utils.otherutils.g.a(this, kVarC.q());
            } else {
                com.amgcyo.cuttadon.utils.otherutils.g.a(this, com.amgcyo.cuttadon.utils.otherutils.g.M());
            }
        }
    }

    @Override // com.amgcyo.cuttadon.h.f.c
    public void onRewardAdClose(String str) {
        if (this.F0) {
            q();
        } else {
            showMessage("获取数据失败，请稍后重试！错误码：c1129");
        }
        this.F0 = false;
    }

    @Override // com.amgcyo.cuttadon.h.f.c
    public void onRewardAdFail(int i2, String str, String str2, String str3) {
        if (com.amgcyo.cuttadon.utils.otherutils.h.a(i2, str2)) {
            q();
            return;
        }
        if (i2 == 0) {
            showMessage("请求数据超时，请检查网络或反馈给客服");
            return;
        }
        showMessage("数据加载失败!错误码：" + i2);
    }

    @Override // com.amgcyo.cuttadon.h.f.c
    public void onRewardAdSuccess(com.amgcyo.cuttadon.h.g.h hVar) {
        this.F0 = hVar != null;
    }

    @Override // com.amgcyo.cuttadon.h.f.c
    public void onRewardAdVideoCached(Object obj) {
    }

    public void selectedQiushuHistoryFragment() {
        MkQiushuFragemnt mkQiushuFragemnt = this.f2581p0;
        if (mkQiushuFragemnt != null) {
            mkQiushuFragemnt.m();
            String strB = com.amgcyo.cuttadon.utils.otherutils.g.B();
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b(strB + "technology", this.E0 + 1);
        }
    }

    public void setLoginText(final MkUser mkUser) {
        runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f2637s.a(mkUser);
            }
        });
    }

    public void shareWhenFission() {
        if (this.f2591z0 == -1) {
            for (int i2 = 0; i2 < this.f2582q0.size(); i2++) {
                Fragment fragment = this.f2582q0.get(i2);
                if ((fragment instanceof Fission5IndexFragment) || (fragment instanceof Fission6IndexFragment)) {
                    this.f2591z0 = i2;
                    break;
                }
            }
        }
        int currentItem = this.viewpager.getCurrentItem();
        int i3 = this.f2591z0;
        if (currentItem != i3) {
            this.viewpager.setCurrentItem(i3);
            me.jessyan.art.f.h.c((Activity) this.f2277w);
        }
        BadgeView badgeView = this.f2588w0;
        if (badgeView != null) {
            badgeView.a();
        }
        FixedAnimatedRadioButton fixedAnimatedRadioButton = this.rb_fission6;
        if (fixedAnimatedRadioButton != null) {
            fixedAnimatedRadioButton.setChecked(true);
        }
    }

    public void toBookBookshelf() {
        if (this.rb_bookshelf == null || this.viewpager == null || com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2582q0)) {
            return;
        }
        this.rb_bookshelf.setChecked(true);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= this.f2582q0.size()) {
                break;
            }
            if (this.f2582q0.get(i3) instanceof BookAndComicFragment) {
                i2 = i3;
                break;
            }
            i3++;
        }
        this.viewpager.setCurrentItem(i2);
        me.jessyan.art.f.h.a((Activity) this.f2277w);
    }

    public void toBookCity(int i2) {
        String str = "form:" + i2;
        if (this.rb_bookCity == null || this.viewpager == null || com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2582q0)) {
            return;
        }
        this.rb_bookCity.setChecked(true);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= this.f2582q0.size()) {
                break;
            }
            if (this.f2582q0.get(i4) instanceof MkBookStoreFragment) {
                i3 = i4;
                break;
            }
            i4++;
        }
        this.viewpager.setCurrentItem(i3);
        if (this.D0 == null) {
            this.D0 = new MkCommentEvent();
        }
        this.D0.b(i2);
        me.jessyan.art.d.f.a().a(this.D0, "goto_book_city_by_type");
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.base.f.h
    public boolean useFragment() {
        return true;
    }

    static /* synthetic */ void a(String str, boolean z2, ITagManager.Result result) {
        System.out.println("migration status：" + z2 + " msg: " + result);
        if (!z2) {
            com.amgcyo.cuttadon.utils.otherutils.g.a(true);
        }
        if (z2) {
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b(str, true);
        }
        result.toString();
    }

    public /* synthetic */ void b(int i2, UpdateResponse updateResponse) {
        BmobException exception = updateResponse.getException();
        hideLoading();
        if (exception == null) {
            String str = "检测更新返回：" + updateResponse.version + "-" + updateResponse.path;
        }
    }

    public /* synthetic */ void c(int i2) {
        if (i2 != 6) {
            showMessage("请尽快更新最新版本!");
        } else {
            showMessage("正在处理中，请稍后!");
        }
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public ConfigPresenter obtainPresenter() {
        return new ConfigPresenter(me.jessyan.art.f.e.a(this));
    }

    public /* synthetic */ void a(MkUser mkUser) {
        if (mkUser != null) {
            FixedAnimatedRadioButton fixedAnimatedRadioButton = this.rb_mine;
            if (fixedAnimatedRadioButton != null) {
                fixedAnimatedRadioButton.setText("我的");
            }
        } else {
            FixedAnimatedRadioButton fixedAnimatedRadioButton2 = this.rb_mine;
            if (fixedAnimatedRadioButton2 != null) {
                fixedAnimatedRadioButton2.setText("我的");
            }
            if (com.amgcyo.cuttadon.utils.otherutils.h.H0()) {
                runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.activity.main.d0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2641s.o();
                    }
                });
            }
        }
        FixedAnimatedRadioButton fixedAnimatedRadioButton3 = this.rb_mine;
        if (fixedAnimatedRadioButton3 != null) {
            fixedAnimatedRadioButton3.setTextSize(2, 12.0f);
        }
    }

    private void a(int i2, final int i3) {
        if (i2 > 0) {
            com.amgcyo.cuttadon.f.o.a(a(), "提示", "检测到书架存在书籍，若恢复成功将清空现有书籍，是否继续恢复?", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.main.g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2645s.a(i3, view);
                }
            }, (View.OnClickListener) null);
        } else if (i3 == 0) {
            s();
        } else {
            r();
        }
    }

    public /* synthetic */ void a(int i2, View view) {
        if (i2 == 0) {
            s();
        } else {
            r();
        }
    }
}
