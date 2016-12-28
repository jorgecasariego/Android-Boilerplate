package enterprisesolutions.dagger2_rx.mvp.presenter;


import java.util.List;

import javax.inject.Inject;

import enterprisesolutions.dagger2_rx.api.CakeApiService;
import enterprisesolutions.dagger2_rx.base.BasePresenter;
import enterprisesolutions.dagger2_rx.mapper.CakeMapper;
import enterprisesolutions.dagger2_rx.mvp.model.Cake;
import enterprisesolutions.dagger2_rx.mvp.model.CakesResponse;
import enterprisesolutions.dagger2_rx.mvp.model.Storage;
import enterprisesolutions.dagger2_rx.mvp.view.MainView;
import rx.Observable;
import rx.Observer;

/**
 * Created by jorgecasariego on 27/12/16.
 */

public class CakePresenter extends BasePresenter<MainView> implements Observer<CakesResponse> {

    @Inject protected CakeApiService mApiService;
    @Inject protected CakeMapper mCakeMapper;
    @Inject protected Storage mStorage;

    @Inject
    public CakePresenter() {
    }

    public void getCakes() {
        getView().onShowDialog("Loading cakes...");
        Observable<CakesResponse> cakesResponseObservable = mApiService.getCakes();
        subscribe(cakesResponseObservable, this);
    }

    @Override
    public void onCompleted() {
        getView().onHideDialog();
        getView().onShowToast("Cakes loading complete!");
    }

    @Override
    public void onError(Throwable e) {
        getView().onHideDialog();
        getView().onShowToast("Error loading cakes: " + e.getMessage());
    }

    @Override
    public void onNext(CakesResponse cakesResponse) {
        List<Cake> cakes = mCakeMapper.mapCakes(mStorage, cakesResponse);
        getView().onClearItems();
        getView().onCakeLoaded(cakes);
    }

    public void getCakesFromDatabase() {
        List<Cake> cakes = mStorage.getSaveCakes();
        getView().onClearItems();
        getView().onCakeLoaded(cakes);
    }
}
