package ca.uottawa.ljin027.myrestaurant;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * @author Ling Jin
 * Created by Ling on 10/02/2015.
 * This class implements the welcome activity (requirement 1).
 * The welcome activity serves as the main activity of our app.
 * It shows a log, a description and a button.
 * Clicking the button shows the history of the previous orders (requirement 6).
 * The order report is implemented using fragment cause it is a little wired to make this little
 * function a independent activity.
 */
public class WelcomeFragment extends BitmapFragment {
    TextView orderStatistics;

    // Constructor, initialize super class and TAG
    public WelcomeFragment() {
        super();
        TAG = "--> WelcomeFragment";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        // A button click listener to show the report of the order history
        Button buttonReport = (Button) view.findViewById(R.id.button_report);
        buttonReport.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
            MessageDialog reportDialog = new MessageDialog();
            reportDialog.setMessage(MainActivity.data.getOrderStatistics());
            reportDialog.show(getFragmentManager(), null);
            }
        });

        // When the facebook icon is clicked, browse the facebook.com
        ImageButton facebookButton = (ImageButton) view.findViewById(R.id.imageButton_welcome_facebook);
        facebookButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "!!!!!! Facebook Clicked");
                Uri uri = Uri.parse(getString(R.string.facebook_url));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        // When the twitter icon is clicked, browse the twitter.com
        ImageButton twitterButton = (ImageButton) view.findViewById(R.id.imageButton_welcome_twitter);
        twitterButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "!!!!!! Twitter Clicked");
                Uri uri = Uri.parse(getString(R.string.twitter_url));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Log.i(TAG, "!!!!!! ViewCreated");

        addBitmap(R.id.imageView_log, R.drawable.ic_log);
        addBitmap(R.id.imageButton_welcome_facebook, R.drawable.ic_facebook);
        addBitmap(R.id.imageButton_welcome_twitter, R.drawable.ic_twitter);

        return view;
    }
}
