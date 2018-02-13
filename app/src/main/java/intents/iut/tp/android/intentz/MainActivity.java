package intents.iut.tp.android.intentz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import intents.iut.tp.android.intentz.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_qrreader = findViewById(R.id.btn_qrreader);
        btn_qrreader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goQr = new Intent(v.getContext(), QRCodeActivity.class);
                startActivity(goQr);
            }
        });


    }

    public void onClickAllerEcran2(View view){
        Intent intent = new Intent(this, Ecran2Activity.class);

        RadioGroup rg = findViewById(R.id.etatdame);
        int radioSelection = rg.getCheckedRadioButtonId();

        Log.d("GoScreen2","radio id= " + radioSelection);

        switch (radioSelection){
            case R.id.rb_c:
                intent.putExtra(Ecran2Activity.ETAT_D_AME,Ecran2Activity.ETAT_D_AME_CONTENT);
                break;
            case R.id.rb_pc:
                intent.putExtra(Ecran2Activity.ETAT_D_AME,Ecran2Activity.ETAT_D_AME_PAS_CONTENT);
                break;
        }

    if(radioSelection == -1){
        Toast.makeText(this,"Il faut choisir", Toast.LENGTH_SHORT).show();
    }else
        startActivity(intent);
    }


    public void onClickCallMeMaybe(View view){
        Uri number = Uri.parse("tel:0628000000");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }
}
