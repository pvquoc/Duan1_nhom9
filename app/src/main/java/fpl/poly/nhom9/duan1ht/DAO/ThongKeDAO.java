package fpl.poly.nhom9.duan1ht.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fpl.poly.nhom9.duan1ht.DBHelper.MyDBHelper;
import fpl.poly.nhom9.duan1ht.DTO.DanhSachSanPhamDTO;
import fpl.poly.nhom9.duan1ht.DTO.GioHangDTO;

public class ThongKeDAO {
    MyDBHelper myDBHelper;
    SQLiteDatabase sqLiteDatabase;
    public ThongKeDAO(Context context){
        myDBHelper=new MyDBHelper(context);
    sqLiteDatabase=myDBHelper.getWritableDatabase();
    }
    public int getDoanhThu(String ngaybatdau, String ngayketthuc){
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT SUM(tong_tien) FROM tb_hoa_don WHERE ngay_dat  BETWEEN ? AND ? AND trang_thai LIKE '%Đã thanh toán%' ",new String[]{ngaybatdau, ngayketthuc});
        ArrayList<Integer> list = new ArrayList<>();

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                try {
                    int doanhthu = cursor.getInt(0);
                    list.add(doanhthu);
                }catch (Exception e){
                    list.get(0);
                }
                cursor.moveToNext();

            }

        }
        return list.get(0);
    }
    public ArrayList<GioHangDTO> getTop10(){
            ArrayList<GioHangDTO>list= new ArrayList<>();
           SQLiteDatabase sqLiteDatabase= myDBHelper.getReadableDatabase();
             Cursor cursor=sqLiteDatabase.rawQuery("Select sp.img_url,hd.id_san_pham,sp.ten_san_pham,COUNT(hd.id_san_pham) FROM tb_san_pham sp,tb_hoa_don hd WHERE sp.id_san_pham=hd.id_san_pham and hd.trang_thai LIKE '%Đã thanh toán%' GROUP BY hd.id_san_pham,sp.ten_san_pham ORDER BY COUNT(hd.id_san_pham) DESC LIMIT 10",null);
             if (cursor.getCount()!=0){
              cursor.moveToFirst();
              do {
             list.add(new GioHangDTO(cursor.getString(0),cursor.getInt(1),cursor.getString(2),cursor.getInt(3)));
              }while (cursor.moveToNext());
             }
             return list;
    }
}
