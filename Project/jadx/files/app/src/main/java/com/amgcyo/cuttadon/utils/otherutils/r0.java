package com.amgcyo.cuttadon.utils.otherutils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.amgcyo.cuttadon.activity.comic.MkComicSourceActivity;
import com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity;
import com.amgcyo.cuttadon.activity.comic.UnlockComicChapterActivity;
import com.amgcyo.cuttadon.activity.detail.MkBookDetailActivity;
import com.amgcyo.cuttadon.activity.detail.MkCommentListActivity;
import com.amgcyo.cuttadon.activity.fission5.Fission5IncomeActivity;
import com.amgcyo.cuttadon.activity.fission5.Fission5WithdrawActivity;
import com.amgcyo.cuttadon.activity.fission5.FissionBaseActivity;
import com.amgcyo.cuttadon.activity.read.MkReadModelHActivity;
import com.amgcyo.cuttadon.activity.read.MkReadModelVActivity;
import com.amgcyo.cuttadon.activity.read.UnlockNovelChapterActivity;
import com.amgcyo.cuttadon.activity.search.MkAuthorResultActivity;
import com.amgcyo.cuttadon.activity.search.MkSearchActivity;
import com.amgcyo.cuttadon.activity.setting.MkBrowserActivity;
import com.amgcyo.cuttadon.activity.setting.MkKeepAliveActivity;
import com.amgcyo.cuttadon.activity.shelf.BookShelfCleanaupActivity;
import com.amgcyo.cuttadon.activity.user.MkUserLoginActivity;
import com.amgcyo.cuttadon.activity.user.MkUserRegActivity;
import com.amgcyo.cuttadon.api.entity.comic.ComicChapter;
import com.amgcyo.cuttadon.api.entity.config.FissionData;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.Slippage;
import com.amgcyo.cuttadon.app.MkApplication;
import com.fatcatfat.io.R;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: compiled from: SwitchActivityManager.java */
/* JADX INFO: loaded from: classes.dex */
public class r0 {
    public static void a(Context context, Bundle bundle) {
        Intent intent = new Intent(context, (Class<?>) MkUserRegActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.from_bottom_to_top, R.anim.anim_silent);
    }

    public static void b(Context context, int i2) {
        Intent intent = new Intent(context, (Class<?>) BookShelfCleanaupActivity.class);
        intent.putExtra("form", i2);
        intent.putExtra("type_id", 20);
        context.startActivity(intent);
    }

