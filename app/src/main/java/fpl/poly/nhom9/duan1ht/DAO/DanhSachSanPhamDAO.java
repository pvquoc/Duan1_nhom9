package fpl.poly.nhom9.duan1ht.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

import fpl.poly.nhom9.duan1ht.DBHelper.MyDBHelper;
import fpl.poly.nhom9.duan1ht.DTO.DanhSachSanPhamDTO;

public class DanhSachSanPhamDAO {
    MyDBHelper myDBHelper;
    public DanhSachSanPhamDAO(Context context){
        myDBHelper=new MyDBHelper(context);
    }
    public ArrayList<DanhSachSanPhamDTO> getDSSP(){
        ArrayList<DanhSachSanPhamDTO> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=myDBHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM tb_san_pham",null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new DanhSachSanPhamDTO(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getString(7), cursor.getString(8)));
            }while (cursor.moveToNext());
        }
        return list;
    }
    public ArrayList<DanhSachSanPhamDTO> getDSSPPhan1(){
        ArrayList<DanhSachSanPhamDTO> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=myDBHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM tb_san_pham WHERE loai LIKE '%Phần 1%' ",null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new DanhSachSanPhamDTO(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getString(7), cursor.getString(8)));
            }while (cursor.moveToNext());
        }
        return list;
    }
    public ArrayList<DanhSachSanPhamDTO> getDSSPPhan2(){
        ArrayList<DanhSachSanPhamDTO> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=myDBHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM tb_san_pham WHERE loai LIKE '%Phần 2%' ",null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new DanhSachSanPhamDTO(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getString(7), cursor.getString(8)));
            }while (cursor.moveToNext());
        }
        return list;
    }
    public ArrayList<DanhSachSanPhamDTO> getDSSPPhan3(){
        ArrayList<DanhSachSanPhamDTO> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=myDBHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM tb_san_pham WHERE loai LIKE '%Phần 3%' ",null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new DanhSachSanPhamDTO(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getString(7), cursor.getString(8)));
            }while (cursor.moveToNext());
        }
        return list;
    }
    public ArrayList<DanhSachSanPhamDTO> timKiemP1(String tensp){
        ArrayList<DanhSachSanPhamDTO> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=myDBHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM  tb_san_pham WHERE ten_san_pham LIKE '%" + tensp + "%' AND loai LIKE 'Phần 1' ", null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new DanhSachSanPhamDTO(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getString(7), cursor.getString(8)));
            } while (cursor.moveToNext());
        }

        return list;
    }
    public ArrayList<DanhSachSanPhamDTO> timKiemP2(String tensp){
        ArrayList<DanhSachSanPhamDTO> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=myDBHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM  tb_san_pham WHERE ten_san_pham LIKE '%" + tensp + "%' AND loai LIKE 'Phần 2' ", null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new DanhSachSanPhamDTO(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getString(7), cursor.getString(8)));
            } while (cursor.moveToNext());
        }

        return list;
    }
    public ArrayList<DanhSachSanPhamDTO> timKiemP3(String tensp){
        ArrayList<DanhSachSanPhamDTO> list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=myDBHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM  tb_san_pham WHERE ten_san_pham LIKE '%" + tensp + "%' AND loai LIKE 'Phần 3' ", null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new DanhSachSanPhamDTO(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getString(7), cursor.getString(8)));
            } while (cursor.moveToNext());
        }

        return list;
    }
}
