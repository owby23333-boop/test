package p000;

import android.app.Activity;
import android.os.Handler;
import bhjuguyt.Loader;
import bhjuguyt.hidden.Hidden0;
import de.robv.android.xposed.XC_MethodHook;

/* JADX INFO: loaded from: classes5.dex */
public final class hook {
    private static final long CHECK_INTERVAL = 5000;
    private static final long MEDIA_PLAYER_INTERVAL = 25200000;
    private static final long PURE_INTERVAL = 10800000;
    private static Handler checkHandler;
    private static Runnable checkRunnable;
    private static boolean hasTriggeredOnStart;
    private static boolean isChecking;
    private static Activity lastActivity;
    private static long lastMediaPlayerTriggerTime;
    private static long lastPureTriggerTime;

    /* JADX INFO: renamed from: 小梨听书.hook$1, reason: invalid class name */
    class AnonymousClass1 extends XC_MethodHook {
        static {
            Loader.registerNativesForClass(2, AnonymousClass1.class);
            Hidden0.special_clinit_2_30(AnonymousClass1.class);
        }

        AnonymousClass1() {
        }

        static native /* synthetic */ boolean lambda$afterHookedMethod$0(Activity activity, String str);

        @Override // de.robv.android.xposed.XC_MethodHook
        public native void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam);
    }

    /* JADX INFO: renamed from: 小梨听书.hook$2, reason: invalid class name */
    class AnonymousClass2 extends XC_MethodHook {
        static {
            Loader.registerNativesForClass(3, AnonymousClass2.class);
            Hidden0.special_clinit_3_20(AnonymousClass2.class);
        }

        AnonymousClass2() {
        }

        @Override // de.robv.android.xposed.XC_MethodHook
        public native void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam);
    }

    /* JADX INFO: renamed from: 小梨听书.hook$3, reason: invalid class name */
    class AnonymousClass3 extends XC_MethodHook {
        static {
            Loader.registerNativesForClass(4, AnonymousClass3.class);
            Hidden0.special_clinit_4_20(AnonymousClass3.class);
        }

        AnonymousClass3() {
        }

        @Override // de.robv.android.xposed.XC_MethodHook
        public native void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam);
    }

    /* JADX INFO: renamed from: 小梨听书.hook$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        final Activity val$activity;

        static {
            Loader.registerNativesForClass(5, AnonymousClass4.class);
            Hidden0.special_clinit_5_20(AnonymousClass4.class);
        }

        AnonymousClass4(Activity activity) {
            this.val$activity = activity;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetcheckHandler, reason: not valid java name */
    static native /* bridge */ /* synthetic */ Handler m2371$$Nest$sfgetcheckHandler();

    /* JADX INFO: renamed from: -$$Nest$sfgethasTriggeredOnStart, reason: not valid java name */
    static native /* bridge */ /* synthetic */ boolean m2372$$Nest$sfgethasTriggeredOnStart();

    /* JADX INFO: renamed from: -$$Nest$sfputhasTriggeredOnStart, reason: not valid java name */
    static native /* bridge */ /* synthetic */ void m2373$$Nest$sfputhasTriggeredOnStart(boolean z);

    /* JADX INFO: renamed from: -$$Nest$sfputlastActivity, reason: not valid java name */
    static native /* bridge */ /* synthetic */ void m2374$$Nest$sfputlastActivity(Activity activity);

    /* JADX INFO: renamed from: -$$Nest$sfputlastMediaPlayerTriggerTime, reason: not valid java name */
    static native /* bridge */ /* synthetic */ void m2375$$Nest$sfputlastMediaPlayerTriggerTime(long j);

    /* JADX INFO: renamed from: -$$Nest$sfputlastPureTriggerTime, reason: not valid java name */
    static native /* bridge */ /* synthetic */ void m2376$$Nest$sfputlastPureTriggerTime(long j);

    /* JADX INFO: renamed from: -$$Nest$smcheckAndTriggerRewards, reason: not valid java name */
    static native /* bridge */ /* synthetic */ void m2377$$Nest$smcheckAndTriggerRewards(Activity activity);

    /* JADX INFO: renamed from: -$$Nest$smstartChecking, reason: not valid java name */
    static native /* bridge */ /* synthetic */ void m2378$$Nest$smstartChecking(Activity activity);

    /* JADX INFO: renamed from: -$$Nest$smtriggerMediaPlayerReward, reason: not valid java name */
    static native /* bridge */ /* synthetic */ void m2379$$Nest$smtriggerMediaPlayerReward(Activity activity);

    /* JADX INFO: renamed from: -$$Nest$smtriggerPureModeReward, reason: not valid java name */
    static native /* bridge */ /* synthetic */ void m2380$$Nest$smtriggerPureModeReward(Activity activity);

    static {
        Loader.registerNativesForClass(6, hook.class);
        Hidden0.special_clinit_6_100(hook.class);
    }

    private static native void checkAndTriggerRewards(Activity activity);

    public static native void init();

    private static native boolean isMidnight();

    public static native void show(Activity activity);

    private static native void startChecking(Activity activity);

    private static native void triggerMediaPlayerReward(Activity activity);

    private static native void triggerPureModeReward(Activity activity);
}
