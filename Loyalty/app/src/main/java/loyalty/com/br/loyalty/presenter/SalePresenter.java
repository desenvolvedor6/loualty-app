package loyalty.com.br.loyalty.presenter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import loyalty.com.br.loyalty.R;
import loyalty.com.br.loyalty.activity.Sale;
import loyalty.com.br.loyalty.adapter.SaleCashierAdapter;
import loyalty.com.br.loyalty.model.bean.CardClient;
import loyalty.com.br.loyalty.model.bean.SaleCashier;
import loyalty.com.br.loyalty.task.SaleTask;
import roboguice.inject.InjectView;

/**
 * Created by root on 13/10/15.
 */
public class SalePresenter {

    private Sale activity;
    private EditText numberCard;
    private ListView userClientListView;
    private List<SaleCashier> listSaleCashier;
    private CardClient cardClient;
    private String pathFileImage;
    private static final int MAKE_PHOTO_CLIENT = 123;

    @InjectView(R.id.btnNextOne)
    private Button btnNextOne;
    @InjectView(R.id.btnNextTwo)
    private Button btnNextTwo;
    @InjectView
    private EditText valueBuy;

    public SalePresenter(Sale activity, CardClient cardClient) {
        this.activity = activity;
        this.cardClient = cardClient;
    }

    public void init() {
        if (cardClient != null) {
            activity.setContentView(R.layout.fragment_sale_2);
            btnNextTwo = (Button) activity.findViewById(R.id.btnNextTwo);
            this.valueBuy = (EditText) activity.findViewById(R.id.valueBuy);
            btnNextTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    saleTwo();
                }
            });
        } else {
            activity.setContentView(R.layout.fragment_sale);
            btnNextOne = (Button) activity.findViewById(R.id.btnNextOne);
            btnNextOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    saleOne();
                }
            });
        }

    }

    public void saleOne() {
        numberCard = (EditText) activity.findViewById(R.id.numberCard);
        SaleTask saleTask = new SaleTask(activity);
        saleTask.execute();
    }

    public void saleTwo() {
        activity.setContentView(R.layout.fragment_sale_3);
        userClientListView = (ListView) activity.findViewById(R.id.userClientListView);
        activity.registerForContextMenu(userClientListView);
        loadList();
    }

    private void loadList() {
        SaleCashierAdapter adapter;
        SaleCashier saleCashier = new SaleCashier();
        List<SaleCashier> list = new ArrayList<>();
        Log.i("INFO", this.valueBuy.getText().toString());
        saleCashier.setCardClient(cardClient);
        saleCashier.setValueTotal(Double.parseDouble(valueBuy.getText().toString()));
        list.add(saleCashier);
        listSaleCashier = list;
        adapter = new SaleCashierAdapter(activity, listSaleCashier);
        userClientListView.setAdapter(adapter);
    }
}
