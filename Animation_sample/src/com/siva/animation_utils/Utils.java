/**
 * 
 */
package com.siva.animation_utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author sivakrishna
 *
 */
public class Utils {

	public static final String NO_INTERNET_CONNECTION="No Internet Connection";
    private static ConnectivityManager connectivityManager;
	
	 public static boolean isNetworkConnected(Context context) {
	        connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
	        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
	        
	        return (activeNetwork != null && activeNetwork.isConnectedOrConnecting());
	    }
	 
	 public static boolean isWifiConnected(Context context) {
	        connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
	       // NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
	        NetworkInfo mWifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

	        if (mWifi.isConnected()) {
	            // Do whatever
	        }
	     //   return (activeNetwork != null && activeNetwork.isConnectedOrConnecting());
	        return  mWifi.isConnected();
	 }
}
