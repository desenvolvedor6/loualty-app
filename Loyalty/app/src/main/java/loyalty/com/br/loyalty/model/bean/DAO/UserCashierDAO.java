package loyalty.com.br.loyalty.model.bean.DAO;

import loyalty.com.br.loyalty.model.bean.UserCashier;

/**
 * Created by root on 07/10/15.
 */
public class UserCashierDAO extends AbstractGenericDAO<UserCashier> {

    private static UserCashierDAO instance;

    public UserCashierDAO() {

    }

    public static UserCashierDAO getInstance() {
        if (instance == null) {
            instance = new UserCashierDAO();
        }
        return instance;
    }
}
