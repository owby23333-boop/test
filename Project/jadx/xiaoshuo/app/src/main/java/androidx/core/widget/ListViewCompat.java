package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class ListViewCompat {
    private ListViewCompat() {
    }

    public static boolean canScrollList(@NonNull ListView listView, int direction) {
        return listView.canScrollList(direction);
    }

    public static void scrollListBy(@NonNull ListView listView, int y) {
        listView.scrollListBy(y);
    }
}
