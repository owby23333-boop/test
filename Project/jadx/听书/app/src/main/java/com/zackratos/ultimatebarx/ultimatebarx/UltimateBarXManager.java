package com.zackratos.ultimatebarx.ultimatebarx;

import android.content.Context;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.d;
import com.zackratos.ultimatebarx.ultimatebarx.bean.BarConfig;
import com.zackratos.ultimatebarx.ultimatebarx.extension.ActivityKt;
import com.zackratos.ultimatebarx.ultimatebarx.rom.Rom;
import java.lang.reflect.Field;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UltimateBarXManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 T2\u00020\u0001:\u0002TUB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010+\u001a\u00020\u00062\b\b\u0001\u0010,\u001a\u00020-H\u0002J\u0015\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0002\b1J\u0015\u00102\u001a\u00020\u00062\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0002\b3J\u0015\u00104\u001a\u00020\u001a2\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0002\b5J\u0015\u00106\u001a\u00020\u00062\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0002\b7J\u0015\u00108\u001a\u00020\u001a2\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0002\b9J\u0015\u0010:\u001a\u00020\u00062\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0002\b;J\u0015\u0010<\u001a\u00020=2\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0002\b>J\u0015\u0010?\u001a\u00020=2\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0002\b@J\u001d\u0010A\u001a\u00020=2\u0006\u0010/\u001a\u0002002\u0006\u0010B\u001a\u00020\u001aH\u0000¢\u0006\u0002\bCJ\u0015\u0010D\u001a\u00020=2\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0002\bEJ\u0015\u0010F\u001a\u00020=2\u0006\u0010G\u001a\u00020HH\u0001¢\u0006\u0002\bIJ\u0015\u0010J\u001a\u00020=2\u0006\u0010G\u001a\u00020HH\u0001¢\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020=2\u0006\u0010G\u001a\u00020HH\u0001¢\u0006\u0002\bMJ\u001d\u0010N\u001a\u00020=2\u0006\u0010/\u001a\u0002002\u0006\u0010B\u001a\u00020\u001aH\u0000¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020=2\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0002\bQJ\u0015\u0010R\u001a\u00020=2\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0002\bSR'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u0014R'\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0017\u0010\bR'\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001b\u0010\bR'\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001e\u0010\bR\u001b\u0010 \u001a\u00020!8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\n\u001a\u0004\b\"\u0010#R'\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\n\u001a\u0004\b&\u0010\bR'\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\n\u001a\u0004\b)\u0010\b¨\u0006V"}, d2 = {"Lcom/zackratos/ultimatebarx/ultimatebarx/UltimateBarXManager;", "", "()V", "addObsMap", "", "", "", "getAddObsMap", "()Ljava/util/Map;", "addObsMap$delegate", "Lkotlin/Lazy;", d.R, "Landroid/content/Context;", "getContext$ultimatebarx_release", "()Landroid/content/Context;", "setContext$ultimatebarx_release", "(Landroid/content/Context;)V", "fragmentViewFiled", "Ljava/lang/reflect/Field;", "getFragmentViewFiled$ultimatebarx_release", "()Ljava/lang/reflect/Field;", "fragmentViewFiled$delegate", "initializationMap", "getInitializationMap", "initializationMap$delegate", "navConfigMap", "Lcom/zackratos/ultimatebarx/ultimatebarx/bean/BarConfig;", "getNavConfigMap", "navConfigMap$delegate", "navDefMap", "getNavDefMap", "navDefMap$delegate", "rom", "Lcom/zackratos/ultimatebarx/ultimatebarx/rom/Rom;", "getRom$ultimatebarx_release", "()Lcom/zackratos/ultimatebarx/ultimatebarx/rom/Rom;", "rom$delegate", "staConfigMap", "getStaConfigMap", "staConfigMap$delegate", "staDefMap", "getStaDefMap", "staDefMap$delegate", "calculateLight", "color", "", "getAddObserver", "owner", "Landroidx/lifecycle/LifecycleOwner;", "getAddObserver$ultimatebarx_release", "getInitialization", "getInitialization$ultimatebarx_release", "getNavigationBarConfig", "getNavigationBarConfig$ultimatebarx_release", "getNavigationBarDefault", "getNavigationBarDefault$ultimatebarx_release", "getStatusBarConfig", "getStatusBarConfig$ultimatebarx_release", "getStatusBarDefault", "getStatusBarDefault$ultimatebarx_release", "putAddObserver", "", "putAddObserver$ultimatebarx_release", "putInitialization", "putInitialization$ultimatebarx_release", "putNavigationBarConfig", "config", "putNavigationBarConfig$ultimatebarx_release", "putNavigationBarDefault", "putNavigationBarDefault$ultimatebarx_release", "putOriginConfig", TTDownloadField.TT_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "putOriginConfig$ultimatebarx_release", "putOriginNavigationBarConfig", "putOriginNavigationBarConfig$ultimatebarx_release", "putOriginStatusBarConfig", "putOriginStatusBarConfig$ultimatebarx_release", "putStatusBarConfig", "putStatusBarConfig$ultimatebarx_release", "putStatusBarDefault", "putStatusBarDefault$ultimatebarx_release", "removeAllData", "removeAllData$ultimatebarx_release", "Companion", "Holder", "ultimatebarx_release"}, k = 1, mv = {1, 1, 16})
public final class UltimateBarXManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: addObsMap$delegate, reason: from kotlin metadata */
    private final Lazy addObsMap;
    public Context context;

    /* JADX INFO: renamed from: fragmentViewFiled$delegate, reason: from kotlin metadata */
    private final Lazy fragmentViewFiled;

    /* JADX INFO: renamed from: initializationMap$delegate, reason: from kotlin metadata */
    private final Lazy initializationMap;

    /* JADX INFO: renamed from: navConfigMap$delegate, reason: from kotlin metadata */
    private final Lazy navConfigMap;

    /* JADX INFO: renamed from: navDefMap$delegate, reason: from kotlin metadata */
    private final Lazy navDefMap;

    /* JADX INFO: renamed from: rom$delegate, reason: from kotlin metadata */
    private final Lazy rom;

    /* JADX INFO: renamed from: staConfigMap$delegate, reason: from kotlin metadata */
    private final Lazy staConfigMap;

    /* JADX INFO: renamed from: staDefMap$delegate, reason: from kotlin metadata */
    private final Lazy staDefMap;

    private final boolean calculateLight(int color) {
        return color > -16777216;
    }

    private final Map<String, Boolean> getAddObsMap() {
        return (Map) this.addObsMap.getValue();
    }

    private final Map<String, Boolean> getInitializationMap() {
        return (Map) this.initializationMap.getValue();
    }

    private final Map<String, BarConfig> getNavConfigMap() {
        return (Map) this.navConfigMap.getValue();
    }

    private final Map<String, Boolean> getNavDefMap() {
        return (Map) this.navDefMap.getValue();
    }

    private final Map<String, BarConfig> getStaConfigMap() {
        return (Map) this.staConfigMap.getValue();
    }

    private final Map<String, Boolean> getStaDefMap() {
        return (Map) this.staDefMap.getValue();
    }

    public final Field getFragmentViewFiled$ultimatebarx_release() {
        return (Field) this.fragmentViewFiled.getValue();
    }

    public final Rom getRom$ultimatebarx_release() {
        return (Rom) this.rom.getValue();
    }

    /* JADX INFO: compiled from: UltimateBarXManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/zackratos/ultimatebarx/ultimatebarx/UltimateBarXManager$Companion;", "", "()V", "instance", "Lcom/zackratos/ultimatebarx/ultimatebarx/UltimateBarXManager;", "getInstance", "()Lcom/zackratos/ultimatebarx/ultimatebarx/UltimateBarXManager;", "ultimatebarx_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UltimateBarXManager getInstance() {
            return Holder.INSTANCE.getINSTANCE();
        }
    }

    private UltimateBarXManager() {
        this.rom = LazyKt.lazy(new Function0<Rom>() { // from class: com.zackratos.ultimatebarx.ultimatebarx.UltimateBarXManager$rom$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Rom invoke() {
                return com.zackratos.ultimatebarx.ultimatebarx.extension.GlobalKt.getRom();
            }
        });
        this.fragmentViewFiled = LazyKt.lazy(new Function0<Field>() { // from class: com.zackratos.ultimatebarx.ultimatebarx.UltimateBarXManager$fragmentViewFiled$2
            @Override // kotlin.jvm.functions.Function0
            public final Field invoke() throws NoSuchFieldException {
                Field declaredField = Fragment.class.getDeclaredField("mView");
                declaredField.setAccessible(true);
                return declaredField;
            }
        });
        this.staDefMap = LazyKt.lazy(new Function0<ArrayMap<String, Boolean>>() { // from class: com.zackratos.ultimatebarx.ultimatebarx.UltimateBarXManager$staDefMap$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ArrayMap<String, Boolean> invoke() {
                return new ArrayMap<>();
            }
        });
        this.navDefMap = LazyKt.lazy(new Function0<ArrayMap<String, Boolean>>() { // from class: com.zackratos.ultimatebarx.ultimatebarx.UltimateBarXManager$navDefMap$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ArrayMap<String, Boolean> invoke() {
                return new ArrayMap<>();
            }
        });
        this.addObsMap = LazyKt.lazy(new Function0<ArrayMap<String, Boolean>>() { // from class: com.zackratos.ultimatebarx.ultimatebarx.UltimateBarXManager$addObsMap$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ArrayMap<String, Boolean> invoke() {
                return new ArrayMap<>();
            }
        });
        this.initializationMap = LazyKt.lazy(new Function0<ArrayMap<String, Boolean>>() { // from class: com.zackratos.ultimatebarx.ultimatebarx.UltimateBarXManager$initializationMap$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ArrayMap<String, Boolean> invoke() {
                return new ArrayMap<>();
            }
        });
        this.staConfigMap = LazyKt.lazy(new Function0<ArrayMap<String, BarConfig>>() { // from class: com.zackratos.ultimatebarx.ultimatebarx.UltimateBarXManager$staConfigMap$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ArrayMap<String, BarConfig> invoke() {
                return new ArrayMap<>();
            }
        });
        this.navConfigMap = LazyKt.lazy(new Function0<ArrayMap<String, BarConfig>>() { // from class: com.zackratos.ultimatebarx.ultimatebarx.UltimateBarXManager$navConfigMap$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ArrayMap<String, BarConfig> invoke() {
                return new ArrayMap<>();
            }
        });
    }

    public /* synthetic */ UltimateBarXManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: UltimateBarXManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/zackratos/ultimatebarx/ultimatebarx/UltimateBarXManager$Holder;", "", "()V", "INSTANCE", "Lcom/zackratos/ultimatebarx/ultimatebarx/UltimateBarXManager;", "getINSTANCE", "()Lcom/zackratos/ultimatebarx/ultimatebarx/UltimateBarXManager;", "ultimatebarx_release"}, k = 1, mv = {1, 1, 16})
    private static final class Holder {
        public static final Holder INSTANCE = new Holder();
        private static final UltimateBarXManager INSTANCE = new UltimateBarXManager(null);

        private Holder() {
        }

        public final UltimateBarXManager getINSTANCE() {
            return INSTANCE;
        }
    }

    public final Context getContext$ultimatebarx_release() {
        Context context = this.context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException(d.R);
        }
        return context;
    }

    public final void setContext$ultimatebarx_release(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "<set-?>");
        this.context = context;
    }

    public final void removeAllData$ultimatebarx_release(LifecycleOwner owner) {
        Intrinsics.checkParameterIsNotNull(owner, "owner");
        String strValueOf = String.valueOf(owner.hashCode());
        getStaDefMap().remove(strValueOf);
        getNavDefMap().remove(strValueOf);
        getAddObsMap().remove(strValueOf);
        getInitializationMap().remove(strValueOf);
        getStaConfigMap().remove(strValueOf);
        getNavConfigMap().remove(strValueOf);
    }

    public final void putAddObserver$ultimatebarx_release(LifecycleOwner owner) {
        Intrinsics.checkParameterIsNotNull(owner, "owner");
        getAddObsMap().put(String.valueOf(owner.hashCode()), true);
    }

    public final boolean getAddObserver$ultimatebarx_release(LifecycleOwner owner) {
        Intrinsics.checkParameterIsNotNull(owner, "owner");
        Boolean bool = getAddObsMap().get(String.valueOf(owner.hashCode()));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void putStatusBarDefault$ultimatebarx_release(LifecycleOwner owner) {
        Intrinsics.checkParameterIsNotNull(owner, "owner");
        getStaDefMap().put(String.valueOf(owner.hashCode()), true);
    }

    public final void putNavigationBarDefault$ultimatebarx_release(LifecycleOwner owner) {
        Intrinsics.checkParameterIsNotNull(owner, "owner");
        getNavDefMap().put(String.valueOf(owner.hashCode()), true);
    }

    public final boolean getStatusBarDefault$ultimatebarx_release(LifecycleOwner owner) {
        Intrinsics.checkParameterIsNotNull(owner, "owner");
        Boolean bool = getStaDefMap().get(String.valueOf(owner.hashCode()));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean getNavigationBarDefault$ultimatebarx_release(LifecycleOwner owner) {
        Intrinsics.checkParameterIsNotNull(owner, "owner");
        Boolean bool = getNavDefMap().get(String.valueOf(owner.hashCode()));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean getInitialization$ultimatebarx_release(LifecycleOwner owner) {
        Intrinsics.checkParameterIsNotNull(owner, "owner");
        Boolean bool = getInitializationMap().get(String.valueOf(owner.hashCode()));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void putInitialization$ultimatebarx_release(LifecycleOwner owner) {
        Intrinsics.checkParameterIsNotNull(owner, "owner");
        getInitializationMap().put(String.valueOf(owner.hashCode()), true);
    }

    public final void putOriginConfig$ultimatebarx_release(FragmentActivity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        putOriginStatusBarConfig$ultimatebarx_release(activity);
        putOriginNavigationBarConfig$ultimatebarx_release(activity);
    }

    public final void putOriginStatusBarConfig$ultimatebarx_release(FragmentActivity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        FragmentActivity fragmentActivity = activity;
        BarConfig statusBarConfig$ultimatebarx_release = getStatusBarConfig$ultimatebarx_release(fragmentActivity);
        statusBarConfig$ultimatebarx_release.getBackground().setColor(ActivityKt.getOriginStatusBarColor(activity));
        putStatusBarConfig$ultimatebarx_release(fragmentActivity, statusBarConfig$ultimatebarx_release);
    }

    public final void putOriginNavigationBarConfig$ultimatebarx_release(FragmentActivity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        FragmentActivity fragmentActivity = activity;
        BarConfig navigationBarConfig$ultimatebarx_release = getNavigationBarConfig$ultimatebarx_release(fragmentActivity);
        navigationBarConfig$ultimatebarx_release.getBackground().setColor(ActivityKt.getOriginNavigationBarColor(activity));
        navigationBarConfig$ultimatebarx_release.setLight(calculateLight(navigationBarConfig$ultimatebarx_release.getBackground().getColor()));
        putNavigationBarConfig$ultimatebarx_release(fragmentActivity, navigationBarConfig$ultimatebarx_release);
    }

    public final void putStatusBarConfig$ultimatebarx_release(LifecycleOwner owner, BarConfig config) {
        Intrinsics.checkParameterIsNotNull(owner, "owner");
        Intrinsics.checkParameterIsNotNull(config, "config");
        getStaConfigMap().put(String.valueOf(owner.hashCode()), config);
    }

    public final BarConfig getStatusBarConfig$ultimatebarx_release(LifecycleOwner owner) {
        Intrinsics.checkParameterIsNotNull(owner, "owner");
        BarConfig barConfig = getStaConfigMap().get(String.valueOf(owner.hashCode()));
        return barConfig != null ? barConfig : BarConfig.INSTANCE.newInstance();
    }

    public final void putNavigationBarConfig$ultimatebarx_release(LifecycleOwner owner, BarConfig config) {
        Intrinsics.checkParameterIsNotNull(owner, "owner");
        Intrinsics.checkParameterIsNotNull(config, "config");
        getNavConfigMap().put(String.valueOf(owner.hashCode()), config);
    }

    public final BarConfig getNavigationBarConfig$ultimatebarx_release(LifecycleOwner owner) {
        Intrinsics.checkParameterIsNotNull(owner, "owner");
        BarConfig barConfig = getNavConfigMap().get(String.valueOf(owner.hashCode()));
        return barConfig != null ? barConfig : BarConfig.INSTANCE.newInstance();
    }
}
