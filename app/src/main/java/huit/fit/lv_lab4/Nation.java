package huit.fit.lv_lab4;

public class Nation {
    int idAnh;
    String nationName;

    public Nation(int idAnh, String nationName) {
        this.idAnh = idAnh;
        this.nationName = nationName;
    }

    public Nation() {
    }

    public int getIdAnh() {
        return idAnh;
    }

    public void setIdAnh(int idAnh) {
        this.idAnh = idAnh;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }
}
