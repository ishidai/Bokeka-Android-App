package com.bokeka.hub.repository.base;

import com.bokeka.hub.LiveBus;
import com.bokeka.hub.net.ApiClient;
import com.bokeka.hub.net.ApiService;

/**
 * @author daixin 2019/1/7
 * @website bokeka.com
 */
public class AppRepository extends BaseRepository {

    protected ApiService apiService;

    public AppRepository() {
        if (null == apiService) {
            apiService = ApiClient.getInstance().create(ApiService.class);
        }
    }

    protected void sendData(Object eventKey, Object t) {
        sendData(eventKey, null, t);
    }

    protected void showPageState(Object eventKey, String state) {
        sendData(eventKey, state);
    }

    protected void showPageState(Object eventKey, String tag, String state) {
        sendData(eventKey, tag, state);
    }

    protected void sendData(Object eventKey, String tag, Object t) {
        LiveBus.getDefault().postEvent(eventKey, tag, t);
    }
}
