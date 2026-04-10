package com.bytedance.sdk.openadsdk.res.layout.video;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* JADX INFO: loaded from: classes2.dex */
public class LayoutVideoDetail extends RelativeLayout {
    public LayoutVideoDetail(Context context) {
        super(context);
        z(context);
    }

    private void z(Context context) {
        setId(2114387714);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        setBackgroundColor(-1);
        addView(g(context));
        addView(new a().g(context));
        addView(dl(context));
        addView(a(context));
        addView(gc(context));
        addView(m(context));
        addView(e(context));
        addView(gz(context));
        TTViewStub tTViewStub = new TTViewStub(context, new m());
        tTViewStub.setId(2114387744);
        tTViewStub.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(tTViewStub);
        TTViewStub tTViewStub2 = new TTViewStub(context, new g());
        tTViewStub2.setId(2114387666);
        tTViewStub2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(tTViewStub2);
        addView(fo(context));
    }

    private View g(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387900);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setGravity(17);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387651);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        tTProgressBar.setId(2114387631);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(oq.dl(context, 60.0f), oq.dl(context, 60.0f));
        layoutParams.addRule(13);
        tTProgressBar.setLayoutParams(layoutParams);
        tTProgressBar.setIndeterminateDrawable(tb.dl(context, "tt_video_loading_progress_bar"));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387823);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setVisibility(8);
        ImageView imageView2 = new ImageView(context);
        imageView2.setId(2114387618);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        tb.z(context, "tt_refreshing_video_textpage", imageView2);
        TextView textView = new TextView(context);
        textView.setId(2114387860);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(tb.z(context, "tt_video_retry_des_txt"));
        textView.setTextColor(tb.uy(context, "tt_heise3"));
        linearLayout.addView(imageView2);
        linearLayout.addView(textView);
        relativeLayout.addView(imageView);
        relativeLayout.addView(tTProgressBar);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    private View dl(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387626);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        tb.z(context, "tt_play_movebar_textpage", imageView);
        imageView.setVisibility(8);
        return imageView;
    }

    private View a(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387678);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#26000000"));
        gradientDrawable.setCornerRadius(oq.dl(context, 4.0f));
        imageView.setBackground(gradientDrawable);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        int color = Color.parseColor("#959595");
        com.bytedance.sdk.openadsdk.res.z zVar = new com.bytedance.sdk.openadsdk.res.z(48);
        zVar.z(color);
        float fDl = oq.dl(context, 2.0f);
        zVar.z(fDl);
        int color2 = Color.parseColor("#FFFFFF");
        com.bytedance.sdk.openadsdk.res.z zVar2 = new com.bytedance.sdk.openadsdk.res.z(48);
        zVar2.z(color2);
        zVar2.z(fDl);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, zVar);
        stateListDrawable.addState(new int[0], zVar2);
        imageView.setImageDrawable(stateListDrawable);
        int iDl = oq.dl(context, 30.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDl, iDl);
        layoutParams.addRule(21);
        layoutParams.addRule(11);
        int iDl2 = oq.dl(context, 7.0f);
        layoutParams.setMargins(0, iDl2, iDl2, 0);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    private View gc(Context context) {
        TextView textView = new TextView(context);
        textView.setId(2114387730);
        textView.setGravity(8388659);
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine(false);
        textView.setTextSize(2, 17.0f);
        textView.setTextColor(-1);
        textView.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
        textView.setBackground(gradientDrawable);
        int iDl = oq.dl(context, 15.0f);
        textView.setPadding(iDl, oq.dl(context, 14.0f), iDl, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(20);
        layoutParams.addRule(10);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private View m(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387605);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setGravity(16);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387897);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.leftMargin = oq.dl(context, 12.0f);
        imageView.setLayoutParams(layoutParams2);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        int color = Color.parseColor("#959595");
        com.bytedance.sdk.openadsdk.res.z zVar = new com.bytedance.sdk.openadsdk.res.z(48);
        zVar.z(color);
        float fDl = oq.dl(context, 2.0f);
        zVar.z(fDl);
        int color2 = Color.parseColor("#FFFFFF");
        com.bytedance.sdk.openadsdk.res.z zVar2 = new com.bytedance.sdk.openadsdk.res.z(48);
        zVar2.z(color2);
        zVar2.z(fDl);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, zVar);
        stateListDrawable.addState(new int[0], zVar2);
        imageView.setImageDrawable(stateListDrawable);
        relativeLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setId(2114387706);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        textView.setGravity(16);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine(true);
        textView.setTextSize(2, 17.0f);
        textView.setTextColor(-1);
        int iDl = oq.dl(context, 15.0f);
        textView.setPadding(iDl, 0, iDl, 0);
        relativeLayout.addView(textView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387797);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(iDl, 0, iDl, 0);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387846);
        textView2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView2.setGravity(17);
        textView2.setMaxLines(1);
        textView2.setSingleLine(true);
        textView2.setTextSize(2, 12.0f);
        textView2.setTextColor(-1);
        linearLayout.addView(textView2);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    private View e(Context context) {
        TTProgressBar tTProgressBar = new TTProgressBar(context, null, tb.gz(context, "tt_Widget_ProgressBar_Horizontal"));
        tTProgressBar.setId(2114387653);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, oq.dl(context, 1.5f));
        layoutParams.addRule(12);
        tTProgressBar.setLayoutParams(layoutParams);
        tTProgressBar.setBackground(null);
        tTProgressBar.setMax(100);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#A5FFFFFF"));
        float fDl = oq.dl(context, 1.0f);
        gradientDrawable.setCornerRadius(fDl);
        int iDl = oq.dl(context, 2.0f);
        gradientDrawable.setSize(-1, iDl);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFFFF"));
        gradientDrawable2.setCornerRadius(fDl);
        gradientDrawable2.setSize(-1, iDl);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFF85959"));
        gradientDrawable3.setCornerRadius(fDl);
        gradientDrawable3.setSize(-1, iDl);
        com.bytedance.sdk.openadsdk.res.m.z(tTProgressBar, new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        tTProgressBar.setVisibility(8);
        return tTProgressBar;
    }

    private View gz(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387628);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, oq.dl(context, 40.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setVisibility(8);
        TextView textView = new TextView(context);
        textView.setId(2114387811);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(oq.dl(context, 16.0f), 0, oq.dl(context, 12.0f), 0);
        textView.setLayoutParams(layoutParams2);
        textView.setText("00:00");
        textView.setTextColor(-1);
        textView.setTextSize(2, 10.0f);
        linearLayout.addView(textView);
        SeekBar seekBar = new SeekBar(context);
        seekBar.setId(2114387872);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams3.gravity = 16;
        seekBar.setLayoutParams(layoutParams3);
        seekBar.setBackground(null);
        seekBar.setMax(100);
        if (Build.VERSION.SDK_INT >= 29) {
            seekBar.setMaxHeight(oq.dl(context, 4.0f));
            seekBar.setMinHeight(oq.dl(context, 4.0f));
        } else {
            layoutParams3.height = oq.dl(context, 4.0f);
        }
        seekBar.setPadding(0, 0, 0, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#A5FFFFFF"));
        float fDl = oq.dl(context, 1.0f);
        gradientDrawable.setCornerRadius(fDl);
        int iDl = oq.dl(context, 2.0f);
        gradientDrawable.setSize(-1, iDl);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFFFF"));
        gradientDrawable2.setCornerRadius(fDl);
        gradientDrawable2.setSize(-1, iDl);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFF85959"));
        gradientDrawable3.setCornerRadius(fDl);
        gradientDrawable3.setSize(-1, iDl);
        seekBar.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(Color.parseColor("#FFFFFFFF"));
        int iDl2 = oq.dl(context, 15.0f);
        shapeDrawable.setIntrinsicWidth(iDl2);
        shapeDrawable.setIntrinsicHeight(iDl2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(oq.dl(context, 1.0f));
        paint.setColor(Color.parseColor("#1E000000"));
        seekBar.setThumb(shapeDrawable);
        seekBar.setThumbOffset(0);
        linearLayout.addView(seekBar);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387668);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.setMargins(oq.dl(context, 12.0f), 0, oq.dl(context, 16.0f), 0);
        textView2.setLayoutParams(layoutParams4);
        textView2.setText("00:00");
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 10.0f);
        linearLayout.addView(textView2);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387661);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams5.setMargins(oq.dl(context, 16.0f), 0, oq.dl(context, 16.0f), 0);
        imageView.setLayoutParams(layoutParams5);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setVisibility(8);
        tb.z(context, "tt_enlarge_video", imageView);
        linearLayout.addView(imageView);
        return linearLayout;
    }

    private View fo(Context context) {
        TextView textView = new TextView(context);
        textView.setId(2114387759);
        textView.setBackgroundColor(0);
        textView.setMinHeight(oq.dl(context, 44.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = oq.dl(context, 12.0f);
        textView.setLayoutParams(layoutParams);
        textView.setCompoundDrawablesWithIntrinsicBounds(uy(context), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(uy(context), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setText("关闭");
        return textView;
    }

    private StateListDrawable uy(Context context) {
        int color = Color.parseColor("#959595");
        com.bytedance.sdk.openadsdk.res.z zVar = new com.bytedance.sdk.openadsdk.res.z(48);
        zVar.z(color);
        float fDl = oq.dl(context, 2.0f);
        zVar.z(fDl);
        int color2 = Color.parseColor("#FFFFFF");
        com.bytedance.sdk.openadsdk.res.z zVar2 = new com.bytedance.sdk.openadsdk.res.z(48);
        zVar2.z(color2);
        zVar2.z(fDl);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, zVar);
        stateListDrawable.addState(new int[0], zVar2);
        return stateListDrawable;
    }
}
