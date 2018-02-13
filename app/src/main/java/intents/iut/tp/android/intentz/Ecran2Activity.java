package intents.iut.tp.android.intentz;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import intents.iut.tp.android.intentz.R;

public class Ecran2Activity extends Activity {

    public static final String ETAT_D_AME = "etadame";
    public static final String ETAT_D_AME_CONTENT = "youpi";
    public static final String ETAT_D_AME_PAS_CONTENT = "pakontan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(ETAT_D_AME, "onCreate");
        setContentView(R.layout.activity_ecran2);

        String tonEtatDAme = getIntent().getStringExtra(ETAT_D_AME) ;
        ImageView imageView = findViewById(R.id.imageView);

        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate_pic);
        imageView.startAnimation(rotate);

        switch(tonEtatDAme){
            case ETAT_D_AME_CONTENT:
                imageView.setImageResource(R.drawable.happy );
                Log.d(ETAT_D_AME, "happy");
                break;
            case ETAT_D_AME_PAS_CONTENT:
                //imageView.setImageDrawable( getDrawable( R.drawable.nothappy) );
                imageView.setImageResource(R.drawable.nothappy);
                Log.d(ETAT_D_AME, "not happy");
                break;
        }

        Log.d(ETAT_D_AME, "Valeur: " + tonEtatDAme);
        Log.d(ETAT_D_AME, "Fin");
    }
}
