package com.amgcyo.cuttadon.activity.read;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.internal.Utils;
import com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity_ViewBinding;
import com.amgcyo.cuttadon.view.otherview.BatteryView;
import com.amgcyo.cuttadon.view.otherview.DarkFrameLayout;
import com.amgcyo.cuttadon.view.otherview.PercentageRing;
import com.amgcyo.cuttadon.view.otherview.RoundRelativeLayout;
import com.amgcyo.cuttadon.view.readermenu.ReaderNewPanel;
import com.fatcatfat.io.R;
import com.gongwen.marqueen.XMarqueeView;

/* JADX INFO: loaded from: classes.dex */
public class MkNovelBaseReaderActivity_ViewBinding extends MyRewardBaseAdActivity_ViewBinding {
    private MkNovelBaseReaderActivity b;

    @UiThread
    public MkNovelBaseReaderActivity_ViewBinding(MkNovelBaseReaderActivity mkNovelBaseReaderActivity, View view) {
        super(mkNovelBaseReaderActivity, view);
        this.b = mkNovelBaseReaderActivity;
        mkNovelBaseReaderActivity.layoutBookView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout_bookview, "field 'layoutBookView'", LinearLayout.class);
        mkNovelBaseReaderActivity.layout_root = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.layout_root, "field 'layout_root'", RelativeLayout.class);
        mkNovelBaseReaderActivity.readerNewPanel = (ReaderNewPanel) Utils.findRequiredViewAsType(view, R.id.readerNewPanel, "field 'readerNewPanel'", ReaderNewPanel.class);
        mkNovelBaseReaderActivity.view_time = (TextView) Utils.findRequiredViewAsType(view, R.id.view_time, "field 'view_time'", TextView.class);
        mkNovelBaseReaderActivity.horizontalBattery = (BatteryView) Utils.findRequiredViewAsType(view, R.id.horizontalBattery, "field 'horizontalBattery'", BatteryView.class);
        mkNovelBaseReaderActivity.read_count = (TextView) Utils.findRequiredViewAsType(view, R.id.read_count, "field 'read_count'", TextView.class);
        mkNovelBaseReaderActivity.tv_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_msg, "field 'tv_msg'", TextView.class);
        mkNovelBaseReaderActivity.tv_tips = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tips, "field 'tv_tips'", TextView.class);
        mkNovelBaseReaderActivity.rrl_fiision5 = (RoundRelativeLayout) Utils.findRequiredViewAsType(view, R.id.rrl_fiision5, "field 'rrl_fiision5'", RoundRelativeLayout.class);
        mkNovelBaseReaderActivity.iv_read_jb = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_read_jb, "field 'iv_read_jb'", ImageView.class);
        mkNovelBaseReaderActivity.progress_circular = Utils.findRequiredView(view, R.id.progress_circular, "field 'progress_circular'");
        mkNovelBaseReaderActivity.tagView = (XMarqueeView) Utils.findRequiredViewAsType(view, R.id.tagView, "field 'tagView'", XMarqueeView.class);
        mkNovelBaseReaderActivity.circle_progress_bar = (PercentageRing) Utils.findRequiredViewAsType(view, R.id.circle_progress_bar, "field 'circle_progress_bar'", PercentageRing.class);
        mkNovelBaseReaderActivity.ll_coin_tips = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_coin_tips, "field 'll_coin_tips'", LinearLayout.class);
        mkNovelBaseReaderActivity.app_des = (TextView) Utils.findRequiredViewAsType(view, R.id.app_des, "field 'app_des'", TextView.class);
        mkNovelBaseReaderActivity.chapter_page = (TextView) Utils.findRequiredViewAsType(view, R.id.chapter_page, "field 'chapter_page'", TextView.class);
        mkNovelBaseReaderActivity.chapter_name = (TextView) Utils.findRequiredViewAsType(view, R.id.chapter_name, "field 'chapter_name'", TextView.class);
        mkNovelBaseReaderActivity.rl_top_bar = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_top_bar, "field 'rl_top_bar'", RelativeLayout.class);
        mkNovelBaseReaderActivity.ll_bottom = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.ll_bottom, "field 'll_bottom'", RelativeLayout.class);
        mkNovelBaseReaderActivity.chapterBottomAdView = (DarkFrameLayout) Utils.findRequiredViewAsType(view, R.id.ad_bottom, "field 'chapterBottomAdView'", DarkFrameLayout.class);
        mkNovelBaseReaderActivity.chapterEndAdView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.ad_end, "field 'chapterEndAdView'", FrameLayout.class);
        mkNovelBaseReaderActivity.chapterContentAdView = (DarkFrameLayout) Utils.findRequiredViewAsType(view, R.id.zx_ad_page_content, "field 'chapterContentAdView'", DarkFrameLayout.class);
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.MyRewardBaseAdActivity_ViewBinding, butterknife.Unbinder
    public void unbind() {
        MkNovelBaseReaderActivity mkNovelBaseReaderActivity = this.b;
        if (mkNovelBaseReaderActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        mkNovelBaseReaderActivity.layoutBookView = null;
        mkNovelBaseReaderActivity.layout_root = null;
        mkNovelBaseReaderActivity.readerNewPanel = null;
        mkNovelBaseReaderActivity.view_time = null;
        mkNovelBaseReaderActivity.horizontalBattery = null;
        mkNovelBaseReaderActivity.read_count = null;
        mkNovelBaseReaderActivity.tv_msg = null;
        mkNovelBaseReaderActivity.tv_tips = null;
        mkNovelBaseReaderActivity.rrl_fiision5 = null;
        mkNovelBaseReaderActivity.iv_read_jb = null;
        mkNovelBaseReaderActivity.progress_circular = null;
        mkNovelBaseReaderActivity.tagView = null;
        mkNovelBaseReaderActivity.circle_progress_bar = null;
        mkNovelBaseReaderActivity.ll_coin_tips = null;
        mkNovelBaseReaderActivity.app_des = null;
        mkNovelBaseReaderActivity.chapter_page = null;
        mkNovelBaseReaderActivity.chapter_name = null;
        mkNovelBaseReaderActivity.rl_top_bar = null;
        mkNovelBaseReaderActivity.ll_bottom = null;
        mkNovelBaseReaderActivity.chapterBottomAdView = null;
        mkNovelBaseReaderActivity.chapterEndAdView = null;
        mkNovelBaseReaderActivity.chapterContentAdView = null;
        super.unbind();
    }
}
