package com.siva.animation_sample;

import com.siva.animation_utils.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class MainActivity extends Activity {
ImageView img;
AlertDialog.Builder alert;
boolean shown_settings=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=(ImageView)findViewById(R.id.imageView1);
        
        Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim);
        anim.setInterpolator((new AccelerateDecelerateInterpolator()));
        anim.setFillAfter(true);
        img.setAnimation(anim);
        
        Create_alert_box();
        
        
        Thread th=new Thread(){
        	
        	
        	/* (non-Javadoc)
        	 * @see java.lang.Thread#run()
        	 */
        	@Override
        	public void run() {
        		// TODO Auto-generated method stub
        		super.run();
        		try {
					sleep(7000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		finally{
        			
        			if(Utils.isWifiConnected(MainActivity.this)){
        				
        				startActivity(new Intent(MainActivity.this,HomeActivity.class));
            			finish();	
        				
        			}else{
        				
        				MainActivity.this.runOnUiThread(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								Show_alert_prompt();
							}
						});
        				
        			}
        			
        			
        			
        		}
        	}
        	
        	
        };th.start();
    }
	/**
	 * 
	 */
	protected void Show_alert_prompt() {
		// TODO Auto-generated method stub
		alert.show();
	}
	/**
	 * 
	 */
	private void Create_alert_box() {
		// TODO Auto-generated method stub
		alert=new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Network Error");
        alert.setIcon(getResources().getDrawable(android.R.drawable.ic_dialog_alert));
        alert.setMessage(" No Internet Connection is Detected. \n  Please Click Ok to open wifi settings.");
        alert.setCancelable(false);
        alert.setPositiveButton("Connect", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
				shown_settings=true;
				//startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
				//startActivity(new Intent(android.provider.Settings.ACTION_WIFI_IP_SETTINGS));
				startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
				
			}
		});
        alert.setNegativeButton("Exit", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
				MainActivity.this.finish();
				System.exit(0);
			}
		});
	}

	
	/* (non-Javadoc)
		 * @see android.app.Activity#onResume()
		 */
		@Override
		protected void onResume() {
			// TODO Auto-generated method stub
			super.onResume();
			
			 if(shown_settings){
				 Thread restart_thread=new Thread(){
					 
					 
					 /* (non-Javadoc)
					 * @see java.lang.Thread#run()
					 */
					@Override
					public void run() {
						// TODO Auto-generated method stub
						super.run();
						
						try {
							sleep(3000);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						finally{
							if(Utils.isWifiConnected(MainActivity.this)){
								
								startActivity(new Intent(MainActivity.this,HomeActivity.class));
				    			finish();	
								
							}else{
								
							}
						}
					}
					 
				 };restart_thread.start();
				 shown_settings=false;
				 
			 }
			
			
		}
    
}
