package huit.fit.lv_lab4;

public class Flag {
    int idAnh;
    String tenQG;

    public Flag(int idAnh, String tenQG) {
        this.idAnh = idAnh;
        this.tenQG = tenQG;
    }

    public Flag() {
    }

    public int getIdAnh() {
        return idAnh;
    }

    public void setIdAnh(int idAnh) {
        this.idAnh = idAnh;
    }

    public String getTenQG() {
        return tenQG;
    }

    public void setTenQG(String tenQG) {
        this.tenQG = tenQG;
    }
}
