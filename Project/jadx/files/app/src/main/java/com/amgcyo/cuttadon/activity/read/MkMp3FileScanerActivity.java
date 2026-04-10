package com.amgcyo.cuttadon.activity.read;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.LocalMp3Bean;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.j.itemdecoration.a;
import com.amgcyo.cuttadon.view.otherview.CustomTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fatcatfat.io.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class MkMp3FileScanerActivity extends BaseRefreshMoreRecyclerActivity<UserPresenter> implements BaseQuickAdapter.g {

    @BindView(R.id.iv_search)
    ImageView iv_search;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    List<LocalMp3Bean> f2692r0 = new ArrayList();

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private String f2693s0;

    @BindView(R.id.searchHolder)
    SearchView searchHolder;

    @BindView(R.id.toolbar_title)
    CustomTextView toolbar_title;

    class a implements SearchView.OnQueryTextListener {
        a() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            MkMp3FileScanerActivity.this.afterTextChanged(str);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            MkMp3FileScanerActivity.this.afterTextChanged(str);
            return false;
        }
    }

    class b extends com.amgcyo.cuttadon.j.g.h.b<Object> {
        b(Object obj) {
            super(obj);
        }

        @Override // com.amgcyo.cuttadon.j.g.g.a
        public Void a(Object obj) {
            try {
                try {
                    MkMp3FileScanerActivity.this.getMusicForMediaStore();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return null;
            } finally {
                MkMp3FileScanerActivity.this.s();
            }
        }
    }

    class c implements Comparator {
        c(MkMp3FileScanerActivity mkMp3FileScanerActivity) {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((LocalMp3Bean) obj).getName().compareTo(((LocalMp3Bean) obj2).getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        runOnUiThread(new Runnable() { // from class: com.amgcyo.cuttadon.activity.read.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f2745s.r();
            }
        });
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public void afterTextChanged(String str) {
        List<LocalMp3Bean> list = this.f2692r0;
        if (list == null || list.size() <= 0 || this.f2256n0 == null) {
            return;
        }
        if (str.equals("")) {
            ((com.amgcyo.cuttadon.b.c.v) this.f2256n0).a((List) this.f2692r0);
            this.f2256n0.notifyDataSetChanged();
        } else {
            ((com.amgcyo.cuttadon.b.c.v) this.f2256n0).a((List) matcherSearch(str.replace("+", ""), this.f2692r0));
            this.f2256n0.notifyDataSetChanged();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "";
    }

    public /* synthetic */ void e(View view) {
        this.searchHolder.setVisibility(0);
        this.searchHolder.setIconified(false);
        this.searchHolder.setQueryHint("输入搜索关键字");
        this.toolbar_title.setVisibility(8);
        this.iv_search.setVisibility(8);
    }

    public void getMusicForMediaStore() {
        Cursor cursorQuery = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, "mime_type=?", new String[]{MimeTypeMap.getSingleton().getMimeTypeFromExtension("mp3")}, "title_key");
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            return;
        }
        while (!cursorQuery.isAfterLast()) {
            cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_id"));
            String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
            cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("artist"));
            File file = new File(string);
            if (file.exists()) {
                this.f2692r0.add(new LocalMp3Bean(file.getName(), file.getAbsolutePath()));
            }
            cursorQuery.moveToNext();
        }
        cursorQuery.close();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        this.L = com.amgcyo.cuttadon.widget.ui.b.b().a(this.mRefreshView).a(new Runnable() { // from class: com.amgcyo.cuttadon.activity.read.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f2743s.j();
            }
        });
        this.f2693s0 = com.amgcyo.cuttadon.utils.otherutils.g0.a().d("tts_mp3_path");
        this.toolbar_title.setText("本机mp3文件");
        this.iv_search.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.read.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2740s.e(view);
            }
        });
        this.searchHolder.setOnCloseListener(new SearchView.OnCloseListener() { // from class: com.amgcyo.cuttadon.activity.read.e
            @Override // androidx.appcompat.widget.SearchView.OnCloseListener
            public final boolean onClose() {
                return this.a.q();
            }
        });
        this.searchHolder.setOnQueryTextListener(new a());
        a.b bVar = new a.b(this.f2277w);
        bVar.c(R.dimen.dimen1dp);
        bVar.e(R.dimen.dimen1dp);
        bVar.b(R.color.FBFBFB);
        bVar.d(R.dimen.dimen15dp);
        bVar.f(R.dimen.dimen15dp);
        this.recyclerView.addItemDecoration(bVar.a());
        if (Environment.getExternalStorageState().equals("mounted")) {
            com.amgcyo.cuttadon.j.g.b.a(new b(""));
        } else {
            showMessage("没有SD卡");
            finish();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_bgm_scaner;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    public void loadData() {
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return false;
    }

    public List<LocalMp3Bean> matcherSearch(String str, List<LocalMp3Bean> list) {
        ArrayList arrayList = new ArrayList();
        Pattern patternCompile = Pattern.compile(Pattern.quote(str), 2);
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (patternCompile.matcher(list.get(i2).getName()).find()) {
                arrayList.add(list.get(i2));
            }
        }
        return arrayList;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.g
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2692r0)) {
            return;
        }
        try {
            LocalMp3Bean localMp3Bean = (LocalMp3Bean) ((com.amgcyo.cuttadon.b.c.v) this.f2256n0).getData().get(i2);
            if (localMp3Bean == null) {
                return;
            }
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            bundle.putSerializable("LocalMp3Bean", localMp3Bean);
            intent.putExtras(bundle);
            setResult(836, intent);
            finish();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity
    protected boolean p() {
        return false;
    }

    public /* synthetic */ boolean q() {
        this.searchHolder.setVisibility(8);
        this.toolbar_title.setVisibility(0);
        this.iv_search.setVisibility(0);
        return false;
    }

    public /* synthetic */ void r() {
        c(false);
        d(false);
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(this.f2692r0)) {
            showEmpty();
            return;
        }
        Iterator<LocalMp3Bean> it = this.f2692r0.iterator();
        while (it.hasNext()) {
            it.next().setItemType(2);
        }
        Collections.sort(this.f2692r0, new c(this));
        this.f2256n0 = new com.amgcyo.cuttadon.b.c.v(this.f2692r0, this.f2693s0);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.f2256n0);
        }
        this.f2256n0.a((BaseQuickAdapter.g) this);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseRefreshMoreRecyclerActivity, me.jessyan.art.base.f.h
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this));
    }
}
