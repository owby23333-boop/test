package androidx.window.embedding;

import android.app.Activity;
import android.content.Intent;
import androidx.window.SafeWindowExtensionsProvider;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.ExtensionsUtil;
import androidx.window.extensions.WindowExtensions;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import androidx.window.extensions.embedding.ActivityRule;
import androidx.window.extensions.embedding.SplitAttributes;
import androidx.window.reflection.ReflectionUtils;
import androidx.window.reflection.WindowExtensionsConstants;
import java.lang.reflect.Method;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SafeActivityEmbeddingComponentProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\r\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0002\b\u0016J\r\u0010\u0017\u001a\u00020\u0014H\u0001¢\u0006\u0002\b\u0018J\r\u0010\u0019\u001a\u00020\u0014H\u0001¢\u0006\u0002\b\u001aJ\b\u0010\u001b\u001a\u00020\u0014H\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\b\u0010 \u001a\u00020\u0014H\u0002J\b\u0010!\u001a\u00020\u0014H\u0002J\b\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u0014H\u0002J\b\u0010$\u001a\u00020\u0014H\u0002J\b\u0010%\u001a\u00020\u0014H\u0002J\b\u0010&\u001a\u00020\u0014H\u0002J\b\u0010'\u001a\u00020\u0014H\u0002J\b\u0010(\u001a\u00020\u0014H\u0002R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Landroidx/window/embedding/SafeActivityEmbeddingComponentProvider;", "", "loader", "Ljava/lang/ClassLoader;", "consumerAdapter", "Landroidx/window/core/ConsumerAdapter;", "windowExtensions", "Landroidx/window/extensions/WindowExtensions;", "(Ljava/lang/ClassLoader;Landroidx/window/core/ConsumerAdapter;Landroidx/window/extensions/WindowExtensions;)V", "activityEmbeddingComponent", "Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "getActivityEmbeddingComponent", "()Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "activityEmbeddingComponentClass", "Ljava/lang/Class;", "getActivityEmbeddingComponentClass", "()Ljava/lang/Class;", "safeWindowExtensionsProvider", "Landroidx/window/SafeWindowExtensionsProvider;", "canUseActivityEmbeddingComponent", "", "hasValidVendorApiLevel1", "hasValidVendorApiLevel1$window_release", "hasValidVendorApiLevel2", "hasValidVendorApiLevel2$window_release", "isActivityEmbeddingComponentAccessible", "isActivityEmbeddingComponentAccessible$window_release", "isActivityEmbeddingComponentValid", "isClassActivityRuleValid", "isClassSplitAttributesValid", "isClassSplitInfoValid", "isClassSplitPairRuleValid", "isClassSplitPlaceholderRuleValid", "isClassSplitTypeValid", "isMethodClearSplitInfoCallbackValid", "isMethodGetSplitAttributesValid", "isMethodIsActivityEmbeddedValid", "isMethodSetEmbeddingRulesValid", "isMethodSetSplitInfoCallbackJavaConsumerValid", "isMethodSetSplitInfoCallbackWindowConsumerValid", "isMethodSplitAttributesCalculatorValid", "window_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SafeActivityEmbeddingComponentProvider {
    private final ConsumerAdapter consumerAdapter;
    private final ClassLoader loader;
    private final SafeWindowExtensionsProvider safeWindowExtensionsProvider;
    private final WindowExtensions windowExtensions;

    public SafeActivityEmbeddingComponentProvider(ClassLoader loader, ConsumerAdapter consumerAdapter, WindowExtensions windowExtensions) {
        Intrinsics.checkNotNullParameter(loader, "loader");
        Intrinsics.checkNotNullParameter(consumerAdapter, "consumerAdapter");
        Intrinsics.checkNotNullParameter(windowExtensions, "windowExtensions");
        this.loader = loader;
        this.consumerAdapter = consumerAdapter;
        this.windowExtensions = windowExtensions;
        this.safeWindowExtensionsProvider = new SafeWindowExtensionsProvider(loader);
    }

    public final ActivityEmbeddingComponent getActivityEmbeddingComponent() {
        if (!canUseActivityEmbeddingComponent()) {
            return null;
        }
        try {
            return this.windowExtensions.getActivityEmbeddingComponent();
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    private final boolean canUseActivityEmbeddingComponent() {
        if (!isActivityEmbeddingComponentAccessible$window_release()) {
            return false;
        }
        int safeVendorApiLevel = ExtensionsUtil.INSTANCE.getSafeVendorApiLevel();
        if (safeVendorApiLevel == 1) {
            return hasValidVendorApiLevel1$window_release();
        }
        if (2 <= safeVendorApiLevel && safeVendorApiLevel <= Integer.MAX_VALUE) {
            return hasValidVendorApiLevel2$window_release();
        }
        return false;
    }

    public final boolean isActivityEmbeddingComponentAccessible$window_release() {
        return this.safeWindowExtensionsProvider.isWindowExtensionsValid$window_release() && isActivityEmbeddingComponentValid();
    }

    public final boolean hasValidVendorApiLevel1$window_release() {
        return isMethodSetEmbeddingRulesValid() && isMethodIsActivityEmbeddedValid() && isMethodSetSplitInfoCallbackJavaConsumerValid() && isClassActivityRuleValid() && isClassSplitInfoValid() && isClassSplitPairRuleValid() && isClassSplitPlaceholderRuleValid();
    }

    public final boolean hasValidVendorApiLevel2$window_release() {
        return hasValidVendorApiLevel1$window_release() && isMethodSetSplitInfoCallbackWindowConsumerValid() && isMethodClearSplitInfoCallbackValid() && isMethodSplitAttributesCalculatorValid() && isMethodGetSplitAttributesValid() && isClassSplitAttributesValid() && isClassSplitTypeValid();
    }

    private final boolean isMethodSetEmbeddingRulesValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setEmbeddingRules is not valid", new Function0<Boolean>() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodSetEmbeddingRulesValid.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException {
                Method setEmbeddingRulesMethod = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("setEmbeddingRules", Set.class);
                ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(setEmbeddingRulesMethod, "setEmbeddingRulesMethod");
                return Boolean.valueOf(reflectionUtils.isPublic$window_release(setEmbeddingRulesMethod));
            }
        });
    }

    private final boolean isMethodIsActivityEmbeddedValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#isActivityEmbedded is not valid", new Function0<Boolean>() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodIsActivityEmbeddedValid.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException {
                Method isActivityEmbeddedMethod = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("isActivityEmbedded", Activity.class);
                ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(isActivityEmbeddedMethod, "isActivityEmbeddedMethod");
                return Boolean.valueOf(reflectionUtils.isPublic$window_release(isActivityEmbeddedMethod) && ReflectionUtils.INSTANCE.doesReturn$window_release(isActivityEmbeddedMethod, Boolean.TYPE));
            }
        });
    }

    private final boolean isMethodClearSplitInfoCallbackValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#clearSplitInfoCallback is not valid", new Function0<Boolean>() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodClearSplitInfoCallbackValid.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException {
                Method clearSplitInfoCallbackMethod = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("clearSplitInfoCallback", new Class[0]);
                ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(clearSplitInfoCallbackMethod, "clearSplitInfoCallbackMethod");
                return Boolean.valueOf(reflectionUtils.isPublic$window_release(clearSplitInfoCallbackMethod));
            }
        });
    }

    private final boolean isMethodSplitAttributesCalculatorValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setSplitAttributesCalculator is not valid", new Function0<Boolean>() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodSplitAttributesCalculatorValid.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Removed duplicated region for block: B:7:0x003f  */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException {
                /*
                    r6 = this;
                    androidx.window.embedding.SafeActivityEmbeddingComponentProvider r0 = androidx.window.embedding.SafeActivityEmbeddingComponentProvider.this
                    java.lang.Class r0 = androidx.window.embedding.SafeActivityEmbeddingComponentProvider.access$getActivityEmbeddingComponentClass(r0)
                    r1 = 1
                    java.lang.Class[] r2 = new java.lang.Class[r1]
                    java.lang.Class<androidx.window.extensions.core.util.function.Function> r3 = androidx.window.extensions.core.util.function.Function.class
                    r4 = 0
                    r2[r4] = r3
                    java.lang.String r3 = "setSplitAttributesCalculator"
                    java.lang.reflect.Method r0 = r0.getMethod(r3, r2)
                    androidx.window.embedding.SafeActivityEmbeddingComponentProvider r2 = androidx.window.embedding.SafeActivityEmbeddingComponentProvider.this
                    java.lang.Class r2 = androidx.window.embedding.SafeActivityEmbeddingComponentProvider.access$getActivityEmbeddingComponentClass(r2)
                    java.lang.String r3 = "clearSplitAttributesCalculator"
                    java.lang.Class[] r5 = new java.lang.Class[r4]
                    java.lang.reflect.Method r2 = r2.getMethod(r3, r5)
                    androidx.window.reflection.ReflectionUtils r3 = androidx.window.reflection.ReflectionUtils.INSTANCE
                    java.lang.String r5 = "setSplitAttributesCalculatorMethod"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
                    boolean r0 = r3.isPublic$window_release(r0)
                    if (r0 == 0) goto L3f
                    androidx.window.reflection.ReflectionUtils r0 = androidx.window.reflection.ReflectionUtils.INSTANCE
                    java.lang.String r3 = "clearSplitAttributesCalculatorMethod"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                    boolean r0 = r0.isPublic$window_release(r2)
                    if (r0 == 0) goto L3f
                    goto L40
                L3f:
                    r1 = r4
                L40:
                    java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.SafeActivityEmbeddingComponentProvider.C05441.invoke():java.lang.Boolean");
            }
        });
    }

    private final boolean isMethodGetSplitAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("SplitInfo#getSplitAttributes is not valid", new Function0<Boolean>() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodGetSplitAttributesValid.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException {
                boolean z = false;
                Method getSplitAttributesMethod = androidx.window.extensions.embedding.SplitInfo.class.getMethod("getSplitAttributes", new Class[0]);
                ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(getSplitAttributesMethod, "getSplitAttributesMethod");
                if (reflectionUtils.isPublic$window_release(getSplitAttributesMethod) && ReflectionUtils.INSTANCE.doesReturn$window_release(getSplitAttributesMethod, androidx.window.extensions.embedding.SplitAttributes.class)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    private final boolean isClassSplitAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitAttributes is not valid", new Function0<Boolean>() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitAttributesValid.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException {
                boolean z = false;
                Method getLayoutDirectionMethod = androidx.window.extensions.embedding.SplitAttributes.class.getMethod("getLayoutDirection", new Class[0]);
                Method getSplitTypeMethod = androidx.window.extensions.embedding.SplitAttributes.class.getMethod("getSplitType", new Class[0]);
                Method setSplitTypeMethod = SplitAttributes.Builder.class.getMethod("setSplitType", SplitAttributes.SplitType.class);
                Method setLayoutDirectionMethod = SplitAttributes.Builder.class.getMethod("setLayoutDirection", Integer.TYPE);
                ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(getLayoutDirectionMethod, "getLayoutDirectionMethod");
                if (reflectionUtils.isPublic$window_release(getLayoutDirectionMethod) && ReflectionUtils.INSTANCE.doesReturn$window_release(getLayoutDirectionMethod, Integer.TYPE)) {
                    ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(getSplitTypeMethod, "getSplitTypeMethod");
                    if (reflectionUtils2.isPublic$window_release(getSplitTypeMethod) && ReflectionUtils.INSTANCE.doesReturn$window_release(getSplitTypeMethod, SplitAttributes.SplitType.class)) {
                        ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(setSplitTypeMethod, "setSplitTypeMethod");
                        if (reflectionUtils3.isPublic$window_release(setSplitTypeMethod)) {
                            ReflectionUtils reflectionUtils4 = ReflectionUtils.INSTANCE;
                            Intrinsics.checkNotNullExpressionValue(setLayoutDirectionMethod, "setLayoutDirectionMethod");
                            if (reflectionUtils4.isPublic$window_release(setLayoutDirectionMethod)) {
                                z = true;
                            }
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
        });
    }

    private final boolean isClassSplitTypeValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitAttributes.SplitType is not valid", new Function0<Boolean>() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitTypeValid.1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Removed duplicated region for block: B:21:0x00a9  */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException {
                /*
                    r10 = this;
                    java.lang.Class<androidx.window.extensions.embedding.SplitAttributes$SplitType$RatioSplitType> r0 = androidx.window.extensions.embedding.SplitAttributes.SplitType.RatioSplitType.class
                    r1 = 1
                    java.lang.Class[] r2 = new java.lang.Class[r1]
                    java.lang.Class r3 = java.lang.Float.TYPE
                    r4 = 0
                    r2[r4] = r3
                    java.lang.reflect.Constructor r2 = r0.getDeclaredConstructor(r2)
                    java.lang.String r3 = "getRatio"
                    java.lang.Class[] r5 = new java.lang.Class[r4]
                    java.lang.reflect.Method r3 = r0.getMethod(r3, r5)
                    java.lang.String r5 = "splitEqually"
                    java.lang.Class[] r6 = new java.lang.Class[r4]
                    java.lang.reflect.Method r0 = r0.getMethod(r5, r6)
                    java.lang.Class<androidx.window.extensions.embedding.SplitAttributes$SplitType$HingeSplitType> r5 = androidx.window.extensions.embedding.SplitAttributes.SplitType.HingeSplitType.class
                    java.lang.Class[] r6 = new java.lang.Class[r1]
                    java.lang.Class<androidx.window.extensions.embedding.SplitAttributes$SplitType> r7 = androidx.window.extensions.embedding.SplitAttributes.SplitType.class
                    r6[r4] = r7
                    java.lang.reflect.Constructor r6 = r5.getDeclaredConstructor(r6)
                    java.lang.String r7 = "getFallbackSplitType"
                    java.lang.Class[] r8 = new java.lang.Class[r4]
                    java.lang.reflect.Method r5 = r5.getMethod(r7, r8)
                    java.lang.Class<androidx.window.extensions.embedding.SplitAttributes$SplitType$ExpandContainersSplitType> r7 = androidx.window.extensions.embedding.SplitAttributes.SplitType.ExpandContainersSplitType.class
                    java.lang.Class[] r8 = new java.lang.Class[r4]
                    java.lang.reflect.Constructor r7 = r7.getDeclaredConstructor(r8)
                    androidx.window.reflection.ReflectionUtils r8 = androidx.window.reflection.ReflectionUtils.INSTANCE
                    java.lang.String r9 = "ratioSplitTypeConstructor"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)
                    boolean r2 = r8.isPublic$window_release(r2)
                    if (r2 == 0) goto La9
                    androidx.window.reflection.ReflectionUtils r2 = androidx.window.reflection.ReflectionUtils.INSTANCE
                    java.lang.String r8 = "getRatioMethod"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r8)
                    boolean r2 = r2.isPublic$window_release(r3)
                    if (r2 == 0) goto La9
                    androidx.window.reflection.ReflectionUtils r2 = androidx.window.reflection.ReflectionUtils.INSTANCE
                    java.lang.Class r8 = java.lang.Float.TYPE
                    boolean r2 = r2.doesReturn$window_release(r3, r8)
                    if (r2 == 0) goto La9
                    androidx.window.reflection.ReflectionUtils r2 = androidx.window.reflection.ReflectionUtils.INSTANCE
                    java.lang.String r3 = "hingeSplitTypeConstructor"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
                    boolean r2 = r2.isPublic$window_release(r6)
                    if (r2 == 0) goto La9
                    androidx.window.reflection.ReflectionUtils r2 = androidx.window.reflection.ReflectionUtils.INSTANCE
                    java.lang.String r3 = "splitEquallyMethod"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
                    boolean r2 = r2.isPublic$window_release(r0)
                    if (r2 == 0) goto La9
                    androidx.window.reflection.ReflectionUtils r2 = androidx.window.reflection.ReflectionUtils.INSTANCE
                    java.lang.Class<androidx.window.extensions.embedding.SplitAttributes$SplitType$RatioSplitType> r3 = androidx.window.extensions.embedding.SplitAttributes.SplitType.RatioSplitType.class
                    boolean r0 = r2.doesReturn$window_release(r0, r3)
                    if (r0 == 0) goto La9
                    androidx.window.reflection.ReflectionUtils r0 = androidx.window.reflection.ReflectionUtils.INSTANCE
                    java.lang.String r2 = "getFallbackSplitTypeMethod"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
                    boolean r0 = r0.isPublic$window_release(r5)
                    if (r0 == 0) goto La9
                    androidx.window.reflection.ReflectionUtils r0 = androidx.window.reflection.ReflectionUtils.INSTANCE
                    java.lang.Class<androidx.window.extensions.embedding.SplitAttributes$SplitType> r2 = androidx.window.extensions.embedding.SplitAttributes.SplitType.class
                    boolean r0 = r0.doesReturn$window_release(r5, r2)
                    if (r0 == 0) goto La9
                    androidx.window.reflection.ReflectionUtils r0 = androidx.window.reflection.ReflectionUtils.INSTANCE
                    java.lang.String r2 = "expandContainersSplitTypeConstructor"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)
                    boolean r0 = r0.isPublic$window_release(r7)
                    if (r0 == 0) goto La9
                    goto Laa
                La9:
                    r1 = r4
                Laa:
                    java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.SafeActivityEmbeddingComponentProvider.C05371.invoke():java.lang.Boolean");
            }
        });
    }

    private final boolean isMethodSetSplitInfoCallbackJavaConsumerValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setSplitInfoCallback is not valid", new Function0<Boolean>() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodSetSplitInfoCallbackJavaConsumerValid.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException {
                Class<?> clsConsumerClassOrNull$window_release = SafeActivityEmbeddingComponentProvider.this.consumerAdapter.consumerClassOrNull$window_release();
                if (clsConsumerClassOrNull$window_release == null) {
                    return false;
                }
                Method setSplitInfoCallbackMethod = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("setSplitInfoCallback", clsConsumerClassOrNull$window_release);
                ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(setSplitInfoCallbackMethod, "setSplitInfoCallbackMethod");
                return Boolean.valueOf(reflectionUtils.isPublic$window_release(setSplitInfoCallbackMethod));
            }
        });
    }

    private final boolean isClassActivityRuleValid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityRule is not valid", new Function0<Boolean>() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassActivityRuleValid.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException {
                boolean z = false;
                Method shouldAlwaysExpandMethod = androidx.window.extensions.embedding.ActivityRule.class.getMethod("shouldAlwaysExpand", new Class[0]);
                Method setShouldAlwaysExpandMethod = ActivityRule.Builder.class.getMethod("setShouldAlwaysExpand", Boolean.TYPE);
                ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(shouldAlwaysExpandMethod, "shouldAlwaysExpandMethod");
                if (reflectionUtils.isPublic$window_release(shouldAlwaysExpandMethod) && ReflectionUtils.INSTANCE.doesReturn$window_release(shouldAlwaysExpandMethod, Boolean.TYPE)) {
                    ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(setShouldAlwaysExpandMethod, "setShouldAlwaysExpandMethod");
                    if (reflectionUtils2.isPublic$window_release(setShouldAlwaysExpandMethod)) {
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            }
        });
    }

    private final boolean isClassSplitInfoValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitInfo is not valid", new Function0<Boolean>() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitInfoValid.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException {
                boolean z = false;
                Method getPrimaryActivityStackMethod = androidx.window.extensions.embedding.SplitInfo.class.getMethod("getPrimaryActivityStack", new Class[0]);
                Method getSecondaryActivityStackMethod = androidx.window.extensions.embedding.SplitInfo.class.getMethod("getSecondaryActivityStack", new Class[0]);
                Method getSplitRatioMethod = androidx.window.extensions.embedding.SplitInfo.class.getMethod("getSplitRatio", new Class[0]);
                ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(getPrimaryActivityStackMethod, "getPrimaryActivityStackMethod");
                if (reflectionUtils.isPublic$window_release(getPrimaryActivityStackMethod) && ReflectionUtils.INSTANCE.doesReturn$window_release(getPrimaryActivityStackMethod, androidx.window.extensions.embedding.ActivityStack.class)) {
                    ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(getSecondaryActivityStackMethod, "getSecondaryActivityStackMethod");
                    if (reflectionUtils2.isPublic$window_release(getSecondaryActivityStackMethod) && ReflectionUtils.INSTANCE.doesReturn$window_release(getSecondaryActivityStackMethod, androidx.window.extensions.embedding.ActivityStack.class)) {
                        ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(getSplitRatioMethod, "getSplitRatioMethod");
                        if (reflectionUtils3.isPublic$window_release(getSplitRatioMethod) && ReflectionUtils.INSTANCE.doesReturn$window_release(getSplitRatioMethod, Float.TYPE)) {
                            z = true;
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
        });
    }

    private final boolean isClassSplitPairRuleValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPairRule is not valid", new Function0<Boolean>() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleValid.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException {
                boolean z = false;
                Method getFinishPrimaryWithSecondaryMethod = androidx.window.extensions.embedding.SplitPairRule.class.getMethod("getFinishPrimaryWithSecondary", new Class[0]);
                Method getFinishSecondaryWithPrimaryMethod = androidx.window.extensions.embedding.SplitPairRule.class.getMethod("getFinishSecondaryWithPrimary", new Class[0]);
                Method shouldClearTopMethod = androidx.window.extensions.embedding.SplitPairRule.class.getMethod("shouldClearTop", new Class[0]);
                ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(getFinishPrimaryWithSecondaryMethod, "getFinishPrimaryWithSecondaryMethod");
                if (reflectionUtils.isPublic$window_release(getFinishPrimaryWithSecondaryMethod) && ReflectionUtils.INSTANCE.doesReturn$window_release(getFinishPrimaryWithSecondaryMethod, Integer.TYPE)) {
                    ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(getFinishSecondaryWithPrimaryMethod, "getFinishSecondaryWithPrimaryMethod");
                    if (reflectionUtils2.isPublic$window_release(getFinishSecondaryWithPrimaryMethod) && ReflectionUtils.INSTANCE.doesReturn$window_release(getFinishSecondaryWithPrimaryMethod, Integer.TYPE)) {
                        ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(shouldClearTopMethod, "shouldClearTopMethod");
                        if (reflectionUtils3.isPublic$window_release(shouldClearTopMethod) && ReflectionUtils.INSTANCE.doesReturn$window_release(shouldClearTopMethod, Boolean.TYPE)) {
                            z = true;
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
        });
    }

    private final boolean isClassSplitPlaceholderRuleValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPlaceholderRule is not valid", new Function0<Boolean>() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleValid.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException {
                boolean z = false;
                Method getPlaceholderIntentMethod = androidx.window.extensions.embedding.SplitPlaceholderRule.class.getMethod("getPlaceholderIntent", new Class[0]);
                Method isStickyMethod = androidx.window.extensions.embedding.SplitPlaceholderRule.class.getMethod("isSticky", new Class[0]);
                Method getFinishPrimaryWithSecondaryMethod = androidx.window.extensions.embedding.SplitPlaceholderRule.class.getMethod("getFinishPrimaryWithSecondary", new Class[0]);
                ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(getPlaceholderIntentMethod, "getPlaceholderIntentMethod");
                if (reflectionUtils.isPublic$window_release(getPlaceholderIntentMethod) && ReflectionUtils.INSTANCE.doesReturn$window_release(getPlaceholderIntentMethod, Intent.class)) {
                    ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(isStickyMethod, "isStickyMethod");
                    if (reflectionUtils2.isPublic$window_release(isStickyMethod)) {
                        ReflectionUtils.INSTANCE.doesReturn$window_release(isStickyMethod, Boolean.TYPE);
                    }
                }
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(getFinishPrimaryWithSecondaryMethod, "getFinishPrimaryWithSecondaryMethod");
                if (reflectionUtils3.isPublic$window_release(getFinishPrimaryWithSecondaryMethod) && ReflectionUtils.INSTANCE.doesReturn$window_release(getFinishPrimaryWithSecondaryMethod, Integer.TYPE)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    private final boolean isMethodSetSplitInfoCallbackWindowConsumerValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setSplitInfoCallback is not valid", new Function0<Boolean>() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isMethodSetSplitInfoCallbackWindowConsumerValid.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException {
                Method setSplitInfoCallbackMethod = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass().getMethod("setSplitInfoCallback", Consumer.class);
                ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(setSplitInfoCallbackMethod, "setSplitInfoCallbackMethod");
                return Boolean.valueOf(reflectionUtils.isPublic$window_release(setSplitInfoCallbackMethod));
            }
        });
    }

    private final boolean isActivityEmbeddingComponentValid() {
        return ReflectionUtils.validateReflection$window_release("WindowExtensions#getActivityEmbeddingComponent is not valid", new Function0<Boolean>() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider.isActivityEmbeddingComponentValid.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
                boolean z = false;
                Method getActivityEmbeddingComponentMethod = SafeActivityEmbeddingComponentProvider.this.safeWindowExtensionsProvider.getWindowExtensionsClass$window_release().getMethod("getActivityEmbeddingComponent", new Class[0]);
                Class<?> activityEmbeddingComponentClass = SafeActivityEmbeddingComponentProvider.this.getActivityEmbeddingComponentClass();
                ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(getActivityEmbeddingComponentMethod, "getActivityEmbeddingComponentMethod");
                if (reflectionUtils.isPublic$window_release(getActivityEmbeddingComponentMethod) && ReflectionUtils.INSTANCE.doesReturn$window_release(getActivityEmbeddingComponentMethod, activityEmbeddingComponentClass)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> getActivityEmbeddingComponentClass() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.loader.loadClass(WindowExtensionsConstants.ACTIVITY_EMBEDDING_COMPONENT_CLASS);
        Intrinsics.checkNotNullExpressionValue(clsLoadClass, "loader.loadClass(ACTIVIT…MBEDDING_COMPONENT_CLASS)");
        return clsLoadClass;
    }
}
