package loyalty.com.br.loyalty.model.bean.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import loyalty.com.br.loyalty.model.bean.IEntiyBean;
import loyalty.com.br.loyalty.model.bean.UserCashier;

/**
 * Created by root on 07/10/15.
 */
public class DataBaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "loyalty.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TAG = DataBaseHelper.class.getSimpleName();

    private Map<Class, Object> daos = new HashMap<>();


    private Context context;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Log.i(TAG, "onCreate()");
            TableUtils.createTable(connectionSource, UserCashier.class);

        } catch (Exception ex) {
            Log.e(TAG, "onCreate(): Falha ao criar tabelas", ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(TAG, "onUpgrade");
            TableUtils.dropTable(connectionSource, UserCashier.class, true);
            onCreate(database, connectionSource);
        } catch (Exception ex) {
            Log.e(TAG, "onUpgrade(): Falha ao criar tabelas", ex);
            throw new RuntimeException(ex);
        }
    }

    public <T> Dao<T, Object> getDAO(Class klass) throws SQLException {
        Dao<IEntiyBean, Object> dao = null;
        //Consulta ao mapa de DAOs
        if (daos.get(klass) == null) {
            dao = super.getDao(klass);
            //atualização do mapa de DAOS
            daos.put(klass, dao);
        }

        return (Dao<T, Object>) daos.get(klass);
    }

    @Override
    public void close() {
        super.close();
    }

    public Context getContext() {
        return context;
    }
}
