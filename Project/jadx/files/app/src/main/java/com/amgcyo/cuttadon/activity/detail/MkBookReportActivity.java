package com.amgcyo.cuttadon.activity.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.view.comic.TagCloudView;
import com.fatcatfat.io.R;
import java.util.ArrayList;
import java.util.List;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkBookReportActivity extends BaseTitleBarActivity<UserPresenter> {

    @BindView(R.id.book_author)
    TextView book_author;

    @BindView(R.id.book_cover_iv)
    ImageView book_cover_iv;

    @BindView(R.id.book_name)
    TextView book_name;

    @BindView(R.id.edit_reason)
    EditText edit_reason;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private int f2465n0 = 7;

    @BindView(R.id.tcv_tag)
    TagCloudView tcv_tag;

    @BindView(R.id.tv_submit)
    TextView tv_submit;

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public /* synthetic */ void a(List list, int i2) {
        this.f2465n0 = i2 + 1;
        int i3 = 0;
        while (i3 < list.size()) {
            this.tcv_tag.getChildAt(i3).setSelected(i2 == i3);
            i3++;
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "不良信息举报";
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        if (message.f21197s == 892) {
            finish();
        }
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        final MkBook mkBook = (MkBook) extras.getSerializable("book");
        if (mkBook == null) {
            finish();
            return;
        }
        this.G.a(this.f2277w, ImageConfigImpl.builder().imageRadius(8).placeholder(R.drawable.icon_pic_def).url(String.format("%s%s", com.amgcyo.cuttadon.utils.otherutils.g.e(mkBook.getForm()), mkBook.getImage())).form(mkBook.getForm()).imageView(this.book_cover_iv).build());
        this.book_name.setText(mkBook.getName());
        this.book_author.setText(mkBook.getAuthor());
        final ArrayList arrayList = new ArrayList();
        arrayList.add("色情低俗");
        arrayList.add("政治敏感");
        arrayList.add("血腥暴力");
        arrayList.add("欺诈广告");
        arrayList.add("抄袭侵权");
        arrayList.add("未成年不良信息");
        arrayList.add("其他，我要补充");
        this.tcv_tag.setTags(arrayList);
        this.tcv_tag.setOnTagClickListener(new TagCloudView.b() { // from class: com.amgcyo.cuttadon.activity.detail.k
            @Override // com.amgcyo.cuttadon.view.comic.TagCloudView.b
            public final void a(int i2) {
                this.a.a(arrayList, i2);
            }
        });
        this.tv_submit.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.detail.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2497s.a(mkBook, view);
            }
        });
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.ac_comic_feedback;
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
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this));
    }

    public /* synthetic */ void a(MkBook mkBook, View view) {
        ((UserPresenter) this.f2276v).s(Message.a(this, new Object[]{Integer.valueOf(mkBook.getBook_id()), "", this.edit_reason.getText().toString(), Integer.valueOf(mkBook.getForm()), Integer.valueOf(this.f2465n0)}));
    }
}
