package com.luky_ponies.omoshiro2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class Lecture4Activity extends AppCompatActivity {

    private File mImageFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture4);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //カメラを起動
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File strageDir = getExternalFilesDir(null);
                mImageFile = new File(strageDir, "photo.jpg");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mImageFile));
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //写真の結果があれば
        if(resultCode == RESULT_OK){
//             Bitmap bitmap = data.getParcelableExtra("data");
            //外部ストレージからビットマップを取得
            Bitmap bitmap = BitmapFactory.decodeFile(mImageFile.getAbsolutePath());
            ImageView imageView = (ImageView) findViewById(R.id.imageview);
            imageView.setImageBitmap(bitmap);


        //キャンセルだったら
        }else if(resultCode == RESULT_CANCELED){

        }
    }
}
