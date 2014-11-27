package cruz.jason.mysecretkeeper;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainScreen extends Activity {
	
	//Extract
	Button bt_Hide, bt_Extract;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = getActionBar();

		// more stuff here...
		actionBar.show(); 
		bt_Hide = (Button)findViewById(R.id.bt_Hide);
		bt_Extract = (Button)findViewById(R.id.bt_Extract);
		
		
		bt_Hide.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
			     Intent intent1 = new Intent("cruz.jason.hide");
			     startActivity(intent1);
			}
		});
		
		bt_Extract.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
			     Intent intent2 = new Intent("cruz.jason.extract");
			     startActivity(intent2);
			}
		});
	}
		
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		 switch (item.getItemId()) {
		    // action with ID action_refresh was selected
		    case R.id.action_instructions:
		      Toast.makeText(this, "Instructions selected", Toast.LENGTH_SHORT)
		          .show();
		      break;
		    // action with ID action_settings was selected
		    case R.id.action_settings:
		      Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
		          .show();
		      break;

		    case R.id.action_about:
		    	 // Inflate the about message contents
		        View messageView = getLayoutInflater().inflate(R.layout.dialog_about, null, false);
		 
		        // When linking text, force to always use default color. This works
		        // around a pressed color state bug.
		        TextView textView = (TextView) messageView.findViewById(R.id.about_credits);
		        int defaultColor = textView.getTextColors().getDefaultColor();
		        textView.setTextColor(defaultColor);
		 
		        AlertDialog.Builder builder = new AlertDialog.Builder(this);
		        builder.setIcon(R.drawable.ic_action_about);
		        builder.setTitle("About This App");
		        builder.setView(messageView);
		        builder.create();
		        builder.show();
			      break;
			    default:
			      break;
		    }

		    return true;
	}

}
