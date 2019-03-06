package com.thoughtbot.expandablerecyclerview.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.percolate.foam.FoamEvent;
import com.thoughtbot.expandablerecyclerview.sample.custom.CustomExpandActivity;
import com.thoughtbot.expandablerecyclerview.sample.multicheck.MultiCheckActivity;
import com.thoughtbot.expandablerecyclerview.sample.multitype.MultiTypeActivity;
import com.thoughtbot.expandablerecyclerview.sample.multitypeandcheck.MultiTypeCheckGenreActivity;
import com.thoughtbot.expandablerecyclerview.sample.singlecheck.SingleCheckActivity;
import org.slf4j.LoggerFactory;

public class MainActivity extends Activity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final org.slf4j.Logger log = LoggerFactory.getLogger(MainActivity.class);
    log.error("hello world dsflksadjf ---lkjdflkj ");

    Log.e("", "onCreate: -------------------------------->");
    Log.e("", "onCreate: -----------------------------Demo app--->");
    Log.e("", "onCreate: -----------------------------Demo app--->");
    Log.e("", "onCreate: -----------------------------Demo app--->");
    Log.e("", "onCreate: -----------------------------Demo app--->");
    Log.e("", "onCreate: -----------------------------Demo app--->");
    Log.e("", "onCreate: -----------------------------Demo app--->");
    Log.e("", "onCreate: -----------------------------Demo app--->");

    Log.e("This is demo", "onCreate:---------------------- ");
    Log.e("This is demo", "onCreate:---------------------- ");
    Log.e("This is demo", "onCreate:---------------------- ");
    Log.e("This is demo", "onCreate:---------------------- ");
    Log.e("This is demo", "onCreate:---------------------- ");
    Log.e("This is demo", "onCreate:---------------------- ");

    FoamEvent foamEvent = new FoamEvent();
    foamEvent.track(this, "-------------------------------------------->");

    foamEvent.track(this, "This is another demo");

    Button expand = (Button) findViewById(R.id.expand_button);
    expand.setOnClickListener(navigateTo(CustomExpandActivity.class));

    Button multiSelect = (Button) findViewById(R.id.multi_check_button);
    multiSelect.setOnClickListener(navigateTo(MultiCheckActivity.class));

    Button singleSelect = (Button) findViewById(R.id.single_check_button);
    singleSelect.setOnClickListener(navigateTo(SingleCheckActivity.class));

    Button mixedSelect = (Button) findViewById(R.id.mixedtype_button);
    mixedSelect.setOnClickListener(navigateTo(MultiTypeActivity.class));

    Button mixedTypeAndCheck = (Button) findViewById(R.id.mixedtype_check_button);
    mixedTypeAndCheck.setOnClickListener(navigateTo(MultiTypeCheckGenreActivity.class));
  }

  public OnClickListener navigateTo(final Class<?> clazz) {
    return new OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, clazz);
        startActivity(intent);
      }
    };
  }
}
