package com.augustosalazar.as_android_importantlibraries;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import eventBus.MessageChangeF1;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {
    ListView lwUsers;
    @Override
    public void onStart() {
        super.onStart();
        Log.d(General.TAG, "F1 On start");
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_fragment1, container, false);
        lwUsers = (ListView) v.findViewById(R.id.listView);
        return v;
    }

    @Subscribe
    public void onMessageEvent(MessageChangeF1 event) throws SQLException {
        Log.d("TAG",event.users.get(0).toString());
        ArrayAdapter<User> adaptador = new ArrayAdapter<User>(getActivity(), android.R.layout.simple_list_item_1, event.users);
        lwUsers.setAdapter(adaptador);


    }


}
