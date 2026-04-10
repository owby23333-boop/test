package com.amgcyo.cuttadon.view.popupview;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.activity.comic.MkComicsBaseReaderActivity;
import com.amgcyo.cuttadon.utils.otherutils.g0;
import com.amgcyo.cuttadon.view.comic.DanmuColorSelectedView;
import com.fatcatfat.io.R;
import com.lxj.xpopup.core.BottomPopupView;

/* JADX INFO: loaded from: classes.dex */
public class SendDanmuBottomPopup extends BottomPopupView implements DanmuColorSelectedView.a, View.OnClickListener {
    private int O;
    private EditText P;
    private LinearLayout Q;
    private DanmuColorSelectedView R;
    private DanmuColorSelectedView S;
    private DanmuColorSelectedView T;
    private DanmuColorSelectedView U;
    private DanmuColorSelectedView V;
    private DanmuColorSelectedView W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private Context f5171a0;

    public SendDanmuBottomPopup(@NonNull Context context) {
        super(context);
        this.O = 1;
        this.f5171a0 = context;
    }

    private void b(int i2) {
        g0.a().b("danmu_color_index", i2);
        this.O = i2;
    }

    private void x() {
        this.R.setSelect(false);
        this.S.setSelect(false);
        this.T.setSelect(false);
        this.U.setSelect(false);
        this.V.setSelect(false);
        this.W.setSelect(false);
    }

    private void y() {
        LinearLayout linearLayout = this.Q;
        if (linearLayout == null) {
            return;
        }
        if (linearLayout.isShown()) {
            this.Q.setVisibility(8);
        } else {
            this.Q.setVisibility(0);
        }
    }

    @Override // com.amgcyo.cuttadon.view.comic.DanmuColorSelectedView.a
    public void a(DanmuColorSelectedView danmuColorSelectedView, boolean z2) {
        x();
        if (z2) {
            danmuColorSelectedView.setSelect(true);
            int id = danmuColorSelectedView.getId();
            if (id == R.id.danmu_blue) {
                b(6);
            }
            if (id == R.id.danmu_green) {
                b(5);
                return;
            }
            switch (id) {
                case R.id.danmu_orange /* 2131296888 */:
                    b(2);
                    break;
                case R.id.danmu_pink /* 2131296889 */:
                    b(3);
                    break;
                case R.id.danmu_white /* 2131296890 */:
                    b(1);
                    break;
                case R.id.danmu_yellow /* 2131296891 */:
                    b(4);
                    break;
            }
        }
    }

    public String getDanmuComment() {
        EditText editText = this.P;
        return editText == null ? "" : editText.getText().toString();
    }

    @Override // com.lxj.xpopup.core.BottomPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.menu_send_danmu_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        int id = view.getId();
        if (id == R.id.danmu_color_btn) {
            y();
        } else if (id == R.id.send_danmu && (context = this.f5171a0) != null && (context instanceof MkComicsBaseReaderActivity)) {
            ((MkComicsBaseReaderActivity) context).sendDanmuContent(getDanmuComment(), this.O);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void r() {
        super.r();
        this.O = g0.a().a("danmu_color_index", 1);
        ((ImageView) findViewById(R.id.danmu_color_btn)).setOnClickListener(this);
        this.P = (EditText) findViewById(R.id.danmu_edit);
        ((TextView) findViewById(R.id.send_danmu)).setOnClickListener(this);
        this.Q = (LinearLayout) findViewById(R.id.danmu_color_layout);
        this.R = (DanmuColorSelectedView) findViewById(R.id.danmu_white);
        this.S = (DanmuColorSelectedView) findViewById(R.id.danmu_orange);
        this.T = (DanmuColorSelectedView) findViewById(R.id.danmu_pink);
        this.U = (DanmuColorSelectedView) findViewById(R.id.danmu_yellow);
        this.V = (DanmuColorSelectedView) findViewById(R.id.danmu_green);
        this.W = (DanmuColorSelectedView) findViewById(R.id.danmu_blue);
        this.R.setListener(this);
        this.S.setListener(this);
        this.T.setListener(this);
        this.U.setListener(this);
        this.V.setListener(this);
        this.W.setListener(this);
        switch (this.O) {
            case 1:
                this.R.setSelect(true);
                break;
            case 2:
                this.S.setSelect(true);
                break;
            case 3:
                this.T.setSelect(true);
                break;
            case 4:
                this.U.setSelect(true);
                break;
            case 5:
                this.V.setSelect(true);
                break;
            case 6:
                this.W.setSelect(true);
                break;
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void s() {
        super.s();
        EditText editText = this.P;
        if (editText != null) {
            editText.setText("");
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void t() {
        super.t();
    }
}
