/**
 * Copyright 2013 Motivity Labs, Inc. All rights reserved.
 */
package android.demo.amitrai.staksdk.StakUtil;

/**
 * @author bhimesh
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkConnection {

		public static boolean isConnectedToNetwork(Context context) {
			ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		    NetworkInfo netInfo = cm.getActiveNetworkInfo();
		    if (netInfo != null && netInfo.isConnected()) {
		        return true;
		    }
		    return false;
		}

}
