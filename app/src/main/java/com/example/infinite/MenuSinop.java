package com.example.infinite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infinite.utilidades.Links;
import com.example.infinite.utilidades.Sinopsis;
import com.squareup.picasso.Picasso;

public class MenuSinop extends AppCompatActivity {
    TextView Sinop;
    ImageView img;
    Toolbar toolbar;
    String título;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_sinop);
        Sinop = (TextView)findViewById(R.id.txt_sinopsis);
        img = (ImageView)findViewById(R.id.img_sinop);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        DetectarSinpo();
        setSupportActionBar(toolbar);
        if (getSupportActionBar()!=null)
        {
            //Para habilitar el botón de regresar
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            //Para mostrarlo
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }
        getSupportActionBar().setTitle(título);
        getSupportActionBar().setSubtitle("Sinopsis");

        /*Sinop.setText(Sinopsis.PANDARIA);
        img.setImageResource(R.drawable.mop_img);*/
    }

    public void DetectarSinpo(){
        try{
            Intent i = getIntent();
            Bundle datos = i.getExtras();
            int ID = (int)datos.get("idv");
            switch (ID){
                case 1:
                    Sinop.setText(Sinopsis.SINOPSIS_SHREK);
                    //img.setImageResource(R.drawable.video_not_found);
                    Picasso.get().load(Links.ShrekIMG1).into(img);
                    título = "Shrek";
                    break;
                case 2:
                    Sinop.setText(Sinopsis.SINOPSIS_SHREK2);
                    Picasso.get().load(Links.ShrekIMG2).into(img);
                    título = "Shrek 2";
                    break;

                case 3:
                    Sinop.setText(Sinopsis.SNIOPSIS_SHREK3);
                    Picasso.get().load(Links.ShrekIMG3).into(img);
                    título = "Shrek 3";
                    break;
                case 4:
                    Sinop.setText(Sinopsis.SINOPSIS_HOWTO);
                    Picasso.get().load(Links.HowToIMG1).into(img);
                    título = "Cómo entrenar a tu dragón";
                    break;
                case 5:
                    Sinop.setText(Sinopsis.SINOPSIS_HOWTO2);
                    Picasso.get().load(Links.HowTo2IMG2).into(img);
                    título = "Cómo entrenar a tu dragón 2";
                    break;

                case 6:
                    Sinop.setText(Sinopsis.SINOPSIS_HOWTO3);
                    Picasso.get().load(Links.HowTo3IMG3).into(img);
                    título = "Cómo entrenar a tu dragón 3";
                    break;
                case 7:
                    Sinop.setText(Sinopsis.SINOPSIS_SpaceJam);
                    Picasso.get().load(Links.SpaceJamIMG).into(img);
                    título = "Space Jam";
                    break;
                case 8:
                    Sinop.setText(Sinopsis.SINOPSIS_RIO);
                    Picasso.get().load(Links.RioIMG).into(img);
                    título = "Río";
                    break;

                case 9:
                    Sinop.setText(Sinopsis.SINOPSIS_INCREIBLES);
                    Picasso.get().load(Links.IncreiblesIMG).into(img);
                    título = "Los increíbles";
                    break;
                case 10:
                    Sinop.setText(Sinopsis.SINOPSIS_Tranformers);
                    Picasso.get().load(Links.TransformersIMG).into(img);
                    título = "Transformers";
                    break;
                case 11:
                    Sinop.setText(Sinopsis.SINOPSIS_CAP_AMERICA);
                    Picasso.get().load(Links.CapAImg).into(img);
                    título = "Capitán América: El primer vengador";
                    break;

                case 12:
                    Sinop.setText(Sinopsis.SINOPSIS_TOYSTORY);
                    Picasso.get().load(Links.ToyStoryImg).into(img);
                    título = "Toy Story";
                    break;
                case 13:
                    Sinop.setText(Sinopsis.SINOPSIS_AVENGERS);
                    Picasso.get().load(Links.AvengersIMG).into(img);
                    título = "Avengers";
                    break;
                case 14:
                    Sinop.setText(Sinopsis.SINOPSIS_Cars);
                    Picasso.get().load(Links.CarsIMG).into(img);
                    título = "Cars";
                    break;

                case 15:
                    Sinop.setText(Sinopsis.SINOPSIS_Deadpool);
                    Picasso.get().load(Links.DeadpoolImg).into(img);
                    título = "Deadpool";




                    break;
                case 16:
                    Sinop.setText(Sinopsis.SINOPSIS_TOYSTORY2);
                    Picasso.get().load(Links.ToyStory2Img).into(img);
                    título = "Toy Story 2";
                    break;
                case 17:
                    Sinop.setText(Sinopsis.SINOPSIS_TOYSTORY3);
                    Picasso.get().load(Links.ToyStory3Img).into(img);
                    título = "Toy Story 3";
                    break;

                case 18:
                    Sinop.setText(Sinopsis.SINOPSIS_Titanic);
                    Picasso.get().load(Links.TitanicIMG).into(img);
                    título = "Titanic";
                    break;
                case 19:
                    Sinop.setText(Sinopsis.SINOPSIS_AVENGERS2);
                    Picasso.get().load(Links.Avengers2IMG).into(img);
                    título = "Avengers: La era de Ultrón";
                    break;
                case 20:
                    Sinop.setText(Sinopsis.SINOPSIS_AVENGERS3);
                    Picasso.get().load(Links.Avengers3IMG).into(img);
                    título = "Avengers: Infinity war";
                    break;

                case 21:
                    Sinop.setText(Sinopsis.SINOPSIS_IT);
                    Picasso.get().load(Links.ItIMG).into(img);
                    título = "IT";
                    break;
                case 22:
                    Sinop.setText(Sinopsis.SINOPSIS_CAP_AMERICA2);
                    Picasso.get().load(Links.CapA2Img).into(img);
                    título = "Capián América: El soldado del invierno";
                    break;
                case 23:
                    Sinop.setText(Sinopsis.SINOPSIS_CAP_AMERICA3);
                    Picasso.get().load(Links.CapA3Img).into(img);
                    título = "Capitán América: Civil War";
                    break;

                case 24:
                    Sinop.setText(Sinopsis.SINOPSIS_INCREIBLES2);
                    Picasso.get().load(Links.Increibles2IMG).into(img);
                    título = "Los increíbles 2";
                    break;

                default:
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        catch (Exception e){
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    public void Movie(View view){
        Intent i2 = new Intent(this, Video.class);
        Intent i = getIntent();
        Bundle datos = i.getExtras();
        int ID = (int)datos.get("idv");
        String TakeID="";
        switch (ID)
        {
            case 1:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 2:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 3:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 4:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 5:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 6:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 7:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 8:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 9:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 10:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 11:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 12:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 13:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 14:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 15:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 16:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 17:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 18:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;

            case 19:
            i2.putExtra("idv", ID);
            startActivity(i2);
            break;
            case 20:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 21:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 22:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 23:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
            case 24:
                i2.putExtra("idv", ID);
                startActivity(i2);
                break;
        }
    }

    public boolean onOptionsItemSelected (MenuItem item)
    {
        //Sí el objeto item toma la Id de "home"

        /*if (item.getItemId()==android.R.id.home)
            finish();*/
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
