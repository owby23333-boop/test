package com.amgcyo.cuttadon.activity.setting;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.fatcatfat.io.R;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class MkBigPicActivity extends BaseTitleBarActivity {

    @BindView(R.id.img_big)
    ImageView img_big;

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "查看大图";
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        String string = extras.getString("default_pic_url");
        if (TextUtils.isEmpty(string)) {
            showMessage("查看大图失败!");
            return;
        }
        if (!com.amgcyo.cuttadon.utils.otherutils.g.j(string) || string == null) {
            this.G.a(this.f2277w, ImageConfigImpl.builder().imageRadius(8).url(string).imageView(this.img_big).build());
            return;
        }
        byte[] bArrDecode = Base64.decode(string.split(",")[1], 0);
        this.img_big.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_big_pic;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public me.jessyan.art.mvp.c obtainPresenter() {
        return null;
    }
}
