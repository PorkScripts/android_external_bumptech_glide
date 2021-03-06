package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, emulateSdk = 18)
public class BitmapImageViewTargetTest {

    private ImageView view;
    private BitmapImageViewTarget target;

    @Before
    public void setUp() {
        view = new ImageView(Robolectric.application);
        target = new BitmapImageViewTarget(view);
    }

    @Test
    public void testSetsBitmapOnViewInSetResource() {
        Bitmap bitmap = Bitmap.createBitmap(100, 75, Bitmap.Config.RGB_565);
        target.setResource(bitmap);
        assertEquals(bitmap, ((BitmapDrawable) view.getDrawable()).getBitmap());
    }
}