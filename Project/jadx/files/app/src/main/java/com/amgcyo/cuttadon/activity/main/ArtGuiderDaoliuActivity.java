package com.amgcyo.cuttadon.activity.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import butterknife.BindView;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.fatcatfat.io.R;
import java.util.regex.Pattern;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class ArtGuiderDaoliuActivity extends BaseTitleBarActivity {

    @BindView(R.id.btn_kown)
    TextView btn_kown;

    @BindView(R.id.iv_step)
    ImageView iv_step;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private String[] f2571n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private boolean f2572o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private CountDownTimer f2573p0;

    @BindView(R.id.tv_info)
    TextView tv_info;

    class a extends CountDownTimer {
        final /* synthetic */ String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j2, long j3, String str) {
            super(j2, j3);
            this.a = str;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ArtGuiderDaoliuActivity.this.btn_kown.setEnabled(true);
            ArtGuiderDaoliuActivity.this.btn_kown.setText(this.a);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            String strValueOf = String.valueOf((int) (j2 / 1000));
            ArtGuiderDaoliuActivity.this.btn_kown.setText(String.format(this.a + " %ss", strValueOf));
        }
    }

    private String a(String str, String str2, String str3, String str4) {
        return "请下载安装<br/> <font color='" + str + "'>" + str2 + "</font><br/>后进入书架页面，根据以下图示步骤选择<br/><font color='" + str + "'>【" + str3 + "】</font><br/>" + str4 + "。";
    }

    public static String getSimpleSqlId2(String str, int i2) {
        return str.substring(str.lastIndexOf("/", i2 - 1) + 1, i2);
    }

    private void n() {
        showErrorMsgGravityBottom("回答错误，请再次仔细阅读操作提示！");
    }

    private void o() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("温馨提示");
        builder.setIcon(R.mipmap.app_logo);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, this.f2571n0);
        View viewInflate = getLayoutInflater().inflate(R.layout.list_msg_dialog, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_msg)).setText("为保证你的数据可以正常恢复，请仔细阅读图示指引后回答以下哪个选项可以恢复你的数据？");
        final ListView listView = (ListView) viewInflate.findViewById(R.id.lv_items);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setChoiceMode(1);
        builder.setView(viewInflate);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.main.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f2635s.a(listView, dialogInterface, i2);
            }
        });
        builder.create().show();
    }

    private void p() {
        setResult(836);
        finish();
    }

    private void q() {
        o();
    }

    private void r() {
        this.btn_kown.setEnabled(false);
        this.f2573p0 = new a(10000L, 1000L, "我知道了");
        this.f2573p0.start();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "操作提示";
    }

    public /* synthetic */ void e(View view) {
        o();
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        String simpleSqlId2;
        String strSubstring;
        Intent intent = getIntent();
        if (intent == null) {
            showMessage("参数异常！");
            finish();
            return;
        }
        this.f2571n0 = getResources().getStringArray(R.array.arrayMethod);
        String str = "#" + Integer.toHexString(ContextCompat.getColor(this, R.color.colorPrimary) & ViewCompat.MEASURED_SIZE_MASK);
        String stringExtra = intent.getStringExtra("theme_path");
        String stringExtra2 = intent.getStringExtra("title");
        if (TextUtils.isEmpty(stringExtra2)) {
            stringExtra2 = "新版app";
        }
        this.f2572o0 = intent.getBooleanExtra("SafBean", false);
        String str2 = this.f2572o0 + " path: " + stringExtra;
        if (this.f2572o0) {
            String str3 = "";
            if (TextUtils.isEmpty(stringExtra) || stringExtra == null) {
                simpleSqlId2 = "";
                strSubstring = simpleSqlId2;
            } else {
                int iLastIndexOf = stringExtra.lastIndexOf("/");
                strSubstring = iLastIndexOf != -1 ? stringExtra.substring(iLastIndexOf + 1) : "";
                simpleSqlId2 = getSimpleSqlId2(stringExtra, iLastIndexOf);
                if (Pattern.matches(".*(?=storage).*", stringExtra)) {
                    str3 = "内存卡的";
                }
            }
            showMsgGravityBottomByType("备份成功", 1);
            String strA = a(str, stringExtra2, this.f2571n0[0], "数据");
            String str4 = "备份成功，" + strA;
            if (!TextUtils.isEmpty(simpleSqlId2) && !TextUtils.isEmpty(strSubstring)) {
                str4 = "已成功在<font color='" + str + "'>" + str3 + "</font><font color='" + str + "'>" + simpleSqlId2 + "</font>文件夹下备份了<font color='" + str + "'>" + strSubstring + "</font> 文件<br/>" + a(str, stringExtra2, this.f2571n0[0], "然后找到<font color='" + str + "'>" + strSubstring + "</font>进行数据恢复");
            } else if (!TextUtils.isEmpty(stringExtra)) {
                str4 = "备份成功，路径为：<font color='" + str + "'>" + stringExtra + "</font> <br/>" + strA;
            }
            this.tv_info.setText(Html.fromHtml(str4));
            this.G.a(this.f2277w, ImageConfigImpl.builder().resId(R.drawable.daoliu_1).imageRadius(8).imageView(this.iv_step).build());
        } else {
            showMsgGravityBottomByType("备份失败！", 3);
            this.tv_info.setText(Html.fromHtml("啊哦~居然<font color='" + str + "'>备份失败</font>了，<br/>系统已为你自动切换到备用方案，" + a(str, stringExtra2, this.f2571n0[1], "数据")));
            this.G.a(this.f2277w, ImageConfigImpl.builder().resId(R.drawable.daoliu_2).imageRadius(8).imageView(this.iv_step).build());
        }
        r();
        this.btn_kown.setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.main.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2633s.e(view);
            }
        });
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.guiderdaoliu_activity;
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

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        q();
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.f2573p0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 && i2 != 3) {
            return super.onKeyDown(i2, keyEvent);
        }
        q();
        return true;
    }

    public /* synthetic */ void a(ListView listView, DialogInterface dialogInterface, int i2) {
        int checkedItemPosition = listView.getCheckedItemPosition();
        if (checkedItemPosition == 0) {
            if (this.f2572o0) {
                p();
                return;
            } else {
                n();
                return;
            }
        }
        if (checkedItemPosition != 1) {
            showErrorMsgGravityBottom("请选择");
        } else if (this.f2572o0) {
            n();
        } else {
            p();
        }
    }
}
