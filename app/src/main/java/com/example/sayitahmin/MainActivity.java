package com.example.sayitahmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Değişkenlerimizi tanımladık.
    Button tahminEt, yenidenOyna;
    EditText gelenSayi;
    public int rastgeleSayi;
    public int girilenSayi;
    TextView tv,dn;
    int sayac;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Tasarım kısmında verdiğimiz id ye göre nesnelerimizi atıyoruz.
        tahminEt = (Button) findViewById(R.id.gonder);
        yenidenOyna = (Button) findViewById(R.id.tekrar);
        gelenSayi = (EditText) findViewById(R.id.gelen);
        tv = (TextView) findViewById(R.id.tahmin);
        dn = (TextView) findViewById(R.id.deneme);
        sayac = 0;
        rastgeleSayi = (int) (((Math.random()) * 100) + 1);
        yenidenOyna.setEnabled(false); // oyun bir kez bitmeden yeniden oyna butonu aktif olmaması için

        tahminEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)

            {
                girilenSayi = Integer.parseInt(gelenSayi.getText().toString());
                sayac++;
                dn.setText(Integer.toString(sayac) +". deneme");
                if (girilenSayi > rastgeleSayi) {
                    //Toast.makeText(...) kısmı telefon bildirimi olarak bize gönderiyor.
                    Toast.makeText(MainActivity.this, "Daha Küçük Sayı Gir", Toast.LENGTH_SHORT).show();
                    tv.setText("Daha Küçük Sayı Giriniz");//Burada labela yazıyor
                } else if (girilenSayi < rastgeleSayi) {
                    Toast.makeText(MainActivity.this, "Daha Büyük Sayı Gir", Toast.LENGTH_SHORT).show();
                    tv.setText("Daha Büyük Sayı Giriniz");
                } else if (girilenSayi == rastgeleSayi) {
                    Toast.makeText(MainActivity.this, "Tebrikler Sayiyi Buldun !  Sayı : " + rastgeleSayi, Toast.LENGTH_SHORT).show();
                    tv.setText("Tebrikler, Dogru Bildiniz");
                    yenidenOyna.setEnabled(true); //oyun bitttikten sonra yeniden oyna butonu aktif olması için

                }

            }
        });


        yenidenOyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Yeniden 1-100 arasi rastgele bir sayi olusturduk. Sayacımızı ve labellarımızı sıfırladık.
                rastgeleSayi = (int) (((Math.random()) * 100) + 1);
                sayac =0;
                dn.setText("TAHMİN");
                tv.setText("DENEME");
                gelenSayi.setText("");
                // Kullaniciya oyunun yeniden basladigini iletiyoruz.
                Toast.makeText(MainActivity.this, "Oyun Yeniden Başladı !", Toast.LENGTH_SHORT).show();

            }
        });


    }
}