    public static void c(Context context, int i2) {
        Intent intent = new Intent(context, (Class<?>) MkSearchActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("form", i2);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void d(Context context, MkBook mkBook) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("book", mkBook);
        bundle.putBoolean("from_unlock_activity", true);
        if (com.amgcyo.cuttadon.view.read.page.m.a(context)) {
            startActivity(context, bundle, MkReadModelHActivity.class);
        } else {
            startActivity(context, bundle, MkReadModelVActivity.class);
        }
    }

    public static void startActivity(Context context, Class<?> cls) {
        context.startActivity(new Intent(context, cls));
        ((Activity) context).overridePendingTransition(R.anim.left_out, R.anim.left_in);
    }

    public static void startActivity(Context context, Bundle bundle, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        intent.putExtras(bundle);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(0, 0);
    }

    public static void a(Context context, MkBook mkBook, ComicChapter comicChapter) {
        Intent intent = new Intent(context, (Class<?>) UnlockComicChapterActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("book", mkBook);
        bundle.putSerializable("comicChapterTag", comicChapter);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void b(Context context, MkBook mkBook) {
        Intent intent = new Intent(context, (Class<?>) MkComicSourceActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("book", mkBook);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void c(Context context, MkBook mkBook) {
        Intent intent = new Intent(context, (Class<?>) MkCommentListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("book", mkBook);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void b(Context context, int i2, int i3) {
        Intent intent = new Intent(context, (Class<?>) MkBookDetailActivity.class);
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        Bundle bundle = new Bundle();
        bundle.putInt("book_id", i2);
        bundle.putInt("form", i3);
        intent.putExtras(bundle);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.from_bottom_to_top, R.anim.anim_silent);
    }

    public static void a(Context context, MkBook mkBook, Slippage slippage) {
        Intent intent = new Intent(context, (Class<?>) UnlockNovelChapterActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("book", mkBook);
        bundle.putSerializable("Slippage", slippage);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void c(Context context) {
        Intent intent = new Intent(context, (Class<?>) Fission5WithdrawActivity.class);
        intent.putExtras(new Bundle());
        context.startActivity(intent);
    }

    public static void a(Context context, int i2, int i3) {
        Intent intent = new Intent(context, (Class<?>) MkBookDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("book_id", i2);
        bundle.putInt("form", i3);
        intent.putExtras(bundle);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.from_bottom_to_top, R.anim.anim_silent);
    }

    public static void b(Context context) {
        context.startActivity(new Intent(context, (Class<?>) MkUserLoginActivity.class));
        ((Activity) context).overridePendingTransition(R.anim.from_bottom_to_top, R.anim.anim_silent);
    }

    public static void a(Context context, String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) MkAuthorResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("book_author", str);
        bundle.putInt("form", i2);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void a(Context context, MkBook mkBook) {
        if (!g.j0()) {
            com.amgcyo.cuttadon.utils.comic.a aVar = MkApplication.getAppContext().mPreferenceManager;
            int iB = aVar.b("pref_reader_mode", 1);
            int iB2 = aVar.b(iB == 0 ? "pref_reader_page_orientation" : "pref_reader_stream_orientation", 1);
            MkApplication.getAppContext().setOrientation(iB2);
            context.startActivity(MkComicsBaseReaderActivity.createIntent(context, mkBook, iB, iB2));
            x0.c().a(3, mkBook.getBook_id(), mkBook.getRead_begin(), iB == 0 ? "水平" : "上下", mkBook.getUpdated());
            return;
        }
        com.amgcyo.cuttadon.f.o.b("渠道参数异常，请反馈给客服！");
    }

    public static void a(Context context, boolean z2) {
        Intent intent = new Intent(context, (Class<?>) MkUserLoginActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean(DownloadSettingKeys.AhPlans.KEY_SHOW_TIPS, z2);
        intent.putExtras(bundle);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.from_bottom_to_top, R.anim.anim_silent);
    }

    public static void a(Context context, boolean z2, int i2) {
        Intent intent = new Intent(context, (Class<?>) MkUserLoginActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean(DownloadSettingKeys.AhPlans.KEY_SHOW_TIPS, z2);
        bundle.putInt("fission_index_page", i2);
        intent.putExtras(bundle);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.from_bottom_to_top, R.anim.anim_silent);
    }

    public static void a(Context context, int i2) {
        Intent intent = new Intent(context, (Class<?>) Fission5IncomeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("type_id", i2);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void a(Activity activity) {
        activity.finish();
    }

    public static void a(Context context, Class<?> cls, String str, int i2) {
        Intent intent = new Intent(context, cls);
        intent.putExtra("key_desc", str);
        intent.putExtra("errorCode", i2);
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        context.startActivity(intent);
    }

    public static void a(Context context, Class<?> cls) {
        context.startActivity(new Intent(context, cls));
        ((Activity) context).overridePendingTransition(0, 0);
    }

    public static void a(Context context, Class<?> cls, boolean z2) {
        context.startActivity(new Intent(context, cls));
        if (z2) {
            ((Activity) context).finish();
        }
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) MkBrowserActivity.class);
        intent.putExtra("param_url", str);
        context.startActivity(intent);
        String str2 = "loadUrl: " + str;
        ((Activity) context).overridePendingTransition(R.anim.from_bottom_to_top, R.anim.anim_silent);
    }

    public static void a(Context context, String str, FissionData fissionData) {
        Intent intent = new Intent(context, (Class<?>) FissionBaseActivity.class);
        intent.putExtra("param_url", str);
        intent.putExtra("fission_data", fissionData);
        context.startActivity(intent);
        String str2 = "loadUrl: " + str;
        ((Activity) context).overridePendingTransition(R.anim.from_bottom_to_top, R.anim.anim_silent);
    }

    public static void a(Context context) {
        String strC0 = h.C0();
        if (TextUtils.isEmpty(strC0)) {
            return;
        }
        String str = strC0 + "/set_background_run.html";
        Intent intent = new Intent(context, (Class<?>) MkKeepAliveActivity.class);
        intent.putExtra("param_url", str);
        context.startActivity(intent);
        String str2 = "loadUrl: " + str;
        ((Activity) context).overridePendingTransition(R.anim.from_bottom_to_top, R.anim.anim_silent);
    }
}
