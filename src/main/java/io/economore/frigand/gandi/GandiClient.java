package io.economore.frigand.gandi;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface GandiClient {

    @RequestLine("PUT /domains/{domain}/records/{name}/{type}")
    @Headers({"Content-Type: application/json", "X-Api-Key: {apikey}"})
    GandiAnswer update(@Param("domain") String domain, @Param("name") String name,
                       @Param("type") String type,
                       @Param("apikey") String apikey,
                       GandiAUpdateRequest request);

}
