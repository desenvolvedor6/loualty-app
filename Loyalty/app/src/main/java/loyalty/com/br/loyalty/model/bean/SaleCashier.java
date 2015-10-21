package loyalty.com.br.loyalty.model.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by root on 20/10/15.
 */
@DatabaseTable
public class SaleCashier implements IEntiyBean {

    @DatabaseField(generatedId = true)
    private Long id;
    private UserCashier userCashier;
    private CardClient cardClient;
    private Double valueTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserCashier getUserCashier() {
        return userCashier;
    }

    public void setUserCashier(UserCashier userCashier) {
        this.userCashier = userCashier;
    }

    public CardClient getCardClient() {
        return cardClient;
    }

    public void setCardClient(CardClient cardClient) {
        this.cardClient = cardClient;
    }

    public Double getValueTotal() {
        return valueTotal;
    }

    public void setValueTotal(Double valueTotal) {
        this.valueTotal = valueTotal;
    }
}
