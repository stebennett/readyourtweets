package me.sbio.readyourtweets.listener;

import me.sbio.readyourtweets.twitterapiclient.config.TwitterConfig;
import me.sbio.twitterstub.TwitterStubServer;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

public class StubServerListener extends RunListener {

    private TwitterConfig twitterConfig = new TwitterConfig();
    private TwitterStubServer twitterStubServer;

    @Override
    public void testRunStarted(Description description) throws Exception {
        twitterStubServer = new TwitterStubServer(twitterConfig.getPort());
        twitterStubServer.start();
        twitterStubServer.registerMappings();
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        twitterStubServer.stop();
    }
}
