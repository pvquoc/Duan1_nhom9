package fpl.poly.nhom9.duan1ht.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fpl.poly.nhom9.duan1ht.DBHelper.MyDBHelper;
import fpl.poly.nhom9.duan1ht.DTO.SanPhamTrangChuDTO;

public class TrangChuAdminDAO {
    MyDBHelper myDBHelper;
    public TrangChuAdminDAO(Context context){
        myDBHelper=new MyDBHelper(context);
    }
    public ArrayList<SanPhamTrangChuDTO> getDanhSachSPAdmin(){
        ArrayList<SanPhamTrangChuDTO> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=myDBHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM tb_san_pham", null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new SanPhamTrangChuDTO(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getString(7), cursor.getString(8)));

            }while (cursor.moveToNext());
        }
        return list;
    }
    public boolean ThemSanPham(String tensanpham, int dongia, String img, String mota, String loai, String nhacungcap) {
        SQLiteDatabase sqLiteDatabase = myDBHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("ten_san_pham", tensanpham);
        values.put("don_gia", dongia);
        values.put("img_url", img);
        values.put("mo_ta", mota);
        values.put("loai", loai);
        values.put("nhacungcap", nhacungcap);

        long check = sqLiteDatabase.insert("tb_san_pham", null, values);
        if (check == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean SuaSanPham(int id_san_pham, String tensanpham, int dongia,String mo_ta, String loai){
        SQLiteDatabase sqLiteDatabase = myDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(" ten_san_pham", tensanpham);
        values.put(" don_gia ", dongia);
        values.put("mo_ta", mo_ta);
        values.put("loai", loai);

        int check = sqLiteDatabase.update("tb_san_pham",values,"  id_san_pham =?",new String[]{String.valueOf(id_san_pham)});

        getDanhSachSPAdmin();
        return check !=0;
    }
    public ArrayList<SanPhamTrangChuDTO> getDSSanPhamP1Admin() {
        ArrayList<SanPhamTrangChuDTO> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = myDBHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM  tb_san_pham WHERE loai LIKE '%Phần 1%' ", null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new SanPhamTrangChuDTO(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getString(7), cursor.getString(8)));
            } while (cursor.moveToNext());
        }
        return list;
    }
    public ArrayList<SanPhamTrangChuDTO> getDSSanPhamP2Admin() {
        ArrayList<SanPhamTrangChuDTO> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = myDBHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM  tb_san_pham WHERE loai LIKE '%Phần 2%' ", null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new SanPhamTrangChuDTO(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getString(7), cursor.getString(8)));
            } while (cursor.moveToNext());
        }
        return list;
    }
    public ArrayList<SanPhamTrangChuDTO> getDSSanPhamP3Admin() {
        ArrayList<SanPhamTrangChuDTO> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = myDBHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM  tb_san_pham WHERE loai LIKE '%Phần 3%' ", null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new SanPhamTrangChuDTO(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getString(7), cursor.getString(8)));
            } while (cursor.moveToNext());
        }
        return list;
    }
    public ArrayList<SanPhamTrangChuDTO> timKiemP1(String tenSp){
        ArrayList<SanPhamTrangChuDTO> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=myDBHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM  tb_san_pham WHERE ten_san_pham LIKE '%" + tenSp + "%' AND loai LIKE '%Phần 1%' ", null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new SanPhamTrangChuDTO(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getString(7), cursor.getString(8)));
            } while (cursor.moveToNext());
        }
        return list;
    }
    public ArrayList<SanPhamTrangChuDTO> timKiemP2(String tenSp){
        ArrayList<SanPhamTrangChuDTO> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=myDBHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM  tb_san_pham WHERE ten_san_pham LIKE '%" + tenSp + "%' AND loai LIKE '%Phần 2%' ", null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new SanPhamTrangChuDTO(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getString(7), cursor.getString(8)));
            } while (cursor.moveToNext());
        }
        return list;
    }
    public ArrayList<SanPhamTrangChuDTO> timKiemP3(String tenSp){
        ArrayList<SanPhamTrangChuDTO> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=myDBHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM  tb_san_pham WHERE ten_san_pham LIKE '%" + tenSp + "%' AND loai LIKE '%Phần 3%' ", null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new SanPhamTrangChuDTO(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getString(7), cursor.getString(8)));
            } while (cursor.moveToNext());
        }
        return list;
    }
}
