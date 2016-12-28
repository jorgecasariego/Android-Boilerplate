package enterprisesolutions.dagger2_rx.base;

import javax.inject.Inject;

import enterprisesolutions.dagger2_rx.mvp.view.BaseView;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jorgecasariego on 27/12/16.
 */

public class BasePresenter<V extends BaseView> {

    protected V getView() {
        return mView;
    }

    @Inject protected V mView;

    protected <T> void subscribe(Observable<T> observable, Observer<T> observer){
        observable.subscribeOn(Schedulers.newThread())
                .toSingle()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
