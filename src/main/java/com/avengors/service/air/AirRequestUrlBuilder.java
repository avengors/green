package com.avengors.service.air;

import com.avengors.requestutil.RequestUrlBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AirRequestUrlBuilder extends RequestUrlBuilder {
    private final String searchDate;
    private final String serviceKey;
    private final String returnType; // xml, json
    private final String informCode; // PM10, PM25

    public AirRequestUrlBuilder(String informCode, String returnType, String serviceKey) {
        if (!informCode.equals("PM10") && !informCode.equals("PM25")) {
            throw new IllegalArgumentException("`informCode` must be `PM10` or `PM25`.");
        }
        if (!returnType.equals("xml") && !returnType.equals("json")) {
            throw new IllegalArgumentException("`returnType` must be `json` or `xml`");
        }
        this.informCode = informCode;
        this.returnType = returnType;
        this.serviceKey = serviceKey;
    }

    @Override
    protected String getBaseUrl() {
        return "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth";
    }

    protected String getServiceKey() {
        return serviceKey;
    }

    protected String getSearchDate() {
        return searchDate;
    }

    protected String getReturnType() {
        return returnType;
    }

    protected String getInformCode() {
        return informCode;
    }
}
