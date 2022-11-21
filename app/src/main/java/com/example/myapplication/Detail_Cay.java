package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class Detail_Cay extends Fragment {
    String Dactinh,Tencay,image;

    public Detail_Cay(String Dactinh, String Tencay, String image) {
        this.Dactinh = Dactinh;
        this.Tencay = Tencay;
        this.image = image;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.detail, container, false);
        ImageView imageDetail = view.findViewById(R.id.imageviewDetail);
        TextView txtTencay = view.findViewById(R.id.textviewTencay);
        TextView txtDactinh = view.findViewById(R.id.textviewDactinh);

        txtTencay.setText(Tencay);
        txtDactinh.setText(Dactinh);
        Glide.with(getContext()).load(image).into(imageDetail);

        return view;
    }
    public void onBackPressed(){
        AppCompatActivity activity= (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new menu_list()).addToBackStack(null).commit();

    }

}
