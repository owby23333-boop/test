package androidx.window.area.utils;

import android.util.DisplayMetrics;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: DeviceUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0002\b\u000bJ\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0002\b\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/window/area/utils/DeviceUtils;", "", "()V", "deviceList", "", "Landroidx/window/area/utils/DeviceMetrics;", "getRearDisplayMetrics", "Landroid/util/DisplayMetrics;", "manufacturer", "", "model", "getRearDisplayMetrics$window_release", "hasDeviceMetrics", "", "hasDeviceMetrics$window_release", "window_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DeviceUtils {
    public static final DeviceUtils INSTANCE = new DeviceUtils();
    private static final List<DeviceMetrics> deviceList;

    private DeviceUtils() {
    }

    static {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.widthPixels = 1080;
        displayMetrics.heightPixels = 2092;
        displayMetrics.density = 2.625f;
        displayMetrics.densityDpi = TypedValues.Cycle.TYPE_EASING;
        Unit unit = Unit.INSTANCE;
        deviceList = CollectionsKt.listOf(new DeviceMetrics("google", "pixel fold", displayMetrics));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean hasDeviceMetrics$window_release(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = "manufacturer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "model"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.util.List<androidx.window.area.utils.DeviceMetrics> r0 = androidx.window.area.utils.DeviceUtils.deviceList
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 0
            if (r1 == 0) goto L1d
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L1d
            goto L65
        L1d:
            java.util.Iterator r0 = r0.iterator()
        L21:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L65
            java.lang.Object r1 = r0.next()
            androidx.window.area.utils.DeviceMetrics r1 = (androidx.window.area.utils.DeviceMetrics) r1
            java.lang.String r3 = r1.getManufacturer()
            java.util.Locale r4 = java.util.Locale.US
            java.lang.String r5 = "US"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.String r4 = r8.toLowerCase(r4)
            java.lang.String r6 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            r4 = 1
            if (r3 == 0) goto L61
            java.lang.String r1 = r1.getModel()
            java.util.Locale r3 = java.util.Locale.US
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            java.lang.String r3 = r9.toLowerCase(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 == 0) goto L61
            r1 = r4
            goto L62
        L61:
            r1 = r2
        L62:
            if (r1 == 0) goto L21
            r2 = r4
        L65:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.area.utils.DeviceUtils.hasDeviceMetrics$window_release(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.DisplayMetrics getRearDisplayMetrics$window_release(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "manufacturer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "model"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.util.List<androidx.window.area.utils.DeviceMetrics> r0 = androidx.window.area.utils.DeviceUtils.deviceList
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L12:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L57
            java.lang.Object r1 = r0.next()
            r3 = r1
            androidx.window.area.utils.DeviceMetrics r3 = (androidx.window.area.utils.DeviceMetrics) r3
            java.lang.String r4 = r3.getManufacturer()
            java.util.Locale r5 = java.util.Locale.US
            java.lang.String r6 = "US"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.String r5 = r9.toLowerCase(r5)
            java.lang.String r7 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r4 == 0) goto L53
            java.lang.String r3 = r3.getModel()
            java.util.Locale r4 = java.util.Locale.US
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            java.lang.String r4 = r10.toLowerCase(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 == 0) goto L53
            r3 = 1
            goto L54
        L53:
            r3 = 0
        L54:
            if (r3 == 0) goto L12
            goto L58
        L57:
            r1 = r2
        L58:
            androidx.window.area.utils.DeviceMetrics r1 = (androidx.window.area.utils.DeviceMetrics) r1
            if (r1 == 0) goto L60
            android.util.DisplayMetrics r2 = r1.getRearDisplayMetrics()
        L60:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.area.utils.DeviceUtils.getRearDisplayMetrics$window_release(java.lang.String, java.lang.String):android.util.DisplayMetrics");
    }
}
