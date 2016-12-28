package enterprisesolutions.dagger2_rx.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import enterprisesolutions.dagger2_rx.mvp.model.Cake;
import enterprisesolutions.dagger2_rx.mvp.model.CakesResponse;
import enterprisesolutions.dagger2_rx.mvp.model.CakesResponseCakes;
import enterprisesolutions.dagger2_rx.mvp.model.Storage;

/**
 * Created by jorgecasariego on 27/12/16.
 */

public class CakeMapper {

    @Inject
    public CakeMapper() {
    }

    public List<Cake> mapCakes(Storage storage, CakesResponse response){
        List<Cake> cakeList = new ArrayList<>();

        if (response != null) {
            CakesResponseCakes[] responseCakes = response.getCakes();
            if (responseCakes != null) {
                for (CakesResponseCakes cake : responseCakes) {
                    Cake myCake = new Cake();
                    myCake.setId(cake.getId());
                    myCake.setTitle(cake.getTitle());
                    myCake.setDetailDescription(cake.getDetailDescription());
                    myCake.setPreviewDescription(cake.getPreviewDescription());
                    myCake.setImageUrl(cake.getImage());
                    storage.addCake(myCake);
                    cakeList.add(myCake);
                }
            }
        }


        return cakeList;
    }
}
