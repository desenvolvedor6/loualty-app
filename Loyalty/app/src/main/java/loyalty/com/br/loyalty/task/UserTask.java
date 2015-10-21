package loyalty.com.br.loyalty.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import loyalty.com.br.loyalty.converter.Converter;
import loyalty.com.br.loyalty.integration.WebClient;
import loyalty.com.br.loyalty.model.bean.UserCashier;
import loyalty.com.br.loyalty.model.bean.UserClient;
import loyalty.com.br.loyalty.presenter.LoginPresenterImpl;

/**
 * Created by root on 08/10/15.
 */
public class UserTask extends AsyncTask<Object, Object, UserCashier> {
    private final String url = "http://192.168.10.98/loyalty/";
    private Context context;
    private ProgressDialog progress;
    private UserClient userClientReceived;

    public UserTask(Context context, UserClient userClientReceived) {
        this.context = context;
        this.userClientReceived = userClientReceived;

    }

    @Override
    protected void onPreExecute() {
        progress = ProgressDialog.show(context, "Aguarde...", "enviando dados para o servidor web", true, true);
    }

    protected void onPostExecute(UserCashier userCashier) {
        Activity activity = (Activity) context;
        LoginPresenterImpl loginPresenter = new LoginPresenterImpl(activity);
        loginPresenter.validateCredentials(userCashier);
        progress.dismiss();

    }

    @Override
    protected UserCashier doInBackground(Object... params) {
        try {
            WebClient webClient = new WebClient(url);
            Converter converter = new Converter();

            String param = converter.converterTOObject(userClientReceived);
            String retorno = webClient.post(param);

            Object userCashier = new UserCashier();
            Object userCashier1 = converter.converterTOJSON(retorno, userCashier);
            return (UserCashier) userCashier1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
