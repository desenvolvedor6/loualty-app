package loyalty.com.br.loyalty.converter;

import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONStringer;

/**
 * Created by root on 08/10/15.
 */
public class Converter {

    private Gson gson;

    public Converter() {
        this.gson = new Gson();
    }

    public Object converterTOJSON(String jsonString, Object t) {
        t = gson.fromJson(jsonString, t.getClass());
        return t;
    }

    public String converterTOObject(Object o) {
        return gson.toJson(o);
    }

}

