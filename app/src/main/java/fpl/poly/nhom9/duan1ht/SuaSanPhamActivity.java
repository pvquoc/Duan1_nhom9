package fpl.poly.nhom9.duan1ht;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import fpl.poly.nhom9.duan1ht.DAO.TrangChuAdminDAO;
import fpl.poly.nhom9.duan1ht.DBHelper.MyDBHelper;
import fpl.poly.nhom9.duan1ht.DTO.SanPhamTrangChuDTO;

public class SuaSanPhamActivity extends AppCompatActivity {
    EditText edtSuatensp, edtSuaGiasp, edtSuaNhaCungCap, edtSuaMoTa;
    AppCompatButton btnSuasp;
    Spinner spnCategorySuaSp;
    ImageView ivBack;
    private SanPhamTrangChuDTO dto;

    private TrangChuAdminDAO dao;

    private MyDBHelper dbHelper;

    int positionSpinner = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_san_pham);

        edtSuatensp = findViewById(R.id.edtSuaTenSp);
        edtSuaGiasp = findViewById(R.id.edtSuaGiaSp);
        btnSuasp = findViewById(R.id.btnSuaSp);
        edtSuaNhaCungCap = findViewById(R.id.edtSuaNhaCungCap);
        edtSuaMoTa = findViewById(R.id.edtSuaMoTa);
        spnCategorySuaSp = findViewById(R.id.spnCategorySuaSp);
        ivBack = findViewById(R.id.ivBackSuaSp);


        dbHelper = new MyDBHelper(SuaSanPhamActivity.this);
        dao = new TrangChuAdminDAO(SuaSanPhamActivity.this);
        getDataIntent();

        getDataAdmin(spnCategorySuaSp);
        btnSuasp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newName = edtSuatensp.getText().toString().trim();
                String newPrice = edtSuaGiasp.getText().toString().trim();
                String mota = edtSuaMoTa.getText().toString().trim();

                if (newName.equals("") || String.valueOf(newPrice).equals("")) {
                    Toast.makeText(SuaSanPhamActivity.this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    boolean result = dao.SuaSanPham(dto.getId_san_pham(), newName, Integer.parseInt(newPrice), mota, getTenLoai((int) spnCategorySuaSp.getSelectedItemId()));
                    if (result) {
                        Toast.makeText(SuaSanPhamActivity.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    }
                }
            }
        });
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
    }
    private String getTenLoai(int positionSpinner) {
        String tenLoai = "";

        switch (positionSpinner) {
            case 0:
                tenLoai = "Phần 1";
                break;
            case 1:
                tenLoai = "Phần 2";
                break;
            case 2:
                tenLoai = "Phần 3";
                break;
        }
        return tenLoai;
    }
    private void getDataAdmin(Spinner spinnerAdmin) {
        ArrayList<String> list = new ArrayList<>();
        list.add(new String("Phần 1"));
        list.add(new String("Phần 2"));
        list.add(new String("Phần 3"));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        spinnerAdmin.setAdapter(adapter);
        spinnerAdmin.setSelection(positionSpinner);
    }
    private void getDataIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            dto = (SanPhamTrangChuDTO) intent.getSerializableExtra("dto");
            edtSuatensp.setText(dto.getTen_san_pham());
            edtSuaGiasp.setText(String.valueOf(dto.getDon_gia()));
            edtSuaNhaCungCap.setText(dto.getNhacungcap());
            edtSuaMoTa.setText(dto.getMo_ta());
            edtSuaMoTa.setText(dto.getMo_ta());


            switch (dto.getLoai()) {
                case "Phần 1":
                    positionSpinner = 0;
                    break;
                case "Phần 2":
                    positionSpinner = 1;
                    break;
                case "Phần 3":
                    positionSpinner = 2;
                    break;
            }
            spnCategorySuaSp.setSelection(positionSpinner);
        }
    }
}