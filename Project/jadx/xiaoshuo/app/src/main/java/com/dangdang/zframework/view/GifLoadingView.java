package com.dangdang.zframework.view;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dangdang.zframework.log.LogM;
import com.youth.banner.config.BannerConfig;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/* JADX INFO: loaded from: classes10.dex */
public class GifLoadingView extends LoadingView {
    private GifDrawable mGifDrawable;
    private int mGifRawId;
    private GifImageView mGifView;

    public GifLoadingView(Context context) {
        super(context);
        this.mGifRawId = -1;
    }

    public GifDrawable getGifDrawable() {
        return this.mGifDrawable;
    }

    public GifImageView getGifView() {
        return this.mGifView;
    }

    public int getGifViewSrc() {
        return this.mGifRawId;
    }

    public TextView getMessageTv() {
        return this.mMessageTV;
    }

    @Override // com.dangdang.zframework.view.LoadingView
    public void init(Context context) {
        this.mLoadingView = new RelativeLayout(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        View gifImageView = new GifImageView(context);
        this.mGifView = gifImageView;
        linearLayout.addView(gifImageView, layoutParams);
        TextView textView = new TextView(context);
        this.mMessageTV = textView;
        linearLayout.addView(textView, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        ((ViewGroup) this.mLoadingView).addView(linearLayout, layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.mLoadingView.getLayoutParams();
        if (layoutParams3 != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            layoutParams3.width = displayMetrics.widthPixels;
            layoutParams3.height = displayMetrics.heightPixels;
            this.mLoadingView.setLayoutParams(layoutParams3);
        }
        this.mLoadingView.setBackgroundColor(BannerConfig.INDICATOR_SELECTED_COLOR);
        this.mLoadingView.setClickable(true);
    }

    @Override // com.dangdang.zframework.view.LoadingView
    public void reset() {
        try {
            GifDrawable gifDrawable = this.mGifDrawable;
            if (gifDrawable != null) {
                gifDrawable.recycle();
                this.mGifDrawable = null;
            }
            this.mGifView.destroyDrawingCache();
        } catch (Exception unused) {
        }
    }

    public void setGifViewSrc(int i) {
        try {
            GifDrawable gifDrawable = this.mGifDrawable;
            if (gifDrawable != null) {
                gifDrawable.recycle();
                this.mGifDrawable = null;
            }
            GifDrawable gifDrawable2 = new GifDrawable(this.mContext.getResources(), i);
            this.mGifDrawable = gifDrawable2;
            this.mGifView.setImageDrawable(gifDrawable2);
            this.mGifRawId = i;
        } catch (Exception e) {
            LogM.e(e.toString());
        } catch (OutOfMemoryError e2) {
            LogM.e(e2.toString());
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mGifView.setOnClickListener(onClickListener);
        this.mMessageTV.setOnClickListener(onClickListener);
    }

    public void startGif() {
        try {
            GifDrawable gifDrawable = this.mGifDrawable;
            if (gifDrawable != null) {
                gifDrawable.start();
            }
        } catch (Exception e) {
            LogM.e(e.toString());
        } catch (OutOfMemoryError e2) {
            LogM.e(e2.toString());
        }
    }

    public void stopGif() {
        try {
            GifDrawable gifDrawable = this.mGifDrawable;
            if (gifDrawable != null) {
                gifDrawable.stop();
            }
        } catch (Exception e) {
            LogM.e(e.toString());
        } catch (OutOfMemoryError e2) {
            LogM.e(e2.toString());
        }
    }
}
