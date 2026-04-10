package com.xiaomi.passport.ui.internal.util;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.xiaomi.account.passportsdk.account_sso.R;
import com.xiaomi.accountsdk.account.utils.BitmapUtils;
import com.xiaomi.accountsdk.utils.AccountLogger;

/* JADX INFO: loaded from: classes8.dex */
public class SysHelper {
    private static final String TAG = "SysHelper";

    private static boolean atLeast2True(boolean z, boolean z2, boolean z3) {
        return (z && z2) || (z && z3) || (z2 && z3);
    }

    public static boolean checkPasswordPattern(String str) {
        int length;
        if (str == null || (length = str.length()) < 8 || length > 16) {
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < ' ' || cCharAt > '~') {
                return false;
            }
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                z = true;
            } else if (cCharAt < '0' || cCharAt > '9') {
                z3 = true;
            } else {
                z2 = true;
            }
        }
        return atLeast2True(z, z2, z3);
    }

    public static Bitmap createPhoto(Activity activity, String str) {
        Bitmap userAvatarByAbsPath = str != null ? BitmapUtils.getUserAvatarByAbsPath(activity, str) : null;
        if (userAvatarByAbsPath == null) {
            userAvatarByAbsPath = android.graphics.BitmapFactory.decodeResource(activity.getResources(), R.drawable.passport_default_avatar);
        }
        if (userAvatarByAbsPath == null) {
            return null;
        }
        Bitmap bitmapCreatePhoto = BitmapFactory.createPhoto(activity, userAvatarByAbsPath);
        userAvatarByAbsPath.recycle();
        return bitmapCreatePhoto;
    }

    public static void delayDisplaySoftInputIfNeed(final Context context, final View view, final boolean z, int i) {
        if (view == null) {
            AccountLogger.log(TAG, "no focused view");
        } else {
            final InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            view.postDelayed(new Runnable() { // from class: com.xiaomi.passport.ui.internal.util.SysHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    view.requestFocus();
                    if (z && context.getResources().getConfiguration().orientation == 1) {
                        inputMethodManager.showSoftInput(view, 0);
                    } else {
                        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }
                }
            }, i);
        }
    }

    public static void displaySoftInputIfNeed(Context context, View view, boolean z) {
        if (view == null) {
            AccountLogger.log(TAG, "no focused view");
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (z && context.getResources().getConfiguration().orientation == 1) {
            inputMethodManager.showSoftInput(view, 0);
        } else {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static int getEditViewInputType(boolean z) {
        return (z ? MediaPlayer.MEDIA_PLAYER_OPTION_SPADE : 128) | 1;
    }

    public static void replaceToFragment(Activity activity, Fragment fragment, boolean z) {
        replaceToFragment(activity, fragment, z, android.R.id.content);
    }

    public static void replaceToFragment(Activity activity, Fragment fragment, boolean z, int i) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            FragmentManager fragmentManager = activity.getFragmentManager();
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            if (z) {
                int backStackEntryCount = fragmentManager.getBackStackEntryCount();
                for (int i2 = 0; i2 < backStackEntryCount; i2++) {
                    fragmentManager.popBackStack();
                }
            }
            fragmentTransactionBeginTransaction.setTransition(4099);
            fragmentTransactionBeginTransaction.replace(i, fragment);
            if (!z) {
                fragmentTransactionBeginTransaction.addToBackStack(null);
            }
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        } catch (IllegalStateException e) {
            AccountLogger.log(TAG, "fragment", e);
        }
    }
}
