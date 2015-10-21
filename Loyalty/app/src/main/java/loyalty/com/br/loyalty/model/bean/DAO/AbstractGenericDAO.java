package loyalty.com.br.loyalty.model.bean.DAO;

import android.util.Log;

import com.j256.ormlite.dao.Dao;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import loyalty.com.br.loyalty.model.bean.DAO.DataBaseHelper;
import loyalty.com.br.loyalty.model.bean.DAO.DataBaseManager;
import loyalty.com.br.loyalty.model.bean.IEntiyBean;

/**
 * Created by root on 07/10/15.
 */
public class AbstractGenericDAO<T extends IEntiyBean> {

    private static final String TAG = AbstractGenericDAO.class.getSimpleName();

    protected DataBaseHelper getHelper() {

        return DataBaseManager.getInstace().getHelper();
    }

    protected Dao<T, Object> getConnection() {
        return (Dao<T, Object>) getHelper().getRuntimeExceptionDao(getEntityClass());
    }

    private Class getEntityClass() {
        ParameterizedType t = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class) t.getActualTypeArguments()[0];
    }

    public boolean createOrUpdate(IEntiyBean entidade) {
        try {
            Dao<IEntiyBean, Object> dao = getHelper().getDAO(getEntityClass());
            int qtdeLinhasAlteradas = dao.createOrUpdate(entidade).getNumLinesChanged();
            return (qtdeLinhasAlteradas > 0);
        } catch (SQLException e) {
            Log.e(TAG, "Erro método creteOrUpdate AbstractDAO", e);
            return false;
        }

    }

    public boolean delete(IEntiyBean entidade) {
        try {
            return (getHelper().getDAO(getEntityClass()).delete(entidade) > 0);
        } catch (SQLException e) {
            Log.e(TAG, "Error método delete AbstractDAO", e);
            return false;
        }

    }

    public List<T> findAll() {
        try {
            return (List) getHelper().getDAO(getEntityClass()).queryForAll();
        } catch (SQLException e) {
            Log.e(TAG, "ERRO no método findAll AbstractDAO", e);
            return Collections.EMPTY_LIST;
        }
    }

    public T findByPK(Object id) {
        try {
            return (T) getHelper().getDAO(getEntityClass()).queryForId(id);
        } catch (SQLException e) {
            Log.e(TAG, "Erro no método findByPK", e);
            return null;
        }
    }

    public List<T> findForAttribute(String attributeName, Object value) {
        try {
            return (List) getHelper().getDAO(getEntityClass()).queryForEq(attributeName, value);
        } catch (SQLException e) {
            Log.e(TAG, "ERRO no método findAll AbstractDAO", e);
            return null;
        }
    }

}
