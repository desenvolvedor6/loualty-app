package loyalty.com.br.loyalty.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import loyalty.com.br.loyalty.activity.Sale;
import loyalty.com.br.loyalty.converter.Converter;
import loyalty.com.br.loyalty.integration.WebClient;
import loyalty.com.br.loyalty.model.bean.CardClient;
import loyalty.com.br.loyalty.model.bean.UserCashier;

/**
 * Created by root on 14/10/15.
 */
public class SaleTask extends AsyncTask<Object, Object, CardClient> {

    private final String url = "http://192.168.10.98/loyalty/getCard.php";
    private Context context;
    private ProgressDialog progress;

    public SaleTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        progress = ProgressDialog.show(context, "Aguarde...", "enviando dados para o servidor web", true, true);
    }

    @Override
    protected void onPostExecute(CardClient cardClient) {
        Activity activity = (Activity) context;
        progress.dismiss();
        Intent intent = new Intent();
        intent.setClass(activity, Sale.class);
        intent.putExtra("card", cardClient);
        activity.startActivity(intent);
    }

    @Override
    protected CardClient doInBackground(Object... objects) {

        WebClient webClient = new WebClient(url);

        String retorno = webClient.post("");

        Converter converter = new Converter();
        Object cardClient = new CardClient();
        Object cardClient1 = converter.converterTOJSON(retorno, cardClient);

        return (CardClient) cardClient1;
    }
}
