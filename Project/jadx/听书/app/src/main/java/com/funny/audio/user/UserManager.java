package com.funny.audio.user;

import android.app.Application;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.funny.audio.core.utils.Md5Utils;
import com.funny.audio.core.utils.MiscUtils;
import com.funny.audio.core.utils.TextUtils;
import com.funny.audio.models.UserInfo;
import com.funny.audio.settings.AppSettingEntityKt;
import com.umeng.analytics.pro.d;
import com.umeng.analytics.pro.z;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: UserManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0002J\u000e\u0010+\u001a\u00020,2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010-\u001a\u00020,J\u000e\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020 J\b\u00100\u001a\u00020,H\u0002J\b\u00101\u001a\u00020,H\u0002J\u0011\u00102\u001a\u00020,H\u0082@ø\u0001\u0000¢\u0006\u0002\u00103J\u0011\u00104\u001a\u00020,H\u0082@ø\u0001\u0000¢\u0006\u0002\u00103R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lcom/funny/audio/user/UserManager;", "", "()V", "appKey", "", "getAppKey", "()Ljava/lang/String;", "setAppKey", "(Ljava/lang/String;)V", d.R, "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "setContext", "(Landroid/app/Application;)V", "isLogin", "", "()Z", "setLogin", "(Z)V", "setting", "Lcom/funny/audio/user/UserSettings;", "getSetting", "()Lcom/funny/audio/user/UserSettings;", "setSetting", "(Lcom/funny/audio/user/UserSettings;)V", "syncBookshelfJobRef", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/Job;", "syncHistoryDataJobRef", "tagName", z.m, "Lcom/funny/audio/models/UserInfo;", "getUser", "()Lcom/funny/audio/models/UserInfo;", "setUser", "(Lcom/funny/audio/models/UserInfo;)V", "userId", "getUserId", "setUserId", "getDataId", "type", "id", "init", "", "logout", "save", "info", "startSyncBookshelfData", "startSyncHistoryData", "syncBookshelfData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncPlayHistoryData", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UserManager {
    private static Application context;
    private static boolean isLogin;
    private static UserSettings setting;
    private static UserInfo user;
    public static final UserManager INSTANCE = new UserManager();
    private static String userId = "";
    private static String appKey = "";
    private static final String tagName = "USER";
    private static final AtomicReference<Job> syncBookshelfJobRef = new AtomicReference<>(null);
    private static final AtomicReference<Job> syncHistoryDataJobRef = new AtomicReference<>(null);

    /* JADX INFO: renamed from: com.funny.audio.user.UserManager$syncBookshelfData$1, reason: invalid class name */
    /* JADX INFO: compiled from: UserManager.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.user.UserManager", f = "UserManager.kt", i = {0, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH, 158}, m = "syncBookshelfData", n = {"this", "this"}, s = {"L$0", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UserManager.this.syncBookshelfData(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.user.UserManager$syncPlayHistoryData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UserManager.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.user.UserManager", f = "UserManager.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO}, m = "syncPlayHistoryData", n = {"this"}, s = {"L$0"})
    static final class C05651 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C05651(Continuation<? super C05651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UserManager.this.syncPlayHistoryData(this);
        }
    }

    private UserManager() {
    }

    public final Application getContext() {
        return context;
    }

    public final void setContext(Application application) {
        context = application;
    }

    public final UserSettings getSetting() {
        return setting;
    }

    public final void setSetting(UserSettings userSettings) {
        setting = userSettings;
    }

    public final String getUserId() {
        return userId;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        userId = str;
    }

    public final UserInfo getUser() {
        return user;
    }

    public final void setUser(UserInfo userInfo) {
        user = userInfo;
    }

    public final boolean isLogin() {
        return isLogin;
    }

    public final void setLogin(boolean z) {
        isLogin = z;
    }

    public final String getAppKey() {
        return appKey;
    }

    public final void setAppKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        appKey = str;
    }

    public final void save(UserInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        isLogin = true;
        userId = info.getId();
        UserSettings userSettings = setting;
        Intrinsics.checkNotNull(userSettings);
        AppSettingEntityKt.save(userSettings.getUserIdSetting(), info.getId());
        user = info;
        String strSerializeJson = TextUtils.INSTANCE.serializeJson(info);
        UserSettings userSettings2 = setting;
        Intrinsics.checkNotNull(userSettings2);
        AppSettingEntityKt.save(userSettings2.getUserInfoSetting(), strSerializeJson);
    }

    public final void logout() {
        userId = "";
        user = null;
        isLogin = false;
        UserSettings userSettings = setting;
        Intrinsics.checkNotNull(userSettings);
        AppSettingEntityKt.save(userSettings.getUserIdSetting(), "");
        UserSettings userSettings2 = setting;
        Intrinsics.checkNotNull(userSettings2);
        AppSettingEntityKt.save(userSettings2.getUserInfoSetting(), "");
    }

    public final void init(Application context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        context = context2;
        Application application = context2;
        String packageName = MiscUtils.getPackageName(application);
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(context)");
        appKey = packageName;
        UserSettings userSettingsLoad = UserSettings.INSTANCE.load(application);
        setting = userSettingsLoad;
        Intrinsics.checkNotNull(userSettingsLoad);
        userId = userSettingsLoad.getUserId();
        try {
            TextUtils textUtils = TextUtils.INSTANCE;
            UserSettings userSettings = setting;
            Intrinsics.checkNotNull(userSettings);
            user = (UserInfo) textUtils.getGson().fromJson(userSettings.getUserInfo(), UserInfo.class);
        } catch (Exception unused) {
        }
        if (userId.length() > 0) {
            isLogin = true;
        }
        startSyncBookshelfData();
        startSyncHistoryData();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c A[Catch: all -> 0x003e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0009, B:7:0x0012, B:12:0x003a, B:11:0x001c), top: B:18:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void startSyncBookshelfData() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.concurrent.atomic.AtomicReference<kotlinx.coroutines.Job> r0 = com.funny.audio.user.UserManager.syncBookshelfJobRef     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r1 = r0.get()     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L1c
            java.lang.Object r1 = r0.get()     // Catch: java.lang.Throwable -> L3e
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1     // Catch: java.lang.Throwable -> L3e
            r2 = 0
            if (r1 == 0) goto L1a
            boolean r1 = r1.isCompleted()     // Catch: java.lang.Throwable -> L3e
            r3 = 1
            if (r1 != r3) goto L1a
            r2 = r3
        L1a:
            if (r2 == 0) goto L3a
        L1c:
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Throwable -> L3e
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1     // Catch: java.lang.Throwable -> L3e
            kotlinx.coroutines.CoroutineScope r2 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r1)     // Catch: java.lang.Throwable -> L3e
            r3 = 0
            r4 = 0
            com.funny.audio.user.UserManager$startSyncBookshelfData$1$newJob$1 r1 = new com.funny.audio.user.UserManager$startSyncBookshelfData$1$newJob$1     // Catch: java.lang.Throwable -> L3e
            r5 = 0
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L3e
            r5 = r1
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch: java.lang.Throwable -> L3e
            r6 = 3
            r7 = 0
            kotlinx.coroutines.Job r1 = kotlinx.coroutines.BuildersKt.launch$default(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L3e
            r0.set(r1)     // Catch: java.lang.Throwable -> L3e
        L3a:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L3e
            monitor-exit(r8)
            return
        L3e:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.user.UserManager.startSyncBookshelfData():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c A[Catch: all -> 0x003e, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0009, B:7:0x0012, B:12:0x003a, B:11:0x001c), top: B:18:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void startSyncHistoryData() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.concurrent.atomic.AtomicReference<kotlinx.coroutines.Job> r0 = com.funny.audio.user.UserManager.syncHistoryDataJobRef     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r1 = r0.get()     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L1c
            java.lang.Object r1 = r0.get()     // Catch: java.lang.Throwable -> L3e
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1     // Catch: java.lang.Throwable -> L3e
            r2 = 0
            if (r1 == 0) goto L1a
            boolean r1 = r1.isCompleted()     // Catch: java.lang.Throwable -> L3e
            r3 = 1
            if (r1 != r3) goto L1a
            r2 = r3
        L1a:
            if (r2 == 0) goto L3a
        L1c:
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Throwable -> L3e
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1     // Catch: java.lang.Throwable -> L3e
            kotlinx.coroutines.CoroutineScope r2 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r1)     // Catch: java.lang.Throwable -> L3e
            r3 = 0
            r4 = 0
            com.funny.audio.user.UserManager$startSyncHistoryData$1$newJob$1 r1 = new com.funny.audio.user.UserManager$startSyncHistoryData$1$newJob$1     // Catch: java.lang.Throwable -> L3e
            r5 = 0
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L3e
            r5 = r1
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch: java.lang.Throwable -> L3e
            r6 = 3
            r7 = 0
            kotlinx.coroutines.Job r1 = kotlinx.coroutines.BuildersKt.launch$default(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L3e
            r0.set(r1)     // Catch: java.lang.Throwable -> L3e
        L3a:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L3e
            monitor-exit(r8)
            return
        L3e:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.user.UserManager.startSyncHistoryData():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010f A[Catch: Exception -> 0x0038, TryCatch #2 {Exception -> 0x0038, blocks: (B:13:0x0033, B:44:0x0115, B:46:0x011b, B:48:0x0163, B:49:0x0170, B:41:0x00f7, B:43:0x010f), top: B:59:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011b A[Catch: Exception -> 0x0038, TryCatch #2 {Exception -> 0x0038, blocks: (B:13:0x0033, B:44:0x0115, B:46:0x011b, B:48:0x0163, B:49:0x0170, B:41:0x00f7, B:43:0x010f), top: B:59:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncBookshelfData(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.user.UserManager.syncBookshelfData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncPlayHistoryData(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.user.UserManager.syncPlayHistoryData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getDataId(String type, String id) {
        return Md5Utils.INSTANCE.md5encode(appKey + userId + type + id);
    }
}
