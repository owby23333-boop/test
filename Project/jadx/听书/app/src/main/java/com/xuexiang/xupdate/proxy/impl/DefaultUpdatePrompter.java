package com.xuexiang.xupdate.proxy.impl;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.xuexiang.xupdate.entity.PromptEntity;
import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.logs.UpdateLog;
import com.xuexiang.xupdate.proxy.IPrompterProxy;
import com.xuexiang.xupdate.proxy.IUpdatePrompter;
import com.xuexiang.xupdate.proxy.IUpdateProxy;
import com.xuexiang.xupdate.widget.UpdateDialog;
import com.xuexiang.xupdate.widget.UpdateDialogActivity;
import com.xuexiang.xupdate.widget.UpdateDialogFragment;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultUpdatePrompter implements IUpdatePrompter {
    @Override // com.xuexiang.xupdate.proxy.IUpdatePrompter
    public void showPrompt(UpdateEntity updateEntity, IUpdateProxy iUpdateProxy, PromptEntity promptEntity) {
        Context context = iUpdateProxy.getContext();
        if (context == null) {
            UpdateLog.e("showPrompt failed, context is null!");
            return;
        }
        beforeShowPrompt(updateEntity, promptEntity);
        UpdateLog.d("[DefaultUpdatePrompter] showPrompt, " + promptEntity);
        if (context instanceof FragmentActivity) {
            UpdateDialogFragment.show(((FragmentActivity) context).getSupportFragmentManager(), updateEntity, getPrompterProxy(iUpdateProxy), promptEntity);
        } else if (context instanceof Activity) {
            UpdateDialog.newInstance(context, updateEntity, getPrompterProxy(iUpdateProxy), promptEntity).show();
        } else {
            UpdateDialogActivity.show(context, updateEntity, getPrompterProxy(iUpdateProxy), promptEntity);
        }
    }

    protected void beforeShowPrompt(UpdateEntity updateEntity, PromptEntity promptEntity) {
        if (updateEntity.isForce()) {
            promptEntity.setIgnoreDownloadError(true);
        }
    }

    protected IPrompterProxy getPrompterProxy(IUpdateProxy iUpdateProxy) {
        return new DefaultPrompterProxyImpl(iUpdateProxy);
    }
}
