package com.vermilion.perpusapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_activity_utama);
        replaceFragment(new Beranda());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager             = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction     = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_tambah_buku:
                Toast.makeText(this, "Tambah Buku", Toast.LENGTH_SHORT).show();
                replaceFragment(new TambahBuku());
                return true;

            case R.id.menu_list_buku:
                Toast.makeText(this, "List Buku", Toast.LENGTH_SHORT).show();
                replaceFragment(new Beranda());
                return true;

            case R.id.menu_keluar:
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Peringatan");
                alertDialog.setMessage("Apakah anda yakin untuk keluar dari aplikasi ?");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Tidak",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }
                );
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Ya",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Terimakasih", Toast.LENGTH_SHORT).show();
                                System.exit(0);
                            }
                        }
                );
                alertDialog.show();
                return true;

            default:
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }
    }
}