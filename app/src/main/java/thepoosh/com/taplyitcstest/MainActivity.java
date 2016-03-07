package thepoosh.com.taplyitcstest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.taplytics.sdk.Taplytics;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static final String[] DATA = ("Lorem ipsum dolor sit amet, consectetur adipiscing " +
            "elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. " +
            "Nulla quis sem at nibh elementum imperdiet. Duis sagittis ipsum. Praesent mauris. " +
            "Fusce nec tellus sed augue semper porta. Mauris massa. Vestibulum lacinia arcu eget" +
            " nulla. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per" +
            " inceptos himenaeos. Curabitur sodales ligula in libero. Sed dignissim lacinia nunc." +
            " Curabitur tortor. Pellentesque nibh. Aenean quam. In scelerisque sem at dolor. " +
            "Maecenas mattis. Sed convallis tristique sem. Proin ut ligula vel nunc egestas " +
            "porttitor. Morbi lectus risus, iaculis vel, suscipit quis, luctus non, massa. " +
            "Fusce ac turpis quis ligula lacinia aliquet. Mauris ipsum. Nulla metus metus, " +
            "ullamcorper vel, tincidunt sed, euismod in, nibh. Quisque volutpat condimentum " +
            "velit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per " +
            "inceptos himenaeos. Nam nec ante. Sed lacinia, urna non tincidunt mattis, tortor " +
            "neque adipiscing diam, a cursus ipsum ante quis turpis. Nulla facilisi. Ut " +
            "fringilla. Suspendisse potenti. Nunc feugiat mi a tellus consequat imperdiet. " +
            "Vestibulum sapien. Proin quam. Etiam ultrices. Suspendisse in justo eu magna luctus " +
            "suscipit. Sed lectus. Integer euismod lacus luctus magna. Quisque cursus, metus " +
            "vitae pharetra auctor, sem massa mattis sem, at interdum magna augue eget diam. " +
            "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia " +
            "Curae; Morbi lacinia molestie dui. Praesent blandit dolor. Sed non quam. In vel mi " +
            "sit amet augue congue elementum. Morbi in ipsum sit amet pede facilisis laoreet. " +
            "Donec lacus nunc, viverra nec.").split(" ");

    @Bind(R.id.test_list)
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        list.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, DATA));
        handleDeepLink(getIntent());
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


    private void handleDeepLink(Intent intent) {
        String tlDeeplink = intent.getDataString(); //example deep link: 'tl-506f596f://e10651f9ef6b'
        if (tlDeeplink == null) {
            // No deeplink found
            return;
        }
        Taplytics.deviceLink(tlDeeplink);
    }
}
