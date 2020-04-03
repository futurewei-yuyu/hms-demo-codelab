package hw.account.demo.huawei.logger;

import hw.account.demo.huawei.logger.Log.LogNode;

public class LogCatWrapper implements LogNode {
    private Log.LogNode mNext;

    public LogNode getNext() {
        return mNext;
    }

    public void setNext(LogNode node) {
        mNext = node;
    }

    @Override
    public void println(int priority, String tag, String msg, Throwable tr) {
        String useMsg = msg;
        if (useMsg == null) {
            useMsg = "";
        }

        if (tr != null) {
            useMsg += "\n" + android.util.Log.getStackTraceString(tr);
        }

        android.util.Log.println(priority, tag, useMsg);

        if (mNext != null) {
            mNext.println(priority, tag, msg, tr);
        }
    }
}
