package enterprisesolutions.dagger2_rx.application;

import android.app.Application;

import enterprisesolutions.dagger2_rx.di.components.ApplicationComponent;
import enterprisesolutions.dagger2_rx.di.components.DaggerApplicationComponent;
import enterprisesolutions.dagger2_rx.di.module.ApplicationModule;

/**
 * Created by jorgecasariego on 19/12/16.
 */

public class CakeApplication extends Application{
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this, "https://gist.githubusercontent.com"))
                .build();
    }

    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
