package com.usc.mylab;

/**
 * Created by kanchanapratharasappan on 11/28/13.
 */

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import android.widget.ImageView;
import com.example.app.R;


public class LazyAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;
    //public ImageLoader imageLoader;

    public LazyAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //imageLoader=new ImageLoader(activity.getApplicationContext());
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);

        TextView name = (TextView)vi.findViewById(R.id.prosname); // title
        TextView phone = (TextView)vi.findViewById(R.id.prosphone);
        TextView email = (TextView)vi.findViewById(R.id.prosemail);
        TextView other = (TextView)vi.findViewById(R.id.prosother);
        TextView date = (TextView)vi.findViewById(R.id.prosdate); // duration
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image); // thumb image

        HashMap prospects = new HashMap<String, String>();
        prospects = data.get(position);
        byte[] picture = (byte[])prospects.get(myLabProfile.KEY_IMAGE);
        Bitmap bitmap = BitmapFactory.decodeByteArray(picture, 0, picture.length);

        // Setting all values in listview
        name.setText((String)prospects.get(myLabProfile.KEY_NAME));
        phone.setText((String)prospects.get(myLabProfile.KEY_PHONE));
        email.setText((String)prospects.get(myLabProfile.KEY_EMAIL));
        other.setText((String)prospects.get(myLabProfile.KEY_OTHER));
        date.setText((String)prospects.get(myLabProfile.KEY_DATE));
        thumb_image.setImageBitmap(bitmap);
        thumb_image.setRotation(90);
        //imageLoader.DisplayImage(song.get(myLab_AddContact.KEY_THUMB_URL), thumb_image);
        return vi;
    }
}
