package loyalty.com.br.loyalty.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import loyalty.com.br.loyalty.R;
import loyalty.com.br.loyalty.model.bean.DAO.UserCashierDAO;
import loyalty.com.br.loyalty.model.bean.UserCashier;
import loyalty.com.br.loyalty.presenter.LoginPresenterImpl;
import loyalty.com.br.loyalty.task.UserTask;
import roboguice.inject.InjectView;


public class Loyalty extends Activity {

    @InjectView(R.id.btnAuth)
    Button buttonAuth;

    @InjectView(R.id.name)
    EditText name;
    @InjectView(R.id.password)
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loyalty);
        getActionBar().setIcon(R.drawable.ic_launcher);
        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
        getActionBar().setTitle(R.string.titleLoyalty);

        buttonAuth = (Button) findViewById(R.id.btnAuth);
        buttonAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginPresenterImpl loginPresenter = new LoginPresenterImpl(Loyalty.this);
                loginPresenter.init();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_loyalty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
