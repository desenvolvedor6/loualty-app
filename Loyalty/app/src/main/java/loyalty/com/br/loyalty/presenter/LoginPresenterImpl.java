package loyalty.com.br.loyalty.presenter;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

import loyalty.com.br.loyalty.R;
import loyalty.com.br.loyalty.activity.Loyalty;
import loyalty.com.br.loyalty.activity.Sale;
import loyalty.com.br.loyalty.model.bean.UserCashier;
import loyalty.com.br.loyalty.model.bean.UserClient;
import loyalty.com.br.loyalty.task.UserTask;

/**
 * Created by root on 09/10/15.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private Activity activity;
    private EditText name;
    private EditText pass;
    private UserClient userClient;

    public LoginPresenterImpl(Activity activity) {
        this.activity = activity;
    }

    public void init() {
        Intent intent = new Intent();
        userClient = new UserClient();
        name = (EditText) activity.findViewById(R.id.name);
        pass = (EditText) activity.findViewById(R.id.password);
        userClient.setName(name.getText().toString());
        userClient.setPass(pass.getText().toString());
        new UserTask(activity, userClient).execute();
    }

    @Override
    public void validateCredentials(UserCashier userCashier) {
        Intent intent = new Intent();
        if (userCashier != null) {
            intent.setClass(activity, Sale.class);
        } else if (userCashier == null) {
            intent.setClass(activity, Loyalty.class);
        }
        activity.startActivity(intent);

    }
}
