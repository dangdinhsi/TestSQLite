package com.dangdinhsi.ss9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db= AppDatabase.getAppDatabase(this);
        insertUser();
        getAllUser();
        updateUser(1);
        deleteUser(1);
    }

    public void insertUser(){
        User user = new User();
        for (int i=0;i<=10;i++){
            user.setName("Nguyen Van A" +i);
            user.setPhone("09xxxxx"+i);
            db.userDAO().insertUser(user);
        }

    }

    public void updateUser(int id){
        User user = db.userDAO().getUser(id);
        if(user!=null){
            user.setName("xxxxxxxxxxx");
            user.setPhone("123456");
            db.userDAO().updateUser(user);
        }
    }

    public void getAllUser(){
        List<User> list =db.userDAO().getAllUser();
        for (User model : list){
            Log.d("List User", "Danh sach:"+model.getId()+" - "+model.getName()+" - "+model.getPhone());
        }
    }
    public void deleteUser(int id){
        User user = db.userDAO().getUser(id);
        if(user!=null){
            db.userDAO().deleteUser(user);
        }else {
            Log.d("Message", "user khong ton tai");
        }
    }
}