package fpl.poly.nhom9.duan1ht.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class MyDBHelper extends SQLiteOpenHelper {

    public  static  final  String DB_NAME = "QuanLy";
    public  static  final  int DB_VERSION = 3;

    public MyDBHelper(Context context){


        super(context,DB_NAME,null,DB_VERSION);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        String sqlLoaiSanPham = "CREATE TABLE tb_loai_san_pham (\n" +
                "    id_san_pham       INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    ten_loai_san_pham TEXT    NOT NULL\n" +
                ");\n";
        db.execSQL(sqlLoaiSanPham);

        String sqlSanPham = "CREATE TABLE tb_san_pham (\n" +
                "    id_san_pham      INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    id_loai_san_pham INTEGER REFERENCES tb_loai_san_pham (id_san_pham),\n" +
                "    ten_san_pham     TEXT    NOT NULL,\n" +
                "    don_gia          INTEGER NOT NULL,\n" +
                "    img_url          TEXT NOT NULL,\n" +
                "    mo_ta            TEXT    NOT NULL,\n" +
                "    so_luong         INTEGER ,\n" +
                "    nhacungcap         TEXT NOT NULL,\n" +
                "    loai         TEXT \n" +
                ");\n";
        db.execSQL(sqlSanPham);
        db.execSQL("insert into tb_san_pham values (2,2,'NINJAGO Maste rs of Spinjitzu',17000,'img_1','NINJAGO Masters of Spinjitzu:\n" +
                "ĐỒ CHƠI LEGO NINJAGO Masters of Spinjitzu: Stormbringer 70652 rất thích hợp cho những bé trong độ tuổi 8-14 để các bé có thể phát triển khả năng tư duy thông minh và sáng tạo hơn với những mô hình lắp ghép rất hấp dẫn và sáng tạo\n" +
                ".',5,'Phạm Văn Quốc','Phần 1')");
        db.execSQL("insert into tb_san_pham values (1,2,'Ninjago – Siêu thuyền Katana',13000,'img_2','ĐỒ CHƠI LEGO NINJAGO Masters of Spinjitzu: Stormbringer 70652 rất thích hợp cho những bé trong độ tuổi 8-14 để các bé có thể phát triển khả năng tư duy thông minh và sáng tạo hơn với những mô hình lắp ghép rất hấp dẫn và sáng tạo',6,'Trần Đức Nghiêm','Phần 2')");
        db.execSQL("insert into tb_san_pham values (3,2,' Ninjago– Xe đua bóng đêm',15000,'img_3','ĐỒ CHƠI LEGO NINJAGO Masters of Spinjitzu: Stormbringer 70652 rất thích hợp cho những bé trong độ tuổi 8-14 để các bé có thể phát triển khả năng tư duy thông minh và sáng tạo hơn với những mô hình lắp ghép rất hấp dẫn và sáng tạo',5,'Đỗ Trung Hiếu','Phần 3')");
        db.execSQL("insert into tb_san_pham values (4,2,'Ninjago – Võ Đường Ninja',15000,'img_4','ĐỒ CHƠI LEGO NINJAGO Masters of Spinjitzu: Stormbringer 70652 rất thích hợp cho những bé trong độ tuổi 8-14 để các bé có thể phát triển khả năng tư duy thông minh và sáng tạo hơn với những mô hình lắp ghép rất hấp dẫn và sáng tạo',6,'Phạm Văn Quốc','Phần 2')");
        db.execSQL("insert into tb_san_pham values (5,2,'Ninjago – Siêu Người Máy Samurai',15000,'img_5','ĐỒ CHƠI LEGO NINJAGO Masters of Spinjitzu: Stormbringer 70652 rất thích hợp cho những bé trong độ tuổi 8-14 để các bé có thể phát triển khả năng tư duy thông minh và sáng tạo hơn với những mô hình lắp ghép rất hấp dẫn và sáng tạo',7,'Phạm Văn Quốc','Phần 1')");
        db.execSQL("insert into tb_san_pham values (6,2,'Ninjago – Siêu thuyền Katana',15000,'img_6','ĐỒ CHƠI LEGO NINJAGO Masters of Spinjitzu: Stormbringer 70652 rất thích hợp cho những bé trong độ tuổi 8-14 để các bé có thể phát triển khả năng tư duy thông minh và sáng tạo hơn với những mô hình lắp ghép rất hấp dẫn và sáng tạo',3,'Phạm Văn Quốc','Phần 1')");
        db.execSQL("insert into tb_san_pham values (7,2,'Ninjago – Siêu thuyền Katana',15000,'img_7','ĐỒ CHƠI LEGO NINJAGO Masters of Spinjitzu: Stormbringer 70652 rất thích hợp cho những bé trong độ tuổi 8-14 để các bé có thể phát triển khả năng tư duy thông minh và sáng tạo hơn với những mô hình lắp ghép rất hấp dẫn và sáng tạo',7,'Phạm Văn Quốc','Phần 3')");
        db.execSQL("insert into tb_san_pham values (8,2,'Ninjago – Siêu thuyền Katana',15000,'img_8','ĐỒ CHƠI LEGO NINJAGO Masters of Spinjitzu: Stormbringer 70652 rất thích hợp cho những bé trong độ tuổi 8-14 để các bé có thể phát triển khả năng tư duy thông minh và sáng tạo hơn với những mô hình lắp ghép rất hấp dẫn và sáng tạo',2,'Phạm Văn Quốc','Phần 2')");
        db.execSQL("insert into tb_san_pham values (9,2,'Ninjago 70665 Legacy Samurai Mech – Siêu Người Máy Samurai',15000,'img_9','ĐỒ CHƠI LEGO NINJAGO Masters of Spinjitzu: Stormbringer 70652 rất thích hợp cho những bé trong độ tuổi 8-14 để các bé có thể phát triển khả năng tư duy thông minh và sáng tạo hơn với những mô hình lắp ghép rất hấp dẫn và sáng tạo',6,'Đỗ Trung Hiếu','Phần 2')");
        db.execSQL("insert into tb_san_pham values (10,2,'Ninjago 70665 Legacy Samurai Mech – Siêu Người Máy Samurai',15000,'img_10','ĐỒ CHƠI LEGO NINJAGO Masters of Spinjitzu: Stormbringer 70652 rất thích hợp cho những bé trong độ tuổi 8-14 để các bé có thể phát triển khả năng tư duy thông minh và sáng tạo hơn với những mô hình lắp ghép rất hấp dẫn và sáng tạo',6,'Đỗ Trung Hiếu','Phần 3')");

        String sqlThongTinKhachHang = "CREATE TABLE tb_thong_tin_khach_hang (\n" +
                "    id_khach_hang  INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    ten_khach_hang TEXT    NOT NULL,\n" +
                "    so_dien_thoai  TEXT    NOT NULL,\n" +
                "    gioi_tinh      TEXT    NOT NULL,\n" +
                "    ngay_sinh      TEXT    NOT NULL,\n" +
                "    email          TEXT    NOT NULL,\n" +
                "    dia_chi        TEXT    NOT NULL\n"+
                ");\n";
        db.execSQL(sqlThongTinKhachHang);

        String sqlHoaDon = "CREATE TABLE tb_hoa_don (\n" +
                "    id_hoa_don    INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    id_san_pham   INTEGER REFERENCES tb_san_pham (id_san_pham),\n" +
                "    ten_khach_hang TEXT REFERENCES tb_khach_hang (ten_khach_hang)," +
                "    danh_sach_san_pham TEXT," +
                "    so_dien_thoai TEXT    NOT NULL,\n" +
                "    dia_chi       TEXT    NOT NULL,\n" +
                "    ngay_dat      TEXT    NOT NULL,\n" +
                "    trang_thai    TEXT    NOT NULL,\n" +
                "    tong_tien     INTEGER NOT NULL\n" +
                ");\n";
        db.execSQL(sqlHoaDon);


        String sqlTaiKhoan = "CREATE TABLE tb_tai_khoan (\n" +
                "    id_tai_khoan  INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    id_khach_hang INTEGER REFERENCES tb_khach_hang (id_khach_hang),\n" +
                "    ten_dang_nhap TEXT    NOT NULL,\n" +
                "    mat_khau      TEXT    NOT NULL ," +
                "tenUser TEXT, " +
                "email TEXT, " +
                "soDienThoai TEXT, " +
                "gioiTinh TEXT," +
                " ngaySinh TEXT\n" +
                ");\n";
        db.execSQL(sqlTaiKhoan);

        db.execSQL("INSERT INTO tb_tai_khoan VALUES(1, 1, 'admin', '12345', 'Quốc Mini', 'cuocmini@gmail.com', '0369999999', 'Nam', '01/01/2004')");



        String sqlChiTietHoaDon = "CREATE TABLE tb_chi_tiet_hoa_don (\n" +
                "    id_chi_tiet_hoa_don INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    id_san_pham         INTEGER NOT NULL\n" +
                "                                REFERENCES tb_san_pham (id_san_pham),\n" +
                "    id_hoa_don          INTEGER NOT NULL\n" +
                "                                REFERENCES tb_hoa_don (id_hoa_don),\n" +
                "    ten_san_hoa_pham    TEXT    NOT NULL,\n" +
                "    so_luong            INTEGER NOT NULL,\n" +
                "    tong_tien_hoa_don   TEXT    NOT NULL\n" +
                ");\n";
        db.execSQL(sqlChiTietHoaDon);

        String sqlGioHang = "CREATE TABLE tb_gio_hang (\n" +
                "    id           INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    id_san_pham  INTEGER REFERENCES tb_san_pham (id_san_pham),\n" +
                "    ten_san_pham TEXT,\n" +
                "    gia_san_pham TEXT,\n" +
                "    img_url      TEXT," +
                "    so_luong_sp INTEGER," +
                "    tongTien1Sp INTEGER" +
                ");\n";
        db.execSQL(sqlGioHang);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE tb_loai_san_pham");
        db.execSQL("DROP TABLE  tb_san_pham");
        db.execSQL("DROP TABLE tb_thong_tin_khach_hang");
        db.execSQL("DROP TABLE tb_hoa_don");
        db.execSQL("DROP TABLE tb_tai_khoan");
        db.execSQL("DROP TABLE tb_chi_tiet_hoa_don");
        db.execSQL("DROP TABLE tb_gio_hang");

        onCreate(db);


    }
}
