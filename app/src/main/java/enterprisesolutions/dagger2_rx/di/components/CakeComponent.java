package enterprisesolutions.dagger2_rx.di.components;

import dagger.Component;
import enterprisesolutions.dagger2_rx.di.module.CakeModule;
import enterprisesolutions.dagger2_rx.di.scope.PerActivity;
import enterprisesolutions.dagger2_rx.modules.home.MainActivity;

/**
 * Created by jorgecasariego on 27/12/16.
 */
@PerActivity
@Component(
        modules = CakeModule.class,
        dependencies = ApplicationComponent.class
)
public interface CakeComponent {

    void inject(MainActivity activity);
}
