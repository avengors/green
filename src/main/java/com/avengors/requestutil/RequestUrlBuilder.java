package com.avengors.requestutil;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;


public interface RequestUrlBuilder {

    @JsonIgnore
    String getBaseUrl();

    /**
     * Build URL that query string converted from member field.
     * <br>
     * not {@code private} getter is required.
     *
     * @return {@link URL}
     * @throws MalformedURLException    See {@link java.net.URI#toURL()}
     * @throws IllegalArgumentException See {@link java.net.URI#toURL()}
     */
    default URL build() throws MalformedURLException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NON_PRIVATE);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        Map<String, String> map = mapper.convertValue(this, new TypeReference<Map<String, String>>() {
        });

        params.setAll(map);

        return UriComponentsBuilder
                .fromHttpUrl(getBaseUrl())
                .queryParams(params)
                .build()
                .toUri()
                .toURL();
    }
}
