package com.kyleruss.collector.mobile.comms;

import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;

import com.kyleruss.collector.mobile.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

public abstract class HTTPAsync extends AsyncTask<ServiceRequest, Void, String>
{
    private String getResponse(HttpURLConnection conn) throws IOException
    {
        String response =   "";
        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK)
        {
            InputStream inputStream = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;

            while ((line = reader.readLine()) != null)
                response += line + "\n";

            inputStream.close();
            return response;
        }

        else return "fail: " + conn.getResponseCode();
    }

    private void writeRequest(HttpURLConnection conn, String params) throws IOException
    {
        OutputStreamWriter writer   =   new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
        writer.write(params);
        writer.flush();
        writer.close();
    }

    protected ServiceResponse getServiceResponse(String response)
    {
        try
        {
            JSONObject jsonObject   =   new JSONObject(response);
            boolean status          =   jsonObject.getBoolean("actionStatus");
            String message          =   jsonObject.getString("message");

            return new ServiceResponse(message, status);
        }

        catch(JSONException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    protected JSONObject getJSONResult(String response)
    {
        try
        {
            return new JSONObject(response);
        }

        catch(JSONException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public void showServicingSpinner(ImageView v)
    {
        v.setImageResource(android.R.color.transparent);
        v.setBackgroundResource(R.drawable.spinner_animation);
        AnimationDrawable animation =   (AnimationDrawable) v.getBackground();
        animation.start();
    }

    public void hideServicingSpinner(ImageView v, int prevDrawable)
    {
        AnimationDrawable animation =   (AnimationDrawable) v.getBackground();
        animation.stop();
        v.setBackgroundResource(android.R.color.transparent);
        v.setImageResource(prevDrawable);
    }

    @Override
    protected String doInBackground(ServiceRequest... requests)
    {
        try
        {
            ServiceRequest request          =   requests[0];
            HttpURLConnection connection    =   request.getConnection();

            writeRequest(connection, request.prepareParams());

            Thread.sleep(3000);
            return getResponse(connection);
        }

        catch(Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    protected abstract void onPostExecute(String response);
}
