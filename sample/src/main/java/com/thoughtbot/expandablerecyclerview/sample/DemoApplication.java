package com.thoughtbot.expandablerecyclerview.sample;

import com.percolate.foam.FoamApiKeys;
import com.percolate.foam.FoamApplication;

@FoamApiKeys(papertrail = "logs3.papertrailapp.com:50710") public class DemoApplication
    extends FoamApplication {

  @Override public void onCreate() {
    super.onCreate();
  }
}
