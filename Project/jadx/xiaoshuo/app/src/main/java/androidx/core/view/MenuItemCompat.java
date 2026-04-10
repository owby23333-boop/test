package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.core.internal.view.SupportMenuItem;

/* JADX INFO: loaded from: classes.dex */
public final class MenuItemCompat {

    @Deprecated
    public static final int SHOW_AS_ACTION_ALWAYS = 2;

    @Deprecated
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;

    @Deprecated
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;

    @Deprecated
    public static final int SHOW_AS_ACTION_NEVER = 0;

    @Deprecated
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final String TAG = "MenuItemCompat";

    @Deprecated
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem item);

        boolean onMenuItemActionExpand(MenuItem item);
    }

    private MenuItemCompat() {
    }

    @Deprecated
    public static boolean collapseActionView(MenuItem item) {
        return item.collapseActionView();
    }

    @Deprecated
    public static boolean expandActionView(MenuItem item) {
        return item.expandActionView();
    }

    public static ActionProvider getActionProvider(MenuItem item) {
        if (item instanceof SupportMenuItem) {
            return ((SupportMenuItem) item).getSupportActionProvider();
        }
        Log.w(TAG, "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    @Deprecated
    public static View getActionView(MenuItem item) {
        return item.getActionView();
    }

    public static int getAlphabeticModifiers(MenuItem item) {
        return item instanceof SupportMenuItem ? ((SupportMenuItem) item).getAlphabeticModifiers() : item.getAlphabeticModifiers();
    }

    public static CharSequence getContentDescription(MenuItem item) {
        return item instanceof SupportMenuItem ? ((SupportMenuItem) item).getContentDescription() : item.getContentDescription();
    }

    public static ColorStateList getIconTintList(MenuItem item) {
        return item instanceof SupportMenuItem ? ((SupportMenuItem) item).getIconTintList() : item.getIconTintList();
    }

    public static PorterDuff.Mode getIconTintMode(MenuItem item) {
        return item instanceof SupportMenuItem ? ((SupportMenuItem) item).getIconTintMode() : item.getIconTintMode();
    }

    public static int getNumericModifiers(MenuItem item) {
        return item instanceof SupportMenuItem ? ((SupportMenuItem) item).getNumericModifiers() : item.getNumericModifiers();
    }

    public static CharSequence getTooltipText(MenuItem item) {
        return item instanceof SupportMenuItem ? ((SupportMenuItem) item).getTooltipText() : item.getTooltipText();
    }

    @Deprecated
    public static boolean isActionViewExpanded(MenuItem item) {
        return item.isActionViewExpanded();
    }

    public static MenuItem setActionProvider(MenuItem item, ActionProvider provider) {
        if (item instanceof SupportMenuItem) {
            return ((SupportMenuItem) item).setSupportActionProvider(provider);
        }
        Log.w(TAG, "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return item;
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem item, View view) {
        return item.setActionView(view);
    }

    public static void setAlphabeticShortcut(MenuItem item, char alphaChar, int alphaModifiers) {
        if (item instanceof SupportMenuItem) {
            ((SupportMenuItem) item).setAlphabeticShortcut(alphaChar, alphaModifiers);
        } else {
            item.setAlphabeticShortcut(alphaChar, alphaModifiers);
        }
    }

    public static void setContentDescription(MenuItem item, CharSequence contentDescription) {
        if (item instanceof SupportMenuItem) {
            ((SupportMenuItem) item).setContentDescription(contentDescription);
        } else {
            item.setContentDescription(contentDescription);
        }
    }

    public static void setIconTintList(MenuItem item, ColorStateList tint) {
        if (item instanceof SupportMenuItem) {
            ((SupportMenuItem) item).setIconTintList(tint);
        } else {
            item.setIconTintList(tint);
        }
    }

    public static void setIconTintMode(MenuItem item, PorterDuff.Mode tintMode) {
        if (item instanceof SupportMenuItem) {
            ((SupportMenuItem) item).setIconTintMode(tintMode);
        } else {
            item.setIconTintMode(tintMode);
        }
    }

    public static void setNumericShortcut(MenuItem item, char numericChar, int numericModifiers) {
        if (item instanceof SupportMenuItem) {
            ((SupportMenuItem) item).setNumericShortcut(numericChar, numericModifiers);
        } else {
            item.setNumericShortcut(numericChar, numericModifiers);
        }
    }

    @Deprecated
    public static MenuItem setOnActionExpandListener(MenuItem item, final OnActionExpandListener listener2) {
        return item.setOnActionExpandListener(new MenuItem.OnActionExpandListener() { // from class: androidx.core.view.MenuItemCompat.1
            @Override // android.view.MenuItem.OnActionExpandListener
            public boolean onMenuItemActionCollapse(MenuItem item2) {
                return listener2.onMenuItemActionCollapse(item2);
            }

            @Override // android.view.MenuItem.OnActionExpandListener
            public boolean onMenuItemActionExpand(MenuItem item2) {
                return listener2.onMenuItemActionExpand(item2);
            }
        });
    }

    public static void setShortcut(MenuItem item, char numericChar, char alphaChar, int numericModifiers, int alphaModifiers) {
        if (item instanceof SupportMenuItem) {
            ((SupportMenuItem) item).setShortcut(numericChar, alphaChar, numericModifiers, alphaModifiers);
        } else {
            item.setShortcut(numericChar, alphaChar, numericModifiers, alphaModifiers);
        }
    }

    @Deprecated
    public static void setShowAsAction(MenuItem item, int actionEnum) {
        item.setShowAsAction(actionEnum);
    }

    public static void setTooltipText(MenuItem item, CharSequence tooltipText) {
        if (item instanceof SupportMenuItem) {
            ((SupportMenuItem) item).setTooltipText(tooltipText);
        } else {
            item.setTooltipText(tooltipText);
        }
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem item, int resId) {
        return item.setActionView(resId);
    }
}
