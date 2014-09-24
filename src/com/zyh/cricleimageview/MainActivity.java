package com.zyh.cricleimageview;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends Activity {

	private CircleImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv = (CircleImageView) findViewById(R.id.iv);
		iv.setBorderWidth(15, Color.BLACK);// …Ë÷√±ﬂøÚ
		iv.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.p)); // …Ë÷√Õº∆¨
	}
}
