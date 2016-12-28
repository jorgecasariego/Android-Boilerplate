package enterprisesolutions.dagger2_rx.mvp.view;

import java.util.List;

import enterprisesolutions.dagger2_rx.mvp.model.Cake;

/**
 * Created by jorgecasariego on 27/12/16.
 */

public interface MainView extends BaseView {
    void onCakeLoaded(List<Cake> cakes);

    void onShowDialog(String message);

    void onShowToast(String message);

    void onHideDialog();

    void onClearItems();
}
