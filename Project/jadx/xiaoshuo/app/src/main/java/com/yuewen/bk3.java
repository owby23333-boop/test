package com.yuewen;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class bk3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bk3 f9109a = new bk3();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9110b = "ShortCutsManager";

    public static bk3 c() {
        return f9109a;
    }

    public static /* synthetic */ void d(Context context, int i, String str, String str2, Icon icon, Intent intent) {
        ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
        List<ShortcutInfo> dynamicShortcuts = shortcutManager.getDynamicShortcuts();
        if (i == 1) {
            Iterator<ShortcutInfo> it = dynamicShortcuts.iterator();
            while (it.hasNext()) {
                if (it.next().getId().equals(str)) {
                    return;
                }
            }
        } else if (i == 2) {
            Iterator<ShortcutInfo> it2 = dynamicShortcuts.iterator();
            while (it2.hasNext()) {
                if (it2.next().getShortLabel().equals(str2)) {
                    return;
                }
            }
        } else if (i == 3) {
            for (ShortcutInfo shortcutInfo : dynamicShortcuts) {
                if (shortcutInfo.getShortLabel().equals(str2) || shortcutInfo.getId().equals(str)) {
                    return;
                }
            }
        } else if (i == 4) {
            for (ShortcutInfo shortcutInfo2 : dynamicShortcuts) {
                if (shortcutInfo2.getShortLabel().equals(str2) && shortcutInfo2.getId().equals(str)) {
                    return;
                }
            }
        }
        ShortcutInfo shortcutInfoBuild = new ShortcutInfo.Builder(context, str).setShortLabel(str2).setLongLabel(str2).setIcon(icon).setIntent(intent).build();
        LinkedList linkedList = new LinkedList();
        linkedList.add(shortcutInfoBuild);
        try {
            shortcutManager.addDynamicShortcuts(linkedList);
        } catch (Exception e) {
            qt1.d(f9110b, e.getMessage());
        }
    }

    public void b(final String str, final Icon icon, final String str2, final Intent intent, final Context context, final int i) {
        cl2.q(new Runnable() { // from class: com.yuewen.ak3
            @Override // java.lang.Runnable
            public final void run() {
                bk3.d(context, i, str, str2, icon, intent);
            }
        });
    }
}
