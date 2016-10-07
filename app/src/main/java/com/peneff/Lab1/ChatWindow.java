package com.peneff.Lab1;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {

    private final String ACTIVITY_NAME = ListItemsActivity.class.getSimpleName();

    private ListView listView;
    private EditText editText;
    private Button send;
    ArrayList<String> data = new ArrayList<String>();
    ArrayAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);


     final ChatAdapter messageAdapter = new ChatAdapter( this );


        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter (messageAdapter);
        editText = (EditText) findViewById(R.id.EditText4);
        send = (Button) findViewById(R.id.button4);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(ChatWindow.this, editText.getText(), Toast.LENGTH_LONG).show();
            //    listView.setAdapter (adapter);// proba
                data.add(editText.getText().toString());
                messageAdapter.notifyDataSetChanged();
                editText.setText("");
            }
        });
        listView.setAdapter(messageAdapter );
      //  listView.setAdapter (messageAdapter);

    }

    //inner class
    class ChatAdapter extends ArrayAdapter<String>{
    Context mycontext;
       // ChatWindow cw = new ChatWindow();

        public ChatAdapter(Context ctx) {
            super(ctx, 0);
        }

        //step 6 functions
        public int getCount(){
            return data.size();
        }
        public String getItem(int position){
            return data.get(position);               // data.get(position)
        }
        //step 9
           public View getView(int position, View convertView, ViewGroup parent){
            View result = null ;


            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();

            if(position%2 == 0)
                result = inflater.inflate(R.layout.chat_row_incoming, null);
            else
                result = inflater.inflate(R.layout.chat_row_outgoing, null);

            TextView message = (TextView)result.findViewById(R.id.message_text);
            message.setText(   getItem(position)  ); // get the string at position
            return result;


        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(ACTIVITY_NAME, "onRestart");
    }


}


