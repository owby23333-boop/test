package miuix.appcompat.internal.view.menu;

import android.graphics.drawable.Drawable;
import miuix.appcompat.internal.view.menu.MenuBuilder;

/* JADX INFO: loaded from: classes7.dex */
public interface MenuView {

    public interface ItemView {
        MenuItemImpl getItemData();

        void initialize(MenuItemImpl menuItemImpl, int i);

        boolean prefersCondensedTitle();

        void setCheckable(boolean z);

        void setChecked(boolean z);

        void setEnabled(boolean z);

        void setIcon(Drawable drawable2);

        void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker);

        void setShortcut(boolean z, char c);

        void setTitle(CharSequence charSequence);

        boolean showsIcon();
    }

    boolean filterLeftoverView(int i);

    int getWindowAnimations();

    boolean hasBackgroundView();

    void initialize(MenuBuilder menuBuilder);
}
