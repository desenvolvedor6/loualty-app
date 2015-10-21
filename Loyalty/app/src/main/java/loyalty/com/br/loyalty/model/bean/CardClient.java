package loyalty.com.br.loyalty.model.bean;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by root on 13/10/15.
 */
public class CardClient implements IEntiyBean {

    @DatabaseField(generatedId = true)
    private Long id;
    @DatabaseField
    private String numberCard;
    @DatabaseField
    private int cashBack;
    @DatabaseField
    private UserClient userClient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public UserClient getUserClient() {
        return userClient;
    }

    public void setUserClient(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardClient cardClient = (CardClient) o;

        return !(id != null ? !id.equals(cardClient.id) : cardClient.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
