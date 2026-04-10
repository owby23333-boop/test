package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class PopupWindowCompat {
    private static final String TAG = "PopupWindowCompatApi21";
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Field sOverlapAnchorField;
    private static boolean sOverlapAnchorFieldAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;

    private PopupWindowCompat() {
    }

    public static boolean getOverlapAnchor(@NonNull PopupWindow popupWindow) {
        return popupWindow.getOverlapAnchor();
    }

    public static int getWindowLayoutType(@NonNull PopupWindow popupWindow) {
        return popupWindow.getWindowLayoutType();
    }

    public static void setOverlapAnchor(@NonNull PopupWindow popupWindow, boolean overlapAnchor) {
        popupWindow.setOverlapAnchor(overlapAnchor);
    }

    public static void setWindowLayoutType(@NonNull PopupWindow popupWindow, int layoutType) {
        popupWindow.setWindowLayoutType(layoutType);
    }

    public static void showAsDropDown(@NonNull PopupWindow popup, @NonNull View anchor, int xoff, int yoff, int gravity) {
        popup.showAsDropDown(anchor, xoff, yoff, gravity);
    }
}
