package com.bytedance.sdk.openadsdk.tools.floatwindow.page;

/* JADX INFO: loaded from: classes2.dex */
public class UGenTestToolsPage extends BaseToolPage {
    private boolean z;

    @Override // com.bytedance.sdk.openadsdk.tools.floatwindow.page.BaseToolPage
    public String getPageTitle() {
        return "UGen调试";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.z = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.z = true;
    }
}
