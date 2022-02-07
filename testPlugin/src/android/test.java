package cordova.plugin.test;

import android.content.Context;
import android.content.Intent;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.annotation.Nullable;
import android.widget.Toast;

/**
 * This class echoes a string called from JavaScript.
 */
public class test extends CordovaPlugin {
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        Context context = cordova.getActivity().getApplicationContext();
        Intent intent = new Intent(context, NewActivity.class);
        cordova.setActivityResultCallback (this);
        this.cordova.getActivity().startActivityForResult(intent, 22);
        //this.cordova.getActivity().startActivity(intent);
        // if (message != null && message.length() > 0) {
        // Toast toast = Toast.makeText(cordova.getActivity(), message,
        // Toast.LENGTH_LONG);
        // // Display toast
        // toast.show();
        // callbackContext.success(message);
        // } else {
        // callbackContext.error("Expected one non-empty string argument.");
        // }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 22 && resultCode == 200 && data != null) {
            // String name = data.getExtra("name");
            // String addr = data.getExtra("address");
            // String phone = data.getExtra("phone");
            // String email = data.getExtra("email");
            System.out.println(data);

                    }
        // final int responseCode = data.getIntExtra("fingerprint_response_code", -1);
        // if (responseCode > 0) {
        //     FingerprintResponse fingerprintResponse = ResultIPC.getInstance().getFingerprintResponse(responseCode);
        //     if (fingerprintResponse != null && fingerprintResponse.getIdentificationResponse() != null) {
        //         // Initialize views and show person's data

        //         System.out.println(fingerprintResponse.getIdentificationResponse());
        //     } else {
        //         // If not empty, show results
        //         //fingerprintResponse.getPngList();
        //         fingerprintResponse.getWsqList();
        //         System.out.println("Response : " + fingerprintResponse.getWsqList());
        //     }
        // }
    }
}
