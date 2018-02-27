package lab5.android.wku.edu.shapedrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by chunh on 2/26/2018.
 */

public class myShape extends View {

    public myShape(Context c) {
        super(c);
        init();
    }

    public myShape(Context c, AttributeSet a) {
        super(c, a);
        init();
    }

    protected ShapeDrawable circle;

    protected void init() {
        circle = new ShapeDrawable(new OvalShape());
        circle.getPaint().setColor(getResources().getColor(R.color.colorPrimary));
        circle.setBounds(230, 220, 230+80, 220+80);
    }

    protected void onDraw(Canvas canvas) {
        circle.draw(canvas);
    }
}
