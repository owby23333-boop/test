package com.amgcyo.cuttadon.fragment.books;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.activity.feedback.MkFeedBackActivity;
import com.amgcyo.cuttadon.activity.fission6.Fission6FeedbackActivity;
import com.amgcyo.cuttadon.api.entity.other.MkAppVersion;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.presenter.ConfigPresenter;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.fatcatfat.io.R;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkFeedbackFragment extends com.amgcyo.cuttadon.fragment.base.a<UserPresenter> {
    private String G;
    private int H = TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO;
    private String I = "";

    @BindView(R.id.et_input)
    EditText etInput;

    @BindView(R.id.et_num)
    EditText etNum;

    @BindView(R.id.spinner)
    Spinner spinner;

    @BindView(R.id.tv_submit)
    TextView tvSubmit;

    @BindView(R.id.tv_textNum)
    TextView tvTextNum;

    class a implements AdapterView.OnItemSelectedListener {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ List f3764s;

        a(List list) {
            this.f3764s = list;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            MkFeedbackFragment.this.G = (String) this.f3764s.get(i2);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            MkFeedbackFragment.this.tvTextNum.setText(String.format(Locale.getDefault(), "%d/%d", Integer.valueOf(MkFeedbackFragment.this.etInput.length()), Integer.valueOf(MkFeedbackFragment.this.H)));
            if (MkFeedbackFragment.this.etInput.length() <= MkFeedbackFragment.this.H) {
                MkFeedbackFragment.this.tvTextNum.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.text_bottom_comment));
                return;
            }
            MkFeedbackFragment.this.tvTextNum.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.dot_hong));
            MkFeedbackFragment.this.etInput.setText(editable.toString().substring(0, MkFeedbackFragment.this.H));
            MkFeedbackFragment mkFeedbackFragment = MkFeedbackFragment.this;
            mkFeedbackFragment.etInput.setSelection(mkFeedbackFragment.H);
            com.amgcyo.cuttadon.f.o.b("您最多能输入" + MkFeedbackFragment.this.H + "个字");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    private void l() {
        new ConfigPresenter(me.jessyan.art.f.e.a(this.f3725t)).d(Message.a(this, new Object[0]));
    }

    private void m() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("请选择");
        arrayList.add("微信");
        arrayList.add("QQ");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.f3725t, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        this.spinner.setSelection(0);
        this.spinner.setOnItemSelectedListener(new a(arrayList));
    }

    @Override // me.jessyan.art.base.f.i
    public int a() {
        return R.layout.fragment_feedback;
    }

    public /* synthetic */ void b(MkAppVersion mkAppVersion, View view) {
        Context context = this.f3725t;
        if (context instanceof BaseTitleBarActivity) {
            ((BaseTitleBarActivity) context).checkUpdate(mkAppVersion);
        }
    }

    @Override // com.amgcyo.cuttadon.fragment.base.a, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        final MkAppVersion mkAppVersion;
        super.handleMessage(message);
        Context context = this.f3725t;
        if (context instanceof BaseTitleBarActivity) {
            ((BaseTitleBarActivity) context).hideLoading();
        }
        TextView textView = this.tvSubmit;
        if (textView != null) {
            textView.setEnabled(true);
        }
        EditText editText = this.etInput;
        if (editText != null) {
            editText.setText("");
        }
        EditText editText2 = this.etNum;
        if (editText2 != null) {
            editText2.setText("");
        }
        int i2 = message.f21197s;
        if (i2 == 825 || i2 == 1020) {
            com.amgcyo.cuttadon.utils.otherutils.g0.a().b("feedback_content", "");
            FragmentActivity activity = getActivity();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            if (activity instanceof MkFeedBackActivity) {
                ((MkFeedBackActivity) activity).selectedHistoryFragment();
            }
            if (activity instanceof Fission6FeedbackActivity) {
                activity.finish();
                return;
            }
            return;
        }
        if (i2 != 851 || (mkAppVersion = (MkAppVersion) message.f21202x) == null || this.f3725t == null) {
            return;
        }
        ArrayList<Integer> version_data = mkAppVersion.getVersion_data();
        if (!com.amgcyo.cuttadon.utils.otherutils.g.a((List<?>) version_data) && com.amgcyo.cuttadon.utils.otherutils.g.a(version_data)) {
            com.amgcyo.cuttadon.view.dialog.b1 b1Var = new com.amgcyo.cuttadon.view.dialog.b1(this.f3725t);
            b1Var.a(new com.amgcyo.cuttadon.g.f() { // from class: com.amgcyo.cuttadon.fragment.books.d0
                @Override // com.amgcyo.cuttadon.g.f
                public final void a() {
                    this.a.a(mkAppVersion);
                }
            });
            b1Var.show();
            b1Var.a(String.format(com.amgcyo.cuttadon.f.o.d(R.string.string_enable), "5.0.2", com.amgcyo.cuttadon.utils.otherutils.h.C0()));
            return;
        }
        if (mkAppVersion.getVersion() > 502) {
            String str = "系统检测到新版本" + mkAppVersion.getVersion_name() + "，当前版本过低，你遇到的问题可能已经修复，请升级到新版本后查看问题是否解决！是否升级？";
            if (mkAppVersion.getUpdate_state() == 0) {
                com.amgcyo.cuttadon.f.o.a(this.f3725t, "升级到新版本", "继续反馈", "更新提醒", str, new View.OnClickListener() { // from class: com.amgcyo.cuttadon.fragment.books.f0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f3811s.a(mkAppVersion, view);
                    }
                }, (View.OnClickListener) null);
            } else {
                com.amgcyo.cuttadon.f.o.a(this.f3725t, "确定", true, (CharSequence) "更新提醒", (CharSequence) str, new View.OnClickListener() { // from class: com.amgcyo.cuttadon.fragment.books.e0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f3808s.b(mkAppVersion, view);
                    }
                });
            }
        }
    }

    @Override // me.jessyan.art.base.f.i
    public void initData(@Nullable Bundle bundle) {
        this.tvTextNum.setText(String.format(Locale.getDefault(), "0/%d", Integer.valueOf(this.H)));
        this.etInput.addTextChangedListener(new b());
        String strA = com.amgcyo.cuttadon.utils.otherutils.g0.a().a("feedback_content", "");
        if (!TextUtils.isEmpty(strA)) {
            this.etInput.setText(strA);
        }
        m();
        l();
    }

    @OnClick({R.id.tv_submit})
    public void onClick(View view) {
        if (com.amgcyo.cuttadon.fragment.base.a.n()) {
            com.amgcyo.cuttadon.f.o.d(R.string.operating_busy);
            return;
        }
        if (view.getId() == R.id.tv_submit) {
            String strTrim = this.etInput.getText().toString().trim();
            String strTrim2 = this.etNum.getText().toString().trim();
            MkUser mkUserJ = com.amgcyo.cuttadon.utils.otherutils.g.j();
            if (mkUserJ == null) {
                if (!TextUtils.isEmpty(strTrim)) {
                    com.amgcyo.cuttadon.utils.otherutils.g0.a().b("feedback_content", strTrim);
                }
                showMessage("请先登录");
                return;
            }
            if (TextUtils.isEmpty(strTrim) || TextUtils.isEmpty(strTrim2)) {
                showMessage("请输入必要信息");
                return;
            }
            if (this.spinner.getSelectedItemPosition() <= 0) {
                showMessage("请选择联系方式");
                this.spinner.performClick();
                return;
            }
            String str = this.G + " ：" + strTrim2;
            Context context = this.f3725t;
            if (context instanceof BaseTitleBarActivity) {
                ((BaseTitleBarActivity) context).showLoading();
            }
            com.amgcyo.cuttadon.i.n.a(mkUserJ);
            String str2 = "otherData:" + this.I;
            if (TextUtils.isEmpty(this.I)) {
                ((UserPresenter) this.f3726u).L(Message.a(this, new Object[]{strTrim, str}));
            } else {
                ((UserPresenter) this.f3726u).M(Message.a(this, new Object[]{strTrim, str, this.I}));
            }
            TextView textView = this.tvSubmit;
            if (textView != null) {
                textView.setEnabled(false);
            }
        }
    }

    @Override // me.jessyan.art.base.f.i
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this.f3725t));
    }

    public /* synthetic */ void a(MkAppVersion mkAppVersion) {
        String download_url = mkAppVersion.getDownload_url();
        if (TextUtils.isEmpty(download_url)) {
            download_url = com.amgcyo.cuttadon.utils.otherutils.h.C0();
            Toast.makeText(this.f3725t, "请在App官网下载", 0).show();
        } else {
            Toast.makeText(this.f3725t, "正在通过系统浏览器下载", 0).show();
        }
        com.amgcyo.cuttadon.view.webview.b.startActivity(this.f3725t, download_url);
    }

    public /* synthetic */ void a(MkAppVersion mkAppVersion, View view) {
        Context context = this.f3725t;
        if (context instanceof BaseTitleBarActivity) {
            ((BaseTitleBarActivity) context).checkUpdate(mkAppVersion);
        }
    }

    public void a(@Nullable Object obj) {
        if (obj instanceof String) {
            this.I = (String) obj;
            String str = "otherData:" + this.I;
        }
    }
}
