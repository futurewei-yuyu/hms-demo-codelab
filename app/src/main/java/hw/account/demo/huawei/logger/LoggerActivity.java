package hw.account.demo.huawei.logger;

import android.app.Activity;

import hw.account.demo.huawei.sample.LogFragment;
import hw.account.demo.huawei.R;

public class LoggerActivity extends Activity {
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        initializeLogging();
    }


    private void initializeLogging() {
        LogFragment logFragment = (LogFragment) getFragmentManager().findFragmentById(R.id.framelog);

        LogCatWrapper logcat = new LogCatWrapper();
        logcat.setNext(logFragment.getLogView());

        Log.setLogNode(logcat);
    }
}
