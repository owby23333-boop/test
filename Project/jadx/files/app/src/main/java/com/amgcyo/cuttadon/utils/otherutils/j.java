package com.amgcyo.cuttadon.utils.otherutils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: ClipboardUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class j {
    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        ClipData clipDataNewPlainText = ClipData.newPlainText("simpleText", str);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
    }

    public static String b(Context context) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager == null || !clipboardManager.hasPrimaryClip() || clipboardManager.getPrimaryClip() == null || clipboardManager.getPrimaryClip().getItemCount() <= 0) {
            return null;
        }
        String strValueOf = String.valueOf(clipboardManager.getPrimaryClip().getItemAt(0).getText());
        if (TextUtils.isEmpty(strValueOf)) {
            return null;
        }
        return strValueOf.trim();
    }

    public static void a(Context context) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager == null || !clipboardManager.hasPrimaryClip() || clipboardManager.getPrimaryClip() == null || clipboardManager.getPrimaryClip().getItemCount() <= 0) {
            return;
        }
        clipboardManager.setPrimaryClip(clipboardManager.getPrimaryClip());
        clipboardManager.setPrimaryClip(ClipData.newPlainText("", ""));
    }
}
