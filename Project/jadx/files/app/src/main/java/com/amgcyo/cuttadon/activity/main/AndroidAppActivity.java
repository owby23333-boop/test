package com.amgcyo.cuttadon.activity.main;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.amgcyo.cuttadon.app.MkApplication;

/* JADX INFO: loaded from: classes.dex */
public class AndroidAppActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        MkApplication.killFlag = 1;
        startActivity(new Intent(this, (Class<?>) MkSplashActivity.class));
        finish();
    }
}
