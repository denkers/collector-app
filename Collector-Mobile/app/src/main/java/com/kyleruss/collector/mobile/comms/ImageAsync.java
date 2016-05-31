package com.kyleruss.collector.mobile.comms;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.net.URL;

public class ImageAsync extends AsyncTask<String, Void, Bitmap>
{
    ImageView imageView;

    public ImageAsync() {}

    public ImageAsync(ImageView imageView)
    {
        this.imageView  =   imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params)
    {
        String urlStr  =   params[0];

        try
        {
            URL url     =   new URL(urlStr);
            Bitmap bmap = BitmapFactory.decodeStream(url.openStream());
            return bmap;
        }

        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onPostExecute(Bitmap bmap)
    {
        imageView.setImageBitmap(bmap);
    }

    public ImageView getImageView()
    {
        return imageView;
    }

    public void setImageView(ImageView imageView)
    {
        this.imageView  =   imageView;
    }
}
