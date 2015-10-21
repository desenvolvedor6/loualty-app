package loyalty.com.br.loyalty.presenter;

import loyalty.com.br.loyalty.model.bean.UserCashier;

/**
 * Created by root on 09/10/15.
 */
public interface LoginPresenter {
    public void validateCredentials(UserCashier userCashier);
}
