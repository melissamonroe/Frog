package com.infovisionsoftware.frog;

import android.app.Application;

import com.infovisionsoftware.frog.ui.MainActivity;
import com.infovisionsoftware.frog.utils.ParseConstants;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.PushService;

/**
 * Created by Melissa on 2/2/2015.
 */
public class FrogApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this,
                "MINyjGWp6xsz2VY4hZYWGluw8Rs8FthElfmBBBfh",
                "m9WRaOOjPh3LtOs8opAWCaL1ZprwXft9vq0u2iUY");

        //PushService.setDefaultPushCallback(this, MainActivity.class);
        PushService.setDefaultPushCallback(this, MainActivity.class,
                R.drawable.ic_stat_ic_launcher);

        ParseInstallation.getCurrentInstallation().saveInBackground();
    }

    public static void updateParseInstallation(ParseUser user) {

        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        installation.put(ParseConstants.KEY_USER_ID, user.getObjectId());
        installation.saveInBackground();

    }

}
