package loyalty.com.br.loyalty.ApplicationContext;

import android.app.Application;
import android.util.Log;

import loyalty.com.br.loyalty.model.bean.DAO.DataBaseManager;

/**
 * Created by root on 07/10/15.
 */
public class ApplicationContext extends Application {
    private static final String TAG = ApplicationContext.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        DataBaseManager.init(this);
    }

    @Override
    public void onTerminate() {
        Log.d(TAG, "onTerminate");
        DataBaseManager.close();
        super.onTerminate();

    }
}
