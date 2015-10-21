package loyalty.com.br.loyalty.model.bean.DAO;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;

/**
 * Created by root on 07/10/15.
 */
public class DataBaseManager {

    private static DataBaseManager instace;
    private DataBaseHelper dataBaseHelper;

    private DataBaseManager(Context context) {
        dataBaseHelper = OpenHelperManager.getHelper(context, DataBaseHelper.class);
        dataBaseHelper.getWritableDatabase();
    }

    public static void init(Context context) {
        if (instace == null) {
            instace = new DataBaseManager(context);
        }
    }

    public static void close() {
        OpenHelperManager.releaseHelper();
        instace.setHelper(null);
    }

    private void setHelper(DataBaseHelper object) {
        dataBaseHelper = object;
    }

    public DataBaseHelper getHelper() {
        return dataBaseHelper;
    }

    public static DataBaseManager getInstace() {
        return instace;
    }

}
