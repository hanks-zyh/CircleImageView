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
 * 圆角图片
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

	private int bWidth = 10;// 边框宽度
	private int bColor = Color.WHITE;// 边框颜色

	/**
	 * 设置圆形图片的边框颜色
	 * @param color
	 */
	public void setBorderColor(int color) {
		bColor = color;
	}

	/**
	 * 设置圆形图片的边框宽度
	 * @param
	 */
	public void setBorderWidth(int width) {
		bWidth = width;
	}

	/**
	 * 设置圆形图片的边框宽度和颜色
	 * @param
	 */
	public void setBorderWidth(int width, int color) {
		bWidth = width;
		bColor = color;
	}

	@Override
	public void setImageBitmap(Bitmap bm) {

		int d = Math.min(bm.getWidth(), bm.getHeight());// 或得圆直径
		Bitmap dest = Bitmap.createBitmap(d, d, bm.getConfig());// 创建一个副本
		// 画边框
		Canvas c = new Canvas(dest);
		Paint paint = new Paint();
		paint.setColor(bColor); // 边框颜色
		paint.setAntiAlias(true);// 设置抗锯齿
		c.drawCircle(d / 2, d / 2, d / 2, paint);
		// 画圆
		Path path = new Path();
		path.addCircle(d / 2, d / 2, d / 2 - bWidth, Path.Direction.CW);
		c.clipPath(path); // 裁剪区域

		Matrix matrix = new Matrix();// 不缩放
		c.drawBitmap(bm, matrix, paint);// 把图画上去
		super.setImageBitmap(dest);
	}

	// 图片
	// private Bitmap mSrc;
	// // 控件的宽度
	// private int mWidth;
	// // 控件的高度
	// private int mHeight;
	//
	// @Override
	// protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	// // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	// // 设置宽度
	// int specMode = MeasureSpec.getMode(widthMeasureSpec);
	// int specSize = MeasureSpec.getSize(widthMeasureSpec);
	// if (specMode == MeasureSpec.EXACTLY) mWidth = specSize; // match_parent , accurate
	// else {// 由图片决定的宽
	// int desireByImg = getPaddingLeft() + getPaddingRight() + mSrc.getWidth();
	// if (specMode == MeasureSpec.AT_MOST) mWidth = Math.min(desireByImg, specSize);// wrap_content
	// }
	//
	// // 设置高度
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
	// * 绘制
	// */
	// @Override
	// protected void onDraw(Canvas canvas) {
	// // 如果是TYPE_CIRCLE绘制圆形
	// int min = Math.min(mWidth, mHeight);
	// // 长度如果不一致，按小的值进行压缩
	// mSrc = Bitmap.createScaledBitmap(mSrc, min, min, false);
	// canvas.drawBitmap(createCircleImage(mSrc, min), 0, 0, null);
	// }
	//
	// /**
	// * 根据原图和变长绘制圆形图片
	// * @param source 原图片
	// * @param min 圆直径
	// * @return 圆形图片
	// */
	// private Bitmap createCircleImage(Bitmap source, int min) {
	// final Paint paint = new Paint();
	// paint.setAntiAlias(true);
	// Bitmap target = Bitmap.createBitmap(min, min, Config.ARGB_8888);
	// // 产生一个同样大小的画布
	// Canvas canvas = new Canvas(target);
	// // 首先绘制圆形
	// canvas.drawCircle(min / 2, min / 2, min / 2, paint);
	// // 使用SRC_IN，参考上面的说明 //把两张bitmap 按照 SRC_IN模式叠加
	// paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
	// // 绘制图片
	// canvas.drawBitmap(source, 0, 0, paint);
	//
	// return target;
	// }

}
