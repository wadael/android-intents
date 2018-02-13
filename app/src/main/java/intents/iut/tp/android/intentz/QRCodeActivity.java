package intents.iut.tp.android.intentz;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import intents.iut.tp.android.intentz.R;

public class QRCodeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        try {
            Intent intent = new Intent("com.google.zxing.client.android.SCAN");
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE"); // "PRODUCT_MODE for bar codes
            startActivityForResult(intent, 0);
        } catch (Exception e) {
            Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
            Intent marketIntent = new Intent(Intent.ACTION_VIEW, marketUri);
            startActivity(marketIntent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = data.getStringExtra("SCAN_RESULT");
                TextView tvqr = findViewById(R.id.tv_qr);
                tvqr.setText(contents);
            }

            if (resultCode == RESULT_CANCELED) {
                //handle cancel
                LinearLayout layout_qr = findViewById(R.id.layout_qr);
                ImageView iv_qr = new ImageView(this);
                iv_qr.setImageDrawable( getDrawable(R.drawable.qrcode) );
                iv_qr.setMinimumHeight(100);
                iv_qr.setMinimumWidth(100);
                iv_qr.setVisibility(View.VISIBLE);

                layout_qr.addView(iv_qr);
            }
        }
    }


}
