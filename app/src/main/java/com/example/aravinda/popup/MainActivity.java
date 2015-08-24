package com.example.aravinda.popup;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    final Context context = this;
    private Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                                                  context);

                                          // set title
                                          alertDialogBuilder.setTitle("Your Title");

                                          // set dialog message
                                          alertDialogBuilder
                                                  .setMessage("Click yes to exit!")
                                                  .setCancelable(false)
                                                  .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                      public void onClick(DialogInterface dialog, int id) {
                                                          // if this button is clicked, close
                                                          // current activity
                                                          MainActivity.this.finish();
                                                      }
                                                  })
                                                  .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                      public void onClick(DialogInterface dialog, int id) {
                                                          // if this button is clicked, just close
                                                          // the dialog box and do nothing
                                                          dialog.cancel();
                                                      }
                                                  });

                                          // create alert dialog
                                          AlertDialog alertDialog = alertDialogBuilder.create();

                                          // show it
                                          alertDialog.show();
                                      }
                                  }

        );

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_internal_error);
                dialog.setTitle("Title...");

                // set the custom dialog components - text, image and button
                TextView text = (TextView) dialog.findViewById(R.id.text);
                text.setText("Android custom dialog example!");
                ImageView image = (ImageView) dialog.findViewById(R.id.image);
                image.setImageResource(R.drawable.ic_launcher);

                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
