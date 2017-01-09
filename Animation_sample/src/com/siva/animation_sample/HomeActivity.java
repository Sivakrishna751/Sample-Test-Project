package com.siva.animation_sample;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class HomeActivity extends FragmentActivity implements PopupMenu.OnMenuItemClickListener {

	AlertDialog.Builder alert;
	 private FragmentTabHost mTabHost;
	 View custom_action_view =null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		//getActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
		getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getActionBar().setDisplayShowCustomEnabled(true);
        getActionBar().setCustomView(R.layout.custom_action_bar_layout);
        custom_action_view =getActionBar().getCustomView();
       ImageView more_icon =(ImageView)custom_action_view.findViewById(R.id.moreimage);
       more_icon.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			 PopupMenu popup = new PopupMenu(HomeActivity.this, v);
			    MenuInflater inflate = popup.getMenuInflater();
			    inflate.inflate(R.menu.home, popup.getMenu());
			    popup.show();
			    popup.setOnMenuItemClickListener(HomeActivity.this);
		
		}
	});
       
       mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
       mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
       Create_alert_box();
      
       mTabHost.addTab(
               mTabHost.newTabSpec("tab1").setIndicator(null, getResources().getDrawable(R.drawable.ic_launcher)),
               FragmentTab1.class, null);
       mTabHost.addTab(
               mTabHost.newTabSpec("tab2").setIndicator(null, getResources().getDrawable(R.drawable.ic_launcher)),
               FragmentTab2.class, null);
       mTabHost.addTab(
               mTabHost.newTabSpec("tab3").setIndicator(null, getResources().getDrawable(R.drawable.ic_launcher)),
               FragmentTab3.class, null);
       mTabHost.addTab(
               mTabHost.newTabSpec("tab4").setIndicator(null, getResources().getDrawable(R.drawable.ic_launcher)),
               FragmentTab4.class, null);
       mTabHost.addTab(
               mTabHost.newTabSpec("tab5").setIndicator(null, getResources().getDrawable(R.drawable.ic_launcher)),
               FragmentTab5.class, null);
       
       mTabHost.setCurrentTab(2);
        
	}

	
	
	@Override
	public boolean onMenuItemClick(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()) {
	    case R.id.home_button:    
	    	Toast.makeText(getApplicationContext(), "You have  the  button", Toast.LENGTH_SHORT).show();
	        return true;
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}
	
	private void Create_alert_box() {
		// TODO Auto-generated method stub
		alert=new AlertDialog.Builder(HomeActivity.this);
        alert.setTitle("Terms and Conditions");
        //alert.setIcon(getResources().getDrawable(android.R.drawable.ic_dialog_alert));
        alert.setMessage(" The Gulfring Dialer is licensed under the following terms and conditions. Please read the following instructions carefully. \n Thank you");
        alert.setCancelable(false);
        alert.setPositiveButton("Accept", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
				Toast.makeText(getApplicationContext(), "Thanks for accepting the conditions", Toast.LENGTH_SHORT).show();
				
			}
		});
        alert.setNegativeButton("Decline", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
				HomeActivity.this.finish();
				System.exit(0);
				
			}
		});
        alert.show();
	}




	/* (non-Javadoc)
	 * @see android.widget.PopupMenu.OnMenuItemClickListener#onMenuItemClick(android.view.MenuItem)
	 */
	
	
	
	
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		if (id == R.id.action_settings) {
			Toast.makeText(getApplicationContext(), "Clicked on Settings button", Toast.LENGTH_SHORT).show();
		}
		
		if(id == R.id.home_button){
			Toast.makeText(getApplicationContext(), "Clicked on Home button", Toast.LENGTH_SHORT).show();
		}
		
		return super.onOptionsItemSelected(item);
	}*/
}
