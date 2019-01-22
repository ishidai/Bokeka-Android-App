package com.bokeka.hub.repository.base;

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
}
