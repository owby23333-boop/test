package com.arialyy.aria.core.command;

import com.arialyy.aria.core.download.AbsGroupTaskWrapper;

/* JADX INFO: loaded from: classes2.dex */
public class GroupCmdFactory {
    private static volatile GroupCmdFactory INSTANCE = null;
    public static final int SUB_TASK_START = 161;
    public static final int SUB_TASK_STOP = 162;

    private GroupCmdFactory() {
    }

    public static GroupCmdFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (GroupCmdFactory.class) {
                INSTANCE = new GroupCmdFactory();
            }
        }
        return INSTANCE;
    }

    public AbsGroupCmd createCmd(AbsGroupTaskWrapper absGroupTaskWrapper, int i2, String str) {
        AbsGroupCmd dGSubStopCmd = i2 != 161 ? i2 != 162 ? null : new DGSubStopCmd(absGroupTaskWrapper) : new DGSubStartCmd(absGroupTaskWrapper);
        if (dGSubStopCmd != null) {
            dGSubStopCmd.childUrl = str;
        }
        return dGSubStopCmd;
    }
}
