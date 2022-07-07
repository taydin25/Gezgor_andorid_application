package com.example.mdpro;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class places extends AppCompatActivity {
    static boolean clicked[]=new boolean[1000];
    TextView txt_name,iabcity,iabcity2,iabcity3,iabcity4,iabcity5,iabcity6;//text views for information about city.
    ImageView image,image2,image3,image4,image5,image6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        //For camera and galery uploading
        image=findViewById(R.id.image);
        image2=findViewById(R.id.image2);
        image3=findViewById(R.id.image3);
        image4=findViewById(R.id.image4);
        image5=findViewById(R.id.image5);
        image6=findViewById(R.id.image6);
        txt_name=findViewById(R.id.inf);
        iabcity=findViewById(R.id.infocity);
        iabcity2=findViewById(R.id.infocity2);
        iabcity3=findViewById(R.id.infocity3);
        iabcity4=findViewById(R.id.infocity4);
        iabcity5=findViewById(R.id.infocity5);
        iabcity6=findViewById(R.id.infocity6);
        Intent receiveIntent = this.getIntent();
        String city2 =receiveIntent.getStringExtra("city2");
        System.out.println("şehir " +city2);


        if(        city2.equals("İstanbul") || city2.equals("Ankara") || city2.equals("Antakya") || city2.equals("Kocaeli")
                || city2.equals("İzmir") || city2.equals("Tokat") || city2.equals("Mardin") || city2.equals("Hakkari")
                || city2.equals("Malatya") || city2.equals("Gaziantep") || city2.equals("Şanlıurfa") || city2.equals("Adıyaman")
                || city2.equals("Adana") || city2.equals("Diyarbakır") || city2.equals("Trabzon") || city2.equals("Rize")
                || city2.equals("Erzurum") || city2.equals("Batman") || city2.equals("Yalova") || city2.equals("Edirne")
                || city2.equals("Erzincan") || city2.equals("Van") || city2.equals("Ağrı") || city2.equals("Iğdır")
                || city2.equals("Sivas") || city2.equals("Mersin") || city2.equals("Niğde") || city2.equals("Karaman")
                || city2.equals("Nevşehir") || city2.equals("Kırşehir") || city2.equals("Konya") || city2.equals("Antalya")
                || city2.equals("Uşak") || city2.equals("Denizli") || city2.equals("Isparta") || city2.equals("Kütahya")
                || city2.equals("Muğla") || city2.equals("Aydın") || city2.equals("Manisa") || city2.equals("Balıkesir")
                || city2.equals("Artvin") || city2.equals("Samsun") || city2.equals("Çanakkale") || city2.equals("Bursa")
                || city2.equals("Muş") || city2.equals("Çorum") || city2.equals("Kırklareli") || city2.equals("Bolu")
                || city2.equals("Karabük") || city2.equals("Kastamonu") || city2.equals("Yozgat") || city2.equals("Kilis")
                || city2.equals("Kayseri") || city2.equals("Zonguldak") || city2.equals("Sakarya") || city2.equals("Düzce")
                || city2.equals("Tunceli")|| city2.equals("Amasya")|| city2.equals("Kırıkkale")|| city2.equals("Ordu")
                || city2.equals("Ardahan")|| city2.equals("Kars")|| city2.equals("Bayburt")|| city2.equals("Gümüşhane")
                || city2.equals("Siirt")|| city2.equals("Bingöl")|| city2.equals("Giresun")|| city2.equals("Sinop")|| city2.equals("Tekirdağ")
                || city2.equals("Osmaniye")|| city2.equals("Eskişehir")|| city2.equals("Afyonkarahisar")|| city2.equals("Burdur")
                || city2.equals("Kahramanmaraş")|| city2.equals("Şırnak")   || city2.equals("Elazığ")  || city2.equals("Hatay")
                || city2.equals("Aksaray")){
            txt_name.setText(city2);
        }


        if( city2.equals("İstanbul")){
            iabcity.setText("Topkapı Sarayı");
            iabcity2.setText("İstanbul Boğazı");
            iabcity3.setText("Sultanahmet Cami");
            iabcity4.setText("Yerebatan Sarnıcı");
            iabcity5.setText("Ayasofya");
            iabcity6.setText("Galata Kulesi");
        }
        else if( city2.equals("Ankara")) {
            iabcity.setText("Ankara Kalesi");
            iabcity2.setText("Tuz Gölü");
            iabcity3.setText("Augustus Tapınağı");
            iabcity4.setText("Jülien Sütunu");
            iabcity5.setText("Ankara Bağ Evi");
            iabcity6.setText("Anıtkabir");
        }
        else if( city2.equals("İzmir")) {
            iabcity.setText("Bergama");
            iabcity2.setText("Alaçatı");
            iabcity3.setText("İzmir Kültürpark");
            iabcity4.setText("Dario Moreno Sokağı");
            iabcity5.setText("Kalem Adası");
            iabcity6.setText("Homeros Vadisi");
        }
        else if( city2.equals("Erzurum")) {
            iabcity.setText("Palandöken");
            iabcity2.setText("Erzurum Kalesi");
            iabcity3.setText("Üç Kümbetler");
            iabcity4.setText("Çifte Minareli Medrese");
            iabcity5.setText("Tortum Şelalesi");
            iabcity6.setText("Nene Hatun Tarihi Milli Parkı");
        }
            else if(city2.equals("Hatay")) {
            iabcity.setText("St. Pierre Kilisesi");
            iabcity2.setText("Beşikli Mağara");
            iabcity3.setText("Antakya Mozaik Müzesi");
            iabcity4.setText("Hatay Uzun Çarşı");
            iabcity5.setText("Payas Kalesi");
            iabcity6.setText("Asi Nehri");
        }
        else if(city2.equals("Kocaeli")) {
            iabcity.setText("Darıca Kuş Cenneti");
            iabcity2.setText("Selim Sırrı Paşa Konağı");
            iabcity3.setText("Tahtalı Göleti");
            iabcity4.setText("Babalı Köyü") ;
            iabcity5.setText("İnönü Yaylası");
            iabcity6.setText("Seyrek Kalesi");
        }
        else if(city2.equals("Gümüşhane")) {
            iabcity.setText("Karaca Mağarası");

        }
        else if(city2.equals("Edirne")) {
            iabcity.setText("Karaağaç");
            iabcity2.setText("Selimiye Camii");
            iabcity3.setText("Edirne Buyuk Sinagogu");
            iabcity4.setText("Enez Kalesi") ;
            iabcity5.setText("Rüstem Paşa Kervansarayı");
            iabcity6.setText("Sweti George Bulgar Kilisesi");
        }
        else if(city2.equals("Kırıkkale")) {
            iabcity.setText("Sulu Mağara");
            iabcity2.setText("Hasandede Camii");
            iabcity3.setText("Silah Sanayi Müzesi");
            iabcity4.setText("Kırıkkale Tren Garı") ;
            iabcity5.setText("Lavanta Vadisi");
            iabcity6.setText("Çeşnigir Köprüsü");
        }
        else if(city2.equals("Konya")) {
            iabcity.setText("Mevlana Müzesi");
            iabcity2.setText("Karatay Medresesi");
            iabcity3.setText("Konya Arkeoloji Müzesi");
            iabcity4.setText("Konya Ereğli Müzesi") ;
            iabcity5.setText("İstiklal Harbi Şehitleri Abidesi");
            iabcity6.setText("Alaeddin Tepesi");
        }
        else if(city2.equals("Antalya")) {
            iabcity.setText("Alanya");
            iabcity2.setText("Aspendos Antik Kenti");
            iabcity3.setText("Antalya Hayvanat Bahçesi");
            iabcity4.setText("Karain Mağarası") ;
            iabcity5.setText("Manavgat Şelalesi");
            iabcity6.setText("Köprülü Kanyon");
        }
        else if(city2.equals("Bursa")) {
            iabcity.setText("Uludağ");
            iabcity2.setText("Podyum Park");
            iabcity3.setText("İnegöl");
            iabcity4.setText("Gemlik") ;
            iabcity5.setText("Bursa Ulu Camii");
            iabcity6.setText("Gölyazı");
        }
        else if(city2.equals("Çanakkale")) {
            iabcity.setText("Assos Antik Kenti");
            iabcity2.setText("Troya Müzesi");
            iabcity3.setText("Aynalı Çarşı");
            iabcity4.setText("Biga Çayı") ;
            iabcity5.setText("Seddülbahir Savaş Müzesi");
            iabcity6.setText("Bozcaada Müzesi");
        }else if(city2.equals("Rize")) {
            iabcity.setText("Zil Kalesi");
            iabcity2.setText("Palovit Şelalesi");
            iabcity3.setText("Anzer Yaylası");
            iabcity4.setText("Zil Kalesi") ;
            iabcity5.setText("Fırtına Deresi");
            iabcity6.setText("Çağrankaya Yaylası");
        }
        else if(city2.equals("Van")) {
            iabcity.setText("Akdamar Adası");
            iabcity2.setText("Van Gölü");
            iabcity3.setText("Van Kalesi");
            iabcity4.setText("Akdamar Kilisesi") ;
            iabcity5.setText("Muradiye Şelalesi");
            iabcity6.setText("Hoşap Kalesi");
        }
        else if(city2.equals("Şanlıurfa")) {
            iabcity.setText("Şehrazad Konağı");
            iabcity2.setText("Şanlıurfa Kalesi");
            iabcity3.setText("Rizvaniye Cami");
            iabcity4.setText("Göbeklitepe") ;
            iabcity5.setText("Halfeti Antik Kenti");
            iabcity6.setText("Atatürk Barajı");
        }
        else if(city2.equals("Kahramanmaraş")) {
            iabcity.setText("Bakırcılar Çarşısı");
            iabcity2.setText("Maraş Ulu Camii");
            iabcity3.setText("Eshab-ı Kehf Külliyesi");
            iabcity4.setText("Germenicia Antik Kenti") ;
            iabcity5.setText("Döngel Şelalesi");
            iabcity6.setText("Ceyhan Köprüsü");
        }
        else if(city2.equals("Gaziantep")) {
            iabcity.setText("Şahinbey Millî Mücadele Müzesi");
            iabcity2.setText("Emine Göğüş Mutfak Müzesi");
            iabcity3.setText("Zeugma Mozaik Müzesi");
            iabcity4.setText("Kaleoğlu Mağarası") ;
            iabcity5.setText("Tarihi Naib Hamamı");
            iabcity6.setText("Gaziantep Kalesi");
        }
        else if(city2.equals("Aydın")) {
            iabcity.setText("Güzelçamlı Milli Park");
            iabcity2.setText("Nysa Antik Kenti");
            iabcity3.setText("Arapapıştı Kanyonu");
            iabcity4.setText("Zeus Mağarası") ;
            iabcity5.setText("Yörük Ali Efe Müzesi");
            iabcity6.setText("Aydın Müzesi");
        }
        else if(city2.equals("Denizli")) {
            iabcity.setText("Pamukkale Travertenleri");
            iabcity2.setText("Hierapolis Antik Kenti");
            iabcity3.setText("Güney Şelalesi");
            iabcity4.setText("Kaleiçi Çarşısı") ;
            iabcity5.setText("Tripolis Antik Kenti");
            iabcity6.setText("Denizli UFO Müzesi");
        }
        else if(city2.equals("Uşak")) {
            iabcity.setText("Uşak Bedesteni");
            iabcity2.setText("Blaundos Antik Kenti");
            iabcity3.setText("Uşak Atatürk ve Etnografya Müzesi");
            iabcity4.setText("Hamamboğazı Kaplıcaları") ;
            iabcity5.setText("İnay Kervansarayı");
            iabcity6.setText("Aksaz Kaplıcası");
        }
        else if(city2.equals("Afyonkarahisar")) {
            iabcity.setText("Afyon Karahisar Kalesi");
            iabcity2.setText("Hüdai Kaplıcaları");
            iabcity3.setText("İscehisar Peri Bacaları");
            iabcity4.setText("Başkomutanlık Tarihi Milli Parkı") ;
            iabcity5.setText("Kırkgöz Köprüsü");
            iabcity6.setText("Ayazin Köyü");
        }
        else if(city2.equals("Adana")) {
            iabcity.setText("Kapıkaya Kanyonu ");
            iabcity2.setText("Adana Arkeoloji Müzesi");
            iabcity3.setText("Adana Ulu Cami");
            iabcity4.setText("Yumurtalık Plajı") ;
            iabcity5.setText("Bebekli Kilise");
            iabcity6.setText("Varda Köprüsü");
        }
        else if(city2.equals("Sivas")) {
            iabcity.setText("Tödürge Gölü");
            iabcity2.setText("Divriği Ulu Camii");
            iabcity3.setText("Çaltı Çayı");
            iabcity4.setText("Sivas Çifte Minareli Medrese") ;
            iabcity5.setText("Sivas Kale Camii");
            iabcity6.setText("Kızılırmak");
        }
        else if(city2.equals("Mersin")) {
            iabcity.setText("Yapraklı Koyu");
            iabcity2.setText("Erdemli Talat Göktepe Çamlığı");
            iabcity3.setText("Kayacı Vadisi");
            iabcity4.setText("Sertavul Geçidi") ;
            iabcity5.setText("Adam Kayalar");
            iabcity6.setText("Cennet Cehennem Mağaraları");
        }
        else if(city2.equals("Diyarbakır")) {
            iabcity.setText("Malabadi Köprüsü");
            iabcity2.setText("Diyarbakır Surları");
            iabcity3.setText("Dicle Nehri");
            iabcity4.setText("Hevsel Bahçeleri") ;
            iabcity5.setText("Sülüklü Han");
            iabcity6.setText("Hasan Paşa Hanı");
        }
        else if(city2.equals("Eskişehir")) {
            iabcity.setText("Porsuk Çayı ");
            iabcity2.setText("Gürleyik Şelalesi");
            iabcity3.setText("Sivrihisar Ulu Camii");
            iabcity4.setText("Eskişehir Hamamları") ;
            iabcity5.setText("Haller Gençlik Merkezi");
            iabcity6.setText("Musaözü Göleti");
        }
        else if(city2.equals("Giresun")) {
            iabcity.setText("Giresun Kalesi");
            iabcity2.setText("Kümbet Yaylası");
            iabcity3.setText("Giresun Adası");
            iabcity4.setText("Giresun Müzesi") ;
            iabcity5.setText("Kuzalan Şelalesi");
            iabcity6.setText("Şebinkarahisar Kalesi");
        }
        else if(city2.equals("Manisa")) {
            iabcity.setText("Kurşunlu Kaplıcaları");
            iabcity2.setText("Urganlı Kaplıcaları");
            iabcity3.setText("Sart Antik Kenti");
            iabcity4.setText("Manisa Muradiye Camii") ;
            iabcity5.setText("Kuladokya Kula Peri Bacaları");
            iabcity6.setText("Bintepe Tümülüsleri");
        }
        else if(city2.equals("Isparta")) {
            iabcity.setText("Davraz Kayak Merkezi");
            iabcity2.setText("Kovada Gölü Milli Parkı");
            iabcity3.setText("Lavanta Vadisi");
            iabcity4.setText("Adada Antik Kenti") ;
            iabcity5.setText("Antiocheia Antik Kenti");
            iabcity6.setText("Zindan Mağarası");
        }
        else if(city2.equals("Malatya")) {
            iabcity.setText("Günpınar Şelalesi");
            iabcity2.setText("Levent Vadisi");
            iabcity3.setText("Malatya Müzesi");
            iabcity4.setText("Malatya Kalesi") ;
            iabcity5.setText("Silahtar Mustafa Paşa Kervansarayı");
            iabcity6.setText("Battalgazi Ulu Cami");
        }
        else if(city2.equals("Samsun")) {
            iabcity.setText("Samsun Hayvanat Bahçesi");
            iabcity2.setText("Samsun Gazi Müzesi");
            iabcity3.setText("Kabaceviz Şelaleleri");
            iabcity4.setText("Akdağ Kayak Merkezi") ;
            iabcity5.setText("Sarıgazel Tabiat Parkı");
            iabcity6.setText("Atakum Sahil Şeridi");
        }
        else if(city2.equals("Kastamonu")) {
            iabcity.setText("Gideros Koyu");
            iabcity2.setText("Kastamonu Kalesi");
            iabcity3.setText("Küre Dağları Milli Parkı");
            iabcity4.setText("Dipsizgöl Tabiat Parkı") ;
            iabcity5.setText("Kastamonu Arkeoloji Müzesi");
            iabcity6.setText("Kastamonu Konakları");
        }else if(city2.equals("Balıkesir")) {
            iabcity.setText("Avşa Adası");
            iabcity2.setText("Cunda Adası");
            iabcity3.setText("Altınoluk");
            iabcity4.setText("Akçay") ;
            iabcity5.setText("Şeytan Sofrası");
            iabcity6.setText("Kaz Dağı");
        }else if(city2.equals("Ordu")) {
            iabcity.setText("Çambaşı Yaylası");
            iabcity2.setText("Perşembe Yaylası");
            iabcity3.setText("Yason Burnu");
            iabcity4.setText("Gaga Gölü") ;
            iabcity5.setText("Ulugöl Tabiat Parkı");
            iabcity6.setText("Turnasuyu Vadisi");
        }else if(city2.equals("Sakarya")) {
            iabcity.setText("Maşukiye");
            iabcity2.setText("Acarlar Longozu");
            iabcity3.setText("Poyrazlar Gölü");
            iabcity4.setText("Sakarya Müzesi") ;
            iabcity5.setText("Maden Deresi");
            iabcity6.setText("Sapanca Soğucak Yaylası");
        }else if(city2.equals("Kayseri")) {
            iabcity.setText("Erciyes Dağı");
            iabcity2.setText("Kayseri Kalesi");
            iabcity3.setText("Kapuzbaşı Şelaleleri");
            iabcity4.setText("Şah Cihan Hatun Kümbeti") ;
            iabcity5.setText("Kayseri Cumhuriyet Meydanı ");
            iabcity6.setText("Sultan Sazlığı Milli Parkı");
        }else if(city2.equals("Nevşehir")) {
            iabcity.setText("Uçhisar Kalesi");
            iabcity2.setText("Göreme Açık Hava Müzesi");
            iabcity3.setText("Güvercinlik Vadisi");
            iabcity4.setText("Kaymaklı Yeraltı Şehri") ;
            iabcity5.setText("Güray Müze");
            iabcity6.setText("Devrent Vadisi");
        }else if(city2.equals("Aksaray")) {
            iabcity.setText("Belisırma Köyü");
            iabcity2.setText("Bahattin Samanlığı Kilisesi");
            iabcity3.setText("Karagedik Kilisesi");
            iabcity4.setText("Acemhöyük") ;
            iabcity5.setText("Ziga Kaplıcaları");
            iabcity6.setText("Aksaray Müzesi");
        }else if(city2.equals("Bingöl")) {
            iabcity.setText("Kale Tepesi");
            iabcity2.setText("Sülbüs Dağı");
            iabcity3.setText("Kanireş Barajı");
            iabcity4.setText("Sebeterias Kalesi") ;
            iabcity5.setText("Çır Şelalesi");
            iabcity6.setText("Bingöl Hesarek Kayak Merkezi");
        }else if(city2.equals("Tokat")) {
            iabcity.setText("Ballıca Mağarası");
            iabcity2.setText("Niksar Kalesi");
            iabcity3.setText("Sulusaray Antik Kenti");
            iabcity4.setText("Tokat Atatürk Evi") ;
            iabcity5.setText("Zile Kalesi");
            iabcity6.setText("Mahperi Hatun Kervansarayı");
        }else if(city2.equals("Tekirdağ")) {
            iabcity.setText("Rüstem Paşa Camii ");
            iabcity2.setText("Rakoczi Müzesi");
            iabcity3.setText("Namık Kemal Evi");
            iabcity4.setText("Kumbağ") ;
            iabcity5.setText("Tekirdağ Şehitler Abidesi");
            iabcity6.setText("Marmara Ereğlisi");
        }else if(city2.equals("Kütahya")) {
            iabcity.setText("Murat Dağı Kaplıcaları");
            iabcity2.setText("Kütahya Çinili Camii");
            iabcity3.setText("Kütahya Kalesi");
            iabcity4.setText("Kütahya Ulu Camii") ;
            iabcity5.setText("Kütahya Zafertepe Anıtı");
            iabcity6.setText("Kütahya Arkeoloji Müzesi");
        }
        /*else if(city2.equals("")) {
            iabcity.setText("");
            iabcity2.setText("");
            iabcity3.setText("");
            iabcity4.setText("") ;
            iabcity5.setText("");
            iabcity6.setText("");
        }*/
        //send infos to maps activity
        Intent intent = new Intent(places.this,MapsActivity.class);
        iabcity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("Pretty_places",iabcity.getText());
                startActivity(intent);
            }
        });
        iabcity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("Pretty_places",iabcity2.getText());
                startActivity(intent);
            }
        });
        iabcity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("Pretty_places",iabcity3.getText());
                startActivity(intent);
            }
        });
        iabcity4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("Pretty_places",iabcity4.getText());
                startActivity(intent);
            }
        });
        iabcity5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("Pretty_places",iabcity5.getText());
                startActivity(intent);
            }
        });
        iabcity6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("Pretty_places",iabcity6.getText());
                startActivity(intent);
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                boolean pick=true;
                clicked[0]=true;
                clicked[1]=false;
                clicked[2]=false;
                clicked[3]=false;
                clicked[4]=false;
                clicked[5]=false;
                if(pick==true){
                    if(!checkCameraPermission()){
                        requestCameraPermission();
                    }else PickImage();
                }else{
                    if(!checkStoragePermission()){
                        requestStoragePermission();
                    }else PickImage();
                }
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                boolean pick=true;
                clicked[0]=false;
                clicked[1]=true;
                clicked[2]=false;
                clicked[3]=false;
                clicked[4]=false;
                clicked[5]=false;
                if(pick==true){
                    if(!checkCameraPermission()){
                        requestCameraPermission();
                    }else PickImage();
                }else{
                    if(!checkStoragePermission()){
                        requestStoragePermission();
                    }else PickImage();
                }
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                boolean pick=true;
                clicked[0]=false;
                clicked[1]=false;
                clicked[2]=true;
                clicked[3]=false;
                clicked[4]=false;
                clicked[5]=false;
                if(pick==true){
                    if(!checkCameraPermission()){
                        requestCameraPermission();
                    }else PickImage();
                }else{
                    if(!checkStoragePermission()){
                        requestStoragePermission();
                    }else PickImage();
                }
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                boolean pick=true;
                clicked[0]=false;
                clicked[1]=false;
                clicked[2]=false;
                clicked[3]=true;
                clicked[4]=false;
                clicked[5]=false;
                if(pick==true){
                    if(!checkCameraPermission()){
                        requestCameraPermission();
                    }else PickImage();
                }else{
                    if(!checkStoragePermission()){
                        requestStoragePermission();
                    }else PickImage();
                }
            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                boolean pick=true;
                clicked[0]=false;
                clicked[1]=false;
                clicked[2]=false;
                clicked[3]=false;
                clicked[4]=true;
                clicked[5]=false;
                if(pick==true){
                    if(!checkCameraPermission()){
                        requestCameraPermission();
                    }else PickImage();
                }else{
                    if(!checkStoragePermission()){
                        requestStoragePermission();
                    }else PickImage();
                }
            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                boolean pick=true;
                clicked[0]=false;
                clicked[1]=false;
                clicked[2]=false;
                clicked[3]=false;
                clicked[4]=false;
                clicked[5]=true;
                if(pick==true){
                    if(!checkCameraPermission()){
                        requestCameraPermission();
                    }else PickImage();
                }else{
                    if(!checkStoragePermission()){
                        requestStoragePermission();
                    }else PickImage();
                }
            }
        });
    }
    //Methods for camera and gallery
    private void PickImage() {
        CropImage.activity().start(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void requestStoragePermission() {
        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void requestCameraPermission() {
        requestPermissions(new String[]{Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
    }

    private boolean checkStoragePermission() {
        boolean res2=ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED;
        return res2;
    }

    private boolean checkCameraPermission() {
        boolean res1= ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED;
        boolean res2= ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED;
        return res1 && res2;
    }

    //bu kısıma dikkatli bak------------------------------------------------------
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                if(clicked[0]==true) Picasso.with(this).load(resultUri).into(image);
                else if(clicked[1]==true)  Picasso.with(this).load(resultUri).into(image2);
                else if(clicked[2]==true)  Picasso.with(this).load(resultUri).into(image3);
                else if(clicked[3]==true)  Picasso.with(this).load(resultUri).into(image4);
                else if(clicked[4]==true)  Picasso.with(this).load(resultUri).into(image5);
                else if(clicked[5]==true)  Picasso.with(this).load(resultUri).into(image6);

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}