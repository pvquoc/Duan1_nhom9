package fpl.poly.nhom9.duan1ht.DTO;

public class SanPhamTrangChuAdmin {
    private int imgSPAdim;
    private String tenSPAdmin;
    private String priceSPAdmin;

    public SanPhamTrangChuAdmin() {
    }

    public SanPhamTrangChuAdmin(int imgSPAdim, String tenSPAdmin, String priceSPAdmin) {
        this.imgSPAdim = imgSPAdim;
        this.tenSPAdmin = tenSPAdmin;
        this.priceSPAdmin = priceSPAdmin;
    }

    public int getImgSPAdim() {
        return imgSPAdim;
    }

    public void setImgSPAdim(int imgSPAdim) {
        this.imgSPAdim = imgSPAdim;
    }

    public String getTenSPAdmin() {
        return tenSPAdmin;
    }

    public void setTenSPAdmin(String tenSPAdmin) {
        this.tenSPAdmin = tenSPAdmin;
    }

    public String getPriceSPAdmin() {
        return priceSPAdmin;
    }

    public void setPriceSPAdmin(String priceSPAdmin) {
        this.priceSPAdmin = priceSPAdmin;
    }
}
