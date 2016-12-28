package enterprisesolutions.dagger2_rx.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import enterprisesolutions.dagger2_rx.di.module.ApplicationModule;
import retrofit2.Retrofit;

/**
 * Created by jorgecasariego on 20/12/16.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Retrofit exposeRetrofit();

    Context exposeContext();
}
