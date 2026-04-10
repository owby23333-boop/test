package com.amgcyo.cuttadon.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import com.amgcyo.cuttadon.activity.fission6.Fission6IndexActivity;
import com.amgcyo.cuttadon.activity.main.MkShareActivity;
import com.amgcyo.cuttadon.api.entity.comic.Base64Bean;
import com.amgcyo.cuttadon.api.entity.config.Fission;
import com.amgcyo.cuttadon.api.entity.config.FissionData;
import com.amgcyo.cuttadon.api.entity.config.JsonColorStyle;
import com.amgcyo.cuttadon.api.entity.config.MkAppConfig;
import com.amgcyo.cuttadon.api.entity.other.MkAreaCodeBean;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.entity.other.SdkErrorBean;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.utils.otherutils.t0;
import com.amgcyo.cuttadon.utils.otherutils.y;
import com.amgcyo.cuttadon.view.otherview.BadgeView;
import com.amgcyo.cuttadon.view.otherview.URLSpanNoUnderline;
import com.amgcyo.cuttadon.view.otherview.URLSpanNoUnderlineColor;
import com.amgcyo.cuttadon.view.showcaseview.MaterialShowcaseView;
import com.amgcyo.cuttadon.view.showcaseview.ShowcaseTooltip;
import com.amgcyo.cuttadon.widget.lovelydialog.LovelyStandardDialog;
import com.amgcyo.cuttadon.widget.lovelydialog.b;
import com.amgcyo.cuttadon.widget.lovelydialog.d;
import com.fatcatfat.io.R;
import com.jakewharton.processphoenix.ProcessPhoenix;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: ArtUIHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class o {
    public static String a(int i2) {
        return i2 == 1 ? "已完结" : "连载中";
    }

    public static void a(Context context, CharSequence charSequence, CharSequence charSequence2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        new LovelyStandardDialog(context, LovelyStandardDialog.ButtonLayout.HORIZONTAL).a(context.getResources().getDrawable(R.drawable.dialog_bg_round_top)).j(R.color.colorPrimary).h(R.color.text_66).c(R.drawable.ic_info_outline_black_32dp).b(charSequence).a(charSequence2).b(R.string.confirm, onClickListener).a(R.string.cancel, onClickListener2).c();
    }

    static /* synthetic */ void a(View view) {
    }

    public static void b(Activity activity) {
        if (com.amgcyo.cuttadon.utils.otherutils.h.I0()) {
            r0.startActivity(activity, Fission6IndexActivity.class);
        } else {
            a(activity);
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static void e(String str) {
        com.sdsmdg.tastytoast.a.a(MkApplication.getAppContext(), 17, str, 0, 3);
    }

    public static void f(int i2) {
        l.b.a.j.a(i2);
    }

    public static void g(String str) {
    }

    public static String d(@StringRes int i2) {
        return MkApplication.getAppContext().getString(i2);
    }

    public static String e(int i2) {
        return i2 != 2 ? i2 != 3 ? d(R.string.fission6_not_free) : "特权已过期" : "账号在其它设备登录，特权已失效";
    }

    public static void f(String str) {
        com.sdsmdg.tastytoast.a.a(MkApplication.getAppContext(), 17, str, 1, 1);
    }

    public static void b(String str) {
        l.b.a.j.a((CharSequence) str);
    }

    public static void c(TextView textView) {
        Calendar calendar = Calendar.getInstance();
        textView.setText(String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12))));
    }

    static /* synthetic */ void b(View view, View view2) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        if (view.getRootView().getHeight() - rect.bottom > view.getRootView().getHeight() / 4) {
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            view.scrollTo(0, (iArr[1] + view2.getHeight()) - rect.bottom);
            return;
        }
        view.scrollTo(0, 0);
    }

    public static void c(final View view) {
        if (view != null) {
            try {
                view.setEnabled(false);
                view.postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.f.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.b(view);
                    }
                }, 500L);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    static /* synthetic */ void c(Context context, View view) {
        String strC0 = com.amgcyo.cuttadon.utils.otherutils.h.C0();
        a(context, strC0, R.string.website_copy_suc);
        com.amgcyo.cuttadon.view.webview.b.startActivity(context, strC0);
    }

    public static void a(Context context, String str, boolean z2, CharSequence charSequence, CharSequence charSequence2, View.OnClickListener onClickListener) {
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        new LovelyStandardDialog(context, LovelyStandardDialog.ButtonLayout.HORIZONTAL).a(context.getResources().getDrawable(R.drawable.dialog_bg_round_top)).f(R.color.colorPrimary).c(R.drawable.ic_info_outline_black_32dp).b(charSequence).a(false).a(charSequence2).b(str, onClickListener, z2).d().c();
    }

    public static int b(@ColorRes int i2) {
        return MkApplication.getAppContext().getResources().getColor(i2);
    }

    public static JsonColorStyle c() {
        JsonColorStyle jsonColorStyle;
        String strD = g0.a().d("json_colorstyle");
        if (TextUtils.isEmpty(strD) || (jsonColorStyle = (JsonColorStyle) com.amgcyo.cuttadon.utils.otherutils.r.a(strD, JsonColorStyle.class)) == null) {
            return null;
        }
        String str = "自渲染颜色：" + jsonColorStyle.toString();
        return jsonColorStyle;
    }

    public static void b(TextView textView, Drawable drawable) {
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
    }

    public static void b(TextView textView) {
        if (textView == null || !(textView.getText() instanceof Spannable)) {
            return;
        }
        Spannable spannable = (Spannable) textView.getText();
        for (URLSpan uRLSpan : (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class)) {
            int spanStart = spannable.getSpanStart(uRLSpan);
            int spanEnd = spannable.getSpanEnd(uRLSpan);
            spannable.removeSpan(uRLSpan);
            spannable.setSpan(new URLSpanNoUnderlineColor(uRLSpan.getURL()), spanStart, spanEnd, 0);
        }
        textView.setAutoLinkMask(0);
        textView.setText(spannable);
    }

    public static String c(@StringRes int i2) {
        return String.format(Locale.getDefault(), d(i2), a());
    }

    private static void a(Context context, boolean z2, CharSequence charSequence, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        new LovelyStandardDialog(context, LovelyStandardDialog.ButtonLayout.HORIZONTAL).a(context.getResources().getDrawable(R.drawable.dialog_bg_round_top)).f(R.color.colorPrimary).c(R.drawable.ic_info_outline_black_32dp).b("系统提示").a(false).a(charSequence).j(R.color.colorPrimary).h(R.color.text_99).b(z2).b("立即下载并安装", onClickListener, false).a("反馈给客服", onClickListener2, true).c();
    }

    static /* synthetic */ void b(View view) {
        if (view.getContext() != null) {
            view.setEnabled(true);
        }
    }

    static /* synthetic */ void b(Context context, View view) {
        Toast.makeText(context, "请点击桌面APP图标进行启动", 0).show();
        me.jessyan.art.d.d.e().d();
        g0.a().b("config_use_timestamp", true);
        MobclickAgent.onKillProcess(context);
        System.exit(0);
    }

    static /* synthetic */ void b(Context context, SdkErrorBean sdkErrorBean, View view) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
            r0.b(context);
        } else {
            me.jessyan.art.d.f.a().a(sdkErrorBean, "submitFeebV2");
        }
    }

    public static void a(Context context, String str, String str2, CharSequence charSequence, CharSequence charSequence2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        new LovelyStandardDialog(context, LovelyStandardDialog.ButtonLayout.HORIZONTAL).a(context.getResources().getDrawable(R.drawable.dialog_bg_round_top)).f(R.color.colorPrimary).c(R.drawable.ic_info_outline_black_32dp).b(charSequence).a(charSequence2).c(str, onClickListener).a(str2, onClickListener2).c();
    }

    public static String b() {
        if (com.amgcyo.cuttadon.utils.otherutils.h.u() == 0) {
            return d(R.string.cz_noad_read);
        }
        return d(R.string.cz_free_read);
    }

    private static void a(Context context, String str, String str2, String str3, CharSequence charSequence, CharSequence charSequence2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        new LovelyStandardDialog(context, LovelyStandardDialog.ButtonLayout.HORIZONTAL).a(context.getResources().getDrawable(R.drawable.dialog_bg_round_top)).f(R.color.colorPrimary).a(false).c(R.drawable.ic_info_outline_black_32dp).b(charSequence).a(charSequence2, 14.0f).c(str, onClickListener).a(str2, onClickListener2).a(str3, false, onClickListener3).c();
    }

    public static boolean a(final Context context, int i2, int i3) {
        Fission next;
        final FissionData fission_data;
        int upload_avatar_count;
        ArrayList<Fission> arrayListK = com.amgcyo.cuttadon.utils.otherutils.h.K();
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(arrayListK)) {
            return true;
        }
        Iterator<Fission> it = arrayListK.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (i3 == next.getScheme()) {
                break;
            }
        }
        if (next == null) {
            return true;
        }
        final String menu_url = next.getMenu_url();
        if (TextUtils.isEmpty(menu_url) || (fission_data = next.getFission_data()) == null) {
            return true;
        }
        if (i2 == 1) {
            upload_avatar_count = fission_data.getDown_done_cache_count();
        } else if (i2 == 2) {
            upload_avatar_count = fission_data.getListening_to_books_count();
        } else {
            upload_avatar_count = i2 == 3 ? fission_data.getUpload_avatar_count() : 0;
        }
        MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
        if (mkUserJ != null && mkUserJ.getInvitation_count() >= upload_avatar_count) {
            return true;
        }
        a(context, "提示", "需要解锁任务后才能使用该功能,是否去解锁?", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.f.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r0.a(context, menu_url, fission_data);
            }
        }, new View.OnClickListener() { // from class: com.amgcyo.cuttadon.f.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.a(view);
            }
        });
        return false;
    }

    public static BadgeView a(Context context, View view, String str, int i2, int i3, int i4) {
        BadgeView badgeView = new BadgeView(context, view);
        badgeView.setText(str);
        badgeView.setBadgePosition(i4);
        badgeView.setTextColor(-1);
        badgeView.setBadgeBackgroundColor(b(R.color.colorPrimary));
        badgeView.setTextSize(0, com.amgcyo.cuttadon.utils.otherutils.n.a(10.0f));
        badgeView.a(i2, i3);
        badgeView.b();
        return badgeView;
    }

    public static void a(Context context, CharSequence charSequence, CharSequence charSequence2, ArrayAdapter arrayAdapter, b.c cVar) {
        new com.amgcyo.cuttadon.widget.lovelydialog.b(context).a(context.getResources().getDrawable(R.drawable.dialog_bg_round_top)).c(R.drawable.ic_info_outline_black_32dp).b(charSequence).a(arrayAdapter, cVar).a(charSequence2).c();
    }

    public static void a(Context context, String str, @StringRes int i2) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText(null, str));
        l.b.a.j.a(i2);
    }

    public static void a(Context context, String str, String str2) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText(null, str));
        l.b.a.j.a((CharSequence) str2);
    }

    public static String a(int i2, Integer num) {
        if (i2 < 10000) {
            return "少于1万字";
        }
        double d2 = i2;
        Double.isNaN(d2);
        double d3 = d2 / 10000.0d;
        if (num != null) {
            return String.format("%." + num + "f", Double.valueOf(d3)) + "万字";
        }
        return d3 + "万字";
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r7, java.lang.Boolean r8) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.f.o.a(java.lang.String, java.lang.Boolean):java.lang.String");
    }

    public static Dialog a(Context context, @StringRes int i2, String str, CharSequence charSequence, CharSequence charSequence2, d.c cVar, View.OnClickListener onClickListener) {
        return new com.amgcyo.cuttadon.widget.lovelydialog.d(context, R.style.EditTextTintTheme).b(charSequence).f(R.color.colorPrimary).e(R.color.colorPrimary).a(charSequence2).a(str).c(R.drawable.ic_assignment_black_24dp).a(i2, new d.InterfaceC0124d() { // from class: com.amgcyo.cuttadon.f.c
            @Override // com.amgcyo.cuttadon.widget.lovelydialog.d.InterfaceC0124d
            public final boolean check(String str2) {
                return str2.matches("\\w+");
            }
        }).a(android.R.string.ok, cVar).a(android.R.string.no, (View.OnClickListener) null).a(new com.amgcyo.cuttadon.widget.lovelydialog.e() { // from class: com.amgcyo.cuttadon.f.b
            @Override // com.amgcyo.cuttadon.widget.lovelydialog.e
            public final void a(View view) {
                ((EditText) view).setMaxLines(1);
            }
        }).c();
    }

    public static boolean a(MkAreaCodeBean mkAreaCodeBean, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && str.length() != 0) {
            if (!com.amgcyo.cuttadon.utils.otherutils.g.b(mkAreaCodeBean.getRegexp_literal(), str)) {
                b("手机号格式不正确~");
                return false;
            }
            if (!TextUtils.isEmpty(str3) && str3.length() != 0) {
                if (!Pattern.compile("^[0-9]{6}$").matcher(str3).matches()) {
                    b("验证码只能是6位数字");
                    return false;
                }
                if (!TextUtils.isEmpty(str2) && str2.length() != 0) {
                    if (Pattern.compile("^.{6,20}$").matcher(str2).matches()) {
                        return true;
                    }
                    b(d(R.string.pwd_error));
                    return false;
                }
                b("请输入密码");
                return false;
            }
            b("请输入验证码");
            return false;
        }
        b(d(R.string.input_phone));
        return false;
    }

    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.length() != 0) {
            Pattern patternCompile = Pattern.compile("^.{6,20}$");
            Matcher matcher = patternCompile.matcher(str2);
            Matcher matcher2 = patternCompile.matcher(str);
            if (matcher.matches() && matcher2.matches()) {
                return true;
            }
            b(d(R.string.pwd_error));
            return false;
        }
        b("请输入必要信息");
        return false;
    }

    public static void a(final View view, final View view2) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.amgcyo.cuttadon.f.j
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                o.b(view, view2);
            }
        });
    }

    public static void a(TextView textView, Drawable drawable) {
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(drawable, null, null, null);
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        if (view == null || view.getLayoutParams() == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMargins(i2, i3, i4, i5);
        view.setLayoutParams(marginLayoutParams);
    }

    public static GradientDrawable a(int i2, int i3, int i4, String str, int i5) {
        int color = (str == null || str.equals("")) ? -1 : Color.parseColor(str);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i5);
        if (-1 == i4) {
            gradientDrawable.setShape(0);
        } else {
            gradientDrawable.setShape(i4);
        }
        if (-1 != i3) {
            gradientDrawable.setCornerRadius(i3);
        }
        if (-1 != i2 && -1 != color) {
            gradientDrawable.setStroke(i2, color);
        }
        return gradientDrawable;
    }

    public static void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof ViewGroup) {
                    childAt.setBackground(null);
                    a((ViewGroup) childAt);
                } else {
                    if (childAt != null) {
                        childAt.setBackground(null);
                    }
                    if (childAt instanceof ImageView) {
                        ((ImageView) childAt).setImageDrawable(null);
                    } else {
                        boolean z2 = childAt instanceof EditText;
                    }
                }
            }
        }
    }

    public static void a(ImageView imageView) {
        ColorMatrix colorMatrix = new ColorMatrix();
        float f2 = -80;
        colorMatrix.set(new float[]{1.0f, 0.0f, 0.0f, 0.0f, f2, 0.0f, 1.0f, 0.0f, 0.0f, f2, 0.0f, 0.0f, 1.0f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    public static Bitmap a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static void a(Drawable drawable, View view) {
        if (view == null) {
            return;
        }
        Palette paletteGenerate = Palette.from(a(drawable)).generate();
        if (paletteGenerate.getDominantSwatch() != null) {
            view.setBackgroundColor(ColorUtils.setAlphaComponent(paletteGenerate.getDominantSwatch().getRgb(), 180));
            return;
        }
        if (paletteGenerate.getVibrantSwatch() != null) {
            view.setBackgroundColor(paletteGenerate.getVibrantSwatch().getBodyTextColor());
            return;
        }
        if (paletteGenerate.getDarkVibrantSwatch() != null) {
            view.setBackgroundColor(paletteGenerate.getDarkVibrantSwatch().getBodyTextColor());
            return;
        }
        if (paletteGenerate.getLightVibrantSwatch() != null) {
            view.setBackgroundColor(paletteGenerate.getLightVibrantSwatch().getBodyTextColor());
            return;
        }
        if (paletteGenerate.getMutedSwatch() != null) {
            view.setBackgroundColor(paletteGenerate.getMutedSwatch().getBodyTextColor());
            return;
        }
        if (paletteGenerate.getDarkMutedSwatch() != null) {
            view.setBackgroundColor(paletteGenerate.getDarkMutedSwatch().getBodyTextColor());
        } else if (paletteGenerate.getLightVibrantSwatch() != null) {
            view.setBackgroundColor(paletteGenerate.getLightVibrantSwatch().getBodyTextColor());
        } else {
            view.setBackgroundColor(b(R.color.color_5d5b58));
        }
    }

    public static MaterialShowcaseView a(Activity activity, View view, String str, com.amgcyo.cuttadon.view.showcaseview.i.e eVar, int i2, int i3, int i4, com.amgcyo.cuttadon.view.showcaseview.e eVar2) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.cus_caseview, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_tips)).setText(str);
        MaterialShowcaseView.d dVar = new MaterialShowcaseView.d(activity);
        dVar.a(view);
        dVar.a(a(activity, i4, viewInflate));
        dVar.a(eVar);
        dVar.c();
        dVar.c(i2);
        dVar.b(i3);
        dVar.a(false);
        dVar.a(eVar2);
        dVar.b();
        dVar.a(ContextCompat.getColor(activity, R.color.tooltip_mask));
        final MaterialShowcaseView materialShowcaseViewA = dVar.a();
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.f.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                materialShowcaseViewA.c();
            }
        });
        return materialShowcaseViewA;
    }

    private static ShowcaseTooltip a(Context context, int i2, View view) {
        ShowcaseTooltip showcaseTooltipA = ShowcaseTooltip.a(context);
        showcaseTooltipA.a(i2);
        showcaseTooltipA.a(view);
        return showcaseTooltipA;
    }

    public static void a(Activity activity) {
        r0.startActivity(activity, MkShareActivity.class);
    }

    public static void a(ImageView imageView, int i2) {
        if (imageView == null) {
            return;
        }
        try {
            imageView.setImageResource(i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(View view, int i2) {
        if (view == null) {
            return;
        }
        try {
            if (view.getVisibility() != i2) {
                view.setVisibility(i2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(View view, boolean z2) {
        if (view == null) {
            return;
        }
        try {
            a(view, z2 ? 0 : 8);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(TextView textView) {
        if (textView == null || !(textView.getText() instanceof Spannable)) {
            return;
        }
        Spannable spannable = (Spannable) textView.getText();
        for (URLSpan uRLSpan : (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class)) {
            int spanStart = spannable.getSpanStart(uRLSpan);
            int spanEnd = spannable.getSpanEnd(uRLSpan);
            spannable.removeSpan(uRLSpan);
            spannable.setSpan(new URLSpanNoUnderline(uRLSpan.getURL()), spanStart, spanEnd, 0);
        }
        textView.setAutoLinkMask(0);
        textView.setText(spannable);
    }

    public static void a(final Context context, final SdkErrorBean sdkErrorBean) {
        String str;
        String str2;
        if (sdkErrorBean == null || context == null) {
            return;
        }
        int iG = com.amgcyo.cuttadon.utils.otherutils.g.g();
        int errorCode = sdkErrorBean.getErrorCode();
        String strF = com.amgcyo.cuttadon.utils.otherutils.g.F();
        System.out.println(iG + " url：" + strF);
        if (iG >= 4) {
            return;
        }
        MkAppConfig mkAppConfigJ0 = com.amgcyo.cuttadon.utils.otherutils.h.j0();
        if (mkAppConfigJ0 != null) {
            str = " 本地缓存请求时间：" + mkAppConfigJ0.getSave_time();
        } else {
            str = " 本地缓存请求时间：null";
        }
        String str3 = "time_save:" + str;
        sdkErrorBean.setSaveTime(str);
        sdkErrorBean.toString();
        com.amgcyo.cuttadon.utils.otherutils.h.i("");
        g0.a().b("hcehiuwhrg", "");
        g0.a().b("koiweoivna", "");
        g0.a().b("fqie9", "");
        if (com.amgcyo.cuttadon.utils.otherutils.h.w(errorCode)) {
            com.amgcyo.cuttadon.h.h.c.a(sdkErrorBean.getPlatform(), errorCode + " " + str + " " + sdkErrorBean.getErrorMsg());
            int i2 = com.amgcyo.cuttadon.utils.otherutils.g.i();
            Integer.valueOf(i2);
            if (i2 <= 3) {
                a(context, sdkErrorBean, errorCode, i2);
                return;
            }
            if (i2 <= 4) {
                a(context, sdkErrorBean, errorCode, i2);
                return;
            }
            String strC = com.amgcyo.cuttadon.sdk.utils.g.c("stamp");
            String str4 = "stamp:" + strC;
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            String strA = com.amgcyo.cuttadon.utils.comic.b.a(new Base64Bean(strC));
            String str5 = "stamp:" + strA;
            if (TextUtils.isEmpty(strA) || strA == null) {
                return;
            }
            String str6 = "platformSha1:" + com.amgcyo.cuttadon.utils.otherutils.g.q();
            if (!strA.equalsIgnoreCase(r5)) {
                a(context, sdkErrorBean, errorCode, i2);
                return;
            }
            return;
        }
        String str7 = "\u3000\u3000系统参数异常，请重新启动APP；重启过程中请务必保持网络连接正常，否则该错误将持续出现！！！";
        if (iG <= 1) {
            str2 = "";
        } else {
            str7 = "\u3000\u3000系统参数异常，请重新启动APP；重启过程中请务必保持网络连接正常，否则该错误将持续出现！！！\n\u3000\u3000如果重启多次后仍然无法解决，请5分钟后再试或者反馈给客服！";
            str2 = "反馈给客服";
        }
        a(context, "自动重启", "手动重启", str2, "温馨提示", str7, new View.OnClickListener() { // from class: com.amgcyo.cuttadon.f.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.a(context, view);
            }
        }, new View.OnClickListener() { // from class: com.amgcyo.cuttadon.f.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.b(context, view);
            }
        }, new View.OnClickListener() { // from class: com.amgcyo.cuttadon.f.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.a(context, sdkErrorBean, view);
            }
        });
        com.amgcyo.cuttadon.utils.otherutils.g.l(iG + 1);
    }

    static /* synthetic */ void a(Context context, View view) {
        g0.a().b("config_use_timestamp", true);
        ProcessPhoenix.triggerRebirth(context);
    }

    static /* synthetic */ void a(Context context, SdkErrorBean sdkErrorBean, View view) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.j() == null) {
            r0.a(context, true);
        } else {
            me.jessyan.art.d.f.a().a(sdkErrorBean, "submitFeebV2");
        }
    }

    private static void a(final Context context, final SdkErrorBean sdkErrorBean, int i2, int i3) {
        com.amgcyo.cuttadon.utils.otherutils.g.n(i3 + 1);
        String str = "请下载并安装官方正版App！！！\n如果下载并覆盖安装后还有问题，请反馈给客服！\n错误码：" + i2;
        boolean z2 = i3 <= 2;
        if (z2) {
            str = "请下载并安装官方正版App！！！\n错误码：" + i2;
        }
        a(context, z2, str, new View.OnClickListener() { // from class: com.amgcyo.cuttadon.f.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.c(context, view);
            }
        }, new View.OnClickListener() { // from class: com.amgcyo.cuttadon.f.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.b(context, sdkErrorBean, view);
            }
        });
    }

    public static void a(final Context context) {
        final String strC0 = com.amgcyo.cuttadon.utils.otherutils.h.C0();
        if (!TextUtils.isEmpty(strC0) && context != null) {
            a(context, "提示", "未检测到最新版本，是否访问APP官网下载最新版？", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.f.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o.a(context, strC0, view);
                }
            }, (View.OnClickListener) null);
        } else {
            l.b.a.j.a((CharSequence) "当前已是最新版！");
        }
    }

    static /* synthetic */ void a(Context context, String str, View view) {
        a(context, str, R.string.website_copy_suc);
        com.amgcyo.cuttadon.view.webview.b.startActivity(context, str);
    }

    public static void a(Context context, int i2, String str) {
        if (i2 == 1) {
            r0.a(context, str);
        } else if (i2 == 2) {
            Toast.makeText(context, "正在使用系统浏览器打开", 0).show();
            com.amgcyo.cuttadon.view.webview.b.startActivity(context, str);
        }
    }

    public static String a() {
        return com.amgcyo.cuttadon.utils.otherutils.h.u() == 0 ? "免广告" : "免章节";
    }

    public static String a(String str) {
        return String.format(Locale.getDefault(), d(R.string.fission6_time_end), t0.c(y.f(str)));
    }
}
