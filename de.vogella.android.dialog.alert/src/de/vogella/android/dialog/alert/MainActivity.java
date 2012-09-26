/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.vogella.android.dialog.alert;

/**
 *
 * @author qzeng
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

  private static final int DIALOG_ALERT = 10;

  
/** Called when the activity is first created. */


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

  }

  public void onClick(View view) {
    showDialog(DIALOG_ALERT);
  }

  @Override
  protected Dialog onCreateDialog(int id) {
    switch (id) {
    case DIALOG_ALERT:
      // Create out AlterDialog
      Builder builder = new AlertDialog.Builder(this);
      builder.setMessage("Fortune cookie says...");
      builder.setCancelable(true);
      builder.setPositiveButton("Door 1", new CancelOnClickListener());
      builder.setNeutralButton("Door 2", new CancelOnClickListener2());
      builder.setNegativeButton("Door 3", new CancelOnClickListener3());
      
      AlertDialog dialog = builder.create();
      dialog.show();
    }
    return super.onCreateDialog(id);
  }

  private final class CancelOnClickListener implements
      DialogInterface.OnClickListener {
    public void onClick(DialogInterface dialog, int which) {
      Toast.makeText(getApplicationContext(), "Now or Never. Carpe Diem. Say what"
              + " you need to say.",
          Toast.LENGTH_LONG).show();
    }
  }
  
  
  private final class CancelOnClickListener2 implements
      DialogInterface.OnClickListener {
    public void onClick(DialogInterface dialog, int which) {
      Toast.makeText(getApplicationContext(), "Today you will have the chance to "
              + "make a difference in someone's life",
          Toast.LENGTH_LONG).show();
    }
  }
  
    private final class CancelOnClickListener3 implements
      DialogInterface.OnClickListener {
    public void onClick(DialogInterface dialog, int which) {
      Toast.makeText(getApplicationContext(), "Today is your day. Today you will"
              + " move mountains!",
          Toast.LENGTH_LONG).show();
    }
  }
  


 /** private final class OkOnClickListener implements
      DialogInterface.OnClickListener {
    public void onClick(DialogInterface dialog, int which) {
      MainActivity.this.finish();
    }
  } **/

} 