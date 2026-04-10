package com.angcyo.tablayout;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Gravity;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DslGravity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0089\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052K\u0010\u000b\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\fH\u0002\u001a\u0087\u0001\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052K\u0010\u000b\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\f\u001a\u0087\u0001\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052K\u0010\u000b\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\f\u001a\n\u0010\u0015\u001a\u00020\u0016*\u00020\u0005\u001a\n\u0010\u0017\u001a\u00020\u0016*\u00020\u0005\u001a\n\u0010\u0018\u001a\u00020\u0016*\u00020\u0005\u001a\n\u0010\u0019\u001a\u00020\u0016*\u00020\u0005\u001a\n\u0010\u001a\u001a\u00020\u0016*\u00020\u0005¨\u0006\u001b"}, d2 = {"_config", "", "_dslGravity", "Lcom/angcyo/tablayout/DslGravity;", "gravity", "", MediaFormat.KEY_WIDTH, "", MediaFormat.KEY_HEIGHT, "offsetX", "offsetY", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "dslGravity", "centerX", "centerY", "rect", "Landroid/graphics/Rect;", "Landroid/graphics/RectF;", "isBottom", "", "isCenter", "isLeft", "isRight", "isTop", "TabLayout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DslGravityKt {
    public static final boolean isBottom(int i) {
        return (i & 112) == 80;
    }

    public static final boolean isTop(int i) {
        return (i & 112) == 48;
    }

    public static final DslGravity dslGravity(RectF rect, int i, float f, float f2, int i2, int i3, Function3<? super DslGravity, ? super Integer, ? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(callback, "callback");
        DslGravity dslGravity = new DslGravity();
        dslGravity.setGravityBounds(rect);
        _config(dslGravity, i, f, f2, i2, i3, callback);
        return dslGravity;
    }

    public static final DslGravity dslGravity(Rect rect, int i, float f, float f2, int i2, int i3, Function3<? super DslGravity, ? super Integer, ? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(callback, "callback");
        DslGravity dslGravity = new DslGravity();
        dslGravity.setGravityBounds(rect);
        _config(dslGravity, i, f, f2, i2, i3, callback);
        return dslGravity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _config(final DslGravity dslGravity, int i, float f, float f2, int i2, int i3, final Function3<? super DslGravity, ? super Integer, ? super Integer, Unit> function3) {
        dslGravity.setGravity(i);
        dslGravity.setGravityOffsetX(i2);
        dslGravity.setGravityOffsetY(i3);
        dslGravity.applyGravity(f, f2, new Function2<Integer, Integer, Unit>() { // from class: com.angcyo.tablayout.DslGravityKt._config.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i4, int i5) {
                function3.invoke(dslGravity, Integer.valueOf(i4), Integer.valueOf(i5));
            }
        });
    }

    public static final boolean isCenter(int i) {
        return (i & 112) == 16 && (Gravity.getAbsoluteGravity(i, 0) & 7) == 1;
    }

    public static final boolean isLeft(int i) {
        return (Gravity.getAbsoluteGravity(i, 0) & 7) == 3;
    }

    public static final boolean isRight(int i) {
        return (Gravity.getAbsoluteGravity(i, 0) & 7) == 5;
    }
}
