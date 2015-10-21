package loyalty.com.br.loyalty.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import loyalty.com.br.loyalty.R;
import loyalty.com.br.loyalty.activity.Sale;
import loyalty.com.br.loyalty.model.bean.SaleCashier;
import loyalty.com.br.loyalty.model.bean.UserClient;

/**
 * Created by root on 14/10/15.
 */
public class SaleCashierAdapter extends BaseAdapter {

    private Activity activity;
    private List<SaleCashier> listSaleCashier;

    public SaleCashierAdapter(Sale activity, List<SaleCashier> listSaleCashier) {
        this.activity = activity;
        this.listSaleCashier = listSaleCashier;
    }

    @Override
    public int getCount() {
        return listSaleCashier.size();
    }

    @Override
    public Object getItem(int position) {
        return listSaleCashier.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listSaleCashier.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View viewItem = (View) activity.getLayoutInflater().inflate(R.layout.itemlist, null);

        TextView name = (TextView) viewItem.findViewById(R.id.itemLayoutNome);
        ImageView image = (ImageView) viewItem.findViewById(R.id.itemLayoutFoto);
        TextView valueTotal = (TextView) viewItem.findViewById(R.id.valueTotal);
        UserClient userClient = listSaleCashier.get(position).getCardClient().getUserClient();


        name.setText(userClient.getName() + " - " + userClient.getUid());

        Bitmap bmp;
        if (userClient.getFoto() != null) {
            bmp = BitmapFactory.decodeFile(userClient.getFoto());
        } else {
            bmp = BitmapFactory.decodeResource(activity.getResources(), R.drawable.ic_no_image);
        }
        bmp = Bitmap.createScaledBitmap(bmp, 100, 100, true);
        image.setImageBitmap(bmp);
        valueTotal.setText(listSaleCashier.get(position).getValueTotal() + "");

        return viewItem;
    }
}
