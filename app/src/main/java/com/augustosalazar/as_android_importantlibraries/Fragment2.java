package com.augustosalazar.as_android_importantlibraries;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import eventBus.MessageChangeF1;
import eventBus.MessageChangeF2;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment  {
    EditText edtName;
    EditText edtLastName;

    @Override
    public void onStart() {
        super.onStart();
        Log.d(General.TAG, "F2 On start");
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
        View v = inflater.inflate(R.layout.fragment_fragment2, container, false);
        Log.d(General.TAG, "F2 onCreateView");
        edtName = (EditText) v.findViewById(R.id.edtName);
        edtLastName = (EditText) v.findViewById(R.id.edtLastName);
        return v;
    }

    @Subscribe
    public void onMessageEvent(MessageChangeF2 event) throws SQLException {
        TodoOpenDatabaseHelper todoOpenDatabaseHelper = OpenHelperManager.getHelper(getActivity(),
                TodoOpenDatabaseHelper.class);

        Dao<User, Long> todoDao = todoOpenDatabaseHelper.getDao();

        todoDao.create(new User(edtName.getText().toString(), edtLastName.getText().toString()));

        List<User> todos = todoDao.queryForAll();
        EventBus.getDefault().post(new MessageChangeF1(todos));

    }

}
