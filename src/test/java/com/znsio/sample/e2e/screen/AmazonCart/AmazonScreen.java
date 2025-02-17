package com.znsio.sample.e2e.screen.AmazonCart;

import com.znsio.e2e.entities.Platform;
import com.znsio.e2e.runner.Runner;
import com.znsio.e2e.tools.Driver;
import com.znsio.e2e.tools.Visual;
import com.znsio.sample.e2e.screen.android.theapp.AppLaunchScreenAndroid;
import com.znsio.sample.e2e.screen.theapp.AppLaunchScreen;
import com.znsio.sample.e2e.screen.web.AmazonCartWeb.AmazonScreenWeb;
import com.znsio.sample.e2e.screen.web.theapp.AppLaunchScreenWeb;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.log4j.Logger;

import static com.znsio.e2e.runner.Runner.fetchDriver;
import static com.znsio.e2e.runner.Runner.fetchEyes;

public abstract class AmazonScreen {

    private static final String SCREEN_NAME = AmazonScreen.class.getSimpleName();
    private static final Logger LOGGER = Logger.getLogger(SCREEN_NAME);

    public static AmazonScreen get() {
        Driver driver = fetchDriver(Thread.currentThread()
                .getId());
        Platform platform = Runner.fetchPlatform(Thread.currentThread()
                .getId());
        LOGGER.info(SCREEN_NAME + ": Driver type: " + driver.getType() + ": Platform: " + platform);
        Visual visually = fetchEyes(Thread.currentThread()
                .getId());

        switch(platform) {
            case web:
                return new AmazonScreenWeb(driver, visually);
        }
        throw new NotImplementedException(SCREEN_NAME + " is not implemented in " + Runner.platform);
    }

    public abstract String getSignInStatus();

    public abstract SearchResultsScreen searchTheProduct(String product);

}
