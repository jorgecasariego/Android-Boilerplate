package enterprisesolutions.dagger2_rx.modules.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import enterprisesolutions.dagger2_rx.R;
import enterprisesolutions.dagger2_rx.Utilities.NetworkUtils;
import enterprisesolutions.dagger2_rx.base.BaseActivity;
import enterprisesolutions.dagger2_rx.di.components.DaggerCakeComponent;
import enterprisesolutions.dagger2_rx.di.module.CakeModule;
import enterprisesolutions.dagger2_rx.modules.home.adapter.CakeAdapter;
import enterprisesolutions.dagger2_rx.mvp.model.Cake;
import enterprisesolutions.dagger2_rx.mvp.presenter.CakePresenter;
import enterprisesolutions.dagger2_rx.mvp.view.MainView;

public class MainActivity extends BaseActivity implements MainView{

    @Bind(R.id.cake_list) protected RecyclerView mCakeList;
    @Inject protected CakePresenter mPresenter;
    private CakeAdapter mCakeAdapter;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        initializeList();

        if(NetworkUtils.isNetworkAvailable(this)){
            mPresenter.getCakes();
        } else {
            mPresenter.getCakesFromDatabase();
        }


    }

    private void initializeList() {
        mCakeList.setHasFixedSize(true);
        mCakeList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mCakeAdapter = new CakeAdapter(getLayoutInflater());
        mCakeList.setAdapter(mCakeAdapter);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }


    @Override
    protected void resolveDaggerDependency() {
        DaggerCakeComponent.builder()
            .applicationComponent(getApplicationComponent())
            .cakeModule(new CakeModule(this))
            .build()
            .inject(this);
    }

    @Override
    public void onCakeLoaded(List<Cake> cakes) {
        mCakeAdapter.addCakes(cakes);
    }

    @Override
    public void onShowDialog(String message) {
        showDialog(message);
    }

    @Override
    public void onShowToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onHideDialog() {
        hideDialog();
    }

    @Override
    public void onClearItems() {
        mCakeAdapter.clearCakes();
    }
}
