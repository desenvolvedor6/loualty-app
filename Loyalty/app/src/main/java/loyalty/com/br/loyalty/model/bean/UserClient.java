package loyalty.com.br.loyalty.model.bean;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by root on 13/10/15.
 */
public class UserClient implements IEntiyBean {

    @DatabaseField(generatedId = true)
    private Long id;
    @DatabaseField
    private Long uid;
    @DatabaseField
    private String name;
    @DatabaseField
    private String foto;
    @DatabaseField
    private String pass;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserClient userClient = (UserClient) o;

        return !(id != null ? !id.equals(userClient.id) : userClient.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}