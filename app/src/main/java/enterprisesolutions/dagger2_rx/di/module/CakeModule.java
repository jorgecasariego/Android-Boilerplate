package enterprisesolutions.dagger2_rx.di.module;

import dagger.Module;
import dagger.Provides;
import enterprisesolutions.dagger2_rx.api.CakeApiService;
import enterprisesolutions.dagger2_rx.di.scope.PerActivity;
import enterprisesolutions.dagger2_rx.mvp.view.MainView;
import retrofit2.Retrofit;

/**
 * Created by jorgecasariego on 27/12/16.
 */
@Module
public class CakeModule {

    private MainView mView;

    public CakeModule(MainView mView) {
        this.mView = mView;
    }

    @PerActivity
    @Provides
    CakeApiService provideApiService(Retrofit retrofit){
        return retrofit.create(CakeApiService.class);
    }

    @PerActivity
    @Provides
    MainView provideMainView(){
        return mView;
    }
}
