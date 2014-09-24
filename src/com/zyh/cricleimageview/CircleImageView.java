package com.zyh.cricleimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Բ��ͼƬ
 * @author zyh
 */
public class CircleImageView extends ImageView {

	public CircleImageView(Context context) {
		super(context);
	}

	public CircleImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CircleImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	private int bWidth = 10;// �߿���
	private int bColor = Color.WHITE;// �߿���ɫ

	/**
	 * ����Բ��ͼƬ�ı߿���ɫ
	 * @param color
	 */
	public void setBorderColor(int color) {
		bColor = color;
	}

	/**
	 * ����Բ��ͼƬ�ı߿���
	 * @param
	 */
	public void setBorderWidth(int width) {
		bWidth = width;
	}

	/**
	 * ����Բ��ͼƬ�ı߿��Ⱥ���ɫ
	 * @param
	 */
	public void setBorderWidth(int width, int color) {
		bWidth = width;
		bColor = color;
	}

	@Override
	public void setImageBitmap(Bitmap bm) {

		int d = Math.min(bm.getWidth(), bm.getHeight());// ���Բֱ��
		Bitmap dest = Bitmap.createBitmap(d, d, bm.getConfig());// ����һ������
		// ���߿�
		Canvas c = new Canvas(dest);
		Paint paint = new Paint();
		paint.setColor(bColor); // �߿���ɫ
		paint.setAntiAlias(true);// ���ÿ����
		c.drawCircle(d / 2, d / 2, d / 2, paint);
		// ��Բ
		Path path = new Path();
		path.addCircle(d / 2, d / 2, d / 2 - bWidth, Path.Direction.CW);
		c.clipPath(path); // �ü�����

		Matrix matrix = new Matrix();// ������
		c.drawBitmap(bm, matrix, paint);// ��ͼ����ȥ
		super.setImageBitmap(dest);
	}

	// ͼƬ
	// private Bitmap mSrc;
	// // �ؼ��Ŀ��
	// private int mWidth;
	// // �ؼ��ĸ߶�
	// private int mHeight;
	//
	// @Override
	// protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	// // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	// // ���ÿ��
	// int specMode = MeasureSpec.getMode(widthMeasureSpec);
	// int specSize = MeasureSpec.getSize(widthMeasureSpec);
	// if (specMode == MeasureSpec.EXACTLY) mWidth = specSize; // match_parent , accurate
	// else {// ��ͼƬ�����Ŀ�
	// int desireByImg = getPaddingLeft() + getPaddingRight() + mSrc.getWidth();
	// if (specMode == MeasureSpec.AT_MOST) mWidth = Math.min(desireByImg, specSize);// wrap_content
	// }
	//
	// // ���ø߶�
	// specMode = MeasureSpec.getMode(heightMeasureSpec);
	// specSize = MeasureSpec.getSize(heightMeasureSpec);
	// if (specMode == MeasureSpec.EXACTLY) mHeight = specSize;// match_parent , accurate
	// else {
	// int desire = getPaddingTop() + getPaddingBottom() + mSrc.getHeight();
	// if (specMode == MeasureSpec.AT_MOST) mHeight = Math.min(desire, specSize);// wrap_content
	// }
	// setMeasuredDimension(mWidth, mHeight);
	// }
	//
	// /**
	// * ����
	// */
	// @Override
	// protected void onDraw(Canvas canvas) {
	// // �����TYPE_CIRCLE����Բ��
	// int min = Math.min(mWidth, mHeight);
	// // ���������һ�£���С��ֵ����ѹ��
	// mSrc = Bitmap.createScaledBitmap(mSrc, min, min, false);
	// canvas.drawBitmap(createCircleImage(mSrc, min), 0, 0, null);
	// }
	//
	// /**
	// * ����ԭͼ�ͱ䳤����Բ��ͼƬ
	// * @param source ԭͼƬ
	// * @param min Բֱ��
	// * @return Բ��ͼƬ
	// */
	// private Bitmap createCircleImage(Bitmap source, int min) {
	// final Paint paint = new Paint();
	// paint.setAntiAlias(true);
	// Bitmap target = Bitmap.createBitmap(min, min, Config.ARGB_8888);
	// // ����һ��ͬ����С�Ļ���
	// Canvas canvas = new Canvas(target);
	// // ���Ȼ���Բ��
	// canvas.drawCircle(min / 2, min / 2, min / 2, paint);
	// // ʹ��SRC_IN���ο������˵�� //������bitmap ���� SRC_INģʽ����
	// paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
	// // ����ͼƬ
	// canvas.drawBitmap(source, 0, 0, paint);
	//
	// return target;
	// }

}
