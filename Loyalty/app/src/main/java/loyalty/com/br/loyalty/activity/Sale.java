package loyalty.com.br.loyalty.activity;


import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


import loyalty.com.br.loyalty.R;
import loyalty.com.br.loyalty.model.bean.CardClient;
import loyalty.com.br.loyalty.presenter.SalePresenter;


public class Sale extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //RoboGuice.getInjector(Sale.this).injectMembers(Sale.this);
        super.onCreate(savedInstanceState);

        getActionBar().setIcon(R.drawable.ic_launcher);
        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
        getActionBar().setTitle(R.string.titleLoyalty);
        CardClient cardClient = (CardClient) getIntent().getSerializableExtra("card");
        SalePresenter salePresenter = new SalePresenter(Sale.this, cardClient);
        salePresenter.init();
    }
}
