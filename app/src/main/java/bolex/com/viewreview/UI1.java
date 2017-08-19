package bolex.com.viewreview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by liushenen on 2017/8/15.
 */

public class UI1 extends View {
    public UI1(Context context) {
        this(context,null);
    }

    public UI1(Context context, @Nullable AttributeSet attrs) {
        this(context,null,0);
    }

    public UI1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(40);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(Color.BLACK);
        canvas.drawPoint(20, 20, paint);
        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(20, 80, paint);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(20, 150, paint);

        int left = 50;
        int top = 50;
        int right = 350;
        int bottom = 200;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            canvas.drawOval(left, top, right, bottom, paint);
            paint.setColor(Color.RED);
            paint.setStrokeWidth(2);
            canvas.drawLine(left,0,left,(bottom-top)/2+top,paint); //左
            canvas.drawLine(right,0,right,(bottom-top)/2+top,paint);//右
            canvas.drawLine(0,top,(right-left)/2+left,top,paint);
            canvas.drawLine(0,bottom,(right-left)/2+left,bottom,paint);

        }

        paint.setStyle(Paint.Style.FILL); // 填充模式
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawArc(left, top, right, bottom, 0, 90, true, paint); // 绘制扇形
            paint.setColor(Color.GREEN);
            canvas.drawArc(left, top, right, bottom, -90, 90, false, paint); // 绘制弧形

        Path path = new Path();
        paint.setStyle(Paint.Style.STROKE);
        path.lineTo(100, 100); // 由当前位置 (0, 0) 向 (100, 100) 画一条直线
        path.rLineTo(100, 0); // 由当前位置 (100, 100) 向正右方 100 像素的位置画一条直线
        path.moveTo(0, 300); // 我移~~
        path.lineTo(1200, 0); // 画竖线
        path.moveTo(0, 700); // 我移~~
        path.quadTo(0, 0,400,600); // 我移~~
        path.rQuadTo(400, 600, 400, 0);
        path.moveTo(0, 800); // 我移~~
        path.arcTo(600, 600, 900, 900, 0, 90, false); // 强制移动到弧形起点（无痕迹）
        path.addArc(600, 600, 900, 900, -90, 90);
        path.close(); //合并起点和终点
            canvas.drawPath(path,paint);
        }

        Paint linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(Color.WHITE);
        int textSize = 14;
        linePaint.setTextSize(textSize);
        int startLineX = 20;
        int startLineY = 40;

        int stopBottomToRightLineX = 400;
        int startBottomToHightLineY = 240;

        canvas.drawLine(startLineX, startLineY, startLineX, startBottomToHightLineY, linePaint);
        canvas.drawLine(startLineX, startBottomToHightLineY, stopBottomToRightLineX, startBottomToHightLineY, linePaint);
        int lineWidth = stopBottomToRightLineX - startLineX; //底部线长度
        int padding = 5;
        int itemSize = 7;
        int itemWidth = (lineWidth - padding * itemSize + 1) / itemSize; //item 长度
        linePaint.setColor(Color.GREEN);
        for (int i1 = 0; i1 < itemSize; i1++) {
            canvas.drawText(i1 + "", startLineX + padding * i1 + itemWidth * i1 + itemWidth / 2, startBottomToHightLineY + padding + textSize, linePaint);
            Rect rect = new Rect(startLineX + padding * i1 + itemWidth * i1,
                    startBottomToHightLineY - i1 * 10,
                    startLineX + padding * i1 + itemWidth * i1 + itemWidth,
                    startBottomToHightLineY);
            canvas.drawRect(rect, linePaint);

        }





    }
}
