package com.funny.audio.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.funny.audio.AppManager;
import com.funny.audio.ad.view.ResumeSplashActivity;
import com.funny.audio.ad.view.SplashActivity;
import com.funny.audio.models.GroupInfo;
import com.funny.audio.view.album.AlbumDetailActivity;
import com.funny.audio.view.announcer.AnnouncerAlbumActivity;
import com.funny.audio.view.homepage.HomepageGroupMoreActivity;
import com.funny.audio.view.mine.FeedbackActivity;
import com.funny.audio.view.mine.LoginActivity;
import com.funny.audio.view.mine.NoticeActivity;
import com.funny.audio.view.mine.PleaseAlbumActivity;
import com.funny.audio.view.mine.RegisterActivity;
import com.funny.audio.view.mine.SystemSettingActivity;
import com.funny.audio.view.mine.UserEditActivity;
import com.funny.audio.view.player.TrackPlayerActivity;
import com.funny.audio.view.search.SearchActivity;
import com.funny.audio.view.tag.TagAlbumActivity;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavigationUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u0004J\u0018\u0010 \u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020\u0004J\u0010\u0010\"\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ$\u0010#\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010$\u001a\u00020\u00042\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0004J\u0018\u0010&\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010$\u001a\u00020\u0004J\u0018\u0010'\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010(\u001a\u00020)J(\u0010*\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0004J\u0010\u0010-\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010.\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010/\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u00100\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u00101\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u00102\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u00103\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u00104\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0018\u00105\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u00106\u001a\u00020\u0004J\u0010\u00107\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u00108\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006¨\u00069"}, d2 = {"Lcom/funny/audio/view/NavigationUtils;", "", "()V", "ACCOUNT", "", "getACCOUNT", "()Ljava/lang/String;", "ALBUM_ID", "getALBUM_ID", "ANNOUNCER_ID", "getANNOUNCER_ID", "PASSWORD", "getPASSWORD", "TAG_ID", "getTAG_ID", "TITLE", "getTITLE", "URL", "getURL", "getAccount", "intent", "Landroid/content/Intent;", "getAlbumId", "getAnnouncerId", "getPassword", "getTagId", "getTitle", "toAlbumDetail", "", d.R, "Landroid/content/Context;", "albumId", "toAnnouncerAlbum", "announcerId", "toFeedback", "toH5In", "url", "title", "toH5Out", "toHomepageGroupMore", "groupInfo", "Lcom/funny/audio/models/GroupInfo;", "toLogin", "account", "password", "toMain", "toNotice", "toPleaseAlbum", "toRegister", "toResumeSplashAd", "toSearch", "toSplashAd", "toSystemSetting", "toTagAlbum", "tagId", "toTrackPlayer", "toUserEdit", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NavigationUtils {
    public static final NavigationUtils INSTANCE = new NavigationUtils();
    private static final String ALBUM_ID = "ALBUM_ID";
    private static final String ANNOUNCER_ID = "ANNOUNCER_ID";
    private static final String TAG_ID = "TAG_ID";
    private static final String ACCOUNT = "ACCOUNT";
    private static final String PASSWORD = "PASSWORD";
    private static final String TITLE = "TITLE";
    private static final String URL = "URL";

    private NavigationUtils() {
    }

    public final String getALBUM_ID() {
        return ALBUM_ID;
    }

    public final String getANNOUNCER_ID() {
        return ANNOUNCER_ID;
    }

    public final String getTAG_ID() {
        return TAG_ID;
    }

    public final String getACCOUNT() {
        return ACCOUNT;
    }

    public final String getPASSWORD() {
        return PASSWORD;
    }

    public final String getTITLE() {
        return TITLE;
    }

    public final String getURL() {
        return URL;
    }

    public final void toMain(Context context) {
        Intent intent = new Intent(context, (Class<?>) MainActivity.class);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public final void toSplashAd(Context context) {
        Intent intent = new Intent(context, (Class<?>) SplashActivity.class);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public final void toResumeSplashAd(Context context) {
        Intent intent = new Intent(context, (Class<?>) ResumeSplashActivity.class);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public final void toAlbumDetail(Context context, String albumId) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intent intent = new Intent(context, (Class<?>) AlbumDetailActivity.class);
        intent.putExtra(ALBUM_ID, albumId);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public final void toAnnouncerAlbum(Context context, String announcerId) {
        Intrinsics.checkNotNullParameter(announcerId, "announcerId");
        Intent intent = new Intent(context, (Class<?>) AnnouncerAlbumActivity.class);
        intent.putExtra(ANNOUNCER_ID, announcerId);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public final String getAnnouncerId(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra(ANNOUNCER_ID);
        Intrinsics.checkNotNull(stringExtra);
        return stringExtra;
    }

    public final void toTagAlbum(Context context, String tagId) {
        Intrinsics.checkNotNullParameter(tagId, "tagId");
        Intent intent = new Intent(context, (Class<?>) TagAlbumActivity.class);
        intent.putExtra(TAG_ID, tagId);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public final String getTagId(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra(TAG_ID);
        Intrinsics.checkNotNull(stringExtra);
        return stringExtra;
    }

    public static /* synthetic */ void toLogin$default(NavigationUtils navigationUtils, Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        navigationUtils.toLogin(context, str, str2);
    }

    public final void toLogin(Context context, String account, String password) {
        Intent intent = new Intent(context, (Class<?>) LoginActivity.class);
        if (account != null) {
            intent.putExtra(ACCOUNT, account);
        }
        if (password != null) {
            intent.putExtra(PASSWORD, password);
        }
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public final String getAccount(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return intent.getStringExtra(ACCOUNT);
    }

    public final String getPassword(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return intent.getStringExtra(PASSWORD);
    }

    public final void toRegister(Context context) {
        Intent intent = new Intent(context, (Class<?>) RegisterActivity.class);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public final void toNotice(Context context) {
        Intent intent = new Intent(context, (Class<?>) NoticeActivity.class);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public final void toFeedback(Context context) {
        Intent intent = new Intent(context, (Class<?>) FeedbackActivity.class);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public final void toPleaseAlbum(Context context) {
        Intent intent = new Intent(context, (Class<?>) PleaseAlbumActivity.class);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public final void toUserEdit(Context context) {
        Intent intent = new Intent(context, (Class<?>) UserEditActivity.class);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public final void toSystemSetting(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemSettingActivity.class);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public final String getAlbumId(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra(ALBUM_ID);
        Intrinsics.checkNotNull(stringExtra);
        return stringExtra;
    }

    public final void toTrackPlayer(Context context) {
        Intent intent = new Intent(context, (Class<?>) TrackPlayerActivity.class);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public final void toSearch(Context context) {
        Intent intent = new Intent(context, (Class<?>) SearchActivity.class);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public static /* synthetic */ void toH5In$default(NavigationUtils navigationUtils, Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        navigationUtils.toH5In(context, str, str2);
    }

    public final void toH5In(Context context, String url, String title) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intent intent = new Intent(context, (Class<?>) H5InActivity.class);
        if (title != null) {
            intent.putExtra(TITLE, title);
        }
        intent.putExtra(URL, url);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public final void toH5Out(Context context, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public final String getTitle(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return intent.getStringExtra(TITLE);
    }

    public final String getURL(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra(URL);
        Intrinsics.checkNotNull(stringExtra);
        return stringExtra;
    }

    public final void toHomepageGroupMore(Context context, GroupInfo groupInfo) {
        Intrinsics.checkNotNullParameter(groupInfo, "groupInfo");
        AppManager.INSTANCE.setGroupInfo(groupInfo);
        Intent intent = new Intent(context, (Class<?>) HomepageGroupMoreActivity.class);
        if (context != null) {
            context.startActivity(intent);
        }
    }
}
